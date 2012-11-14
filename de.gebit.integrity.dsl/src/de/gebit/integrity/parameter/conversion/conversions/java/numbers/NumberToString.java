/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.java.numbers;

import de.gebit.integrity.parameter.conversion.TargetedConversion;

/**
 * A default Integrity conversion. 
 * 
 * @author Rene Schneider
 * 
 */
public class NumberToString implements TargetedConversion<Number, String> {

	@Override
	public String convert(Number aSource) {
		return aSource.toString();
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
