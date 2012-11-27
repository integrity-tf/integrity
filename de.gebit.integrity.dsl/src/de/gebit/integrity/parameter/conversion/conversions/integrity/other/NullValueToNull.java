/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.other;

import de.gebit.integrity.dsl.NullValue;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider
 * 
 */
@de.gebit.integrity.parameter.conversion.Conversion.Priority(0)
public class NullValueToNull extends Conversion<NullValue, Object> {

	@Override
	public Object convert(NullValue aSource, Class<? extends Object> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) {
		return null;
	}

}
