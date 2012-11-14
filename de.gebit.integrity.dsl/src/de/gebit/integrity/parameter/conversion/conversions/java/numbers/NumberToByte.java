/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.java.numbers;

import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.TargetedConversion;

/**
 * A default Integrity conversion. 
 * 
 * @author Rene Schneider
 * 
 */
public class NumberToByte implements TargetedConversion<Number, Byte> {

	@Override
	public Byte convert(Number aSource) throws ConversionFailedException {
		return aSource.byteValue();
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
