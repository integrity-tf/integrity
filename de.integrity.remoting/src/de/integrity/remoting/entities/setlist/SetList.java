package de.integrity.remoting.entities.setlist;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unchecked")
public class SetList implements Serializable {

	private static final long serialVersionUID = -5710551695226775511L;

	private List<SetListEntry> entries = new ArrayList<SetListEntry>();

	private int entryListPosition;

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
			return entries.get(aParent);
		} else {
			return null;
		}
	}
}
