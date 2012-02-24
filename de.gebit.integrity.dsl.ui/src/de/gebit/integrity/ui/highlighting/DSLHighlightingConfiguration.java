/**
 * 
 */
package de.gebit.integrity.ui.highlighting;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

/**
 * Custom highlighting configuration.
 * 
 * @author Rene Schneider
 * 
 */
public class DSLHighlightingConfiguration extends DefaultHighlightingConfiguration {

	/**
	 * The ID for visible comments.
	 */
	public static final String VISIBLE_COMMENT_ID = "visiblecomment";

	/**
	 * Configures highlighting styles for the IDs.
	 */
	public void configure(IHighlightingConfigurationAcceptor anAcceptor) {
		super.configure(anAcceptor);
		anAcceptor.acceptDefaultHighlighting(VISIBLE_COMMENT_ID, "Visible Comment", visibleCommentTextStyle());
	}

	/**
	 * Creates a text style to use for visible comments.
	 * 
	 * @return the style
	 */
	public TextStyle visibleCommentTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(14, 70, 0));
		tempTextStyle.setStyle(tempTextStyle.getStyle() | SWT.ITALIC | SWT.BOLD);
		return tempTextStyle;
	}
}
