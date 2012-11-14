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
public class IntegerValueToInteger implements TargetedConversion<IntegerValue, Integer> {

	@Override
	public Integer convert(IntegerValue aSource) {
		return aSource.getIntegerValue().intValue();
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
