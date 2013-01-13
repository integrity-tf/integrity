/**
 * 
 */
package de.gebit.integrity.operations.standard.operands;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.google.inject.Inject;

import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.parameter.conversion.UnresolvableVariableHandling;
import de.gebit.integrity.parameter.conversion.ValueConverter;
import de.gebit.integrity.parameter.variables.VariableManager;
import de.gebit.integrity.utils.JavaTypeUtil;
import de.gebit.integrity.utils.ParameterUtil.UnresolvableVariableException;

/**
 * 
 * @param <LEFT>
 * @param <RIGHT>
 * @author Slartibartfast
 * 
 */
public abstract class OperatorNode<LEFT extends Object, RIGHT extends Object> {

	private Object leftOperand;

	private Object rightOperand;

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

	public OperatorNode(Object aLeftOperand, Object aRightOperand) {
		leftOperand = aLeftOperand;
		rightOperand = aRightOperand;
	}

	protected Object getEvaluatedLeftOperand() throws UnexecutableException {
		if (leftOperand instanceof OperatorNode<?, ?>) {
			return ((OperatorNode<?, ?>) leftOperand).evaluate();
		} else {
			return leftOperand;
		}
	}

	protected Object getEvaluatedRightOperand() throws UnexecutableException {
		if (rightOperand instanceof OperatorNode<?, ?>) {
			return ((OperatorNode<?, ?>) rightOperand).evaluate();
		} else {
			return rightOperand;
		}
	}

	@SuppressWarnings("unchecked")
	public Object evaluate() throws UnexecutableException {
		Type tempType = JavaTypeUtil.findGenericInterfaceOrSuperType(getClass(), OperatorNode.class);
		if (tempType != null) {
			Class<?> tempLeftOperandType = (Class<?>) ((ParameterizedType) tempType).getActualTypeArguments()[0];
			Class<?> tempRightOperandType = (Class<?>) ((ParameterizedType) tempType).getActualTypeArguments()[1];

			try {
				LEFT tempConvertedLeftOperand = (LEFT) valueConverter.convertValue(tempLeftOperandType,
						getEvaluatedLeftOperand(), UnresolvableVariableHandling.EXCEPTION);
				RIGHT tempConvertedRightOperand = (RIGHT) valueConverter.convertValue(tempRightOperandType,
						getEvaluatedRightOperand(), UnresolvableVariableHandling.EXCEPTION);

				return evaluateInternal(tempConvertedLeftOperand, tempConvertedRightOperand);
			} catch (UnresolvableVariableException exc) {
				throw new UnexecutableException(exc.getMessage(), exc);
			}
		} else {
			throw new IllegalArgumentException("Was unable to find valid generic Conversion superinterface");
		}
	}

	protected abstract Object evaluateInternal(LEFT aLeftOperand, RIGHT aRightOperand);

}
