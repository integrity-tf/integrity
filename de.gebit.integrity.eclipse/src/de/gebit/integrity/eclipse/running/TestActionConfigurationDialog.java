/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.eclipse.running;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.debug.ui.DebugUITools;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.window.IShellProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;

import de.gebit.integrity.eclipse.Activator;

/**
 * The configuration dialog for the "launch-and-connect" feature.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class TestActionConfigurationDialog extends Dialog {

	/**
	 * The launch configurations found in the workspace.
	 */
	private Map<ILaunchConfigurationType, List<ILaunchConfiguration>> launchConfigurations = new HashMap<>();

	/**
	 * The list that displays all launch configurations.
	 */
	private TreeViewer launchConfigList;

	/**
	 * The selected launch config.
	 */
	private ILaunchConfiguration selectedConfiguration;

	/**
	 * The pre-selected configuration on open.
	 */
	private ILaunchConfiguration preselectedConfiguration;

	/**
	 * Creates a new instance.
	 * 
	 * @param parentShell
	 */
	protected TestActionConfigurationDialog(IShellProvider aParentShell) {
		super(aParentShell);
	}

	/**
	 * Creates a new instance.
	 * 
	 * @param aParentShell
	 */
	public TestActionConfigurationDialog(Shell aParentShell, ILaunchConfiguration aPreselectedConfiguration) {
		super(aParentShell);
		preselectedConfiguration = aPreselectedConfiguration;
		selectedConfiguration = aPreselectedConfiguration;
	}

	@Override
	public void create() {
		setShellStyle(getShellStyle() | SWT.RESIZE);
		super.create();
	}

	@Override
	protected void initializeBounds() {
		super.initializeBounds();

		IDialogSettings tempSettings = Activator.getInstance().getDialogSettings()
				.getSection(TestActionConfigurationDialog.class.getName());
		int tempWidth = 400;
		int tempHeight = 500;
		if (tempSettings != null) {
			try {
				tempWidth = tempSettings.getInt("width");
				tempHeight = tempSettings.getInt("height");
			} catch (NumberFormatException exc) {
				exc.printStackTrace();
				tempWidth = 400;
				tempHeight = 500;
			}
		} else {
			tempSettings = Activator.getInstance().getDialogSettings()
					.addNewSection(TestActionConfigurationDialog.class.getName());
			tempSettings.put("width", tempWidth);
			tempSettings.put("height", tempHeight);
		}

		final Shell tempShell = getShell();
		tempShell.setSize(tempWidth, tempHeight);
		Monitor tempMonitor = tempShell.getMonitor();
		Rectangle tempBounds = tempMonitor.getBounds();
		Rectangle tempRect = tempShell.getBounds();
		int tempX = tempBounds.x + (tempBounds.width - tempRect.width) / 2;
		int tempY = tempBounds.y + (tempBounds.height - tempRect.height) / 2;
		tempShell.setLocation(tempX, tempY);

		final IDialogSettings tempFinalSettings = tempSettings;
		tempShell.addControlListener(new ControlListener() {

			@Override
			public void controlResized(ControlEvent anEvent) {
				tempFinalSettings.put("width", tempShell.getSize().x);
				tempFinalSettings.put("height", tempShell.getSize().y);
			}

			@Override
			public void controlMoved(ControlEvent anEvent) {

			}
		});
	}

	@Override
	protected void configureShell(Shell aShell) {
		super.configureShell(aShell);
		aShell.setText("Launch Configuration to run");
	}

	@Override
	protected Layout getLayout() {
		GridLayout tempLayout = new GridLayout();
		tempLayout.marginLeft = 2;
		tempLayout.marginRight = 2;
		tempLayout.marginTop = 2;
		tempLayout.marginBottom = 2;

		return tempLayout;
	}

	@Override
	protected Control createDialogArea(Composite aParent) {
		launchConfigList = new TreeViewer(aParent, SWT.BORDER | SWT.V_SCROLL);
		GridData tempGrid = new GridData();
		tempGrid.grabExcessHorizontalSpace = true;
		tempGrid.horizontalAlignment = GridData.FILL;
		tempGrid.grabExcessVerticalSpace = true;
		tempGrid.verticalAlignment = GridData.FILL;
		launchConfigList.getTree().setLayoutData(tempGrid);

		DebugPlugin tempDebugPlugin = DebugPlugin.getDefault();
		ILaunchManager tempLaunchManager = tempDebugPlugin.getLaunchManager();

		launchConfigurations.clear();
		try {
			ILaunchConfiguration[] tempLaunchConfigs = tempLaunchManager.getLaunchConfigurations();
			java.util.List<ILaunchConfiguration> tempLaunchConfigList = Arrays.asList(tempLaunchConfigs);
			Collections.sort(tempLaunchConfigList, new Comparator<ILaunchConfiguration>() {

				private static final String TRIGGER_WORD = "integrity";

				/**
				 * For easier usage, we apply a simple heuristic to sorting the launch configs: if the name contains
				 * 'integrity', the config is moved to the top.
				 * 
				 * @param aFirstConfig
				 * @param aSecondConfig
				 * @return
				 */
				@Override
				public int compare(ILaunchConfiguration aFirstConfig, ILaunchConfiguration aSecondConfig) {
					if (aFirstConfig.getName().toLowerCase().contains(TRIGGER_WORD)) {
						if (!aSecondConfig.getName().toLowerCase().contains(TRIGGER_WORD)) {
							return -1;
						}
					} else {
						if (aSecondConfig.getName().toLowerCase().contains(TRIGGER_WORD)) {
							return 1;
						}
					}

					return aFirstConfig.getName().compareTo(aSecondConfig.getName());
				}
			});

			for (ILaunchConfiguration tempLaunchConfig : tempLaunchConfigList) {
				List<ILaunchConfiguration> tempList = launchConfigurations.get(tempLaunchConfig.getType());

				if (tempList == null) {
					tempList = new ArrayList<>();
					launchConfigurations.put(tempLaunchConfig.getType(), tempList);
				}

				tempList.add(tempLaunchConfig);
			}

			launchConfigList.setContentProvider(new LaunchConfigContentProvider());
			launchConfigList.setLabelProvider(new LaunchConfigLabelProvider());
			launchConfigList.addSelectionChangedListener(new LaunchConfigSelectionChangedListener());
			launchConfigList.setInput(this);
			if (preselectedConfiguration != null) {
				launchConfigList.setSelection(new StructuredSelection(preselectedConfiguration), true);
			}
		} catch (CoreException exc) {
			throw new RuntimeException(exc);
		}

		return aParent;
	}

	@Override
	protected void okPressed() {
		setReturnCode(OK);
		close();
	}

	public ILaunchConfiguration getSelectedConfiguration() {
		return selectedConfiguration;
	}

	private class LaunchConfigSelectionChangedListener implements ISelectionChangedListener {

		@Override
		public void selectionChanged(SelectionChangedEvent anEvent) {
			// During init, the OK button might not yet be available
			if (getButton(IDialogConstants.OK_ID) != null) {
				if (anEvent.getSelection().isEmpty()) {
					getButton(IDialogConstants.OK_ID).setEnabled(false);
				} else {
					IStructuredSelection tempSelection = (IStructuredSelection) anEvent.getSelection();
					if (tempSelection.getFirstElement() instanceof ILaunchConfiguration) {
						getButton(IDialogConstants.OK_ID).setEnabled(true);
						selectedConfiguration = (ILaunchConfiguration) tempSelection.getFirstElement();
					} else {
						getButton(IDialogConstants.OK_ID).setEnabled(false);
						selectedConfiguration = null;
					}
				}
			}
		}

	}

	private class LaunchConfigContentProvider implements ITreeContentProvider {

		/**
		 * An empty array.
		 */
		private final Object[] emptyArray = new Object[0];

		@Override
		public void dispose() {
			// nothing to do
		}

		@Override
		public void inputChanged(Viewer aViewer, Object anOldInput, Object aNewInput) {
			// nothing to do
		}

		@Override
		public Object[] getChildren(Object aCurrentElement) {
			if (aCurrentElement instanceof ILaunchConfigurationType) {
				return launchConfigurations.get(aCurrentElement).toArray(emptyArray);
			} else if (aCurrentElement == TestActionConfigurationDialog.this) {
				List<ILaunchConfigurationType> tempSortedList = new ArrayList<>(launchConfigurations.keySet());
				Collections.sort(tempSortedList, new Comparator<ILaunchConfigurationType>() {

					@Override
					public int compare(ILaunchConfigurationType aFirst, ILaunchConfigurationType aSecond) {
						return aFirst.getName().toLowerCase().compareTo(aSecond.getName().toLowerCase());
					}
				});

				return tempSortedList.toArray(emptyArray);
			}

			return emptyArray;
		}

		@Override
		public Object[] getElements(Object aCurrentElement) {
			return getChildren(aCurrentElement);
		}

		@Override
		public Object getParent(Object aCurrentElement) {
			if (aCurrentElement instanceof ILaunchConfiguration) {
				try {
					return ((ILaunchConfiguration) aCurrentElement).getType();
				} catch (CoreException exc) {
					throw new RuntimeException(exc);
				}
			} else if (aCurrentElement instanceof ILaunchConfigurationType) {
				return TestActionConfigurationDialog.this;
			}

			return null;
		}

		@Override
		public boolean hasChildren(Object aCurrentElement) {
			if (aCurrentElement instanceof ILaunchConfigurationType) {
				return !launchConfigurations.get(aCurrentElement).isEmpty();
			} else if (aCurrentElement == TestActionConfigurationDialog.this) {
				return !launchConfigurations.isEmpty();
			}

			return false;
		}

	}

	private class LaunchConfigLabelProvider extends LabelProvider implements ILabelProvider {

		@Override
		public Image getImage(Object anElement) {
			if (anElement instanceof ILaunchConfigurationType) {
				return DebugUITools.getImage(((ILaunchConfigurationType) anElement).getIdentifier());
			} else if (anElement instanceof ILaunchConfiguration) {
				try {
					return DebugUITools.getImage(((ILaunchConfiguration) anElement).getType().getIdentifier());
				} catch (CoreException exc) {
					throw new RuntimeException(exc);
				}
			}

			return null;
		}

		@Override
		public String getText(Object anElement) {
			if (anElement instanceof ILaunchConfigurationType) {
				return ((ILaunchConfigurationType) anElement).getName();
			} else if (anElement instanceof ILaunchConfiguration) {
				return ((ILaunchConfiguration) anElement).getName();
			}

			return null;
		}

	}

}
