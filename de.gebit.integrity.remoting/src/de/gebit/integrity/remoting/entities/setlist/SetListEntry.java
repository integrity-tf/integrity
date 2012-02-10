package de.gebit.integrity.remoting.entities.setlist;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * A set list entry is an entry in the {@link SetList}, which is a test execution and result data structure. The actual
 * nature of an entry is defined by its type.
 * 
 * @author Rene Schneider
 * 
 */
public class SetListEntry implements Serializable {

	/**
	 * Serialization.
	 */
	private static final long serialVersionUID = 1041569547603746549L;

	/**
	 * Attributes of this entry, with the keys being values of {@link SetListEntryAttributeKeys}, but stored as strings
	 * to prevent problems during Java serialization/deserialization due to different enum versions.
	 */
	private Map<String, Serializable> attributes = new HashMap<String, Serializable>();

	/**
	 * The ID of this entry. Entries get IDs which must be equal in the first (dry) and second (real) test run.
	 */
	private int id;

	/**
	 * The type of this entry. Stored as string to prevent problems during Java serialization/deserialization due to
	 * different versions of {@link SetListEntryTypes}.
	 */
	private String type;

	/**
	 * Creates a new instance.
	 * 
	 * @param anId
	 * @param aType
	 */
	public SetListEntry(int anId, SetListEntryTypes aType) {
		id = anId;
		type = aType.toString();
	}

	public int getId() {
		return id;
	}

	@Override
	public boolean equals(Object anOtherObject) {
		if (anOtherObject == this) {
			return true;
		}
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

	/**
	 * Returns the type. Performs automatic conversion to the {@link SetListEntryTypes} enum.
	 * 
	 * @return
	 */
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

	/**
	 * Sets the attribute.
	 * 
	 * @param aKey
	 *            the attribute key
	 * @param aValue
	 *            the value to set
	 */
	public void setAttribute(SetListEntryAttributeKeys aKey, Serializable aValue) {
		attributes.put(aKey.toString(), aValue);
	}

	/**
	 * Returns the attribute value for a specific key.
	 * 
	 * @param aKey
	 *            the attribute key
	 * @return the value, or null if none was set
	 */
	public Serializable getAttribute(SetListEntryAttributeKeys aKey) {
		return attributes.get(aKey.toString());
	}

	/**
	 * Returns the attribute value for a specific key, or a default value in case of the attribute being unset.
	 * 
	 * @param aKey
	 *            the attribute key
	 * @param aValueIfUnset
	 *            the default value
	 * @return the attribute value or the default
	 */
	public Serializable getAttribute(SetListEntryAttributeKeys aKey, Serializable aValueIfUnset) {
		if (attributes.containsKey(aKey.toString())) {
			return attributes.get(aKey.toString());
		} else {
			attributes.put(aKey.toString(), aValueIfUnset);
			return aValueIfUnset;
		}
	}

	/**
	 * Convenience method to access an attribute. Casts the attribute to a specified target class.
	 * 
	 * @param anAttributeClass
	 *            the target class
	 * @param aKey
	 *            the attribute key
	 * @return the casted attribute or null if not set or not castable to the specified class
	 */
	@SuppressWarnings("unchecked")
	public <T extends Serializable> T getAttribute(Class<T> anAttributeClass, SetListEntryAttributeKeys aKey) {
		try {
			return (T) attributes.get(aKey.toString());
		} catch (ClassCastException exc) {
			exc.printStackTrace();
			return null;
		}
	}

	/**
	 * Convenience method to access an attribute with default value. Casts the attribute to a specified target class.
	 * 
	 * @param anAttributeClass
	 *            the target class
	 * @param aKey
	 *            the attribute key
	 * @param aValueIfUnset
	 *            the default value
	 * @return the casted value or the default if not set or not castable
	 */
	@SuppressWarnings("unchecked")
	public <T extends Serializable> T getAttribute(Class<T> anAttributeClass, SetListEntryAttributeKeys aKey,
			T aValueIfUnset) {
		if (attributes.containsKey(aKey.toString())) {
			try {
				return (T) attributes.get(aKey.toString());
			} catch (ClassCastException exc) {
				exc.printStackTrace();
				return aValueIfUnset;
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
