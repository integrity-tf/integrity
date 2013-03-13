/**
 * 
 */
package de.gebit.integrity.bindings.swing;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public abstract class AbstractSwingComponentPathException extends Exception {

	/**
	 * Serial Version.
	 */
	private static final long serialVersionUID = -9106012024572041003L;

	private String path;

	private StringBuilder detailString;

	private AbstractSwingComponentHandler componentHandler;

	protected static final String NEWLINE = System.getProperty("line.separator");

	protected static final String PREFIX = "      in ";

	public AbstractSwingComponentPathException(String aPath, AbstractSwingComponentHandler aComponentHandler,
			String aMessage) {
		super(aMessage);
		path = aPath;
		componentHandler = aComponentHandler;
	}

	protected abstract void buildDetailString(StringBuilder aStringBuilder,
			AbstractSwingComponentHandler aComponentHandler);

	public String getPath() {
		return path;
	}

	public String getDetailString() {
		if (detailString == null) {
			detailString = new StringBuilder();
			buildDetailString(detailString, componentHandler);
		}

		return detailString.toString();
	}

	public void printActualStackTrace() {
		super.printStackTrace();
	}

	public void printActualStackTrace(PrintStream aStream) {
		super.printStackTrace(aStream);
	}

	public void printActualStackTrace(PrintWriter aWriter) {
		super.printStackTrace(aWriter);
	}

	@Override
	public void printStackTrace() {
		printMessageAndDetails();
	}

	public void printStackTrace(PrintStream aStream) {
		printMessageAndDetails(aStream);
	}

	@Override
	public void printStackTrace(PrintWriter aWriter) {
		printMessageAndDetails(aWriter);
	}

	public void printMessageAndDetails(PrintWriter aWriter) {
		aWriter.println(getClass().getName() + ": " + getMessage());
		aWriter.println("");
		aWriter.print(getDetailString());
	}

	public void printMessageAndDetails(PrintStream aStream) {
		aStream.println(getClass().getName() + ": " + getMessage());
		aStream.println("");
		aStream.print(getDetailString());
	}

	public void printMessageAndDetails() {
		printMessageAndDetails(System.err);
	}

}
