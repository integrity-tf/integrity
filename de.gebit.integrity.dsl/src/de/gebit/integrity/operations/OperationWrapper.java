/**
 * 
 */
package de.gebit.integrity.operations;

import java.lang.reflect.Method;
import java.util.Map;

import org.eclipse.xtext.common.types.JvmType;

import de.gebit.integrity.dsl.Operation;
import de.gebit.integrity.dsl.OperationDefinition;
import de.gebit.integrity.dsl.VariableEntity;
import de.gebit.integrity.parameter.conversion.ValueConverter;
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;

/**
 * The operation wrapper is used to wrap an operation class and instance for execution. The wrapper does perform class
 * loading and instantiation.
 * 
 * @author Rene Schneider
 * 
 */
public class OperationWrapper {

	/**
	 * The operation to perform.
	 */
	private Operation operation;

	/**
	 * The operation class.
	 */
	private Class<? extends de.gebit.integrity.operations.Operation<?, ?, ?>> operationClass;

	/**
	 * The value converter to use.
	 */
	private ValueConverter valueConverter;

	/**
	 * Creates a new wrapper instance. This also loads the actual operation implementation class using the provided
	 * classloader.
	 * 
	 * @param anOperation
	 *            the operation to wrap
	 * @param aClassLoader
	 *            the classloader to use for loading the operation class
	 * @param aValueConverter
	 *            the value converter to use
	 * @throws ClassNotFoundException
	 *             if the operations' class could not be found
	 */
	@SuppressWarnings("unchecked")
	public OperationWrapper(Operation anOperation, ClassLoader aClassLoader, ValueConverter aValueConverter)
			throws ClassNotFoundException {
		operation = anOperation;
		valueConverter = aValueConverter;

		OperationDefinition tempDefinition = operation.getDefinition();
		if (tempDefinition == null) {
			throw new IllegalStateException("No definition found for operation " + operation);
		}

		JvmType tempType = tempDefinition.getOperationType();
		if (tempType == null) {
			throw new IllegalStateException("No method reference found for operation with name '"
					+ tempDefinition.getName() + "'");
		}

		operationClass = (Class<? extends de.gebit.integrity.operations.Operation<?, ?, ?>>) aClassLoader
				.loadClass(tempType.getQualifiedName());
	}

	/**
	 * Executes the wrapped operation logic.
	 * 
	 * @param aVariableMap
	 *            the current variable map
	 * @param aLeaveUnexecutableOperationIntact
	 *            true in case an operation that cannot be executed (because it depends on variable values which are not
	 *            defined) shall result in the operation object being returned instead of an exception
	 * @return the result of the operation
	 * @throws UnexecutableException
	 *             if the operation cannot be executed because it depends on variables which are not defined
	 * @throws InstantiationException
	 *             the instantiation exception
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Object executeOperation(Map<VariableEntity, Object> aVariableMap, boolean aLeaveUnexecutableOperationIntact)
			throws UnexecutableException, InstantiationException, ClassNotFoundException {
		de.gebit.integrity.operations.Operation tempOperationInstance;

		try {
			tempOperationInstance = operationClass.newInstance();
		} catch (IllegalAccessException exc) {
			throw new IllegalArgumentException("Caught exception when trying to instantiate operation class '"
					+ operationClass + "'", exc);
		}

		try {
			Object tempConvertedPrefixParameter = null;
			if (operation.getPrefixOperand() != null) {
				tempConvertedPrefixParameter = valueConverter.convertEncapsulatedValueCollectionToParamType(
						determinePrefixParameterTargetType(), operation.getPrefixOperand(), aVariableMap,
						operationClass.getClassLoader());
			}
			Object tempConvertedPostfixParameter = null;
			if (operation.getPostfixOperand() != null) {
				tempConvertedPostfixParameter = valueConverter.convertEncapsulatedValueCollectionToParamType(
						determinePostfixParameterTargetType(), operation.getPostfixOperand(), aVariableMap,
						operationClass.getClassLoader());
			}

			return tempOperationInstance.execute(tempConvertedPrefixParameter, tempConvertedPostfixParameter);
		} catch (UnresolvableVariableException exc) {
			if (aLeaveUnexecutableOperationIntact) {
				// We shall continue execution, but with the operation not being resolvable due to undefined values, we
				// can only return the operation as-is
				return operation;
			} else {
				throw new UnexecutableException("Failed to resolve a variable during execution of operation '"
						+ operation.getDefinition().getName() + "'", exc);
			}
		}
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
			if ("execute".equals(tempPossibleMethod.getName())) {
				tempMethod = tempPossibleMethod;
				break;
			}
		}

		if (tempMethod == null) {
			throw new IllegalStateException("Found no execute method on operation class " + operationClass + ".");
		}

		return tempMethod;
	}

	/**
	 * This exception is thrown if an operation cannot be executed (usually because it depends on variables which are
	 * not resolvable because no variable map was given).
	 * 
	 * 
	 * @author Rene Schneider
	 * 
	 */
	public class UnexecutableException extends Exception {

		/**
		 * The serialization version.
		 */
		private static final long serialVersionUID = -6492533441071927015L;

		/**
		 * Instantiates a new unexecutable exception.
		 */
		public UnexecutableException() {
			super();
		}

		/**
		 * Instantiates a new unexecutable exception.
		 * 
		 * @param aMessage
		 *            the a message
		 * @param aCause
		 *            the a cause
		 */
		public UnexecutableException(String aMessage, Throwable aCause) {
			super(aMessage, aCause);
		}

		/**
		 * Instantiates a new unexecutable exception.
		 * 
		 * @param aMessage
		 *            the a message
		 */
		public UnexecutableException(String aMessage) {
			super(aMessage);
		}

		/**
		 * Instantiates a new unexecutable exception.
		 * 
		 * @param aCause
		 *            the a cause
		 */
		public UnexecutableException(Throwable aCause) {
			super(aCause);
		}

	}
}
