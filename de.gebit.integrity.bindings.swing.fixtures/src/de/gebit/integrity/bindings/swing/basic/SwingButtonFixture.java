/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.bindings.swing.basic;

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
 * This fixture provides access to {@link JButton} components.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class SwingButtonFixture extends AbstractSwingFixture implements CustomProposalFixture {

	/**
	 * Clicks the button.
	 * 
	 * @param aComponentPath
	 *            the path to the component
	 * @throws AmbiguousComponentPathException
	 * @throws EventQueueTimeoutException
	 * @throws InvalidComponentPathException
	 */
	@FixtureMethod(description = "Click the button '$name$'")
	public void clickButton(@FixtureParameter(name = COMPONENT_PATH_PARAMETER_NAME) String aComponentPath)
			throws AmbiguousComponentPathException, EventQueueTimeoutException, InvalidComponentPathException {
		clickButton(findComponentGuarded(aComponentPath, JButton.class, null));
	}

	/**
	 * Answers the currently visible {@link JDialog} by clicking the given {@link DialogButton}.
	 * 
	 * @param aButton
	 *            the button to click
	 * @throws IntegritySwingBindingsException
	 * @throws EventQueueTimeoutException
	 */
	@FixtureMethod(description = "Answer the dialog by clicking '$button$'")
	public void answerDialog(@FixtureParameter(name = "button") DialogButton aButton)
			throws IntegritySwingBindingsException, EventQueueTimeoutException {
		JDialog tempDialog = findFocusedDialogGuarded();
		List<JOptionPane> tempPanes = findComponentsInContainer(tempDialog, null, JOptionPane.class);
		if (tempPanes.size() == 0) {
			throw new IntegritySwingBindingsException("The dialog '" + tempDialog
					+ "' does not seem to be a JOptionPane-based dialog.");
		}

		JOptionPane tempOptionPane = (JOptionPane) tempPanes.get(0);
		switch (tempOptionPane.getOptionType()) {
		case JOptionPane.YES_NO_CANCEL_OPTION:
			switch (aButton) {
			case YES:
				clickButton(findComponentsInContainer(tempOptionPane, null, JButton.class).get(0));
				return;
			case NO:
				clickButton(findComponentsInContainer(tempOptionPane, null, JButton.class).get(1));
				return;
			case CANCEL:
				clickButton(findComponentsInContainer(tempOptionPane, null, JButton.class).get(2));
				return;
			default:
				break;
			}
			break;
		case JOptionPane.YES_NO_OPTION:
			switch (aButton) {
			case YES:
				clickButton(findComponentsInContainer(tempOptionPane, null, JButton.class).get(0));
				return;
			case NO:
				clickButton(findComponentsInContainer(tempOptionPane, null, JButton.class).get(1));
				return;
			default:
				break;
			}
			break;
		case JOptionPane.OK_CANCEL_OPTION:
			switch (aButton) {
			case OK:
				clickButton(findComponentsInContainer(tempOptionPane, null, JButton.class).get(0));
				return;
			case CANCEL:
				clickButton(findComponentsInContainer(tempOptionPane, null, JButton.class).get(2));
				return;
			default:
				break;
			}
			break;
		default:
			break;
		}

		throw new IllegalArgumentException("The button '" + aButton + "' was not found in the active dialog.");
	}

	/**
	 * The standard responses available in the various {@link JDialog} dialog box variants.
	 * 
	 * 
	 * @author Rene Schneider - initial API and implementation
	 * 
	 */
	public static enum DialogButton {

		/**
		 * The "yes" button.
		 */
		YES,

		/**
		 * The "no" button.
		 */
		NO,

		/**
		 * The "OK" button.
		 */
		OK,

		/**
		 * The "Cancel" button.
		 */
		CANCEL;

	}

	/**
	 * Actually clicks the provided button on the AWT event queue and waits for the queue to process the event.
	 * 
	 * @param aButton
	 *            the button
	 * @throws EventQueueTimeoutException
	 */
	protected void clickButton(JButton aButton) throws EventQueueTimeoutException {
		runOnEventQueueAndWait(createButtonClickRunnable(aButton));
	}

	/**
	 * Creates the runnable to click the given button. The runnable is to be run on the Event Queue.
	 * 
	 * @param aButton
	 * @return the runnable
	 */
	protected Runnable createButtonClickRunnable(final JButton aButton) {
		return new Runnable() {

			@Override
			public void run() {
				aButton.doClick();
			}
		};
	}

}
