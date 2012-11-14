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
public class IntegerValueToByte implements TargetedConversion<IntegerValue, Byte> {

	@Override
	public Byte convert(IntegerValue aSource) {
		return aSource.getIntegerValue().byteValue();
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
