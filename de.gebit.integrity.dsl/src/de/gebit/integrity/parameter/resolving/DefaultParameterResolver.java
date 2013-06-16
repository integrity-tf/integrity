/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.resolving;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import de.gebit.integrity.dsl.ArbitraryParameterOrResultName;
import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.ConstantDefinition;
import de.gebit.integrity.dsl.CustomOperation;
import de.gebit.integrity.dsl.EnumValue;
import de.gebit.integrity.dsl.KeyValuePair;
import de.gebit.integrity.dsl.NamedResult;
import de.gebit.integrity.dsl.NestedObject;
import de.gebit.integrity.dsl.Parameter;
import de.gebit.integrity.dsl.ParameterName;
import de.gebit.integrity.dsl.ParameterTableHeader;
import de.gebit.integrity.dsl.StandardOperation;
import de.gebit.integrity.dsl.StaticValue;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.TypedNestedObject;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperation;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.dsl.VariableDefinition;
import de.gebit.integrity.dsl.VariableOrConstantEntity;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.exceptions.ThisShouldNeverHappenException;
import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.operations.custom.CustomOperationWrapper;
import de.gebit.integrity.operations.standard.StandardOperationProcessor;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.parameter.variables.VariableManager;
import de.gebit.integrity.utils.IntegrityDSLUtil;
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;
import de.gebit.integrity.wrapper.WrapperFactory;

/**
 * The default implementation of a parameter resolver.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
@Singleton
public class DefaultParameterResolver implements ParameterResolver {

	/**
	 * The wrapper factory to use.
	 */
	@Inject(optional = true)
	protected WrapperFactory wrapperFactory;

	/**
	 * The variable manager to use.
	 */
	@Inject(optional = true)
	protected VariableManager variableManager;

	/**
	 * The processor for standard operations.
	 */
	@Inject
	protected StandardOperationProcessor standardOperationProcessor;

	@Override
	public Map<String, Object> createParameterMap(Test aTest, boolean anIncludeArbitraryParametersFlag,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ClassNotFoundException,
			UnexecutableException, InstantiationException {
		return createParameterMap(aTest.getParameters(), anIncludeArbitraryParametersFlag,
				anUnresolvableVariableHandlingPolicy);
	}

	@Override
	public Map<String, Object> createParameterMap(Call aCall, boolean anIncludeArbitraryParametersFlag,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws ClassNotFoundException,
			UnexecutableException, InstantiationException {
		return createParameterMap(aCall.getParameters(), anIncludeArbitraryParametersFlag,
				anUnresolvableVariableHandlingPolicy);
	}

	@Override
	public Map<String, Object> createParameterMap(TableTest aTableTest, TableTestRow aTableTestRow,
			boolean anIncludeArbitraryParametersFlag, UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy)
			throws ClassNotFoundException, UnexecutableException, InstantiationException {
		LinkedHashMap<ParameterName, ValueOrEnumValueOrOperationCollection> tempParameterMap = new LinkedHashMap<ParameterName, ValueOrEnumValueOrOperationCollection>();
		for (Parameter tempParameter : aTableTest.getParameters()) {
			tempParameterMap.put(tempParameter.getName(), tempParameter.getValue());
		}

		int tempCount = 0;
		for (ParameterTableHeader tempParameterHeader : aTableTest.getParameterHeaders()) {
			tempParameterMap.put(tempParameterHeader.getName(), (aTableTestRow == null || tempCount >= aTableTestRow
					.getValues().size()) ? null : aTableTestRow.getValues().get(tempCount).getValue());
			tempCount++;
		}

		return createParameterMap(tempParameterMap, anIncludeArbitraryParametersFlag,
				anUnresolvableVariableHandlingPolicy);
	}

	@Override
	public Map<String, Object> createParameterMap(List<Parameter> someParameters,
			boolean anIncludeArbitraryParametersFlag, UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy)
			throws ClassNotFoundException, UnexecutableException, InstantiationException {
		Map<ParameterName, ValueOrEnumValueOrOperationCollection> tempParameters = new LinkedHashMap<ParameterName, ValueOrEnumValueOrOperationCollection>();
		for (Parameter tempParameter : someParameters) {
			tempParameters.put(tempParameter.getName(), tempParameter.getValue());
		}

		return createParameterMap(tempParameters, anIncludeArbitraryParametersFlag,
				anUnresolvableVariableHandlingPolicy);
	}

	private Map<String, Object> createParameterMap(
			Map<ParameterName, ValueOrEnumValueOrOperationCollection> someParameters,
			boolean anIncludeArbitraryParametersFlag, UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy)
			throws ClassNotFoundException, UnexecutableException, InstantiationException {
		Map<String, Object> tempResult = new LinkedHashMap<String, Object>();
		for (Entry<ParameterName, ValueOrEnumValueOrOperationCollection> tempEntry : someParameters.entrySet()) {
			if (tempEntry.getKey() != null && tempEntry.getValue() != null) {
				Object tempValue = resolveParameterValue((ValueOrEnumValueOrOperationCollection) tempEntry.getValue(),
						anUnresolvableVariableHandlingPolicy);

				if (anIncludeArbitraryParametersFlag || !(tempEntry.getKey() instanceof ArbitraryParameterOrResultName)) {
					String tempKey = IntegrityDSLUtil.getParamNameStringFromParameterName(tempEntry.getKey());
					if (tempKey != null) {
						tempResult.put(tempKey, tempValue);
					}
				}
			}
		}

		return tempResult;
	}

	@Override
	public Object resolveParameterValue(ValueOrEnumValueOrOperationCollection aValueCollection,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws UnexecutableException,
			InstantiationException, ClassNotFoundException {
		if (aValueCollection.getMoreValues().size() > 0) {
			// if multiple values have been provided
			Object[] tempValueArray = new Object[aValueCollection.getMoreValues().size() + 1];
			tempValueArray[0] = aValueCollection.getValue();
			for (int i = 0; i <= aValueCollection.getMoreValues().size(); i++) {
				ValueOrEnumValueOrOperation tempSingleValue = (i == 0 ? aValueCollection.getValue() : aValueCollection
						.getMoreValues().get(i - 1));

				tempValueArray[i] = resolveSingleParameterValue(tempSingleValue, anUnresolvableVariableHandlingPolicy);
			}
			return tempValueArray;
		} else {
			// if only one value has been provided
			return resolveSingleParameterValue(aValueCollection.getValue(), anUnresolvableVariableHandlingPolicy);
		}
	}

	@Override
	public Object resolveSingleParameterValue(ValueOrEnumValueOrOperation aValue,
			UnresolvableVariableHandling anUnresolvableVariableHandlingPolicy) throws UnexecutableException,
			InstantiationException, ClassNotFoundException {
		if (aValue instanceof Variable) {
			Variable tempVariable = (Variable) aValue;
			Object tempResolvedValue = (variableManager != null ? variableManager.get(tempVariable.getName()) : null);
			if (tempResolvedValue != null) {
				return tempResolvedValue;
			} else {
				switch (anUnresolvableVariableHandlingPolicy) {
				case KEEP_UNRESOLVED:
					return tempVariable;
				case RESOLVE_TO_NULL_VALUE:
					return null;
				case RESOLVE_TO_NAME_STRING:
					return tempVariable.getName().getName();
				case RESOLVE_TO_NULL_STRING:
					return "null";
				case RESOLVE_TO_QUESTIONMARK_STRING:
					return "???";
				case EXCEPTION:
				default:
					throw new UnresolvableVariableException("Unresolvable variable " + tempVariable.getName().getName()
							+ " encountered!");
				}
			}
		} else if (aValue instanceof StandardOperation) {
			try {
				return standardOperationProcessor.executeOperation((StandardOperation) aValue);
			} catch (UnexecutableException exc) {
				// this is expected to happen in some cases during dry run - but not a problem
				return null;
			}
		} else if (aValue instanceof CustomOperation) {
			if (wrapperFactory != null) {
				CustomOperationWrapper tempWrapper = wrapperFactory.newCustomOperationWrapper((CustomOperation) aValue);
				return tempWrapper.executeOperation();
			} else {
				return null;
			}
		} else {
			// TODO what about nested objects with inner operations or variables?
		}

		return aValue;
	}

	@Override
	public Object resolveStatically(Variable aVariable, VariantDefinition aVariant) {
		VariableOrConstantEntity tempEntity = aVariable.getName();
		return IntegrityDSLUtil.getInitialValueForVariableOrConstantEntity(tempEntity, aVariant);
	}

	@Override
	public Object resolveStatically(ValueOrEnumValueOrOperation aValue, VariantDefinition aVariant)
			throws UnexecutableException, ClassNotFoundException, InstantiationException {
		if (aValue instanceof Variable) {
			VariableOrConstantEntity tempEntity = ((Variable) aValue).getName();
			return resolveStatically(IntegrityDSLUtil.getInitialValueForVariableOrConstantEntity(tempEntity, aVariant),
					aVariant);
		} else if (aValue instanceof StandardOperation) {
			return standardOperationProcessor.executeOperation((StandardOperation) aValue);
		} else if (aValue instanceof CustomOperation) {
			if (wrapperFactory != null) {
				CustomOperationWrapper tempWrapper = wrapperFactory.newCustomOperationWrapper((CustomOperation) aValue);
				return tempWrapper.executeOperation();
			} else {
				return null;
			}
		}

		return aValue;
	}

	@Override
	public boolean isSafelyStaticallyResolvable(ValueOrEnumValueOrOperationCollection aValue, VariantDefinition aVariant) {
		if (aValue == null) {
			return true;
		}

		if (!isSafelyStaticallyResolvable(aValue.getValue(), aVariant)) {
			return false;
		}
		for (ValueOrEnumValueOrOperation tempSubValue : aValue.getMoreValues()) {
			if (!isSafelyStaticallyResolvable(tempSubValue, aVariant)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean isSafelyStaticallyResolvable(ValueOrEnumValueOrOperation aValue, VariantDefinition aVariant) {
		if (aValue == null) {
			return true;
		}

		if (aValue instanceof StaticValue) {
			return true;
		} else if (aValue instanceof Variable) {
			VariableOrConstantEntity tempEntity = ((Variable) aValue).getName();
			if (tempEntity instanceof VariableDefinition) {
				// Variables can be altered during runtime -> definitely not statically resolvable to a constant value
				return false;
			} else if (tempEntity instanceof ConstantDefinition) {
				// trace the initial value and check whether that can be resolved
				return isSafelyStaticallyResolvable(
						IntegrityDSLUtil.getInitialValueForVariableOrConstantEntity(tempEntity, aVariant), aVariant);
			}
		} else if (aValue instanceof NestedObject) {
			// Explore the nested object and check all attributes. Might of course create recursion, but hey, recursion
			// is cool :-)
			for (KeyValuePair tempAttribute : ((NestedObject) aValue).getAttributes()) {
				if (!isSafelyStaticallyResolvable(tempAttribute.getValue(), aVariant)) {
					return false;
				}
			}
		} else if (aValue instanceof TypedNestedObject) {
			// The same as above, but for typed nested objects (we simply recurse into the inner nested object)
			return isSafelyStaticallyResolvable(((TypedNestedObject) aValue).getNestedObject(), aVariant);
		} else if (aValue instanceof EnumValue) {
			// Enum values only make sense in the context of a fixture call. This method does not require such a
			// context, thus it considers enum values to be nonresolvable.
			return false;
		} else if (aValue instanceof StandardOperation) {
			// All parameters of the operation must be statically resolvable, just like with nested objects.
			if (!isSafelyStaticallyResolvable(((StandardOperation) aValue).getFirstOperand(), aVariant)) {
				return false;
			}
			for (ValueOrEnumValueOrOperation tempSubValue : ((StandardOperation) aValue).getMoreOperands()) {
				if (!isSafelyStaticallyResolvable(tempSubValue, aVariant)) {
					return false;
				}
			}
			return true;
		} else if (aValue instanceof CustomOperation) {
			// Custom operations are considered to return the same values if the input parameters are kept constant,
			// thus we check those input parameters. Note however that we cannot make sure that the code of a given
			// custom operation actually obeys the rule of providing a stable mapping between input parameters and
			// output, thus this assumption is unfortunately not 100% safe.
			return isSafelyStaticallyResolvable(((CustomOperation) aValue).getPrefixOperand(), aVariant)
					&& isSafelyStaticallyResolvable(((CustomOperation) aValue).getPostfixOperand(), aVariant);
		}

		throw new ThisShouldNeverHappenException();
	}

	@Override
	public Object resolveStatically(ConstantDefinition aConstant, VariantDefinition aVariant)
			throws UnexecutableException, ClassNotFoundException, InstantiationException {
		ValueOrEnumValueOrOperation tempValue = IntegrityDSLUtil.getInitialValueForConstant(aConstant, aVariant);

		return resolveStatically(tempValue, aVariant);
	}

	@Override
	public Map<String, Object> createExpectedResultMap(Test aTest, boolean anIncludeArbitraryResultFlag) {
		return createExpectedResultMap(aTest.getResults(), anIncludeArbitraryResultFlag);
	}

	private Map<String, Object> createExpectedResultMap(List<NamedResult> aTestResultList,
			boolean anIncludeArbitraryResultFlag) {
		Map<String, Object> tempResultMap = new LinkedHashMap<String, Object>();
		for (NamedResult tempEntry : aTestResultList) {
			if (tempEntry.getName() != null && tempEntry.getValue() != null) {
				Object tempValue = tempEntry.getValue();
				if (tempValue instanceof Variable) {
					// Variable resolving is not supported here since this method is currently only used in
					// circumstances where this is impossible anyway (autocompletion in the IDE)
					tempValue = null;
				}
				if (anIncludeArbitraryResultFlag || !(tempEntry.getName() instanceof ArbitraryParameterOrResultName)) {
					tempResultMap.put(
							IntegrityDSLUtil.getExpectedResultNameStringFromTestResultName(tempEntry.getName()),
							tempEntry.getValue());
				}
			}
		}

		return tempResultMap;
	}

}
