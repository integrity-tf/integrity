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
public class IntegerValueToFloat extends Conversion<IntegerValue, Float> {

	@Override
	public Float convert(IntegerValue aSource, Class<? extends Float> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		return aSource.getIntegerValue().floatValue();
	}

}
