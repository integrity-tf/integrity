/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.eclipse.views;

import java.util.Set;

import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.IFontProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import de.gebit.integrity.eclipse.Activator;
import de.gebit.integrity.remoting.entities.setlist.SetList;
import de.gebit.integrity.remoting.entities.setlist.SetListEntry;
import de.gebit.integrity.remoting.entities.setlist.SetListEntryAttributeKeys;
import de.gebit.integrity.remoting.entities.setlist.SetListEntryResultStates;
import de.gebit.integrity.remoting.entities.setlist.SetListEntryTypes;

/**
 * The label provider for the main test execution tree.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class TestTreeLabelProvider extends LabelProvider implements ILabelProvider, IColorProvider, IFontProvider {

	/**
	 * The set list to use.
	 */
	private SetList setList;

	/**
	 * The current set of active breakpoints.
	 */
	private Set<Integer> breakpointSet;

	/**
	 * The image used for suites that have not yet been executed.
	 */
	private Image suiteImage;

	/**
	 * The image for successfully executed suites.
	 */
	private Image suiteSuccessImage;

	/**
	 * The image for suites that had at least one failure in execution.
	 */
	private Image suiteFailureImage;

	/**
	 * The image for suites that had at least one exception in execution.
	 */
	private Image suiteExceptionImage;

	/**
	 * The image for tests that have not yet been executed.
	 */
	private Image testImage;

	/**
	 * The image for tests that have been successfully executed.
	 */
	private Image testSuccessImage;

	/**
	 * The image for tests that were executed but concluded with a failure.
	 */
	private Image testFailureImage;

	/**
	 * The image for tests that encountered an exception during execution.
	 */
	private Image testExceptionImage;

	/**
	 * The image for calls that have not yet been executed.
	 */
	private Image callImage;

	/**
	 * The image for calls that have been successfully executed.
	 */
	private Image callSuccessImage;

	/**
	 * The image for calls that encountered an exception during execution.
	 */
	private Image callExceptionImage;

	/**
	 * The text color for comments.
	 */
	private Color commentTextColor;

	/**
	 * The comment font.
	 */
	private Font commentFont;

	/**
	 * Constructs a new instance.
	 * 
	 * @param aSetList
	 *            the set list to use
	 * @param aBreakpointSet
	 *            the initial breakpoint set
	 */
	public TestTreeLabelProvider(SetList aSetList, Set<Integer> aBreakpointSet, Display aDisplay, TreeViewer anOwner) {
		setList = aSetList;
		breakpointSet = aBreakpointSet;
		suiteImage = Activator.getImageDescriptor("icons/suite.gif").createImage();
		suiteSuccessImage = Activator.getImageDescriptor("icons/suite_ok.gif").createImage();
		suiteFailureImage = Activator.getImageDescriptor("icons/suite_error.gif").createImage();
		suiteExceptionImage = Activator.getImageDescriptor("icons/suite_exception.gif").createImage();
		testImage = Activator.getImageDescriptor("icons/test.png").createImage();
		testSuccessImage = Activator.getImageDescriptor("icons/test_success.gif").createImage();
		testFailureImage = Activator.getImageDescriptor("icons/test_failed.gif").createImage();
		testExceptionImage = Activator.getImageDescriptor("icons/test_exception.gif").createImage();
		callImage = Activator.getImageDescriptor("icons/call.gif").createImage();
		callSuccessImage = Activator.getImageDescriptor("icons/call_success.gif").createImage();
		callExceptionImage = Activator.getImageDescriptor("icons/call_exception.gif").createImage();
		commentTextColor = new Color(aDisplay, 14, 70, 0);
		FontData tempFontData = anOwner.getTree().getFont().getFontData()[0];
		tempFontData.setStyle(tempFontData.getStyle() | SWT.ITALIC | SWT.BOLD);
		commentFont = new Font(aDisplay, tempFontData);
	}

	@Override
	public void dispose() {
		super.dispose();
		suiteImage.dispose();
		suiteSuccessImage.dispose();
		suiteFailureImage.dispose();
		suiteExceptionImage.dispose();
		testImage.dispose();
		testSuccessImage.dispose();
		testFailureImage.dispose();
		testExceptionImage.dispose();
		callImage.dispose();
		callSuccessImage.dispose();
		callExceptionImage.dispose();
		commentTextColor.dispose();
		commentFont.dispose();
	}

	/**
	 * Called by the tree in order to determine the image to use for an entry.
	 */
	@Override
	public Image getImage(Object anElement) {
		SetListEntry tempEntry = (SetListEntry) anElement;
		SetListEntryResultStates tempResultState = setList.getResultStateForEntry(tempEntry);

		switch (tempEntry.getType()) {
		case SUITE:
			switch (tempResultState) {
			case SUCCESSFUL:
				return suiteSuccessImage;
			case FAILED:
				return suiteFailureImage;
			case EXCEPTION:
				return suiteExceptionImage;
			case UNKNOWN:
			default:
				return suiteImage;
			}
		case CALL:
			switch (tempResultState) {
			case SUCCESSFUL:
				return callSuccessImage;
			case EXCEPTION:
				return callExceptionImage;
			case UNKNOWN:
			default:
				return callImage;
			}
		case VARIABLE_ASSIGNMENT:
			return callImage;
		case TEST:
		case TABLETEST:
		case RESULT:
			switch (tempResultState) {
			case SUCCESSFUL:
				return testSuccessImage;
			case FAILED:
				return testFailureImage;
			case EXCEPTION:
				return testExceptionImage;
			case UNKNOWN:
			default:
				return testImage;
			}
		case COMMENT:
		default:
			return null;
		}
	}

	/**
	 * Called by the tree to determine the text to display for a certain element.
	 */
	@Override
	public String getText(Object anElement) {
		SetListEntry tempEntry = (SetListEntry) anElement;
		SetListEntryResultStates tempResultState = setList.getResultStateForEntry(tempEntry);

		// The "space suffixes" below serve a very important purpose. The TreeViewer performs sophisticated optimization
		// when determining whether to update an already-rendered element. If the text and icon don't change, it will
		// not render the item at all! That is bad, since we also change the background color depending on the result
		// state, and there are cases in which neither the text nor the icon change, but the background color, which
		// is not checked by the TreeViewer and which thus does not trigger a redraw. To overcome this, we arbitrarily
		// change the text by appending stuff like invisible spaces.
		String tempSuffix = "";
		if ((tempResultState == null || tempResultState == SetListEntryResultStates.UNKNOWN)
				&& setList.isEntryInExecution(tempEntry)) {
			tempSuffix = "...";
		} else if (breakpointSet.contains(tempEntry.getId())) {
			tempSuffix = " ";
		} else if (tempEntry.getType() == SetListEntryTypes.VARIABLE_ASSIGNMENT
				&& tempResultState == SetListEntryResultStates.SUCCESSFUL) {
			tempSuffix = " ";
		}

		switch (tempEntry.getType()) {
		case SUITE:
			return ((String) tempEntry.getAttribute(SetListEntryAttributeKeys.NAME)) + tempSuffix;
		case TEST:
		case TABLETEST:
		case CALL:
		case VARIABLE_ASSIGNMENT:
			return ((String) tempEntry.getAttribute(SetListEntryAttributeKeys.DESCRIPTION)) + tempSuffix;
		case RESULT:
			return ((String) tempEntry.getAttribute(SetListEntryAttributeKeys.DESCRIPTION)) + tempSuffix;
		case COMMENT:
			return (String) tempEntry.getAttribute(SetListEntryAttributeKeys.VALUE);
		default:
			return tempEntry.toString() + tempSuffix;
		}
	}

	@Override
	public Color getForeground(Object anElement) {
		SetListEntry tempEntry = (SetListEntry) anElement;

		switch (tempEntry.getType()) {
		case COMMENT:
			return commentTextColor;
		default:
			return null;
		}
	}

	@Override
	public Color getBackground(Object anElement) {
		return null;
	}

	@Override
	public Font getFont(Object anElement) {
		SetListEntry tempEntry = (SetListEntry) anElement;

		switch (tempEntry.getType()) {
		case COMMENT:
			return commentFont;
		default:
			return null;
		}
	}

}
