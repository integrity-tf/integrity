/**
 * 
 */
package de.gebit.integrity.parameter.conversion;

/**
 * A {@link TargetedConversion} defines a transformation from one type into another.
 * 
 * @param <FROM>
 *            the source type
 * @param <TO>
 *            the target type
 * @author Rene Schneider
 * 
 */
public interface TargetedConversion<FROM extends Object, TO extends Object> extends Conversion {

	/**
	 * Performs the conversion.
	 * 
	 * @param aSource
	 *            the source object to convert
	 * @param anUnresolvableVariableHandlingPolicy
	 *            Defines the policy how unresolvable variable references (no variable given or no
	 *            {@link de.gebit.integrity.parameter.variables.VariableManager} available) shall be treated
	 * @return the converted object
	 * @throws ConversionFailedException
	 *             in case of conversion errors
	 */
	TO convert(FROM aSource, UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy)
			throws ConversionFailedException;

	/**
	 * The priority returned by this method is used to determine the default conversion if an object is given, but no
	 * target type is defined. Highest priority wins!
	 * 
	 * @return the priority number
	 */
	int getPriority();

}
