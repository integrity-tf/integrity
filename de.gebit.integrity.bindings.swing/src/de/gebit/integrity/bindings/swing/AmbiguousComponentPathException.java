/**
 * 
 */
package de.gebit.integrity.bindings.swing;

import java.awt.Component;
import java.awt.Window;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.List;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class AmbiguousComponentPathException extends Exception {

	private String ambiguousPath;

	private List<Component> components;

	private StringBuilder detailString;

	private static final String NEWLINE = System.getProperty("line.separator");

	private static final String PREFIX = "      in ";

	public AmbiguousComponentPathException(String aPath, List<Component> someComponents,
			AbstractSwingComponentHandler aComponentHandler) {
		super("Component path '" + aPath + "' is ambiguous (" + someComponents.size() + " matches)");
		ambiguousPath = aPath;
		components = someComponents;

		detailString = new StringBuilder();

		int tempCount = 0;
		for (Component tempComponent : someComponents) {
			tempCount++;
			detailString.append(tempCount + ": ");
			String tempPath = aComponentHandler.createComponentPath(tempComponent);
			String tempUniquifiedPath = aComponentHandler.createUniquifiedComponentPath(tempComponent);
			detailString.append(tempPath + " (" + tempUniquifiedPath + ")");
			detailString.append(NEWLINE);

			Component tempComponentInFocus = tempComponent.getParent();
			while (tempComponentInFocus != null) {
				detailString.append(PREFIX);
				detailString.append(aComponentHandler.getPrettyComponentDescription(tempComponentInFocus));
				detailString.append(NEWLINE);

				if (tempComponentInFocus instanceof Window) {
					break;
				}
				tempComponentInFocus = tempComponentInFocus.getParent();
			}
		}
	}

	public String getAmbiguousPath() {
		return ambiguousPath;
	}

	public List<Component> getComponents() {
		return components;
	}

	public StringBuilder getDetailString() {
		return detailString;
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
