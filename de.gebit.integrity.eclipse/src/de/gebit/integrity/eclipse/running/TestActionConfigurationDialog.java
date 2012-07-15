/**
 * 
 */
package de.gebit.integrity.eclipse.running;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class TestActionConfigurationDialog extends Dialog {

	/**
	 * @param parentShell
	 */
	protected TestActionConfigurationDialog(IShellProvider aParentShell) {
		super(aParentShell);
	}

	public TestActionConfigurationDialog(Shell aParentShell) {
		super(aParentShell);
	}

	@Override
	public void create() {
		super.create();
	}

	@Override
	protected Control createDialogArea(Composite aParent) {
		GridLayout tempLayout = new GridLayout();
		tempLayout.numColumns = 2;

		List tempList = new List(aParent, SWT.NONE);
		GridData tempGrid = new GridData();
		tempGrid.horizontalAlignment = GridData.FILL;
		tempGrid.verticalAlignment = GridData.FILL;
		tempList.setLayoutData(tempGrid);

		Composite tempListActions = new Composite(aParent, SWT.NONE);

		Button tempAddButton = new Button(tempListActions, SWT.NONE);
		tempAddButton.setText("+");

		Button tempRemoveButton = new Button(tempListActions, SWT.NONE);
		tempRemoveButton.setText("-");

		return aParent;
	}

}
