/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.modelcheck;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.xtext.common.types.JvmType;

import com.google.inject.Inject;

import de.gebit.integrity.classloading.IntegrityClassLoader;
import de.gebit.integrity.dsl.Call;
import de.gebit.integrity.dsl.CustomOperation;
import de.gebit.integrity.dsl.EnumValue;
import de.gebit.integrity.dsl.FixedParameterName;
import de.gebit.integrity.dsl.FixedResultName;
import de.gebit.integrity.dsl.KeyValuePair;
import de.gebit.integrity.dsl.MethodReference;
import de.gebit.integrity.dsl.NamedCallResult;
import de.gebit.integrity.dsl.NamedResult;
import de.gebit.integrity.dsl.NestedObject;
import de.gebit.integrity.dsl.Operation;
import de.gebit.integrity.dsl.Parameter;
import de.gebit.integrity.dsl.ParameterName;
import de.gebit.integrity.dsl.ParameterTableHeader;
import de.gebit.integrity.dsl.ParameterTableValue;
import de.gebit.integrity.dsl.ResultTableHeader;
import de.gebit.integrity.dsl.StandardOperation;
import de.gebit.integrity.dsl.StaticValue;
import de.gebit.integrity.dsl.Suite;
import de.gebit.integrity.dsl.SuiteParameter;
import de.gebit.integrity.dsl.TableTest;
import de.gebit.integrity.dsl.TableTestRow;
import de.gebit.integrity.dsl.Test;
import de.gebit.integrity.dsl.TypedNestedObject;
import de.gebit.integrity.dsl.Value;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperation;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperationCollection;
import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.dsl.VariableVariable;
import de.gebit.integrity.exceptions.MethodNotFoundException;
import de.gebit.integrity.exceptions.ModelRuntimeLinkException;
import de.gebit.integrity.modelsource.ModelSourceExplorer;
import de.gebit.integrity.modelsource.ModelSourceInformationElement;

/**
 * Default implementation of a {@link ModelChecker}.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DefaultModelChecker implements ModelChecker {

	/**
	 * The classloader to use for class resolving.
	 */
	@Inject
	protected IntegrityClassLoader classLoader;

	/**
	 * The model source explorer.
	 */
	@Inject
	protected ModelSourceExplorer modelSourceExplorer;

	@Override
	public void check(Test aTest) throws ModelRuntimeLinkException {
		if (aTest.getDefinition() == null || aTest.getDefinition().getName() == null) {
			throw new ModelRuntimeLinkException("Failed to resolve test definition for test statement.", aTest,
					modelSourceExplorer.determineSourceInformation(aTest));
		}
		if (aTest.getDefinition().getFixtureMethod() == null
				|| aTest.getDefinition().getFixtureMethod().getMethod() == null) {
			throw new ModelRuntimeLinkException("Failed to resolve test fixture for test definition.", aTest,
					modelSourceExplorer.determineSourceInformation(aTest));
		}

		tryFixtureMethodResolve(aTest.getDefinition().getFixtureMethod());

		String tempFixtureName = aTest.getDefinition().getName();
		checkParameters(aTest.getParameters(), tempFixtureName);
		for (NamedResult tempNamedResult : aTest.getResults()) {
			if (tempNamedResult.getName() == null) {
				throw new ModelRuntimeLinkException("Failed to resolve named result name", tempNamedResult,
						modelSourceExplorer.determineSourceInformation(tempNamedResult));
			}

			if (tempNamedResult.getName() instanceof FixedResultName) {
				checkSingleFixedNamedResult((FixedResultName) tempNamedResult.getName(), tempFixtureName);
			}

			checkValueContainer(tempNamedResult.getValue());
		}
	}

	@Override
	public void check(Call aCall) throws ModelRuntimeLinkException {
		if (aCall.getDefinition() == null || aCall.getDefinition().getName() == null) {
			throw new ModelRuntimeLinkException("Failed to resolve call definition for call statement.", aCall,
					modelSourceExplorer.determineSourceInformation(aCall));
		}
		if (aCall.getDefinition().getFixtureMethod() == null
				|| aCall.getDefinition().getFixtureMethod().getMethod() == null) {
			throw new ModelRuntimeLinkException("Failed to resolve call fixture for call definition.", aCall,
					modelSourceExplorer.determineSourceInformation(aCall));
		}

		tryFixtureMethodResolve(aCall.getDefinition().getFixtureMethod());

		String tempFixtureName = aCall.getDefinition().getName();
		checkParameters(aCall.getParameters(), tempFixtureName);
		if (aCall.getResult() != null) {
			checkVariableVariable(aCall.getResult());
		}

		for (NamedCallResult tempResult : aCall.getResults()) {
			checkVariableVariable(tempResult.getTarget());
		}
	}

	@Override
	public void check(TableTest aTableTest) throws ModelRuntimeLinkException {
		if (aTableTest.getDefinition() == null || aTableTest.getDefinition().getName() == null) {
			throw new ModelRuntimeLinkException("Failed to resolve test definition for tabletest statement.",
					aTableTest, modelSourceExplorer.determineSourceInformation(aTableTest));
		}
		if (aTableTest.getDefinition().getFixtureMethod() == null
				|| aTableTest.getDefinition().getFixtureMethod().getMethod() == null) {
			throw new ModelRuntimeLinkException("Failed to resolve test fixture for test definition.", aTableTest,
					modelSourceExplorer.determineSourceInformation(aTableTest));
		}

		tryFixtureMethodResolve(aTableTest.getDefinition().getFixtureMethod());

		String tempFixtureName = aTableTest.getDefinition().getName();
		// First check the normal parameters of the table
		checkParameters(aTableTest.getParameters(), tempFixtureName);

		// Now look at the headers for parameters...
		for (ParameterTableHeader tempTableHeader : aTableTest.getParameterHeaders()) {
			if (tempTableHeader.getName() == null) {
				throw new ModelRuntimeLinkException("Failed to resolve parameter name", tempTableHeader,
						modelSourceExplorer.determineSourceInformation(tempTableHeader));
			}
			checkSingleParameterName(tempTableHeader.getName(), tempFixtureName);
		}

		// ...and results!
		for (ResultTableHeader tempTableHeader : aTableTest.getResultHeaders()) {
			if (tempTableHeader.getName() != null) {
				if (tempTableHeader.getName() instanceof FixedResultName) {
					checkSingleFixedNamedResult((FixedResultName) tempTableHeader.getName(), tempFixtureName);
				}
			}
		}

		// Now finally look at all the cells
		for (TableTestRow tempRow : aTableTest.getRows()) {
			for (ParameterTableValue tempValue : tempRow.getValues()) {
				checkValueContainer(tempValue.getValue());
			}
		}
	}

	/**
	 * Used to keep track on which methods a class loading has already been attempted. Subsequent loadings are assumed
	 * to deliver the same result and thus omittable.
	 */
	private Set<MethodReference> resolvedFixtureMethods = new HashSet<MethodReference>();

	private void tryFixtureMethodResolve(MethodReference aMethodReference) {
		if (resolvedFixtureMethods.contains(aMethodReference)) {
			return;
		}
		resolvedFixtureMethods.add(aMethodReference);

		try {
			classLoader.loadMethod(aMethodReference);
		} catch (ClassNotFoundException exc) {
			ModelSourceInformationElement tempSourceInfo = modelSourceExplorer
					.determineSourceInformation(aMethodReference);
			String tempClassName = tempSourceInfo.getSnippet().split("#")[0].trim();
			throw new ModelRuntimeLinkException("Failed to resolve fixture class '" + tempClassName + "'.",
					aMethodReference, tempSourceInfo, exc);
		} catch (MethodNotFoundException exc) {
			ModelSourceInformationElement tempSourceInfo = modelSourceExplorer
					.determineSourceInformation(aMethodReference);
			throw new ModelRuntimeLinkException("Failed to resolve fixture method '" + exc.getMessage() + "'.",
					aMethodReference, tempSourceInfo, exc);
		}
	}

	/**
	 * Used to keep track on which operation classes a class loading has already been attempted. Subsequent loadings are
	 * assumed to deliver the same result and thus omittable.
	 */
	private Set<JvmType> resolvedOperationClasses = new HashSet<JvmType>();

	@Override
	public void check(CustomOperation aCustomOperation) throws ModelRuntimeLinkException {
		if (aCustomOperation.getDefinition() == null) {
			throw new ModelRuntimeLinkException("Failed to resolve operation definition for custom operation.",
					aCustomOperation, modelSourceExplorer.determineSourceInformation(aCustomOperation));
		} else if (aCustomOperation.getDefinition().getOperationType() == null
				|| aCustomOperation.getDefinition().getOperationType().getType() == null) {
			throw new ModelRuntimeLinkException("Failed to resolve operation class for custom operation definition.",
					aCustomOperation, modelSourceExplorer.determineSourceInformation(aCustomOperation));
		}

		JvmType tempType = aCustomOperation.getDefinition().getOperationType().getType();

		if (resolvedOperationClasses.contains(tempType)) {
			return;
		}
		resolvedOperationClasses.add(tempType);

		try {
			classLoader.loadClass(tempType);
		} catch (ClassNotFoundException exc) {
			ModelSourceInformationElement tempSourceInfo = modelSourceExplorer.determineSourceInformation(tempType);
			String tempClassName = tempSourceInfo.getSnippet().split("#")[0].trim();
			throw new ModelRuntimeLinkException("Failed to resolve operation class '" + tempClassName + "'.", tempType,
					tempSourceInfo, exc);
		}

		if (aCustomOperation.getPrefixOperand() != null) {
			checkValueContainer(aCustomOperation.getPrefixOperand());
		}
		if (aCustomOperation.getPostfixOperand() != null) {
			checkValueContainer(aCustomOperation.getPostfixOperand());
		}
	}

	/**
	 * Checks a list of parameters (of a test or call).
	 * 
	 * @param someParameters
	 *            a list of parameters to check
	 * @param aFixtureName
	 *            the fixture name that these parameters belong to (used for error output)
	 */
	protected void checkParameters(List<Parameter> someParameters, String aFixtureName) {
		for (Parameter tempParameter : someParameters) {
			if (tempParameter.getName() == null) {
				throw new ModelRuntimeLinkException("Failed to resolve parameter name", tempParameter,
						modelSourceExplorer.determineSourceInformation(tempParameter));
			}
			checkSingleParameterName(tempParameter.getName(), aFixtureName);

			if (tempParameter.getValue() != null) {
				checkValueContainer(tempParameter.getValue());
			}
		}
	}

	/**
	 * Checks a single parameter name of a test or call.
	 * 
	 * @param aParameterName
	 *            the parameter name to check
	 * @param aTestOrCallName
	 *            the test/call name that this parameter belongs to (used for error output)
	 */
	protected void checkSingleParameterName(ParameterName aParameterName, String aTestOrCallName) {
		if (aParameterName instanceof FixedParameterName) {
			// Fixed parameters must be connected to a fixtures' parameter annotation
			FixedParameterName tempFixedParameterName = (FixedParameterName) aParameterName;
			if (tempFixedParameterName.getAnnotation() == null
					|| tempFixedParameterName.getAnnotation().getAnnotation() == null) {
				ModelSourceInformationElement tempSourceInfo = modelSourceExplorer
						.determineSourceInformation(tempFixedParameterName);
				throw new ModelRuntimeLinkException("Failed to resolve parameter name '" + tempSourceInfo.getSnippet()
						+ "' in test/call '" + aTestOrCallName + "'.", tempFixedParameterName, tempSourceInfo);
			}
		}
	}

	/**
	 * Checks a single fixed named result of a test.
	 * 
	 * @param aFixedResultName
	 *            the fixed result name to check
	 * @param aTestName
	 *            the test name that this result belongs to (for error output)
	 */
	protected void checkSingleFixedNamedResult(FixedResultName aFixedResultName, String aTestName) {
		if (aFixedResultName.getField() == null || aFixedResultName.getField().getType() == null) {
			ModelSourceInformationElement tempSourceInfo = modelSourceExplorer
					.determineSourceInformation(aFixedResultName);
			throw new ModelRuntimeLinkException("Failed to resolve named result field '" + tempSourceInfo.getSnippet()
					+ "' in test '" + aTestName + "'.", aFixedResultName, tempSourceInfo);
		}
	}

	@Override
	public void check(Suite aSuite) throws ModelRuntimeLinkException {
		if (aSuite.getDefinition() == null) {
			ModelSourceInformationElement tempSourceInfo = modelSourceExplorer.determineSourceInformation(aSuite);
			throw new ModelRuntimeLinkException("Failed to resolve suite.", aSuite, tempSourceInfo);
		}

		if (aSuite.getDefinition().getName() == null) {
			ModelSourceInformationElement tempSourceInfo = modelSourceExplorer.determineSourceInformation(aSuite);
			throw new ModelRuntimeLinkException("Failed to resolve suite referenced in suite call '"
					+ tempSourceInfo.getSnippet() + "'.", aSuite.getDefinition(), tempSourceInfo);
		}

		for (SuiteParameter tempParameter : aSuite.getParameters()) {
			if (tempParameter.getName() == null || tempParameter.getName().getName() == null) {
				throw new ModelRuntimeLinkException("Failed to resolve suite parameter name", tempParameter,
						modelSourceExplorer.determineSourceInformation(tempParameter));
			}
		}
	}

	/**
	 * Check a {@link ValueOrEnumValueOrOperationCollection}.
	 * 
	 * @param aValue
	 */
	protected void checkValueContainer(ValueOrEnumValueOrOperationCollection aValue) {
		if (aValue.getValue() == null) {
			throw new ModelRuntimeLinkException("Failed to resolve value", aValue,
					modelSourceExplorer.determineSourceInformation(aValue));
		} else {
			checkValueContainer(aValue.getValue());
		}

		for (ValueOrEnumValueOrOperation tempMoreValue : aValue.getMoreValues()) {
			checkValueContainer(tempMoreValue);
		}
	}

	/**
	 * Check a {@link ValueOrEnumValueOrOperation}.
	 * 
	 * @param aValue
	 */
	protected void checkValueContainer(ValueOrEnumValueOrOperation aValue) {
		if (aValue instanceof Value) {
			checkValueContainer((Value) aValue);
		} else if (aValue instanceof EnumValue) {
			checkEnumValue((EnumValue) aValue);
		} else if (aValue instanceof Operation) {
			checkOperation((Operation) aValue);
		}
	}

	/**
	 * Check a {@link Value}.
	 * 
	 * @param aValue
	 */
	protected void checkValueContainer(Value aValue) {
		if (aValue instanceof StaticValue) {
			// no further checks supported
		} else if (aValue instanceof Variable) {
			checkVariable((Variable) aValue);
		} else if (aValue instanceof NestedObject) {
			checkNestedObject((NestedObject) aValue);
		} else if (aValue instanceof TypedNestedObject) {
			checkTypedNestedObject((TypedNestedObject) aValue);
		}
	}

	/**
	 * Checks an {@link EnumValue}.
	 * 
	 * @param aValue
	 */
	protected void checkEnumValue(EnumValue aValue) {
		if (aValue.getEnumValue() == null) {
			throw new ModelRuntimeLinkException("Failed to resolve enum value", aValue.getEnumValue(),
					modelSourceExplorer.determineSourceInformation(aValue.getEnumValue()));
		}
	}

	/**
	 * Checks an {@link Operation}.
	 * 
	 * @param anOperation
	 */
	protected void checkOperation(Operation anOperation) {
		if (anOperation instanceof CustomOperation) {
			check((CustomOperation) anOperation);
		} else if (anOperation instanceof StandardOperation) {
			StandardOperation tempOperation = (StandardOperation) anOperation;
			if (tempOperation.getFirstOperand() != null) {
				checkValueContainer(tempOperation.getFirstOperand());
			}
			for (ValueOrEnumValueOrOperation tempOperand : tempOperation.getMoreOperands()) {
				checkValueContainer(tempOperand);
			}
		}
	}

	/**
	 * Checks a {@link Variable}.
	 * 
	 * @param aVariable
	 */
	protected void checkVariable(Variable aVariable) {
		if (aVariable.getName() == null || aVariable.getName().getName() == null) {
			throw new ModelRuntimeLinkException("Failed to resolve variable name", aVariable,
					modelSourceExplorer.determineSourceInformation(aVariable));
		}
	}

	/**
	 * Checks a {@link VariableVariable}.
	 * 
	 * @param aVariable
	 */
	protected void checkVariableVariable(VariableVariable aVariable) {
		if (aVariable.getName() == null || aVariable.getName().getName() == null) {
			throw new ModelRuntimeLinkException("Failed to resolve variable name", aVariable,
					modelSourceExplorer.determineSourceInformation(aVariable));
		}
	}

	/**
	 * Checks a {@link NestedObject}.
	 * 
	 * @param anObject
	 */
	protected void checkNestedObject(NestedObject anObject) {
		for (KeyValuePair tempPair : anObject.getAttributes()) {
			checkValueContainer(tempPair.getValue());
		}
	}

	/**
	 * Checks a {@link TypedNestedObject}.
	 * 
	 * @param anObject
	 */
	protected void checkTypedNestedObject(TypedNestedObject anObject) {
		checkNestedObject(anObject.getNestedObject());
	}
}
