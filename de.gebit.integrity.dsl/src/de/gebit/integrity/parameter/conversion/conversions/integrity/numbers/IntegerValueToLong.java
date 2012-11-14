/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.numbers;

import de.gebit.integrity.dsl.IntegerValue;
import de.gebit.integrity.parameter.conversion.TargetedConversion;

/**
 * A default Integrity conversion. 
 * 
 * @author Rene Schneider
 * 
 */
public class IntegerValueToLong implements TargetedConversion<IntegerValue, Long> {

	@Override
	public Long convert(IntegerValue aSource) {
		return aSource.getIntegerValue().longValue();
	}

	@Override
	public int getPriority() {
		return 0;
	}

}
