/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.java.other;

import java.text.DateFormat;
import java.util.Date;

import de.gebit.integrity.parameter.conversion.TargetedConversion;

/**
 * A default Integrity conversion. 
 * 
 * @author Rene Schneider
 * 
 */
public class DateToString implements TargetedConversion<Date, String> {

	@Override
	public String convert(Date aSource) {
		return DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG).format(aSource);
	}

	@Override
	public int getPriority() {
		return Integer.MIN_VALUE;
	}

}
