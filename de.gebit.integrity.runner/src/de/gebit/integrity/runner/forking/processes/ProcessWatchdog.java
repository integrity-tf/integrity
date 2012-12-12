/**
 * 
 */
package de.gebit.integrity.runner.forking.processes;

import de.gebit.integrity.runner.forking.ForkedProcess;

/**
 * 
 * 
 * @author Slartibartfast
 * 
 */
public interface ProcessWatchdog {

	void registerFork(ForkedProcess aFork);

	void unregisterFork(ForkedProcess aFork);

	void registerProcess(Process aProcess);

	void unregisterProcess(Process aProcess);

	boolean killAndWait(int aTimeout);

}
