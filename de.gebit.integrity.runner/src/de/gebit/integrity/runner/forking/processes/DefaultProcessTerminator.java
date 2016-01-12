/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.forking.processes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.google.inject.Singleton;

import de.gebit.integrity.runner.forking.Fork;

/**
 * The standard process terminator implementation.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
@Singleton
public class DefaultProcessTerminator implements ProcessTerminator {

	/**
	 * List of all known forks.
	 */
	protected List<Fork> forks = new ArrayList<Fork>();

	/**
	 * List of all known generic processes.
	 */
	protected List<Process> processes = new ArrayList<Process>();

	/**
	 * We need to ignore deregistrations from outside during kill phases.
	 */
	protected boolean ignoreDeregistrations;

	@Override
	public void registerFork(Fork aFork) {
		synchronized (forks) {
			if (!forks.contains(aFork)) {
				forks.add(aFork);
			}
		}
	}

	@Override
	public void unregisterFork(Fork aFork) {
		if (ignoreDeregistrations) {
			return;
		}

		synchronized (forks) {
			forks.remove(aFork);
		}
	}

	@Override
	public void registerProcess(Process aProcess) {
		synchronized (processes) {
			if (!processes.contains(aProcess)) {
				processes.add(aProcess);
			}
		}
	}

	@Override
	public void unregisterProcess(Process aProcess) {
		if (ignoreDeregistrations) {
			return;
		}

		synchronized (processes) {
			processes.remove(aProcess);
		}
	}

	@Override
	public boolean killAndWait(int aTimeout) {
		Thread tempKillThread = new Thread("Process Terminator Thread") {

			public void run() {
				try {
					ignoreDeregistrations = true;

					synchronized (forks) {
						Iterator<Fork> tempForkIterator = forks.iterator();
						while (tempForkIterator.hasNext()) {
							Fork tempFork = tempForkIterator.next();
							try {
								tempFork.kill();
								tempForkIterator.remove();
							} catch (InterruptedException exc) {
								exc.printStackTrace();
								return;
							}
						}
					}

					synchronized (processes) {
						Iterator<Process> tempProcessIterator = processes.iterator();
						while (tempProcessIterator.hasNext()) {
							try {
								Process tempProcess = tempProcessIterator.next();
								tempProcess.destroy();
								tempProcess.waitFor();
								tempProcessIterator.remove();
							} catch (InterruptedException exc) {
								exc.printStackTrace();
								return;
							}
						}
					}

				} finally {
					ignoreDeregistrations = false;
				}
			}

		};

		tempKillThread.start();

		try {
			tempKillThread.join(aTimeout);
			if (tempKillThread.isAlive()) {
				tempKillThread.interrupt();
			}
		} catch (InterruptedException exc) {
			exc.printStackTrace();
		}

		return forks.size() + processes.size() == 0;
	}

}
