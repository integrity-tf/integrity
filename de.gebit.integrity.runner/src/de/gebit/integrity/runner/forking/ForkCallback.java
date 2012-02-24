/**
 * 
 */
package de.gebit.integrity.runner.forking;

/**
 * Callback to deliver events from a fork to the parent.
 * 
 * @author Rene Schneider
 * 
 */
public interface ForkCallback {

	/**
	 * If the fork sets variables, it will sync them to the parent using this method.
	 * 
	 * @param aQualifiedVariableName
	 *            the variable name
	 * @param aValue
	 *            the new value
	 * @param aDoSendUpdateFlag
	 *            whether updates should be distributed to other remoting clients
	 */
	void onSetVariableValue(String aQualifiedVariableName, Object aValue, boolean aDoSendUpdateFlag);

	/**
	 * Called when the fork exits.
	 * 
	 * @param aFork
	 *            the fork
	 */
	void onForkExit(Fork aFork);

}
