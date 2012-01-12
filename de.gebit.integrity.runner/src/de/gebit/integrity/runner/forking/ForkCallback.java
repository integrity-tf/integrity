/**
 * 
 */
package de.gebit.integrity.runner.forking;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public interface ForkCallback {

	void onSetVariableValue(String aQualifiedVariableName, Object aValue, boolean aDoSendUpdateFlag);

	void onForkExit(Fork aFork);

}
