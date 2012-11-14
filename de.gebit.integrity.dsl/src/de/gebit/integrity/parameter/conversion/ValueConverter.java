/**
 * 
 */
package de.gebit.integrity.parameter.conversion;

import java.util.Map;

import de.gebit.integrity.dsl.ValueOrEnumValueOrOperation;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.operations.OperationWrapper.UnexecutableException;
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;

/**
 * The value converter is responsible for conversion of values during test execution and/or inside the Eclipse
 * integration.
 * 
 * @author Rene Schneider
 * 
 */
public interface ValueConverter {

	/**
	 * Convert a given single Integrity or Java type value to a given target type (which is always a Java type).
	 * 
	 * @param aTargetClass
	 *            the target type
	 * @param aValue
	 *            the value
	 * @return the converted object
	 */
	Object convertValueToParamType(Class<?> aTargetClass, Object aValue);

	/**
	 * Converts a given {@link ValueOrEnumValueOrOperation} to a given Java type class, if possible.
	 * 
	 * @param aTargetClass
	 *            the target type
	 * @param aValue
	 *            the value
	 * @param aVariableMap
	 *            the variable map, if variable references shall be resolved. If this is null, unresolved variable
	 *            references given as values will provoke an exception!
	 * @return the converted value
	 * @throws UnresolvableVariableException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws UnexecutableException
	 */
	Object convertEncapsulatedValueToParamType(Class<?> aTargetClass, ValueOrEnumValueOrOperation aValue,
			Map<VariableEntity, Object> aVariableMap, ClassLoader aClassLoader) throws UnresolvableVariableException,
			ClassNotFoundException, UnexecutableException, InstantiationException;

	/**
	 * Converts a given value collection to a given Java type class, if possible. Will return an array if the collection
	 * contains more than one item.
	 * 
	 * @param aTargetClass
	 *            the target type
	 * @param aCollection
	 *            the value collection
	 * @param aVariableMap
	 *            the variable map, if variable references shall be resolved. If this is null, unresolved variable
	 *            references given as values will provoke an exception!
	 * @param aClassLoader
	 *            the a class loader
	 * @return the converted value
	 * @throws ClassNotFoundException
	 * @throws UnexecutableException
	 * @throws InstantiationException
	 */
	Object convertEncapsulatedValueCollectionToParamType(Class<?> aTargetClass,
			ValueOrEnumValueOrOperationCollection aCollection, Map<VariableEntity, Object> aVariableMap,
			ClassLoader aClassLoader) throws ClassNotFoundException, UnexecutableException, InstantiationException;

	/**
	 * Converts a given value to a String. This method is intended to be used for the output of values (for example in
	 * test results, on the console etc).
	 * 
	 * @param aValue
	 *            the value (can be an {@link ValueOrEnumValueOrOperationCollection} or a plain Java Object)
	 * @param aVariableMap
	 *            the variable map, if variable references as values shall be resolved. If this is null, unresolved
	 *            variable references will always return either the string "(null)" or a null value, depending on the
	 *            following flag
	 * @param aClassLoader
	 *            the classloader to use in order to resolve operations. If not given, operations will be "resolved" to
	 *            the string "UNSUPPORTED".
	 * @param anAllowNullResultFlag
	 *            whether a null value shall be returned in case of unresolvable variable references or operations - if
	 *            this is not set, the method will not return null, but the String "null" instead!
	 * @return the string
	 */
	String convertValueToString(Object aValue, Map<VariableEntity, Object> aVariableMap, ClassLoader aClassLoader,
			boolean anAllowNullResultFlag);

}
