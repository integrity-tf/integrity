package de.gebit.integrity.eclipse.actions;

import org.eclipse.jface.action.Action;

/**
 * Uses an Integrity URL to jump to a specific link.
 * 
 * @author Rene Schneider
 * 
 */
public class JumpToLinkAction extends Action {

	/**
	 * The URL.
	 */
	private String url;

	/**
	 * Creates a new instance.
	 * 
	 * @param anURL
	 *            the URL for the jump
	 * @param aText
	 *            the action text
	 * @param aToolTipText
	 *            the tooltip description for the action
	 */
	public JumpToLinkAction(String anURL, String aText, String aToolTipText) {
		url = anURL;
		setText(aText);
		setToolTipText(aToolTipText);
	}

	protected String getURL() {
		return url;
	}

}
