/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider (GEBIT Solutions GmbH) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.runner.console.intercept;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import com.google.inject.Singleton;

/**
 * Default implementation of a console output interceptor. Hooks the System.out and System.err streams to do its work,
 * thus it is critical that there's only one instance of this service in a given JVM. This imlementation automatically
 * hooks the streams when at least one target is registered, and unhooks them when the last target unregisters.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
@Singleton
public class DefaultConsoleOutputInterceptor implements ConsoleOutputInterceptor {

	/**
	 * A sync object used to synchronize interception target access.
	 */
	protected final Object targetSync = new Object();

	/**
	 * The interception targets.
	 */
	protected List<ConsoleInterceptorTarget> targets = new ArrayList<ConsoleInterceptorTarget>();

	/**
	 * The original STDOUT stream.
	 */
	protected final PrintStream stdout = System.out;

	/**
	 * The interceptor stream for STDOUT.
	 */
	protected InterceptPrintStream interceptStdout;

	/**
	 * The original STDERR stream.
	 */
	protected final PrintStream stderr = System.err;

	/**
	 * The interceptor stream for STDERR.
	 */
	protected InterceptPrintStream interceptStderr;

	/**
	 * Reevaluates whether the streams are to be captured at the time of calling, and hooks or unhooks the streams as
	 * necessary.
	 */
	protected void updateStreamCapture() {
		if (targets.size() > 0 && interceptStdout == null) {
			interceptStdout = new InterceptPrintStream(stdout, false);
			System.setOut(interceptStdout);

			interceptStderr = new InterceptPrintStream(stderr, true);
			System.setErr(interceptStderr);
		} else if (targets.size() == 0 && interceptStdout != null) {
			System.setOut(stdout);
			interceptStdout = null;

			System.setErr(stderr);
			interceptStderr = null;
		}
	}

	@Override
	public void registerTarget(ConsoleInterceptorTarget aTarget) {
		synchronized (targetSync) {
			if (!targets.contains(aTarget)) {
				targets.add(aTarget);
				updateStreamCapture();
			}
		}
	}

	@Override
	public void unregisterTarget(ConsoleInterceptorTarget aTarget) {
		synchronized (targetSync) {
			if (targets.contains(aTarget)) {
				targets.remove(aTarget);
				updateStreamCapture();
			}
		}
	}

	@Override
	public void printlnStdErr(String aLine) {
		stderr.println(aLine);
		stderr.flush();
	}

	@Override
	public void printStdErr(String aText) {
		stderr.print(aText);
	}

	@Override
	public void printlnStdOut(String aLine) {
		stdout.println(aLine);
		stdout.flush();
	}

	@Override
	public void printStdOut(String aText) {
		stdout.print(aText);
	}

	/**
	 * This stream is the core of this service: it captures all data being printed through it, splits it into single
	 * lines and forwards the lines to all targets.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	protected class InterceptPrintStream extends PrintStream {

		/**
		 * Whether this interceptor is capturing STDERR.
		 */
		private boolean stdErr;

		/**
		 * The currently captured line.
		 */
		private volatile StringBuilder currentLine = new StringBuilder();

		/**
		 * Flag used to prevent data captured in the print() methods from being captured again after it was encoded to
		 * bytes and passed on to the write() methods. Theoretically it would be sufficient to just hook the write
		 * methods, but data captured from those must be converted back to strings again, which is rather inefficient
		 * and can create encoding problems.
		 */
		private boolean writingStringData;

		/**
		 * Creates a new instance.
		 * 
		 * @param aTarget
		 *            the actual stream which is to receive everything
		 * @param anStdErrFlag
		 *            whether this stream is used to intercept stderr
		 */
		public InterceptPrintStream(PrintStream aTarget, boolean anStdErrFlag) {
			super(aTarget);
			stdErr = anStdErrFlag;
		}

		/**
		 * Flushes the current line to the targets, splitting it into single lines in the process. This does not flush
		 * if the line is entirely empty, but it will flush incomplete lines as well.
		 */
		public void flushBufferedLine() {
			try {
				synchronized (currentLine) {
					if (currentLine.length() > 0) {
						String tempCurrentLine = currentLine.toString();
						currentLine = new StringBuilder();

						String[] tempSplitted = tempCurrentLine.split("(\\r\\n)|(\\r)|(\\n)");
						synchronized (targetSync) {
							for (String tempPart : tempSplitted) {
								for (ConsoleInterceptorTarget tempTarget : targets) {
									tempTarget.onLine(tempPart, stdErr);
								}
							}
						}
					}
				}
				// SUPPRESS CHECKSTYLE IllegalCatch
			} catch (Throwable exc) {
				// caught here to prevent errors in the interceptor from harming the intercepted application
				exc.printStackTrace();
			}
		}

		private void appendToCurrentLine(String aText) {
			try {
				synchronized (currentLine) {
					currentLine.append(aText);
					flushIfNecessary();
				}
				// SUPPRESS CHECKSTYLE IllegalCatch
			} catch (Throwable exc) {
				// caught here to prevent errors in the interceptor from harming the intercepted application
				exc.printStackTrace();
			}
		}

		/**
		 * Flushes the current line to the targets, but only if it ends with a newline and can thus be considered
		 * "complete".
		 */
		public void flushIfNecessary() {
			try {
				synchronized (currentLine) {
					if (currentLine.length() > 0) {
						char tempLastChar = currentLine.charAt(currentLine.length() - 1);
						if (tempLastChar == '\r' || tempLastChar == '\n') {
							flushBufferedLine();
						}
					}
				}
				// SUPPRESS CHECKSTYLE IllegalCatch
			} catch (Throwable exc) {
				// caught here to prevent errors in the interceptor from harming the intercepted application
				exc.printStackTrace();
			}
		}

		@Override
		public void println(String aLine) {
			writingStringData = true;
			try {
				super.println(aLine);
				flushIfNecessary();
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void println() {
			writingStringData = true;
			try {
				super.println();
				flushIfNecessary();
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void println(Object anObject) {
			writingStringData = true;
			try {
				super.println(anObject);
				flushIfNecessary();
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void println(boolean aBoolean) {
			writingStringData = true;
			try {
				super.println(aBoolean);
				flushIfNecessary();
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void println(char aChar) {
			writingStringData = true;
			try {
				super.println(aChar);
				flushIfNecessary();
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void println(char[] someChars) {
			writingStringData = true;
			try {
				super.println(someChars);
				flushIfNecessary();
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void println(double aDouble) {
			writingStringData = true;
			try {
				super.println(aDouble);
				flushIfNecessary();
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void println(float aFloat) {
			writingStringData = true;
			try {
				super.println(aFloat);
				flushIfNecessary();
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void println(int anInteger) {
			writingStringData = true;
			try {
				super.println(anInteger);
				flushIfNecessary();
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void println(long aLong) {
			writingStringData = true;
			try {
				super.println(aLong);
				flushIfNecessary();
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void print(String aString) {
			writingStringData = true;
			try {
				appendToCurrentLine(aString);
				super.print(aString);
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void print(char aChar) {
			writingStringData = true;
			try {
				appendToCurrentLine(Character.toString(aChar));
				super.print(aChar);
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void print(double aDouble) {
			writingStringData = true;
			try {
				appendToCurrentLine(Double.toString(aDouble));
				super.print(aDouble);
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void print(boolean aBoolean) {
			writingStringData = true;
			try {
				appendToCurrentLine(Boolean.toString(aBoolean));
				super.print(aBoolean);
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void print(int anInteger) {
			writingStringData = true;
			try {
				appendToCurrentLine(Integer.toString(anInteger));
				super.print(anInteger);
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void print(long aLong) {
			writingStringData = true;
			try {
				appendToCurrentLine(Long.toString(aLong));
				super.print(aLong);
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void print(Object anObject) {
			writingStringData = true;
			try {
				appendToCurrentLine("" + anObject);
				super.print(anObject);
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void print(char[] someChars) {
			writingStringData = true;
			try {
				appendToCurrentLine(Arrays.toString(someChars));
				super.print(someChars);
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void print(float aFloat) {
			writingStringData = true;
			try {
				appendToCurrentLine(Float.toString(aFloat));
				super.print(aFloat);
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public PrintStream printf(String aFormat, Object... someArgs) {
			return super.printf(aFormat, someArgs);
		}

		@Override
		public PrintStream printf(Locale aLocale, String aFormat, Object... someArgs) {
			return super.printf(aLocale, aFormat, someArgs);
		}

		@Override
		public PrintStream format(Locale aLocale, String aFormat, Object... someArgs) {
			return super.format(aLocale, aFormat, someArgs);
		}

		@Override
		public PrintStream format(String aFormat, Object... someArgs) {
			return super.format(aFormat, someArgs);
		}

		@Override
		public PrintStream append(char aChar) {
			writingStringData = true;
			try {
				appendToCurrentLine(Character.toString(aChar));
				return super.append(aChar);
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public PrintStream append(CharSequence aSequence) {
			writingStringData = true;
			try {
				appendToCurrentLine(aSequence == null ? "null" : aSequence.toString());
				return super.append(aSequence);
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public PrintStream append(CharSequence aSequence, int aStart, int anEnd) {
			writingStringData = true;
			try {
				appendToCurrentLine(aSequence == null ? "null" : aSequence.subSequence(aStart, anEnd).toString());
				return super.append(aSequence, aStart, anEnd);
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void write(int aByte) {
			if (!writingStringData) {
				appendToCurrentLine(Character.toString((char) aByte));
			}
			super.write(aByte);
		}

		@Override
		public void write(byte[] someBytes, int anOffset, int aLength) {
			if (!writingStringData) {
				appendToCurrentLine(new String(someBytes, anOffset, aLength));
			}
			super.write(someBytes, anOffset, aLength);
		}

	}
}
