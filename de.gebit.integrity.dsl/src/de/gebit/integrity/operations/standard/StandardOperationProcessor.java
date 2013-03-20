/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.operations.standard;

import de.gebit.integrity.dsl.StandardOperation;
import de.gebit.integrity.operations.UnexecutableException;

/**
 * Implementations of this class are responsible for processing {@link StandardOperation} instances, which are
 * operations directly supported in the Integrity language core. Right now that covers some basic arithmetic operations
 * and string concatenation.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public interface StandardOperationProcessor {

	/**
	 * Evaluates the given {@link StandardOperation} and returns the result object (not converted to any specific type).
	 * 
	 * @param anOperation
	 *            the operation to execute
	 * @return the result
	 * @throws UnexecutableException
	 *             in case the operation cannot be executed (such as because we're running in Eclipse and don't have
	 *             access to variable values)
	 */
	Object executeOperation(StandardOperation anOperation) throws UnexecutableException;

}
