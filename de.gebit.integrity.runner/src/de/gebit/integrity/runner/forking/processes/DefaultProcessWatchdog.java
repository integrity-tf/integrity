/**
 * 
 */
package de.gebit.integrity.runner.forking.processes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import de.gebit.integrity.runner.forking.ForkedProcess;

/**
 * 
 * 
 * @author Slartibartfast
 * 
 */
public class DefaultProcessWatchdog implements ProcessWatchdog {

	protected List<ForkedProcess> forkedProcesses = Collections.synchronizedList(new ArrayList<ForkedProcess>());

	protected List<Process> processes = Collections.synchronizedList(new ArrayList<Process>());

	@Override
	public void registerFork(ForkedProcess aFork) {
		if (!forkedProcesses.contains(aFork)) {
			forkedProcesses.add(aFork);
		}
	}

	@Override
	public void unregisterFork(ForkedProcess aFork) {
		forkedProcesses.remove(aFork);
	}

	@Override
	public void registerProcess(Process aProcess) {
		if (!processes.contains(aProcess)) {
			processes.add(aProcess);
		}
	}

	@Override
	public void unregisterProcess(Process aProcess) {
		processes.remove(aProcess);
	}

	@Override
	public boolean killAndWait(int aTimeout) {
		Thread tempKillThread = new Thread() {

			public void run() {
				Iterator<ForkedProcess> tempForkIterator = forkedProcesses.iterator();
				while (tempForkIterator.hasNext()) {
					ForkedProcess tempFork = tempForkIterator.next();
					try {
						tempFork.kill();
						tempForkIterator.remove();
					} catch (InterruptedException exc) {
						exc.printStackTrace();
						return;
					}
				}

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

		return forkedProcesses.size() + processes.size() == 0;
	}

}
