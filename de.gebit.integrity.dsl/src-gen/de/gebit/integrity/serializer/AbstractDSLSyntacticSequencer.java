package de.gebit.integrity.serializer;

import com.google.inject.Inject;
import de.gebit.integrity.services.DSLGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("restriction")
public class AbstractDSLSyntacticSequencer extends AbstractSyntacticSequencer {

	protected DSLGrammarAccess grammarAccess;
	protected AbstractElementAlias match_SuiteDefinition_ConcludedbyKeyword_7_0_q;
	protected AbstractElementAlias match_SuiteDefinition_GetsKeyword_2_0_q;
	protected AbstractElementAlias match_SuiteDefinition_RequiresKeyword_3_0_q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (DSLGrammarAccess) access;
		match_SuiteDefinition_ConcludedbyKeyword_7_0_q = new TokenAlias(false, true, grammarAccess.getSuiteDefinitionAccess().getConcludedbyKeyword_7_0());
		match_SuiteDefinition_GetsKeyword_2_0_q = new TokenAlias(false, true, grammarAccess.getSuiteDefinitionAccess().getGetsKeyword_2_0());
		match_SuiteDefinition_RequiresKeyword_3_0_q = new TokenAlias(false, true, grammarAccess.getSuiteDefinitionAccess().getRequiresKeyword_3_0());
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_SuiteDefinition_ConcludedbyKeyword_7_0_q.equals(syntax))
				emit_SuiteDefinition_ConcludedbyKeyword_7_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SuiteDefinition_GetsKeyword_2_0_q.equals(syntax))
				emit_SuiteDefinition_GetsKeyword_2_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_SuiteDefinition_RequiresKeyword_3_0_q.equals(syntax))
				emit_SuiteDefinition_RequiresKeyword_3_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     'concludedby'?
	 */
	protected void emit_SuiteDefinition_ConcludedbyKeyword_7_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'gets'?
	 */
	protected void emit_SuiteDefinition_GetsKeyword_2_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'requires'?
	 */
	protected void emit_SuiteDefinition_RequiresKeyword_3_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
