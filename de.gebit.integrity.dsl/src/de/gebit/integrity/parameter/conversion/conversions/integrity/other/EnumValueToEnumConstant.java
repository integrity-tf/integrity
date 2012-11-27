/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.other;

import de.gebit.integrity.dsl.EnumValue;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.Conversion;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider
 * 
 */
@SuppressWarnings("rawtypes")
public class EnumValueToEnumConstant extends Conversion<EnumValue, Enum> {

	@Override
	public Enum convert(EnumValue aSource, Class<? extends Enum> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) {
		if (Enum.class.isAssignableFrom(aTargetType)) {
			for (Enum tempConstant : aTargetType.getEnumConstants()) {
				if (tempConstant.toString().equals(aSource.getEnumValue().getSimpleName())) {
					return tempConstant;
				}
			}
			throw new ConversionFailedException(EnumValue.class, aTargetType, "Constant value '"
					+ aSource.getEnumValue().getSimpleName() + "' not found in enum class '" + aTargetType.getName()
					+ "'");
		}
		throw new ConversionFailedException(EnumValue.class, aTargetType, "Class '" + aTargetType.getName()
				+ "' is not an enum");
	}

}
