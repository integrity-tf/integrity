/**
 * 
 */
package de.gebit.integrity.parameter.resolving;

import java.util.List;
import java.util.Map;

import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.ConstantDefinition;
import de.gebit.integrity.dsl.Parameter;
import de.gebit.integrity.dsl.StaticValue;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperation;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.operations.OperationWrapper.UnexecutableException;
import de.gebit.integrity.parameter.conversion.ValueConverter;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public interface ParameterResolver {

	/**
	 * Returns a map mapping a parameter name to a value, exploring a given {@link Test} to determine the valid
	 * parameters. Parameters that contain references to variables will be resolved if the variable map is provided, but
	 * no type conversions will be done.
	 * 
	 * @param aTest
	 *            the test
	 * @param aVariableMap
	 *            the variable map containing the current value of various variables, or null if no variable resolution
	 *            shall be done
	 * @param aClassLoader
	 *            the classloader to use for instantiation of operations, or null if operations shall not be executed
	 *            (will result in null values automatically)
	 * @param anIncludeArbitraryParametersFlag
	 *            whether arbitrary parameters should be determined and included as well
	 * @param aLeaveUnresolvableVariableReferencesIntact
	 *            whether non-resolvable variable references should be left in the list (otherwise they're replaced with
	 *            null)
	 * @return a map with a String to value mapping
	 * @throws InstantiationException
	 * @throws UnexecutableException
	 * @throws ClassNotFoundException
	 */
	Map<String, Object> createParameterMap(Test aTest, Map<VariableEntity, Object> aVariableMap,
			ClassLoader aClassLoader, ValueConverter aConverter, boolean anIncludeArbitraryParametersFlag,
			boolean aLeaveUnresolvableVariableReferencesIntact) throws ClassNotFoundException, UnexecutableException,
			InstantiationException;

	/**
	 * Returns a map mapping a parameter name to a value, exploring a given {@link Call} to determine the valid
	 * parameters. Parameters that contain references to variables will be resolved if the variable map is provided, but
	 * no type conversions will be done.
	 * 
	 * @param aCall
	 *            the call
	 * @param aVariableMap
	 *            the variable map containing the current value of various variables, or null if no variable resolution
	 *            shall be done
	 * @param aClassLoader
	 *            the classloader to use for instantiation of operations, or null if operations shall not be executed
	 *            (will result in null values automatically)
	 * @param anIncludeArbitraryParametersFlag
	 *            whether arbitrary parameters should be determined and included as well
	 * @param aLeaveUnresolvableVariableReferencesIntact
	 *            whether non-resolvable variable references should be left in the list (otherwise they're replaced with
	 *            null)
	 * @return a map with a String to value mapping
	 * @throws InstantiationException
	 * @throws UnexecutableException
	 * @throws ClassNotFoundException
	 */
	Map<String, Object> createParameterMap(Call aCall, Map<VariableEntity, Object> aVariableMap,
			ClassLoader aClassLoader, ValueConverter aConverter, boolean anIncludeArbitraryParametersFlag,
			boolean aLeaveUnresolvableVariableReferencesIntact) throws ClassNotFoundException, UnexecutableException,
			InstantiationException;

	/**
	 * Returns a map mapping a parameter name to a value, exploring a given row of a {@link TableTest} to determine the
	 * valid parameters. Parameters that contain operations and/or references to variables will be resolved if the
	 * variable map is provided, but no type conversions will be done.
	 * 
	 * @param aTableTest
	 *            the table test
	 * @param aTableTestRow
	 *            the row of the test
	 * @param aVariableMap
	 *            the variable map containing the current value of various variables, or null if no variable resolution
	 *            shall be done
	 * @param aClassLoader
	 *            the classloader to use for instantiation of operations, or null if operations shall not be executed
	 *            (will result in null values automatically)
	 * @param anIncludeArbitraryParametersFlag
	 *            whether arbitrary parameters should be determined and included as well
	 * @param aLeaveUnresolvableVariableReferencesIntact
	 *            whether non-resolvable variable references should be left in the list (otherwise they're replaced with
	 *            null)
	 * @return a map with a String to value mapping
	 * @throws InstantiationException
	 * @throws UnexecutableException
	 * @throws ClassNotFoundException
	 */
	Map<String, Object> createParameterMap(TableTest aTableTest, TableTestRow aTableTestRow,
			Map<VariableEntity, Object> aVariableMap, ClassLoader aClassLoader, ValueConverter aConverter,
			boolean anIncludeArbitraryParametersFlag, boolean aLeaveUnresolvableVariableReferencesIntact)
			throws ClassNotFoundException, UnexecutableException, InstantiationException;

	/**
	 * Returns a map mapping a parameter name to a value, using a list of {@link Parameter} instances to determine the
	 * valid parameters. Parameters that contain operations or references to variables will be resolved if the variable
	 * map is provided, but no type conversions will be done.
	 * 
	 * @param someParameters
	 *            the parameters
	 * @param aVariableMap
	 *            the variable map containing the current value of various variables, or null if no variable resolution
	 *            shall be done
	 * @param aClassLoader
	 *            the classloader to use for instantiation of operations, or null if operations shall not be executed
	 *            (will result in null values automatically)
	 * @param anIncludeArbitraryParametersFlag
	 *            whether arbitrary parameters should be determined and included as well
	 * @param aLeaveUnresolvableVariableReferencesIntact
	 *            whether non-resolvable variable references should be left in the list (otherwise they're replaced with
	 *            null)
	 * @return a map with a String to value mapping
	 * @throws InstantiationException
	 * @throws UnexecutableException
	 * @throws ClassNotFoundException
	 */
	Map<String, Object> createParameterMap(List<Parameter> someParameters, Map<VariableEntity, Object> aVariableMap,
			ClassLoader aClassLoader, ValueConverter aConverter, boolean anIncludeArbitraryParametersFlag,
			boolean aLeaveUnresolvableVariableReferencesIntact) throws ClassNotFoundException, UnexecutableException,
			InstantiationException;

	/**
	 * Resolves the given {@link ValueOrEnumValueOrOperationCollection}, using the variable map given. Resolving only
	 * attempts to execute any operations and replace variable references with the current variable value, but does NOT
	 * convert the values to any other target type.
	 * 
	 * @param aValueCollection
	 *            the value collection to resolve
	 * @param aVariableMap
	 *            the variable map used to resolve variables (optional)
	 * @param aClassLoader
	 *            the classloader to use for loading of operation classes (optional)
	 * @param aLeaveUnresolvableVariableReferencesIntact
	 *            whether unresolvable variable references shall be left as they are. otherwise they resolve to null.
	 * @return the resolved value
	 * @throws UnexecutableException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	Object resolveParameterValue(ValueOrEnumValueOrOperationCollection aValueCollection,
			Map<VariableEntity, Object> aVariableMap, ClassLoader aClassLoader, ValueConverter aConverter,
			boolean aLeaveUnresolvableVariableReferencesIntact) throws UnexecutableException, InstantiationException,
			ClassNotFoundException;

	/**
	 * Resolves the given {@link ValueOrEnumValueOrOperation}, using the variable map given. Resolving only attempts to
	 * execute any operations and replace variable references with the current variable value, but does NOT convert the
	 * values to any other target type.
	 * 
	 * @param aValue
	 *            the value to resolve
	 * @param aVariableMap
	 *            the variable map used to resolve variables (optional)
	 * @param aClassLoader
	 *            the classloader to use for loading of operation classes (optional)
	 * @param aLeaveUnresolvableVariableReferencesIntact
	 *            whether unresolvable variable references shall be left as they are. otherwise they resolve to null.
	 * @return the resolved value
	 * @throws UnexecutableException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	Object resolveSingleParameterValue(ValueOrEnumValueOrOperation aValue, Map<VariableEntity, Object> aVariableMap,
			ClassLoader aClassLoader, ValueConverter aConverter, boolean aLeaveUnresolvableVariableReferencesIntact)
			throws UnexecutableException, InstantiationException, ClassNotFoundException;

	/**
	 * Resolves a variable (recursively, if necessary) to its actual value. Since this static method doesn't have access
	 * to the actual variable store of a test runner instance, the resolving can only be successful in cases of
	 * variables with initial value (giving that value) or constants.
	 * 
	 * @param aVariable
	 *            the variable to resolve
	 * @param aVariant
	 *            the active variant
	 * @return the result, or null if none was found
	 */
	Object resolveVariableStatically(Variable aVariable, VariantDefinition aVariant);

	/**
	 * Resolves a constant definition to its defined value, which may depend on the active variant.
	 * 
	 * @param aConstant
	 *            the constant to resolve
	 * @param aVariant
	 *            the active variant
	 * @return the result, or null if none is defined for the constant
	 */
	StaticValue resolveConstantValue(ConstantDefinition aConstant, VariantDefinition aVariant);

}
