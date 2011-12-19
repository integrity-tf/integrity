package de.integrity.eclipse.actions;

import org.eclipse.jface.action.Action;

public class BreakpointAction extends Action {

	private int entryReference;

	public BreakpointAction(int anEntryReference, String aText, String aToolTipText) {
		entryReference = anEntryReference;
		setText(aText);
		setToolTipText(aToolTipText);
	}

	protected int getEntryReference() {
		return entryReference;
	}

}
