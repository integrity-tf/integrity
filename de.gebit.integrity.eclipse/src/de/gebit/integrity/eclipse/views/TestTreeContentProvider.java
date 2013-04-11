/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.eclipse.views;

import java.util.List;

import org.eclipse.jface.viewers.ILazyTreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import de.gebit.integrity.remoting.entities.setlist.SetList;
import de.gebit.integrity.remoting.entities.setlist.SetListEntry;
import de.gebit.integrity.remoting.entities.setlist.SetListEntryTypes;
import de.gebit.integrity.remoting.entities.setlist.SetListUtil;

/**
 * Provides the content for the main test execution tree.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class TestTreeContentProvider implements ILazyTreeContentProvider {

	/**
	 * The set list to use.
	 */
	private SetList setList;

	/**
	 * The {@link TreeViewer} that this provider belongs to.
	 */
	private TreeViewer owner;

	/**
	 * Constructs a new instance.
	 * 
	 * @param anOwner
	 *            the owner that will receive this provider
	 */
	public TestTreeContentProvider(TreeViewer anOwner) {
		owner = anOwner;
	}

	@Override
	public void updateElement(Object aParent, int anIndex) {
		SetListEntry tempChild;
		if (aParent == setList) {
			tempChild = SetListUtil.getSetListEntryChild(setList.getRootEntry(), setList, anIndex);
		} else {
			tempChild = SetListUtil.getSetListEntryChild((SetListEntry) aParent, setList, anIndex);
		}
		owner.replace(aParent, anIndex, tempChild);
		owner.setChildCount(tempChild, SetListUtil.getSetListEntryChildCount(tempChild));
	}

	@Override
	public void updateChildCount(Object anElement, int aCurrentChildCount) {
		int tempCount;
		if (anElement == setList) {
			tempCount = SetListUtil.getSetListEntryChildCount(setList.getRootEntry());
		} else {
			tempCount = SetListUtil.getSetListEntryChildCount((SetListEntry) anElement);
		}

		if (tempCount != aCurrentChildCount) {
			owner.setChildCount(anElement, tempCount);
		}
	}

	@Override
	public Object getParent(Object anElement) {
		if (anElement == setList) {
			return null;
		} else {
			return setList.getParent((SetListEntry) anElement);
		}
	}

	@Override
	public void dispose() {

	}

	/**
	 * Expands all nodes to a specific depth.
	 * 
	 * @param aDepth
	 *            the depth
	 */
	public void expandToLevel(int aDepth) {
		expandToLevelInternal(setList.getRootEntry(), aDepth);
	}

	/**
	 * Used internally to expand a node to a specific depth (recursively).
	 * 
	 * @param anEntry
	 *            the node to expand
	 * @param aDepth
	 *            the depth
	 */
	protected void expandToLevelInternal(Object anEntry, int aDepth) {
		if (aDepth == 0) {
			return;
		} else {
			if (anEntry instanceof SetListEntry) {
				// table tests are excluded in automatic expansion
				if (((SetListEntry) anEntry).getType() != SetListEntryTypes.TABLETEST) {
					List<Integer> tempRefs = SetListUtil.getSetListEntryChildReferences((SetListEntry) anEntry);
					if (tempRefs != null) {
						owner.setExpandedState(anEntry, true);
						for (Integer tempRef : tempRefs) {
							SetListEntry tempNextEntry = setList.resolveReference(tempRef);
							expandToLevelInternal(tempNextEntry, aDepth - 1);
						}
					}
				}
			}
		}
	}

	@Override
	public void inputChanged(Viewer aViewer, Object anOldInput, Object aNewInput) {
		setList = (SetList) aNewInput;
	}

}
