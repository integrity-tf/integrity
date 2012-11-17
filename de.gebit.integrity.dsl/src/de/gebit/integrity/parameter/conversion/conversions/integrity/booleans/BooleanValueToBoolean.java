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
public class BooleanValueToBoolean implements Conversion<BooleanValue, Boolean> {

	@Override
	public Boolean convert(BooleanValue aSource, Class<? extends Boolean> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		return Boolean.valueOf(aSource.getBooleanValue());
	}

	@Override
	public int getPriority() {
		return 0;
	}

}
