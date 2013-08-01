/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.ui.formatting;

import java.io.IOException;
import java.io.InputStream;

/**
 * Automatically detects the line separator type used on a text file. Supports Mac OS (old), Linux/Unix and
 * Windows-style line breaks.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class LineSeparatorDetector {

	/**
	 * Maximum bytes to read before aborting line break detection.
	 */
	private int maxScanSize = 1024;

	/**
	 * Creates a new instance with default settings.
	 */
	public LineSeparatorDetector() {
		// does nothing
	}

	/**
	 * Creates a new instance.
	 * 
	 * @param aMaxScanSize
	 *            the maximum bytes to scan in a file before giving up
	 */
	public LineSeparatorDetector(int aMaxScanSize) {
		maxScanSize = aMaxScanSize;
	}

	/**
	 * Attempts to detect the line break type of the provided {@link InputStream}.
	 * 
	 * @param aStream
	 *            the stream to scan
	 * @return the detected line break type or null if no decision could be made
	 * @throws IOException
	 */
	public LineSeparatorType detectLineBreakType(InputStream aStream) throws IOException {
		int tempPrevious = 0;
		int tempCurrent = 0;
		int i = 0;

		do {
			tempPrevious = tempCurrent;
			tempCurrent = aStream.read();
			i++;

			if (tempPrevious == '\r') {
				if (tempCurrent == '\n') {
					return LineSeparatorType.WINDOWS;
				} else {
					return LineSeparatorType.MAC_OLD;
				}
			} else if (tempPrevious == '\n') {
				return LineSeparatorType.UNIX;
			}
		} while (tempPrevious != -1 && i < maxScanSize);

		return null;
	}

	/**
	 * The supported line break types.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	public static enum LineSeparatorType {

		/**
		 * Unix-style line endings.
		 */
		UNIX("\n"),

		/**
		 * Windows-style line endings.
		 */
		WINDOWS("\r\n"),

		/**
		 * Mac-OS-style line endings (pre-OS-X).
		 */
		MAC_OLD("\r");

		/**
		 * The line break.
		 */
		private String lineSeparatorChars;

		private LineSeparatorType(String aLineSeparatorChars) {
			lineSeparatorChars = aLineSeparatorChars;
		}

		public String getLineSeparatorChars() {
			return lineSeparatorChars;
		}

	}

}
