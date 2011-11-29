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
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.HyperlinkGroup;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.Section;
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

	private Form details;
	private HyperlinkGroup fixtureLinkGroup;
	private Hyperlink fixtureLink;
	private Composite detailGroups;
	private Section variableSection;
	private Composite variableComposite;
	private TableViewer variableTable;
	private Section parameterSection;
	private Composite parameterComposite;
	private TableViewer parameterTable;
	private Section resultSection;
	private Composite resultComposite;
	private Label resultLine1;
	private Label resultLine2;
	private Label resultLine3;
	private Color resultSuccessColor;
	private Color resultFailureColor;
	private Color resultNeutralColor;
	private Color resultExceptionColor;
	private Image resultSuccessIcon;
	private Image resultFailureIcon;
	private Image resultExceptionIcon;

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

		final FormToolkit tempToolkit = new FormToolkit(parent.getDisplay());

		sashForm = new SashForm(parent, SWT.HORIZONTAL | SWT.SMOOTH);

		treeViewer = new TreeViewer(sashForm, SWT.VIRTUAL | SWT.H_SCROLL | SWT.V_SCROLL);
		treeViewer.setUseHashlookup(true);
		treeViewer.setContentProvider(new TestTreeContentProvider(treeViewer));

		details = tempToolkit.createForm(sashForm);
		details.getBody().setLayout(new FormLayout());
		// details.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		tempToolkit.decorateFormHeading(details);

		fixtureLinkGroup = new HyperlinkGroup(parent.getDisplay());
		fixtureLink = new Hyperlink(details.getBody(), SWT.NONE);
		fixtureLink.setBackground(details.getBackground());
		fixtureLink.setText("de.firehead.test#whatever");
		FormData tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 5);
		tempFormData.right = new FormAttachment(100, -5);
		tempFormData.top = new FormAttachment(0, 3);
		tempFormData.height = 10;
		fixtureLink.setLayoutData(tempFormData);
		fixtureLink.addHyperlinkListener(new HyperlinkAdapter() {
			public void linkActivated(HyperlinkEvent e) {
				// TODO jump to the class!
			}
		});
		fixtureLinkGroup.add(fixtureLink);

		detailGroups = new Composite(details.getBody(), SWT.NONE);
		detailGroups.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		FillLayout tempFillLayout = new FillLayout(SWT.VERTICAL);
		tempFillLayout.spacing = 6;
		detailGroups.setLayout(tempFillLayout);
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 5);
		tempFormData.right = new FormAttachment(100, -5);
		tempFormData.top = new FormAttachment(fixtureLink, 10);
		tempFormData.bottom = new FormAttachment(100, 0);
		detailGroups.setLayoutData(tempFormData);

		variableSection = tempToolkit.createSection(detailGroups, Section.TITLE_BAR);
		variableSection.setText("Variable definitions");
		variableComposite = tempToolkit.createComposite(variableSection);
		tempToolkit.paintBordersFor(variableComposite);
		variableSection.setClient(variableComposite);
		variableComposite.setLayout(new FillLayout());

		variableTable = new TableViewer(variableComposite);
		variableTable.setContentProvider(new ArrayContentProvider());
		configureTable(variableTable);

		parameterSection = tempToolkit.createSection(detailGroups, Section.TITLE_BAR);
		parameterSection.setText("Parameters");
		parameterSection.setLayout(new FillLayout());
		parameterComposite = tempToolkit.createComposite(parameterSection);
		tempToolkit.paintBordersFor(parameterComposite);
		parameterSection.setClient(parameterComposite);
		parameterComposite.setLayout(new FillLayout());

		parameterTable = new TableViewer(parameterComposite);
		parameterTable.setContentProvider(new ArrayContentProvider());
		configureTable(parameterTable);

		resultSection = tempToolkit.createSection(detailGroups, Section.TITLE_BAR);
		resultSection.setText("Result");
		resultSection.setLayout(new FillLayout());
		resultComposite = tempToolkit.createComposite(resultSection);
		tempToolkit.paintBordersFor(resultComposite);
		resultSection.setClient(resultComposite);
		resultComposite.setLayout(new FormLayout());

		resultLine1 = new Label(resultComposite, SWT.WRAP);
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 5);
		tempFormData.right = new FormAttachment(100, -5);
		tempFormData.top = new FormAttachment(0, 6);
		resultLine1.setLayoutData(tempFormData);

		resultLine2 = new Label(resultComposite, SWT.WRAP);
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 5);
		tempFormData.right = new FormAttachment(100, -5);
		tempFormData.top = new FormAttachment(resultLine1, 6);
		resultLine2.setLayoutData(tempFormData);

		resultLine3 = new Label(resultComposite, SWT.WRAP);
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 5);
		tempFormData.right = new FormAttachment(100, -5);
		tempFormData.top = new FormAttachment(resultLine2, 6);
		resultLine3.setLayoutData(tempFormData);

		resultSuccessColor = new Color(Display.getCurrent(), 0, 94, 13);
		resultFailureColor = new Color(Display.getCurrent(), 190, 0, 0);
		resultNeutralColor = new Color(Display.getCurrent(), 0, 0, 0);
		resultExceptionColor = new Color(Display.getCurrent(), 204, 163, 0);

		resultSuccessIcon = Activator.getImageDescriptor("icons/suite_success_big.png").createImage();
		resultFailureIcon = Activator.getImageDescriptor("icons/suite_failure_big.png").createImage();
		resultExceptionIcon = Activator.getImageDescriptor("icons/suite_exception_big.png").createImage();

		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(treeViewer.getControl(), "de.integrity.eclipse.viewer");
		attachTreeSelectionListeners();
		makeActions();
		hookContextMenu();
		contributeToActionBars();
		updateDetailPanel(null, null);
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
		tempColumn.getColumn().setWidth(200);
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
					updateDetailPanel(null, null);
				} else {
					if (anEvent.getSelection() instanceof TreeSelection) {
						TreeSelection tempSelection = (TreeSelection) anEvent.getSelection();
						if (tempSelection.getFirstElement() instanceof SetListEntry) {
							updateDetailPanel((SetListEntry) tempSelection.getFirstElement(),
									(ILabelProvider) ((TreeViewer) anEvent.getSource()).getLabelProvider());
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

	private void updateDetailPanel(SetListEntry anEntry, ILabelProvider aProvider) {
		if (anEntry == null) {
			details.setText("Details");
			details.setImage(null);
			fixtureLink.setVisible(false);
			// resultLine1.setVisible(false);
			// resultLine2.setVisible(false);
			// resultLine3.setVisible(false);
		} else {
			if (anEntry.getType() == SetListEntryTypes.SUITE) {
				details.setText((String) anEntry.getAttribute(SetListEntryAttributeKeys.NAME));
				fixtureLink.setVisible(false);
			} else {
				details.setText((String) anEntry.getAttribute(SetListEntryAttributeKeys.DESCRIPTION));
				fixtureLink.setText((String) anEntry.getAttribute(SetListEntryAttributeKeys.FIXTURE));
				fixtureLink.setVisible(true);
			}
			details.setImage(aProvider.getImage(anEntry));

			List<SetListEntry> tempVariables = setList.resolveReferences(anEntry,
					SetListEntryAttributeKeys.VARIABLE_DEFINITIONS);
			if (tempVariables.size() > 0) {
				variableTable.setInput(tempVariables);
			} else {
				variableTable.setInput(null);
			}

			List<SetListEntry> tempParameters = setList
					.resolveReferences(anEntry, SetListEntryAttributeKeys.PARAMETERS);
			if (tempParameters.size() > 0) {
				parameterTable.setInput(tempParameters);
			} else {
				parameterTable.setInput(null);
			}

			SetListEntry tempResultEntry = setList.resolveReferences(anEntry, SetListEntryAttributeKeys.RESULT).get(0);
			if (tempResultEntry != null) {
				if (anEntry.getType() == SetListEntryTypes.SUITE) {
					if (tempResultEntry.getAttribute(SetListEntryAttributeKeys.SUCCESS_COUNT) != null) {
						int tempSuccessCount = (Integer) tempResultEntry
								.getAttribute(SetListEntryAttributeKeys.SUCCESS_COUNT);
						int tempFailureCount = (Integer) tempResultEntry
								.getAttribute(SetListEntryAttributeKeys.FAILURE_COUNT);
						int tempExceptionCount = (Integer) tempResultEntry
								.getAttribute(SetListEntryAttributeKeys.EXCEPTION_COUNT);

					} else {
						resultLine1.setVisible(false);
						resultLine2.setVisible(false);
						resultLine3.setVisible(false);
					}
				}
			} else {
				resultLine1.setVisible(false);
				resultLine2.setVisible(false);
				resultLine3.setVisible(false);
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