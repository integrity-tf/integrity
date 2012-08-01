package de.gebit.integrity.eclipse.views;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.jface.viewers.ILazyTreeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;

import de.gebit.integrity.remoting.entities.setlist.SetList;
import de.gebit.integrity.remoting.entities.setlist.SetListEntry;
import de.gebit.integrity.remoting.entities.setlist.SetListEntryAttributeKeys;
import de.gebit.integrity.remoting.entities.setlist.SetListEntryTypes;

/**
 * Provides the content for the main test execution tree.
 * 
 * @author Rene Schneider
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
			tempChild = getSetListEntryChild(setList.getRootEntry(), anIndex);
		} else {
			tempChild = getSetListEntryChild((SetListEntry) aParent, anIndex);
		}
		owner.replace(aParent, anIndex, tempChild);
		owner.setChildCount(tempChild, getSetListEntryChildCount(tempChild));
	}

	@Override
	public void updateChildCount(Object anElement, int aCurrentChildCount) {
		int tempCount;
		if (anElement == setList) {
			tempCount = getSetListEntryChildCount(setList.getRootEntry());
		} else {
			tempCount = getSetListEntryChildCount((SetListEntry) anElement);
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

	public void expandToLevel(int aDepth) {
		expandToLevelInternal(setList.getRootEntry(), aDepth);
	}

	protected void expandToLevelInternal(Object anEntry, int aDepth) {
		if (aDepth == 0) {
			return;
		} else {
			if (anEntry instanceof SetListEntry) {
				// table tests are excluded in automatic expansion
				if (((SetListEntry) anEntry).getType() != SetListEntryTypes.TABLETEST) {
					List<Integer> tempRefs = getSetListEntryChildReferences((SetListEntry) anEntry);
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

	/**
	 * Returns the number of children that a specified {@link SetListEntry} has. This includes only "children" to be
	 * displayed as child nodes in the tree.
	 * 
	 * @param anEntry
	 *            the entry
	 * @return the number of child nodes
	 */
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

	/**
	 * Returns a list of child node references belonging to a specified {@link SetListEntry}. This only includes such
	 * children that should be displayed in the tree.
	 * 
	 * @param anEntry
	 *            the entry
	 * @return a list of child references (entry IDs), or null if this is not applicable.
	 */
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

	/**
	 * Returns the actual child entry at a specified position within the children of a specified {@link SetListEntry}.
	 * 
	 * @param anEntry
	 *            the entry
	 * @param aChildIndex
	 *            the index of the child to get
	 * @return the child entry, or null if there is none
	 */
	public SetListEntry getSetListEntryChild(SetListEntry anEntry, int aChildIndex) {
		List<Integer> tempReferences = getSetListEntryChildReferences(anEntry);
		if (tempReferences != null && aChildIndex >= 0 && aChildIndex < tempReferences.size()) {
			return setList.resolveReference(tempReferences.get(aChildIndex));
		} else {
			return null;
		}
	}

}
