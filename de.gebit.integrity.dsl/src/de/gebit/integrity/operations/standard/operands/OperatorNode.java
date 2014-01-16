/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.operations.standard.operands;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.google.inject.Inject;

import de.gebit.integrity.operations.UnexecutableException;
import de.gebit.integrity.parameter.conversion.ValueConverter;
import de.gebit.integrity.utils.JavaTypeUtil;

/**
 * Abstract base class for operator nodes. An operator node is a node in the AST built to evaluate
 * {@link de.gebit.integrity.dsl.StandardOperation}s.
 * 
 * @param <LEFT>
 *            the left argument
 * @param <RIGHT>
 *            the right argument
 * @author Rene Schneider - initial API and implementation
 * 
 */
public abstract class OperatorNode<LEFT extends Object, RIGHT extends Object> {

	/**
	 * The left operand.
	 */
	private Object leftOperand;

	/**
	 * The right operand.
	 */
	private Object rightOperand;

	/**
	 * The value converter to use.
	 */
	@Inject
	private ValueConverter valueConverter;

	/**
	 * Creates an instance.
	 * 
	 * @param aLeftOperand
	 *            the left operand
	 * @param aRightOperand
	 *            the right operand
	 */
	public OperatorNode(Object aLeftOperand, Object aRightOperand) {
		leftOperand = aLeftOperand;
		rightOperand = aRightOperand;
	}

	/**
	 * Returns the left operand in an evaluated version.
	 * 
	 * @return the result of the evaluation
	 * @throws UnexecutableException
	 */
	protected Object getEvaluatedLeftOperand() throws UnexecutableException {
		if (leftOperand instanceof OperatorNode<?, ?>) {
			return ((OperatorNode<?, ?>) leftOperand).evaluate();
		} else {
			return leftOperand;
		}
	}

	/**
	 * Returns the right operand in an evaluated version.
	 * 
	 * @return the result of the evaluation
	 * @throws UnexecutableException
	 */
	protected Object getEvaluatedRightOperand() throws UnexecutableException {
		if (rightOperand instanceof OperatorNode<?, ?>) {
			return ((OperatorNode<?, ?>) rightOperand).evaluate();
		} else {
			return rightOperand;
		}
	}

	/**
	 * Evaluates the whole node.
	 * 
	 * @return the evaluation result
	 * @throws UnexecutableException
	 */
	@SuppressWarnings("unchecked")
	public Object evaluate() throws UnexecutableException {
		Type tempType = JavaTypeUtil.findGenericInterfaceOrSuperType(getClass(), OperatorNode.class);
		if (tempType != null) {
			Class<?> tempLeftOperandType = (Class<?>) ((ParameterizedType) tempType).getActualTypeArguments()[0];
			Class<?> tempRightOperandType = (Class<?>) ((ParameterizedType) tempType).getActualTypeArguments()[1];

			LEFT tempConvertedLeftOperand = (LEFT) valueConverter.convertValue(tempLeftOperandType,
					getEvaluatedLeftOperand(), null);
			RIGHT tempConvertedRightOperand = (RIGHT) valueConverter.convertValue(tempRightOperandType,
					getEvaluatedRightOperand(), null);

			return evaluateInternal(tempConvertedLeftOperand, tempConvertedRightOperand);
		} else {
			throw new IllegalArgumentException("Was unable to find valid generic Conversion superinterface");
		}
	}

	/**
	 * Must be implemented by subclasses to implement the actual evaluation of this node. It will get evaluated and
	 * converted operands and needs to return the result of the evaluation.
	 * 
	 * @param aLeftOperand
	 *            the evaluated left operand
	 * @param aRightOperand
	 *            the evaluated right operand
	 * @return the result of the evaluation
	 */
	protected abstract Object evaluateInternal(LEFT aLeftOperand, RIGHT aRightOperand) throws UnexecutableException;

}
