/**
 * 
 */
package de.gebit.integrity.ui.highlighting;

import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class DSLHighlightingConfiguration extends DefaultHighlightingConfiguration {

	public static final String VISIBLE_COMMENT_ID = "visiblecomment";

	public void configure(IHighlightingConfigurationAcceptor anAcceptor) {
		super.configure(anAcceptor);
		anAcceptor.acceptDefaultHighlighting(VISIBLE_COMMENT_ID, "Visible Comment", visibleCommentTextStyle());
	}

	public TextStyle visibleCommentTextStyle() {
		TextStyle tempTextStyle = defaultTextStyle().copy();
		tempTextStyle.setColor(new RGB(14, 70, 0));
		return tempTextStyle;
	}

}
