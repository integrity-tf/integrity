/**
 * 
 */
package de.gebit.integrity.runner.forking;

import java.io.InputStream;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class LocalForkedProcess implements ForkedProcess {

	/**
	 * The OS process encapsulated.
	 */
	protected Process process;

	public LocalForkedProcess(Process aProcess) {
		process = aProcess;
	}

	@Override
	public boolean isAlive() {
		boolean tempIsAlive = false;
		try {
			process.exitValue();
		} catch (IllegalThreadStateException exc) {
			tempIsAlive = true;
		}
		return tempIsAlive;
	}

	@Override
	public void kill() {
		process.destroy();
	}

	@Override
	public InputStream getInputStream() {
		return process.getInputStream();
	}

	@Override
	public InputStream getErrorStream() {
		return process.getErrorStream();
	}

}
