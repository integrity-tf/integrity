/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.java.strings;

import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.TargetedConversion;

/**
 * A default Integrity conversion. This conversion actually doesn't convert anything - it exists solely to keep strings as strings by default.
 * 
 * @author Rene Schneider
 * 
 */
public class StringToString implements TargetedConversion<String, String> {

	@Override
	public String convert(String aSource) throws ConversionFailedException {
		return aSource;
	}

	@Override
	public int getPriority() {
		return 0;
	}

}
