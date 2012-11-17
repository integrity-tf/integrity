/**
 * 
 */
package de.gebit.integrity.parameter.conversion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * A {@link Conversion} defines a transformation from one type into another.
 * 
 * @param <FROM>
 *            the source type
 * @param <TO>
 *            the target type
 * @author Rene Schneider
 * 
 */
public interface Conversion<FROM extends Object, TO extends Object> {

	/**
	 * Performs the conversion.
	 * 
	 * @param aSource
	 *            the source object to convert
	 * @param aTargetType
	 *            TODO
	 * @param anUnresolvableVariableHandlingPolicy
	 *            Defines the policy how unresolvable variable references (no variable given or no
	 *            {@link de.gebit.integrity.parameter.variables.VariableManager} available) shall be treated
	 * @return the converted object
	 * @throws ConversionFailedException
	 *             in case of conversion errors
	 */
	TO convert(FROM aSource, Class<? extends TO> aTargetType,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ConversionFailedException;

	/**
	 * Add this annotation to a {@link Conversion} implementation to set the priority of this conversion. Priorities are
	 * used to determine the default conversion which is used if no target conversion is given and thus multiple
	 * conversions may be used. Highest priority wins. If none is given {@link Integer#MIN_VALUE} is assumed.
	 * 
	 * 
	 * @author Rene Schneider
	 * 
	 */
	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	public @interface Priority {

		/**
		 * The priority. Higher is more.
		 */
		int value() default Integer.MIN_VALUE;

	}

}
