/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.numbers;

import java.math.BigDecimal;

import de.gebit.integrity.dsl.DecimalValue;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.TargetedConversion;

/**
 * A default Integrity conversion. 
 * 
 * @author Rene Schneider
 * 
 */
public class DecimalValueToBigDecimal implements TargetedConversion<DecimalValue, BigDecimal> {

	@Override
	public BigDecimal convert(DecimalValue aSource) throws ConversionFailedException {
		return aSource.getDecimalValue();
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
