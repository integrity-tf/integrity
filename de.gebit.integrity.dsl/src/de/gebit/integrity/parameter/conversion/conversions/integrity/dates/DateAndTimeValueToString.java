/**
 * 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.dates;

import java.text.DateFormat;
import java.text.ParseException;

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
public class DateAndTimeValueToString implements TargetedConversion<DateAndTimeValue, String> {

	@Override
	public String convert(DateAndTimeValue aSource) throws ConversionFailedException {
		try {
			return DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(
					DateUtil.convertDateAndTimeValue(aSource).getTime());
		} catch (ParseException exc) {
			throw new ConversionFailedException(DateAndTimeValue.class, String.class, null, exc);
		}
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
