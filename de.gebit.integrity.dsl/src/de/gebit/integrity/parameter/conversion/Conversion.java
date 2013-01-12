/**
 * 
 */
package de.gebit.integrity.parameter.conversion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Set;

import com.google.inject.Inject;

import de.gebit.integrity.operations.CustomOperationWrapper.UnexecutableException;
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;

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
public abstract class Conversion<FROM extends Object, TO extends Object> {

	/**
	 * The value converter used for recursive conversion.
	 */
	@Inject
	private ValueConverter valueConverter;

	/**
	 * This set is used for automatic endless loop protection.
	 */
	private Set<Object> visitedObjects;

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
	public abstract TO convert(FROM aSource, Class<? extends TO> aTargetType,
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

	public void setVisitedObjects(Set<Object> someVisitedObjects) {
		visitedObjects = someVisitedObjects;
	}

	/**
	 * Recursively converts the given value to the defined target type. This method provides implicit protection against
	 * endless recursion loops.
	 * 
	 * @param aTargetType
	 *            the target type
	 * @param aParameterizedType
	 *            the parameterized type in case of generics
	 * @param aValue
	 *            the value to convert
	 * @param anUnresolvableVariableHandlingPolicy
	 *            what to do with unresolvable variables
	 * @return the converted value
	 * @throws UnresolvableVariableException
	 * @throws ClassNotFoundException
	 * @throws UnexecutableException
	 * @throws InstantiationException
	 */
	protected Object convertValueRecursive(Class<?> aTargetType, Class<?> aParameterizedType, Object aValue,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws UnresolvableVariableException,
			ClassNotFoundException, UnexecutableException, InstantiationException {
		if ((valueConverter instanceof AbstractModularValueConverter) && visitedObjects != null) {
			return ((AbstractModularValueConverter) valueConverter).convertValue(aTargetType, aParameterizedType,
					aValue, anUnresolvableVariableHandlingPolicy, visitedObjects);
		} else {
			return valueConverter.convertValue(aTargetType, aParameterizedType, aValue,
					anUnresolvableVariableHandlingPolicy);
		}
	}

	/**
	 * Recursively converts the given value to a string array. This method provides implicit protection against endless
	 * recursion loops.
	 * 
	 * @param aValue
	 *            the value to convert
	 * @param anUnresolvableVariableHandlingPolicy
	 *            how to deal with unresolvable variables
	 * @return the converted string array
	 */
	protected String[] convertValueToStringArrayRecursive(Object aValue,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) {
		if ((valueConverter instanceof AbstractModularValueConverter) && visitedObjects != null) {
			return ((AbstractModularValueConverter) valueConverter).convertValueToStringArray(aValue,
					anUnresolvableVariableHandlingPolicy, visitedObjects);
		} else {
			return valueConverter.convertValueToStringArray(aValue, anUnresolvableVariableHandlingPolicy);
		}
	}

}
