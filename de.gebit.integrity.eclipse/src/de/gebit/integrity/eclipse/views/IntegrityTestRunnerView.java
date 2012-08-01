package de.gebit.integrity.eclipse.views;

import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.jdt.core.IMethod;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.eclipse.jdt.core.search.SearchEngine;
import org.eclipse.jdt.core.search.SearchMatch;
import org.eclipse.jdt.core.search.SearchParticipant;
import org.eclipse.jdt.core.search.SearchPattern;
import org.eclipse.jdt.core.search.SearchRequestor;
import org.eclipse.jdt.ui.JavaUI;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
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
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.HyperlinkGroup;
import org.eclipse.ui.forms.IFormColors;
import org.eclipse.ui.forms.events.HyperlinkAdapter;
import org.eclipse.ui.forms.events.HyperlinkEvent;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Hyperlink;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.part.ViewPart;

import de.gebit.integrity.eclipse.Activator;
import de.gebit.integrity.eclipse.actions.BreakpointAction;
import de.gebit.integrity.eclipse.controls.ProgressBar;
import de.gebit.integrity.eclipse.running.TestActionConfigurationDialog;
import de.gebit.integrity.remoting.IntegrityRemotingConstants;
import de.gebit.integrity.remoting.client.IntegrityRemotingClient;
import de.gebit.integrity.remoting.client.IntegrityRemotingClientListener;
import de.gebit.integrity.remoting.entities.setlist.SetList;
import de.gebit.integrity.remoting.entities.setlist.SetListEntry;
import de.gebit.integrity.remoting.entities.setlist.SetListEntryAttributeKeys;
import de.gebit.integrity.remoting.entities.setlist.SetListEntryTypes;
import de.gebit.integrity.remoting.transport.Endpoint;
import de.gebit.integrity.remoting.transport.enums.ExecutionCommands;
import de.gebit.integrity.remoting.transport.enums.ExecutionStates;
import de.gebit.integrity.remoting.transport.enums.TestRunnerCallbackMethods;
import de.gebit.integrity.remoting.transport.messages.ExecutionStateMessage;
import de.gebit.integrity.remoting.transport.messages.IntegrityRemotingVersionMessage;
import de.gebit.integrity.remoting.transport.messages.SetListBaselineMessage;

/**
 * The Integrity Test Runner Eclipse Plugin main view.
 * 
 * @author Rene Schneider
 */
public class IntegrityTestRunnerView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "de.gebit.integrity.eclipse.views.IntegrityTestRunnerView";

	/**
	 * The sash form used to split the screen in one half for the tree, and another for the details view.
	 */
	private SashForm sashForm;

	/**
	 * The container for the tree.
	 */
	private Form treeContainer;

	/**
	 * The test execution tree viewer.
	 */
	private TreeViewer treeViewer;

	/**
	 * The drawer to colorize the test execution tree.
	 */
	private TestTreeContentDrawer viewerContentDrawer;

	/**
	 * The container for the detail information.
	 */
	private Composite detailsContainer;

	/**
	 * The scrolling form for the details.
	 */
	private ScrolledForm details;

	/**
	 * The hyperlink group for the fixture link.
	 */
	private HyperlinkGroup fixtureLinkGroup;

	/**
	 * The link that allows to jump to a specific fixture method.
	 */
	private Hyperlink fixtureLink;

	/**
	 * The label displaying whether a command is executed on a fork.
	 */
	private Label forkLabel;

	/**
	 * The container for the detail information groups.
	 */
	private Composite detailGroups;

	/**
	 * The variable section.
	 */
	private Section variableSection;

	/**
	 * The composite for the variable table.
	 */
	private Composite variableComposite;

	/**
	 * The table of defined variables.
	 */
	private TableViewer variableTable;

	/**
	 * The section for parameters.
	 */
	private Section parameterSection;

	/**
	 * The composite for the parameter table.
	 */
	private Composite parameterComposite;

	/**
	 * The table with all defined parameters.
	 */
	private TableViewer parameterTable;

	/**
	 * The section that gets the result info.
	 */
	private Section resultSection;

	/**
	 * The composite containing result UI elements.
	 */
	private Composite resultComposite;

	/**
	 * The label for the first (actual) result.
	 */
	private Label resultLine1Name;

	/**
	 * The text field for the first (actual) result.
	 */
	private Text resultLine1Text;

	/**
	 * The container for the first (actual) result text field, which adds a color border around it.
	 */
	private Composite resultLine1Border;

	/**
	 * The label for the second (expected) result.
	 */
	private Label resultLine2Name;

	/**
	 * The text field for the second (expected) result.
	 */
	private Text resultLine2Text;

	/**
	 * The container for the second (expected) result text field, which adds a color border around it.
	 */
	private Composite resultLine2Border;

	/**
	 * The container for the result table.
	 */
	private Composite resultTableComposite;

	/**
	 * The result table (for multi-result tests).
	 */
	private TableViewer resultTable;

	/**
	 * The container for the variable update table.
	 */
	private Composite varUpdateTableComposite;

	/**
	 * The variable update table (for calls with multi-variable updates).
	 */
	private TableViewer varUpdateTable;

	/**
	 * The color for results of successful tests.
	 */
	private Color resultSuccessColor;

	/**
	 * The color for results of failed tests.
	 */
	private Color resultFailureColor;

	/**
	 * The neutral color for results.
	 */
	private Color resultNeutralColor;

	/**
	 * The color of exception results.
	 */
	private Color resultExceptionColor;

	/**
	 * The image used to display successful test results.
	 */
	private Image resultSuccessIconImage;

	/**
	 * The image used to display failed test results.
	 */
	private Image resultFailureIconImage;

	/**
	 * The image used to display exception test results.
	 */
	private Image resultExceptionIconImage;

	/**
	 * The container to display the success icon.
	 */
	private Label resultSuccessIcon;

	/**
	 * The container to display the failure icon.
	 */
	private Label resultFailureIcon;

	/**
	 * The container to display the exception icon.
	 */
	private Label resultExceptionIcon;

	/**
	 * The success count.
	 */
	private Label resultSuccessCountLabel;

	/**
	 * The failure count.
	 */
	private Label resultFailureCountLabel;

	/**
	 * The exception count.
	 */
	private Label resultExceptionCountLabel;

	/**
	 * The progress bar displaying the test execution progress.
	 */
	private ProgressBar executionProgress;

	/**
	 * The background color for table test results (successful tests).
	 */
	private Color resultTableSuccessColor;

	/**
	 * The background color for failed table test results (failed tests).
	 */
	private Color resultTableFailureColor;

	/**
	 * The action that connects to a test runner.
	 */
	private Action connectToTestRunnerAction;

	/**
	 * The action that allows test continuation.
	 */
	private Action playAction;

	/**
	 * The action that allows to pause a running test execution.
	 */
	private Action pauseAction;

	/**
	 * The action for single-stepping test execution steps.
	 */
	private Action stepIntoAction;

	/**
	 * The action for stepping over suite calls.
	 */
	private Action stepOverAction;

	/**
	 * The action that runs a predefined launch config and connects to the test runner automatically.
	 */
	private Action executeTestAction;

	/**
	 * The action allowing to configure what is executed with {@link #executeTestAction}.
	 */
	private Action configureTestAction;

	/**
	 * The remoting client instance.
	 */
	private IntegrityRemotingClient client;

	/**
	 * The currently used set list instance.
	 */
	private SetList setList;

	/**
	 * The set of breakpoints currently in use.
	 */
	private Set<Integer> breakpointSet = Collections.synchronizedSet(new HashSet<Integer>());

	/**
	 * The launch configuration to run when the start button in the view is pressed.
	 */
	private ILaunchConfiguration launchConfiguration;

	/**
	 * The constructor.
	 */
	public IntegrityTestRunnerView() {
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize it.
	 */
	// SUPPRESS CHECKSTYLE MethodLength
	public void createPartControl(final Composite aParent) {
		aParent.setLayout(new FillLayout());

		final FormToolkit tempToolkit = new FormToolkit(aParent.getDisplay());

		resultSuccessColor = new Color(Display.getCurrent(), 0, 94, 13);
		resultFailureColor = new Color(Display.getCurrent(), 190, 0, 0);
		resultNeutralColor = new Color(Display.getCurrent(), 0, 0, 0);
		resultExceptionColor = new Color(Display.getCurrent(), 204, 163, 0);

		resultTableSuccessColor = new Color(Display.getCurrent(), 205, 255, 222);
		resultTableFailureColor = new Color(Display.getCurrent(), 255, 130, 130);

		resultSuccessIconImage = Activator.getImageDescriptor("icons/suite_success_big.png").createImage();
		resultFailureIconImage = Activator.getImageDescriptor("icons/suite_failure_big.png").createImage();
		resultExceptionIconImage = Activator.getImageDescriptor("icons/suite_exception_big.png").createImage();

		sashForm = new SashForm(aParent, SWT.HORIZONTAL | SWT.SMOOTH);

		treeContainer = new Form(sashForm, SWT.NONE);
		treeContainer.setText("Not connected");
		treeContainer.getBody().setLayout(new FormLayout());
		treeContainer.setBackground(tempToolkit.getColors().getBackground());
		treeContainer.setForeground(tempToolkit.getColors().getColor(IFormColors.TITLE));
		treeContainer.setFont(JFaceResources.getHeaderFont());
		tempToolkit.decorateFormHeading(treeContainer);

		executionProgress = new ProgressBar(treeContainer.getBody(), SWT.NONE);
		FormData tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 0);
		tempFormData.right = new FormAttachment(100, 0);
		tempFormData.top = new FormAttachment(0, 0);
		tempFormData.bottom = new FormAttachment(0, 16);
		executionProgress.setLayoutData(tempFormData);

		treeViewer = new TreeViewer(treeContainer.getBody(), SWT.VIRTUAL | SWT.H_SCROLL | SWT.V_SCROLL);
		treeViewer.setUseHashlookup(true);
		treeViewer.setContentProvider(new TestTreeContentProvider(treeViewer));
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 0);
		tempFormData.right = new FormAttachment(100, 0);
		tempFormData.top = new FormAttachment(executionProgress, 0);
		tempFormData.bottom = new FormAttachment(100, 0);
		treeViewer.getTree().setLayoutData(tempFormData);

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

		fixtureLinkGroup = new HyperlinkGroup(aParent.getDisplay());
		fixtureLink = new Hyperlink(details.getBody(), SWT.NONE);
		fixtureLink.setBackground(details.getBackground());
		fixtureLink.setText("");
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 5);
		tempFormData.right = new FormAttachment(100, -5);
		tempFormData.top = new FormAttachment(0, 3);
		tempFormData.height = 10;
		fixtureLink.setLayoutData(tempFormData);
		fixtureLink.addHyperlinkListener(new HyperlinkAdapter() {
			public void linkActivated(HyperlinkEvent anEvent) {
				jumpToJavaMethod(anEvent.getLabel());
			}
		});
		fixtureLinkGroup.add(fixtureLink);

		forkLabel = new Label(details.getBody(), SWT.NONE);
		forkLabel.setText("");
		forkLabel.setBackground(tempToolkit.getColors().getBackground());
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 5);
		tempFormData.right = new FormAttachment(100, -5);
		tempFormData.top = new FormAttachment(fixtureLink, 3);
		tempFormData.height = 14;
		forkLabel.setLayoutData(tempFormData);

		detailGroups = new Composite(details.getBody(), SWT.NONE);
		detailGroups.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
		detailGroups.setLayout(new FormLayout());
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 5);
		tempFormData.right = new FormAttachment(100, -5);
		tempFormData.top = new FormAttachment(forkLabel, 3);
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

		resultTableComposite = tempToolkit.createComposite(resultComposite);
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 5);
		tempFormData.right = new FormAttachment(100, -5);
		tempFormData.top = new FormAttachment(resultComposite, 10);
		tempFormData.bottom = new FormAttachment(resultComposite, 160, SWT.BOTTOM);
		resultTableComposite.setLayoutData(tempFormData);
		resultTableComposite.setLayout(new FillLayout());

		resultTable = new TableViewer(resultTableComposite);
		resultTable.setContentProvider(new ArrayContentProvider());
		configureResultTable(resultTable);

		varUpdateTableComposite = tempToolkit.createComposite(resultComposite);
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 5);
		tempFormData.right = new FormAttachment(100, -5);
		tempFormData.top = new FormAttachment(resultComposite, 10);
		tempFormData.bottom = new FormAttachment(resultComposite, 160, SWT.BOTTOM);
		varUpdateTableComposite.setLayoutData(tempFormData);
		varUpdateTableComposite.setLayout(new FillLayout());

		varUpdateTable = new TableViewer(varUpdateTableComposite);
		varUpdateTable.setContentProvider(new ArrayContentProvider());
		configureVarUpdateTable(varUpdateTable);

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

		PlatformUI.getWorkbench().getHelpSystem().setHelp(treeViewer.getControl(), "de.gebit.integrity.eclipse.viewer");
		attachTreeInteractionListeners();
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
			public String getText(Object anElement) {
				SetListEntry tempEntry = (SetListEntry) anElement;
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
			public String getText(Object anElement) {
				SetListEntry tempEntry = (SetListEntry) anElement;
				return (String) tempEntry.getAttribute(SetListEntryAttributeKeys.VALUE);
			}
		});
	}

	private void configureResultTable(final TableViewer aTable) {
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
			public String getText(Object anElement) {
				SetListEntry tempEntry = (SetListEntry) anElement;
				return (String) tempEntry.getAttribute(SetListEntryAttributeKeys.NAME);
			}

			@Override
			public Color getBackground(Object anElement) {
				SetListEntry tempEntry = (SetListEntry) anElement;
				Boolean tempSuccess = (Boolean) tempEntry.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG);
				if (tempSuccess == null) {
					return super.getBackground(anElement);
				} else if (tempSuccess) {
					return resultTableSuccessColor;
				} else {
					return resultTableFailureColor;
				}
			}
		});

		tempColumn = new TableViewerColumn(aTable, SWT.NONE);
		tempColumn.getColumn().setText("Result");
		tempColumn.getColumn().setWidth(150);
		tempColumn.getColumn().setResizable(true);
		tempColumn.getColumn().setMoveable(false);
		tempColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object anElement) {
				SetListEntry tempEntry = (SetListEntry) anElement;
				return (String) tempEntry.getAttribute(SetListEntryAttributeKeys.VALUE);
			}

			@Override
			public Color getBackground(Object anElement) {
				SetListEntry tempEntry = (SetListEntry) anElement;
				Boolean tempSuccess = (Boolean) tempEntry.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG);
				if (tempSuccess == null) {
					return super.getBackground(anElement);
				} else if (tempSuccess) {
					return resultTableSuccessColor;
				} else {
					return resultTableFailureColor;
				}
			}
		});

		tempColumn = new TableViewerColumn(aTable, SWT.NONE);
		tempColumn.getColumn().setText("Expected");
		tempColumn.getColumn().setWidth(150);
		tempColumn.getColumn().setResizable(true);
		tempColumn.getColumn().setMoveable(false);
		tempColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object anElement) {
				SetListEntry tempEntry = (SetListEntry) anElement;
				return (String) tempEntry.getAttribute(SetListEntryAttributeKeys.EXPECTED_RESULT);
			}

			@Override
			public Color getBackground(Object anElement) {
				SetListEntry tempEntry = (SetListEntry) anElement;
				Boolean tempSuccess = (Boolean) tempEntry.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG);
				if (tempSuccess == null) {
					return super.getBackground(anElement);
				} else if (tempSuccess) {
					return resultTableSuccessColor;
				} else {
					return resultTableFailureColor;
				}
			}
		});
	}

	private void configureVarUpdateTable(final TableViewer aTable) {
		aTable.getTable().setHeaderVisible(true);
		aTable.getTable().setLinesVisible(true);

		TableViewerColumn tempColumn = new TableViewerColumn(aTable, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL
				| SWT.FULL_SELECTION);
		tempColumn.getColumn().setText("Result");
		tempColumn.getColumn().setWidth(150);
		tempColumn.getColumn().setResizable(true);
		tempColumn.getColumn().setMoveable(false);
		tempColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object anElement) {
				SetListEntry tempEntry = (SetListEntry) anElement;
				return (String) tempEntry.getAttribute(SetListEntryAttributeKeys.PARAMETER_NAME);
			}
		});

		tempColumn = new TableViewerColumn(aTable, SWT.NONE);
		tempColumn.getColumn().setText("Variable");
		tempColumn.getColumn().setWidth(150);
		tempColumn.getColumn().setResizable(true);
		tempColumn.getColumn().setMoveable(false);
		tempColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object anElement) {
				SetListEntry tempEntry = (SetListEntry) anElement;
				return (String) tempEntry.getAttribute(SetListEntryAttributeKeys.VARIABLE_NAME);
			}
		});

		tempColumn = new TableViewerColumn(aTable, SWT.NONE);
		tempColumn.getColumn().setText("Value");
		tempColumn.getColumn().setWidth(150);
		tempColumn.getColumn().setResizable(true);
		tempColumn.getColumn().setMoveable(false);
		tempColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object anElement) {
				SetListEntry tempEntry = (SetListEntry) anElement;
				return (String) tempEntry.getAttribute(SetListEntryAttributeKeys.VALUE);
			}
		});
	}

	private void configureTextFieldBorder(final Composite aBorder) {
		aBorder.addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent anEvent) {
				GC tempGC = anEvent.gc;
				tempGC.setForeground(aBorder.getForeground());
				Rectangle tempRect = aBorder.getBounds();

				tempGC.drawRectangle(0, 0, tempRect.width - 1, tempRect.height - 1);
			}
		});
	}

	private void attachTreeInteractionListeners() {
		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent anEvent) {
				if (anEvent.getSelection().isEmpty()) {
					updateDetailPanel(null, null);
				} else {
					if (anEvent.getSelection() instanceof TreeSelection) {
						TreeSelection tempSelection = (TreeSelection) anEvent.getSelection();
						if (tempSelection.getFirstElement() instanceof SetListEntry) {
							SetListEntry tempEntry = (SetListEntry) tempSelection.getFirstElement();
							if (tempEntry.getType() == SetListEntryTypes.COMMENT) {
								updateDetailPanel(null, null);
							} else {
								updateDetailPanel(tempEntry,
										(ILabelProvider) ((TreeViewer) anEvent.getSource()).getLabelProvider());
							}
						}
					}
				}
			}
		});
	}

	private void hookContextMenu() {
		MenuManager tempMenuMgr = new MenuManager("#PopupMenu");
		tempMenuMgr.setRemoveAllWhenShown(true);
		tempMenuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager aManager) {
				IntegrityTestRunnerView.this.fillContextMenu(aManager);
			}
		});
		Menu tempMenu = tempMenuMgr.createContextMenu(treeViewer.getControl());
		treeViewer.getControl().setMenu(tempMenu);
		getSite().registerContextMenu(tempMenuMgr, treeViewer);
	}

	private void contributeToActionBars() {
		IActionBars tempBars = getViewSite().getActionBars();
		fillLocalPullDown(tempBars.getMenuManager());
		fillLocalToolBar(tempBars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager aManager) {
		aManager.add(playAction);
		aManager.add(pauseAction);
		aManager.add(stepIntoAction);
		aManager.add(new Separator());
		aManager.add(connectToTestRunnerAction);
	}

	private void fillContextMenu(IMenuManager aManager) {
		if (treeViewer.getSelection().isEmpty()) {
			return;
		}

		if (treeViewer.getSelection() instanceof IStructuredSelection) {
			IStructuredSelection tempSelection = (IStructuredSelection) treeViewer.getSelection();
			if (tempSelection.getFirstElement() instanceof SetListEntry) {
				final SetListEntry tempEntry = (SetListEntry) tempSelection.getFirstElement();

				if (tempEntry.getType() == SetListEntryTypes.TEST || tempEntry.getType() == SetListEntryTypes.CALL) {
					if (breakpointSet.contains(tempEntry.getId())) {
						aManager.add(new BreakpointAction(tempEntry.getId(), "Remove Breakpoint",
								"Removes the breakpoint from the selected step.") {
							public void run() {
								client.deleteBreakpoint(tempEntry.getId());
							}
						});
					} else {
						aManager.add(new BreakpointAction(tempEntry.getId(), "Add Breakpoint",
								"Adds a breakpoint to the selected step.") {
							public void run() {
								client.createBreakpoint(tempEntry.getId());
							}
						});
					}
				}
			}
		}
	}

	private void fillLocalToolBar(IToolBarManager aManager) {
		// These are still in development...
		aManager.add(executeTestAction);
		aManager.add(configureTestAction);
		aManager.add(new Separator());
		aManager.add(playAction);
		aManager.add(pauseAction);
		aManager.add(stepIntoAction);
		aManager.add(stepOverAction);
		aManager.add(new Separator());
		aManager.add(connectToTestRunnerAction);
	}

	private void makeActions() {
		connectToTestRunnerAction = new Action() {
			private String lastHostname = "localhost";

			public void run() {
				if (client == null || !client.isActive()) {
					InputDialog tempDialog = new InputDialog(getSite().getShell(), "Connect to test runner",
							"Please enter the hostname or IP address to connect to", lastHostname, null);
					if (tempDialog.open() == IStatus.OK && tempDialog.getValue() != null
							&& tempDialog.getValue().length() > 0) {
						lastHostname = tempDialog.getValue();
						String tempHost = lastHostname;
						int tempPort = IntegrityRemotingConstants.DEFAULT_PORT;
						if (tempHost.contains(":")) {
							try {
								tempPort = Integer.parseInt(tempHost.substring(tempHost.indexOf(':') + 1));
							} catch (NumberFormatException exc) {
								showMessage("The port number given is illegal.");
								return;
							} catch (IndexOutOfBoundsException exc) {
								showMessage("No port number given.");
								return;
							}
							tempHost = tempHost.substring(0, tempHost.indexOf(':'));
						}
						connectToTestRunnerAsync(tempHost, tempPort);
					}
				} else {
					disconnectFromTestRunner();
				}
			}
		};

		playAction = new Action() {
			public void run() {
				client.controlExecution(ExecutionCommands.RUN);
				updateStatus("Continuing test execution...");
			}
		};
		playAction.setText("Start or continue test execution");
		playAction.setToolTipText("Continues test execution if currently paused.");
		playAction.setImageDescriptor(Activator.getImageDescriptor("icons/play_enabled.gif"));
		playAction.setDisabledImageDescriptor(Activator.getImageDescriptor("icons/play_disabled.gif"));

		pauseAction = new Action() {
			public void run() {
				client.controlExecution(ExecutionCommands.PAUSE);
				updateStatus("Pausing test execution...");
			}
		};
		pauseAction.setText("Pause test execution");
		pauseAction.setToolTipText("Interrupts test execution; the currently running test will be finished though.");
		pauseAction.setImageDescriptor(Activator.getImageDescriptor("icons/pause_enabled.gif"));
		pauseAction.setDisabledImageDescriptor(Activator.getImageDescriptor("icons/pause_disabled.gif"));

		stepIntoAction = new Action() {
			public void run() {
				client.controlExecution(ExecutionCommands.STEP_INTO);
				updateStatus("Executing single step...");
			}
		};
		stepIntoAction.setText("Single step / step into");
		stepIntoAction.setToolTipText("Executes a single test or call.");
		stepIntoAction.setImageDescriptor(Activator.getImageDescriptor("icons/stepinto_enabled.gif"));
		stepIntoAction.setDisabledImageDescriptor(Activator.getImageDescriptor("icons/stepinto_disabled.gif"));

		stepOverAction = new Action() {
			@SuppressWarnings("unchecked")
			public void run() {
				SetListEntry tempTarget = null;
				SetListEntry tempCurrentSuite = setList.getParent(setList.getEntryInExecution());
				if (tempCurrentSuite != null) {
					SetListEntry tempOuterSuite = setList.getParent(tempCurrentSuite);
					while (tempOuterSuite != null && tempTarget == null) {
						List<Integer> tempSetupStatements = (List<Integer>) tempOuterSuite
								.getAttribute(SetListEntryAttributeKeys.SETUP);
						List<Integer> tempSuiteStatements = (List<Integer>) tempOuterSuite
								.getAttribute(SetListEntryAttributeKeys.STATEMENTS);
						List<Integer> tempTeardownStatements = (List<Integer>) tempOuterSuite
								.getAttribute(SetListEntryAttributeKeys.TEARDOWN);
						List<Integer> tempAllStatements = new LinkedList<Integer>();
						if (tempSetupStatements != null) {
							tempAllStatements.addAll(tempSetupStatements);
						}
						if (tempSuiteStatements != null) {
							tempAllStatements.addAll(tempSuiteStatements);
						}
						if (tempTeardownStatements != null) {
							tempAllStatements.addAll(tempTeardownStatements);
						}

						int tempPos = tempAllStatements.indexOf(tempCurrentSuite.getId()) + 1;
						if (tempPos == 0 || tempPos >= tempAllStatements.size()) {
							tempOuterSuite = setList.getParent(tempOuterSuite);
						} else {
							tempTarget = setList.resolveReference(tempAllStatements.get(tempPos));
						}
					}
				}

				if (tempTarget != null) {
					while (tempTarget != null && tempTarget.getType() != SetListEntryTypes.CALL
							&& tempTarget.getType() != SetListEntryTypes.TEST) {
						tempTarget = setList.resolveReference(tempTarget.getId() + 1);
					}
				}

				if (tempTarget != null) {
					client.createBreakpoint(tempTarget.getId());
					client.controlExecution(ExecutionCommands.RUN);
					updateStatus("Executing until end of current suite...");
				} else {
					client.controlExecution(ExecutionCommands.RUN);
					updateStatus("Continuing test execution...");
				}
			}
		};
		stepOverAction.setText("Single step / step into");
		stepOverAction.setToolTipText("Places a breakpoint after the current suite call and continues execution.");
		stepOverAction.setImageDescriptor(Activator.getImageDescriptor("icons/stepover_enabled.gif"));
		stepOverAction.setDisabledImageDescriptor(Activator.getImageDescriptor("icons/stepover_disabled.gif"));

		executeTestAction = new Action() {
			public void run() {
				if (launchConfiguration != null) {
					try {
						executeTestAction.setEnabled(false);
						final ILaunch tempLaunch = launchConfiguration.launch(ILaunchManager.RUN_MODE, null);
						new Thread() {
							@SuppressWarnings("restriction")
							@Override
							public void run() {
								boolean tempSuccess = false;

								while (!tempLaunch.isTerminated()) {
									try {
										if (!tempSuccess && !isConnected()) {
											// try to connect at least once
											connectToTestRunner("localhost", IntegrityRemotingConstants.DEFAULT_PORT);
											tempSuccess = true;
										} else {
											// Now we'll wait until the launch has terminated
											try {
												Thread.sleep(1000);
											} catch (InterruptedException exc) {
												// don't care
											}
										}
									} catch (UnknownHostException exc) {
										// exceptions are expected, that just means we need to retry
									} catch (IOException exc) {
										// exceptions are expected, that just means we need to retry
									}
								}
								executeTestAction.setEnabled(true);
							};
						}.start();
					} catch (CoreException exc) {
						showException(exc);
					}
				}
			}
		};
		executeTestAction.setText("Launch test application");
		executeTestAction.setToolTipText("Launches the test run configuration.");
		executeTestAction.setImageDescriptor(Activator.getImageDescriptor("icons/exec_enabled.gif"));
		executeTestAction.setEnabled(false);

		configureTestAction = new Action() {
			public void run() {
				TestActionConfigurationDialog tempDialog = new TestActionConfigurationDialog(getSite().getShell());
				if (tempDialog.open() == Dialog.OK) {
					launchConfiguration = tempDialog.getSelectedConfiguration();
					if (launchConfiguration != null) {
						executeTestAction.setEnabled(true);
					}
				}
			}
		};
		configureTestAction.setText("Configure test application");
		configureTestAction.setToolTipText("Configures the test run configuration(s) to launch.");
		configureTestAction.setImageDescriptor(Activator.getImageDescriptor("icons/exec_config_enabled.gif"));

		updateActionStatus(null);
	}

	private boolean isConnected() {
		return (client != null && client.isActive());
	}

	private void updateActionStatus(final ExecutionStates anExecutionState) {
		Runnable tempRunnable = new Runnable() {

			@Override
			public void run() {
				if (!isConnected()) {
					connectToTestRunnerAction.setText("Connect to test runner");
					connectToTestRunnerAction.setToolTipText("Connects to a local or remote test runner");
					connectToTestRunnerAction.setImageDescriptor(Activator.getImageDescriptor("icons/connect.gif"));
					playAction.setEnabled(false);
					pauseAction.setEnabled(false);
					stepIntoAction.setEnabled(false);
					stepOverAction.setEnabled(false);
				} else {
					connectToTestRunnerAction.setText("Disconnect from test runner");
					connectToTestRunnerAction
							.setToolTipText("Disconnects the client from the currently connected test runner");
					connectToTestRunnerAction.setImageDescriptor(Activator.getImageDescriptor("icons/disconnect.gif"));
					if (anExecutionState == null) {
						playAction.setEnabled(false);
						pauseAction.setEnabled(false);
						stepIntoAction.setEnabled(false);
						stepOverAction.setEnabled(false);
					} else {
						switch (anExecutionState) {
						case BLOCKED:
							playAction.setEnabled(true);
							pauseAction.setEnabled(false);
							stepIntoAction.setEnabled(true);
							stepOverAction.setEnabled(true);
							updateStatus("Waiting for execution start");
							break;
						case PAUSED:
							playAction.setEnabled(true);
							pauseAction.setEnabled(false);
							stepIntoAction.setEnabled(true);
							stepOverAction.setEnabled(true);
							updateStatus("Paused test execution");
							break;
						case RUNNING:
							playAction.setEnabled(false);
							pauseAction.setEnabled(true);
							stepIntoAction.setEnabled(false);
							stepOverAction.setEnabled(false);
							updateStatus("Running tests...");
							break;
						case ENDED:
							playAction.setEnabled(false);
							pauseAction.setEnabled(false);
							stepIntoAction.setEnabled(false);
							stepOverAction.setEnabled(false);
							updateStatus("Test execution finished");
							break;
						default:
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

	// SUPPRESS CHECKSTYLE MethodLength
	private void updateDetailPanel(SetListEntry anEntry, ILabelProvider aProvider) {
		fixtureLink.setVisible(false);
		forkLabel.setVisible(false);
		resultTableComposite.setVisible(false);
		varUpdateTableComposite.setVisible(false);
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
				if (anEntry.getType() == SetListEntryTypes.RESULT) {
					fixtureLink.setText((String) setList.getParent(anEntry).getAttribute(
							SetListEntryAttributeKeys.FIXTURE));
				} else {
					fixtureLink.setText((String) anEntry.getAttribute(SetListEntryAttributeKeys.FIXTURE));
				}
				fixtureLink.setVisible(true);
			}

			String[] tempForkName = setList.getForkExecutingEntry(anEntry);
			if (tempForkName != null) {
				String tempLabelText = "executed on fork '" + tempForkName[0] + "'";
				if (tempForkName[1] != null) {
					tempLabelText += " (" + tempForkName[1] + ")";
				}
				forkLabel.setText(tempLabelText);
				forkLabel.setVisible(true);
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

			SetListEntry tempResultEntry = null;
			if (anEntry.getType() == SetListEntryTypes.TABLETEST) {
				// High-level table test summary information is stored in the
				// tabletest entry itself
				tempResultEntry = anEntry;
			} else if (anEntry.getType() == SetListEntryTypes.RESULT) {
				// result entries are results by themselves ;-)
				tempResultEntry = anEntry;
			} else {
				tempResultEntry = setList.resolveReferences(anEntry, SetListEntryAttributeKeys.RESULT).get(0);
			}

			if (tempResultEntry != null) {
				switch (anEntry.getType()) {
				case SUITE:
				case TABLETEST:
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
					} else {
						resultLine1Name.setText("No results available - please run the tests first.");
						resultLine1Name.setVisible(true);
					}
					break;
				case TEST:
				case RESULT:
					@SuppressWarnings("unchecked")
					List<SetListEntry> tempComparisonEntries = setList
							.resolveReferences(((List<Integer>) tempResultEntry
									.getAttribute(SetListEntryAttributeKeys.COMPARISONS)));

					if (tempComparisonEntries.size() > 1) {
						resultTable.setInput(tempComparisonEntries);
						resultTableComposite.setVisible(true);
					} else {
						SetListEntry tempComparisonEntry = tempComparisonEntries.get(0);
						resultLine2Name.setText("Expected value: ");
						resultLine2Text.setText((String) tempComparisonEntry
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
							if (tempComparisonEntry.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG) != null) {
								resultLine1Name.setText("Result returned by the test fixture: ");
								resultLine1Text.setText((String) tempComparisonEntry
										.getAttribute(SetListEntryAttributeKeys.VALUE));
								if (tempComparisonEntry.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG) != null) {
									if (Boolean.TRUE.equals(tempComparisonEntry
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
					}
					break;
				case CALL:
					if (tempResultEntry.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG) != null) {
						if (tempResultEntry.getAttribute(SetListEntryAttributeKeys.EXCEPTION) != null) {
							resultLine1Name.setText("Exception occurred while running the test fixture:");
							resultLine1Text.setText((String) tempResultEntry
									.getAttribute(SetListEntryAttributeKeys.EXCEPTION));
							resultLine1Border.setForeground(resultExceptionColor);
							resultLine1Border.setVisible(true);
						} else {
							List<SetListEntry> tempVarUpdates = setList.resolveReferences(tempResultEntry,
									SetListEntryAttributeKeys.VARIABLE_UPDATES);

							if (tempVarUpdates.size() == 1) {
								String tempResultValue = (String) tempVarUpdates.get(0).getAttribute(
										SetListEntryAttributeKeys.VALUE);
								String tempTargetVariable = (String) tempVarUpdates.get(0).getAttribute(
										SetListEntryAttributeKeys.VARIABLE_NAME);
								if (tempTargetVariable != null) {
									tempResultValue += " ➔ " + tempTargetVariable;
								}
								resultLine1Name.setText("Result returned by the fixture:");
								resultLine1Text.setText(tempResultValue);
								resultLine1Border.setForeground(resultNeutralColor);
								resultLine1Border.setVisible(true);
							} else if (tempVarUpdates.size() > 1) {
								varUpdateTable.setInput(tempVarUpdates);
								varUpdateTableComposite.setVisible(true);
							} else {
								resultLine1Name.setText("No result returned by the fixture.");
							}
						}
					} else {
						resultLine1Name.setText("No result available - please run the tests first.");
					}
					resultLine1Name.setVisible(true);
					break;
				default:
					break;
				}
			}
		}
	}

	private void showMessage(final String aMessage) {
		Runnable tempRunnable = new Runnable() {
			@Override
			public void run() {
				MessageDialog.openInformation(treeViewer.getControl().getShell(), "Integrity Test Runner", aMessage);
			}
		};

		Display.getDefault().asyncExec(tempRunnable);
	}

	private void showException(final Exception anException) {
		Runnable tempRunnable = new Runnable() {
			@Override
			public void run() {
				MessageDialog.openError(treeViewer.getControl().getShell(), "Integrity Test Runner",
						anException.getLocalizedMessage());
			}
		};

		Display.getDefault().asyncExec(tempRunnable);
	}

	private void updateStatus(final String aStatus) {
		Runnable tempRunnable = new Runnable() {

			@Override
			public void run() {
				treeContainer.setText(aStatus);
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

	private void connectToTestRunnerAsync(final String aHost, final int aPort) {
		new Thread("Test Runner Connect Thread") {

			@Override
			public void run() {
				try {
					connectToTestRunner(aHost, aPort);
					return;
				} catch (UnknownHostException exc) {
					showMessage("Target host name '" + aHost + "' could not be resolved.");
				} catch (IOException exc) {
					showMessage("Error while connecting to '" + aHost + "': " + exc.getMessage());
				}
			}

		}.start();
	}

	private void connectToTestRunner(final String aHost, final int aPort) throws UnknownHostException, IOException {
		updateStatus("Connecting...");
		boolean tempSuccessful = false;
		try {
			client = new IntegrityRemotingClient(aHost, aPort, new RemotingListener());
			tempSuccessful = true;
			updateStatus("Connected, downloading test data...");
		} finally {
			if (!tempSuccessful) {
				updateStatus("Not connected");
			}
		}
	}

	private void disconnectFromTestRunner() {
		client.close();
		client = null;
		updateActionStatus(null);
		updateStatus("Not connected");
	}

	private void jumpToJavaMethod(String aJavaClassAndMethod) {
		Matcher tempMatcher = Pattern.compile("([^#]*)\\.([^#]*)#(.*)").matcher(aJavaClassAndMethod);
		if (tempMatcher.matches()) {
			final String tempPackageName = tempMatcher.group(1);
			String tempClassName = tempMatcher.group(2);
			final String tempMethodName = tempMatcher.group(3);

			SearchPattern tempPattern = SearchPattern.createPattern(tempClassName, IJavaSearchConstants.TYPE,
					IJavaSearchConstants.DECLARATIONS, SearchPattern.R_EXACT_MATCH | SearchPattern.R_CASE_SENSITIVE);
			IJavaSearchScope tempScope = SearchEngine.createWorkspaceScope();
			SearchRequestor tempRequestor = new SearchRequestor() {

				@Override
				public void acceptSearchMatch(SearchMatch aMatch) throws CoreException {
					IType tempType = (IType) aMatch.getElement();
					if (tempPackageName.equals(tempType.getPackageFragment().getElementName())) {
						for (IMethod tempMethod : tempType.getMethods()) {
							if (tempMethodName.equals(tempMethod.getElementName())) {
								JavaUI.openInEditor(tempMethod);
								return;
							}
						}
					}
				}
			};

			SearchEngine tempSearchEngine = new SearchEngine();
			try {
				tempSearchEngine.search(tempPattern,
						new SearchParticipant[] { SearchEngine.getDefaultSearchParticipant() }, tempScope,
						tempRequestor, null);
			} catch (CoreException exc) {
				exc.printStackTrace();
			}
		}
	}

	private class RemotingListener implements IntegrityRemotingClientListener {

		@Override
		public void onConnectionSuccessful(IntegrityRemotingVersionMessage aRemoteVersion, Endpoint anEndpoint) {
			// request set list baseline and execution state
			anEndpoint.sendMessage(new SetListBaselineMessage(null));
			anEndpoint.sendMessage(new ExecutionStateMessage(null));
			updateActionStatus(client.getExecutionState());
		}

		@Override
		public void onVersionMismatch(IntegrityRemotingVersionMessage aRemoteVersion, Endpoint anEndpoint) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onBaselineReceived(SetList aSetList, Endpoint anEndpoint) {
			setList = aSetList;
			breakpointSet.clear();
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					treeViewer.setInput(setList);
					executionProgress.setSetList(setList);
					executionProgress.redraw();

					// the following will automatically dispose the old
					// provider!
					treeViewer.setLabelProvider(new TestTreeLabelProvider(setList, breakpointSet, Display.getCurrent(),
							treeViewer));

					// the drawer must be manually disposed
					if (viewerContentDrawer != null) {
						viewerContentDrawer.dispose(treeViewer.getTree());
					}
					viewerContentDrawer = new TestTreeContentDrawer(setList, breakpointSet, Display.getCurrent());
					viewerContentDrawer.attachToTree(treeViewer.getTree());

					updateStatus("Connected and ready");
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
			updateStatus("Not connected");
		}

		@Override
		public void onSetListUpdate(final SetListEntry[] someUpdatedEntries, final Integer anEntryInExecutionReference,
				Endpoint anEndpoint) {
			setList.integrateUpdates(someUpdatedEntries);
			if (anEntryInExecutionReference != null) {
				setList.setEntryInExecutionReference(anEntryInExecutionReference);
			}
			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run() {
					for (SetListEntry tempEntry : someUpdatedEntries) {
						switch (tempEntry.getType()) {
						case RESULT:
							treeViewer.update(setList.getParent(tempEntry), null);
							treeViewer.update(tempEntry, null);
							break;
						default:
							treeViewer.update(tempEntry, null);
						}
					}
					if (anEntryInExecutionReference != null) {
						for (SetListEntry tempEntry : setList.getEntriesInExecution()) {
							treeViewer.update(tempEntry, null);
						}
					}
					executionProgress.redraw();
				}
			});
		}

		@Override
		public void onConfirmCreateBreakpoint(final int anEntryReference, Endpoint anEndpoint) {
			breakpointSet.add(anEntryReference);
			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run() {
					treeViewer.update(setList.resolveReference(anEntryReference), null);
				}
			});
		}

		@Override
		public void onConfirmRemoveBreakpoint(final int anEntryReference, Endpoint anEndpoint) {
			breakpointSet.remove(anEntryReference);
			Display.getDefault().syncExec(new Runnable() {
				@Override
				public void run() {
					treeViewer.update(setList.resolveReference(anEntryReference), null);
				}
			});
		}

		@Override
		public void onTestRunnerCallbackMessageRetrieval(String aCallbackClassName, TestRunnerCallbackMethods aMethod,
				Serializable[] someData) {
			// not used in this context
		}

		@Override
		public void onVariableUpdateRetrieval(String aVariableName, Serializable aValue) {
			// not used in this context
		}
	}
}