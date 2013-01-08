/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.java.other;

import java.text.DateFormat;
import java.util.Calendar;

import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider
 * 
 */
public class CalendarToString extends Conversion<Calendar, String> {

	@Override
	public String convert(Calendar aSource, Class<? extends String> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		return DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(aSource.getTime());
	}

}
