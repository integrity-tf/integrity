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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_UPPERCASE_ID", "RULE_SL_VISIBLE_COMMENT", "RULE_ML_VISIBLE_COMMENT", "RULE_STRING", "RULE_INTEGER", "RULE_DECIMAL", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'|'", "'packagedef'", "'with'", "'packageend'", "'import'", "'forkdef'", "'testdef'", "'uses'", "'calldef'", "'suitedef'", "'suiteend'", "'gets'", "'requires'", "'concludedby'", "'variable'", "'initially'", "'constant'", "'test'", "'='", "'tabletest'", "'call'", "'->'", "'suite'", "'on'", "':'", "'+'", "'#'", "'.'", "'.*'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int T__21=21;
    public static final int RULE_ANY_OTHER=14;
    public static final int T__20=20;
    public static final int RULE_SL_VISIBLE_COMMENT=6;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int RULE_UPPERCASE_ID=5;
    public static final int RULE_DECIMAL=10;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int RULE_ML_VISIBLE_COMMENT=7;
    public static final int RULE_SL_COMMENT=12;
    public static final int RULE_ML_COMMENT=11;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_STRING=8;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=13;
    public static final int RULE_INTEGER=9;

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

                if ( (LA1_0==16||LA1_0==19||LA1_0==37) ) {
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


    // $ANTLR start "entryRuleValueOrEnumValue"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:984:1: entryRuleValueOrEnumValue : ruleValueOrEnumValue EOF ;
    public final void entryRuleValueOrEnumValue() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:985:1: ( ruleValueOrEnumValue EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:986:1: ruleValueOrEnumValue EOF
            {
             before(grammarAccess.getValueOrEnumValueRule()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_entryRuleValueOrEnumValue2042);
            ruleValueOrEnumValue();

            state._fsp--;

             after(grammarAccess.getValueOrEnumValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueOrEnumValue2049); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:993:1: ruleValueOrEnumValue : ( ( rule__ValueOrEnumValue__Alternatives ) ) ;
    public final void ruleValueOrEnumValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:997:2: ( ( ( rule__ValueOrEnumValue__Alternatives ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:998:1: ( ( rule__ValueOrEnumValue__Alternatives ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:998:1: ( ( rule__ValueOrEnumValue__Alternatives ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:999:1: ( rule__ValueOrEnumValue__Alternatives )
            {
             before(grammarAccess.getValueOrEnumValueAccess().getAlternatives()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1000:1: ( rule__ValueOrEnumValue__Alternatives )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1000:2: rule__ValueOrEnumValue__Alternatives
            {
            pushFollow(FOLLOW_rule__ValueOrEnumValue__Alternatives_in_ruleValueOrEnumValue2075);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1012:1: entryRuleValue : ruleValue EOF ;
    public final void entryRuleValue() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1013:1: ( ruleValue EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1014:1: ruleValue EOF
            {
             before(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue2102);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue2109); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1021:1: ruleValue : ( ( rule__Value__Alternatives ) ) ;
    public final void ruleValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1025:2: ( ( ( rule__Value__Alternatives ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1026:1: ( ( rule__Value__Alternatives ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1026:1: ( ( rule__Value__Alternatives ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1027:1: ( rule__Value__Alternatives )
            {
             before(grammarAccess.getValueAccess().getAlternatives()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1028:1: ( rule__Value__Alternatives )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1028:2: rule__Value__Alternatives
            {
            pushFollow(FOLLOW_rule__Value__Alternatives_in_ruleValue2135);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1040:1: entryRuleIntegerValue : ruleIntegerValue EOF ;
    public final void entryRuleIntegerValue() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1041:1: ( ruleIntegerValue EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1042:1: ruleIntegerValue EOF
            {
             before(grammarAccess.getIntegerValueRule()); 
            pushFollow(FOLLOW_ruleIntegerValue_in_entryRuleIntegerValue2162);
            ruleIntegerValue();

            state._fsp--;

             after(grammarAccess.getIntegerValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerValue2169); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1049:1: ruleIntegerValue : ( ( rule__IntegerValue__IntegerValueAssignment ) ) ;
    public final void ruleIntegerValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1053:2: ( ( ( rule__IntegerValue__IntegerValueAssignment ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1054:1: ( ( rule__IntegerValue__IntegerValueAssignment ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1054:1: ( ( rule__IntegerValue__IntegerValueAssignment ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1055:1: ( rule__IntegerValue__IntegerValueAssignment )
            {
             before(grammarAccess.getIntegerValueAccess().getIntegerValueAssignment()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1056:1: ( rule__IntegerValue__IntegerValueAssignment )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1056:2: rule__IntegerValue__IntegerValueAssignment
            {
            pushFollow(FOLLOW_rule__IntegerValue__IntegerValueAssignment_in_ruleIntegerValue2195);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1068:1: entryRuleDecimalValue : ruleDecimalValue EOF ;
    public final void entryRuleDecimalValue() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1069:1: ( ruleDecimalValue EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1070:1: ruleDecimalValue EOF
            {
             before(grammarAccess.getDecimalValueRule()); 
            pushFollow(FOLLOW_ruleDecimalValue_in_entryRuleDecimalValue2222);
            ruleDecimalValue();

            state._fsp--;

             after(grammarAccess.getDecimalValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalValue2229); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1077:1: ruleDecimalValue : ( ( rule__DecimalValue__DecimalValueAssignment ) ) ;
    public final void ruleDecimalValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1081:2: ( ( ( rule__DecimalValue__DecimalValueAssignment ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1082:1: ( ( rule__DecimalValue__DecimalValueAssignment ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1082:1: ( ( rule__DecimalValue__DecimalValueAssignment ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1083:1: ( rule__DecimalValue__DecimalValueAssignment )
            {
             before(grammarAccess.getDecimalValueAccess().getDecimalValueAssignment()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1084:1: ( rule__DecimalValue__DecimalValueAssignment )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1084:2: rule__DecimalValue__DecimalValueAssignment
            {
            pushFollow(FOLLOW_rule__DecimalValue__DecimalValueAssignment_in_ruleDecimalValue2255);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1096:1: entryRuleStringValue : ruleStringValue EOF ;
    public final void entryRuleStringValue() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1097:1: ( ruleStringValue EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1098:1: ruleStringValue EOF
            {
             before(grammarAccess.getStringValueRule()); 
            pushFollow(FOLLOW_ruleStringValue_in_entryRuleStringValue2282);
            ruleStringValue();

            state._fsp--;

             after(grammarAccess.getStringValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringValue2289); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1105:1: ruleStringValue : ( ( rule__StringValue__StringValueAssignment ) ) ;
    public final void ruleStringValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1109:2: ( ( ( rule__StringValue__StringValueAssignment ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1110:1: ( ( rule__StringValue__StringValueAssignment ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1110:1: ( ( rule__StringValue__StringValueAssignment ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1111:1: ( rule__StringValue__StringValueAssignment )
            {
             before(grammarAccess.getStringValueAccess().getStringValueAssignment()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1112:1: ( rule__StringValue__StringValueAssignment )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1112:2: rule__StringValue__StringValueAssignment
            {
            pushFollow(FOLLOW_rule__StringValue__StringValueAssignment_in_ruleStringValue2315);
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


    // $ANTLR start "entryRuleVariable"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1124:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1125:1: ( ruleVariable EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1126:1: ruleVariable EOF
            {
             before(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable2342);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getVariableRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable2349); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1133:1: ruleVariable : ( ( rule__Variable__NameAssignment ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1137:2: ( ( ( rule__Variable__NameAssignment ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1138:1: ( ( rule__Variable__NameAssignment ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1138:1: ( ( rule__Variable__NameAssignment ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1139:1: ( rule__Variable__NameAssignment )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1140:1: ( rule__Variable__NameAssignment )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1140:2: rule__Variable__NameAssignment
            {
            pushFollow(FOLLOW_rule__Variable__NameAssignment_in_ruleVariable2375);
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


    // $ANTLR start "entryRuleEnumValue"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1152:1: entryRuleEnumValue : ruleEnumValue EOF ;
    public final void entryRuleEnumValue() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1153:1: ( ruleEnumValue EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1154:1: ruleEnumValue EOF
            {
             before(grammarAccess.getEnumValueRule()); 
            pushFollow(FOLLOW_ruleEnumValue_in_entryRuleEnumValue2402);
            ruleEnumValue();

            state._fsp--;

             after(grammarAccess.getEnumValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumValue2409); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1161:1: ruleEnumValue : ( ( rule__EnumValue__EnumValueAssignment ) ) ;
    public final void ruleEnumValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1165:2: ( ( ( rule__EnumValue__EnumValueAssignment ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1166:1: ( ( rule__EnumValue__EnumValueAssignment ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1166:1: ( ( rule__EnumValue__EnumValueAssignment ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1167:1: ( rule__EnumValue__EnumValueAssignment )
            {
             before(grammarAccess.getEnumValueAccess().getEnumValueAssignment()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1168:1: ( rule__EnumValue__EnumValueAssignment )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1168:2: rule__EnumValue__EnumValueAssignment
            {
            pushFollow(FOLLOW_rule__EnumValue__EnumValueAssignment_in_ruleEnumValue2435);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1180:1: entryRuleMethodReference : ruleMethodReference EOF ;
    public final void entryRuleMethodReference() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1181:1: ( ruleMethodReference EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1182:1: ruleMethodReference EOF
            {
             before(grammarAccess.getMethodReferenceRule()); 
            pushFollow(FOLLOW_ruleMethodReference_in_entryRuleMethodReference2462);
            ruleMethodReference();

            state._fsp--;

             after(grammarAccess.getMethodReferenceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodReference2469); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1189:1: ruleMethodReference : ( ( rule__MethodReference__Group__0 ) ) ;
    public final void ruleMethodReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1193:2: ( ( ( rule__MethodReference__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1194:1: ( ( rule__MethodReference__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1194:1: ( ( rule__MethodReference__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1195:1: ( rule__MethodReference__Group__0 )
            {
             before(grammarAccess.getMethodReferenceAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1196:1: ( rule__MethodReference__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1196:2: rule__MethodReference__Group__0
            {
            pushFollow(FOLLOW_rule__MethodReference__Group__0_in_ruleMethodReference2495);
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


    // $ANTLR start "entryRuleQualifiedName"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1208:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1209:1: ( ruleQualifiedName EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1210:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2522);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName2529); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1217:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1221:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1222:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1222:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1223:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1224:1: ( rule__QualifiedName__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1224:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName2555);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1236:1: entryRuleQualifiedJavaClassName : ruleQualifiedJavaClassName EOF ;
    public final void entryRuleQualifiedJavaClassName() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1237:1: ( ruleQualifiedJavaClassName EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1238:1: ruleQualifiedJavaClassName EOF
            {
             before(grammarAccess.getQualifiedJavaClassNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_entryRuleQualifiedJavaClassName2582);
            ruleQualifiedJavaClassName();

            state._fsp--;

             after(grammarAccess.getQualifiedJavaClassNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedJavaClassName2589); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1245:1: ruleQualifiedJavaClassName : ( ( rule__QualifiedJavaClassName__Group__0 ) ) ;
    public final void ruleQualifiedJavaClassName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1249:2: ( ( ( rule__QualifiedJavaClassName__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1250:1: ( ( rule__QualifiedJavaClassName__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1250:1: ( ( rule__QualifiedJavaClassName__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1251:1: ( rule__QualifiedJavaClassName__Group__0 )
            {
             before(grammarAccess.getQualifiedJavaClassNameAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1252:1: ( rule__QualifiedJavaClassName__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1252:2: rule__QualifiedJavaClassName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__0_in_ruleQualifiedJavaClassName2615);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1264:1: entryRuleQualifiedNameWithWildcard : ruleQualifiedNameWithWildcard EOF ;
    public final void entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1265:1: ( ruleQualifiedNameWithWildcard EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1266:1: ruleQualifiedNameWithWildcard EOF
            {
             before(grammarAccess.getQualifiedNameWithWildcardRule()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard2642);
            ruleQualifiedNameWithWildcard();

            state._fsp--;

             after(grammarAccess.getQualifiedNameWithWildcardRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard2649); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1273:1: ruleQualifiedNameWithWildcard : ( ( rule__QualifiedNameWithWildcard__Group__0 ) ) ;
    public final void ruleQualifiedNameWithWildcard() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1277:2: ( ( ( rule__QualifiedNameWithWildcard__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1278:1: ( ( rule__QualifiedNameWithWildcard__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1278:1: ( ( rule__QualifiedNameWithWildcard__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1279:1: ( rule__QualifiedNameWithWildcard__Group__0 )
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1280:1: ( rule__QualifiedNameWithWildcard__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1280:2: rule__QualifiedNameWithWildcard__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__0_in_ruleQualifiedNameWithWildcard2675);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1292:1: rule__Statement__Alternatives : ( ( rulePackageDefinition ) | ( ruleImport ) | ( ruleSuite ) );
    public final void rule__Statement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1296:1: ( ( rulePackageDefinition ) | ( ruleImport ) | ( ruleSuite ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt2=1;
                }
                break;
            case 19:
                {
                alt2=2;
                }
                break;
            case 37:
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
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1297:1: ( rulePackageDefinition )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1297:1: ( rulePackageDefinition )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1298:1: rulePackageDefinition
                    {
                     before(grammarAccess.getStatementAccess().getPackageDefinitionParserRuleCall_0()); 
                    pushFollow(FOLLOW_rulePackageDefinition_in_rule__Statement__Alternatives2711);
                    rulePackageDefinition();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getPackageDefinitionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1303:6: ( ruleImport )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1303:6: ( ruleImport )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1304:1: ruleImport
                    {
                     before(grammarAccess.getStatementAccess().getImportParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleImport_in_rule__Statement__Alternatives2728);
                    ruleImport();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getImportParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1309:6: ( ruleSuite )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1309:6: ( ruleSuite )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1310:1: ruleSuite
                    {
                     before(grammarAccess.getStatementAccess().getSuiteParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleSuite_in_rule__Statement__Alternatives2745);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1320:1: rule__PackageStatement__Alternatives : ( ( ruleImport ) | ( ruleForkDefinition ) | ( ruleTestDefinition ) | ( ruleCallDefinition ) | ( ruleSuiteDefinition ) | ( ruleVariableDefinition ) | ( ruleConstantDefinition ) );
    public final void rule__PackageStatement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1324:1: ( ( ruleImport ) | ( ruleForkDefinition ) | ( ruleTestDefinition ) | ( ruleCallDefinition ) | ( ruleSuiteDefinition ) | ( ruleVariableDefinition ) | ( ruleConstantDefinition ) )
            int alt3=7;
            switch ( input.LA(1) ) {
            case 19:
                {
                alt3=1;
                }
                break;
            case 20:
                {
                alt3=2;
                }
                break;
            case 21:
                {
                alt3=3;
                }
                break;
            case 23:
                {
                alt3=4;
                }
                break;
            case 24:
                {
                alt3=5;
                }
                break;
            case 29:
                {
                alt3=6;
                }
                break;
            case 31:
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
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1325:1: ( ruleImport )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1325:1: ( ruleImport )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1326:1: ruleImport
                    {
                     before(grammarAccess.getPackageStatementAccess().getImportParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleImport_in_rule__PackageStatement__Alternatives2777);
                    ruleImport();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getImportParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1331:6: ( ruleForkDefinition )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1331:6: ( ruleForkDefinition )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1332:1: ruleForkDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getForkDefinitionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleForkDefinition_in_rule__PackageStatement__Alternatives2794);
                    ruleForkDefinition();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getForkDefinitionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1337:6: ( ruleTestDefinition )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1337:6: ( ruleTestDefinition )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1338:1: ruleTestDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getTestDefinitionParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleTestDefinition_in_rule__PackageStatement__Alternatives2811);
                    ruleTestDefinition();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getTestDefinitionParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1343:6: ( ruleCallDefinition )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1343:6: ( ruleCallDefinition )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1344:1: ruleCallDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getCallDefinitionParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleCallDefinition_in_rule__PackageStatement__Alternatives2828);
                    ruleCallDefinition();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getCallDefinitionParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1349:6: ( ruleSuiteDefinition )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1349:6: ( ruleSuiteDefinition )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1350:1: ruleSuiteDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getSuiteDefinitionParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleSuiteDefinition_in_rule__PackageStatement__Alternatives2845);
                    ruleSuiteDefinition();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getSuiteDefinitionParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1355:6: ( ruleVariableDefinition )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1355:6: ( ruleVariableDefinition )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1356:1: ruleVariableDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getVariableDefinitionParserRuleCall_5()); 
                    pushFollow(FOLLOW_ruleVariableDefinition_in_rule__PackageStatement__Alternatives2862);
                    ruleVariableDefinition();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getVariableDefinitionParserRuleCall_5()); 

                    }


                    }
                    break;
                case 7 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1361:6: ( ruleConstantDefinition )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1361:6: ( ruleConstantDefinition )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1362:1: ruleConstantDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getConstantDefinitionParserRuleCall_6()); 
                    pushFollow(FOLLOW_ruleConstantDefinition_in_rule__PackageStatement__Alternatives2879);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1372:1: rule__SuiteStatement__Alternatives : ( ( ruleSuiteStatementWithResult ) | ( ruleCall ) | ( ruleVariableDefinition ) | ( ruleConstantDefinition ) | ( ruleVisibleSingleLineComment ) | ( ruleVisibleMultiLineComment ) );
    public final void rule__SuiteStatement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1376:1: ( ( ruleSuiteStatementWithResult ) | ( ruleCall ) | ( ruleVariableDefinition ) | ( ruleConstantDefinition ) | ( ruleVisibleSingleLineComment ) | ( ruleVisibleMultiLineComment ) )
            int alt4=6;
            switch ( input.LA(1) ) {
            case 32:
            case 34:
            case 37:
                {
                alt4=1;
                }
                break;
            case 35:
                {
                alt4=2;
                }
                break;
            case 29:
                {
                alt4=3;
                }
                break;
            case 31:
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
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1377:1: ( ruleSuiteStatementWithResult )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1377:1: ( ruleSuiteStatementWithResult )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1378:1: ruleSuiteStatementWithResult
                    {
                     before(grammarAccess.getSuiteStatementAccess().getSuiteStatementWithResultParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSuiteStatementWithResult_in_rule__SuiteStatement__Alternatives2911);
                    ruleSuiteStatementWithResult();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementAccess().getSuiteStatementWithResultParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1383:6: ( ruleCall )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1383:6: ( ruleCall )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1384:1: ruleCall
                    {
                     before(grammarAccess.getSuiteStatementAccess().getCallParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleCall_in_rule__SuiteStatement__Alternatives2928);
                    ruleCall();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementAccess().getCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1389:6: ( ruleVariableDefinition )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1389:6: ( ruleVariableDefinition )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1390:1: ruleVariableDefinition
                    {
                     before(grammarAccess.getSuiteStatementAccess().getVariableDefinitionParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleVariableDefinition_in_rule__SuiteStatement__Alternatives2945);
                    ruleVariableDefinition();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementAccess().getVariableDefinitionParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1395:6: ( ruleConstantDefinition )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1395:6: ( ruleConstantDefinition )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1396:1: ruleConstantDefinition
                    {
                     before(grammarAccess.getSuiteStatementAccess().getConstantDefinitionParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleConstantDefinition_in_rule__SuiteStatement__Alternatives2962);
                    ruleConstantDefinition();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementAccess().getConstantDefinitionParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1401:6: ( ruleVisibleSingleLineComment )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1401:6: ( ruleVisibleSingleLineComment )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1402:1: ruleVisibleSingleLineComment
                    {
                     before(grammarAccess.getSuiteStatementAccess().getVisibleSingleLineCommentParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleVisibleSingleLineComment_in_rule__SuiteStatement__Alternatives2979);
                    ruleVisibleSingleLineComment();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementAccess().getVisibleSingleLineCommentParserRuleCall_4()); 

                    }


                    }
                    break;
                case 6 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1407:6: ( ruleVisibleMultiLineComment )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1407:6: ( ruleVisibleMultiLineComment )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1408:1: ruleVisibleMultiLineComment
                    {
                     before(grammarAccess.getSuiteStatementAccess().getVisibleMultiLineCommentParserRuleCall_5()); 
                    pushFollow(FOLLOW_ruleVisibleMultiLineComment_in_rule__SuiteStatement__Alternatives2996);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1418:1: rule__SuiteStatementWithResult__Alternatives : ( ( ruleSuite ) | ( ruleTest ) | ( ruleTableTest ) );
    public final void rule__SuiteStatementWithResult__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1422:1: ( ( ruleSuite ) | ( ruleTest ) | ( ruleTableTest ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt5=1;
                }
                break;
            case 32:
                {
                alt5=2;
                }
                break;
            case 34:
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
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1423:1: ( ruleSuite )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1423:1: ( ruleSuite )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1424:1: ruleSuite
                    {
                     before(grammarAccess.getSuiteStatementWithResultAccess().getSuiteParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSuite_in_rule__SuiteStatementWithResult__Alternatives3028);
                    ruleSuite();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementWithResultAccess().getSuiteParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1429:6: ( ruleTest )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1429:6: ( ruleTest )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1430:1: ruleTest
                    {
                     before(grammarAccess.getSuiteStatementWithResultAccess().getTestParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleTest_in_rule__SuiteStatementWithResult__Alternatives3045);
                    ruleTest();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementWithResultAccess().getTestParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1435:6: ( ruleTableTest )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1435:6: ( ruleTableTest )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1436:1: ruleTableTest
                    {
                     before(grammarAccess.getSuiteStatementWithResultAccess().getTableTestParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleTableTest_in_rule__SuiteStatementWithResult__Alternatives3062);
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


    // $ANTLR start "rule__TableTest__Alternatives_5"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1446:1: rule__TableTest__Alternatives_5 : ( ( ( rule__TableTest__Group_5_0__0 ) ) | ( '|' ) );
    public final void rule__TableTest__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1450:1: ( ( ( rule__TableTest__Group_5_0__0 ) ) | ( '|' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==15) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==33) ) {
                    alt6=1;
                }
                else if ( (LA6_1==15) ) {
                    alt6=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1451:1: ( ( rule__TableTest__Group_5_0__0 ) )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1451:1: ( ( rule__TableTest__Group_5_0__0 ) )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1452:1: ( rule__TableTest__Group_5_0__0 )
                    {
                     before(grammarAccess.getTableTestAccess().getGroup_5_0()); 
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1453:1: ( rule__TableTest__Group_5_0__0 )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1453:2: rule__TableTest__Group_5_0__0
                    {
                    pushFollow(FOLLOW_rule__TableTest__Group_5_0__0_in_rule__TableTest__Alternatives_53094);
                    rule__TableTest__Group_5_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTableTestAccess().getGroup_5_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1457:6: ( '|' )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1457:6: ( '|' )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1458:1: '|'
                    {
                     before(grammarAccess.getTableTestAccess().getVerticalLineKeyword_5_1()); 
                    match(input,15,FOLLOW_15_in_rule__TableTest__Alternatives_53113); 
                     after(grammarAccess.getTableTestAccess().getVerticalLineKeyword_5_1()); 

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
    // $ANTLR end "rule__TableTest__Alternatives_5"


    // $ANTLR start "rule__TableTestRow__Alternatives_2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1470:1: rule__TableTestRow__Alternatives_2 : ( ( ( rule__TableTestRow__Group_2_0__0 ) ) | ( '|' ) );
    public final void rule__TableTestRow__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1474:1: ( ( ( rule__TableTestRow__Group_2_0__0 ) ) | ( '|' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==15) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==33) ) {
                    alt7=1;
                }
                else if ( (LA7_1==EOF||(LA7_1>=RULE_SL_VISIBLE_COMMENT && LA7_1<=RULE_ML_VISIBLE_COMMENT)||LA7_1==15||LA7_1==25||LA7_1==29||(LA7_1>=31 && LA7_1<=32)||(LA7_1>=34 && LA7_1<=35)||LA7_1==37) ) {
                    alt7=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1475:1: ( ( rule__TableTestRow__Group_2_0__0 ) )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1475:1: ( ( rule__TableTestRow__Group_2_0__0 ) )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1476:1: ( rule__TableTestRow__Group_2_0__0 )
                    {
                     before(grammarAccess.getTableTestRowAccess().getGroup_2_0()); 
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1477:1: ( rule__TableTestRow__Group_2_0__0 )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1477:2: rule__TableTestRow__Group_2_0__0
                    {
                    pushFollow(FOLLOW_rule__TableTestRow__Group_2_0__0_in_rule__TableTestRow__Alternatives_23147);
                    rule__TableTestRow__Group_2_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTableTestRowAccess().getGroup_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1481:6: ( '|' )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1481:6: ( '|' )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1482:1: '|'
                    {
                     before(grammarAccess.getTableTestRowAccess().getVerticalLineKeyword_2_1()); 
                    match(input,15,FOLLOW_15_in_rule__TableTestRow__Alternatives_23166); 
                     after(grammarAccess.getTableTestRowAccess().getVerticalLineKeyword_2_1()); 

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
    // $ANTLR end "rule__TableTestRow__Alternatives_2"


    // $ANTLR start "rule__ResultName__Alternatives"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1494:1: rule__ResultName__Alternatives : ( ( ruleFixedResultName ) | ( ruleArbitraryParameterOrResultName ) );
    public final void rule__ResultName__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1498:1: ( ( ruleFixedResultName ) | ( ruleArbitraryParameterOrResultName ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            else if ( (LA8_0==40) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1499:1: ( ruleFixedResultName )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1499:1: ( ruleFixedResultName )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1500:1: ruleFixedResultName
                    {
                     before(grammarAccess.getResultNameAccess().getFixedResultNameParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleFixedResultName_in_rule__ResultName__Alternatives3200);
                    ruleFixedResultName();

                    state._fsp--;

                     after(grammarAccess.getResultNameAccess().getFixedResultNameParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1505:6: ( ruleArbitraryParameterOrResultName )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1505:6: ( ruleArbitraryParameterOrResultName )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1506:1: ruleArbitraryParameterOrResultName
                    {
                     before(grammarAccess.getResultNameAccess().getArbitraryParameterOrResultNameParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleArbitraryParameterOrResultName_in_rule__ResultName__Alternatives3217);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1516:1: rule__ParameterName__Alternatives : ( ( ruleFixedParameterName ) | ( ruleArbitraryParameterOrResultName ) );
    public final void rule__ParameterName__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1520:1: ( ( ruleFixedParameterName ) | ( ruleArbitraryParameterOrResultName ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            else if ( (LA9_0==40) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1521:1: ( ruleFixedParameterName )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1521:1: ( ruleFixedParameterName )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1522:1: ruleFixedParameterName
                    {
                     before(grammarAccess.getParameterNameAccess().getFixedParameterNameParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleFixedParameterName_in_rule__ParameterName__Alternatives3249);
                    ruleFixedParameterName();

                    state._fsp--;

                     after(grammarAccess.getParameterNameAccess().getFixedParameterNameParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1527:6: ( ruleArbitraryParameterOrResultName )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1527:6: ( ruleArbitraryParameterOrResultName )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1528:1: ruleArbitraryParameterOrResultName
                    {
                     before(grammarAccess.getParameterNameAccess().getArbitraryParameterOrResultNameParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleArbitraryParameterOrResultName_in_rule__ParameterName__Alternatives3266);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1538:1: rule__ValueOrEnumValue__Alternatives : ( ( ruleValue ) | ( ruleEnumValue ) );
    public final void rule__ValueOrEnumValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1542:1: ( ( ruleValue ) | ( ruleEnumValue ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID||(LA10_0>=RULE_STRING && LA10_0<=RULE_DECIMAL)) ) {
                alt10=1;
            }
            else if ( (LA10_0==RULE_UPPERCASE_ID) ) {
                alt10=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1543:1: ( ruleValue )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1543:1: ( ruleValue )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1544:1: ruleValue
                    {
                     before(grammarAccess.getValueOrEnumValueAccess().getValueParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleValue_in_rule__ValueOrEnumValue__Alternatives3298);
                    ruleValue();

                    state._fsp--;

                     after(grammarAccess.getValueOrEnumValueAccess().getValueParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1549:6: ( ruleEnumValue )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1549:6: ( ruleEnumValue )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1550:1: ruleEnumValue
                    {
                     before(grammarAccess.getValueOrEnumValueAccess().getEnumValueParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleEnumValue_in_rule__ValueOrEnumValue__Alternatives3315);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1560:1: rule__Value__Alternatives : ( ( ruleStringValue ) | ( ruleIntegerValue ) | ( ruleDecimalValue ) | ( ruleVariable ) );
    public final void rule__Value__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1564:1: ( ( ruleStringValue ) | ( ruleIntegerValue ) | ( ruleDecimalValue ) | ( ruleVariable ) )
            int alt11=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt11=1;
                }
                break;
            case RULE_INTEGER:
                {
                alt11=2;
                }
                break;
            case RULE_DECIMAL:
                {
                alt11=3;
                }
                break;
            case RULE_ID:
                {
                alt11=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1565:1: ( ruleStringValue )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1565:1: ( ruleStringValue )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1566:1: ruleStringValue
                    {
                     before(grammarAccess.getValueAccess().getStringValueParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleStringValue_in_rule__Value__Alternatives3347);
                    ruleStringValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getStringValueParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1571:6: ( ruleIntegerValue )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1571:6: ( ruleIntegerValue )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1572:1: ruleIntegerValue
                    {
                     before(grammarAccess.getValueAccess().getIntegerValueParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleIntegerValue_in_rule__Value__Alternatives3364);
                    ruleIntegerValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getIntegerValueParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1577:6: ( ruleDecimalValue )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1577:6: ( ruleDecimalValue )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1578:1: ruleDecimalValue
                    {
                     before(grammarAccess.getValueAccess().getDecimalValueParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleDecimalValue_in_rule__Value__Alternatives3381);
                    ruleDecimalValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getDecimalValueParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1583:6: ( ruleVariable )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1583:6: ( ruleVariable )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1584:1: ruleVariable
                    {
                     before(grammarAccess.getValueAccess().getVariableParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleVariable_in_rule__Value__Alternatives3398);
                    ruleVariable();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getVariableParserRuleCall_3()); 

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


    // $ANTLR start "rule__PackageDefinition__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1596:1: rule__PackageDefinition__Group__0 : rule__PackageDefinition__Group__0__Impl rule__PackageDefinition__Group__1 ;
    public final void rule__PackageDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1600:1: ( rule__PackageDefinition__Group__0__Impl rule__PackageDefinition__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1601:2: rule__PackageDefinition__Group__0__Impl rule__PackageDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__0__Impl_in_rule__PackageDefinition__Group__03428);
            rule__PackageDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDefinition__Group__1_in_rule__PackageDefinition__Group__03431);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1608:1: rule__PackageDefinition__Group__0__Impl : ( 'packagedef' ) ;
    public final void rule__PackageDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1612:1: ( ( 'packagedef' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1613:1: ( 'packagedef' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1613:1: ( 'packagedef' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1614:1: 'packagedef'
            {
             before(grammarAccess.getPackageDefinitionAccess().getPackagedefKeyword_0()); 
            match(input,16,FOLLOW_16_in_rule__PackageDefinition__Group__0__Impl3459); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1627:1: rule__PackageDefinition__Group__1 : rule__PackageDefinition__Group__1__Impl rule__PackageDefinition__Group__2 ;
    public final void rule__PackageDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1631:1: ( rule__PackageDefinition__Group__1__Impl rule__PackageDefinition__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1632:2: rule__PackageDefinition__Group__1__Impl rule__PackageDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__1__Impl_in_rule__PackageDefinition__Group__13490);
            rule__PackageDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDefinition__Group__2_in_rule__PackageDefinition__Group__13493);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1639:1: rule__PackageDefinition__Group__1__Impl : ( ( rule__PackageDefinition__NameAssignment_1 ) ) ;
    public final void rule__PackageDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1643:1: ( ( ( rule__PackageDefinition__NameAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1644:1: ( ( rule__PackageDefinition__NameAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1644:1: ( ( rule__PackageDefinition__NameAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1645:1: ( rule__PackageDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getPackageDefinitionAccess().getNameAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1646:1: ( rule__PackageDefinition__NameAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1646:2: rule__PackageDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__PackageDefinition__NameAssignment_1_in_rule__PackageDefinition__Group__1__Impl3520);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1656:1: rule__PackageDefinition__Group__2 : rule__PackageDefinition__Group__2__Impl rule__PackageDefinition__Group__3 ;
    public final void rule__PackageDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1660:1: ( rule__PackageDefinition__Group__2__Impl rule__PackageDefinition__Group__3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1661:2: rule__PackageDefinition__Group__2__Impl rule__PackageDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__2__Impl_in_rule__PackageDefinition__Group__23550);
            rule__PackageDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDefinition__Group__3_in_rule__PackageDefinition__Group__23553);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1668:1: rule__PackageDefinition__Group__2__Impl : ( 'with' ) ;
    public final void rule__PackageDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1672:1: ( ( 'with' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1673:1: ( 'with' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1673:1: ( 'with' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1674:1: 'with'
            {
             before(grammarAccess.getPackageDefinitionAccess().getWithKeyword_2()); 
            match(input,17,FOLLOW_17_in_rule__PackageDefinition__Group__2__Impl3581); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1687:1: rule__PackageDefinition__Group__3 : rule__PackageDefinition__Group__3__Impl rule__PackageDefinition__Group__4 ;
    public final void rule__PackageDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1691:1: ( rule__PackageDefinition__Group__3__Impl rule__PackageDefinition__Group__4 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1692:2: rule__PackageDefinition__Group__3__Impl rule__PackageDefinition__Group__4
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__3__Impl_in_rule__PackageDefinition__Group__33612);
            rule__PackageDefinition__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDefinition__Group__4_in_rule__PackageDefinition__Group__33615);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1699:1: rule__PackageDefinition__Group__3__Impl : ( ( rule__PackageDefinition__StatementsAssignment_3 )* ) ;
    public final void rule__PackageDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1703:1: ( ( ( rule__PackageDefinition__StatementsAssignment_3 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1704:1: ( ( rule__PackageDefinition__StatementsAssignment_3 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1704:1: ( ( rule__PackageDefinition__StatementsAssignment_3 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1705:1: ( rule__PackageDefinition__StatementsAssignment_3 )*
            {
             before(grammarAccess.getPackageDefinitionAccess().getStatementsAssignment_3()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1706:1: ( rule__PackageDefinition__StatementsAssignment_3 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=19 && LA12_0<=21)||(LA12_0>=23 && LA12_0<=24)||LA12_0==29||LA12_0==31) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1706:2: rule__PackageDefinition__StatementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__PackageDefinition__StatementsAssignment_3_in_rule__PackageDefinition__Group__3__Impl3642);
            	    rule__PackageDefinition__StatementsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1716:1: rule__PackageDefinition__Group__4 : rule__PackageDefinition__Group__4__Impl ;
    public final void rule__PackageDefinition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1720:1: ( rule__PackageDefinition__Group__4__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1721:2: rule__PackageDefinition__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__4__Impl_in_rule__PackageDefinition__Group__43673);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1727:1: rule__PackageDefinition__Group__4__Impl : ( 'packageend' ) ;
    public final void rule__PackageDefinition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1731:1: ( ( 'packageend' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1732:1: ( 'packageend' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1732:1: ( 'packageend' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1733:1: 'packageend'
            {
             before(grammarAccess.getPackageDefinitionAccess().getPackageendKeyword_4()); 
            match(input,18,FOLLOW_18_in_rule__PackageDefinition__Group__4__Impl3701); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1756:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1760:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1761:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__03742);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__03745);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1768:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1772:1: ( ( 'import' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1773:1: ( 'import' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1773:1: ( 'import' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1774:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,19,FOLLOW_19_in_rule__Import__Group__0__Impl3773); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1787:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1791:1: ( rule__Import__Group__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1792:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__13804);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1798:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1802:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1803:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1803:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1804:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1805:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1805:2: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl3831);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1819:1: rule__ForkDefinition__Group__0 : rule__ForkDefinition__Group__0__Impl rule__ForkDefinition__Group__1 ;
    public final void rule__ForkDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1823:1: ( rule__ForkDefinition__Group__0__Impl rule__ForkDefinition__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1824:2: rule__ForkDefinition__Group__0__Impl rule__ForkDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__ForkDefinition__Group__0__Impl_in_rule__ForkDefinition__Group__03865);
            rule__ForkDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ForkDefinition__Group__1_in_rule__ForkDefinition__Group__03868);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1831:1: rule__ForkDefinition__Group__0__Impl : ( 'forkdef' ) ;
    public final void rule__ForkDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1835:1: ( ( 'forkdef' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1836:1: ( 'forkdef' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1836:1: ( 'forkdef' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1837:1: 'forkdef'
            {
             before(grammarAccess.getForkDefinitionAccess().getForkdefKeyword_0()); 
            match(input,20,FOLLOW_20_in_rule__ForkDefinition__Group__0__Impl3896); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1850:1: rule__ForkDefinition__Group__1 : rule__ForkDefinition__Group__1__Impl rule__ForkDefinition__Group__2 ;
    public final void rule__ForkDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1854:1: ( rule__ForkDefinition__Group__1__Impl rule__ForkDefinition__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1855:2: rule__ForkDefinition__Group__1__Impl rule__ForkDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__ForkDefinition__Group__1__Impl_in_rule__ForkDefinition__Group__13927);
            rule__ForkDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ForkDefinition__Group__2_in_rule__ForkDefinition__Group__13930);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1862:1: rule__ForkDefinition__Group__1__Impl : ( ( rule__ForkDefinition__NameAssignment_1 ) ) ;
    public final void rule__ForkDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1866:1: ( ( ( rule__ForkDefinition__NameAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1867:1: ( ( rule__ForkDefinition__NameAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1867:1: ( ( rule__ForkDefinition__NameAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1868:1: ( rule__ForkDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getForkDefinitionAccess().getNameAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1869:1: ( rule__ForkDefinition__NameAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1869:2: rule__ForkDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ForkDefinition__NameAssignment_1_in_rule__ForkDefinition__Group__1__Impl3957);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1879:1: rule__ForkDefinition__Group__2 : rule__ForkDefinition__Group__2__Impl ;
    public final void rule__ForkDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1883:1: ( rule__ForkDefinition__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1884:2: rule__ForkDefinition__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ForkDefinition__Group__2__Impl_in_rule__ForkDefinition__Group__23987);
            rule__ForkDefinition__Group__2__Impl();

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1890:1: rule__ForkDefinition__Group__2__Impl : ( ( rule__ForkDefinition__DescriptionAssignment_2 )? ) ;
    public final void rule__ForkDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1894:1: ( ( ( rule__ForkDefinition__DescriptionAssignment_2 )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1895:1: ( ( rule__ForkDefinition__DescriptionAssignment_2 )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1895:1: ( ( rule__ForkDefinition__DescriptionAssignment_2 )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1896:1: ( rule__ForkDefinition__DescriptionAssignment_2 )?
            {
             before(grammarAccess.getForkDefinitionAccess().getDescriptionAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1897:1: ( rule__ForkDefinition__DescriptionAssignment_2 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_STRING) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1897:2: rule__ForkDefinition__DescriptionAssignment_2
                    {
                    pushFollow(FOLLOW_rule__ForkDefinition__DescriptionAssignment_2_in_rule__ForkDefinition__Group__2__Impl4014);
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


    // $ANTLR start "rule__TestDefinition__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1913:1: rule__TestDefinition__Group__0 : rule__TestDefinition__Group__0__Impl rule__TestDefinition__Group__1 ;
    public final void rule__TestDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1917:1: ( rule__TestDefinition__Group__0__Impl rule__TestDefinition__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1918:2: rule__TestDefinition__Group__0__Impl rule__TestDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__TestDefinition__Group__0__Impl_in_rule__TestDefinition__Group__04051);
            rule__TestDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TestDefinition__Group__1_in_rule__TestDefinition__Group__04054);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1925:1: rule__TestDefinition__Group__0__Impl : ( 'testdef' ) ;
    public final void rule__TestDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1929:1: ( ( 'testdef' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1930:1: ( 'testdef' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1930:1: ( 'testdef' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1931:1: 'testdef'
            {
             before(grammarAccess.getTestDefinitionAccess().getTestdefKeyword_0()); 
            match(input,21,FOLLOW_21_in_rule__TestDefinition__Group__0__Impl4082); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1944:1: rule__TestDefinition__Group__1 : rule__TestDefinition__Group__1__Impl rule__TestDefinition__Group__2 ;
    public final void rule__TestDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1948:1: ( rule__TestDefinition__Group__1__Impl rule__TestDefinition__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1949:2: rule__TestDefinition__Group__1__Impl rule__TestDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__TestDefinition__Group__1__Impl_in_rule__TestDefinition__Group__14113);
            rule__TestDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TestDefinition__Group__2_in_rule__TestDefinition__Group__14116);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1956:1: rule__TestDefinition__Group__1__Impl : ( ( rule__TestDefinition__NameAssignment_1 ) ) ;
    public final void rule__TestDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1960:1: ( ( ( rule__TestDefinition__NameAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1961:1: ( ( rule__TestDefinition__NameAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1961:1: ( ( rule__TestDefinition__NameAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1962:1: ( rule__TestDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getTestDefinitionAccess().getNameAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1963:1: ( rule__TestDefinition__NameAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1963:2: rule__TestDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__TestDefinition__NameAssignment_1_in_rule__TestDefinition__Group__1__Impl4143);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1973:1: rule__TestDefinition__Group__2 : rule__TestDefinition__Group__2__Impl rule__TestDefinition__Group__3 ;
    public final void rule__TestDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1977:1: ( rule__TestDefinition__Group__2__Impl rule__TestDefinition__Group__3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1978:2: rule__TestDefinition__Group__2__Impl rule__TestDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__TestDefinition__Group__2__Impl_in_rule__TestDefinition__Group__24173);
            rule__TestDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TestDefinition__Group__3_in_rule__TestDefinition__Group__24176);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1985:1: rule__TestDefinition__Group__2__Impl : ( 'uses' ) ;
    public final void rule__TestDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1989:1: ( ( 'uses' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1990:1: ( 'uses' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1990:1: ( 'uses' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1991:1: 'uses'
            {
             before(grammarAccess.getTestDefinitionAccess().getUsesKeyword_2()); 
            match(input,22,FOLLOW_22_in_rule__TestDefinition__Group__2__Impl4204); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2004:1: rule__TestDefinition__Group__3 : rule__TestDefinition__Group__3__Impl ;
    public final void rule__TestDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2008:1: ( rule__TestDefinition__Group__3__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2009:2: rule__TestDefinition__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__TestDefinition__Group__3__Impl_in_rule__TestDefinition__Group__34235);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2015:1: rule__TestDefinition__Group__3__Impl : ( ( rule__TestDefinition__FixtureMethodAssignment_3 ) ) ;
    public final void rule__TestDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2019:1: ( ( ( rule__TestDefinition__FixtureMethodAssignment_3 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2020:1: ( ( rule__TestDefinition__FixtureMethodAssignment_3 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2020:1: ( ( rule__TestDefinition__FixtureMethodAssignment_3 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2021:1: ( rule__TestDefinition__FixtureMethodAssignment_3 )
            {
             before(grammarAccess.getTestDefinitionAccess().getFixtureMethodAssignment_3()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2022:1: ( rule__TestDefinition__FixtureMethodAssignment_3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2022:2: rule__TestDefinition__FixtureMethodAssignment_3
            {
            pushFollow(FOLLOW_rule__TestDefinition__FixtureMethodAssignment_3_in_rule__TestDefinition__Group__3__Impl4262);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2040:1: rule__CallDefinition__Group__0 : rule__CallDefinition__Group__0__Impl rule__CallDefinition__Group__1 ;
    public final void rule__CallDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2044:1: ( rule__CallDefinition__Group__0__Impl rule__CallDefinition__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2045:2: rule__CallDefinition__Group__0__Impl rule__CallDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__CallDefinition__Group__0__Impl_in_rule__CallDefinition__Group__04300);
            rule__CallDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CallDefinition__Group__1_in_rule__CallDefinition__Group__04303);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2052:1: rule__CallDefinition__Group__0__Impl : ( 'calldef' ) ;
    public final void rule__CallDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2056:1: ( ( 'calldef' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2057:1: ( 'calldef' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2057:1: ( 'calldef' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2058:1: 'calldef'
            {
             before(grammarAccess.getCallDefinitionAccess().getCalldefKeyword_0()); 
            match(input,23,FOLLOW_23_in_rule__CallDefinition__Group__0__Impl4331); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2071:1: rule__CallDefinition__Group__1 : rule__CallDefinition__Group__1__Impl rule__CallDefinition__Group__2 ;
    public final void rule__CallDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2075:1: ( rule__CallDefinition__Group__1__Impl rule__CallDefinition__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2076:2: rule__CallDefinition__Group__1__Impl rule__CallDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__CallDefinition__Group__1__Impl_in_rule__CallDefinition__Group__14362);
            rule__CallDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CallDefinition__Group__2_in_rule__CallDefinition__Group__14365);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2083:1: rule__CallDefinition__Group__1__Impl : ( ( rule__CallDefinition__NameAssignment_1 ) ) ;
    public final void rule__CallDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2087:1: ( ( ( rule__CallDefinition__NameAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2088:1: ( ( rule__CallDefinition__NameAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2088:1: ( ( rule__CallDefinition__NameAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2089:1: ( rule__CallDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getCallDefinitionAccess().getNameAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2090:1: ( rule__CallDefinition__NameAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2090:2: rule__CallDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__CallDefinition__NameAssignment_1_in_rule__CallDefinition__Group__1__Impl4392);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2100:1: rule__CallDefinition__Group__2 : rule__CallDefinition__Group__2__Impl rule__CallDefinition__Group__3 ;
    public final void rule__CallDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2104:1: ( rule__CallDefinition__Group__2__Impl rule__CallDefinition__Group__3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2105:2: rule__CallDefinition__Group__2__Impl rule__CallDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__CallDefinition__Group__2__Impl_in_rule__CallDefinition__Group__24422);
            rule__CallDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CallDefinition__Group__3_in_rule__CallDefinition__Group__24425);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2112:1: rule__CallDefinition__Group__2__Impl : ( 'uses' ) ;
    public final void rule__CallDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2116:1: ( ( 'uses' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2117:1: ( 'uses' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2117:1: ( 'uses' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2118:1: 'uses'
            {
             before(grammarAccess.getCallDefinitionAccess().getUsesKeyword_2()); 
            match(input,22,FOLLOW_22_in_rule__CallDefinition__Group__2__Impl4453); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2131:1: rule__CallDefinition__Group__3 : rule__CallDefinition__Group__3__Impl ;
    public final void rule__CallDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2135:1: ( rule__CallDefinition__Group__3__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2136:2: rule__CallDefinition__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__CallDefinition__Group__3__Impl_in_rule__CallDefinition__Group__34484);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2142:1: rule__CallDefinition__Group__3__Impl : ( ( rule__CallDefinition__FixtureMethodAssignment_3 ) ) ;
    public final void rule__CallDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2146:1: ( ( ( rule__CallDefinition__FixtureMethodAssignment_3 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2147:1: ( ( rule__CallDefinition__FixtureMethodAssignment_3 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2147:1: ( ( rule__CallDefinition__FixtureMethodAssignment_3 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2148:1: ( rule__CallDefinition__FixtureMethodAssignment_3 )
            {
             before(grammarAccess.getCallDefinitionAccess().getFixtureMethodAssignment_3()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2149:1: ( rule__CallDefinition__FixtureMethodAssignment_3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2149:2: rule__CallDefinition__FixtureMethodAssignment_3
            {
            pushFollow(FOLLOW_rule__CallDefinition__FixtureMethodAssignment_3_in_rule__CallDefinition__Group__3__Impl4511);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2167:1: rule__SuiteDefinition__Group__0 : rule__SuiteDefinition__Group__0__Impl rule__SuiteDefinition__Group__1 ;
    public final void rule__SuiteDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2171:1: ( rule__SuiteDefinition__Group__0__Impl rule__SuiteDefinition__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2172:2: rule__SuiteDefinition__Group__0__Impl rule__SuiteDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__0__Impl_in_rule__SuiteDefinition__Group__04549);
            rule__SuiteDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__1_in_rule__SuiteDefinition__Group__04552);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2179:1: rule__SuiteDefinition__Group__0__Impl : ( 'suitedef' ) ;
    public final void rule__SuiteDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2183:1: ( ( 'suitedef' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2184:1: ( 'suitedef' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2184:1: ( 'suitedef' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2185:1: 'suitedef'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getSuitedefKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__SuiteDefinition__Group__0__Impl4580); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2198:1: rule__SuiteDefinition__Group__1 : rule__SuiteDefinition__Group__1__Impl rule__SuiteDefinition__Group__2 ;
    public final void rule__SuiteDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2202:1: ( rule__SuiteDefinition__Group__1__Impl rule__SuiteDefinition__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2203:2: rule__SuiteDefinition__Group__1__Impl rule__SuiteDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__1__Impl_in_rule__SuiteDefinition__Group__14611);
            rule__SuiteDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__2_in_rule__SuiteDefinition__Group__14614);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2210:1: rule__SuiteDefinition__Group__1__Impl : ( ( rule__SuiteDefinition__NameAssignment_1 ) ) ;
    public final void rule__SuiteDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2214:1: ( ( ( rule__SuiteDefinition__NameAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2215:1: ( ( rule__SuiteDefinition__NameAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2215:1: ( ( rule__SuiteDefinition__NameAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2216:1: ( rule__SuiteDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getSuiteDefinitionAccess().getNameAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2217:1: ( rule__SuiteDefinition__NameAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2217:2: rule__SuiteDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__NameAssignment_1_in_rule__SuiteDefinition__Group__1__Impl4641);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2227:1: rule__SuiteDefinition__Group__2 : rule__SuiteDefinition__Group__2__Impl rule__SuiteDefinition__Group__3 ;
    public final void rule__SuiteDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2231:1: ( rule__SuiteDefinition__Group__2__Impl rule__SuiteDefinition__Group__3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2232:2: rule__SuiteDefinition__Group__2__Impl rule__SuiteDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__2__Impl_in_rule__SuiteDefinition__Group__24671);
            rule__SuiteDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__3_in_rule__SuiteDefinition__Group__24674);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2239:1: rule__SuiteDefinition__Group__2__Impl : ( ( rule__SuiteDefinition__Group_2__0 )? ) ;
    public final void rule__SuiteDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2243:1: ( ( ( rule__SuiteDefinition__Group_2__0 )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2244:1: ( ( rule__SuiteDefinition__Group_2__0 )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2244:1: ( ( rule__SuiteDefinition__Group_2__0 )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2245:1: ( rule__SuiteDefinition__Group_2__0 )?
            {
             before(grammarAccess.getSuiteDefinitionAccess().getGroup_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2246:1: ( rule__SuiteDefinition__Group_2__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==26) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2246:2: rule__SuiteDefinition__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__SuiteDefinition__Group_2__0_in_rule__SuiteDefinition__Group__2__Impl4701);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2256:1: rule__SuiteDefinition__Group__3 : rule__SuiteDefinition__Group__3__Impl rule__SuiteDefinition__Group__4 ;
    public final void rule__SuiteDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2260:1: ( rule__SuiteDefinition__Group__3__Impl rule__SuiteDefinition__Group__4 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2261:2: rule__SuiteDefinition__Group__3__Impl rule__SuiteDefinition__Group__4
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__3__Impl_in_rule__SuiteDefinition__Group__34732);
            rule__SuiteDefinition__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__4_in_rule__SuiteDefinition__Group__34735);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2268:1: rule__SuiteDefinition__Group__3__Impl : ( ( rule__SuiteDefinition__Group_3__0 )? ) ;
    public final void rule__SuiteDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2272:1: ( ( ( rule__SuiteDefinition__Group_3__0 )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2273:1: ( ( rule__SuiteDefinition__Group_3__0 )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2273:1: ( ( rule__SuiteDefinition__Group_3__0 )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2274:1: ( rule__SuiteDefinition__Group_3__0 )?
            {
             before(grammarAccess.getSuiteDefinitionAccess().getGroup_3()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2275:1: ( rule__SuiteDefinition__Group_3__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==27) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2275:2: rule__SuiteDefinition__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__SuiteDefinition__Group_3__0_in_rule__SuiteDefinition__Group__3__Impl4762);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2285:1: rule__SuiteDefinition__Group__4 : rule__SuiteDefinition__Group__4__Impl rule__SuiteDefinition__Group__5 ;
    public final void rule__SuiteDefinition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2289:1: ( rule__SuiteDefinition__Group__4__Impl rule__SuiteDefinition__Group__5 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2290:2: rule__SuiteDefinition__Group__4__Impl rule__SuiteDefinition__Group__5
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__4__Impl_in_rule__SuiteDefinition__Group__44793);
            rule__SuiteDefinition__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__5_in_rule__SuiteDefinition__Group__44796);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2297:1: rule__SuiteDefinition__Group__4__Impl : ( 'with' ) ;
    public final void rule__SuiteDefinition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2301:1: ( ( 'with' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2302:1: ( 'with' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2302:1: ( 'with' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2303:1: 'with'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getWithKeyword_4()); 
            match(input,17,FOLLOW_17_in_rule__SuiteDefinition__Group__4__Impl4824); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2316:1: rule__SuiteDefinition__Group__5 : rule__SuiteDefinition__Group__5__Impl rule__SuiteDefinition__Group__6 ;
    public final void rule__SuiteDefinition__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2320:1: ( rule__SuiteDefinition__Group__5__Impl rule__SuiteDefinition__Group__6 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2321:2: rule__SuiteDefinition__Group__5__Impl rule__SuiteDefinition__Group__6
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__5__Impl_in_rule__SuiteDefinition__Group__54855);
            rule__SuiteDefinition__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__6_in_rule__SuiteDefinition__Group__54858);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2328:1: rule__SuiteDefinition__Group__5__Impl : ( ( rule__SuiteDefinition__StatementsAssignment_5 )* ) ;
    public final void rule__SuiteDefinition__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2332:1: ( ( ( rule__SuiteDefinition__StatementsAssignment_5 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2333:1: ( ( rule__SuiteDefinition__StatementsAssignment_5 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2333:1: ( ( rule__SuiteDefinition__StatementsAssignment_5 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2334:1: ( rule__SuiteDefinition__StatementsAssignment_5 )*
            {
             before(grammarAccess.getSuiteDefinitionAccess().getStatementsAssignment_5()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2335:1: ( rule__SuiteDefinition__StatementsAssignment_5 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=RULE_SL_VISIBLE_COMMENT && LA16_0<=RULE_ML_VISIBLE_COMMENT)||LA16_0==29||(LA16_0>=31 && LA16_0<=32)||(LA16_0>=34 && LA16_0<=35)||LA16_0==37) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2335:2: rule__SuiteDefinition__StatementsAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__SuiteDefinition__StatementsAssignment_5_in_rule__SuiteDefinition__Group__5__Impl4885);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2345:1: rule__SuiteDefinition__Group__6 : rule__SuiteDefinition__Group__6__Impl rule__SuiteDefinition__Group__7 ;
    public final void rule__SuiteDefinition__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2349:1: ( rule__SuiteDefinition__Group__6__Impl rule__SuiteDefinition__Group__7 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2350:2: rule__SuiteDefinition__Group__6__Impl rule__SuiteDefinition__Group__7
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__6__Impl_in_rule__SuiteDefinition__Group__64916);
            rule__SuiteDefinition__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__7_in_rule__SuiteDefinition__Group__64919);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2357:1: rule__SuiteDefinition__Group__6__Impl : ( 'suiteend' ) ;
    public final void rule__SuiteDefinition__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2361:1: ( ( 'suiteend' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2362:1: ( 'suiteend' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2362:1: ( 'suiteend' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2363:1: 'suiteend'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getSuiteendKeyword_6()); 
            match(input,25,FOLLOW_25_in_rule__SuiteDefinition__Group__6__Impl4947); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2376:1: rule__SuiteDefinition__Group__7 : rule__SuiteDefinition__Group__7__Impl ;
    public final void rule__SuiteDefinition__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2380:1: ( rule__SuiteDefinition__Group__7__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2381:2: rule__SuiteDefinition__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__7__Impl_in_rule__SuiteDefinition__Group__74978);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2387:1: rule__SuiteDefinition__Group__7__Impl : ( ( rule__SuiteDefinition__Group_7__0 )? ) ;
    public final void rule__SuiteDefinition__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2391:1: ( ( ( rule__SuiteDefinition__Group_7__0 )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2392:1: ( ( rule__SuiteDefinition__Group_7__0 )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2392:1: ( ( rule__SuiteDefinition__Group_7__0 )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2393:1: ( rule__SuiteDefinition__Group_7__0 )?
            {
             before(grammarAccess.getSuiteDefinitionAccess().getGroup_7()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2394:1: ( rule__SuiteDefinition__Group_7__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==28) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2394:2: rule__SuiteDefinition__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__SuiteDefinition__Group_7__0_in_rule__SuiteDefinition__Group__7__Impl5005);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2420:1: rule__SuiteDefinition__Group_2__0 : rule__SuiteDefinition__Group_2__0__Impl rule__SuiteDefinition__Group_2__1 ;
    public final void rule__SuiteDefinition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2424:1: ( rule__SuiteDefinition__Group_2__0__Impl rule__SuiteDefinition__Group_2__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2425:2: rule__SuiteDefinition__Group_2__0__Impl rule__SuiteDefinition__Group_2__1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_2__0__Impl_in_rule__SuiteDefinition__Group_2__05052);
            rule__SuiteDefinition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group_2__1_in_rule__SuiteDefinition__Group_2__05055);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2432:1: rule__SuiteDefinition__Group_2__0__Impl : ( 'gets' ) ;
    public final void rule__SuiteDefinition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2436:1: ( ( 'gets' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2437:1: ( 'gets' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2437:1: ( 'gets' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2438:1: 'gets'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getGetsKeyword_2_0()); 
            match(input,26,FOLLOW_26_in_rule__SuiteDefinition__Group_2__0__Impl5083); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2451:1: rule__SuiteDefinition__Group_2__1 : rule__SuiteDefinition__Group_2__1__Impl ;
    public final void rule__SuiteDefinition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2455:1: ( rule__SuiteDefinition__Group_2__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2456:2: rule__SuiteDefinition__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_2__1__Impl_in_rule__SuiteDefinition__Group_2__15114);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2462:1: rule__SuiteDefinition__Group_2__1__Impl : ( ( rule__SuiteDefinition__ParametersAssignment_2_1 )* ) ;
    public final void rule__SuiteDefinition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2466:1: ( ( ( rule__SuiteDefinition__ParametersAssignment_2_1 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2467:1: ( ( rule__SuiteDefinition__ParametersAssignment_2_1 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2467:1: ( ( rule__SuiteDefinition__ParametersAssignment_2_1 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2468:1: ( rule__SuiteDefinition__ParametersAssignment_2_1 )*
            {
             before(grammarAccess.getSuiteDefinitionAccess().getParametersAssignment_2_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2469:1: ( rule__SuiteDefinition__ParametersAssignment_2_1 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2469:2: rule__SuiteDefinition__ParametersAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_rule__SuiteDefinition__ParametersAssignment_2_1_in_rule__SuiteDefinition__Group_2__1__Impl5141);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2483:1: rule__SuiteDefinition__Group_3__0 : rule__SuiteDefinition__Group_3__0__Impl rule__SuiteDefinition__Group_3__1 ;
    public final void rule__SuiteDefinition__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2487:1: ( rule__SuiteDefinition__Group_3__0__Impl rule__SuiteDefinition__Group_3__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2488:2: rule__SuiteDefinition__Group_3__0__Impl rule__SuiteDefinition__Group_3__1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_3__0__Impl_in_rule__SuiteDefinition__Group_3__05176);
            rule__SuiteDefinition__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group_3__1_in_rule__SuiteDefinition__Group_3__05179);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2495:1: rule__SuiteDefinition__Group_3__0__Impl : ( 'requires' ) ;
    public final void rule__SuiteDefinition__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2499:1: ( ( 'requires' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2500:1: ( 'requires' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2500:1: ( 'requires' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2501:1: 'requires'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getRequiresKeyword_3_0()); 
            match(input,27,FOLLOW_27_in_rule__SuiteDefinition__Group_3__0__Impl5207); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2514:1: rule__SuiteDefinition__Group_3__1 : rule__SuiteDefinition__Group_3__1__Impl ;
    public final void rule__SuiteDefinition__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2518:1: ( rule__SuiteDefinition__Group_3__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2519:2: rule__SuiteDefinition__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_3__1__Impl_in_rule__SuiteDefinition__Group_3__15238);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2525:1: rule__SuiteDefinition__Group_3__1__Impl : ( ( rule__SuiteDefinition__DependenciesAssignment_3_1 )* ) ;
    public final void rule__SuiteDefinition__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2529:1: ( ( ( rule__SuiteDefinition__DependenciesAssignment_3_1 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2530:1: ( ( rule__SuiteDefinition__DependenciesAssignment_3_1 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2530:1: ( ( rule__SuiteDefinition__DependenciesAssignment_3_1 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2531:1: ( rule__SuiteDefinition__DependenciesAssignment_3_1 )*
            {
             before(grammarAccess.getSuiteDefinitionAccess().getDependenciesAssignment_3_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2532:1: ( rule__SuiteDefinition__DependenciesAssignment_3_1 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2532:2: rule__SuiteDefinition__DependenciesAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_rule__SuiteDefinition__DependenciesAssignment_3_1_in_rule__SuiteDefinition__Group_3__1__Impl5265);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2546:1: rule__SuiteDefinition__Group_7__0 : rule__SuiteDefinition__Group_7__0__Impl rule__SuiteDefinition__Group_7__1 ;
    public final void rule__SuiteDefinition__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2550:1: ( rule__SuiteDefinition__Group_7__0__Impl rule__SuiteDefinition__Group_7__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2551:2: rule__SuiteDefinition__Group_7__0__Impl rule__SuiteDefinition__Group_7__1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_7__0__Impl_in_rule__SuiteDefinition__Group_7__05300);
            rule__SuiteDefinition__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group_7__1_in_rule__SuiteDefinition__Group_7__05303);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2558:1: rule__SuiteDefinition__Group_7__0__Impl : ( 'concludedby' ) ;
    public final void rule__SuiteDefinition__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2562:1: ( ( 'concludedby' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2563:1: ( 'concludedby' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2563:1: ( 'concludedby' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2564:1: 'concludedby'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getConcludedbyKeyword_7_0()); 
            match(input,28,FOLLOW_28_in_rule__SuiteDefinition__Group_7__0__Impl5331); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2577:1: rule__SuiteDefinition__Group_7__1 : rule__SuiteDefinition__Group_7__1__Impl ;
    public final void rule__SuiteDefinition__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2581:1: ( rule__SuiteDefinition__Group_7__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2582:2: rule__SuiteDefinition__Group_7__1__Impl
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_7__1__Impl_in_rule__SuiteDefinition__Group_7__15362);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2588:1: rule__SuiteDefinition__Group_7__1__Impl : ( ( rule__SuiteDefinition__FinalizersAssignment_7_1 )* ) ;
    public final void rule__SuiteDefinition__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2592:1: ( ( ( rule__SuiteDefinition__FinalizersAssignment_7_1 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2593:1: ( ( rule__SuiteDefinition__FinalizersAssignment_7_1 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2593:1: ( ( rule__SuiteDefinition__FinalizersAssignment_7_1 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2594:1: ( rule__SuiteDefinition__FinalizersAssignment_7_1 )*
            {
             before(grammarAccess.getSuiteDefinitionAccess().getFinalizersAssignment_7_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2595:1: ( rule__SuiteDefinition__FinalizersAssignment_7_1 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2595:2: rule__SuiteDefinition__FinalizersAssignment_7_1
            	    {
            	    pushFollow(FOLLOW_rule__SuiteDefinition__FinalizersAssignment_7_1_in_rule__SuiteDefinition__Group_7__1__Impl5389);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2609:1: rule__VariableDefinition__Group__0 : rule__VariableDefinition__Group__0__Impl rule__VariableDefinition__Group__1 ;
    public final void rule__VariableDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2613:1: ( rule__VariableDefinition__Group__0__Impl rule__VariableDefinition__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2614:2: rule__VariableDefinition__Group__0__Impl rule__VariableDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group__0__Impl_in_rule__VariableDefinition__Group__05424);
            rule__VariableDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDefinition__Group__1_in_rule__VariableDefinition__Group__05427);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2621:1: rule__VariableDefinition__Group__0__Impl : ( 'variable' ) ;
    public final void rule__VariableDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2625:1: ( ( 'variable' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2626:1: ( 'variable' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2626:1: ( 'variable' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2627:1: 'variable'
            {
             before(grammarAccess.getVariableDefinitionAccess().getVariableKeyword_0()); 
            match(input,29,FOLLOW_29_in_rule__VariableDefinition__Group__0__Impl5455); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2640:1: rule__VariableDefinition__Group__1 : rule__VariableDefinition__Group__1__Impl rule__VariableDefinition__Group__2 ;
    public final void rule__VariableDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2644:1: ( rule__VariableDefinition__Group__1__Impl rule__VariableDefinition__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2645:2: rule__VariableDefinition__Group__1__Impl rule__VariableDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group__1__Impl_in_rule__VariableDefinition__Group__15486);
            rule__VariableDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDefinition__Group__2_in_rule__VariableDefinition__Group__15489);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2652:1: rule__VariableDefinition__Group__1__Impl : ( ( rule__VariableDefinition__NameAssignment_1 ) ) ;
    public final void rule__VariableDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2656:1: ( ( ( rule__VariableDefinition__NameAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2657:1: ( ( rule__VariableDefinition__NameAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2657:1: ( ( rule__VariableDefinition__NameAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2658:1: ( rule__VariableDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getVariableDefinitionAccess().getNameAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2659:1: ( rule__VariableDefinition__NameAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2659:2: rule__VariableDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__VariableDefinition__NameAssignment_1_in_rule__VariableDefinition__Group__1__Impl5516);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2669:1: rule__VariableDefinition__Group__2 : rule__VariableDefinition__Group__2__Impl ;
    public final void rule__VariableDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2673:1: ( rule__VariableDefinition__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2674:2: rule__VariableDefinition__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group__2__Impl_in_rule__VariableDefinition__Group__25546);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2680:1: rule__VariableDefinition__Group__2__Impl : ( ( rule__VariableDefinition__Group_2__0 )? ) ;
    public final void rule__VariableDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2684:1: ( ( ( rule__VariableDefinition__Group_2__0 )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2685:1: ( ( rule__VariableDefinition__Group_2__0 )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2685:1: ( ( rule__VariableDefinition__Group_2__0 )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2686:1: ( rule__VariableDefinition__Group_2__0 )?
            {
             before(grammarAccess.getVariableDefinitionAccess().getGroup_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2687:1: ( rule__VariableDefinition__Group_2__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==30) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2687:2: rule__VariableDefinition__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__VariableDefinition__Group_2__0_in_rule__VariableDefinition__Group__2__Impl5573);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2703:1: rule__VariableDefinition__Group_2__0 : rule__VariableDefinition__Group_2__0__Impl rule__VariableDefinition__Group_2__1 ;
    public final void rule__VariableDefinition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2707:1: ( rule__VariableDefinition__Group_2__0__Impl rule__VariableDefinition__Group_2__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2708:2: rule__VariableDefinition__Group_2__0__Impl rule__VariableDefinition__Group_2__1
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group_2__0__Impl_in_rule__VariableDefinition__Group_2__05610);
            rule__VariableDefinition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDefinition__Group_2__1_in_rule__VariableDefinition__Group_2__05613);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2715:1: rule__VariableDefinition__Group_2__0__Impl : ( 'initially' ) ;
    public final void rule__VariableDefinition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2719:1: ( ( 'initially' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2720:1: ( 'initially' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2720:1: ( 'initially' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2721:1: 'initially'
            {
             before(grammarAccess.getVariableDefinitionAccess().getInitiallyKeyword_2_0()); 
            match(input,30,FOLLOW_30_in_rule__VariableDefinition__Group_2__0__Impl5641); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2734:1: rule__VariableDefinition__Group_2__1 : rule__VariableDefinition__Group_2__1__Impl ;
    public final void rule__VariableDefinition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2738:1: ( rule__VariableDefinition__Group_2__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2739:2: rule__VariableDefinition__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group_2__1__Impl_in_rule__VariableDefinition__Group_2__15672);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2745:1: rule__VariableDefinition__Group_2__1__Impl : ( ( rule__VariableDefinition__InitialValueAssignment_2_1 ) ) ;
    public final void rule__VariableDefinition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2749:1: ( ( ( rule__VariableDefinition__InitialValueAssignment_2_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2750:1: ( ( rule__VariableDefinition__InitialValueAssignment_2_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2750:1: ( ( rule__VariableDefinition__InitialValueAssignment_2_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2751:1: ( rule__VariableDefinition__InitialValueAssignment_2_1 )
            {
             before(grammarAccess.getVariableDefinitionAccess().getInitialValueAssignment_2_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2752:1: ( rule__VariableDefinition__InitialValueAssignment_2_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2752:2: rule__VariableDefinition__InitialValueAssignment_2_1
            {
            pushFollow(FOLLOW_rule__VariableDefinition__InitialValueAssignment_2_1_in_rule__VariableDefinition__Group_2__1__Impl5699);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2766:1: rule__ConstantDefinition__Group__0 : rule__ConstantDefinition__Group__0__Impl rule__ConstantDefinition__Group__1 ;
    public final void rule__ConstantDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2770:1: ( rule__ConstantDefinition__Group__0__Impl rule__ConstantDefinition__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2771:2: rule__ConstantDefinition__Group__0__Impl rule__ConstantDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__ConstantDefinition__Group__0__Impl_in_rule__ConstantDefinition__Group__05733);
            rule__ConstantDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstantDefinition__Group__1_in_rule__ConstantDefinition__Group__05736);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2778:1: rule__ConstantDefinition__Group__0__Impl : ( 'constant' ) ;
    public final void rule__ConstantDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2782:1: ( ( 'constant' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2783:1: ( 'constant' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2783:1: ( 'constant' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2784:1: 'constant'
            {
             before(grammarAccess.getConstantDefinitionAccess().getConstantKeyword_0()); 
            match(input,31,FOLLOW_31_in_rule__ConstantDefinition__Group__0__Impl5764); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2797:1: rule__ConstantDefinition__Group__1 : rule__ConstantDefinition__Group__1__Impl rule__ConstantDefinition__Group__2 ;
    public final void rule__ConstantDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2801:1: ( rule__ConstantDefinition__Group__1__Impl rule__ConstantDefinition__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2802:2: rule__ConstantDefinition__Group__1__Impl rule__ConstantDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__ConstantDefinition__Group__1__Impl_in_rule__ConstantDefinition__Group__15795);
            rule__ConstantDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ConstantDefinition__Group__2_in_rule__ConstantDefinition__Group__15798);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2809:1: rule__ConstantDefinition__Group__1__Impl : ( ( rule__ConstantDefinition__NameAssignment_1 ) ) ;
    public final void rule__ConstantDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2813:1: ( ( ( rule__ConstantDefinition__NameAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2814:1: ( ( rule__ConstantDefinition__NameAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2814:1: ( ( rule__ConstantDefinition__NameAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2815:1: ( rule__ConstantDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getConstantDefinitionAccess().getNameAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2816:1: ( rule__ConstantDefinition__NameAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2816:2: rule__ConstantDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ConstantDefinition__NameAssignment_1_in_rule__ConstantDefinition__Group__1__Impl5825);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2826:1: rule__ConstantDefinition__Group__2 : rule__ConstantDefinition__Group__2__Impl ;
    public final void rule__ConstantDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2830:1: ( rule__ConstantDefinition__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2831:2: rule__ConstantDefinition__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ConstantDefinition__Group__2__Impl_in_rule__ConstantDefinition__Group__25855);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2837:1: rule__ConstantDefinition__Group__2__Impl : ( ( rule__ConstantDefinition__ValueAssignment_2 ) ) ;
    public final void rule__ConstantDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2841:1: ( ( ( rule__ConstantDefinition__ValueAssignment_2 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2842:1: ( ( rule__ConstantDefinition__ValueAssignment_2 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2842:1: ( ( rule__ConstantDefinition__ValueAssignment_2 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2843:1: ( rule__ConstantDefinition__ValueAssignment_2 )
            {
             before(grammarAccess.getConstantDefinitionAccess().getValueAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2844:1: ( rule__ConstantDefinition__ValueAssignment_2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2844:2: rule__ConstantDefinition__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__ConstantDefinition__ValueAssignment_2_in_rule__ConstantDefinition__Group__2__Impl5882);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2860:1: rule__Test__Group__0 : rule__Test__Group__0__Impl rule__Test__Group__1 ;
    public final void rule__Test__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2864:1: ( rule__Test__Group__0__Impl rule__Test__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2865:2: rule__Test__Group__0__Impl rule__Test__Group__1
            {
            pushFollow(FOLLOW_rule__Test__Group__0__Impl_in_rule__Test__Group__05918);
            rule__Test__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Test__Group__1_in_rule__Test__Group__05921);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2872:1: rule__Test__Group__0__Impl : ( 'test' ) ;
    public final void rule__Test__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2876:1: ( ( 'test' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2877:1: ( 'test' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2877:1: ( 'test' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2878:1: 'test'
            {
             before(grammarAccess.getTestAccess().getTestKeyword_0()); 
            match(input,32,FOLLOW_32_in_rule__Test__Group__0__Impl5949); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2891:1: rule__Test__Group__1 : rule__Test__Group__1__Impl rule__Test__Group__2 ;
    public final void rule__Test__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2895:1: ( rule__Test__Group__1__Impl rule__Test__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2896:2: rule__Test__Group__1__Impl rule__Test__Group__2
            {
            pushFollow(FOLLOW_rule__Test__Group__1__Impl_in_rule__Test__Group__15980);
            rule__Test__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Test__Group__2_in_rule__Test__Group__15983);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2903:1: rule__Test__Group__1__Impl : ( ( rule__Test__DefinitionAssignment_1 ) ) ;
    public final void rule__Test__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2907:1: ( ( ( rule__Test__DefinitionAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2908:1: ( ( rule__Test__DefinitionAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2908:1: ( ( rule__Test__DefinitionAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2909:1: ( rule__Test__DefinitionAssignment_1 )
            {
             before(grammarAccess.getTestAccess().getDefinitionAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2910:1: ( rule__Test__DefinitionAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2910:2: rule__Test__DefinitionAssignment_1
            {
            pushFollow(FOLLOW_rule__Test__DefinitionAssignment_1_in_rule__Test__Group__1__Impl6010);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2920:1: rule__Test__Group__2 : rule__Test__Group__2__Impl rule__Test__Group__3 ;
    public final void rule__Test__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2924:1: ( rule__Test__Group__2__Impl rule__Test__Group__3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2925:2: rule__Test__Group__2__Impl rule__Test__Group__3
            {
            pushFollow(FOLLOW_rule__Test__Group__2__Impl_in_rule__Test__Group__26040);
            rule__Test__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Test__Group__3_in_rule__Test__Group__26043);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2932:1: rule__Test__Group__2__Impl : ( ( rule__Test__ParametersAssignment_2 )* ) ;
    public final void rule__Test__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2936:1: ( ( ( rule__Test__ParametersAssignment_2 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2937:1: ( ( rule__Test__ParametersAssignment_2 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2937:1: ( ( rule__Test__ParametersAssignment_2 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2938:1: ( rule__Test__ParametersAssignment_2 )*
            {
             before(grammarAccess.getTestAccess().getParametersAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2939:1: ( rule__Test__ParametersAssignment_2 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_ID) ) {
                    int LA22_1 = input.LA(2);

                    if ( (LA22_1==39) ) {
                        alt22=1;
                    }


                }
                else if ( (LA22_0==40) ) {
                    int LA22_2 = input.LA(2);

                    if ( (LA22_2==RULE_ID) ) {
                        int LA22_5 = input.LA(3);

                        if ( (LA22_5==39) ) {
                            alt22=1;
                        }


                    }


                }


                switch (alt22) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2939:2: rule__Test__ParametersAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Test__ParametersAssignment_2_in_rule__Test__Group__2__Impl6070);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2949:1: rule__Test__Group__3 : rule__Test__Group__3__Impl rule__Test__Group__4 ;
    public final void rule__Test__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2953:1: ( rule__Test__Group__3__Impl rule__Test__Group__4 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2954:2: rule__Test__Group__3__Impl rule__Test__Group__4
            {
            pushFollow(FOLLOW_rule__Test__Group__3__Impl_in_rule__Test__Group__36101);
            rule__Test__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Test__Group__4_in_rule__Test__Group__36104);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2961:1: rule__Test__Group__3__Impl : ( ( rule__Test__ResultsAssignment_3 )* ) ;
    public final void rule__Test__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2965:1: ( ( ( rule__Test__ResultsAssignment_3 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2966:1: ( ( rule__Test__ResultsAssignment_3 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2966:1: ( ( rule__Test__ResultsAssignment_3 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2967:1: ( rule__Test__ResultsAssignment_3 )*
            {
             before(grammarAccess.getTestAccess().getResultsAssignment_3()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2968:1: ( rule__Test__ResultsAssignment_3 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_ID||LA23_0==40) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2968:2: rule__Test__ResultsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__Test__ResultsAssignment_3_in_rule__Test__Group__3__Impl6131);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2978:1: rule__Test__Group__4 : rule__Test__Group__4__Impl ;
    public final void rule__Test__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2982:1: ( rule__Test__Group__4__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2983:2: rule__Test__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Test__Group__4__Impl_in_rule__Test__Group__46162);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2989:1: rule__Test__Group__4__Impl : ( ( rule__Test__Group_4__0 )? ) ;
    public final void rule__Test__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2993:1: ( ( ( rule__Test__Group_4__0 )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2994:1: ( ( rule__Test__Group_4__0 )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2994:1: ( ( rule__Test__Group_4__0 )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2995:1: ( rule__Test__Group_4__0 )?
            {
             before(grammarAccess.getTestAccess().getGroup_4()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2996:1: ( rule__Test__Group_4__0 )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==33) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2996:2: rule__Test__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Test__Group_4__0_in_rule__Test__Group__4__Impl6189);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3016:1: rule__Test__Group_4__0 : rule__Test__Group_4__0__Impl rule__Test__Group_4__1 ;
    public final void rule__Test__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3020:1: ( rule__Test__Group_4__0__Impl rule__Test__Group_4__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3021:2: rule__Test__Group_4__0__Impl rule__Test__Group_4__1
            {
            pushFollow(FOLLOW_rule__Test__Group_4__0__Impl_in_rule__Test__Group_4__06230);
            rule__Test__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Test__Group_4__1_in_rule__Test__Group_4__06233);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3028:1: rule__Test__Group_4__0__Impl : ( '=' ) ;
    public final void rule__Test__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3032:1: ( ( '=' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3033:1: ( '=' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3033:1: ( '=' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3034:1: '='
            {
             before(grammarAccess.getTestAccess().getEqualsSignKeyword_4_0()); 
            match(input,33,FOLLOW_33_in_rule__Test__Group_4__0__Impl6261); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3047:1: rule__Test__Group_4__1 : rule__Test__Group_4__1__Impl ;
    public final void rule__Test__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3051:1: ( rule__Test__Group_4__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3052:2: rule__Test__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Test__Group_4__1__Impl_in_rule__Test__Group_4__16292);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3058:1: rule__Test__Group_4__1__Impl : ( ( rule__Test__ResultAssignment_4_1 ) ) ;
    public final void rule__Test__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3062:1: ( ( ( rule__Test__ResultAssignment_4_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3063:1: ( ( rule__Test__ResultAssignment_4_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3063:1: ( ( rule__Test__ResultAssignment_4_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3064:1: ( rule__Test__ResultAssignment_4_1 )
            {
             before(grammarAccess.getTestAccess().getResultAssignment_4_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3065:1: ( rule__Test__ResultAssignment_4_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3065:2: rule__Test__ResultAssignment_4_1
            {
            pushFollow(FOLLOW_rule__Test__ResultAssignment_4_1_in_rule__Test__Group_4__1__Impl6319);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3079:1: rule__TableTest__Group__0 : rule__TableTest__Group__0__Impl rule__TableTest__Group__1 ;
    public final void rule__TableTest__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3083:1: ( rule__TableTest__Group__0__Impl rule__TableTest__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3084:2: rule__TableTest__Group__0__Impl rule__TableTest__Group__1
            {
            pushFollow(FOLLOW_rule__TableTest__Group__0__Impl_in_rule__TableTest__Group__06353);
            rule__TableTest__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group__1_in_rule__TableTest__Group__06356);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3091:1: rule__TableTest__Group__0__Impl : ( 'tabletest' ) ;
    public final void rule__TableTest__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3095:1: ( ( 'tabletest' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3096:1: ( 'tabletest' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3096:1: ( 'tabletest' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3097:1: 'tabletest'
            {
             before(grammarAccess.getTableTestAccess().getTabletestKeyword_0()); 
            match(input,34,FOLLOW_34_in_rule__TableTest__Group__0__Impl6384); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3110:1: rule__TableTest__Group__1 : rule__TableTest__Group__1__Impl rule__TableTest__Group__2 ;
    public final void rule__TableTest__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3114:1: ( rule__TableTest__Group__1__Impl rule__TableTest__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3115:2: rule__TableTest__Group__1__Impl rule__TableTest__Group__2
            {
            pushFollow(FOLLOW_rule__TableTest__Group__1__Impl_in_rule__TableTest__Group__16415);
            rule__TableTest__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group__2_in_rule__TableTest__Group__16418);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3122:1: rule__TableTest__Group__1__Impl : ( ( rule__TableTest__DefinitionAssignment_1 ) ) ;
    public final void rule__TableTest__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3126:1: ( ( ( rule__TableTest__DefinitionAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3127:1: ( ( rule__TableTest__DefinitionAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3127:1: ( ( rule__TableTest__DefinitionAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3128:1: ( rule__TableTest__DefinitionAssignment_1 )
            {
             before(grammarAccess.getTableTestAccess().getDefinitionAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3129:1: ( rule__TableTest__DefinitionAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3129:2: rule__TableTest__DefinitionAssignment_1
            {
            pushFollow(FOLLOW_rule__TableTest__DefinitionAssignment_1_in_rule__TableTest__Group__1__Impl6445);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3139:1: rule__TableTest__Group__2 : rule__TableTest__Group__2__Impl rule__TableTest__Group__3 ;
    public final void rule__TableTest__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3143:1: ( rule__TableTest__Group__2__Impl rule__TableTest__Group__3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3144:2: rule__TableTest__Group__2__Impl rule__TableTest__Group__3
            {
            pushFollow(FOLLOW_rule__TableTest__Group__2__Impl_in_rule__TableTest__Group__26475);
            rule__TableTest__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group__3_in_rule__TableTest__Group__26478);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3151:1: rule__TableTest__Group__2__Impl : ( ( rule__TableTest__ParametersAssignment_2 )* ) ;
    public final void rule__TableTest__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3155:1: ( ( ( rule__TableTest__ParametersAssignment_2 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3156:1: ( ( rule__TableTest__ParametersAssignment_2 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3156:1: ( ( rule__TableTest__ParametersAssignment_2 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3157:1: ( rule__TableTest__ParametersAssignment_2 )*
            {
             before(grammarAccess.getTableTestAccess().getParametersAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3158:1: ( rule__TableTest__ParametersAssignment_2 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_ID||LA25_0==40) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3158:2: rule__TableTest__ParametersAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__TableTest__ParametersAssignment_2_in_rule__TableTest__Group__2__Impl6505);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3168:1: rule__TableTest__Group__3 : rule__TableTest__Group__3__Impl rule__TableTest__Group__4 ;
    public final void rule__TableTest__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3172:1: ( rule__TableTest__Group__3__Impl rule__TableTest__Group__4 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3173:2: rule__TableTest__Group__3__Impl rule__TableTest__Group__4
            {
            pushFollow(FOLLOW_rule__TableTest__Group__3__Impl_in_rule__TableTest__Group__36536);
            rule__TableTest__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group__4_in_rule__TableTest__Group__36539);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3180:1: rule__TableTest__Group__3__Impl : ( ( rule__TableTest__ParameterHeadersAssignment_3 )* ) ;
    public final void rule__TableTest__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3184:1: ( ( ( rule__TableTest__ParameterHeadersAssignment_3 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3185:1: ( ( rule__TableTest__ParameterHeadersAssignment_3 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3185:1: ( ( rule__TableTest__ParameterHeadersAssignment_3 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3186:1: ( rule__TableTest__ParameterHeadersAssignment_3 )*
            {
             before(grammarAccess.getTableTestAccess().getParameterHeadersAssignment_3()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3187:1: ( rule__TableTest__ParameterHeadersAssignment_3 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==15) ) {
                    int LA26_1 = input.LA(2);

                    if ( (LA26_1==RULE_ID) ) {
                        int LA26_3 = input.LA(3);

                        if ( (LA26_3==15) ) {
                            alt26=1;
                        }


                    }
                    else if ( (LA26_1==40) ) {
                        int LA26_4 = input.LA(3);

                        if ( (LA26_4==RULE_ID) ) {
                            int LA26_6 = input.LA(4);

                            if ( (LA26_6==15) ) {
                                alt26=1;
                            }


                        }


                    }


                }


                switch (alt26) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3187:2: rule__TableTest__ParameterHeadersAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__TableTest__ParameterHeadersAssignment_3_in_rule__TableTest__Group__3__Impl6566);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3197:1: rule__TableTest__Group__4 : rule__TableTest__Group__4__Impl rule__TableTest__Group__5 ;
    public final void rule__TableTest__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3201:1: ( rule__TableTest__Group__4__Impl rule__TableTest__Group__5 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3202:2: rule__TableTest__Group__4__Impl rule__TableTest__Group__5
            {
            pushFollow(FOLLOW_rule__TableTest__Group__4__Impl_in_rule__TableTest__Group__46597);
            rule__TableTest__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group__5_in_rule__TableTest__Group__46600);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3209:1: rule__TableTest__Group__4__Impl : ( ( rule__TableTest__ResultHeadersAssignment_4 )* ) ;
    public final void rule__TableTest__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3213:1: ( ( ( rule__TableTest__ResultHeadersAssignment_4 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3214:1: ( ( rule__TableTest__ResultHeadersAssignment_4 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3214:1: ( ( rule__TableTest__ResultHeadersAssignment_4 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3215:1: ( rule__TableTest__ResultHeadersAssignment_4 )*
            {
             before(grammarAccess.getTableTestAccess().getResultHeadersAssignment_4()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3216:1: ( rule__TableTest__ResultHeadersAssignment_4 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==15) ) {
                    int LA27_1 = input.LA(2);

                    if ( (LA27_1==RULE_ID||LA27_1==40) ) {
                        alt27=1;
                    }


                }


                switch (alt27) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3216:2: rule__TableTest__ResultHeadersAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__TableTest__ResultHeadersAssignment_4_in_rule__TableTest__Group__4__Impl6627);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3226:1: rule__TableTest__Group__5 : rule__TableTest__Group__5__Impl rule__TableTest__Group__6 ;
    public final void rule__TableTest__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3230:1: ( rule__TableTest__Group__5__Impl rule__TableTest__Group__6 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3231:2: rule__TableTest__Group__5__Impl rule__TableTest__Group__6
            {
            pushFollow(FOLLOW_rule__TableTest__Group__5__Impl_in_rule__TableTest__Group__56658);
            rule__TableTest__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group__6_in_rule__TableTest__Group__56661);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3238:1: rule__TableTest__Group__5__Impl : ( ( rule__TableTest__Alternatives_5 ) ) ;
    public final void rule__TableTest__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3242:1: ( ( ( rule__TableTest__Alternatives_5 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3243:1: ( ( rule__TableTest__Alternatives_5 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3243:1: ( ( rule__TableTest__Alternatives_5 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3244:1: ( rule__TableTest__Alternatives_5 )
            {
             before(grammarAccess.getTableTestAccess().getAlternatives_5()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3245:1: ( rule__TableTest__Alternatives_5 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3245:2: rule__TableTest__Alternatives_5
            {
            pushFollow(FOLLOW_rule__TableTest__Alternatives_5_in_rule__TableTest__Group__5__Impl6688);
            rule__TableTest__Alternatives_5();

            state._fsp--;


            }

             after(grammarAccess.getTableTestAccess().getAlternatives_5()); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3255:1: rule__TableTest__Group__6 : rule__TableTest__Group__6__Impl ;
    public final void rule__TableTest__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3259:1: ( rule__TableTest__Group__6__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3260:2: rule__TableTest__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__TableTest__Group__6__Impl_in_rule__TableTest__Group__66718);
            rule__TableTest__Group__6__Impl();

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3266:1: rule__TableTest__Group__6__Impl : ( ( ( rule__TableTest__RowsAssignment_6 ) ) ( ( rule__TableTest__RowsAssignment_6 )* ) ) ;
    public final void rule__TableTest__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3270:1: ( ( ( ( rule__TableTest__RowsAssignment_6 ) ) ( ( rule__TableTest__RowsAssignment_6 )* ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3271:1: ( ( ( rule__TableTest__RowsAssignment_6 ) ) ( ( rule__TableTest__RowsAssignment_6 )* ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3271:1: ( ( ( rule__TableTest__RowsAssignment_6 ) ) ( ( rule__TableTest__RowsAssignment_6 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3272:1: ( ( rule__TableTest__RowsAssignment_6 ) ) ( ( rule__TableTest__RowsAssignment_6 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3272:1: ( ( rule__TableTest__RowsAssignment_6 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3273:1: ( rule__TableTest__RowsAssignment_6 )
            {
             before(grammarAccess.getTableTestAccess().getRowsAssignment_6()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3274:1: ( rule__TableTest__RowsAssignment_6 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3274:2: rule__TableTest__RowsAssignment_6
            {
            pushFollow(FOLLOW_rule__TableTest__RowsAssignment_6_in_rule__TableTest__Group__6__Impl6747);
            rule__TableTest__RowsAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getTableTestAccess().getRowsAssignment_6()); 

            }

            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3277:1: ( ( rule__TableTest__RowsAssignment_6 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3278:1: ( rule__TableTest__RowsAssignment_6 )*
            {
             before(grammarAccess.getTableTestAccess().getRowsAssignment_6()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3279:1: ( rule__TableTest__RowsAssignment_6 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==15) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3279:2: rule__TableTest__RowsAssignment_6
            	    {
            	    pushFollow(FOLLOW_rule__TableTest__RowsAssignment_6_in_rule__TableTest__Group__6__Impl6759);
            	    rule__TableTest__RowsAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

             after(grammarAccess.getTableTestAccess().getRowsAssignment_6()); 

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
    // $ANTLR end "rule__TableTest__Group__6__Impl"


    // $ANTLR start "rule__TableTest__Group_5_0__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3304:1: rule__TableTest__Group_5_0__0 : rule__TableTest__Group_5_0__0__Impl rule__TableTest__Group_5_0__1 ;
    public final void rule__TableTest__Group_5_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3308:1: ( rule__TableTest__Group_5_0__0__Impl rule__TableTest__Group_5_0__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3309:2: rule__TableTest__Group_5_0__0__Impl rule__TableTest__Group_5_0__1
            {
            pushFollow(FOLLOW_rule__TableTest__Group_5_0__0__Impl_in_rule__TableTest__Group_5_0__06806);
            rule__TableTest__Group_5_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group_5_0__1_in_rule__TableTest__Group_5_0__06809);
            rule__TableTest__Group_5_0__1();

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
    // $ANTLR end "rule__TableTest__Group_5_0__0"


    // $ANTLR start "rule__TableTest__Group_5_0__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3316:1: rule__TableTest__Group_5_0__0__Impl : ( '|' ) ;
    public final void rule__TableTest__Group_5_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3320:1: ( ( '|' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3321:1: ( '|' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3321:1: ( '|' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3322:1: '|'
            {
             before(grammarAccess.getTableTestAccess().getVerticalLineKeyword_5_0_0()); 
            match(input,15,FOLLOW_15_in_rule__TableTest__Group_5_0__0__Impl6837); 
             after(grammarAccess.getTableTestAccess().getVerticalLineKeyword_5_0_0()); 

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
    // $ANTLR end "rule__TableTest__Group_5_0__0__Impl"


    // $ANTLR start "rule__TableTest__Group_5_0__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3335:1: rule__TableTest__Group_5_0__1 : rule__TableTest__Group_5_0__1__Impl rule__TableTest__Group_5_0__2 ;
    public final void rule__TableTest__Group_5_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3339:1: ( rule__TableTest__Group_5_0__1__Impl rule__TableTest__Group_5_0__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3340:2: rule__TableTest__Group_5_0__1__Impl rule__TableTest__Group_5_0__2
            {
            pushFollow(FOLLOW_rule__TableTest__Group_5_0__1__Impl_in_rule__TableTest__Group_5_0__16868);
            rule__TableTest__Group_5_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group_5_0__2_in_rule__TableTest__Group_5_0__16871);
            rule__TableTest__Group_5_0__2();

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
    // $ANTLR end "rule__TableTest__Group_5_0__1"


    // $ANTLR start "rule__TableTest__Group_5_0__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3347:1: rule__TableTest__Group_5_0__1__Impl : ( '=' ) ;
    public final void rule__TableTest__Group_5_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3351:1: ( ( '=' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3352:1: ( '=' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3352:1: ( '=' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3353:1: '='
            {
             before(grammarAccess.getTableTestAccess().getEqualsSignKeyword_5_0_1()); 
            match(input,33,FOLLOW_33_in_rule__TableTest__Group_5_0__1__Impl6899); 
             after(grammarAccess.getTableTestAccess().getEqualsSignKeyword_5_0_1()); 

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
    // $ANTLR end "rule__TableTest__Group_5_0__1__Impl"


    // $ANTLR start "rule__TableTest__Group_5_0__2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3366:1: rule__TableTest__Group_5_0__2 : rule__TableTest__Group_5_0__2__Impl ;
    public final void rule__TableTest__Group_5_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3370:1: ( rule__TableTest__Group_5_0__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3371:2: rule__TableTest__Group_5_0__2__Impl
            {
            pushFollow(FOLLOW_rule__TableTest__Group_5_0__2__Impl_in_rule__TableTest__Group_5_0__26930);
            rule__TableTest__Group_5_0__2__Impl();

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
    // $ANTLR end "rule__TableTest__Group_5_0__2"


    // $ANTLR start "rule__TableTest__Group_5_0__2__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3377:1: rule__TableTest__Group_5_0__2__Impl : ( '|' ) ;
    public final void rule__TableTest__Group_5_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3381:1: ( ( '|' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3382:1: ( '|' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3382:1: ( '|' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3383:1: '|'
            {
             before(grammarAccess.getTableTestAccess().getVerticalLineKeyword_5_0_2()); 
            match(input,15,FOLLOW_15_in_rule__TableTest__Group_5_0__2__Impl6958); 
             after(grammarAccess.getTableTestAccess().getVerticalLineKeyword_5_0_2()); 

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
    // $ANTLR end "rule__TableTest__Group_5_0__2__Impl"


    // $ANTLR start "rule__TableTestRow__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3402:1: rule__TableTestRow__Group__0 : rule__TableTestRow__Group__0__Impl rule__TableTestRow__Group__1 ;
    public final void rule__TableTestRow__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3406:1: ( rule__TableTestRow__Group__0__Impl rule__TableTestRow__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3407:2: rule__TableTestRow__Group__0__Impl rule__TableTestRow__Group__1
            {
            pushFollow(FOLLOW_rule__TableTestRow__Group__0__Impl_in_rule__TableTestRow__Group__06995);
            rule__TableTestRow__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTestRow__Group__1_in_rule__TableTestRow__Group__06998);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3414:1: rule__TableTestRow__Group__0__Impl : ( () ) ;
    public final void rule__TableTestRow__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3418:1: ( ( () ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3419:1: ( () )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3419:1: ( () )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3420:1: ()
            {
             before(grammarAccess.getTableTestRowAccess().getTableTestRowAction_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3421:1: ()
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3423:1: 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3433:1: rule__TableTestRow__Group__1 : rule__TableTestRow__Group__1__Impl rule__TableTestRow__Group__2 ;
    public final void rule__TableTestRow__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3437:1: ( rule__TableTestRow__Group__1__Impl rule__TableTestRow__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3438:2: rule__TableTestRow__Group__1__Impl rule__TableTestRow__Group__2
            {
            pushFollow(FOLLOW_rule__TableTestRow__Group__1__Impl_in_rule__TableTestRow__Group__17056);
            rule__TableTestRow__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTestRow__Group__2_in_rule__TableTestRow__Group__17059);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3445:1: rule__TableTestRow__Group__1__Impl : ( ( rule__TableTestRow__ValuesAssignment_1 )* ) ;
    public final void rule__TableTestRow__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3449:1: ( ( ( rule__TableTestRow__ValuesAssignment_1 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3450:1: ( ( rule__TableTestRow__ValuesAssignment_1 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3450:1: ( ( rule__TableTestRow__ValuesAssignment_1 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3451:1: ( rule__TableTestRow__ValuesAssignment_1 )*
            {
             before(grammarAccess.getTableTestRowAccess().getValuesAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3452:1: ( rule__TableTestRow__ValuesAssignment_1 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==15) ) {
                    int LA29_1 = input.LA(2);

                    if ( ((LA29_1>=RULE_ID && LA29_1<=RULE_UPPERCASE_ID)||(LA29_1>=RULE_STRING && LA29_1<=RULE_DECIMAL)) ) {
                        alt29=1;
                    }


                }


                switch (alt29) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3452:2: rule__TableTestRow__ValuesAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__TableTestRow__ValuesAssignment_1_in_rule__TableTestRow__Group__1__Impl7086);
            	    rule__TableTestRow__ValuesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3462:1: rule__TableTestRow__Group__2 : rule__TableTestRow__Group__2__Impl ;
    public final void rule__TableTestRow__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3466:1: ( rule__TableTestRow__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3467:2: rule__TableTestRow__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__TableTestRow__Group__2__Impl_in_rule__TableTestRow__Group__27117);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3473:1: rule__TableTestRow__Group__2__Impl : ( ( rule__TableTestRow__Alternatives_2 ) ) ;
    public final void rule__TableTestRow__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3477:1: ( ( ( rule__TableTestRow__Alternatives_2 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3478:1: ( ( rule__TableTestRow__Alternatives_2 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3478:1: ( ( rule__TableTestRow__Alternatives_2 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3479:1: ( rule__TableTestRow__Alternatives_2 )
            {
             before(grammarAccess.getTableTestRowAccess().getAlternatives_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3480:1: ( rule__TableTestRow__Alternatives_2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3480:2: rule__TableTestRow__Alternatives_2
            {
            pushFollow(FOLLOW_rule__TableTestRow__Alternatives_2_in_rule__TableTestRow__Group__2__Impl7144);
            rule__TableTestRow__Alternatives_2();

            state._fsp--;


            }

             after(grammarAccess.getTableTestRowAccess().getAlternatives_2()); 

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


    // $ANTLR start "rule__TableTestRow__Group_2_0__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3496:1: rule__TableTestRow__Group_2_0__0 : rule__TableTestRow__Group_2_0__0__Impl rule__TableTestRow__Group_2_0__1 ;
    public final void rule__TableTestRow__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3500:1: ( rule__TableTestRow__Group_2_0__0__Impl rule__TableTestRow__Group_2_0__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3501:2: rule__TableTestRow__Group_2_0__0__Impl rule__TableTestRow__Group_2_0__1
            {
            pushFollow(FOLLOW_rule__TableTestRow__Group_2_0__0__Impl_in_rule__TableTestRow__Group_2_0__07180);
            rule__TableTestRow__Group_2_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTestRow__Group_2_0__1_in_rule__TableTestRow__Group_2_0__07183);
            rule__TableTestRow__Group_2_0__1();

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
    // $ANTLR end "rule__TableTestRow__Group_2_0__0"


    // $ANTLR start "rule__TableTestRow__Group_2_0__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3508:1: rule__TableTestRow__Group_2_0__0__Impl : ( '|' ) ;
    public final void rule__TableTestRow__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3512:1: ( ( '|' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3513:1: ( '|' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3513:1: ( '|' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3514:1: '|'
            {
             before(grammarAccess.getTableTestRowAccess().getVerticalLineKeyword_2_0_0()); 
            match(input,15,FOLLOW_15_in_rule__TableTestRow__Group_2_0__0__Impl7211); 
             after(grammarAccess.getTableTestRowAccess().getVerticalLineKeyword_2_0_0()); 

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
    // $ANTLR end "rule__TableTestRow__Group_2_0__0__Impl"


    // $ANTLR start "rule__TableTestRow__Group_2_0__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3527:1: rule__TableTestRow__Group_2_0__1 : rule__TableTestRow__Group_2_0__1__Impl rule__TableTestRow__Group_2_0__2 ;
    public final void rule__TableTestRow__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3531:1: ( rule__TableTestRow__Group_2_0__1__Impl rule__TableTestRow__Group_2_0__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3532:2: rule__TableTestRow__Group_2_0__1__Impl rule__TableTestRow__Group_2_0__2
            {
            pushFollow(FOLLOW_rule__TableTestRow__Group_2_0__1__Impl_in_rule__TableTestRow__Group_2_0__17242);
            rule__TableTestRow__Group_2_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTestRow__Group_2_0__2_in_rule__TableTestRow__Group_2_0__17245);
            rule__TableTestRow__Group_2_0__2();

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
    // $ANTLR end "rule__TableTestRow__Group_2_0__1"


    // $ANTLR start "rule__TableTestRow__Group_2_0__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3539:1: rule__TableTestRow__Group_2_0__1__Impl : ( '=' ) ;
    public final void rule__TableTestRow__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3543:1: ( ( '=' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3544:1: ( '=' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3544:1: ( '=' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3545:1: '='
            {
             before(grammarAccess.getTableTestRowAccess().getEqualsSignKeyword_2_0_1()); 
            match(input,33,FOLLOW_33_in_rule__TableTestRow__Group_2_0__1__Impl7273); 
             after(grammarAccess.getTableTestRowAccess().getEqualsSignKeyword_2_0_1()); 

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
    // $ANTLR end "rule__TableTestRow__Group_2_0__1__Impl"


    // $ANTLR start "rule__TableTestRow__Group_2_0__2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3558:1: rule__TableTestRow__Group_2_0__2 : rule__TableTestRow__Group_2_0__2__Impl rule__TableTestRow__Group_2_0__3 ;
    public final void rule__TableTestRow__Group_2_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3562:1: ( rule__TableTestRow__Group_2_0__2__Impl rule__TableTestRow__Group_2_0__3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3563:2: rule__TableTestRow__Group_2_0__2__Impl rule__TableTestRow__Group_2_0__3
            {
            pushFollow(FOLLOW_rule__TableTestRow__Group_2_0__2__Impl_in_rule__TableTestRow__Group_2_0__27304);
            rule__TableTestRow__Group_2_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTestRow__Group_2_0__3_in_rule__TableTestRow__Group_2_0__27307);
            rule__TableTestRow__Group_2_0__3();

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
    // $ANTLR end "rule__TableTestRow__Group_2_0__2"


    // $ANTLR start "rule__TableTestRow__Group_2_0__2__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3570:1: rule__TableTestRow__Group_2_0__2__Impl : ( ( rule__TableTestRow__ResultAssignment_2_0_2 ) ) ;
    public final void rule__TableTestRow__Group_2_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3574:1: ( ( ( rule__TableTestRow__ResultAssignment_2_0_2 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3575:1: ( ( rule__TableTestRow__ResultAssignment_2_0_2 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3575:1: ( ( rule__TableTestRow__ResultAssignment_2_0_2 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3576:1: ( rule__TableTestRow__ResultAssignment_2_0_2 )
            {
             before(grammarAccess.getTableTestRowAccess().getResultAssignment_2_0_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3577:1: ( rule__TableTestRow__ResultAssignment_2_0_2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3577:2: rule__TableTestRow__ResultAssignment_2_0_2
            {
            pushFollow(FOLLOW_rule__TableTestRow__ResultAssignment_2_0_2_in_rule__TableTestRow__Group_2_0__2__Impl7334);
            rule__TableTestRow__ResultAssignment_2_0_2();

            state._fsp--;


            }

             after(grammarAccess.getTableTestRowAccess().getResultAssignment_2_0_2()); 

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
    // $ANTLR end "rule__TableTestRow__Group_2_0__2__Impl"


    // $ANTLR start "rule__TableTestRow__Group_2_0__3"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3587:1: rule__TableTestRow__Group_2_0__3 : rule__TableTestRow__Group_2_0__3__Impl ;
    public final void rule__TableTestRow__Group_2_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3591:1: ( rule__TableTestRow__Group_2_0__3__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3592:2: rule__TableTestRow__Group_2_0__3__Impl
            {
            pushFollow(FOLLOW_rule__TableTestRow__Group_2_0__3__Impl_in_rule__TableTestRow__Group_2_0__37364);
            rule__TableTestRow__Group_2_0__3__Impl();

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
    // $ANTLR end "rule__TableTestRow__Group_2_0__3"


    // $ANTLR start "rule__TableTestRow__Group_2_0__3__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3598:1: rule__TableTestRow__Group_2_0__3__Impl : ( '|' ) ;
    public final void rule__TableTestRow__Group_2_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3602:1: ( ( '|' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3603:1: ( '|' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3603:1: ( '|' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3604:1: '|'
            {
             before(grammarAccess.getTableTestRowAccess().getVerticalLineKeyword_2_0_3()); 
            match(input,15,FOLLOW_15_in_rule__TableTestRow__Group_2_0__3__Impl7392); 
             after(grammarAccess.getTableTestRowAccess().getVerticalLineKeyword_2_0_3()); 

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
    // $ANTLR end "rule__TableTestRow__Group_2_0__3__Impl"


    // $ANTLR start "rule__ParameterTableHeader__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3625:1: rule__ParameterTableHeader__Group__0 : rule__ParameterTableHeader__Group__0__Impl rule__ParameterTableHeader__Group__1 ;
    public final void rule__ParameterTableHeader__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3629:1: ( rule__ParameterTableHeader__Group__0__Impl rule__ParameterTableHeader__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3630:2: rule__ParameterTableHeader__Group__0__Impl rule__ParameterTableHeader__Group__1
            {
            pushFollow(FOLLOW_rule__ParameterTableHeader__Group__0__Impl_in_rule__ParameterTableHeader__Group__07431);
            rule__ParameterTableHeader__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParameterTableHeader__Group__1_in_rule__ParameterTableHeader__Group__07434);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3637:1: rule__ParameterTableHeader__Group__0__Impl : ( '|' ) ;
    public final void rule__ParameterTableHeader__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3641:1: ( ( '|' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3642:1: ( '|' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3642:1: ( '|' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3643:1: '|'
            {
             before(grammarAccess.getParameterTableHeaderAccess().getVerticalLineKeyword_0()); 
            match(input,15,FOLLOW_15_in_rule__ParameterTableHeader__Group__0__Impl7462); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3656:1: rule__ParameterTableHeader__Group__1 : rule__ParameterTableHeader__Group__1__Impl ;
    public final void rule__ParameterTableHeader__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3660:1: ( rule__ParameterTableHeader__Group__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3661:2: rule__ParameterTableHeader__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ParameterTableHeader__Group__1__Impl_in_rule__ParameterTableHeader__Group__17493);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3667:1: rule__ParameterTableHeader__Group__1__Impl : ( ( rule__ParameterTableHeader__NameAssignment_1 ) ) ;
    public final void rule__ParameterTableHeader__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3671:1: ( ( ( rule__ParameterTableHeader__NameAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3672:1: ( ( rule__ParameterTableHeader__NameAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3672:1: ( ( rule__ParameterTableHeader__NameAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3673:1: ( rule__ParameterTableHeader__NameAssignment_1 )
            {
             before(grammarAccess.getParameterTableHeaderAccess().getNameAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3674:1: ( rule__ParameterTableHeader__NameAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3674:2: rule__ParameterTableHeader__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ParameterTableHeader__NameAssignment_1_in_rule__ParameterTableHeader__Group__1__Impl7520);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3688:1: rule__ResultTableHeader__Group__0 : rule__ResultTableHeader__Group__0__Impl rule__ResultTableHeader__Group__1 ;
    public final void rule__ResultTableHeader__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3692:1: ( rule__ResultTableHeader__Group__0__Impl rule__ResultTableHeader__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3693:2: rule__ResultTableHeader__Group__0__Impl rule__ResultTableHeader__Group__1
            {
            pushFollow(FOLLOW_rule__ResultTableHeader__Group__0__Impl_in_rule__ResultTableHeader__Group__07554);
            rule__ResultTableHeader__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultTableHeader__Group__1_in_rule__ResultTableHeader__Group__07557);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3700:1: rule__ResultTableHeader__Group__0__Impl : ( '|' ) ;
    public final void rule__ResultTableHeader__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3704:1: ( ( '|' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3705:1: ( '|' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3705:1: ( '|' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3706:1: '|'
            {
             before(grammarAccess.getResultTableHeaderAccess().getVerticalLineKeyword_0()); 
            match(input,15,FOLLOW_15_in_rule__ResultTableHeader__Group__0__Impl7585); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3719:1: rule__ResultTableHeader__Group__1 : rule__ResultTableHeader__Group__1__Impl rule__ResultTableHeader__Group__2 ;
    public final void rule__ResultTableHeader__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3723:1: ( rule__ResultTableHeader__Group__1__Impl rule__ResultTableHeader__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3724:2: rule__ResultTableHeader__Group__1__Impl rule__ResultTableHeader__Group__2
            {
            pushFollow(FOLLOW_rule__ResultTableHeader__Group__1__Impl_in_rule__ResultTableHeader__Group__17616);
            rule__ResultTableHeader__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultTableHeader__Group__2_in_rule__ResultTableHeader__Group__17619);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3731:1: rule__ResultTableHeader__Group__1__Impl : ( ( rule__ResultTableHeader__NameAssignment_1 ) ) ;
    public final void rule__ResultTableHeader__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3735:1: ( ( ( rule__ResultTableHeader__NameAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3736:1: ( ( rule__ResultTableHeader__NameAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3736:1: ( ( rule__ResultTableHeader__NameAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3737:1: ( rule__ResultTableHeader__NameAssignment_1 )
            {
             before(grammarAccess.getResultTableHeaderAccess().getNameAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3738:1: ( rule__ResultTableHeader__NameAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3738:2: rule__ResultTableHeader__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ResultTableHeader__NameAssignment_1_in_rule__ResultTableHeader__Group__1__Impl7646);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3748:1: rule__ResultTableHeader__Group__2 : rule__ResultTableHeader__Group__2__Impl ;
    public final void rule__ResultTableHeader__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3752:1: ( rule__ResultTableHeader__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3753:2: rule__ResultTableHeader__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ResultTableHeader__Group__2__Impl_in_rule__ResultTableHeader__Group__27676);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3759:1: rule__ResultTableHeader__Group__2__Impl : ( '=' ) ;
    public final void rule__ResultTableHeader__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3763:1: ( ( '=' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3764:1: ( '=' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3764:1: ( '=' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3765:1: '='
            {
             before(grammarAccess.getResultTableHeaderAccess().getEqualsSignKeyword_2()); 
            match(input,33,FOLLOW_33_in_rule__ResultTableHeader__Group__2__Impl7704); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3784:1: rule__ParameterTableValue__Group__0 : rule__ParameterTableValue__Group__0__Impl rule__ParameterTableValue__Group__1 ;
    public final void rule__ParameterTableValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3788:1: ( rule__ParameterTableValue__Group__0__Impl rule__ParameterTableValue__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3789:2: rule__ParameterTableValue__Group__0__Impl rule__ParameterTableValue__Group__1
            {
            pushFollow(FOLLOW_rule__ParameterTableValue__Group__0__Impl_in_rule__ParameterTableValue__Group__07741);
            rule__ParameterTableValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParameterTableValue__Group__1_in_rule__ParameterTableValue__Group__07744);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3796:1: rule__ParameterTableValue__Group__0__Impl : ( '|' ) ;
    public final void rule__ParameterTableValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3800:1: ( ( '|' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3801:1: ( '|' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3801:1: ( '|' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3802:1: '|'
            {
             before(grammarAccess.getParameterTableValueAccess().getVerticalLineKeyword_0()); 
            match(input,15,FOLLOW_15_in_rule__ParameterTableValue__Group__0__Impl7772); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3815:1: rule__ParameterTableValue__Group__1 : rule__ParameterTableValue__Group__1__Impl ;
    public final void rule__ParameterTableValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3819:1: ( rule__ParameterTableValue__Group__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3820:2: rule__ParameterTableValue__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ParameterTableValue__Group__1__Impl_in_rule__ParameterTableValue__Group__17803);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3826:1: rule__ParameterTableValue__Group__1__Impl : ( ( rule__ParameterTableValue__ValueAssignment_1 ) ) ;
    public final void rule__ParameterTableValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3830:1: ( ( ( rule__ParameterTableValue__ValueAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3831:1: ( ( rule__ParameterTableValue__ValueAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3831:1: ( ( rule__ParameterTableValue__ValueAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3832:1: ( rule__ParameterTableValue__ValueAssignment_1 )
            {
             before(grammarAccess.getParameterTableValueAccess().getValueAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3833:1: ( rule__ParameterTableValue__ValueAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3833:2: rule__ParameterTableValue__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__ParameterTableValue__ValueAssignment_1_in_rule__ParameterTableValue__Group__1__Impl7830);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3847:1: rule__NamedResult__Group__0 : rule__NamedResult__Group__0__Impl rule__NamedResult__Group__1 ;
    public final void rule__NamedResult__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3851:1: ( rule__NamedResult__Group__0__Impl rule__NamedResult__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3852:2: rule__NamedResult__Group__0__Impl rule__NamedResult__Group__1
            {
            pushFollow(FOLLOW_rule__NamedResult__Group__0__Impl_in_rule__NamedResult__Group__07864);
            rule__NamedResult__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NamedResult__Group__1_in_rule__NamedResult__Group__07867);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3859:1: rule__NamedResult__Group__0__Impl : ( ( rule__NamedResult__NameAssignment_0 ) ) ;
    public final void rule__NamedResult__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3863:1: ( ( ( rule__NamedResult__NameAssignment_0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3864:1: ( ( rule__NamedResult__NameAssignment_0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3864:1: ( ( rule__NamedResult__NameAssignment_0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3865:1: ( rule__NamedResult__NameAssignment_0 )
            {
             before(grammarAccess.getNamedResultAccess().getNameAssignment_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3866:1: ( rule__NamedResult__NameAssignment_0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3866:2: rule__NamedResult__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__NamedResult__NameAssignment_0_in_rule__NamedResult__Group__0__Impl7894);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3876:1: rule__NamedResult__Group__1 : rule__NamedResult__Group__1__Impl rule__NamedResult__Group__2 ;
    public final void rule__NamedResult__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3880:1: ( rule__NamedResult__Group__1__Impl rule__NamedResult__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3881:2: rule__NamedResult__Group__1__Impl rule__NamedResult__Group__2
            {
            pushFollow(FOLLOW_rule__NamedResult__Group__1__Impl_in_rule__NamedResult__Group__17924);
            rule__NamedResult__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NamedResult__Group__2_in_rule__NamedResult__Group__17927);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3888:1: rule__NamedResult__Group__1__Impl : ( '=' ) ;
    public final void rule__NamedResult__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3892:1: ( ( '=' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3893:1: ( '=' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3893:1: ( '=' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3894:1: '='
            {
             before(grammarAccess.getNamedResultAccess().getEqualsSignKeyword_1()); 
            match(input,33,FOLLOW_33_in_rule__NamedResult__Group__1__Impl7955); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3907:1: rule__NamedResult__Group__2 : rule__NamedResult__Group__2__Impl ;
    public final void rule__NamedResult__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3911:1: ( rule__NamedResult__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3912:2: rule__NamedResult__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__NamedResult__Group__2__Impl_in_rule__NamedResult__Group__27986);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3918:1: rule__NamedResult__Group__2__Impl : ( ( rule__NamedResult__ValueAssignment_2 ) ) ;
    public final void rule__NamedResult__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3922:1: ( ( ( rule__NamedResult__ValueAssignment_2 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3923:1: ( ( rule__NamedResult__ValueAssignment_2 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3923:1: ( ( rule__NamedResult__ValueAssignment_2 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3924:1: ( rule__NamedResult__ValueAssignment_2 )
            {
             before(grammarAccess.getNamedResultAccess().getValueAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3925:1: ( rule__NamedResult__ValueAssignment_2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3925:2: rule__NamedResult__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__NamedResult__ValueAssignment_2_in_rule__NamedResult__Group__2__Impl8013);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3941:1: rule__Call__Group__0 : rule__Call__Group__0__Impl rule__Call__Group__1 ;
    public final void rule__Call__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3945:1: ( rule__Call__Group__0__Impl rule__Call__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3946:2: rule__Call__Group__0__Impl rule__Call__Group__1
            {
            pushFollow(FOLLOW_rule__Call__Group__0__Impl_in_rule__Call__Group__08049);
            rule__Call__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group__1_in_rule__Call__Group__08052);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3953:1: rule__Call__Group__0__Impl : ( 'call' ) ;
    public final void rule__Call__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3957:1: ( ( 'call' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3958:1: ( 'call' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3958:1: ( 'call' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3959:1: 'call'
            {
             before(grammarAccess.getCallAccess().getCallKeyword_0()); 
            match(input,35,FOLLOW_35_in_rule__Call__Group__0__Impl8080); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3972:1: rule__Call__Group__1 : rule__Call__Group__1__Impl rule__Call__Group__2 ;
    public final void rule__Call__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3976:1: ( rule__Call__Group__1__Impl rule__Call__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3977:2: rule__Call__Group__1__Impl rule__Call__Group__2
            {
            pushFollow(FOLLOW_rule__Call__Group__1__Impl_in_rule__Call__Group__18111);
            rule__Call__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group__2_in_rule__Call__Group__18114);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3984:1: rule__Call__Group__1__Impl : ( ( rule__Call__DefinitionAssignment_1 ) ) ;
    public final void rule__Call__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3988:1: ( ( ( rule__Call__DefinitionAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3989:1: ( ( rule__Call__DefinitionAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3989:1: ( ( rule__Call__DefinitionAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3990:1: ( rule__Call__DefinitionAssignment_1 )
            {
             before(grammarAccess.getCallAccess().getDefinitionAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3991:1: ( rule__Call__DefinitionAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3991:2: rule__Call__DefinitionAssignment_1
            {
            pushFollow(FOLLOW_rule__Call__DefinitionAssignment_1_in_rule__Call__Group__1__Impl8141);
            rule__Call__DefinitionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getCallAccess().getDefinitionAssignment_1()); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4001:1: rule__Call__Group__2 : rule__Call__Group__2__Impl rule__Call__Group__3 ;
    public final void rule__Call__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4005:1: ( rule__Call__Group__2__Impl rule__Call__Group__3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4006:2: rule__Call__Group__2__Impl rule__Call__Group__3
            {
            pushFollow(FOLLOW_rule__Call__Group__2__Impl_in_rule__Call__Group__28171);
            rule__Call__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group__3_in_rule__Call__Group__28174);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4013:1: rule__Call__Group__2__Impl : ( ( rule__Call__ParametersAssignment_2 )* ) ;
    public final void rule__Call__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4017:1: ( ( ( rule__Call__ParametersAssignment_2 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4018:1: ( ( rule__Call__ParametersAssignment_2 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4018:1: ( ( rule__Call__ParametersAssignment_2 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4019:1: ( rule__Call__ParametersAssignment_2 )*
            {
             before(grammarAccess.getCallAccess().getParametersAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4020:1: ( rule__Call__ParametersAssignment_2 )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==RULE_ID) ) {
                    int LA30_1 = input.LA(2);

                    if ( (LA30_1==39) ) {
                        alt30=1;
                    }


                }
                else if ( (LA30_0==40) ) {
                    int LA30_2 = input.LA(2);

                    if ( (LA30_2==RULE_ID) ) {
                        int LA30_5 = input.LA(3);

                        if ( (LA30_5==39) ) {
                            alt30=1;
                        }


                    }


                }


                switch (alt30) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4020:2: rule__Call__ParametersAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Call__ParametersAssignment_2_in_rule__Call__Group__2__Impl8201);
            	    rule__Call__ParametersAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

             after(grammarAccess.getCallAccess().getParametersAssignment_2()); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4030:1: rule__Call__Group__3 : rule__Call__Group__3__Impl rule__Call__Group__4 ;
    public final void rule__Call__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4034:1: ( rule__Call__Group__3__Impl rule__Call__Group__4 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4035:2: rule__Call__Group__3__Impl rule__Call__Group__4
            {
            pushFollow(FOLLOW_rule__Call__Group__3__Impl_in_rule__Call__Group__38232);
            rule__Call__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group__4_in_rule__Call__Group__38235);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4042:1: rule__Call__Group__3__Impl : ( ( rule__Call__ResultsAssignment_3 )* ) ;
    public final void rule__Call__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4046:1: ( ( ( rule__Call__ResultsAssignment_3 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4047:1: ( ( rule__Call__ResultsAssignment_3 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4047:1: ( ( rule__Call__ResultsAssignment_3 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4048:1: ( rule__Call__ResultsAssignment_3 )*
            {
             before(grammarAccess.getCallAccess().getResultsAssignment_3()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4049:1: ( rule__Call__ResultsAssignment_3 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_ID||LA31_0==40) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4049:2: rule__Call__ResultsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__Call__ResultsAssignment_3_in_rule__Call__Group__3__Impl8262);
            	    rule__Call__ResultsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

             after(grammarAccess.getCallAccess().getResultsAssignment_3()); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4059:1: rule__Call__Group__4 : rule__Call__Group__4__Impl ;
    public final void rule__Call__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4063:1: ( rule__Call__Group__4__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4064:2: rule__Call__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Call__Group__4__Impl_in_rule__Call__Group__48293);
            rule__Call__Group__4__Impl();

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4070:1: rule__Call__Group__4__Impl : ( ( rule__Call__Group_4__0 )? ) ;
    public final void rule__Call__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4074:1: ( ( ( rule__Call__Group_4__0 )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4075:1: ( ( rule__Call__Group_4__0 )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4075:1: ( ( rule__Call__Group_4__0 )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4076:1: ( rule__Call__Group_4__0 )?
            {
             before(grammarAccess.getCallAccess().getGroup_4()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4077:1: ( rule__Call__Group_4__0 )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==36) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4077:2: rule__Call__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Call__Group_4__0_in_rule__Call__Group__4__Impl8320);
                    rule__Call__Group_4__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCallAccess().getGroup_4()); 

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


    // $ANTLR start "rule__Call__Group_4__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4097:1: rule__Call__Group_4__0 : rule__Call__Group_4__0__Impl rule__Call__Group_4__1 ;
    public final void rule__Call__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4101:1: ( rule__Call__Group_4__0__Impl rule__Call__Group_4__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4102:2: rule__Call__Group_4__0__Impl rule__Call__Group_4__1
            {
            pushFollow(FOLLOW_rule__Call__Group_4__0__Impl_in_rule__Call__Group_4__08361);
            rule__Call__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group_4__1_in_rule__Call__Group_4__08364);
            rule__Call__Group_4__1();

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
    // $ANTLR end "rule__Call__Group_4__0"


    // $ANTLR start "rule__Call__Group_4__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4109:1: rule__Call__Group_4__0__Impl : ( '->' ) ;
    public final void rule__Call__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4113:1: ( ( '->' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4114:1: ( '->' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4114:1: ( '->' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4115:1: '->'
            {
             before(grammarAccess.getCallAccess().getHyphenMinusGreaterThanSignKeyword_4_0()); 
            match(input,36,FOLLOW_36_in_rule__Call__Group_4__0__Impl8392); 
             after(grammarAccess.getCallAccess().getHyphenMinusGreaterThanSignKeyword_4_0()); 

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
    // $ANTLR end "rule__Call__Group_4__0__Impl"


    // $ANTLR start "rule__Call__Group_4__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4128:1: rule__Call__Group_4__1 : rule__Call__Group_4__1__Impl ;
    public final void rule__Call__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4132:1: ( rule__Call__Group_4__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4133:2: rule__Call__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Call__Group_4__1__Impl_in_rule__Call__Group_4__18423);
            rule__Call__Group_4__1__Impl();

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
    // $ANTLR end "rule__Call__Group_4__1"


    // $ANTLR start "rule__Call__Group_4__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4139:1: rule__Call__Group_4__1__Impl : ( ( rule__Call__ResultAssignment_4_1 ) ) ;
    public final void rule__Call__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4143:1: ( ( ( rule__Call__ResultAssignment_4_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4144:1: ( ( rule__Call__ResultAssignment_4_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4144:1: ( ( rule__Call__ResultAssignment_4_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4145:1: ( rule__Call__ResultAssignment_4_1 )
            {
             before(grammarAccess.getCallAccess().getResultAssignment_4_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4146:1: ( rule__Call__ResultAssignment_4_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4146:2: rule__Call__ResultAssignment_4_1
            {
            pushFollow(FOLLOW_rule__Call__ResultAssignment_4_1_in_rule__Call__Group_4__1__Impl8450);
            rule__Call__ResultAssignment_4_1();

            state._fsp--;


            }

             after(grammarAccess.getCallAccess().getResultAssignment_4_1()); 

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
    // $ANTLR end "rule__Call__Group_4__1__Impl"


    // $ANTLR start "rule__NamedCallResult__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4160:1: rule__NamedCallResult__Group__0 : rule__NamedCallResult__Group__0__Impl rule__NamedCallResult__Group__1 ;
    public final void rule__NamedCallResult__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4164:1: ( rule__NamedCallResult__Group__0__Impl rule__NamedCallResult__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4165:2: rule__NamedCallResult__Group__0__Impl rule__NamedCallResult__Group__1
            {
            pushFollow(FOLLOW_rule__NamedCallResult__Group__0__Impl_in_rule__NamedCallResult__Group__08484);
            rule__NamedCallResult__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NamedCallResult__Group__1_in_rule__NamedCallResult__Group__08487);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4172:1: rule__NamedCallResult__Group__0__Impl : ( ( rule__NamedCallResult__NameAssignment_0 ) ) ;
    public final void rule__NamedCallResult__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4176:1: ( ( ( rule__NamedCallResult__NameAssignment_0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4177:1: ( ( rule__NamedCallResult__NameAssignment_0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4177:1: ( ( rule__NamedCallResult__NameAssignment_0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4178:1: ( rule__NamedCallResult__NameAssignment_0 )
            {
             before(grammarAccess.getNamedCallResultAccess().getNameAssignment_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4179:1: ( rule__NamedCallResult__NameAssignment_0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4179:2: rule__NamedCallResult__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__NamedCallResult__NameAssignment_0_in_rule__NamedCallResult__Group__0__Impl8514);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4189:1: rule__NamedCallResult__Group__1 : rule__NamedCallResult__Group__1__Impl rule__NamedCallResult__Group__2 ;
    public final void rule__NamedCallResult__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4193:1: ( rule__NamedCallResult__Group__1__Impl rule__NamedCallResult__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4194:2: rule__NamedCallResult__Group__1__Impl rule__NamedCallResult__Group__2
            {
            pushFollow(FOLLOW_rule__NamedCallResult__Group__1__Impl_in_rule__NamedCallResult__Group__18544);
            rule__NamedCallResult__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NamedCallResult__Group__2_in_rule__NamedCallResult__Group__18547);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4201:1: rule__NamedCallResult__Group__1__Impl : ( '->' ) ;
    public final void rule__NamedCallResult__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4205:1: ( ( '->' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4206:1: ( '->' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4206:1: ( '->' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4207:1: '->'
            {
             before(grammarAccess.getNamedCallResultAccess().getHyphenMinusGreaterThanSignKeyword_1()); 
            match(input,36,FOLLOW_36_in_rule__NamedCallResult__Group__1__Impl8575); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4220:1: rule__NamedCallResult__Group__2 : rule__NamedCallResult__Group__2__Impl ;
    public final void rule__NamedCallResult__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4224:1: ( rule__NamedCallResult__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4225:2: rule__NamedCallResult__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__NamedCallResult__Group__2__Impl_in_rule__NamedCallResult__Group__28606);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4231:1: rule__NamedCallResult__Group__2__Impl : ( ( rule__NamedCallResult__TargetAssignment_2 ) ) ;
    public final void rule__NamedCallResult__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4235:1: ( ( ( rule__NamedCallResult__TargetAssignment_2 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4236:1: ( ( rule__NamedCallResult__TargetAssignment_2 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4236:1: ( ( rule__NamedCallResult__TargetAssignment_2 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4237:1: ( rule__NamedCallResult__TargetAssignment_2 )
            {
             before(grammarAccess.getNamedCallResultAccess().getTargetAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4238:1: ( rule__NamedCallResult__TargetAssignment_2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4238:2: rule__NamedCallResult__TargetAssignment_2
            {
            pushFollow(FOLLOW_rule__NamedCallResult__TargetAssignment_2_in_rule__NamedCallResult__Group__2__Impl8633);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4254:1: rule__Suite__Group__0 : rule__Suite__Group__0__Impl rule__Suite__Group__1 ;
    public final void rule__Suite__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4258:1: ( rule__Suite__Group__0__Impl rule__Suite__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4259:2: rule__Suite__Group__0__Impl rule__Suite__Group__1
            {
            pushFollow(FOLLOW_rule__Suite__Group__0__Impl_in_rule__Suite__Group__08669);
            rule__Suite__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Suite__Group__1_in_rule__Suite__Group__08672);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4266:1: rule__Suite__Group__0__Impl : ( 'suite' ) ;
    public final void rule__Suite__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4270:1: ( ( 'suite' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4271:1: ( 'suite' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4271:1: ( 'suite' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4272:1: 'suite'
            {
             before(grammarAccess.getSuiteAccess().getSuiteKeyword_0()); 
            match(input,37,FOLLOW_37_in_rule__Suite__Group__0__Impl8700); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4285:1: rule__Suite__Group__1 : rule__Suite__Group__1__Impl rule__Suite__Group__2 ;
    public final void rule__Suite__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4289:1: ( rule__Suite__Group__1__Impl rule__Suite__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4290:2: rule__Suite__Group__1__Impl rule__Suite__Group__2
            {
            pushFollow(FOLLOW_rule__Suite__Group__1__Impl_in_rule__Suite__Group__18731);
            rule__Suite__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Suite__Group__2_in_rule__Suite__Group__18734);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4297:1: rule__Suite__Group__1__Impl : ( ( rule__Suite__DefinitionAssignment_1 ) ) ;
    public final void rule__Suite__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4301:1: ( ( ( rule__Suite__DefinitionAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4302:1: ( ( rule__Suite__DefinitionAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4302:1: ( ( rule__Suite__DefinitionAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4303:1: ( rule__Suite__DefinitionAssignment_1 )
            {
             before(grammarAccess.getSuiteAccess().getDefinitionAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4304:1: ( rule__Suite__DefinitionAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4304:2: rule__Suite__DefinitionAssignment_1
            {
            pushFollow(FOLLOW_rule__Suite__DefinitionAssignment_1_in_rule__Suite__Group__1__Impl8761);
            rule__Suite__DefinitionAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getSuiteAccess().getDefinitionAssignment_1()); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4314:1: rule__Suite__Group__2 : rule__Suite__Group__2__Impl rule__Suite__Group__3 ;
    public final void rule__Suite__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4318:1: ( rule__Suite__Group__2__Impl rule__Suite__Group__3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4319:2: rule__Suite__Group__2__Impl rule__Suite__Group__3
            {
            pushFollow(FOLLOW_rule__Suite__Group__2__Impl_in_rule__Suite__Group__28791);
            rule__Suite__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Suite__Group__3_in_rule__Suite__Group__28794);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4326:1: rule__Suite__Group__2__Impl : ( ( rule__Suite__ParametersAssignment_2 )* ) ;
    public final void rule__Suite__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4330:1: ( ( ( rule__Suite__ParametersAssignment_2 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4331:1: ( ( rule__Suite__ParametersAssignment_2 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4331:1: ( ( rule__Suite__ParametersAssignment_2 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4332:1: ( rule__Suite__ParametersAssignment_2 )*
            {
             before(grammarAccess.getSuiteAccess().getParametersAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4333:1: ( rule__Suite__ParametersAssignment_2 )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_ID) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4333:2: rule__Suite__ParametersAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Suite__ParametersAssignment_2_in_rule__Suite__Group__2__Impl8821);
            	    rule__Suite__ParametersAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);

             after(grammarAccess.getSuiteAccess().getParametersAssignment_2()); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4343:1: rule__Suite__Group__3 : rule__Suite__Group__3__Impl ;
    public final void rule__Suite__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4347:1: ( rule__Suite__Group__3__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4348:2: rule__Suite__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Suite__Group__3__Impl_in_rule__Suite__Group__38852);
            rule__Suite__Group__3__Impl();

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4354:1: rule__Suite__Group__3__Impl : ( ( rule__Suite__Group_3__0 )? ) ;
    public final void rule__Suite__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4358:1: ( ( ( rule__Suite__Group_3__0 )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4359:1: ( ( rule__Suite__Group_3__0 )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4359:1: ( ( rule__Suite__Group_3__0 )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4360:1: ( rule__Suite__Group_3__0 )?
            {
             before(grammarAccess.getSuiteAccess().getGroup_3()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4361:1: ( rule__Suite__Group_3__0 )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==38) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4361:2: rule__Suite__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Suite__Group_3__0_in_rule__Suite__Group__3__Impl8879);
                    rule__Suite__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSuiteAccess().getGroup_3()); 

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


    // $ANTLR start "rule__Suite__Group_3__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4379:1: rule__Suite__Group_3__0 : rule__Suite__Group_3__0__Impl rule__Suite__Group_3__1 ;
    public final void rule__Suite__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4383:1: ( rule__Suite__Group_3__0__Impl rule__Suite__Group_3__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4384:2: rule__Suite__Group_3__0__Impl rule__Suite__Group_3__1
            {
            pushFollow(FOLLOW_rule__Suite__Group_3__0__Impl_in_rule__Suite__Group_3__08918);
            rule__Suite__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Suite__Group_3__1_in_rule__Suite__Group_3__08921);
            rule__Suite__Group_3__1();

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
    // $ANTLR end "rule__Suite__Group_3__0"


    // $ANTLR start "rule__Suite__Group_3__0__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4391:1: rule__Suite__Group_3__0__Impl : ( 'on' ) ;
    public final void rule__Suite__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4395:1: ( ( 'on' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4396:1: ( 'on' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4396:1: ( 'on' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4397:1: 'on'
            {
             before(grammarAccess.getSuiteAccess().getOnKeyword_3_0()); 
            match(input,38,FOLLOW_38_in_rule__Suite__Group_3__0__Impl8949); 
             after(grammarAccess.getSuiteAccess().getOnKeyword_3_0()); 

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
    // $ANTLR end "rule__Suite__Group_3__0__Impl"


    // $ANTLR start "rule__Suite__Group_3__1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4410:1: rule__Suite__Group_3__1 : rule__Suite__Group_3__1__Impl ;
    public final void rule__Suite__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4414:1: ( rule__Suite__Group_3__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4415:2: rule__Suite__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Suite__Group_3__1__Impl_in_rule__Suite__Group_3__18980);
            rule__Suite__Group_3__1__Impl();

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
    // $ANTLR end "rule__Suite__Group_3__1"


    // $ANTLR start "rule__Suite__Group_3__1__Impl"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4421:1: rule__Suite__Group_3__1__Impl : ( ( rule__Suite__ForkAssignment_3_1 ) ) ;
    public final void rule__Suite__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4425:1: ( ( ( rule__Suite__ForkAssignment_3_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4426:1: ( ( rule__Suite__ForkAssignment_3_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4426:1: ( ( rule__Suite__ForkAssignment_3_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4427:1: ( rule__Suite__ForkAssignment_3_1 )
            {
             before(grammarAccess.getSuiteAccess().getForkAssignment_3_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4428:1: ( rule__Suite__ForkAssignment_3_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4428:2: rule__Suite__ForkAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Suite__ForkAssignment_3_1_in_rule__Suite__Group_3__1__Impl9007);
            rule__Suite__ForkAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getSuiteAccess().getForkAssignment_3_1()); 

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
    // $ANTLR end "rule__Suite__Group_3__1__Impl"


    // $ANTLR start "rule__SuiteParameter__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4442:1: rule__SuiteParameter__Group__0 : rule__SuiteParameter__Group__0__Impl rule__SuiteParameter__Group__1 ;
    public final void rule__SuiteParameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4446:1: ( rule__SuiteParameter__Group__0__Impl rule__SuiteParameter__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4447:2: rule__SuiteParameter__Group__0__Impl rule__SuiteParameter__Group__1
            {
            pushFollow(FOLLOW_rule__SuiteParameter__Group__0__Impl_in_rule__SuiteParameter__Group__09041);
            rule__SuiteParameter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteParameter__Group__1_in_rule__SuiteParameter__Group__09044);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4454:1: rule__SuiteParameter__Group__0__Impl : ( ( rule__SuiteParameter__NameAssignment_0 ) ) ;
    public final void rule__SuiteParameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4458:1: ( ( ( rule__SuiteParameter__NameAssignment_0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4459:1: ( ( rule__SuiteParameter__NameAssignment_0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4459:1: ( ( rule__SuiteParameter__NameAssignment_0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4460:1: ( rule__SuiteParameter__NameAssignment_0 )
            {
             before(grammarAccess.getSuiteParameterAccess().getNameAssignment_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4461:1: ( rule__SuiteParameter__NameAssignment_0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4461:2: rule__SuiteParameter__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__SuiteParameter__NameAssignment_0_in_rule__SuiteParameter__Group__0__Impl9071);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4471:1: rule__SuiteParameter__Group__1 : rule__SuiteParameter__Group__1__Impl rule__SuiteParameter__Group__2 ;
    public final void rule__SuiteParameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4475:1: ( rule__SuiteParameter__Group__1__Impl rule__SuiteParameter__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4476:2: rule__SuiteParameter__Group__1__Impl rule__SuiteParameter__Group__2
            {
            pushFollow(FOLLOW_rule__SuiteParameter__Group__1__Impl_in_rule__SuiteParameter__Group__19101);
            rule__SuiteParameter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteParameter__Group__2_in_rule__SuiteParameter__Group__19104);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4483:1: rule__SuiteParameter__Group__1__Impl : ( ':' ) ;
    public final void rule__SuiteParameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4487:1: ( ( ':' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4488:1: ( ':' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4488:1: ( ':' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4489:1: ':'
            {
             before(grammarAccess.getSuiteParameterAccess().getColonKeyword_1()); 
            match(input,39,FOLLOW_39_in_rule__SuiteParameter__Group__1__Impl9132); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4502:1: rule__SuiteParameter__Group__2 : rule__SuiteParameter__Group__2__Impl ;
    public final void rule__SuiteParameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4506:1: ( rule__SuiteParameter__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4507:2: rule__SuiteParameter__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__SuiteParameter__Group__2__Impl_in_rule__SuiteParameter__Group__29163);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4513:1: rule__SuiteParameter__Group__2__Impl : ( ( rule__SuiteParameter__ValueAssignment_2 ) ) ;
    public final void rule__SuiteParameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4517:1: ( ( ( rule__SuiteParameter__ValueAssignment_2 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4518:1: ( ( rule__SuiteParameter__ValueAssignment_2 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4518:1: ( ( rule__SuiteParameter__ValueAssignment_2 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4519:1: ( rule__SuiteParameter__ValueAssignment_2 )
            {
             before(grammarAccess.getSuiteParameterAccess().getValueAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4520:1: ( rule__SuiteParameter__ValueAssignment_2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4520:2: rule__SuiteParameter__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__SuiteParameter__ValueAssignment_2_in_rule__SuiteParameter__Group__2__Impl9190);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4536:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4540:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4541:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
            {
            pushFollow(FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__09226);
            rule__Parameter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__09229);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4548:1: rule__Parameter__Group__0__Impl : ( ( rule__Parameter__NameAssignment_0 ) ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4552:1: ( ( ( rule__Parameter__NameAssignment_0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4553:1: ( ( rule__Parameter__NameAssignment_0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4553:1: ( ( rule__Parameter__NameAssignment_0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4554:1: ( rule__Parameter__NameAssignment_0 )
            {
             before(grammarAccess.getParameterAccess().getNameAssignment_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4555:1: ( rule__Parameter__NameAssignment_0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4555:2: rule__Parameter__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Parameter__NameAssignment_0_in_rule__Parameter__Group__0__Impl9256);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4565:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl rule__Parameter__Group__2 ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4569:1: ( rule__Parameter__Group__1__Impl rule__Parameter__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4570:2: rule__Parameter__Group__1__Impl rule__Parameter__Group__2
            {
            pushFollow(FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__19286);
            rule__Parameter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Parameter__Group__2_in_rule__Parameter__Group__19289);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4577:1: rule__Parameter__Group__1__Impl : ( ':' ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4581:1: ( ( ':' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4582:1: ( ':' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4582:1: ( ':' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4583:1: ':'
            {
             before(grammarAccess.getParameterAccess().getColonKeyword_1()); 
            match(input,39,FOLLOW_39_in_rule__Parameter__Group__1__Impl9317); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4596:1: rule__Parameter__Group__2 : rule__Parameter__Group__2__Impl ;
    public final void rule__Parameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4600:1: ( rule__Parameter__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4601:2: rule__Parameter__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Parameter__Group__2__Impl_in_rule__Parameter__Group__29348);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4607:1: rule__Parameter__Group__2__Impl : ( ( rule__Parameter__ValueAssignment_2 ) ) ;
    public final void rule__Parameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4611:1: ( ( ( rule__Parameter__ValueAssignment_2 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4612:1: ( ( rule__Parameter__ValueAssignment_2 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4612:1: ( ( rule__Parameter__ValueAssignment_2 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4613:1: ( rule__Parameter__ValueAssignment_2 )
            {
             before(grammarAccess.getParameterAccess().getValueAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4614:1: ( rule__Parameter__ValueAssignment_2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4614:2: rule__Parameter__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__Parameter__ValueAssignment_2_in_rule__Parameter__Group__2__Impl9375);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4630:1: rule__ArbitraryParameterOrResultName__Group__0 : rule__ArbitraryParameterOrResultName__Group__0__Impl rule__ArbitraryParameterOrResultName__Group__1 ;
    public final void rule__ArbitraryParameterOrResultName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4634:1: ( rule__ArbitraryParameterOrResultName__Group__0__Impl rule__ArbitraryParameterOrResultName__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4635:2: rule__ArbitraryParameterOrResultName__Group__0__Impl rule__ArbitraryParameterOrResultName__Group__1
            {
            pushFollow(FOLLOW_rule__ArbitraryParameterOrResultName__Group__0__Impl_in_rule__ArbitraryParameterOrResultName__Group__09411);
            rule__ArbitraryParameterOrResultName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ArbitraryParameterOrResultName__Group__1_in_rule__ArbitraryParameterOrResultName__Group__09414);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4642:1: rule__ArbitraryParameterOrResultName__Group__0__Impl : ( '+' ) ;
    public final void rule__ArbitraryParameterOrResultName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4646:1: ( ( '+' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4647:1: ( '+' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4647:1: ( '+' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4648:1: '+'
            {
             before(grammarAccess.getArbitraryParameterOrResultNameAccess().getPlusSignKeyword_0()); 
            match(input,40,FOLLOW_40_in_rule__ArbitraryParameterOrResultName__Group__0__Impl9442); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4661:1: rule__ArbitraryParameterOrResultName__Group__1 : rule__ArbitraryParameterOrResultName__Group__1__Impl ;
    public final void rule__ArbitraryParameterOrResultName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4665:1: ( rule__ArbitraryParameterOrResultName__Group__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4666:2: rule__ArbitraryParameterOrResultName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ArbitraryParameterOrResultName__Group__1__Impl_in_rule__ArbitraryParameterOrResultName__Group__19473);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4672:1: rule__ArbitraryParameterOrResultName__Group__1__Impl : ( ( rule__ArbitraryParameterOrResultName__IdentifierAssignment_1 ) ) ;
    public final void rule__ArbitraryParameterOrResultName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4676:1: ( ( ( rule__ArbitraryParameterOrResultName__IdentifierAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4677:1: ( ( rule__ArbitraryParameterOrResultName__IdentifierAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4677:1: ( ( rule__ArbitraryParameterOrResultName__IdentifierAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4678:1: ( rule__ArbitraryParameterOrResultName__IdentifierAssignment_1 )
            {
             before(grammarAccess.getArbitraryParameterOrResultNameAccess().getIdentifierAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4679:1: ( rule__ArbitraryParameterOrResultName__IdentifierAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4679:2: rule__ArbitraryParameterOrResultName__IdentifierAssignment_1
            {
            pushFollow(FOLLOW_rule__ArbitraryParameterOrResultName__IdentifierAssignment_1_in_rule__ArbitraryParameterOrResultName__Group__1__Impl9500);
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


    // $ANTLR start "rule__MethodReference__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4693:1: rule__MethodReference__Group__0 : rule__MethodReference__Group__0__Impl rule__MethodReference__Group__1 ;
    public final void rule__MethodReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4697:1: ( rule__MethodReference__Group__0__Impl rule__MethodReference__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4698:2: rule__MethodReference__Group__0__Impl rule__MethodReference__Group__1
            {
            pushFollow(FOLLOW_rule__MethodReference__Group__0__Impl_in_rule__MethodReference__Group__09534);
            rule__MethodReference__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodReference__Group__1_in_rule__MethodReference__Group__09537);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4705:1: rule__MethodReference__Group__0__Impl : ( ( rule__MethodReference__TypeAssignment_0 ) ) ;
    public final void rule__MethodReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4709:1: ( ( ( rule__MethodReference__TypeAssignment_0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4710:1: ( ( rule__MethodReference__TypeAssignment_0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4710:1: ( ( rule__MethodReference__TypeAssignment_0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4711:1: ( rule__MethodReference__TypeAssignment_0 )
            {
             before(grammarAccess.getMethodReferenceAccess().getTypeAssignment_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4712:1: ( rule__MethodReference__TypeAssignment_0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4712:2: rule__MethodReference__TypeAssignment_0
            {
            pushFollow(FOLLOW_rule__MethodReference__TypeAssignment_0_in_rule__MethodReference__Group__0__Impl9564);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4722:1: rule__MethodReference__Group__1 : rule__MethodReference__Group__1__Impl rule__MethodReference__Group__2 ;
    public final void rule__MethodReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4726:1: ( rule__MethodReference__Group__1__Impl rule__MethodReference__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4727:2: rule__MethodReference__Group__1__Impl rule__MethodReference__Group__2
            {
            pushFollow(FOLLOW_rule__MethodReference__Group__1__Impl_in_rule__MethodReference__Group__19594);
            rule__MethodReference__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodReference__Group__2_in_rule__MethodReference__Group__19597);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4734:1: rule__MethodReference__Group__1__Impl : ( '#' ) ;
    public final void rule__MethodReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4738:1: ( ( '#' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4739:1: ( '#' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4739:1: ( '#' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4740:1: '#'
            {
             before(grammarAccess.getMethodReferenceAccess().getNumberSignKeyword_1()); 
            match(input,41,FOLLOW_41_in_rule__MethodReference__Group__1__Impl9625); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4753:1: rule__MethodReference__Group__2 : rule__MethodReference__Group__2__Impl ;
    public final void rule__MethodReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4757:1: ( rule__MethodReference__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4758:2: rule__MethodReference__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__MethodReference__Group__2__Impl_in_rule__MethodReference__Group__29656);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4764:1: rule__MethodReference__Group__2__Impl : ( ( rule__MethodReference__MethodAssignment_2 ) ) ;
    public final void rule__MethodReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4768:1: ( ( ( rule__MethodReference__MethodAssignment_2 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4769:1: ( ( rule__MethodReference__MethodAssignment_2 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4769:1: ( ( rule__MethodReference__MethodAssignment_2 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4770:1: ( rule__MethodReference__MethodAssignment_2 )
            {
             before(grammarAccess.getMethodReferenceAccess().getMethodAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4771:1: ( rule__MethodReference__MethodAssignment_2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4771:2: rule__MethodReference__MethodAssignment_2
            {
            pushFollow(FOLLOW_rule__MethodReference__MethodAssignment_2_in_rule__MethodReference__Group__2__Impl9683);
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


    // $ANTLR start "rule__QualifiedName__Group__0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4787:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4791:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4792:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__09719);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__09722);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4799:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4803:1: ( ( RULE_ID ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4804:1: ( RULE_ID )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4804:1: ( RULE_ID )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4805:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl9749); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4816:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4820:1: ( rule__QualifiedName__Group__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4821:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__19778);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4827:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4831:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4832:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4832:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4833:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4834:1: ( rule__QualifiedName__Group_1__0 )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==42) ) {
                    int LA35_2 = input.LA(2);

                    if ( (LA35_2==RULE_ID) ) {
                        alt35=1;
                    }


                }


                switch (alt35) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4834:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl9805);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop35;
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4848:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4852:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4853:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__09840);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__09843);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4860:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4864:1: ( ( '.' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4865:1: ( '.' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4865:1: ( '.' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4866:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,42,FOLLOW_42_in_rule__QualifiedName__Group_1__0__Impl9871); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4879:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4883:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4884:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__19902);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4890:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4894:1: ( ( RULE_ID ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4895:1: ( RULE_ID )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4895:1: ( RULE_ID )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4896:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl9929); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4911:1: rule__QualifiedJavaClassName__Group__0 : rule__QualifiedJavaClassName__Group__0__Impl rule__QualifiedJavaClassName__Group__1 ;
    public final void rule__QualifiedJavaClassName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4915:1: ( rule__QualifiedJavaClassName__Group__0__Impl rule__QualifiedJavaClassName__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4916:2: rule__QualifiedJavaClassName__Group__0__Impl rule__QualifiedJavaClassName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__0__Impl_in_rule__QualifiedJavaClassName__Group__09962);
            rule__QualifiedJavaClassName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__1_in_rule__QualifiedJavaClassName__Group__09965);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4923:1: rule__QualifiedJavaClassName__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedJavaClassName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4927:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4928:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4928:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4929:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedJavaClassNameAccess().getQualifiedNameParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedJavaClassName__Group__0__Impl9992);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4940:1: rule__QualifiedJavaClassName__Group__1 : rule__QualifiedJavaClassName__Group__1__Impl rule__QualifiedJavaClassName__Group__2 ;
    public final void rule__QualifiedJavaClassName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4944:1: ( rule__QualifiedJavaClassName__Group__1__Impl rule__QualifiedJavaClassName__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4945:2: rule__QualifiedJavaClassName__Group__1__Impl rule__QualifiedJavaClassName__Group__2
            {
            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__1__Impl_in_rule__QualifiedJavaClassName__Group__110021);
            rule__QualifiedJavaClassName__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__2_in_rule__QualifiedJavaClassName__Group__110024);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4952:1: rule__QualifiedJavaClassName__Group__1__Impl : ( '.' ) ;
    public final void rule__QualifiedJavaClassName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4956:1: ( ( '.' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4957:1: ( '.' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4957:1: ( '.' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4958:1: '.'
            {
             before(grammarAccess.getQualifiedJavaClassNameAccess().getFullStopKeyword_1()); 
            match(input,42,FOLLOW_42_in_rule__QualifiedJavaClassName__Group__1__Impl10052); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4971:1: rule__QualifiedJavaClassName__Group__2 : rule__QualifiedJavaClassName__Group__2__Impl ;
    public final void rule__QualifiedJavaClassName__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4975:1: ( rule__QualifiedJavaClassName__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4976:2: rule__QualifiedJavaClassName__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__2__Impl_in_rule__QualifiedJavaClassName__Group__210083);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4982:1: rule__QualifiedJavaClassName__Group__2__Impl : ( RULE_UPPERCASE_ID ) ;
    public final void rule__QualifiedJavaClassName__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4986:1: ( ( RULE_UPPERCASE_ID ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4987:1: ( RULE_UPPERCASE_ID )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4987:1: ( RULE_UPPERCASE_ID )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4988:1: RULE_UPPERCASE_ID
            {
             before(grammarAccess.getQualifiedJavaClassNameAccess().getUPPERCASE_IDTerminalRuleCall_2()); 
            match(input,RULE_UPPERCASE_ID,FOLLOW_RULE_UPPERCASE_ID_in_rule__QualifiedJavaClassName__Group__2__Impl10110); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5005:1: rule__QualifiedNameWithWildcard__Group__0 : rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 ;
    public final void rule__QualifiedNameWithWildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5009:1: ( rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5010:2: rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__0__Impl_in_rule__QualifiedNameWithWildcard__Group__010145);
            rule__QualifiedNameWithWildcard__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__1_in_rule__QualifiedNameWithWildcard__Group__010148);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5017:1: rule__QualifiedNameWithWildcard__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedNameWithWildcard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5021:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5022:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5022:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5023:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildcard__Group__0__Impl10175);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5034:1: rule__QualifiedNameWithWildcard__Group__1 : rule__QualifiedNameWithWildcard__Group__1__Impl ;
    public final void rule__QualifiedNameWithWildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5038:1: ( rule__QualifiedNameWithWildcard__Group__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5039:2: rule__QualifiedNameWithWildcard__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__1__Impl_in_rule__QualifiedNameWithWildcard__Group__110204);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5045:1: rule__QualifiedNameWithWildcard__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__QualifiedNameWithWildcard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5049:1: ( ( ( '.*' )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5050:1: ( ( '.*' )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5050:1: ( ( '.*' )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5051:1: ( '.*' )?
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5052:1: ( '.*' )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==43) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5053:2: '.*'
                    {
                    match(input,43,FOLLOW_43_in_rule__QualifiedNameWithWildcard__Group__1__Impl10233); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5069:1: rule__Model__StatementsAssignment : ( ruleStatement ) ;
    public final void rule__Model__StatementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5073:1: ( ( ruleStatement ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5074:1: ( ruleStatement )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5074:1: ( ruleStatement )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5075:1: ruleStatement
            {
             before(grammarAccess.getModelAccess().getStatementsStatementParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleStatement_in_rule__Model__StatementsAssignment10275);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5084:1: rule__VisibleSingleLineComment__ContentAssignment : ( RULE_SL_VISIBLE_COMMENT ) ;
    public final void rule__VisibleSingleLineComment__ContentAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5088:1: ( ( RULE_SL_VISIBLE_COMMENT ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5089:1: ( RULE_SL_VISIBLE_COMMENT )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5089:1: ( RULE_SL_VISIBLE_COMMENT )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5090:1: RULE_SL_VISIBLE_COMMENT
            {
             before(grammarAccess.getVisibleSingleLineCommentAccess().getContentSL_VISIBLE_COMMENTTerminalRuleCall_0()); 
            match(input,RULE_SL_VISIBLE_COMMENT,FOLLOW_RULE_SL_VISIBLE_COMMENT_in_rule__VisibleSingleLineComment__ContentAssignment10306); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5099:1: rule__VisibleMultiLineComment__ContentAssignment : ( RULE_ML_VISIBLE_COMMENT ) ;
    public final void rule__VisibleMultiLineComment__ContentAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5103:1: ( ( RULE_ML_VISIBLE_COMMENT ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5104:1: ( RULE_ML_VISIBLE_COMMENT )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5104:1: ( RULE_ML_VISIBLE_COMMENT )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5105:1: RULE_ML_VISIBLE_COMMENT
            {
             before(grammarAccess.getVisibleMultiLineCommentAccess().getContentML_VISIBLE_COMMENTTerminalRuleCall_0()); 
            match(input,RULE_ML_VISIBLE_COMMENT,FOLLOW_RULE_ML_VISIBLE_COMMENT_in_rule__VisibleMultiLineComment__ContentAssignment10337); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5114:1: rule__PackageDefinition__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__PackageDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5118:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5119:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5119:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5120:1: ruleQualifiedName
            {
             before(grammarAccess.getPackageDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__PackageDefinition__NameAssignment_110368);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5129:1: rule__PackageDefinition__StatementsAssignment_3 : ( rulePackageStatement ) ;
    public final void rule__PackageDefinition__StatementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5133:1: ( ( rulePackageStatement ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5134:1: ( rulePackageStatement )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5134:1: ( rulePackageStatement )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5135:1: rulePackageStatement
            {
             before(grammarAccess.getPackageDefinitionAccess().getStatementsPackageStatementParserRuleCall_3_0()); 
            pushFollow(FOLLOW_rulePackageStatement_in_rule__PackageDefinition__StatementsAssignment_310399);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5144:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleQualifiedNameWithWildcard ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5148:1: ( ( ruleQualifiedNameWithWildcard ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5149:1: ( ruleQualifiedNameWithWildcard )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5149:1: ( ruleQualifiedNameWithWildcard )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5150:1: ruleQualifiedNameWithWildcard
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_rule__Import__ImportedNamespaceAssignment_110430);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5159:1: rule__ForkDefinition__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__ForkDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5163:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5164:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5164:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5165:1: ruleQualifiedName
            {
             before(grammarAccess.getForkDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__ForkDefinition__NameAssignment_110461);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5174:1: rule__ForkDefinition__DescriptionAssignment_2 : ( RULE_STRING ) ;
    public final void rule__ForkDefinition__DescriptionAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5178:1: ( ( RULE_STRING ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5179:1: ( RULE_STRING )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5179:1: ( RULE_STRING )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5180:1: RULE_STRING
            {
             before(grammarAccess.getForkDefinitionAccess().getDescriptionSTRINGTerminalRuleCall_2_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__ForkDefinition__DescriptionAssignment_210492); 
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


    // $ANTLR start "rule__TestDefinition__NameAssignment_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5189:1: rule__TestDefinition__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__TestDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5193:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5194:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5194:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5195:1: ruleQualifiedName
            {
             before(grammarAccess.getTestDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__TestDefinition__NameAssignment_110523);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5204:1: rule__TestDefinition__FixtureMethodAssignment_3 : ( ruleMethodReference ) ;
    public final void rule__TestDefinition__FixtureMethodAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5208:1: ( ( ruleMethodReference ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5209:1: ( ruleMethodReference )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5209:1: ( ruleMethodReference )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5210:1: ruleMethodReference
            {
             before(grammarAccess.getTestDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleMethodReference_in_rule__TestDefinition__FixtureMethodAssignment_310554);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5219:1: rule__CallDefinition__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__CallDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5223:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5224:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5224:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5225:1: ruleQualifiedName
            {
             before(grammarAccess.getCallDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__CallDefinition__NameAssignment_110585);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5234:1: rule__CallDefinition__FixtureMethodAssignment_3 : ( ruleMethodReference ) ;
    public final void rule__CallDefinition__FixtureMethodAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5238:1: ( ( ruleMethodReference ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5239:1: ( ruleMethodReference )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5239:1: ( ruleMethodReference )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5240:1: ruleMethodReference
            {
             before(grammarAccess.getCallDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleMethodReference_in_rule__CallDefinition__FixtureMethodAssignment_310616);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5249:1: rule__SuiteDefinition__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__SuiteDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5253:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5254:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5254:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5255:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__NameAssignment_110647);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5264:1: rule__SuiteDefinition__ParametersAssignment_2_1 : ( ruleVariableEntity ) ;
    public final void rule__SuiteDefinition__ParametersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5268:1: ( ( ruleVariableEntity ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5269:1: ( ruleVariableEntity )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5269:1: ( ruleVariableEntity )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5270:1: ruleVariableEntity
            {
             before(grammarAccess.getSuiteDefinitionAccess().getParametersVariableEntityParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleVariableEntity_in_rule__SuiteDefinition__ParametersAssignment_2_110678);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5279:1: rule__SuiteDefinition__DependenciesAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__SuiteDefinition__DependenciesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5283:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5284:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5284:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5285:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSuiteDefinitionAccess().getDependenciesSuiteDefinitionCrossReference_3_1_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5286:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5287:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteDefinitionAccess().getDependenciesSuiteDefinitionQualifiedNameParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__DependenciesAssignment_3_110713);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5298:1: rule__SuiteDefinition__StatementsAssignment_5 : ( ruleSuiteStatement ) ;
    public final void rule__SuiteDefinition__StatementsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5302:1: ( ( ruleSuiteStatement ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5303:1: ( ruleSuiteStatement )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5303:1: ( ruleSuiteStatement )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5304:1: ruleSuiteStatement
            {
             before(grammarAccess.getSuiteDefinitionAccess().getStatementsSuiteStatementParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleSuiteStatement_in_rule__SuiteDefinition__StatementsAssignment_510748);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5313:1: rule__SuiteDefinition__FinalizersAssignment_7_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__SuiteDefinition__FinalizersAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5317:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5318:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5318:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5319:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSuiteDefinitionAccess().getFinalizersSuiteDefinitionCrossReference_7_1_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5320:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5321:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteDefinitionAccess().getFinalizersSuiteDefinitionQualifiedNameParserRuleCall_7_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__FinalizersAssignment_7_110783);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5332:1: rule__VariableDefinition__NameAssignment_1 : ( ruleVariableEntity ) ;
    public final void rule__VariableDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5336:1: ( ( ruleVariableEntity ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5337:1: ( ruleVariableEntity )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5337:1: ( ruleVariableEntity )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5338:1: ruleVariableEntity
            {
             before(grammarAccess.getVariableDefinitionAccess().getNameVariableEntityParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleVariableEntity_in_rule__VariableDefinition__NameAssignment_110818);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5347:1: rule__VariableDefinition__InitialValueAssignment_2_1 : ( ruleValue ) ;
    public final void rule__VariableDefinition__InitialValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5351:1: ( ( ruleValue ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5352:1: ( ruleValue )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5352:1: ( ruleValue )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5353:1: ruleValue
            {
             before(grammarAccess.getVariableDefinitionAccess().getInitialValueValueParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleValue_in_rule__VariableDefinition__InitialValueAssignment_2_110849);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5362:1: rule__ConstantDefinition__NameAssignment_1 : ( ruleVariableEntity ) ;
    public final void rule__ConstantDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5366:1: ( ( ruleVariableEntity ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5367:1: ( ruleVariableEntity )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5367:1: ( ruleVariableEntity )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5368:1: ruleVariableEntity
            {
             before(grammarAccess.getConstantDefinitionAccess().getNameVariableEntityParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleVariableEntity_in_rule__ConstantDefinition__NameAssignment_110880);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5377:1: rule__ConstantDefinition__ValueAssignment_2 : ( ruleValue ) ;
    public final void rule__ConstantDefinition__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5381:1: ( ( ruleValue ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5382:1: ( ruleValue )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5382:1: ( ruleValue )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5383:1: ruleValue
            {
             before(grammarAccess.getConstantDefinitionAccess().getValueValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleValue_in_rule__ConstantDefinition__ValueAssignment_210911);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5392:1: rule__VariableEntity__NameAssignment : ( ruleQualifiedName ) ;
    public final void rule__VariableEntity__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5396:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5397:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5397:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5398:1: ruleQualifiedName
            {
             before(grammarAccess.getVariableEntityAccess().getNameQualifiedNameParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__VariableEntity__NameAssignment10942);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5407:1: rule__Test__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Test__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5411:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5412:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5412:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5413:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getTestAccess().getDefinitionTestDefinitionCrossReference_1_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5414:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5415:1: ruleQualifiedName
            {
             before(grammarAccess.getTestAccess().getDefinitionTestDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Test__DefinitionAssignment_110977);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5426:1: rule__Test__ParametersAssignment_2 : ( ruleParameter ) ;
    public final void rule__Test__ParametersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5430:1: ( ( ruleParameter ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5431:1: ( ruleParameter )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5431:1: ( ruleParameter )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5432:1: ruleParameter
            {
             before(grammarAccess.getTestAccess().getParametersParameterParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleParameter_in_rule__Test__ParametersAssignment_211012);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5441:1: rule__Test__ResultsAssignment_3 : ( ruleNamedResult ) ;
    public final void rule__Test__ResultsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5445:1: ( ( ruleNamedResult ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5446:1: ( ruleNamedResult )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5446:1: ( ruleNamedResult )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5447:1: ruleNamedResult
            {
             before(grammarAccess.getTestAccess().getResultsNamedResultParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleNamedResult_in_rule__Test__ResultsAssignment_311043);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5456:1: rule__Test__ResultAssignment_4_1 : ( ruleValueOrEnumValue ) ;
    public final void rule__Test__ResultAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5460:1: ( ( ruleValueOrEnumValue ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5461:1: ( ruleValueOrEnumValue )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5461:1: ( ruleValueOrEnumValue )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5462:1: ruleValueOrEnumValue
            {
             before(grammarAccess.getTestAccess().getResultValueOrEnumValueParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_rule__Test__ResultAssignment_4_111074);
            ruleValueOrEnumValue();

            state._fsp--;

             after(grammarAccess.getTestAccess().getResultValueOrEnumValueParserRuleCall_4_1_0()); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5471:1: rule__TableTest__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__TableTest__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5475:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5476:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5476:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5477:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getTableTestAccess().getDefinitionTestDefinitionCrossReference_1_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5478:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5479:1: ruleQualifiedName
            {
             before(grammarAccess.getTableTestAccess().getDefinitionTestDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__TableTest__DefinitionAssignment_111109);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5490:1: rule__TableTest__ParametersAssignment_2 : ( ruleParameter ) ;
    public final void rule__TableTest__ParametersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5494:1: ( ( ruleParameter ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5495:1: ( ruleParameter )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5495:1: ( ruleParameter )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5496:1: ruleParameter
            {
             before(grammarAccess.getTableTestAccess().getParametersParameterParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleParameter_in_rule__TableTest__ParametersAssignment_211144);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5505:1: rule__TableTest__ParameterHeadersAssignment_3 : ( ruleParameterTableHeader ) ;
    public final void rule__TableTest__ParameterHeadersAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5509:1: ( ( ruleParameterTableHeader ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5510:1: ( ruleParameterTableHeader )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5510:1: ( ruleParameterTableHeader )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5511:1: ruleParameterTableHeader
            {
             before(grammarAccess.getTableTestAccess().getParameterHeadersParameterTableHeaderParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleParameterTableHeader_in_rule__TableTest__ParameterHeadersAssignment_311175);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5520:1: rule__TableTest__ResultHeadersAssignment_4 : ( ruleResultTableHeader ) ;
    public final void rule__TableTest__ResultHeadersAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5524:1: ( ( ruleResultTableHeader ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5525:1: ( ruleResultTableHeader )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5525:1: ( ruleResultTableHeader )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5526:1: ruleResultTableHeader
            {
             before(grammarAccess.getTableTestAccess().getResultHeadersResultTableHeaderParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleResultTableHeader_in_rule__TableTest__ResultHeadersAssignment_411206);
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


    // $ANTLR start "rule__TableTest__RowsAssignment_6"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5535:1: rule__TableTest__RowsAssignment_6 : ( ruleTableTestRow ) ;
    public final void rule__TableTest__RowsAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5539:1: ( ( ruleTableTestRow ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5540:1: ( ruleTableTestRow )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5540:1: ( ruleTableTestRow )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5541:1: ruleTableTestRow
            {
             before(grammarAccess.getTableTestAccess().getRowsTableTestRowParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleTableTestRow_in_rule__TableTest__RowsAssignment_611237);
            ruleTableTestRow();

            state._fsp--;

             after(grammarAccess.getTableTestAccess().getRowsTableTestRowParserRuleCall_6_0()); 

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
    // $ANTLR end "rule__TableTest__RowsAssignment_6"


    // $ANTLR start "rule__TableTestRow__ValuesAssignment_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5550:1: rule__TableTestRow__ValuesAssignment_1 : ( ruleParameterTableValue ) ;
    public final void rule__TableTestRow__ValuesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5554:1: ( ( ruleParameterTableValue ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5555:1: ( ruleParameterTableValue )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5555:1: ( ruleParameterTableValue )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5556:1: ruleParameterTableValue
            {
             before(grammarAccess.getTableTestRowAccess().getValuesParameterTableValueParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleParameterTableValue_in_rule__TableTestRow__ValuesAssignment_111268);
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


    // $ANTLR start "rule__TableTestRow__ResultAssignment_2_0_2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5565:1: rule__TableTestRow__ResultAssignment_2_0_2 : ( ruleValueOrEnumValue ) ;
    public final void rule__TableTestRow__ResultAssignment_2_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5569:1: ( ( ruleValueOrEnumValue ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5570:1: ( ruleValueOrEnumValue )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5570:1: ( ruleValueOrEnumValue )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5571:1: ruleValueOrEnumValue
            {
             before(grammarAccess.getTableTestRowAccess().getResultValueOrEnumValueParserRuleCall_2_0_2_0()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_rule__TableTestRow__ResultAssignment_2_0_211299);
            ruleValueOrEnumValue();

            state._fsp--;

             after(grammarAccess.getTableTestRowAccess().getResultValueOrEnumValueParserRuleCall_2_0_2_0()); 

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
    // $ANTLR end "rule__TableTestRow__ResultAssignment_2_0_2"


    // $ANTLR start "rule__ParameterTableHeader__NameAssignment_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5580:1: rule__ParameterTableHeader__NameAssignment_1 : ( ruleParameterName ) ;
    public final void rule__ParameterTableHeader__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5584:1: ( ( ruleParameterName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5585:1: ( ruleParameterName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5585:1: ( ruleParameterName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5586:1: ruleParameterName
            {
             before(grammarAccess.getParameterTableHeaderAccess().getNameParameterNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleParameterName_in_rule__ParameterTableHeader__NameAssignment_111330);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5595:1: rule__ResultTableHeader__NameAssignment_1 : ( ruleResultName ) ;
    public final void rule__ResultTableHeader__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5599:1: ( ( ruleResultName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5600:1: ( ruleResultName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5600:1: ( ruleResultName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5601:1: ruleResultName
            {
             before(grammarAccess.getResultTableHeaderAccess().getNameResultNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleResultName_in_rule__ResultTableHeader__NameAssignment_111361);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5610:1: rule__ParameterTableValue__ValueAssignment_1 : ( ruleValueOrEnumValue ) ;
    public final void rule__ParameterTableValue__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5614:1: ( ( ruleValueOrEnumValue ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5615:1: ( ruleValueOrEnumValue )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5615:1: ( ruleValueOrEnumValue )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5616:1: ruleValueOrEnumValue
            {
             before(grammarAccess.getParameterTableValueAccess().getValueValueOrEnumValueParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_rule__ParameterTableValue__ValueAssignment_111392);
            ruleValueOrEnumValue();

            state._fsp--;

             after(grammarAccess.getParameterTableValueAccess().getValueValueOrEnumValueParserRuleCall_1_0()); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5625:1: rule__NamedResult__NameAssignment_0 : ( ruleResultName ) ;
    public final void rule__NamedResult__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5629:1: ( ( ruleResultName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5630:1: ( ruleResultName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5630:1: ( ruleResultName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5631:1: ruleResultName
            {
             before(grammarAccess.getNamedResultAccess().getNameResultNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleResultName_in_rule__NamedResult__NameAssignment_011423);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5640:1: rule__NamedResult__ValueAssignment_2 : ( ruleValueOrEnumValue ) ;
    public final void rule__NamedResult__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5644:1: ( ( ruleValueOrEnumValue ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5645:1: ( ruleValueOrEnumValue )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5645:1: ( ruleValueOrEnumValue )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5646:1: ruleValueOrEnumValue
            {
             before(grammarAccess.getNamedResultAccess().getValueValueOrEnumValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_rule__NamedResult__ValueAssignment_211454);
            ruleValueOrEnumValue();

            state._fsp--;

             after(grammarAccess.getNamedResultAccess().getValueValueOrEnumValueParserRuleCall_2_0()); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5655:1: rule__FixedResultName__FieldAssignment : ( ( RULE_ID ) ) ;
    public final void rule__FixedResultName__FieldAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5659:1: ( ( ( RULE_ID ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5660:1: ( ( RULE_ID ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5660:1: ( ( RULE_ID ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5661:1: ( RULE_ID )
            {
             before(grammarAccess.getFixedResultNameAccess().getFieldJvmFieldCrossReference_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5662:1: ( RULE_ID )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5663:1: RULE_ID
            {
             before(grammarAccess.getFixedResultNameAccess().getFieldJvmFieldIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FixedResultName__FieldAssignment11489); 
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


    // $ANTLR start "rule__Call__DefinitionAssignment_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5674:1: rule__Call__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Call__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5678:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5679:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5679:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5680:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getCallAccess().getDefinitionCallDefinitionCrossReference_1_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5681:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5682:1: ruleQualifiedName
            {
             before(grammarAccess.getCallAccess().getDefinitionCallDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Call__DefinitionAssignment_111528);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getCallAccess().getDefinitionCallDefinitionQualifiedNameParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getCallAccess().getDefinitionCallDefinitionCrossReference_1_0()); 

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
    // $ANTLR end "rule__Call__DefinitionAssignment_1"


    // $ANTLR start "rule__Call__ParametersAssignment_2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5693:1: rule__Call__ParametersAssignment_2 : ( ruleParameter ) ;
    public final void rule__Call__ParametersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5697:1: ( ( ruleParameter ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5698:1: ( ruleParameter )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5698:1: ( ruleParameter )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5699:1: ruleParameter
            {
             before(grammarAccess.getCallAccess().getParametersParameterParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleParameter_in_rule__Call__ParametersAssignment_211563);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getCallAccess().getParametersParameterParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__Call__ParametersAssignment_2"


    // $ANTLR start "rule__Call__ResultsAssignment_3"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5708:1: rule__Call__ResultsAssignment_3 : ( ruleNamedCallResult ) ;
    public final void rule__Call__ResultsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5712:1: ( ( ruleNamedCallResult ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5713:1: ( ruleNamedCallResult )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5713:1: ( ruleNamedCallResult )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5714:1: ruleNamedCallResult
            {
             before(grammarAccess.getCallAccess().getResultsNamedCallResultParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleNamedCallResult_in_rule__Call__ResultsAssignment_311594);
            ruleNamedCallResult();

            state._fsp--;

             after(grammarAccess.getCallAccess().getResultsNamedCallResultParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__Call__ResultsAssignment_3"


    // $ANTLR start "rule__Call__ResultAssignment_4_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5723:1: rule__Call__ResultAssignment_4_1 : ( ruleVariable ) ;
    public final void rule__Call__ResultAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5727:1: ( ( ruleVariable ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5728:1: ( ruleVariable )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5728:1: ( ruleVariable )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5729:1: ruleVariable
            {
             before(grammarAccess.getCallAccess().getResultVariableParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleVariable_in_rule__Call__ResultAssignment_4_111625);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getCallAccess().getResultVariableParserRuleCall_4_1_0()); 

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
    // $ANTLR end "rule__Call__ResultAssignment_4_1"


    // $ANTLR start "rule__NamedCallResult__NameAssignment_0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5738:1: rule__NamedCallResult__NameAssignment_0 : ( ruleResultName ) ;
    public final void rule__NamedCallResult__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5742:1: ( ( ruleResultName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5743:1: ( ruleResultName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5743:1: ( ruleResultName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5744:1: ruleResultName
            {
             before(grammarAccess.getNamedCallResultAccess().getNameResultNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleResultName_in_rule__NamedCallResult__NameAssignment_011656);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5753:1: rule__NamedCallResult__TargetAssignment_2 : ( ruleVariable ) ;
    public final void rule__NamedCallResult__TargetAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5757:1: ( ( ruleVariable ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5758:1: ( ruleVariable )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5758:1: ( ruleVariable )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5759:1: ruleVariable
            {
             before(grammarAccess.getNamedCallResultAccess().getTargetVariableParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleVariable_in_rule__NamedCallResult__TargetAssignment_211687);
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


    // $ANTLR start "rule__Suite__DefinitionAssignment_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5768:1: rule__Suite__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Suite__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5772:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5773:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5773:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5774:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSuiteAccess().getDefinitionSuiteDefinitionCrossReference_1_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5775:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5776:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteAccess().getDefinitionSuiteDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Suite__DefinitionAssignment_111722);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getSuiteAccess().getDefinitionSuiteDefinitionQualifiedNameParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getSuiteAccess().getDefinitionSuiteDefinitionCrossReference_1_0()); 

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
    // $ANTLR end "rule__Suite__DefinitionAssignment_1"


    // $ANTLR start "rule__Suite__ParametersAssignment_2"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5787:1: rule__Suite__ParametersAssignment_2 : ( ruleSuiteParameter ) ;
    public final void rule__Suite__ParametersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5791:1: ( ( ruleSuiteParameter ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5792:1: ( ruleSuiteParameter )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5792:1: ( ruleSuiteParameter )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5793:1: ruleSuiteParameter
            {
             before(grammarAccess.getSuiteAccess().getParametersSuiteParameterParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleSuiteParameter_in_rule__Suite__ParametersAssignment_211757);
            ruleSuiteParameter();

            state._fsp--;

             after(grammarAccess.getSuiteAccess().getParametersSuiteParameterParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__Suite__ParametersAssignment_2"


    // $ANTLR start "rule__Suite__ForkAssignment_3_1"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5802:1: rule__Suite__ForkAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Suite__ForkAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5806:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5807:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5807:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5808:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSuiteAccess().getForkForkDefinitionCrossReference_3_1_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5809:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5810:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteAccess().getForkForkDefinitionQualifiedNameParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Suite__ForkAssignment_3_111792);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getSuiteAccess().getForkForkDefinitionQualifiedNameParserRuleCall_3_1_0_1()); 

            }

             after(grammarAccess.getSuiteAccess().getForkForkDefinitionCrossReference_3_1_0()); 

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
    // $ANTLR end "rule__Suite__ForkAssignment_3_1"


    // $ANTLR start "rule__SuiteParameter__NameAssignment_0"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5821:1: rule__SuiteParameter__NameAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__SuiteParameter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5825:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5826:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5826:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5827:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSuiteParameterAccess().getNameVariableEntityCrossReference_0_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5828:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5829:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteParameterAccess().getNameVariableEntityQualifiedNameParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__SuiteParameter__NameAssignment_011831);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5840:1: rule__SuiteParameter__ValueAssignment_2 : ( ruleValue ) ;
    public final void rule__SuiteParameter__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5844:1: ( ( ruleValue ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5845:1: ( ruleValue )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5845:1: ( ruleValue )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5846:1: ruleValue
            {
             before(grammarAccess.getSuiteParameterAccess().getValueValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleValue_in_rule__SuiteParameter__ValueAssignment_211866);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5855:1: rule__Parameter__NameAssignment_0 : ( ruleParameterName ) ;
    public final void rule__Parameter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5859:1: ( ( ruleParameterName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5860:1: ( ruleParameterName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5860:1: ( ruleParameterName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5861:1: ruleParameterName
            {
             before(grammarAccess.getParameterAccess().getNameParameterNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleParameterName_in_rule__Parameter__NameAssignment_011897);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5870:1: rule__Parameter__ValueAssignment_2 : ( ruleValueOrEnumValue ) ;
    public final void rule__Parameter__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5874:1: ( ( ruleValueOrEnumValue ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5875:1: ( ruleValueOrEnumValue )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5875:1: ( ruleValueOrEnumValue )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5876:1: ruleValueOrEnumValue
            {
             before(grammarAccess.getParameterAccess().getValueValueOrEnumValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_rule__Parameter__ValueAssignment_211928);
            ruleValueOrEnumValue();

            state._fsp--;

             after(grammarAccess.getParameterAccess().getValueValueOrEnumValueParserRuleCall_2_0()); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5885:1: rule__FixedParameterName__AnnotationAssignment : ( ( RULE_ID ) ) ;
    public final void rule__FixedParameterName__AnnotationAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5889:1: ( ( ( RULE_ID ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5890:1: ( ( RULE_ID ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5890:1: ( ( RULE_ID ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5891:1: ( RULE_ID )
            {
             before(grammarAccess.getFixedParameterNameAccess().getAnnotationJvmAnnotationReferenceCrossReference_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5892:1: ( RULE_ID )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5893:1: RULE_ID
            {
             before(grammarAccess.getFixedParameterNameAccess().getAnnotationJvmAnnotationReferenceIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FixedParameterName__AnnotationAssignment11963); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5904:1: rule__ArbitraryParameterOrResultName__IdentifierAssignment_1 : ( RULE_ID ) ;
    public final void rule__ArbitraryParameterOrResultName__IdentifierAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5908:1: ( ( RULE_ID ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5909:1: ( RULE_ID )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5909:1: ( RULE_ID )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5910:1: RULE_ID
            {
             before(grammarAccess.getArbitraryParameterOrResultNameAccess().getIdentifierIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ArbitraryParameterOrResultName__IdentifierAssignment_111998); 
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


    // $ANTLR start "rule__IntegerValue__IntegerValueAssignment"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5919:1: rule__IntegerValue__IntegerValueAssignment : ( RULE_INTEGER ) ;
    public final void rule__IntegerValue__IntegerValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5923:1: ( ( RULE_INTEGER ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5924:1: ( RULE_INTEGER )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5924:1: ( RULE_INTEGER )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5925:1: RULE_INTEGER
            {
             before(grammarAccess.getIntegerValueAccess().getIntegerValueINTEGERTerminalRuleCall_0()); 
            match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_rule__IntegerValue__IntegerValueAssignment12029); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5934:1: rule__DecimalValue__DecimalValueAssignment : ( RULE_DECIMAL ) ;
    public final void rule__DecimalValue__DecimalValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5938:1: ( ( RULE_DECIMAL ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5939:1: ( RULE_DECIMAL )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5939:1: ( RULE_DECIMAL )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5940:1: RULE_DECIMAL
            {
             before(grammarAccess.getDecimalValueAccess().getDecimalValueDECIMALTerminalRuleCall_0()); 
            match(input,RULE_DECIMAL,FOLLOW_RULE_DECIMAL_in_rule__DecimalValue__DecimalValueAssignment12060); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5949:1: rule__StringValue__StringValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringValue__StringValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5953:1: ( ( RULE_STRING ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5954:1: ( RULE_STRING )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5954:1: ( RULE_STRING )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5955:1: RULE_STRING
            {
             before(grammarAccess.getStringValueAccess().getStringValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringValue__StringValueAssignment12091); 
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


    // $ANTLR start "rule__Variable__NameAssignment"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5964:1: rule__Variable__NameAssignment : ( ( ruleQualifiedName ) ) ;
    public final void rule__Variable__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5968:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5969:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5969:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5970:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getVariableAccess().getNameVariableEntityCrossReference_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5971:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5972:1: ruleQualifiedName
            {
             before(grammarAccess.getVariableAccess().getNameVariableEntityQualifiedNameParserRuleCall_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Variable__NameAssignment12126);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5983:1: rule__EnumValue__EnumValueAssignment : ( ( RULE_UPPERCASE_ID ) ) ;
    public final void rule__EnumValue__EnumValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5987:1: ( ( ( RULE_UPPERCASE_ID ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5988:1: ( ( RULE_UPPERCASE_ID ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5988:1: ( ( RULE_UPPERCASE_ID ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5989:1: ( RULE_UPPERCASE_ID )
            {
             before(grammarAccess.getEnumValueAccess().getEnumValueJvmEnumerationLiteralCrossReference_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5990:1: ( RULE_UPPERCASE_ID )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5991:1: RULE_UPPERCASE_ID
            {
             before(grammarAccess.getEnumValueAccess().getEnumValueJvmEnumerationLiteralUPPERCASE_IDTerminalRuleCall_0_1()); 
            match(input,RULE_UPPERCASE_ID,FOLLOW_RULE_UPPERCASE_ID_in_rule__EnumValue__EnumValueAssignment12165); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6002:1: rule__MethodReference__TypeAssignment_0 : ( ( ruleQualifiedJavaClassName ) ) ;
    public final void rule__MethodReference__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6006:1: ( ( ( ruleQualifiedJavaClassName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6007:1: ( ( ruleQualifiedJavaClassName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6007:1: ( ( ruleQualifiedJavaClassName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6008:1: ( ruleQualifiedJavaClassName )
            {
             before(grammarAccess.getMethodReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6009:1: ( ruleQualifiedJavaClassName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6010:1: ruleQualifiedJavaClassName
            {
             before(grammarAccess.getMethodReferenceAccess().getTypeJvmTypeQualifiedJavaClassNameParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_rule__MethodReference__TypeAssignment_012204);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6021:1: rule__MethodReference__MethodAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__MethodReference__MethodAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6025:1: ( ( ( RULE_ID ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6026:1: ( ( RULE_ID ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6026:1: ( ( RULE_ID ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6027:1: ( RULE_ID )
            {
             before(grammarAccess.getMethodReferenceAccess().getMethodJvmOperationCrossReference_2_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6028:1: ( RULE_ID )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:6029:1: RULE_ID
            {
             before(grammarAccess.getMethodReferenceAccess().getMethodJvmOperationIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__MethodReference__MethodAssignment_212243); 
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

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__StatementsAssignment_in_ruleModel94 = new BitSet(new long[]{0x0000002000090002L});
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
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_entryRuleValueOrEnumValue2042 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueOrEnumValue2049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueOrEnumValue__Alternatives_in_ruleValueOrEnumValue2075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue2102 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue2109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Alternatives_in_ruleValue2135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerValue_in_entryRuleIntegerValue2162 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerValue2169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntegerValue__IntegerValueAssignment_in_ruleIntegerValue2195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalValue_in_entryRuleDecimalValue2222 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalValue2229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalValue__DecimalValueAssignment_in_ruleDecimalValue2255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringValue_in_entryRuleStringValue2282 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringValue2289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringValue__StringValueAssignment_in_ruleStringValue2315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable2342 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable2349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__NameAssignment_in_ruleVariable2375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumValue_in_entryRuleEnumValue2402 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumValue2409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumValue__EnumValueAssignment_in_ruleEnumValue2435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodReference_in_entryRuleMethodReference2462 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodReference2469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__0_in_ruleMethodReference2495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2522 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName2529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName2555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_entryRuleQualifiedJavaClassName2582 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedJavaClassName2589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__0_in_ruleQualifiedJavaClassName2615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard2642 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard2649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__0_in_ruleQualifiedNameWithWildcard2675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDefinition_in_rule__Statement__Alternatives2711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__Statement__Alternatives2728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_rule__Statement__Alternatives2745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__PackageStatement__Alternatives2777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForkDefinition_in_rule__PackageStatement__Alternatives2794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestDefinition_in_rule__PackageStatement__Alternatives2811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallDefinition_in_rule__PackageStatement__Alternatives2828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteDefinition_in_rule__PackageStatement__Alternatives2845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_rule__PackageStatement__Alternatives2862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantDefinition_in_rule__PackageStatement__Alternatives2879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteStatementWithResult_in_rule__SuiteStatement__Alternatives2911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_rule__SuiteStatement__Alternatives2928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_rule__SuiteStatement__Alternatives2945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantDefinition_in_rule__SuiteStatement__Alternatives2962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleSingleLineComment_in_rule__SuiteStatement__Alternatives2979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleMultiLineComment_in_rule__SuiteStatement__Alternatives2996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_rule__SuiteStatementWithResult__Alternatives3028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTest_in_rule__SuiteStatementWithResult__Alternatives3045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTableTest_in_rule__SuiteStatementWithResult__Alternatives3062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group_5_0__0_in_rule__TableTest__Alternatives_53094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__TableTest__Alternatives_53113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group_2_0__0_in_rule__TableTestRow__Alternatives_23147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__TableTestRow__Alternatives_23166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedResultName_in_rule__ResultName__Alternatives3200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterOrResultName_in_rule__ResultName__Alternatives3217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedParameterName_in_rule__ParameterName__Alternatives3249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterOrResultName_in_rule__ParameterName__Alternatives3266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__ValueOrEnumValue__Alternatives3298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumValue_in_rule__ValueOrEnumValue__Alternatives3315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringValue_in_rule__Value__Alternatives3347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerValue_in_rule__Value__Alternatives3364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalValue_in_rule__Value__Alternatives3381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__Value__Alternatives3398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__0__Impl_in_rule__PackageDefinition__Group__03428 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__1_in_rule__PackageDefinition__Group__03431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__PackageDefinition__Group__0__Impl3459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__1__Impl_in_rule__PackageDefinition__Group__13490 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__2_in_rule__PackageDefinition__Group__13493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__NameAssignment_1_in_rule__PackageDefinition__Group__1__Impl3520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__2__Impl_in_rule__PackageDefinition__Group__23550 = new BitSet(new long[]{0x00000000A1BC0000L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__3_in_rule__PackageDefinition__Group__23553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__PackageDefinition__Group__2__Impl3581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__3__Impl_in_rule__PackageDefinition__Group__33612 = new BitSet(new long[]{0x00000000A1BC0000L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__4_in_rule__PackageDefinition__Group__33615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__StatementsAssignment_3_in_rule__PackageDefinition__Group__3__Impl3642 = new BitSet(new long[]{0x00000000A1B80002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__4__Impl_in_rule__PackageDefinition__Group__43673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__PackageDefinition__Group__4__Impl3701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__03742 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__03745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Import__Group__0__Impl3773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__13804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl3831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ForkDefinition__Group__0__Impl_in_rule__ForkDefinition__Group__03865 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ForkDefinition__Group__1_in_rule__ForkDefinition__Group__03868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ForkDefinition__Group__0__Impl3896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ForkDefinition__Group__1__Impl_in_rule__ForkDefinition__Group__13927 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_rule__ForkDefinition__Group__2_in_rule__ForkDefinition__Group__13930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ForkDefinition__NameAssignment_1_in_rule__ForkDefinition__Group__1__Impl3957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ForkDefinition__Group__2__Impl_in_rule__ForkDefinition__Group__23987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ForkDefinition__DescriptionAssignment_2_in_rule__ForkDefinition__Group__2__Impl4014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__0__Impl_in_rule__TestDefinition__Group__04051 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__1_in_rule__TestDefinition__Group__04054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__TestDefinition__Group__0__Impl4082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__1__Impl_in_rule__TestDefinition__Group__14113 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__2_in_rule__TestDefinition__Group__14116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__NameAssignment_1_in_rule__TestDefinition__Group__1__Impl4143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__2__Impl_in_rule__TestDefinition__Group__24173 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__3_in_rule__TestDefinition__Group__24176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__TestDefinition__Group__2__Impl4204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__3__Impl_in_rule__TestDefinition__Group__34235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__FixtureMethodAssignment_3_in_rule__TestDefinition__Group__3__Impl4262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__0__Impl_in_rule__CallDefinition__Group__04300 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__1_in_rule__CallDefinition__Group__04303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__CallDefinition__Group__0__Impl4331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__1__Impl_in_rule__CallDefinition__Group__14362 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__2_in_rule__CallDefinition__Group__14365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__NameAssignment_1_in_rule__CallDefinition__Group__1__Impl4392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__2__Impl_in_rule__CallDefinition__Group__24422 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__3_in_rule__CallDefinition__Group__24425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__CallDefinition__Group__2__Impl4453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__3__Impl_in_rule__CallDefinition__Group__34484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__FixtureMethodAssignment_3_in_rule__CallDefinition__Group__3__Impl4511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__0__Impl_in_rule__SuiteDefinition__Group__04549 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__1_in_rule__SuiteDefinition__Group__04552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__SuiteDefinition__Group__0__Impl4580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__1__Impl_in_rule__SuiteDefinition__Group__14611 = new BitSet(new long[]{0x000000000C020000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__2_in_rule__SuiteDefinition__Group__14614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__NameAssignment_1_in_rule__SuiteDefinition__Group__1__Impl4641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__2__Impl_in_rule__SuiteDefinition__Group__24671 = new BitSet(new long[]{0x000000000C020000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__3_in_rule__SuiteDefinition__Group__24674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_2__0_in_rule__SuiteDefinition__Group__2__Impl4701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__3__Impl_in_rule__SuiteDefinition__Group__34732 = new BitSet(new long[]{0x000000000C020000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__4_in_rule__SuiteDefinition__Group__34735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_3__0_in_rule__SuiteDefinition__Group__3__Impl4762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__4__Impl_in_rule__SuiteDefinition__Group__44793 = new BitSet(new long[]{0x0000002DA3B900C0L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__5_in_rule__SuiteDefinition__Group__44796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__SuiteDefinition__Group__4__Impl4824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__5__Impl_in_rule__SuiteDefinition__Group__54855 = new BitSet(new long[]{0x0000002DA3B900C0L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__6_in_rule__SuiteDefinition__Group__54858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__StatementsAssignment_5_in_rule__SuiteDefinition__Group__5__Impl4885 = new BitSet(new long[]{0x0000002DA1B900C2L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__6__Impl_in_rule__SuiteDefinition__Group__64916 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__7_in_rule__SuiteDefinition__Group__64919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__SuiteDefinition__Group__6__Impl4947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__7__Impl_in_rule__SuiteDefinition__Group__74978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_7__0_in_rule__SuiteDefinition__Group__7__Impl5005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_2__0__Impl_in_rule__SuiteDefinition__Group_2__05052 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_2__1_in_rule__SuiteDefinition__Group_2__05055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__SuiteDefinition__Group_2__0__Impl5083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_2__1__Impl_in_rule__SuiteDefinition__Group_2__15114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__ParametersAssignment_2_1_in_rule__SuiteDefinition__Group_2__1__Impl5141 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_3__0__Impl_in_rule__SuiteDefinition__Group_3__05176 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_3__1_in_rule__SuiteDefinition__Group_3__05179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__SuiteDefinition__Group_3__0__Impl5207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_3__1__Impl_in_rule__SuiteDefinition__Group_3__15238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__DependenciesAssignment_3_1_in_rule__SuiteDefinition__Group_3__1__Impl5265 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_7__0__Impl_in_rule__SuiteDefinition__Group_7__05300 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_7__1_in_rule__SuiteDefinition__Group_7__05303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__SuiteDefinition__Group_7__0__Impl5331 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_7__1__Impl_in_rule__SuiteDefinition__Group_7__15362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__FinalizersAssignment_7_1_in_rule__SuiteDefinition__Group_7__1__Impl5389 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__0__Impl_in_rule__VariableDefinition__Group__05424 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__1_in_rule__VariableDefinition__Group__05427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__VariableDefinition__Group__0__Impl5455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__1__Impl_in_rule__VariableDefinition__Group__15486 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__2_in_rule__VariableDefinition__Group__15489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__NameAssignment_1_in_rule__VariableDefinition__Group__1__Impl5516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__2__Impl_in_rule__VariableDefinition__Group__25546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group_2__0_in_rule__VariableDefinition__Group__2__Impl5573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group_2__0__Impl_in_rule__VariableDefinition__Group_2__05610 = new BitSet(new long[]{0x0000000000000710L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group_2__1_in_rule__VariableDefinition__Group_2__05613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__VariableDefinition__Group_2__0__Impl5641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group_2__1__Impl_in_rule__VariableDefinition__Group_2__15672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__InitialValueAssignment_2_1_in_rule__VariableDefinition__Group_2__1__Impl5699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstantDefinition__Group__0__Impl_in_rule__ConstantDefinition__Group__05733 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ConstantDefinition__Group__1_in_rule__ConstantDefinition__Group__05736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ConstantDefinition__Group__0__Impl5764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstantDefinition__Group__1__Impl_in_rule__ConstantDefinition__Group__15795 = new BitSet(new long[]{0x0000000000000710L});
    public static final BitSet FOLLOW_rule__ConstantDefinition__Group__2_in_rule__ConstantDefinition__Group__15798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstantDefinition__NameAssignment_1_in_rule__ConstantDefinition__Group__1__Impl5825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstantDefinition__Group__2__Impl_in_rule__ConstantDefinition__Group__25855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ConstantDefinition__ValueAssignment_2_in_rule__ConstantDefinition__Group__2__Impl5882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group__0__Impl_in_rule__Test__Group__05918 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Test__Group__1_in_rule__Test__Group__05921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Test__Group__0__Impl5949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group__1__Impl_in_rule__Test__Group__15980 = new BitSet(new long[]{0x0000010200000010L});
    public static final BitSet FOLLOW_rule__Test__Group__2_in_rule__Test__Group__15983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__DefinitionAssignment_1_in_rule__Test__Group__1__Impl6010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group__2__Impl_in_rule__Test__Group__26040 = new BitSet(new long[]{0x0000010200000010L});
    public static final BitSet FOLLOW_rule__Test__Group__3_in_rule__Test__Group__26043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__ParametersAssignment_2_in_rule__Test__Group__2__Impl6070 = new BitSet(new long[]{0x0000010000000012L});
    public static final BitSet FOLLOW_rule__Test__Group__3__Impl_in_rule__Test__Group__36101 = new BitSet(new long[]{0x0000010200000010L});
    public static final BitSet FOLLOW_rule__Test__Group__4_in_rule__Test__Group__36104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__ResultsAssignment_3_in_rule__Test__Group__3__Impl6131 = new BitSet(new long[]{0x0000010000000012L});
    public static final BitSet FOLLOW_rule__Test__Group__4__Impl_in_rule__Test__Group__46162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group_4__0_in_rule__Test__Group__4__Impl6189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group_4__0__Impl_in_rule__Test__Group_4__06230 = new BitSet(new long[]{0x0000000000000730L});
    public static final BitSet FOLLOW_rule__Test__Group_4__1_in_rule__Test__Group_4__06233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Test__Group_4__0__Impl6261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group_4__1__Impl_in_rule__Test__Group_4__16292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__ResultAssignment_4_1_in_rule__Test__Group_4__1__Impl6319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group__0__Impl_in_rule__TableTest__Group__06353 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TableTest__Group__1_in_rule__TableTest__Group__06356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__TableTest__Group__0__Impl6384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group__1__Impl_in_rule__TableTest__Group__16415 = new BitSet(new long[]{0x0000010000008010L});
    public static final BitSet FOLLOW_rule__TableTest__Group__2_in_rule__TableTest__Group__16418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__DefinitionAssignment_1_in_rule__TableTest__Group__1__Impl6445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group__2__Impl_in_rule__TableTest__Group__26475 = new BitSet(new long[]{0x0000010000008010L});
    public static final BitSet FOLLOW_rule__TableTest__Group__3_in_rule__TableTest__Group__26478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__ParametersAssignment_2_in_rule__TableTest__Group__2__Impl6505 = new BitSet(new long[]{0x0000010000000012L});
    public static final BitSet FOLLOW_rule__TableTest__Group__3__Impl_in_rule__TableTest__Group__36536 = new BitSet(new long[]{0x0000010000008010L});
    public static final BitSet FOLLOW_rule__TableTest__Group__4_in_rule__TableTest__Group__36539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__ParameterHeadersAssignment_3_in_rule__TableTest__Group__3__Impl6566 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__TableTest__Group__4__Impl_in_rule__TableTest__Group__46597 = new BitSet(new long[]{0x0000010000008010L});
    public static final BitSet FOLLOW_rule__TableTest__Group__5_in_rule__TableTest__Group__46600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__ResultHeadersAssignment_4_in_rule__TableTest__Group__4__Impl6627 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__TableTest__Group__5__Impl_in_rule__TableTest__Group__56658 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__TableTest__Group__6_in_rule__TableTest__Group__56661 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Alternatives_5_in_rule__TableTest__Group__5__Impl6688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group__6__Impl_in_rule__TableTest__Group__66718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__RowsAssignment_6_in_rule__TableTest__Group__6__Impl6747 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__TableTest__RowsAssignment_6_in_rule__TableTest__Group__6__Impl6759 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__TableTest__Group_5_0__0__Impl_in_rule__TableTest__Group_5_0__06806 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__TableTest__Group_5_0__1_in_rule__TableTest__Group_5_0__06809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__TableTest__Group_5_0__0__Impl6837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group_5_0__1__Impl_in_rule__TableTest__Group_5_0__16868 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__TableTest__Group_5_0__2_in_rule__TableTest__Group_5_0__16871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__TableTest__Group_5_0__1__Impl6899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group_5_0__2__Impl_in_rule__TableTest__Group_5_0__26930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__TableTest__Group_5_0__2__Impl6958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group__0__Impl_in_rule__TableTestRow__Group__06995 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group__1_in_rule__TableTestRow__Group__06998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group__1__Impl_in_rule__TableTestRow__Group__17056 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group__2_in_rule__TableTestRow__Group__17059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__ValuesAssignment_1_in_rule__TableTestRow__Group__1__Impl7086 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group__2__Impl_in_rule__TableTestRow__Group__27117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Alternatives_2_in_rule__TableTestRow__Group__2__Impl7144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group_2_0__0__Impl_in_rule__TableTestRow__Group_2_0__07180 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group_2_0__1_in_rule__TableTestRow__Group_2_0__07183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__TableTestRow__Group_2_0__0__Impl7211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group_2_0__1__Impl_in_rule__TableTestRow__Group_2_0__17242 = new BitSet(new long[]{0x0000000000000730L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group_2_0__2_in_rule__TableTestRow__Group_2_0__17245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__TableTestRow__Group_2_0__1__Impl7273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group_2_0__2__Impl_in_rule__TableTestRow__Group_2_0__27304 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group_2_0__3_in_rule__TableTestRow__Group_2_0__27307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__ResultAssignment_2_0_2_in_rule__TableTestRow__Group_2_0__2__Impl7334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group_2_0__3__Impl_in_rule__TableTestRow__Group_2_0__37364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__TableTestRow__Group_2_0__3__Impl7392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableHeader__Group__0__Impl_in_rule__ParameterTableHeader__Group__07431 = new BitSet(new long[]{0x0000010000000010L});
    public static final BitSet FOLLOW_rule__ParameterTableHeader__Group__1_in_rule__ParameterTableHeader__Group__07434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ParameterTableHeader__Group__0__Impl7462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableHeader__Group__1__Impl_in_rule__ParameterTableHeader__Group__17493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableHeader__NameAssignment_1_in_rule__ParameterTableHeader__Group__1__Impl7520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultTableHeader__Group__0__Impl_in_rule__ResultTableHeader__Group__07554 = new BitSet(new long[]{0x0000010000000010L});
    public static final BitSet FOLLOW_rule__ResultTableHeader__Group__1_in_rule__ResultTableHeader__Group__07557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ResultTableHeader__Group__0__Impl7585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultTableHeader__Group__1__Impl_in_rule__ResultTableHeader__Group__17616 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__ResultTableHeader__Group__2_in_rule__ResultTableHeader__Group__17619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultTableHeader__NameAssignment_1_in_rule__ResultTableHeader__Group__1__Impl7646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultTableHeader__Group__2__Impl_in_rule__ResultTableHeader__Group__27676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ResultTableHeader__Group__2__Impl7704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableValue__Group__0__Impl_in_rule__ParameterTableValue__Group__07741 = new BitSet(new long[]{0x0000000000000730L});
    public static final BitSet FOLLOW_rule__ParameterTableValue__Group__1_in_rule__ParameterTableValue__Group__07744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ParameterTableValue__Group__0__Impl7772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableValue__Group__1__Impl_in_rule__ParameterTableValue__Group__17803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableValue__ValueAssignment_1_in_rule__ParameterTableValue__Group__1__Impl7830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedResult__Group__0__Impl_in_rule__NamedResult__Group__07864 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__NamedResult__Group__1_in_rule__NamedResult__Group__07867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedResult__NameAssignment_0_in_rule__NamedResult__Group__0__Impl7894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedResult__Group__1__Impl_in_rule__NamedResult__Group__17924 = new BitSet(new long[]{0x0000000000000730L});
    public static final BitSet FOLLOW_rule__NamedResult__Group__2_in_rule__NamedResult__Group__17927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__NamedResult__Group__1__Impl7955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedResult__Group__2__Impl_in_rule__NamedResult__Group__27986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedResult__ValueAssignment_2_in_rule__NamedResult__Group__2__Impl8013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__0__Impl_in_rule__Call__Group__08049 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Call__Group__1_in_rule__Call__Group__08052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__Call__Group__0__Impl8080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__1__Impl_in_rule__Call__Group__18111 = new BitSet(new long[]{0x0000011000000010L});
    public static final BitSet FOLLOW_rule__Call__Group__2_in_rule__Call__Group__18114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__DefinitionAssignment_1_in_rule__Call__Group__1__Impl8141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__2__Impl_in_rule__Call__Group__28171 = new BitSet(new long[]{0x0000011000000010L});
    public static final BitSet FOLLOW_rule__Call__Group__3_in_rule__Call__Group__28174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__ParametersAssignment_2_in_rule__Call__Group__2__Impl8201 = new BitSet(new long[]{0x0000010000000012L});
    public static final BitSet FOLLOW_rule__Call__Group__3__Impl_in_rule__Call__Group__38232 = new BitSet(new long[]{0x0000011000000010L});
    public static final BitSet FOLLOW_rule__Call__Group__4_in_rule__Call__Group__38235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__ResultsAssignment_3_in_rule__Call__Group__3__Impl8262 = new BitSet(new long[]{0x0000010000000012L});
    public static final BitSet FOLLOW_rule__Call__Group__4__Impl_in_rule__Call__Group__48293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group_4__0_in_rule__Call__Group__4__Impl8320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group_4__0__Impl_in_rule__Call__Group_4__08361 = new BitSet(new long[]{0x0000000000000710L});
    public static final BitSet FOLLOW_rule__Call__Group_4__1_in_rule__Call__Group_4__08364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__Call__Group_4__0__Impl8392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group_4__1__Impl_in_rule__Call__Group_4__18423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__ResultAssignment_4_1_in_rule__Call__Group_4__1__Impl8450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedCallResult__Group__0__Impl_in_rule__NamedCallResult__Group__08484 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__NamedCallResult__Group__1_in_rule__NamedCallResult__Group__08487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedCallResult__NameAssignment_0_in_rule__NamedCallResult__Group__0__Impl8514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedCallResult__Group__1__Impl_in_rule__NamedCallResult__Group__18544 = new BitSet(new long[]{0x0000000000000710L});
    public static final BitSet FOLLOW_rule__NamedCallResult__Group__2_in_rule__NamedCallResult__Group__18547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__NamedCallResult__Group__1__Impl8575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedCallResult__Group__2__Impl_in_rule__NamedCallResult__Group__28606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedCallResult__TargetAssignment_2_in_rule__NamedCallResult__Group__2__Impl8633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group__0__Impl_in_rule__Suite__Group__08669 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Suite__Group__1_in_rule__Suite__Group__08672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__Suite__Group__0__Impl8700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group__1__Impl_in_rule__Suite__Group__18731 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_rule__Suite__Group__2_in_rule__Suite__Group__18734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__DefinitionAssignment_1_in_rule__Suite__Group__1__Impl8761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group__2__Impl_in_rule__Suite__Group__28791 = new BitSet(new long[]{0x0000004000000010L});
    public static final BitSet FOLLOW_rule__Suite__Group__3_in_rule__Suite__Group__28794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__ParametersAssignment_2_in_rule__Suite__Group__2__Impl8821 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Suite__Group__3__Impl_in_rule__Suite__Group__38852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group_3__0_in_rule__Suite__Group__3__Impl8879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group_3__0__Impl_in_rule__Suite__Group_3__08918 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Suite__Group_3__1_in_rule__Suite__Group_3__08921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Suite__Group_3__0__Impl8949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group_3__1__Impl_in_rule__Suite__Group_3__18980 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__ForkAssignment_3_1_in_rule__Suite__Group_3__1__Impl9007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__0__Impl_in_rule__SuiteParameter__Group__09041 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__1_in_rule__SuiteParameter__Group__09044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__NameAssignment_0_in_rule__SuiteParameter__Group__0__Impl9071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__1__Impl_in_rule__SuiteParameter__Group__19101 = new BitSet(new long[]{0x0000000000000710L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__2_in_rule__SuiteParameter__Group__19104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__SuiteParameter__Group__1__Impl9132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__2__Impl_in_rule__SuiteParameter__Group__29163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__ValueAssignment_2_in_rule__SuiteParameter__Group__2__Impl9190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__09226 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__09229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__NameAssignment_0_in_rule__Parameter__Group__0__Impl9256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__19286 = new BitSet(new long[]{0x0000000000000730L});
    public static final BitSet FOLLOW_rule__Parameter__Group__2_in_rule__Parameter__Group__19289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__Parameter__Group__1__Impl9317 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__2__Impl_in_rule__Parameter__Group__29348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__ValueAssignment_2_in_rule__Parameter__Group__2__Impl9375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArbitraryParameterOrResultName__Group__0__Impl_in_rule__ArbitraryParameterOrResultName__Group__09411 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ArbitraryParameterOrResultName__Group__1_in_rule__ArbitraryParameterOrResultName__Group__09414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__ArbitraryParameterOrResultName__Group__0__Impl9442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArbitraryParameterOrResultName__Group__1__Impl_in_rule__ArbitraryParameterOrResultName__Group__19473 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArbitraryParameterOrResultName__IdentifierAssignment_1_in_rule__ArbitraryParameterOrResultName__Group__1__Impl9500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__0__Impl_in_rule__MethodReference__Group__09534 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__1_in_rule__MethodReference__Group__09537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__TypeAssignment_0_in_rule__MethodReference__Group__0__Impl9564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__1__Impl_in_rule__MethodReference__Group__19594 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__2_in_rule__MethodReference__Group__19597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__MethodReference__Group__1__Impl9625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__2__Impl_in_rule__MethodReference__Group__29656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__MethodAssignment_2_in_rule__MethodReference__Group__2__Impl9683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__09719 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__09722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl9749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__19778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl9805 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__09840 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__09843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__QualifiedName__Group_1__0__Impl9871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__19902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl9929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__0__Impl_in_rule__QualifiedJavaClassName__Group__09962 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__1_in_rule__QualifiedJavaClassName__Group__09965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedJavaClassName__Group__0__Impl9992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__1__Impl_in_rule__QualifiedJavaClassName__Group__110021 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__2_in_rule__QualifiedJavaClassName__Group__110024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__QualifiedJavaClassName__Group__1__Impl10052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__2__Impl_in_rule__QualifiedJavaClassName__Group__210083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UPPERCASE_ID_in_rule__QualifiedJavaClassName__Group__2__Impl10110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__0__Impl_in_rule__QualifiedNameWithWildcard__Group__010145 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__1_in_rule__QualifiedNameWithWildcard__Group__010148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildcard__Group__0__Impl10175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__1__Impl_in_rule__QualifiedNameWithWildcard__Group__110204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__QualifiedNameWithWildcard__Group__1__Impl10233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_rule__Model__StatementsAssignment10275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SL_VISIBLE_COMMENT_in_rule__VisibleSingleLineComment__ContentAssignment10306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ML_VISIBLE_COMMENT_in_rule__VisibleMultiLineComment__ContentAssignment10337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__PackageDefinition__NameAssignment_110368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageStatement_in_rule__PackageDefinition__StatementsAssignment_310399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_rule__Import__ImportedNamespaceAssignment_110430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__ForkDefinition__NameAssignment_110461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__ForkDefinition__DescriptionAssignment_210492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__TestDefinition__NameAssignment_110523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodReference_in_rule__TestDefinition__FixtureMethodAssignment_310554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__CallDefinition__NameAssignment_110585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodReference_in_rule__CallDefinition__FixtureMethodAssignment_310616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__NameAssignment_110647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_rule__SuiteDefinition__ParametersAssignment_2_110678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__DependenciesAssignment_3_110713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteStatement_in_rule__SuiteDefinition__StatementsAssignment_510748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__FinalizersAssignment_7_110783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_rule__VariableDefinition__NameAssignment_110818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__VariableDefinition__InitialValueAssignment_2_110849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_rule__ConstantDefinition__NameAssignment_110880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__ConstantDefinition__ValueAssignment_210911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__VariableEntity__NameAssignment10942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Test__DefinitionAssignment_110977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_rule__Test__ParametersAssignment_211012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedResult_in_rule__Test__ResultsAssignment_311043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_rule__Test__ResultAssignment_4_111074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__TableTest__DefinitionAssignment_111109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_rule__TableTest__ParametersAssignment_211144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableHeader_in_rule__TableTest__ParameterHeadersAssignment_311175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultTableHeader_in_rule__TableTest__ResultHeadersAssignment_411206 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTableTestRow_in_rule__TableTest__RowsAssignment_611237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableValue_in_rule__TableTestRow__ValuesAssignment_111268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_rule__TableTestRow__ResultAssignment_2_0_211299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterName_in_rule__ParameterTableHeader__NameAssignment_111330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultName_in_rule__ResultTableHeader__NameAssignment_111361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_rule__ParameterTableValue__ValueAssignment_111392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultName_in_rule__NamedResult__NameAssignment_011423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_rule__NamedResult__ValueAssignment_211454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FixedResultName__FieldAssignment11489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Call__DefinitionAssignment_111528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_rule__Call__ParametersAssignment_211563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedCallResult_in_rule__Call__ResultsAssignment_311594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__Call__ResultAssignment_4_111625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultName_in_rule__NamedCallResult__NameAssignment_011656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__NamedCallResult__TargetAssignment_211687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Suite__DefinitionAssignment_111722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteParameter_in_rule__Suite__ParametersAssignment_211757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Suite__ForkAssignment_3_111792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__SuiteParameter__NameAssignment_011831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__SuiteParameter__ValueAssignment_211866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterName_in_rule__Parameter__NameAssignment_011897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_rule__Parameter__ValueAssignment_211928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FixedParameterName__AnnotationAssignment11963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ArbitraryParameterOrResultName__IdentifierAssignment_111998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_rule__IntegerValue__IntegerValueAssignment12029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DECIMAL_in_rule__DecimalValue__DecimalValueAssignment12060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringValue__StringValueAssignment12091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Variable__NameAssignment12126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UPPERCASE_ID_in_rule__EnumValue__EnumValueAssignment12165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_rule__MethodReference__TypeAssignment_012204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__MethodReference__MethodAssignment_212243 = new BitSet(new long[]{0x0000000000000002L});

}