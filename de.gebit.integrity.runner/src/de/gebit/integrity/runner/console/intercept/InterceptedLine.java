/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.console.intercept;

/**
 * Represents a single captured line of the {@link ConsoleInterceptionAggregator}.
 * 
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class InterceptedLine {

	/**
	 * The text.
	 */
	private String text;

	/**
	 * The timestamp at which this line was captured.
	 */
	private long timestamp = System.currentTimeMillis();

	/**
	 * Whether the line was captured from STDERR.
	 */
	private boolean stdErr;

	/**
	 * Creates a new instance.
	 * 
	 * @param aText
	 *            the text
	 * @param anStdErrFlag
	 *            whether the line was captured from STDERR
	 */
	public InterceptedLine(String aText, boolean anStdErrFlag) {
		text = aText;
		stdErr = anStdErrFlag;
	}

	public String getText() {
		return text;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public boolean isStdErr() {
		return stdErr;
	}

}