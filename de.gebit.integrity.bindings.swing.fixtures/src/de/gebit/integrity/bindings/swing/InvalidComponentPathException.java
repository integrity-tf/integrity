/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.bindings.swing;

import java.awt.Component;
import java.awt.Container;
import java.awt.Window;

import de.gebit.integrity.bindings.swing.authorassist.SwingAuthorAssistFrame;

/**
 * Thrown if no matching component was found for a given component path. This exception contains human-readable detail
 * info which lay out the whole component graph in readable form, optimized to help identifying the problem in the path.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class InvalidComponentPathException extends AbstractSwingComponentPathException {

	/**
	 * Serial Version.
	 */
	private static final long serialVersionUID = 9135172457237976659L;

	/**
	 * The inset to be added in front of every line, per depth step.
	 */
	protected static final String INSET_PER_STEP = "  ";

	/**
	 * Constructs a new instance.
	 * 
	 * @param aPath
	 *            the path
	 * @param aComponentHandler
	 *            the component handler
	 */
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

	private void recursiveBuildComponentHierarchy(Component aComponent, int aDepth, StringBuilder aStringBuilder,
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

	private void appendInset(StringBuilder aStringBuilder, int aNumberOfTimes) {
		for (int i = 0; i < aNumberOfTimes; i++) {
			aStringBuilder.append(INSET_PER_STEP);
		}
	}
}
