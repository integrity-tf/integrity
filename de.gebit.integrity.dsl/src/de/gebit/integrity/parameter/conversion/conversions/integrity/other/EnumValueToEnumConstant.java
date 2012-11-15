/**
 * A default Integrity conversion. 
 */
package de.gebit.integrity.parameter.conversion.conversions.integrity.other;

import de.gebit.integrity.dsl.EnumValue;
import de.gebit.integrity.parameter.conversion.ConversionFailedException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.parameter.conversion.UntargetedConversion;

/**
 * A default Integrity conversion.
 * 
 * @author Rene Schneider
 * 
 */
public class EnumValueToEnumConstant implements UntargetedConversion<EnumValue> {

	@Override
	public Object convert(EnumValue aSource, Class<?> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) {
		if (Enum.class.isAssignableFrom(aTargetType)) {
			for (Object tempConstant : aTargetType.getEnumConstants()) {
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
