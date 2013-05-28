/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.operations.custom;

import java.lang.reflect.Method;

import org.eclipse.xtext.common.types.JvmType;

import com.google.inject.Binder;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;

import de.gebit.integrity.dsl.CustomOperation;
import de.gebit.integrity.dsl.OperationDefinition;
import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.parameter.conversion.ValueConverter;
import de.gebit.integrity.parameter.variables.VariableManager;

/**
 * The custom operation wrapper is used to wrap a custom operation class and instance for execution. The wrapper does
 * perform class loading and instantiation.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class CustomOperationWrapper {

	/**
	 * The operation to perform.
	 */
	private CustomOperation operation;

	/**
	 * The operation class.
	 */
	private Class<? extends de.gebit.integrity.operations.custom.Operation<?, ?, ?>> operationClass;

	/**
	 * The value converter to use.
	 */
	@Inject
	private ValueConverter valueConverter;

	/**
	 * The variable manager to use.
	 */
	@Inject
	private VariableManager variableManager;

	/**
	 * The injector used to inject stuff into operation instances.
	 */
	@Inject
	private Injector injector;

	/**
	 * Creates a new wrapper instance. This also loads the actual operation implementation class using the injected
	 * classloader.
	 * 
	 * @param anOperation
	 *            the operation to wrap
	 * @param aClassLoader
	 *            the classloader to use (cannot be injected at the moment because it's required during object
	 *            construction)
	 * @throws ClassNotFoundException
	 *             if the operations' class could not be found
	 */
	@SuppressWarnings("unchecked")
	public CustomOperationWrapper(CustomOperation anOperation, ClassLoader aClassLoader) throws ClassNotFoundException {
		operation = anOperation;

		OperationDefinition tempDefinition = operation.getDefinition();
		if (tempDefinition == null) {
			throw new IllegalStateException("No definition found for operation " + operation);
		}

		JvmType tempType = tempDefinition.getOperationType();
		if (tempType == null) {
			throw new IllegalStateException("No method reference found for operation with name '"
					+ tempDefinition.getName() + "'");
		}

		operationClass = (Class<? extends de.gebit.integrity.operations.custom.Operation<?, ?, ?>>) aClassLoader
				.loadClass(tempType.getQualifiedName());
	}

	/**
	 * Executes the wrapped operation logic.
	 * 
	 * @return the result of the operation
	 * @throws UnexecutableException
	 *             if the operation cannot be executed for any reason
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object executeOperation() throws UnexecutableException {
		de.gebit.integrity.operations.custom.Operation tempOperationInstance;

		try {
			tempOperationInstance = operationClass.newInstance();
		} catch (IllegalAccessException exc) {
			throw new UnexecutableException(exc);
		} catch (InstantiationException exc) {
			throw new UnexecutableException(exc);
		}

		injector.createChildInjector(new Module() {

			@Override
			public void configure(Binder aBinder) {
				aBinder.bind(CustomOperation.class).toInstance(operation);
			}
		}).injectMembers(tempOperationInstance);

		Object tempConvertedPrefixParameter = null;
		if (operation.getPrefixOperand() != null) {
			tempConvertedPrefixParameter = valueConverter.convertValue(determinePrefixParameterTargetType(),
					operation.getPrefixOperand(), UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);
		}
		Object tempConvertedPostfixParameter = null;
		if (operation.getPostfixOperand() != null) {
			tempConvertedPostfixParameter = valueConverter.convertValue(determinePostfixParameterTargetType(),
					operation.getPostfixOperand(), UnresolvableVariableHandling.RESOLVE_TO_NULL_VALUE);
		}

		return tempOperationInstance.execute(tempConvertedPrefixParameter, tempConvertedPostfixParameter);
	}

	/**
	 * Determines the type of the operation prefix parameter.
	 * 
	 * @return the expected type
	 */
	protected Class<?> determinePrefixParameterTargetType() {
		// first parameter is the prefix parameter
		return determineExecuteMethod().getParameterTypes()[0];
	}

	/**
	 * Determines the type of the operation postfix parameter.
	 * 
	 * @return the expected type
	 */
	protected Class<?> determinePostfixParameterTargetType() {
		// second parameter is the postfix parameter
		return determineExecuteMethod().getParameterTypes()[1];
	}

	/**
	 * Searches the operation class for the "execute" method, and returns the corresponding reflection method instance.
	 * 
	 * @return the method representation
	 */
	protected Method determineExecuteMethod() {
		Method tempMethod = null;
		for (Method tempPossibleMethod : operationClass.getMethods()) {
			if (!tempPossibleMethod.isBridge() && "execute".equals(tempPossibleMethod.getName())) {
				tempMethod = tempPossibleMethod;
				break;
			}
		}

		if (tempMethod == null) {
			throw new IllegalStateException("Found no execute method on operation class " + operationClass + ".");
		}

		return tempMethod;
	}
}
