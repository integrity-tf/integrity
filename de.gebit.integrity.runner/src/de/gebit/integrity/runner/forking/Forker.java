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

	final String ENV_FORK_REMOTING_PORT = "forkRemotingPort";

	Process fork(String[] someCommandLineArguments, int aPortNumber) throws ForkException;

}
