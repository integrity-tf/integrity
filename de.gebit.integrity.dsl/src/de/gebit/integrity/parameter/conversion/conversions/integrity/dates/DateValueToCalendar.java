/**
 * 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.dates;

import java.text.ParseException;
import java.util.Calendar;

import de.gebit.integrity.dsl.DateValue;
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
public class DateValueToCalendar extends Conversion<DateValue, Calendar> {

	@Override
	public Calendar convert(DateValue aSource, Class<? extends Calendar> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		try {
			return DateUtil.convertDateValue(aSource);
		} catch (ParseException exc) {
			throw new ConversionFailedException(DateValue.class, Calendar.class, null, exc);
		}
	}

}
