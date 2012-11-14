/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.java.other;

import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.TargetedConversion;

/**
 * A default Integrity conversion. 
 * 
 * @author Rene Schneider
 * 
 */
public class BooleanToString implements TargetedConversion<Boolean, String> {

	@Override
	public String convert(Boolean aSource) throws ConversionFailedException {
		return aSource.toString();
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
