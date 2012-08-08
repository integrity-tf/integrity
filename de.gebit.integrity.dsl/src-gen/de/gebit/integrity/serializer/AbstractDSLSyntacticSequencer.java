package de.gebit.integrity.serializer;

import com.google.inject.Inject;
import de.gebit.integrity.services.DSLGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public abstract class AbstractDSLSyntacticSequencer extends AbstractSyntacticSequencer {

	protected DSLGrammarAccess grammarAccess;
	protected AbstractElementAlias match_ParameterTableHeader_VerticalLineKeyword_2_q;
	protected AbstractElementAlias match_ParameterTableValue_VerticalLineKeyword_2_q;
	protected AbstractElementAlias match_ResultTableHeader_VerticalLineKeyword_3_q;
	protected AbstractElementAlias match_SuiteDefinition___ConcludedbyKeyword_6_0_NLParserRuleCall_6_1__q;
	protected AbstractElementAlias match_SuiteDefinition___GetsKeyword_4_0_NLParserRuleCall_4_1__q;
	protected AbstractElementAlias match_SuiteDefinition___RequiresKeyword_5_0_NLParserRuleCall_5_1__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (DSLGrammarAccess) access;
		match_ParameterTableHeader_VerticalLineKeyword_2_q = new TokenAlias(false, true, grammarAccess.getParameterTableHeaderAccess().getVerticalLineKeyword_2());
		match_ParameterTableValue_VerticalLineKeyword_2_q = new TokenAlias(false, true, grammarAccess.getParameterTableValueAccess().getVerticalLineKeyword_2());
		match_ResultTableHeader_VerticalLineKeyword_3_q = new TokenAlias(false, true, grammarAccess.getResultTableHeaderAccess().getVerticalLineKeyword_3());
		match_SuiteDefinition___ConcludedbyKeyword_6_0_NLParserRuleCall_6_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getSuiteDefinitionAccess().getConcludedbyKeyword_6_0()), new TokenAlias(false, false, grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_6_1()));
		match_SuiteDefinition___GetsKeyword_4_0_NLParserRuleCall_4_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getSuiteDefinitionAccess().getGetsKeyword_4_0()), new TokenAlias(false, false, grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_4_1()));
		match_SuiteDefinition___RequiresKeyword_5_0_NLParserRuleCall_5_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getSuiteDefinitionAccess().getRequiresKeyword_5_0()), new TokenAlias(false, false, grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_5_1()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getNLRule())
			return getNLToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getNLFORCEDRule())
			return getNLFORCEDToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * NL:
	 * 	(NEWLINE WS?)*;
	 */
	protected String getNLToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * NLFORCED:
	 * 	NEWLINE WS? NL;
	 */
	protected String getNLFORCEDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "\r";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_ParameterTableHeader_VerticalLineKeyword_2_q.equals(syntax))
				emit_ParameterTableHeader_VerticalLineKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ParameterTableValue_VerticalLineKeyword_2_q.equals(syntax))
				emit_ParameterTableValue_VerticalLineKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ResultTableHeader_VerticalLineKeyword_3_q.equals(syntax))
				emit_ResultTableHeader_VerticalLineKeyword_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SuiteDefinition___ConcludedbyKeyword_6_0_NLParserRuleCall_6_1__q.equals(syntax))
				emit_SuiteDefinition___ConcludedbyKeyword_6_0_NLParserRuleCall_6_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SuiteDefinition___GetsKeyword_4_0_NLParserRuleCall_4_1__q.equals(syntax))
				emit_SuiteDefinition___GetsKeyword_4_0_NLParserRuleCall_4_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SuiteDefinition___RequiresKeyword_5_0_NLParserRuleCall_5_1__q.equals(syntax))
				emit_SuiteDefinition___RequiresKeyword_5_0_NLParserRuleCall_5_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     '|'?
	 */
	protected void emit_ParameterTableHeader_VerticalLineKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '|'?
	 */
	protected void emit_ParameterTableValue_VerticalLineKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     '|'?
	 */
	protected void emit_ResultTableHeader_VerticalLineKeyword_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('concludedby' NL)?
	 */
	protected void emit_SuiteDefinition___ConcludedbyKeyword_6_0_NLParserRuleCall_6_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('gets' NL)?
	 */
	protected void emit_SuiteDefinition___GetsKeyword_4_0_NLParserRuleCall_4_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('requires' NL)?
	 */
	protected void emit_SuiteDefinition___RequiresKeyword_5_0_NLParserRuleCall_5_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
