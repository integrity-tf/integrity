/**
 * 
 */
package de.gebit.integrity.bindings.swing.basic;

import java.awt.Component;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import de.gebit.integrity.bindings.swing.AbstractSwingFixture;
import de.gebit.integrity.bindings.swing.AmbiguousComponentPathException;
import de.gebit.integrity.bindings.swing.EventQueueTimeoutException;
import de.gebit.integrity.bindings.swing.IntegritySwingBindingsException;
import de.gebit.integrity.bindings.swing.InvalidComponentPathException;
import de.gebit.integrity.fixtures.CustomProposalFixture;
import de.gebit.integrity.fixtures.FixtureMethod;
import de.gebit.integrity.fixtures.FixtureParameter;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class SwingButtonFixture extends AbstractSwingFixture implements CustomProposalFixture {

	@FixtureMethod(description = "Click the button '$name$'")
	public void clickButton(@FixtureParameter(name = COMPONENT_PATH_PARAMETER_NAME) String aComponentPath)
			throws AmbiguousComponentPathException, EventQueueTimeoutException, InvalidComponentPathException {
		final JButton tempButton = (JButton) findComponentGuarded(aComponentPath, JButton.class, null);

		runOnEventQueueAndWait(new Runnable() {

			@Override
			public void run() {
				tempButton.doClick();
			}
		});
	}

	@FixtureMethod(description = "Answer the dialog by clicking '$button$'")
	public void answerDialog(@FixtureParameter(name = "button") DialogButton aButton)
			throws IntegritySwingBindingsException {
		JDialog tempDialog = findFocusedDialogGuarded();
		List<Component> tempPanes = findComponentsInContainer(tempDialog, null, JOptionPane.class);
		if (tempPanes.size() == 0) {
			throw new IntegritySwingBindingsException("The dialog '" + tempDialog
					+ "' does not seem to be a JOptionPane-based dialog.");
		}

		JOptionPane tempOptionPane = (JOptionPane) tempPanes.get(0);
		switch (tempOptionPane.getOptionType()) {
		case JOptionPane.YES_NO_OPTION:
			switch (aButton) {

			}
		}

	}

	public static enum DialogButton {

		YES,

		NO,

		ABORT;

	}

}
