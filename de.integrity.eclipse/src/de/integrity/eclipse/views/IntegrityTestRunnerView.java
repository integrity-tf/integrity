package de.integrity.eclipse.views;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import de.integrity.eclipse.Activator;
import de.integrity.remoting.IntegrityRemotingConstants;
import de.integrity.remoting.client.IntegrityRemotingClient;
import de.integrity.remoting.client.IntegrityRemotingClientListener;
import de.integrity.remoting.entities.setlist.SetList;
import de.integrity.remoting.entities.setlist.SetListEntry;
import de.integrity.remoting.entities.setlist.SetListEntryAttributeKeys;
import de.integrity.remoting.entities.setlist.SetListEntryTypes;
import de.integrity.remoting.transport.Endpoint;
import de.integrity.remoting.transport.enums.ExecutionCommands;
import de.integrity.remoting.transport.enums.ExecutionStates;
import de.integrity.remoting.transport.messages.IntegrityRemotingVersionMessage;

/**
 * This sample class demonstrates how to plug-in a new workbench view. The view
 * shows data obtained from the model. The sample creates a dummy model on the
 * fly, but a real implementation would connect to the model available either in
 * this or another plug-in (e.g. the workspace). The view is connected to the
 * model using a content provider.
 * <p>
 * The view uses a label provider to define how model objects should be
 * presented in the view. Each view can present the same model objects using
 * different labels and icons, if needed. Alternatively, a single label provider
 * can be shared between views in order to ensure that objects of the same type
 * are presented in the same way everywhere.
 * <p>
 */

public class IntegrityTestRunnerView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "de.integrity.eclipse.views.IntegrityTestRunnerView";

	private SashForm sashForm;

	private TreeViewer treeViewer;
	private TestTreeContentDrawer viewerContentDrawer;

	private Composite details;
	private Label focusTitle;
	private Label focusSubtitle;
	private Composite detailGroups;
	private Group variables;
	private TableViewer variableTable;
	private Group parameters;
	private Group result;

	private Action connectToTestRunnerAction;
	private Action playAction;
	private Action pauseAction;
	private Action stepIntoAction;
	private Action setpOverAction;

	private IntegrityRemotingClient client;

	private SetList setList;

	/**
	 * The constructor.
	 */
	public IntegrityTestRunnerView() {
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(final Composite parent) {
		parent.setLayout(new FillLayout());

		sashForm = new SashForm(parent, SWT.HORIZONTAL | SWT.SMOOTH);

		treeViewer = new TreeViewer(sashForm, SWT.VIRTUAL | SWT.H_SCROLL | SWT.V_SCROLL);
		treeViewer.setUseHashlookup(true);
		treeViewer.setContentProvider(new TestTreeContentProvider(treeViewer));

		details = new Composite(sashForm, SWT.NONE);
		details.setLayout(new FormLayout());
		details.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

		focusTitle = new Label(details, SWT.WRAP);
		focusTitle.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		focusTitle.setText("Checks if 5 equals 12");
		FontData[] fontData = focusTitle.getFont().getFontData();
		for (int i = 0; i < fontData.length; ++i) {
			fontData[i].setHeight(10);
			fontData[i].setStyle(SWT.BOLD);
		}
		final Font tempNewFont = new Font(Display.getCurrent(), fontData);
		focusTitle.setFont(tempNewFont);
		focusTitle.addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				tempNewFont.dispose();
			}
		});

		FormData tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 5);
		tempFormData.right = new FormAttachment(100, -5);
		tempFormData.top = new FormAttachment(details, 5);
		focusTitle.setLayoutData(tempFormData);

		focusSubtitle = new Label(details, SWT.WRAP);
		focusSubtitle.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		focusSubtitle.setText("de.firehead.test#whatever");
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 5);
		tempFormData.right = new FormAttachment(100, -5);
		tempFormData.top = new FormAttachment(focusTitle, 3);
		focusSubtitle.setLayoutData(tempFormData);

		detailGroups = new Composite(details, SWT.NONE);
		detailGroups.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		detailGroups.setLayout(new FillLayout(SWT.VERTICAL));
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 5);
		tempFormData.right = new FormAttachment(100, -5);
		tempFormData.top = new FormAttachment(focusSubtitle, 10);
		tempFormData.bottom = new FormAttachment(100, 0);
		detailGroups.setLayoutData(tempFormData);

		variables = new Group(detailGroups, SWT.SHADOW_NONE);
		variables.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		variables.setText("Variable definitions");
		variables.setLayout(new FillLayout());

		variableTable = new TableViewer(variables);
		variableTable.setContentProvider(new ArrayContentProvider());
		configureTable(variableTable);

		parameters = new Group(detailGroups, SWT.SHADOW_NONE);
		parameters.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		parameters.setText("Parameters");

		result = new Group(detailGroups, SWT.SHADOW_NONE);
		result.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		result.setText("Result");

		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(treeViewer.getControl(), "de.integrity.eclipse.viewer");
		attachTreeSelectionListeners();
		makeActions();
		hookContextMenu();
		contributeToActionBars();
		updateDetailPanel(null);
	}

	private void configureTable(final TableViewer aTable) {
		aTable.getTable().setHeaderVisible(true);
		aTable.getTable().setLinesVisible(true);

		TableViewerColumn tempColumn = new TableViewerColumn(aTable, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.FULL_SELECTION | SWT.BORDER);
		tempColumn.getColumn().setText("Name");
		tempColumn.getColumn().setWidth(180);
		tempColumn.getColumn().setResizable(true);
		tempColumn.getColumn().setMoveable(false);
		tempColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				SetListEntry tempEntry = (SetListEntry) element;
				return (String) tempEntry.getAttribute(SetListEntryAttributeKeys.NAME);
			}
		});

		tempColumn = new TableViewerColumn(aTable, SWT.NONE);
		tempColumn.getColumn().setText("Value");
		tempColumn.getColumn().setResizable(true);
		tempColumn.getColumn().setMoveable(false);
		tempColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				SetListEntry tempEntry = (SetListEntry) element;
				return (String) tempEntry.getAttribute(SetListEntryAttributeKeys.VALUE);
			}
		});
	}

	private void attachTreeSelectionListeners() {
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent anEvent) {
				if (anEvent.getSelection().isEmpty()) {
					updateDetailPanel(null);
				} else {
					if (anEvent.getSelection() instanceof TreeSelection) {
						TreeSelection tempSelection = (TreeSelection) anEvent.getSelection();
						if (tempSelection.getFirstElement() instanceof SetListEntry) {
							updateDetailPanel((SetListEntry) tempSelection.getFirstElement());
						}
					}
				}
			}
		});
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				IntegrityTestRunnerView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(treeViewer.getControl());
		treeViewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, treeViewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(playAction);
		manager.add(new Separator());
		manager.add(connectToTestRunnerAction);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}

	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(playAction);
		manager.add(new Separator());
		manager.add(connectToTestRunnerAction);
	}

	private void makeActions() {
		connectToTestRunnerAction = new Action() {
			public void run() {
				if (client == null || !client.isActive()) {
					connectToTestRunner();
				} else {
					disconnectFromTestRunner();
				}
			}
		};

		playAction = new Action() {
			public void run() {
				runTests();
			}
		};
		playAction.setText("Start or continue test execution");
		playAction.setToolTipText("Continues test execution if currently paused");
		playAction.setImageDescriptor(Activator.getImageDescriptor("icons/play_enabled.gif"));
		playAction.setDisabledImageDescriptor(Activator.getImageDescriptor("icons/play_disabled.gif"));

		updateActionStatus(null);
	}

	private void updateActionStatus(final ExecutionStates anExecutionState) {
		Runnable tempRunnable = new Runnable() {

			@Override
			public void run() {
				if (client == null || !client.isActive()) {
					connectToTestRunnerAction.setText("Connect to local test runner");
					connectToTestRunnerAction.setToolTipText("Connects to a local test runner");
					connectToTestRunnerAction.setImageDescriptor(Activator.getImageDescriptor("icons/connect.gif"));
					playAction.setEnabled(false);

				} else {
					connectToTestRunnerAction.setText("Disconnect from test runner");
					connectToTestRunnerAction
							.setToolTipText("Disconnects the client from the currently connected test runner");
					connectToTestRunnerAction.setImageDescriptor(Activator.getImageDescriptor("icons/disconnect.gif"));
					if (anExecutionState == null) {
						playAction.setEnabled(false);
					} else {
						switch (anExecutionState) {
						case BLOCKED:
							playAction.setEnabled(true);
							break;
						case PAUSED:
							playAction.setEnabled(true);
							break;
						case RUNNING:
							playAction.setEnabled(false);
							break;
						case ENDED:
							playAction.setEnabled(false);
							break;
						}
					}
				}
			}
		};

		if (Display.getCurrent() != null) {
			Display.getCurrent().syncExec(tempRunnable);
		} else {
			Display.getDefault().asyncExec(tempRunnable);
		}
	}

	private void updateDetailPanel(SetListEntry anEntry) {
		if (anEntry == null) {
			focusTitle.setVisible(false);
			focusSubtitle.setVisible(false);
			variables.setVisible(false);
			parameters.setVisible(false);
			result.setVisible(false);
		} else {
			if (anEntry.getType() == SetListEntryTypes.SUITE) {
				focusTitle.setText((String) anEntry.getAttribute(SetListEntryAttributeKeys.NAME));
				focusSubtitle.setVisible(false);
			} else {
				focusTitle.setText((String) anEntry.getAttribute(SetListEntryAttributeKeys.DESCRIPTION));
				focusSubtitle.setText((String) anEntry.getAttribute(SetListEntryAttributeKeys.FIXTURE));
				focusSubtitle.setVisible(true);
			}
			focusTitle.setVisible(true);

			List<SetListEntry> tempVariables = setList.resolveReferences(anEntry,
					SetListEntryAttributeKeys.VARIABLE_DEFINITIONS);
			if (tempVariables.size() > 0) {
				variableTable.setInput(tempVariables);
				variables.setVisible(true);
			} else {
				variables.setVisible(false);
			}

		}
	}

	private void showMessage(final String message) {
		Runnable tempRunnable = new Runnable() {
			@Override
			public void run() {
				MessageDialog.openInformation(treeViewer.getControl().getShell(), "Integrity Test Runner", message);
			}
		};

		Display.getDefault().asyncExec(tempRunnable);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		treeViewer.getControl().setFocus();
	}

	private void connectToTestRunner() {
		new Thread("Test Runner Connect Thread") {

			@Override
			public void run() {
				try {
					client = new IntegrityRemotingClient("localhost", IntegrityRemotingConstants.DEFAULT_PORT,
							new RemotingListener());
				} catch (UnknownHostException exc) {
					// TODO Auto-generated catch block
					exc.printStackTrace();
				} catch (IOException exc) {
					// TODO Auto-generated catch block
					exc.printStackTrace();
				}
			}

		}.start();
	}

	private void disconnectFromTestRunner() {
		client.close();
		client = null;
		updateActionStatus(null);
	}

	private void runTests() {
		client.controlExecution(ExecutionCommands.RUN);
	}

	private class RemotingListener implements IntegrityRemotingClientListener {

		@Override
		public void onConnectionSuccessful(IntegrityRemotingVersionMessage aRemoteVersion, Endpoint anEndpoint) {
			updateActionStatus(client.getExecutionState());
		}

		@Override
		public void onVersionMismatch(IntegrityRemotingVersionMessage aRemoteVersion, Endpoint anEndpoint) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onBaselineReceived(SetList aSetList, Endpoint anEndpoint) {
			setList = aSetList;
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					treeViewer.setInput(setList);

					// the following will automatically dispose the old
					// provider!
					treeViewer.setLabelProvider(new TestTreeLabelProvider(setList));

					// the drawer must be manually disposed
					if (viewerContentDrawer != null) {
						viewerContentDrawer.dispose(treeViewer.getTree());
					}
					viewerContentDrawer = new TestTreeContentDrawer(setList, Display.getCurrent());
					viewerContentDrawer.attachToTree(treeViewer.getTree());
				}
			});
		}

		@Override
		public void onExecutionStateUpdate(ExecutionStates aState, Endpoint anEndpoint) {
			updateActionStatus(aState);
		}

		@Override
		public void onConnectionLost(Endpoint anEndpoint) {
			client = null;
			updateActionStatus(null);
		}

		@Override
		public void onSetListUpdate(Endpoint anEndpoint, final SetListEntry[] someUpdatedEntries) {
			setList.integrateUpdates(someUpdatedEntries);
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					for (SetListEntry tempEntry : someUpdatedEntries) {
						switch (tempEntry.getType()) {
						case RESULT:
							treeViewer.update(setList.getParent(tempEntry), null);
						default:
							treeViewer.update(tempEntry, null);
						}
					}
				}
			});
		}
	}
}