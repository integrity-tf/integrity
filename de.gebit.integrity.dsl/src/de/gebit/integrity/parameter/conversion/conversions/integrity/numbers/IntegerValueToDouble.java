/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.numbers;

import de.gebit.integrity.dsl.IntegerValue;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider
 * 
 */
public class IntegerValueToDouble implements Conversion<IntegerValue, Double> {

	@Override
	public Double convert(IntegerValue aSource, Class<? extends Double> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		return aSource.getIntegerValue().doubleValue();
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
