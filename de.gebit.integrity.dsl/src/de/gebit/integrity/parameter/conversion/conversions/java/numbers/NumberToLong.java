/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.java.numbers;

import de.gebit.integrity.parameter.conversion.TargetedConversion;

/**
 * A default Integrity conversion. 
 * 
 * @author Rene Schneider
 * 
 */
public class NumberToLong implements TargetedConversion<Number, Long> {

	@Override
	public Long convert(Number aSource) {
		return aSource.longValue();
	}

	@Override
	public int getPriority() {
		return 0;
	}

}
