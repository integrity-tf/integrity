/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.java.strings;

import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider
 * 
 */
public class StringToCharacter extends Conversion<String, Character> {

	@Override
	public Character convert(String aSource, Class<? extends Character> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		if (aSource.length() != 1) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, "String '" + aSource
					+ "' does not consist of a single character.");
		}

		return aSource.charAt(0);

	}

}
