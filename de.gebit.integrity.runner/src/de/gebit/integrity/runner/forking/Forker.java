/**
 * 
 */
package de.gebit.integrity.runner.forking;

/**
 * A forker is an implementation of an execution forking mechanism. Its task is to create another process, which ideally
 * is an exact clone of the current (parent) process. The idea is similar to a UNIX fork, but the child process is
 * expected to start "fresh" instead of continuing at the current instruction.
 * 
 * @author Rene Schneider
 * 
 */
public interface Forker {

	/**
	 * System parameter name for the remoting port to use to communicate with the fork.
	 */
	String SYSPARAM_FORK_REMOTING_PORT = "integrity.fork.port";

	/**
	 * System parameter name for the fork name.
	 */
	String SYSPARAM_FORK_NAME = "integrity.fork.name";

	/**
	 * Performs the actual forking.
	 * 
	 * @param someCommandLineArguments
	 *            the original command line arguments given to the JVM of the parent process
	 * @param aPortNumber
	 *            the port number to use for remoting to the new fork
	 * @param aForkName
	 *            the name of the fork
	 * @return the newly created process
	 * @throws ForkException
	 *             if something goes wrong
	 */
	ForkedProcess fork(String[] someCommandLineArguments, int aPortNumber, String aForkName) throws ForkException;

}
