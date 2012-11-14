/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.java.numbers;

import java.math.BigDecimal;

import de.gebit.integrity.parameter.conversion.TargetedConversion;

/**
 * A default Integrity conversion. 
 * 
 * @author Rene Schneider
 * 
 */
public class DoubleToBigDecimal implements TargetedConversion<Double, BigDecimal> {

	@Override
	public BigDecimal convert(Double aSource) {
		return new BigDecimal(aSource);
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
