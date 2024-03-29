/*
 * generated by Xtext
 */
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
	protected AbstractElementAlias match_SuiteDefinition___ConcludedbyKeyword_11_0_NLParserRuleCall_11_1__q;
	protected AbstractElementAlias match_SuiteDefinition___RequiresKeyword_10_0_NLParserRuleCall_10_1__q;
	protected AbstractElementAlias match_Suite_CommaKeyword_9_2_1_q;
	protected AbstractElementAlias match_TimeSet_CommaKeyword_3_2_1_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (DSLGrammarAccess) access;
		match_ParameterTableHeader_VerticalLineKeyword_2_q = new TokenAlias(false, true, grammarAccess.getParameterTableHeaderAccess().getVerticalLineKeyword_2());
		match_ParameterTableValue_VerticalLineKeyword_2_q = new TokenAlias(false, true, grammarAccess.getParameterTableValueAccess().getVerticalLineKeyword_2());
		match_ResultTableHeader_VerticalLineKeyword_3_q = new TokenAlias(false, true, grammarAccess.getResultTableHeaderAccess().getVerticalLineKeyword_3());
		match_SuiteDefinition___ConcludedbyKeyword_11_0_NLParserRuleCall_11_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getSuiteDefinitionAccess().getConcludedbyKeyword_11_0()), new TokenAlias(false, false, grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_11_1()));
		match_SuiteDefinition___RequiresKeyword_10_0_NLParserRuleCall_10_1__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getSuiteDefinitionAccess().getRequiresKeyword_10_0()), new TokenAlias(false, false, grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_10_1()));
		match_Suite_CommaKeyword_9_2_1_q = new TokenAlias(false, true, grammarAccess.getSuiteAccess().getCommaKeyword_9_2_1());
		match_TimeSet_CommaKeyword_3_2_1_q = new TokenAlias(false, true, grammarAccess.getTimeSetAccess().getCommaKeyword_3_2_1());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (ruleCall.getRule() == grammarAccess.getNLRule())
			return getNLToken(semanticObject, ruleCall, node);
		else if (ruleCall.getRule() == grammarAccess.getNLFORCEDRule())
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
			if (match_ParameterTableHeader_VerticalLineKeyword_2_q.equals(syntax))
				emit_ParameterTableHeader_VerticalLineKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ParameterTableValue_VerticalLineKeyword_2_q.equals(syntax))
				emit_ParameterTableValue_VerticalLineKeyword_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_ResultTableHeader_VerticalLineKeyword_3_q.equals(syntax))
				emit_ResultTableHeader_VerticalLineKeyword_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_SuiteDefinition___ConcludedbyKeyword_11_0_NLParserRuleCall_11_1__q.equals(syntax))
				emit_SuiteDefinition___ConcludedbyKeyword_11_0_NLParserRuleCall_11_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_SuiteDefinition___RequiresKeyword_10_0_NLParserRuleCall_10_1__q.equals(syntax))
				emit_SuiteDefinition___RequiresKeyword_10_0_NLParserRuleCall_10_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_Suite_CommaKeyword_9_2_1_q.equals(syntax))
				emit_Suite_CommaKeyword_9_2_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if (match_TimeSet_CommaKeyword_3_2_1_q.equals(syntax))
				emit_TimeSet_CommaKeyword_3_2_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     '|'?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ParameterName (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_ParameterTableHeader_VerticalLineKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     '|'?
	 *
	 * This ambiguous syntax occurs at:
	 *     value=ValueOrEnumValueOrOperationCollection (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_ParameterTableValue_VerticalLineKeyword_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     '|'?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=ResultName '=' (ambiguity) (rule end)
	 
	 * </pre>
	 */
	protected void emit_ResultTableHeader_VerticalLineKeyword_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ('concludedby' NL)?
	 *
	 * This ambiguous syntax occurs at:
	 *     dependencies+=[SuiteDefinition|QualifiedName] NL (ambiguity) 'with' NL 'suiteend' NL (rule end)
	 *     dependencies+=[SuiteDefinition|QualifiedName] NL (ambiguity) 'with' NL statements+=SuiteStatement
	 *     name=QualifiedName NL ('requires' NL)? (ambiguity) 'with' NL 'suiteend' NL (rule end)
	 *     name=QualifiedName NL ('requires' NL)? (ambiguity) 'with' NL statements+=SuiteStatement
	 *     parameters+=SuiteParameterDefinition NL ('requires' NL)? (ambiguity) 'with' NL 'suiteend' NL (rule end)
	 *     parameters+=SuiteParameterDefinition NL ('requires' NL)? (ambiguity) 'with' NL statements+=SuiteStatement
	 *     return+=SuiteReturnDefinition NL ('requires' NL)? (ambiguity) 'with' NL 'suiteend' NL (rule end)
	 *     return+=SuiteReturnDefinition NL ('requires' NL)? (ambiguity) 'with' NL statements+=SuiteStatement
	 
	 * </pre>
	 */
	protected void emit_SuiteDefinition___ConcludedbyKeyword_11_0_NLParserRuleCall_11_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ('requires' NL)?
	 *
	 * This ambiguous syntax occurs at:
	 *     name=QualifiedName NL (ambiguity) 'concludedby' NL finalizers+=[SuiteDefinition|QualifiedName]
	 *     name=QualifiedName NL (ambiguity) ('concludedby' NL)? 'with' NL 'suiteend' NL (rule end)
	 *     name=QualifiedName NL (ambiguity) ('concludedby' NL)? 'with' NL statements+=SuiteStatement
	 *     parameters+=SuiteParameterDefinition NL (ambiguity) 'concludedby' NL finalizers+=[SuiteDefinition|QualifiedName]
	 *     parameters+=SuiteParameterDefinition NL (ambiguity) ('concludedby' NL)? 'with' NL 'suiteend' NL (rule end)
	 *     parameters+=SuiteParameterDefinition NL (ambiguity) ('concludedby' NL)? 'with' NL statements+=SuiteStatement
	 *     return+=SuiteReturnDefinition NL (ambiguity) 'concludedby' NL finalizers+=[SuiteDefinition|QualifiedName]
	 *     return+=SuiteReturnDefinition NL (ambiguity) ('concludedby' NL)? 'with' NL 'suiteend' NL (rule end)
	 *     return+=SuiteReturnDefinition NL (ambiguity) ('concludedby' NL)? 'with' NL statements+=SuiteStatement
	 
	 * </pre>
	 */
	protected void emit_SuiteDefinition___RequiresKeyword_10_0_NLParserRuleCall_10_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ','?
	 *
	 * This ambiguous syntax occurs at:
	 *     variants+=[VariantDefinition|QualifiedName] (ambiguity) NL (rule end)
	 *     variants+=[VariantDefinition|QualifiedName] (ambiguity) NL variants+=[VariantDefinition|QualifiedName]
	 
	 * </pre>
	 */
	protected void emit_Suite_CommaKeyword_9_2_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * <pre>
	 * Ambiguous syntax:
	 *     ','?
	 *
	 * This ambiguous syntax occurs at:
	 *     forks+=[ForkDefinition|QualifiedName] (ambiguity) NL (rule end)
	 *     forks+=[ForkDefinition|QualifiedName] (ambiguity) NL forks+=[ForkDefinition|QualifiedName]
	 *     forks+=[ForkDefinition|QualifiedName] (ambiguity) NL masterFork='master'
	 *     masterFork='master' (ambiguity) NL (rule end)
	 *     masterFork='master' (ambiguity) NL forks+=[ForkDefinition|QualifiedName]
	 *     masterFork='master' (ambiguity) NL masterFork='master'
	 
	 * </pre>
	 */
	protected void emit_TimeSet_CommaKeyword_3_2_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
