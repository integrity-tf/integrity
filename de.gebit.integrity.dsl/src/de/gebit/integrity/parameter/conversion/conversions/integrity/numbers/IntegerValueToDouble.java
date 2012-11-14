/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.numbers;

import de.gebit.integrity.dsl.IntegerValue;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.TargetedConversion;

/**
 * A default Integrity conversion. 
 * 
 * @author Rene Schneider
 * 
 */
public class IntegerValueToDouble implements TargetedConversion<IntegerValue, Double> {

	@Override
	public Double convert(IntegerValue aSource) throws ConversionFailedException {
		return aSource.getIntegerValue().doubleValue();
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
