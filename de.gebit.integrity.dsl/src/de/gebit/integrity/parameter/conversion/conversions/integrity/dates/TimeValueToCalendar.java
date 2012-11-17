/**
 * 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.dates;

import java.text.ParseException;
import java.util.Calendar;

import de.gebit.integrity.dsl.TimeValue;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.utils.DateUtil;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider
 * 
 */
public class TimeValueToCalendar implements Conversion<TimeValue, Calendar> {

	@Override
	public Calendar convert(TimeValue aSource, Class<? extends Calendar> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		try {
			return DateUtil.convertTimeValue(aSource);
		} catch (ParseException exc) {
			throw new ConversionFailedException(TimeValue.class, Calendar.class, null, exc);
		}
	}

	@Override
	public int getPriority() {
		return 0;
	}

}
