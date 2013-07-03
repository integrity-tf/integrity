package de.gebit.integrity.experiments.fixtures;

import de.gebit.integrity.operations.custom.Operation;

public class ConcatenationOperation implements Operation<String[], String[], String> {

	@Override
	public String execute(String[] aPrefixParameter, String[] aPostfixParameter) {
		StringBuffer tempBuffer = new StringBuffer();
		if (aPrefixParameter != null) {
			for (String tempString : aPrefixParameter) {
				tempBuffer.append(tempString);
			}
		}
		if (aPostfixParameter != null) {
			for (String tempString : aPostfixParameter) {
				tempBuffer.append(tempString);
			}
		}

		return tempBuffer.toString();
	}
}
