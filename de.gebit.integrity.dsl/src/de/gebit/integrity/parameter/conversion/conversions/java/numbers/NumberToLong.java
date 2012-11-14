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
public class NumberToLong implements TargetedConversion<Number, Long> {

	@Override
	public Long convert(Number aSource) throws ConversionFailedException {
		return aSource.longValue();
	}

	@Override
	public int getPriority() {
		return 0;
	}

}
