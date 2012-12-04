/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.java.numbers;

import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider
 * 
 */
public class NumberToCharacter extends Conversion<Number, Character> {

	@Override
	public Character convert(Number aSource, Class<? extends Character> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		String tempString = aSource.toString();

		if (tempString.length() != 1) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, "Number '" + tempString
					+ "' does not consist of a single character.");
		}

		return tempString.charAt(0);
	}

}
