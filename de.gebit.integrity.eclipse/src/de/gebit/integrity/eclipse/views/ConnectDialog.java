/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.eclipse.views;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;

/**
 *
 *
 * @author Rene Schneider - initial API and implementation
 *
 */
public class ConnectDialog extends InputDialog {

	/**
	 * Whether auto-retry was chosen.
	 */
	private boolean autoRetryEnabled;

	/**
	 * @param parentShell
	 * @param aDialogTitle
	 * @param aDialogMessage
	 * @param anInitialValue
	 * @param aValidator
	 */
	public ConnectDialog(Shell aParentShell, String anInitialValue, IInputValidator aValidator) {
		super(aParentShell, "Connect to test runner", "Please enter the hostname or IP address to connect to",
				anInitialValue, null);
	}

	@Override
	protected void createButtonsForButtonBar(Composite aParent) {
		super.createButtonsForButtonBar(aParent);

		createButton(aParent, IDialogConstants.RETRY_ID, "OK (retry)", false);
	}

	@Override
	protected void buttonPressed(int aButtonId) {
		if (aButtonId == IDialogConstants.RETRY_ID) {
			autoRetryEnabled = true;
			super.buttonPressed(IDialogConstants.OK_ID);
		} else {
			super.buttonPressed(aButtonId);
		}
	}

	public boolean isAutoRetryEnabled() {
		return autoRetryEnabled;
	}

}
