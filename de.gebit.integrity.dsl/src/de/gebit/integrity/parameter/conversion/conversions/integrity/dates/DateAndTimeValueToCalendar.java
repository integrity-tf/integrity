/**
 * 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.dates;

import java.text.ParseException;
import java.util.Calendar;

import de.gebit.integrity.dsl.DateAndTimeValue;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.TargetedConversion;
import de.gebit.integrity.utils.DateUtil;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider
 * 
 */
public class DateAndTimeValueToCalendar implements TargetedConversion<DateAndTimeValue, Calendar> {

	@Override
	public Calendar convert(DateAndTimeValue aSource) {
		try {
			return DateUtil.convertDateAndTimeValue(aSource);
		} catch (ParseException exc) {
			throw new ConversionFailedException(DateAndTimeValue.class, Calendar.class, null, exc);
		}
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
