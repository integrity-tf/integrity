/**
 * 
 */
package de.gebit.integrity.ui.highlighting;

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;

/**
 * 
 * 
 * @author Rene Schneider
 * 
 */
public class DSLAntlrTokenToAttributeIdMapper extends DefaultAntlrTokenToAttributeIdMapper {

	@Override
	protected String calculateId(String aTokenName, int aTokenType) {
		if ("RULE_SL_VISIBLE_COMMENT".equals(aTokenName) || "RULE_ML_VISIBLE_COMMENT".equals(aTokenName)) {
			return DSLHighlightingConfiguration.VISIBLE_COMMENT_ID;
		}

		return super.calculateId(aTokenName, aTokenType);
	}

}
