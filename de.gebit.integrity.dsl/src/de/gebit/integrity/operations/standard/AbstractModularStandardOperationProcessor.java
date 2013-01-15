/**
 * 
 */
package de.gebit.integrity.operations.standard;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.inject.Inject;
import com.google.inject.Injector;

import de.gebit.integrity.dsl.StandardOperation;
import de.gebit.integrity.dsl.ValueOrEnumValueOrOperation;
import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.operations.standard.operands.OperatorNode;

/**
 * Abstract base implementation for a modular processor processing standard operations. This processor builds a kind of
 * abstract syntax tree for evaluation of operations.
 * 
 * @author Rene Schneider
 * 
 */
public abstract class AbstractModularStandardOperationProcessor implements StandardOperationProcessor {

	/**
	 * A map storing the operator precedence order.
	 */
	private Map<String, Integer> operatorPrecedences = new HashMap<String, Integer>();

	/**
	 * A map storing the operator node classes for fast access.
	 */
	private Map<String, Class<? extends OperatorNode<?, ?>>> operatorNodeClasses = new HashMap<String, Class<? extends OperatorNode<?, ?>>>();

	/**
	 * The injector.
	 */
	@Inject
	private Injector injector;

	/**
	 * Creates an instance.
	 */
	public AbstractModularStandardOperationProcessor() {
		initializeOperatorInfo();
	}

	/**
	 * Initializes all operators by calls to {@link #addOperatorInfo(String, Class)}.
	 */
	protected abstract void initializeOperatorInfo();

	/**
	 * Adds an operator.
	 * 
	 * @param anOperator
	 *            the operator string
	 * @param aNodeClass
	 *            the node class representing this operator
	 */
	protected void addOperatorInfo(String anOperator, Class<? extends OperatorNode<?, ?>> aNodeClass) {
		operatorPrecedences.put(anOperator, operatorPrecedences.size());
		operatorNodeClasses.put(anOperator, aNodeClass);
	}

	@Override
	public Object executeOperation(StandardOperation anOperation) throws UnexecutableException {
		try {
			OperatorNode<?, ?> tempRootNode = parseOperation(anOperation);

			return tempRootNode.evaluate();
		} catch (SecurityException exc) {
			throw new UnexecutableException(exc);
		} catch (IllegalArgumentException exc) {
			throw new UnexecutableException(exc);
		} catch (NoSuchMethodException exc) {
			throw new UnexecutableException(exc);
		} catch (InstantiationException exc) {
			throw new UnexecutableException(exc);
		} catch (IllegalAccessException exc) {
			throw new UnexecutableException(exc);
		} catch (InvocationTargetException exc) {
			throw new UnexecutableException(exc);
		}
	}

	/**
	 * Parses the given operation.
	 * 
	 * @param anOperation
	 *            the operation to parse
	 * @return the AST representing the operation
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws NoSuchMethodException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	protected OperatorNode<?, ?> parseOperation(StandardOperation anOperation) throws SecurityException,
			IllegalArgumentException, NoSuchMethodException, InstantiationException, IllegalAccessException,
			InvocationTargetException {
		List<Object> tempOperands = new ArrayList<Object>();
		List<String> tempOperators = new ArrayList<String>();

		tempOperands.add(anOperation.getFirstOperand());
		for (ValueOrEnumValueOrOperation tempOperand : anOperation.getMoreOperands()) {
			tempOperands.add(tempOperand);
		}
		for (String tempOperator : anOperation.getOperators()) {
			tempOperators.add(tempOperator);
		}

		while (tempOperators.size() > 0) {
			int tempHighestPreference = -1;
			int tempHighestPreferencePos = 0;
			for (int i = 0; i < tempOperators.size(); i++) {
				String tempOperator = tempOperators.get(i);

				int tempPreference = getOperatorPrecedence(tempOperator);
				if (tempPreference > tempHighestPreference) {
					tempHighestPreference = tempPreference;
					tempHighestPreferencePos = i;
				}
			}

			String tempOperator = tempOperators.remove(tempHighestPreferencePos);
			Object tempLeftOperand = tempOperands.get(tempHighestPreferencePos); // no remove; will be replaced later!
			Object tempRightOperand = tempOperands.remove(tempHighestPreferencePos + 1);

			// These shortcuts handle the most-common case of operands being operations themselves. Technically these
			// are optional, evaluation would happen anyway during value conversion, but this speeds things up.
			if (tempLeftOperand instanceof StandardOperation) {
				tempLeftOperand = parseOperation((StandardOperation) tempLeftOperand);
			}
			if (tempRightOperand instanceof StandardOperation) {
				tempRightOperand = parseOperation((StandardOperation) tempRightOperand);
			}

			OperatorNode<?, ?> tempNewNode = createNode(tempOperator, tempLeftOperand, tempRightOperand);
			tempOperands.set(tempHighestPreferencePos, tempNewNode);
		}

		return (OperatorNode<?, ?>) tempOperands.get(0);
	}

	/**
	 * Determines the precedence (ordering) of the given operator.
	 * 
	 * @param anOperator
	 *            the operator to evaluate
	 * @return the numeric precedence (higher = evaluate first)
	 */
	protected int getOperatorPrecedence(String anOperator) {
		Integer tempPrecedence = operatorPrecedences.get(anOperator);
		if (tempPrecedence == null) {
			// Actually this should never happen, but...
			throw new RuntimeException("Operator '" + anOperator + "' is unknown!");
		}

		return tempPrecedence;
	}

	/**
	 * Creates a new node.
	 * 
	 * @param anOperator
	 *            the operator
	 * @param aLeftOperand
	 *            the left operand (not evaluated)
	 * @param aRightOperand
	 *            the right operand (not evaluated)
	 * @return the node
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 * @throws IllegalArgumentException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 * @throws InvocationTargetException
	 */
	protected OperatorNode<?, ?> createNode(String anOperator, Object aLeftOperand, Object aRightOperand)
			throws SecurityException, NoSuchMethodException, IllegalArgumentException, InstantiationException,
			IllegalAccessException, InvocationTargetException {
		Class<? extends OperatorNode<?, ?>> tempClass = operatorNodeClasses.get(anOperator);
		if (tempClass == null) {
			// Actually this should never happen, but...
			throw new RuntimeException("Operator '" + anOperator + "' is unknown!");
		}

		Constructor<? extends OperatorNode<?, ?>> tempConstructor = tempClass.getConstructor(new Class<?>[] {
				Object.class, Object.class });

		OperatorNode<?, ?> tempInstance = tempConstructor.newInstance(aLeftOperand, aRightOperand);
		injector.injectMembers(tempInstance);
		return tempInstance;
	}

}
