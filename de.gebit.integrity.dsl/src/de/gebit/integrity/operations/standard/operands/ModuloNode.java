/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.operations.standard.operands;

import java.math.BigInteger;

import de.gebit.integrity.operations.UnexecutableException;

/**
 * Modulo calculation.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class ModuloNode extends OperatorNode<BigInteger, BigInteger> {

	/**
	 * Creates a new instance.
	 * 
	 * @param aLeftOperand
	 * @param aRightOperand
	 */
	public ModuloNode(Object aLeftOperand, Object aRightOperand) {
		super(aLeftOperand, aRightOperand);
	}

	@Override
	protected Object evaluateInternal(BigInteger aLeftOperand, BigInteger aRightOperand) throws UnexecutableException {
		if (aLeftOperand == null) {
			throw new UnexecutableException("Cannot evaluate operation: left operand missing!");
		} else if (aRightOperand == null) {
			throw new UnexecutableException("Cannot evaluate operation: right operand missing!");
		}
		return aLeftOperand.mod(aRightOperand);
	}
}
