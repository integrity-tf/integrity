/**
 * 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.dates;

import java.text.ParseException;
import java.util.Date;

import de.gebit.integrity.dsl.DateAndTimeValue;
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
public class DateAndTimeValueToDate implements Conversion<DateAndTimeValue, Date> {

	@Override
	public Date convert(DateAndTimeValue aSource, Class<? extends Date> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		try {
			return DateUtil.convertDateAndTimeValue(aSource).getTime();
		} catch (ParseException exc) {
			throw new ConversionFailedException(DateAndTimeValue.class, Date.class, null, exc);
		}
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
