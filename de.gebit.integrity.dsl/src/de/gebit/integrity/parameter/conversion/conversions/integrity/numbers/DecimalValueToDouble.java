/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.numbers;

import de.gebit.integrity.dsl.DecimalValue;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider
 * 
 */
public class DecimalValueToDouble implements Conversion<DecimalValue, Double> {

	@Override
	public Double convert(DecimalValue aSource, Class<? extends Double> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		return aSource.getDecimalValue().doubleValue();
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
