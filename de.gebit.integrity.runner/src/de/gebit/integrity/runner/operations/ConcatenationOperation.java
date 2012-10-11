/**
 * 
 */
package de.gebit.integrity.runner.operations;

import de.gebit.integrity.operations.Operation;

/**
 * This operation concatenates all provided values to a single result string. Prefix and postfix parameters are
 * supported. Any values not already a string are converted to strings.
 * 
 * @author Rene Schneider
 * 
 */
public class ConcatenationOperation implements Operation<String[], String[], String> {

	@Override
	public String execute(String[] aPrefixParameter, String[] aPostfixParameter) {
		StringBuilder tempBuilder = new StringBuilder();

		if (aPrefixParameter != null) {
			for (String tempPart : aPrefixParameter) {
				tempBuilder.append(tempPart);
			}
		}
		if (aPostfixParameter != null) {
			for (String tempPart : aPostfixParameter) {
				tempBuilder.append(tempPart);
			}
		}

		return tempBuilder.toString();
	}

}
