package de.integrity.eclipse.views;

import java.util.List;

import org.eclipse.jface.viewers.ILazyTreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import de.integrity.remoting.entities.setlist.SetList;
import de.integrity.remoting.entities.setlist.SetListEntry;
import de.integrity.remoting.entities.setlist.SetListEntryAttributeKeys;

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

	protected int getSetListEntryChildCount(SetListEntry anEntry) {
		List<Integer> tempChildReferences = getSetListEntryChildReferences(anEntry);
		if (tempChildReferences == null) {
			return 0;
		} else {
			return tempChildReferences.size();
		}
	}

	@SuppressWarnings("unchecked")
	protected List<Integer> getSetListEntryChildReferences(SetListEntry anEntry) {
		switch (anEntry.getType()) {
		case EXECUTION:
		case SUITE:
		case SETUP:
		case TEARDOWN:
			return (List<Integer>) anEntry.getAttribute(SetListEntryAttributeKeys.STATEMENTS);
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
