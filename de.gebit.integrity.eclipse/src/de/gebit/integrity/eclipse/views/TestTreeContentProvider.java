package de.gebit.integrity.eclipse.views;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.viewers.ILazyTreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import de.gebit.integrity.remoting.entities.setlist.SetList;
import de.gebit.integrity.remoting.entities.setlist.SetListEntry;
import de.gebit.integrity.remoting.entities.setlist.SetListEntryAttributeKeys;

public class TestTreeContentProvider implements ILazyTreeContentProvider {

	private SetList setList;

	private TreeViewer owner;

	public TestTreeContentProvider(TreeViewer anOwner) {
		owner = anOwner;
	}

	@Override
	public void updateElement(Object parent, int index) {
		SetListEntry tempChild;
		if (parent == setList) {
			tempChild = getSetListEntryChild(setList.getRootEntry(), index);
		} else {
			tempChild = getSetListEntryChild((SetListEntry) parent, index);
		}
		owner.replace(parent, index, tempChild);
		owner.setChildCount(tempChild, getSetListEntryChildCount(tempChild));
	}

	@Override
	public void updateChildCount(Object element, int currentChildCount) {
		int tempCount;
		if (element == setList) {
			tempCount = getSetListEntryChildCount(setList.getRootEntry());
		} else {
			tempCount = getSetListEntryChildCount((SetListEntry) element);
		}

		if (tempCount != currentChildCount) {
			owner.setChildCount(element, tempCount);
		}
	}

	@Override
	public Object getParent(Object element) {
		if (element == setList) {
			return null;
		} else {
			return setList.getParent((SetListEntry) element);
		}
	}

	@Override
	public void dispose() {

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		setList = (SetList) newInput;
	}

	@SuppressWarnings("unchecked")
	protected int getSetListEntryChildCount(SetListEntry anEntry) {
		switch (anEntry.getType()) {
		case EXECUTION:
		case SUITE:
			int tempStatements = ((List<Integer>) anEntry.getAttribute(SetListEntryAttributeKeys.STATEMENTS)).size();
			List<Integer> tempSetups = (List<Integer>) anEntry.getAttribute(SetListEntryAttributeKeys.SETUP);
			List<Integer> tempTeardowns = (List<Integer>) anEntry.getAttribute(SetListEntryAttributeKeys.TEARDOWN);
			if (tempSetups != null) {
				tempStatements += tempSetups.size();
			}
			if (tempTeardowns != null) {
				tempStatements += tempTeardowns.size();
			}
			return tempStatements;
		case TABLETEST:
			return ((List<Integer>) anEntry.getAttribute(SetListEntryAttributeKeys.RESULT)).size();
		default:
			return 0;
		}
	}

	@SuppressWarnings("unchecked")
	protected List<Integer> getSetListEntryChildReferences(SetListEntry anEntry) {
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
				tempTotal.addAll(tempStatements);
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

	public SetListEntry getSetListEntryChild(SetListEntry anEntry, int aChildIndex) {
		List<Integer> tempReferences = getSetListEntryChildReferences(anEntry);
		if (tempReferences != null && aChildIndex >= 0 && aChildIndex < tempReferences.size()) {
			return setList.resolveReference(tempReferences.get(aChildIndex));
		} else {
			return null;
		}
	}

}
