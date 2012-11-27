/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.other;

import de.gebit.integrity.dsl.EnumValue;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider
 * 
 */
@de.gebit.integrity.parameter.conversion.Conversion.Priority(0)
public class EnumValueToString extends Conversion<EnumValue, String> {

	@Override
	public String convert(EnumValue aSource, Class<? extends String> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) {
		return aSource.getEnumValue().getSimpleName();
	}

}
