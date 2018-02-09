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
 * A forked process implementation that wraps a local process.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class LocalForkedProcess implements ForkedProcess {

	/**
	 * The OS process encapsulated.
	 */
	protected Process process;

	/**
	 * Creates a new instance.
	 * 
	 * @param aProcess
	 *            the process to wrap
	 */
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

	@Override
	public String getHost() {
		throw new UnsupportedOperationException("Not supported; host/port is communicated via STDOUT.");
	}

	@Override
	public int getPort() {
		throw new UnsupportedOperationException("Not supported; host/port is communicated via STDOUT.");
	}

}
