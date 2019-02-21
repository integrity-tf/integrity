/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.logging;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import de.gebit.integrity.fixtures.logging.FixtureLogLevel;

/**
 * Represents a single log line of the {@link DefaultFixtureLogger}.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class LogLine {

	/**
	 * The text.
	 */
	protected String text;

	/**
	 * The timestamp at which this line was logged.
	 */
	protected long timestamp = System.currentTimeMillis();

	/**
	 * The level at which the line was logged.
	 */
	protected FixtureLogLevel level;

	/**
	 * The timestamp format for stringification of this log line.
	 */
	protected static final DateFormat TIMESTAMP_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

	/**
	 * Creates a new instance.
	 * 
	 * @param aText
	 *            the text
	 * @param aLevel
	 *            the level at which the line was logged
	 */
	public LogLine(String aText, FixtureLogLevel aLevel) {
		text = aText;
		level = aLevel;
	}

	public String getText() {
		return text;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public FixtureLogLevel getLevel() {
		return level;
	}

	@Override
	public String toString() {
		return TIMESTAMP_FORMAT.format(new Date(timestamp)) + " | " + level.getPaddedName() + " | " + text;
	}

}