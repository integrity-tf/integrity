/*******************************************************************************
 * Copyright (c) 2017 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.variables;

import de.gebit.integrity.dsl.VariableOrConstantEntity;

/**
 * Interface for a callback implementation that allows the {@link VariableManager} to trigger the definition of the
 * (typically initial) value for a given {@link VariableOrConstantEntity} by someone capable of defining this value (=
 * the implementor of this interface).
 * 
 * @author Rene Schneider - initial API and implementation
 *
 */
public interface VariableOrConstantEntityInitialValueDefinitionCallback {

	/**
	 * When called, the definition of the given {@link VariableOrConstantEntity} should be performed. It must be
	 * performed synchronously, because the caller is allowed to expect the {@link VariableOrConstantEntity} to be
	 * defined after this method returns.
	 * 
	 * @param anEntity
	 *            the entity to define
	 */
	void triggerDefinition(VariableOrConstantEntity anEntity);

}
