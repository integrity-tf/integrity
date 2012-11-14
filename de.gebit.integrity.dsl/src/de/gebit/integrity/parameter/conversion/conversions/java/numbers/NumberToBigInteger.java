/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.java.numbers;

import java.math.BigInteger;

import de.gebit.integrity.parameter.conversion.TargetedConversion;

/**
 * A default Integrity conversion. 
 * 
 * @author Rene Schneider
 * 
 */
public class NumberToBigInteger implements TargetedConversion<Number, BigInteger> {

	@Override
	public BigInteger convert(Number aSource) {
		return BigInteger.valueOf(aSource.longValue());
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
