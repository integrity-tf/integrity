/**
 * 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.booleans;

import de.gebit.integrity.dsl.BooleanValue;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider
 * 
 */
public class BooleanValueToString implements Conversion<BooleanValue, String> {

	@Override
	public String convert(BooleanValue aSource, Class<? extends String> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		return aSource.getBooleanValue();
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
