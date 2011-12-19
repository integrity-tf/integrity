package de.integrity.remoting.entities.setlist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("unchecked")
public class SetList implements Serializable {

	private static final long serialVersionUID = -5710551695226775511L;

	private List<SetListEntry> entries = new ArrayList<SetListEntry>();

	private Integer entryInExecutionReference;

	private transient Set<SetListEntry> pathOfEntriesInExecution = new HashSet<SetListEntry>();

	private transient HashMap<SetListEntry, SetListEntryResultStates> resultBearingEntryResultMap;

	private transient HashMap<SetListEntry, Integer> executableEntryResultIndex;

	private transient ArrayList<SetListEntryResultStates> executableEntryResultStates;

	private transient int entryListPosition;

	private transient Map<SetListEntryTypes, Integer> lastCreatedEntryIdMap = new HashMap<SetListEntryTypes, Integer>();

	public void recreateTransientData() {
		resultBearingEntryResultMap = new HashMap<SetListEntry, SetListEntryResultStates>();
		executableEntryResultIndex = new HashMap<SetListEntry, Integer>();
		executableEntryResultStates = new ArrayList<SetListEntryResultStates>();
		lastCreatedEntryIdMap = new HashMap<SetListEntryTypes, Integer>();

		int tempPosition = 0;
		for (SetListEntry tempEntry : entries) {
			SetListEntryResultStates tempResultState = determineEntryResultState(tempEntry);

			if (tempResultState != null) {
				resultBearingEntryResultMap.put(tempEntry, tempResultState);
				// if the entry is a result itself, it's not executable;
				// otherwise it is
				if (tempEntry.getType() != SetListEntryTypes.RESULT) {
					executableEntryResultIndex.put(tempEntry, tempPosition);
					executableEntryResultStates.add(tempResultState);
					tempPosition++;
				}
			}
		}

		pathOfEntriesInExecution = new HashSet<SetListEntry>();
		setEntryInExecutionReference(entryInExecutionReference);
	}

	protected SetListEntryResultStates determineEntryResultState(SetListEntry anEntry) {
		boolean tempEntryIsResultOfTableTestRow = (anEntry.getType() == SetListEntryTypes.RESULT && getParent(anEntry)
				.getType() == SetListEntryTypes.TABLETEST);
		List<SetListEntry> tempResultEntries = tempEntryIsResultOfTableTestRow ? null : resolveReferences(anEntry,
				SetListEntryAttributeKeys.RESULT);
		if (tempEntryIsResultOfTableTestRow || tempResultEntries.size() > 0) {
			SetListEntry tempResultEntry = tempEntryIsResultOfTableTestRow ? anEntry : tempResultEntries.get(0);

			switch (anEntry.getType()) {
			case SUITE:
				if (tempResultEntry.getAttribute(SetListEntryAttributeKeys.SUCCESS_COUNT) != null) {
					int tempFailureCount = (Integer) tempResultEntry
							.getAttribute(SetListEntryAttributeKeys.FAILURE_COUNT);
					int tempExceptionCount = (Integer) tempResultEntry
							.getAttribute(SetListEntryAttributeKeys.EXCEPTION_COUNT);
					if (tempExceptionCount > 0) {
						return SetListEntryResultStates.EXCEPTION;
					} else if (tempFailureCount > 0) {
						return SetListEntryResultStates.FAILED;
					} else {
						return SetListEntryResultStates.SUCCESSFUL;
					}
				}
				return SetListEntryResultStates.UNKNOWN;
			case CALL:
				if (tempResultEntry.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG) != null) {
					if (Boolean.TRUE
							.equals(tempResultEntry.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG))) {
						return SetListEntryResultStates.SUCCESSFUL;
					} else {
						return SetListEntryResultStates.EXCEPTION;
					}
				}
				return SetListEntryResultStates.UNKNOWN;
			case TEST:
			case RESULT:
				if (tempResultEntry.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG) != null) {
					if (Boolean.TRUE
							.equals(tempResultEntry.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG))) {
						return SetListEntryResultStates.SUCCESSFUL;
					} else if (Boolean.FALSE.equals(tempResultEntry
							.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG))) {
						if (tempResultEntry.getAttribute(SetListEntryAttributeKeys.EXCEPTION) != null) {
							return SetListEntryResultStates.EXCEPTION;
						} else {
							return SetListEntryResultStates.FAILED;
						}
					}
				}
				return SetListEntryResultStates.UNKNOWN;
			case TABLETEST:
				boolean tempHasException = false;
				boolean tempHasFailure = false;
				boolean tempHasAnyResult = false;
				for (int i = 0; i < tempResultEntries.size(); i++) {
					tempResultEntry = tempResultEntries.get(i);
					if (tempResultEntry.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG) != null) {
						tempHasAnyResult = true;
						if (Boolean.FALSE.equals(tempResultEntry
								.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG))) {
							if (tempResultEntry.getAttribute(SetListEntryAttributeKeys.EXCEPTION) != null) {
								tempHasException = true;
								break;
							} else {
								tempHasFailure = true;
							}
						}
					}
				}
				if (tempHasException) {
					return SetListEntryResultStates.EXCEPTION;
				} else if (tempHasFailure) {
					return SetListEntryResultStates.FAILED;
				} else if (tempHasAnyResult) {
					return SetListEntryResultStates.SUCCESSFUL;
				} else {
					return SetListEntryResultStates.UNKNOWN;
				}
			default:
				return null;
			}
		}
		return null;
	}

	public int getNumberOfExecutableEntries() {
		return executableEntryResultStates.size();
	}

	public SetListEntryResultStates getResultStateForEntry(SetListEntry anEntry) {
		return resultBearingEntryResultMap.get(anEntry);
	}

	public SetListEntryResultStates getResultStateForExecutableEntry(int aPosition) {
		if (aPosition < 0 || aPosition >= executableEntryResultStates.size()) {
			return null;
		} else {
			return executableEntryResultStates.get(aPosition);
		}
	}

	public SetListEntry createEntry(SetListEntryTypes aType) {
		if (entries.size() > entryListPosition) {
			lastCreatedEntryIdMap.put(aType, entryListPosition);
			entryListPosition++;
			return entries.get(entryListPosition - 1);
		} else {
			SetListEntry tempNewEntry = new SetListEntry(entryListPosition, aType);
			entries.add(tempNewEntry);
			lastCreatedEntryIdMap.put(aType, tempNewEntry.getId());
			entryListPosition++;
			return tempNewEntry;
		}
	}

	public Integer getLastCreatedEntryId(SetListEntryTypes aType) {
		if (aType != null) {
			return lastCreatedEntryIdMap.get(aType);
		} else {
			if (entries.size() == 0) {
				return null;
			} else {
				return entries.get(entries.size() - 1).getId();
			}
		}
	}

	public Integer getLastCreatedEntryId(SetListEntryTypes... someTypes) {
		List<Integer> tempList = new ArrayList<Integer>();
		for (SetListEntryTypes tempType : someTypes) {
			Integer tempEntryRef = getLastCreatedEntryId(tempType);
			if (tempEntryRef != null) {
				tempList.add(tempEntryRef);
			}
		}

		if (tempList.size() == 0) {
			return null;
		} else {
			Collections.sort(tempList);
			return tempList.get(tempList.size() - 1);
		}
	}

	public void addReference(SetListEntry aReferringEntry, SetListEntryAttributeKeys anAttributeKey,
			SetListEntry aReferredEntry) {
		LinkedList<Integer> tempList = (LinkedList<Integer>) aReferringEntry.getAttribute(LinkedList.class,
				anAttributeKey, new LinkedList<Integer>());
		if (!tempList.contains(aReferredEntry.getId())) {
			tempList.add(aReferredEntry.getId());
		}
		aReferredEntry.setAttribute(SetListEntryAttributeKeys.PARENT, aReferringEntry.getId());
	}

	public void rewind() {
		entryListPosition = 0;
		lastCreatedEntryIdMap.clear();
	}

	public void integrateUpdates(SetListEntry[] someUpdatedEntries) {
		for (SetListEntry tempEntry : someUpdatedEntries) {
			entries.set(tempEntry.getId(), tempEntry);
		}
		for (SetListEntry tempEntry : someUpdatedEntries) {
			switch (tempEntry.getType()) {
			case RESULT:
				SetListEntry tempParent = getParent(tempEntry);
				switch (tempParent.getType()) {
				case TEST:
				case CALL:
				case SUITE:
					if (resultBearingEntryResultMap.containsKey(tempParent)) {
						SetListEntryResultStates tempResultState = determineEntryResultState(tempParent);
						resultBearingEntryResultMap.put(tempParent, tempResultState);
						executableEntryResultStates.set(executableEntryResultIndex.get(tempParent), tempResultState);
					}
				case TABLETEST:
					if (resultBearingEntryResultMap.containsKey(tempEntry)) {
						resultBearingEntryResultMap.put(tempEntry, determineEntryResultState(tempEntry));
					}
				}
				break;
			default:
				if (resultBearingEntryResultMap.containsKey(tempEntry)) {
					SetListEntryResultStates tempResultState = determineEntryResultState(tempEntry);
					resultBearingEntryResultMap.put(tempEntry, tempResultState);
					if (executableEntryResultIndex.containsKey(tempEntry)) {
						executableEntryResultStates.set(executableEntryResultIndex.get(tempEntry), tempResultState);
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		StringBuffer tempBuffer = new StringBuffer();
		for (SetListEntry tempEntry : entries) {
			tempBuffer.append(tempEntry.toString() + "\n");
		}

		return tempBuffer.toString();
	}

	public List<SetListEntry> resolveReferences(SetListEntry anEntry, SetListEntryAttributeKeys anAttributeKey) {
		return resolveReferences((List<Integer>) anEntry.getAttribute(anAttributeKey));
	}

	public List<SetListEntry> resolveReferences(List<Integer> someItemIds) {
		List<SetListEntry> tempList = new LinkedList<SetListEntry>();

		if (someItemIds != null) {
			for (Integer tempItemId : someItemIds) {
				tempList.add(entries.get(tempItemId));
			}
		}

		return tempList;
	}

	public SetListEntry resolveReference(Integer aReference) {
		if (aReference == null || aReference < 0 || aReference >= entries.size()) {
			return null;
		} else {
			return entries.get(aReference);
		}
	}

	public SetListEntry getRootEntry() {
		return entries.get(0);
	}

	public SetListEntry getParent(SetListEntry anEntry) {
		if (anEntry == null) {
			return null;
		}
		Integer aParent = (Integer) anEntry.getAttribute(SetListEntryAttributeKeys.PARENT);
		if (aParent != null) {
			return resolveReference(aParent);
		} else {
			return null;
		}
	}

	public void setEntryInExecutionReference(Integer anEntryReference) {
		entryInExecutionReference = anEntryReference;
		pathOfEntriesInExecution.clear();
		if (anEntryReference != null) {
			SetListEntry tempCurrent = resolveReference(anEntryReference);
			while (tempCurrent != null) {
				pathOfEntriesInExecution.add(tempCurrent);
				tempCurrent = getParent(tempCurrent);
			}
		}
	}

	public SetListEntry getEntryInExecution() {
		return resolveReference(entryInExecutionReference);
	}

	public Set<SetListEntry> getEntriesInExecution() {
		return pathOfEntriesInExecution;
	}

	public boolean isEntryInExecution(SetListEntry anEntry) {
		if (entryInExecutionReference == null) {
			return false;
		} else {
			switch (anEntry.getType()) {
			case TEST:
			case CALL:
			case TABLETEST:
				return anEntry.getId() == entryInExecutionReference;
			case SETUP:
			case SUITE:
			case TEARDOWN:
				return pathOfEntriesInExecution.contains(anEntry);
			case EXECUTION:
				return true;
			default:
				return false;
			}
		}
	}
}
