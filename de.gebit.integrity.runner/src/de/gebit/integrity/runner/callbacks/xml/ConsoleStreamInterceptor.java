/**
 * 
 */
package de.gebit.integrity.runner.callbacks.xml;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class ConsoleStreamInterceptor {

	private PrintStream stdout;

	private InterceptPrintStream interceptStdout;

	private PrintStream stderr;

	private InterceptPrintStream interceptStderr;

	private Object interceptionBufferSync = new Object();

	private List<InterceptedLine> interceptionBuffer = new ArrayList<InterceptedLine>();

	public ConsoleStreamInterceptor() {

	}

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

	public void stopIntercept() {
		if (interceptStdout != null) {
			System.setOut(stdout);
			interceptStdout = null;

			System.setErr(stderr);
			interceptStderr = null;
		}
	}

	public List<InterceptedLine> retrieveLines() {
		synchronized (interceptionBufferSync) {
			List<InterceptedLine> tempBuffer = interceptionBuffer;
			interceptionBuffer = new ArrayList<InterceptedLine>();
			return tempBuffer;
		}
	}

	/**
	 * 
	 * 
	 * 
	 * @author Rene Schneider
	 * 
	 */
	public static class InterceptedLine {

		private String text;

		private boolean stdErr;

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

		private PrintStream target;

		private boolean stdErr;

		private StringBuilder currentLine = new StringBuilder();

		public InterceptPrintStream(PrintStream aTarget, boolean anStdErrFlag) {
			super(aTarget);
			target = aTarget;
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

		// @Override
		// public void write(byte[] someBytes, int anOffset, int aLength) {
		// if (anOffset != 0 || aLength != someBytes.length) {
		// byte[] tempBytes = new byte[aLength];
		// System.arraycopy(someBytes, anOffset, tempBytes, 0, aLength);
		// currentLine.append(tempBytes);
		// } else {
		// currentLine.append(someBytes);
		// }
		//
		// super.write(someBytes, anOffset, aLength);
		// }
		//
		// @Override
		// public void write(byte[] someBytes) throws IOException {
		// super.write(someBytes); // calls the write method above
		// }
		//
		// @Override
		// public void write(int aByte) {
		// currentLine.append((char) aByte);
		// super.write(aByte);
		// }

	}

}
