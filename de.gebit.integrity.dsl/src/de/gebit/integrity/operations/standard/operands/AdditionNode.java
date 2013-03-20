/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.operations.standard.operands;

import java.math.BigDecimal;

import de.gebit.integrity.operations.UnexecutableException;

/**
 * Adds two values. Always uses BigDecimals since those can cover the whole range of values supported by Integrity.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class AdditionNode extends OperatorNode<BigDecimal, BigDecimal> {

	/**
	 * Constructs a new instance.
	 * 
	 * @param aLeftOperand
	 * @param aRightOperand
	 */
	public AdditionNode(Object aLeftOperand, Object aRightOperand) {
		super(aLeftOperand, aRightOperand);
	}

	@Override
	protected Object evaluateInternal(BigDecimal aLeftOperand, BigDecimal aRightOperand) throws UnexecutableException {
		if (aLeftOperand == null) {
			throw new UnexecutableException("Cannot evaluate operation: left operand missing!");
		} else if (aRightOperand == null) {
			throw new UnexecutableException("Cannot evaluate operation: right operand missing!");
		}
		return aLeftOperand.add(aRightOperand);
	}
}
