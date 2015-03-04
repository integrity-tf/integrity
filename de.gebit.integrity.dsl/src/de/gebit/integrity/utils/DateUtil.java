/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.utils;

import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import de.gebit.integrity.dsl.DateAndTimeValue;
import de.gebit.integrity.dsl.DateValue;
import de.gebit.integrity.dsl.EuropeanDateAnd12HrsTimeValue;
import de.gebit.integrity.dsl.EuropeanDateAnd24HrsTimeValue;
import de.gebit.integrity.dsl.EuropeanDateValue;
import de.gebit.integrity.dsl.IsoDateAndTimeValue;
import de.gebit.integrity.dsl.IsoDateValue;
import de.gebit.integrity.dsl.IsoTimeValue;
import de.gebit.integrity.dsl.Simple12HrsTimeValue;
import de.gebit.integrity.dsl.Simple24HrsTimeValue;
import de.gebit.integrity.dsl.TimeValue;
import de.gebit.integrity.dsl.USDateAnd12HrsTimeValue;
import de.gebit.integrity.dsl.USDateValue;

/**
 * A utility class to handle date/time parsing and other date stuff. Sorry for the uglyness, but date/time handling just
 * IS ugly crap, especially when using Java's built-in functionality :-(.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public final class DateUtil {

	private DateUtil() {
		// nothing to do
	}

	/**
	 * Creates a preconfigured {@link SimpleDateFormat} for the given format string which can be used by the class
	 * internally.
	 * 
	 * @param aFormatString
	 *            the format string to use
	 * @return the date format instance
	 */
	private static SimpleDateFormat getSimpleDateFormat(String aFormatString) {
		SimpleDateFormat tempFormat = new SimpleDateFormat(aFormatString);
		tempFormat.setLenient(false);
		return tempFormat;
	}

	/**
	 * Converts a given date value to a {@link Calendar}.
	 * 
	 * @param aValue
	 *            the date value
	 * @return the calendar set to the specified date
	 * @throws ParseException
	 *             if the value cannot be parsed because it is of wrong format or depicts an illegal date/time
	 */
	public static Calendar convertDateValue(DateValue aValue) throws ParseException {
		if (aValue instanceof IsoDateValue) {
			return parseIsoDateAndTimeString(aValue.getDateValue(), null);
		} else if (aValue instanceof EuropeanDateValue) {
			return parseDateOrTimeString(aValue.getDateValue(), "dd.MM.yyyy");
		} else if (aValue instanceof USDateValue) {
			return parseDateOrTimeString(aValue.getDateValue(), "MM/dd/yyyy");
		} else {
			throw new UnsupportedOperationException("Someone forgot to implement a new date format!");
		}
	}

	/**
	 * Converts a given time value to a {@link Calendar}.
	 * 
	 * @param aValue
	 *            the time value
	 * @return the calendar set to the specified date
	 * @throws ParseException
	 *             if the value cannot be parsed because it is of wrong format or depicts an illegal date/time
	 */
	public static Calendar convertTimeValue(TimeValue aValue) throws ParseException {
		if (aValue instanceof IsoTimeValue) {
			return parseIsoDateAndTimeString(null, aValue.getTimeValue());
		} else if (aValue instanceof Simple24HrsTimeValue) {
			return parseEuropeanDateAnd24HrsTimeString(null, aValue.getTimeValue());
		} else if (aValue instanceof Simple12HrsTimeValue) {
			return parseEuropeanDateAnd12HrsTimeString(null, aValue.getTimeValue());
		} else {
			throw new UnsupportedOperationException("Someone forgot to implement a new time format!");
		}
	}

	/**
	 * Converts a given date and time to a {@link Calendar}.
	 * 
	 * @param aValue
	 *            the date value
	 * @return the calendar set to the specified date
	 * @throws ParseException
	 *             if the value cannot be parsed because it is of wrong format or depicts an illegal date/time
	 */
	public static Calendar convertDateAndTimeValue(DateAndTimeValue aValue) throws ParseException {
		if (aValue instanceof IsoDateAndTimeValue) {
			return parseIsoDateAndTimeString(aValue.getDateValue(), aValue.getTimeValue());
		} else if (aValue instanceof EuropeanDateAnd24HrsTimeValue) {
			return parseEuropeanDateAnd24HrsTimeString(aValue.getDateValue(), aValue.getTimeValue());
		} else if (aValue instanceof EuropeanDateAnd12HrsTimeValue) {
			return parseEuropeanDateAnd12HrsTimeString(aValue.getDateValue(), aValue.getTimeValue());
		} else if (aValue instanceof USDateAnd12HrsTimeValue) {
			return parseUSDateAnd12HrsTimeString(aValue.getDateValue(), aValue.getTimeValue());
		} else {
			throw new UnsupportedOperationException("Someone forgot to implement a new time format!");
		}
	}

	/**
	 * Strips the time information from a given {@link Date} (sets all time fields to zero).
	 * 
	 * @param aDate
	 *            the date
	 * @return a new Date without time information
	 */
	public static Date stripTimeFromDate(Date aDate) {
		Calendar tempCalendar = Calendar.getInstance();

		tempCalendar.setTime(aDate);
		tempCalendar.set(Calendar.HOUR_OF_DAY, 0);
		tempCalendar.set(Calendar.MINUTE, 0);
		tempCalendar.set(Calendar.SECOND, 0);
		tempCalendar.set(Calendar.MILLISECOND, 0);

		return tempCalendar.getTime();
	}

	/**
	 * Strips the date information from a given {@link Date} (sets all time fields to zero).
	 * 
	 * @param aTime
	 *            the time
	 * @return a new Time without the date information
	 */
	public static Date stripDateFromTime(Date aTime) {
		if (aTime == null) {
			return null;
		}
		Calendar tempCalendar = Calendar.getInstance();

		tempCalendar.setTime(aTime);
		tempCalendar.set(Calendar.YEAR, 0);
		tempCalendar.set(Calendar.MONTH, 0);
		tempCalendar.set(Calendar.DAY_OF_MONTH, 0);

		return tempCalendar.getTime();
	}

	private static Calendar parseDateOrTimeString(String aDateString, String aFormatString) throws ParseException {
		Calendar tempCalendar = Calendar.getInstance();
		tempCalendar.setTime(getSimpleDateFormat(aFormatString).parse(aDateString));
		return tempCalendar;
	}

	private static Calendar parseEuropeanDateAnd24HrsTimeString(String aDateString, String aTimeString)
			throws ParseException {
		String tempStringToParse;
		if (aDateString != null) {
			tempStringToParse = aDateString;
		} else {
			// use the common "zero" date if no date was given.
			tempStringToParse = "01.01.1970";
		}

		// append a divider
		tempStringToParse += "T";

		if (aTimeString.length() < 6) {
			// append seconds if they're not given; they're optional, but if not present :00 is assumed
			tempStringToParse += aTimeString + ":00.000";
		} else {
			if (aTimeString.length() < 9) {
				// append milliseconds if they're not given
				tempStringToParse += aTimeString + ".000";
			} else {
				tempStringToParse += aTimeString;
			}
		}

		return parseDateOrTimeString(tempStringToParse, "dd.MM.yyyy'T'HH:mm:ss.SSS");
	}

	private static Calendar parseEuropeanDateAnd12HrsTimeString(String aDateString, String aTimeString)
			throws ParseException {
		String tempStringToParse;
		if (aDateString != null) {
			tempStringToParse = aDateString;
		} else {
			// use the common "zero" date if no date was given.
			tempStringToParse = "01.01.1970";
		}

		// append a divider
		tempStringToParse += "T";

		if (aTimeString.length() < 8) {
			// inject seconds if they're not given; they're optional, but if not present :00 is assumed
			tempStringToParse += aTimeString.substring(0, aTimeString.length() - 2) + ":00.000"
					+ aTimeString.substring(aTimeString.length() - 2);
		} else {
			if (aTimeString.length() < 11) {
				// inject just milliseconds
				tempStringToParse += aTimeString.substring(0, aTimeString.length() - 2) + ".000"
						+ aTimeString.substring(aTimeString.length() - 2);
			} else {
				tempStringToParse += aTimeString;
			}
		}

		return parseDateOrTimeString(tempStringToParse, "dd.MM.yyyy'T'hh:mm:ss.SSSaa");
	}

	private static Calendar parseUSDateAnd12HrsTimeString(String aDateString, String aTimeString) throws ParseException {
		String tempStringToParse;
		if (aDateString != null) {
			tempStringToParse = aDateString;
		} else {
			// use the common "zero" date if no date was given.
			tempStringToParse = "01/01/1970";
		}

		// append a divider
		tempStringToParse += "T";

		if (aTimeString.length() < 8) {
			// inject seconds if they're not given; they're optional, but if not present :00 is assumed
			tempStringToParse += aTimeString.substring(0, aTimeString.length() - 2) + ":00.000"
					+ aTimeString.substring(aTimeString.length() - 2);
		} else {
			if (aTimeString.length() < 11) {
				// inject just milliseconds
				tempStringToParse += aTimeString.substring(0, aTimeString.length() - 2) + ".000"
						+ aTimeString.substring(aTimeString.length() - 2);
			} else {
				tempStringToParse += aTimeString;
			}
		}

		return parseDateOrTimeString(tempStringToParse, "MM/dd/yyyy'T'hh:mm:ss.SSSaa");
	}

	private static Calendar parseIsoDateAndTimeString(String aDateString, String aTimeString) throws ParseException {
		String tempDateValue = aDateString;
		if (tempDateValue == null) {
			// in case no date is given, use the "zero" date
			tempDateValue = "1970-01-01";
		}

		String tempTimeValue;

		if (aTimeString == null) {
			// in case no time is given, use the "zero" time
			tempTimeValue = "T00:00:00.000";
		} else {
			tempTimeValue = aTimeString;
			if (!tempTimeValue.startsWith("T")) {
				tempTimeValue = "T" + tempTimeValue;
			}

			// handle Zulu time
			tempTimeValue = tempTimeValue.replace("Z", "+0000");
		}

		boolean tempHasTimezone = tempTimeValue.contains("+") | tempTimeValue.contains("-");
		boolean tempHasSeconds = (!tempHasTimezone && tempTimeValue.length() > 6)
				| (tempHasTimezone && tempTimeValue.length() > 12);

		if (tempHasTimezone) {
			if (tempTimeValue.charAt(tempTimeValue.length() - 3) == ':') {
				// remove the optional colon in the timezone, if present
				tempTimeValue = tempTimeValue.substring(0, tempTimeValue.length() - 3)
						+ tempTimeValue.substring(tempTimeValue.length() - 2, tempTimeValue.length());
			}
		}

		if (tempHasSeconds) {
			if (!tempTimeValue.contains(".")) {
				// inject milliseconds, if none are present but seconds are given
				if (tempHasTimezone) {
					tempTimeValue = tempTimeValue.substring(0, tempTimeValue.length() - 5) + ".000"
							+ tempTimeValue.substring(tempTimeValue.length() - 5);
				} else {
					tempTimeValue += ".000";
				}
			}
		}

		Calendar tempCalendar;

		if (tempHasTimezone) {
			if (tempTimeValue.charAt(tempTimeValue.length() - 3) == ':') {
				// remove the optional colon in the timezone, if present
				tempTimeValue = tempTimeValue.substring(0, tempTimeValue.length() - 3)
						+ tempTimeValue.substring(tempTimeValue.length() - 2, tempTimeValue.length());
			}
			tempCalendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"
					+ tempTimeValue.substring(tempHasSeconds ? 9 : 6)));

			if (tempHasSeconds) {
				tempCalendar.setTime(getSimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(
						tempDateValue + tempTimeValue));
			} else {
				tempCalendar.setTime(getSimpleDateFormat("yyyy-MM-dd'T'HH:mmZ").parse(tempDateValue + tempTimeValue));
			}
		} else {
			tempCalendar = Calendar.getInstance();

			if (tempHasSeconds) {
				tempCalendar.setTime(getSimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS").parse(
						tempDateValue + tempTimeValue));
			} else {
				tempCalendar.setTime(getSimpleDateFormat("yyyy-MM-dd'T'HH:mm").parse(tempDateValue + tempTimeValue));
			}
		}

		return tempCalendar;
	}

	/**
	 * Performs date formatting using the provided format, but injects millisecond precision if the millisecond value is
	 * not "000". This is intended to be used with the standard date/time formats returned by DateFormat factory
	 * methods, which don't include milliseconds in most cases unfortunately. It employs a rather ugly hack to enhance
	 * the pattern which only works with {@link SimpleDateFormat}, but as far as I know there's no better method to
	 * achieve this result.
	 * 
	 * @param aFormat
	 *            the base format
	 * @param aDate
	 *            the date to format
	 * @return the formatted string
	 */
	public static String formatDateWithMilliseconds(DateFormat aFormat, Date aDate) {
		DateFormat tempFormat = aFormat;

		if (aDate.getTime() % 1000 != 0) {
			if (aFormat instanceof SimpleDateFormat) {
				Field tempField;
				try {
					tempField = SimpleDateFormat.class.getDeclaredField("pattern");
					tempField.setAccessible(true);
					String tempPattern = (String) tempField.get(aFormat);

					tempPattern = tempPattern.replace(":ss", ":ss.SSS");

					tempFormat = new SimpleDateFormat(tempPattern);
				} catch (SecurityException exc) {
					exc.printStackTrace();
				} catch (NoSuchFieldException exc) {
					exc.printStackTrace();
				} catch (IllegalArgumentException exc) {
					exc.printStackTrace();
				} catch (IllegalAccessException exc) {
					exc.printStackTrace();
				}
			}
		}

		return tempFormat.format(aDate);
	}

	/**
	 * Converts a duration in nanoseconds to a human-readable, nicely formatted string.
	 * 
	 * @param aTimespan
	 *            the timespan in nanoseconds
	 * @param aShortFormat
	 *            if true, a short format for the units is chosen
	 * @param aLongFormat
	 *            if true, a long format for the units is chosen
	 * @return the formatted string
	 */
	public static String convertNanosecondTimespanToHumanReadableFormat(long aTimespan, boolean aShortFormat,
			boolean aLongFormat) {
		if (aTimespan < TimeUnit.SECONDS.toMillis(1)) {
			return aTimespan + (aShortFormat ? "ms" : aLongFormat ? " milliseconds" : "ms");
		} else {
			StringBuilder tempBuilder = new StringBuilder();

			if (aTimespan >= TimeUnit.DAYS.toNanos(1)) {
				tempBuilder.append(TimeUnit.NANOSECONDS.toDays(aTimespan)
						+ (aShortFormat ? "d" : aLongFormat ? " days" : " days"));
			}
			if (aTimespan >= TimeUnit.HOURS.toNanos(1)) {
				if (tempBuilder.length() > 0) {
					tempBuilder.append(" ");
				}
				tempBuilder.append(TimeUnit.NANOSECONDS.toHours(aTimespan % TimeUnit.DAYS.toNanos(1))
						+ (aShortFormat ? "h" : aLongFormat ? " hours" : "hrs"));
			}
			if (aTimespan >= TimeUnit.MINUTES.toNanos(1)) {
				if (tempBuilder.length() > 0) {
					tempBuilder.append(" ");
				}
				tempBuilder.append(TimeUnit.NANOSECONDS.toMinutes(aTimespan % TimeUnit.HOURS.toNanos(1))
						+ (aShortFormat ? "m" : aLongFormat ? " minutes" : "min"));
			}
			if (aTimespan >= TimeUnit.SECONDS.toNanos(1)) {
				if (tempBuilder.length() > 0) {
					tempBuilder.append(" ");
				}
				tempBuilder.append(TimeUnit.NANOSECONDS.toSeconds(aTimespan % TimeUnit.MINUTES.toNanos(1))
						+ (aShortFormat ? "s" : aLongFormat ? " seconds" : "sec"));
			}
			if (aTimespan >= TimeUnit.MILLISECONDS.toNanos(1) && aTimespan < TimeUnit.MINUTES.toNanos(1)) {
				if (tempBuilder.length() > 0) {
					tempBuilder.append(" ");
				}
				tempBuilder.append(TimeUnit.NANOSECONDS.toMillis(aTimespan % TimeUnit.SECONDS.toNanos(1))
						+ (aShortFormat ? "ms" : aLongFormat ? " milliseconds" : "msecs"));
			}
			if (aTimespan >= 1 && aTimespan < TimeUnit.SECONDS.toNanos(1)) {
				if (tempBuilder.length() > 0) {
					tempBuilder.append(" ");
				}
				tempBuilder.append((aTimespan % TimeUnit.MILLISECONDS.toNanos(1))
						+ (aShortFormat ? "ns" : aLongFormat ? " nanoseconds" : "ns"));
			}

			return tempBuilder.toString();
		}
	}
}
