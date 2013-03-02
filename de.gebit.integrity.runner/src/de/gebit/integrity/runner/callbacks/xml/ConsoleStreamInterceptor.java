/**
 * 
 */
package de.gebit.integrity.runner.callbacks.xml;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/**
 * Intercepts STDOUT and STDERR and provides a method to access the intercepted lines.
 * 
 * @author Rene Schneider
 * 
 */
public class ConsoleStreamInterceptor {

	/**
	 * The original STDOUT stream.
	 */
	private PrintStream stdout;

	/**
	 * The interceptor stream for STDOUT.
	 */
	private InterceptPrintStream interceptStdout;

	/**
	 * The original STDERR stream.
	 */
	private PrintStream stderr;

	/**
	 * The interceptor stream for STDERR.
	 */
	private InterceptPrintStream interceptStderr;

	/**
	 * A sync object used to synchronize access to the interception buffer.
	 */
	private final Object interceptionBufferSync = new Object();

	/**
	 * The intercepted lines are collected in this buffer.
	 */
	private List<InterceptedLine> interceptionBuffer = new ArrayList<InterceptedLine>();

	/**
	 * Whether interception is temporarily paused. This flag is used for quick and lightweight interception pauses.
	 */
	private volatile boolean interceptPaused;

	/**
	 * Starts interception. This command hooks the normal stdout/err streams. Must be called at least once. May be
	 * called repeatedly without any effect.
	 */
	public void startIntercept() {
		if (interceptStdout == null) {
			stdout = System.out;
			interceptStdout = new InterceptPrintStream(stdout, false);
			System.setOut(interceptStdout);

			stderr = System.err;
			interceptStderr = new InterceptPrintStream(stderr, true);
			System.setErr(interceptStderr);
		}
	}

	/**
	 * Stops interception. Unhooks the streams. Must be called at some point in time if an interception has been
	 * started! Can be called repeatedly without any effect.
	 */
	public void stopIntercept() {
		if (interceptStdout != null) {
			System.setOut(stdout);
			interceptStdout = null;

			System.setErr(stderr);
			interceptStderr = null;
		}
	}

	/**
	 * Pauses interception. Streams are kept hooked; this command can thus be called often without negative effects on
	 * performance.
	 */
	public void pauseIntercept() {
		interceptPaused = true;
	}

	/**
	 * Resumes a paused interception.
	 */
	public void resumeIntercept() {
		interceptPaused = false;
	}

	/**
	 * Returns the list of captured lines. Lines are sorted by time. Calling this method clears the internal capture
	 * buffer, so each line will only be returned once!
	 * 
	 * @return the captured lines or an empty list if none were captured
	 */
	public List<InterceptedLine> retrieveLines() {
		synchronized (interceptionBufferSync) {
			interceptStdout.flushBufferedLine(false);
			interceptStderr.flushBufferedLine(false);

			List<InterceptedLine> tempBuffer = interceptionBuffer;
			interceptionBuffer = new ArrayList<InterceptedLine>();
			return tempBuffer;
		}
	}

	/**
	 * Represents a single captured line.
	 * 
	 * 
	 * @author Rene Schneider
	 * 
	 */
	public static class InterceptedLine {

		/**
		 * The text.
		 */
		private String text;

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

		public boolean isStdErr() {
			return stdErr;
		}

	}

	private class InterceptPrintStream extends PrintStream {

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

		public InterceptPrintStream(PrintStream aTarget, boolean anStdErrFlag) {
			super(aTarget);
			stdErr = anStdErrFlag;
		}

		public void flushBufferedLine(boolean aForceOnEmptyLine) {
			if (currentLine.length() > 0 || aForceOnEmptyLine) {
				String tempCurrentLine = currentLine.toString();
				currentLine = new StringBuilder();

				String[] tempSplitted = tempCurrentLine.split("(\\r\\n)|(\\r)|(\\n)");
				synchronized (interceptionBufferSync) {
					for (String tempPart : tempSplitted) {
						interceptionBuffer.add(new InterceptedLine(tempPart, stdErr));
					}
				}
			}
		}

		private void newLine() {
			if (!interceptPaused) {
				flushBufferedLine(true);
			}
		}

		public void appendToCurrentLine(String aText) {
			if (!interceptPaused) {
				currentLine.append(aText);
			}
		}

		@Override
		public void println(String aLine) {
			writingStringData = true;
			try {
				super.println(aLine);
				newLine();
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void println() {
			writingStringData = true;
			try {
				super.println();
				newLine();
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void println(Object anObject) {
			writingStringData = true;
			try {
				super.println(anObject);
				newLine();
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void println(boolean aBoolean) {
			writingStringData = true;
			try {
				super.println(aBoolean);
				newLine();
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void println(char aChar) {
			writingStringData = true;
			try {
				super.println(aChar);
				newLine();
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void println(char[] someChars) {
			writingStringData = true;
			try {
				super.println(someChars);
				newLine();
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void println(double aDouble) {
			writingStringData = true;
			try {
				super.println(aDouble);
				newLine();
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void println(float aFloat) {
			writingStringData = true;
			try {
				super.println(aFloat);
				newLine();
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void println(int anInteger) {
			writingStringData = true;
			try {
				super.println(anInteger);
				newLine();
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void println(long aLong) {
			writingStringData = true;
			try {
				super.println(aLong);
				newLine();
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
				if (!interceptPaused) {
					currentLine.append(aSequence);
				}
				return super.append(aSequence);
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public PrintStream append(CharSequence aSequence, int aStart, int anEnd) {
			writingStringData = true;
			try {
				if (!interceptPaused) {
					currentLine.append(aSequence, aStart, anEnd);
				}
				return super.append(aSequence, aStart, anEnd);
			} finally {
				writingStringData = false;
			}
		}

		@Override
		public void write(int aByte) {
			if (!writingStringData) {
				if (!interceptPaused) {
					currentLine.append((char) aByte);
				}
			}
			super.write(aByte);
		}

		@Override
		public void write(byte[] someBytes, int anOffset, int aLength) {
			if (!writingStringData) {
				if (!interceptPaused) {
					currentLine.append(new String(someBytes, anOffset, aLength));
				}
			}
			super.write(someBytes, anOffset, aLength);
		}

	}

}
