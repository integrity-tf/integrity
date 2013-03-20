/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.operations.standard;

import de.gebit.integrity.operations.standard.operands.AdditionNode;
import de.gebit.integrity.operations.standard.operands.DivisionNode;
import de.gebit.integrity.operations.standard.operands.ModuloNode;
import de.gebit.integrity.operations.standard.operands.MultiplicationNode;
import de.gebit.integrity.operations.standard.operands.StringConcatenationNode;
import de.gebit.integrity.operations.standard.operands.SubtractionNode;

/**
 * The {@link StandardOperationProcessor} used by default in Integrity.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class DefaultModularStandardOperationProcessor extends AbstractModularStandardOperationProcessor {

	@Override
	protected void initializeOperatorInfo() {
		addOperatorInfo("+", AdditionNode.class);
		addOperatorInfo("-", SubtractionNode.class);
		addOperatorInfo("*", MultiplicationNode.class);
		addOperatorInfo("/", DivisionNode.class);
		addOperatorInfo("%", ModuloNode.class);
		addOperatorInfo("..", StringConcatenationNode.class);
	}

}
