/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.other;

import de.gebit.integrity.dsl.NullValue;
import de.gebit.integrity.parameter.conversion.UntargetedConversion;

/**
 * A default Integrity conversion. 
 * 
 * @author Rene Schneider
 * 
 */
public class NullValueToNull implements UntargetedConversion<NullValue> {

	@Override
	public Object convert(NullValue aSource, Class<?> aTargetType) {
		return null;
	}

}
