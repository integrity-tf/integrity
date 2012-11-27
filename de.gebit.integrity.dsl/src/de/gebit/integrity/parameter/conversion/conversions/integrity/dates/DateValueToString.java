/**
 * 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.dates;

import java.text.DateFormat;
import java.text.ParseException;

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
public class DateValueToString extends Conversion<DateValue, String> {

	@Override
	public String convert(DateValue aSource, Class<? extends String> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException {
		try {
			return DateFormat.getDateInstance(DateFormat.LONG).format(DateUtil.convertDateValue(aSource).getTime());
		} catch (ParseException exc) {
			throw new ConversionFailedException(DateValue.class, String.class, null, exc);
		}
	}

}
