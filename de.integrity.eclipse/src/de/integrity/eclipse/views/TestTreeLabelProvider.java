package de.integrity.eclipse.views;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import de.integrity.eclipse.Activator;
import de.integrity.remoting.entities.setlist.SetList;
import de.integrity.remoting.entities.setlist.SetListEntry;
import de.integrity.remoting.entities.setlist.SetListEntryAttributeKeys;

public class TestTreeLabelProvider extends LabelProvider implements ILabelProvider {

	private SetList setList;

	private Image suiteImage;
	private Image suiteSuccessImage;
	private Image suiteFailureImage;
	private Image suiteExceptionImage;
	private Image testImage;
	private Image testSuccessImage;
	private Image testFailureImage;
	private Image testExceptionImage;
	private Image callImage;
	private Image callSuccessImage;
	private Image callExceptionImage;

	public TestTreeLabelProvider(SetList aSetList) {
		setList = aSetList;
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
	}

	public Image getImage(Object element) {
		SetListEntry tempEntry = (SetListEntry) element;
		SetListEntry tempResultEntry = setList.resolveReferences(tempEntry, SetListEntryAttributeKeys.RESULT).get(0);

		switch (tempEntry.getType()) {
		case SUITE:
			if (tempResultEntry.getAttribute(SetListEntryAttributeKeys.SUCCESS_COUNT) == null) {
				return suiteImage;
			} else {
				int tempFailureCount = (Integer) tempResultEntry.getAttribute(SetListEntryAttributeKeys.FAILURE_COUNT);
				int tempExceptionCount = (Integer) tempResultEntry
						.getAttribute(SetListEntryAttributeKeys.EXCEPTION_COUNT);
				if (tempExceptionCount > 0) {
					return suiteExceptionImage;
				} else if (tempFailureCount > 0) {
					return suiteFailureImage;
				} else {
					return suiteSuccessImage;
				}
			}
		case CALL:
			if (tempResultEntry.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG) == null) {
				return callImage;
			} else {
				if (Boolean.TRUE.equals(tempResultEntry.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG))) {
					return callSuccessImage;
				} else {
					return callExceptionImage;
				}
			}
		case TEST:
			if (tempResultEntry.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG) == null) {
				return testImage;
			} else {
				if (Boolean.TRUE.equals(tempResultEntry.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG))) {
					return testSuccessImage;
				} else if (Boolean.FALSE.equals(tempResultEntry
						.getAttribute(SetListEntryAttributeKeys.RESULT_SUCCESS_FLAG))) {
					if (tempResultEntry.getAttribute(SetListEntryAttributeKeys.EXCEPTION) != null) {
						return testExceptionImage;
					} else {
						return testFailureImage;
					}
				}
			}
		default:
			return null;
		}
	}

	@Override
	public String getText(Object element) {
		SetListEntry tempEntry = (SetListEntry) element;

		switch (tempEntry.getType()) {
		case SUITE:
			return (String) tempEntry.getAttribute(SetListEntryAttributeKeys.NAME);
		case TEST:
		case CALL:
			return (String) tempEntry.getAttribute(SetListEntryAttributeKeys.DESCRIPTION);
		default:
			return tempEntry.toString();
		}
	}

}
