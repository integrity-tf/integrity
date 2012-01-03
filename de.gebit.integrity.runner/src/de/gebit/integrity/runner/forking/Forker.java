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
public interface Forker {

	final String ENV_FORK_REMOTING_PORT = "integrity.fork.port";

	final String ENV_FORK_NAME = "integrity.fork.name";

	Process fork(String[] someCommandLineArguments, int aPortNumber, String aForkName) throws ForkException;

}
