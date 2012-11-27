/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.strings;

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
public class StringValueToShort extends Conversion<StringValue, Short> {

	@Override
	public Short convert(StringValue aSource, Class<? extends Short> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		try {
			return Short.parseShort(aSource.getStringValue());
		} catch (NumberFormatException exc) {
			throw new ConversionFailedException(StringValue.class, Short.class, null, exc);
		}
	}

}
