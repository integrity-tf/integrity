/**
 * 
 */
package de.gebit.integrity.bindings.swing;

import java.awt.Component;
import java.awt.Container;
import java.awt.Window;

import de.gebit.integrity.bindings.swing.authorassist.SwingAuthorAssistFrame;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class InvalidComponentPathException extends AbstractSwingComponentPathException {

	/**
	 * Serial Version.
	 */
	private static final long serialVersionUID = 9135172457237976659L;

	protected static final String INSET_PER_STEP = "  ";

	public InvalidComponentPathException(String aPath, AbstractSwingComponentHandler aComponentHandler) {
		super(aPath, aComponentHandler, "No component found for path '" + aPath + "'.");
	}

	@Override
	protected void buildDetailString(StringBuilder aStringBuilder, AbstractSwingComponentHandler aComponentHandler) {
		aStringBuilder.append("Current component hierarchy:" + NEWLINE);

		for (Window tempWindow : Window.getWindows()) {
			if (!SwingAuthorAssistFrame.class.isAssignableFrom(tempWindow.getClass())) {
				recursiveBuildComponentHierarchy(tempWindow, 0, aStringBuilder, aComponentHandler);
			}
		}
	}

	protected void recursiveBuildComponentHierarchy(Component aComponent, int aDepth, StringBuilder aStringBuilder,
			AbstractSwingComponentHandler aComponentHandler) {
		appendInset(aStringBuilder, aDepth);
		aStringBuilder.append("'" + aComponentHandler.createComponentPath(aComponent) + "' ");
		aStringBuilder.append(aComponentHandler.getPrettyComponentDescription(aComponent));
		aStringBuilder.append(NEWLINE);

		if (aComponent instanceof Container) {
			for (Component tempComponent : ((Container) aComponent).getComponents()) {
				recursiveBuildComponentHierarchy(tempComponent, aDepth + 1, aStringBuilder, aComponentHandler);
			}
		}
	}

	protected void appendInset(StringBuilder aStringBuilder, int aNumberOfTimes) {
		for (int i = 0; i < aNumberOfTimes; i++) {
			aStringBuilder.append(INSET_PER_STEP);
		}
	}
}
