/**
 * 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.dates;

import java.text.ParseException;
import java.util.Date;

import de.gebit.integrity.dsl.TimeValue;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.TargetedConversion;
import de.gebit.integrity.utils.DateUtil;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider
 * 
 */
public class TimeValueToDate implements TargetedConversion<TimeValue, Date> {

	@Override
	public Date convert(TimeValue aSource) {
		try {
			return DateUtil.convertTimeValue(aSource).getTime();
		} catch (ParseException exc) {
			throw new ConversionFailedException(TimeValue.class, Date.class, null, exc);
		}
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
