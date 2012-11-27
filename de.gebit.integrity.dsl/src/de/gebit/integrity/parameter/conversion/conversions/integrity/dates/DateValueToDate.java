/**
 * 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.dates;

import java.text.ParseException;
import java.util.Date;

import de.gebit.integrity.dsl.DateValue;
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
public class DateValueToDate extends Conversion<DateValue, Date> {

	@Override
	public Date convert(DateValue aSource, Class<? extends Date> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		try {
			return DateUtil.convertDateValue(aSource).getTime();
		} catch (ParseException exc) {
			throw new ConversionFailedException(DateValue.class, Date.class, null, exc);
		}
	}

}
