/**
 * 
 */
package de.gebit.integrity.parameter.conversion;

import com.google.inject.Singleton;

import de.gebit.integrity.parameter.conversion.conversions.integrity.booleans.BooleanValueToBoolean;
import de.gebit.integrity.parameter.conversion.conversions.integrity.booleans.BooleanValueToString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateAndTimeValueToCalendar;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateAndTimeValueToDate;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateAndTimeValueToString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateValueToCalendar;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateValueToDate;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.DateValueToString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.TimeValueToCalendar;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.TimeValueToDate;
import de.gebit.integrity.parameter.conversion.conversions.integrity.dates.TimeValueToString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.nestedobjects.NestedObjectToBean;
import de.gebit.integrity.parameter.conversion.conversions.integrity.nestedobjects.NestedObjectToMap;
import de.gebit.integrity.parameter.conversion.conversions.integrity.nestedobjects.NestedObjectToString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.DecimalValueToBigDecimal;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.DecimalValueToDouble;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.DecimalValueToFloat;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.DecimalValueToString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.IntegerValueToBigDecimal;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.IntegerValueToBigInteger;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.IntegerValueToByte;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.IntegerValueToCharacter;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.IntegerValueToDouble;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.IntegerValueToFloat;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.IntegerValueToInteger;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.IntegerValueToLong;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.IntegerValueToShort;
import de.gebit.integrity.parameter.conversion.conversions.integrity.numbers.IntegerValueToString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.other.EnumValueToEnumConstant;
import de.gebit.integrity.parameter.conversion.conversions.integrity.other.EnumValueToString;
import de.gebit.integrity.parameter.conversion.conversions.integrity.other.NullValueToNull;
import de.gebit.integrity.parameter.conversion.conversions.integrity.strings.StringValueToBigDecimal;
import de.gebit.integrity.parameter.conversion.conversions.integrity.strings.StringValueToBigInteger;
import de.gebit.integrity.parameter.conversion.conversions.integrity.strings.StringValueToBoolean;
import de.gebit.integrity.parameter.conversion.conversions.integrity.strings.StringValueToByte;
import de.gebit.integrity.parameter.conversion.conversions.integrity.strings.StringValueToCharacter;
import de.gebit.integrity.parameter.conversion.conversions.integrity.strings.StringValueToDouble;
import de.gebit.integrity.parameter.conversion.conversions.integrity.strings.StringValueToFloat;
import de.gebit.integrity.parameter.conversion.conversions.integrity.strings.StringValueToInteger;
import de.gebit.integrity.parameter.conversion.conversions.integrity.strings.StringValueToLong;
import de.gebit.integrity.parameter.conversion.conversions.integrity.strings.StringValueToShort;
import de.gebit.integrity.parameter.conversion.conversions.integrity.strings.StringValueToString;
import de.gebit.integrity.parameter.conversion.conversions.java.identity.BigDecimalToBigDecimal;
import de.gebit.integrity.parameter.conversion.conversions.java.identity.BigIntegerToBigInteger;
import de.gebit.integrity.parameter.conversion.conversions.java.identity.BooleanToBoolean;
import de.gebit.integrity.parameter.conversion.conversions.java.identity.ByteToByte;
import de.gebit.integrity.parameter.conversion.conversions.java.identity.CharacterToCharacter;
import de.gebit.integrity.parameter.conversion.conversions.java.identity.DoubleToDouble;
import de.gebit.integrity.parameter.conversion.conversions.java.identity.FloatToFloat;
import de.gebit.integrity.parameter.conversion.conversions.java.identity.IntegerToInteger;
import de.gebit.integrity.parameter.conversion.conversions.java.identity.LongToLong;
import de.gebit.integrity.parameter.conversion.conversions.java.identity.ShortToShort;
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
import de.gebit.integrity.parameter.conversion.conversions.java.numbers.NumberToInteger;
import de.gebit.integrity.parameter.conversion.conversions.java.numbers.NumberToLong;
import de.gebit.integrity.parameter.conversion.conversions.java.numbers.NumberToShort;
import de.gebit.integrity.parameter.conversion.conversions.java.numbers.NumberToString;
import de.gebit.integrity.parameter.conversion.conversions.java.numbers.ShortToBigDecimal;
import de.gebit.integrity.parameter.conversion.conversions.java.other.BooleanToString;
import de.gebit.integrity.parameter.conversion.conversions.java.other.CalendarToString;
import de.gebit.integrity.parameter.conversion.conversions.java.other.DateToString;
import de.gebit.integrity.parameter.conversion.conversions.java.other.EnumToString;
import de.gebit.integrity.parameter.conversion.conversions.java.other.MapToString;
import de.gebit.integrity.parameter.conversion.conversions.java.other.ObjectToMap;
import de.gebit.integrity.parameter.conversion.conversions.java.other.ObjectToString;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.CharacterToBigDecimal;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.CharacterToBigInteger;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.CharacterToString;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.StringToBigDecimal;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.StringToBigInteger;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.StringToByte;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.StringToCharacter;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.StringToDouble;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.StringToFloat;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.StringToInteger;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.StringToLong;
import de.gebit.integrity.parameter.conversion.conversions.java.strings.StringToShort;

/**
 * Default implementation of a modular value converter. This adds all the standard Integrity-supplied conversions. You
 * may extend this class to add your own conversions, if you desire!
 * 
 * @author Rene Schneider
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
		addConversion(CharacterToString.class);
		addConversion(CharacterToBigInteger.class);
		addConversion(CharacterToBigDecimal.class);

		// other conversions, Java -> Java
		addConversion(BooleanToString.class);
		addConversion(DateToString.class);
		addConversion(CalendarToString.class);
		addConversion(ObjectToString.class);
		addConversion(MapToString.class);
		addConversion(ObjectToMap.class);
		addConversion(EnumToString.class);

		// identity conversions, Java -> Java
		addConversion(StringToString.class);
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

		// numeric conversions, Integrity -> Java
		addConversion(DecimalValueToBigDecimal.class);
		addConversion(DecimalValueToDouble.class);
		addConversion(DecimalValueToFloat.class);
		addConversion(DecimalValueToString.class);
		addConversion(IntegerValueToBigDecimal.class);
		addConversion(IntegerValueToBigInteger.class);
		addConversion(IntegerValueToByte.class);
		addConversion(IntegerValueToDouble.class);
		addConversion(IntegerValueToFloat.class);
		addConversion(IntegerValueToInteger.class);
		addConversion(IntegerValueToLong.class);
		addConversion(IntegerValueToShort.class);
		addConversion(IntegerValueToString.class);
		addConversion(IntegerValueToCharacter.class);

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
		addConversion(StringValueToCharacter.class);

		// boolean conversions, Integrity -> Java
		addConversion(BooleanValueToBoolean.class);
		addConversion(BooleanValueToString.class);

		// date/time conversions, Integrity -> Java
		addConversion(DateAndTimeValueToCalendar.class);
		addConversion(DateAndTimeValueToDate.class);
		addConversion(DateAndTimeValueToString.class);
		addConversion(DateValueToCalendar.class);
		addConversion(DateValueToDate.class);
		addConversion(DateValueToString.class);
		addConversion(TimeValueToCalendar.class);
		addConversion(TimeValueToDate.class);
		addConversion(TimeValueToString.class);

		// nested objects, Integrity -> Java
		addConversion(NestedObjectToMap.class);
		addConversion(NestedObjectToString.class);
		addConversion(NestedObjectToBean.class);

		// other conversions, Integrity -> Java
		addConversion(NullValueToNull.class);
		addConversion(EnumValueToEnumConstant.class);
		addConversion(EnumValueToString.class);
	}

}
