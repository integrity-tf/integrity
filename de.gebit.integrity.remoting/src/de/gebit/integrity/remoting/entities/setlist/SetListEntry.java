package de.gebit.integrity.remoting.entities.setlist;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SetListEntry implements Serializable {

	private static final long serialVersionUID = 1041569547603746549L;

	private Map<String, Serializable> attributes = new HashMap<String, Serializable>();

	private int id;

	private String type;

	public SetListEntry(int anId, SetListEntryTypes aType) {
		id = anId;
		type = aType.toString();
	}

	public int getId() {
		return id;
	}

	@Override
	public boolean equals(Object anOtherObject) {
		if (!(anOtherObject instanceof SetListEntry)) {
			return false;
		}
		SetListEntry tempOtherEntry = (SetListEntry) anOtherObject;
		return id == tempOtherEntry.id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	public SetListEntryTypes getType() {
		if (type == null) {
			return null;
		}

		try {
			return SetListEntryTypes.valueOf(type);
		} catch (IllegalArgumentException exc) {
			// if the type is unknown on the current system
			return null;
		}
	}

	public void setAttribute(SetListEntryAttributeKeys aKey, Serializable aValue) {
		attributes.put(aKey.toString(), aValue);
	}

	public Serializable getAttribute(SetListEntryAttributeKeys aKey) {
		return attributes.get(aKey.toString());
	}

	public Serializable getAttribute(SetListEntryAttributeKeys aKey, Serializable aValueIfUnset) {
		if (attributes.containsKey(aKey.toString())) {
			return attributes.get(aKey.toString());
		} else {
			attributes.put(aKey.toString(), aValueIfUnset);
			return aValueIfUnset;
		}
	}

	@SuppressWarnings("unchecked")
	public <T extends Serializable> T getAttribute(Class<T> anAttributeClass, SetListEntryAttributeKeys aKey) {
		try {
			return (T) attributes.get(aKey.toString());
		} catch (ClassCastException exc) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	public <T extends Serializable> T getAttribute(Class<T> anAttributeClass, SetListEntryAttributeKeys aKey,
			T aValueIfUnset) {
		if (attributes.containsKey(aKey.toString())) {
			try {
				return (T) attributes.get(aKey.toString());
			} catch (ClassCastException exc) {
				return null;
			}
		} else {
			attributes.put(aKey.toString(), aValueIfUnset);
			return aValueIfUnset;
		}
	}

	@Override
	public String toString() {
		StringBuffer tempBuffer = new StringBuffer();
		tempBuffer.append(type + " (" + id + "):\n");
		for (Entry<String, Serializable> tempEntry : attributes.entrySet()) {
			tempBuffer.append(tempEntry.getKey() + ": " + tempEntry.getValue().toString() + "\n");
		}

		return tempBuffer.toString();
	}

}
