/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.numbers;

import java.math.BigDecimal;

import de.gebit.integrity.dsl.IntegerValue;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider
 * 
 */
public class IntegerValueToBigDecimal extends Conversion<IntegerValue, BigDecimal> {

	@Override
	public BigDecimal convert(IntegerValue aSource, Class<? extends BigDecimal> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		return new BigDecimal(aSource.getIntegerValue(), 0);
	}

}
