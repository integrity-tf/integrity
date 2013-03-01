/**
 * 
 */
package de.gebit.integrity.runner.callbacks.xml;

import java.io.PrintStream;
import java.util.ArrayList;
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
	 * Starts interception. Must be called at least once. May be called repeatedly without any effect.
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
	 * Stops interception. Must be called at some point in time if an interception has been started! Can be called
	 * repeatedly without any effect.
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
	 * Returns the list of captured lines. Lines are sorted by time. Calling this method clears the internal capture
	 * buffer, so each line will only be returned once!
	 * 
	 * @return the captured lines or an empty list if none were captured
	 */
	public List<InterceptedLine> retrieveLines() {
		synchronized (interceptionBufferSync) {
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
		private StringBuilder currentLine = new StringBuilder();

		public InterceptPrintStream(PrintStream aTarget, boolean anStdErrFlag) {
			super(aTarget);
			stdErr = anStdErrFlag;
		}

		private void newLine() {
			String tempCurrentLine = currentLine.toString();
			currentLine = new StringBuilder();

			String[] tempSplitted = tempCurrentLine.split("(\\r\\n)|(\\r)|(\\n)");
			synchronized (interceptionBufferSync) {
				for (String tempPart : tempSplitted) {
					interceptionBuffer.add(new InterceptedLine(tempPart, stdErr));
				}
			}
		}

		@Override
		public void println(String aLine) {
			super.println(aLine);
			newLine();
		}

		@Override
		public void println() {
			super.println();
			newLine();
		}

		@Override
		public void println(Object anObject) {
			super.println(anObject);
			newLine();
		}

		@Override
		public void println(boolean aBoolean) {
			super.println(aBoolean);
			newLine();
		}

		@Override
		public void println(char aChar) {
			super.println(aChar);
			newLine();
		}

		@Override
		public void println(char[] someChars) {
			super.println(someChars);
			newLine();
		}

		@Override
		public void println(double aDouble) {
			super.println(aDouble);
			newLine();
		}

		@Override
		public void println(float aFloat) {
			super.println(aFloat);
			newLine();
		}

		@Override
		public void println(int anInteger) {
			super.println(anInteger);
			newLine();
		}

		@Override
		public void println(long aLong) {
			super.println(aLong);
			newLine();
		}

		@Override
		public void print(String aString) {
			currentLine.append(aString);
			super.print(aString);
		}

		@Override
		public void print(char aChar) {
			currentLine.append(aChar);
			super.print(aChar);
		}

		@Override
		public void print(double aDouble) {
			currentLine.append(aDouble);
			super.print(aDouble);
		}

		@Override
		public void print(boolean aBoolean) {
			currentLine.append(aBoolean);
			super.print(aBoolean);
		}

		@Override
		public void print(int anInteger) {
			currentLine.append(anInteger);
			super.print(anInteger);
		}

		@Override
		public void print(long aLong) {
			currentLine.append(aLong);
			super.print(aLong);
		}

		@Override
		public void print(Object anObject) {
			currentLine.append(anObject);
			super.print(anObject);
		}

		@Override
		public void print(char[] someChars) {
			currentLine.append(someChars);
			super.print(someChars);
		}

		@Override
		public void print(float aFloat) {
			currentLine.append(aFloat);
			super.print(aFloat);
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
			currentLine.append(aChar);
			return super.append(aChar);
		}

		@Override
		public PrintStream append(CharSequence aSequence) {
			currentLine.append(aSequence);
			return super.append(aSequence);
		}

		@Override
		public PrintStream append(CharSequence aSequence, int aStart, int anEnd) {
			currentLine.append(aSequence, aStart, anEnd);
			return super.append(aSequence, aStart, anEnd);
		}

	}

}
