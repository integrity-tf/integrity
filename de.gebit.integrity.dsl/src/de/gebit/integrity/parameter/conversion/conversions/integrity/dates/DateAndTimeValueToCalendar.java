/**
 * 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.dates;

import java.text.ParseException;
import java.util.Calendar;

import de.gebit.integrity.dsl.DateAndTimeValue;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.utils.DateUtil;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider
 * 
 */
@de.gebit.integrity.parameter.conversion.Conversion.Priority(0)
public class DateAndTimeValueToCalendar implements Conversion<DateAndTimeValue, Calendar> {

	@Override
	public Calendar convert(DateAndTimeValue aSource, Class<? extends Calendar> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		try {
			return DateUtil.convertDateAndTimeValue(aSource);
		} catch (ParseException exc) {
			throw new ConversionFailedException(DateAndTimeValue.class, Calendar.class, null, exc);
		}
	}

}
