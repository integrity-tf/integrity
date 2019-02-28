/*******************************************************************************
 * Copyright (c) 2019 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.logging;

import java.util.List;

import de.gebit.integrity.fixtures.logging.FixtureLogger;

/**
 * A sub-interface of {@link FixtureLogger} which aggregates the log messages and provides methods to retrieve them.
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public interface AggregatingFixtureLogger extends FixtureLogger {

	/**
	 * Clears any lines currently stored in the logger.
	 */
	void clearLines();

	/**
	 * Returns the currently aggregated log lines, but does NOT clear the buffer. This method guarantees to return a
	 * finalized collection that will not be modified anymore by the aggregator.
	 * 
	 * @return the logged lines
	 */
	List<LogLine> getLines();

}
