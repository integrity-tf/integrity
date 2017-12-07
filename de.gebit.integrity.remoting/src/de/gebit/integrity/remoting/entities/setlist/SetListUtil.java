/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.remoting.entities.setlist;

import java.util.LinkedList;
import java.util.List;

/**
 * This utility class collects several methods used to explore {@link SetList}s. Quite some of these could well be
 * implemented in the {@link SetListEntry} class, but they've been deliberately implemented in a separate utility class
 * to minimize code changes in the set list classes and thus minimize the risk of introducing serialization
 * incompatibilities.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public final class SetListUtil {

	private SetListUtil() {
		// private constructor
	}

	/**
	 * Returns the number of children that a specified {@link SetListEntry} has. This includes only "children" to be
	 * displayed as child nodes in the tree.
	 * 
	 * @param anEntry
	 *            the entry
	 * @return the number of child nodes
	 */
	@SuppressWarnings("unchecked")
	public static int getSetListEntryChildCount(SetListEntry anEntry) {
		switch (anEntry.getType()) {
		case EXECUTION:
		case SUITE:
			List<Integer> tempStatements = ((List<Integer>) anEntry.getAttribute(SetListEntryAttributeKeys.STATEMENTS));
			List<Integer> tempSetups = (List<Integer>) anEntry.getAttribute(SetListEntryAttributeKeys.SETUP);
			List<Integer> tempTeardowns = (List<Integer>) anEntry.getAttribute(SetListEntryAttributeKeys.TEARDOWN);
			int tempStatementCount = 0;
			if (tempStatements != null) {
				tempStatementCount += tempStatements.size();
			}
			if (tempSetups != null) {
				tempStatementCount += tempSetups.size();
			}
			if (tempTeardowns != null) {
				tempStatementCount += tempTeardowns.size();
			}
			return tempStatementCount;
		case TABLETEST:
			return ((List<Integer>) anEntry.getAttribute(SetListEntryAttributeKeys.RESULT)).size();
		default:
			return 0;
		}
	}

	/**
	 * Returns a list of child node references belonging to a specified {@link SetListEntry}. This only includes such
	 * children that should be displayed in the tree.
	 * 
	 * @param anEntry
	 *            the entry
	 * @return a list of child references (entry IDs), or null if this is not applicable.
	 */
	@SuppressWarnings("unchecked")
	public static List<Integer> getSetListEntryChildReferences(SetListEntry anEntry) {
		switch (anEntry.getType()) {
		case EXECUTION:
		case SUITE:
			List<Integer> tempStatements = (List<Integer>) anEntry.getAttribute(SetListEntryAttributeKeys.STATEMENTS);
			List<Integer> tempSetups = (List<Integer>) anEntry.getAttribute(SetListEntryAttributeKeys.SETUP);
			List<Integer> tempTeardowns = (List<Integer>) anEntry.getAttribute(SetListEntryAttributeKeys.TEARDOWN);
			if (tempSetups == null && tempTeardowns == null) {
				return tempStatements;
			} else {
				List<Integer> tempTotal = new LinkedList<Integer>();
				if (tempSetups != null) {
					tempTotal.addAll(tempSetups);
				}
				if (tempStatements != null) {
					tempTotal.addAll(tempStatements);
				}
				if (tempTeardowns != null) {
					tempTotal.addAll(tempTeardowns);
				}
				return tempTotal;
			}
		case TABLETEST:
			return (List<Integer>) anEntry.getAttribute(SetListEntryAttributeKeys.RESULT);
		default:
			return null;
		}
	}

	/**
	 * Returns the actual child entry at a specified position within the children of a specified {@link SetListEntry}.
	 * 
	 * @param anEntry
	 *            the entry
	 * @param aSetList
	 *            the setlist that the entry belongs to
	 * @param aChildIndex
	 *            the index of the child to get
	 * @return the child entry, or null if there is none
	 */
	public static SetListEntry getSetListEntryChild(SetListEntry anEntry, SetList aSetList, int aChildIndex) {
		List<Integer> tempReferences = getSetListEntryChildReferences(anEntry);
		if (tempReferences != null && aChildIndex >= 0 && aChildIndex < tempReferences.size()) {
			return aSetList.resolveReference(tempReferences.get(aChildIndex));
		} else {
			return null;
		}
	}

	/**
	 * Returns the actual child entries of the given {@link SetListEntry}.
	 * 
	 * @param anEntry
	 *            the entry
	 * @param aSetList
	 *            the setlist that the entry belongs to
	 * @return the list of childs, or null if the entry does not refer to any childs due to its type
	 */
	public static List<SetListEntry> getSetListEntryChilds(SetListEntry anEntry, SetList aSetList) {
		List<Integer> tempReferences = getSetListEntryChildReferences(anEntry);
		if (tempReferences != null) {
			return aSetList.resolveReferences(tempReferences);
		} else {
			return null;
		}
	}

}
