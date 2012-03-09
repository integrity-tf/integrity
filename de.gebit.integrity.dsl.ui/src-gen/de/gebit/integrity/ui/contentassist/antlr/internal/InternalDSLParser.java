package de.gebit.integrity.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import de.gebit.integrity.services.DSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDSLParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_BOOLEAN_TRUE", "RULE_BOOLEAN_FALSE", "RULE_ID", "RULE_UPPERCASE_ID", "RULE_SL_VISIBLE_COMMENT", "RULE_ML_VISIBLE_COMMENT", "RULE_STRING", "RULE_INTEGER", "RULE_DECIMAL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'packagedef'", "'with'", "'packageend'", "'import'", "'forkdef'", "'uses'", "'testdef'", "'calldef'", "'suitedef'", "'suiteend'", "'gets'", "'requires'", "'concludedby'", "'variable'", "'initially'", "'constant'", "'test'", "'='", "'tabletest'", "'|'", "'call'", "'->'", "'suite'", "'on'", "':'", "'+'", "','", "'null'", "'#'", "'*'", "'.'", "'.*'"
    };
    public static final int RULE_ID=6;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=16;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_VISIBLE_COMMENT=8;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__18=18;
    public static final int RULE_BOOLEAN_FALSE=5;
    public static final int T__17=17;
    public static final int RULE_UPPERCASE_ID=7;
    public static final int RULE_DECIMAL=12;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_ML_VISIBLE_COMMENT=9;
    public static final int T__48=48;
    public static final int RULE_SL_COMMENT=14;
    public static final int RULE_ML_COMMENT=13;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_BOOLEAN_TRUE=4;
    public static final int RULE_STRING=10;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=15;
    public static final int RULE_INTEGER=11;

    // delegates
    // delegators


        public InternalDSLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDSLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDSLParser.tokenNames; }
    public String getGrammarFileName() { return "../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g"; }


     
     	private DSLGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(DSLGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleModel"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:61:1: ( ruleModel EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:62:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel61);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel68); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:69:1: ruleModel : ( ( rule__Model__StatementsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:73:2: ( ( ( rule__Model__StatementsAssignment )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:74:1: ( ( rule__Model__StatementsAssignment )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:74:1: ( ( rule__Model__StatementsAssignment )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:75:1: ( rule__Model__StatementsAssignment )*
            {
             before(grammarAccess.getModelAccess().getStatementsAssignment()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:76:1: ( rule__Model__StatementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==17||LA1_0==20||LA1_0==39) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:76:2: rule__Model__StatementsAssignment
            	    {
            	    pushFollow(FOLLOW_rule__Model__StatementsAssignment_in_ruleModel94);
            	    rule__Model__StatementsAssignment();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getStatementsAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleStatement"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:88:1: entryRuleStatement : ruleStatement EOF ;
    public final void entryRuleStatement() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:89:1: ( ruleStatement EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:90:1: ruleStatement EOF
            {
             before(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_ruleStatement_in_entryRuleStatement122);
            ruleStatement();

            state._fsp--;

             after(grammarAccess.getStatementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatement129); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:97:1: ruleStatement : ( ( rule__Statement__Alternatives ) ) ;
    public final void ruleStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:101:2: ( ( ( rule__Statement__Alternatives ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:102:1: ( ( rule__Statement__Alternatives ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:102:1: ( ( rule__Statement__Alternatives ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:103:1: ( rule__Statement__Alternatives )
            {
             before(grammarAccess.getStatementAccess().getAlternatives()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:104:1: ( rule__Statement__Alternatives )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:104:2: rule__Statement__Alternatives
            {
            pushFollow(FOLLOW_rule__Statement__Alternatives_in_ruleStatement155);
            rule__Statement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getStatementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleVisibleSingleLineComment"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:116:1: entryRuleVisibleSingleLineComment : ruleVisibleSingleLineComment EOF ;
    public final void entryRuleVisibleSingleLineComment() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:117:1: ( ruleVisibleSingleLineComment EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:118:1: ruleVisibleSingleLineComment EOF
            {
             before(grammarAccess.getVisibleSingleLineCommentRule()); 
            pushFollow(FOLLOW_ruleVisibleSingleLineComment_in_entryRuleVisibleSingleLineComment182);
            ruleVisibleSingleLineComment();

            state._fsp--;

             after(grammarAccess.getVisibleSingleLineCommentRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVisibleSingleLineComment189); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVisibleSingleLineComment"


    // $ANTLR start "ruleVisibleSingleLineComment"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:125:1: ruleVisibleSingleLineComment : ( ( rule__VisibleSingleLineComment__ContentAssignment ) ) ;
    public final void ruleVisibleSingleLineComment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:129:2: ( ( ( rule__VisibleSingleLineComment__ContentAssignment ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:130:1: ( ( rule__VisibleSingleLineComment__ContentAssignment ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:130:1: ( ( rule__VisibleSingleLineComment__ContentAssignment ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:131:1: ( rule__VisibleSingleLineComment__ContentAssignment )
            {
             before(grammarAccess.getVisibleSingleLineCommentAccess().getContentAssignment()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:132:1: ( rule__VisibleSingleLineComment__ContentAssignment )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:132:2: rule__VisibleSingleLineComment__ContentAssignment
            {
            pushFollow(FOLLOW_rule__VisibleSingleLineComment__ContentAssignment_in_ruleVisibleSingleLineComment215);
            rule__VisibleSingleLineComment__ContentAssignment();

            state._fsp--;


            }

             after(grammarAccess.getVisibleSingleLineCommentAccess().getContentAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVisibleSingleLineComment"


    // $ANTLR start "entryRuleVisibleMultiLineComment"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:144:1: entryRuleVisibleMultiLineComment : ruleVisibleMultiLineComment EOF ;
    public final void entryRuleVisibleMultiLineComment() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:145:1: ( ruleVisibleMultiLineComment EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:146:1: ruleVisibleMultiLineComment EOF
            {
             before(grammarAccess.getVisibleMultiLineCommentRule()); 
            pushFollow(FOLLOW_ruleVisibleMultiLineComment_in_entryRuleVisibleMultiLineComment242);
            ruleVisibleMultiLineComment();

            state._fsp--;

             after(grammarAccess.getVisibleMultiLineCommentRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVisibleMultiLineComment249); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVisibleMultiLineComment"


    // $ANTLR start "ruleVisibleMultiLineComment"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:153:1: ruleVisibleMultiLineComment : ( ( rule__VisibleMultiLineComment__ContentAssignment ) ) ;
    public final void ruleVisibleMultiLineComment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:157:2: ( ( ( rule__VisibleMultiLineComment__ContentAssignment ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:158:1: ( ( rule__VisibleMultiLineComment__ContentAssignment ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:158:1: ( ( rule__VisibleMultiLineComment__ContentAssignment ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:159:1: ( rule__VisibleMultiLineComment__ContentAssignment )
            {
             before(grammarAccess.getVisibleMultiLineCommentAccess().getContentAssignment()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:160:1: ( rule__VisibleMultiLineComment__ContentAssignment )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:160:2: rule__VisibleMultiLineComment__ContentAssignment
            {
            pushFollow(FOLLOW_rule__VisibleMultiLineComment__ContentAssignment_in_ruleVisibleMultiLineComment275);
            rule__VisibleMultiLineComment__ContentAssignment();

            state._fsp--;


            }

             after(grammarAccess.getVisibleMultiLineCommentAccess().getContentAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVisibleMultiLineComment"


    // $ANTLR start "entryRulePackageDefinition"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:172:1: entryRulePackageDefinition : rulePackageDefinition EOF ;
    public final void entryRulePackageDefinition() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:173:1: ( rulePackageDefinition EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:174:1: rulePackageDefinition EOF
            {
             before(grammarAccess.getPackageDefinitionRule()); 
            pushFollow(FOLLOW_rulePackageDefinition_in_entryRulePackageDefinition302);
            rulePackageDefinition();

            state._fsp--;

             after(grammarAccess.getPackageDefinitionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePackageDefinition309); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePackageDefinition"


    // $ANTLR start "rulePackageDefinition"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:181:1: rulePackageDefinition : ( ( rule__PackageDefinition__Group__0 ) ) ;
    public final void rulePackageDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:185:2: ( ( ( rule__PackageDefinition__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:186:1: ( ( rule__PackageDefinition__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:186:1: ( ( rule__PackageDefinition__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:187:1: ( rule__PackageDefinition__Group__0 )
            {
             before(grammarAccess.getPackageDefinitionAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:188:1: ( rule__PackageDefinition__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:188:2: rule__PackageDefinition__Group__0
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__0_in_rulePackageDefinition335);
            rule__PackageDefinition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getPackageDefinitionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePackageDefinition"


    // $ANTLR start "entryRulePackageStatement"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:200:1: entryRulePackageStatement : rulePackageStatement EOF ;
    public final void entryRulePackageStatement() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:201:1: ( rulePackageStatement EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:202:1: rulePackageStatement EOF
            {
             before(grammarAccess.getPackageStatementRule()); 
            pushFollow(FOLLOW_rulePackageStatement_in_entryRulePackageStatement362);
            rulePackageStatement();

            state._fsp--;

             after(grammarAccess.getPackageStatementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePackageStatement369); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePackageStatement"


    // $ANTLR start "rulePackageStatement"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:209:1: rulePackageStatement : ( ( rule__PackageStatement__Alternatives ) ) ;
    public final void rulePackageStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:213:2: ( ( ( rule__PackageStatement__Alternatives ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:214:1: ( ( rule__PackageStatement__Alternatives ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:214:1: ( ( rule__PackageStatement__Alternatives ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:215:1: ( rule__PackageStatement__Alternatives )
            {
             before(grammarAccess.getPackageStatementAccess().getAlternatives()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:216:1: ( rule__PackageStatement__Alternatives )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:216:2: rule__PackageStatement__Alternatives
            {
            pushFollow(FOLLOW_rule__PackageStatement__Alternatives_in_rulePackageStatement395);
            rule__PackageStatement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getPackageStatementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePackageStatement"


    // $ANTLR start "entryRuleImport"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:228:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:229:1: ( ruleImport EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:230:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport422);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport429); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:237:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:241:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:242:1: ( ( rule__Import__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:242:1: ( ( rule__Import__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:243:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:244:1: ( rule__Import__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:244:2: rule__Import__Group__0
            {
            pushFollow(FOLLOW_rule__Import__Group__0_in_ruleImport455);
            rule__Import__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleForkDefinition"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:256:1: entryRuleForkDefinition : ruleForkDefinition EOF ;
    public final void entryRuleForkDefinition() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:257:1: ( ruleForkDefinition EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:258:1: ruleForkDefinition EOF
            {
             before(grammarAccess.getForkDefinitionRule()); 
            pushFollow(FOLLOW_ruleForkDefinition_in_entryRuleForkDefinition482);
            ruleForkDefinition();

            state._fsp--;

             after(grammarAccess.getForkDefinitionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleForkDefinition489); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleForkDefinition"


    // $ANTLR start "ruleForkDefinition"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:265:1: ruleForkDefinition : ( ( rule__ForkDefinition__Group__0 ) ) ;
    public final void ruleForkDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:269:2: ( ( ( rule__ForkDefinition__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:270:1: ( ( rule__ForkDefinition__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:270:1: ( ( rule__ForkDefinition__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:271:1: ( rule__ForkDefinition__Group__0 )
            {
             before(grammarAccess.getForkDefinitionAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:272:1: ( rule__ForkDefinition__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:272:2: rule__ForkDefinition__Group__0
            {
            pushFollow(FOLLOW_rule__ForkDefinition__Group__0_in_ruleForkDefinition515);
            rule__ForkDefinition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getForkDefinitionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleForkDefinition"


    // $ANTLR start "entryRuleTestDefinition"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:284:1: entryRuleTestDefinition : ruleTestDefinition EOF ;
    public final void entryRuleTestDefinition() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:285:1: ( ruleTestDefinition EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:286:1: ruleTestDefinition EOF
            {
             before(grammarAccess.getTestDefinitionRule()); 
            pushFollow(FOLLOW_ruleTestDefinition_in_entryRuleTestDefinition542);
            ruleTestDefinition();

            state._fsp--;

             after(grammarAccess.getTestDefinitionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestDefinition549); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTestDefinition"


    // $ANTLR start "ruleTestDefinition"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:293:1: ruleTestDefinition : ( ( rule__TestDefinition__Group__0 ) ) ;
    public final void ruleTestDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:297:2: ( ( ( rule__TestDefinition__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:298:1: ( ( rule__TestDefinition__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:298:1: ( ( rule__TestDefinition__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:299:1: ( rule__TestDefinition__Group__0 )
            {
             before(grammarAccess.getTestDefinitionAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:300:1: ( rule__TestDefinition__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:300:2: rule__TestDefinition__Group__0
            {
            pushFollow(FOLLOW_rule__TestDefinition__Group__0_in_ruleTestDefinition575);
            rule__TestDefinition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTestDefinitionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTestDefinition"


    // $ANTLR start "entryRuleCallDefinition"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:312:1: entryRuleCallDefinition : ruleCallDefinition EOF ;
    public final void entryRuleCallDefinition() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:313:1: ( ruleCallDefinition EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:314:1: ruleCallDefinition EOF
            {
             before(grammarAccess.getCallDefinitionRule()); 
            pushFollow(FOLLOW_ruleCallDefinition_in_entryRuleCallDefinition602);
            ruleCallDefinition();

            state._fsp--;

             after(grammarAccess.getCallDefinitionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallDefinition609); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCallDefinition"


    // $ANTLR start "ruleCallDefinition"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:321:1: ruleCallDefinition : ( ( rule__CallDefinition__Group__0 ) ) ;
    public final void ruleCallDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:325:2: ( ( ( rule__CallDefinition__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:326:1: ( ( rule__CallDefinition__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:326:1: ( ( rule__CallDefinition__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:327:1: ( rule__CallDefinition__Group__0 )
            {
             before(grammarAccess.getCallDefinitionAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:328:1: ( rule__CallDefinition__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:328:2: rule__CallDefinition__Group__0
            {
            pushFollow(FOLLOW_rule__CallDefinition__Group__0_in_ruleCallDefinition635);
            rule__CallDefinition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCallDefinitionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCallDefinition"


    // $ANTLR start "entryRuleSuiteDefinition"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:340:1: entryRuleSuiteDefinition : ruleSuiteDefinition EOF ;
    public final void entryRuleSuiteDefinition() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:341:1: ( ruleSuiteDefinition EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:342:1: ruleSuiteDefinition EOF
            {
             before(grammarAccess.getSuiteDefinitionRule()); 
            pushFollow(FOLLOW_ruleSuiteDefinition_in_entryRuleSuiteDefinition662);
            ruleSuiteDefinition();

            state._fsp--;

             after(grammarAccess.getSuiteDefinitionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteDefinition669); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSuiteDefinition"


    // $ANTLR start "ruleSuiteDefinition"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:349:1: ruleSuiteDefinition : ( ( rule__SuiteDefinition__Group__0 ) ) ;
    public final void ruleSuiteDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:353:2: ( ( ( rule__SuiteDefinition__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:354:1: ( ( rule__SuiteDefinition__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:354:1: ( ( rule__SuiteDefinition__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:355:1: ( rule__SuiteDefinition__Group__0 )
            {
             before(grammarAccess.getSuiteDefinitionAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:356:1: ( rule__SuiteDefinition__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:356:2: rule__SuiteDefinition__Group__0
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__0_in_ruleSuiteDefinition695);
            rule__SuiteDefinition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSuiteDefinitionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSuiteDefinition"


    // $ANTLR start "entryRuleSuiteStatement"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:368:1: entryRuleSuiteStatement : ruleSuiteStatement EOF ;
    public final void entryRuleSuiteStatement() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:369:1: ( ruleSuiteStatement EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:370:1: ruleSuiteStatement EOF
            {
             before(grammarAccess.getSuiteStatementRule()); 
            pushFollow(FOLLOW_ruleSuiteStatement_in_entryRuleSuiteStatement722);
            ruleSuiteStatement();

            state._fsp--;

             after(grammarAccess.getSuiteStatementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteStatement729); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSuiteStatement"


    // $ANTLR start "ruleSuiteStatement"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:377:1: ruleSuiteStatement : ( ( rule__SuiteStatement__Alternatives ) ) ;
    public final void ruleSuiteStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:381:2: ( ( ( rule__SuiteStatement__Alternatives ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:382:1: ( ( rule__SuiteStatement__Alternatives ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:382:1: ( ( rule__SuiteStatement__Alternatives ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:383:1: ( rule__SuiteStatement__Alternatives )
            {
             before(grammarAccess.getSuiteStatementAccess().getAlternatives()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:384:1: ( rule__SuiteStatement__Alternatives )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:384:2: rule__SuiteStatement__Alternatives
            {
            pushFollow(FOLLOW_rule__SuiteStatement__Alternatives_in_ruleSuiteStatement755);
            rule__SuiteStatement__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getSuiteStatementAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSuiteStatement"


    // $ANTLR start "entryRuleSuiteStatementWithResult"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:396:1: entryRuleSuiteStatementWithResult : ruleSuiteStatementWithResult EOF ;
    public final void entryRuleSuiteStatementWithResult() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:397:1: ( ruleSuiteStatementWithResult EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:398:1: ruleSuiteStatementWithResult EOF
            {
             before(grammarAccess.getSuiteStatementWithResultRule()); 
            pushFollow(FOLLOW_ruleSuiteStatementWithResult_in_entryRuleSuiteStatementWithResult782);
            ruleSuiteStatementWithResult();

            state._fsp--;

             after(grammarAccess.getSuiteStatementWithResultRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteStatementWithResult789); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSuiteStatementWithResult"


    // $ANTLR start "ruleSuiteStatementWithResult"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:405:1: ruleSuiteStatementWithResult : ( ( rule__SuiteStatementWithResult__Alternatives ) ) ;
    public final void ruleSuiteStatementWithResult() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:409:2: ( ( ( rule__SuiteStatementWithResult__Alternatives ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:410:1: ( ( rule__SuiteStatementWithResult__Alternatives ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:410:1: ( ( rule__SuiteStatementWithResult__Alternatives ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:411:1: ( rule__SuiteStatementWithResult__Alternatives )
            {
             before(grammarAccess.getSuiteStatementWithResultAccess().getAlternatives()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:412:1: ( rule__SuiteStatementWithResult__Alternatives )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:412:2: rule__SuiteStatementWithResult__Alternatives
            {
            pushFollow(FOLLOW_rule__SuiteStatementWithResult__Alternatives_in_ruleSuiteStatementWithResult815);
            rule__SuiteStatementWithResult__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getSuiteStatementWithResultAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSuiteStatementWithResult"


    // $ANTLR start "entryRuleVariableDefinition"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:424:1: entryRuleVariableDefinition : ruleVariableDefinition EOF ;
    public final void entryRuleVariableDefinition() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:425:1: ( ruleVariableDefinition EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:426:1: ruleVariableDefinition EOF
            {
             before(grammarAccess.getVariableDefinitionRule()); 
            pushFollow(FOLLOW_ruleVariableDefinition_in_entryRuleVariableDefinition842);
            ruleVariableDefinition();

            state._fsp--;

             after(grammarAccess.getVariableDefinitionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDefinition849); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVariableDefinition"


    // $ANTLR start "ruleVariableDefinition"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:433:1: ruleVariableDefinition : ( ( rule__VariableDefinition__Group__0 ) ) ;
    public final void ruleVariableDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:437:2: ( ( ( rule__VariableDefinition__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:438:1: ( ( rule__VariableDefinition__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:438:1: ( ( rule__VariableDefinition__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:439:1: ( rule__VariableDefinition__Group__0 )
            {
             before(grammarAccess.getVariableDefinitionAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:440:1: ( rule__VariableDefinition__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:440:2: rule__VariableDefinition__Group__0
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group__0_in_ruleVariableDefinition875);
            rule__VariableDefinition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getVariableDefinitionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVariableDefinition"


    // $ANTLR start "entryRuleConstantDefinition"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:452:1: entryRuleConstantDefinition : ruleConstantDefinition EOF ;
    public final void entryRuleConstantDefinition() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:453:1: ( ruleConstantDefinition EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:454:1: ruleConstantDefinition EOF
            {
             before(grammarAccess.getConstantDefinitionRule()); 
            pushFollow(FOLLOW_ruleConstantDefinition_in_entryRuleConstantDefinition902);
            ruleConstantDefinition();

            state._fsp--;

             after(grammarAccess.getConstantDefinitionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstantDefinition909); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleConstantDefinition"


    // $ANTLR start "ruleConstantDefinition"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:461:1: ruleConstantDefinition : ( ( rule__ConstantDefinition__Group__0 ) ) ;
    public final void ruleConstantDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:465:2: ( ( ( rule__ConstantDefinition__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:466:1: ( ( rule__ConstantDefinition__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:466:1: ( ( rule__ConstantDefinition__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:467:1: ( rule__ConstantDefinition__Group__0 )
            {
             before(grammarAccess.getConstantDefinitionAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:468:1: ( rule__ConstantDefinition__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:468:2: rule__ConstantDefinition__Group__0
            {
            pushFollow(FOLLOW_rule__ConstantDefinition__Group__0_in_ruleConstantDefinition935);
            rule__ConstantDefinition__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getConstantDefinitionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleConstantDefinition"


    // $ANTLR start "entryRuleVariableEntity"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:480:1: entryRuleVariableEntity : ruleVariableEntity EOF ;
    public final void entryRuleVariableEntity() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:481:1: ( ruleVariableEntity EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:482:1: ruleVariableEntity EOF
            {
             before(grammarAccess.getVariableEntityRule()); 
            pushFollow(FOLLOW_ruleVariableEntity_in_entryRuleVariableEntity962);
            ruleVariableEntity();

            state._fsp--;

             after(grammarAccess.getVariableEntityRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableEntity969); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVariableEntity"


    // $ANTLR start "ruleVariableEntity"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:489:1: ruleVariableEntity : ( ( rule__VariableEntity__NameAssignment ) ) ;
    public final void ruleVariableEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:493:2: ( ( ( rule__VariableEntity__NameAssignment ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:494:1: ( ( rule__VariableEntity__NameAssignment ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:494:1: ( ( rule__VariableEntity__NameAssignment ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:495:1: ( rule__VariableEntity__NameAssignment )
            {
             before(grammarAccess.getVariableEntityAccess().getNameAssignment()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:496:1: ( rule__VariableEntity__NameAssignment )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:496:2: rule__VariableEntity__NameAssignment
            {
            pushFollow(FOLLOW_rule__VariableEntity__NameAssignment_in_ruleVariableEntity995);
            rule__VariableEntity__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getVariableEntityAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVariableEntity"


    // $ANTLR start "entryRuleTest"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:508:1: entryRuleTest : ruleTest EOF ;
    public final void entryRuleTest() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:509:1: ( ruleTest EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:510:1: ruleTest EOF
            {
             before(grammarAccess.getTestRule()); 
            pushFollow(FOLLOW_ruleTest_in_entryRuleTest1022);
            ruleTest();

            state._fsp--;

             after(grammarAccess.getTestRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTest1029); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTest"


    // $ANTLR start "ruleTest"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:517:1: ruleTest : ( ( rule__Test__Group__0 ) ) ;
    public final void ruleTest() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:521:2: ( ( ( rule__Test__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:522:1: ( ( rule__Test__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:522:1: ( ( rule__Test__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:523:1: ( rule__Test__Group__0 )
            {
             before(grammarAccess.getTestAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:524:1: ( rule__Test__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:524:2: rule__Test__Group__0
            {
            pushFollow(FOLLOW_rule__Test__Group__0_in_ruleTest1055);
            rule__Test__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTestAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTest"


    // $ANTLR start "entryRuleTableTest"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:536:1: entryRuleTableTest : ruleTableTest EOF ;
    public final void entryRuleTableTest() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:537:1: ( ruleTableTest EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:538:1: ruleTableTest EOF
            {
             before(grammarAccess.getTableTestRule()); 
            pushFollow(FOLLOW_ruleTableTest_in_entryRuleTableTest1082);
            ruleTableTest();

            state._fsp--;

             after(grammarAccess.getTableTestRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTableTest1089); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTableTest"


    // $ANTLR start "ruleTableTest"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:545:1: ruleTableTest : ( ( rule__TableTest__Group__0 ) ) ;
    public final void ruleTableTest() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:549:2: ( ( ( rule__TableTest__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:550:1: ( ( rule__TableTest__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:550:1: ( ( rule__TableTest__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:551:1: ( rule__TableTest__Group__0 )
            {
             before(grammarAccess.getTableTestAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:552:1: ( rule__TableTest__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:552:2: rule__TableTest__Group__0
            {
            pushFollow(FOLLOW_rule__TableTest__Group__0_in_ruleTableTest1115);
            rule__TableTest__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTableTestAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTableTest"


    // $ANTLR start "entryRuleTableTestRow"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:564:1: entryRuleTableTestRow : ruleTableTestRow EOF ;
    public final void entryRuleTableTestRow() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:565:1: ( ruleTableTestRow EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:566:1: ruleTableTestRow EOF
            {
             before(grammarAccess.getTableTestRowRule()); 
            pushFollow(FOLLOW_ruleTableTestRow_in_entryRuleTableTestRow1142);
            ruleTableTestRow();

            state._fsp--;

             after(grammarAccess.getTableTestRowRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTableTestRow1149); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTableTestRow"


    // $ANTLR start "ruleTableTestRow"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:573:1: ruleTableTestRow : ( ( rule__TableTestRow__Group__0 ) ) ;
    public final void ruleTableTestRow() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:577:2: ( ( ( rule__TableTestRow__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:578:1: ( ( rule__TableTestRow__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:578:1: ( ( rule__TableTestRow__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:579:1: ( rule__TableTestRow__Group__0 )
            {
             before(grammarAccess.getTableTestRowAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:580:1: ( rule__TableTestRow__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:580:2: rule__TableTestRow__Group__0
            {
            pushFollow(FOLLOW_rule__TableTestRow__Group__0_in_ruleTableTestRow1175);
            rule__TableTestRow__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTableTestRowAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTableTestRow"


    // $ANTLR start "entryRuleParameterTableHeader"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:592:1: entryRuleParameterTableHeader : ruleParameterTableHeader EOF ;
    public final void entryRuleParameterTableHeader() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:593:1: ( ruleParameterTableHeader EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:594:1: ruleParameterTableHeader EOF
            {
             before(grammarAccess.getParameterTableHeaderRule()); 
            pushFollow(FOLLOW_ruleParameterTableHeader_in_entryRuleParameterTableHeader1202);
            ruleParameterTableHeader();

            state._fsp--;

             after(grammarAccess.getParameterTableHeaderRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterTableHeader1209); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterTableHeader"


    // $ANTLR start "ruleParameterTableHeader"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:601:1: ruleParameterTableHeader : ( ( rule__ParameterTableHeader__Group__0 ) ) ;
    public final void ruleParameterTableHeader() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:605:2: ( ( ( rule__ParameterTableHeader__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:606:1: ( ( rule__ParameterTableHeader__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:606:1: ( ( rule__ParameterTableHeader__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:607:1: ( rule__ParameterTableHeader__Group__0 )
            {
             before(grammarAccess.getParameterTableHeaderAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:608:1: ( rule__ParameterTableHeader__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:608:2: rule__ParameterTableHeader__Group__0
            {
            pushFollow(FOLLOW_rule__ParameterTableHeader__Group__0_in_ruleParameterTableHeader1235);
            rule__ParameterTableHeader__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterTableHeaderAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterTableHeader"


    // $ANTLR start "entryRuleResultTableHeader"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:620:1: entryRuleResultTableHeader : ruleResultTableHeader EOF ;
    public final void entryRuleResultTableHeader() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:621:1: ( ruleResultTableHeader EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:622:1: ruleResultTableHeader EOF
            {
             before(grammarAccess.getResultTableHeaderRule()); 
            pushFollow(FOLLOW_ruleResultTableHeader_in_entryRuleResultTableHeader1262);
            ruleResultTableHeader();

            state._fsp--;

             after(grammarAccess.getResultTableHeaderRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultTableHeader1269); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleResultTableHeader"


    // $ANTLR start "ruleResultTableHeader"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:629:1: ruleResultTableHeader : ( ( rule__ResultTableHeader__Group__0 ) ) ;
    public final void ruleResultTableHeader() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:633:2: ( ( ( rule__ResultTableHeader__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:634:1: ( ( rule__ResultTableHeader__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:634:1: ( ( rule__ResultTableHeader__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:635:1: ( rule__ResultTableHeader__Group__0 )
            {
             before(grammarAccess.getResultTableHeaderAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:636:1: ( rule__ResultTableHeader__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:636:2: rule__ResultTableHeader__Group__0
            {
            pushFollow(FOLLOW_rule__ResultTableHeader__Group__0_in_ruleResultTableHeader1295);
            rule__ResultTableHeader__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getResultTableHeaderAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleResultTableHeader"


    // $ANTLR start "entryRuleParameterTableValue"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:648:1: entryRuleParameterTableValue : ruleParameterTableValue EOF ;
    public final void entryRuleParameterTableValue() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:649:1: ( ruleParameterTableValue EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:650:1: ruleParameterTableValue EOF
            {
             before(grammarAccess.getParameterTableValueRule()); 
            pushFollow(FOLLOW_ruleParameterTableValue_in_entryRuleParameterTableValue1322);
            ruleParameterTableValue();

            state._fsp--;

             after(grammarAccess.getParameterTableValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterTableValue1329); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterTableValue"


    // $ANTLR start "ruleParameterTableValue"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:657:1: ruleParameterTableValue : ( ( rule__ParameterTableValue__Group__0 ) ) ;
    public final void ruleParameterTableValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:661:2: ( ( ( rule__ParameterTableValue__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:662:1: ( ( rule__ParameterTableValue__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:662:1: ( ( rule__ParameterTableValue__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:663:1: ( rule__ParameterTableValue__Group__0 )
            {
             before(grammarAccess.getParameterTableValueAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:664:1: ( rule__ParameterTableValue__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:664:2: rule__ParameterTableValue__Group__0
            {
            pushFollow(FOLLOW_rule__ParameterTableValue__Group__0_in_ruleParameterTableValue1355);
            rule__ParameterTableValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterTableValueAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterTableValue"


    // $ANTLR start "entryRuleNamedResult"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:676:1: entryRuleNamedResult : ruleNamedResult EOF ;
    public final void entryRuleNamedResult() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:677:1: ( ruleNamedResult EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:678:1: ruleNamedResult EOF
            {
             before(grammarAccess.getNamedResultRule()); 
            pushFollow(FOLLOW_ruleNamedResult_in_entryRuleNamedResult1382);
            ruleNamedResult();

            state._fsp--;

             after(grammarAccess.getNamedResultRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedResult1389); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNamedResult"


    // $ANTLR start "ruleNamedResult"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:685:1: ruleNamedResult : ( ( rule__NamedResult__Group__0 ) ) ;
    public final void ruleNamedResult() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:689:2: ( ( ( rule__NamedResult__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:690:1: ( ( rule__NamedResult__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:690:1: ( ( rule__NamedResult__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:691:1: ( rule__NamedResult__Group__0 )
            {
             before(grammarAccess.getNamedResultAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:692:1: ( rule__NamedResult__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:692:2: rule__NamedResult__Group__0
            {
            pushFollow(FOLLOW_rule__NamedResult__Group__0_in_ruleNamedResult1415);
            rule__NamedResult__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNamedResultAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNamedResult"


    // $ANTLR start "entryRuleResultName"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:704:1: entryRuleResultName : ruleResultName EOF ;
    public final void entryRuleResultName() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:705:1: ( ruleResultName EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:706:1: ruleResultName EOF
            {
             before(grammarAccess.getResultNameRule()); 
            pushFollow(FOLLOW_ruleResultName_in_entryRuleResultName1442);
            ruleResultName();

            state._fsp--;

             after(grammarAccess.getResultNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultName1449); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleResultName"


    // $ANTLR start "ruleResultName"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:713:1: ruleResultName : ( ( rule__ResultName__Alternatives ) ) ;
    public final void ruleResultName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:717:2: ( ( ( rule__ResultName__Alternatives ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:718:1: ( ( rule__ResultName__Alternatives ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:718:1: ( ( rule__ResultName__Alternatives ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:719:1: ( rule__ResultName__Alternatives )
            {
             before(grammarAccess.getResultNameAccess().getAlternatives()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:720:1: ( rule__ResultName__Alternatives )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:720:2: rule__ResultName__Alternatives
            {
            pushFollow(FOLLOW_rule__ResultName__Alternatives_in_ruleResultName1475);
            rule__ResultName__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getResultNameAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleResultName"


    // $ANTLR start "entryRuleFixedResultName"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:732:1: entryRuleFixedResultName : ruleFixedResultName EOF ;
    public final void entryRuleFixedResultName() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:733:1: ( ruleFixedResultName EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:734:1: ruleFixedResultName EOF
            {
             before(grammarAccess.getFixedResultNameRule()); 
            pushFollow(FOLLOW_ruleFixedResultName_in_entryRuleFixedResultName1502);
            ruleFixedResultName();

            state._fsp--;

             after(grammarAccess.getFixedResultNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFixedResultName1509); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFixedResultName"


    // $ANTLR start "ruleFixedResultName"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:741:1: ruleFixedResultName : ( ( rule__FixedResultName__FieldAssignment ) ) ;
    public final void ruleFixedResultName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:745:2: ( ( ( rule__FixedResultName__FieldAssignment ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:746:1: ( ( rule__FixedResultName__FieldAssignment ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:746:1: ( ( rule__FixedResultName__FieldAssignment ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:747:1: ( rule__FixedResultName__FieldAssignment )
            {
             before(grammarAccess.getFixedResultNameAccess().getFieldAssignment()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:748:1: ( rule__FixedResultName__FieldAssignment )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:748:2: rule__FixedResultName__FieldAssignment
            {
            pushFollow(FOLLOW_rule__FixedResultName__FieldAssignment_in_ruleFixedResultName1535);
            rule__FixedResultName__FieldAssignment();

            state._fsp--;


            }

             after(grammarAccess.getFixedResultNameAccess().getFieldAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFixedResultName"


    // $ANTLR start "entryRuleCall"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:760:1: entryRuleCall : ruleCall EOF ;
    public final void entryRuleCall() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:761:1: ( ruleCall EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:762:1: ruleCall EOF
            {
             before(grammarAccess.getCallRule()); 
            pushFollow(FOLLOW_ruleCall_in_entryRuleCall1562);
            ruleCall();

            state._fsp--;

             after(grammarAccess.getCallRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCall1569); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCall"


    // $ANTLR start "ruleCall"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:769:1: ruleCall : ( ( rule__Call__Group__0 ) ) ;
    public final void ruleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:773:2: ( ( ( rule__Call__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:774:1: ( ( rule__Call__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:774:1: ( ( rule__Call__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:775:1: ( rule__Call__Group__0 )
            {
             before(grammarAccess.getCallAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:776:1: ( rule__Call__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:776:2: rule__Call__Group__0
            {
            pushFollow(FOLLOW_rule__Call__Group__0_in_ruleCall1595);
            rule__Call__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getCallAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCall"


    // $ANTLR start "entryRuleNamedCallResult"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:788:1: entryRuleNamedCallResult : ruleNamedCallResult EOF ;
    public final void entryRuleNamedCallResult() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:789:1: ( ruleNamedCallResult EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:790:1: ruleNamedCallResult EOF
            {
             before(grammarAccess.getNamedCallResultRule()); 
            pushFollow(FOLLOW_ruleNamedCallResult_in_entryRuleNamedCallResult1622);
            ruleNamedCallResult();

            state._fsp--;

             after(grammarAccess.getNamedCallResultRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedCallResult1629); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNamedCallResult"


    // $ANTLR start "ruleNamedCallResult"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:797:1: ruleNamedCallResult : ( ( rule__NamedCallResult__Group__0 ) ) ;
    public final void ruleNamedCallResult() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:801:2: ( ( ( rule__NamedCallResult__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:802:1: ( ( rule__NamedCallResult__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:802:1: ( ( rule__NamedCallResult__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:803:1: ( rule__NamedCallResult__Group__0 )
            {
             before(grammarAccess.getNamedCallResultAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:804:1: ( rule__NamedCallResult__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:804:2: rule__NamedCallResult__Group__0
            {
            pushFollow(FOLLOW_rule__NamedCallResult__Group__0_in_ruleNamedCallResult1655);
            rule__NamedCallResult__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNamedCallResultAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNamedCallResult"


    // $ANTLR start "entryRuleSuite"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:816:1: entryRuleSuite : ruleSuite EOF ;
    public final void entryRuleSuite() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:817:1: ( ruleSuite EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:818:1: ruleSuite EOF
            {
             before(grammarAccess.getSuiteRule()); 
            pushFollow(FOLLOW_ruleSuite_in_entryRuleSuite1682);
            ruleSuite();

            state._fsp--;

             after(grammarAccess.getSuiteRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuite1689); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSuite"


    // $ANTLR start "ruleSuite"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:825:1: ruleSuite : ( ( rule__Suite__Group__0 ) ) ;
    public final void ruleSuite() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:829:2: ( ( ( rule__Suite__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:830:1: ( ( rule__Suite__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:830:1: ( ( rule__Suite__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:831:1: ( rule__Suite__Group__0 )
            {
             before(grammarAccess.getSuiteAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:832:1: ( rule__Suite__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:832:2: rule__Suite__Group__0
            {
            pushFollow(FOLLOW_rule__Suite__Group__0_in_ruleSuite1715);
            rule__Suite__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSuiteAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSuite"


    // $ANTLR start "entryRuleSuiteParameter"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:844:1: entryRuleSuiteParameter : ruleSuiteParameter EOF ;
    public final void entryRuleSuiteParameter() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:845:1: ( ruleSuiteParameter EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:846:1: ruleSuiteParameter EOF
            {
             before(grammarAccess.getSuiteParameterRule()); 
            pushFollow(FOLLOW_ruleSuiteParameter_in_entryRuleSuiteParameter1742);
            ruleSuiteParameter();

            state._fsp--;

             after(grammarAccess.getSuiteParameterRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteParameter1749); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSuiteParameter"


    // $ANTLR start "ruleSuiteParameter"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:853:1: ruleSuiteParameter : ( ( rule__SuiteParameter__Group__0 ) ) ;
    public final void ruleSuiteParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:857:2: ( ( ( rule__SuiteParameter__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:858:1: ( ( rule__SuiteParameter__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:858:1: ( ( rule__SuiteParameter__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:859:1: ( rule__SuiteParameter__Group__0 )
            {
             before(grammarAccess.getSuiteParameterAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:860:1: ( rule__SuiteParameter__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:860:2: rule__SuiteParameter__Group__0
            {
            pushFollow(FOLLOW_rule__SuiteParameter__Group__0_in_ruleSuiteParameter1775);
            rule__SuiteParameter__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getSuiteParameterAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSuiteParameter"


    // $ANTLR start "entryRuleParameter"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:872:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:873:1: ( ruleParameter EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:874:1: ruleParameter EOF
            {
             before(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter1802);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getParameterRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter1809); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:881:1: ruleParameter : ( ( rule__Parameter__Group__0 ) ) ;
    public final void ruleParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:885:2: ( ( ( rule__Parameter__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:886:1: ( ( rule__Parameter__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:886:1: ( ( rule__Parameter__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:887:1: ( rule__Parameter__Group__0 )
            {
             before(grammarAccess.getParameterAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:888:1: ( rule__Parameter__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:888:2: rule__Parameter__Group__0
            {
            pushFollow(FOLLOW_rule__Parameter__Group__0_in_ruleParameter1835);
            rule__Parameter__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleParameterName"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:900:1: entryRuleParameterName : ruleParameterName EOF ;
    public final void entryRuleParameterName() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:901:1: ( ruleParameterName EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:902:1: ruleParameterName EOF
            {
             before(grammarAccess.getParameterNameRule()); 
            pushFollow(FOLLOW_ruleParameterName_in_entryRuleParameterName1862);
            ruleParameterName();

            state._fsp--;

             after(grammarAccess.getParameterNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterName1869); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleParameterName"


    // $ANTLR start "ruleParameterName"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:909:1: ruleParameterName : ( ( rule__ParameterName__Alternatives ) ) ;
    public final void ruleParameterName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:913:2: ( ( ( rule__ParameterName__Alternatives ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:914:1: ( ( rule__ParameterName__Alternatives ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:914:1: ( ( rule__ParameterName__Alternatives ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:915:1: ( rule__ParameterName__Alternatives )
            {
             before(grammarAccess.getParameterNameAccess().getAlternatives()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:916:1: ( rule__ParameterName__Alternatives )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:916:2: rule__ParameterName__Alternatives
            {
            pushFollow(FOLLOW_rule__ParameterName__Alternatives_in_ruleParameterName1895);
            rule__ParameterName__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getParameterNameAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleParameterName"


    // $ANTLR start "entryRuleFixedParameterName"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:928:1: entryRuleFixedParameterName : ruleFixedParameterName EOF ;
    public final void entryRuleFixedParameterName() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:929:1: ( ruleFixedParameterName EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:930:1: ruleFixedParameterName EOF
            {
             before(grammarAccess.getFixedParameterNameRule()); 
            pushFollow(FOLLOW_ruleFixedParameterName_in_entryRuleFixedParameterName1922);
            ruleFixedParameterName();

            state._fsp--;

             after(grammarAccess.getFixedParameterNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFixedParameterName1929); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFixedParameterName"


    // $ANTLR start "ruleFixedParameterName"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:937:1: ruleFixedParameterName : ( ( rule__FixedParameterName__AnnotationAssignment ) ) ;
    public final void ruleFixedParameterName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:941:2: ( ( ( rule__FixedParameterName__AnnotationAssignment ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:942:1: ( ( rule__FixedParameterName__AnnotationAssignment ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:942:1: ( ( rule__FixedParameterName__AnnotationAssignment ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:943:1: ( rule__FixedParameterName__AnnotationAssignment )
            {
             before(grammarAccess.getFixedParameterNameAccess().getAnnotationAssignment()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:944:1: ( rule__FixedParameterName__AnnotationAssignment )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:944:2: rule__FixedParameterName__AnnotationAssignment
            {
            pushFollow(FOLLOW_rule__FixedParameterName__AnnotationAssignment_in_ruleFixedParameterName1955);
            rule__FixedParameterName__AnnotationAssignment();

            state._fsp--;


            }

             after(grammarAccess.getFixedParameterNameAccess().getAnnotationAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFixedParameterName"


    // $ANTLR start "entryRuleArbitraryParameterOrResultName"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:956:1: entryRuleArbitraryParameterOrResultName : ruleArbitraryParameterOrResultName EOF ;
    public final void entryRuleArbitraryParameterOrResultName() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:957:1: ( ruleArbitraryParameterOrResultName EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:958:1: ruleArbitraryParameterOrResultName EOF
            {
             before(grammarAccess.getArbitraryParameterOrResultNameRule()); 
            pushFollow(FOLLOW_ruleArbitraryParameterOrResultName_in_entryRuleArbitraryParameterOrResultName1982);
            ruleArbitraryParameterOrResultName();

            state._fsp--;

             after(grammarAccess.getArbitraryParameterOrResultNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArbitraryParameterOrResultName1989); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleArbitraryParameterOrResultName"


    // $ANTLR start "ruleArbitraryParameterOrResultName"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:965:1: ruleArbitraryParameterOrResultName : ( ( rule__ArbitraryParameterOrResultName__Group__0 ) ) ;
    public final void ruleArbitraryParameterOrResultName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:969:2: ( ( ( rule__ArbitraryParameterOrResultName__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:970:1: ( ( rule__ArbitraryParameterOrResultName__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:970:1: ( ( rule__ArbitraryParameterOrResultName__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:971:1: ( rule__ArbitraryParameterOrResultName__Group__0 )
            {
             before(grammarAccess.getArbitraryParameterOrResultNameAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:972:1: ( rule__ArbitraryParameterOrResultName__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:972:2: rule__ArbitraryParameterOrResultName__Group__0
            {
            pushFollow(FOLLOW_rule__ArbitraryParameterOrResultName__Group__0_in_ruleArbitraryParameterOrResultName2015);
            rule__ArbitraryParameterOrResultName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getArbitraryParameterOrResultNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleArbitraryParameterOrResultName"


    // $ANTLR start "entryRuleValueOrEnumValueCollection"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:984:1: entryRuleValueOrEnumValueCollection : ruleValueOrEnumValueCollection EOF ;
    public final void entryRuleValueOrEnumValueCollection() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:985:1: ( ruleValueOrEnumValueCollection EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:986:1: ruleValueOrEnumValueCollection EOF
            {
             before(grammarAccess.getValueOrEnumValueCollectionRule()); 
            pushFollow(FOLLOW_ruleValueOrEnumValueCollection_in_entryRuleValueOrEnumValueCollection2042);
            ruleValueOrEnumValueCollection();

            state._fsp--;

             after(grammarAccess.getValueOrEnumValueCollectionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueOrEnumValueCollection2049); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleValueOrEnumValueCollection"


    // $ANTLR start "ruleValueOrEnumValueCollection"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:993:1: ruleValueOrEnumValueCollection : ( ( rule__ValueOrEnumValueCollection__Group__0 ) ) ;
    public final void ruleValueOrEnumValueCollection() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:997:2: ( ( ( rule__ValueOrEnumValueCollection__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:998:1: ( ( rule__ValueOrEnumValueCollection__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:998:1: ( ( rule__ValueOrEnumValueCollection__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:999:1: ( rule__ValueOrEnumValueCollection__Group__0 )
            {
             before(grammarAccess.getValueOrEnumValueCollectionAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1000:1: ( rule__ValueOrEnumValueCollection__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1000:2: rule__ValueOrEnumValueCollection__Group__0
            {
            pushFollow(FOLLOW_rule__ValueOrEnumValueCollection__Group__0_in_ruleValueOrEnumValueCollection2075);
            rule__ValueOrEnumValueCollection__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getValueOrEnumValueCollectionAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValueOrEnumValueCollection"


    // $ANTLR start "entryRuleValueOrEnumValue"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1012:1: entryRuleValueOrEnumValue : ruleValueOrEnumValue EOF ;
    public final void entryRuleValueOrEnumValue() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1013:1: ( ruleValueOrEnumValue EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1014:1: ruleValueOrEnumValue EOF
            {
             before(grammarAccess.getValueOrEnumValueRule()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_entryRuleValueOrEnumValue2102);
            ruleValueOrEnumValue();

            state._fsp--;

             after(grammarAccess.getValueOrEnumValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueOrEnumValue2109); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleValueOrEnumValue"


    // $ANTLR start "ruleValueOrEnumValue"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1021:1: ruleValueOrEnumValue : ( ( rule__ValueOrEnumValue__Alternatives ) ) ;
    public final void ruleValueOrEnumValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1025:2: ( ( ( rule__ValueOrEnumValue__Alternatives ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1026:1: ( ( rule__ValueOrEnumValue__Alternatives ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1026:1: ( ( rule__ValueOrEnumValue__Alternatives ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1027:1: ( rule__ValueOrEnumValue__Alternatives )
            {
             before(grammarAccess.getValueOrEnumValueAccess().getAlternatives()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1028:1: ( rule__ValueOrEnumValue__Alternatives )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1028:2: rule__ValueOrEnumValue__Alternatives
            {
            pushFollow(FOLLOW_rule__ValueOrEnumValue__Alternatives_in_ruleValueOrEnumValue2135);
            rule__ValueOrEnumValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getValueOrEnumValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValueOrEnumValue"


    // $ANTLR start "entryRuleValue"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1040:1: entryRuleValue : ruleValue EOF ;
    public final void entryRuleValue() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1041:1: ( ruleValue EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1042:1: ruleValue EOF
            {
             before(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue2162);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue2169); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1049:1: ruleValue : ( ( rule__Value__Alternatives ) ) ;
    public final void ruleValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1053:2: ( ( ( rule__Value__Alternatives ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1054:1: ( ( rule__Value__Alternatives ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1054:1: ( ( rule__Value__Alternatives ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1055:1: ( rule__Value__Alternatives )
            {
             before(grammarAccess.getValueAccess().getAlternatives()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1056:1: ( rule__Value__Alternatives )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1056:2: rule__Value__Alternatives
            {
            pushFollow(FOLLOW_rule__Value__Alternatives_in_ruleValue2195);
            rule__Value__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleIntegerValue"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1068:1: entryRuleIntegerValue : ruleIntegerValue EOF ;
    public final void entryRuleIntegerValue() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1069:1: ( ruleIntegerValue EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1070:1: ruleIntegerValue EOF
            {
             before(grammarAccess.getIntegerValueRule()); 
            pushFollow(FOLLOW_ruleIntegerValue_in_entryRuleIntegerValue2222);
            ruleIntegerValue();

            state._fsp--;

             after(grammarAccess.getIntegerValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerValue2229); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIntegerValue"


    // $ANTLR start "ruleIntegerValue"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1077:1: ruleIntegerValue : ( ( rule__IntegerValue__IntegerValueAssignment ) ) ;
    public final void ruleIntegerValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1081:2: ( ( ( rule__IntegerValue__IntegerValueAssignment ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1082:1: ( ( rule__IntegerValue__IntegerValueAssignment ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1082:1: ( ( rule__IntegerValue__IntegerValueAssignment ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1083:1: ( rule__IntegerValue__IntegerValueAssignment )
            {
             before(grammarAccess.getIntegerValueAccess().getIntegerValueAssignment()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1084:1: ( rule__IntegerValue__IntegerValueAssignment )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1084:2: rule__IntegerValue__IntegerValueAssignment
            {
            pushFollow(FOLLOW_rule__IntegerValue__IntegerValueAssignment_in_ruleIntegerValue2255);
            rule__IntegerValue__IntegerValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getIntegerValueAccess().getIntegerValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIntegerValue"


    // $ANTLR start "entryRuleDecimalValue"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1096:1: entryRuleDecimalValue : ruleDecimalValue EOF ;
    public final void entryRuleDecimalValue() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1097:1: ( ruleDecimalValue EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1098:1: ruleDecimalValue EOF
            {
             before(grammarAccess.getDecimalValueRule()); 
            pushFollow(FOLLOW_ruleDecimalValue_in_entryRuleDecimalValue2282);
            ruleDecimalValue();

            state._fsp--;

             after(grammarAccess.getDecimalValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalValue2289); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDecimalValue"


    // $ANTLR start "ruleDecimalValue"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1105:1: ruleDecimalValue : ( ( rule__DecimalValue__DecimalValueAssignment ) ) ;
    public final void ruleDecimalValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1109:2: ( ( ( rule__DecimalValue__DecimalValueAssignment ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1110:1: ( ( rule__DecimalValue__DecimalValueAssignment ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1110:1: ( ( rule__DecimalValue__DecimalValueAssignment ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1111:1: ( rule__DecimalValue__DecimalValueAssignment )
            {
             before(grammarAccess.getDecimalValueAccess().getDecimalValueAssignment()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1112:1: ( rule__DecimalValue__DecimalValueAssignment )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1112:2: rule__DecimalValue__DecimalValueAssignment
            {
            pushFollow(FOLLOW_rule__DecimalValue__DecimalValueAssignment_in_ruleDecimalValue2315);
            rule__DecimalValue__DecimalValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getDecimalValueAccess().getDecimalValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDecimalValue"


    // $ANTLR start "entryRuleStringValue"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1124:1: entryRuleStringValue : ruleStringValue EOF ;
    public final void entryRuleStringValue() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1125:1: ( ruleStringValue EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1126:1: ruleStringValue EOF
            {
             before(grammarAccess.getStringValueRule()); 
            pushFollow(FOLLOW_ruleStringValue_in_entryRuleStringValue2342);
            ruleStringValue();

            state._fsp--;

             after(grammarAccess.getStringValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringValue2349); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleStringValue"


    // $ANTLR start "ruleStringValue"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1133:1: ruleStringValue : ( ( rule__StringValue__StringValueAssignment ) ) ;
    public final void ruleStringValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1137:2: ( ( ( rule__StringValue__StringValueAssignment ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1138:1: ( ( rule__StringValue__StringValueAssignment ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1138:1: ( ( rule__StringValue__StringValueAssignment ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1139:1: ( rule__StringValue__StringValueAssignment )
            {
             before(grammarAccess.getStringValueAccess().getStringValueAssignment()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1140:1: ( rule__StringValue__StringValueAssignment )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1140:2: rule__StringValue__StringValueAssignment
            {
            pushFollow(FOLLOW_rule__StringValue__StringValueAssignment_in_ruleStringValue2375);
            rule__StringValue__StringValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getStringValueAccess().getStringValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleStringValue"


    // $ANTLR start "entryRuleBooleanValue"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1152:1: entryRuleBooleanValue : ruleBooleanValue EOF ;
    public final void entryRuleBooleanValue() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1153:1: ( ruleBooleanValue EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1154:1: ruleBooleanValue EOF
            {
             before(grammarAccess.getBooleanValueRule()); 
            pushFollow(FOLLOW_ruleBooleanValue_in_entryRuleBooleanValue2402);
            ruleBooleanValue();

            state._fsp--;

             after(grammarAccess.getBooleanValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanValue2409); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleBooleanValue"


    // $ANTLR start "ruleBooleanValue"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1161:1: ruleBooleanValue : ( ( rule__BooleanValue__BooleanValueAssignment ) ) ;
    public final void ruleBooleanValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1165:2: ( ( ( rule__BooleanValue__BooleanValueAssignment ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1166:1: ( ( rule__BooleanValue__BooleanValueAssignment ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1166:1: ( ( rule__BooleanValue__BooleanValueAssignment ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1167:1: ( rule__BooleanValue__BooleanValueAssignment )
            {
             before(grammarAccess.getBooleanValueAccess().getBooleanValueAssignment()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1168:1: ( rule__BooleanValue__BooleanValueAssignment )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1168:2: rule__BooleanValue__BooleanValueAssignment
            {
            pushFollow(FOLLOW_rule__BooleanValue__BooleanValueAssignment_in_ruleBooleanValue2435);
            rule__BooleanValue__BooleanValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getBooleanValueAccess().getBooleanValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleBooleanValue"


    // $ANTLR start "entryRuleVariable"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1180:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1181:1: ( ruleVariable EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1182:1: ruleVariable EOF
            {
             before(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable2462);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getVariableRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable2469); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1189:1: ruleVariable : ( ( rule__Variable__NameAssignment ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1193:2: ( ( ( rule__Variable__NameAssignment ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1194:1: ( ( rule__Variable__NameAssignment ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1194:1: ( ( rule__Variable__NameAssignment ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1195:1: ( rule__Variable__NameAssignment )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1196:1: ( rule__Variable__NameAssignment )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1196:2: rule__Variable__NameAssignment
            {
            pushFollow(FOLLOW_rule__Variable__NameAssignment_in_ruleVariable2495);
            rule__Variable__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getVariableAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleNullValue"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1208:1: entryRuleNullValue : ruleNullValue EOF ;
    public final void entryRuleNullValue() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1209:1: ( ruleNullValue EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1210:1: ruleNullValue EOF
            {
             before(grammarAccess.getNullValueRule()); 
            pushFollow(FOLLOW_ruleNullValue_in_entryRuleNullValue2522);
            ruleNullValue();

            state._fsp--;

             after(grammarAccess.getNullValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullValue2529); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleNullValue"


    // $ANTLR start "ruleNullValue"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1217:1: ruleNullValue : ( ( rule__NullValue__Group__0 ) ) ;
    public final void ruleNullValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1221:2: ( ( ( rule__NullValue__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1222:1: ( ( rule__NullValue__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1222:1: ( ( rule__NullValue__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1223:1: ( rule__NullValue__Group__0 )
            {
             before(grammarAccess.getNullValueAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1224:1: ( rule__NullValue__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1224:2: rule__NullValue__Group__0
            {
            pushFollow(FOLLOW_rule__NullValue__Group__0_in_ruleNullValue2555);
            rule__NullValue__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getNullValueAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleNullValue"


    // $ANTLR start "entryRuleEnumValue"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1236:1: entryRuleEnumValue : ruleEnumValue EOF ;
    public final void entryRuleEnumValue() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1237:1: ( ruleEnumValue EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1238:1: ruleEnumValue EOF
            {
             before(grammarAccess.getEnumValueRule()); 
            pushFollow(FOLLOW_ruleEnumValue_in_entryRuleEnumValue2582);
            ruleEnumValue();

            state._fsp--;

             after(grammarAccess.getEnumValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumValue2589); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEnumValue"


    // $ANTLR start "ruleEnumValue"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1245:1: ruleEnumValue : ( ( rule__EnumValue__EnumValueAssignment ) ) ;
    public final void ruleEnumValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1249:2: ( ( ( rule__EnumValue__EnumValueAssignment ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1250:1: ( ( rule__EnumValue__EnumValueAssignment ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1250:1: ( ( rule__EnumValue__EnumValueAssignment ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1251:1: ( rule__EnumValue__EnumValueAssignment )
            {
             before(grammarAccess.getEnumValueAccess().getEnumValueAssignment()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1252:1: ( rule__EnumValue__EnumValueAssignment )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1252:2: rule__EnumValue__EnumValueAssignment
            {
            pushFollow(FOLLOW_rule__EnumValue__EnumValueAssignment_in_ruleEnumValue2615);
            rule__EnumValue__EnumValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getEnumValueAccess().getEnumValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEnumValue"


    // $ANTLR start "entryRuleMethodReference"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1264:1: entryRuleMethodReference : ruleMethodReference EOF ;
    public final void entryRuleMethodReference() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1265:1: ( ruleMethodReference EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1266:1: ruleMethodReference EOF
            {
             before(grammarAccess.getMethodReferenceRule()); 
            pushFollow(FOLLOW_ruleMethodReference_in_entryRuleMethodReference2642);
            ruleMethodReference();

            state._fsp--;

             after(grammarAccess.getMethodReferenceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodReference2649); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMethodReference"


    // $ANTLR start "ruleMethodReference"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1273:1: ruleMethodReference : ( ( rule__MethodReference__Group__0 ) ) ;
    public final void ruleMethodReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1277:2: ( ( ( rule__MethodReference__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1278:1: ( ( rule__MethodReference__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1278:1: ( ( rule__MethodReference__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1279:1: ( rule__MethodReference__Group__0 )
            {
             before(grammarAccess.getMethodReferenceAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1280:1: ( rule__MethodReference__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1280:2: rule__MethodReference__Group__0
            {
            pushFollow(FOLLOW_rule__MethodReference__Group__0_in_ruleMethodReference2675);
            rule__MethodReference__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMethodReferenceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMethodReference"


    // $ANTLR start "entryRuleExecutionMultiplier"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1292:1: entryRuleExecutionMultiplier : ruleExecutionMultiplier EOF ;
    public final void entryRuleExecutionMultiplier() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1293:1: ( ruleExecutionMultiplier EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1294:1: ruleExecutionMultiplier EOF
            {
             before(grammarAccess.getExecutionMultiplierRule()); 
            pushFollow(FOLLOW_ruleExecutionMultiplier_in_entryRuleExecutionMultiplier2702);
            ruleExecutionMultiplier();

            state._fsp--;

             after(grammarAccess.getExecutionMultiplierRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExecutionMultiplier2709); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleExecutionMultiplier"


    // $ANTLR start "ruleExecutionMultiplier"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1301:1: ruleExecutionMultiplier : ( ( rule__ExecutionMultiplier__Group__0 ) ) ;
    public final void ruleExecutionMultiplier() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1305:2: ( ( ( rule__ExecutionMultiplier__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1306:1: ( ( rule__ExecutionMultiplier__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1306:1: ( ( rule__ExecutionMultiplier__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1307:1: ( rule__ExecutionMultiplier__Group__0 )
            {
             before(grammarAccess.getExecutionMultiplierAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1308:1: ( rule__ExecutionMultiplier__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1308:2: rule__ExecutionMultiplier__Group__0
            {
            pushFollow(FOLLOW_rule__ExecutionMultiplier__Group__0_in_ruleExecutionMultiplier2735);
            rule__ExecutionMultiplier__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExecutionMultiplierAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleExecutionMultiplier"


    // $ANTLR start "entryRuleQualifiedName"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1320:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1321:1: ( ruleQualifiedName EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1322:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2762);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName2769); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1329:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1333:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1334:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1334:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1335:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1336:1: ( rule__QualifiedName__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1336:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName2795);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleQualifiedJavaClassName"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1348:1: entryRuleQualifiedJavaClassName : ruleQualifiedJavaClassName EOF ;
    public final void entryRuleQualifiedJavaClassName() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1349:1: ( ruleQualifiedJavaClassName EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1350:1: ruleQualifiedJavaClassName EOF
            {
             before(grammarAccess.getQualifiedJavaClassNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_entryRuleQualifiedJavaClassName2822);
            ruleQualifiedJavaClassName();

            state._fsp--;

             after(grammarAccess.getQualifiedJavaClassNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedJavaClassName2829); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedJavaClassName"


    // $ANTLR start "ruleQualifiedJavaClassName"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1357:1: ruleQualifiedJavaClassName : ( ( rule__QualifiedJavaClassName__Group__0 ) ) ;
    public final void ruleQualifiedJavaClassName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1361:2: ( ( ( rule__QualifiedJavaClassName__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1362:1: ( ( rule__QualifiedJavaClassName__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1362:1: ( ( rule__QualifiedJavaClassName__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1363:1: ( rule__QualifiedJavaClassName__Group__0 )
            {
             before(grammarAccess.getQualifiedJavaClassNameAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1364:1: ( rule__QualifiedJavaClassName__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1364:2: rule__QualifiedJavaClassName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__0_in_ruleQualifiedJavaClassName2855);
            rule__QualifiedJavaClassName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedJavaClassNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedJavaClassName"


    // $ANTLR start "entryRuleQualifiedNameWithWildcard"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1376:1: entryRuleQualifiedNameWithWildcard : ruleQualifiedNameWithWildcard EOF ;
    public final void entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1377:1: ( ruleQualifiedNameWithWildcard EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1378:1: ruleQualifiedNameWithWildcard EOF
            {
             before(grammarAccess.getQualifiedNameWithWildcardRule()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard2882);
            ruleQualifiedNameWithWildcard();

            state._fsp--;

             after(grammarAccess.getQualifiedNameWithWildcardRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard2889); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildcard"


    // $ANTLR start "ruleQualifiedNameWithWildcard"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1385:1: ruleQualifiedNameWithWildcard : ( ( rule__QualifiedNameWithWildcard__Group__0 ) ) ;
    public final void ruleQualifiedNameWithWildcard() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1389:2: ( ( ( rule__QualifiedNameWithWildcard__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1390:1: ( ( rule__QualifiedNameWithWildcard__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1390:1: ( ( rule__QualifiedNameWithWildcard__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1391:1: ( rule__QualifiedNameWithWildcard__Group__0 )
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1392:1: ( rule__QualifiedNameWithWildcard__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1392:2: rule__QualifiedNameWithWildcard__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__0_in_ruleQualifiedNameWithWildcard2915);
            rule__QualifiedNameWithWildcard__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedNameWithWildcard"


    // $ANTLR start "rule__Statement__Alternatives"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1404:1: rule__Statement__Alternatives : ( ( rulePackageDefinition ) | ( ruleImport ) | ( ruleSuite ) );
    public final void rule__Statement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1408:1: ( ( rulePackageDefinition ) | ( ruleImport ) | ( ruleSuite ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt2=1;
                }
                break;
            case 20:
                {
                alt2=2;
                }
                break;
            case 39:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1409:1: ( rulePackageDefinition )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1409:1: ( rulePackageDefinition )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1410:1: rulePackageDefinition
                    {
                     before(grammarAccess.getStatementAccess().getPackageDefinitionParserRuleCall_0()); 
                    pushFollow(FOLLOW_rulePackageDefinition_in_rule__Statement__Alternatives2951);
                    rulePackageDefinition();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getPackageDefinitionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1415:6: ( ruleImport )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1415:6: ( ruleImport )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1416:1: ruleImport
                    {
                     before(grammarAccess.getStatementAccess().getImportParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleImport_in_rule__Statement__Alternatives2968);
                    ruleImport();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getImportParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1421:6: ( ruleSuite )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1421:6: ( ruleSuite )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1422:1: ruleSuite
                    {
                     before(grammarAccess.getStatementAccess().getSuiteParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleSuite_in_rule__Statement__Alternatives2985);
                    ruleSuite();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getSuiteParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Statement__Alternatives"


    // $ANTLR start "rule__PackageStatement__Alternatives"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1432:1: rule__PackageStatement__Alternatives : ( ( ruleImport ) | ( ruleForkDefinition ) | ( ruleTestDefinition ) | ( ruleCallDefinition ) | ( ruleSuiteDefinition ) | ( ruleVariableDefinition ) | ( ruleConstantDefinition ) );
    public final void rule__PackageStatement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1436:1: ( ( ruleImport ) | ( ruleForkDefinition ) | ( ruleTestDefinition ) | ( ruleCallDefinition ) | ( ruleSuiteDefinition ) | ( ruleVariableDefinition ) | ( ruleConstantDefinition ) )
            int alt3=7;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt3=1;
                }
                break;
            case 21:
                {
                alt3=2;
                }
                break;
            case 23:
                {
                alt3=3;
                }
                break;
            case 24:
                {
                alt3=4;
                }
                break;
            case 25:
                {
                alt3=5;
                }
                break;
            case 30:
                {
                alt3=6;
                }
                break;
            case 32:
                {
                alt3=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1437:1: ( ruleImport )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1437:1: ( ruleImport )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1438:1: ruleImport
                    {
                     before(grammarAccess.getPackageStatementAccess().getImportParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleImport_in_rule__PackageStatement__Alternatives3017);
                    ruleImport();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getImportParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1443:6: ( ruleForkDefinition )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1443:6: ( ruleForkDefinition )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1444:1: ruleForkDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getForkDefinitionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleForkDefinition_in_rule__PackageStatement__Alternatives3034);
                    ruleForkDefinition();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getForkDefinitionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1449:6: ( ruleTestDefinition )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1449:6: ( ruleTestDefinition )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1450:1: ruleTestDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getTestDefinitionParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleTestDefinition_in_rule__PackageStatement__Alternatives3051);
                    ruleTestDefinition();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getTestDefinitionParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1455:6: ( ruleCallDefinition )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1455:6: ( ruleCallDefinition )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1456:1: ruleCallDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getCallDefinitionParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleCallDefinition_in_rule__PackageStatement__Alternatives3068);
                    ruleCallDefinition();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getCallDefinitionParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1461:6: ( ruleSuiteDefinition )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1461:6: ( ruleSuiteDefinition )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1462:1: ruleSuiteDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getSuiteDefinitionParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleSuiteDefinition_in_rule__PackageStatement__Alternatives3085);
                    ruleSuiteDefinition();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getSuiteDefinitionParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1467:6: ( ruleVariableDefinition )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1467:6: ( ruleVariableDefinition )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1468:1: ruleVariableDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getVariableDefinitionParserRuleCall_5()); 
                    pushFollow(FOLLOW_ruleVariableDefinition_in_rule__PackageStatement__Alternatives3102);
                    ruleVariableDefinition();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getVariableDefinitionParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1473:6: ( ruleConstantDefinition )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1473:6: ( ruleConstantDefinition )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1474:1: ruleConstantDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getConstantDefinitionParserRuleCall_6()); 
                    pushFollow(FOLLOW_ruleConstantDefinition_in_rule__PackageStatement__Alternatives3119);
                    ruleConstantDefinition();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getConstantDefinitionParserRuleCall_6()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageStatement__Alternatives"


    // $ANTLR start "rule__SuiteStatement__Alternatives"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1484:1: rule__SuiteStatement__Alternatives : ( ( ruleSuiteStatementWithResult ) | ( ruleCall ) | ( ruleVariableDefinition ) | ( ruleConstantDefinition ) | ( ruleVisibleSingleLineComment ) | ( ruleVisibleMultiLineComment ) );
    public final void rule__SuiteStatement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1488:1: ( ( ruleSuiteStatementWithResult ) | ( ruleCall ) | ( ruleVariableDefinition ) | ( ruleConstantDefinition ) | ( ruleVisibleSingleLineComment ) | ( ruleVisibleMultiLineComment ) )
            int alt4=6;
            switch ( input.LA(1) ) {
            case 33:
            case 35:
            case 39:
                {
                alt4=1;
                }
                break;
            case 37:
                {
                alt4=2;
                }
                break;
            case 30:
                {
                alt4=3;
                }
                break;
            case 32:
                {
                alt4=4;
                }
                break;
            case RULE_SL_VISIBLE_COMMENT:
                {
                alt4=5;
                }
                break;
            case RULE_ML_VISIBLE_COMMENT:
                {
                alt4=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1489:1: ( ruleSuiteStatementWithResult )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1489:1: ( ruleSuiteStatementWithResult )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1490:1: ruleSuiteStatementWithResult
                    {
                     before(grammarAccess.getSuiteStatementAccess().getSuiteStatementWithResultParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSuiteStatementWithResult_in_rule__SuiteStatement__Alternatives3151);
                    ruleSuiteStatementWithResult();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementAccess().getSuiteStatementWithResultParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1495:6: ( ruleCall )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1495:6: ( ruleCall )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1496:1: ruleCall
                    {
                     before(grammarAccess.getSuiteStatementAccess().getCallParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleCall_in_rule__SuiteStatement__Alternatives3168);
                    ruleCall();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementAccess().getCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1501:6: ( ruleVariableDefinition )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1501:6: ( ruleVariableDefinition )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1502:1: ruleVariableDefinition
                    {
                     before(grammarAccess.getSuiteStatementAccess().getVariableDefinitionParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleVariableDefinition_in_rule__SuiteStatement__Alternatives3185);
                    ruleVariableDefinition();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementAccess().getVariableDefinitionParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1507:6: ( ruleConstantDefinition )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1507:6: ( ruleConstantDefinition )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1508:1: ruleConstantDefinition
                    {
                     before(grammarAccess.getSuiteStatementAccess().getConstantDefinitionParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleConstantDefinition_in_rule__SuiteStatement__Alternatives3202);
                    ruleConstantDefinition();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementAccess().getConstantDefinitionParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1513:6: ( ruleVisibleSingleLineComment )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1513:6: ( ruleVisibleSingleLineComment )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1514:1: ruleVisibleSingleLineComment
                    {
                     before(grammarAccess.getSuiteStatementAccess().getVisibleSingleLineCommentParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleVisibleSingleLineComment_in_rule__SuiteStatement__Alternatives3219);
                    ruleVisibleSingleLineComment();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementAccess().getVisibleSingleLineCommentParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1519:6: ( ruleVisibleMultiLineComment )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1519:6: ( ruleVisibleMultiLineComment )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1520:1: ruleVisibleMultiLineComment
                    {
                     before(grammarAccess.getSuiteStatementAccess().getVisibleMultiLineCommentParserRuleCall_5()); 
                    pushFollow(FOLLOW_ruleVisibleMultiLineComment_in_rule__SuiteStatement__Alternatives3236);
                    ruleVisibleMultiLineComment();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementAccess().getVisibleMultiLineCommentParserRuleCall_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteStatement__Alternatives"


    // $ANTLR start "rule__SuiteStatementWithResult__Alternatives"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1530:1: rule__SuiteStatementWithResult__Alternatives : ( ( ruleSuite ) | ( ruleTest ) | ( ruleTableTest ) );
    public final void rule__SuiteStatementWithResult__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1534:1: ( ( ruleSuite ) | ( ruleTest ) | ( ruleTableTest ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 39:
                {
                alt5=1;
                }
                break;
            case 33:
                {
                alt5=2;
                }
                break;
            case 35:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1535:1: ( ruleSuite )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1535:1: ( ruleSuite )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1536:1: ruleSuite
                    {
                     before(grammarAccess.getSuiteStatementWithResultAccess().getSuiteParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSuite_in_rule__SuiteStatementWithResult__Alternatives3268);
                    ruleSuite();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementWithResultAccess().getSuiteParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1541:6: ( ruleTest )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1541:6: ( ruleTest )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1542:1: ruleTest
                    {
                     before(grammarAccess.getSuiteStatementWithResultAccess().getTestParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleTest_in_rule__SuiteStatementWithResult__Alternatives3285);
                    ruleTest();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementWithResultAccess().getTestParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1547:6: ( ruleTableTest )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1547:6: ( ruleTableTest )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1548:1: ruleTableTest
                    {
                     before(grammarAccess.getSuiteStatementWithResultAccess().getTableTestParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleTableTest_in_rule__SuiteStatementWithResult__Alternatives3302);
                    ruleTableTest();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementWithResultAccess().getTableTestParserRuleCall_2()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteStatementWithResult__Alternatives"


    // $ANTLR start "rule__ResultName__Alternatives"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1558:1: rule__ResultName__Alternatives : ( ( ruleFixedResultName ) | ( ruleArbitraryParameterOrResultName ) );
    public final void rule__ResultName__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1562:1: ( ( ruleFixedResultName ) | ( ruleArbitraryParameterOrResultName ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==42) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1563:1: ( ruleFixedResultName )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1563:1: ( ruleFixedResultName )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1564:1: ruleFixedResultName
                    {
                     before(grammarAccess.getResultNameAccess().getFixedResultNameParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleFixedResultName_in_rule__ResultName__Alternatives3334);
                    ruleFixedResultName();

                    state._fsp--;

                     after(grammarAccess.getResultNameAccess().getFixedResultNameParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1569:6: ( ruleArbitraryParameterOrResultName )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1569:6: ( ruleArbitraryParameterOrResultName )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1570:1: ruleArbitraryParameterOrResultName
                    {
                     before(grammarAccess.getResultNameAccess().getArbitraryParameterOrResultNameParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleArbitraryParameterOrResultName_in_rule__ResultName__Alternatives3351);
                    ruleArbitraryParameterOrResultName();

                    state._fsp--;

                     after(grammarAccess.getResultNameAccess().getArbitraryParameterOrResultNameParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultName__Alternatives"


    // $ANTLR start "rule__ParameterName__Alternatives"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1580:1: rule__ParameterName__Alternatives : ( ( ruleFixedParameterName ) | ( ruleArbitraryParameterOrResultName ) );
    public final void rule__ParameterName__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1584:1: ( ( ruleFixedParameterName ) | ( ruleArbitraryParameterOrResultName ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            else if ( (LA7_0==42) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1585:1: ( ruleFixedParameterName )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1585:1: ( ruleFixedParameterName )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1586:1: ruleFixedParameterName
                    {
                     before(grammarAccess.getParameterNameAccess().getFixedParameterNameParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleFixedParameterName_in_rule__ParameterName__Alternatives3383);
                    ruleFixedParameterName();

                    state._fsp--;

                     after(grammarAccess.getParameterNameAccess().getFixedParameterNameParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1591:6: ( ruleArbitraryParameterOrResultName )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1591:6: ( ruleArbitraryParameterOrResultName )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1592:1: ruleArbitraryParameterOrResultName
                    {
                     before(grammarAccess.getParameterNameAccess().getArbitraryParameterOrResultNameParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleArbitraryParameterOrResultName_in_rule__ParameterName__Alternatives3400);
                    ruleArbitraryParameterOrResultName();

                    state._fsp--;

                     after(grammarAccess.getParameterNameAccess().getArbitraryParameterOrResultNameParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterName__Alternatives"


    // $ANTLR start "rule__ValueOrEnumValue__Alternatives"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1602:1: rule__ValueOrEnumValue__Alternatives : ( ( ruleValue ) | ( ruleEnumValue ) );
    public final void rule__ValueOrEnumValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1606:1: ( ( ruleValue ) | ( ruleEnumValue ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( ((LA8_0>=RULE_BOOLEAN_TRUE && LA8_0<=RULE_ID)||(LA8_0>=RULE_STRING && LA8_0<=RULE_DECIMAL)||LA8_0==44) ) {
                alt8=1;
            }
            else if ( (LA8_0==RULE_UPPERCASE_ID) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1607:1: ( ruleValue )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1607:1: ( ruleValue )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1608:1: ruleValue
                    {
                     before(grammarAccess.getValueOrEnumValueAccess().getValueParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleValue_in_rule__ValueOrEnumValue__Alternatives3432);
                    ruleValue();

                    state._fsp--;

                     after(grammarAccess.getValueOrEnumValueAccess().getValueParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1613:6: ( ruleEnumValue )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1613:6: ( ruleEnumValue )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1614:1: ruleEnumValue
                    {
                     before(grammarAccess.getValueOrEnumValueAccess().getEnumValueParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleEnumValue_in_rule__ValueOrEnumValue__Alternatives3449);
                    ruleEnumValue();

                    state._fsp--;

                     after(grammarAccess.getValueOrEnumValueAccess().getEnumValueParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueOrEnumValue__Alternatives"


    // $ANTLR start "rule__Value__Alternatives"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1624:1: rule__Value__Alternatives : ( ( ruleStringValue ) | ( ruleIntegerValue ) | ( ruleDecimalValue ) | ( ruleBooleanValue ) | ( ruleVariable ) | ( ruleNullValue ) );
    public final void rule__Value__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1628:1: ( ( ruleStringValue ) | ( ruleIntegerValue ) | ( ruleDecimalValue ) | ( ruleBooleanValue ) | ( ruleVariable ) | ( ruleNullValue ) )
            int alt9=6;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt9=1;
                }
                break;
            case RULE_INTEGER:
                {
                alt9=2;
                }
                break;
            case RULE_DECIMAL:
                {
                alt9=3;
                }
                break;
            case RULE_BOOLEAN_TRUE:
            case RULE_BOOLEAN_FALSE:
                {
                alt9=4;
                }
                break;
            case RULE_ID:
                {
                alt9=5;
                }
                break;
            case 44:
                {
                alt9=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }

            switch (alt9) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1629:1: ( ruleStringValue )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1629:1: ( ruleStringValue )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1630:1: ruleStringValue
                    {
                     before(grammarAccess.getValueAccess().getStringValueParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleStringValue_in_rule__Value__Alternatives3481);
                    ruleStringValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getStringValueParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1635:6: ( ruleIntegerValue )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1635:6: ( ruleIntegerValue )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1636:1: ruleIntegerValue
                    {
                     before(grammarAccess.getValueAccess().getIntegerValueParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleIntegerValue_in_rule__Value__Alternatives3498);
                    ruleIntegerValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getIntegerValueParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1641:6: ( ruleDecimalValue )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1641:6: ( ruleDecimalValue )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1642:1: ruleDecimalValue
                    {
                     before(grammarAccess.getValueAccess().getDecimalValueParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleDecimalValue_in_rule__Value__Alternatives3515);
                    ruleDecimalValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getDecimalValueParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1647:6: ( ruleBooleanValue )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1647:6: ( ruleBooleanValue )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1648:1: ruleBooleanValue
                    {
                     before(grammarAccess.getValueAccess().getBooleanValueParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleBooleanValue_in_rule__Value__Alternatives3532);
                    ruleBooleanValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getBooleanValueParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1653:6: ( ruleVariable )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1653:6: ( ruleVariable )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1654:1: ruleVariable
                    {
                     before(grammarAccess.getValueAccess().getVariableParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleVariable_in_rule__Value__Alternatives3549);
                    ruleVariable();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getVariableParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1659:6: ( ruleNullValue )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1659:6: ( ruleNullValue )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1660:1: ruleNullValue
                    {
                     before(grammarAccess.getValueAccess().getNullValueParserRuleCall_5()); 
                    pushFollow(FOLLOW_ruleNullValue_in_rule__Value__Alternatives3566);
                    ruleNullValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getNullValueParserRuleCall_5()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Value__Alternatives"


    // $ANTLR start "rule__BooleanValue__BooleanValueAlternatives_0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1670:1: rule__BooleanValue__BooleanValueAlternatives_0 : ( ( RULE_BOOLEAN_TRUE ) | ( RULE_BOOLEAN_FALSE ) );
    public final void rule__BooleanValue__BooleanValueAlternatives_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1674:1: ( ( RULE_BOOLEAN_TRUE ) | ( RULE_BOOLEAN_FALSE ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_BOOLEAN_TRUE) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_BOOLEAN_FALSE) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1675:1: ( RULE_BOOLEAN_TRUE )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1675:1: ( RULE_BOOLEAN_TRUE )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1676:1: RULE_BOOLEAN_TRUE
                    {
                     before(grammarAccess.getBooleanValueAccess().getBooleanValueBOOLEAN_TRUETerminalRuleCall_0_0()); 
                    match(input,RULE_BOOLEAN_TRUE,FOLLOW_RULE_BOOLEAN_TRUE_in_rule__BooleanValue__BooleanValueAlternatives_03598); 
                     after(grammarAccess.getBooleanValueAccess().getBooleanValueBOOLEAN_TRUETerminalRuleCall_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1681:6: ( RULE_BOOLEAN_FALSE )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1681:6: ( RULE_BOOLEAN_FALSE )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1682:1: RULE_BOOLEAN_FALSE
                    {
                     before(grammarAccess.getBooleanValueAccess().getBooleanValueBOOLEAN_FALSETerminalRuleCall_0_1()); 
                    match(input,RULE_BOOLEAN_FALSE,FOLLOW_RULE_BOOLEAN_FALSE_in_rule__BooleanValue__BooleanValueAlternatives_03615); 
                     after(grammarAccess.getBooleanValueAccess().getBooleanValueBOOLEAN_FALSETerminalRuleCall_0_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanValue__BooleanValueAlternatives_0"


    // $ANTLR start "rule__PackageDefinition__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1694:1: rule__PackageDefinition__Group__0 : rule__PackageDefinition__Group__0__Impl rule__PackageDefinition__Group__1 ;
    public final void rule__PackageDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1698:1: ( rule__PackageDefinition__Group__0__Impl rule__PackageDefinition__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1699:2: rule__PackageDefinition__Group__0__Impl rule__PackageDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__0__Impl_in_rule__PackageDefinition__Group__03645);
            rule__PackageDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDefinition__Group__1_in_rule__PackageDefinition__Group__03648);
            rule__PackageDefinition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__Group__0"


    // $ANTLR start "rule__PackageDefinition__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1706:1: rule__PackageDefinition__Group__0__Impl : ( 'packagedef' ) ;
    public final void rule__PackageDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1710:1: ( ( 'packagedef' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1711:1: ( 'packagedef' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1711:1: ( 'packagedef' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1712:1: 'packagedef'
            {
             before(grammarAccess.getPackageDefinitionAccess().getPackagedefKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__PackageDefinition__Group__0__Impl3676); 
             after(grammarAccess.getPackageDefinitionAccess().getPackagedefKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__Group__0__Impl"


    // $ANTLR start "rule__PackageDefinition__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1725:1: rule__PackageDefinition__Group__1 : rule__PackageDefinition__Group__1__Impl rule__PackageDefinition__Group__2 ;
    public final void rule__PackageDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1729:1: ( rule__PackageDefinition__Group__1__Impl rule__PackageDefinition__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1730:2: rule__PackageDefinition__Group__1__Impl rule__PackageDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__1__Impl_in_rule__PackageDefinition__Group__13707);
            rule__PackageDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDefinition__Group__2_in_rule__PackageDefinition__Group__13710);
            rule__PackageDefinition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__Group__1"


    // $ANTLR start "rule__PackageDefinition__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1737:1: rule__PackageDefinition__Group__1__Impl : ( ( rule__PackageDefinition__NameAssignment_1 ) ) ;
    public final void rule__PackageDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1741:1: ( ( ( rule__PackageDefinition__NameAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1742:1: ( ( rule__PackageDefinition__NameAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1742:1: ( ( rule__PackageDefinition__NameAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1743:1: ( rule__PackageDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getPackageDefinitionAccess().getNameAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1744:1: ( rule__PackageDefinition__NameAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1744:2: rule__PackageDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__PackageDefinition__NameAssignment_1_in_rule__PackageDefinition__Group__1__Impl3737);
            rule__PackageDefinition__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getPackageDefinitionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__Group__1__Impl"


    // $ANTLR start "rule__PackageDefinition__Group__2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1754:1: rule__PackageDefinition__Group__2 : rule__PackageDefinition__Group__2__Impl rule__PackageDefinition__Group__3 ;
    public final void rule__PackageDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1758:1: ( rule__PackageDefinition__Group__2__Impl rule__PackageDefinition__Group__3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1759:2: rule__PackageDefinition__Group__2__Impl rule__PackageDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__2__Impl_in_rule__PackageDefinition__Group__23767);
            rule__PackageDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDefinition__Group__3_in_rule__PackageDefinition__Group__23770);
            rule__PackageDefinition__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__Group__2"


    // $ANTLR start "rule__PackageDefinition__Group__2__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1766:1: rule__PackageDefinition__Group__2__Impl : ( 'with' ) ;
    public final void rule__PackageDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1770:1: ( ( 'with' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1771:1: ( 'with' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1771:1: ( 'with' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1772:1: 'with'
            {
             before(grammarAccess.getPackageDefinitionAccess().getWithKeyword_2()); 
            match(input,18,FOLLOW_18_in_rule__PackageDefinition__Group__2__Impl3798); 
             after(grammarAccess.getPackageDefinitionAccess().getWithKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__Group__2__Impl"


    // $ANTLR start "rule__PackageDefinition__Group__3"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1785:1: rule__PackageDefinition__Group__3 : rule__PackageDefinition__Group__3__Impl rule__PackageDefinition__Group__4 ;
    public final void rule__PackageDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1789:1: ( rule__PackageDefinition__Group__3__Impl rule__PackageDefinition__Group__4 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1790:2: rule__PackageDefinition__Group__3__Impl rule__PackageDefinition__Group__4
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__3__Impl_in_rule__PackageDefinition__Group__33829);
            rule__PackageDefinition__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDefinition__Group__4_in_rule__PackageDefinition__Group__33832);
            rule__PackageDefinition__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__Group__3"


    // $ANTLR start "rule__PackageDefinition__Group__3__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1797:1: rule__PackageDefinition__Group__3__Impl : ( ( rule__PackageDefinition__StatementsAssignment_3 )* ) ;
    public final void rule__PackageDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1801:1: ( ( ( rule__PackageDefinition__StatementsAssignment_3 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1802:1: ( ( rule__PackageDefinition__StatementsAssignment_3 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1802:1: ( ( rule__PackageDefinition__StatementsAssignment_3 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1803:1: ( rule__PackageDefinition__StatementsAssignment_3 )*
            {
             before(grammarAccess.getPackageDefinitionAccess().getStatementsAssignment_3()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1804:1: ( rule__PackageDefinition__StatementsAssignment_3 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=20 && LA11_0<=21)||(LA11_0>=23 && LA11_0<=25)||LA11_0==30||LA11_0==32) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1804:2: rule__PackageDefinition__StatementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__PackageDefinition__StatementsAssignment_3_in_rule__PackageDefinition__Group__3__Impl3859);
            	    rule__PackageDefinition__StatementsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getPackageDefinitionAccess().getStatementsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__Group__3__Impl"


    // $ANTLR start "rule__PackageDefinition__Group__4"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1814:1: rule__PackageDefinition__Group__4 : rule__PackageDefinition__Group__4__Impl ;
    public final void rule__PackageDefinition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1818:1: ( rule__PackageDefinition__Group__4__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1819:2: rule__PackageDefinition__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__4__Impl_in_rule__PackageDefinition__Group__43890);
            rule__PackageDefinition__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__Group__4"


    // $ANTLR start "rule__PackageDefinition__Group__4__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1825:1: rule__PackageDefinition__Group__4__Impl : ( 'packageend' ) ;
    public final void rule__PackageDefinition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1829:1: ( ( 'packageend' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1830:1: ( 'packageend' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1830:1: ( 'packageend' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1831:1: 'packageend'
            {
             before(grammarAccess.getPackageDefinitionAccess().getPackageendKeyword_4()); 
            match(input,19,FOLLOW_19_in_rule__PackageDefinition__Group__4__Impl3918); 
             after(grammarAccess.getPackageDefinitionAccess().getPackageendKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__Group__4__Impl"


    // $ANTLR start "rule__Import__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1854:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1858:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1859:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__03959);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__03962);
            rule__Import__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0"


    // $ANTLR start "rule__Import__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1866:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1870:1: ( ( 'import' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1871:1: ( 'import' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1871:1: ( 'import' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1872:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,20,FOLLOW_20_in_rule__Import__Group__0__Impl3990); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__0__Impl"


    // $ANTLR start "rule__Import__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1885:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1889:1: ( rule__Import__Group__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1890:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__14021);
            rule__Import__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1"


    // $ANTLR start "rule__Import__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1896:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1900:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1901:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1901:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1902:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1903:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1903:2: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl4048);
            rule__Import__ImportedNamespaceAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__Group__1__Impl"


    // $ANTLR start "rule__ForkDefinition__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1917:1: rule__ForkDefinition__Group__0 : rule__ForkDefinition__Group__0__Impl rule__ForkDefinition__Group__1 ;
    public final void rule__ForkDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1921:1: ( rule__ForkDefinition__Group__0__Impl rule__ForkDefinition__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1922:2: rule__ForkDefinition__Group__0__Impl rule__ForkDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__ForkDefinition__Group__0__Impl_in_rule__ForkDefinition__Group__04082);
            rule__ForkDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ForkDefinition__Group__1_in_rule__ForkDefinition__Group__04085);
            rule__ForkDefinition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForkDefinition__Group__0"


    // $ANTLR start "rule__ForkDefinition__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1929:1: rule__ForkDefinition__Group__0__Impl : ( 'forkdef' ) ;
    public final void rule__ForkDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1933:1: ( ( 'forkdef' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1934:1: ( 'forkdef' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1934:1: ( 'forkdef' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1935:1: 'forkdef'
            {
             before(grammarAccess.getForkDefinitionAccess().getForkdefKeyword_0()); 
            match(input,21,FOLLOW_21_in_rule__ForkDefinition__Group__0__Impl4113); 
             after(grammarAccess.getForkDefinitionAccess().getForkdefKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForkDefinition__Group__0__Impl"


    // $ANTLR start "rule__ForkDefinition__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1948:1: rule__ForkDefinition__Group__1 : rule__ForkDefinition__Group__1__Impl rule__ForkDefinition__Group__2 ;
    public final void rule__ForkDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1952:1: ( rule__ForkDefinition__Group__1__Impl rule__ForkDefinition__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1953:2: rule__ForkDefinition__Group__1__Impl rule__ForkDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__ForkDefinition__Group__1__Impl_in_rule__ForkDefinition__Group__14144);
            rule__ForkDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ForkDefinition__Group__2_in_rule__ForkDefinition__Group__14147);
            rule__ForkDefinition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForkDefinition__Group__1"


    // $ANTLR start "rule__ForkDefinition__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1960:1: rule__ForkDefinition__Group__1__Impl : ( ( rule__ForkDefinition__NameAssignment_1 ) ) ;
    public final void rule__ForkDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1964:1: ( ( ( rule__ForkDefinition__NameAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1965:1: ( ( rule__ForkDefinition__NameAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1965:1: ( ( rule__ForkDefinition__NameAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1966:1: ( rule__ForkDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getForkDefinitionAccess().getNameAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1967:1: ( rule__ForkDefinition__NameAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1967:2: rule__ForkDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ForkDefinition__NameAssignment_1_in_rule__ForkDefinition__Group__1__Impl4174);
            rule__ForkDefinition__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getForkDefinitionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForkDefinition__Group__1__Impl"


    // $ANTLR start "rule__ForkDefinition__Group__2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1977:1: rule__ForkDefinition__Group__2 : rule__ForkDefinition__Group__2__Impl rule__ForkDefinition__Group__3 ;
    public final void rule__ForkDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1981:1: ( rule__ForkDefinition__Group__2__Impl rule__ForkDefinition__Group__3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1982:2: rule__ForkDefinition__Group__2__Impl rule__ForkDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__ForkDefinition__Group__2__Impl_in_rule__ForkDefinition__Group__24204);
            rule__ForkDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ForkDefinition__Group__3_in_rule__ForkDefinition__Group__24207);
            rule__ForkDefinition__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForkDefinition__Group__2"


    // $ANTLR start "rule__ForkDefinition__Group__2__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1989:1: rule__ForkDefinition__Group__2__Impl : ( ( rule__ForkDefinition__DescriptionAssignment_2 )? ) ;
    public final void rule__ForkDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1993:1: ( ( ( rule__ForkDefinition__DescriptionAssignment_2 )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1994:1: ( ( rule__ForkDefinition__DescriptionAssignment_2 )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1994:1: ( ( rule__ForkDefinition__DescriptionAssignment_2 )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1995:1: ( rule__ForkDefinition__DescriptionAssignment_2 )?
            {
             before(grammarAccess.getForkDefinitionAccess().getDescriptionAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1996:1: ( rule__ForkDefinition__DescriptionAssignment_2 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_STRING) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1996:2: rule__ForkDefinition__DescriptionAssignment_2
                    {
                    pushFollow(FOLLOW_rule__ForkDefinition__DescriptionAssignment_2_in_rule__ForkDefinition__Group__2__Impl4234);
                    rule__ForkDefinition__DescriptionAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getForkDefinitionAccess().getDescriptionAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForkDefinition__Group__2__Impl"


    // $ANTLR start "rule__ForkDefinition__Group__3"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2006:1: rule__ForkDefinition__Group__3 : rule__ForkDefinition__Group__3__Impl ;
    public final void rule__ForkDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2010:1: ( rule__ForkDefinition__Group__3__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2011:2: rule__ForkDefinition__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__ForkDefinition__Group__3__Impl_in_rule__ForkDefinition__Group__34265);
            rule__ForkDefinition__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForkDefinition__Group__3"


    // $ANTLR start "rule__ForkDefinition__Group__3__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2017:1: rule__ForkDefinition__Group__3__Impl : ( ( rule__ForkDefinition__Group_3__0 )? ) ;
    public final void rule__ForkDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2021:1: ( ( ( rule__ForkDefinition__Group_3__0 )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2022:1: ( ( rule__ForkDefinition__Group_3__0 )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2022:1: ( ( rule__ForkDefinition__Group_3__0 )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2023:1: ( rule__ForkDefinition__Group_3__0 )?
            {
             before(grammarAccess.getForkDefinitionAccess().getGroup_3()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2024:1: ( rule__ForkDefinition__Group_3__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==22) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2024:2: rule__ForkDefinition__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__ForkDefinition__Group_3__0_in_rule__ForkDefinition__Group__3__Impl4292);
                    rule__ForkDefinition__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getForkDefinitionAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForkDefinition__Group__3__Impl"


    // $ANTLR start "rule__ForkDefinition__Group_3__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2042:1: rule__ForkDefinition__Group_3__0 : rule__ForkDefinition__Group_3__0__Impl rule__ForkDefinition__Group_3__1 ;
    public final void rule__ForkDefinition__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2046:1: ( rule__ForkDefinition__Group_3__0__Impl rule__ForkDefinition__Group_3__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2047:2: rule__ForkDefinition__Group_3__0__Impl rule__ForkDefinition__Group_3__1
            {
            pushFollow(FOLLOW_rule__ForkDefinition__Group_3__0__Impl_in_rule__ForkDefinition__Group_3__04331);
            rule__ForkDefinition__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ForkDefinition__Group_3__1_in_rule__ForkDefinition__Group_3__04334);
            rule__ForkDefinition__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForkDefinition__Group_3__0"


    // $ANTLR start "rule__ForkDefinition__Group_3__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2054:1: rule__ForkDefinition__Group_3__0__Impl : ( 'uses' ) ;
    public final void rule__ForkDefinition__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2058:1: ( ( 'uses' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2059:1: ( 'uses' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2059:1: ( 'uses' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2060:1: 'uses'
            {
             before(grammarAccess.getForkDefinitionAccess().getUsesKeyword_3_0()); 
            match(input,22,FOLLOW_22_in_rule__ForkDefinition__Group_3__0__Impl4362); 
             after(grammarAccess.getForkDefinitionAccess().getUsesKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForkDefinition__Group_3__0__Impl"


    // $ANTLR start "rule__ForkDefinition__Group_3__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2073:1: rule__ForkDefinition__Group_3__1 : rule__ForkDefinition__Group_3__1__Impl ;
    public final void rule__ForkDefinition__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2077:1: ( rule__ForkDefinition__Group_3__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2078:2: rule__ForkDefinition__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__ForkDefinition__Group_3__1__Impl_in_rule__ForkDefinition__Group_3__14393);
            rule__ForkDefinition__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForkDefinition__Group_3__1"


    // $ANTLR start "rule__ForkDefinition__Group_3__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2084:1: rule__ForkDefinition__Group_3__1__Impl : ( ( rule__ForkDefinition__ForkerClassAssignment_3_1 ) ) ;
    public final void rule__ForkDefinition__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2088:1: ( ( ( rule__ForkDefinition__ForkerClassAssignment_3_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2089:1: ( ( rule__ForkDefinition__ForkerClassAssignment_3_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2089:1: ( ( rule__ForkDefinition__ForkerClassAssignment_3_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2090:1: ( rule__ForkDefinition__ForkerClassAssignment_3_1 )
            {
             before(grammarAccess.getForkDefinitionAccess().getForkerClassAssignment_3_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2091:1: ( rule__ForkDefinition__ForkerClassAssignment_3_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2091:2: rule__ForkDefinition__ForkerClassAssignment_3_1
            {
            pushFollow(FOLLOW_rule__ForkDefinition__ForkerClassAssignment_3_1_in_rule__ForkDefinition__Group_3__1__Impl4420);
            rule__ForkDefinition__ForkerClassAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getForkDefinitionAccess().getForkerClassAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForkDefinition__Group_3__1__Impl"


    // $ANTLR start "rule__TestDefinition__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2105:1: rule__TestDefinition__Group__0 : rule__TestDefinition__Group__0__Impl rule__TestDefinition__Group__1 ;
    public final void rule__TestDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2109:1: ( rule__TestDefinition__Group__0__Impl rule__TestDefinition__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2110:2: rule__TestDefinition__Group__0__Impl rule__TestDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__TestDefinition__Group__0__Impl_in_rule__TestDefinition__Group__04454);
            rule__TestDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TestDefinition__Group__1_in_rule__TestDefinition__Group__04457);
            rule__TestDefinition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestDefinition__Group__0"


    // $ANTLR start "rule__TestDefinition__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2117:1: rule__TestDefinition__Group__0__Impl : ( 'testdef' ) ;
    public final void rule__TestDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2121:1: ( ( 'testdef' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2122:1: ( 'testdef' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2122:1: ( 'testdef' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2123:1: 'testdef'
            {
             before(grammarAccess.getTestDefinitionAccess().getTestdefKeyword_0()); 
            match(input,23,FOLLOW_23_in_rule__TestDefinition__Group__0__Impl4485); 
             after(grammarAccess.getTestDefinitionAccess().getTestdefKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestDefinition__Group__0__Impl"


    // $ANTLR start "rule__TestDefinition__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2136:1: rule__TestDefinition__Group__1 : rule__TestDefinition__Group__1__Impl rule__TestDefinition__Group__2 ;
    public final void rule__TestDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2140:1: ( rule__TestDefinition__Group__1__Impl rule__TestDefinition__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2141:2: rule__TestDefinition__Group__1__Impl rule__TestDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__TestDefinition__Group__1__Impl_in_rule__TestDefinition__Group__14516);
            rule__TestDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TestDefinition__Group__2_in_rule__TestDefinition__Group__14519);
            rule__TestDefinition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestDefinition__Group__1"


    // $ANTLR start "rule__TestDefinition__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2148:1: rule__TestDefinition__Group__1__Impl : ( ( rule__TestDefinition__NameAssignment_1 ) ) ;
    public final void rule__TestDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2152:1: ( ( ( rule__TestDefinition__NameAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2153:1: ( ( rule__TestDefinition__NameAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2153:1: ( ( rule__TestDefinition__NameAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2154:1: ( rule__TestDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getTestDefinitionAccess().getNameAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2155:1: ( rule__TestDefinition__NameAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2155:2: rule__TestDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__TestDefinition__NameAssignment_1_in_rule__TestDefinition__Group__1__Impl4546);
            rule__TestDefinition__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTestDefinitionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestDefinition__Group__1__Impl"


    // $ANTLR start "rule__TestDefinition__Group__2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2165:1: rule__TestDefinition__Group__2 : rule__TestDefinition__Group__2__Impl rule__TestDefinition__Group__3 ;
    public final void rule__TestDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2169:1: ( rule__TestDefinition__Group__2__Impl rule__TestDefinition__Group__3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2170:2: rule__TestDefinition__Group__2__Impl rule__TestDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__TestDefinition__Group__2__Impl_in_rule__TestDefinition__Group__24576);
            rule__TestDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TestDefinition__Group__3_in_rule__TestDefinition__Group__24579);
            rule__TestDefinition__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestDefinition__Group__2"


    // $ANTLR start "rule__TestDefinition__Group__2__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2177:1: rule__TestDefinition__Group__2__Impl : ( 'uses' ) ;
    public final void rule__TestDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2181:1: ( ( 'uses' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2182:1: ( 'uses' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2182:1: ( 'uses' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2183:1: 'uses'
            {
             before(grammarAccess.getTestDefinitionAccess().getUsesKeyword_2()); 
            match(input,22,FOLLOW_22_in_rule__TestDefinition__Group__2__Impl4607); 
             after(grammarAccess.getTestDefinitionAccess().getUsesKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestDefinition__Group__2__Impl"


    // $ANTLR start "rule__TestDefinition__Group__3"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2196:1: rule__TestDefinition__Group__3 : rule__TestDefinition__Group__3__Impl ;
    public final void rule__TestDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2200:1: ( rule__TestDefinition__Group__3__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2201:2: rule__TestDefinition__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__TestDefinition__Group__3__Impl_in_rule__TestDefinition__Group__34638);
            rule__TestDefinition__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestDefinition__Group__3"


    // $ANTLR start "rule__TestDefinition__Group__3__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2207:1: rule__TestDefinition__Group__3__Impl : ( ( rule__TestDefinition__FixtureMethodAssignment_3 ) ) ;
    public final void rule__TestDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2211:1: ( ( ( rule__TestDefinition__FixtureMethodAssignment_3 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2212:1: ( ( rule__TestDefinition__FixtureMethodAssignment_3 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2212:1: ( ( rule__TestDefinition__FixtureMethodAssignment_3 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2213:1: ( rule__TestDefinition__FixtureMethodAssignment_3 )
            {
             before(grammarAccess.getTestDefinitionAccess().getFixtureMethodAssignment_3()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2214:1: ( rule__TestDefinition__FixtureMethodAssignment_3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2214:2: rule__TestDefinition__FixtureMethodAssignment_3
            {
            pushFollow(FOLLOW_rule__TestDefinition__FixtureMethodAssignment_3_in_rule__TestDefinition__Group__3__Impl4665);
            rule__TestDefinition__FixtureMethodAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTestDefinitionAccess().getFixtureMethodAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestDefinition__Group__3__Impl"


    // $ANTLR start "rule__CallDefinition__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2232:1: rule__CallDefinition__Group__0 : rule__CallDefinition__Group__0__Impl rule__CallDefinition__Group__1 ;
    public final void rule__CallDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2236:1: ( rule__CallDefinition__Group__0__Impl rule__CallDefinition__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2237:2: rule__CallDefinition__Group__0__Impl rule__CallDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__CallDefinition__Group__0__Impl_in_rule__CallDefinition__Group__04703);
            rule__CallDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CallDefinition__Group__1_in_rule__CallDefinition__Group__04706);
            rule__CallDefinition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallDefinition__Group__0"


    // $ANTLR start "rule__CallDefinition__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2244:1: rule__CallDefinition__Group__0__Impl : ( 'calldef' ) ;
    public final void rule__CallDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2248:1: ( ( 'calldef' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2249:1: ( 'calldef' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2249:1: ( 'calldef' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2250:1: 'calldef'
            {
             before(grammarAccess.getCallDefinitionAccess().getCalldefKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__CallDefinition__Group__0__Impl4734); 
             after(grammarAccess.getCallDefinitionAccess().getCalldefKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallDefinition__Group__0__Impl"


    // $ANTLR start "rule__CallDefinition__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2263:1: rule__CallDefinition__Group__1 : rule__CallDefinition__Group__1__Impl rule__CallDefinition__Group__2 ;
    public final void rule__CallDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2267:1: ( rule__CallDefinition__Group__1__Impl rule__CallDefinition__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2268:2: rule__CallDefinition__Group__1__Impl rule__CallDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__CallDefinition__Group__1__Impl_in_rule__CallDefinition__Group__14765);
            rule__CallDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CallDefinition__Group__2_in_rule__CallDefinition__Group__14768);
            rule__CallDefinition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallDefinition__Group__1"


    // $ANTLR start "rule__CallDefinition__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2275:1: rule__CallDefinition__Group__1__Impl : ( ( rule__CallDefinition__NameAssignment_1 ) ) ;
    public final void rule__CallDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2279:1: ( ( ( rule__CallDefinition__NameAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2280:1: ( ( rule__CallDefinition__NameAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2280:1: ( ( rule__CallDefinition__NameAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2281:1: ( rule__CallDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getCallDefinitionAccess().getNameAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2282:1: ( rule__CallDefinition__NameAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2282:2: rule__CallDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__CallDefinition__NameAssignment_1_in_rule__CallDefinition__Group__1__Impl4795);
            rule__CallDefinition__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getCallDefinitionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallDefinition__Group__1__Impl"


    // $ANTLR start "rule__CallDefinition__Group__2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2292:1: rule__CallDefinition__Group__2 : rule__CallDefinition__Group__2__Impl rule__CallDefinition__Group__3 ;
    public final void rule__CallDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2296:1: ( rule__CallDefinition__Group__2__Impl rule__CallDefinition__Group__3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2297:2: rule__CallDefinition__Group__2__Impl rule__CallDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__CallDefinition__Group__2__Impl_in_rule__CallDefinition__Group__24825);
            rule__CallDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CallDefinition__Group__3_in_rule__CallDefinition__Group__24828);
            rule__CallDefinition__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallDefinition__Group__2"


    // $ANTLR start "rule__CallDefinition__Group__2__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2304:1: rule__CallDefinition__Group__2__Impl : ( 'uses' ) ;
    public final void rule__CallDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2308:1: ( ( 'uses' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2309:1: ( 'uses' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2309:1: ( 'uses' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2310:1: 'uses'
            {
             before(grammarAccess.getCallDefinitionAccess().getUsesKeyword_2()); 
            match(input,22,FOLLOW_22_in_rule__CallDefinition__Group__2__Impl4856); 
             after(grammarAccess.getCallDefinitionAccess().getUsesKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallDefinition__Group__2__Impl"


    // $ANTLR start "rule__CallDefinition__Group__3"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2323:1: rule__CallDefinition__Group__3 : rule__CallDefinition__Group__3__Impl ;
    public final void rule__CallDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2327:1: ( rule__CallDefinition__Group__3__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2328:2: rule__CallDefinition__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__CallDefinition__Group__3__Impl_in_rule__CallDefinition__Group__34887);
            rule__CallDefinition__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallDefinition__Group__3"


    // $ANTLR start "rule__CallDefinition__Group__3__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2334:1: rule__CallDefinition__Group__3__Impl : ( ( rule__CallDefinition__FixtureMethodAssignment_3 ) ) ;
    public final void rule__CallDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2338:1: ( ( ( rule__CallDefinition__FixtureMethodAssignment_3 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2339:1: ( ( rule__CallDefinition__FixtureMethodAssignment_3 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2339:1: ( ( rule__CallDefinition__FixtureMethodAssignment_3 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2340:1: ( rule__CallDefinition__FixtureMethodAssignment_3 )
            {
             before(grammarAccess.getCallDefinitionAccess().getFixtureMethodAssignment_3()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2341:1: ( rule__CallDefinition__FixtureMethodAssignment_3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2341:2: rule__CallDefinition__FixtureMethodAssignment_3
            {
            pushFollow(FOLLOW_rule__CallDefinition__FixtureMethodAssignment_3_in_rule__CallDefinition__Group__3__Impl4914);
            rule__CallDefinition__FixtureMethodAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getCallDefinitionAccess().getFixtureMethodAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallDefinition__Group__3__Impl"


    // $ANTLR start "rule__SuiteDefinition__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2359:1: rule__SuiteDefinition__Group__0 : rule__SuiteDefinition__Group__0__Impl rule__SuiteDefinition__Group__1 ;
    public final void rule__SuiteDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2363:1: ( rule__SuiteDefinition__Group__0__Impl rule__SuiteDefinition__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2364:2: rule__SuiteDefinition__Group__0__Impl rule__SuiteDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__0__Impl_in_rule__SuiteDefinition__Group__04952);
            rule__SuiteDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__1_in_rule__SuiteDefinition__Group__04955);
            rule__SuiteDefinition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group__0"


    // $ANTLR start "rule__SuiteDefinition__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2371:1: rule__SuiteDefinition__Group__0__Impl : ( 'suitedef' ) ;
    public final void rule__SuiteDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2375:1: ( ( 'suitedef' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2376:1: ( 'suitedef' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2376:1: ( 'suitedef' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2377:1: 'suitedef'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getSuitedefKeyword_0()); 
            match(input,25,FOLLOW_25_in_rule__SuiteDefinition__Group__0__Impl4983); 
             after(grammarAccess.getSuiteDefinitionAccess().getSuitedefKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group__0__Impl"


    // $ANTLR start "rule__SuiteDefinition__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2390:1: rule__SuiteDefinition__Group__1 : rule__SuiteDefinition__Group__1__Impl rule__SuiteDefinition__Group__2 ;
    public final void rule__SuiteDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2394:1: ( rule__SuiteDefinition__Group__1__Impl rule__SuiteDefinition__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2395:2: rule__SuiteDefinition__Group__1__Impl rule__SuiteDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__1__Impl_in_rule__SuiteDefinition__Group__15014);
            rule__SuiteDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__2_in_rule__SuiteDefinition__Group__15017);
            rule__SuiteDefinition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group__1"


    // $ANTLR start "rule__SuiteDefinition__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2402:1: rule__SuiteDefinition__Group__1__Impl : ( ( rule__SuiteDefinition__NameAssignment_1 ) ) ;
    public final void rule__SuiteDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2406:1: ( ( ( rule__SuiteDefinition__NameAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2407:1: ( ( rule__SuiteDefinition__NameAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2407:1: ( ( rule__SuiteDefinition__NameAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2408:1: ( rule__SuiteDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getSuiteDefinitionAccess().getNameAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2409:1: ( rule__SuiteDefinition__NameAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2409:2: rule__SuiteDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__NameAssignment_1_in_rule__SuiteDefinition__Group__1__Impl5044);
            rule__SuiteDefinition__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSuiteDefinitionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group__1__Impl"


    // $ANTLR start "rule__SuiteDefinition__Group__2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2419:1: rule__SuiteDefinition__Group__2 : rule__SuiteDefinition__Group__2__Impl rule__SuiteDefinition__Group__3 ;
    public final void rule__SuiteDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2423:1: ( rule__SuiteDefinition__Group__2__Impl rule__SuiteDefinition__Group__3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2424:2: rule__SuiteDefinition__Group__2__Impl rule__SuiteDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__2__Impl_in_rule__SuiteDefinition__Group__25074);
            rule__SuiteDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__3_in_rule__SuiteDefinition__Group__25077);
            rule__SuiteDefinition__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group__2"


    // $ANTLR start "rule__SuiteDefinition__Group__2__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2431:1: rule__SuiteDefinition__Group__2__Impl : ( ( rule__SuiteDefinition__Group_2__0 )? ) ;
    public final void rule__SuiteDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2435:1: ( ( ( rule__SuiteDefinition__Group_2__0 )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2436:1: ( ( rule__SuiteDefinition__Group_2__0 )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2436:1: ( ( rule__SuiteDefinition__Group_2__0 )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2437:1: ( rule__SuiteDefinition__Group_2__0 )?
            {
             before(grammarAccess.getSuiteDefinitionAccess().getGroup_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2438:1: ( rule__SuiteDefinition__Group_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==27) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2438:2: rule__SuiteDefinition__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__SuiteDefinition__Group_2__0_in_rule__SuiteDefinition__Group__2__Impl5104);
                    rule__SuiteDefinition__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSuiteDefinitionAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group__2__Impl"


    // $ANTLR start "rule__SuiteDefinition__Group__3"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2448:1: rule__SuiteDefinition__Group__3 : rule__SuiteDefinition__Group__3__Impl rule__SuiteDefinition__Group__4 ;
    public final void rule__SuiteDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2452:1: ( rule__SuiteDefinition__Group__3__Impl rule__SuiteDefinition__Group__4 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2453:2: rule__SuiteDefinition__Group__3__Impl rule__SuiteDefinition__Group__4
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__3__Impl_in_rule__SuiteDefinition__Group__35135);
            rule__SuiteDefinition__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__4_in_rule__SuiteDefinition__Group__35138);
            rule__SuiteDefinition__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group__3"


    // $ANTLR start "rule__SuiteDefinition__Group__3__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2460:1: rule__SuiteDefinition__Group__3__Impl : ( ( rule__SuiteDefinition__Group_3__0 )? ) ;
    public final void rule__SuiteDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2464:1: ( ( ( rule__SuiteDefinition__Group_3__0 )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2465:1: ( ( rule__SuiteDefinition__Group_3__0 )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2465:1: ( ( rule__SuiteDefinition__Group_3__0 )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2466:1: ( rule__SuiteDefinition__Group_3__0 )?
            {
             before(grammarAccess.getSuiteDefinitionAccess().getGroup_3()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2467:1: ( rule__SuiteDefinition__Group_3__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==28) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2467:2: rule__SuiteDefinition__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__SuiteDefinition__Group_3__0_in_rule__SuiteDefinition__Group__3__Impl5165);
                    rule__SuiteDefinition__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSuiteDefinitionAccess().getGroup_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group__3__Impl"


    // $ANTLR start "rule__SuiteDefinition__Group__4"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2477:1: rule__SuiteDefinition__Group__4 : rule__SuiteDefinition__Group__4__Impl rule__SuiteDefinition__Group__5 ;
    public final void rule__SuiteDefinition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2481:1: ( rule__SuiteDefinition__Group__4__Impl rule__SuiteDefinition__Group__5 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2482:2: rule__SuiteDefinition__Group__4__Impl rule__SuiteDefinition__Group__5
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__4__Impl_in_rule__SuiteDefinition__Group__45196);
            rule__SuiteDefinition__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__5_in_rule__SuiteDefinition__Group__45199);
            rule__SuiteDefinition__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group__4"


    // $ANTLR start "rule__SuiteDefinition__Group__4__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2489:1: rule__SuiteDefinition__Group__4__Impl : ( 'with' ) ;
    public final void rule__SuiteDefinition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2493:1: ( ( 'with' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2494:1: ( 'with' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2494:1: ( 'with' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2495:1: 'with'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getWithKeyword_4()); 
            match(input,18,FOLLOW_18_in_rule__SuiteDefinition__Group__4__Impl5227); 
             after(grammarAccess.getSuiteDefinitionAccess().getWithKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group__4__Impl"


    // $ANTLR start "rule__SuiteDefinition__Group__5"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2508:1: rule__SuiteDefinition__Group__5 : rule__SuiteDefinition__Group__5__Impl rule__SuiteDefinition__Group__6 ;
    public final void rule__SuiteDefinition__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2512:1: ( rule__SuiteDefinition__Group__5__Impl rule__SuiteDefinition__Group__6 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2513:2: rule__SuiteDefinition__Group__5__Impl rule__SuiteDefinition__Group__6
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__5__Impl_in_rule__SuiteDefinition__Group__55258);
            rule__SuiteDefinition__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__6_in_rule__SuiteDefinition__Group__55261);
            rule__SuiteDefinition__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group__5"


    // $ANTLR start "rule__SuiteDefinition__Group__5__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2520:1: rule__SuiteDefinition__Group__5__Impl : ( ( rule__SuiteDefinition__StatementsAssignment_5 )* ) ;
    public final void rule__SuiteDefinition__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2524:1: ( ( ( rule__SuiteDefinition__StatementsAssignment_5 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2525:1: ( ( rule__SuiteDefinition__StatementsAssignment_5 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2525:1: ( ( rule__SuiteDefinition__StatementsAssignment_5 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2526:1: ( rule__SuiteDefinition__StatementsAssignment_5 )*
            {
             before(grammarAccess.getSuiteDefinitionAccess().getStatementsAssignment_5()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2527:1: ( rule__SuiteDefinition__StatementsAssignment_5 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=RULE_SL_VISIBLE_COMMENT && LA16_0<=RULE_ML_VISIBLE_COMMENT)||LA16_0==30||(LA16_0>=32 && LA16_0<=33)||LA16_0==35||LA16_0==37||LA16_0==39) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2527:2: rule__SuiteDefinition__StatementsAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__SuiteDefinition__StatementsAssignment_5_in_rule__SuiteDefinition__Group__5__Impl5288);
            	    rule__SuiteDefinition__StatementsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getSuiteDefinitionAccess().getStatementsAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group__5__Impl"


    // $ANTLR start "rule__SuiteDefinition__Group__6"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2537:1: rule__SuiteDefinition__Group__6 : rule__SuiteDefinition__Group__6__Impl rule__SuiteDefinition__Group__7 ;
    public final void rule__SuiteDefinition__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2541:1: ( rule__SuiteDefinition__Group__6__Impl rule__SuiteDefinition__Group__7 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2542:2: rule__SuiteDefinition__Group__6__Impl rule__SuiteDefinition__Group__7
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__6__Impl_in_rule__SuiteDefinition__Group__65319);
            rule__SuiteDefinition__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__7_in_rule__SuiteDefinition__Group__65322);
            rule__SuiteDefinition__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group__6"


    // $ANTLR start "rule__SuiteDefinition__Group__6__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2549:1: rule__SuiteDefinition__Group__6__Impl : ( 'suiteend' ) ;
    public final void rule__SuiteDefinition__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2553:1: ( ( 'suiteend' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2554:1: ( 'suiteend' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2554:1: ( 'suiteend' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2555:1: 'suiteend'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getSuiteendKeyword_6()); 
            match(input,26,FOLLOW_26_in_rule__SuiteDefinition__Group__6__Impl5350); 
             after(grammarAccess.getSuiteDefinitionAccess().getSuiteendKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group__6__Impl"


    // $ANTLR start "rule__SuiteDefinition__Group__7"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2568:1: rule__SuiteDefinition__Group__7 : rule__SuiteDefinition__Group__7__Impl ;
    public final void rule__SuiteDefinition__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2572:1: ( rule__SuiteDefinition__Group__7__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2573:2: rule__SuiteDefinition__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__7__Impl_in_rule__SuiteDefinition__Group__75381);
            rule__SuiteDefinition__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group__7"


    // $ANTLR start "rule__SuiteDefinition__Group__7__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2579:1: rule__SuiteDefinition__Group__7__Impl : ( ( rule__SuiteDefinition__Group_7__0 )? ) ;
    public final void rule__SuiteDefinition__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2583:1: ( ( ( rule__SuiteDefinition__Group_7__0 )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2584:1: ( ( rule__SuiteDefinition__Group_7__0 )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2584:1: ( ( rule__SuiteDefinition__Group_7__0 )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2585:1: ( rule__SuiteDefinition__Group_7__0 )?
            {
             before(grammarAccess.getSuiteDefinitionAccess().getGroup_7()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2586:1: ( rule__SuiteDefinition__Group_7__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==29) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2586:2: rule__SuiteDefinition__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__SuiteDefinition__Group_7__0_in_rule__SuiteDefinition__Group__7__Impl5408);
                    rule__SuiteDefinition__Group_7__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSuiteDefinitionAccess().getGroup_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group__7__Impl"


    // $ANTLR start "rule__SuiteDefinition__Group_2__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2612:1: rule__SuiteDefinition__Group_2__0 : rule__SuiteDefinition__Group_2__0__Impl rule__SuiteDefinition__Group_2__1 ;
    public final void rule__SuiteDefinition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2616:1: ( rule__SuiteDefinition__Group_2__0__Impl rule__SuiteDefinition__Group_2__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2617:2: rule__SuiteDefinition__Group_2__0__Impl rule__SuiteDefinition__Group_2__1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_2__0__Impl_in_rule__SuiteDefinition__Group_2__05455);
            rule__SuiteDefinition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group_2__1_in_rule__SuiteDefinition__Group_2__05458);
            rule__SuiteDefinition__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group_2__0"


    // $ANTLR start "rule__SuiteDefinition__Group_2__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2624:1: rule__SuiteDefinition__Group_2__0__Impl : ( 'gets' ) ;
    public final void rule__SuiteDefinition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2628:1: ( ( 'gets' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2629:1: ( 'gets' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2629:1: ( 'gets' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2630:1: 'gets'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getGetsKeyword_2_0()); 
            match(input,27,FOLLOW_27_in_rule__SuiteDefinition__Group_2__0__Impl5486); 
             after(grammarAccess.getSuiteDefinitionAccess().getGetsKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group_2__0__Impl"


    // $ANTLR start "rule__SuiteDefinition__Group_2__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2643:1: rule__SuiteDefinition__Group_2__1 : rule__SuiteDefinition__Group_2__1__Impl ;
    public final void rule__SuiteDefinition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2647:1: ( rule__SuiteDefinition__Group_2__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2648:2: rule__SuiteDefinition__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_2__1__Impl_in_rule__SuiteDefinition__Group_2__15517);
            rule__SuiteDefinition__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group_2__1"


    // $ANTLR start "rule__SuiteDefinition__Group_2__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2654:1: rule__SuiteDefinition__Group_2__1__Impl : ( ( rule__SuiteDefinition__ParametersAssignment_2_1 )* ) ;
    public final void rule__SuiteDefinition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2658:1: ( ( ( rule__SuiteDefinition__ParametersAssignment_2_1 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2659:1: ( ( rule__SuiteDefinition__ParametersAssignment_2_1 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2659:1: ( ( rule__SuiteDefinition__ParametersAssignment_2_1 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2660:1: ( rule__SuiteDefinition__ParametersAssignment_2_1 )*
            {
             before(grammarAccess.getSuiteDefinitionAccess().getParametersAssignment_2_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2661:1: ( rule__SuiteDefinition__ParametersAssignment_2_1 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2661:2: rule__SuiteDefinition__ParametersAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_rule__SuiteDefinition__ParametersAssignment_2_1_in_rule__SuiteDefinition__Group_2__1__Impl5544);
            	    rule__SuiteDefinition__ParametersAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getSuiteDefinitionAccess().getParametersAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group_2__1__Impl"


    // $ANTLR start "rule__SuiteDefinition__Group_3__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2675:1: rule__SuiteDefinition__Group_3__0 : rule__SuiteDefinition__Group_3__0__Impl rule__SuiteDefinition__Group_3__1 ;
    public final void rule__SuiteDefinition__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2679:1: ( rule__SuiteDefinition__Group_3__0__Impl rule__SuiteDefinition__Group_3__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2680:2: rule__SuiteDefinition__Group_3__0__Impl rule__SuiteDefinition__Group_3__1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_3__0__Impl_in_rule__SuiteDefinition__Group_3__05579);
            rule__SuiteDefinition__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group_3__1_in_rule__SuiteDefinition__Group_3__05582);
            rule__SuiteDefinition__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group_3__0"


    // $ANTLR start "rule__SuiteDefinition__Group_3__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2687:1: rule__SuiteDefinition__Group_3__0__Impl : ( 'requires' ) ;
    public final void rule__SuiteDefinition__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2691:1: ( ( 'requires' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2692:1: ( 'requires' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2692:1: ( 'requires' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2693:1: 'requires'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getRequiresKeyword_3_0()); 
            match(input,28,FOLLOW_28_in_rule__SuiteDefinition__Group_3__0__Impl5610); 
             after(grammarAccess.getSuiteDefinitionAccess().getRequiresKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group_3__0__Impl"


    // $ANTLR start "rule__SuiteDefinition__Group_3__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2706:1: rule__SuiteDefinition__Group_3__1 : rule__SuiteDefinition__Group_3__1__Impl ;
    public final void rule__SuiteDefinition__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2710:1: ( rule__SuiteDefinition__Group_3__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2711:2: rule__SuiteDefinition__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_3__1__Impl_in_rule__SuiteDefinition__Group_3__15641);
            rule__SuiteDefinition__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group_3__1"


    // $ANTLR start "rule__SuiteDefinition__Group_3__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2717:1: rule__SuiteDefinition__Group_3__1__Impl : ( ( rule__SuiteDefinition__DependenciesAssignment_3_1 )* ) ;
    public final void rule__SuiteDefinition__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2721:1: ( ( ( rule__SuiteDefinition__DependenciesAssignment_3_1 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2722:1: ( ( rule__SuiteDefinition__DependenciesAssignment_3_1 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2722:1: ( ( rule__SuiteDefinition__DependenciesAssignment_3_1 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2723:1: ( rule__SuiteDefinition__DependenciesAssignment_3_1 )*
            {
             before(grammarAccess.getSuiteDefinitionAccess().getDependenciesAssignment_3_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2724:1: ( rule__SuiteDefinition__DependenciesAssignment_3_1 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2724:2: rule__SuiteDefinition__DependenciesAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_rule__SuiteDefinition__DependenciesAssignment_3_1_in_rule__SuiteDefinition__Group_3__1__Impl5668);
            	    rule__SuiteDefinition__DependenciesAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getSuiteDefinitionAccess().getDependenciesAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group_3__1__Impl"


    // $ANTLR start "rule__SuiteDefinition__Group_7__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2738:1: rule__SuiteDefinition__Group_7__0 : rule__SuiteDefinition__Group_7__0__Impl rule__SuiteDefinition__Group_7__1 ;
    public final void rule__SuiteDefinition__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2742:1: ( rule__SuiteDefinition__Group_7__0__Impl rule__SuiteDefinition__Group_7__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2743:2: rule__SuiteDefinition__Group_7__0__Impl rule__SuiteDefinition__Group_7__1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_7__0__Impl_in_rule__SuiteDefinition__Group_7__05703);
            rule__SuiteDefinition__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group_7__1_in_rule__SuiteDefinition__Group_7__05706);
            rule__SuiteDefinition__Group_7__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group_7__0"


    // $ANTLR start "rule__SuiteDefinition__Group_7__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2750:1: rule__SuiteDefinition__Group_7__0__Impl : ( 'concludedby' ) ;
    public final void rule__SuiteDefinition__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2754:1: ( ( 'concludedby' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2755:1: ( 'concludedby' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2755:1: ( 'concludedby' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2756:1: 'concludedby'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getConcludedbyKeyword_7_0()); 
            match(input,29,FOLLOW_29_in_rule__SuiteDefinition__Group_7__0__Impl5734); 
             after(grammarAccess.getSuiteDefinitionAccess().getConcludedbyKeyword_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group_7__0__Impl"


    // $ANTLR start "rule__SuiteDefinition__Group_7__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2769:1: rule__SuiteDefinition__Group_7__1 : rule__SuiteDefinition__Group_7__1__Impl ;
    public final void rule__SuiteDefinition__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2773:1: ( rule__SuiteDefinition__Group_7__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2774:2: rule__SuiteDefinition__Group_7__1__Impl
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_7__1__Impl_in_rule__SuiteDefinition__Group_7__15765);
            rule__SuiteDefinition__Group_7__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group_7__1"


    // $ANTLR start "rule__SuiteDefinition__Group_7__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2780:1: rule__SuiteDefinition__Group_7__1__Impl : ( ( rule__SuiteDefinition__FinalizersAssignment_7_1 )* ) ;
    public final void rule__SuiteDefinition__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2784:1: ( ( ( rule__SuiteDefinition__FinalizersAssignment_7_1 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2785:1: ( ( rule__SuiteDefinition__FinalizersAssignment_7_1 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2785:1: ( ( rule__SuiteDefinition__FinalizersAssignment_7_1 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2786:1: ( rule__SuiteDefinition__FinalizersAssignment_7_1 )*
            {
             before(grammarAccess.getSuiteDefinitionAccess().getFinalizersAssignment_7_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2787:1: ( rule__SuiteDefinition__FinalizersAssignment_7_1 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2787:2: rule__SuiteDefinition__FinalizersAssignment_7_1
            	    {
            	    pushFollow(FOLLOW_rule__SuiteDefinition__FinalizersAssignment_7_1_in_rule__SuiteDefinition__Group_7__1__Impl5792);
            	    rule__SuiteDefinition__FinalizersAssignment_7_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getSuiteDefinitionAccess().getFinalizersAssignment_7_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__Group_7__1__Impl"


    // $ANTLR start "rule__VariableDefinition__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2801:1: rule__VariableDefinition__Group__0 : rule__VariableDefinition__Group__0__Impl rule__VariableDefinition__Group__1 ;
    public final void rule__VariableDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2805:1: ( rule__VariableDefinition__Group__0__Impl rule__VariableDefinition__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2806:2: rule__VariableDefinition__Group__0__Impl rule__VariableDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group__0__Impl_in_rule__VariableDefinition__Group__05827);
            rule__VariableDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDefinition__Group__1_in_rule__VariableDefinition__Group__05830);
            rule__VariableDefinition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDefinition__Group__0"


    // $ANTLR start "rule__VariableDefinition__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2813:1: rule__VariableDefinition__Group__0__Impl : ( 'variable' ) ;
    public final void rule__VariableDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2817:1: ( ( 'variable' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2818:1: ( 'variable' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2818:1: ( 'variable' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2819:1: 'variable'
            {
             before(grammarAccess.getVariableDefinitionAccess().getVariableKeyword_0()); 
            match(input,30,FOLLOW_30_in_rule__VariableDefinition__Group__0__Impl5858); 
             after(grammarAccess.getVariableDefinitionAccess().getVariableKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDefinition__Group__0__Impl"


    // $ANTLR start "rule__VariableDefinition__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2832:1: rule__VariableDefinition__Group__1 : rule__VariableDefinition__Group__1__Impl rule__VariableDefinition__Group__2 ;
    public final void rule__VariableDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2836:1: ( rule__VariableDefinition__Group__1__Impl rule__VariableDefinition__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2837:2: rule__VariableDefinition__Group__1__Impl rule__VariableDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group__1__Impl_in_rule__VariableDefinition__Group__15889);
            rule__VariableDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDefinition__Group__2_in_rule__VariableDefinition__Group__15892);
            rule__VariableDefinition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDefinition__Group__1"


    // $ANTLR start "rule__VariableDefinition__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2844:1: rule__VariableDefinition__Group__1__Impl : ( ( rule__VariableDefinition__NameAssignment_1 ) ) ;
    public final void rule__VariableDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2848:1: ( ( ( rule__VariableDefinition__NameAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2849:1: ( ( rule__VariableDefinition__NameAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2849:1: ( ( rule__VariableDefinition__NameAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2850:1: ( rule__VariableDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getVariableDefinitionAccess().getNameAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2851:1: ( rule__VariableDefinition__NameAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2851:2: rule__VariableDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__VariableDefinition__NameAssignment_1_in_rule__VariableDefinition__Group__1__Impl5919);
            rule__VariableDefinition__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getVariableDefinitionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDefinition__Group__1__Impl"


    // $ANTLR start "rule__VariableDefinition__Group__2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2861:1: rule__VariableDefinition__Group__2 : rule__VariableDefinition__Group__2__Impl ;
    public final void rule__VariableDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2865:1: ( rule__VariableDefinition__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2866:2: rule__VariableDefinition__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group__2__Impl_in_rule__VariableDefinition__Group__25949);
            rule__VariableDefinition__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDefinition__Group__2"


    // $ANTLR start "rule__VariableDefinition__Group__2__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2872:1: rule__VariableDefinition__Group__2__Impl : ( ( rule__VariableDefinition__Group_2__0 )? ) ;
    public final void rule__VariableDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2876:1: ( ( ( rule__VariableDefinition__Group_2__0 )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2877:1: ( ( rule__VariableDefinition__Group_2__0 )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2877:1: ( ( rule__VariableDefinition__Group_2__0 )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2878:1: ( rule__VariableDefinition__Group_2__0 )?
            {
             before(grammarAccess.getVariableDefinitionAccess().getGroup_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2879:1: ( rule__VariableDefinition__Group_2__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==31) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2879:2: rule__VariableDefinition__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__VariableDefinition__Group_2__0_in_rule__VariableDefinition__Group__2__Impl5976);
                    rule__VariableDefinition__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getVariableDefinitionAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDefinition__Group__2__Impl"


    // $ANTLR start "rule__VariableDefinition__Group_2__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2895:1: rule__VariableDefinition__Group_2__0 : rule__VariableDefinition__Group_2__0__Impl rule__VariableDefinition__Group_2__1 ;
    public final void rule__VariableDefinition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2899:1: ( rule__VariableDefinition__Group_2__0__Impl rule__VariableDefinition__Group_2__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2900:2: rule__VariableDefinition__Group_2__0__Impl rule__VariableDefinition__Group_2__1
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group_2__0__Impl_in_rule__VariableDefinition__Group_2__06013);
            rule__VariableDefinition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDefinition__Group_2__1_in_rule__VariableDefinition__Group_2__06016);
            rule__VariableDefinition__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDefinition__Group_2__0"


    // $ANTLR start "rule__VariableDefinition__Group_2__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2907:1: rule__VariableDefinition__Group_2__0__Impl : ( 'initially' ) ;
    public final void rule__VariableDefinition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2911:1: ( ( 'initially' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2912:1: ( 'initially' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2912:1: ( 'initially' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2913:1: 'initially'
            {
             before(grammarAccess.getVariableDefinitionAccess().getInitiallyKeyword_2_0()); 
            match(input,31,FOLLOW_31_in_rule__VariableDefinition__Group_2__0__Impl6044); 
             after(grammarAccess.getVariableDefinitionAccess().getInitiallyKeyword_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDefinition__Group_2__0__Impl"


    // $ANTLR start "rule__VariableDefinition__Group_2__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2926:1: rule__VariableDefinition__Group_2__1 : rule__VariableDefinition__Group_2__1__Impl ;
    public final void rule__VariableDefinition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2930:1: ( rule__VariableDefinition__Group_2__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2931:2: rule__VariableDefinition__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group_2__1__Impl_in_rule__VariableDefinition__Group_2__16075);
            rule__VariableDefinition__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDefinition__Group_2__1"


    // $ANTLR start "rule__VariableDefinition__Group_2__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2937:1: rule__VariableDefinition__Group_2__1__Impl : ( ( rule__VariableDefinition__InitialValueAssignment_2_1 ) ) ;
    public final void rule__VariableDefinition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2941:1: ( ( ( rule__VariableDefinition__InitialValueAssignment_2_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2942:1: ( ( rule__VariableDefinition__InitialValueAssignment_2_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2942:1: ( ( rule__VariableDefinition__InitialValueAssignment_2_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2943:1: ( rule__VariableDefinition__InitialValueAssignment_2_1 )
            {
             before(grammarAccess.getVariableDefinitionAccess().getInitialValueAssignment_2_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2944:1: ( rule__VariableDefinition__InitialValueAssignment_2_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2944:2: rule__VariableDefinition__InitialValueAssignment_2_1
            {
            pushFollow(FOLLOW_rule__VariableDefinition__InitialValueAssignment_2_1_in_rule__VariableDefinition__Group_2__1__Impl6102);
            rule__VariableDefinition__InitialValueAssignment_2_1();

            state._fsp--;


            }

             after(grammarAccess.getVariableDefinitionAccess().getInitialValueAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDefinition__Group_2__1__Impl"


    // $ANTLR start "rule__ConstantDefinition__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2958:1: rule__ConstantDefinition__Group__0 : rule__ConstantDefinition__Group__0__Impl rule__ConstantDefinition__Group__1 ;
    public final void rule__ConstantDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2962:1: ( rule__ConstantDefinition__Group__0__Impl rule__ConstantDefinition__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2963:2: rule__ConstantDefinition__Group__0__Impl rule__ConstantDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__ConstantDefinition__Group__0__Impl_in_rule__ConstantDefinition__Group__06136);
            rule__ConstantDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstantDefinition__Group__1_in_rule__ConstantDefinition__Group__06139);
            rule__ConstantDefinition__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstantDefinition__Group__0"


    // $ANTLR start "rule__ConstantDefinition__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2970:1: rule__ConstantDefinition__Group__0__Impl : ( 'constant' ) ;
    public final void rule__ConstantDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2974:1: ( ( 'constant' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2975:1: ( 'constant' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2975:1: ( 'constant' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2976:1: 'constant'
            {
             before(grammarAccess.getConstantDefinitionAccess().getConstantKeyword_0()); 
            match(input,32,FOLLOW_32_in_rule__ConstantDefinition__Group__0__Impl6167); 
             after(grammarAccess.getConstantDefinitionAccess().getConstantKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstantDefinition__Group__0__Impl"


    // $ANTLR start "rule__ConstantDefinition__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2989:1: rule__ConstantDefinition__Group__1 : rule__ConstantDefinition__Group__1__Impl rule__ConstantDefinition__Group__2 ;
    public final void rule__ConstantDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2993:1: ( rule__ConstantDefinition__Group__1__Impl rule__ConstantDefinition__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2994:2: rule__ConstantDefinition__Group__1__Impl rule__ConstantDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__ConstantDefinition__Group__1__Impl_in_rule__ConstantDefinition__Group__16198);
            rule__ConstantDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstantDefinition__Group__2_in_rule__ConstantDefinition__Group__16201);
            rule__ConstantDefinition__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstantDefinition__Group__1"


    // $ANTLR start "rule__ConstantDefinition__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3001:1: rule__ConstantDefinition__Group__1__Impl : ( ( rule__ConstantDefinition__NameAssignment_1 ) ) ;
    public final void rule__ConstantDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3005:1: ( ( ( rule__ConstantDefinition__NameAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3006:1: ( ( rule__ConstantDefinition__NameAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3006:1: ( ( rule__ConstantDefinition__NameAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3007:1: ( rule__ConstantDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getConstantDefinitionAccess().getNameAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3008:1: ( rule__ConstantDefinition__NameAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3008:2: rule__ConstantDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ConstantDefinition__NameAssignment_1_in_rule__ConstantDefinition__Group__1__Impl6228);
            rule__ConstantDefinition__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getConstantDefinitionAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstantDefinition__Group__1__Impl"


    // $ANTLR start "rule__ConstantDefinition__Group__2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3018:1: rule__ConstantDefinition__Group__2 : rule__ConstantDefinition__Group__2__Impl ;
    public final void rule__ConstantDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3022:1: ( rule__ConstantDefinition__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3023:2: rule__ConstantDefinition__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ConstantDefinition__Group__2__Impl_in_rule__ConstantDefinition__Group__26258);
            rule__ConstantDefinition__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstantDefinition__Group__2"


    // $ANTLR start "rule__ConstantDefinition__Group__2__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3029:1: rule__ConstantDefinition__Group__2__Impl : ( ( rule__ConstantDefinition__ValueAssignment_2 ) ) ;
    public final void rule__ConstantDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3033:1: ( ( ( rule__ConstantDefinition__ValueAssignment_2 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3034:1: ( ( rule__ConstantDefinition__ValueAssignment_2 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3034:1: ( ( rule__ConstantDefinition__ValueAssignment_2 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3035:1: ( rule__ConstantDefinition__ValueAssignment_2 )
            {
             before(grammarAccess.getConstantDefinitionAccess().getValueAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3036:1: ( rule__ConstantDefinition__ValueAssignment_2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3036:2: rule__ConstantDefinition__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__ConstantDefinition__ValueAssignment_2_in_rule__ConstantDefinition__Group__2__Impl6285);
            rule__ConstantDefinition__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getConstantDefinitionAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstantDefinition__Group__2__Impl"


    // $ANTLR start "rule__Test__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3052:1: rule__Test__Group__0 : rule__Test__Group__0__Impl rule__Test__Group__1 ;
    public final void rule__Test__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3056:1: ( rule__Test__Group__0__Impl rule__Test__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3057:2: rule__Test__Group__0__Impl rule__Test__Group__1
            {
            pushFollow(FOLLOW_rule__Test__Group__0__Impl_in_rule__Test__Group__06321);
            rule__Test__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Test__Group__1_in_rule__Test__Group__06324);
            rule__Test__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__Group__0"


    // $ANTLR start "rule__Test__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3064:1: rule__Test__Group__0__Impl : ( 'test' ) ;
    public final void rule__Test__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3068:1: ( ( 'test' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3069:1: ( 'test' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3069:1: ( 'test' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3070:1: 'test'
            {
             before(grammarAccess.getTestAccess().getTestKeyword_0()); 
            match(input,33,FOLLOW_33_in_rule__Test__Group__0__Impl6352); 
             after(grammarAccess.getTestAccess().getTestKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__Group__0__Impl"


    // $ANTLR start "rule__Test__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3083:1: rule__Test__Group__1 : rule__Test__Group__1__Impl rule__Test__Group__2 ;
    public final void rule__Test__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3087:1: ( rule__Test__Group__1__Impl rule__Test__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3088:2: rule__Test__Group__1__Impl rule__Test__Group__2
            {
            pushFollow(FOLLOW_rule__Test__Group__1__Impl_in_rule__Test__Group__16383);
            rule__Test__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Test__Group__2_in_rule__Test__Group__16386);
            rule__Test__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__Group__1"


    // $ANTLR start "rule__Test__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3095:1: rule__Test__Group__1__Impl : ( ( rule__Test__DefinitionAssignment_1 ) ) ;
    public final void rule__Test__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3099:1: ( ( ( rule__Test__DefinitionAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3100:1: ( ( rule__Test__DefinitionAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3100:1: ( ( rule__Test__DefinitionAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3101:1: ( rule__Test__DefinitionAssignment_1 )
            {
             before(grammarAccess.getTestAccess().getDefinitionAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3102:1: ( rule__Test__DefinitionAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3102:2: rule__Test__DefinitionAssignment_1
            {
            pushFollow(FOLLOW_rule__Test__DefinitionAssignment_1_in_rule__Test__Group__1__Impl6413);
            rule__Test__DefinitionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTestAccess().getDefinitionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__Group__1__Impl"


    // $ANTLR start "rule__Test__Group__2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3112:1: rule__Test__Group__2 : rule__Test__Group__2__Impl rule__Test__Group__3 ;
    public final void rule__Test__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3116:1: ( rule__Test__Group__2__Impl rule__Test__Group__3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3117:2: rule__Test__Group__2__Impl rule__Test__Group__3
            {
            pushFollow(FOLLOW_rule__Test__Group__2__Impl_in_rule__Test__Group__26443);
            rule__Test__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Test__Group__3_in_rule__Test__Group__26446);
            rule__Test__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__Group__2"


    // $ANTLR start "rule__Test__Group__2__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3124:1: rule__Test__Group__2__Impl : ( ( rule__Test__ParametersAssignment_2 )* ) ;
    public final void rule__Test__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3128:1: ( ( ( rule__Test__ParametersAssignment_2 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3129:1: ( ( rule__Test__ParametersAssignment_2 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3129:1: ( ( rule__Test__ParametersAssignment_2 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3130:1: ( rule__Test__ParametersAssignment_2 )*
            {
             before(grammarAccess.getTestAccess().getParametersAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3131:1: ( rule__Test__ParametersAssignment_2 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_ID) ) {
                    int LA22_1 = input.LA(2);

                    if ( (LA22_1==41) ) {
                        alt22=1;
                    }


                }
                else if ( (LA22_0==42) ) {
                    int LA22_2 = input.LA(2);

                    if ( (LA22_2==RULE_ID) ) {
                        int LA22_5 = input.LA(3);

                        if ( (LA22_5==41) ) {
                            alt22=1;
                        }


                    }


                }


                switch (alt22) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3131:2: rule__Test__ParametersAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Test__ParametersAssignment_2_in_rule__Test__Group__2__Impl6473);
            	    rule__Test__ParametersAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getTestAccess().getParametersAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__Group__2__Impl"


    // $ANTLR start "rule__Test__Group__3"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3141:1: rule__Test__Group__3 : rule__Test__Group__3__Impl rule__Test__Group__4 ;
    public final void rule__Test__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3145:1: ( rule__Test__Group__3__Impl rule__Test__Group__4 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3146:2: rule__Test__Group__3__Impl rule__Test__Group__4
            {
            pushFollow(FOLLOW_rule__Test__Group__3__Impl_in_rule__Test__Group__36504);
            rule__Test__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Test__Group__4_in_rule__Test__Group__36507);
            rule__Test__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__Group__3"


    // $ANTLR start "rule__Test__Group__3__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3153:1: rule__Test__Group__3__Impl : ( ( rule__Test__ResultsAssignment_3 )* ) ;
    public final void rule__Test__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3157:1: ( ( ( rule__Test__ResultsAssignment_3 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3158:1: ( ( rule__Test__ResultsAssignment_3 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3158:1: ( ( rule__Test__ResultsAssignment_3 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3159:1: ( rule__Test__ResultsAssignment_3 )*
            {
             before(grammarAccess.getTestAccess().getResultsAssignment_3()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3160:1: ( rule__Test__ResultsAssignment_3 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_ID||LA23_0==42) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3160:2: rule__Test__ResultsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__Test__ResultsAssignment_3_in_rule__Test__Group__3__Impl6534);
            	    rule__Test__ResultsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getTestAccess().getResultsAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__Group__3__Impl"


    // $ANTLR start "rule__Test__Group__4"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3170:1: rule__Test__Group__4 : rule__Test__Group__4__Impl ;
    public final void rule__Test__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3174:1: ( rule__Test__Group__4__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3175:2: rule__Test__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Test__Group__4__Impl_in_rule__Test__Group__46565);
            rule__Test__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__Group__4"


    // $ANTLR start "rule__Test__Group__4__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3181:1: rule__Test__Group__4__Impl : ( ( rule__Test__Group_4__0 )? ) ;
    public final void rule__Test__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3185:1: ( ( ( rule__Test__Group_4__0 )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3186:1: ( ( rule__Test__Group_4__0 )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3186:1: ( ( rule__Test__Group_4__0 )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3187:1: ( rule__Test__Group_4__0 )?
            {
             before(grammarAccess.getTestAccess().getGroup_4()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3188:1: ( rule__Test__Group_4__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==34) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3188:2: rule__Test__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Test__Group_4__0_in_rule__Test__Group__4__Impl6592);
                    rule__Test__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTestAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__Group__4__Impl"


    // $ANTLR start "rule__Test__Group_4__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3208:1: rule__Test__Group_4__0 : rule__Test__Group_4__0__Impl rule__Test__Group_4__1 ;
    public final void rule__Test__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3212:1: ( rule__Test__Group_4__0__Impl rule__Test__Group_4__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3213:2: rule__Test__Group_4__0__Impl rule__Test__Group_4__1
            {
            pushFollow(FOLLOW_rule__Test__Group_4__0__Impl_in_rule__Test__Group_4__06633);
            rule__Test__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Test__Group_4__1_in_rule__Test__Group_4__06636);
            rule__Test__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__Group_4__0"


    // $ANTLR start "rule__Test__Group_4__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3220:1: rule__Test__Group_4__0__Impl : ( '=' ) ;
    public final void rule__Test__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3224:1: ( ( '=' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3225:1: ( '=' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3225:1: ( '=' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3226:1: '='
            {
             before(grammarAccess.getTestAccess().getEqualsSignKeyword_4_0()); 
            match(input,34,FOLLOW_34_in_rule__Test__Group_4__0__Impl6664); 
             after(grammarAccess.getTestAccess().getEqualsSignKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__Group_4__0__Impl"


    // $ANTLR start "rule__Test__Group_4__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3239:1: rule__Test__Group_4__1 : rule__Test__Group_4__1__Impl ;
    public final void rule__Test__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3243:1: ( rule__Test__Group_4__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3244:2: rule__Test__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Test__Group_4__1__Impl_in_rule__Test__Group_4__16695);
            rule__Test__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__Group_4__1"


    // $ANTLR start "rule__Test__Group_4__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3250:1: rule__Test__Group_4__1__Impl : ( ( rule__Test__ResultAssignment_4_1 ) ) ;
    public final void rule__Test__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3254:1: ( ( ( rule__Test__ResultAssignment_4_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3255:1: ( ( rule__Test__ResultAssignment_4_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3255:1: ( ( rule__Test__ResultAssignment_4_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3256:1: ( rule__Test__ResultAssignment_4_1 )
            {
             before(grammarAccess.getTestAccess().getResultAssignment_4_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3257:1: ( rule__Test__ResultAssignment_4_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3257:2: rule__Test__ResultAssignment_4_1
            {
            pushFollow(FOLLOW_rule__Test__ResultAssignment_4_1_in_rule__Test__Group_4__1__Impl6722);
            rule__Test__ResultAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getTestAccess().getResultAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__Group_4__1__Impl"


    // $ANTLR start "rule__TableTest__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3271:1: rule__TableTest__Group__0 : rule__TableTest__Group__0__Impl rule__TableTest__Group__1 ;
    public final void rule__TableTest__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3275:1: ( rule__TableTest__Group__0__Impl rule__TableTest__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3276:2: rule__TableTest__Group__0__Impl rule__TableTest__Group__1
            {
            pushFollow(FOLLOW_rule__TableTest__Group__0__Impl_in_rule__TableTest__Group__06756);
            rule__TableTest__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group__1_in_rule__TableTest__Group__06759);
            rule__TableTest__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__Group__0"


    // $ANTLR start "rule__TableTest__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3283:1: rule__TableTest__Group__0__Impl : ( 'tabletest' ) ;
    public final void rule__TableTest__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3287:1: ( ( 'tabletest' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3288:1: ( 'tabletest' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3288:1: ( 'tabletest' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3289:1: 'tabletest'
            {
             before(grammarAccess.getTableTestAccess().getTabletestKeyword_0()); 
            match(input,35,FOLLOW_35_in_rule__TableTest__Group__0__Impl6787); 
             after(grammarAccess.getTableTestAccess().getTabletestKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__Group__0__Impl"


    // $ANTLR start "rule__TableTest__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3302:1: rule__TableTest__Group__1 : rule__TableTest__Group__1__Impl rule__TableTest__Group__2 ;
    public final void rule__TableTest__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3306:1: ( rule__TableTest__Group__1__Impl rule__TableTest__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3307:2: rule__TableTest__Group__1__Impl rule__TableTest__Group__2
            {
            pushFollow(FOLLOW_rule__TableTest__Group__1__Impl_in_rule__TableTest__Group__16818);
            rule__TableTest__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group__2_in_rule__TableTest__Group__16821);
            rule__TableTest__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__Group__1"


    // $ANTLR start "rule__TableTest__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3314:1: rule__TableTest__Group__1__Impl : ( ( rule__TableTest__DefinitionAssignment_1 ) ) ;
    public final void rule__TableTest__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3318:1: ( ( ( rule__TableTest__DefinitionAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3319:1: ( ( rule__TableTest__DefinitionAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3319:1: ( ( rule__TableTest__DefinitionAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3320:1: ( rule__TableTest__DefinitionAssignment_1 )
            {
             before(grammarAccess.getTableTestAccess().getDefinitionAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3321:1: ( rule__TableTest__DefinitionAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3321:2: rule__TableTest__DefinitionAssignment_1
            {
            pushFollow(FOLLOW_rule__TableTest__DefinitionAssignment_1_in_rule__TableTest__Group__1__Impl6848);
            rule__TableTest__DefinitionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTableTestAccess().getDefinitionAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__Group__1__Impl"


    // $ANTLR start "rule__TableTest__Group__2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3331:1: rule__TableTest__Group__2 : rule__TableTest__Group__2__Impl rule__TableTest__Group__3 ;
    public final void rule__TableTest__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3335:1: ( rule__TableTest__Group__2__Impl rule__TableTest__Group__3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3336:2: rule__TableTest__Group__2__Impl rule__TableTest__Group__3
            {
            pushFollow(FOLLOW_rule__TableTest__Group__2__Impl_in_rule__TableTest__Group__26878);
            rule__TableTest__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group__3_in_rule__TableTest__Group__26881);
            rule__TableTest__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__Group__2"


    // $ANTLR start "rule__TableTest__Group__2__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3343:1: rule__TableTest__Group__2__Impl : ( ( rule__TableTest__ParametersAssignment_2 )* ) ;
    public final void rule__TableTest__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3347:1: ( ( ( rule__TableTest__ParametersAssignment_2 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3348:1: ( ( rule__TableTest__ParametersAssignment_2 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3348:1: ( ( rule__TableTest__ParametersAssignment_2 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3349:1: ( rule__TableTest__ParametersAssignment_2 )*
            {
             before(grammarAccess.getTableTestAccess().getParametersAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3350:1: ( rule__TableTest__ParametersAssignment_2 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_ID||LA25_0==42) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3350:2: rule__TableTest__ParametersAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__TableTest__ParametersAssignment_2_in_rule__TableTest__Group__2__Impl6908);
            	    rule__TableTest__ParametersAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

             after(grammarAccess.getTableTestAccess().getParametersAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__Group__2__Impl"


    // $ANTLR start "rule__TableTest__Group__3"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3360:1: rule__TableTest__Group__3 : rule__TableTest__Group__3__Impl rule__TableTest__Group__4 ;
    public final void rule__TableTest__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3364:1: ( rule__TableTest__Group__3__Impl rule__TableTest__Group__4 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3365:2: rule__TableTest__Group__3__Impl rule__TableTest__Group__4
            {
            pushFollow(FOLLOW_rule__TableTest__Group__3__Impl_in_rule__TableTest__Group__36939);
            rule__TableTest__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group__4_in_rule__TableTest__Group__36942);
            rule__TableTest__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__Group__3"


    // $ANTLR start "rule__TableTest__Group__3__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3372:1: rule__TableTest__Group__3__Impl : ( ( rule__TableTest__ParameterHeadersAssignment_3 )* ) ;
    public final void rule__TableTest__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3376:1: ( ( ( rule__TableTest__ParameterHeadersAssignment_3 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3377:1: ( ( rule__TableTest__ParameterHeadersAssignment_3 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3377:1: ( ( rule__TableTest__ParameterHeadersAssignment_3 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3378:1: ( rule__TableTest__ParameterHeadersAssignment_3 )*
            {
             before(grammarAccess.getTableTestAccess().getParameterHeadersAssignment_3()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3379:1: ( rule__TableTest__ParameterHeadersAssignment_3 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==36) ) {
                    int LA26_1 = input.LA(2);

                    if ( (LA26_1==RULE_ID) ) {
                        int LA26_2 = input.LA(3);

                        if ( (LA26_2==36) ) {
                            alt26=1;
                        }


                    }
                    else if ( (LA26_1==42) ) {
                        int LA26_3 = input.LA(3);

                        if ( (LA26_3==RULE_ID) ) {
                            int LA26_6 = input.LA(4);

                            if ( (LA26_6==36) ) {
                                alt26=1;
                            }


                        }


                    }


                }


                switch (alt26) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3379:2: rule__TableTest__ParameterHeadersAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__TableTest__ParameterHeadersAssignment_3_in_rule__TableTest__Group__3__Impl6969);
            	    rule__TableTest__ParameterHeadersAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             after(grammarAccess.getTableTestAccess().getParameterHeadersAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__Group__3__Impl"


    // $ANTLR start "rule__TableTest__Group__4"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3389:1: rule__TableTest__Group__4 : rule__TableTest__Group__4__Impl rule__TableTest__Group__5 ;
    public final void rule__TableTest__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3393:1: ( rule__TableTest__Group__4__Impl rule__TableTest__Group__5 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3394:2: rule__TableTest__Group__4__Impl rule__TableTest__Group__5
            {
            pushFollow(FOLLOW_rule__TableTest__Group__4__Impl_in_rule__TableTest__Group__47000);
            rule__TableTest__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group__5_in_rule__TableTest__Group__47003);
            rule__TableTest__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__Group__4"


    // $ANTLR start "rule__TableTest__Group__4__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3401:1: rule__TableTest__Group__4__Impl : ( ( rule__TableTest__ResultHeadersAssignment_4 )* ) ;
    public final void rule__TableTest__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3405:1: ( ( ( rule__TableTest__ResultHeadersAssignment_4 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3406:1: ( ( rule__TableTest__ResultHeadersAssignment_4 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3406:1: ( ( rule__TableTest__ResultHeadersAssignment_4 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3407:1: ( rule__TableTest__ResultHeadersAssignment_4 )*
            {
             before(grammarAccess.getTableTestAccess().getResultHeadersAssignment_4()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3408:1: ( rule__TableTest__ResultHeadersAssignment_4 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==36) ) {
                    int LA27_1 = input.LA(2);

                    if ( (LA27_1==RULE_ID||LA27_1==42) ) {
                        alt27=1;
                    }


                }


                switch (alt27) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3408:2: rule__TableTest__ResultHeadersAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__TableTest__ResultHeadersAssignment_4_in_rule__TableTest__Group__4__Impl7030);
            	    rule__TableTest__ResultHeadersAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

             after(grammarAccess.getTableTestAccess().getResultHeadersAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__Group__4__Impl"


    // $ANTLR start "rule__TableTest__Group__5"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3418:1: rule__TableTest__Group__5 : rule__TableTest__Group__5__Impl rule__TableTest__Group__6 ;
    public final void rule__TableTest__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3422:1: ( rule__TableTest__Group__5__Impl rule__TableTest__Group__6 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3423:2: rule__TableTest__Group__5__Impl rule__TableTest__Group__6
            {
            pushFollow(FOLLOW_rule__TableTest__Group__5__Impl_in_rule__TableTest__Group__57061);
            rule__TableTest__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group__6_in_rule__TableTest__Group__57064);
            rule__TableTest__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__Group__5"


    // $ANTLR start "rule__TableTest__Group__5__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3430:1: rule__TableTest__Group__5__Impl : ( '|' ) ;
    public final void rule__TableTest__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3434:1: ( ( '|' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3435:1: ( '|' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3435:1: ( '|' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3436:1: '|'
            {
             before(grammarAccess.getTableTestAccess().getVerticalLineKeyword_5()); 
            match(input,36,FOLLOW_36_in_rule__TableTest__Group__5__Impl7092); 
             after(grammarAccess.getTableTestAccess().getVerticalLineKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__Group__5__Impl"


    // $ANTLR start "rule__TableTest__Group__6"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3449:1: rule__TableTest__Group__6 : rule__TableTest__Group__6__Impl rule__TableTest__Group__7 ;
    public final void rule__TableTest__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3453:1: ( rule__TableTest__Group__6__Impl rule__TableTest__Group__7 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3454:2: rule__TableTest__Group__6__Impl rule__TableTest__Group__7
            {
            pushFollow(FOLLOW_rule__TableTest__Group__6__Impl_in_rule__TableTest__Group__67123);
            rule__TableTest__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group__7_in_rule__TableTest__Group__67126);
            rule__TableTest__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__Group__6"


    // $ANTLR start "rule__TableTest__Group__6__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3461:1: rule__TableTest__Group__6__Impl : ( ( rule__TableTest__Group_6__0 )? ) ;
    public final void rule__TableTest__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3465:1: ( ( ( rule__TableTest__Group_6__0 )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3466:1: ( ( rule__TableTest__Group_6__0 )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3466:1: ( ( rule__TableTest__Group_6__0 )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3467:1: ( rule__TableTest__Group_6__0 )?
            {
             before(grammarAccess.getTableTestAccess().getGroup_6()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3468:1: ( rule__TableTest__Group_6__0 )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==34) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3468:2: rule__TableTest__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__TableTest__Group_6__0_in_rule__TableTest__Group__6__Impl7153);
                    rule__TableTest__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTableTestAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__Group__6__Impl"


    // $ANTLR start "rule__TableTest__Group__7"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3478:1: rule__TableTest__Group__7 : rule__TableTest__Group__7__Impl ;
    public final void rule__TableTest__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3482:1: ( rule__TableTest__Group__7__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3483:2: rule__TableTest__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__TableTest__Group__7__Impl_in_rule__TableTest__Group__77184);
            rule__TableTest__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__Group__7"


    // $ANTLR start "rule__TableTest__Group__7__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3489:1: rule__TableTest__Group__7__Impl : ( ( ( rule__TableTest__RowsAssignment_7 ) ) ( ( rule__TableTest__RowsAssignment_7 )* ) ) ;
    public final void rule__TableTest__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3493:1: ( ( ( ( rule__TableTest__RowsAssignment_7 ) ) ( ( rule__TableTest__RowsAssignment_7 )* ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3494:1: ( ( ( rule__TableTest__RowsAssignment_7 ) ) ( ( rule__TableTest__RowsAssignment_7 )* ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3494:1: ( ( ( rule__TableTest__RowsAssignment_7 ) ) ( ( rule__TableTest__RowsAssignment_7 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3495:1: ( ( rule__TableTest__RowsAssignment_7 ) ) ( ( rule__TableTest__RowsAssignment_7 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3495:1: ( ( rule__TableTest__RowsAssignment_7 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3496:1: ( rule__TableTest__RowsAssignment_7 )
            {
             before(grammarAccess.getTableTestAccess().getRowsAssignment_7()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3497:1: ( rule__TableTest__RowsAssignment_7 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3497:2: rule__TableTest__RowsAssignment_7
            {
            pushFollow(FOLLOW_rule__TableTest__RowsAssignment_7_in_rule__TableTest__Group__7__Impl7213);
            rule__TableTest__RowsAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getTableTestAccess().getRowsAssignment_7()); 

            }

            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3500:1: ( ( rule__TableTest__RowsAssignment_7 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3501:1: ( rule__TableTest__RowsAssignment_7 )*
            {
             before(grammarAccess.getTableTestAccess().getRowsAssignment_7()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3502:1: ( rule__TableTest__RowsAssignment_7 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==36) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3502:2: rule__TableTest__RowsAssignment_7
            	    {
            	    pushFollow(FOLLOW_rule__TableTest__RowsAssignment_7_in_rule__TableTest__Group__7__Impl7225);
            	    rule__TableTest__RowsAssignment_7();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

             after(grammarAccess.getTableTestAccess().getRowsAssignment_7()); 

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__Group__7__Impl"


    // $ANTLR start "rule__TableTest__Group_6__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3529:1: rule__TableTest__Group_6__0 : rule__TableTest__Group_6__0__Impl rule__TableTest__Group_6__1 ;
    public final void rule__TableTest__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3533:1: ( rule__TableTest__Group_6__0__Impl rule__TableTest__Group_6__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3534:2: rule__TableTest__Group_6__0__Impl rule__TableTest__Group_6__1
            {
            pushFollow(FOLLOW_rule__TableTest__Group_6__0__Impl_in_rule__TableTest__Group_6__07274);
            rule__TableTest__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group_6__1_in_rule__TableTest__Group_6__07277);
            rule__TableTest__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__Group_6__0"


    // $ANTLR start "rule__TableTest__Group_6__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3541:1: rule__TableTest__Group_6__0__Impl : ( ( rule__TableTest__DefaultResultColumnAssignment_6_0 ) ) ;
    public final void rule__TableTest__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3545:1: ( ( ( rule__TableTest__DefaultResultColumnAssignment_6_0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3546:1: ( ( rule__TableTest__DefaultResultColumnAssignment_6_0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3546:1: ( ( rule__TableTest__DefaultResultColumnAssignment_6_0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3547:1: ( rule__TableTest__DefaultResultColumnAssignment_6_0 )
            {
             before(grammarAccess.getTableTestAccess().getDefaultResultColumnAssignment_6_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3548:1: ( rule__TableTest__DefaultResultColumnAssignment_6_0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3548:2: rule__TableTest__DefaultResultColumnAssignment_6_0
            {
            pushFollow(FOLLOW_rule__TableTest__DefaultResultColumnAssignment_6_0_in_rule__TableTest__Group_6__0__Impl7304);
            rule__TableTest__DefaultResultColumnAssignment_6_0();

            state._fsp--;


            }

             after(grammarAccess.getTableTestAccess().getDefaultResultColumnAssignment_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__Group_6__0__Impl"


    // $ANTLR start "rule__TableTest__Group_6__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3558:1: rule__TableTest__Group_6__1 : rule__TableTest__Group_6__1__Impl ;
    public final void rule__TableTest__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3562:1: ( rule__TableTest__Group_6__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3563:2: rule__TableTest__Group_6__1__Impl
            {
            pushFollow(FOLLOW_rule__TableTest__Group_6__1__Impl_in_rule__TableTest__Group_6__17334);
            rule__TableTest__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__Group_6__1"


    // $ANTLR start "rule__TableTest__Group_6__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3569:1: rule__TableTest__Group_6__1__Impl : ( '|' ) ;
    public final void rule__TableTest__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3573:1: ( ( '|' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3574:1: ( '|' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3574:1: ( '|' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3575:1: '|'
            {
             before(grammarAccess.getTableTestAccess().getVerticalLineKeyword_6_1()); 
            match(input,36,FOLLOW_36_in_rule__TableTest__Group_6__1__Impl7362); 
             after(grammarAccess.getTableTestAccess().getVerticalLineKeyword_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__Group_6__1__Impl"


    // $ANTLR start "rule__TableTestRow__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3592:1: rule__TableTestRow__Group__0 : rule__TableTestRow__Group__0__Impl rule__TableTestRow__Group__1 ;
    public final void rule__TableTestRow__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3596:1: ( rule__TableTestRow__Group__0__Impl rule__TableTestRow__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3597:2: rule__TableTestRow__Group__0__Impl rule__TableTestRow__Group__1
            {
            pushFollow(FOLLOW_rule__TableTestRow__Group__0__Impl_in_rule__TableTestRow__Group__07397);
            rule__TableTestRow__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTestRow__Group__1_in_rule__TableTestRow__Group__07400);
            rule__TableTestRow__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTestRow__Group__0"


    // $ANTLR start "rule__TableTestRow__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3604:1: rule__TableTestRow__Group__0__Impl : ( () ) ;
    public final void rule__TableTestRow__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3608:1: ( ( () ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3609:1: ( () )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3609:1: ( () )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3610:1: ()
            {
             before(grammarAccess.getTableTestRowAccess().getTableTestRowAction_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3611:1: ()
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3613:1: 
            {
            }

             after(grammarAccess.getTableTestRowAccess().getTableTestRowAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTestRow__Group__0__Impl"


    // $ANTLR start "rule__TableTestRow__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3623:1: rule__TableTestRow__Group__1 : rule__TableTestRow__Group__1__Impl rule__TableTestRow__Group__2 ;
    public final void rule__TableTestRow__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3627:1: ( rule__TableTestRow__Group__1__Impl rule__TableTestRow__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3628:2: rule__TableTestRow__Group__1__Impl rule__TableTestRow__Group__2
            {
            pushFollow(FOLLOW_rule__TableTestRow__Group__1__Impl_in_rule__TableTestRow__Group__17458);
            rule__TableTestRow__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTestRow__Group__2_in_rule__TableTestRow__Group__17461);
            rule__TableTestRow__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTestRow__Group__1"


    // $ANTLR start "rule__TableTestRow__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3635:1: rule__TableTestRow__Group__1__Impl : ( ( rule__TableTestRow__ValuesAssignment_1 )* ) ;
    public final void rule__TableTestRow__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3639:1: ( ( ( rule__TableTestRow__ValuesAssignment_1 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3640:1: ( ( rule__TableTestRow__ValuesAssignment_1 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3640:1: ( ( rule__TableTestRow__ValuesAssignment_1 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3641:1: ( rule__TableTestRow__ValuesAssignment_1 )*
            {
             before(grammarAccess.getTableTestRowAccess().getValuesAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3642:1: ( rule__TableTestRow__ValuesAssignment_1 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==36) ) {
                    int LA30_1 = input.LA(2);

                    if ( ((LA30_1>=RULE_BOOLEAN_TRUE && LA30_1<=RULE_UPPERCASE_ID)||(LA30_1>=RULE_STRING && LA30_1<=RULE_DECIMAL)||LA30_1==44) ) {
                        alt30=1;
                    }


                }


                switch (alt30) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3642:2: rule__TableTestRow__ValuesAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__TableTestRow__ValuesAssignment_1_in_rule__TableTestRow__Group__1__Impl7488);
            	    rule__TableTestRow__ValuesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getTableTestRowAccess().getValuesAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTestRow__Group__1__Impl"


    // $ANTLR start "rule__TableTestRow__Group__2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3652:1: rule__TableTestRow__Group__2 : rule__TableTestRow__Group__2__Impl ;
    public final void rule__TableTestRow__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3656:1: ( rule__TableTestRow__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3657:2: rule__TableTestRow__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__TableTestRow__Group__2__Impl_in_rule__TableTestRow__Group__27519);
            rule__TableTestRow__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTestRow__Group__2"


    // $ANTLR start "rule__TableTestRow__Group__2__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3663:1: rule__TableTestRow__Group__2__Impl : ( '|' ) ;
    public final void rule__TableTestRow__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3667:1: ( ( '|' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3668:1: ( '|' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3668:1: ( '|' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3669:1: '|'
            {
             before(grammarAccess.getTableTestRowAccess().getVerticalLineKeyword_2()); 
            match(input,36,FOLLOW_36_in_rule__TableTestRow__Group__2__Impl7547); 
             after(grammarAccess.getTableTestRowAccess().getVerticalLineKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTestRow__Group__2__Impl"


    // $ANTLR start "rule__ParameterTableHeader__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3688:1: rule__ParameterTableHeader__Group__0 : rule__ParameterTableHeader__Group__0__Impl rule__ParameterTableHeader__Group__1 ;
    public final void rule__ParameterTableHeader__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3692:1: ( rule__ParameterTableHeader__Group__0__Impl rule__ParameterTableHeader__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3693:2: rule__ParameterTableHeader__Group__0__Impl rule__ParameterTableHeader__Group__1
            {
            pushFollow(FOLLOW_rule__ParameterTableHeader__Group__0__Impl_in_rule__ParameterTableHeader__Group__07584);
            rule__ParameterTableHeader__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParameterTableHeader__Group__1_in_rule__ParameterTableHeader__Group__07587);
            rule__ParameterTableHeader__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterTableHeader__Group__0"


    // $ANTLR start "rule__ParameterTableHeader__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3700:1: rule__ParameterTableHeader__Group__0__Impl : ( '|' ) ;
    public final void rule__ParameterTableHeader__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3704:1: ( ( '|' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3705:1: ( '|' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3705:1: ( '|' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3706:1: '|'
            {
             before(grammarAccess.getParameterTableHeaderAccess().getVerticalLineKeyword_0()); 
            match(input,36,FOLLOW_36_in_rule__ParameterTableHeader__Group__0__Impl7615); 
             after(grammarAccess.getParameterTableHeaderAccess().getVerticalLineKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterTableHeader__Group__0__Impl"


    // $ANTLR start "rule__ParameterTableHeader__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3719:1: rule__ParameterTableHeader__Group__1 : rule__ParameterTableHeader__Group__1__Impl ;
    public final void rule__ParameterTableHeader__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3723:1: ( rule__ParameterTableHeader__Group__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3724:2: rule__ParameterTableHeader__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ParameterTableHeader__Group__1__Impl_in_rule__ParameterTableHeader__Group__17646);
            rule__ParameterTableHeader__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterTableHeader__Group__1"


    // $ANTLR start "rule__ParameterTableHeader__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3730:1: rule__ParameterTableHeader__Group__1__Impl : ( ( rule__ParameterTableHeader__NameAssignment_1 ) ) ;
    public final void rule__ParameterTableHeader__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3734:1: ( ( ( rule__ParameterTableHeader__NameAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3735:1: ( ( rule__ParameterTableHeader__NameAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3735:1: ( ( rule__ParameterTableHeader__NameAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3736:1: ( rule__ParameterTableHeader__NameAssignment_1 )
            {
             before(grammarAccess.getParameterTableHeaderAccess().getNameAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3737:1: ( rule__ParameterTableHeader__NameAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3737:2: rule__ParameterTableHeader__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ParameterTableHeader__NameAssignment_1_in_rule__ParameterTableHeader__Group__1__Impl7673);
            rule__ParameterTableHeader__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterTableHeaderAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterTableHeader__Group__1__Impl"


    // $ANTLR start "rule__ResultTableHeader__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3751:1: rule__ResultTableHeader__Group__0 : rule__ResultTableHeader__Group__0__Impl rule__ResultTableHeader__Group__1 ;
    public final void rule__ResultTableHeader__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3755:1: ( rule__ResultTableHeader__Group__0__Impl rule__ResultTableHeader__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3756:2: rule__ResultTableHeader__Group__0__Impl rule__ResultTableHeader__Group__1
            {
            pushFollow(FOLLOW_rule__ResultTableHeader__Group__0__Impl_in_rule__ResultTableHeader__Group__07707);
            rule__ResultTableHeader__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultTableHeader__Group__1_in_rule__ResultTableHeader__Group__07710);
            rule__ResultTableHeader__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultTableHeader__Group__0"


    // $ANTLR start "rule__ResultTableHeader__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3763:1: rule__ResultTableHeader__Group__0__Impl : ( '|' ) ;
    public final void rule__ResultTableHeader__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3767:1: ( ( '|' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3768:1: ( '|' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3768:1: ( '|' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3769:1: '|'
            {
             before(grammarAccess.getResultTableHeaderAccess().getVerticalLineKeyword_0()); 
            match(input,36,FOLLOW_36_in_rule__ResultTableHeader__Group__0__Impl7738); 
             after(grammarAccess.getResultTableHeaderAccess().getVerticalLineKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultTableHeader__Group__0__Impl"


    // $ANTLR start "rule__ResultTableHeader__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3782:1: rule__ResultTableHeader__Group__1 : rule__ResultTableHeader__Group__1__Impl rule__ResultTableHeader__Group__2 ;
    public final void rule__ResultTableHeader__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3786:1: ( rule__ResultTableHeader__Group__1__Impl rule__ResultTableHeader__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3787:2: rule__ResultTableHeader__Group__1__Impl rule__ResultTableHeader__Group__2
            {
            pushFollow(FOLLOW_rule__ResultTableHeader__Group__1__Impl_in_rule__ResultTableHeader__Group__17769);
            rule__ResultTableHeader__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultTableHeader__Group__2_in_rule__ResultTableHeader__Group__17772);
            rule__ResultTableHeader__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultTableHeader__Group__1"


    // $ANTLR start "rule__ResultTableHeader__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3794:1: rule__ResultTableHeader__Group__1__Impl : ( ( rule__ResultTableHeader__NameAssignment_1 ) ) ;
    public final void rule__ResultTableHeader__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3798:1: ( ( ( rule__ResultTableHeader__NameAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3799:1: ( ( rule__ResultTableHeader__NameAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3799:1: ( ( rule__ResultTableHeader__NameAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3800:1: ( rule__ResultTableHeader__NameAssignment_1 )
            {
             before(grammarAccess.getResultTableHeaderAccess().getNameAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3801:1: ( rule__ResultTableHeader__NameAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3801:2: rule__ResultTableHeader__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ResultTableHeader__NameAssignment_1_in_rule__ResultTableHeader__Group__1__Impl7799);
            rule__ResultTableHeader__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getResultTableHeaderAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultTableHeader__Group__1__Impl"


    // $ANTLR start "rule__ResultTableHeader__Group__2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3811:1: rule__ResultTableHeader__Group__2 : rule__ResultTableHeader__Group__2__Impl ;
    public final void rule__ResultTableHeader__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3815:1: ( rule__ResultTableHeader__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3816:2: rule__ResultTableHeader__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ResultTableHeader__Group__2__Impl_in_rule__ResultTableHeader__Group__27829);
            rule__ResultTableHeader__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultTableHeader__Group__2"


    // $ANTLR start "rule__ResultTableHeader__Group__2__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3822:1: rule__ResultTableHeader__Group__2__Impl : ( '=' ) ;
    public final void rule__ResultTableHeader__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3826:1: ( ( '=' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3827:1: ( '=' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3827:1: ( '=' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3828:1: '='
            {
             before(grammarAccess.getResultTableHeaderAccess().getEqualsSignKeyword_2()); 
            match(input,34,FOLLOW_34_in_rule__ResultTableHeader__Group__2__Impl7857); 
             after(grammarAccess.getResultTableHeaderAccess().getEqualsSignKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultTableHeader__Group__2__Impl"


    // $ANTLR start "rule__ParameterTableValue__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3847:1: rule__ParameterTableValue__Group__0 : rule__ParameterTableValue__Group__0__Impl rule__ParameterTableValue__Group__1 ;
    public final void rule__ParameterTableValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3851:1: ( rule__ParameterTableValue__Group__0__Impl rule__ParameterTableValue__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3852:2: rule__ParameterTableValue__Group__0__Impl rule__ParameterTableValue__Group__1
            {
            pushFollow(FOLLOW_rule__ParameterTableValue__Group__0__Impl_in_rule__ParameterTableValue__Group__07894);
            rule__ParameterTableValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParameterTableValue__Group__1_in_rule__ParameterTableValue__Group__07897);
            rule__ParameterTableValue__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterTableValue__Group__0"


    // $ANTLR start "rule__ParameterTableValue__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3859:1: rule__ParameterTableValue__Group__0__Impl : ( '|' ) ;
    public final void rule__ParameterTableValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3863:1: ( ( '|' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3864:1: ( '|' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3864:1: ( '|' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3865:1: '|'
            {
             before(grammarAccess.getParameterTableValueAccess().getVerticalLineKeyword_0()); 
            match(input,36,FOLLOW_36_in_rule__ParameterTableValue__Group__0__Impl7925); 
             after(grammarAccess.getParameterTableValueAccess().getVerticalLineKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterTableValue__Group__0__Impl"


    // $ANTLR start "rule__ParameterTableValue__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3878:1: rule__ParameterTableValue__Group__1 : rule__ParameterTableValue__Group__1__Impl ;
    public final void rule__ParameterTableValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3882:1: ( rule__ParameterTableValue__Group__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3883:2: rule__ParameterTableValue__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ParameterTableValue__Group__1__Impl_in_rule__ParameterTableValue__Group__17956);
            rule__ParameterTableValue__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterTableValue__Group__1"


    // $ANTLR start "rule__ParameterTableValue__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3889:1: rule__ParameterTableValue__Group__1__Impl : ( ( rule__ParameterTableValue__ValueAssignment_1 ) ) ;
    public final void rule__ParameterTableValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3893:1: ( ( ( rule__ParameterTableValue__ValueAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3894:1: ( ( rule__ParameterTableValue__ValueAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3894:1: ( ( rule__ParameterTableValue__ValueAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3895:1: ( rule__ParameterTableValue__ValueAssignment_1 )
            {
             before(grammarAccess.getParameterTableValueAccess().getValueAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3896:1: ( rule__ParameterTableValue__ValueAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3896:2: rule__ParameterTableValue__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__ParameterTableValue__ValueAssignment_1_in_rule__ParameterTableValue__Group__1__Impl7983);
            rule__ParameterTableValue__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getParameterTableValueAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterTableValue__Group__1__Impl"


    // $ANTLR start "rule__NamedResult__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3910:1: rule__NamedResult__Group__0 : rule__NamedResult__Group__0__Impl rule__NamedResult__Group__1 ;
    public final void rule__NamedResult__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3914:1: ( rule__NamedResult__Group__0__Impl rule__NamedResult__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3915:2: rule__NamedResult__Group__0__Impl rule__NamedResult__Group__1
            {
            pushFollow(FOLLOW_rule__NamedResult__Group__0__Impl_in_rule__NamedResult__Group__08017);
            rule__NamedResult__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NamedResult__Group__1_in_rule__NamedResult__Group__08020);
            rule__NamedResult__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedResult__Group__0"


    // $ANTLR start "rule__NamedResult__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3922:1: rule__NamedResult__Group__0__Impl : ( ( rule__NamedResult__NameAssignment_0 ) ) ;
    public final void rule__NamedResult__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3926:1: ( ( ( rule__NamedResult__NameAssignment_0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3927:1: ( ( rule__NamedResult__NameAssignment_0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3927:1: ( ( rule__NamedResult__NameAssignment_0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3928:1: ( rule__NamedResult__NameAssignment_0 )
            {
             before(grammarAccess.getNamedResultAccess().getNameAssignment_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3929:1: ( rule__NamedResult__NameAssignment_0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3929:2: rule__NamedResult__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__NamedResult__NameAssignment_0_in_rule__NamedResult__Group__0__Impl8047);
            rule__NamedResult__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getNamedResultAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedResult__Group__0__Impl"


    // $ANTLR start "rule__NamedResult__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3939:1: rule__NamedResult__Group__1 : rule__NamedResult__Group__1__Impl rule__NamedResult__Group__2 ;
    public final void rule__NamedResult__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3943:1: ( rule__NamedResult__Group__1__Impl rule__NamedResult__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3944:2: rule__NamedResult__Group__1__Impl rule__NamedResult__Group__2
            {
            pushFollow(FOLLOW_rule__NamedResult__Group__1__Impl_in_rule__NamedResult__Group__18077);
            rule__NamedResult__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NamedResult__Group__2_in_rule__NamedResult__Group__18080);
            rule__NamedResult__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedResult__Group__1"


    // $ANTLR start "rule__NamedResult__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3951:1: rule__NamedResult__Group__1__Impl : ( '=' ) ;
    public final void rule__NamedResult__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3955:1: ( ( '=' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3956:1: ( '=' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3956:1: ( '=' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3957:1: '='
            {
             before(grammarAccess.getNamedResultAccess().getEqualsSignKeyword_1()); 
            match(input,34,FOLLOW_34_in_rule__NamedResult__Group__1__Impl8108); 
             after(grammarAccess.getNamedResultAccess().getEqualsSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedResult__Group__1__Impl"


    // $ANTLR start "rule__NamedResult__Group__2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3970:1: rule__NamedResult__Group__2 : rule__NamedResult__Group__2__Impl ;
    public final void rule__NamedResult__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3974:1: ( rule__NamedResult__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3975:2: rule__NamedResult__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__NamedResult__Group__2__Impl_in_rule__NamedResult__Group__28139);
            rule__NamedResult__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedResult__Group__2"


    // $ANTLR start "rule__NamedResult__Group__2__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3981:1: rule__NamedResult__Group__2__Impl : ( ( rule__NamedResult__ValueAssignment_2 ) ) ;
    public final void rule__NamedResult__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3985:1: ( ( ( rule__NamedResult__ValueAssignment_2 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3986:1: ( ( rule__NamedResult__ValueAssignment_2 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3986:1: ( ( rule__NamedResult__ValueAssignment_2 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3987:1: ( rule__NamedResult__ValueAssignment_2 )
            {
             before(grammarAccess.getNamedResultAccess().getValueAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3988:1: ( rule__NamedResult__ValueAssignment_2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3988:2: rule__NamedResult__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__NamedResult__ValueAssignment_2_in_rule__NamedResult__Group__2__Impl8166);
            rule__NamedResult__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getNamedResultAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedResult__Group__2__Impl"


    // $ANTLR start "rule__Call__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4004:1: rule__Call__Group__0 : rule__Call__Group__0__Impl rule__Call__Group__1 ;
    public final void rule__Call__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4008:1: ( rule__Call__Group__0__Impl rule__Call__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4009:2: rule__Call__Group__0__Impl rule__Call__Group__1
            {
            pushFollow(FOLLOW_rule__Call__Group__0__Impl_in_rule__Call__Group__08202);
            rule__Call__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group__1_in_rule__Call__Group__08205);
            rule__Call__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__Group__0"


    // $ANTLR start "rule__Call__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4016:1: rule__Call__Group__0__Impl : ( 'call' ) ;
    public final void rule__Call__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4020:1: ( ( 'call' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4021:1: ( 'call' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4021:1: ( 'call' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4022:1: 'call'
            {
             before(grammarAccess.getCallAccess().getCallKeyword_0()); 
            match(input,37,FOLLOW_37_in_rule__Call__Group__0__Impl8233); 
             after(grammarAccess.getCallAccess().getCallKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__Group__0__Impl"


    // $ANTLR start "rule__Call__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4035:1: rule__Call__Group__1 : rule__Call__Group__1__Impl rule__Call__Group__2 ;
    public final void rule__Call__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4039:1: ( rule__Call__Group__1__Impl rule__Call__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4040:2: rule__Call__Group__1__Impl rule__Call__Group__2
            {
            pushFollow(FOLLOW_rule__Call__Group__1__Impl_in_rule__Call__Group__18264);
            rule__Call__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group__2_in_rule__Call__Group__18267);
            rule__Call__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__Group__1"


    // $ANTLR start "rule__Call__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4047:1: rule__Call__Group__1__Impl : ( ( rule__Call__MultiplierAssignment_1 )? ) ;
    public final void rule__Call__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4051:1: ( ( ( rule__Call__MultiplierAssignment_1 )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4052:1: ( ( rule__Call__MultiplierAssignment_1 )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4052:1: ( ( rule__Call__MultiplierAssignment_1 )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4053:1: ( rule__Call__MultiplierAssignment_1 )?
            {
             before(grammarAccess.getCallAccess().getMultiplierAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4054:1: ( rule__Call__MultiplierAssignment_1 )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_INTEGER) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4054:2: rule__Call__MultiplierAssignment_1
                    {
                    pushFollow(FOLLOW_rule__Call__MultiplierAssignment_1_in_rule__Call__Group__1__Impl8294);
                    rule__Call__MultiplierAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCallAccess().getMultiplierAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__Group__1__Impl"


    // $ANTLR start "rule__Call__Group__2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4064:1: rule__Call__Group__2 : rule__Call__Group__2__Impl rule__Call__Group__3 ;
    public final void rule__Call__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4068:1: ( rule__Call__Group__2__Impl rule__Call__Group__3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4069:2: rule__Call__Group__2__Impl rule__Call__Group__3
            {
            pushFollow(FOLLOW_rule__Call__Group__2__Impl_in_rule__Call__Group__28325);
            rule__Call__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group__3_in_rule__Call__Group__28328);
            rule__Call__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__Group__2"


    // $ANTLR start "rule__Call__Group__2__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4076:1: rule__Call__Group__2__Impl : ( ( rule__Call__DefinitionAssignment_2 ) ) ;
    public final void rule__Call__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4080:1: ( ( ( rule__Call__DefinitionAssignment_2 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4081:1: ( ( rule__Call__DefinitionAssignment_2 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4081:1: ( ( rule__Call__DefinitionAssignment_2 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4082:1: ( rule__Call__DefinitionAssignment_2 )
            {
             before(grammarAccess.getCallAccess().getDefinitionAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4083:1: ( rule__Call__DefinitionAssignment_2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4083:2: rule__Call__DefinitionAssignment_2
            {
            pushFollow(FOLLOW_rule__Call__DefinitionAssignment_2_in_rule__Call__Group__2__Impl8355);
            rule__Call__DefinitionAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getCallAccess().getDefinitionAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__Group__2__Impl"


    // $ANTLR start "rule__Call__Group__3"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4093:1: rule__Call__Group__3 : rule__Call__Group__3__Impl rule__Call__Group__4 ;
    public final void rule__Call__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4097:1: ( rule__Call__Group__3__Impl rule__Call__Group__4 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4098:2: rule__Call__Group__3__Impl rule__Call__Group__4
            {
            pushFollow(FOLLOW_rule__Call__Group__3__Impl_in_rule__Call__Group__38385);
            rule__Call__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group__4_in_rule__Call__Group__38388);
            rule__Call__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__Group__3"


    // $ANTLR start "rule__Call__Group__3__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4105:1: rule__Call__Group__3__Impl : ( ( rule__Call__ParametersAssignment_3 )* ) ;
    public final void rule__Call__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4109:1: ( ( ( rule__Call__ParametersAssignment_3 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4110:1: ( ( rule__Call__ParametersAssignment_3 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4110:1: ( ( rule__Call__ParametersAssignment_3 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4111:1: ( rule__Call__ParametersAssignment_3 )*
            {
             before(grammarAccess.getCallAccess().getParametersAssignment_3()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4112:1: ( rule__Call__ParametersAssignment_3 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_ID) ) {
                    int LA32_1 = input.LA(2);

                    if ( (LA32_1==41) ) {
                        alt32=1;
                    }


                }
                else if ( (LA32_0==42) ) {
                    int LA32_2 = input.LA(2);

                    if ( (LA32_2==RULE_ID) ) {
                        int LA32_5 = input.LA(3);

                        if ( (LA32_5==41) ) {
                            alt32=1;
                        }


                    }


                }


                switch (alt32) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4112:2: rule__Call__ParametersAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__Call__ParametersAssignment_3_in_rule__Call__Group__3__Impl8415);
            	    rule__Call__ParametersAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

             after(grammarAccess.getCallAccess().getParametersAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__Group__3__Impl"


    // $ANTLR start "rule__Call__Group__4"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4122:1: rule__Call__Group__4 : rule__Call__Group__4__Impl rule__Call__Group__5 ;
    public final void rule__Call__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4126:1: ( rule__Call__Group__4__Impl rule__Call__Group__5 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4127:2: rule__Call__Group__4__Impl rule__Call__Group__5
            {
            pushFollow(FOLLOW_rule__Call__Group__4__Impl_in_rule__Call__Group__48446);
            rule__Call__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group__5_in_rule__Call__Group__48449);
            rule__Call__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__Group__4"


    // $ANTLR start "rule__Call__Group__4__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4134:1: rule__Call__Group__4__Impl : ( ( rule__Call__ResultsAssignment_4 )* ) ;
    public final void rule__Call__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4138:1: ( ( ( rule__Call__ResultsAssignment_4 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4139:1: ( ( rule__Call__ResultsAssignment_4 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4139:1: ( ( rule__Call__ResultsAssignment_4 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4140:1: ( rule__Call__ResultsAssignment_4 )*
            {
             before(grammarAccess.getCallAccess().getResultsAssignment_4()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4141:1: ( rule__Call__ResultsAssignment_4 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_ID||LA33_0==42) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4141:2: rule__Call__ResultsAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__Call__ResultsAssignment_4_in_rule__Call__Group__4__Impl8476);
            	    rule__Call__ResultsAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

             after(grammarAccess.getCallAccess().getResultsAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__Group__4__Impl"


    // $ANTLR start "rule__Call__Group__5"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4151:1: rule__Call__Group__5 : rule__Call__Group__5__Impl ;
    public final void rule__Call__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4155:1: ( rule__Call__Group__5__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4156:2: rule__Call__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__Call__Group__5__Impl_in_rule__Call__Group__58507);
            rule__Call__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__Group__5"


    // $ANTLR start "rule__Call__Group__5__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4162:1: rule__Call__Group__5__Impl : ( ( rule__Call__Group_5__0 )? ) ;
    public final void rule__Call__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4166:1: ( ( ( rule__Call__Group_5__0 )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4167:1: ( ( rule__Call__Group_5__0 )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4167:1: ( ( rule__Call__Group_5__0 )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4168:1: ( rule__Call__Group_5__0 )?
            {
             before(grammarAccess.getCallAccess().getGroup_5()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4169:1: ( rule__Call__Group_5__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==38) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4169:2: rule__Call__Group_5__0
                    {
                    pushFollow(FOLLOW_rule__Call__Group_5__0_in_rule__Call__Group__5__Impl8534);
                    rule__Call__Group_5__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCallAccess().getGroup_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__Group__5__Impl"


    // $ANTLR start "rule__Call__Group_5__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4191:1: rule__Call__Group_5__0 : rule__Call__Group_5__0__Impl rule__Call__Group_5__1 ;
    public final void rule__Call__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4195:1: ( rule__Call__Group_5__0__Impl rule__Call__Group_5__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4196:2: rule__Call__Group_5__0__Impl rule__Call__Group_5__1
            {
            pushFollow(FOLLOW_rule__Call__Group_5__0__Impl_in_rule__Call__Group_5__08577);
            rule__Call__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group_5__1_in_rule__Call__Group_5__08580);
            rule__Call__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__Group_5__0"


    // $ANTLR start "rule__Call__Group_5__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4203:1: rule__Call__Group_5__0__Impl : ( '->' ) ;
    public final void rule__Call__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4207:1: ( ( '->' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4208:1: ( '->' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4208:1: ( '->' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4209:1: '->'
            {
             before(grammarAccess.getCallAccess().getHyphenMinusGreaterThanSignKeyword_5_0()); 
            match(input,38,FOLLOW_38_in_rule__Call__Group_5__0__Impl8608); 
             after(grammarAccess.getCallAccess().getHyphenMinusGreaterThanSignKeyword_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__Group_5__0__Impl"


    // $ANTLR start "rule__Call__Group_5__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4222:1: rule__Call__Group_5__1 : rule__Call__Group_5__1__Impl ;
    public final void rule__Call__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4226:1: ( rule__Call__Group_5__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4227:2: rule__Call__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__Call__Group_5__1__Impl_in_rule__Call__Group_5__18639);
            rule__Call__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__Group_5__1"


    // $ANTLR start "rule__Call__Group_5__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4233:1: rule__Call__Group_5__1__Impl : ( ( rule__Call__ResultAssignment_5_1 ) ) ;
    public final void rule__Call__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4237:1: ( ( ( rule__Call__ResultAssignment_5_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4238:1: ( ( rule__Call__ResultAssignment_5_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4238:1: ( ( rule__Call__ResultAssignment_5_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4239:1: ( rule__Call__ResultAssignment_5_1 )
            {
             before(grammarAccess.getCallAccess().getResultAssignment_5_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4240:1: ( rule__Call__ResultAssignment_5_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4240:2: rule__Call__ResultAssignment_5_1
            {
            pushFollow(FOLLOW_rule__Call__ResultAssignment_5_1_in_rule__Call__Group_5__1__Impl8666);
            rule__Call__ResultAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getCallAccess().getResultAssignment_5_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__Group_5__1__Impl"


    // $ANTLR start "rule__NamedCallResult__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4254:1: rule__NamedCallResult__Group__0 : rule__NamedCallResult__Group__0__Impl rule__NamedCallResult__Group__1 ;
    public final void rule__NamedCallResult__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4258:1: ( rule__NamedCallResult__Group__0__Impl rule__NamedCallResult__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4259:2: rule__NamedCallResult__Group__0__Impl rule__NamedCallResult__Group__1
            {
            pushFollow(FOLLOW_rule__NamedCallResult__Group__0__Impl_in_rule__NamedCallResult__Group__08700);
            rule__NamedCallResult__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NamedCallResult__Group__1_in_rule__NamedCallResult__Group__08703);
            rule__NamedCallResult__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedCallResult__Group__0"


    // $ANTLR start "rule__NamedCallResult__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4266:1: rule__NamedCallResult__Group__0__Impl : ( ( rule__NamedCallResult__NameAssignment_0 ) ) ;
    public final void rule__NamedCallResult__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4270:1: ( ( ( rule__NamedCallResult__NameAssignment_0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4271:1: ( ( rule__NamedCallResult__NameAssignment_0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4271:1: ( ( rule__NamedCallResult__NameAssignment_0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4272:1: ( rule__NamedCallResult__NameAssignment_0 )
            {
             before(grammarAccess.getNamedCallResultAccess().getNameAssignment_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4273:1: ( rule__NamedCallResult__NameAssignment_0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4273:2: rule__NamedCallResult__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__NamedCallResult__NameAssignment_0_in_rule__NamedCallResult__Group__0__Impl8730);
            rule__NamedCallResult__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getNamedCallResultAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedCallResult__Group__0__Impl"


    // $ANTLR start "rule__NamedCallResult__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4283:1: rule__NamedCallResult__Group__1 : rule__NamedCallResult__Group__1__Impl rule__NamedCallResult__Group__2 ;
    public final void rule__NamedCallResult__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4287:1: ( rule__NamedCallResult__Group__1__Impl rule__NamedCallResult__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4288:2: rule__NamedCallResult__Group__1__Impl rule__NamedCallResult__Group__2
            {
            pushFollow(FOLLOW_rule__NamedCallResult__Group__1__Impl_in_rule__NamedCallResult__Group__18760);
            rule__NamedCallResult__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NamedCallResult__Group__2_in_rule__NamedCallResult__Group__18763);
            rule__NamedCallResult__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedCallResult__Group__1"


    // $ANTLR start "rule__NamedCallResult__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4295:1: rule__NamedCallResult__Group__1__Impl : ( '->' ) ;
    public final void rule__NamedCallResult__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4299:1: ( ( '->' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4300:1: ( '->' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4300:1: ( '->' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4301:1: '->'
            {
             before(grammarAccess.getNamedCallResultAccess().getHyphenMinusGreaterThanSignKeyword_1()); 
            match(input,38,FOLLOW_38_in_rule__NamedCallResult__Group__1__Impl8791); 
             after(grammarAccess.getNamedCallResultAccess().getHyphenMinusGreaterThanSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedCallResult__Group__1__Impl"


    // $ANTLR start "rule__NamedCallResult__Group__2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4314:1: rule__NamedCallResult__Group__2 : rule__NamedCallResult__Group__2__Impl ;
    public final void rule__NamedCallResult__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4318:1: ( rule__NamedCallResult__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4319:2: rule__NamedCallResult__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__NamedCallResult__Group__2__Impl_in_rule__NamedCallResult__Group__28822);
            rule__NamedCallResult__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedCallResult__Group__2"


    // $ANTLR start "rule__NamedCallResult__Group__2__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4325:1: rule__NamedCallResult__Group__2__Impl : ( ( rule__NamedCallResult__TargetAssignment_2 ) ) ;
    public final void rule__NamedCallResult__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4329:1: ( ( ( rule__NamedCallResult__TargetAssignment_2 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4330:1: ( ( rule__NamedCallResult__TargetAssignment_2 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4330:1: ( ( rule__NamedCallResult__TargetAssignment_2 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4331:1: ( rule__NamedCallResult__TargetAssignment_2 )
            {
             before(grammarAccess.getNamedCallResultAccess().getTargetAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4332:1: ( rule__NamedCallResult__TargetAssignment_2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4332:2: rule__NamedCallResult__TargetAssignment_2
            {
            pushFollow(FOLLOW_rule__NamedCallResult__TargetAssignment_2_in_rule__NamedCallResult__Group__2__Impl8849);
            rule__NamedCallResult__TargetAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getNamedCallResultAccess().getTargetAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedCallResult__Group__2__Impl"


    // $ANTLR start "rule__Suite__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4348:1: rule__Suite__Group__0 : rule__Suite__Group__0__Impl rule__Suite__Group__1 ;
    public final void rule__Suite__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4352:1: ( rule__Suite__Group__0__Impl rule__Suite__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4353:2: rule__Suite__Group__0__Impl rule__Suite__Group__1
            {
            pushFollow(FOLLOW_rule__Suite__Group__0__Impl_in_rule__Suite__Group__08885);
            rule__Suite__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Suite__Group__1_in_rule__Suite__Group__08888);
            rule__Suite__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Suite__Group__0"


    // $ANTLR start "rule__Suite__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4360:1: rule__Suite__Group__0__Impl : ( 'suite' ) ;
    public final void rule__Suite__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4364:1: ( ( 'suite' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4365:1: ( 'suite' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4365:1: ( 'suite' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4366:1: 'suite'
            {
             before(grammarAccess.getSuiteAccess().getSuiteKeyword_0()); 
            match(input,39,FOLLOW_39_in_rule__Suite__Group__0__Impl8916); 
             after(grammarAccess.getSuiteAccess().getSuiteKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Suite__Group__0__Impl"


    // $ANTLR start "rule__Suite__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4379:1: rule__Suite__Group__1 : rule__Suite__Group__1__Impl rule__Suite__Group__2 ;
    public final void rule__Suite__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4383:1: ( rule__Suite__Group__1__Impl rule__Suite__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4384:2: rule__Suite__Group__1__Impl rule__Suite__Group__2
            {
            pushFollow(FOLLOW_rule__Suite__Group__1__Impl_in_rule__Suite__Group__18947);
            rule__Suite__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Suite__Group__2_in_rule__Suite__Group__18950);
            rule__Suite__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Suite__Group__1"


    // $ANTLR start "rule__Suite__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4391:1: rule__Suite__Group__1__Impl : ( ( rule__Suite__MultiplierAssignment_1 )? ) ;
    public final void rule__Suite__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4395:1: ( ( ( rule__Suite__MultiplierAssignment_1 )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4396:1: ( ( rule__Suite__MultiplierAssignment_1 )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4396:1: ( ( rule__Suite__MultiplierAssignment_1 )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4397:1: ( rule__Suite__MultiplierAssignment_1 )?
            {
             before(grammarAccess.getSuiteAccess().getMultiplierAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4398:1: ( rule__Suite__MultiplierAssignment_1 )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_INTEGER) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4398:2: rule__Suite__MultiplierAssignment_1
                    {
                    pushFollow(FOLLOW_rule__Suite__MultiplierAssignment_1_in_rule__Suite__Group__1__Impl8977);
                    rule__Suite__MultiplierAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSuiteAccess().getMultiplierAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Suite__Group__1__Impl"


    // $ANTLR start "rule__Suite__Group__2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4408:1: rule__Suite__Group__2 : rule__Suite__Group__2__Impl rule__Suite__Group__3 ;
    public final void rule__Suite__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4412:1: ( rule__Suite__Group__2__Impl rule__Suite__Group__3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4413:2: rule__Suite__Group__2__Impl rule__Suite__Group__3
            {
            pushFollow(FOLLOW_rule__Suite__Group__2__Impl_in_rule__Suite__Group__29008);
            rule__Suite__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Suite__Group__3_in_rule__Suite__Group__29011);
            rule__Suite__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Suite__Group__2"


    // $ANTLR start "rule__Suite__Group__2__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4420:1: rule__Suite__Group__2__Impl : ( ( rule__Suite__DefinitionAssignment_2 ) ) ;
    public final void rule__Suite__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4424:1: ( ( ( rule__Suite__DefinitionAssignment_2 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4425:1: ( ( rule__Suite__DefinitionAssignment_2 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4425:1: ( ( rule__Suite__DefinitionAssignment_2 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4426:1: ( rule__Suite__DefinitionAssignment_2 )
            {
             before(grammarAccess.getSuiteAccess().getDefinitionAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4427:1: ( rule__Suite__DefinitionAssignment_2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4427:2: rule__Suite__DefinitionAssignment_2
            {
            pushFollow(FOLLOW_rule__Suite__DefinitionAssignment_2_in_rule__Suite__Group__2__Impl9038);
            rule__Suite__DefinitionAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSuiteAccess().getDefinitionAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Suite__Group__2__Impl"


    // $ANTLR start "rule__Suite__Group__3"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4437:1: rule__Suite__Group__3 : rule__Suite__Group__3__Impl rule__Suite__Group__4 ;
    public final void rule__Suite__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4441:1: ( rule__Suite__Group__3__Impl rule__Suite__Group__4 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4442:2: rule__Suite__Group__3__Impl rule__Suite__Group__4
            {
            pushFollow(FOLLOW_rule__Suite__Group__3__Impl_in_rule__Suite__Group__39068);
            rule__Suite__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Suite__Group__4_in_rule__Suite__Group__39071);
            rule__Suite__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Suite__Group__3"


    // $ANTLR start "rule__Suite__Group__3__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4449:1: rule__Suite__Group__3__Impl : ( ( rule__Suite__ParametersAssignment_3 )* ) ;
    public final void rule__Suite__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4453:1: ( ( ( rule__Suite__ParametersAssignment_3 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4454:1: ( ( rule__Suite__ParametersAssignment_3 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4454:1: ( ( rule__Suite__ParametersAssignment_3 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4455:1: ( rule__Suite__ParametersAssignment_3 )*
            {
             before(grammarAccess.getSuiteAccess().getParametersAssignment_3()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4456:1: ( rule__Suite__ParametersAssignment_3 )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==RULE_ID) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4456:2: rule__Suite__ParametersAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__Suite__ParametersAssignment_3_in_rule__Suite__Group__3__Impl9098);
            	    rule__Suite__ParametersAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

             after(grammarAccess.getSuiteAccess().getParametersAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Suite__Group__3__Impl"


    // $ANTLR start "rule__Suite__Group__4"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4466:1: rule__Suite__Group__4 : rule__Suite__Group__4__Impl ;
    public final void rule__Suite__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4470:1: ( rule__Suite__Group__4__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4471:2: rule__Suite__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Suite__Group__4__Impl_in_rule__Suite__Group__49129);
            rule__Suite__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Suite__Group__4"


    // $ANTLR start "rule__Suite__Group__4__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4477:1: rule__Suite__Group__4__Impl : ( ( rule__Suite__Group_4__0 )? ) ;
    public final void rule__Suite__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4481:1: ( ( ( rule__Suite__Group_4__0 )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4482:1: ( ( rule__Suite__Group_4__0 )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4482:1: ( ( rule__Suite__Group_4__0 )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4483:1: ( rule__Suite__Group_4__0 )?
            {
             before(grammarAccess.getSuiteAccess().getGroup_4()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4484:1: ( rule__Suite__Group_4__0 )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==40) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4484:2: rule__Suite__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Suite__Group_4__0_in_rule__Suite__Group__4__Impl9156);
                    rule__Suite__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSuiteAccess().getGroup_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Suite__Group__4__Impl"


    // $ANTLR start "rule__Suite__Group_4__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4504:1: rule__Suite__Group_4__0 : rule__Suite__Group_4__0__Impl rule__Suite__Group_4__1 ;
    public final void rule__Suite__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4508:1: ( rule__Suite__Group_4__0__Impl rule__Suite__Group_4__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4509:2: rule__Suite__Group_4__0__Impl rule__Suite__Group_4__1
            {
            pushFollow(FOLLOW_rule__Suite__Group_4__0__Impl_in_rule__Suite__Group_4__09197);
            rule__Suite__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Suite__Group_4__1_in_rule__Suite__Group_4__09200);
            rule__Suite__Group_4__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Suite__Group_4__0"


    // $ANTLR start "rule__Suite__Group_4__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4516:1: rule__Suite__Group_4__0__Impl : ( 'on' ) ;
    public final void rule__Suite__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4520:1: ( ( 'on' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4521:1: ( 'on' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4521:1: ( 'on' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4522:1: 'on'
            {
             before(grammarAccess.getSuiteAccess().getOnKeyword_4_0()); 
            match(input,40,FOLLOW_40_in_rule__Suite__Group_4__0__Impl9228); 
             after(grammarAccess.getSuiteAccess().getOnKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Suite__Group_4__0__Impl"


    // $ANTLR start "rule__Suite__Group_4__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4535:1: rule__Suite__Group_4__1 : rule__Suite__Group_4__1__Impl ;
    public final void rule__Suite__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4539:1: ( rule__Suite__Group_4__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4540:2: rule__Suite__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Suite__Group_4__1__Impl_in_rule__Suite__Group_4__19259);
            rule__Suite__Group_4__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Suite__Group_4__1"


    // $ANTLR start "rule__Suite__Group_4__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4546:1: rule__Suite__Group_4__1__Impl : ( ( rule__Suite__ForkAssignment_4_1 ) ) ;
    public final void rule__Suite__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4550:1: ( ( ( rule__Suite__ForkAssignment_4_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4551:1: ( ( rule__Suite__ForkAssignment_4_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4551:1: ( ( rule__Suite__ForkAssignment_4_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4552:1: ( rule__Suite__ForkAssignment_4_1 )
            {
             before(grammarAccess.getSuiteAccess().getForkAssignment_4_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4553:1: ( rule__Suite__ForkAssignment_4_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4553:2: rule__Suite__ForkAssignment_4_1
            {
            pushFollow(FOLLOW_rule__Suite__ForkAssignment_4_1_in_rule__Suite__Group_4__1__Impl9286);
            rule__Suite__ForkAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getSuiteAccess().getForkAssignment_4_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Suite__Group_4__1__Impl"


    // $ANTLR start "rule__SuiteParameter__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4567:1: rule__SuiteParameter__Group__0 : rule__SuiteParameter__Group__0__Impl rule__SuiteParameter__Group__1 ;
    public final void rule__SuiteParameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4571:1: ( rule__SuiteParameter__Group__0__Impl rule__SuiteParameter__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4572:2: rule__SuiteParameter__Group__0__Impl rule__SuiteParameter__Group__1
            {
            pushFollow(FOLLOW_rule__SuiteParameter__Group__0__Impl_in_rule__SuiteParameter__Group__09320);
            rule__SuiteParameter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteParameter__Group__1_in_rule__SuiteParameter__Group__09323);
            rule__SuiteParameter__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteParameter__Group__0"


    // $ANTLR start "rule__SuiteParameter__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4579:1: rule__SuiteParameter__Group__0__Impl : ( ( rule__SuiteParameter__NameAssignment_0 ) ) ;
    public final void rule__SuiteParameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4583:1: ( ( ( rule__SuiteParameter__NameAssignment_0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4584:1: ( ( rule__SuiteParameter__NameAssignment_0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4584:1: ( ( rule__SuiteParameter__NameAssignment_0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4585:1: ( rule__SuiteParameter__NameAssignment_0 )
            {
             before(grammarAccess.getSuiteParameterAccess().getNameAssignment_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4586:1: ( rule__SuiteParameter__NameAssignment_0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4586:2: rule__SuiteParameter__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__SuiteParameter__NameAssignment_0_in_rule__SuiteParameter__Group__0__Impl9350);
            rule__SuiteParameter__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getSuiteParameterAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteParameter__Group__0__Impl"


    // $ANTLR start "rule__SuiteParameter__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4596:1: rule__SuiteParameter__Group__1 : rule__SuiteParameter__Group__1__Impl rule__SuiteParameter__Group__2 ;
    public final void rule__SuiteParameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4600:1: ( rule__SuiteParameter__Group__1__Impl rule__SuiteParameter__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4601:2: rule__SuiteParameter__Group__1__Impl rule__SuiteParameter__Group__2
            {
            pushFollow(FOLLOW_rule__SuiteParameter__Group__1__Impl_in_rule__SuiteParameter__Group__19380);
            rule__SuiteParameter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteParameter__Group__2_in_rule__SuiteParameter__Group__19383);
            rule__SuiteParameter__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteParameter__Group__1"


    // $ANTLR start "rule__SuiteParameter__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4608:1: rule__SuiteParameter__Group__1__Impl : ( ':' ) ;
    public final void rule__SuiteParameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4612:1: ( ( ':' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4613:1: ( ':' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4613:1: ( ':' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4614:1: ':'
            {
             before(grammarAccess.getSuiteParameterAccess().getColonKeyword_1()); 
            match(input,41,FOLLOW_41_in_rule__SuiteParameter__Group__1__Impl9411); 
             after(grammarAccess.getSuiteParameterAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteParameter__Group__1__Impl"


    // $ANTLR start "rule__SuiteParameter__Group__2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4627:1: rule__SuiteParameter__Group__2 : rule__SuiteParameter__Group__2__Impl ;
    public final void rule__SuiteParameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4631:1: ( rule__SuiteParameter__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4632:2: rule__SuiteParameter__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__SuiteParameter__Group__2__Impl_in_rule__SuiteParameter__Group__29442);
            rule__SuiteParameter__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteParameter__Group__2"


    // $ANTLR start "rule__SuiteParameter__Group__2__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4638:1: rule__SuiteParameter__Group__2__Impl : ( ( rule__SuiteParameter__ValueAssignment_2 ) ) ;
    public final void rule__SuiteParameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4642:1: ( ( ( rule__SuiteParameter__ValueAssignment_2 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4643:1: ( ( rule__SuiteParameter__ValueAssignment_2 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4643:1: ( ( rule__SuiteParameter__ValueAssignment_2 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4644:1: ( rule__SuiteParameter__ValueAssignment_2 )
            {
             before(grammarAccess.getSuiteParameterAccess().getValueAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4645:1: ( rule__SuiteParameter__ValueAssignment_2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4645:2: rule__SuiteParameter__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__SuiteParameter__ValueAssignment_2_in_rule__SuiteParameter__Group__2__Impl9469);
            rule__SuiteParameter__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getSuiteParameterAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteParameter__Group__2__Impl"


    // $ANTLR start "rule__Parameter__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4661:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4665:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4666:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
            {
            pushFollow(FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__09505);
            rule__Parameter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__09508);
            rule__Parameter__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__0"


    // $ANTLR start "rule__Parameter__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4673:1: rule__Parameter__Group__0__Impl : ( ( rule__Parameter__NameAssignment_0 ) ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4677:1: ( ( ( rule__Parameter__NameAssignment_0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4678:1: ( ( rule__Parameter__NameAssignment_0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4678:1: ( ( rule__Parameter__NameAssignment_0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4679:1: ( rule__Parameter__NameAssignment_0 )
            {
             before(grammarAccess.getParameterAccess().getNameAssignment_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4680:1: ( rule__Parameter__NameAssignment_0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4680:2: rule__Parameter__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Parameter__NameAssignment_0_in_rule__Parameter__Group__0__Impl9535);
            rule__Parameter__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__0__Impl"


    // $ANTLR start "rule__Parameter__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4690:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl rule__Parameter__Group__2 ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4694:1: ( rule__Parameter__Group__1__Impl rule__Parameter__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4695:2: rule__Parameter__Group__1__Impl rule__Parameter__Group__2
            {
            pushFollow(FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__19565);
            rule__Parameter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Parameter__Group__2_in_rule__Parameter__Group__19568);
            rule__Parameter__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__1"


    // $ANTLR start "rule__Parameter__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4702:1: rule__Parameter__Group__1__Impl : ( ':' ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4706:1: ( ( ':' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4707:1: ( ':' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4707:1: ( ':' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4708:1: ':'
            {
             before(grammarAccess.getParameterAccess().getColonKeyword_1()); 
            match(input,41,FOLLOW_41_in_rule__Parameter__Group__1__Impl9596); 
             after(grammarAccess.getParameterAccess().getColonKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__1__Impl"


    // $ANTLR start "rule__Parameter__Group__2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4721:1: rule__Parameter__Group__2 : rule__Parameter__Group__2__Impl ;
    public final void rule__Parameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4725:1: ( rule__Parameter__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4726:2: rule__Parameter__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Parameter__Group__2__Impl_in_rule__Parameter__Group__29627);
            rule__Parameter__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__2"


    // $ANTLR start "rule__Parameter__Group__2__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4732:1: rule__Parameter__Group__2__Impl : ( ( rule__Parameter__ValueAssignment_2 ) ) ;
    public final void rule__Parameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4736:1: ( ( ( rule__Parameter__ValueAssignment_2 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4737:1: ( ( rule__Parameter__ValueAssignment_2 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4737:1: ( ( rule__Parameter__ValueAssignment_2 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4738:1: ( rule__Parameter__ValueAssignment_2 )
            {
             before(grammarAccess.getParameterAccess().getValueAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4739:1: ( rule__Parameter__ValueAssignment_2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4739:2: rule__Parameter__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__Parameter__ValueAssignment_2_in_rule__Parameter__Group__2__Impl9654);
            rule__Parameter__ValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getParameterAccess().getValueAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__Group__2__Impl"


    // $ANTLR start "rule__ArbitraryParameterOrResultName__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4755:1: rule__ArbitraryParameterOrResultName__Group__0 : rule__ArbitraryParameterOrResultName__Group__0__Impl rule__ArbitraryParameterOrResultName__Group__1 ;
    public final void rule__ArbitraryParameterOrResultName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4759:1: ( rule__ArbitraryParameterOrResultName__Group__0__Impl rule__ArbitraryParameterOrResultName__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4760:2: rule__ArbitraryParameterOrResultName__Group__0__Impl rule__ArbitraryParameterOrResultName__Group__1
            {
            pushFollow(FOLLOW_rule__ArbitraryParameterOrResultName__Group__0__Impl_in_rule__ArbitraryParameterOrResultName__Group__09690);
            rule__ArbitraryParameterOrResultName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ArbitraryParameterOrResultName__Group__1_in_rule__ArbitraryParameterOrResultName__Group__09693);
            rule__ArbitraryParameterOrResultName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArbitraryParameterOrResultName__Group__0"


    // $ANTLR start "rule__ArbitraryParameterOrResultName__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4767:1: rule__ArbitraryParameterOrResultName__Group__0__Impl : ( '+' ) ;
    public final void rule__ArbitraryParameterOrResultName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4771:1: ( ( '+' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4772:1: ( '+' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4772:1: ( '+' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4773:1: '+'
            {
             before(grammarAccess.getArbitraryParameterOrResultNameAccess().getPlusSignKeyword_0()); 
            match(input,42,FOLLOW_42_in_rule__ArbitraryParameterOrResultName__Group__0__Impl9721); 
             after(grammarAccess.getArbitraryParameterOrResultNameAccess().getPlusSignKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArbitraryParameterOrResultName__Group__0__Impl"


    // $ANTLR start "rule__ArbitraryParameterOrResultName__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4786:1: rule__ArbitraryParameterOrResultName__Group__1 : rule__ArbitraryParameterOrResultName__Group__1__Impl ;
    public final void rule__ArbitraryParameterOrResultName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4790:1: ( rule__ArbitraryParameterOrResultName__Group__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4791:2: rule__ArbitraryParameterOrResultName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ArbitraryParameterOrResultName__Group__1__Impl_in_rule__ArbitraryParameterOrResultName__Group__19752);
            rule__ArbitraryParameterOrResultName__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArbitraryParameterOrResultName__Group__1"


    // $ANTLR start "rule__ArbitraryParameterOrResultName__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4797:1: rule__ArbitraryParameterOrResultName__Group__1__Impl : ( ( rule__ArbitraryParameterOrResultName__IdentifierAssignment_1 ) ) ;
    public final void rule__ArbitraryParameterOrResultName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4801:1: ( ( ( rule__ArbitraryParameterOrResultName__IdentifierAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4802:1: ( ( rule__ArbitraryParameterOrResultName__IdentifierAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4802:1: ( ( rule__ArbitraryParameterOrResultName__IdentifierAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4803:1: ( rule__ArbitraryParameterOrResultName__IdentifierAssignment_1 )
            {
             before(grammarAccess.getArbitraryParameterOrResultNameAccess().getIdentifierAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4804:1: ( rule__ArbitraryParameterOrResultName__IdentifierAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4804:2: rule__ArbitraryParameterOrResultName__IdentifierAssignment_1
            {
            pushFollow(FOLLOW_rule__ArbitraryParameterOrResultName__IdentifierAssignment_1_in_rule__ArbitraryParameterOrResultName__Group__1__Impl9779);
            rule__ArbitraryParameterOrResultName__IdentifierAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getArbitraryParameterOrResultNameAccess().getIdentifierAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArbitraryParameterOrResultName__Group__1__Impl"


    // $ANTLR start "rule__ValueOrEnumValueCollection__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4818:1: rule__ValueOrEnumValueCollection__Group__0 : rule__ValueOrEnumValueCollection__Group__0__Impl rule__ValueOrEnumValueCollection__Group__1 ;
    public final void rule__ValueOrEnumValueCollection__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4822:1: ( rule__ValueOrEnumValueCollection__Group__0__Impl rule__ValueOrEnumValueCollection__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4823:2: rule__ValueOrEnumValueCollection__Group__0__Impl rule__ValueOrEnumValueCollection__Group__1
            {
            pushFollow(FOLLOW_rule__ValueOrEnumValueCollection__Group__0__Impl_in_rule__ValueOrEnumValueCollection__Group__09813);
            rule__ValueOrEnumValueCollection__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ValueOrEnumValueCollection__Group__1_in_rule__ValueOrEnumValueCollection__Group__09816);
            rule__ValueOrEnumValueCollection__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueOrEnumValueCollection__Group__0"


    // $ANTLR start "rule__ValueOrEnumValueCollection__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4830:1: rule__ValueOrEnumValueCollection__Group__0__Impl : ( ( rule__ValueOrEnumValueCollection__ValueAssignment_0 ) ) ;
    public final void rule__ValueOrEnumValueCollection__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4834:1: ( ( ( rule__ValueOrEnumValueCollection__ValueAssignment_0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4835:1: ( ( rule__ValueOrEnumValueCollection__ValueAssignment_0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4835:1: ( ( rule__ValueOrEnumValueCollection__ValueAssignment_0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4836:1: ( rule__ValueOrEnumValueCollection__ValueAssignment_0 )
            {
             before(grammarAccess.getValueOrEnumValueCollectionAccess().getValueAssignment_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4837:1: ( rule__ValueOrEnumValueCollection__ValueAssignment_0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4837:2: rule__ValueOrEnumValueCollection__ValueAssignment_0
            {
            pushFollow(FOLLOW_rule__ValueOrEnumValueCollection__ValueAssignment_0_in_rule__ValueOrEnumValueCollection__Group__0__Impl9843);
            rule__ValueOrEnumValueCollection__ValueAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getValueOrEnumValueCollectionAccess().getValueAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueOrEnumValueCollection__Group__0__Impl"


    // $ANTLR start "rule__ValueOrEnumValueCollection__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4847:1: rule__ValueOrEnumValueCollection__Group__1 : rule__ValueOrEnumValueCollection__Group__1__Impl ;
    public final void rule__ValueOrEnumValueCollection__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4851:1: ( rule__ValueOrEnumValueCollection__Group__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4852:2: rule__ValueOrEnumValueCollection__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ValueOrEnumValueCollection__Group__1__Impl_in_rule__ValueOrEnumValueCollection__Group__19873);
            rule__ValueOrEnumValueCollection__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueOrEnumValueCollection__Group__1"


    // $ANTLR start "rule__ValueOrEnumValueCollection__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4858:1: rule__ValueOrEnumValueCollection__Group__1__Impl : ( ( rule__ValueOrEnumValueCollection__Group_1__0 )* ) ;
    public final void rule__ValueOrEnumValueCollection__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4862:1: ( ( ( rule__ValueOrEnumValueCollection__Group_1__0 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4863:1: ( ( rule__ValueOrEnumValueCollection__Group_1__0 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4863:1: ( ( rule__ValueOrEnumValueCollection__Group_1__0 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4864:1: ( rule__ValueOrEnumValueCollection__Group_1__0 )*
            {
             before(grammarAccess.getValueOrEnumValueCollectionAccess().getGroup_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4865:1: ( rule__ValueOrEnumValueCollection__Group_1__0 )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==43) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4865:2: rule__ValueOrEnumValueCollection__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ValueOrEnumValueCollection__Group_1__0_in_rule__ValueOrEnumValueCollection__Group__1__Impl9900);
            	    rule__ValueOrEnumValueCollection__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

             after(grammarAccess.getValueOrEnumValueCollectionAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueOrEnumValueCollection__Group__1__Impl"


    // $ANTLR start "rule__ValueOrEnumValueCollection__Group_1__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4879:1: rule__ValueOrEnumValueCollection__Group_1__0 : rule__ValueOrEnumValueCollection__Group_1__0__Impl rule__ValueOrEnumValueCollection__Group_1__1 ;
    public final void rule__ValueOrEnumValueCollection__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4883:1: ( rule__ValueOrEnumValueCollection__Group_1__0__Impl rule__ValueOrEnumValueCollection__Group_1__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4884:2: rule__ValueOrEnumValueCollection__Group_1__0__Impl rule__ValueOrEnumValueCollection__Group_1__1
            {
            pushFollow(FOLLOW_rule__ValueOrEnumValueCollection__Group_1__0__Impl_in_rule__ValueOrEnumValueCollection__Group_1__09935);
            rule__ValueOrEnumValueCollection__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ValueOrEnumValueCollection__Group_1__1_in_rule__ValueOrEnumValueCollection__Group_1__09938);
            rule__ValueOrEnumValueCollection__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueOrEnumValueCollection__Group_1__0"


    // $ANTLR start "rule__ValueOrEnumValueCollection__Group_1__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4891:1: rule__ValueOrEnumValueCollection__Group_1__0__Impl : ( ',' ) ;
    public final void rule__ValueOrEnumValueCollection__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4895:1: ( ( ',' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4896:1: ( ',' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4896:1: ( ',' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4897:1: ','
            {
             before(grammarAccess.getValueOrEnumValueCollectionAccess().getCommaKeyword_1_0()); 
            match(input,43,FOLLOW_43_in_rule__ValueOrEnumValueCollection__Group_1__0__Impl9966); 
             after(grammarAccess.getValueOrEnumValueCollectionAccess().getCommaKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueOrEnumValueCollection__Group_1__0__Impl"


    // $ANTLR start "rule__ValueOrEnumValueCollection__Group_1__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4910:1: rule__ValueOrEnumValueCollection__Group_1__1 : rule__ValueOrEnumValueCollection__Group_1__1__Impl ;
    public final void rule__ValueOrEnumValueCollection__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4914:1: ( rule__ValueOrEnumValueCollection__Group_1__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4915:2: rule__ValueOrEnumValueCollection__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ValueOrEnumValueCollection__Group_1__1__Impl_in_rule__ValueOrEnumValueCollection__Group_1__19997);
            rule__ValueOrEnumValueCollection__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueOrEnumValueCollection__Group_1__1"


    // $ANTLR start "rule__ValueOrEnumValueCollection__Group_1__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4921:1: rule__ValueOrEnumValueCollection__Group_1__1__Impl : ( ( rule__ValueOrEnumValueCollection__MoreValuesAssignment_1_1 ) ) ;
    public final void rule__ValueOrEnumValueCollection__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4925:1: ( ( ( rule__ValueOrEnumValueCollection__MoreValuesAssignment_1_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4926:1: ( ( rule__ValueOrEnumValueCollection__MoreValuesAssignment_1_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4926:1: ( ( rule__ValueOrEnumValueCollection__MoreValuesAssignment_1_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4927:1: ( rule__ValueOrEnumValueCollection__MoreValuesAssignment_1_1 )
            {
             before(grammarAccess.getValueOrEnumValueCollectionAccess().getMoreValuesAssignment_1_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4928:1: ( rule__ValueOrEnumValueCollection__MoreValuesAssignment_1_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4928:2: rule__ValueOrEnumValueCollection__MoreValuesAssignment_1_1
            {
            pushFollow(FOLLOW_rule__ValueOrEnumValueCollection__MoreValuesAssignment_1_1_in_rule__ValueOrEnumValueCollection__Group_1__1__Impl10024);
            rule__ValueOrEnumValueCollection__MoreValuesAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getValueOrEnumValueCollectionAccess().getMoreValuesAssignment_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueOrEnumValueCollection__Group_1__1__Impl"


    // $ANTLR start "rule__NullValue__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4942:1: rule__NullValue__Group__0 : rule__NullValue__Group__0__Impl rule__NullValue__Group__1 ;
    public final void rule__NullValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4946:1: ( rule__NullValue__Group__0__Impl rule__NullValue__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4947:2: rule__NullValue__Group__0__Impl rule__NullValue__Group__1
            {
            pushFollow(FOLLOW_rule__NullValue__Group__0__Impl_in_rule__NullValue__Group__010058);
            rule__NullValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NullValue__Group__1_in_rule__NullValue__Group__010061);
            rule__NullValue__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NullValue__Group__0"


    // $ANTLR start "rule__NullValue__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4954:1: rule__NullValue__Group__0__Impl : ( () ) ;
    public final void rule__NullValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4958:1: ( ( () ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4959:1: ( () )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4959:1: ( () )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4960:1: ()
            {
             before(grammarAccess.getNullValueAccess().getNullAction_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4961:1: ()
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4963:1: 
            {
            }

             after(grammarAccess.getNullValueAccess().getNullAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NullValue__Group__0__Impl"


    // $ANTLR start "rule__NullValue__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4973:1: rule__NullValue__Group__1 : rule__NullValue__Group__1__Impl ;
    public final void rule__NullValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4977:1: ( rule__NullValue__Group__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4978:2: rule__NullValue__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__NullValue__Group__1__Impl_in_rule__NullValue__Group__110119);
            rule__NullValue__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NullValue__Group__1"


    // $ANTLR start "rule__NullValue__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4984:1: rule__NullValue__Group__1__Impl : ( 'null' ) ;
    public final void rule__NullValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4988:1: ( ( 'null' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4989:1: ( 'null' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4989:1: ( 'null' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4990:1: 'null'
            {
             before(grammarAccess.getNullValueAccess().getNullKeyword_1()); 
            match(input,44,FOLLOW_44_in_rule__NullValue__Group__1__Impl10147); 
             after(grammarAccess.getNullValueAccess().getNullKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NullValue__Group__1__Impl"


    // $ANTLR start "rule__MethodReference__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5007:1: rule__MethodReference__Group__0 : rule__MethodReference__Group__0__Impl rule__MethodReference__Group__1 ;
    public final void rule__MethodReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5011:1: ( rule__MethodReference__Group__0__Impl rule__MethodReference__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5012:2: rule__MethodReference__Group__0__Impl rule__MethodReference__Group__1
            {
            pushFollow(FOLLOW_rule__MethodReference__Group__0__Impl_in_rule__MethodReference__Group__010182);
            rule__MethodReference__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodReference__Group__1_in_rule__MethodReference__Group__010185);
            rule__MethodReference__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodReference__Group__0"


    // $ANTLR start "rule__MethodReference__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5019:1: rule__MethodReference__Group__0__Impl : ( ( rule__MethodReference__TypeAssignment_0 ) ) ;
    public final void rule__MethodReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5023:1: ( ( ( rule__MethodReference__TypeAssignment_0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5024:1: ( ( rule__MethodReference__TypeAssignment_0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5024:1: ( ( rule__MethodReference__TypeAssignment_0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5025:1: ( rule__MethodReference__TypeAssignment_0 )
            {
             before(grammarAccess.getMethodReferenceAccess().getTypeAssignment_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5026:1: ( rule__MethodReference__TypeAssignment_0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5026:2: rule__MethodReference__TypeAssignment_0
            {
            pushFollow(FOLLOW_rule__MethodReference__TypeAssignment_0_in_rule__MethodReference__Group__0__Impl10212);
            rule__MethodReference__TypeAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getMethodReferenceAccess().getTypeAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodReference__Group__0__Impl"


    // $ANTLR start "rule__MethodReference__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5036:1: rule__MethodReference__Group__1 : rule__MethodReference__Group__1__Impl rule__MethodReference__Group__2 ;
    public final void rule__MethodReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5040:1: ( rule__MethodReference__Group__1__Impl rule__MethodReference__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5041:2: rule__MethodReference__Group__1__Impl rule__MethodReference__Group__2
            {
            pushFollow(FOLLOW_rule__MethodReference__Group__1__Impl_in_rule__MethodReference__Group__110242);
            rule__MethodReference__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodReference__Group__2_in_rule__MethodReference__Group__110245);
            rule__MethodReference__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodReference__Group__1"


    // $ANTLR start "rule__MethodReference__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5048:1: rule__MethodReference__Group__1__Impl : ( '#' ) ;
    public final void rule__MethodReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5052:1: ( ( '#' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5053:1: ( '#' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5053:1: ( '#' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5054:1: '#'
            {
             before(grammarAccess.getMethodReferenceAccess().getNumberSignKeyword_1()); 
            match(input,45,FOLLOW_45_in_rule__MethodReference__Group__1__Impl10273); 
             after(grammarAccess.getMethodReferenceAccess().getNumberSignKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodReference__Group__1__Impl"


    // $ANTLR start "rule__MethodReference__Group__2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5067:1: rule__MethodReference__Group__2 : rule__MethodReference__Group__2__Impl ;
    public final void rule__MethodReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5071:1: ( rule__MethodReference__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5072:2: rule__MethodReference__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__MethodReference__Group__2__Impl_in_rule__MethodReference__Group__210304);
            rule__MethodReference__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodReference__Group__2"


    // $ANTLR start "rule__MethodReference__Group__2__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5078:1: rule__MethodReference__Group__2__Impl : ( ( rule__MethodReference__MethodAssignment_2 ) ) ;
    public final void rule__MethodReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5082:1: ( ( ( rule__MethodReference__MethodAssignment_2 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5083:1: ( ( rule__MethodReference__MethodAssignment_2 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5083:1: ( ( rule__MethodReference__MethodAssignment_2 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5084:1: ( rule__MethodReference__MethodAssignment_2 )
            {
             before(grammarAccess.getMethodReferenceAccess().getMethodAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5085:1: ( rule__MethodReference__MethodAssignment_2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5085:2: rule__MethodReference__MethodAssignment_2
            {
            pushFollow(FOLLOW_rule__MethodReference__MethodAssignment_2_in_rule__MethodReference__Group__2__Impl10331);
            rule__MethodReference__MethodAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getMethodReferenceAccess().getMethodAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodReference__Group__2__Impl"


    // $ANTLR start "rule__ExecutionMultiplier__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5101:1: rule__ExecutionMultiplier__Group__0 : rule__ExecutionMultiplier__Group__0__Impl rule__ExecutionMultiplier__Group__1 ;
    public final void rule__ExecutionMultiplier__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5105:1: ( rule__ExecutionMultiplier__Group__0__Impl rule__ExecutionMultiplier__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5106:2: rule__ExecutionMultiplier__Group__0__Impl rule__ExecutionMultiplier__Group__1
            {
            pushFollow(FOLLOW_rule__ExecutionMultiplier__Group__0__Impl_in_rule__ExecutionMultiplier__Group__010367);
            rule__ExecutionMultiplier__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExecutionMultiplier__Group__1_in_rule__ExecutionMultiplier__Group__010370);
            rule__ExecutionMultiplier__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExecutionMultiplier__Group__0"


    // $ANTLR start "rule__ExecutionMultiplier__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5113:1: rule__ExecutionMultiplier__Group__0__Impl : ( ( rule__ExecutionMultiplier__CountAssignment_0 ) ) ;
    public final void rule__ExecutionMultiplier__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5117:1: ( ( ( rule__ExecutionMultiplier__CountAssignment_0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5118:1: ( ( rule__ExecutionMultiplier__CountAssignment_0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5118:1: ( ( rule__ExecutionMultiplier__CountAssignment_0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5119:1: ( rule__ExecutionMultiplier__CountAssignment_0 )
            {
             before(grammarAccess.getExecutionMultiplierAccess().getCountAssignment_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5120:1: ( rule__ExecutionMultiplier__CountAssignment_0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5120:2: rule__ExecutionMultiplier__CountAssignment_0
            {
            pushFollow(FOLLOW_rule__ExecutionMultiplier__CountAssignment_0_in_rule__ExecutionMultiplier__Group__0__Impl10397);
            rule__ExecutionMultiplier__CountAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getExecutionMultiplierAccess().getCountAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExecutionMultiplier__Group__0__Impl"


    // $ANTLR start "rule__ExecutionMultiplier__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5130:1: rule__ExecutionMultiplier__Group__1 : rule__ExecutionMultiplier__Group__1__Impl ;
    public final void rule__ExecutionMultiplier__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5134:1: ( rule__ExecutionMultiplier__Group__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5135:2: rule__ExecutionMultiplier__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ExecutionMultiplier__Group__1__Impl_in_rule__ExecutionMultiplier__Group__110427);
            rule__ExecutionMultiplier__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExecutionMultiplier__Group__1"


    // $ANTLR start "rule__ExecutionMultiplier__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5141:1: rule__ExecutionMultiplier__Group__1__Impl : ( '*' ) ;
    public final void rule__ExecutionMultiplier__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5145:1: ( ( '*' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5146:1: ( '*' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5146:1: ( '*' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5147:1: '*'
            {
             before(grammarAccess.getExecutionMultiplierAccess().getAsteriskKeyword_1()); 
            match(input,46,FOLLOW_46_in_rule__ExecutionMultiplier__Group__1__Impl10455); 
             after(grammarAccess.getExecutionMultiplierAccess().getAsteriskKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExecutionMultiplier__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5164:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5168:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5169:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__010490);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__010493);
            rule__QualifiedName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5176:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5180:1: ( ( RULE_ID ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5181:1: ( RULE_ID )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5181:1: ( RULE_ID )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5182:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl10520); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5193:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5197:1: ( rule__QualifiedName__Group__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5198:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__110549);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5204:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5208:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5209:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5209:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5210:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5211:1: ( rule__QualifiedName__Group_1__0 )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==47) ) {
                    int LA39_2 = input.LA(2);

                    if ( (LA39_2==RULE_ID) ) {
                        alt39=1;
                    }


                }


                switch (alt39) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5211:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl10576);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

             after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5225:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5229:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5230:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__010611);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__010614);
            rule__QualifiedName__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5237:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5241:1: ( ( '.' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5242:1: ( '.' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5242:1: ( '.' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5243:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,47,FOLLOW_47_in_rule__QualifiedName__Group_1__0__Impl10642); 
             after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5256:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5260:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5261:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__110673);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5267:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5271:1: ( ( RULE_ID ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5272:1: ( RULE_ID )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5272:1: ( RULE_ID )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5273:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl10700); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__QualifiedJavaClassName__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5288:1: rule__QualifiedJavaClassName__Group__0 : rule__QualifiedJavaClassName__Group__0__Impl rule__QualifiedJavaClassName__Group__1 ;
    public final void rule__QualifiedJavaClassName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5292:1: ( rule__QualifiedJavaClassName__Group__0__Impl rule__QualifiedJavaClassName__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5293:2: rule__QualifiedJavaClassName__Group__0__Impl rule__QualifiedJavaClassName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__0__Impl_in_rule__QualifiedJavaClassName__Group__010733);
            rule__QualifiedJavaClassName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__1_in_rule__QualifiedJavaClassName__Group__010736);
            rule__QualifiedJavaClassName__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedJavaClassName__Group__0"


    // $ANTLR start "rule__QualifiedJavaClassName__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5300:1: rule__QualifiedJavaClassName__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedJavaClassName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5304:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5305:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5305:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5306:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedJavaClassNameAccess().getQualifiedNameParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedJavaClassName__Group__0__Impl10763);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedJavaClassNameAccess().getQualifiedNameParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedJavaClassName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedJavaClassName__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5317:1: rule__QualifiedJavaClassName__Group__1 : rule__QualifiedJavaClassName__Group__1__Impl rule__QualifiedJavaClassName__Group__2 ;
    public final void rule__QualifiedJavaClassName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5321:1: ( rule__QualifiedJavaClassName__Group__1__Impl rule__QualifiedJavaClassName__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5322:2: rule__QualifiedJavaClassName__Group__1__Impl rule__QualifiedJavaClassName__Group__2
            {
            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__1__Impl_in_rule__QualifiedJavaClassName__Group__110792);
            rule__QualifiedJavaClassName__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__2_in_rule__QualifiedJavaClassName__Group__110795);
            rule__QualifiedJavaClassName__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedJavaClassName__Group__1"


    // $ANTLR start "rule__QualifiedJavaClassName__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5329:1: rule__QualifiedJavaClassName__Group__1__Impl : ( '.' ) ;
    public final void rule__QualifiedJavaClassName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5333:1: ( ( '.' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5334:1: ( '.' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5334:1: ( '.' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5335:1: '.'
            {
             before(grammarAccess.getQualifiedJavaClassNameAccess().getFullStopKeyword_1()); 
            match(input,47,FOLLOW_47_in_rule__QualifiedJavaClassName__Group__1__Impl10823); 
             after(grammarAccess.getQualifiedJavaClassNameAccess().getFullStopKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedJavaClassName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedJavaClassName__Group__2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5348:1: rule__QualifiedJavaClassName__Group__2 : rule__QualifiedJavaClassName__Group__2__Impl ;
    public final void rule__QualifiedJavaClassName__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5352:1: ( rule__QualifiedJavaClassName__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5353:2: rule__QualifiedJavaClassName__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__2__Impl_in_rule__QualifiedJavaClassName__Group__210854);
            rule__QualifiedJavaClassName__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedJavaClassName__Group__2"


    // $ANTLR start "rule__QualifiedJavaClassName__Group__2__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5359:1: rule__QualifiedJavaClassName__Group__2__Impl : ( RULE_UPPERCASE_ID ) ;
    public final void rule__QualifiedJavaClassName__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5363:1: ( ( RULE_UPPERCASE_ID ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5364:1: ( RULE_UPPERCASE_ID )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5364:1: ( RULE_UPPERCASE_ID )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5365:1: RULE_UPPERCASE_ID
            {
             before(grammarAccess.getQualifiedJavaClassNameAccess().getUPPERCASE_IDTerminalRuleCall_2()); 
            match(input,RULE_UPPERCASE_ID,FOLLOW_RULE_UPPERCASE_ID_in_rule__QualifiedJavaClassName__Group__2__Impl10881); 
             after(grammarAccess.getQualifiedJavaClassNameAccess().getUPPERCASE_IDTerminalRuleCall_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedJavaClassName__Group__2__Impl"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5382:1: rule__QualifiedNameWithWildcard__Group__0 : rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 ;
    public final void rule__QualifiedNameWithWildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5386:1: ( rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5387:2: rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__0__Impl_in_rule__QualifiedNameWithWildcard__Group__010916);
            rule__QualifiedNameWithWildcard__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__1_in_rule__QualifiedNameWithWildcard__Group__010919);
            rule__QualifiedNameWithWildcard__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__0"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5394:1: rule__QualifiedNameWithWildcard__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedNameWithWildcard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5398:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5399:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5399:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5400:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildcard__Group__0__Impl10946);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__0__Impl"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5411:1: rule__QualifiedNameWithWildcard__Group__1 : rule__QualifiedNameWithWildcard__Group__1__Impl ;
    public final void rule__QualifiedNameWithWildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5415:1: ( rule__QualifiedNameWithWildcard__Group__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5416:2: rule__QualifiedNameWithWildcard__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__1__Impl_in_rule__QualifiedNameWithWildcard__Group__110975);
            rule__QualifiedNameWithWildcard__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__1"


    // $ANTLR start "rule__QualifiedNameWithWildcard__Group__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5422:1: rule__QualifiedNameWithWildcard__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__QualifiedNameWithWildcard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5426:1: ( ( ( '.*' )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5427:1: ( ( '.*' )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5427:1: ( ( '.*' )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5428:1: ( '.*' )?
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5429:1: ( '.*' )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==48) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5430:2: '.*'
                    {
                    match(input,48,FOLLOW_48_in_rule__QualifiedNameWithWildcard__Group__1__Impl11004); 

                    }
                    break;

            }

             after(grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedNameWithWildcard__Group__1__Impl"


    // $ANTLR start "rule__Model__StatementsAssignment"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5446:1: rule__Model__StatementsAssignment : ( ruleStatement ) ;
    public final void rule__Model__StatementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5450:1: ( ( ruleStatement ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5451:1: ( ruleStatement )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5451:1: ( ruleStatement )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5452:1: ruleStatement
            {
             before(grammarAccess.getModelAccess().getStatementsStatementParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleStatement_in_rule__Model__StatementsAssignment11046);
            ruleStatement();

            state._fsp--;

             after(grammarAccess.getModelAccess().getStatementsStatementParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Model__StatementsAssignment"


    // $ANTLR start "rule__VisibleSingleLineComment__ContentAssignment"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5461:1: rule__VisibleSingleLineComment__ContentAssignment : ( RULE_SL_VISIBLE_COMMENT ) ;
    public final void rule__VisibleSingleLineComment__ContentAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5465:1: ( ( RULE_SL_VISIBLE_COMMENT ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5466:1: ( RULE_SL_VISIBLE_COMMENT )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5466:1: ( RULE_SL_VISIBLE_COMMENT )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5467:1: RULE_SL_VISIBLE_COMMENT
            {
             before(grammarAccess.getVisibleSingleLineCommentAccess().getContentSL_VISIBLE_COMMENTTerminalRuleCall_0()); 
            match(input,RULE_SL_VISIBLE_COMMENT,FOLLOW_RULE_SL_VISIBLE_COMMENT_in_rule__VisibleSingleLineComment__ContentAssignment11077); 
             after(grammarAccess.getVisibleSingleLineCommentAccess().getContentSL_VISIBLE_COMMENTTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VisibleSingleLineComment__ContentAssignment"


    // $ANTLR start "rule__VisibleMultiLineComment__ContentAssignment"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5476:1: rule__VisibleMultiLineComment__ContentAssignment : ( RULE_ML_VISIBLE_COMMENT ) ;
    public final void rule__VisibleMultiLineComment__ContentAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5480:1: ( ( RULE_ML_VISIBLE_COMMENT ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5481:1: ( RULE_ML_VISIBLE_COMMENT )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5481:1: ( RULE_ML_VISIBLE_COMMENT )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5482:1: RULE_ML_VISIBLE_COMMENT
            {
             before(grammarAccess.getVisibleMultiLineCommentAccess().getContentML_VISIBLE_COMMENTTerminalRuleCall_0()); 
            match(input,RULE_ML_VISIBLE_COMMENT,FOLLOW_RULE_ML_VISIBLE_COMMENT_in_rule__VisibleMultiLineComment__ContentAssignment11108); 
             after(grammarAccess.getVisibleMultiLineCommentAccess().getContentML_VISIBLE_COMMENTTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VisibleMultiLineComment__ContentAssignment"


    // $ANTLR start "rule__PackageDefinition__NameAssignment_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5491:1: rule__PackageDefinition__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__PackageDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5495:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5496:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5496:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5497:1: ruleQualifiedName
            {
             before(grammarAccess.getPackageDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__PackageDefinition__NameAssignment_111139);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getPackageDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__NameAssignment_1"


    // $ANTLR start "rule__PackageDefinition__StatementsAssignment_3"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5506:1: rule__PackageDefinition__StatementsAssignment_3 : ( rulePackageStatement ) ;
    public final void rule__PackageDefinition__StatementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5510:1: ( ( rulePackageStatement ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5511:1: ( rulePackageStatement )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5511:1: ( rulePackageStatement )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5512:1: rulePackageStatement
            {
             before(grammarAccess.getPackageDefinitionAccess().getStatementsPackageStatementParserRuleCall_3_0()); 
            pushFollow(FOLLOW_rulePackageStatement_in_rule__PackageDefinition__StatementsAssignment_311170);
            rulePackageStatement();

            state._fsp--;

             after(grammarAccess.getPackageDefinitionAccess().getStatementsPackageStatementParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PackageDefinition__StatementsAssignment_3"


    // $ANTLR start "rule__Import__ImportedNamespaceAssignment_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5521:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleQualifiedNameWithWildcard ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5525:1: ( ( ruleQualifiedNameWithWildcard ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5526:1: ( ruleQualifiedNameWithWildcard )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5526:1: ( ruleQualifiedNameWithWildcard )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5527:1: ruleQualifiedNameWithWildcard
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_rule__Import__ImportedNamespaceAssignment_111201);
            ruleQualifiedNameWithWildcard();

            state._fsp--;

             after(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Import__ImportedNamespaceAssignment_1"


    // $ANTLR start "rule__ForkDefinition__NameAssignment_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5536:1: rule__ForkDefinition__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__ForkDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5540:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5541:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5541:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5542:1: ruleQualifiedName
            {
             before(grammarAccess.getForkDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__ForkDefinition__NameAssignment_111232);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getForkDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForkDefinition__NameAssignment_1"


    // $ANTLR start "rule__ForkDefinition__DescriptionAssignment_2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5551:1: rule__ForkDefinition__DescriptionAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ForkDefinition__DescriptionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5555:1: ( ( RULE_STRING ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5556:1: ( RULE_STRING )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5556:1: ( RULE_STRING )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5557:1: RULE_STRING
            {
             before(grammarAccess.getForkDefinitionAccess().getDescriptionSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ForkDefinition__DescriptionAssignment_211263); 
             after(grammarAccess.getForkDefinitionAccess().getDescriptionSTRINGTerminalRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForkDefinition__DescriptionAssignment_2"


    // $ANTLR start "rule__ForkDefinition__ForkerClassAssignment_3_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5566:1: rule__ForkDefinition__ForkerClassAssignment_3_1 : ( ( ruleQualifiedJavaClassName ) ) ;
    public final void rule__ForkDefinition__ForkerClassAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5570:1: ( ( ( ruleQualifiedJavaClassName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5571:1: ( ( ruleQualifiedJavaClassName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5571:1: ( ( ruleQualifiedJavaClassName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5572:1: ( ruleQualifiedJavaClassName )
            {
             before(grammarAccess.getForkDefinitionAccess().getForkerClassJvmTypeCrossReference_3_1_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5573:1: ( ruleQualifiedJavaClassName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5574:1: ruleQualifiedJavaClassName
            {
             before(grammarAccess.getForkDefinitionAccess().getForkerClassJvmTypeQualifiedJavaClassNameParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_rule__ForkDefinition__ForkerClassAssignment_3_111298);
            ruleQualifiedJavaClassName();

            state._fsp--;

             after(grammarAccess.getForkDefinitionAccess().getForkerClassJvmTypeQualifiedJavaClassNameParserRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getForkDefinitionAccess().getForkerClassJvmTypeCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ForkDefinition__ForkerClassAssignment_3_1"


    // $ANTLR start "rule__TestDefinition__NameAssignment_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5585:1: rule__TestDefinition__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__TestDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5589:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5590:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5590:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5591:1: ruleQualifiedName
            {
             before(grammarAccess.getTestDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__TestDefinition__NameAssignment_111333);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getTestDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestDefinition__NameAssignment_1"


    // $ANTLR start "rule__TestDefinition__FixtureMethodAssignment_3"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5600:1: rule__TestDefinition__FixtureMethodAssignment_3 : ( ruleMethodReference ) ;
    public final void rule__TestDefinition__FixtureMethodAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5604:1: ( ( ruleMethodReference ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5605:1: ( ruleMethodReference )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5605:1: ( ruleMethodReference )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5606:1: ruleMethodReference
            {
             before(grammarAccess.getTestDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleMethodReference_in_rule__TestDefinition__FixtureMethodAssignment_311364);
            ruleMethodReference();

            state._fsp--;

             after(grammarAccess.getTestDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TestDefinition__FixtureMethodAssignment_3"


    // $ANTLR start "rule__CallDefinition__NameAssignment_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5615:1: rule__CallDefinition__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__CallDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5619:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5620:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5620:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5621:1: ruleQualifiedName
            {
             before(grammarAccess.getCallDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__CallDefinition__NameAssignment_111395);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getCallDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallDefinition__NameAssignment_1"


    // $ANTLR start "rule__CallDefinition__FixtureMethodAssignment_3"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5630:1: rule__CallDefinition__FixtureMethodAssignment_3 : ( ruleMethodReference ) ;
    public final void rule__CallDefinition__FixtureMethodAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5634:1: ( ( ruleMethodReference ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5635:1: ( ruleMethodReference )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5635:1: ( ruleMethodReference )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5636:1: ruleMethodReference
            {
             before(grammarAccess.getCallDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleMethodReference_in_rule__CallDefinition__FixtureMethodAssignment_311426);
            ruleMethodReference();

            state._fsp--;

             after(grammarAccess.getCallDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CallDefinition__FixtureMethodAssignment_3"


    // $ANTLR start "rule__SuiteDefinition__NameAssignment_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5645:1: rule__SuiteDefinition__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__SuiteDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5649:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5650:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5650:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5651:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__NameAssignment_111457);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getSuiteDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__NameAssignment_1"


    // $ANTLR start "rule__SuiteDefinition__ParametersAssignment_2_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5660:1: rule__SuiteDefinition__ParametersAssignment_2_1 : ( ruleVariableEntity ) ;
    public final void rule__SuiteDefinition__ParametersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5664:1: ( ( ruleVariableEntity ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5665:1: ( ruleVariableEntity )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5665:1: ( ruleVariableEntity )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5666:1: ruleVariableEntity
            {
             before(grammarAccess.getSuiteDefinitionAccess().getParametersVariableEntityParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleVariableEntity_in_rule__SuiteDefinition__ParametersAssignment_2_111488);
            ruleVariableEntity();

            state._fsp--;

             after(grammarAccess.getSuiteDefinitionAccess().getParametersVariableEntityParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__ParametersAssignment_2_1"


    // $ANTLR start "rule__SuiteDefinition__DependenciesAssignment_3_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5675:1: rule__SuiteDefinition__DependenciesAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__SuiteDefinition__DependenciesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5679:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5680:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5680:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5681:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSuiteDefinitionAccess().getDependenciesSuiteDefinitionCrossReference_3_1_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5682:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5683:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteDefinitionAccess().getDependenciesSuiteDefinitionQualifiedNameParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__DependenciesAssignment_3_111523);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getSuiteDefinitionAccess().getDependenciesSuiteDefinitionQualifiedNameParserRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getSuiteDefinitionAccess().getDependenciesSuiteDefinitionCrossReference_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__DependenciesAssignment_3_1"


    // $ANTLR start "rule__SuiteDefinition__StatementsAssignment_5"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5694:1: rule__SuiteDefinition__StatementsAssignment_5 : ( ruleSuiteStatement ) ;
    public final void rule__SuiteDefinition__StatementsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5698:1: ( ( ruleSuiteStatement ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5699:1: ( ruleSuiteStatement )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5699:1: ( ruleSuiteStatement )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5700:1: ruleSuiteStatement
            {
             before(grammarAccess.getSuiteDefinitionAccess().getStatementsSuiteStatementParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleSuiteStatement_in_rule__SuiteDefinition__StatementsAssignment_511558);
            ruleSuiteStatement();

            state._fsp--;

             after(grammarAccess.getSuiteDefinitionAccess().getStatementsSuiteStatementParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__StatementsAssignment_5"


    // $ANTLR start "rule__SuiteDefinition__FinalizersAssignment_7_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5709:1: rule__SuiteDefinition__FinalizersAssignment_7_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__SuiteDefinition__FinalizersAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5713:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5714:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5714:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5715:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSuiteDefinitionAccess().getFinalizersSuiteDefinitionCrossReference_7_1_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5716:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5717:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteDefinitionAccess().getFinalizersSuiteDefinitionQualifiedNameParserRuleCall_7_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__FinalizersAssignment_7_111593);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getSuiteDefinitionAccess().getFinalizersSuiteDefinitionQualifiedNameParserRuleCall_7_1_0_1()); 

            }

             after(grammarAccess.getSuiteDefinitionAccess().getFinalizersSuiteDefinitionCrossReference_7_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteDefinition__FinalizersAssignment_7_1"


    // $ANTLR start "rule__VariableDefinition__NameAssignment_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5728:1: rule__VariableDefinition__NameAssignment_1 : ( ruleVariableEntity ) ;
    public final void rule__VariableDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5732:1: ( ( ruleVariableEntity ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5733:1: ( ruleVariableEntity )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5733:1: ( ruleVariableEntity )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5734:1: ruleVariableEntity
            {
             before(grammarAccess.getVariableDefinitionAccess().getNameVariableEntityParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleVariableEntity_in_rule__VariableDefinition__NameAssignment_111628);
            ruleVariableEntity();

            state._fsp--;

             after(grammarAccess.getVariableDefinitionAccess().getNameVariableEntityParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDefinition__NameAssignment_1"


    // $ANTLR start "rule__VariableDefinition__InitialValueAssignment_2_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5743:1: rule__VariableDefinition__InitialValueAssignment_2_1 : ( ruleValue ) ;
    public final void rule__VariableDefinition__InitialValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5747:1: ( ( ruleValue ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5748:1: ( ruleValue )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5748:1: ( ruleValue )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5749:1: ruleValue
            {
             before(grammarAccess.getVariableDefinitionAccess().getInitialValueValueParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleValue_in_rule__VariableDefinition__InitialValueAssignment_2_111659);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getVariableDefinitionAccess().getInitialValueValueParserRuleCall_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableDefinition__InitialValueAssignment_2_1"


    // $ANTLR start "rule__ConstantDefinition__NameAssignment_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5758:1: rule__ConstantDefinition__NameAssignment_1 : ( ruleVariableEntity ) ;
    public final void rule__ConstantDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5762:1: ( ( ruleVariableEntity ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5763:1: ( ruleVariableEntity )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5763:1: ( ruleVariableEntity )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5764:1: ruleVariableEntity
            {
             before(grammarAccess.getConstantDefinitionAccess().getNameVariableEntityParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleVariableEntity_in_rule__ConstantDefinition__NameAssignment_111690);
            ruleVariableEntity();

            state._fsp--;

             after(grammarAccess.getConstantDefinitionAccess().getNameVariableEntityParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstantDefinition__NameAssignment_1"


    // $ANTLR start "rule__ConstantDefinition__ValueAssignment_2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5773:1: rule__ConstantDefinition__ValueAssignment_2 : ( ruleValue ) ;
    public final void rule__ConstantDefinition__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5777:1: ( ( ruleValue ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5778:1: ( ruleValue )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5778:1: ( ruleValue )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5779:1: ruleValue
            {
             before(grammarAccess.getConstantDefinitionAccess().getValueValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleValue_in_rule__ConstantDefinition__ValueAssignment_211721);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getConstantDefinitionAccess().getValueValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ConstantDefinition__ValueAssignment_2"


    // $ANTLR start "rule__VariableEntity__NameAssignment"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5788:1: rule__VariableEntity__NameAssignment : ( ruleQualifiedName ) ;
    public final void rule__VariableEntity__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5792:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5793:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5793:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5794:1: ruleQualifiedName
            {
             before(grammarAccess.getVariableEntityAccess().getNameQualifiedNameParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__VariableEntity__NameAssignment11752);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getVariableEntityAccess().getNameQualifiedNameParserRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__VariableEntity__NameAssignment"


    // $ANTLR start "rule__Test__DefinitionAssignment_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5803:1: rule__Test__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Test__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5807:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5808:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5808:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5809:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getTestAccess().getDefinitionTestDefinitionCrossReference_1_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5810:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5811:1: ruleQualifiedName
            {
             before(grammarAccess.getTestAccess().getDefinitionTestDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Test__DefinitionAssignment_111787);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getTestAccess().getDefinitionTestDefinitionQualifiedNameParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getTestAccess().getDefinitionTestDefinitionCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__DefinitionAssignment_1"


    // $ANTLR start "rule__Test__ParametersAssignment_2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5822:1: rule__Test__ParametersAssignment_2 : ( ruleParameter ) ;
    public final void rule__Test__ParametersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5826:1: ( ( ruleParameter ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5827:1: ( ruleParameter )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5827:1: ( ruleParameter )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5828:1: ruleParameter
            {
             before(grammarAccess.getTestAccess().getParametersParameterParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleParameter_in_rule__Test__ParametersAssignment_211822);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getTestAccess().getParametersParameterParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__ParametersAssignment_2"


    // $ANTLR start "rule__Test__ResultsAssignment_3"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5837:1: rule__Test__ResultsAssignment_3 : ( ruleNamedResult ) ;
    public final void rule__Test__ResultsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5841:1: ( ( ruleNamedResult ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5842:1: ( ruleNamedResult )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5842:1: ( ruleNamedResult )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5843:1: ruleNamedResult
            {
             before(grammarAccess.getTestAccess().getResultsNamedResultParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleNamedResult_in_rule__Test__ResultsAssignment_311853);
            ruleNamedResult();

            state._fsp--;

             after(grammarAccess.getTestAccess().getResultsNamedResultParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__ResultsAssignment_3"


    // $ANTLR start "rule__Test__ResultAssignment_4_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5852:1: rule__Test__ResultAssignment_4_1 : ( ruleValueOrEnumValueCollection ) ;
    public final void rule__Test__ResultAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5856:1: ( ( ruleValueOrEnumValueCollection ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5857:1: ( ruleValueOrEnumValueCollection )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5857:1: ( ruleValueOrEnumValueCollection )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5858:1: ruleValueOrEnumValueCollection
            {
             before(grammarAccess.getTestAccess().getResultValueOrEnumValueCollectionParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleValueOrEnumValueCollection_in_rule__Test__ResultAssignment_4_111884);
            ruleValueOrEnumValueCollection();

            state._fsp--;

             after(grammarAccess.getTestAccess().getResultValueOrEnumValueCollectionParserRuleCall_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__ResultAssignment_4_1"


    // $ANTLR start "rule__TableTest__DefinitionAssignment_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5867:1: rule__TableTest__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__TableTest__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5871:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5872:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5872:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5873:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getTableTestAccess().getDefinitionTestDefinitionCrossReference_1_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5874:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5875:1: ruleQualifiedName
            {
             before(grammarAccess.getTableTestAccess().getDefinitionTestDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__TableTest__DefinitionAssignment_111919);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getTableTestAccess().getDefinitionTestDefinitionQualifiedNameParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getTableTestAccess().getDefinitionTestDefinitionCrossReference_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__DefinitionAssignment_1"


    // $ANTLR start "rule__TableTest__ParametersAssignment_2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5886:1: rule__TableTest__ParametersAssignment_2 : ( ruleParameter ) ;
    public final void rule__TableTest__ParametersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5890:1: ( ( ruleParameter ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5891:1: ( ruleParameter )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5891:1: ( ruleParameter )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5892:1: ruleParameter
            {
             before(grammarAccess.getTableTestAccess().getParametersParameterParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleParameter_in_rule__TableTest__ParametersAssignment_211954);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getTableTestAccess().getParametersParameterParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__ParametersAssignment_2"


    // $ANTLR start "rule__TableTest__ParameterHeadersAssignment_3"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5901:1: rule__TableTest__ParameterHeadersAssignment_3 : ( ruleParameterTableHeader ) ;
    public final void rule__TableTest__ParameterHeadersAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5905:1: ( ( ruleParameterTableHeader ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5906:1: ( ruleParameterTableHeader )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5906:1: ( ruleParameterTableHeader )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5907:1: ruleParameterTableHeader
            {
             before(grammarAccess.getTableTestAccess().getParameterHeadersParameterTableHeaderParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleParameterTableHeader_in_rule__TableTest__ParameterHeadersAssignment_311985);
            ruleParameterTableHeader();

            state._fsp--;

             after(grammarAccess.getTableTestAccess().getParameterHeadersParameterTableHeaderParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__ParameterHeadersAssignment_3"


    // $ANTLR start "rule__TableTest__ResultHeadersAssignment_4"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5916:1: rule__TableTest__ResultHeadersAssignment_4 : ( ruleResultTableHeader ) ;
    public final void rule__TableTest__ResultHeadersAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5920:1: ( ( ruleResultTableHeader ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5921:1: ( ruleResultTableHeader )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5921:1: ( ruleResultTableHeader )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5922:1: ruleResultTableHeader
            {
             before(grammarAccess.getTableTestAccess().getResultHeadersResultTableHeaderParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleResultTableHeader_in_rule__TableTest__ResultHeadersAssignment_412016);
            ruleResultTableHeader();

            state._fsp--;

             after(grammarAccess.getTableTestAccess().getResultHeadersResultTableHeaderParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__ResultHeadersAssignment_4"


    // $ANTLR start "rule__TableTest__DefaultResultColumnAssignment_6_0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5931:1: rule__TableTest__DefaultResultColumnAssignment_6_0 : ( ( '=' ) ) ;
    public final void rule__TableTest__DefaultResultColumnAssignment_6_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5935:1: ( ( ( '=' ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5936:1: ( ( '=' ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5936:1: ( ( '=' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5937:1: ( '=' )
            {
             before(grammarAccess.getTableTestAccess().getDefaultResultColumnEqualsSignKeyword_6_0_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5938:1: ( '=' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5939:1: '='
            {
             before(grammarAccess.getTableTestAccess().getDefaultResultColumnEqualsSignKeyword_6_0_0()); 
            match(input,34,FOLLOW_34_in_rule__TableTest__DefaultResultColumnAssignment_6_012052); 
             after(grammarAccess.getTableTestAccess().getDefaultResultColumnEqualsSignKeyword_6_0_0()); 

            }

             after(grammarAccess.getTableTestAccess().getDefaultResultColumnEqualsSignKeyword_6_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__DefaultResultColumnAssignment_6_0"


    // $ANTLR start "rule__TableTest__RowsAssignment_7"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5954:1: rule__TableTest__RowsAssignment_7 : ( ruleTableTestRow ) ;
    public final void rule__TableTest__RowsAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5958:1: ( ( ruleTableTestRow ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5959:1: ( ruleTableTestRow )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5959:1: ( ruleTableTestRow )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5960:1: ruleTableTestRow
            {
             before(grammarAccess.getTableTestAccess().getRowsTableTestRowParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleTableTestRow_in_rule__TableTest__RowsAssignment_712091);
            ruleTableTestRow();

            state._fsp--;

             after(grammarAccess.getTableTestAccess().getRowsTableTestRowParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__RowsAssignment_7"


    // $ANTLR start "rule__TableTestRow__ValuesAssignment_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5969:1: rule__TableTestRow__ValuesAssignment_1 : ( ruleParameterTableValue ) ;
    public final void rule__TableTestRow__ValuesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5973:1: ( ( ruleParameterTableValue ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5974:1: ( ruleParameterTableValue )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5974:1: ( ruleParameterTableValue )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5975:1: ruleParameterTableValue
            {
             before(grammarAccess.getTableTestRowAccess().getValuesParameterTableValueParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleParameterTableValue_in_rule__TableTestRow__ValuesAssignment_112122);
            ruleParameterTableValue();

            state._fsp--;

             after(grammarAccess.getTableTestRowAccess().getValuesParameterTableValueParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTestRow__ValuesAssignment_1"


    // $ANTLR start "rule__ParameterTableHeader__NameAssignment_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5984:1: rule__ParameterTableHeader__NameAssignment_1 : ( ruleParameterName ) ;
    public final void rule__ParameterTableHeader__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5988:1: ( ( ruleParameterName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5989:1: ( ruleParameterName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5989:1: ( ruleParameterName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5990:1: ruleParameterName
            {
             before(grammarAccess.getParameterTableHeaderAccess().getNameParameterNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleParameterName_in_rule__ParameterTableHeader__NameAssignment_112153);
            ruleParameterName();

            state._fsp--;

             after(grammarAccess.getParameterTableHeaderAccess().getNameParameterNameParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterTableHeader__NameAssignment_1"


    // $ANTLR start "rule__ResultTableHeader__NameAssignment_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5999:1: rule__ResultTableHeader__NameAssignment_1 : ( ruleResultName ) ;
    public final void rule__ResultTableHeader__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6003:1: ( ( ruleResultName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6004:1: ( ruleResultName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6004:1: ( ruleResultName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6005:1: ruleResultName
            {
             before(grammarAccess.getResultTableHeaderAccess().getNameResultNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleResultName_in_rule__ResultTableHeader__NameAssignment_112184);
            ruleResultName();

            state._fsp--;

             after(grammarAccess.getResultTableHeaderAccess().getNameResultNameParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ResultTableHeader__NameAssignment_1"


    // $ANTLR start "rule__ParameterTableValue__ValueAssignment_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6014:1: rule__ParameterTableValue__ValueAssignment_1 : ( ruleValueOrEnumValueCollection ) ;
    public final void rule__ParameterTableValue__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6018:1: ( ( ruleValueOrEnumValueCollection ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6019:1: ( ruleValueOrEnumValueCollection )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6019:1: ( ruleValueOrEnumValueCollection )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6020:1: ruleValueOrEnumValueCollection
            {
             before(grammarAccess.getParameterTableValueAccess().getValueValueOrEnumValueCollectionParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleValueOrEnumValueCollection_in_rule__ParameterTableValue__ValueAssignment_112215);
            ruleValueOrEnumValueCollection();

            state._fsp--;

             after(grammarAccess.getParameterTableValueAccess().getValueValueOrEnumValueCollectionParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ParameterTableValue__ValueAssignment_1"


    // $ANTLR start "rule__NamedResult__NameAssignment_0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6029:1: rule__NamedResult__NameAssignment_0 : ( ruleResultName ) ;
    public final void rule__NamedResult__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6033:1: ( ( ruleResultName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6034:1: ( ruleResultName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6034:1: ( ruleResultName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6035:1: ruleResultName
            {
             before(grammarAccess.getNamedResultAccess().getNameResultNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleResultName_in_rule__NamedResult__NameAssignment_012246);
            ruleResultName();

            state._fsp--;

             after(grammarAccess.getNamedResultAccess().getNameResultNameParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedResult__NameAssignment_0"


    // $ANTLR start "rule__NamedResult__ValueAssignment_2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6044:1: rule__NamedResult__ValueAssignment_2 : ( ruleValueOrEnumValueCollection ) ;
    public final void rule__NamedResult__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6048:1: ( ( ruleValueOrEnumValueCollection ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6049:1: ( ruleValueOrEnumValueCollection )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6049:1: ( ruleValueOrEnumValueCollection )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6050:1: ruleValueOrEnumValueCollection
            {
             before(grammarAccess.getNamedResultAccess().getValueValueOrEnumValueCollectionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleValueOrEnumValueCollection_in_rule__NamedResult__ValueAssignment_212277);
            ruleValueOrEnumValueCollection();

            state._fsp--;

             after(grammarAccess.getNamedResultAccess().getValueValueOrEnumValueCollectionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedResult__ValueAssignment_2"


    // $ANTLR start "rule__FixedResultName__FieldAssignment"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6059:1: rule__FixedResultName__FieldAssignment : ( ( RULE_ID ) ) ;
    public final void rule__FixedResultName__FieldAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6063:1: ( ( ( RULE_ID ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6064:1: ( ( RULE_ID ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6064:1: ( ( RULE_ID ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6065:1: ( RULE_ID )
            {
             before(grammarAccess.getFixedResultNameAccess().getFieldJvmFieldCrossReference_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6066:1: ( RULE_ID )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6067:1: RULE_ID
            {
             before(grammarAccess.getFixedResultNameAccess().getFieldJvmFieldIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FixedResultName__FieldAssignment12312); 
             after(grammarAccess.getFixedResultNameAccess().getFieldJvmFieldIDTerminalRuleCall_0_1()); 

            }

             after(grammarAccess.getFixedResultNameAccess().getFieldJvmFieldCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FixedResultName__FieldAssignment"


    // $ANTLR start "rule__Call__MultiplierAssignment_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6078:1: rule__Call__MultiplierAssignment_1 : ( ruleExecutionMultiplier ) ;
    public final void rule__Call__MultiplierAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6082:1: ( ( ruleExecutionMultiplier ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6083:1: ( ruleExecutionMultiplier )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6083:1: ( ruleExecutionMultiplier )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6084:1: ruleExecutionMultiplier
            {
             before(grammarAccess.getCallAccess().getMultiplierExecutionMultiplierParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleExecutionMultiplier_in_rule__Call__MultiplierAssignment_112347);
            ruleExecutionMultiplier();

            state._fsp--;

             after(grammarAccess.getCallAccess().getMultiplierExecutionMultiplierParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__MultiplierAssignment_1"


    // $ANTLR start "rule__Call__DefinitionAssignment_2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6093:1: rule__Call__DefinitionAssignment_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Call__DefinitionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6097:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6098:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6098:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6099:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getCallAccess().getDefinitionCallDefinitionCrossReference_2_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6100:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6101:1: ruleQualifiedName
            {
             before(grammarAccess.getCallAccess().getDefinitionCallDefinitionQualifiedNameParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Call__DefinitionAssignment_212382);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getCallAccess().getDefinitionCallDefinitionQualifiedNameParserRuleCall_2_0_1()); 

            }

             after(grammarAccess.getCallAccess().getDefinitionCallDefinitionCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__DefinitionAssignment_2"


    // $ANTLR start "rule__Call__ParametersAssignment_3"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6112:1: rule__Call__ParametersAssignment_3 : ( ruleParameter ) ;
    public final void rule__Call__ParametersAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6116:1: ( ( ruleParameter ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6117:1: ( ruleParameter )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6117:1: ( ruleParameter )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6118:1: ruleParameter
            {
             before(grammarAccess.getCallAccess().getParametersParameterParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleParameter_in_rule__Call__ParametersAssignment_312417);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getCallAccess().getParametersParameterParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__ParametersAssignment_3"


    // $ANTLR start "rule__Call__ResultsAssignment_4"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6127:1: rule__Call__ResultsAssignment_4 : ( ruleNamedCallResult ) ;
    public final void rule__Call__ResultsAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6131:1: ( ( ruleNamedCallResult ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6132:1: ( ruleNamedCallResult )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6132:1: ( ruleNamedCallResult )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6133:1: ruleNamedCallResult
            {
             before(grammarAccess.getCallAccess().getResultsNamedCallResultParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleNamedCallResult_in_rule__Call__ResultsAssignment_412448);
            ruleNamedCallResult();

            state._fsp--;

             after(grammarAccess.getCallAccess().getResultsNamedCallResultParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__ResultsAssignment_4"


    // $ANTLR start "rule__Call__ResultAssignment_5_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6142:1: rule__Call__ResultAssignment_5_1 : ( ruleVariable ) ;
    public final void rule__Call__ResultAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6146:1: ( ( ruleVariable ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6147:1: ( ruleVariable )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6147:1: ( ruleVariable )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6148:1: ruleVariable
            {
             before(grammarAccess.getCallAccess().getResultVariableParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_ruleVariable_in_rule__Call__ResultAssignment_5_112479);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getCallAccess().getResultVariableParserRuleCall_5_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__ResultAssignment_5_1"


    // $ANTLR start "rule__NamedCallResult__NameAssignment_0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6157:1: rule__NamedCallResult__NameAssignment_0 : ( ruleResultName ) ;
    public final void rule__NamedCallResult__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6161:1: ( ( ruleResultName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6162:1: ( ruleResultName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6162:1: ( ruleResultName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6163:1: ruleResultName
            {
             before(grammarAccess.getNamedCallResultAccess().getNameResultNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleResultName_in_rule__NamedCallResult__NameAssignment_012510);
            ruleResultName();

            state._fsp--;

             after(grammarAccess.getNamedCallResultAccess().getNameResultNameParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedCallResult__NameAssignment_0"


    // $ANTLR start "rule__NamedCallResult__TargetAssignment_2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6172:1: rule__NamedCallResult__TargetAssignment_2 : ( ruleVariable ) ;
    public final void rule__NamedCallResult__TargetAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6176:1: ( ( ruleVariable ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6177:1: ( ruleVariable )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6177:1: ( ruleVariable )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6178:1: ruleVariable
            {
             before(grammarAccess.getNamedCallResultAccess().getTargetVariableParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleVariable_in_rule__NamedCallResult__TargetAssignment_212541);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getNamedCallResultAccess().getTargetVariableParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__NamedCallResult__TargetAssignment_2"


    // $ANTLR start "rule__Suite__MultiplierAssignment_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6187:1: rule__Suite__MultiplierAssignment_1 : ( ruleExecutionMultiplier ) ;
    public final void rule__Suite__MultiplierAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6191:1: ( ( ruleExecutionMultiplier ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6192:1: ( ruleExecutionMultiplier )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6192:1: ( ruleExecutionMultiplier )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6193:1: ruleExecutionMultiplier
            {
             before(grammarAccess.getSuiteAccess().getMultiplierExecutionMultiplierParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleExecutionMultiplier_in_rule__Suite__MultiplierAssignment_112572);
            ruleExecutionMultiplier();

            state._fsp--;

             after(grammarAccess.getSuiteAccess().getMultiplierExecutionMultiplierParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Suite__MultiplierAssignment_1"


    // $ANTLR start "rule__Suite__DefinitionAssignment_2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6202:1: rule__Suite__DefinitionAssignment_2 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Suite__DefinitionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6206:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6207:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6207:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6208:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSuiteAccess().getDefinitionSuiteDefinitionCrossReference_2_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6209:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6210:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteAccess().getDefinitionSuiteDefinitionQualifiedNameParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Suite__DefinitionAssignment_212607);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getSuiteAccess().getDefinitionSuiteDefinitionQualifiedNameParserRuleCall_2_0_1()); 

            }

             after(grammarAccess.getSuiteAccess().getDefinitionSuiteDefinitionCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Suite__DefinitionAssignment_2"


    // $ANTLR start "rule__Suite__ParametersAssignment_3"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6221:1: rule__Suite__ParametersAssignment_3 : ( ruleSuiteParameter ) ;
    public final void rule__Suite__ParametersAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6225:1: ( ( ruleSuiteParameter ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6226:1: ( ruleSuiteParameter )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6226:1: ( ruleSuiteParameter )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6227:1: ruleSuiteParameter
            {
             before(grammarAccess.getSuiteAccess().getParametersSuiteParameterParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleSuiteParameter_in_rule__Suite__ParametersAssignment_312642);
            ruleSuiteParameter();

            state._fsp--;

             after(grammarAccess.getSuiteAccess().getParametersSuiteParameterParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Suite__ParametersAssignment_3"


    // $ANTLR start "rule__Suite__ForkAssignment_4_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6236:1: rule__Suite__ForkAssignment_4_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Suite__ForkAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6240:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6241:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6241:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6242:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSuiteAccess().getForkForkDefinitionCrossReference_4_1_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6243:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6244:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteAccess().getForkForkDefinitionQualifiedNameParserRuleCall_4_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Suite__ForkAssignment_4_112677);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getSuiteAccess().getForkForkDefinitionQualifiedNameParserRuleCall_4_1_0_1()); 

            }

             after(grammarAccess.getSuiteAccess().getForkForkDefinitionCrossReference_4_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Suite__ForkAssignment_4_1"


    // $ANTLR start "rule__SuiteParameter__NameAssignment_0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6255:1: rule__SuiteParameter__NameAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__SuiteParameter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6259:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6260:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6260:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6261:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSuiteParameterAccess().getNameVariableEntityCrossReference_0_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6262:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6263:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteParameterAccess().getNameVariableEntityQualifiedNameParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__SuiteParameter__NameAssignment_012716);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getSuiteParameterAccess().getNameVariableEntityQualifiedNameParserRuleCall_0_0_1()); 

            }

             after(grammarAccess.getSuiteParameterAccess().getNameVariableEntityCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteParameter__NameAssignment_0"


    // $ANTLR start "rule__SuiteParameter__ValueAssignment_2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6274:1: rule__SuiteParameter__ValueAssignment_2 : ( ruleValue ) ;
    public final void rule__SuiteParameter__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6278:1: ( ( ruleValue ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6279:1: ( ruleValue )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6279:1: ( ruleValue )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6280:1: ruleValue
            {
             before(grammarAccess.getSuiteParameterAccess().getValueValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleValue_in_rule__SuiteParameter__ValueAssignment_212751);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getSuiteParameterAccess().getValueValueParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SuiteParameter__ValueAssignment_2"


    // $ANTLR start "rule__Parameter__NameAssignment_0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6289:1: rule__Parameter__NameAssignment_0 : ( ruleParameterName ) ;
    public final void rule__Parameter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6293:1: ( ( ruleParameterName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6294:1: ( ruleParameterName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6294:1: ( ruleParameterName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6295:1: ruleParameterName
            {
             before(grammarAccess.getParameterAccess().getNameParameterNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleParameterName_in_rule__Parameter__NameAssignment_012782);
            ruleParameterName();

            state._fsp--;

             after(grammarAccess.getParameterAccess().getNameParameterNameParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__NameAssignment_0"


    // $ANTLR start "rule__Parameter__ValueAssignment_2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6304:1: rule__Parameter__ValueAssignment_2 : ( ruleValueOrEnumValueCollection ) ;
    public final void rule__Parameter__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6308:1: ( ( ruleValueOrEnumValueCollection ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6309:1: ( ruleValueOrEnumValueCollection )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6309:1: ( ruleValueOrEnumValueCollection )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6310:1: ruleValueOrEnumValueCollection
            {
             before(grammarAccess.getParameterAccess().getValueValueOrEnumValueCollectionParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleValueOrEnumValueCollection_in_rule__Parameter__ValueAssignment_212813);
            ruleValueOrEnumValueCollection();

            state._fsp--;

             after(grammarAccess.getParameterAccess().getValueValueOrEnumValueCollectionParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Parameter__ValueAssignment_2"


    // $ANTLR start "rule__FixedParameterName__AnnotationAssignment"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6319:1: rule__FixedParameterName__AnnotationAssignment : ( ( RULE_ID ) ) ;
    public final void rule__FixedParameterName__AnnotationAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6323:1: ( ( ( RULE_ID ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6324:1: ( ( RULE_ID ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6324:1: ( ( RULE_ID ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6325:1: ( RULE_ID )
            {
             before(grammarAccess.getFixedParameterNameAccess().getAnnotationJvmAnnotationReferenceCrossReference_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6326:1: ( RULE_ID )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6327:1: RULE_ID
            {
             before(grammarAccess.getFixedParameterNameAccess().getAnnotationJvmAnnotationReferenceIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FixedParameterName__AnnotationAssignment12848); 
             after(grammarAccess.getFixedParameterNameAccess().getAnnotationJvmAnnotationReferenceIDTerminalRuleCall_0_1()); 

            }

             after(grammarAccess.getFixedParameterNameAccess().getAnnotationJvmAnnotationReferenceCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FixedParameterName__AnnotationAssignment"


    // $ANTLR start "rule__ArbitraryParameterOrResultName__IdentifierAssignment_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6338:1: rule__ArbitraryParameterOrResultName__IdentifierAssignment_1 : ( RULE_ID ) ;
    public final void rule__ArbitraryParameterOrResultName__IdentifierAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6342:1: ( ( RULE_ID ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6343:1: ( RULE_ID )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6343:1: ( RULE_ID )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6344:1: RULE_ID
            {
             before(grammarAccess.getArbitraryParameterOrResultNameAccess().getIdentifierIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ArbitraryParameterOrResultName__IdentifierAssignment_112883); 
             after(grammarAccess.getArbitraryParameterOrResultNameAccess().getIdentifierIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArbitraryParameterOrResultName__IdentifierAssignment_1"


    // $ANTLR start "rule__ValueOrEnumValueCollection__ValueAssignment_0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6353:1: rule__ValueOrEnumValueCollection__ValueAssignment_0 : ( ruleValueOrEnumValue ) ;
    public final void rule__ValueOrEnumValueCollection__ValueAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6357:1: ( ( ruleValueOrEnumValue ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6358:1: ( ruleValueOrEnumValue )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6358:1: ( ruleValueOrEnumValue )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6359:1: ruleValueOrEnumValue
            {
             before(grammarAccess.getValueOrEnumValueCollectionAccess().getValueValueOrEnumValueParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_rule__ValueOrEnumValueCollection__ValueAssignment_012914);
            ruleValueOrEnumValue();

            state._fsp--;

             after(grammarAccess.getValueOrEnumValueCollectionAccess().getValueValueOrEnumValueParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueOrEnumValueCollection__ValueAssignment_0"


    // $ANTLR start "rule__ValueOrEnumValueCollection__MoreValuesAssignment_1_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6368:1: rule__ValueOrEnumValueCollection__MoreValuesAssignment_1_1 : ( ruleValueOrEnumValue ) ;
    public final void rule__ValueOrEnumValueCollection__MoreValuesAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6372:1: ( ( ruleValueOrEnumValue ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6373:1: ( ruleValueOrEnumValue )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6373:1: ( ruleValueOrEnumValue )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6374:1: ruleValueOrEnumValue
            {
             before(grammarAccess.getValueOrEnumValueCollectionAccess().getMoreValuesValueOrEnumValueParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_rule__ValueOrEnumValueCollection__MoreValuesAssignment_1_112945);
            ruleValueOrEnumValue();

            state._fsp--;

             after(grammarAccess.getValueOrEnumValueCollectionAccess().getMoreValuesValueOrEnumValueParserRuleCall_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ValueOrEnumValueCollection__MoreValuesAssignment_1_1"


    // $ANTLR start "rule__IntegerValue__IntegerValueAssignment"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6383:1: rule__IntegerValue__IntegerValueAssignment : ( RULE_INTEGER ) ;
    public final void rule__IntegerValue__IntegerValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6387:1: ( ( RULE_INTEGER ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6388:1: ( RULE_INTEGER )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6388:1: ( RULE_INTEGER )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6389:1: RULE_INTEGER
            {
             before(grammarAccess.getIntegerValueAccess().getIntegerValueINTEGERTerminalRuleCall_0()); 
            match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_rule__IntegerValue__IntegerValueAssignment12976); 
             after(grammarAccess.getIntegerValueAccess().getIntegerValueINTEGERTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__IntegerValue__IntegerValueAssignment"


    // $ANTLR start "rule__DecimalValue__DecimalValueAssignment"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6398:1: rule__DecimalValue__DecimalValueAssignment : ( RULE_DECIMAL ) ;
    public final void rule__DecimalValue__DecimalValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6402:1: ( ( RULE_DECIMAL ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6403:1: ( RULE_DECIMAL )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6403:1: ( RULE_DECIMAL )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6404:1: RULE_DECIMAL
            {
             before(grammarAccess.getDecimalValueAccess().getDecimalValueDECIMALTerminalRuleCall_0()); 
            match(input,RULE_DECIMAL,FOLLOW_RULE_DECIMAL_in_rule__DecimalValue__DecimalValueAssignment13007); 
             after(grammarAccess.getDecimalValueAccess().getDecimalValueDECIMALTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DecimalValue__DecimalValueAssignment"


    // $ANTLR start "rule__StringValue__StringValueAssignment"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6413:1: rule__StringValue__StringValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringValue__StringValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6417:1: ( ( RULE_STRING ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6418:1: ( RULE_STRING )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6418:1: ( RULE_STRING )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6419:1: RULE_STRING
            {
             before(grammarAccess.getStringValueAccess().getStringValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringValue__StringValueAssignment13038); 
             after(grammarAccess.getStringValueAccess().getStringValueSTRINGTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__StringValue__StringValueAssignment"


    // $ANTLR start "rule__BooleanValue__BooleanValueAssignment"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6428:1: rule__BooleanValue__BooleanValueAssignment : ( ( rule__BooleanValue__BooleanValueAlternatives_0 ) ) ;
    public final void rule__BooleanValue__BooleanValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6432:1: ( ( ( rule__BooleanValue__BooleanValueAlternatives_0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6433:1: ( ( rule__BooleanValue__BooleanValueAlternatives_0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6433:1: ( ( rule__BooleanValue__BooleanValueAlternatives_0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6434:1: ( rule__BooleanValue__BooleanValueAlternatives_0 )
            {
             before(grammarAccess.getBooleanValueAccess().getBooleanValueAlternatives_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6435:1: ( rule__BooleanValue__BooleanValueAlternatives_0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6435:2: rule__BooleanValue__BooleanValueAlternatives_0
            {
            pushFollow(FOLLOW_rule__BooleanValue__BooleanValueAlternatives_0_in_rule__BooleanValue__BooleanValueAssignment13069);
            rule__BooleanValue__BooleanValueAlternatives_0();

            state._fsp--;


            }

             after(grammarAccess.getBooleanValueAccess().getBooleanValueAlternatives_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__BooleanValue__BooleanValueAssignment"


    // $ANTLR start "rule__Variable__NameAssignment"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6444:1: rule__Variable__NameAssignment : ( ( ruleQualifiedName ) ) ;
    public final void rule__Variable__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6448:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6449:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6449:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6450:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getVariableAccess().getNameVariableEntityCrossReference_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6451:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6452:1: ruleQualifiedName
            {
             before(grammarAccess.getVariableAccess().getNameVariableEntityQualifiedNameParserRuleCall_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Variable__NameAssignment13106);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getVariableAccess().getNameVariableEntityQualifiedNameParserRuleCall_0_1()); 

            }

             after(grammarAccess.getVariableAccess().getNameVariableEntityCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Variable__NameAssignment"


    // $ANTLR start "rule__EnumValue__EnumValueAssignment"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6463:1: rule__EnumValue__EnumValueAssignment : ( ( RULE_UPPERCASE_ID ) ) ;
    public final void rule__EnumValue__EnumValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6467:1: ( ( ( RULE_UPPERCASE_ID ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6468:1: ( ( RULE_UPPERCASE_ID ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6468:1: ( ( RULE_UPPERCASE_ID ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6469:1: ( RULE_UPPERCASE_ID )
            {
             before(grammarAccess.getEnumValueAccess().getEnumValueJvmEnumerationLiteralCrossReference_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6470:1: ( RULE_UPPERCASE_ID )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6471:1: RULE_UPPERCASE_ID
            {
             before(grammarAccess.getEnumValueAccess().getEnumValueJvmEnumerationLiteralUPPERCASE_IDTerminalRuleCall_0_1()); 
            match(input,RULE_UPPERCASE_ID,FOLLOW_RULE_UPPERCASE_ID_in_rule__EnumValue__EnumValueAssignment13145); 
             after(grammarAccess.getEnumValueAccess().getEnumValueJvmEnumerationLiteralUPPERCASE_IDTerminalRuleCall_0_1()); 

            }

             after(grammarAccess.getEnumValueAccess().getEnumValueJvmEnumerationLiteralCrossReference_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EnumValue__EnumValueAssignment"


    // $ANTLR start "rule__MethodReference__TypeAssignment_0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6482:1: rule__MethodReference__TypeAssignment_0 : ( ( ruleQualifiedJavaClassName ) ) ;
    public final void rule__MethodReference__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6486:1: ( ( ( ruleQualifiedJavaClassName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6487:1: ( ( ruleQualifiedJavaClassName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6487:1: ( ( ruleQualifiedJavaClassName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6488:1: ( ruleQualifiedJavaClassName )
            {
             before(grammarAccess.getMethodReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6489:1: ( ruleQualifiedJavaClassName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6490:1: ruleQualifiedJavaClassName
            {
             before(grammarAccess.getMethodReferenceAccess().getTypeJvmTypeQualifiedJavaClassNameParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_rule__MethodReference__TypeAssignment_013184);
            ruleQualifiedJavaClassName();

            state._fsp--;

             after(grammarAccess.getMethodReferenceAccess().getTypeJvmTypeQualifiedJavaClassNameParserRuleCall_0_0_1()); 

            }

             after(grammarAccess.getMethodReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodReference__TypeAssignment_0"


    // $ANTLR start "rule__MethodReference__MethodAssignment_2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6501:1: rule__MethodReference__MethodAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__MethodReference__MethodAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6505:1: ( ( ( RULE_ID ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6506:1: ( ( RULE_ID ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6506:1: ( ( RULE_ID ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6507:1: ( RULE_ID )
            {
             before(grammarAccess.getMethodReferenceAccess().getMethodJvmOperationCrossReference_2_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6508:1: ( RULE_ID )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6509:1: RULE_ID
            {
             before(grammarAccess.getMethodReferenceAccess().getMethodJvmOperationIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__MethodReference__MethodAssignment_213223); 
             after(grammarAccess.getMethodReferenceAccess().getMethodJvmOperationIDTerminalRuleCall_2_0_1()); 

            }

             after(grammarAccess.getMethodReferenceAccess().getMethodJvmOperationCrossReference_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MethodReference__MethodAssignment_2"


    // $ANTLR start "rule__ExecutionMultiplier__CountAssignment_0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6520:1: rule__ExecutionMultiplier__CountAssignment_0 : ( RULE_INTEGER ) ;
    public final void rule__ExecutionMultiplier__CountAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6524:1: ( ( RULE_INTEGER ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6525:1: ( RULE_INTEGER )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6525:1: ( RULE_INTEGER )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6526:1: RULE_INTEGER
            {
             before(grammarAccess.getExecutionMultiplierAccess().getCountINTEGERTerminalRuleCall_0_0()); 
            match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_rule__ExecutionMultiplier__CountAssignment_013258); 
             after(grammarAccess.getExecutionMultiplierAccess().getCountINTEGERTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExecutionMultiplier__CountAssignment_0"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__StatementsAssignment_in_ruleModel94 = new BitSet(new long[]{0x0000008000120002L});
    public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement122 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatement129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statement__Alternatives_in_ruleStatement155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleSingleLineComment_in_entryRuleVisibleSingleLineComment182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVisibleSingleLineComment189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VisibleSingleLineComment__ContentAssignment_in_ruleVisibleSingleLineComment215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleMultiLineComment_in_entryRuleVisibleMultiLineComment242 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVisibleMultiLineComment249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VisibleMultiLineComment__ContentAssignment_in_ruleVisibleMultiLineComment275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDefinition_in_entryRulePackageDefinition302 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageDefinition309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__0_in_rulePackageDefinition335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageStatement_in_entryRulePackageStatement362 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageStatement369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageStatement__Alternatives_in_rulePackageStatement395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport422 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForkDefinition_in_entryRuleForkDefinition482 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleForkDefinition489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ForkDefinition__Group__0_in_ruleForkDefinition515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestDefinition_in_entryRuleTestDefinition542 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestDefinition549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__0_in_ruleTestDefinition575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallDefinition_in_entryRuleCallDefinition602 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallDefinition609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__0_in_ruleCallDefinition635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteDefinition_in_entryRuleSuiteDefinition662 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteDefinition669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__0_in_ruleSuiteDefinition695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteStatement_in_entryRuleSuiteStatement722 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteStatement729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteStatement__Alternatives_in_ruleSuiteStatement755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteStatementWithResult_in_entryRuleSuiteStatementWithResult782 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteStatementWithResult789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteStatementWithResult__Alternatives_in_ruleSuiteStatementWithResult815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_entryRuleVariableDefinition842 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDefinition849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__0_in_ruleVariableDefinition875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantDefinition_in_entryRuleConstantDefinition902 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstantDefinition909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstantDefinition__Group__0_in_ruleConstantDefinition935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_entryRuleVariableEntity962 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableEntity969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableEntity__NameAssignment_in_ruleVariableEntity995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTest_in_entryRuleTest1022 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTest1029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group__0_in_ruleTest1055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTableTest_in_entryRuleTableTest1082 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTableTest1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group__0_in_ruleTableTest1115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTableTestRow_in_entryRuleTableTestRow1142 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTableTestRow1149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group__0_in_ruleTableTestRow1175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableHeader_in_entryRuleParameterTableHeader1202 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterTableHeader1209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableHeader__Group__0_in_ruleParameterTableHeader1235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultTableHeader_in_entryRuleResultTableHeader1262 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultTableHeader1269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultTableHeader__Group__0_in_ruleResultTableHeader1295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableValue_in_entryRuleParameterTableValue1322 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterTableValue1329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableValue__Group__0_in_ruleParameterTableValue1355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedResult_in_entryRuleNamedResult1382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedResult1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedResult__Group__0_in_ruleNamedResult1415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultName_in_entryRuleResultName1442 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultName1449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultName__Alternatives_in_ruleResultName1475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedResultName_in_entryRuleFixedResultName1502 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFixedResultName1509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FixedResultName__FieldAssignment_in_ruleFixedResultName1535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_entryRuleCall1562 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCall1569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__0_in_ruleCall1595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedCallResult_in_entryRuleNamedCallResult1622 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedCallResult1629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedCallResult__Group__0_in_ruleNamedCallResult1655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_entryRuleSuite1682 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuite1689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group__0_in_ruleSuite1715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteParameter_in_entryRuleSuiteParameter1742 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteParameter1749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__0_in_ruleSuiteParameter1775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter1802 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter1809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__0_in_ruleParameter1835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterName_in_entryRuleParameterName1862 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterName1869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterName__Alternatives_in_ruleParameterName1895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedParameterName_in_entryRuleFixedParameterName1922 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFixedParameterName1929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FixedParameterName__AnnotationAssignment_in_ruleFixedParameterName1955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterOrResultName_in_entryRuleArbitraryParameterOrResultName1982 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArbitraryParameterOrResultName1989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArbitraryParameterOrResultName__Group__0_in_ruleArbitraryParameterOrResultName2015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueCollection_in_entryRuleValueOrEnumValueCollection2042 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueOrEnumValueCollection2049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueOrEnumValueCollection__Group__0_in_ruleValueOrEnumValueCollection2075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_entryRuleValueOrEnumValue2102 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueOrEnumValue2109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueOrEnumValue__Alternatives_in_ruleValueOrEnumValue2135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue2162 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue2169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Alternatives_in_ruleValue2195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerValue_in_entryRuleIntegerValue2222 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerValue2229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntegerValue__IntegerValueAssignment_in_ruleIntegerValue2255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalValue_in_entryRuleDecimalValue2282 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalValue2289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalValue__DecimalValueAssignment_in_ruleDecimalValue2315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringValue_in_entryRuleStringValue2342 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringValue2349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringValue__StringValueAssignment_in_ruleStringValue2375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanValue_in_entryRuleBooleanValue2402 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanValue2409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanValue__BooleanValueAssignment_in_ruleBooleanValue2435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable2462 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable2469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__NameAssignment_in_ruleVariable2495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullValue_in_entryRuleNullValue2522 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullValue2529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NullValue__Group__0_in_ruleNullValue2555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumValue_in_entryRuleEnumValue2582 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumValue2589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumValue__EnumValueAssignment_in_ruleEnumValue2615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodReference_in_entryRuleMethodReference2642 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodReference2649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__0_in_ruleMethodReference2675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecutionMultiplier_in_entryRuleExecutionMultiplier2702 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExecutionMultiplier2709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionMultiplier__Group__0_in_ruleExecutionMultiplier2735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2762 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName2769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName2795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_entryRuleQualifiedJavaClassName2822 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedJavaClassName2829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__0_in_ruleQualifiedJavaClassName2855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard2882 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard2889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__0_in_ruleQualifiedNameWithWildcard2915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDefinition_in_rule__Statement__Alternatives2951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__Statement__Alternatives2968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_rule__Statement__Alternatives2985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__PackageStatement__Alternatives3017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForkDefinition_in_rule__PackageStatement__Alternatives3034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestDefinition_in_rule__PackageStatement__Alternatives3051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallDefinition_in_rule__PackageStatement__Alternatives3068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteDefinition_in_rule__PackageStatement__Alternatives3085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_rule__PackageStatement__Alternatives3102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantDefinition_in_rule__PackageStatement__Alternatives3119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteStatementWithResult_in_rule__SuiteStatement__Alternatives3151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_rule__SuiteStatement__Alternatives3168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_rule__SuiteStatement__Alternatives3185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantDefinition_in_rule__SuiteStatement__Alternatives3202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleSingleLineComment_in_rule__SuiteStatement__Alternatives3219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleMultiLineComment_in_rule__SuiteStatement__Alternatives3236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_rule__SuiteStatementWithResult__Alternatives3268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTest_in_rule__SuiteStatementWithResult__Alternatives3285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTableTest_in_rule__SuiteStatementWithResult__Alternatives3302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedResultName_in_rule__ResultName__Alternatives3334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterOrResultName_in_rule__ResultName__Alternatives3351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedParameterName_in_rule__ParameterName__Alternatives3383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterOrResultName_in_rule__ParameterName__Alternatives3400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__ValueOrEnumValue__Alternatives3432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumValue_in_rule__ValueOrEnumValue__Alternatives3449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringValue_in_rule__Value__Alternatives3481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerValue_in_rule__Value__Alternatives3498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalValue_in_rule__Value__Alternatives3515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanValue_in_rule__Value__Alternatives3532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__Value__Alternatives3549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullValue_in_rule__Value__Alternatives3566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOLEAN_TRUE_in_rule__BooleanValue__BooleanValueAlternatives_03598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOLEAN_FALSE_in_rule__BooleanValue__BooleanValueAlternatives_03615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__0__Impl_in_rule__PackageDefinition__Group__03645 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__1_in_rule__PackageDefinition__Group__03648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__PackageDefinition__Group__0__Impl3676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__1__Impl_in_rule__PackageDefinition__Group__13707 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__2_in_rule__PackageDefinition__Group__13710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__NameAssignment_1_in_rule__PackageDefinition__Group__1__Impl3737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__2__Impl_in_rule__PackageDefinition__Group__23767 = new BitSet(new long[]{0x0000000143B80000L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__3_in_rule__PackageDefinition__Group__23770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__PackageDefinition__Group__2__Impl3798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__3__Impl_in_rule__PackageDefinition__Group__33829 = new BitSet(new long[]{0x0000000143B80000L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__4_in_rule__PackageDefinition__Group__33832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__StatementsAssignment_3_in_rule__PackageDefinition__Group__3__Impl3859 = new BitSet(new long[]{0x0000000143B00002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__4__Impl_in_rule__PackageDefinition__Group__43890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__PackageDefinition__Group__4__Impl3918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__03959 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__03962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Import__Group__0__Impl3990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__14021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl4048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ForkDefinition__Group__0__Impl_in_rule__ForkDefinition__Group__04082 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ForkDefinition__Group__1_in_rule__ForkDefinition__Group__04085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ForkDefinition__Group__0__Impl4113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ForkDefinition__Group__1__Impl_in_rule__ForkDefinition__Group__14144 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_rule__ForkDefinition__Group__2_in_rule__ForkDefinition__Group__14147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ForkDefinition__NameAssignment_1_in_rule__ForkDefinition__Group__1__Impl4174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ForkDefinition__Group__2__Impl_in_rule__ForkDefinition__Group__24204 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_rule__ForkDefinition__Group__3_in_rule__ForkDefinition__Group__24207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ForkDefinition__DescriptionAssignment_2_in_rule__ForkDefinition__Group__2__Impl4234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ForkDefinition__Group__3__Impl_in_rule__ForkDefinition__Group__34265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ForkDefinition__Group_3__0_in_rule__ForkDefinition__Group__3__Impl4292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ForkDefinition__Group_3__0__Impl_in_rule__ForkDefinition__Group_3__04331 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ForkDefinition__Group_3__1_in_rule__ForkDefinition__Group_3__04334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ForkDefinition__Group_3__0__Impl4362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ForkDefinition__Group_3__1__Impl_in_rule__ForkDefinition__Group_3__14393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ForkDefinition__ForkerClassAssignment_3_1_in_rule__ForkDefinition__Group_3__1__Impl4420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__0__Impl_in_rule__TestDefinition__Group__04454 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__1_in_rule__TestDefinition__Group__04457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__TestDefinition__Group__0__Impl4485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__1__Impl_in_rule__TestDefinition__Group__14516 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__2_in_rule__TestDefinition__Group__14519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__NameAssignment_1_in_rule__TestDefinition__Group__1__Impl4546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__2__Impl_in_rule__TestDefinition__Group__24576 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__3_in_rule__TestDefinition__Group__24579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__TestDefinition__Group__2__Impl4607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__3__Impl_in_rule__TestDefinition__Group__34638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__FixtureMethodAssignment_3_in_rule__TestDefinition__Group__3__Impl4665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__0__Impl_in_rule__CallDefinition__Group__04703 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__1_in_rule__CallDefinition__Group__04706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__CallDefinition__Group__0__Impl4734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__1__Impl_in_rule__CallDefinition__Group__14765 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__2_in_rule__CallDefinition__Group__14768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__NameAssignment_1_in_rule__CallDefinition__Group__1__Impl4795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__2__Impl_in_rule__CallDefinition__Group__24825 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__3_in_rule__CallDefinition__Group__24828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__CallDefinition__Group__2__Impl4856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__3__Impl_in_rule__CallDefinition__Group__34887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__FixtureMethodAssignment_3_in_rule__CallDefinition__Group__3__Impl4914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__0__Impl_in_rule__SuiteDefinition__Group__04952 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__1_in_rule__SuiteDefinition__Group__04955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__SuiteDefinition__Group__0__Impl4983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__1__Impl_in_rule__SuiteDefinition__Group__15014 = new BitSet(new long[]{0x0000000018040000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__2_in_rule__SuiteDefinition__Group__15017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__NameAssignment_1_in_rule__SuiteDefinition__Group__1__Impl5044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__2__Impl_in_rule__SuiteDefinition__Group__25074 = new BitSet(new long[]{0x0000000018040000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__3_in_rule__SuiteDefinition__Group__25077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_2__0_in_rule__SuiteDefinition__Group__2__Impl5104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__3__Impl_in_rule__SuiteDefinition__Group__35135 = new BitSet(new long[]{0x0000000018040000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__4_in_rule__SuiteDefinition__Group__35138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_3__0_in_rule__SuiteDefinition__Group__3__Impl5165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__4__Impl_in_rule__SuiteDefinition__Group__45196 = new BitSet(new long[]{0x000000AB47B20300L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__5_in_rule__SuiteDefinition__Group__45199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__SuiteDefinition__Group__4__Impl5227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__5__Impl_in_rule__SuiteDefinition__Group__55258 = new BitSet(new long[]{0x000000AB47B20300L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__6_in_rule__SuiteDefinition__Group__55261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__StatementsAssignment_5_in_rule__SuiteDefinition__Group__5__Impl5288 = new BitSet(new long[]{0x000000AB43B20302L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__6__Impl_in_rule__SuiteDefinition__Group__65319 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__7_in_rule__SuiteDefinition__Group__65322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__SuiteDefinition__Group__6__Impl5350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__7__Impl_in_rule__SuiteDefinition__Group__75381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_7__0_in_rule__SuiteDefinition__Group__7__Impl5408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_2__0__Impl_in_rule__SuiteDefinition__Group_2__05455 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_2__1_in_rule__SuiteDefinition__Group_2__05458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__SuiteDefinition__Group_2__0__Impl5486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_2__1__Impl_in_rule__SuiteDefinition__Group_2__15517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__ParametersAssignment_2_1_in_rule__SuiteDefinition__Group_2__1__Impl5544 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_3__0__Impl_in_rule__SuiteDefinition__Group_3__05579 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_3__1_in_rule__SuiteDefinition__Group_3__05582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__SuiteDefinition__Group_3__0__Impl5610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_3__1__Impl_in_rule__SuiteDefinition__Group_3__15641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__DependenciesAssignment_3_1_in_rule__SuiteDefinition__Group_3__1__Impl5668 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_7__0__Impl_in_rule__SuiteDefinition__Group_7__05703 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_7__1_in_rule__SuiteDefinition__Group_7__05706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__SuiteDefinition__Group_7__0__Impl5734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_7__1__Impl_in_rule__SuiteDefinition__Group_7__15765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__FinalizersAssignment_7_1_in_rule__SuiteDefinition__Group_7__1__Impl5792 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__0__Impl_in_rule__VariableDefinition__Group__05827 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__1_in_rule__VariableDefinition__Group__05830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__VariableDefinition__Group__0__Impl5858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__1__Impl_in_rule__VariableDefinition__Group__15889 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__2_in_rule__VariableDefinition__Group__15892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__NameAssignment_1_in_rule__VariableDefinition__Group__1__Impl5919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__2__Impl_in_rule__VariableDefinition__Group__25949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group_2__0_in_rule__VariableDefinition__Group__2__Impl5976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group_2__0__Impl_in_rule__VariableDefinition__Group_2__06013 = new BitSet(new long[]{0x0000100000001C70L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group_2__1_in_rule__VariableDefinition__Group_2__06016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__VariableDefinition__Group_2__0__Impl6044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group_2__1__Impl_in_rule__VariableDefinition__Group_2__16075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__InitialValueAssignment_2_1_in_rule__VariableDefinition__Group_2__1__Impl6102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstantDefinition__Group__0__Impl_in_rule__ConstantDefinition__Group__06136 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ConstantDefinition__Group__1_in_rule__ConstantDefinition__Group__06139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__ConstantDefinition__Group__0__Impl6167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstantDefinition__Group__1__Impl_in_rule__ConstantDefinition__Group__16198 = new BitSet(new long[]{0x0000100000001C70L});
    public static final BitSet FOLLOW_rule__ConstantDefinition__Group__2_in_rule__ConstantDefinition__Group__16201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstantDefinition__NameAssignment_1_in_rule__ConstantDefinition__Group__1__Impl6228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstantDefinition__Group__2__Impl_in_rule__ConstantDefinition__Group__26258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstantDefinition__ValueAssignment_2_in_rule__ConstantDefinition__Group__2__Impl6285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group__0__Impl_in_rule__Test__Group__06321 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Test__Group__1_in_rule__Test__Group__06324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Test__Group__0__Impl6352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group__1__Impl_in_rule__Test__Group__16383 = new BitSet(new long[]{0x0000040400000040L});
    public static final BitSet FOLLOW_rule__Test__Group__2_in_rule__Test__Group__16386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__DefinitionAssignment_1_in_rule__Test__Group__1__Impl6413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group__2__Impl_in_rule__Test__Group__26443 = new BitSet(new long[]{0x0000040400000040L});
    public static final BitSet FOLLOW_rule__Test__Group__3_in_rule__Test__Group__26446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__ParametersAssignment_2_in_rule__Test__Group__2__Impl6473 = new BitSet(new long[]{0x0000040000000042L});
    public static final BitSet FOLLOW_rule__Test__Group__3__Impl_in_rule__Test__Group__36504 = new BitSet(new long[]{0x0000040400000040L});
    public static final BitSet FOLLOW_rule__Test__Group__4_in_rule__Test__Group__36507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__ResultsAssignment_3_in_rule__Test__Group__3__Impl6534 = new BitSet(new long[]{0x0000040000000042L});
    public static final BitSet FOLLOW_rule__Test__Group__4__Impl_in_rule__Test__Group__46565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group_4__0_in_rule__Test__Group__4__Impl6592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group_4__0__Impl_in_rule__Test__Group_4__06633 = new BitSet(new long[]{0x0000100000001CF0L});
    public static final BitSet FOLLOW_rule__Test__Group_4__1_in_rule__Test__Group_4__06636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Test__Group_4__0__Impl6664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group_4__1__Impl_in_rule__Test__Group_4__16695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__ResultAssignment_4_1_in_rule__Test__Group_4__1__Impl6722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group__0__Impl_in_rule__TableTest__Group__06756 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__TableTest__Group__1_in_rule__TableTest__Group__06759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__TableTest__Group__0__Impl6787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group__1__Impl_in_rule__TableTest__Group__16818 = new BitSet(new long[]{0x0000041000000040L});
    public static final BitSet FOLLOW_rule__TableTest__Group__2_in_rule__TableTest__Group__16821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__DefinitionAssignment_1_in_rule__TableTest__Group__1__Impl6848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group__2__Impl_in_rule__TableTest__Group__26878 = new BitSet(new long[]{0x0000041000000040L});
    public static final BitSet FOLLOW_rule__TableTest__Group__3_in_rule__TableTest__Group__26881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__ParametersAssignment_2_in_rule__TableTest__Group__2__Impl6908 = new BitSet(new long[]{0x0000040000000042L});
    public static final BitSet FOLLOW_rule__TableTest__Group__3__Impl_in_rule__TableTest__Group__36939 = new BitSet(new long[]{0x0000041000000040L});
    public static final BitSet FOLLOW_rule__TableTest__Group__4_in_rule__TableTest__Group__36942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__ParameterHeadersAssignment_3_in_rule__TableTest__Group__3__Impl6969 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group__4__Impl_in_rule__TableTest__Group__47000 = new BitSet(new long[]{0x0000041000000040L});
    public static final BitSet FOLLOW_rule__TableTest__Group__5_in_rule__TableTest__Group__47003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__ResultHeadersAssignment_4_in_rule__TableTest__Group__4__Impl7030 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group__5__Impl_in_rule__TableTest__Group__57061 = new BitSet(new long[]{0x0000001400000000L});
    public static final BitSet FOLLOW_rule__TableTest__Group__6_in_rule__TableTest__Group__57064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__TableTest__Group__5__Impl7092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group__6__Impl_in_rule__TableTest__Group__67123 = new BitSet(new long[]{0x0000001400000000L});
    public static final BitSet FOLLOW_rule__TableTest__Group__7_in_rule__TableTest__Group__67126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group_6__0_in_rule__TableTest__Group__6__Impl7153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group__7__Impl_in_rule__TableTest__Group__77184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__RowsAssignment_7_in_rule__TableTest__Group__7__Impl7213 = new BitSet(new long[]{0x0000001400000002L});
    public static final BitSet FOLLOW_rule__TableTest__RowsAssignment_7_in_rule__TableTest__Group__7__Impl7225 = new BitSet(new long[]{0x0000001400000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group_6__0__Impl_in_rule__TableTest__Group_6__07274 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__TableTest__Group_6__1_in_rule__TableTest__Group_6__07277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__DefaultResultColumnAssignment_6_0_in_rule__TableTest__Group_6__0__Impl7304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group_6__1__Impl_in_rule__TableTest__Group_6__17334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__TableTest__Group_6__1__Impl7362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group__0__Impl_in_rule__TableTestRow__Group__07397 = new BitSet(new long[]{0x0000001400000000L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group__1_in_rule__TableTestRow__Group__07400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group__1__Impl_in_rule__TableTestRow__Group__17458 = new BitSet(new long[]{0x0000001400000000L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group__2_in_rule__TableTestRow__Group__17461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__ValuesAssignment_1_in_rule__TableTestRow__Group__1__Impl7488 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group__2__Impl_in_rule__TableTestRow__Group__27519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__TableTestRow__Group__2__Impl7547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableHeader__Group__0__Impl_in_rule__ParameterTableHeader__Group__07584 = new BitSet(new long[]{0x0000040000000040L});
    public static final BitSet FOLLOW_rule__ParameterTableHeader__Group__1_in_rule__ParameterTableHeader__Group__07587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ParameterTableHeader__Group__0__Impl7615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableHeader__Group__1__Impl_in_rule__ParameterTableHeader__Group__17646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableHeader__NameAssignment_1_in_rule__ParameterTableHeader__Group__1__Impl7673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultTableHeader__Group__0__Impl_in_rule__ResultTableHeader__Group__07707 = new BitSet(new long[]{0x0000040000000040L});
    public static final BitSet FOLLOW_rule__ResultTableHeader__Group__1_in_rule__ResultTableHeader__Group__07710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ResultTableHeader__Group__0__Impl7738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultTableHeader__Group__1__Impl_in_rule__ResultTableHeader__Group__17769 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__ResultTableHeader__Group__2_in_rule__ResultTableHeader__Group__17772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultTableHeader__NameAssignment_1_in_rule__ResultTableHeader__Group__1__Impl7799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultTableHeader__Group__2__Impl_in_rule__ResultTableHeader__Group__27829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__ResultTableHeader__Group__2__Impl7857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableValue__Group__0__Impl_in_rule__ParameterTableValue__Group__07894 = new BitSet(new long[]{0x0000100000001CF0L});
    public static final BitSet FOLLOW_rule__ParameterTableValue__Group__1_in_rule__ParameterTableValue__Group__07897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__ParameterTableValue__Group__0__Impl7925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableValue__Group__1__Impl_in_rule__ParameterTableValue__Group__17956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableValue__ValueAssignment_1_in_rule__ParameterTableValue__Group__1__Impl7983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedResult__Group__0__Impl_in_rule__NamedResult__Group__08017 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__NamedResult__Group__1_in_rule__NamedResult__Group__08020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedResult__NameAssignment_0_in_rule__NamedResult__Group__0__Impl8047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedResult__Group__1__Impl_in_rule__NamedResult__Group__18077 = new BitSet(new long[]{0x0000100000001CF0L});
    public static final BitSet FOLLOW_rule__NamedResult__Group__2_in_rule__NamedResult__Group__18080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__NamedResult__Group__1__Impl8108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedResult__Group__2__Impl_in_rule__NamedResult__Group__28139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedResult__ValueAssignment_2_in_rule__NamedResult__Group__2__Impl8166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__0__Impl_in_rule__Call__Group__08202 = new BitSet(new long[]{0x0000000000000840L});
    public static final BitSet FOLLOW_rule__Call__Group__1_in_rule__Call__Group__08205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Call__Group__0__Impl8233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__1__Impl_in_rule__Call__Group__18264 = new BitSet(new long[]{0x0000000000000840L});
    public static final BitSet FOLLOW_rule__Call__Group__2_in_rule__Call__Group__18267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__MultiplierAssignment_1_in_rule__Call__Group__1__Impl8294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__2__Impl_in_rule__Call__Group__28325 = new BitSet(new long[]{0x0000044000000040L});
    public static final BitSet FOLLOW_rule__Call__Group__3_in_rule__Call__Group__28328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__DefinitionAssignment_2_in_rule__Call__Group__2__Impl8355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__3__Impl_in_rule__Call__Group__38385 = new BitSet(new long[]{0x0000044000000040L});
    public static final BitSet FOLLOW_rule__Call__Group__4_in_rule__Call__Group__38388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__ParametersAssignment_3_in_rule__Call__Group__3__Impl8415 = new BitSet(new long[]{0x0000040000000042L});
    public static final BitSet FOLLOW_rule__Call__Group__4__Impl_in_rule__Call__Group__48446 = new BitSet(new long[]{0x0000044000000040L});
    public static final BitSet FOLLOW_rule__Call__Group__5_in_rule__Call__Group__48449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__ResultsAssignment_4_in_rule__Call__Group__4__Impl8476 = new BitSet(new long[]{0x0000040000000042L});
    public static final BitSet FOLLOW_rule__Call__Group__5__Impl_in_rule__Call__Group__58507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group_5__0_in_rule__Call__Group__5__Impl8534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group_5__0__Impl_in_rule__Call__Group_5__08577 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Call__Group_5__1_in_rule__Call__Group_5__08580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Call__Group_5__0__Impl8608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group_5__1__Impl_in_rule__Call__Group_5__18639 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__ResultAssignment_5_1_in_rule__Call__Group_5__1__Impl8666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedCallResult__Group__0__Impl_in_rule__NamedCallResult__Group__08700 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__NamedCallResult__Group__1_in_rule__NamedCallResult__Group__08703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedCallResult__NameAssignment_0_in_rule__NamedCallResult__Group__0__Impl8730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedCallResult__Group__1__Impl_in_rule__NamedCallResult__Group__18760 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__NamedCallResult__Group__2_in_rule__NamedCallResult__Group__18763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__NamedCallResult__Group__1__Impl8791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedCallResult__Group__2__Impl_in_rule__NamedCallResult__Group__28822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedCallResult__TargetAssignment_2_in_rule__NamedCallResult__Group__2__Impl8849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group__0__Impl_in_rule__Suite__Group__08885 = new BitSet(new long[]{0x0000000000000840L});
    public static final BitSet FOLLOW_rule__Suite__Group__1_in_rule__Suite__Group__08888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__Suite__Group__0__Impl8916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group__1__Impl_in_rule__Suite__Group__18947 = new BitSet(new long[]{0x0000000000000840L});
    public static final BitSet FOLLOW_rule__Suite__Group__2_in_rule__Suite__Group__18950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__MultiplierAssignment_1_in_rule__Suite__Group__1__Impl8977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group__2__Impl_in_rule__Suite__Group__29008 = new BitSet(new long[]{0x0000010000000040L});
    public static final BitSet FOLLOW_rule__Suite__Group__3_in_rule__Suite__Group__29011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__DefinitionAssignment_2_in_rule__Suite__Group__2__Impl9038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group__3__Impl_in_rule__Suite__Group__39068 = new BitSet(new long[]{0x0000010000000040L});
    public static final BitSet FOLLOW_rule__Suite__Group__4_in_rule__Suite__Group__39071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__ParametersAssignment_3_in_rule__Suite__Group__3__Impl9098 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_rule__Suite__Group__4__Impl_in_rule__Suite__Group__49129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group_4__0_in_rule__Suite__Group__4__Impl9156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group_4__0__Impl_in_rule__Suite__Group_4__09197 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__Suite__Group_4__1_in_rule__Suite__Group_4__09200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__Suite__Group_4__0__Impl9228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group_4__1__Impl_in_rule__Suite__Group_4__19259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__ForkAssignment_4_1_in_rule__Suite__Group_4__1__Impl9286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__0__Impl_in_rule__SuiteParameter__Group__09320 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__1_in_rule__SuiteParameter__Group__09323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__NameAssignment_0_in_rule__SuiteParameter__Group__0__Impl9350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__1__Impl_in_rule__SuiteParameter__Group__19380 = new BitSet(new long[]{0x0000100000001C70L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__2_in_rule__SuiteParameter__Group__19383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__SuiteParameter__Group__1__Impl9411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__2__Impl_in_rule__SuiteParameter__Group__29442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__ValueAssignment_2_in_rule__SuiteParameter__Group__2__Impl9469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__09505 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__09508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__NameAssignment_0_in_rule__Parameter__Group__0__Impl9535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__19565 = new BitSet(new long[]{0x0000100000001CF0L});
    public static final BitSet FOLLOW_rule__Parameter__Group__2_in_rule__Parameter__Group__19568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__Parameter__Group__1__Impl9596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__2__Impl_in_rule__Parameter__Group__29627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__ValueAssignment_2_in_rule__Parameter__Group__2__Impl9654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArbitraryParameterOrResultName__Group__0__Impl_in_rule__ArbitraryParameterOrResultName__Group__09690 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__ArbitraryParameterOrResultName__Group__1_in_rule__ArbitraryParameterOrResultName__Group__09693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__ArbitraryParameterOrResultName__Group__0__Impl9721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArbitraryParameterOrResultName__Group__1__Impl_in_rule__ArbitraryParameterOrResultName__Group__19752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArbitraryParameterOrResultName__IdentifierAssignment_1_in_rule__ArbitraryParameterOrResultName__Group__1__Impl9779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueOrEnumValueCollection__Group__0__Impl_in_rule__ValueOrEnumValueCollection__Group__09813 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_rule__ValueOrEnumValueCollection__Group__1_in_rule__ValueOrEnumValueCollection__Group__09816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueOrEnumValueCollection__ValueAssignment_0_in_rule__ValueOrEnumValueCollection__Group__0__Impl9843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueOrEnumValueCollection__Group__1__Impl_in_rule__ValueOrEnumValueCollection__Group__19873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueOrEnumValueCollection__Group_1__0_in_rule__ValueOrEnumValueCollection__Group__1__Impl9900 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_rule__ValueOrEnumValueCollection__Group_1__0__Impl_in_rule__ValueOrEnumValueCollection__Group_1__09935 = new BitSet(new long[]{0x0000100000001CF0L});
    public static final BitSet FOLLOW_rule__ValueOrEnumValueCollection__Group_1__1_in_rule__ValueOrEnumValueCollection__Group_1__09938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__ValueOrEnumValueCollection__Group_1__0__Impl9966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueOrEnumValueCollection__Group_1__1__Impl_in_rule__ValueOrEnumValueCollection__Group_1__19997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueOrEnumValueCollection__MoreValuesAssignment_1_1_in_rule__ValueOrEnumValueCollection__Group_1__1__Impl10024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NullValue__Group__0__Impl_in_rule__NullValue__Group__010058 = new BitSet(new long[]{0x0000100000001C70L});
    public static final BitSet FOLLOW_rule__NullValue__Group__1_in_rule__NullValue__Group__010061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NullValue__Group__1__Impl_in_rule__NullValue__Group__110119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__NullValue__Group__1__Impl10147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__0__Impl_in_rule__MethodReference__Group__010182 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__1_in_rule__MethodReference__Group__010185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__TypeAssignment_0_in_rule__MethodReference__Group__0__Impl10212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__1__Impl_in_rule__MethodReference__Group__110242 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__2_in_rule__MethodReference__Group__110245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__MethodReference__Group__1__Impl10273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__2__Impl_in_rule__MethodReference__Group__210304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__MethodAssignment_2_in_rule__MethodReference__Group__2__Impl10331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionMultiplier__Group__0__Impl_in_rule__ExecutionMultiplier__Group__010367 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_rule__ExecutionMultiplier__Group__1_in_rule__ExecutionMultiplier__Group__010370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionMultiplier__CountAssignment_0_in_rule__ExecutionMultiplier__Group__0__Impl10397 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExecutionMultiplier__Group__1__Impl_in_rule__ExecutionMultiplier__Group__110427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__ExecutionMultiplier__Group__1__Impl10455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__010490 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__010493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl10520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__110549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl10576 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__010611 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__010614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__QualifiedName__Group_1__0__Impl10642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__110673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl10700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__0__Impl_in_rule__QualifiedJavaClassName__Group__010733 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__1_in_rule__QualifiedJavaClassName__Group__010736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedJavaClassName__Group__0__Impl10763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__1__Impl_in_rule__QualifiedJavaClassName__Group__110792 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__2_in_rule__QualifiedJavaClassName__Group__110795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rule__QualifiedJavaClassName__Group__1__Impl10823 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__2__Impl_in_rule__QualifiedJavaClassName__Group__210854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UPPERCASE_ID_in_rule__QualifiedJavaClassName__Group__2__Impl10881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__0__Impl_in_rule__QualifiedNameWithWildcard__Group__010916 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__1_in_rule__QualifiedNameWithWildcard__Group__010919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildcard__Group__0__Impl10946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__1__Impl_in_rule__QualifiedNameWithWildcard__Group__110975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rule__QualifiedNameWithWildcard__Group__1__Impl11004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_rule__Model__StatementsAssignment11046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SL_VISIBLE_COMMENT_in_rule__VisibleSingleLineComment__ContentAssignment11077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ML_VISIBLE_COMMENT_in_rule__VisibleMultiLineComment__ContentAssignment11108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__PackageDefinition__NameAssignment_111139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageStatement_in_rule__PackageDefinition__StatementsAssignment_311170 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_rule__Import__ImportedNamespaceAssignment_111201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__ForkDefinition__NameAssignment_111232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ForkDefinition__DescriptionAssignment_211263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_rule__ForkDefinition__ForkerClassAssignment_3_111298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__TestDefinition__NameAssignment_111333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodReference_in_rule__TestDefinition__FixtureMethodAssignment_311364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__CallDefinition__NameAssignment_111395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodReference_in_rule__CallDefinition__FixtureMethodAssignment_311426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__NameAssignment_111457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_rule__SuiteDefinition__ParametersAssignment_2_111488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__DependenciesAssignment_3_111523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteStatement_in_rule__SuiteDefinition__StatementsAssignment_511558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__FinalizersAssignment_7_111593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_rule__VariableDefinition__NameAssignment_111628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__VariableDefinition__InitialValueAssignment_2_111659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_rule__ConstantDefinition__NameAssignment_111690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__ConstantDefinition__ValueAssignment_211721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__VariableEntity__NameAssignment11752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Test__DefinitionAssignment_111787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_rule__Test__ParametersAssignment_211822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedResult_in_rule__Test__ResultsAssignment_311853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueCollection_in_rule__Test__ResultAssignment_4_111884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__TableTest__DefinitionAssignment_111919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_rule__TableTest__ParametersAssignment_211954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableHeader_in_rule__TableTest__ParameterHeadersAssignment_311985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultTableHeader_in_rule__TableTest__ResultHeadersAssignment_412016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__TableTest__DefaultResultColumnAssignment_6_012052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTableTestRow_in_rule__TableTest__RowsAssignment_712091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableValue_in_rule__TableTestRow__ValuesAssignment_112122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterName_in_rule__ParameterTableHeader__NameAssignment_112153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultName_in_rule__ResultTableHeader__NameAssignment_112184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueCollection_in_rule__ParameterTableValue__ValueAssignment_112215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultName_in_rule__NamedResult__NameAssignment_012246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueCollection_in_rule__NamedResult__ValueAssignment_212277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FixedResultName__FieldAssignment12312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecutionMultiplier_in_rule__Call__MultiplierAssignment_112347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Call__DefinitionAssignment_212382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_rule__Call__ParametersAssignment_312417 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedCallResult_in_rule__Call__ResultsAssignment_412448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__Call__ResultAssignment_5_112479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultName_in_rule__NamedCallResult__NameAssignment_012510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__NamedCallResult__TargetAssignment_212541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecutionMultiplier_in_rule__Suite__MultiplierAssignment_112572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Suite__DefinitionAssignment_212607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteParameter_in_rule__Suite__ParametersAssignment_312642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Suite__ForkAssignment_4_112677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__SuiteParameter__NameAssignment_012716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__SuiteParameter__ValueAssignment_212751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterName_in_rule__Parameter__NameAssignment_012782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueCollection_in_rule__Parameter__ValueAssignment_212813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FixedParameterName__AnnotationAssignment12848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ArbitraryParameterOrResultName__IdentifierAssignment_112883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_rule__ValueOrEnumValueCollection__ValueAssignment_012914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_rule__ValueOrEnumValueCollection__MoreValuesAssignment_1_112945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_rule__IntegerValue__IntegerValueAssignment12976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DECIMAL_in_rule__DecimalValue__DecimalValueAssignment13007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringValue__StringValueAssignment13038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__BooleanValue__BooleanValueAlternatives_0_in_rule__BooleanValue__BooleanValueAssignment13069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Variable__NameAssignment13106 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UPPERCASE_ID_in_rule__EnumValue__EnumValueAssignment13145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_rule__MethodReference__TypeAssignment_013184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__MethodReference__MethodAssignment_213223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_rule__ExecutionMultiplier__CountAssignment_013258 = new BitSet(new long[]{0x0000000000000002L});

}