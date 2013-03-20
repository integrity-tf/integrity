/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.operations.standard.operands;

/**
 * Concatenates two strings.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class StringConcatenationNode extends OperatorNode<String, String> {

	/**
	 * Creates a new instance.
	 * 
	 * @param aLeftOperand
	 *            the left operand
	 * @param aRightOperand
	 *            the right operand
	 */
	public StringConcatenationNode(Object aLeftOperand, Object aRightOperand) {
		super(aLeftOperand, aRightOperand);
	}

	@Override
	protected Object evaluateInternal(String aLeftOperand, String aRightOperand) {
		String tempLeftOperand = aLeftOperand == null ? "null" : aLeftOperand;
		String tempRightOperand = aRightOperand == null ? "null" : aRightOperand;

		return tempLeftOperand + tempRightOperand;
	}
}
