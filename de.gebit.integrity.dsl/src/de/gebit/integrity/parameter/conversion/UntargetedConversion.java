/**
 * 
 */
package de.gebit.integrity.parameter.conversion;

/**
 * A {@link UntargetedConversion} defines a transformation from one type into any unspecified other type. If one of
 * these is defined for a type, it is always used.
 * 
 * @param <FROM>
 * @author Rene Schneider
 * 
 */
public interface UntargetedConversion<FROM extends Object> extends Conversion {

	/**
	 * Performs the conversion.
	 * 
	 * @param aSource
	 *            the source object to convert
	 * @param aTargetType
	 *            the given target type for the conversion
	 * @param anUnresolvableVariableHandlingPolicy
	 *            Defines the policy how unresolvable variable references (no variable given or no
	 *            {@link de.gebit.integrity.parameter.variables.VariableManager} available) shall be treated
	 * @return the converted object
	 * @throws ConversionFailedException
	 *             in case of conversion errors
	 */
	Object convert(FROM aSource, Class<?> aTargetType, UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy)
			throws ConversionFailedException;

}
