package de.gebit.integrity.utils;

import org.eclipse.xtext.common.types.JvmField;

/**
 * Container class that links a named result name to a field.
 * 
 * @author Rene Schneider (rene.schneider@gebit.de)
 * 
 */
public class ResultFieldTuple {

	/**
	 * The result name.
	 */
	private String resultName;

	/**
	 * The field.
	 */
	private JvmField field;

	/**
	 * Creates a new instance.
	 * 
	 * @param aResultName
	 * @param aField
	 */
	public ResultFieldTuple(String aResultName, JvmField aField) {
		super();
		resultName = aResultName;
		field = aField;
	}

	public String getResultName() {
		return resultName;
	}

	public JvmField getField() {
		return field;
	}

}
