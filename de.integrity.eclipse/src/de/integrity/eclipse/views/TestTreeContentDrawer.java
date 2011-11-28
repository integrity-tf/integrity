package de.integrity.eclipse.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import de.integrity.remoting.entities.setlist.SetList;
import de.integrity.remoting.entities.setlist.SetListEntry;
import de.integrity.remoting.entities.setlist.SetListEntryAttributeKeys;
import de.integrity.remoting.entities.setlist.SetListEntryTypes;

public class TestTreeContentDrawer {

	private SetList setList;

	private Color nullColor;
	private Color suiteSuccessColor;
	private Color suiteFailureColor;
	private Color suiteExceptionColor;
	private Color testSuccessColor;
	private Color testFailureColor;
	private Color testExceptionColor;
	private Color callExceptionColor;
	private Color callSuccessColor;

	private Listener measureListener;
	private Listener eraseListener;

	private int INDENT_PIXELS = 19;

	private int INDENT_BASE = 42;

	private int GRADIENT_WIDTH = 32;

	private int GRADIENT_OFFSET = -16;

	public TestTreeContentDrawer(SetList aSetList, Display aDisplay) {
		setList = aSetList;
		nullColor = new Color(aDisplay, 255, 255, 255);
		suiteSuccessColor = new Color(aDisplay, 156, 255, 189);
		suiteFailureColor = new Color(aDisplay, 255, 130, 130);
		suiteExceptionColor = new Color(aDisplay, 255, 248, 136);
		testSuccessColor = suiteSuccessColor;
		testFailureColor = suiteFailureColor;
		testExceptionColor = suiteExceptionColor;
		callExceptionColor = suiteExceptionColor;
		callSuccessColor = new Color(aDisplay, 200, 200, 200);
	}

	public void dispose(Tree aTree) {
		nullColor.dispose();
		suiteSuccessColor.dispose();
		suiteFailureColor.dispose();
		suiteExceptionColor.dispose();
		testSuccessColor.dispose();
		testFailureColor.dispose();
		testExceptionColor.dispose();
		callSuccessColor.dispose();
		callExceptionColor.dispose();
		aTree.removeListener(SWT.MeasureItem, measureListener);
		aTree.removeListener(SWT.EraseItem, eraseListener);
	}

	public void attachToTree(final Tree aTree) {
		measureListener = new Listener() {

			@Override
			public void handleEvent(Event event) {
				TreeItem tempItem = (TreeItem) event.item;
				SetListEntry tempEntry = (SetListEntry) tempItem.getData();

				int tempMinWidth = aTree.getClientArea().width - event.x;
				if (event.width < tempMinWidth) {
					event.width = tempMinWidth;
				}
			}
		};
		aTree.addListener(SWT.MeasureItem, measureListener);

		eraseListener = new Listener() {

			@Override
			public void handleEvent(Event event) {
				TreeItem tempItem = (TreeItem) event.item;
				SetListEntry tempEntry = (SetListEntry) tempItem.getData();
				SetListEntry tempResultEntry = setList.resolveReferences(tempEntry, SetListEntryAttributeKeys.RESULT)
						.get(0);
				int tempInset = getTreeItemIndentation(tempItem);

				if (tempResultEntry != null
						&& ((tempEntry.getType() == SetListEntryTypes.SUITE && tempResultEntry
								.getAttribute(SetListEntryAttributeKeys.SUCCESS_COUNT) != null) || (tempResultEntry
								.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG) != null))) {
					Color tempOldForeground = event.gc.getForeground();
					Color tempOldBackground = event.gc.getBackground();

					event.gc.setForeground(nullColor);
					Color tempBackground = tempOldBackground;

					switch (tempEntry.getType()) {
					case SUITE:
						int tempFailureCount = (Integer) tempResultEntry
								.getAttribute(SetListEntryAttributeKeys.FAILURE_COUNT);
						int tempExceptionCount = (Integer) tempResultEntry
								.getAttribute(SetListEntryAttributeKeys.EXCEPTION_COUNT);
						if (tempExceptionCount > 0) {
							tempBackground = suiteExceptionColor;
						} else if (tempFailureCount > 0) {
							tempBackground = suiteFailureColor;
						} else {
							tempBackground = suiteSuccessColor;
						}
						break;
					case CALL:
						if (Boolean.TRUE.equals(tempResultEntry
								.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG))) {
							tempBackground = callSuccessColor;
						} else {
							tempBackground = callExceptionColor;
						}
						break;
					case TEST:
						if (Boolean.TRUE.equals(tempResultEntry
								.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG))) {
							tempBackground = testSuccessColor;
						} else if (Boolean.FALSE.equals(tempResultEntry
								.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG))) {
							if (tempResultEntry.getAttribute(SetListEntryAttributeKeys.EXCEPTION) != null) {
								tempBackground = testExceptionColor;
							} else {
								tempBackground = testFailureColor;
							}
						}
						break;
					}

					event.gc.setBackground(tempBackground);

					event.gc.fillGradientRectangle(event.x + tempInset + GRADIENT_OFFSET, event.y, GRADIENT_WIDTH,
							event.height, false);
					event.gc.fillRectangle(event.x + tempInset + GRADIENT_WIDTH + GRADIENT_OFFSET, event.y, event.width
							- (tempInset + GRADIENT_WIDTH + GRADIENT_OFFSET), event.height);

					event.gc.setForeground(tempOldForeground);
					event.gc.setBackground(tempOldBackground);

					event.detail &= ~SWT.BACKGROUND;
					event.detail &= ~SWT.HOT;
				}
			}
		};
		aTree.addListener(SWT.EraseItem, eraseListener);

		// aTree.addListener(SWT.PaintItem, new Listener() {
		//
		// @Override
		// public void handleEvent(Event event) {
		//
		// }
		// });
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
}
