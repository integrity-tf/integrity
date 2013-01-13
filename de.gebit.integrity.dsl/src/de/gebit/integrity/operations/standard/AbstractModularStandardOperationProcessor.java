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
 * 
 * 
 * @author Slartibartfast
 * 
 */
public abstract class AbstractModularStandardOperationProcessor implements StandardOperationProcessor {

	private Map<String, Integer> operatorPrecedences = new HashMap<String, Integer>();

	private Map<String, Class<? extends OperatorNode<?, ?>>> operatorNodeClasses = new HashMap<String, Class<? extends OperatorNode<?, ?>>>();

	@Inject
	private Injector injector;

	public AbstractModularStandardOperationProcessor() {
		initializeOperatorInfo();
	}

	protected abstract void initializeOperatorInfo();

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

	protected int getOperatorPrecedence(String anOperator) {
		Integer tempPrecedence = operatorPrecedences.get(anOperator);
		if (tempPrecedence == null) {
			// Actually this should never happen, but...
			throw new RuntimeException("Operator '" + anOperator + "' is unknown!");
		}

		return tempPrecedence;
	}

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
