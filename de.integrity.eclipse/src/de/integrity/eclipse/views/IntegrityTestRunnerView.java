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
import org.eclipse.jface.resource.JFaceResources;
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
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.HyperlinkGroup;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
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

	private Composite detailsContainer;
	private ScrolledForm details;
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
	private Label resultLine1Name;
	private Text resultLine1Text;
	private Composite resultLine1Border;
	private Label resultLine2Name;
	private Text resultLine2Text;
	private Composite resultLine2Border;
	private Color resultSuccessColor;
	private Color resultFailureColor;
	private Color resultNeutralColor;
	private Color resultExceptionColor;
	private Image resultSuccessIconImage;
	private Image resultFailureIconImage;
	private Image resultExceptionIconImage;
	private Label resultSuccessIcon;
	private Label resultFailureIcon;
	private Label resultExceptionIcon;
	private Label resultSuccessCountLabel;
	private Label resultFailureCountLabel;
	private Label resultExceptionCountLabel;

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

		resultSuccessColor = new Color(Display.getCurrent(), 0, 94, 13);
		resultFailureColor = new Color(Display.getCurrent(), 190, 0, 0);
		resultNeutralColor = new Color(Display.getCurrent(), 0, 0, 0);
		resultExceptionColor = new Color(Display.getCurrent(), 204, 163, 0);

		resultSuccessIconImage = Activator.getImageDescriptor("icons/suite_success_big.png").createImage();
		resultFailureIconImage = Activator.getImageDescriptor("icons/suite_failure_big.png").createImage();
		resultExceptionIconImage = Activator.getImageDescriptor("icons/suite_exception_big.png").createImage();

		sashForm = new SashForm(parent, SWT.HORIZONTAL | SWT.SMOOTH);

		treeViewer = new TreeViewer(sashForm, SWT.VIRTUAL | SWT.H_SCROLL | SWT.V_SCROLL);
		treeViewer.setUseHashlookup(true);
		treeViewer.setContentProvider(new TestTreeContentProvider(treeViewer));

		detailsContainer = new Composite(sashForm, SWT.NONE);
		detailsContainer.setLayout(new FillLayout());

		details = new ScrolledForm(detailsContainer, SWT.V_SCROLL | SWT.H_SCROLL);
		details.setExpandHorizontal(true);
		details.setExpandVertical(true);
		details.setBackground(tempToolkit.getColors().getBackground());
		details.setForeground(tempToolkit.getColors().getColor(IFormColors.TITLE));
		details.setFont(JFaceResources.getHeaderFont());
		details.getBody().setLayout(new FormLayout());
		tempToolkit.decorateFormHeading(details.getForm());

		fixtureLinkGroup = new HyperlinkGroup(parent.getDisplay());
		fixtureLink = new Hyperlink(details.getBody(), SWT.NONE);
		fixtureLink.setBackground(details.getBackground());
		fixtureLink.setText("");
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
		detailGroups.setLayout(new FormLayout());
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 5);
		tempFormData.right = new FormAttachment(100, -5);
		tempFormData.top = new FormAttachment(fixtureLink, 10);
		tempFormData.bottom = new FormAttachment(100, 0);
		detailGroups.setLayoutData(tempFormData);

		resultSection = tempToolkit.createSection(detailGroups, Section.TITLE_BAR);
		resultSection.setText("Result");
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 5);
		tempFormData.right = new FormAttachment(100, -5);
		tempFormData.top = new FormAttachment(0, 10);
		tempFormData.bottom = new FormAttachment(0, 202);
		resultSection.setLayoutData(tempFormData);
		resultSection.setLayout(new FillLayout());

		resultComposite = tempToolkit.createComposite(resultSection);
		tempToolkit.paintBordersFor(resultComposite);
		resultSection.setClient(resultComposite);
		resultComposite.setLayout(new FormLayout());

		parameterSection = tempToolkit.createSection(detailGroups, Section.TITLE_BAR);
		parameterSection.setText("Parameters");
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 5);
		tempFormData.right = new FormAttachment(100, -5);
		tempFormData.top = new FormAttachment(resultSection, 10);
		tempFormData.bottom = new FormAttachment(resultSection, 140, SWT.BOTTOM);
		parameterSection.setLayoutData(tempFormData);
		parameterSection.setLayout(new FillLayout());

		parameterComposite = tempToolkit.createComposite(parameterSection);
		tempToolkit.paintBordersFor(parameterComposite);
		parameterSection.setClient(parameterComposite);
		parameterComposite.setLayout(new FillLayout());

		parameterTable = new TableViewer(parameterComposite);
		parameterTable.setContentProvider(new ArrayContentProvider());
		configureTable(parameterTable);

		variableSection = tempToolkit.createSection(detailGroups, Section.TITLE_BAR);
		variableSection.setText("Variable definitions");
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 5);
		tempFormData.right = new FormAttachment(100, -5);
		tempFormData.top = new FormAttachment(parameterSection, 10);
		tempFormData.bottom = new FormAttachment(parameterSection, 160, SWT.BOTTOM);
		variableSection.setLayoutData(tempFormData);
		variableSection.setLayout(new FillLayout());

		variableComposite = tempToolkit.createComposite(variableSection);
		tempToolkit.paintBordersFor(variableComposite);
		variableSection.setClient(variableComposite);
		variableComposite.setLayout(new FillLayout());

		variableTable = new TableViewer(variableComposite);
		variableTable.setContentProvider(new ArrayContentProvider());
		configureTable(variableTable);

		resultComposite = tempToolkit.createComposite(resultSection);
		tempToolkit.paintBordersFor(resultComposite);
		resultSection.setClient(resultComposite);
		resultComposite.setLayout(new FormLayout());

		resultLine1Name = new Label(resultComposite, SWT.WRAP);
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 5);
		tempFormData.right = new FormAttachment(100, -5);
		tempFormData.top = new FormAttachment(0, 4);
		resultLine1Name.setLayoutData(tempFormData);

		resultLine1Border = new Composite(resultComposite, SWT.NONE);
		resultLine1Border.setForeground(resultNeutralColor);
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 5);
		tempFormData.right = new FormAttachment(100, -5);
		tempFormData.top = new FormAttachment(resultLine1Name, 2);
		tempFormData.bottom = new FormAttachment(resultLine1Name, 80);
		resultLine1Border.setLayoutData(tempFormData);
		FillLayout tempFill = new FillLayout();
		tempFill.marginHeight = 1;
		tempFill.marginWidth = 1;
		resultLine1Border.setLayout(tempFill);
		configureTextFieldBorder(resultLine1Border);

		resultLine1Text = new Text(resultLine1Border, SWT.READ_ONLY | SWT.H_SCROLL | SWT.V_SCROLL);
		resultLine1Text.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

		resultLine2Name = new Label(resultComposite, SWT.WRAP);
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 5);
		tempFormData.right = new FormAttachment(100, -5);
		tempFormData.top = new FormAttachment(resultLine1Border, 6);
		resultLine2Name.setLayoutData(tempFormData);

		resultLine2Border = new Composite(resultComposite, SWT.NONE);
		resultLine2Border.setForeground(resultNeutralColor);
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 5);
		tempFormData.right = new FormAttachment(100, -5);
		tempFormData.top = new FormAttachment(resultLine2Name, 2);
		tempFormData.bottom = new FormAttachment(resultLine2Name, 80);
		resultLine2Border.setLayoutData(tempFormData);
		tempFill = new FillLayout();
		tempFill.marginHeight = 1;
		tempFill.marginWidth = 1;
		resultLine2Border.setLayout(tempFill);
		configureTextFieldBorder(resultLine2Border);

		resultLine2Text = new Text(resultLine2Border, SWT.READ_ONLY | SWT.H_SCROLL | SWT.V_SCROLL);
		resultLine2Text.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

		resultFailureIcon = new Label(resultComposite, SWT.NONE);
		resultFailureIcon.setImage(resultFailureIconImage);
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(50, -24);
		tempFormData.top = new FormAttachment(0, 10);
		tempFormData.width = 48;
		tempFormData.height = 48;
		resultFailureIcon.setLayoutData(tempFormData);

		resultSuccessIcon = new Label(resultComposite, SWT.NONE);
		resultSuccessIcon.setImage(resultSuccessIconImage);
		tempFormData = new FormData();
		tempFormData.right = new FormAttachment(resultFailureIcon, -16);
		tempFormData.top = new FormAttachment(0, 10);
		tempFormData.width = 48;
		tempFormData.height = 48;
		resultSuccessIcon.setLayoutData(tempFormData);

		resultExceptionIcon = new Label(resultComposite, SWT.NONE);
		resultExceptionIcon.setImage(resultExceptionIconImage);
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(resultFailureIcon, 16);
		tempFormData.top = new FormAttachment(0, 10);
		tempFormData.width = 48;
		tempFormData.height = 48;
		resultExceptionIcon.setLayoutData(tempFormData);

		resultSuccessCountLabel = new Label(resultComposite, SWT.CENTER);
		resultSuccessCountLabel.setText("123");
		resultSuccessCountLabel.setForeground(resultSuccessColor);
		FontData[] tempFontData = resultSuccessCountLabel.getFont().getFontData();
		tempFontData[0].setHeight(16);
		tempFontData[0].setStyle(SWT.BOLD);
		resultSuccessCountLabel.setFont(new Font(Display.getCurrent(), tempFontData[0]));
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(resultSuccessIcon, -32, SWT.CENTER);
		tempFormData.top = new FormAttachment(resultSuccessIcon, 4);
		tempFormData.width = 64;
		tempFormData.height = 24;
		resultSuccessCountLabel.setLayoutData(tempFormData);

		resultFailureCountLabel = new Label(resultComposite, SWT.CENTER);
		resultFailureCountLabel.setText("123");
		resultFailureCountLabel.setForeground(resultFailureColor);
		tempFontData = resultFailureCountLabel.getFont().getFontData();
		tempFontData[0].setHeight(16);
		tempFontData[0].setStyle(SWT.BOLD);
		resultFailureCountLabel.setFont(new Font(Display.getCurrent(), tempFontData[0]));
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(resultFailureIcon, -32, SWT.CENTER);
		tempFormData.top = new FormAttachment(resultFailureIcon, 4);
		tempFormData.width = 64;
		tempFormData.height = 24;
		resultFailureCountLabel.setLayoutData(tempFormData);

		resultExceptionCountLabel = new Label(resultComposite, SWT.CENTER);
		resultExceptionCountLabel.setText("123");
		resultExceptionCountLabel.setForeground(resultExceptionColor);
		tempFontData = resultExceptionCountLabel.getFont().getFontData();
		tempFontData[0].setHeight(16);
		tempFontData[0].setStyle(SWT.BOLD);
		resultExceptionCountLabel.setFont(new Font(Display.getCurrent(), tempFontData[0]));
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(resultExceptionIcon, -32, SWT.CENTER);
		tempFormData.top = new FormAttachment(resultExceptionIcon, 4);
		tempFormData.width = 64;
		tempFormData.height = 24;
		resultExceptionCountLabel.setLayoutData(tempFormData);

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
				| SWT.FULL_SELECTION);
		tempColumn.getColumn().setText("Name");
		tempColumn.getColumn().setWidth(150);
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
		tempColumn.getColumn().setWidth(150);
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

	private void configureTextFieldBorder(final Composite aBorder) {
		aBorder.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent e) {
				GC gc = e.gc;
				gc.setForeground(aBorder.getForeground());
				Rectangle rect = aBorder.getBounds();

				gc.drawRectangle(0, 0, rect.width - 1, rect.height - 1);
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
		fixtureLink.setVisible(false);
		resultLine1Name.setVisible(false);
		resultLine1Border.setVisible(false);
		resultLine1Text.setText("");
		resultLine2Name.setVisible(false);
		resultLine2Border.setVisible(false);

		resultSuccessIcon.setVisible(false);
		resultFailureIcon.setVisible(false);
		resultExceptionIcon.setVisible(false);
		resultSuccessCountLabel.setVisible(false);
		resultFailureCountLabel.setVisible(false);
		resultExceptionCountLabel.setVisible(false);
		if (anEntry == null) {
			details.setText("Details");
			details.setImage(null);
		} else {
			details.setImage(aProvider.getImage(anEntry));
			if (anEntry.getType() == SetListEntryTypes.SUITE) {
				details.setText((String) anEntry.getAttribute(SetListEntryAttributeKeys.NAME));
			} else {
				details.setText((String) anEntry.getAttribute(SetListEntryAttributeKeys.DESCRIPTION));
				fixtureLink.setText((String) anEntry.getAttribute(SetListEntryAttributeKeys.FIXTURE));
				fixtureLink.setVisible(true);
			}

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
				switch (anEntry.getType()) {
				case SUITE:
					if (tempResultEntry.getAttribute(SetListEntryAttributeKeys.SUCCESS_COUNT) != null) {
						int tempSuccessCount = (Integer) tempResultEntry
								.getAttribute(SetListEntryAttributeKeys.SUCCESS_COUNT);
						int tempFailureCount = (Integer) tempResultEntry
								.getAttribute(SetListEntryAttributeKeys.FAILURE_COUNT);
						int tempExceptionCount = (Integer) tempResultEntry
								.getAttribute(SetListEntryAttributeKeys.EXCEPTION_COUNT);

						resultSuccessCountLabel.setText(Integer.toString(tempSuccessCount));
						resultFailureCountLabel.setText(Integer.toString(tempFailureCount));
						resultExceptionCountLabel.setText(Integer.toString(tempExceptionCount));

						resultSuccessIcon.setVisible(true);
						resultFailureIcon.setVisible(true);
						resultExceptionIcon.setVisible(true);
						resultSuccessCountLabel.setVisible(true);
						resultFailureCountLabel.setVisible(true);
						resultExceptionCountLabel.setVisible(true);
					}
					break;
				case TEST:
					resultLine2Name.setText("Expected value: ");
					resultLine2Text.setText((String) tempResultEntry
							.getAttribute(SetListEntryAttributeKeys.EXPECTED_RESULT));
					resultLine2Border.setForeground(resultNeutralColor);
					resultLine2Name.setVisible(true);
					resultLine2Border.setVisible(true);

					if (tempResultEntry.getAttribute(SetListEntryAttributeKeys.EXCEPTION) != null) {
						resultLine1Name.setText("Exception occurred while running the test fixture:");
						resultLine1Text.setText((String) tempResultEntry
								.getAttribute(SetListEntryAttributeKeys.EXCEPTION));
						resultLine1Border.setForeground(resultExceptionColor);
						resultLine1Name.setVisible(true);
						resultLine1Border.setVisible(true);
					} else {
						if (tempResultEntry.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG) != null) {
							resultLine1Name.setText("Result returned by the text fixture: ");
							resultLine1Text.setText((String) tempResultEntry
									.getAttribute(SetListEntryAttributeKeys.VALUE));
							if (tempResultEntry.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG) != null) {
								if (Boolean.TRUE.equals(tempResultEntry
										.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG))) {
									resultLine1Border.setForeground(resultSuccessColor);
								} else {
									resultLine1Border.setForeground(resultFailureColor);
								}
							}
							resultLine1Border.setVisible(true);
						} else {
							resultLine1Name.setText("No result available - please run the tests first.");
						}
						resultLine1Name.setVisible(true);
					}
					break;
				case CALL:
					if (tempResultEntry.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG) != null) {
						if (tempResultEntry.getAttribute(SetListEntryAttributeKeys.EXCEPTION) != null) {
							resultLine1Name.setText("Exception occurred while running the test fixture:");
							resultLine1Text.setText((String) tempResultEntry
									.getAttribute(SetListEntryAttributeKeys.EXCEPTION));
							resultLine1Border.setForeground(resultExceptionColor);
						} else {
							resultLine1Name.setText("Result returned by the fixture:");
							resultLine1Text.setText((String) tempResultEntry
									.getAttribute(SetListEntryAttributeKeys.VALUE));
							resultLine1Border.setForeground(resultNeutralColor);
						}
						resultLine1Border.setVisible(true);
					} else {
						resultLine1Name.setText("No result available - please run the tests first.");
					}
					resultLine1Name.setVisible(true);
					break;
				}
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