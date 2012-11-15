/**
 * 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.dates;

import java.text.ParseException;
import java.util.Calendar;

import de.gebit.integrity.dsl.DateValue;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.TargetedConversion;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.utils.DateUtil;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider
 * 
 */
public class DateValueToCalendar implements TargetedConversion<DateValue, Calendar> {

	@Override
	public Calendar convert(DateValue aSource, UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		try {
			return DateUtil.convertDateValue(aSource);
		} catch (ParseException exc) {
			throw new ConversionFailedException(DateValue.class, Calendar.class, null, exc);
		}
	}

	@Override
	public int getPriority() {
		return 0;
	}

}
