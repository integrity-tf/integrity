/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.parameter.variables;

import java.util.Map;

import de.gebit.integrity.dsl.Variable;
import de.gebit.integrity.dsl.VariableOrConstantEntity;
import de.gebit.integrity.dsl.VariantDefinition;

/**
 * The variable manager is responsible for keeping track of variable values.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public interface VariableManager {

	/**
	 * Gets a value for a specific variable.
	 * 
	 * @param anEntity
	 *            the variable entity
	 * @return the value or null if none was defined
	 */
	Object get(VariableOrConstantEntity anEntity);

	/**
	 * Gets a value for a specific variable. This is able to retrieve attribute values out of bean variable values, if
	 * necessary.
	 * 
	 * @param aVariable
	 *            the variable entity
	 * @return the value or null if none was defined
	 */
	Object get(Variable aVariable);

	/**
	 * Checks whether a specific variable has a defined value. Variables with 'null' as their defined value will return
	 * true here, even though calling get() on them will yield the same result as if they were not defined.
	 * 
	 * @param aVariable
	 *            the variable entity
	 * @return true if the variable is defined, false if not
	 */
	boolean isDefined(VariableOrConstantEntity aVariable);

	/**
	 * Checks whether a specific variable has a defined value. Variables with 'null' as their defined value will return
	 * true here, even though calling get() on them will yield the same result as if they were not defined.
	 * 
	 * @param aVariable
	 *            the variable entity
	 * @return true if the variable is defined, false if not
	 */
	boolean isDefined(Variable aVariable);

	/**
	 * Sets a value for a specific variable. This is also used to define constants, as constants are technically also
	 * {@link de.gebit.integrity.dsl.VariableEntity} instances (
	 * 
	 * @param anEntity
	 *            the variable entity
	 * @param aValue
	 *            the value to set
	 */
	void set(VariableOrConstantEntity anEntity, Object aValue);

	/**
	 * Unsets the specific variable or constant.
	 * 
	 * @param anEntity
	 *            the variable entity
	 */
	void unset(VariableOrConstantEntity anEntity);

	/**
	 * Clears all stored variable values.
	 * 
	 * @param aClearConstantsFlag
	 *            Whether to clear constants as well. If false, only actual variables are cleared.
	 */
	void clear(boolean aClearConstantsFlag);

	/**
	 * Returns all variable entity entries.
	 * 
	 * @return
	 */
	Map<String, Object> dumpVariableState(VariantDefinition aVariant);

	/**
	 * Reads the state as previously exported via {@link #dumpVariableState()}. This is additive, meaning it does not
	 * remove non-mentioned variables.
	 */
	void importVariableState(Map<String, Object> aState);
}
