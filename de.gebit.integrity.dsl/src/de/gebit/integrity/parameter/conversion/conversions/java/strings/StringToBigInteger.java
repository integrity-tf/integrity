/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.java.strings;

import java.math.BigInteger;

import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider
 * 
 */
public class StringToBigInteger implements Conversion<String, BigInteger> {

	@Override
	public BigInteger convert(String aSource, Class<? extends BigInteger> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		return new BigInteger(aSource);
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
