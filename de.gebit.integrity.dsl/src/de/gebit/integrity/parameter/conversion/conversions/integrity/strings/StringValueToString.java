/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.strings;

import de.gebit.integrity.dsl.StringValue;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.TargetedConversion;

/**
 * A default Integrity conversion. 
 * 
 * @author Rene Schneider
 * 
 */
public class StringValueToString implements TargetedConversion<StringValue, String> {

	@Override
	public String convert(StringValue aSource) throws ConversionFailedException {
		return aSource.getStringValue();
	}

	@Override
	public int getPriority() {
		return 0;
	}

}
