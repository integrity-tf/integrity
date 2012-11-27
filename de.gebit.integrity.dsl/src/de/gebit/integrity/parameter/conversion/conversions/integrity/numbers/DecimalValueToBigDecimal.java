/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.numbers;

import java.math.BigDecimal;

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
public class DecimalValueToBigDecimal extends Conversion<DecimalValue, BigDecimal> {

	@Override
	public BigDecimal convert(DecimalValue aSource, Class<? extends BigDecimal> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		return aSource.getDecimalValue();
	}

}
