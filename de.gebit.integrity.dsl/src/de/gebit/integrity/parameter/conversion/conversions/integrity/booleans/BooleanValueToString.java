/**
 * 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.booleans;

import de.gebit.integrity.dsl.BooleanValue;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.TargetedConversion;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class BooleanValueToString implements TargetedConversion<BooleanValue, String> {

	@Override
	public String convert(BooleanValue aSource) throws ConversionFailedException {
		return aSource.getBooleanValue();
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
