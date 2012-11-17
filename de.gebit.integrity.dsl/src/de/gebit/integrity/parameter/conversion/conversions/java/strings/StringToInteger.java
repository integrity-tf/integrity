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
public class StringToInteger implements Conversion<String, Integer> {

	@Override
	public Integer convert(String aSource, Class<? extends Integer> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		return Integer.parseInt(aSource);
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
