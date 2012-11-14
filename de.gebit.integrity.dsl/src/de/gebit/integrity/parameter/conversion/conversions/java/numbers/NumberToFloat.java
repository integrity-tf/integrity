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
public class NumberToFloat implements TargetedConversion<Number, Float> {

	@Override
	public Float convert(Number aSource) {
		return aSource.floatValue();
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
