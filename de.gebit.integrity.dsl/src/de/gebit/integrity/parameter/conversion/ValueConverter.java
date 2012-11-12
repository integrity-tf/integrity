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
	 * Convert a given single Java type value to param type (which is also a Java type).
	 * 
	 * @param aTargetClass
	 *            the param type
	 * @param aValue
	 *            the value
	 * @return the object
	 */
	Object convertValueToParamType(Class<?> aTargetClass, Object aValue);

	/**
	 * Converts a given parameter value to a given Java type class, if possible.
	 * 
	 * @param aParamType
	 *            the target type
	 * @param aValue
	 *            the value
	 * @param aVariableMap
	 *            the variable map, if variable references shall be resolved. If this is null, unresolved variable
	 *            references given as values will provoke an exception!
	 * @return the converted value
	 * @throws UnresolvableVariableException
	 *             the unresolvable variable exception
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws UnexecutableException
	 */
	Object convertEncapsulatedValueToParamType(Class<?> aParamType, ValueOrEnumValueOrOperation aValue,
			Map<VariableEntity, Object> aVariableMap, ClassLoader aClassLoader) throws UnresolvableVariableException,
			ClassNotFoundException, UnexecutableException, InstantiationException;

	/**
	 * Converts a given value to a String.
	 * 
	 * @param aValue
	 *            the value (can be an {@link OperationOrValueCollection} or a plain Java Object)
	 * @param aVariableMap
	 *            the variable map, if variable references as values shall be resolved. If this is null, unresolved
	 *            variable references will always return either the string "(null)" or a null value, depending on the
	 *            following flag
	 * @param aClassLoader
	 *            the classloader to use in order to resolve operations. If not given, operations will be "resolved" to
	 *            the string "UNSUPPORTED".
	 * @param anAllowNullResultFlag
	 *            whether a null value shall be returned in case of unresolvable variable references or operations
	 * @return the string
	 */
	String convertValueToString(Object aValue, Map<VariableEntity, Object> aVariableMap, ClassLoader aClassLoader,
			boolean anAllowNullResultFlag);

	/**
	 * Converts a given value collection to a given Java type class, if possible. Will return an array if the collection
	 * contains more than one item. This method is only being called inside Eclipse!
	 * 
	 * @param aParamType
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
	 *             the class not found exception
	 * @throws UnexecutableException
	 *             the unexecutable exception
	 * @throws InstantiationException
	 *             the instantiation exception
	 */
	Object convertEncapsulatedValueCollectionToParamType(Class<?> aParamType,
			ValueOrEnumValueOrOperationCollection aCollection, Map<VariableEntity, Object> aVariableMap,
			ClassLoader aClassLoader) throws ClassNotFoundException, UnexecutableException, InstantiationException;

}
