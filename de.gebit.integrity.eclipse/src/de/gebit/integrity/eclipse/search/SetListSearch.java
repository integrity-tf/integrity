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

		if (anEntry.getType() == SetListEntryTypes.SUITE) {
			String tempSuiteName = anEntry.getAttribute(String.class, SetListEntryAttributeKeys.NAME);
			if (tempSuiteName != null) {
				// Suites are always considered "successful", even if they contain failed tests. We don't want to find
				// failed suites when trying to find the next failed entry.
				entries.add(new SearchResult(tempSuiteName, true, anEntry));
			}
			tempRecurse = true;
		} else if (anEntry.getType() == SetListEntryTypes.COMMENT) {
			String tempCommentText = (String) anEntry.getAttribute(SetListEntryAttributeKeys.VALUE);
			if (tempCommentText != null) {
				// Comments can't "fail" either
				entries.add(new SearchResult(tempCommentText, true, anEntry));
			}
		} else if (anEntry.getType() == SetListEntryTypes.EXECUTION) {
			// Always recurse into the root entry
			tempRecurse = true;
		} else if (anEntry.getType() == SetListEntryTypes.TEST || anEntry.getType() == SetListEntryTypes.CALL) {
			String tempTestText = (String) anEntry.getAttribute(SetListEntryAttributeKeys.DESCRIPTION);
			if (tempTestText != null) {
				SetListEntryResultStates tempResultState = setList.getResultStateForEntry(anEntry);
				if (tempResultState != null) {
					entries.add(new SearchResult(tempTestText, !tempResultState.isUnsuccessful(), anEntry));
				}
			}
		}

		if (tempRecurse) {
			for (SetListEntry tempChild : SetListUtil.getSetListEntryChilds(anEntry, aSetList)) {
				createIndex(tempChild, aSetList);
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
				tempResults.add(tempPossibleResult.getEntry());
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
		 * The entry.
		 */
		private SetListEntry entry;

		public SearchResult(String aText, boolean aSuccessfulFlag, SetListEntry anEntry) {
			text = aText;
			successful = aSuccessfulFlag;
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

	}

}
