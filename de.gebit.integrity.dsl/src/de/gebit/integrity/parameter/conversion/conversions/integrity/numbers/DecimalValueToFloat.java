/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.numbers;

import de.gebit.integrity.dsl.DecimalValue;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.TargetedConversion;

/**
 * A default Integrity conversion. 
 * 
 * @author Rene Schneider
 * 
 */
public class DecimalValueToFloat implements TargetedConversion<DecimalValue, Float> {

	@Override
	public Float convert(DecimalValue aSource) throws ConversionFailedException {
		return aSource.getDecimalValue().floatValue();
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
