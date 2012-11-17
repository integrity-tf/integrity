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
public class StringToShort implements Conversion<String, Short> {

	@Override
	public Short convert(String aSource, Class<? extends Short> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		return Short.parseShort(aSource);
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
