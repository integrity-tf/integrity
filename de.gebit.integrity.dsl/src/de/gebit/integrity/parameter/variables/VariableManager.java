/**
 * 
 */
package de.gebit.integrity.parameter.variables;

import java.util.Map.Entry;
import java.util.Set;

import de.gebit.integrity.dsl.VariableOrConstantEntity;

/**
 * The variable manager is responsible for keeping track of variable values.
 * 
 * @author Rene Schneider
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

	// TODO eliminate the need for the method below somehow!

	/**
	 * Returns all variable entity entries.
	 * 
	 * @return
	 */
	Set<Entry<VariableOrConstantEntity, Object>> getAllEntries();

}
