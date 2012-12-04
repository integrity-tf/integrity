/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.numbers;

import de.gebit.integrity.dsl.DecimalValue;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider
 * 
 */
public class DecimalValueToCharacter extends Conversion<DecimalValue, Character> {

	@Override
	public Character convert(DecimalValue aSource, Class<? extends Character> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		String tempString = aSource.getDecimalValue().toString();

		if (tempString.length() != 1) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, "Number '" + tempString
					+ "' does not consist of a single character.");
		}

		return tempString.charAt(0);
	}

}
