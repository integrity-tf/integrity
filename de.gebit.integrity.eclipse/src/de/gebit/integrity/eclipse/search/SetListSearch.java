/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.eclipse.search;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import de.gebit.integrity.eclipse.Activator;
import de.gebit.integrity.remoting.entities.setlist.SetList;
import de.gebit.integrity.remoting.entities.setlist.SetListEntry;
import de.gebit.integrity.remoting.entities.setlist.SetListEntryAttributeKeys;
import de.gebit.integrity.remoting.entities.setlist.SetListEntryResultStates;
import de.gebit.integrity.remoting.entities.setlist.SetListEntryTypes;
import de.gebit.integrity.remoting.entities.setlist.SetListUtil;

/**
 * This is a very simple "search engine" used to search for text parts in a {@link SetList}. It searches for suite
 * titles as well as visible comments. The algorithm used is pretty simple, and it remains to be seen whether it is fast
 * enough even for larger setlists or if some kind of more efficient way to search has to be introduced here.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class SetListSearch {

	/**
	 * This contains all indexed entries.
	 */
	private List<SearchResult> entries = new ArrayList<SearchResult>();

	/**
	 * This contains the setlist the index was built upon.
	 */
	private SetList setList;

	/**
	 * Creates a new instance. This causes an indexing process over the {@link SetListEntry} tree.
	 * 
	 * @param aSetList
	 *            the setlist to index
	 */
	public SetListSearch(SetList aSetList) {
		setList = aSetList;
		createIndex(aSetList.getRootEntry(), aSetList);
	}

	/**
	 * Creates an index over the given entry from the given setlist. Called recursively to traverse the whole tree.
	 * 
	 * @param anEntry
	 *            the entry to look at
	 * @param aSetList
	 *            the setlist where the entry came from
	 */
	protected void createIndex(SetListEntry anEntry, SetList aSetList) {
		boolean tempRecurse = false;

		try {
			if (anEntry.getType() == SetListEntryTypes.SUITE) {
				String tempSuiteName = anEntry.getAttribute(String.class, SetListEntryAttributeKeys.NAME);
				if (tempSuiteName != null) {
					SetListEntryResultStates tempResultState = setList.getResultStateForEntry(anEntry);
					if (tempResultState != null) {
						entries.add(new SearchResult(tempSuiteName, !tempResultState.isUnsuccessful(), true, false,
								anEntry));
					}
				}
				tempRecurse = true;
			} else if (anEntry.getType() == SetListEntryTypes.COMMENT) {
				String tempCommentText = (String) anEntry.getAttribute(SetListEntryAttributeKeys.VALUE);
				if (tempCommentText != null) {
					// Comments can't "fail"
					entries.add(new SearchResult(tempCommentText, true, false, false, anEntry));
				}

			} else if (anEntry.getType() == SetListEntryTypes.TIMESET) {
				String tempText = (String) anEntry.getAttribute(SetListEntryAttributeKeys.DESCRIPTION);
				if (tempText != null) {
					SetListEntryResultStates tempResultState = setList.getResultStateForEntry(anEntry);
					if (tempResultState != null) {
						entries.add(
								new SearchResult(tempText, !tempResultState.isUnsuccessful(), false, false, anEntry));
					}
				}
			} else if (anEntry.getType() == SetListEntryTypes.EXECUTION) {
				// Always recurse into the root entry
				tempRecurse = true;
			} else if (anEntry.getType() == SetListEntryTypes.TEST || anEntry.getType() == SetListEntryTypes.CALL) {
				String tempTestText = (String) anEntry.getAttribute(SetListEntryAttributeKeys.DESCRIPTION);
				if (tempTestText != null) {
					SetListEntryResultStates tempResultState = setList.getResultStateForEntry(anEntry);
					if (tempResultState != null) {
						entries.add(new SearchResult(tempTestText, !tempResultState.isUnsuccessful(), false, false,
								anEntry));
					}
				}
			} else if (anEntry.getType() == SetListEntryTypes.TABLETEST) {
				boolean tempHasUnsuccessfulSubResult = false;
				// For tabletests, we fetch all sub-entries with the results for each line here and index them instead
				// of triggering on "result" elements and finding out whether they belong to a tabletest.
				List<SetListEntry> tempResultEntries
						= SetListUtil.getSetListEntryChilds((SetListEntry) anEntry, aSetList);
				for (SetListEntry tempResultEntry : tempResultEntries) {
					if (tempResultEntry.getType() == SetListEntryTypes.RESULT) {
						String tempLineText
								= (String) tempResultEntry.getAttribute(SetListEntryAttributeKeys.DESCRIPTION);
						if (tempLineText != null) {
							SetListEntryResultStates tempResultState = setList.getResultStateForEntry(tempResultEntry);
							if (tempResultState != null) {
								if (!tempHasUnsuccessfulSubResult && tempResultState.isUnsuccessful()) {
									tempHasUnsuccessfulSubResult = true;
								}

								entries.add(new SearchResult(tempLineText, !tempResultState.isUnsuccessful(), false,
										false, tempResultEntry));
							}
						}
					}
				}

				String tempTestText = (String) anEntry.getAttribute(SetListEntryAttributeKeys.DESCRIPTION);
				if (tempTestText != null) {
					SetListEntryResultStates tempResultState = setList.getResultStateForEntry(anEntry);
					if (tempResultState != null) {
						entries.add(new SearchResult(tempTestText, !tempResultState.isUnsuccessful(), true,
								(tempResultState == SetListEntryResultStates.FAILED && !tempHasUnsuccessfulSubResult),
								anEntry));
					}
				}
			}
		} catch (Exception exc) {
			Activator.getInstance().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID,
					"Failed to parse setlist entry for search: '" + anEntry + "'", exc));
		}

		if (tempRecurse) {
			List<SetListEntry> tempList = SetListUtil.getSetListEntryChilds(anEntry, aSetList);

			if (tempList != null) {
				for (SetListEntry tempChild : tempList) {
					createIndex(tempChild, aSetList);
				}
			}
		}
	}

	/**
	 * Finds matching entries for the given query.
	 * 
	 * @param aQuery
	 *            the string to search for
	 * @return matching entries (returns an empty list if no matches were found)
	 */
	public List<SetListEntry> findEntries(String aQuery) {
		List<SetListEntry> tempResults = new ArrayList<SetListEntry>();

		for (SearchResult tempPossibleResult : entries) {
			if (tempPossibleResult.matches(aQuery)) {
				tempResults.add(tempPossibleResult.getEntry());
			}
		}

		return tempResults;
	}

	/**
	 * Finds entries which are considered "unsuccessful" (failed tests, tests with exceptions etc.).
	 * 
	 * @return matching entries (returns an empty list if no matches were found)
	 */
	public List<SetListEntry> findUnsuccessfulEntries() {
		List<SetListEntry> tempResults = new ArrayList<SetListEntry>();

		for (SearchResult tempPossibleResult : entries) {
			if (!tempPossibleResult.isSuccessful()) {
				if (!tempPossibleResult.isSubResultDependent()
						|| tempPossibleResult.isSubResultDependentButHasOwnResult()) {
					tempResults.add(tempPossibleResult.getEntry());
				}
			}
		}

		return tempResults;
	}

	private class SearchResult {

		/**
		 * The textual representation.
		 */
		private String text;

		/**
		 * Whether the element is considered "successful" (ex.: passed test).
		 */
		private boolean successful;

		/**
		 * Whether this is an element whose success status depends on the success of sub-elements (ex.: suites).
		 */
		private boolean subResultDependent;

		/**
		 * Whether this element is sub-result dependent in principle, but has an own result that is to be honored in
		 * this particular case (ex.: tabletests with all results successful, but finalization test failed).
		 */
		private boolean subResultDependentButHasOwnResult;

		/**
		 * The entry.
		 */
		private SetListEntry entry;

		SearchResult(String aText, boolean aSuccessfulFlag, boolean aSubResultDependentFlag,
				boolean aSubResultDependentButHasOwnResult, SetListEntry anEntry) {
			text = aText;
			successful = aSuccessfulFlag;
			subResultDependent = aSubResultDependentFlag;
			subResultDependentButHasOwnResult = aSubResultDependentButHasOwnResult;
			entry = anEntry;
		}

		public SetListEntry getEntry() {
			return entry;
		}

		public boolean matches(String aQuery) {
			return text.contains(aQuery);
		}

		public boolean isSuccessful() {
			return successful;
		}

		public boolean isSubResultDependent() {
			return subResultDependent;
		}

		public boolean isSubResultDependentButHasOwnResult() {
			return subResultDependentButHasOwnResult;
		}

	}

}
