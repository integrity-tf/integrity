/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.conversion;

import com.google.inject.Singleton;

import de.gebit.integrity.parameter.conversion.conversions.integrity.booleans.BooleanValueToBoolean;
import de.gebit.integrity.parameter.conversion.conversions.integrity.booleans.BooleanValueToFormattedString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.booleans.BooleanValueToString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateAndTimeValueToCalendar;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateAndTimeValueToDate;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateAndTimeValueToFormattedString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateAndTimeValueToInstant;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateAndTimeValueToLocalDate;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateAndTimeValueToLocalDateTime;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateAndTimeValueToLocalTime;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateAndTimeValueToSQLDate;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateAndTimeValueToSQLTime;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateAndTimeValueToString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateAndTimeValueToTimestamp;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateAndTimeValueToZonedDateTime;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateValueToCalendar;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateValueToDate;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateValueToFormattedString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateValueToInstant;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateValueToLocalDate;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateValueToLocalDateTime;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateValueToSQLDate;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateValueToSQLTime;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateValueToString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateValueToTimestamp;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateValueToZonedDateTime;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.TimeValueToCalendar;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.TimeValueToDate;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.TimeValueToFormattedString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.TimeValueToInstant;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.TimeValueToLocalDateTime;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.TimeValueToLocalTime;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.TimeValueToSQLDate;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.TimeValueToSQLTime;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.TimeValueToString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.TimeValueToTimestamp;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.TimeValueToZonedDateTime;
import de.gebit.integrity.parameter.conversion.conversions.integrity.javaconstants.JavaConstantToAnything;
import de.gebit.integrity.parameter.conversion.conversions.integrity.javaconstants.JavaConstantToMap;
import de.gebit.integrity.parameter.conversion.conversions.integrity.nestedobjects.NestedObjectToBean;
import de.gebit.integrity.parameter.conversion.conversions.integrity.nestedobjects.NestedObjectToFormattedString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.nestedobjects.NestedObjectToMap;
import de.gebit.integrity.parameter.conversion.conversions.integrity.nestedobjects.NestedObjectToString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.nestedobjects.TypedNestedObjectToBean;
import de.gebit.integrity.parameter.conversion.conversions.integrity.nestedobjects.TypedNestedObjectToFormattedString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.nestedobjects.TypedNestedObjectToMap;
import de.gebit.integrity.parameter.conversion.conversions.integrity.nestedobjects.TypedNestedObjectToString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.DecimalValueToBigDecimal;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.DecimalValueToDouble;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.DecimalValueToFloat;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.DecimalValueToFormattedString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.DecimalValueToNumber;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.DecimalValueToString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.IntegerValueToBigDecimal;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.IntegerValueToBigInteger;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.IntegerValueToByte;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.IntegerValueToCharacter;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.IntegerValueToDouble;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.IntegerValueToFloat;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.IntegerValueToFormattedString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.IntegerValueToInteger;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.IntegerValueToLong;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.IntegerValueToNumber;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.IntegerValueToShort;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.IntegerValueToString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.other.EmptyValueToEmptyString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.other.EmptyValueToFormattedString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.other.EnumValueToEnumConstant;
import de.gebit.integrity.parameter.conversion.conversions.integrity.other.EnumValueToFormattedString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.other.EnumValueToString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.other.InexistentValueToFormattedString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.other.InexistentValueToInexistentString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.other.NullValueToNull;
import de.gebit.integrity.parameter.conversion.conversions.integrity.other.RegexValueToFormattedString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.other.RegexValueToPattern;
import de.gebit.integrity.parameter.conversion.conversions.integrity.other.RegexValueToString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.strings.StringValueToBigDecimal;
import de.gebit.integrity.parameter.conversion.conversions.integrity.strings.StringValueToBigInteger;
import de.gebit.integrity.parameter.conversion.conversions.integrity.strings.StringValueToBoolean;
import de.gebit.integrity.parameter.conversion.conversions.integrity.strings.StringValueToByte;
import de.gebit.integrity.parameter.conversion.conversions.integrity.strings.StringValueToCharacter;
import de.gebit.integrity.parameter.conversion.conversions.integrity.strings.StringValueToDouble;
import de.gebit.integrity.parameter.conversion.conversions.integrity.strings.StringValueToEnumConstant;
import de.gebit.integrity.parameter.conversion.conversions.integrity.strings.StringValueToFloat;
import de.gebit.integrity.parameter.conversion.conversions.integrity.strings.StringValueToFormattedString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.strings.StringValueToInteger;
import de.gebit.integrity.parameter.conversion.conversions.integrity.strings.StringValueToLong;
import de.gebit.integrity.parameter.conversion.conversions.integrity.strings.StringValueToNumber;
import de.gebit.integrity.parameter.conversion.conversions.integrity.strings.StringValueToPattern;
import de.gebit.integrity.parameter.conversion.conversions.integrity.strings.StringValueToShort;
import de.gebit.integrity.parameter.conversion.conversions.integrity.strings.StringValueToString;
import de.gebit.integrity.parameter.conversion.conversions.java.identity.BigDecimalToBigDecimal;
import de.gebit.integrity.parameter.conversion.conversions.java.identity.BigIntegerToBigInteger;
import de.gebit.integrity.parameter.conversion.conversions.java.identity.BooleanToBoolean;
import de.gebit.integrity.parameter.conversion.conversions.java.identity.ByteToByte;
import de.gebit.integrity.parameter.conversion.conversions.java.identity.CharacterToCharacter;
import de.gebit.integrity.parameter.conversion.conversions.java.identity.DoubleToDouble;
import de.gebit.integrity.parameter.conversion.conversions.java.identity.FloatToFloat;
import de.gebit.integrity.parameter.conversion.conversions.java.identity.FormattedStringToFormattedString;
import de.gebit.integrity.parameter.conversion.conversions.java.identity.FormattedStringToString;
import de.gebit.integrity.parameter.conversion.conversions.java.identity.IntegerToInteger;
import de.gebit.integrity.parameter.conversion.conversions.java.identity.LongToLong;
import de.gebit.integrity.parameter.conversion.conversions.java.identity.PatternToPattern;
import de.gebit.integrity.parameter.conversion.conversions.java.identity.ShortToShort;
import de.gebit.integrity.parameter.conversion.conversions.java.identity.StringToFormattedString;
import de.gebit.integrity.parameter.conversion.conversions.java.identity.StringToString;
import de.gebit.integrity.parameter.conversion.conversions.java.numbers.BigIntegerToBigDecimal;
import de.gebit.integrity.parameter.conversion.conversions.java.numbers.ByteToBigDecimal;
import de.gebit.integrity.parameter.conversion.conversions.java.numbers.DoubleToBigDecimal;
import de.gebit.integrity.parameter.conversion.conversions.java.numbers.FloatToBigDecimal;
import de.gebit.integrity.parameter.conversion.conversions.java.numbers.IntegerToBigDecimal;
import de.gebit.integrity.parameter.conversion.conversions.java.numbers.LongToBigDecimal;
import de.gebit.integrity.parameter.conversion.conversions.java.numbers.NumberToBigInteger;
import de.gebit.integrity.parameter.conversion.conversions.java.numbers.NumberToByte;
import de.gebit.integrity.parameter.conversion.conversions.java.numbers.NumberToCharacter;
import de.gebit.integrity.parameter.conversion.conversions.java.numbers.NumberToDouble;
import de.gebit.integrity.parameter.conversion.conversions.java.numbers.NumberToFloat;
import de.gebit.integrity.parameter.conversion.conversions.java.numbers.NumberToFormattedString;
import de.gebit.integrity.parameter.conversion.conversions.java.numbers.NumberToInteger;
import de.gebit.integrity.parameter.conversion.conversions.java.numbers.NumberToLong;
import de.gebit.integrity.parameter.conversion.conversions.java.numbers.NumberToShort;
import de.gebit.integrity.parameter.conversion.conversions.java.numbers.NumberToString;
import de.gebit.integrity.parameter.conversion.conversions.java.numbers.ShortToBigDecimal;
import de.gebit.integrity.parameter.conversion.conversions.java.other.BooleanToFormattedString;
import de.gebit.integrity.parameter.conversion.conversions.java.other.BooleanToString;
import de.gebit.integrity.parameter.conversion.conversions.java.other.CalendarToDate;
import de.gebit.integrity.parameter.conversion.conversions.java.other.CalendarToFormattedString;
import de.gebit.integrity.parameter.conversion.conversions.java.other.CalendarToInstant;
import de.gebit.integrity.parameter.conversion.conversions.java.other.CalendarToLocalDate;
import de.gebit.integrity.parameter.conversion.conversions.java.other.CalendarToLocalDateTime;
import de.gebit.integrity.parameter.conversion.conversions.java.other.CalendarToLocalTime;
import de.gebit.integrity.parameter.conversion.conversions.java.other.CalendarToSQLDate;
import de.gebit.integrity.parameter.conversion.conversions.java.other.CalendarToSQLTime;
import de.gebit.integrity.parameter.conversion.conversions.java.other.CalendarToString;
import de.gebit.integrity.parameter.conversion.conversions.java.other.CalendarToTimestamp;
import de.gebit.integrity.parameter.conversion.conversions.java.other.CalendarToZonedDateTime;
import de.gebit.integrity.parameter.conversion.conversions.java.other.DateToCalendar;
import de.gebit.integrity.parameter.conversion.conversions.java.other.DateToFormattedString;
import de.gebit.integrity.parameter.conversion.conversions.java.other.DateToSQLDate;
import de.gebit.integrity.parameter.conversion.conversions.java.other.DateToSQLTime;
import de.gebit.integrity.parameter.conversion.conversions.java.other.DateToString;
import de.gebit.integrity.parameter.conversion.conversions.java.other.DateToTimestamp;
import de.gebit.integrity.parameter.conversion.conversions.java.other.EnumToFormattedString;
import de.gebit.integrity.parameter.conversion.conversions.java.other.EnumToString;
import de.gebit.integrity.parameter.conversion.conversions.java.other.MapToBean;
import de.gebit.integrity.parameter.conversion.conversions.java.other.MapToFormattedString;
import de.gebit.integrity.parameter.conversion.conversions.java.other.MapToMap;
import de.gebit.integrity.parameter.conversion.conversions.java.other.MapToString;
import de.gebit.integrity.parameter.conversion.conversions.java.other.ObjectToFormattedString;
import de.gebit.integrity.parameter.conversion.conversions.java.other.ObjectToMap;
import de.gebit.integrity.parameter.conversion.conversions.java.other.ObjectToString;
import de.gebit.integrity.parameter.conversion.conversions.java.other.OptionalToContainedObject;
import de.gebit.integrity.parameter.conversion.conversions.java.other.OptionalToFormattedString;
import de.gebit.integrity.parameter.conversion.conversions.java.other.SQLDateToCalendar;
import de.gebit.integrity.parameter.conversion.conversions.java.other.SQLDateToTimestamp;
import de.gebit.integrity.parameter.conversion.conversions.java.other.SQLTimeToCalendar;
import de.gebit.integrity.parameter.conversion.conversions.java.other.SQLTimeToTimestamp;
import de.gebit.integrity.parameter.conversion.conversions.java.other.TimestampToCalendar;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.CharacterToBigDecimal;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.CharacterToBigInteger;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.CharacterToFormattedString;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.CharacterToString;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.StringToBigDecimal;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.StringToBigInteger;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.StringToByte;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.StringToCharacter;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.StringToDouble;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.StringToEnumConstant;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.StringToFloat;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.StringToInteger;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.StringToLong;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.StringToNumber;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.StringToPattern;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.StringToShort;

/**
 * Default implementation of a modular value converter. This adds all the standard Integrity-supplied conversions. You
 * may extend this class to add your own conversions, if you desire!
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
@Singleton
public class DefaultModularValueConverter extends AbstractModularValueConverter {

	@Override
	protected void initializeConversions() {
		// numeric conversions, Java -> Java
		addConversion(NumberToInteger.class);
		addConversion(NumberToLong.class);
		addConversion(NumberToShort.class);
		addConversion(NumberToByte.class);
		addConversion(NumberToBigInteger.class);
		addConversion(NumberToFloat.class);
		addConversion(NumberToDouble.class);
		addConversion(NumberToString.class);
		addConversion(NumberToFormattedString.class);
		addConversion(NumberToCharacter.class);
		addConversion(IntegerToBigDecimal.class);
		addConversion(LongToBigDecimal.class);
		addConversion(ShortToBigDecimal.class);
		addConversion(ByteToBigDecimal.class);
		addConversion(FloatToBigDecimal.class);
		addConversion(DoubleToBigDecimal.class);
		addConversion(BigIntegerToBigDecimal.class);

		// string conversions, Java -> Java
		addConversion(StringToInteger.class);
		addConversion(StringToBigInteger.class);
		addConversion(StringToBigDecimal.class);
		addConversion(StringToFloat.class);
		addConversion(StringToDouble.class);
		addConversion(StringToLong.class);
		addConversion(StringToShort.class);
		addConversion(StringToByte.class);
		addConversion(StringToCharacter.class);
		addConversion(StringToNumber.class);
		addConversion(StringToEnumConstant.class);
		addConversion(StringToPattern.class);
		addConversion(CharacterToString.class);
		addConversion(CharacterToFormattedString.class);
		addConversion(CharacterToBigInteger.class);
		addConversion(CharacterToBigDecimal.class);

		// other conversions, Java -> Java
		addConversion(BooleanToString.class);
		addConversion(BooleanToFormattedString.class);
		addConversion(DateToString.class);
		addConversion(DateToFormattedString.class);
		addConversion(CalendarToTimestamp.class);
		addConversion(CalendarToDate.class);
		addConversion(CalendarToSQLDate.class);
		addConversion(CalendarToSQLTime.class);
		addConversion(CalendarToString.class);
		addConversion(CalendarToFormattedString.class);
		addConversion(CalendarToInstant.class);
		addConversion(CalendarToLocalDate.class);
		addConversion(CalendarToLocalDateTime.class);
		addConversion(CalendarToLocalTime.class);
		addConversion(CalendarToZonedDateTime.class);
		addConversion(ObjectToString.class);
		addConversion(ObjectToFormattedString.class);
		addConversion(MapToBean.class);
		addConversion(MapToString.class);
		addConversion(MapToFormattedString.class);
		addConversion(MapToMap.class);
		addConversion(ObjectToMap.class);
		addConversion(EnumToString.class);
		addConversion(EnumToFormattedString.class);
		addConversion(DateToSQLDate.class);
		addConversion(DateToSQLTime.class);
		addConversion(DateToTimestamp.class);
		addConversion(DateToCalendar.class);
		addConversion(SQLDateToTimestamp.class);
		addConversion(SQLDateToCalendar.class);
		addConversion(SQLTimeToTimestamp.class);
		addConversion(SQLTimeToCalendar.class);
		addConversion(TimestampToCalendar.class);
		addConversion(OptionalToFormattedString.class);
		addConversion(OptionalToContainedObject.class);

		// identity conversions, Java -> Java
		addConversion(StringToString.class);
		addConversion(StringToFormattedString.class);
		addConversion(FormattedStringToFormattedString.class);
		addConversion(FormattedStringToString.class);
		addConversion(BooleanToBoolean.class);
		addConversion(BigDecimalToBigDecimal.class);
		addConversion(BigIntegerToBigInteger.class);
		addConversion(ByteToByte.class);
		addConversion(CharacterToCharacter.class);
		addConversion(DoubleToDouble.class);
		addConversion(FloatToFloat.class);
		addConversion(IntegerToInteger.class);
		addConversion(LongToLong.class);
		addConversion(ShortToShort.class);
		addConversion(PatternToPattern.class);

		// numeric conversions, Integrity -> Java
		addConversion(DecimalValueToBigDecimal.class);
		addConversion(DecimalValueToDouble.class);
		addConversion(DecimalValueToFloat.class);
		addConversion(DecimalValueToString.class);
		addConversion(DecimalValueToFormattedString.class);
		addConversion(DecimalValueToNumber.class);
		addConversion(IntegerValueToBigDecimal.class);
		addConversion(IntegerValueToBigInteger.class);
		addConversion(IntegerValueToByte.class);
		addConversion(IntegerValueToDouble.class);
		addConversion(IntegerValueToFloat.class);
		addConversion(IntegerValueToInteger.class);
		addConversion(IntegerValueToLong.class);
		addConversion(IntegerValueToShort.class);
		addConversion(IntegerValueToString.class);
		addConversion(IntegerValueToFormattedString.class);
		addConversion(IntegerValueToCharacter.class);
		addConversion(IntegerValueToNumber.class);

		// string conversions, Integrity -> Java
		addConversion(StringValueToBigDecimal.class);
		addConversion(StringValueToBigInteger.class);
		addConversion(StringValueToBoolean.class);
		addConversion(StringValueToByte.class);
		addConversion(StringValueToDouble.class);
		addConversion(StringValueToFloat.class);
		addConversion(StringValueToInteger.class);
		addConversion(StringValueToLong.class);
		addConversion(StringValueToShort.class);
		addConversion(StringValueToString.class);
		addConversion(StringValueToFormattedString.class);
		addConversion(StringValueToCharacter.class);
		addConversion(StringValueToNumber.class);
		addConversion(StringValueToEnumConstant.class);
		addConversion(StringValueToPattern.class);

		// boolean conversions, Integrity -> Java
		addConversion(BooleanValueToBoolean.class);
		addConversion(BooleanValueToString.class);
		addConversion(BooleanValueToFormattedString.class);

		// date/time conversions, Integrity -> Java
		addConversion(DateAndTimeValueToCalendar.class);
		addConversion(DateAndTimeValueToDate.class);
		addConversion(DateAndTimeValueToString.class);
		addConversion(DateAndTimeValueToFormattedString.class);
		addConversion(DateAndTimeValueToSQLDate.class);
		addConversion(DateAndTimeValueToSQLTime.class);
		addConversion(DateAndTimeValueToTimestamp.class);
		addConversion(DateValueToCalendar.class);
		addConversion(DateValueToDate.class);
		addConversion(DateValueToString.class);
		addConversion(DateValueToFormattedString.class);
		addConversion(DateValueToSQLDate.class);
		addConversion(DateValueToSQLTime.class);
		addConversion(DateValueToTimestamp.class);
		addConversion(TimeValueToCalendar.class);
		addConversion(TimeValueToDate.class);
		addConversion(TimeValueToString.class);
		addConversion(TimeValueToFormattedString.class);
		addConversion(TimeValueToSQLDate.class);
		addConversion(TimeValueToSQLTime.class);
		addConversion(TimeValueToTimestamp.class);

		// Java8 date/time conversions, Integrity -> Java
		addConversion(DateAndTimeValueToInstant.class);
		addConversion(DateAndTimeValueToLocalDateTime.class);
		addConversion(DateAndTimeValueToZonedDateTime.class);
		addConversion(DateAndTimeValueToLocalDate.class);
		addConversion(DateAndTimeValueToLocalTime.class);
		addConversion(DateValueToInstant.class);
		addConversion(DateValueToLocalDate.class);
		addConversion(DateValueToLocalDateTime.class);
		addConversion(DateValueToZonedDateTime.class);
		addConversion(TimeValueToInstant.class);
		addConversion(TimeValueToLocalDateTime.class);
		addConversion(TimeValueToLocalTime.class);
		addConversion(TimeValueToZonedDateTime.class);

		// nested objects, Integrity -> Java
		addConversion(NestedObjectToMap.class);
		addConversion(NestedObjectToString.class);
		addConversion(NestedObjectToFormattedString.class);
		addConversion(NestedObjectToBean.class);
		addConversion(TypedNestedObjectToMap.class);
		addConversion(TypedNestedObjectToString.class);
		addConversion(TypedNestedObjectToFormattedString.class);
		addConversion(TypedNestedObjectToBean.class);

		// other conversions, Integrity -> Java
		addConversion(NullValueToNull.class);
		addConversion(EnumValueToEnumConstant.class);
		addConversion(EnumValueToString.class);
		addConversion(EnumValueToFormattedString.class);
		addConversion(InexistentValueToInexistentString.class);
		addConversion(InexistentValueToFormattedString.class);
		addConversion(EmptyValueToEmptyString.class);
		addConversion(EmptyValueToFormattedString.class);
		addConversion(RegexValueToString.class);
		addConversion(RegexValueToFormattedString.class);
		addConversion(RegexValueToPattern.class);

		// java constants, Integrity -> Java
		addConversion(JavaConstantToAnything.class);
		addConversion(JavaConstantToMap.class);
	}

}
