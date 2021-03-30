/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.forking.processes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
		Thread tempKillThread = new Thread("Integrity - Process Terminator Thread") {

			@Override
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
						// Kill processes in reverse registration order. This is because we assume processes started
						// later to potentially depend on processes starting first, hence killing them in reverse order
						// may save us from "oops, that other process I depend on has just vanished" messages printed in
						// the last seconds of life of a later-started process.
						Collections.reverse(processes);

						Iterator<Process> tempProcessIterator = processes.iterator();
						while (tempProcessIterator.hasNext()) {
							try {
								Process tempProcess = tempProcessIterator.next();
								tempProcess.destroy();
								if (!tempProcess.waitFor(10, TimeUnit.SECONDS)) {
									tempProcess.destroyForcibly();
									if (!tempProcess.waitFor(30, TimeUnit.SECONDS)) {
										System.err.println("Failed to terminate a process on shutdown - "
												+ "there may be lingering zombie processes after this test runner terminates");
									}
								}
							} catch (InterruptedException exc) {
								// ignored
							}
							tempProcessIterator.remove();
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
