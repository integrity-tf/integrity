package de.gebit.integrity.eclipse.actions;

import org.eclipse.jface.action.Action;

/**
 * Creates a breakpoint at a specified set list entry.
 * 
 * @author Rene Schneider
 * 
 */
public class BreakpointAction extends Action {

	/**
	 * The ID of the entry at which the breakpoint shall be created.
	 */
	private int entryReference;

	/**
	 * Creates a new instance.
	 * 
	 * @param anEntryReference
	 *            the reference to the set list entry at which the breakpoint shall be created
	 * @param aText
	 *            the action text
	 * @param aToolTipText
	 *            the tooltip description for the action
	 */
	public BreakpointAction(int anEntryReference, String aText, String aToolTipText) {
		entryReference = anEntryReference;
		setText(aText);
		setToolTipText(aToolTipText);
	}

	protected int getEntryReference() {
		return entryReference;
	}

}
