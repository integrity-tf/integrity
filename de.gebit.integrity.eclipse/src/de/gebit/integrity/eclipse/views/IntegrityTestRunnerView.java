/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.eclipse.views;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.LinkedBlockingQueue;
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
import org.eclipse.jface.action.IAction;
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
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
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
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
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

import com.google.inject.Inject;

import de.gebit.integrity.eclipse.Activator;
import de.gebit.integrity.eclipse.actions.BreakpointAction;
import de.gebit.integrity.eclipse.actions.JumpToLinkAction;
import de.gebit.integrity.eclipse.controls.ProgressBar;
import de.gebit.integrity.eclipse.running.TestActionConfigurationDialog;
import de.gebit.integrity.eclipse.search.SetListSearch;
import de.gebit.integrity.remoting.IntegrityRemotingConstants;
import de.gebit.integrity.remoting.client.IntegrityRemotingClient;
import de.gebit.integrity.remoting.client.IntegrityRemotingClientListener;
import de.gebit.integrity.remoting.entities.setlist.SetList;
import de.gebit.integrity.remoting.entities.setlist.SetListEntry;
import de.gebit.integrity.remoting.entities.setlist.SetListEntryAttributeKeys;
import de.gebit.integrity.remoting.entities.setlist.SetListEntryResultStates;
import de.gebit.integrity.remoting.entities.setlist.SetListEntryTypes;
import de.gebit.integrity.remoting.transport.Endpoint;
import de.gebit.integrity.remoting.transport.enums.ExecutionCommands;
import de.gebit.integrity.remoting.transport.enums.ExecutionStates;
import de.gebit.integrity.remoting.transport.enums.TestRunnerCallbackMethods;
import de.gebit.integrity.remoting.transport.messages.ExecutionStateMessage;
import de.gebit.integrity.remoting.transport.messages.IntegrityRemotingVersionMessage;
import de.gebit.integrity.remoting.transport.messages.SetListBaselineMessage;
import de.gebit.integrity.ui.linking.IntegrityURLResolver;
import de.gebit.integrity.utils.DateUtil;

/**
 * The Integrity Test Runner Eclipse Plugin main view.
 * 
 * @author Rene Schneider - initial API and implementation
 */
public class IntegrityTestRunnerView extends ViewPart {

	/**
	 * The ID of the view as specified by the extension.
	 */
	public static final String ID = "de.gebit.integrity.eclipse.views.IntegrityTestRunnerView";

	/**
	 * The prefix for Integrity URLs. Required to add to links provided by {@link SetListEntry} instances, which don't
	 * include the prefix to save some space.
	 */
	protected static final String INTEGRITY_URL_PREFIX = "integrity://";

	/**
	 * Height of the result text fields.
	 */
	private static final int RESULT_TEXTFIELD_HEIGHT = 60;

	/**
	 * Height of larger tables in the result (variables, tabletests).
	 */
	private static final int RESULT_TABLE_HEIGHT = 230;

	/**
	 * Height of each text field for extended results in text form.
	 */
	private static final int EXTENDED_RESULT_TEXTFIELD_HEIGHT = 60;

	/**
	 * Space around images in extended result fields.
	 */
	private static final int EXTENDED_RESULT_IMAGE_SPACING = 6;

	/**
	 * Space between each extended result field.
	 */
	private static final int EXTENDED_RESULT_SPACING = 5;

	/**
	 * The "magic search term" for failed test/calls.
	 */
	private static final String MAGIC_SEARCH_TERM_FAILURES = "Tests/Calls with failures or exceptions";

	/**
	 * The Integrity URL resolver.
	 */
	@Inject
	private IntegrityURLResolver urlResolver;

	/**
	 * The sash form used to split the screen in one half for the tree, and another for the details view.
	 */
	private SashForm sashForm;

	/**
	 * The container for the tree.
	 */
	private Form treeContainer;

	/**
	 * This container is placed below the tree and contains the UI elements of the tree search function.
	 */
	private Composite searchContainer;

	/**
	 * The text input field for the tree search.
	 */
	private Text searchTextField;

	/**
	 * A flag used to determine whether the text field just gained the focus.
	 */
	private boolean searchTextFieldJustGainedFocus;

	/**
	 * The "search for error/exception" button for the tree search.
	 */
	private Button searchErrorButton;

	/**
	 * The image for the {@link #searchErrorButton}.
	 */
	private Image searchErrorButtonEnabledImage;

	/**
	 * The "previous result" button for the tree search.
	 */
	private Button searchLeftButton;

	/**
	 * The image for the {@link #searchLeftButton}.
	 */
	private Image searchLeftButtonEnabledImage;

	/**
	 * The "next result" button for the tree search.
	 */
	private Button searchRightButton;

	/**
	 * The image for the {@link #searchRightButton}.
	 */
	private Image searchRightButtonEnabledImage;

	/**
	 * The label denoting the current position and number of results during searching in the tree.
	 */
	private Label searchPositionLabel;

	/**
	 * The test execution tree viewer.
	 */
	private TreeViewer treeViewer;

	/**
	 * Status flag which is used to signal whether the tree viewer is currently scrolled by the user (using the vertical
	 * scrollbar).
	 */
	private boolean treeViewerIsScrolledManually;

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
	 * The label for the third (extended result) result value.
	 */
	private Label resultLine3Name;

	/**
	 * The container for the third (extended result) result value field. This one will be dynamically filled with text
	 * fields or whatever else for displaying the varying number of extended result data objects.
	 */
	private Composite resultLine3Border;

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
	 * The background color of the search container.
	 */
	private Color searchContainerColor;

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
	 * The action for deleting all existing breakpoints.
	 */
	private Action clearBreakpointsAction;

	/**
	 * The action that runs a predefined launch config and connects to the test runner automatically.
	 */
	private Action executeTestAction;

	/**
	 * The action that runs a predefined launch config in debug mode and connects to the test runner automatically.
	 */
	private Action executeDebugTestAction;

	/**
	 * The action allowing to shut down a running test execution.
	 */
	private Action shutdownAction;

	/**
	 * The action allowing to configure what is executed with {@link #executeTestAction}.
	 */
	private Action configureTestAction;

	/**
	 * The action which expands all nodes one level further.
	 */
	private Action expandAllAction;

	/**
	 * The action which collapses all nodes.
	 */
	private Action collapseAllAction;

	/**
	 * The action which toggles the scroll lock function.
	 */
	private Action scrollLockAction;

	/**
	 * Whether scroll lock is active.
	 */
	private boolean scrollLockActive;

	/**
	 * The last level of node expansion.
	 */
	private int lastExpansionLevel;

	/**
	 * The search engine instance used to search the setlist tree.
	 */
	private SetListSearch setListSearch;

	/**
	 * The currently valid setlist tree search result. May be null if no search result is available.
	 */
	private List<SetListEntry> currentSearchResult;

	/**
	 * The current position in the setlist tree search result. May be null if no current position is available.
	 */
	private Integer currentSearchResultPosition;

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
	 * These breakpoints are to be recreated after the next connect to a test runner.
	 */
	private Set<String> breakpointsToRecreate = Collections.synchronizedSet(new HashSet<String>());

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
	@Override
	public void createPartControl(final Composite aParent) {
		aParent.setLayout(new FillLayout());

		final FormToolkit tempToolkit = new FormToolkit(aParent.getDisplay());

		resultSuccessColor = new Color(Display.getCurrent(), 0, 94, 13);
		resultFailureColor = new Color(Display.getCurrent(), 190, 0, 0);
		resultNeutralColor = new Color(Display.getCurrent(), 0, 0, 0);
		resultExceptionColor = new Color(Display.getCurrent(), 204, 163, 0);

		resultTableSuccessColor = new Color(Display.getCurrent(), 205, 255, 222);
		resultTableFailureColor = new Color(Display.getCurrent(), 255, 130, 130);

		searchContainerColor = new Color(Display.getCurrent(), 220, 220, 220);

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
		tempFormData.bottom = new FormAttachment(100, -18);
		treeViewer.getTree().setLayoutData(tempFormData);
		treeViewer.getTree().getVerticalBar().addSelectionListener(new SelectionListener() {
			@Override
			public void widgetDefaultSelected(SelectionEvent anEvent) {
				// nothing to do
			}

			@Override
			public void widgetSelected(SelectionEvent anEvent) {
				if (anEvent.detail == SWT.NONE) {
					treeViewerIsScrolledManually = false;
				} else if (anEvent.detail == SWT.DRAG) {
					treeViewerIsScrolledManually = true;
				}
			}
		});

		searchContainer = new Composite(treeContainer.getBody(), SWT.NONE);
		searchContainer.setLayout(new FormLayout());
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 0);
		tempFormData.right = new FormAttachment(100, 0);
		tempFormData.top = new FormAttachment(treeViewer.getControl(), 0);
		tempFormData.height = 18;
		searchContainer.setLayoutData(tempFormData);
		searchContainer.setBackground(searchContainerColor);

		searchErrorButtonEnabledImage = Activator.getImageDescriptor("icons/search_failed_enabled.gif").createImage();

		searchErrorButton = new Button(searchContainer, SWT.FLAT);
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 0);
		tempFormData.width = 16;
		tempFormData.top = new FormAttachment(0, 2);
		tempFormData.height = 16;
		searchErrorButton.setImage(searchErrorButtonEnabledImage);
		searchErrorButton.setLayoutData(tempFormData);
		searchErrorButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event anEvent) {
				// repeated clicks shall just jump to the next result
				if (!performTreeSearchForFailures()) {
					jumpToNextSearchResult();
				}
			}
		});

		searchTextField = new Text(searchContainer, SWT.SINGLE);
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 16);
		tempFormData.right = new FormAttachment(100, -100);
		tempFormData.top = new FormAttachment(0, 2);
		tempFormData.height = 16;
		searchTextField.setText("");
		searchTextField.setLayoutData(tempFormData);
		searchTextField.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent anEvent) {
				performTreeSearch();
			}
		});
		searchTextField.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent anEvent) {
				searchTextFieldJustGainedFocus = false;
			}

			@Override
			public void focusGained(FocusEvent anEvent) {
				searchTextFieldJustGainedFocus = true;
			}
		});
		searchTextField.addMouseListener(new MouseListener() {

			@Override
			public void mouseUp(MouseEvent anEvent) {
				// Perform a full selection of all entered text if there is text AND the text field just gained the
				// focus.
				if (searchTextFieldJustGainedFocus && searchTextField.getText().length() > 0) {
					searchTextField.selectAll();
				}
				searchTextFieldJustGainedFocus = false;
			}

			@Override
			public void mouseDown(MouseEvent anEvent) {
				// ignored
			}

			@Override
			public void mouseDoubleClick(MouseEvent anEvent) {
				// ignored
			}
		});

		searchLeftButtonEnabledImage = Activator.getImageDescriptor("icons/search_prev_enabled.gif").createImage();

		searchLeftButton = new Button(searchContainer, SWT.FLAT);
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(searchTextField, 0);
		tempFormData.width = 16;
		tempFormData.top = new FormAttachment(0, 2);
		tempFormData.height = 16;
		searchLeftButton.setImage(searchLeftButtonEnabledImage);
		searchLeftButton.setLayoutData(tempFormData);
		searchLeftButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event anEvent) {
				jumpToPreviousSearchResult();
			}
		});

		searchRightButtonEnabledImage = Activator.getImageDescriptor("icons/search_next_enabled.gif").createImage();

		searchRightButton = new Button(searchContainer, SWT.FLAT);
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(searchLeftButton, 0);
		tempFormData.width = 16;
		tempFormData.top = new FormAttachment(0, 2);
		tempFormData.height = 16;
		searchRightButton.setImage(searchRightButtonEnabledImage);
		searchRightButton.setLayoutData(tempFormData);
		searchRightButton.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event anEvent) {
				jumpToNextSearchResult();
			}
		});

		searchPositionLabel = new Label(searchContainer, SWT.NONE);
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(searchRightButton, 0);
		tempFormData.right = new FormAttachment(100, 0);
		tempFormData.top = new FormAttachment(0, 2);
		tempFormData.height = 16;
		searchPositionLabel.setBackground(searchContainerColor);
		searchPositionLabel.setLayoutData(tempFormData);
		searchPositionLabel.setText("");
		searchPositionLabel.setAlignment(SWT.CENTER);

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
			@Override
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
		GridLayout tempGridLayout = new GridLayout(1, true);
		tempGridLayout.verticalSpacing = 10;
		detailGroups.setLayout(tempGridLayout);
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 5);
		tempFormData.right = new FormAttachment(100, -5);
		tempFormData.top = new FormAttachment(forkLabel, 3);
		tempFormData.bottom = new FormAttachment(100, 0);
		detailGroups.setLayoutData(tempFormData);

		resultSection = tempToolkit.createSection(detailGroups, Section.TITLE_BAR | Section.EXPANDED);
		resultSection.setText("Result");
		GridData tempGridData = new GridData();
		tempGridData.minimumHeight = 10;
		tempGridData.horizontalIndent = 5;
		tempGridData.grabExcessHorizontalSpace = true;
		tempGridData.horizontalAlignment = GridData.FILL;
		resultSection.setLayoutData(tempGridData);
		resultSection.setLayout(new FillLayout());

		resultComposite = tempToolkit.createComposite(resultSection);
		tempToolkit.paintBordersFor(resultComposite);
		resultSection.setClient(resultComposite);
		resultComposite.setLayout(new FormLayout());

		parameterSection = tempToolkit.createSection(detailGroups, Section.TITLE_BAR | Section.EXPANDED);
		parameterSection.setText("Parameters");
		tempGridData = new GridData();
		tempGridData.minimumHeight = SWT.DEFAULT;
		tempGridData.heightHint = 130;
		tempGridData.horizontalIndent = 5;
		tempGridData.grabExcessHorizontalSpace = true;
		tempGridData.horizontalAlignment = GridData.FILL;
		parameterSection.setLayoutData(tempGridData);
		parameterSection.setLayout(new FillLayout());

		parameterComposite = tempToolkit.createComposite(parameterSection);
		tempToolkit.paintBordersFor(parameterComposite);
		parameterSection.setClient(parameterComposite);
		parameterComposite.setLayout(new FillLayout());

		parameterTable = new TableViewer(parameterComposite, SWT.FULL_SELECTION);
		parameterTable.setContentProvider(new ArrayContentProvider());
		configureTable(parameterTable);

		variableSection = tempToolkit.createSection(detailGroups, Section.TITLE_BAR | Section.EXPANDED);
		variableSection.setText("Variable definitions");
		tempGridData = new GridData();
		tempGridData.minimumHeight = SWT.DEFAULT;
		tempGridData.heightHint = 150;
		tempGridData.horizontalIndent = 5;
		tempGridData.grabExcessHorizontalSpace = true;
		tempGridData.horizontalAlignment = GridData.FILL;
		variableSection.setLayoutData(tempGridData);
		variableSection.setLayout(new FillLayout());

		variableComposite = tempToolkit.createComposite(variableSection);
		tempToolkit.paintBordersFor(variableComposite);
		variableSection.setClient(variableComposite);
		variableComposite.setLayout(new FillLayout());

		variableTable = new TableViewer(variableComposite, SWT.FULL_SELECTION);
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
		tempFormData.bottom = new FormAttachment(resultTableComposite, RESULT_TABLE_HEIGHT, SWT.TOP);
		resultTableComposite.setLayoutData(tempFormData);
		resultTableComposite.setLayout(new FillLayout());

		resultTable = new TableViewer(resultTableComposite, SWT.FULL_SELECTION);
		resultTable.setContentProvider(new ArrayContentProvider());
		configureResultTable(resultTable);

		varUpdateTableComposite = tempToolkit.createComposite(resultComposite);
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 5);
		tempFormData.right = new FormAttachment(100, -5);
		tempFormData.top = new FormAttachment(resultComposite, 10);
		tempFormData.bottom = new FormAttachment(varUpdateTableComposite, RESULT_TABLE_HEIGHT, SWT.TOP);
		varUpdateTableComposite.setLayoutData(tempFormData);
		varUpdateTableComposite.setLayout(new FillLayout());

		varUpdateTable = new TableViewer(varUpdateTableComposite, SWT.FULL_SELECTION);
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
		tempFormData.top = new FormAttachment(resultLine1Name, 2, SWT.BOTTOM);
		tempFormData.bottom = new FormAttachment(resultLine1Border, RESULT_TEXTFIELD_HEIGHT, SWT.TOP);
		resultLine1Border.setLayoutData(tempFormData);
		FillLayout tempFill = new FillLayout();
		tempFill.marginHeight = 1;
		tempFill.marginWidth = 1;
		resultLine1Border.setLayout(tempFill);
		configureTextFieldBorder(resultLine1Border);

		resultLine1Text = new Text(resultLine1Border, SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
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
		tempFormData.top = new FormAttachment(resultLine2Name, 2, SWT.BOTTOM);
		tempFormData.bottom = new FormAttachment(resultLine2Border, RESULT_TEXTFIELD_HEIGHT, SWT.TOP);
		resultLine2Border.setLayoutData(tempFormData);
		tempFill = new FillLayout();
		tempFill.marginHeight = 1;
		tempFill.marginWidth = 1;
		resultLine2Border.setLayout(tempFill);
		configureTextFieldBorder(resultLine2Border);

		resultLine2Text = new Text(resultLine2Border, SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
		resultLine2Text.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));

		resultLine3Name = new Label(resultComposite, SWT.WRAP);
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 5);
		tempFormData.right = new FormAttachment(100, -5);
		tempFormData.top = new FormAttachment(resultLine2Border, 6);
		resultLine3Name.setLayoutData(tempFormData);
		resultLine3Name.setText("Extended Result Data");

		resultLine3Border = new Composite(resultComposite, SWT.NONE);
		resultLine3Border.setForeground(resultNeutralColor);
		tempFormData = new FormData();
		tempFormData.left = new FormAttachment(0, 5);
		tempFormData.right = new FormAttachment(100, -5);
		tempFormData.top = new FormAttachment(resultLine3Name, 2, SWT.BOTTOM);
		tempFormData.bottom = new FormAttachment(resultLine3Border, 0, SWT.TOP);
		resultLine3Border.setLayoutData(tempFormData);
		resultLine3Border.setLayout(new FormLayout());
		configureTextFieldBorder(resultLine3Border);

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

		TableViewerColumn tempColumn = new TableViewerColumn(aTable,
				SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
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
			public void update(ViewerCell aCell) {
				SetListEntry tempEntry = (SetListEntry) aCell.getElement();
				aCell.setText((String) tempEntry.getAttribute(SetListEntryAttributeKeys.VALUE));
			}
		});
		// Make the value column editable, mostly to be able to copy out results. See issue #77
		tempColumn.setEditingSupport(new EditingSupport(aTable) {

			@Override
			protected void setValue(Object anElement, Object aValue) {
				// not supported, we don't really want to support editing of result values
			}

			@Override
			protected Object getValue(Object anElement) {
				SetListEntry tempEntry = (SetListEntry) anElement;
				return (String) tempEntry.getAttribute(SetListEntryAttributeKeys.VALUE);
			}

			@Override
			protected CellEditor getCellEditor(Object anElement) {
				return new TextCellEditor(aTable.getTable());
			}

			@Override
			protected boolean canEdit(Object anElement) {
				return true;
			}
		});
	}

	private void configureResultTable(final TableViewer aTable) {
		aTable.getTable().setHeaderVisible(true);
		aTable.getTable().setLinesVisible(true);

		TableViewerColumn tempColumn = new TableViewerColumn(aTable,
				SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
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
			public void update(ViewerCell aCell) {
				SetListEntry tempEntry = (SetListEntry) aCell.getElement();
				aCell.setText((String) tempEntry.getAttribute(SetListEntryAttributeKeys.VALUE));
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
		// Make the value column editable, mostly to be able to copy out results. See issue #77
		tempColumn.setEditingSupport(new EditingSupport(aTable) {

			@Override
			protected void setValue(Object anElement, Object aValue) {
				// not supported, we don't really want to support editing of result values
			}

			@Override
			protected Object getValue(Object anElement) {
				SetListEntry tempEntry = (SetListEntry) anElement;
				return (String) tempEntry.getAttribute(SetListEntryAttributeKeys.VALUE);
			}

			@Override
			protected CellEditor getCellEditor(Object anElement) {
				return new TextCellEditor(aTable.getTable());
			}

			@Override
			protected boolean canEdit(Object anElement) {
				return true;
			}
		});

		tempColumn = new TableViewerColumn(aTable, SWT.NONE);
		tempColumn.getColumn().setText("Expected");
		tempColumn.getColumn().setWidth(150);
		tempColumn.getColumn().setResizable(true);
		tempColumn.getColumn().setMoveable(false);
		tempColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public void update(ViewerCell aCell) {
				SetListEntry tempEntry = (SetListEntry) aCell.getElement();
				aCell.setText((String) tempEntry.getAttribute(SetListEntryAttributeKeys.EXPECTED_RESULT));
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
		// Make the value column editable, mostly to be able to copy out results. See issue #77
		tempColumn.setEditingSupport(new EditingSupport(aTable) {

			@Override
			protected void setValue(Object anElement, Object aValue) {
				// not supported, we don't really want to support editing of result values
			}

			@Override
			protected Object getValue(Object anElement) {
				SetListEntry tempEntry = (SetListEntry) anElement;
				return (String) tempEntry.getAttribute(SetListEntryAttributeKeys.EXPECTED_RESULT);
			}

			@Override
			protected CellEditor getCellEditor(Object anElement) {
				return new TextCellEditor(aTable.getTable());
			}

			@Override
			protected boolean canEdit(Object anElement) {
				return true;
			}
		});
	}

	private void configureVarUpdateTable(final TableViewer aTable) {
		aTable.getTable().setHeaderVisible(true);
		aTable.getTable().setLinesVisible(true);

		TableViewerColumn tempColumn = new TableViewerColumn(aTable,
				SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.FULL_SELECTION);
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
			@Override
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

		treeViewer.addDoubleClickListener(new IDoubleClickListener() {

			@Override
			public void doubleClick(DoubleClickEvent anEvent) {
				if (anEvent.getSelection() instanceof TreeSelection) {
					TreeSelection tempSelection = (TreeSelection) anEvent.getSelection();
					if (tempSelection.getFirstElement() instanceof SetListEntry) {
						SetListEntry tempEntry = (SetListEntry) tempSelection.getFirstElement();
						String tempLink = (String) tempEntry.getAttribute(SetListEntryAttributeKeys.LINK);
						if (tempLink != null) {
							urlResolver.parseURL(INTEGRITY_URL_PREFIX + tempLink);
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
			@Override
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
		aManager.add(executeTestAction);
		aManager.add(executeDebugTestAction);
		aManager.add(shutdownAction);
		aManager.add(configureTestAction);
		aManager.add(new Separator());
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
							@Override
							public void run() {
								if (client == null || !client.isActive()) {
									// If not connected, add/remove breakpoint only from the recreation set
									String tempFullyQualifiedName = setList.getFullyQualifiedName(tempEntry);
									if (tempFullyQualifiedName != null) {
										breakpointsToRecreate.remove(tempFullyQualifiedName);
										breakpointSet.remove(tempEntry.getId());
									}

									Display.getDefault().syncExec(new Runnable() {
										@Override
										public void run() {
											treeViewer.update(tempEntry, null);
										}
									});
								} else {
									client.deleteBreakpoint(tempEntry.getId());
								}
							}
						});
					} else {
						aManager.add(new BreakpointAction(tempEntry.getId(), "Add Breakpoint",
								"Adds a breakpoint to the selected step.") {
							@Override
							public void run() {
								if (client == null || !client.isActive()) {
									// If not connected, add/remove breakpoint only from the recreation set
									String tempFullyQualifiedName = setList.getFullyQualifiedName(tempEntry);
									if (tempFullyQualifiedName != null) {
										breakpointsToRecreate.add(tempFullyQualifiedName);
										// However, we also need to insert it into this set in order to display it
										breakpointSet.add(tempEntry.getId());
									}

									Display.getDefault().syncExec(new Runnable() {
										@Override
										public void run() {
											treeViewer.update(tempEntry, null);
										}
									});
								} else {
									client.createBreakpoint(tempEntry.getId());
								}
							}
						});
					}
				}

				String tempLink = (String) tempEntry.getAttribute(SetListEntryAttributeKeys.LINK);
				if (tempLink != null) {
					aManager.add(new JumpToLinkAction(INTEGRITY_URL_PREFIX + tempLink, "Jump to Script",
							"Jumps to the position of this element in the test scripts.") {
						@Override
						public void run() {
							urlResolver.parseURL(getURL());
						}
					});
				}
			}
		}
	}

	private void fillLocalToolBar(IToolBarManager aManager) {
		// These are still in development...
		aManager.add(executeTestAction);
		aManager.add(executeDebugTestAction);
		aManager.add(shutdownAction);
		aManager.add(configureTestAction);
		aManager.add(new Separator());
		aManager.add(expandAllAction);
		aManager.add(collapseAllAction);
		aManager.add(scrollLockAction);
		aManager.add(new Separator());
		aManager.add(playAction);
		aManager.add(pauseAction);
		aManager.add(stepIntoAction);
		aManager.add(stepOverAction);
		aManager.add(clearBreakpointsAction);
		aManager.add(new Separator());
		aManager.add(connectToTestRunnerAction);
	}

	private void makeActions() {
		connectToTestRunnerAction = new Action() {
			private String lastHostname = "localhost";

			@Override
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
			@Override
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
			@Override
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
			@Override
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
			@Override
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

		clearBreakpointsAction = new Action() {
			@Override
			public void run() {
				breakpointsToRecreate.clear();
				if (client != null && client.isActive()) {
					synchronized (breakpointSet) {
						for (Integer tempBreakpoint : breakpointSet) {
							client.deleteBreakpoint(tempBreakpoint);
						}
					}
				} else {
					// If offline, we "fake" removal of breakpoints so we can update the display
					Iterator<Integer> tempIterator = breakpointSet.iterator();
					while (tempIterator.hasNext()) {
						final Integer tempReference = tempIterator.next();
						tempIterator.remove();
						Display.getDefault().asyncExec(new Runnable() {
							@Override
							public void run() {
								treeViewer.update(setList.resolveReference(tempReference), null);
							}
						});
					}
				}
			}
		};
		clearBreakpointsAction.setText("Clear breakpoints");
		clearBreakpointsAction.setToolTipText("Clears all existing and/or saved breakpoints.");
		clearBreakpointsAction.setImageDescriptor(Activator.getImageDescriptor("icons/removeall_enabled.gif"));
		clearBreakpointsAction.setDisabledImageDescriptor(Activator.getImageDescriptor("icons/removeall_disabled.gif"));

		executeTestAction = new Action() {
			@Override
			public void run() {
				if (launchConfiguration != null) {
					try {
						executeTestAction.setEnabled(false);
						executeDebugTestAction.setEnabled(false);
						final ILaunch tempLaunch = launchConfiguration.launch(ILaunchManager.RUN_MODE, null);
						new AutoConnectThread(tempLaunch).start();
					} catch (CoreException exc) {
						showException(exc);
					}
				}
			}
		};
		executeTestAction.setText("Launch test application");
		executeTestAction.setImageDescriptor(Activator.getImageDescriptor("icons/exec_enabled.gif"));

		executeDebugTestAction = new Action() {
			@Override
			public void run() {
				if (launchConfiguration != null) {
					try {
						executeTestAction.setEnabled(false);
						executeDebugTestAction.setEnabled(false);
						final ILaunch tempLaunch = launchConfiguration.launch(ILaunchManager.DEBUG_MODE, null);
						new AutoConnectThread(tempLaunch).start();
					} catch (CoreException exc) {
						showException(exc);
					}
				}
			}
		};
		executeDebugTestAction.setText("Launch test application (debug mode)");
		executeDebugTestAction.setImageDescriptor(Activator.getImageDescriptor("icons/exec_debug_enabled.gif"));
		updateLaunchButtonState();

		shutdownAction = new Action() {
			@Override
			public void run() {
				client.requestShutdown();
				updateStatus("Requested immediate shutdown...");
			};
		};
		shutdownAction.setText("Shutdown running test application");
		shutdownAction.setToolTipText("Requests the test application to shut down immediately.");
		shutdownAction.setImageDescriptor(Activator.getImageDescriptor("icons/shutdown.gif"));
		shutdownAction.setEnabled(false);

		configureTestAction = new Action() {
			@Override
			public void run() {
				TestActionConfigurationDialog tempDialog = new TestActionConfigurationDialog(getSite().getShell(),
						launchConfiguration);
				if (tempDialog.open() == Dialog.OK) {
					launchConfiguration = tempDialog.getSelectedConfiguration();
					updateLaunchButtonState();
				}
			}
		};
		configureTestAction.setText("Configure test application");
		configureTestAction.setToolTipText("Configures the test run configuration(s) to launch.");
		configureTestAction.setImageDescriptor(Activator.getImageDescriptor("icons/exec_config_enabled.gif"));

		expandAllAction = new Action() {
			@Override
			public void run() {
				lastExpansionLevel++;
				((TestTreeContentProvider) treeViewer.getContentProvider()).expandToLevel(lastExpansionLevel + 1);
			}
		};
		expandAllAction.setText("Expand all (one level)");
		expandAllAction.setToolTipText("Expands all nodes one level deeper (except table tests).");
		expandAllAction.setImageDescriptor(Activator.getImageDescriptor("icons/expandall.gif"));

		collapseAllAction = new Action() {
			@Override
			public void run() {
				lastExpansionLevel = 0;
				treeViewer.collapseAll();
			}
		};
		collapseAllAction.setText("Collapse all");
		collapseAllAction.setToolTipText("Collapses all nodes.");
		collapseAllAction.setImageDescriptor(Activator.getImageDescriptor("icons/collapseall.gif"));

		scrollLockAction = new Action("Toggle scroll lock", IAction.AS_CHECK_BOX) {
			@Override
			public void run() {
				scrollLockActive = isChecked();
			};
		};
		scrollLockAction.setToolTipText("Toggles the scroll lock setting.");
		scrollLockAction.setImageDescriptor(Activator.getImageDescriptor("icons/scrolllock.gif"));

		updateActionStatus(null);
	}

	private void updateLaunchButtonState() {
		String tempText;
		boolean tempEnabled;
		if (launchConfiguration != null) {
			tempText = "Launches the test run configuration '" + launchConfiguration.getName() + "'";
			tempEnabled = true;
		} else {
			tempText = "Launches the test run configuration";
			tempEnabled = false;
		}

		executeTestAction.setEnabled(tempEnabled);
		executeTestAction.setToolTipText(tempText);
		executeDebugTestAction.setEnabled(tempEnabled);
		executeDebugTestAction.setToolTipText(tempText + " (debug mode)");
	}

	private boolean isConnected() {
		return (client != null && client.isActive());
	}

	private void updateActionStatus(final ExecutionStates anExecutionState) {
		Runnable tempRunnable = updateActionStatusRunnable(anExecutionState);
		if (Display.getCurrent() != null) {
			Display.getCurrent().syncExec(tempRunnable);
		} else {
			Display.getDefault().asyncExec(tempRunnable);
		}
	}

	private Runnable updateActionStatusRunnable(final ExecutionStates anExecutionState) {
		return new Runnable() {

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
					shutdownAction.setEnabled(false);
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
						shutdownAction.setEnabled(false);
					} else {
						shutdownAction.setEnabled(true);
						switch (anExecutionState) {
						case BLOCKED:
							playAction.setEnabled(true);
							pauseAction.setEnabled(false);
							stepIntoAction.setEnabled(true);
							stepOverAction.setEnabled(true);
							updateStatusRunnable("Waiting for execution start").run();
							break;
						case PAUSED:
							playAction.setEnabled(true);
							pauseAction.setEnabled(false);
							stepIntoAction.setEnabled(true);
							stepOverAction.setEnabled(true);
							updateStatusRunnable(
									determineIntermediateTestResultStatusString("Paused test execution (", ")")).run();
							break;
						case RUNNING:
							playAction.setEnabled(false);
							pauseAction.setEnabled(true);
							stepIntoAction.setEnabled(false);
							stepOverAction.setEnabled(false);
							updateStatusRunnable(determineIntermediateTestResultStatusString("Running tests: ", ""))
									.run();
							break;
						case FINALIZING:
							playAction.setEnabled(false);
							pauseAction.setEnabled(false);
							stepIntoAction.setEnabled(false);
							stepOverAction.setEnabled(false);
							updateStatusRunnable(
									determineIntermediateTestResultStatusString("Finalizing test results (", ")"))
											.run();
							break;
						case ENDED:
							playAction.setEnabled(false);
							pauseAction.setEnabled(false);
							stepIntoAction.setEnabled(false);
							stepOverAction.setEnabled(false);
							updateStatusRunnable(
									determineIntermediateTestResultStatusString("Test execution finished (", ")"))
											.run();
							break;
						default:
							break;
						}
					}
				}
			}
		};
	}

	private String determineIntermediateTestResultStatusString(String aPrefix, String aSuffix) {
		StringBuilder tempBuilder = new StringBuilder(aPrefix);

		if (setList != null) {
			tempBuilder.append(setList.getNumberOfEntriesInResultState(SetListEntryResultStates.SUCCESSFUL));
			tempBuilder.append(" successful, ");
			tempBuilder.append(setList.getNumberOfEntriesInResultState(SetListEntryResultStates.FAILED));
			tempBuilder.append(" failures, ");
			tempBuilder.append(setList.getNumberOfEntriesInResultState(SetListEntryResultStates.EXCEPTION));
			tempBuilder.append(" exceptions");
		}

		tempBuilder.append(aSuffix);
		return tempBuilder.toString();
	}

	private void hideResultComposite(Composite aComposite) {
		aComposite.setVisible(false);
		((FormData) aComposite.getLayoutData()).bottom.offset = 0;
	}

	private void showResultComposite(Composite aComposite, int aHeight) {
		aComposite.setVisible(true);
		((FormData) aComposite.getLayoutData()).bottom.offset = aHeight;
	}

	// SUPPRESS CHECKSTYLE MethodLength
	private void updateDetailPanel(SetListEntry anEntry, ILabelProvider aProvider) {
		fixtureLink.setVisible(false);
		forkLabel.setVisible(false);
		hideResultComposite(resultTableComposite);
		hideResultComposite(varUpdateTableComposite);
		resultLine1Name.setVisible(false);
		hideResultComposite(resultLine1Border);
		resultLine1Text.setText("");
		resultLine2Name.setVisible(false);
		hideResultComposite(resultLine2Border);
		resultLine3Name.setVisible(false);
		resultLine3Border.setVisible(false);
		for (Control tempChild : resultLine3Border.getChildren()) {
			tempChild.dispose();
		}

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
					fixtureLink.setText(
							(String) setList.getParent(anEntry).getAttribute(SetListEntryAttributeKeys.FIXTURE));
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

			List<SetListEntry> tempParameters = setList.resolveReferences(anEntry,
					SetListEntryAttributeKeys.PARAMETERS);
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
								.getAttribute(SetListEntryAttributeKeys.TEST_EXCEPTION_COUNT)
								+ (Integer) tempResultEntry
										.getAttribute(SetListEntryAttributeKeys.CALL_EXCEPTION_COUNT);

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
					List<SetListEntry> tempComparisonEntries = setList.resolveReferences(
							((List<Integer>) tempResultEntry.getAttribute(SetListEntryAttributeKeys.COMPARISONS)));

					if (tempComparisonEntries.size() > 1) {
						resultTable.setInput(tempComparisonEntries);
						showResultComposite(resultTableComposite, RESULT_TABLE_HEIGHT);
					} else {
						SetListEntry tempComparisonEntry = tempComparisonEntries.get(0);
						resultLine2Name.setText("Expected value: ");
						resultLine2Text.setText(
								(String) tempComparisonEntry.getAttribute(SetListEntryAttributeKeys.EXPECTED_RESULT));
						resultLine2Border.setForeground(resultNeutralColor);
						resultLine2Name.setVisible(true);
						showResultComposite(resultLine2Border, RESULT_TEXTFIELD_HEIGHT);

						if (tempResultEntry.getAttribute(SetListEntryAttributeKeys.EXCEPTION) != null) {
							resultLine1Name.setText("Exception occurred while running the test fixture:");
							resultLine1Text.setText(
									(String) tempResultEntry.getAttribute(SetListEntryAttributeKeys.EXCEPTION));
							resultLine1Border.setForeground(resultExceptionColor);
							resultLine1Name.setVisible(true);
							showResultComposite(resultLine1Border, RESULT_TEXTFIELD_HEIGHT);
						} else {
							if (tempComparisonEntry
									.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG) != null) {
								resultLine1Name.setText("Result returned by the test fixture: ");
								String tempResult = (String) tempComparisonEntry
										.getAttribute(SetListEntryAttributeKeys.VALUE);
								resultLine1Text.setText(tempResult == null ? "null" : tempResult);
								if (tempComparisonEntry
										.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG) != null) {
									if (Boolean.TRUE.equals(tempComparisonEntry
											.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG))) {
										resultLine1Border.setForeground(resultSuccessColor);
									} else {
										resultLine1Border.setForeground(resultFailureColor);
									}
								}
								showResultComposite(resultLine1Border, RESULT_TEXTFIELD_HEIGHT);
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
							resultLine1Text.setText(
									(String) tempResultEntry.getAttribute(SetListEntryAttributeKeys.EXCEPTION));
							resultLine1Border.setForeground(resultExceptionColor);
							showResultComposite(resultLine1Border, RESULT_TEXTFIELD_HEIGHT);
						} else {
							List<SetListEntry> tempVarUpdates = setList.resolveReferences(tempResultEntry,
									SetListEntryAttributeKeys.VARIABLE_UPDATES);

							if (tempVarUpdates.size() == 1) {
								String tempResultValue = (String) tempVarUpdates.get(0)
										.getAttribute(SetListEntryAttributeKeys.VALUE);
								String tempTargetVariable = (String) tempVarUpdates.get(0)
										.getAttribute(SetListEntryAttributeKeys.VARIABLE_NAME);
								if (tempTargetVariable != null) {
									tempResultValue += " ➔ " + tempTargetVariable;
								}
								resultLine1Name.setText("Result returned by the fixture:");
								resultLine1Text.setText(tempResultValue);
								resultLine1Border.setForeground(resultNeutralColor);
								showResultComposite(resultLine1Border, RESULT_TEXTFIELD_HEIGHT);
							} else if (tempVarUpdates.size() > 1) {
								varUpdateTable.setInput(tempVarUpdates);
								showResultComposite(varUpdateTableComposite, RESULT_TABLE_HEIGHT);
							} else {
								resultLine1Name.setText("No result returned by the fixture.");
							}
						}
					} else {
						resultLine1Name.setText("No result available - please run the tests first.");
					}
					resultLine1Name.setVisible(true);
					break;
				case VARIABLE_ASSIGNMENT:
					List<SetListEntry> tempVarUpdates = setList.resolveReferences(tempResultEntry,
							SetListEntryAttributeKeys.VARIABLE_UPDATES);

					if (tempVarUpdates.size() == 1) {
						String tempResultValue = (String) tempVarUpdates.get(0)
								.getAttribute(SetListEntryAttributeKeys.VALUE);
						String tempTargetVariable = (String) tempVarUpdates.get(0)
								.getAttribute(SetListEntryAttributeKeys.VARIABLE_NAME);
						if (tempTargetVariable != null) {
							tempResultValue += " ➔ " + tempTargetVariable;
						}
						resultLine1Name.setText("Assigned variable value:");
						resultLine1Text.setText(tempResultValue);
						resultLine1Border.setForeground(resultNeutralColor);
						showResultComposite(resultLine1Border, RESULT_TEXTFIELD_HEIGHT);
					} else if (tempVarUpdates.size() > 1) {
						varUpdateTable.setInput(tempVarUpdates);
						showResultComposite(varUpdateTableComposite, RESULT_TABLE_HEIGHT);
					} else {
						resultLine1Name.setText("No variables assigned.");
					}
					resultLine1Name.setVisible(true);
					break;
				default:
					break;
				}
			}

			Object[] tempExtendedResults = (Object[]) anEntry
					.getAttribute(SetListEntryAttributeKeys.EXTENDED_RESULT_DATA);
			if (tempExtendedResults != null && tempExtendedResults.length > 0) {
				int tempSize = 0;

				for (Object tempExtendedResultArray : tempExtendedResults) {
					if (tempSize > 0) {
						tempSize += EXTENDED_RESULT_SPACING;
					}

					tempSize += createExtendedResultContainer(resultLine3Border, tempSize + 1,
							(Object[]) tempExtendedResultArray);
				}

				resultLine3Name.setVisible(true);
				resultLine3Border.setVisible(true);
				showResultComposite(resultLine3Border, tempSize + 2);
				resultComposite.layout(true, true);
			} else {
				hideResultComposite(resultLine3Border);
			}
		}

		details.layout(true, true);
		details.reflow(false);
		details.redraw();
	}

	private int createExtendedResultContainer(Composite aTargetComposite, int aStartingPosition,
			Object[] someExtendedResultData) {
		String tempTitle = (String) someExtendedResultData[0];
		Object tempData = someExtendedResultData[1];

		int tempTitleSize = 0;
		int tempContentSize = 0;
		Control tempContentContainer = null;

		// First, create the title.
		if (tempTitle != null) {
			tempTitleSize = 18;

			Composite tempResultTitleContainer = new Composite(aTargetComposite, SWT.NONE);
			tempResultTitleContainer.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_BLACK));

			FormData tempFormData = new FormData();
			tempFormData.left = new FormAttachment(0, 1);
			tempFormData.right = new FormAttachment(100, 1);
			tempFormData.top = new FormAttachment(aTargetComposite, aStartingPosition);
			tempFormData.bottom = new FormAttachment(aTargetComposite, aStartingPosition + tempTitleSize, SWT.BOTTOM);
			tempResultTitleContainer.setLayoutData(tempFormData);
			FillLayout tempFillLayout = new FillLayout();
			tempFillLayout.marginWidth = 2;
			tempFillLayout.marginHeight = 2;
			tempResultTitleContainer.setLayout(tempFillLayout);
			tempResultTitleContainer.setVisible(true);

			Label tempResultTitleField = new Label(tempResultTitleContainer, SWT.BOLD);
			tempResultTitleField.setForeground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
			tempResultTitleField.setText(tempTitle);
			tempResultTitleField.setVisible(true);
		}

		// Now, see what we have to display, create the appropriate control and set everything up
		if (tempData instanceof String) { // This covers strings and hypertext strings
			Text tempResultTextField = new Text(aTargetComposite, SWT.READ_ONLY | SWT.WRAP | SWT.V_SCROLL);
			tempResultTextField.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_WHITE));
			tempResultTextField.setText((String) tempData);

			tempContentSize = EXTENDED_RESULT_TEXTFIELD_HEIGHT;
			tempContentContainer = tempResultTextField;
		} else if (tempData instanceof byte[]) { // Covers images
			Image tempImage = new Image(Display.getCurrent(), new ByteArrayInputStream((byte[]) tempData));
			Label tempImageLabel = new Label(aTargetComposite, SWT.NONE);
			tempImageLabel.setImage(tempImage);
			tempImageLabel.setAlignment(SWT.CENTER);

			tempContentSize = tempImage.getBounds().height + EXTENDED_RESULT_IMAGE_SPACING;
			tempContentContainer = tempImageLabel;
		}

		// Finally, place the control onto its parent
		if (tempContentContainer != null) {
			FormData tempFormData = new FormData();
			tempFormData.left = new FormAttachment(0, 1);
			tempFormData.right = new FormAttachment(100, -1);
			tempFormData.top = new FormAttachment(aTargetComposite, aStartingPosition + tempTitleSize);
			tempFormData.bottom = new FormAttachment(aTargetComposite,
					aStartingPosition + tempTitleSize + tempContentSize, SWT.BOTTOM);
			tempContentContainer.setLayoutData(tempFormData);
			tempContentContainer.setVisible(true);
		}

		return tempTitleSize + tempContentSize;
	}

	private void showMessage(final String aMessage) {
		Runnable tempRunnable = new Runnable() {
			@Override
			public void run() {
				MessageDialog.openInformation(treeViewer.getControl().getShell(), "Integrity Test Control", aMessage);
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
		Display.getDefault().asyncExec(updateStatusRunnable(aStatus));
	}

	private Runnable updateStatusRunnable(final String aStatus) {
		return new Runnable() {

			@Override
			public void run() {
				treeContainer.setText(aStatus);
			}
		};
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
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
			client = new IntegrityRemotingClient(aHost, aPort, new RemotingListener(), null);
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

	private void performTreeSearch() {
		String tempSearchQuery = searchTextField.getText();

		if (tempSearchQuery.length() < 3) {
			clearTreeSearchResult();
		} else {
			prepareTreeSearch();

			currentSearchResultPosition = null;

			if (MAGIC_SEARCH_TERM_FAILURES.equals(tempSearchQuery)) {
				currentSearchResult = setListSearch.findUnsuccessfulEntries(false);
			} else {
				currentSearchResult = setListSearch.findEntries(tempSearchQuery);
			}

			if (currentSearchResult.size() > 0) {
				currentSearchResultPosition = 0;
				jumpToCurrentSearchResult();
			}
			updateTreeSearchLabel();
		}
	}

	private boolean performTreeSearchForFailures() {
		if (MAGIC_SEARCH_TERM_FAILURES.equals(searchTextField.getText())) {
			return false;
		}

		searchTextField.setText(MAGIC_SEARCH_TERM_FAILURES);
		performTreeSearch();

		return true;
	}

	private void prepareTreeSearch() {
		if (setListSearch == null) {
			setListSearch = new SetListSearch(setList);
		}
	}

	private void clearTreeSearchResult() {
		currentSearchResultPosition = null;
		currentSearchResult = null;
		searchPositionLabel.setText("");
	}

	private void updateTreeSearchLabel() {
		if (currentSearchResult == null) {
			searchPositionLabel.setText("");
		} else {
			if (currentSearchResult.size() == 0) {
				searchPositionLabel.setText("no matches");
			} else {
				String tempCurrentPosition = (currentSearchResultPosition == null ? "?"
						: Integer.toString(currentSearchResultPosition + 1));
				searchPositionLabel.setText(tempCurrentPosition + " / " + currentSearchResult.size());
			}
		}
	}

	private void jumpToPreviousSearchResult() {
		if (currentSearchResult != null && currentSearchResultPosition != null) {
			currentSearchResultPosition--;
			if (currentSearchResultPosition <= 0) {
				currentSearchResultPosition = 0;
			}
			jumpToCurrentSearchResult();
		}
	}

	private void jumpToNextSearchResult() {
		if (currentSearchResult != null && currentSearchResultPosition != null) {
			currentSearchResultPosition++;
			if (currentSearchResultPosition >= currentSearchResult.size()) {
				currentSearchResultPosition = 0;
			}
			jumpToCurrentSearchResult();
		}
	}

	private void jumpToCurrentSearchResult() {
		if (currentSearchResultPosition != null && currentSearchResult != null && currentSearchResultPosition >= 0
				&& currentSearchResultPosition < currentSearchResult.size()) {
			SetListEntry tempEntry = currentSearchResult.get(currentSearchResultPosition);
			treeViewer.setSelection(new StructuredSelection(tempEntry));
			updateTreeSearchLabel();
		}
	}

	private void updateSetList(SetList aNewSetList) {
		setList = aNewSetList;
		breakpointSet.clear();
		setListSearch = null;

		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				searchTextField.setText("");
				treeViewer.setSelection(null);
				treeViewer.setInput(null);

				executionProgress.setSetList(setList);
				executionProgress.redraw();

				// the following will automatically dispose the old provider!
				treeViewer.setLabelProvider(
						new TestTreeLabelProvider(setList, breakpointSet, Display.getCurrent(), treeViewer));

				// the drawer must be manually disposed
				if (viewerContentDrawer != null) {
					viewerContentDrawer.dispose(treeViewer.getTree());
				}
				viewerContentDrawer = new TestTreeContentDrawer(setList, breakpointSet, Display.getCurrent());
				viewerContentDrawer.attachToTree(treeViewer.getTree());

				treeViewer.setInput(setList);

				((TestTreeContentProvider) treeViewer.getContentProvider()).expandToLevel(lastExpansionLevel + 1);

				updateStatus("Connected and ready");
			}
		});
	}

	private abstract class StatusUpdateRunnable implements Runnable {

		/**
		 * Whether this update may be skipped to improve performance.
		 */
		private boolean skippable;

		StatusUpdateRunnable(boolean aSkippable) {
			skippable = aSkippable;
		}

		public boolean isSkippable() {
			return skippable;
		}

	}

	private class RemotingListener implements IntegrityRemotingClientListener {

		/**
		 * Used to measure the connected time.
		 */
		private long connectionTimestamp;

		@Override
		public void onConnectionSuccessful(IntegrityRemotingVersionMessage aRemoteVersion, Endpoint anEndpoint) {
			// request set list baseline and execution state
			anEndpoint.sendMessage(new SetListBaselineMessage(null));
			anEndpoint.sendMessage(new ExecutionStateMessage(null));
			updateActionStatus(client.getExecutionState());
			connectionTimestamp = System.nanoTime();

			// Initiate the status update timer. See issue #80 and timer javadoc documentation.
			statusUpdateTimer = new Timer("Integrity Test Runner Status Update Timer");
			statusUpdateTimerTask = new TimerTask() {

				private Timer associatedTimer = statusUpdateTimer;

				@Override
				public void run() {
					StatusUpdateRunnable tempRunnable = statusUpdateQueue.poll();
					if (tempRunnable == null) {
						if (statusUpdateTimerTask != this) {
							associatedTimer.cancel();
						}
						return;
					}

					StatusUpdateRunnable tempLastRunnable;
					do {
						tempLastRunnable = tempRunnable;
						if (!tempLastRunnable.isSkippable()) {
							break;
						}

						tempRunnable = statusUpdateQueue.poll();
					} while (tempRunnable != null);

					Display.getDefault().syncExec(tempLastRunnable);
				}
			};
			statusUpdateTimer.scheduleAtFixedRate(statusUpdateTimerTask, 0, STATUS_UPDATE_INTERVAL);
		}

		@Override
		public void onVersionMismatch(IntegrityRemotingVersionMessage aRemoteVersion, Endpoint anEndpoint) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onBaselineReceived(SetList aSetList, Endpoint anEndpoint) {
			updateSetList(aSetList);

			// Recreate breakpoints, if possible
			synchronized (breakpointsToRecreate) {
				for (String tempBreakpointName : breakpointsToRecreate) {
					SetListEntry tempEntry = aSetList.findEntryByFullyQualifiedName(tempBreakpointName);
					if (tempEntry != null) {
						client.createBreakpoint(tempEntry.getId());
					}
				}
			}
		}

		@Override
		public void onExecutionStateUpdate(final ExecutionStates aState, Endpoint anEndpoint) {
			statusUpdateQueue.add(new StatusUpdateRunnable(false) {

				@Override
				public void run() {
					updateActionStatusRunnable(aState).run();
				}
			});
		}

		@Override
		public void onConnectionLost(Endpoint anEndpoint) {
			client = null;
			statusUpdateQueue.add(new StatusUpdateRunnable(false) {

				@Override
				public void run() {
					executionProgress.redraw();
					updateActionStatusRunnable(null).run();
					updateStatusRunnable(determineIntermediateTestResultStatusString("Test Runner disconnected (",
							") after " + DateUtil.convertNanosecondTimespanToHumanReadableFormat(
									System.nanoTime() - connectionTimestamp, true, false))).run();
				}
			});

			statusUpdateTimer = null;
			statusUpdateTimerTask = null;
		}

		/**
		 * This queue is used to queue asynchronous status display update requests (status text and execution progress
		 * bar). Certain updates can be skipped for better performance. See issue #80.
		 */
		private LinkedBlockingQueue<StatusUpdateRunnable> statusUpdateQueue = new LinkedBlockingQueue<StatusUpdateRunnable>();

		/**
		 * The timer used to process status update queue entries. Gets started and stopped with Integrity test
		 * executions.
		 */
		private Timer statusUpdateTimer;

		/**
		 * The task used by the {@link #statusUpdateTimer}.
		 */
		private TimerTask statusUpdateTimerTask;

		/**
		 * The interval in milliseconds with which the status shall be updated. Maximum number of updates per second can
		 * directly be calculated from this.
		 */
		private static final int STATUS_UPDATE_INTERVAL = 200;

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
						List<SetListEntry> tempExecutionPath = setList.getEntriesInExecution();
						for (SetListEntry tempEntry : tempExecutionPath) {
							treeViewer.update(tempEntry, null);
						}

						if (!scrollLockActive && !treeViewerIsScrolledManually && tempExecutionPath.size() > 0) {
							treeViewer.reveal(tempExecutionPath.get(0));
						}
					}
				}
			});

			final String tempStatusUpdate = determineIntermediateTestResultStatusString("Running tests: ", "");
			statusUpdateQueue.add(new StatusUpdateRunnable(true) {

				@Override
				public void run() {
					executionProgress.redraw();
					updateStatusRunnable(tempStatusUpdate).run();
				}
			});
		}

		@Override
		public void onConfirmCreateBreakpoint(final Integer anEntryReference, Endpoint anEndpoint) {
			if (anEntryReference == null) {
				// We are only interested in real breakpoints, not pause-at-next-instructions.
				return;
			}
			breakpointSet.add(anEntryReference);
			String tempFullyQualifiedName = setList.getFullyQualifiedName(anEntryReference);
			if (tempFullyQualifiedName != null) {
				breakpointsToRecreate.add(tempFullyQualifiedName);
			}
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					treeViewer.update(setList.resolveReference(anEntryReference), null);
				}
			});
		}

		@Override
		public void onConfirmRemoveBreakpoint(final Integer anEntryReference, Endpoint anEndpoint) {
			if (anEntryReference == null) {
				// We are only interested in real breakpoints, not pause-at-next-instructions.
				return;
			}
			breakpointSet.remove(anEntryReference);
			String tempFullyQualifiedName = setList.getFullyQualifiedName(anEntryReference);
			if (tempFullyQualifiedName != null) {
				breakpointsToRecreate.remove(tempFullyQualifiedName);
			}
			Display.getDefault().asyncExec(new Runnable() {
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

		@Override
		public void onAbortExecution(String anAbortExecutionMessage, String anAbortExecutionStackTrace) {
			// not used in this context
		}
	}

	private class AutoConnectThread extends Thread {

		/**
		 * The launch to supervise.
		 */
		private ILaunch launch;

		/**
		 * Creates a new instance.
		 */
		AutoConnectThread(ILaunch aLaunch) {
			super("Integrity Autoconnect Thread");
			launch = aLaunch;
		}

		@Override
		public void run() {
			boolean tempSuccess = false;

			while (!launch.isTerminated()) {
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
			executeDebugTestAction.setEnabled(true);
		};
	}
}