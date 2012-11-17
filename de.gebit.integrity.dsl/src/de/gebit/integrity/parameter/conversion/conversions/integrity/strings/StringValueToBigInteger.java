/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.strings;

import java.math.BigInteger;

import de.gebit.integrity.dsl.StringValue;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider
 * 
 */
public class StringValueToBigInteger implements Conversion<StringValue, BigInteger> {

	@Override
	public BigInteger convert(StringValue aSource, Class<? extends BigInteger> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		try {
			return new BigInteger(aSource.getStringValue());
		} catch (NumberFormatException exc) {
			throw new ConversionFailedException(StringValue.class, BigInteger.class, null, exc);
		}
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
