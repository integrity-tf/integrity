/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.bindings.swing.authorassist;

import de.gebit.integrity.bindings.swing.AbstractSwingFixture;
import de.gebit.integrity.fixtures.FixtureMethod;

/**
 * This fixture provides the author assist tool. Call {@link #authorAssist()} from Integrity scripts to invoke this
 * tool.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class SwingAuthorAssistFixture extends AbstractSwingFixture {

	/**
	 * Set this system property to "yes" in order to prevent the author assist tool from appearing. Useful for example
	 * for build environments to guard against an accidentially forgotten call to the tools in the test scripts.
	 */
	public static final String NO_AUTHOR_ASSIST_TOOLS_SYSPROPERTY = "integrity.swing.noAuthorAssist";

	/**
	 * Displays the author assist tools and pauses test execution. This call will return as soon as the tools frame is
	 * closed.
	 */
	@FixtureMethod(description = "Displays the test author assistance tools and pauses test execution")
	public void authorAssist() {
		if (System.getProperty(NO_AUTHOR_ASSIST_TOOLS_SYSPROPERTY) != null) {
			System.out.println("AUTHOR ASSIST TOOLS WERE DEACTIVATED! SKIPPING INVOCATION!");
			return;
		}

		showAssistFrame();
	}

	/**
	 * Show the assistance frame and wait for it to close.
	 */
	protected void showAssistFrame() {
		SwingAuthorAssistFrame tempAssistFrame = new SwingAuthorAssistFrame(this);

		tempAssistFrame.setVisible(true);

		tempAssistFrame.waitForClose();
	}

}
