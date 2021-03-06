/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.resolving;

import java.util.List;
import java.util.Map;

import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.ConstantDefinition;
import de.gebit.integrity.dsl.Parameter;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperation;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.dsl.VariableOrConstantEntity;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;

/**
 * The parameter resolver is responsible for the creation of a map of parameters for fixture executions. It does NOT
 * convert any values, which is the duty of the {@link de.gebit.integrity.parameter.conversion.ValueConverter}.
 * 
 * @author Rene Schneider - initial API and implementation
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
	 * @param anIncludeArbitraryParametersFlag
	 *            whether arbitrary parameters should be determined and included as well
	 * @param anUnresolvableVariableHandlingPolicy
	 *            Defines the policy how unresolvable variable references (no variable given or no
	 *            {@link de.gebit.integrity.parameter.variables.VariableManager} available) shall be treated
	 * @return a map with a String to value mapping
	 * @throws InstantiationException
	 * @throws UnexecutableException
	 * @throws ClassNotFoundException
	 */
	Map<String, Object> createParameterMap(Test aTest, boolean anIncludeArbitraryParametersFlag,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy)
			throws ClassNotFoundException, UnexecutableException, InstantiationException;

	/**
	 * Returns a map mapping a parameter name to a value, exploring a given {@link Call} to determine the valid
	 * parameters. Parameters that contain references to variables will be resolved if the variable map is provided, but
	 * no type conversions will be done.
	 * 
	 * @param aCall
	 *            the call
	 * @param anIncludeArbitraryParametersFlag
	 *            whether arbitrary parameters should be determined and included as well
	 * @param anUnresolvableVariableHandlingPolicy
	 *            Defines the policy how unresolvable variable references (no variable given or no
	 *            {@link de.gebit.integrity.parameter.variables.VariableManager} available) shall be treated
	 * @return a map with a String to value mapping
	 * @throws InstantiationException
	 * @throws UnexecutableException
	 * @throws ClassNotFoundException
	 */
	Map<String, Object> createParameterMap(Call aCall, boolean anIncludeArbitraryParametersFlag,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy)
			throws ClassNotFoundException, UnexecutableException, InstantiationException;

	/**
	 * Returns a map mapping a parameter name to a value, exploring a given row of a {@link TableTest} to determine the
	 * valid parameters. Parameters that contain operations and/or references to variables will be resolved if the
	 * variable map is provided, but no type conversions will be done.
	 * 
	 * @param aTableTest
	 *            the table test
	 * @param aTableTestRow
	 *            the row of the test
	 * @param aResolveMethod
	 *            specifies the kind of params to be resolved (null = {@link TableTestParameterResolveMethod#COMBINED})
	 * @param anIncludeArbitraryParametersFlag
	 *            whether arbitrary parameters should be determined and included as well
	 * @param anUnresolvableVariableHandlingPolicy
	 *            Defines the policy how unresolvable variable references (no variable given or no
	 *            {@link de.gebit.integrity.parameter.variables.VariableManager} available) shall be treated
	 * @return a map with a String to value mapping
	 * @throws InstantiationException
	 * @throws UnexecutableException
	 * @throws ClassNotFoundException
	 */
	Map<String, Object> createParameterMap(TableTest aTableTest, TableTestRow aTableTestRow,
			TableTestParameterResolveMethod aResolveMethod, boolean anIncludeArbitraryParametersFlag,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy)
			throws ClassNotFoundException, UnexecutableException, InstantiationException;

	/**
	 * Returns a map mapping a parameter name to a value, using a list of {@link Parameter} instances to determine the
	 * valid parameters. Parameters that contain operations or references to variables will be resolved if the variable
	 * map is provided, but no type conversions will be done.
	 * 
	 * @param someParameters
	 *            the parameters
	 * @param anIncludeArbitraryParametersFlag
	 *            whether arbitrary parameters should be determined and included as well
	 * @param anUnresolvableVariableHandlingPolicy
	 *            Defines the policy how unresolvable variable references (no variable given or no
	 *            {@link de.gebit.integrity.parameter.variables.VariableManager} available) shall be treated
	 * @return a map with a String to value mapping
	 * @throws InstantiationException
	 * @throws UnexecutableException
	 * @throws ClassNotFoundException
	 */
	Map<String, Object> createParameterMap(List<Parameter> someParameters, boolean anIncludeArbitraryParametersFlag,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy)
			throws ClassNotFoundException, UnexecutableException, InstantiationException;

	/**
	 * Resolves the given {@link ValueOrEnumValueOrOperationCollection}, using the variable map given. Resolving only
	 * attempts to execute any operations and replace variable references with the current variable value, but does NOT
	 * convert the values to any other target type.
	 * 
	 * @param aValueCollection
	 *            the value collection to resolve
	 * @param anUnresolvableVariableHandlingPolicy
	 *            Defines the policy how unresolvable variable references (no variable given or no
	 *            {@link de.gebit.integrity.parameter.variables.VariableManager} available) shall be treated
	 * @return the resolved value
	 * @throws UnexecutableException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	Object resolveParameterValue(ValueOrEnumValueOrOperationCollection aValueCollection,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy)
			throws UnexecutableException, InstantiationException, ClassNotFoundException;

	/**
	 * Resolves the given {@link ValueOrEnumValueOrOperation}, using the variable map given. Resolving only attempts to
	 * execute any operations and replace variable references with the current variable value, but does NOT convert the
	 * values to any other target type.
	 * 
	 * @param aValue
	 *            the value to resolve
	 * @param anUnresolvableVariableHandlingPolicy
	 *            Defines the policy how unresolvable variable references (no variable given or no
	 *            {@link de.gebit.integrity.parameter.variables.VariableManager} available) shall be treated
	 * @return the resolved value
	 * @throws UnexecutableException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	Object resolveSingleParameterValue(ValueOrEnumValueOrOperation aValue,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy)
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
	Object resolveStatically(Variable aVariable, VariantDefinition aVariant)
			throws ClassNotFoundException, InstantiationException, UnexecutableException;

	/**
	 * Resolves a variable (recursively, if necessary) to its actual value. Since this static method doesn't have access
	 * to the actual variable store of a test runner instance, the resolving can only be successful in cases of
	 * variables with initial value (giving that value) or constants.
	 * 
	 * @param anEntity
	 *            the entity to resolve
	 * @param aVariant
	 *            the active variant
	 * @return the result, or null if none was found
	 */
	Object resolveStatically(VariableOrConstantEntity anEntity, VariantDefinition aVariant)
			throws ClassNotFoundException, InstantiationException, UnexecutableException;

	/**
	 * Resolves a {@link ValueOrEnumValueOrOperation} to its actual value statically, that is, not requiring a current
	 * test execution context.
	 * 
	 * @param anEntity
	 *            the entity to resolve
	 * @param aVariant
	 *            the variant in use
	 * @return the result value
	 * @throws UnexecutableException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 */
	Object resolveStatically(ValueOrEnumValueOrOperation anEntity, VariantDefinition aVariant)
			throws UnexecutableException, ClassNotFoundException, InstantiationException;

	/**
	 * Resolves a {@link ValueOrEnumValueOrOperationCollection} to its actual value statically, that is, not requiring a
	 * current test execution context.
	 * 
	 * @param anEntity
	 *            the entity to resolve
	 * @param aVariant
	 *            the variant in use
	 * @return the result value
	 * @throws UnexecutableException
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 */
	Object resolveStatically(ValueOrEnumValueOrOperationCollection anEntity, VariantDefinition aVariant)
			throws UnexecutableException, ClassNotFoundException, InstantiationException;

	/**
	 * Determines whether the given {@link ValueOrEnumValueOrOperationCollection} is safely resolvable to a value in a
	 * static way, that is, not requiring a current execution context. "Safely" means that the resolved value is
	 * guaranteed not to change during runtime.
	 * 
	 * @param aValue
	 *            the value to test
	 * @param aVariant
	 *            the variant to assume
	 * @return true if the value is safely resolvable, false otherwise
	 */
	boolean isSafelyStaticallyResolvable(ValueOrEnumValueOrOperationCollection aValue, VariantDefinition aVariant);

	/**
	 * Determines whether the given {@link ValueOrEnumValueOrOperation} is safely resolvable to a value in a static way,
	 * that is, not requiring a current execution context. "Safely" means that the resolved value is guaranteed not to
	 * change during runtime.
	 * 
	 * @param aValue
	 *            the value to test
	 * @param aVariant
	 *            the variant to assume
	 * @return true if the value is safely resolvable, false otherwise
	 */
	boolean isSafelyStaticallyResolvable(ValueOrEnumValueOrOperation aValue, VariantDefinition aVariant);

	/**
	 * Resolves a constant definition to its defined value, which may depend on the active variant.
	 * 
	 * @param aConstant
	 *            the constant to resolve
	 * @param aVariant
	 *            the active variant
	 * @return the result, or null if none is defined for the constant
	 */
	Object resolveStatically(ConstantDefinition aConstant, VariantDefinition aVariant)
			throws UnexecutableException, ClassNotFoundException, InstantiationException;

	/**
	 * Returns a map of named results as expected by the given {@link Test}. The Map will connect result names to actual
	 * values. Does not support variable resolving!
	 * 
	 * @param aTest
	 *            the test
	 * @param anIncludeArbitraryResultFlag
	 *            whether arbitrary results shall be included
	 * @return a map of Strings to values
	 */
	Map<String, Object> createExpectedResultMap(Test aTest, boolean anIncludeArbitraryResultFlag);

}
