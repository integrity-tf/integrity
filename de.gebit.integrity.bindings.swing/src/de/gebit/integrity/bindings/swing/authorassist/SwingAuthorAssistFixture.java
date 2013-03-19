/**
 * 
 */
package de.gebit.integrity.bindings.swing.authorassist;

import de.gebit.integrity.bindings.swing.AbstractSwingFixture;
import de.gebit.integrity.fixtures.FixtureMethod;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class SwingAuthorAssistFixture extends AbstractSwingFixture {

	public static final String NO_AUTHOR_ASSIST_TOOLS_SYSPROPERTY = "integrity.swing.noAuthorAssist";

	@FixtureMethod(description = "Displays the test author assistance tools and pauses test execution")
	public void authorAssist() {
		if (System.getProperty(NO_AUTHOR_ASSIST_TOOLS_SYSPROPERTY) != null) {
			System.out.println("AUTHOR ASSIST TOOLS WERE DEACTIVATED! SKIPPING INVOCATION!");
			return;
		}

		showAssistFrame();
	}

	protected void showAssistFrame() {
		SwingAuthorAssistFrame tempAssistFrame = new SwingAuthorAssistFrame(this);

		tempAssistFrame.setVisible(true);

		tempAssistFrame.waitForClose();
	}

}
