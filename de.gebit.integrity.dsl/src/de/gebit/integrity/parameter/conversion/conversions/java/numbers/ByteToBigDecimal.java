/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.java.numbers;

import java.math.BigDecimal;

import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.TargetedConversion;

/**
 * A default Integrity conversion. 
 * 
 * @author Rene Schneider
 * 
 */
public class ByteToBigDecimal implements TargetedConversion<Byte, BigDecimal> {

	@Override
	public BigDecimal convert(Byte aSource) throws ConversionFailedException {
		return new BigDecimal(aSource);
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
