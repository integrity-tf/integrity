/**
 * 
 */
package de.gebit.integrity.runner.console.intercept;

/**
 * Implement this interface to be able to receive intercepted console lines from the {@link ConsoleOutputInterceptor}.
 * 
 * @author Rene Schneider
 * 
 */
public interface ConsoleInterceptorTarget {

	/**
	 * Called for each intercepted line.
	 * 
	 * @param aLine
	 *            the line
	 * @param anStdErrFlag
	 *            whether the line was intercepted on stderr
	 */
	void onLine(String aLine, boolean anStdErrFlag);

}
