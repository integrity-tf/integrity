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
public class StringValueToFloat extends Conversion<StringValue, Float> {

	@Override
	public Float convert(StringValue aSource, Class<? extends Float> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		try {
			return Float.parseFloat(aSource.getStringValue());
		} catch (NumberFormatException exc) {
			throw new ConversionFailedException(StringValue.class, Float.class, null, exc);
		}
	}

}
