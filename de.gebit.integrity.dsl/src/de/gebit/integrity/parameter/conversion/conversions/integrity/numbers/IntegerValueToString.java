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
public class IntegerValueToString implements TargetedConversion<IntegerValue, String> {

	@Override
	public String convert(IntegerValue aSource) throws ConversionFailedException {
		return aSource.getIntegerValue().toString();
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
