/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.java.other;

import java.text.DateFormat;
import java.util.Date;

import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider
 * 
 */
public class DateToString implements Conversion<Date, String> {

	@Override
	public String convert(Date aSource, Class<? extends String> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		return DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(aSource);
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
