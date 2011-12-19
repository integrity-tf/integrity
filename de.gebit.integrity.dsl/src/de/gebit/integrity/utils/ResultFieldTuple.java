package de.gebit.integrity.utils;

import org.eclipse.xtext.common.types.JvmField;

public class ResultFieldTuple {

	private String resultName;

	private JvmField field;

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
