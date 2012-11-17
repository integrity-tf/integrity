/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.java.strings;

import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider
 * 
 */
public class StringToByte implements Conversion<String, Byte> {

	@Override
	public Byte convert(String aSource, Class<? extends Byte> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		return Byte.parseByte(aSource);
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
