package de.integrity.remoting.entities.setlist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unchecked")
public class SetList implements Serializable {

	private static final long serialVersionUID = -5710551695226775511L;

	private List<SetListEntry> entries = new ArrayList<SetListEntry>();

	private Integer entryInExecutionReference;

	private transient Set<SetListEntry> pathOfEntriesInExecution = new HashSet<SetListEntry>();

	private transient HashMap<SetListEntry, Integer> executableEntryPositionMap;

	private transient ArrayList<SetListEntryResultStates> executableEntryResultStates;

	private transient int entryListPosition;

	public void recreateTransientData() {
		executableEntryPositionMap = new HashMap<SetListEntry, Integer>();
		executableEntryResultStates = new ArrayList<SetListEntryResultStates>();

		int tempPosition = 0;
		for (SetListEntry tempEntry : entries) {
			SetListEntryResultStates tempResultState = determineEntryResultState(tempEntry);

			if (tempResultState != null) {
				executableEntryResultStates.add(tempResultState);
				executableEntryPositionMap.put(tempEntry, tempPosition);
				tempPosition++;
			}
		}

		pathOfEntriesInExecution = new HashSet<SetListEntry>();
		setEntryInExecutionReference(entryInExecutionReference);
	}

	protected SetListEntryResultStates determineEntryResultState(SetListEntry anEntry) {
		List<SetListEntry> tempResultEntries = resolveReferences(anEntry, SetListEntryAttributeKeys.RESULT);
		if (tempResultEntries.size() > 0) {
			SetListEntry tempResultEntry = tempResultEntries.get(0);

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
			default:
				return null;
			}
		}
		return null;
	}

	public int getNumberOfExecutableEntries() {
		return executableEntryResultStates.size();
	}

	public SetListEntryResultStates getResultStateForExecutableEntry(SetListEntry anEntry) {
		Integer tempPosition = executableEntryPositionMap.get(anEntry);
		if (tempPosition != null) {
			return executableEntryResultStates.get(tempPosition);
		} else {
			return null;
		}
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
			entryListPosition++;
			return entries.get(entryListPosition - 1);
		} else {
			SetListEntry tempNewEntry = new SetListEntry(entryListPosition, aType);
			entries.add(tempNewEntry);
			entryListPosition++;
			return tempNewEntry;
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
	}

	public void integrateUpdates(SetListEntry[] someUpdatedEntries) {
		for (SetListEntry tempEntry : someUpdatedEntries) {
			entries.set(tempEntry.getId(), tempEntry);
		}
		for (SetListEntry tempEntry : someUpdatedEntries) {
			switch (tempEntry.getType()) {
			case RESULT:
				SetListEntry tempParent = getParent(tempEntry);
				if (executableEntryPositionMap.containsKey(tempParent)) {
					executableEntryResultStates.set(executableEntryPositionMap.get(tempParent),
							determineEntryResultState(tempParent));
				}
			default:
				if (executableEntryPositionMap.containsKey(tempEntry)) {
					executableEntryResultStates.set(executableEntryPositionMap.get(tempEntry),
							determineEntryResultState(tempEntry));
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
