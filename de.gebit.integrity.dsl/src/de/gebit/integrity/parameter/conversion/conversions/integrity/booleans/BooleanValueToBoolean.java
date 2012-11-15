/**
 * 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.booleans;

import de.gebit.integrity.dsl.BooleanValue;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.TargetedConversion;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class BooleanValueToBoolean implements TargetedConversion<BooleanValue, Boolean> {

	@Override
	public Boolean convert(BooleanValue aSource, UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		return Boolean.valueOf(aSource.getBooleanValue());
	}

	@Override
	public int getPriority() {
		return 0;
	}

}
