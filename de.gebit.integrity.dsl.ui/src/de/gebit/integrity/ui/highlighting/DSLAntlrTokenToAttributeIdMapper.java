/**
 * 
 */
package de.gebit.integrity.ui.highlighting;

import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultAntlrTokenToAttributeIdMapper;

/**
 * Extension of the custom Antlr token to attribute mapper. This is used by the editor to connect specific token types
 * to a highlighting setting.
 * 
 * @author Rene Schneider
 * 
 */
public class DSLAntlrTokenToAttributeIdMapper extends DefaultAntlrTokenToAttributeIdMapper {

	@Override
	protected String calculateId(String aTokenName, int aTokenType) {
		if ("RULE_SL_VISIBLE_COMMENT".equals(aTokenName) || "RULE_ML_VISIBLE_COMMENT".equals(aTokenName)) {
			return DSLHighlightingConfiguration.VISIBLE_COMMENT_ID;
		} else if ("RULE_DIVIDER".equals(aTokenName)) {
			return DSLHighlightingConfiguration.VISIBLE_DIVIDER_ID;
		} else if ("RULE_INTEGER".equals(aTokenName) || "RULE_DECIMAL".equals(aTokenName)) {
			return DSLHighlightingConfiguration.NUMBER_ID;
		} else if ("RULE_BOOLEAN_TRUE".equals(aTokenName) || "RULE_BOOLEAN_FALSE".equals(aTokenName)) {
			return DSLHighlightingConfiguration.CONSTANT_VALUE_ID;
		}

		return super.calculateId(aTokenName, aTokenType);
	}

}
