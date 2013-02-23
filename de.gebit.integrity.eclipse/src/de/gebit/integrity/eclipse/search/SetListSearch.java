/**
 * 
 */
package de.gebit.integrity.eclipse.search;

import java.util.ArrayList;
import java.util.List;

import de.gebit.integrity.remoting.entities.setlist.SetList;
import de.gebit.integrity.remoting.entities.setlist.SetListEntry;
import de.gebit.integrity.remoting.entities.setlist.SetListEntryAttributeKeys;
import de.gebit.integrity.remoting.entities.setlist.SetListEntryTypes;
import de.gebit.integrity.remoting.entities.setlist.SetListUtil;

/**
 * This is a very simple "search engine" used to search for text parts in a {@link SetList}. It searches for suite
 * titles as well as visible comments. The algorithm used is pretty simple, and it remains to be seen whether it is fast
 * enough even for larger setlists or if some kind of more efficient way to search has to be introduced here.
 * 
 * @author Rene Schneider
 * 
 */
public class SetListSearch {

	/**
	 * This contains all indexed entries.
	 */
	private List<SearchResult> entries = new ArrayList<SearchResult>();

	/**
	 * Creates a new instance. This causes an indexing process over the {@link SetListEntry} tree.
	 * 
	 * @param aSetList
	 *            the setlist to index
	 */
	public SetListSearch(SetList aSetList) {
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
				entries.add(new SearchResult(tempSuiteName, anEntry));
			}
			tempRecurse = true;
		} else if (anEntry.getType() == SetListEntryTypes.COMMENT) {
			String tempCommentText = (String) anEntry.getAttribute(SetListEntryAttributeKeys.VALUE);
			if (tempCommentText != null) {
				entries.add(new SearchResult(tempCommentText, anEntry));
			}
		} else if (anEntry.getType() == SetListEntryTypes.EXECUTION) {
			tempRecurse = true;
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

	private class SearchResult {

		/**
		 * The textual representation.
		 */
		private String text;

		/**
		 * The entry.
		 */
		private SetListEntry entry;

		public SearchResult(String aText, SetListEntry anEntry) {
			text = aText;
			entry = anEntry;
		}

		public SetListEntry getEntry() {
			return entry;
		}

		public boolean matches(String aQuery) {
			return text.contains(aQuery);
		}

	}

}
