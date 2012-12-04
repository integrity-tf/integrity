/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.strings;

import de.gebit.integrity.dsl.StringValue;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider
 * 
 */
@de.gebit.integrity.parameter.conversion.Conversion.Priority(0)
public class StringValueToCharacter extends Conversion<StringValue, Character> {

	@Override
	public Character convert(StringValue aSource, Class<? extends Character> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		if (aSource.getStringValue() == null || aSource.getStringValue().length() != 1) {
			throw new ConversionFailedException(aSource.getClass(), aTargetType, "String '" + aSource.getStringValue()
					+ "' does not consist of a single character.");
		}

		return aSource.getStringValue().charAt(0);
	}

}
