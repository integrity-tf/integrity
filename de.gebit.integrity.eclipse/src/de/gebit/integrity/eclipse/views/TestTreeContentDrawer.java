/*******************************************************************************
 * Copyright (c) 2013 Rene Schneider, GEBIT Solutions GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.gebit.integrity.eclipse.views;

import java.util.HashMap;
import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import de.gebit.integrity.remoting.entities.setlist.SetList;
import de.gebit.integrity.remoting.entities.setlist.SetListEntry;
import de.gebit.integrity.remoting.entities.setlist.SetListEntryResultStates;

/**
 * The custom content drawer for the main test execution tree. Takes care of test statement coloring.
 * 
 * @author Rene Schneider - initial API and implementation
 * 
 */
public class TestTreeContentDrawer {

	/**
	 * The set list to use.
	 */
	private SetList setList;

	/**
	 * The set of breakpoints currently active.
	 */
	private Set<Integer> breakpointSet;

	/**
	 * This color is used as neutral color.
	 */
	private Color nullColor;

	/**
	 * Background color for successfully executed suite calls.
	 */
	private Color suiteSuccessColor;

	/**
	 * Background color for suite calls that contain at least one failed element.
	 */
	private Color suiteFailureColor;

	/**
	 * Background color for suite calls that contain at least one element that threw an exception during execution.
	 */
	private Color suiteExceptionColor;

	/**
	 * Background color for successfully executed tests.
	 */
	private Color testSuccessColor;

	/**
	 * Background color for tests that failed.
	 */
	private Color testFailureColor;

	/**
	 * Background color for tests that threw an exception during execution.
	 */
	private Color testExceptionColor;

	/**
	 * Background color for calls that threw an exception during execution.
	 */
	private Color callExceptionColor;

	/**
	 * Background color for successfully executed calls.
	 */
	private Color callSuccessColor;

	/**
	 * Background color for successfully executed assigns.
	 */
	private Color assignSuccessColor;

	/**
	 * Color for suites that are currently being executed.
	 */
	private Color suiteInExecutionColor;

	/**
	 * Color for calls/tests that are currently being executed.
	 */
	private Color callOrTestInExecutionColor;

	/**
	 * Color for breakpoints.
	 */
	private Color breakpointColor;

	/**
	 * The listener being attached to the tree.
	 */
	private Listener measureListener;

	/**
	 * The listener being attached to the tree.
	 */
	private Listener eraseListener;

	/**
	 * Maps forks identified by their names to unique colors.
	 */
	private HashMap<String, Color> forkColorMap = new HashMap<String, Color>();

	/**
	 * The fork colors.
	 */
	private Color[] forkColors = new Color[8];

	/**
	 * The number of pixels to indent for each "level" in the tree.
	 */
	private static final int INDENT_PIXELS = 19;

	/**
	 * The number of pixels to indent the background color for the first level in the tree.
	 */
	private static final int INDENT_BASE = 42;

	/**
	 * The width of the gradient in pixels.
	 */
	private static final int GRADIENT_WIDTH = 32;

	/**
	 * The offset of the gradient in pixels.
	 */
	private static final int GRADIENT_OFFSET = -16;

	/**
	 * Creates a new instance.
	 * 
	 * @param aSetList
	 *            the set list
	 * @param aBreakpointSet
	 *            the breakpoint set
	 * @param aDisplay
	 *            the display
	 */
	public TestTreeContentDrawer(SetList aSetList, Set<Integer> aBreakpointSet, Display aDisplay) {
		setList = aSetList;
		breakpointSet = aBreakpointSet;
		nullColor = new Color(aDisplay, 255, 255, 255);
		suiteSuccessColor = new Color(aDisplay, 156, 255, 189);
		suiteFailureColor = new Color(aDisplay, 255, 130, 130);
		suiteExceptionColor = new Color(aDisplay, 255, 248, 136);
		testSuccessColor = suiteSuccessColor;
		testFailureColor = suiteFailureColor;
		testExceptionColor = suiteExceptionColor;
		callExceptionColor = suiteExceptionColor;
		callSuccessColor = new Color(aDisplay, 205, 255, 222);
		callOrTestInExecutionColor = new Color(aDisplay, 198, 203, 255);
		suiteInExecutionColor = new Color(aDisplay, 229, 231, 255);
		breakpointColor = new Color(aDisplay, 0, 0, 0);
		assignSuccessColor = new Color(aDisplay, 203, 255, 216);

		forkColors[0] = new Color(aDisplay, 255, 0, 0);
		forkColors[1] = new Color(aDisplay, 255, 255, 0);
		forkColors[2] = new Color(aDisplay, 0, 255, 0);
		forkColors[3] = new Color(aDisplay, 0, 0, 255);
		forkColors[4] = new Color(aDisplay, 0, 255, 255);
		forkColors[5] = new Color(aDisplay, 255, 0, 255);
		forkColors[6] = new Color(aDisplay, 96, 57, 19);
		forkColors[7] = new Color(aDisplay, 0, 0, 0);
	}

	/**
	 * Disposes the drawer instance, cleaning up resources in the process.
	 * 
	 * @param aTree
	 */
	public void dispose(Tree aTree) {
		aTree.removeListener(SWT.MeasureItem, measureListener);
		aTree.removeListener(SWT.EraseItem, eraseListener);
		nullColor.dispose();
		suiteSuccessColor.dispose();
		suiteFailureColor.dispose();
		suiteExceptionColor.dispose();
		testSuccessColor.dispose();
		testFailureColor.dispose();
		testExceptionColor.dispose();
		callSuccessColor.dispose();
		callExceptionColor.dispose();
		callOrTestInExecutionColor.dispose();
		suiteInExecutionColor.dispose();
		breakpointColor.dispose();
		assignSuccessColor.dispose();

		for (int i = 0; i < forkColors.length; i++) {
			forkColors[i].dispose();
		}
	}

	/**
	 * Attaches the drawer to a given tree.
	 * 
	 * @param aTree
	 *            the tree
	 */
	public void attachToTree(final Tree aTree) {
		measureListener = new Listener() {

			@Override
			public void handleEvent(Event anEvent) {
				int tempMinWidth = aTree.getClientArea().width - anEvent.x;
				if (anEvent.width < tempMinWidth) {
					anEvent.width = tempMinWidth;
				}
			}
		};
		aTree.addListener(SWT.MeasureItem, measureListener);

		eraseListener = new Listener() {

			@Override
			public void handleEvent(Event anEvent) {
				TreeItem tempItem = (TreeItem) anEvent.item;
				SetListEntry tempEntry = (SetListEntry) tempItem.getData();
				SetListEntryResultStates tempResultState = setList.getResultStateForEntry(tempEntry);

				if (tempResultState != null && tempResultState != SetListEntryResultStates.UNKNOWN) {
					int tempInset = getTreeItemIndentation(tempItem);
					Color tempOldForeground = anEvent.gc.getForeground();
					Color tempOldBackground = anEvent.gc.getBackground();

					anEvent.gc.setForeground(nullColor);
					Color tempBackground = tempOldBackground;

					switch (tempEntry.getType()) {
					case SUITE:
						switch (tempResultState) {
						case EXCEPTION:
							tempBackground = suiteExceptionColor;
							break;
						case FAILED:
							tempBackground = suiteFailureColor;
							break;
						case SUCCESSFUL:
							tempBackground = suiteSuccessColor;
							break;
						default:
							break;
						}
						break;
					case CALL:
					case TIMESET:
						switch (tempResultState) {
						case SUCCESSFUL:
							tempBackground = callSuccessColor;
							break;
						case EXCEPTION:
							tempBackground = callExceptionColor;
							break;
						default:
							break;
						}
						break;
					case VARIABLE_ASSIGNMENT:
						switch (tempResultState) {
						case SUCCESSFUL:
							tempBackground = assignSuccessColor;
							break;
						default:
							break;
						}
						break;
					case TEST:
					case TABLETEST:
					case RESULT:
						switch (tempResultState) {
						case SUCCESSFUL:
							tempBackground = testSuccessColor;
							break;
						case EXCEPTION:
							tempBackground = testExceptionColor;
							break;
						case FAILED:
							tempBackground = testFailureColor;
							break;
						default:
							break;
						}
						break;
					case COMMENT:
					default:
						break;
					}

					anEvent.gc.setBackground(tempBackground);

					anEvent.gc.fillGradientRectangle(anEvent.x + tempInset + GRADIENT_OFFSET, anEvent.y, GRADIENT_WIDTH,
							anEvent.height, false);
					anEvent.gc.fillRectangle(anEvent.x + tempInset + GRADIENT_WIDTH + GRADIENT_OFFSET, anEvent.y,
							anEvent.width - (tempInset + GRADIENT_WIDTH + GRADIENT_OFFSET), anEvent.height);

					anEvent.gc.setForeground(tempOldForeground);
					anEvent.gc.setBackground(tempOldBackground);

					anEvent.detail &= ~SWT.BACKGROUND;
					anEvent.detail &= ~SWT.HOT;
				} else if (setList.isEntryInExecution(tempEntry)) {
					Color tempOldBackground = anEvent.gc.getBackground();

					switch (tempEntry.getType()) {
					case CALL:
					case TEST:
					case TABLETEST:
					case VARIABLE_ASSIGNMENT:
					case TIMESET:
						anEvent.gc.setBackground(callOrTestInExecutionColor);
						break;
					case SUITE:
					case SETUP:
					case TEARDOWN:
						anEvent.gc.setBackground(suiteInExecutionColor);
						break;
					default:
						break;
					}

					anEvent.gc.fillRectangle(anEvent.x, anEvent.y, anEvent.width, anEvent.height);

					anEvent.gc.setBackground(tempOldBackground);

					anEvent.detail &= ~SWT.BACKGROUND;
					anEvent.detail &= ~SWT.HOT;
				}

				String[] tempForkName = setList.getForkExecutingEntry(tempEntry);
				if (tempForkName != null) {
					Color tempOldBackground = anEvent.gc.getBackground();
					anEvent.gc.setBackground(getForkColor(tempForkName[0]));

					anEvent.gc.fillRectangle(anEvent.x, anEvent.y, 3, anEvent.height);

					anEvent.gc.setBackground(tempOldBackground);

					anEvent.detail &= ~SWT.BACKGROUND;
					anEvent.detail &= ~SWT.HOT;
				}

				if (breakpointSet.contains(tempEntry.getId())) {
					int tempOffset = tempForkName != null ? 3 : 0;
					Color tempOldBackground = anEvent.gc.getBackground();
					anEvent.gc.setBackground(breakpointColor);

					anEvent.gc.fillPolygon(new int[] { anEvent.x + tempOffset, anEvent.y + 2,
							anEvent.x + tempOffset + anEvent.height / 2, anEvent.y + 2 + (anEvent.height - 4) / 2,
							anEvent.x + tempOffset, anEvent.y + (anEvent.height - 4) - 1 });

					anEvent.gc.setBackground(tempOldBackground);

					anEvent.detail &= ~SWT.BACKGROUND;
					anEvent.detail &= ~SWT.HOT;
				}
			}
		};
		aTree.addListener(SWT.EraseItem, eraseListener);
	}

	private int getTreeItemIndentation(TreeItem anItem) {
		int tempIndent = 0;

		TreeItem tempParent = anItem.getParentItem();
		while (tempParent != null) {
			tempIndent++;
			tempParent = tempParent.getParentItem();
		}

		return tempIndent * INDENT_PIXELS + INDENT_BASE;
	}

	private Color getForkColor(String aForkName) {
		Color tempColor = forkColorMap.get(aForkName);
		if (tempColor == null) {
			if (forkColorMap.size() >= forkColors.length) {
				tempColor = forkColors[forkColors.length - 1];
			} else {
				tempColor = forkColors[forkColorMap.size()];
			}
			forkColorMap.put(aForkName, tempColor);
		}

		return tempColor;
	}
}
