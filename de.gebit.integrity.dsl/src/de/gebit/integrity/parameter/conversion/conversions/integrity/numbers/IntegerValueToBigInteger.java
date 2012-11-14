/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.numbers;

import java.math.BigInteger;

import de.gebit.integrity.dsl.IntegerValue;
import de.gebit.integrity.parameter.conversion.TargetedConversion;

/**
 * A default Integrity conversion. 
 * 
 * @author Rene Schneider
 * 
 */
public class IntegerValueToBigInteger implements TargetedConversion<IntegerValue, BigInteger> {

	@Override
	public BigInteger convert(IntegerValue aSource) {
		return aSource.getIntegerValue();
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
