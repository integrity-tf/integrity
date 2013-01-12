/**
 * 
 */
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
import de.gebit.integrity.dsl.NamedResult;
import de.gebit.integrity.dsl.Parameter;
import de.gebit.integrity.dsl.ParameterName;
import de.gebit.integrity.dsl.ParameterTableHeader;
import de.gebit.integrity.dsl.StaticValue;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.Value;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperation;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.dsl.VariableDefinition;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.dsl.VariantDefinition;
import de.gebit.integrity.dsl.VariantValue;
import de.gebit.integrity.operations.CustomOperationWrapper;
import de.gebit.integrity.operations.CustomOperationWrapper.UnexecutableException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.parameter.variables.VariableManager;
import de.gebit.integrity.utils.IntegrityDSLUtil;
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;
import de.gebit.integrity.wrapper.WrapperFactory;

/**
 * The default implementation of a parameter resolver.
 * 
 * @author Rene Schneider
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
		} else if (aValue instanceof CustomOperation) {
			if (wrapperFactory != null) {
				CustomOperationWrapper tempWrapper = wrapperFactory.newCustomOperationWrapper((CustomOperation) aValue);
				return tempWrapper.executeOperation();
			} else {
				return null;
			}
			// TODO what about nested objects with inner operations or variables?
		}

		return aValue;
	}

	@Override
	public Object resolveVariableStatically(Variable aVariable, VariantDefinition aVariant) {
		Value tempValue = null;

		if (aVariable.getName() != null) {
			if (aVariable.getName().eContainer() instanceof VariableDefinition) {
				VariableDefinition tempDefinition = (VariableDefinition) aVariable.getName().eContainer();
				tempValue = tempDefinition.getInitialValue();
			} else if (aVariable.getName().eContainer() instanceof ConstantDefinition) {
				ConstantDefinition tempDefinition = (ConstantDefinition) aVariable.getName().eContainer();
				tempValue = resolveConstantValue(tempDefinition, aVariant);
			}
		}

		if (tempValue != null && tempValue instanceof Variable) {
			return resolveVariableStatically(aVariable, aVariant);
		} else {
			return tempValue;
		}
	}

	@Override
	public StaticValue resolveConstantValue(ConstantDefinition aConstant, VariantDefinition aVariant) {
		StaticValue tempValue = aConstant.getValue();
		if (aVariant != null) {
			outer: for (VariantValue tempVariantValue : aConstant.getVariantValues()) {
				for (VariantDefinition tempDefinition : tempVariantValue.getNames()) {
					if (tempDefinition == aVariant) {
						tempValue = tempVariantValue.getValue();
						break outer;
					}
				}
			}
		}
		return tempValue;
	}

	@Override
	public Map<String, Object> createExpectedResultMap(Test aTest, Map<VariableEntity, Object> aVariableMap,
			boolean anIncludeArbitraryResultFlag) {
		return createExpectedResultMap(aTest.getResults(), aVariableMap, anIncludeArbitraryResultFlag);
	}

	private Map<String, Object> createExpectedResultMap(List<NamedResult> aTestResultList,
			Map<VariableEntity, Object> aVariableMap, boolean anIncludeArbitraryResultFlag) {
		Map<String, Object> tempResultMap = new LinkedHashMap<String, Object>();
		for (NamedResult tempEntry : aTestResultList) {
			if (tempEntry.getName() != null && tempEntry.getValue() != null) {
				Object tempValue = tempEntry.getValue();
				if (tempValue instanceof Variable) {
					if (aVariableMap != null) {
						tempValue = aVariableMap.get(((Variable) tempValue).getName());
					} else {
						tempValue = null;
					}
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
