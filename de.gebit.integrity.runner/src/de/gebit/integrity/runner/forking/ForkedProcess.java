/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.forking;

import java.io.InputStream;

/**
 * Interface for a forked process. Instances of implementations of this interface embody power to influence and
 * communicate with the forked process on a limited scale. It is actually not important if that process resides on the
 * local machine or anywhere else, like on another machine on the network, as long as the required interaction is
 * somehow made possible.<br>
 * <br>
 * Not all methods are actually required; quite some only serve to improve the interaction between master and fork
 * processes. Refer to the remarks at each method to find whether a functionality is optional.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public interface ForkedProcess {

	/**
	 * Checks whether the forked process is up and running. This is a mandatory method.
	 * 
	 * @return true if the process is running, false if it has ended or not even started (for example due to an error)
	 */
	boolean isAlive();

	/**
	 * Kills the forked process, if it is running, and waits for it to exit.<br>
	 * <br>
	 * This functionality is not strictly required, since a test runner process should always end itself after finishing
	 * all its tests, which then leads to the forks automatically exiting gracefully after doing their duty as well. But
	 * in case a fork got started, but it is impossible for the main process to create a remoting connection to it, the
	 * main process will call this method in order to ensure clean termination of the forked process, which would
	 * otherwise sit there forever and wait for its master to connect.
	 */
	void kill() throws InterruptedException;

	/**
	 * Returns the stream carrying standard output (STDOUT) of the process. Supporting this kind of communication is
	 * optional.
	 * 
	 * @return a ready-to-be-read {@link InputStream} or null if this is not supported by the forked process
	 */
	InputStream getInputStream();

	/**
	 * Returns the stream carrying standard error (STDERR) of the process. Supporting this kind of communication is
	 * optional.
	 * 
	 * @return a ready-to-be-read {@link InputStream} or null if this is not supported by the forked process
	 */
	InputStream getErrorStream();

	/**
	 * Returns the network host name where this process is running. In case of local processes, "localhost" shall be
	 * returned, but distributed processes on other machines might of course return different values. This is a
	 * mandatory method.
	 * 
	 * @return the network host name where the process is running
	 */
	String getHost();

	/**
	 * Returns the port where this processes' Integrity Test Runner is open for management connections. This is a
	 * mandatory method.
	 * 
	 * @return the remoting port of the test runner
	 */
	int getPort();

}
