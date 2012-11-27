/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.java.numbers;

import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider
 * 
 */
public class NumberToDouble extends Conversion<Number, Double> {

	@Override
	public Double convert(Number aSource, Class<? extends Double> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		return aSource.doubleValue();
	}

}
