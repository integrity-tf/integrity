package de.integrity.ui.contentassist.antlr.internal; 

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
import de.integrity.services.DSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDSLParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_UPPERCASE_ID", "RULE_INTEGER", "RULE_DECIMAL", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'packagedef'", "'with'", "'packageend'", "'import'", "'testdef'", "'uses'", "'calldef'", "'suitedef'", "'suiteend'", "'gets'", "'requires'", "'concludedby'", "'variable'", "'initially'", "'test'", "'='", "'call'", "'sets'", "'suite'", "':'", "'+'", "'#'", "'.'", "'.*'"
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
    public static final int RULE_ANY_OTHER=12;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=10;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=8;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__34=34;
    public static final int T__15=15;
    public static final int T__35=35;
    public static final int T__18=18;
    public static final int T__36=36;
    public static final int T__17=17;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_UPPERCASE_ID=5;
    public static final int RULE_WS=11;
    public static final int RULE_DECIMAL=7;
    public static final int RULE_INTEGER=6;

    // delegates
    // delegators


        public InternalDSLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDSLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDSLParser.tokenNames; }
    public String getGrammarFileName() { return "../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g"; }


     
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:61:1: ( ruleModel EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:62:1: ruleModel EOF
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:69:1: ruleModel : ( ( rule__Model__StatementsAssignment )* ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:73:2: ( ( ( rule__Model__StatementsAssignment )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:74:1: ( ( rule__Model__StatementsAssignment )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:74:1: ( ( rule__Model__StatementsAssignment )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:75:1: ( rule__Model__StatementsAssignment )*
            {
             before(grammarAccess.getModelAccess().getStatementsAssignment()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:76:1: ( rule__Model__StatementsAssignment )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13||LA1_0==16||LA1_0==31) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:76:2: rule__Model__StatementsAssignment
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:88:1: entryRuleStatement : ruleStatement EOF ;
    public final void entryRuleStatement() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:89:1: ( ruleStatement EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:90:1: ruleStatement EOF
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:97:1: ruleStatement : ( ( rule__Statement__Alternatives ) ) ;
    public final void ruleStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:101:2: ( ( ( rule__Statement__Alternatives ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:102:1: ( ( rule__Statement__Alternatives ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:102:1: ( ( rule__Statement__Alternatives ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:103:1: ( rule__Statement__Alternatives )
            {
             before(grammarAccess.getStatementAccess().getAlternatives()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:104:1: ( rule__Statement__Alternatives )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:104:2: rule__Statement__Alternatives
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


    // $ANTLR start "entryRulePackageDefinition"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:116:1: entryRulePackageDefinition : rulePackageDefinition EOF ;
    public final void entryRulePackageDefinition() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:117:1: ( rulePackageDefinition EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:118:1: rulePackageDefinition EOF
            {
             before(grammarAccess.getPackageDefinitionRule()); 
            pushFollow(FOLLOW_rulePackageDefinition_in_entryRulePackageDefinition182);
            rulePackageDefinition();

            state._fsp--;

             after(grammarAccess.getPackageDefinitionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePackageDefinition189); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:125:1: rulePackageDefinition : ( ( rule__PackageDefinition__Group__0 ) ) ;
    public final void rulePackageDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:129:2: ( ( ( rule__PackageDefinition__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:130:1: ( ( rule__PackageDefinition__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:130:1: ( ( rule__PackageDefinition__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:131:1: ( rule__PackageDefinition__Group__0 )
            {
             before(grammarAccess.getPackageDefinitionAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:132:1: ( rule__PackageDefinition__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:132:2: rule__PackageDefinition__Group__0
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__0_in_rulePackageDefinition215);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:144:1: entryRulePackageStatement : rulePackageStatement EOF ;
    public final void entryRulePackageStatement() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:145:1: ( rulePackageStatement EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:146:1: rulePackageStatement EOF
            {
             before(grammarAccess.getPackageStatementRule()); 
            pushFollow(FOLLOW_rulePackageStatement_in_entryRulePackageStatement242);
            rulePackageStatement();

            state._fsp--;

             after(grammarAccess.getPackageStatementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePackageStatement249); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:153:1: rulePackageStatement : ( ( rule__PackageStatement__Alternatives ) ) ;
    public final void rulePackageStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:157:2: ( ( ( rule__PackageStatement__Alternatives ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:158:1: ( ( rule__PackageStatement__Alternatives ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:158:1: ( ( rule__PackageStatement__Alternatives ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:159:1: ( rule__PackageStatement__Alternatives )
            {
             before(grammarAccess.getPackageStatementAccess().getAlternatives()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:160:1: ( rule__PackageStatement__Alternatives )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:160:2: rule__PackageStatement__Alternatives
            {
            pushFollow(FOLLOW_rule__PackageStatement__Alternatives_in_rulePackageStatement275);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:172:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:173:1: ( ruleImport EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:174:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport302);
            ruleImport();

            state._fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport309); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:181:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:185:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:186:1: ( ( rule__Import__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:186:1: ( ( rule__Import__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:187:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:188:1: ( rule__Import__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:188:2: rule__Import__Group__0
            {
            pushFollow(FOLLOW_rule__Import__Group__0_in_ruleImport335);
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


    // $ANTLR start "entryRuleTestDefinition"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:200:1: entryRuleTestDefinition : ruleTestDefinition EOF ;
    public final void entryRuleTestDefinition() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:201:1: ( ruleTestDefinition EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:202:1: ruleTestDefinition EOF
            {
             before(grammarAccess.getTestDefinitionRule()); 
            pushFollow(FOLLOW_ruleTestDefinition_in_entryRuleTestDefinition362);
            ruleTestDefinition();

            state._fsp--;

             after(grammarAccess.getTestDefinitionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestDefinition369); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:209:1: ruleTestDefinition : ( ( rule__TestDefinition__Group__0 ) ) ;
    public final void ruleTestDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:213:2: ( ( ( rule__TestDefinition__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:214:1: ( ( rule__TestDefinition__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:214:1: ( ( rule__TestDefinition__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:215:1: ( rule__TestDefinition__Group__0 )
            {
             before(grammarAccess.getTestDefinitionAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:216:1: ( rule__TestDefinition__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:216:2: rule__TestDefinition__Group__0
            {
            pushFollow(FOLLOW_rule__TestDefinition__Group__0_in_ruleTestDefinition395);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:228:1: entryRuleCallDefinition : ruleCallDefinition EOF ;
    public final void entryRuleCallDefinition() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:229:1: ( ruleCallDefinition EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:230:1: ruleCallDefinition EOF
            {
             before(grammarAccess.getCallDefinitionRule()); 
            pushFollow(FOLLOW_ruleCallDefinition_in_entryRuleCallDefinition422);
            ruleCallDefinition();

            state._fsp--;

             after(grammarAccess.getCallDefinitionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallDefinition429); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:237:1: ruleCallDefinition : ( ( rule__CallDefinition__Group__0 ) ) ;
    public final void ruleCallDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:241:2: ( ( ( rule__CallDefinition__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:242:1: ( ( rule__CallDefinition__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:242:1: ( ( rule__CallDefinition__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:243:1: ( rule__CallDefinition__Group__0 )
            {
             before(grammarAccess.getCallDefinitionAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:244:1: ( rule__CallDefinition__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:244:2: rule__CallDefinition__Group__0
            {
            pushFollow(FOLLOW_rule__CallDefinition__Group__0_in_ruleCallDefinition455);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:256:1: entryRuleSuiteDefinition : ruleSuiteDefinition EOF ;
    public final void entryRuleSuiteDefinition() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:257:1: ( ruleSuiteDefinition EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:258:1: ruleSuiteDefinition EOF
            {
             before(grammarAccess.getSuiteDefinitionRule()); 
            pushFollow(FOLLOW_ruleSuiteDefinition_in_entryRuleSuiteDefinition482);
            ruleSuiteDefinition();

            state._fsp--;

             after(grammarAccess.getSuiteDefinitionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteDefinition489); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:265:1: ruleSuiteDefinition : ( ( rule__SuiteDefinition__Group__0 ) ) ;
    public final void ruleSuiteDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:269:2: ( ( ( rule__SuiteDefinition__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:270:1: ( ( rule__SuiteDefinition__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:270:1: ( ( rule__SuiteDefinition__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:271:1: ( rule__SuiteDefinition__Group__0 )
            {
             before(grammarAccess.getSuiteDefinitionAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:272:1: ( rule__SuiteDefinition__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:272:2: rule__SuiteDefinition__Group__0
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__0_in_ruleSuiteDefinition515);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:284:1: entryRuleSuiteStatement : ruleSuiteStatement EOF ;
    public final void entryRuleSuiteStatement() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:285:1: ( ruleSuiteStatement EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:286:1: ruleSuiteStatement EOF
            {
             before(grammarAccess.getSuiteStatementRule()); 
            pushFollow(FOLLOW_ruleSuiteStatement_in_entryRuleSuiteStatement542);
            ruleSuiteStatement();

            state._fsp--;

             after(grammarAccess.getSuiteStatementRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteStatement549); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:293:1: ruleSuiteStatement : ( ( rule__SuiteStatement__Alternatives ) ) ;
    public final void ruleSuiteStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:297:2: ( ( ( rule__SuiteStatement__Alternatives ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:298:1: ( ( rule__SuiteStatement__Alternatives ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:298:1: ( ( rule__SuiteStatement__Alternatives ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:299:1: ( rule__SuiteStatement__Alternatives )
            {
             before(grammarAccess.getSuiteStatementAccess().getAlternatives()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:300:1: ( rule__SuiteStatement__Alternatives )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:300:2: rule__SuiteStatement__Alternatives
            {
            pushFollow(FOLLOW_rule__SuiteStatement__Alternatives_in_ruleSuiteStatement575);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:312:1: entryRuleSuiteStatementWithResult : ruleSuiteStatementWithResult EOF ;
    public final void entryRuleSuiteStatementWithResult() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:313:1: ( ruleSuiteStatementWithResult EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:314:1: ruleSuiteStatementWithResult EOF
            {
             before(grammarAccess.getSuiteStatementWithResultRule()); 
            pushFollow(FOLLOW_ruleSuiteStatementWithResult_in_entryRuleSuiteStatementWithResult602);
            ruleSuiteStatementWithResult();

            state._fsp--;

             after(grammarAccess.getSuiteStatementWithResultRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteStatementWithResult609); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:321:1: ruleSuiteStatementWithResult : ( ( rule__SuiteStatementWithResult__Alternatives ) ) ;
    public final void ruleSuiteStatementWithResult() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:325:2: ( ( ( rule__SuiteStatementWithResult__Alternatives ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:326:1: ( ( rule__SuiteStatementWithResult__Alternatives ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:326:1: ( ( rule__SuiteStatementWithResult__Alternatives ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:327:1: ( rule__SuiteStatementWithResult__Alternatives )
            {
             before(grammarAccess.getSuiteStatementWithResultAccess().getAlternatives()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:328:1: ( rule__SuiteStatementWithResult__Alternatives )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:328:2: rule__SuiteStatementWithResult__Alternatives
            {
            pushFollow(FOLLOW_rule__SuiteStatementWithResult__Alternatives_in_ruleSuiteStatementWithResult635);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:340:1: entryRuleVariableDefinition : ruleVariableDefinition EOF ;
    public final void entryRuleVariableDefinition() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:341:1: ( ruleVariableDefinition EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:342:1: ruleVariableDefinition EOF
            {
             before(grammarAccess.getVariableDefinitionRule()); 
            pushFollow(FOLLOW_ruleVariableDefinition_in_entryRuleVariableDefinition662);
            ruleVariableDefinition();

            state._fsp--;

             after(grammarAccess.getVariableDefinitionRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDefinition669); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:349:1: ruleVariableDefinition : ( ( rule__VariableDefinition__Group__0 ) ) ;
    public final void ruleVariableDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:353:2: ( ( ( rule__VariableDefinition__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:354:1: ( ( rule__VariableDefinition__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:354:1: ( ( rule__VariableDefinition__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:355:1: ( rule__VariableDefinition__Group__0 )
            {
             before(grammarAccess.getVariableDefinitionAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:356:1: ( rule__VariableDefinition__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:356:2: rule__VariableDefinition__Group__0
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group__0_in_ruleVariableDefinition695);
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


    // $ANTLR start "entryRuleVariableEntity"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:368:1: entryRuleVariableEntity : ruleVariableEntity EOF ;
    public final void entryRuleVariableEntity() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:369:1: ( ruleVariableEntity EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:370:1: ruleVariableEntity EOF
            {
             before(grammarAccess.getVariableEntityRule()); 
            pushFollow(FOLLOW_ruleVariableEntity_in_entryRuleVariableEntity722);
            ruleVariableEntity();

            state._fsp--;

             after(grammarAccess.getVariableEntityRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableEntity729); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:377:1: ruleVariableEntity : ( ( rule__VariableEntity__NameAssignment ) ) ;
    public final void ruleVariableEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:381:2: ( ( ( rule__VariableEntity__NameAssignment ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:382:1: ( ( rule__VariableEntity__NameAssignment ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:382:1: ( ( rule__VariableEntity__NameAssignment ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:383:1: ( rule__VariableEntity__NameAssignment )
            {
             before(grammarAccess.getVariableEntityAccess().getNameAssignment()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:384:1: ( rule__VariableEntity__NameAssignment )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:384:2: rule__VariableEntity__NameAssignment
            {
            pushFollow(FOLLOW_rule__VariableEntity__NameAssignment_in_ruleVariableEntity755);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:396:1: entryRuleTest : ruleTest EOF ;
    public final void entryRuleTest() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:397:1: ( ruleTest EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:398:1: ruleTest EOF
            {
             before(grammarAccess.getTestRule()); 
            pushFollow(FOLLOW_ruleTest_in_entryRuleTest782);
            ruleTest();

            state._fsp--;

             after(grammarAccess.getTestRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTest789); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:405:1: ruleTest : ( ( rule__Test__Group__0 ) ) ;
    public final void ruleTest() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:409:2: ( ( ( rule__Test__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:410:1: ( ( rule__Test__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:410:1: ( ( rule__Test__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:411:1: ( rule__Test__Group__0 )
            {
             before(grammarAccess.getTestAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:412:1: ( rule__Test__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:412:2: rule__Test__Group__0
            {
            pushFollow(FOLLOW_rule__Test__Group__0_in_ruleTest815);
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


    // $ANTLR start "entryRuleCall"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:424:1: entryRuleCall : ruleCall EOF ;
    public final void entryRuleCall() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:425:1: ( ruleCall EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:426:1: ruleCall EOF
            {
             before(grammarAccess.getCallRule()); 
            pushFollow(FOLLOW_ruleCall_in_entryRuleCall842);
            ruleCall();

            state._fsp--;

             after(grammarAccess.getCallRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCall849); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:433:1: ruleCall : ( ( rule__Call__Group__0 ) ) ;
    public final void ruleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:437:2: ( ( ( rule__Call__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:438:1: ( ( rule__Call__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:438:1: ( ( rule__Call__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:439:1: ( rule__Call__Group__0 )
            {
             before(grammarAccess.getCallAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:440:1: ( rule__Call__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:440:2: rule__Call__Group__0
            {
            pushFollow(FOLLOW_rule__Call__Group__0_in_ruleCall875);
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


    // $ANTLR start "entryRuleSuite"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:452:1: entryRuleSuite : ruleSuite EOF ;
    public final void entryRuleSuite() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:453:1: ( ruleSuite EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:454:1: ruleSuite EOF
            {
             before(grammarAccess.getSuiteRule()); 
            pushFollow(FOLLOW_ruleSuite_in_entryRuleSuite902);
            ruleSuite();

            state._fsp--;

             after(grammarAccess.getSuiteRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuite909); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:461:1: ruleSuite : ( ( rule__Suite__Group__0 ) ) ;
    public final void ruleSuite() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:465:2: ( ( ( rule__Suite__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:466:1: ( ( rule__Suite__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:466:1: ( ( rule__Suite__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:467:1: ( rule__Suite__Group__0 )
            {
             before(grammarAccess.getSuiteAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:468:1: ( rule__Suite__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:468:2: rule__Suite__Group__0
            {
            pushFollow(FOLLOW_rule__Suite__Group__0_in_ruleSuite935);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:480:1: entryRuleSuiteParameter : ruleSuiteParameter EOF ;
    public final void entryRuleSuiteParameter() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:481:1: ( ruleSuiteParameter EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:482:1: ruleSuiteParameter EOF
            {
             before(grammarAccess.getSuiteParameterRule()); 
            pushFollow(FOLLOW_ruleSuiteParameter_in_entryRuleSuiteParameter962);
            ruleSuiteParameter();

            state._fsp--;

             after(grammarAccess.getSuiteParameterRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteParameter969); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:489:1: ruleSuiteParameter : ( ( rule__SuiteParameter__Group__0 ) ) ;
    public final void ruleSuiteParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:493:2: ( ( ( rule__SuiteParameter__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:494:1: ( ( rule__SuiteParameter__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:494:1: ( ( rule__SuiteParameter__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:495:1: ( rule__SuiteParameter__Group__0 )
            {
             before(grammarAccess.getSuiteParameterAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:496:1: ( rule__SuiteParameter__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:496:2: rule__SuiteParameter__Group__0
            {
            pushFollow(FOLLOW_rule__SuiteParameter__Group__0_in_ruleSuiteParameter995);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:508:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:509:1: ( ruleParameter EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:510:1: ruleParameter EOF
            {
             before(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter1022);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getParameterRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter1029); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:517:1: ruleParameter : ( ( rule__Parameter__Group__0 ) ) ;
    public final void ruleParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:521:2: ( ( ( rule__Parameter__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:522:1: ( ( rule__Parameter__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:522:1: ( ( rule__Parameter__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:523:1: ( rule__Parameter__Group__0 )
            {
             before(grammarAccess.getParameterAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:524:1: ( rule__Parameter__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:524:2: rule__Parameter__Group__0
            {
            pushFollow(FOLLOW_rule__Parameter__Group__0_in_ruleParameter1055);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:536:1: entryRuleParameterName : ruleParameterName EOF ;
    public final void entryRuleParameterName() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:537:1: ( ruleParameterName EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:538:1: ruleParameterName EOF
            {
             before(grammarAccess.getParameterNameRule()); 
            pushFollow(FOLLOW_ruleParameterName_in_entryRuleParameterName1082);
            ruleParameterName();

            state._fsp--;

             after(grammarAccess.getParameterNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterName1089); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:545:1: ruleParameterName : ( ( rule__ParameterName__Alternatives ) ) ;
    public final void ruleParameterName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:549:2: ( ( ( rule__ParameterName__Alternatives ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:550:1: ( ( rule__ParameterName__Alternatives ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:550:1: ( ( rule__ParameterName__Alternatives ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:551:1: ( rule__ParameterName__Alternatives )
            {
             before(grammarAccess.getParameterNameAccess().getAlternatives()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:552:1: ( rule__ParameterName__Alternatives )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:552:2: rule__ParameterName__Alternatives
            {
            pushFollow(FOLLOW_rule__ParameterName__Alternatives_in_ruleParameterName1115);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:564:1: entryRuleFixedParameterName : ruleFixedParameterName EOF ;
    public final void entryRuleFixedParameterName() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:565:1: ( ruleFixedParameterName EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:566:1: ruleFixedParameterName EOF
            {
             before(grammarAccess.getFixedParameterNameRule()); 
            pushFollow(FOLLOW_ruleFixedParameterName_in_entryRuleFixedParameterName1142);
            ruleFixedParameterName();

            state._fsp--;

             after(grammarAccess.getFixedParameterNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFixedParameterName1149); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:573:1: ruleFixedParameterName : ( ( rule__FixedParameterName__AnnotationAssignment ) ) ;
    public final void ruleFixedParameterName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:577:2: ( ( ( rule__FixedParameterName__AnnotationAssignment ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:578:1: ( ( rule__FixedParameterName__AnnotationAssignment ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:578:1: ( ( rule__FixedParameterName__AnnotationAssignment ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:579:1: ( rule__FixedParameterName__AnnotationAssignment )
            {
             before(grammarAccess.getFixedParameterNameAccess().getAnnotationAssignment()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:580:1: ( rule__FixedParameterName__AnnotationAssignment )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:580:2: rule__FixedParameterName__AnnotationAssignment
            {
            pushFollow(FOLLOW_rule__FixedParameterName__AnnotationAssignment_in_ruleFixedParameterName1175);
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


    // $ANTLR start "entryRuleArbitraryParameterName"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:592:1: entryRuleArbitraryParameterName : ruleArbitraryParameterName EOF ;
    public final void entryRuleArbitraryParameterName() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:593:1: ( ruleArbitraryParameterName EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:594:1: ruleArbitraryParameterName EOF
            {
             before(grammarAccess.getArbitraryParameterNameRule()); 
            pushFollow(FOLLOW_ruleArbitraryParameterName_in_entryRuleArbitraryParameterName1202);
            ruleArbitraryParameterName();

            state._fsp--;

             after(grammarAccess.getArbitraryParameterNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArbitraryParameterName1209); 

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
    // $ANTLR end "entryRuleArbitraryParameterName"


    // $ANTLR start "ruleArbitraryParameterName"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:601:1: ruleArbitraryParameterName : ( ( rule__ArbitraryParameterName__Group__0 ) ) ;
    public final void ruleArbitraryParameterName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:605:2: ( ( ( rule__ArbitraryParameterName__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:606:1: ( ( rule__ArbitraryParameterName__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:606:1: ( ( rule__ArbitraryParameterName__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:607:1: ( rule__ArbitraryParameterName__Group__0 )
            {
             before(grammarAccess.getArbitraryParameterNameAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:608:1: ( rule__ArbitraryParameterName__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:608:2: rule__ArbitraryParameterName__Group__0
            {
            pushFollow(FOLLOW_rule__ArbitraryParameterName__Group__0_in_ruleArbitraryParameterName1235);
            rule__ArbitraryParameterName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getArbitraryParameterNameAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleArbitraryParameterName"


    // $ANTLR start "entryRuleValueOrEnumValue"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:620:1: entryRuleValueOrEnumValue : ruleValueOrEnumValue EOF ;
    public final void entryRuleValueOrEnumValue() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:621:1: ( ruleValueOrEnumValue EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:622:1: ruleValueOrEnumValue EOF
            {
             before(grammarAccess.getValueOrEnumValueRule()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_entryRuleValueOrEnumValue1262);
            ruleValueOrEnumValue();

            state._fsp--;

             after(grammarAccess.getValueOrEnumValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueOrEnumValue1269); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:629:1: ruleValueOrEnumValue : ( ( rule__ValueOrEnumValue__Alternatives ) ) ;
    public final void ruleValueOrEnumValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:633:2: ( ( ( rule__ValueOrEnumValue__Alternatives ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:634:1: ( ( rule__ValueOrEnumValue__Alternatives ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:634:1: ( ( rule__ValueOrEnumValue__Alternatives ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:635:1: ( rule__ValueOrEnumValue__Alternatives )
            {
             before(grammarAccess.getValueOrEnumValueAccess().getAlternatives()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:636:1: ( rule__ValueOrEnumValue__Alternatives )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:636:2: rule__ValueOrEnumValue__Alternatives
            {
            pushFollow(FOLLOW_rule__ValueOrEnumValue__Alternatives_in_ruleValueOrEnumValue1295);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:648:1: entryRuleValue : ruleValue EOF ;
    public final void entryRuleValue() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:649:1: ( ruleValue EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:650:1: ruleValue EOF
            {
             before(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue1322);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue1329); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:657:1: ruleValue : ( ( rule__Value__Alternatives ) ) ;
    public final void ruleValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:661:2: ( ( ( rule__Value__Alternatives ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:662:1: ( ( rule__Value__Alternatives ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:662:1: ( ( rule__Value__Alternatives ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:663:1: ( rule__Value__Alternatives )
            {
             before(grammarAccess.getValueAccess().getAlternatives()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:664:1: ( rule__Value__Alternatives )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:664:2: rule__Value__Alternatives
            {
            pushFollow(FOLLOW_rule__Value__Alternatives_in_ruleValue1355);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:676:1: entryRuleIntegerValue : ruleIntegerValue EOF ;
    public final void entryRuleIntegerValue() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:677:1: ( ruleIntegerValue EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:678:1: ruleIntegerValue EOF
            {
             before(grammarAccess.getIntegerValueRule()); 
            pushFollow(FOLLOW_ruleIntegerValue_in_entryRuleIntegerValue1382);
            ruleIntegerValue();

            state._fsp--;

             after(grammarAccess.getIntegerValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerValue1389); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:685:1: ruleIntegerValue : ( ( rule__IntegerValue__IntegerValueAssignment ) ) ;
    public final void ruleIntegerValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:689:2: ( ( ( rule__IntegerValue__IntegerValueAssignment ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:690:1: ( ( rule__IntegerValue__IntegerValueAssignment ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:690:1: ( ( rule__IntegerValue__IntegerValueAssignment ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:691:1: ( rule__IntegerValue__IntegerValueAssignment )
            {
             before(grammarAccess.getIntegerValueAccess().getIntegerValueAssignment()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:692:1: ( rule__IntegerValue__IntegerValueAssignment )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:692:2: rule__IntegerValue__IntegerValueAssignment
            {
            pushFollow(FOLLOW_rule__IntegerValue__IntegerValueAssignment_in_ruleIntegerValue1415);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:704:1: entryRuleDecimalValue : ruleDecimalValue EOF ;
    public final void entryRuleDecimalValue() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:705:1: ( ruleDecimalValue EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:706:1: ruleDecimalValue EOF
            {
             before(grammarAccess.getDecimalValueRule()); 
            pushFollow(FOLLOW_ruleDecimalValue_in_entryRuleDecimalValue1442);
            ruleDecimalValue();

            state._fsp--;

             after(grammarAccess.getDecimalValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalValue1449); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:713:1: ruleDecimalValue : ( ( rule__DecimalValue__DecimalValueAssignment ) ) ;
    public final void ruleDecimalValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:717:2: ( ( ( rule__DecimalValue__DecimalValueAssignment ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:718:1: ( ( rule__DecimalValue__DecimalValueAssignment ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:718:1: ( ( rule__DecimalValue__DecimalValueAssignment ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:719:1: ( rule__DecimalValue__DecimalValueAssignment )
            {
             before(grammarAccess.getDecimalValueAccess().getDecimalValueAssignment()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:720:1: ( rule__DecimalValue__DecimalValueAssignment )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:720:2: rule__DecimalValue__DecimalValueAssignment
            {
            pushFollow(FOLLOW_rule__DecimalValue__DecimalValueAssignment_in_ruleDecimalValue1475);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:732:1: entryRuleStringValue : ruleStringValue EOF ;
    public final void entryRuleStringValue() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:733:1: ( ruleStringValue EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:734:1: ruleStringValue EOF
            {
             before(grammarAccess.getStringValueRule()); 
            pushFollow(FOLLOW_ruleStringValue_in_entryRuleStringValue1502);
            ruleStringValue();

            state._fsp--;

             after(grammarAccess.getStringValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringValue1509); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:741:1: ruleStringValue : ( ( rule__StringValue__StringValueAssignment ) ) ;
    public final void ruleStringValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:745:2: ( ( ( rule__StringValue__StringValueAssignment ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:746:1: ( ( rule__StringValue__StringValueAssignment ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:746:1: ( ( rule__StringValue__StringValueAssignment ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:747:1: ( rule__StringValue__StringValueAssignment )
            {
             before(grammarAccess.getStringValueAccess().getStringValueAssignment()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:748:1: ( rule__StringValue__StringValueAssignment )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:748:2: rule__StringValue__StringValueAssignment
            {
            pushFollow(FOLLOW_rule__StringValue__StringValueAssignment_in_ruleStringValue1535);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:760:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:761:1: ( ruleVariable EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:762:1: ruleVariable EOF
            {
             before(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable1562);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getVariableRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable1569); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:769:1: ruleVariable : ( ( rule__Variable__NameAssignment ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:773:2: ( ( ( rule__Variable__NameAssignment ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:774:1: ( ( rule__Variable__NameAssignment ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:774:1: ( ( rule__Variable__NameAssignment ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:775:1: ( rule__Variable__NameAssignment )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:776:1: ( rule__Variable__NameAssignment )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:776:2: rule__Variable__NameAssignment
            {
            pushFollow(FOLLOW_rule__Variable__NameAssignment_in_ruleVariable1595);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:788:1: entryRuleEnumValue : ruleEnumValue EOF ;
    public final void entryRuleEnumValue() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:789:1: ( ruleEnumValue EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:790:1: ruleEnumValue EOF
            {
             before(grammarAccess.getEnumValueRule()); 
            pushFollow(FOLLOW_ruleEnumValue_in_entryRuleEnumValue1622);
            ruleEnumValue();

            state._fsp--;

             after(grammarAccess.getEnumValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumValue1629); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:797:1: ruleEnumValue : ( ( rule__EnumValue__EnumValueAssignment ) ) ;
    public final void ruleEnumValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:801:2: ( ( ( rule__EnumValue__EnumValueAssignment ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:802:1: ( ( rule__EnumValue__EnumValueAssignment ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:802:1: ( ( rule__EnumValue__EnumValueAssignment ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:803:1: ( rule__EnumValue__EnumValueAssignment )
            {
             before(grammarAccess.getEnumValueAccess().getEnumValueAssignment()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:804:1: ( rule__EnumValue__EnumValueAssignment )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:804:2: rule__EnumValue__EnumValueAssignment
            {
            pushFollow(FOLLOW_rule__EnumValue__EnumValueAssignment_in_ruleEnumValue1655);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:816:1: entryRuleMethodReference : ruleMethodReference EOF ;
    public final void entryRuleMethodReference() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:817:1: ( ruleMethodReference EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:818:1: ruleMethodReference EOF
            {
             before(grammarAccess.getMethodReferenceRule()); 
            pushFollow(FOLLOW_ruleMethodReference_in_entryRuleMethodReference1682);
            ruleMethodReference();

            state._fsp--;

             after(grammarAccess.getMethodReferenceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodReference1689); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:825:1: ruleMethodReference : ( ( rule__MethodReference__Group__0 ) ) ;
    public final void ruleMethodReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:829:2: ( ( ( rule__MethodReference__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:830:1: ( ( rule__MethodReference__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:830:1: ( ( rule__MethodReference__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:831:1: ( rule__MethodReference__Group__0 )
            {
             before(grammarAccess.getMethodReferenceAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:832:1: ( rule__MethodReference__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:832:2: rule__MethodReference__Group__0
            {
            pushFollow(FOLLOW_rule__MethodReference__Group__0_in_ruleMethodReference1715);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:844:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:845:1: ( ruleQualifiedName EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:846:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1742);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName1749); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:853:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:857:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:858:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:858:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:859:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:860:1: ( rule__QualifiedName__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:860:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName1775);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:872:1: entryRuleQualifiedJavaClassName : ruleQualifiedJavaClassName EOF ;
    public final void entryRuleQualifiedJavaClassName() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:873:1: ( ruleQualifiedJavaClassName EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:874:1: ruleQualifiedJavaClassName EOF
            {
             before(grammarAccess.getQualifiedJavaClassNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_entryRuleQualifiedJavaClassName1802);
            ruleQualifiedJavaClassName();

            state._fsp--;

             after(grammarAccess.getQualifiedJavaClassNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedJavaClassName1809); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:881:1: ruleQualifiedJavaClassName : ( ( rule__QualifiedJavaClassName__Group__0 ) ) ;
    public final void ruleQualifiedJavaClassName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:885:2: ( ( ( rule__QualifiedJavaClassName__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:886:1: ( ( rule__QualifiedJavaClassName__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:886:1: ( ( rule__QualifiedJavaClassName__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:887:1: ( rule__QualifiedJavaClassName__Group__0 )
            {
             before(grammarAccess.getQualifiedJavaClassNameAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:888:1: ( rule__QualifiedJavaClassName__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:888:2: rule__QualifiedJavaClassName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__0_in_ruleQualifiedJavaClassName1835);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:900:1: entryRuleQualifiedNameWithWildcard : ruleQualifiedNameWithWildcard EOF ;
    public final void entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:901:1: ( ruleQualifiedNameWithWildcard EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:902:1: ruleQualifiedNameWithWildcard EOF
            {
             before(grammarAccess.getQualifiedNameWithWildcardRule()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard1862);
            ruleQualifiedNameWithWildcard();

            state._fsp--;

             after(grammarAccess.getQualifiedNameWithWildcardRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard1869); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:909:1: ruleQualifiedNameWithWildcard : ( ( rule__QualifiedNameWithWildcard__Group__0 ) ) ;
    public final void ruleQualifiedNameWithWildcard() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:913:2: ( ( ( rule__QualifiedNameWithWildcard__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:914:1: ( ( rule__QualifiedNameWithWildcard__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:914:1: ( ( rule__QualifiedNameWithWildcard__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:915:1: ( rule__QualifiedNameWithWildcard__Group__0 )
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:916:1: ( rule__QualifiedNameWithWildcard__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:916:2: rule__QualifiedNameWithWildcard__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__0_in_ruleQualifiedNameWithWildcard1895);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:928:1: rule__Statement__Alternatives : ( ( rulePackageDefinition ) | ( ruleImport ) | ( ruleSuite ) );
    public final void rule__Statement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:932:1: ( ( rulePackageDefinition ) | ( ruleImport ) | ( ruleSuite ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 13:
                {
                alt2=1;
                }
                break;
            case 16:
                {
                alt2=2;
                }
                break;
            case 31:
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
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:933:1: ( rulePackageDefinition )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:933:1: ( rulePackageDefinition )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:934:1: rulePackageDefinition
                    {
                     before(grammarAccess.getStatementAccess().getPackageDefinitionParserRuleCall_0()); 
                    pushFollow(FOLLOW_rulePackageDefinition_in_rule__Statement__Alternatives1931);
                    rulePackageDefinition();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getPackageDefinitionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:939:6: ( ruleImport )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:939:6: ( ruleImport )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:940:1: ruleImport
                    {
                     before(grammarAccess.getStatementAccess().getImportParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleImport_in_rule__Statement__Alternatives1948);
                    ruleImport();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getImportParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:945:6: ( ruleSuite )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:945:6: ( ruleSuite )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:946:1: ruleSuite
                    {
                     before(grammarAccess.getStatementAccess().getSuiteParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleSuite_in_rule__Statement__Alternatives1965);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:956:1: rule__PackageStatement__Alternatives : ( ( ruleImport ) | ( ruleTestDefinition ) | ( ruleCallDefinition ) | ( ruleSuiteDefinition ) | ( ruleVariableDefinition ) );
    public final void rule__PackageStatement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:960:1: ( ( ruleImport ) | ( ruleTestDefinition ) | ( ruleCallDefinition ) | ( ruleSuiteDefinition ) | ( ruleVariableDefinition ) )
            int alt3=5;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt3=1;
                }
                break;
            case 17:
                {
                alt3=2;
                }
                break;
            case 19:
                {
                alt3=3;
                }
                break;
            case 20:
                {
                alt3=4;
                }
                break;
            case 25:
                {
                alt3=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:961:1: ( ruleImport )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:961:1: ( ruleImport )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:962:1: ruleImport
                    {
                     before(grammarAccess.getPackageStatementAccess().getImportParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleImport_in_rule__PackageStatement__Alternatives1997);
                    ruleImport();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getImportParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:967:6: ( ruleTestDefinition )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:967:6: ( ruleTestDefinition )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:968:1: ruleTestDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getTestDefinitionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleTestDefinition_in_rule__PackageStatement__Alternatives2014);
                    ruleTestDefinition();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getTestDefinitionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:973:6: ( ruleCallDefinition )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:973:6: ( ruleCallDefinition )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:974:1: ruleCallDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getCallDefinitionParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleCallDefinition_in_rule__PackageStatement__Alternatives2031);
                    ruleCallDefinition();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getCallDefinitionParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:979:6: ( ruleSuiteDefinition )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:979:6: ( ruleSuiteDefinition )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:980:1: ruleSuiteDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getSuiteDefinitionParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleSuiteDefinition_in_rule__PackageStatement__Alternatives2048);
                    ruleSuiteDefinition();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getSuiteDefinitionParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:985:6: ( ruleVariableDefinition )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:985:6: ( ruleVariableDefinition )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:986:1: ruleVariableDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getVariableDefinitionParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleVariableDefinition_in_rule__PackageStatement__Alternatives2065);
                    ruleVariableDefinition();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getVariableDefinitionParserRuleCall_4()); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:996:1: rule__SuiteStatement__Alternatives : ( ( ruleSuiteStatementWithResult ) | ( ruleCall ) | ( ruleVariableDefinition ) );
    public final void rule__SuiteStatement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1000:1: ( ( ruleSuiteStatementWithResult ) | ( ruleCall ) | ( ruleVariableDefinition ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 27:
            case 31:
                {
                alt4=1;
                }
                break;
            case 29:
                {
                alt4=2;
                }
                break;
            case 25:
                {
                alt4=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1001:1: ( ruleSuiteStatementWithResult )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1001:1: ( ruleSuiteStatementWithResult )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1002:1: ruleSuiteStatementWithResult
                    {
                     before(grammarAccess.getSuiteStatementAccess().getSuiteStatementWithResultParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSuiteStatementWithResult_in_rule__SuiteStatement__Alternatives2097);
                    ruleSuiteStatementWithResult();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementAccess().getSuiteStatementWithResultParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1007:6: ( ruleCall )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1007:6: ( ruleCall )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1008:1: ruleCall
                    {
                     before(grammarAccess.getSuiteStatementAccess().getCallParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleCall_in_rule__SuiteStatement__Alternatives2114);
                    ruleCall();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementAccess().getCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1013:6: ( ruleVariableDefinition )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1013:6: ( ruleVariableDefinition )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1014:1: ruleVariableDefinition
                    {
                     before(grammarAccess.getSuiteStatementAccess().getVariableDefinitionParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleVariableDefinition_in_rule__SuiteStatement__Alternatives2131);
                    ruleVariableDefinition();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementAccess().getVariableDefinitionParserRuleCall_2()); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1024:1: rule__SuiteStatementWithResult__Alternatives : ( ( ruleSuite ) | ( ruleTest ) );
    public final void rule__SuiteStatementWithResult__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1028:1: ( ( ruleSuite ) | ( ruleTest ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==31) ) {
                alt5=1;
            }
            else if ( (LA5_0==27) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1029:1: ( ruleSuite )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1029:1: ( ruleSuite )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1030:1: ruleSuite
                    {
                     before(grammarAccess.getSuiteStatementWithResultAccess().getSuiteParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSuite_in_rule__SuiteStatementWithResult__Alternatives2163);
                    ruleSuite();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementWithResultAccess().getSuiteParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1035:6: ( ruleTest )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1035:6: ( ruleTest )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1036:1: ruleTest
                    {
                     before(grammarAccess.getSuiteStatementWithResultAccess().getTestParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleTest_in_rule__SuiteStatementWithResult__Alternatives2180);
                    ruleTest();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementWithResultAccess().getTestParserRuleCall_1()); 

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


    // $ANTLR start "rule__ParameterName__Alternatives"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1046:1: rule__ParameterName__Alternatives : ( ( ruleFixedParameterName ) | ( ruleArbitraryParameterName ) );
    public final void rule__ParameterName__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1050:1: ( ( ruleFixedParameterName ) | ( ruleArbitraryParameterName ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID) ) {
                alt6=1;
            }
            else if ( (LA6_0==33) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1051:1: ( ruleFixedParameterName )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1051:1: ( ruleFixedParameterName )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1052:1: ruleFixedParameterName
                    {
                     before(grammarAccess.getParameterNameAccess().getFixedParameterNameParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleFixedParameterName_in_rule__ParameterName__Alternatives2212);
                    ruleFixedParameterName();

                    state._fsp--;

                     after(grammarAccess.getParameterNameAccess().getFixedParameterNameParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1057:6: ( ruleArbitraryParameterName )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1057:6: ( ruleArbitraryParameterName )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1058:1: ruleArbitraryParameterName
                    {
                     before(grammarAccess.getParameterNameAccess().getArbitraryParameterNameParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleArbitraryParameterName_in_rule__ParameterName__Alternatives2229);
                    ruleArbitraryParameterName();

                    state._fsp--;

                     after(grammarAccess.getParameterNameAccess().getArbitraryParameterNameParserRuleCall_1()); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1068:1: rule__ValueOrEnumValue__Alternatives : ( ( ruleValue ) | ( ruleEnumValue ) );
    public final void rule__ValueOrEnumValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1072:1: ( ( ruleValue ) | ( ruleEnumValue ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID||(LA7_0>=RULE_INTEGER && LA7_0<=RULE_STRING)) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_UPPERCASE_ID) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1073:1: ( ruleValue )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1073:1: ( ruleValue )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1074:1: ruleValue
                    {
                     before(grammarAccess.getValueOrEnumValueAccess().getValueParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleValue_in_rule__ValueOrEnumValue__Alternatives2261);
                    ruleValue();

                    state._fsp--;

                     after(grammarAccess.getValueOrEnumValueAccess().getValueParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1079:6: ( ruleEnumValue )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1079:6: ( ruleEnumValue )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1080:1: ruleEnumValue
                    {
                     before(grammarAccess.getValueOrEnumValueAccess().getEnumValueParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleEnumValue_in_rule__ValueOrEnumValue__Alternatives2278);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1090:1: rule__Value__Alternatives : ( ( ruleStringValue ) | ( ruleIntegerValue ) | ( ruleDecimalValue ) | ( ruleVariable ) );
    public final void rule__Value__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1094:1: ( ( ruleStringValue ) | ( ruleIntegerValue ) | ( ruleDecimalValue ) | ( ruleVariable ) )
            int alt8=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt8=1;
                }
                break;
            case RULE_INTEGER:
                {
                alt8=2;
                }
                break;
            case RULE_DECIMAL:
                {
                alt8=3;
                }
                break;
            case RULE_ID:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1095:1: ( ruleStringValue )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1095:1: ( ruleStringValue )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1096:1: ruleStringValue
                    {
                     before(grammarAccess.getValueAccess().getStringValueParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleStringValue_in_rule__Value__Alternatives2310);
                    ruleStringValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getStringValueParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1101:6: ( ruleIntegerValue )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1101:6: ( ruleIntegerValue )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1102:1: ruleIntegerValue
                    {
                     before(grammarAccess.getValueAccess().getIntegerValueParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleIntegerValue_in_rule__Value__Alternatives2327);
                    ruleIntegerValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getIntegerValueParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1107:6: ( ruleDecimalValue )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1107:6: ( ruleDecimalValue )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1108:1: ruleDecimalValue
                    {
                     before(grammarAccess.getValueAccess().getDecimalValueParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleDecimalValue_in_rule__Value__Alternatives2344);
                    ruleDecimalValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getDecimalValueParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1113:6: ( ruleVariable )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1113:6: ( ruleVariable )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1114:1: ruleVariable
                    {
                     before(grammarAccess.getValueAccess().getVariableParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleVariable_in_rule__Value__Alternatives2361);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1126:1: rule__PackageDefinition__Group__0 : rule__PackageDefinition__Group__0__Impl rule__PackageDefinition__Group__1 ;
    public final void rule__PackageDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1130:1: ( rule__PackageDefinition__Group__0__Impl rule__PackageDefinition__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1131:2: rule__PackageDefinition__Group__0__Impl rule__PackageDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__0__Impl_in_rule__PackageDefinition__Group__02391);
            rule__PackageDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDefinition__Group__1_in_rule__PackageDefinition__Group__02394);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1138:1: rule__PackageDefinition__Group__0__Impl : ( 'packagedef' ) ;
    public final void rule__PackageDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1142:1: ( ( 'packagedef' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1143:1: ( 'packagedef' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1143:1: ( 'packagedef' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1144:1: 'packagedef'
            {
             before(grammarAccess.getPackageDefinitionAccess().getPackagedefKeyword_0()); 
            match(input,13,FOLLOW_13_in_rule__PackageDefinition__Group__0__Impl2422); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1157:1: rule__PackageDefinition__Group__1 : rule__PackageDefinition__Group__1__Impl rule__PackageDefinition__Group__2 ;
    public final void rule__PackageDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1161:1: ( rule__PackageDefinition__Group__1__Impl rule__PackageDefinition__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1162:2: rule__PackageDefinition__Group__1__Impl rule__PackageDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__1__Impl_in_rule__PackageDefinition__Group__12453);
            rule__PackageDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDefinition__Group__2_in_rule__PackageDefinition__Group__12456);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1169:1: rule__PackageDefinition__Group__1__Impl : ( ( rule__PackageDefinition__NameAssignment_1 ) ) ;
    public final void rule__PackageDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1173:1: ( ( ( rule__PackageDefinition__NameAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1174:1: ( ( rule__PackageDefinition__NameAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1174:1: ( ( rule__PackageDefinition__NameAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1175:1: ( rule__PackageDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getPackageDefinitionAccess().getNameAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1176:1: ( rule__PackageDefinition__NameAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1176:2: rule__PackageDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__PackageDefinition__NameAssignment_1_in_rule__PackageDefinition__Group__1__Impl2483);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1186:1: rule__PackageDefinition__Group__2 : rule__PackageDefinition__Group__2__Impl rule__PackageDefinition__Group__3 ;
    public final void rule__PackageDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1190:1: ( rule__PackageDefinition__Group__2__Impl rule__PackageDefinition__Group__3 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1191:2: rule__PackageDefinition__Group__2__Impl rule__PackageDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__2__Impl_in_rule__PackageDefinition__Group__22513);
            rule__PackageDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDefinition__Group__3_in_rule__PackageDefinition__Group__22516);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1198:1: rule__PackageDefinition__Group__2__Impl : ( 'with' ) ;
    public final void rule__PackageDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1202:1: ( ( 'with' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1203:1: ( 'with' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1203:1: ( 'with' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1204:1: 'with'
            {
             before(grammarAccess.getPackageDefinitionAccess().getWithKeyword_2()); 
            match(input,14,FOLLOW_14_in_rule__PackageDefinition__Group__2__Impl2544); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1217:1: rule__PackageDefinition__Group__3 : rule__PackageDefinition__Group__3__Impl rule__PackageDefinition__Group__4 ;
    public final void rule__PackageDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1221:1: ( rule__PackageDefinition__Group__3__Impl rule__PackageDefinition__Group__4 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1222:2: rule__PackageDefinition__Group__3__Impl rule__PackageDefinition__Group__4
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__3__Impl_in_rule__PackageDefinition__Group__32575);
            rule__PackageDefinition__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDefinition__Group__4_in_rule__PackageDefinition__Group__32578);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1229:1: rule__PackageDefinition__Group__3__Impl : ( ( rule__PackageDefinition__StatementsAssignment_3 )* ) ;
    public final void rule__PackageDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1233:1: ( ( ( rule__PackageDefinition__StatementsAssignment_3 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1234:1: ( ( rule__PackageDefinition__StatementsAssignment_3 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1234:1: ( ( rule__PackageDefinition__StatementsAssignment_3 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1235:1: ( rule__PackageDefinition__StatementsAssignment_3 )*
            {
             before(grammarAccess.getPackageDefinitionAccess().getStatementsAssignment_3()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1236:1: ( rule__PackageDefinition__StatementsAssignment_3 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( ((LA9_0>=16 && LA9_0<=17)||(LA9_0>=19 && LA9_0<=20)||LA9_0==25) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1236:2: rule__PackageDefinition__StatementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__PackageDefinition__StatementsAssignment_3_in_rule__PackageDefinition__Group__3__Impl2605);
            	    rule__PackageDefinition__StatementsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1246:1: rule__PackageDefinition__Group__4 : rule__PackageDefinition__Group__4__Impl ;
    public final void rule__PackageDefinition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1250:1: ( rule__PackageDefinition__Group__4__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1251:2: rule__PackageDefinition__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__4__Impl_in_rule__PackageDefinition__Group__42636);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1257:1: rule__PackageDefinition__Group__4__Impl : ( 'packageend' ) ;
    public final void rule__PackageDefinition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1261:1: ( ( 'packageend' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1262:1: ( 'packageend' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1262:1: ( 'packageend' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1263:1: 'packageend'
            {
             before(grammarAccess.getPackageDefinitionAccess().getPackageendKeyword_4()); 
            match(input,15,FOLLOW_15_in_rule__PackageDefinition__Group__4__Impl2664); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1286:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1290:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1291:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__02705);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__02708);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1298:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1302:1: ( ( 'import' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1303:1: ( 'import' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1303:1: ( 'import' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1304:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,16,FOLLOW_16_in_rule__Import__Group__0__Impl2736); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1317:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1321:1: ( rule__Import__Group__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1322:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__12767);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1328:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1332:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1333:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1333:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1334:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1335:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1335:2: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl2794);
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


    // $ANTLR start "rule__TestDefinition__Group__0"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1349:1: rule__TestDefinition__Group__0 : rule__TestDefinition__Group__0__Impl rule__TestDefinition__Group__1 ;
    public final void rule__TestDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1353:1: ( rule__TestDefinition__Group__0__Impl rule__TestDefinition__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1354:2: rule__TestDefinition__Group__0__Impl rule__TestDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__TestDefinition__Group__0__Impl_in_rule__TestDefinition__Group__02828);
            rule__TestDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TestDefinition__Group__1_in_rule__TestDefinition__Group__02831);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1361:1: rule__TestDefinition__Group__0__Impl : ( 'testdef' ) ;
    public final void rule__TestDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1365:1: ( ( 'testdef' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1366:1: ( 'testdef' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1366:1: ( 'testdef' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1367:1: 'testdef'
            {
             before(grammarAccess.getTestDefinitionAccess().getTestdefKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__TestDefinition__Group__0__Impl2859); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1380:1: rule__TestDefinition__Group__1 : rule__TestDefinition__Group__1__Impl rule__TestDefinition__Group__2 ;
    public final void rule__TestDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1384:1: ( rule__TestDefinition__Group__1__Impl rule__TestDefinition__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1385:2: rule__TestDefinition__Group__1__Impl rule__TestDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__TestDefinition__Group__1__Impl_in_rule__TestDefinition__Group__12890);
            rule__TestDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TestDefinition__Group__2_in_rule__TestDefinition__Group__12893);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1392:1: rule__TestDefinition__Group__1__Impl : ( ( rule__TestDefinition__NameAssignment_1 ) ) ;
    public final void rule__TestDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1396:1: ( ( ( rule__TestDefinition__NameAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1397:1: ( ( rule__TestDefinition__NameAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1397:1: ( ( rule__TestDefinition__NameAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1398:1: ( rule__TestDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getTestDefinitionAccess().getNameAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1399:1: ( rule__TestDefinition__NameAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1399:2: rule__TestDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__TestDefinition__NameAssignment_1_in_rule__TestDefinition__Group__1__Impl2920);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1409:1: rule__TestDefinition__Group__2 : rule__TestDefinition__Group__2__Impl rule__TestDefinition__Group__3 ;
    public final void rule__TestDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1413:1: ( rule__TestDefinition__Group__2__Impl rule__TestDefinition__Group__3 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1414:2: rule__TestDefinition__Group__2__Impl rule__TestDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__TestDefinition__Group__2__Impl_in_rule__TestDefinition__Group__22950);
            rule__TestDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TestDefinition__Group__3_in_rule__TestDefinition__Group__22953);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1421:1: rule__TestDefinition__Group__2__Impl : ( 'uses' ) ;
    public final void rule__TestDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1425:1: ( ( 'uses' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1426:1: ( 'uses' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1426:1: ( 'uses' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1427:1: 'uses'
            {
             before(grammarAccess.getTestDefinitionAccess().getUsesKeyword_2()); 
            match(input,18,FOLLOW_18_in_rule__TestDefinition__Group__2__Impl2981); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1440:1: rule__TestDefinition__Group__3 : rule__TestDefinition__Group__3__Impl ;
    public final void rule__TestDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1444:1: ( rule__TestDefinition__Group__3__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1445:2: rule__TestDefinition__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__TestDefinition__Group__3__Impl_in_rule__TestDefinition__Group__33012);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1451:1: rule__TestDefinition__Group__3__Impl : ( ( rule__TestDefinition__FixtureMethodAssignment_3 ) ) ;
    public final void rule__TestDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1455:1: ( ( ( rule__TestDefinition__FixtureMethodAssignment_3 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1456:1: ( ( rule__TestDefinition__FixtureMethodAssignment_3 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1456:1: ( ( rule__TestDefinition__FixtureMethodAssignment_3 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1457:1: ( rule__TestDefinition__FixtureMethodAssignment_3 )
            {
             before(grammarAccess.getTestDefinitionAccess().getFixtureMethodAssignment_3()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1458:1: ( rule__TestDefinition__FixtureMethodAssignment_3 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1458:2: rule__TestDefinition__FixtureMethodAssignment_3
            {
            pushFollow(FOLLOW_rule__TestDefinition__FixtureMethodAssignment_3_in_rule__TestDefinition__Group__3__Impl3039);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1476:1: rule__CallDefinition__Group__0 : rule__CallDefinition__Group__0__Impl rule__CallDefinition__Group__1 ;
    public final void rule__CallDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1480:1: ( rule__CallDefinition__Group__0__Impl rule__CallDefinition__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1481:2: rule__CallDefinition__Group__0__Impl rule__CallDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__CallDefinition__Group__0__Impl_in_rule__CallDefinition__Group__03077);
            rule__CallDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CallDefinition__Group__1_in_rule__CallDefinition__Group__03080);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1488:1: rule__CallDefinition__Group__0__Impl : ( 'calldef' ) ;
    public final void rule__CallDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1492:1: ( ( 'calldef' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1493:1: ( 'calldef' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1493:1: ( 'calldef' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1494:1: 'calldef'
            {
             before(grammarAccess.getCallDefinitionAccess().getCalldefKeyword_0()); 
            match(input,19,FOLLOW_19_in_rule__CallDefinition__Group__0__Impl3108); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1507:1: rule__CallDefinition__Group__1 : rule__CallDefinition__Group__1__Impl rule__CallDefinition__Group__2 ;
    public final void rule__CallDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1511:1: ( rule__CallDefinition__Group__1__Impl rule__CallDefinition__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1512:2: rule__CallDefinition__Group__1__Impl rule__CallDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__CallDefinition__Group__1__Impl_in_rule__CallDefinition__Group__13139);
            rule__CallDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CallDefinition__Group__2_in_rule__CallDefinition__Group__13142);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1519:1: rule__CallDefinition__Group__1__Impl : ( ( rule__CallDefinition__NameAssignment_1 ) ) ;
    public final void rule__CallDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1523:1: ( ( ( rule__CallDefinition__NameAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1524:1: ( ( rule__CallDefinition__NameAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1524:1: ( ( rule__CallDefinition__NameAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1525:1: ( rule__CallDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getCallDefinitionAccess().getNameAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1526:1: ( rule__CallDefinition__NameAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1526:2: rule__CallDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__CallDefinition__NameAssignment_1_in_rule__CallDefinition__Group__1__Impl3169);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1536:1: rule__CallDefinition__Group__2 : rule__CallDefinition__Group__2__Impl rule__CallDefinition__Group__3 ;
    public final void rule__CallDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1540:1: ( rule__CallDefinition__Group__2__Impl rule__CallDefinition__Group__3 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1541:2: rule__CallDefinition__Group__2__Impl rule__CallDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__CallDefinition__Group__2__Impl_in_rule__CallDefinition__Group__23199);
            rule__CallDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CallDefinition__Group__3_in_rule__CallDefinition__Group__23202);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1548:1: rule__CallDefinition__Group__2__Impl : ( 'uses' ) ;
    public final void rule__CallDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1552:1: ( ( 'uses' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1553:1: ( 'uses' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1553:1: ( 'uses' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1554:1: 'uses'
            {
             before(grammarAccess.getCallDefinitionAccess().getUsesKeyword_2()); 
            match(input,18,FOLLOW_18_in_rule__CallDefinition__Group__2__Impl3230); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1567:1: rule__CallDefinition__Group__3 : rule__CallDefinition__Group__3__Impl ;
    public final void rule__CallDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1571:1: ( rule__CallDefinition__Group__3__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1572:2: rule__CallDefinition__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__CallDefinition__Group__3__Impl_in_rule__CallDefinition__Group__33261);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1578:1: rule__CallDefinition__Group__3__Impl : ( ( rule__CallDefinition__FixtureMethodAssignment_3 ) ) ;
    public final void rule__CallDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1582:1: ( ( ( rule__CallDefinition__FixtureMethodAssignment_3 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1583:1: ( ( rule__CallDefinition__FixtureMethodAssignment_3 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1583:1: ( ( rule__CallDefinition__FixtureMethodAssignment_3 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1584:1: ( rule__CallDefinition__FixtureMethodAssignment_3 )
            {
             before(grammarAccess.getCallDefinitionAccess().getFixtureMethodAssignment_3()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1585:1: ( rule__CallDefinition__FixtureMethodAssignment_3 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1585:2: rule__CallDefinition__FixtureMethodAssignment_3
            {
            pushFollow(FOLLOW_rule__CallDefinition__FixtureMethodAssignment_3_in_rule__CallDefinition__Group__3__Impl3288);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1603:1: rule__SuiteDefinition__Group__0 : rule__SuiteDefinition__Group__0__Impl rule__SuiteDefinition__Group__1 ;
    public final void rule__SuiteDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1607:1: ( rule__SuiteDefinition__Group__0__Impl rule__SuiteDefinition__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1608:2: rule__SuiteDefinition__Group__0__Impl rule__SuiteDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__0__Impl_in_rule__SuiteDefinition__Group__03326);
            rule__SuiteDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__1_in_rule__SuiteDefinition__Group__03329);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1615:1: rule__SuiteDefinition__Group__0__Impl : ( 'suitedef' ) ;
    public final void rule__SuiteDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1619:1: ( ( 'suitedef' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1620:1: ( 'suitedef' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1620:1: ( 'suitedef' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1621:1: 'suitedef'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getSuitedefKeyword_0()); 
            match(input,20,FOLLOW_20_in_rule__SuiteDefinition__Group__0__Impl3357); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1634:1: rule__SuiteDefinition__Group__1 : rule__SuiteDefinition__Group__1__Impl rule__SuiteDefinition__Group__2 ;
    public final void rule__SuiteDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1638:1: ( rule__SuiteDefinition__Group__1__Impl rule__SuiteDefinition__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1639:2: rule__SuiteDefinition__Group__1__Impl rule__SuiteDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__1__Impl_in_rule__SuiteDefinition__Group__13388);
            rule__SuiteDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__2_in_rule__SuiteDefinition__Group__13391);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1646:1: rule__SuiteDefinition__Group__1__Impl : ( ( rule__SuiteDefinition__NameAssignment_1 ) ) ;
    public final void rule__SuiteDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1650:1: ( ( ( rule__SuiteDefinition__NameAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1651:1: ( ( rule__SuiteDefinition__NameAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1651:1: ( ( rule__SuiteDefinition__NameAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1652:1: ( rule__SuiteDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getSuiteDefinitionAccess().getNameAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1653:1: ( rule__SuiteDefinition__NameAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1653:2: rule__SuiteDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__NameAssignment_1_in_rule__SuiteDefinition__Group__1__Impl3418);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1663:1: rule__SuiteDefinition__Group__2 : rule__SuiteDefinition__Group__2__Impl rule__SuiteDefinition__Group__3 ;
    public final void rule__SuiteDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1667:1: ( rule__SuiteDefinition__Group__2__Impl rule__SuiteDefinition__Group__3 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1668:2: rule__SuiteDefinition__Group__2__Impl rule__SuiteDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__2__Impl_in_rule__SuiteDefinition__Group__23448);
            rule__SuiteDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__3_in_rule__SuiteDefinition__Group__23451);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1675:1: rule__SuiteDefinition__Group__2__Impl : ( ( rule__SuiteDefinition__Group_2__0 )? ) ;
    public final void rule__SuiteDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1679:1: ( ( ( rule__SuiteDefinition__Group_2__0 )? ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1680:1: ( ( rule__SuiteDefinition__Group_2__0 )? )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1680:1: ( ( rule__SuiteDefinition__Group_2__0 )? )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1681:1: ( rule__SuiteDefinition__Group_2__0 )?
            {
             before(grammarAccess.getSuiteDefinitionAccess().getGroup_2()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1682:1: ( rule__SuiteDefinition__Group_2__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==22) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1682:2: rule__SuiteDefinition__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__SuiteDefinition__Group_2__0_in_rule__SuiteDefinition__Group__2__Impl3478);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1692:1: rule__SuiteDefinition__Group__3 : rule__SuiteDefinition__Group__3__Impl rule__SuiteDefinition__Group__4 ;
    public final void rule__SuiteDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1696:1: ( rule__SuiteDefinition__Group__3__Impl rule__SuiteDefinition__Group__4 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1697:2: rule__SuiteDefinition__Group__3__Impl rule__SuiteDefinition__Group__4
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__3__Impl_in_rule__SuiteDefinition__Group__33509);
            rule__SuiteDefinition__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__4_in_rule__SuiteDefinition__Group__33512);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1704:1: rule__SuiteDefinition__Group__3__Impl : ( ( rule__SuiteDefinition__Group_3__0 )? ) ;
    public final void rule__SuiteDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1708:1: ( ( ( rule__SuiteDefinition__Group_3__0 )? ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1709:1: ( ( rule__SuiteDefinition__Group_3__0 )? )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1709:1: ( ( rule__SuiteDefinition__Group_3__0 )? )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1710:1: ( rule__SuiteDefinition__Group_3__0 )?
            {
             before(grammarAccess.getSuiteDefinitionAccess().getGroup_3()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1711:1: ( rule__SuiteDefinition__Group_3__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==23) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1711:2: rule__SuiteDefinition__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__SuiteDefinition__Group_3__0_in_rule__SuiteDefinition__Group__3__Impl3539);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1721:1: rule__SuiteDefinition__Group__4 : rule__SuiteDefinition__Group__4__Impl rule__SuiteDefinition__Group__5 ;
    public final void rule__SuiteDefinition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1725:1: ( rule__SuiteDefinition__Group__4__Impl rule__SuiteDefinition__Group__5 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1726:2: rule__SuiteDefinition__Group__4__Impl rule__SuiteDefinition__Group__5
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__4__Impl_in_rule__SuiteDefinition__Group__43570);
            rule__SuiteDefinition__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__5_in_rule__SuiteDefinition__Group__43573);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1733:1: rule__SuiteDefinition__Group__4__Impl : ( 'with' ) ;
    public final void rule__SuiteDefinition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1737:1: ( ( 'with' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1738:1: ( 'with' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1738:1: ( 'with' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1739:1: 'with'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getWithKeyword_4()); 
            match(input,14,FOLLOW_14_in_rule__SuiteDefinition__Group__4__Impl3601); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1752:1: rule__SuiteDefinition__Group__5 : rule__SuiteDefinition__Group__5__Impl rule__SuiteDefinition__Group__6 ;
    public final void rule__SuiteDefinition__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1756:1: ( rule__SuiteDefinition__Group__5__Impl rule__SuiteDefinition__Group__6 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1757:2: rule__SuiteDefinition__Group__5__Impl rule__SuiteDefinition__Group__6
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__5__Impl_in_rule__SuiteDefinition__Group__53632);
            rule__SuiteDefinition__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__6_in_rule__SuiteDefinition__Group__53635);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1764:1: rule__SuiteDefinition__Group__5__Impl : ( ( rule__SuiteDefinition__StatementsAssignment_5 )* ) ;
    public final void rule__SuiteDefinition__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1768:1: ( ( ( rule__SuiteDefinition__StatementsAssignment_5 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1769:1: ( ( rule__SuiteDefinition__StatementsAssignment_5 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1769:1: ( ( rule__SuiteDefinition__StatementsAssignment_5 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1770:1: ( rule__SuiteDefinition__StatementsAssignment_5 )*
            {
             before(grammarAccess.getSuiteDefinitionAccess().getStatementsAssignment_5()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1771:1: ( rule__SuiteDefinition__StatementsAssignment_5 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==25||LA12_0==27||LA12_0==29||LA12_0==31) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1771:2: rule__SuiteDefinition__StatementsAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__SuiteDefinition__StatementsAssignment_5_in_rule__SuiteDefinition__Group__5__Impl3662);
            	    rule__SuiteDefinition__StatementsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1781:1: rule__SuiteDefinition__Group__6 : rule__SuiteDefinition__Group__6__Impl rule__SuiteDefinition__Group__7 ;
    public final void rule__SuiteDefinition__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1785:1: ( rule__SuiteDefinition__Group__6__Impl rule__SuiteDefinition__Group__7 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1786:2: rule__SuiteDefinition__Group__6__Impl rule__SuiteDefinition__Group__7
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__6__Impl_in_rule__SuiteDefinition__Group__63693);
            rule__SuiteDefinition__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__7_in_rule__SuiteDefinition__Group__63696);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1793:1: rule__SuiteDefinition__Group__6__Impl : ( 'suiteend' ) ;
    public final void rule__SuiteDefinition__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1797:1: ( ( 'suiteend' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1798:1: ( 'suiteend' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1798:1: ( 'suiteend' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1799:1: 'suiteend'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getSuiteendKeyword_6()); 
            match(input,21,FOLLOW_21_in_rule__SuiteDefinition__Group__6__Impl3724); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1812:1: rule__SuiteDefinition__Group__7 : rule__SuiteDefinition__Group__7__Impl ;
    public final void rule__SuiteDefinition__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1816:1: ( rule__SuiteDefinition__Group__7__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1817:2: rule__SuiteDefinition__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__7__Impl_in_rule__SuiteDefinition__Group__73755);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1823:1: rule__SuiteDefinition__Group__7__Impl : ( ( rule__SuiteDefinition__Group_7__0 )? ) ;
    public final void rule__SuiteDefinition__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1827:1: ( ( ( rule__SuiteDefinition__Group_7__0 )? ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1828:1: ( ( rule__SuiteDefinition__Group_7__0 )? )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1828:1: ( ( rule__SuiteDefinition__Group_7__0 )? )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1829:1: ( rule__SuiteDefinition__Group_7__0 )?
            {
             before(grammarAccess.getSuiteDefinitionAccess().getGroup_7()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1830:1: ( rule__SuiteDefinition__Group_7__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1830:2: rule__SuiteDefinition__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__SuiteDefinition__Group_7__0_in_rule__SuiteDefinition__Group__7__Impl3782);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1856:1: rule__SuiteDefinition__Group_2__0 : rule__SuiteDefinition__Group_2__0__Impl rule__SuiteDefinition__Group_2__1 ;
    public final void rule__SuiteDefinition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1860:1: ( rule__SuiteDefinition__Group_2__0__Impl rule__SuiteDefinition__Group_2__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1861:2: rule__SuiteDefinition__Group_2__0__Impl rule__SuiteDefinition__Group_2__1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_2__0__Impl_in_rule__SuiteDefinition__Group_2__03829);
            rule__SuiteDefinition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group_2__1_in_rule__SuiteDefinition__Group_2__03832);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1868:1: rule__SuiteDefinition__Group_2__0__Impl : ( 'gets' ) ;
    public final void rule__SuiteDefinition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1872:1: ( ( 'gets' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1873:1: ( 'gets' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1873:1: ( 'gets' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1874:1: 'gets'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getGetsKeyword_2_0()); 
            match(input,22,FOLLOW_22_in_rule__SuiteDefinition__Group_2__0__Impl3860); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1887:1: rule__SuiteDefinition__Group_2__1 : rule__SuiteDefinition__Group_2__1__Impl ;
    public final void rule__SuiteDefinition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1891:1: ( rule__SuiteDefinition__Group_2__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1892:2: rule__SuiteDefinition__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_2__1__Impl_in_rule__SuiteDefinition__Group_2__13891);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1898:1: rule__SuiteDefinition__Group_2__1__Impl : ( ( rule__SuiteDefinition__ParametersAssignment_2_1 )* ) ;
    public final void rule__SuiteDefinition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1902:1: ( ( ( rule__SuiteDefinition__ParametersAssignment_2_1 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1903:1: ( ( rule__SuiteDefinition__ParametersAssignment_2_1 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1903:1: ( ( rule__SuiteDefinition__ParametersAssignment_2_1 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1904:1: ( rule__SuiteDefinition__ParametersAssignment_2_1 )*
            {
             before(grammarAccess.getSuiteDefinitionAccess().getParametersAssignment_2_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1905:1: ( rule__SuiteDefinition__ParametersAssignment_2_1 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1905:2: rule__SuiteDefinition__ParametersAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_rule__SuiteDefinition__ParametersAssignment_2_1_in_rule__SuiteDefinition__Group_2__1__Impl3918);
            	    rule__SuiteDefinition__ParametersAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1919:1: rule__SuiteDefinition__Group_3__0 : rule__SuiteDefinition__Group_3__0__Impl rule__SuiteDefinition__Group_3__1 ;
    public final void rule__SuiteDefinition__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1923:1: ( rule__SuiteDefinition__Group_3__0__Impl rule__SuiteDefinition__Group_3__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1924:2: rule__SuiteDefinition__Group_3__0__Impl rule__SuiteDefinition__Group_3__1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_3__0__Impl_in_rule__SuiteDefinition__Group_3__03953);
            rule__SuiteDefinition__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group_3__1_in_rule__SuiteDefinition__Group_3__03956);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1931:1: rule__SuiteDefinition__Group_3__0__Impl : ( 'requires' ) ;
    public final void rule__SuiteDefinition__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1935:1: ( ( 'requires' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1936:1: ( 'requires' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1936:1: ( 'requires' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1937:1: 'requires'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getRequiresKeyword_3_0()); 
            match(input,23,FOLLOW_23_in_rule__SuiteDefinition__Group_3__0__Impl3984); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1950:1: rule__SuiteDefinition__Group_3__1 : rule__SuiteDefinition__Group_3__1__Impl ;
    public final void rule__SuiteDefinition__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1954:1: ( rule__SuiteDefinition__Group_3__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1955:2: rule__SuiteDefinition__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_3__1__Impl_in_rule__SuiteDefinition__Group_3__14015);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1961:1: rule__SuiteDefinition__Group_3__1__Impl : ( ( rule__SuiteDefinition__DependenciesAssignment_3_1 )* ) ;
    public final void rule__SuiteDefinition__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1965:1: ( ( ( rule__SuiteDefinition__DependenciesAssignment_3_1 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1966:1: ( ( rule__SuiteDefinition__DependenciesAssignment_3_1 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1966:1: ( ( rule__SuiteDefinition__DependenciesAssignment_3_1 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1967:1: ( rule__SuiteDefinition__DependenciesAssignment_3_1 )*
            {
             before(grammarAccess.getSuiteDefinitionAccess().getDependenciesAssignment_3_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1968:1: ( rule__SuiteDefinition__DependenciesAssignment_3_1 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1968:2: rule__SuiteDefinition__DependenciesAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_rule__SuiteDefinition__DependenciesAssignment_3_1_in_rule__SuiteDefinition__Group_3__1__Impl4042);
            	    rule__SuiteDefinition__DependenciesAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1982:1: rule__SuiteDefinition__Group_7__0 : rule__SuiteDefinition__Group_7__0__Impl rule__SuiteDefinition__Group_7__1 ;
    public final void rule__SuiteDefinition__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1986:1: ( rule__SuiteDefinition__Group_7__0__Impl rule__SuiteDefinition__Group_7__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1987:2: rule__SuiteDefinition__Group_7__0__Impl rule__SuiteDefinition__Group_7__1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_7__0__Impl_in_rule__SuiteDefinition__Group_7__04077);
            rule__SuiteDefinition__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group_7__1_in_rule__SuiteDefinition__Group_7__04080);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1994:1: rule__SuiteDefinition__Group_7__0__Impl : ( 'concludedby' ) ;
    public final void rule__SuiteDefinition__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1998:1: ( ( 'concludedby' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1999:1: ( 'concludedby' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1999:1: ( 'concludedby' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2000:1: 'concludedby'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getConcludedbyKeyword_7_0()); 
            match(input,24,FOLLOW_24_in_rule__SuiteDefinition__Group_7__0__Impl4108); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2013:1: rule__SuiteDefinition__Group_7__1 : rule__SuiteDefinition__Group_7__1__Impl ;
    public final void rule__SuiteDefinition__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2017:1: ( rule__SuiteDefinition__Group_7__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2018:2: rule__SuiteDefinition__Group_7__1__Impl
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_7__1__Impl_in_rule__SuiteDefinition__Group_7__14139);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2024:1: rule__SuiteDefinition__Group_7__1__Impl : ( ( rule__SuiteDefinition__FinalizersAssignment_7_1 )* ) ;
    public final void rule__SuiteDefinition__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2028:1: ( ( ( rule__SuiteDefinition__FinalizersAssignment_7_1 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2029:1: ( ( rule__SuiteDefinition__FinalizersAssignment_7_1 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2029:1: ( ( rule__SuiteDefinition__FinalizersAssignment_7_1 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2030:1: ( rule__SuiteDefinition__FinalizersAssignment_7_1 )*
            {
             before(grammarAccess.getSuiteDefinitionAccess().getFinalizersAssignment_7_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2031:1: ( rule__SuiteDefinition__FinalizersAssignment_7_1 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2031:2: rule__SuiteDefinition__FinalizersAssignment_7_1
            	    {
            	    pushFollow(FOLLOW_rule__SuiteDefinition__FinalizersAssignment_7_1_in_rule__SuiteDefinition__Group_7__1__Impl4166);
            	    rule__SuiteDefinition__FinalizersAssignment_7_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2045:1: rule__VariableDefinition__Group__0 : rule__VariableDefinition__Group__0__Impl rule__VariableDefinition__Group__1 ;
    public final void rule__VariableDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2049:1: ( rule__VariableDefinition__Group__0__Impl rule__VariableDefinition__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2050:2: rule__VariableDefinition__Group__0__Impl rule__VariableDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group__0__Impl_in_rule__VariableDefinition__Group__04201);
            rule__VariableDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDefinition__Group__1_in_rule__VariableDefinition__Group__04204);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2057:1: rule__VariableDefinition__Group__0__Impl : ( 'variable' ) ;
    public final void rule__VariableDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2061:1: ( ( 'variable' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2062:1: ( 'variable' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2062:1: ( 'variable' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2063:1: 'variable'
            {
             before(grammarAccess.getVariableDefinitionAccess().getVariableKeyword_0()); 
            match(input,25,FOLLOW_25_in_rule__VariableDefinition__Group__0__Impl4232); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2076:1: rule__VariableDefinition__Group__1 : rule__VariableDefinition__Group__1__Impl rule__VariableDefinition__Group__2 ;
    public final void rule__VariableDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2080:1: ( rule__VariableDefinition__Group__1__Impl rule__VariableDefinition__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2081:2: rule__VariableDefinition__Group__1__Impl rule__VariableDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group__1__Impl_in_rule__VariableDefinition__Group__14263);
            rule__VariableDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDefinition__Group__2_in_rule__VariableDefinition__Group__14266);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2088:1: rule__VariableDefinition__Group__1__Impl : ( ( rule__VariableDefinition__NameAssignment_1 ) ) ;
    public final void rule__VariableDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2092:1: ( ( ( rule__VariableDefinition__NameAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2093:1: ( ( rule__VariableDefinition__NameAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2093:1: ( ( rule__VariableDefinition__NameAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2094:1: ( rule__VariableDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getVariableDefinitionAccess().getNameAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2095:1: ( rule__VariableDefinition__NameAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2095:2: rule__VariableDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__VariableDefinition__NameAssignment_1_in_rule__VariableDefinition__Group__1__Impl4293);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2105:1: rule__VariableDefinition__Group__2 : rule__VariableDefinition__Group__2__Impl ;
    public final void rule__VariableDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2109:1: ( rule__VariableDefinition__Group__2__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2110:2: rule__VariableDefinition__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group__2__Impl_in_rule__VariableDefinition__Group__24323);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2116:1: rule__VariableDefinition__Group__2__Impl : ( ( rule__VariableDefinition__Group_2__0 )? ) ;
    public final void rule__VariableDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2120:1: ( ( ( rule__VariableDefinition__Group_2__0 )? ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2121:1: ( ( rule__VariableDefinition__Group_2__0 )? )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2121:1: ( ( rule__VariableDefinition__Group_2__0 )? )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2122:1: ( rule__VariableDefinition__Group_2__0 )?
            {
             before(grammarAccess.getVariableDefinitionAccess().getGroup_2()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2123:1: ( rule__VariableDefinition__Group_2__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==26) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2123:2: rule__VariableDefinition__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__VariableDefinition__Group_2__0_in_rule__VariableDefinition__Group__2__Impl4350);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2139:1: rule__VariableDefinition__Group_2__0 : rule__VariableDefinition__Group_2__0__Impl rule__VariableDefinition__Group_2__1 ;
    public final void rule__VariableDefinition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2143:1: ( rule__VariableDefinition__Group_2__0__Impl rule__VariableDefinition__Group_2__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2144:2: rule__VariableDefinition__Group_2__0__Impl rule__VariableDefinition__Group_2__1
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group_2__0__Impl_in_rule__VariableDefinition__Group_2__04387);
            rule__VariableDefinition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDefinition__Group_2__1_in_rule__VariableDefinition__Group_2__04390);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2151:1: rule__VariableDefinition__Group_2__0__Impl : ( 'initially' ) ;
    public final void rule__VariableDefinition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2155:1: ( ( 'initially' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2156:1: ( 'initially' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2156:1: ( 'initially' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2157:1: 'initially'
            {
             before(grammarAccess.getVariableDefinitionAccess().getInitiallyKeyword_2_0()); 
            match(input,26,FOLLOW_26_in_rule__VariableDefinition__Group_2__0__Impl4418); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2170:1: rule__VariableDefinition__Group_2__1 : rule__VariableDefinition__Group_2__1__Impl ;
    public final void rule__VariableDefinition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2174:1: ( rule__VariableDefinition__Group_2__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2175:2: rule__VariableDefinition__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group_2__1__Impl_in_rule__VariableDefinition__Group_2__14449);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2181:1: rule__VariableDefinition__Group_2__1__Impl : ( ( rule__VariableDefinition__InitialValueAssignment_2_1 ) ) ;
    public final void rule__VariableDefinition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2185:1: ( ( ( rule__VariableDefinition__InitialValueAssignment_2_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2186:1: ( ( rule__VariableDefinition__InitialValueAssignment_2_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2186:1: ( ( rule__VariableDefinition__InitialValueAssignment_2_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2187:1: ( rule__VariableDefinition__InitialValueAssignment_2_1 )
            {
             before(grammarAccess.getVariableDefinitionAccess().getInitialValueAssignment_2_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2188:1: ( rule__VariableDefinition__InitialValueAssignment_2_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2188:2: rule__VariableDefinition__InitialValueAssignment_2_1
            {
            pushFollow(FOLLOW_rule__VariableDefinition__InitialValueAssignment_2_1_in_rule__VariableDefinition__Group_2__1__Impl4476);
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


    // $ANTLR start "rule__Test__Group__0"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2202:1: rule__Test__Group__0 : rule__Test__Group__0__Impl rule__Test__Group__1 ;
    public final void rule__Test__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2206:1: ( rule__Test__Group__0__Impl rule__Test__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2207:2: rule__Test__Group__0__Impl rule__Test__Group__1
            {
            pushFollow(FOLLOW_rule__Test__Group__0__Impl_in_rule__Test__Group__04510);
            rule__Test__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Test__Group__1_in_rule__Test__Group__04513);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2214:1: rule__Test__Group__0__Impl : ( 'test' ) ;
    public final void rule__Test__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2218:1: ( ( 'test' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2219:1: ( 'test' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2219:1: ( 'test' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2220:1: 'test'
            {
             before(grammarAccess.getTestAccess().getTestKeyword_0()); 
            match(input,27,FOLLOW_27_in_rule__Test__Group__0__Impl4541); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2233:1: rule__Test__Group__1 : rule__Test__Group__1__Impl rule__Test__Group__2 ;
    public final void rule__Test__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2237:1: ( rule__Test__Group__1__Impl rule__Test__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2238:2: rule__Test__Group__1__Impl rule__Test__Group__2
            {
            pushFollow(FOLLOW_rule__Test__Group__1__Impl_in_rule__Test__Group__14572);
            rule__Test__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Test__Group__2_in_rule__Test__Group__14575);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2245:1: rule__Test__Group__1__Impl : ( ( rule__Test__DefinitionAssignment_1 ) ) ;
    public final void rule__Test__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2249:1: ( ( ( rule__Test__DefinitionAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2250:1: ( ( rule__Test__DefinitionAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2250:1: ( ( rule__Test__DefinitionAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2251:1: ( rule__Test__DefinitionAssignment_1 )
            {
             before(grammarAccess.getTestAccess().getDefinitionAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2252:1: ( rule__Test__DefinitionAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2252:2: rule__Test__DefinitionAssignment_1
            {
            pushFollow(FOLLOW_rule__Test__DefinitionAssignment_1_in_rule__Test__Group__1__Impl4602);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2262:1: rule__Test__Group__2 : rule__Test__Group__2__Impl rule__Test__Group__3 ;
    public final void rule__Test__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2266:1: ( rule__Test__Group__2__Impl rule__Test__Group__3 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2267:2: rule__Test__Group__2__Impl rule__Test__Group__3
            {
            pushFollow(FOLLOW_rule__Test__Group__2__Impl_in_rule__Test__Group__24632);
            rule__Test__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Test__Group__3_in_rule__Test__Group__24635);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2274:1: rule__Test__Group__2__Impl : ( ( rule__Test__ParametersAssignment_2 )* ) ;
    public final void rule__Test__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2278:1: ( ( ( rule__Test__ParametersAssignment_2 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2279:1: ( ( rule__Test__ParametersAssignment_2 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2279:1: ( ( rule__Test__ParametersAssignment_2 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2280:1: ( rule__Test__ParametersAssignment_2 )*
            {
             before(grammarAccess.getTestAccess().getParametersAssignment_2()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2281:1: ( rule__Test__ParametersAssignment_2 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID||LA18_0==33) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2281:2: rule__Test__ParametersAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Test__ParametersAssignment_2_in_rule__Test__Group__2__Impl4662);
            	    rule__Test__ParametersAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2291:1: rule__Test__Group__3 : rule__Test__Group__3__Impl ;
    public final void rule__Test__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2295:1: ( rule__Test__Group__3__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2296:2: rule__Test__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Test__Group__3__Impl_in_rule__Test__Group__34693);
            rule__Test__Group__3__Impl();

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2302:1: rule__Test__Group__3__Impl : ( ( rule__Test__Group_3__0 )? ) ;
    public final void rule__Test__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2306:1: ( ( ( rule__Test__Group_3__0 )? ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2307:1: ( ( rule__Test__Group_3__0 )? )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2307:1: ( ( rule__Test__Group_3__0 )? )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2308:1: ( rule__Test__Group_3__0 )?
            {
             before(grammarAccess.getTestAccess().getGroup_3()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2309:1: ( rule__Test__Group_3__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==28) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2309:2: rule__Test__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Test__Group_3__0_in_rule__Test__Group__3__Impl4720);
                    rule__Test__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTestAccess().getGroup_3()); 

            }


            }

        }
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


    // $ANTLR start "rule__Test__Group_3__0"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2327:1: rule__Test__Group_3__0 : rule__Test__Group_3__0__Impl rule__Test__Group_3__1 ;
    public final void rule__Test__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2331:1: ( rule__Test__Group_3__0__Impl rule__Test__Group_3__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2332:2: rule__Test__Group_3__0__Impl rule__Test__Group_3__1
            {
            pushFollow(FOLLOW_rule__Test__Group_3__0__Impl_in_rule__Test__Group_3__04759);
            rule__Test__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Test__Group_3__1_in_rule__Test__Group_3__04762);
            rule__Test__Group_3__1();

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
    // $ANTLR end "rule__Test__Group_3__0"


    // $ANTLR start "rule__Test__Group_3__0__Impl"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2339:1: rule__Test__Group_3__0__Impl : ( '=' ) ;
    public final void rule__Test__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2343:1: ( ( '=' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2344:1: ( '=' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2344:1: ( '=' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2345:1: '='
            {
             before(grammarAccess.getTestAccess().getEqualsSignKeyword_3_0()); 
            match(input,28,FOLLOW_28_in_rule__Test__Group_3__0__Impl4790); 
             after(grammarAccess.getTestAccess().getEqualsSignKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__Group_3__0__Impl"


    // $ANTLR start "rule__Test__Group_3__1"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2358:1: rule__Test__Group_3__1 : rule__Test__Group_3__1__Impl ;
    public final void rule__Test__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2362:1: ( rule__Test__Group_3__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2363:2: rule__Test__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Test__Group_3__1__Impl_in_rule__Test__Group_3__14821);
            rule__Test__Group_3__1__Impl();

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
    // $ANTLR end "rule__Test__Group_3__1"


    // $ANTLR start "rule__Test__Group_3__1__Impl"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2369:1: rule__Test__Group_3__1__Impl : ( ( rule__Test__ResultAssignment_3_1 ) ) ;
    public final void rule__Test__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2373:1: ( ( ( rule__Test__ResultAssignment_3_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2374:1: ( ( rule__Test__ResultAssignment_3_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2374:1: ( ( rule__Test__ResultAssignment_3_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2375:1: ( rule__Test__ResultAssignment_3_1 )
            {
             before(grammarAccess.getTestAccess().getResultAssignment_3_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2376:1: ( rule__Test__ResultAssignment_3_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2376:2: rule__Test__ResultAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Test__ResultAssignment_3_1_in_rule__Test__Group_3__1__Impl4848);
            rule__Test__ResultAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getTestAccess().getResultAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__Group_3__1__Impl"


    // $ANTLR start "rule__Call__Group__0"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2390:1: rule__Call__Group__0 : rule__Call__Group__0__Impl rule__Call__Group__1 ;
    public final void rule__Call__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2394:1: ( rule__Call__Group__0__Impl rule__Call__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2395:2: rule__Call__Group__0__Impl rule__Call__Group__1
            {
            pushFollow(FOLLOW_rule__Call__Group__0__Impl_in_rule__Call__Group__04882);
            rule__Call__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group__1_in_rule__Call__Group__04885);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2402:1: rule__Call__Group__0__Impl : ( 'call' ) ;
    public final void rule__Call__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2406:1: ( ( 'call' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2407:1: ( 'call' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2407:1: ( 'call' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2408:1: 'call'
            {
             before(grammarAccess.getCallAccess().getCallKeyword_0()); 
            match(input,29,FOLLOW_29_in_rule__Call__Group__0__Impl4913); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2421:1: rule__Call__Group__1 : rule__Call__Group__1__Impl rule__Call__Group__2 ;
    public final void rule__Call__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2425:1: ( rule__Call__Group__1__Impl rule__Call__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2426:2: rule__Call__Group__1__Impl rule__Call__Group__2
            {
            pushFollow(FOLLOW_rule__Call__Group__1__Impl_in_rule__Call__Group__14944);
            rule__Call__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group__2_in_rule__Call__Group__14947);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2433:1: rule__Call__Group__1__Impl : ( ( rule__Call__DefinitionAssignment_1 ) ) ;
    public final void rule__Call__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2437:1: ( ( ( rule__Call__DefinitionAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2438:1: ( ( rule__Call__DefinitionAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2438:1: ( ( rule__Call__DefinitionAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2439:1: ( rule__Call__DefinitionAssignment_1 )
            {
             before(grammarAccess.getCallAccess().getDefinitionAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2440:1: ( rule__Call__DefinitionAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2440:2: rule__Call__DefinitionAssignment_1
            {
            pushFollow(FOLLOW_rule__Call__DefinitionAssignment_1_in_rule__Call__Group__1__Impl4974);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2450:1: rule__Call__Group__2 : rule__Call__Group__2__Impl rule__Call__Group__3 ;
    public final void rule__Call__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2454:1: ( rule__Call__Group__2__Impl rule__Call__Group__3 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2455:2: rule__Call__Group__2__Impl rule__Call__Group__3
            {
            pushFollow(FOLLOW_rule__Call__Group__2__Impl_in_rule__Call__Group__25004);
            rule__Call__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group__3_in_rule__Call__Group__25007);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2462:1: rule__Call__Group__2__Impl : ( ( rule__Call__ParametersAssignment_2 )* ) ;
    public final void rule__Call__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2466:1: ( ( ( rule__Call__ParametersAssignment_2 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2467:1: ( ( rule__Call__ParametersAssignment_2 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2467:1: ( ( rule__Call__ParametersAssignment_2 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2468:1: ( rule__Call__ParametersAssignment_2 )*
            {
             before(grammarAccess.getCallAccess().getParametersAssignment_2()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2469:1: ( rule__Call__ParametersAssignment_2 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID||LA20_0==33) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2469:2: rule__Call__ParametersAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Call__ParametersAssignment_2_in_rule__Call__Group__2__Impl5034);
            	    rule__Call__ParametersAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2479:1: rule__Call__Group__3 : rule__Call__Group__3__Impl ;
    public final void rule__Call__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2483:1: ( rule__Call__Group__3__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2484:2: rule__Call__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Call__Group__3__Impl_in_rule__Call__Group__35065);
            rule__Call__Group__3__Impl();

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2490:1: rule__Call__Group__3__Impl : ( ( rule__Call__Group_3__0 )? ) ;
    public final void rule__Call__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2494:1: ( ( ( rule__Call__Group_3__0 )? ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2495:1: ( ( rule__Call__Group_3__0 )? )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2495:1: ( ( rule__Call__Group_3__0 )? )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2496:1: ( rule__Call__Group_3__0 )?
            {
             before(grammarAccess.getCallAccess().getGroup_3()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2497:1: ( rule__Call__Group_3__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==30) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2497:2: rule__Call__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Call__Group_3__0_in_rule__Call__Group__3__Impl5092);
                    rule__Call__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getCallAccess().getGroup_3()); 

            }


            }

        }
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


    // $ANTLR start "rule__Call__Group_3__0"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2515:1: rule__Call__Group_3__0 : rule__Call__Group_3__0__Impl rule__Call__Group_3__1 ;
    public final void rule__Call__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2519:1: ( rule__Call__Group_3__0__Impl rule__Call__Group_3__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2520:2: rule__Call__Group_3__0__Impl rule__Call__Group_3__1
            {
            pushFollow(FOLLOW_rule__Call__Group_3__0__Impl_in_rule__Call__Group_3__05131);
            rule__Call__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group_3__1_in_rule__Call__Group_3__05134);
            rule__Call__Group_3__1();

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
    // $ANTLR end "rule__Call__Group_3__0"


    // $ANTLR start "rule__Call__Group_3__0__Impl"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2527:1: rule__Call__Group_3__0__Impl : ( 'sets' ) ;
    public final void rule__Call__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2531:1: ( ( 'sets' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2532:1: ( 'sets' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2532:1: ( 'sets' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2533:1: 'sets'
            {
             before(grammarAccess.getCallAccess().getSetsKeyword_3_0()); 
            match(input,30,FOLLOW_30_in_rule__Call__Group_3__0__Impl5162); 
             after(grammarAccess.getCallAccess().getSetsKeyword_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__Group_3__0__Impl"


    // $ANTLR start "rule__Call__Group_3__1"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2546:1: rule__Call__Group_3__1 : rule__Call__Group_3__1__Impl ;
    public final void rule__Call__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2550:1: ( rule__Call__Group_3__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2551:2: rule__Call__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Call__Group_3__1__Impl_in_rule__Call__Group_3__15193);
            rule__Call__Group_3__1__Impl();

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
    // $ANTLR end "rule__Call__Group_3__1"


    // $ANTLR start "rule__Call__Group_3__1__Impl"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2557:1: rule__Call__Group_3__1__Impl : ( ( rule__Call__ResultAssignment_3_1 ) ) ;
    public final void rule__Call__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2561:1: ( ( ( rule__Call__ResultAssignment_3_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2562:1: ( ( rule__Call__ResultAssignment_3_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2562:1: ( ( rule__Call__ResultAssignment_3_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2563:1: ( rule__Call__ResultAssignment_3_1 )
            {
             before(grammarAccess.getCallAccess().getResultAssignment_3_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2564:1: ( rule__Call__ResultAssignment_3_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2564:2: rule__Call__ResultAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Call__ResultAssignment_3_1_in_rule__Call__Group_3__1__Impl5220);
            rule__Call__ResultAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getCallAccess().getResultAssignment_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__Group_3__1__Impl"


    // $ANTLR start "rule__Suite__Group__0"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2578:1: rule__Suite__Group__0 : rule__Suite__Group__0__Impl rule__Suite__Group__1 ;
    public final void rule__Suite__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2582:1: ( rule__Suite__Group__0__Impl rule__Suite__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2583:2: rule__Suite__Group__0__Impl rule__Suite__Group__1
            {
            pushFollow(FOLLOW_rule__Suite__Group__0__Impl_in_rule__Suite__Group__05254);
            rule__Suite__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Suite__Group__1_in_rule__Suite__Group__05257);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2590:1: rule__Suite__Group__0__Impl : ( 'suite' ) ;
    public final void rule__Suite__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2594:1: ( ( 'suite' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2595:1: ( 'suite' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2595:1: ( 'suite' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2596:1: 'suite'
            {
             before(grammarAccess.getSuiteAccess().getSuiteKeyword_0()); 
            match(input,31,FOLLOW_31_in_rule__Suite__Group__0__Impl5285); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2609:1: rule__Suite__Group__1 : rule__Suite__Group__1__Impl rule__Suite__Group__2 ;
    public final void rule__Suite__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2613:1: ( rule__Suite__Group__1__Impl rule__Suite__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2614:2: rule__Suite__Group__1__Impl rule__Suite__Group__2
            {
            pushFollow(FOLLOW_rule__Suite__Group__1__Impl_in_rule__Suite__Group__15316);
            rule__Suite__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Suite__Group__2_in_rule__Suite__Group__15319);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2621:1: rule__Suite__Group__1__Impl : ( ( rule__Suite__DefinitionAssignment_1 ) ) ;
    public final void rule__Suite__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2625:1: ( ( ( rule__Suite__DefinitionAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2626:1: ( ( rule__Suite__DefinitionAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2626:1: ( ( rule__Suite__DefinitionAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2627:1: ( rule__Suite__DefinitionAssignment_1 )
            {
             before(grammarAccess.getSuiteAccess().getDefinitionAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2628:1: ( rule__Suite__DefinitionAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2628:2: rule__Suite__DefinitionAssignment_1
            {
            pushFollow(FOLLOW_rule__Suite__DefinitionAssignment_1_in_rule__Suite__Group__1__Impl5346);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2638:1: rule__Suite__Group__2 : rule__Suite__Group__2__Impl ;
    public final void rule__Suite__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2642:1: ( rule__Suite__Group__2__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2643:2: rule__Suite__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Suite__Group__2__Impl_in_rule__Suite__Group__25376);
            rule__Suite__Group__2__Impl();

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2649:1: rule__Suite__Group__2__Impl : ( ( rule__Suite__ParametersAssignment_2 )* ) ;
    public final void rule__Suite__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2653:1: ( ( ( rule__Suite__ParametersAssignment_2 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2654:1: ( ( rule__Suite__ParametersAssignment_2 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2654:1: ( ( rule__Suite__ParametersAssignment_2 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2655:1: ( rule__Suite__ParametersAssignment_2 )*
            {
             before(grammarAccess.getSuiteAccess().getParametersAssignment_2()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2656:1: ( rule__Suite__ParametersAssignment_2 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_ID) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2656:2: rule__Suite__ParametersAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Suite__ParametersAssignment_2_in_rule__Suite__Group__2__Impl5403);
            	    rule__Suite__ParametersAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
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


    // $ANTLR start "rule__SuiteParameter__Group__0"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2672:1: rule__SuiteParameter__Group__0 : rule__SuiteParameter__Group__0__Impl rule__SuiteParameter__Group__1 ;
    public final void rule__SuiteParameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2676:1: ( rule__SuiteParameter__Group__0__Impl rule__SuiteParameter__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2677:2: rule__SuiteParameter__Group__0__Impl rule__SuiteParameter__Group__1
            {
            pushFollow(FOLLOW_rule__SuiteParameter__Group__0__Impl_in_rule__SuiteParameter__Group__05440);
            rule__SuiteParameter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteParameter__Group__1_in_rule__SuiteParameter__Group__05443);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2684:1: rule__SuiteParameter__Group__0__Impl : ( ( rule__SuiteParameter__NameAssignment_0 ) ) ;
    public final void rule__SuiteParameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2688:1: ( ( ( rule__SuiteParameter__NameAssignment_0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2689:1: ( ( rule__SuiteParameter__NameAssignment_0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2689:1: ( ( rule__SuiteParameter__NameAssignment_0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2690:1: ( rule__SuiteParameter__NameAssignment_0 )
            {
             before(grammarAccess.getSuiteParameterAccess().getNameAssignment_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2691:1: ( rule__SuiteParameter__NameAssignment_0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2691:2: rule__SuiteParameter__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__SuiteParameter__NameAssignment_0_in_rule__SuiteParameter__Group__0__Impl5470);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2701:1: rule__SuiteParameter__Group__1 : rule__SuiteParameter__Group__1__Impl rule__SuiteParameter__Group__2 ;
    public final void rule__SuiteParameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2705:1: ( rule__SuiteParameter__Group__1__Impl rule__SuiteParameter__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2706:2: rule__SuiteParameter__Group__1__Impl rule__SuiteParameter__Group__2
            {
            pushFollow(FOLLOW_rule__SuiteParameter__Group__1__Impl_in_rule__SuiteParameter__Group__15500);
            rule__SuiteParameter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteParameter__Group__2_in_rule__SuiteParameter__Group__15503);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2713:1: rule__SuiteParameter__Group__1__Impl : ( ':' ) ;
    public final void rule__SuiteParameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2717:1: ( ( ':' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2718:1: ( ':' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2718:1: ( ':' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2719:1: ':'
            {
             before(grammarAccess.getSuiteParameterAccess().getColonKeyword_1()); 
            match(input,32,FOLLOW_32_in_rule__SuiteParameter__Group__1__Impl5531); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2732:1: rule__SuiteParameter__Group__2 : rule__SuiteParameter__Group__2__Impl ;
    public final void rule__SuiteParameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2736:1: ( rule__SuiteParameter__Group__2__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2737:2: rule__SuiteParameter__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__SuiteParameter__Group__2__Impl_in_rule__SuiteParameter__Group__25562);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2743:1: rule__SuiteParameter__Group__2__Impl : ( ( rule__SuiteParameter__ValueAssignment_2 ) ) ;
    public final void rule__SuiteParameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2747:1: ( ( ( rule__SuiteParameter__ValueAssignment_2 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2748:1: ( ( rule__SuiteParameter__ValueAssignment_2 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2748:1: ( ( rule__SuiteParameter__ValueAssignment_2 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2749:1: ( rule__SuiteParameter__ValueAssignment_2 )
            {
             before(grammarAccess.getSuiteParameterAccess().getValueAssignment_2()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2750:1: ( rule__SuiteParameter__ValueAssignment_2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2750:2: rule__SuiteParameter__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__SuiteParameter__ValueAssignment_2_in_rule__SuiteParameter__Group__2__Impl5589);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2766:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2770:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2771:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
            {
            pushFollow(FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__05625);
            rule__Parameter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__05628);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2778:1: rule__Parameter__Group__0__Impl : ( ( rule__Parameter__NameAssignment_0 ) ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2782:1: ( ( ( rule__Parameter__NameAssignment_0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2783:1: ( ( rule__Parameter__NameAssignment_0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2783:1: ( ( rule__Parameter__NameAssignment_0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2784:1: ( rule__Parameter__NameAssignment_0 )
            {
             before(grammarAccess.getParameterAccess().getNameAssignment_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2785:1: ( rule__Parameter__NameAssignment_0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2785:2: rule__Parameter__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Parameter__NameAssignment_0_in_rule__Parameter__Group__0__Impl5655);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2795:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl rule__Parameter__Group__2 ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2799:1: ( rule__Parameter__Group__1__Impl rule__Parameter__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2800:2: rule__Parameter__Group__1__Impl rule__Parameter__Group__2
            {
            pushFollow(FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__15685);
            rule__Parameter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Parameter__Group__2_in_rule__Parameter__Group__15688);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2807:1: rule__Parameter__Group__1__Impl : ( ':' ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2811:1: ( ( ':' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2812:1: ( ':' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2812:1: ( ':' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2813:1: ':'
            {
             before(grammarAccess.getParameterAccess().getColonKeyword_1()); 
            match(input,32,FOLLOW_32_in_rule__Parameter__Group__1__Impl5716); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2826:1: rule__Parameter__Group__2 : rule__Parameter__Group__2__Impl ;
    public final void rule__Parameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2830:1: ( rule__Parameter__Group__2__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2831:2: rule__Parameter__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Parameter__Group__2__Impl_in_rule__Parameter__Group__25747);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2837:1: rule__Parameter__Group__2__Impl : ( ( rule__Parameter__ValueAssignment_2 ) ) ;
    public final void rule__Parameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2841:1: ( ( ( rule__Parameter__ValueAssignment_2 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2842:1: ( ( rule__Parameter__ValueAssignment_2 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2842:1: ( ( rule__Parameter__ValueAssignment_2 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2843:1: ( rule__Parameter__ValueAssignment_2 )
            {
             before(grammarAccess.getParameterAccess().getValueAssignment_2()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2844:1: ( rule__Parameter__ValueAssignment_2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2844:2: rule__Parameter__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__Parameter__ValueAssignment_2_in_rule__Parameter__Group__2__Impl5774);
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


    // $ANTLR start "rule__ArbitraryParameterName__Group__0"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2860:1: rule__ArbitraryParameterName__Group__0 : rule__ArbitraryParameterName__Group__0__Impl rule__ArbitraryParameterName__Group__1 ;
    public final void rule__ArbitraryParameterName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2864:1: ( rule__ArbitraryParameterName__Group__0__Impl rule__ArbitraryParameterName__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2865:2: rule__ArbitraryParameterName__Group__0__Impl rule__ArbitraryParameterName__Group__1
            {
            pushFollow(FOLLOW_rule__ArbitraryParameterName__Group__0__Impl_in_rule__ArbitraryParameterName__Group__05810);
            rule__ArbitraryParameterName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ArbitraryParameterName__Group__1_in_rule__ArbitraryParameterName__Group__05813);
            rule__ArbitraryParameterName__Group__1();

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
    // $ANTLR end "rule__ArbitraryParameterName__Group__0"


    // $ANTLR start "rule__ArbitraryParameterName__Group__0__Impl"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2872:1: rule__ArbitraryParameterName__Group__0__Impl : ( '+' ) ;
    public final void rule__ArbitraryParameterName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2876:1: ( ( '+' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2877:1: ( '+' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2877:1: ( '+' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2878:1: '+'
            {
             before(grammarAccess.getArbitraryParameterNameAccess().getPlusSignKeyword_0()); 
            match(input,33,FOLLOW_33_in_rule__ArbitraryParameterName__Group__0__Impl5841); 
             after(grammarAccess.getArbitraryParameterNameAccess().getPlusSignKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArbitraryParameterName__Group__0__Impl"


    // $ANTLR start "rule__ArbitraryParameterName__Group__1"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2891:1: rule__ArbitraryParameterName__Group__1 : rule__ArbitraryParameterName__Group__1__Impl ;
    public final void rule__ArbitraryParameterName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2895:1: ( rule__ArbitraryParameterName__Group__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2896:2: rule__ArbitraryParameterName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ArbitraryParameterName__Group__1__Impl_in_rule__ArbitraryParameterName__Group__15872);
            rule__ArbitraryParameterName__Group__1__Impl();

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
    // $ANTLR end "rule__ArbitraryParameterName__Group__1"


    // $ANTLR start "rule__ArbitraryParameterName__Group__1__Impl"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2902:1: rule__ArbitraryParameterName__Group__1__Impl : ( ( rule__ArbitraryParameterName__IdentifierAssignment_1 ) ) ;
    public final void rule__ArbitraryParameterName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2906:1: ( ( ( rule__ArbitraryParameterName__IdentifierAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2907:1: ( ( rule__ArbitraryParameterName__IdentifierAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2907:1: ( ( rule__ArbitraryParameterName__IdentifierAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2908:1: ( rule__ArbitraryParameterName__IdentifierAssignment_1 )
            {
             before(grammarAccess.getArbitraryParameterNameAccess().getIdentifierAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2909:1: ( rule__ArbitraryParameterName__IdentifierAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2909:2: rule__ArbitraryParameterName__IdentifierAssignment_1
            {
            pushFollow(FOLLOW_rule__ArbitraryParameterName__IdentifierAssignment_1_in_rule__ArbitraryParameterName__Group__1__Impl5899);
            rule__ArbitraryParameterName__IdentifierAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getArbitraryParameterNameAccess().getIdentifierAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArbitraryParameterName__Group__1__Impl"


    // $ANTLR start "rule__MethodReference__Group__0"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2923:1: rule__MethodReference__Group__0 : rule__MethodReference__Group__0__Impl rule__MethodReference__Group__1 ;
    public final void rule__MethodReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2927:1: ( rule__MethodReference__Group__0__Impl rule__MethodReference__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2928:2: rule__MethodReference__Group__0__Impl rule__MethodReference__Group__1
            {
            pushFollow(FOLLOW_rule__MethodReference__Group__0__Impl_in_rule__MethodReference__Group__05933);
            rule__MethodReference__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodReference__Group__1_in_rule__MethodReference__Group__05936);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2935:1: rule__MethodReference__Group__0__Impl : ( ( rule__MethodReference__TypeAssignment_0 ) ) ;
    public final void rule__MethodReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2939:1: ( ( ( rule__MethodReference__TypeAssignment_0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2940:1: ( ( rule__MethodReference__TypeAssignment_0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2940:1: ( ( rule__MethodReference__TypeAssignment_0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2941:1: ( rule__MethodReference__TypeAssignment_0 )
            {
             before(grammarAccess.getMethodReferenceAccess().getTypeAssignment_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2942:1: ( rule__MethodReference__TypeAssignment_0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2942:2: rule__MethodReference__TypeAssignment_0
            {
            pushFollow(FOLLOW_rule__MethodReference__TypeAssignment_0_in_rule__MethodReference__Group__0__Impl5963);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2952:1: rule__MethodReference__Group__1 : rule__MethodReference__Group__1__Impl rule__MethodReference__Group__2 ;
    public final void rule__MethodReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2956:1: ( rule__MethodReference__Group__1__Impl rule__MethodReference__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2957:2: rule__MethodReference__Group__1__Impl rule__MethodReference__Group__2
            {
            pushFollow(FOLLOW_rule__MethodReference__Group__1__Impl_in_rule__MethodReference__Group__15993);
            rule__MethodReference__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodReference__Group__2_in_rule__MethodReference__Group__15996);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2964:1: rule__MethodReference__Group__1__Impl : ( '#' ) ;
    public final void rule__MethodReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2968:1: ( ( '#' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2969:1: ( '#' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2969:1: ( '#' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2970:1: '#'
            {
             before(grammarAccess.getMethodReferenceAccess().getNumberSignKeyword_1()); 
            match(input,34,FOLLOW_34_in_rule__MethodReference__Group__1__Impl6024); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2983:1: rule__MethodReference__Group__2 : rule__MethodReference__Group__2__Impl ;
    public final void rule__MethodReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2987:1: ( rule__MethodReference__Group__2__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2988:2: rule__MethodReference__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__MethodReference__Group__2__Impl_in_rule__MethodReference__Group__26055);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2994:1: rule__MethodReference__Group__2__Impl : ( ( rule__MethodReference__MethodAssignment_2 ) ) ;
    public final void rule__MethodReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2998:1: ( ( ( rule__MethodReference__MethodAssignment_2 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2999:1: ( ( rule__MethodReference__MethodAssignment_2 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2999:1: ( ( rule__MethodReference__MethodAssignment_2 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3000:1: ( rule__MethodReference__MethodAssignment_2 )
            {
             before(grammarAccess.getMethodReferenceAccess().getMethodAssignment_2()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3001:1: ( rule__MethodReference__MethodAssignment_2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3001:2: rule__MethodReference__MethodAssignment_2
            {
            pushFollow(FOLLOW_rule__MethodReference__MethodAssignment_2_in_rule__MethodReference__Group__2__Impl6082);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3017:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3021:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3022:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__06118);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__06121);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3029:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3033:1: ( ( RULE_ID ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3034:1: ( RULE_ID )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3034:1: ( RULE_ID )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3035:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl6148); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3046:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3050:1: ( rule__QualifiedName__Group__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3051:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__16177);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3057:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3061:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3062:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3062:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3063:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3064:1: ( rule__QualifiedName__Group_1__0 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==35) ) {
                    int LA23_2 = input.LA(2);

                    if ( (LA23_2==RULE_ID) ) {
                        alt23=1;
                    }


                }


                switch (alt23) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3064:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl6204);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3078:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3082:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3083:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__06239);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__06242);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3090:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3094:1: ( ( '.' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3095:1: ( '.' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3095:1: ( '.' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3096:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,35,FOLLOW_35_in_rule__QualifiedName__Group_1__0__Impl6270); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3109:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3113:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3114:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__16301);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3120:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3124:1: ( ( RULE_ID ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3125:1: ( RULE_ID )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3125:1: ( RULE_ID )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3126:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl6328); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3141:1: rule__QualifiedJavaClassName__Group__0 : rule__QualifiedJavaClassName__Group__0__Impl rule__QualifiedJavaClassName__Group__1 ;
    public final void rule__QualifiedJavaClassName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3145:1: ( rule__QualifiedJavaClassName__Group__0__Impl rule__QualifiedJavaClassName__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3146:2: rule__QualifiedJavaClassName__Group__0__Impl rule__QualifiedJavaClassName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__0__Impl_in_rule__QualifiedJavaClassName__Group__06361);
            rule__QualifiedJavaClassName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__1_in_rule__QualifiedJavaClassName__Group__06364);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3153:1: rule__QualifiedJavaClassName__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedJavaClassName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3157:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3158:1: ( ruleQualifiedName )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3158:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3159:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedJavaClassNameAccess().getQualifiedNameParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedJavaClassName__Group__0__Impl6391);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3170:1: rule__QualifiedJavaClassName__Group__1 : rule__QualifiedJavaClassName__Group__1__Impl rule__QualifiedJavaClassName__Group__2 ;
    public final void rule__QualifiedJavaClassName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3174:1: ( rule__QualifiedJavaClassName__Group__1__Impl rule__QualifiedJavaClassName__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3175:2: rule__QualifiedJavaClassName__Group__1__Impl rule__QualifiedJavaClassName__Group__2
            {
            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__1__Impl_in_rule__QualifiedJavaClassName__Group__16420);
            rule__QualifiedJavaClassName__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__2_in_rule__QualifiedJavaClassName__Group__16423);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3182:1: rule__QualifiedJavaClassName__Group__1__Impl : ( '.' ) ;
    public final void rule__QualifiedJavaClassName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3186:1: ( ( '.' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3187:1: ( '.' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3187:1: ( '.' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3188:1: '.'
            {
             before(grammarAccess.getQualifiedJavaClassNameAccess().getFullStopKeyword_1()); 
            match(input,35,FOLLOW_35_in_rule__QualifiedJavaClassName__Group__1__Impl6451); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3201:1: rule__QualifiedJavaClassName__Group__2 : rule__QualifiedJavaClassName__Group__2__Impl ;
    public final void rule__QualifiedJavaClassName__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3205:1: ( rule__QualifiedJavaClassName__Group__2__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3206:2: rule__QualifiedJavaClassName__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__2__Impl_in_rule__QualifiedJavaClassName__Group__26482);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3212:1: rule__QualifiedJavaClassName__Group__2__Impl : ( RULE_UPPERCASE_ID ) ;
    public final void rule__QualifiedJavaClassName__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3216:1: ( ( RULE_UPPERCASE_ID ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3217:1: ( RULE_UPPERCASE_ID )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3217:1: ( RULE_UPPERCASE_ID )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3218:1: RULE_UPPERCASE_ID
            {
             before(grammarAccess.getQualifiedJavaClassNameAccess().getUPPERCASE_IDTerminalRuleCall_2()); 
            match(input,RULE_UPPERCASE_ID,FOLLOW_RULE_UPPERCASE_ID_in_rule__QualifiedJavaClassName__Group__2__Impl6509); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3235:1: rule__QualifiedNameWithWildcard__Group__0 : rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 ;
    public final void rule__QualifiedNameWithWildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3239:1: ( rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3240:2: rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__0__Impl_in_rule__QualifiedNameWithWildcard__Group__06544);
            rule__QualifiedNameWithWildcard__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__1_in_rule__QualifiedNameWithWildcard__Group__06547);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3247:1: rule__QualifiedNameWithWildcard__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedNameWithWildcard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3251:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3252:1: ( ruleQualifiedName )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3252:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3253:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildcard__Group__0__Impl6574);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3264:1: rule__QualifiedNameWithWildcard__Group__1 : rule__QualifiedNameWithWildcard__Group__1__Impl ;
    public final void rule__QualifiedNameWithWildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3268:1: ( rule__QualifiedNameWithWildcard__Group__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3269:2: rule__QualifiedNameWithWildcard__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__1__Impl_in_rule__QualifiedNameWithWildcard__Group__16603);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3275:1: rule__QualifiedNameWithWildcard__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__QualifiedNameWithWildcard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3279:1: ( ( ( '.*' )? ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3280:1: ( ( '.*' )? )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3280:1: ( ( '.*' )? )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3281:1: ( '.*' )?
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3282:1: ( '.*' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==36) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3283:2: '.*'
                    {
                    match(input,36,FOLLOW_36_in_rule__QualifiedNameWithWildcard__Group__1__Impl6632); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3299:1: rule__Model__StatementsAssignment : ( ruleStatement ) ;
    public final void rule__Model__StatementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3303:1: ( ( ruleStatement ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3304:1: ( ruleStatement )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3304:1: ( ruleStatement )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3305:1: ruleStatement
            {
             before(grammarAccess.getModelAccess().getStatementsStatementParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleStatement_in_rule__Model__StatementsAssignment6674);
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


    // $ANTLR start "rule__PackageDefinition__NameAssignment_1"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3314:1: rule__PackageDefinition__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__PackageDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3318:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3319:1: ( ruleQualifiedName )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3319:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3320:1: ruleQualifiedName
            {
             before(grammarAccess.getPackageDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__PackageDefinition__NameAssignment_16705);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3329:1: rule__PackageDefinition__StatementsAssignment_3 : ( rulePackageStatement ) ;
    public final void rule__PackageDefinition__StatementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3333:1: ( ( rulePackageStatement ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3334:1: ( rulePackageStatement )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3334:1: ( rulePackageStatement )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3335:1: rulePackageStatement
            {
             before(grammarAccess.getPackageDefinitionAccess().getStatementsPackageStatementParserRuleCall_3_0()); 
            pushFollow(FOLLOW_rulePackageStatement_in_rule__PackageDefinition__StatementsAssignment_36736);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3344:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleQualifiedNameWithWildcard ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3348:1: ( ( ruleQualifiedNameWithWildcard ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3349:1: ( ruleQualifiedNameWithWildcard )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3349:1: ( ruleQualifiedNameWithWildcard )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3350:1: ruleQualifiedNameWithWildcard
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_rule__Import__ImportedNamespaceAssignment_16767);
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


    // $ANTLR start "rule__TestDefinition__NameAssignment_1"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3359:1: rule__TestDefinition__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__TestDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3363:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3364:1: ( ruleQualifiedName )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3364:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3365:1: ruleQualifiedName
            {
             before(grammarAccess.getTestDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__TestDefinition__NameAssignment_16798);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3374:1: rule__TestDefinition__FixtureMethodAssignment_3 : ( ruleMethodReference ) ;
    public final void rule__TestDefinition__FixtureMethodAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3378:1: ( ( ruleMethodReference ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3379:1: ( ruleMethodReference )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3379:1: ( ruleMethodReference )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3380:1: ruleMethodReference
            {
             before(grammarAccess.getTestDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleMethodReference_in_rule__TestDefinition__FixtureMethodAssignment_36829);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3389:1: rule__CallDefinition__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__CallDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3393:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3394:1: ( ruleQualifiedName )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3394:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3395:1: ruleQualifiedName
            {
             before(grammarAccess.getCallDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__CallDefinition__NameAssignment_16860);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3404:1: rule__CallDefinition__FixtureMethodAssignment_3 : ( ruleMethodReference ) ;
    public final void rule__CallDefinition__FixtureMethodAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3408:1: ( ( ruleMethodReference ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3409:1: ( ruleMethodReference )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3409:1: ( ruleMethodReference )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3410:1: ruleMethodReference
            {
             before(grammarAccess.getCallDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleMethodReference_in_rule__CallDefinition__FixtureMethodAssignment_36891);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3419:1: rule__SuiteDefinition__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__SuiteDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3423:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3424:1: ( ruleQualifiedName )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3424:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3425:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__NameAssignment_16922);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3434:1: rule__SuiteDefinition__ParametersAssignment_2_1 : ( ruleVariableEntity ) ;
    public final void rule__SuiteDefinition__ParametersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3438:1: ( ( ruleVariableEntity ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3439:1: ( ruleVariableEntity )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3439:1: ( ruleVariableEntity )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3440:1: ruleVariableEntity
            {
             before(grammarAccess.getSuiteDefinitionAccess().getParametersVariableEntityParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleVariableEntity_in_rule__SuiteDefinition__ParametersAssignment_2_16953);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3449:1: rule__SuiteDefinition__DependenciesAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__SuiteDefinition__DependenciesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3453:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3454:1: ( ( ruleQualifiedName ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3454:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3455:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSuiteDefinitionAccess().getDependenciesSuiteDefinitionCrossReference_3_1_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3456:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3457:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteDefinitionAccess().getDependenciesSuiteDefinitionQualifiedNameParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__DependenciesAssignment_3_16988);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3468:1: rule__SuiteDefinition__StatementsAssignment_5 : ( ruleSuiteStatement ) ;
    public final void rule__SuiteDefinition__StatementsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3472:1: ( ( ruleSuiteStatement ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3473:1: ( ruleSuiteStatement )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3473:1: ( ruleSuiteStatement )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3474:1: ruleSuiteStatement
            {
             before(grammarAccess.getSuiteDefinitionAccess().getStatementsSuiteStatementParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleSuiteStatement_in_rule__SuiteDefinition__StatementsAssignment_57023);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3483:1: rule__SuiteDefinition__FinalizersAssignment_7_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__SuiteDefinition__FinalizersAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3487:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3488:1: ( ( ruleQualifiedName ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3488:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3489:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSuiteDefinitionAccess().getFinalizersSuiteDefinitionCrossReference_7_1_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3490:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3491:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteDefinitionAccess().getFinalizersSuiteDefinitionQualifiedNameParserRuleCall_7_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__FinalizersAssignment_7_17058);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3502:1: rule__VariableDefinition__NameAssignment_1 : ( ruleVariableEntity ) ;
    public final void rule__VariableDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3506:1: ( ( ruleVariableEntity ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3507:1: ( ruleVariableEntity )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3507:1: ( ruleVariableEntity )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3508:1: ruleVariableEntity
            {
             before(grammarAccess.getVariableDefinitionAccess().getNameVariableEntityParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleVariableEntity_in_rule__VariableDefinition__NameAssignment_17093);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3517:1: rule__VariableDefinition__InitialValueAssignment_2_1 : ( ruleValue ) ;
    public final void rule__VariableDefinition__InitialValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3521:1: ( ( ruleValue ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3522:1: ( ruleValue )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3522:1: ( ruleValue )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3523:1: ruleValue
            {
             before(grammarAccess.getVariableDefinitionAccess().getInitialValueValueParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleValue_in_rule__VariableDefinition__InitialValueAssignment_2_17124);
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


    // $ANTLR start "rule__VariableEntity__NameAssignment"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3532:1: rule__VariableEntity__NameAssignment : ( ruleQualifiedName ) ;
    public final void rule__VariableEntity__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3536:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3537:1: ( ruleQualifiedName )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3537:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3538:1: ruleQualifiedName
            {
             before(grammarAccess.getVariableEntityAccess().getNameQualifiedNameParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__VariableEntity__NameAssignment7155);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3547:1: rule__Test__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Test__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3551:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3552:1: ( ( ruleQualifiedName ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3552:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3553:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getTestAccess().getDefinitionTestDefinitionCrossReference_1_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3554:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3555:1: ruleQualifiedName
            {
             before(grammarAccess.getTestAccess().getDefinitionTestDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Test__DefinitionAssignment_17190);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3566:1: rule__Test__ParametersAssignment_2 : ( ruleParameter ) ;
    public final void rule__Test__ParametersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3570:1: ( ( ruleParameter ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3571:1: ( ruleParameter )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3571:1: ( ruleParameter )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3572:1: ruleParameter
            {
             before(grammarAccess.getTestAccess().getParametersParameterParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleParameter_in_rule__Test__ParametersAssignment_27225);
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


    // $ANTLR start "rule__Test__ResultAssignment_3_1"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3581:1: rule__Test__ResultAssignment_3_1 : ( ruleValueOrEnumValue ) ;
    public final void rule__Test__ResultAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3585:1: ( ( ruleValueOrEnumValue ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3586:1: ( ruleValueOrEnumValue )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3586:1: ( ruleValueOrEnumValue )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3587:1: ruleValueOrEnumValue
            {
             before(grammarAccess.getTestAccess().getResultValueOrEnumValueParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_rule__Test__ResultAssignment_3_17256);
            ruleValueOrEnumValue();

            state._fsp--;

             after(grammarAccess.getTestAccess().getResultValueOrEnumValueParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Test__ResultAssignment_3_1"


    // $ANTLR start "rule__Call__DefinitionAssignment_1"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3596:1: rule__Call__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Call__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3600:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3601:1: ( ( ruleQualifiedName ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3601:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3602:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getCallAccess().getDefinitionCallDefinitionCrossReference_1_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3603:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3604:1: ruleQualifiedName
            {
             before(grammarAccess.getCallAccess().getDefinitionCallDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Call__DefinitionAssignment_17291);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3615:1: rule__Call__ParametersAssignment_2 : ( ruleParameter ) ;
    public final void rule__Call__ParametersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3619:1: ( ( ruleParameter ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3620:1: ( ruleParameter )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3620:1: ( ruleParameter )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3621:1: ruleParameter
            {
             before(grammarAccess.getCallAccess().getParametersParameterParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleParameter_in_rule__Call__ParametersAssignment_27326);
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


    // $ANTLR start "rule__Call__ResultAssignment_3_1"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3630:1: rule__Call__ResultAssignment_3_1 : ( ruleVariable ) ;
    public final void rule__Call__ResultAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3634:1: ( ( ruleVariable ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3635:1: ( ruleVariable )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3635:1: ( ruleVariable )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3636:1: ruleVariable
            {
             before(grammarAccess.getCallAccess().getResultVariableParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleVariable_in_rule__Call__ResultAssignment_3_17357);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getCallAccess().getResultVariableParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Call__ResultAssignment_3_1"


    // $ANTLR start "rule__Suite__DefinitionAssignment_1"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3645:1: rule__Suite__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Suite__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3649:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3650:1: ( ( ruleQualifiedName ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3650:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3651:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSuiteAccess().getDefinitionSuiteDefinitionCrossReference_1_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3652:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3653:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteAccess().getDefinitionSuiteDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Suite__DefinitionAssignment_17392);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3664:1: rule__Suite__ParametersAssignment_2 : ( ruleSuiteParameter ) ;
    public final void rule__Suite__ParametersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3668:1: ( ( ruleSuiteParameter ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3669:1: ( ruleSuiteParameter )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3669:1: ( ruleSuiteParameter )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3670:1: ruleSuiteParameter
            {
             before(grammarAccess.getSuiteAccess().getParametersSuiteParameterParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleSuiteParameter_in_rule__Suite__ParametersAssignment_27427);
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


    // $ANTLR start "rule__SuiteParameter__NameAssignment_0"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3679:1: rule__SuiteParameter__NameAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__SuiteParameter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3683:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3684:1: ( ( ruleQualifiedName ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3684:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3685:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSuiteParameterAccess().getNameVariableEntityCrossReference_0_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3686:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3687:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteParameterAccess().getNameVariableEntityQualifiedNameParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__SuiteParameter__NameAssignment_07462);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3698:1: rule__SuiteParameter__ValueAssignment_2 : ( ruleValue ) ;
    public final void rule__SuiteParameter__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3702:1: ( ( ruleValue ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3703:1: ( ruleValue )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3703:1: ( ruleValue )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3704:1: ruleValue
            {
             before(grammarAccess.getSuiteParameterAccess().getValueValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleValue_in_rule__SuiteParameter__ValueAssignment_27497);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3713:1: rule__Parameter__NameAssignment_0 : ( ruleParameterName ) ;
    public final void rule__Parameter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3717:1: ( ( ruleParameterName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3718:1: ( ruleParameterName )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3718:1: ( ruleParameterName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3719:1: ruleParameterName
            {
             before(grammarAccess.getParameterAccess().getNameParameterNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleParameterName_in_rule__Parameter__NameAssignment_07528);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3728:1: rule__Parameter__ValueAssignment_2 : ( ruleValueOrEnumValue ) ;
    public final void rule__Parameter__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3732:1: ( ( ruleValueOrEnumValue ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3733:1: ( ruleValueOrEnumValue )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3733:1: ( ruleValueOrEnumValue )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3734:1: ruleValueOrEnumValue
            {
             before(grammarAccess.getParameterAccess().getValueValueOrEnumValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_rule__Parameter__ValueAssignment_27559);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3743:1: rule__FixedParameterName__AnnotationAssignment : ( ( RULE_ID ) ) ;
    public final void rule__FixedParameterName__AnnotationAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3747:1: ( ( ( RULE_ID ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3748:1: ( ( RULE_ID ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3748:1: ( ( RULE_ID ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3749:1: ( RULE_ID )
            {
             before(grammarAccess.getFixedParameterNameAccess().getAnnotationJvmAnnotationReferenceCrossReference_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3750:1: ( RULE_ID )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3751:1: RULE_ID
            {
             before(grammarAccess.getFixedParameterNameAccess().getAnnotationJvmAnnotationReferenceIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FixedParameterName__AnnotationAssignment7594); 
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


    // $ANTLR start "rule__ArbitraryParameterName__IdentifierAssignment_1"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3762:1: rule__ArbitraryParameterName__IdentifierAssignment_1 : ( RULE_ID ) ;
    public final void rule__ArbitraryParameterName__IdentifierAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3766:1: ( ( RULE_ID ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3767:1: ( RULE_ID )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3767:1: ( RULE_ID )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3768:1: RULE_ID
            {
             before(grammarAccess.getArbitraryParameterNameAccess().getIdentifierIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ArbitraryParameterName__IdentifierAssignment_17629); 
             after(grammarAccess.getArbitraryParameterNameAccess().getIdentifierIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArbitraryParameterName__IdentifierAssignment_1"


    // $ANTLR start "rule__IntegerValue__IntegerValueAssignment"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3777:1: rule__IntegerValue__IntegerValueAssignment : ( RULE_INTEGER ) ;
    public final void rule__IntegerValue__IntegerValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3781:1: ( ( RULE_INTEGER ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3782:1: ( RULE_INTEGER )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3782:1: ( RULE_INTEGER )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3783:1: RULE_INTEGER
            {
             before(grammarAccess.getIntegerValueAccess().getIntegerValueINTEGERTerminalRuleCall_0()); 
            match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_rule__IntegerValue__IntegerValueAssignment7660); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3792:1: rule__DecimalValue__DecimalValueAssignment : ( RULE_DECIMAL ) ;
    public final void rule__DecimalValue__DecimalValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3796:1: ( ( RULE_DECIMAL ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3797:1: ( RULE_DECIMAL )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3797:1: ( RULE_DECIMAL )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3798:1: RULE_DECIMAL
            {
             before(grammarAccess.getDecimalValueAccess().getDecimalValueDECIMALTerminalRuleCall_0()); 
            match(input,RULE_DECIMAL,FOLLOW_RULE_DECIMAL_in_rule__DecimalValue__DecimalValueAssignment7691); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3807:1: rule__StringValue__StringValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringValue__StringValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3811:1: ( ( RULE_STRING ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3812:1: ( RULE_STRING )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3812:1: ( RULE_STRING )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3813:1: RULE_STRING
            {
             before(grammarAccess.getStringValueAccess().getStringValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringValue__StringValueAssignment7722); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3822:1: rule__Variable__NameAssignment : ( ( ruleQualifiedName ) ) ;
    public final void rule__Variable__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3826:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3827:1: ( ( ruleQualifiedName ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3827:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3828:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getVariableAccess().getNameVariableEntityCrossReference_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3829:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3830:1: ruleQualifiedName
            {
             before(grammarAccess.getVariableAccess().getNameVariableEntityQualifiedNameParserRuleCall_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Variable__NameAssignment7757);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3841:1: rule__EnumValue__EnumValueAssignment : ( ( RULE_UPPERCASE_ID ) ) ;
    public final void rule__EnumValue__EnumValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3845:1: ( ( ( RULE_UPPERCASE_ID ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3846:1: ( ( RULE_UPPERCASE_ID ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3846:1: ( ( RULE_UPPERCASE_ID ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3847:1: ( RULE_UPPERCASE_ID )
            {
             before(grammarAccess.getEnumValueAccess().getEnumValueJvmEnumerationLiteralCrossReference_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3848:1: ( RULE_UPPERCASE_ID )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3849:1: RULE_UPPERCASE_ID
            {
             before(grammarAccess.getEnumValueAccess().getEnumValueJvmEnumerationLiteralUPPERCASE_IDTerminalRuleCall_0_1()); 
            match(input,RULE_UPPERCASE_ID,FOLLOW_RULE_UPPERCASE_ID_in_rule__EnumValue__EnumValueAssignment7796); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3860:1: rule__MethodReference__TypeAssignment_0 : ( ( ruleQualifiedJavaClassName ) ) ;
    public final void rule__MethodReference__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3864:1: ( ( ( ruleQualifiedJavaClassName ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3865:1: ( ( ruleQualifiedJavaClassName ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3865:1: ( ( ruleQualifiedJavaClassName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3866:1: ( ruleQualifiedJavaClassName )
            {
             before(grammarAccess.getMethodReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3867:1: ( ruleQualifiedJavaClassName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3868:1: ruleQualifiedJavaClassName
            {
             before(grammarAccess.getMethodReferenceAccess().getTypeJvmTypeQualifiedJavaClassNameParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_rule__MethodReference__TypeAssignment_07835);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3879:1: rule__MethodReference__MethodAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__MethodReference__MethodAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3883:1: ( ( ( RULE_ID ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3884:1: ( ( RULE_ID ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3884:1: ( ( RULE_ID ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3885:1: ( RULE_ID )
            {
             before(grammarAccess.getMethodReferenceAccess().getMethodJvmOperationCrossReference_2_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3886:1: ( RULE_ID )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3887:1: RULE_ID
            {
             before(grammarAccess.getMethodReferenceAccess().getMethodJvmOperationIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__MethodReference__MethodAssignment_27874); 
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
    public static final BitSet FOLLOW_rule__Model__StatementsAssignment_in_ruleModel94 = new BitSet(new long[]{0x0000000080012002L});
    public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement122 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatement129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Statement__Alternatives_in_ruleStatement155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDefinition_in_entryRulePackageDefinition182 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageDefinition189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__0_in_rulePackageDefinition215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageStatement_in_entryRulePackageStatement242 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageStatement249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageStatement__Alternatives_in_rulePackageStatement275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport302 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestDefinition_in_entryRuleTestDefinition362 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestDefinition369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__0_in_ruleTestDefinition395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallDefinition_in_entryRuleCallDefinition422 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallDefinition429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__0_in_ruleCallDefinition455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteDefinition_in_entryRuleSuiteDefinition482 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteDefinition489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__0_in_ruleSuiteDefinition515 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteStatement_in_entryRuleSuiteStatement542 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteStatement549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteStatement__Alternatives_in_ruleSuiteStatement575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteStatementWithResult_in_entryRuleSuiteStatementWithResult602 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteStatementWithResult609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteStatementWithResult__Alternatives_in_ruleSuiteStatementWithResult635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_entryRuleVariableDefinition662 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDefinition669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__0_in_ruleVariableDefinition695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_entryRuleVariableEntity722 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableEntity729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableEntity__NameAssignment_in_ruleVariableEntity755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTest_in_entryRuleTest782 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTest789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group__0_in_ruleTest815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_entryRuleCall842 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCall849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__0_in_ruleCall875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_entryRuleSuite902 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuite909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group__0_in_ruleSuite935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteParameter_in_entryRuleSuiteParameter962 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteParameter969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__0_in_ruleSuiteParameter995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter1022 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter1029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__0_in_ruleParameter1055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterName_in_entryRuleParameterName1082 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterName1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterName__Alternatives_in_ruleParameterName1115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedParameterName_in_entryRuleFixedParameterName1142 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFixedParameterName1149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FixedParameterName__AnnotationAssignment_in_ruleFixedParameterName1175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterName_in_entryRuleArbitraryParameterName1202 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArbitraryParameterName1209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArbitraryParameterName__Group__0_in_ruleArbitraryParameterName1235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_entryRuleValueOrEnumValue1262 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueOrEnumValue1269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueOrEnumValue__Alternatives_in_ruleValueOrEnumValue1295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue1322 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue1329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Alternatives_in_ruleValue1355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerValue_in_entryRuleIntegerValue1382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerValue1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntegerValue__IntegerValueAssignment_in_ruleIntegerValue1415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalValue_in_entryRuleDecimalValue1442 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalValue1449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalValue__DecimalValueAssignment_in_ruleDecimalValue1475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringValue_in_entryRuleStringValue1502 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringValue1509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringValue__StringValueAssignment_in_ruleStringValue1535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable1562 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable1569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__NameAssignment_in_ruleVariable1595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumValue_in_entryRuleEnumValue1622 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumValue1629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumValue__EnumValueAssignment_in_ruleEnumValue1655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodReference_in_entryRuleMethodReference1682 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodReference1689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__0_in_ruleMethodReference1715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1742 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName1749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName1775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_entryRuleQualifiedJavaClassName1802 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedJavaClassName1809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__0_in_ruleQualifiedJavaClassName1835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard1862 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard1869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__0_in_ruleQualifiedNameWithWildcard1895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDefinition_in_rule__Statement__Alternatives1931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__Statement__Alternatives1948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_rule__Statement__Alternatives1965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__PackageStatement__Alternatives1997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestDefinition_in_rule__PackageStatement__Alternatives2014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallDefinition_in_rule__PackageStatement__Alternatives2031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteDefinition_in_rule__PackageStatement__Alternatives2048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_rule__PackageStatement__Alternatives2065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteStatementWithResult_in_rule__SuiteStatement__Alternatives2097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_rule__SuiteStatement__Alternatives2114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_rule__SuiteStatement__Alternatives2131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_rule__SuiteStatementWithResult__Alternatives2163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTest_in_rule__SuiteStatementWithResult__Alternatives2180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedParameterName_in_rule__ParameterName__Alternatives2212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterName_in_rule__ParameterName__Alternatives2229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__ValueOrEnumValue__Alternatives2261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumValue_in_rule__ValueOrEnumValue__Alternatives2278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringValue_in_rule__Value__Alternatives2310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerValue_in_rule__Value__Alternatives2327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalValue_in_rule__Value__Alternatives2344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__Value__Alternatives2361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__0__Impl_in_rule__PackageDefinition__Group__02391 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__1_in_rule__PackageDefinition__Group__02394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__PackageDefinition__Group__0__Impl2422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__1__Impl_in_rule__PackageDefinition__Group__12453 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__2_in_rule__PackageDefinition__Group__12456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__NameAssignment_1_in_rule__PackageDefinition__Group__1__Impl2483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__2__Impl_in_rule__PackageDefinition__Group__22513 = new BitSet(new long[]{0x00000000021B8000L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__3_in_rule__PackageDefinition__Group__22516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__PackageDefinition__Group__2__Impl2544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__3__Impl_in_rule__PackageDefinition__Group__32575 = new BitSet(new long[]{0x00000000021B8000L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__4_in_rule__PackageDefinition__Group__32578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__StatementsAssignment_3_in_rule__PackageDefinition__Group__3__Impl2605 = new BitSet(new long[]{0x00000000021B0002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__4__Impl_in_rule__PackageDefinition__Group__42636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__PackageDefinition__Group__4__Impl2664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__02705 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__02708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Import__Group__0__Impl2736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__12767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl2794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__0__Impl_in_rule__TestDefinition__Group__02828 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__1_in_rule__TestDefinition__Group__02831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__TestDefinition__Group__0__Impl2859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__1__Impl_in_rule__TestDefinition__Group__12890 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__2_in_rule__TestDefinition__Group__12893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__NameAssignment_1_in_rule__TestDefinition__Group__1__Impl2920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__2__Impl_in_rule__TestDefinition__Group__22950 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__3_in_rule__TestDefinition__Group__22953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__TestDefinition__Group__2__Impl2981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__3__Impl_in_rule__TestDefinition__Group__33012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__FixtureMethodAssignment_3_in_rule__TestDefinition__Group__3__Impl3039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__0__Impl_in_rule__CallDefinition__Group__03077 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__1_in_rule__CallDefinition__Group__03080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__CallDefinition__Group__0__Impl3108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__1__Impl_in_rule__CallDefinition__Group__13139 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__2_in_rule__CallDefinition__Group__13142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__NameAssignment_1_in_rule__CallDefinition__Group__1__Impl3169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__2__Impl_in_rule__CallDefinition__Group__23199 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__3_in_rule__CallDefinition__Group__23202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__CallDefinition__Group__2__Impl3230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__3__Impl_in_rule__CallDefinition__Group__33261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__FixtureMethodAssignment_3_in_rule__CallDefinition__Group__3__Impl3288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__0__Impl_in_rule__SuiteDefinition__Group__03326 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__1_in_rule__SuiteDefinition__Group__03329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__SuiteDefinition__Group__0__Impl3357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__1__Impl_in_rule__SuiteDefinition__Group__13388 = new BitSet(new long[]{0x0000000000C04000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__2_in_rule__SuiteDefinition__Group__13391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__NameAssignment_1_in_rule__SuiteDefinition__Group__1__Impl3418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__2__Impl_in_rule__SuiteDefinition__Group__23448 = new BitSet(new long[]{0x0000000000C04000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__3_in_rule__SuiteDefinition__Group__23451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_2__0_in_rule__SuiteDefinition__Group__2__Impl3478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__3__Impl_in_rule__SuiteDefinition__Group__33509 = new BitSet(new long[]{0x0000000000C04000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__4_in_rule__SuiteDefinition__Group__33512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_3__0_in_rule__SuiteDefinition__Group__3__Impl3539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__4__Impl_in_rule__SuiteDefinition__Group__43570 = new BitSet(new long[]{0x00000000AA3B2000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__5_in_rule__SuiteDefinition__Group__43573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__SuiteDefinition__Group__4__Impl3601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__5__Impl_in_rule__SuiteDefinition__Group__53632 = new BitSet(new long[]{0x00000000AA3B2000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__6_in_rule__SuiteDefinition__Group__53635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__StatementsAssignment_5_in_rule__SuiteDefinition__Group__5__Impl3662 = new BitSet(new long[]{0x00000000AA1B2002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__6__Impl_in_rule__SuiteDefinition__Group__63693 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__7_in_rule__SuiteDefinition__Group__63696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__SuiteDefinition__Group__6__Impl3724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__7__Impl_in_rule__SuiteDefinition__Group__73755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_7__0_in_rule__SuiteDefinition__Group__7__Impl3782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_2__0__Impl_in_rule__SuiteDefinition__Group_2__03829 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_2__1_in_rule__SuiteDefinition__Group_2__03832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__SuiteDefinition__Group_2__0__Impl3860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_2__1__Impl_in_rule__SuiteDefinition__Group_2__13891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__ParametersAssignment_2_1_in_rule__SuiteDefinition__Group_2__1__Impl3918 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_3__0__Impl_in_rule__SuiteDefinition__Group_3__03953 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_3__1_in_rule__SuiteDefinition__Group_3__03956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__SuiteDefinition__Group_3__0__Impl3984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_3__1__Impl_in_rule__SuiteDefinition__Group_3__14015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__DependenciesAssignment_3_1_in_rule__SuiteDefinition__Group_3__1__Impl4042 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_7__0__Impl_in_rule__SuiteDefinition__Group_7__04077 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_7__1_in_rule__SuiteDefinition__Group_7__04080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__SuiteDefinition__Group_7__0__Impl4108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_7__1__Impl_in_rule__SuiteDefinition__Group_7__14139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__FinalizersAssignment_7_1_in_rule__SuiteDefinition__Group_7__1__Impl4166 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__0__Impl_in_rule__VariableDefinition__Group__04201 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__1_in_rule__VariableDefinition__Group__04204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__VariableDefinition__Group__0__Impl4232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__1__Impl_in_rule__VariableDefinition__Group__14263 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__2_in_rule__VariableDefinition__Group__14266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__NameAssignment_1_in_rule__VariableDefinition__Group__1__Impl4293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__2__Impl_in_rule__VariableDefinition__Group__24323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group_2__0_in_rule__VariableDefinition__Group__2__Impl4350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group_2__0__Impl_in_rule__VariableDefinition__Group_2__04387 = new BitSet(new long[]{0x00000000000001D0L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group_2__1_in_rule__VariableDefinition__Group_2__04390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__VariableDefinition__Group_2__0__Impl4418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group_2__1__Impl_in_rule__VariableDefinition__Group_2__14449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__InitialValueAssignment_2_1_in_rule__VariableDefinition__Group_2__1__Impl4476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group__0__Impl_in_rule__Test__Group__04510 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Test__Group__1_in_rule__Test__Group__04513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Test__Group__0__Impl4541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group__1__Impl_in_rule__Test__Group__14572 = new BitSet(new long[]{0x0000000210000010L});
    public static final BitSet FOLLOW_rule__Test__Group__2_in_rule__Test__Group__14575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__DefinitionAssignment_1_in_rule__Test__Group__1__Impl4602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group__2__Impl_in_rule__Test__Group__24632 = new BitSet(new long[]{0x0000000210000010L});
    public static final BitSet FOLLOW_rule__Test__Group__3_in_rule__Test__Group__24635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__ParametersAssignment_2_in_rule__Test__Group__2__Impl4662 = new BitSet(new long[]{0x0000000200000012L});
    public static final BitSet FOLLOW_rule__Test__Group__3__Impl_in_rule__Test__Group__34693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group_3__0_in_rule__Test__Group__3__Impl4720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group_3__0__Impl_in_rule__Test__Group_3__04759 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__Test__Group_3__1_in_rule__Test__Group_3__04762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Test__Group_3__0__Impl4790 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group_3__1__Impl_in_rule__Test__Group_3__14821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__ResultAssignment_3_1_in_rule__Test__Group_3__1__Impl4848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__0__Impl_in_rule__Call__Group__04882 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Call__Group__1_in_rule__Call__Group__04885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Call__Group__0__Impl4913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__1__Impl_in_rule__Call__Group__14944 = new BitSet(new long[]{0x0000000240000010L});
    public static final BitSet FOLLOW_rule__Call__Group__2_in_rule__Call__Group__14947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__DefinitionAssignment_1_in_rule__Call__Group__1__Impl4974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__2__Impl_in_rule__Call__Group__25004 = new BitSet(new long[]{0x0000000240000010L});
    public static final BitSet FOLLOW_rule__Call__Group__3_in_rule__Call__Group__25007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__ParametersAssignment_2_in_rule__Call__Group__2__Impl5034 = new BitSet(new long[]{0x0000000200000012L});
    public static final BitSet FOLLOW_rule__Call__Group__3__Impl_in_rule__Call__Group__35065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group_3__0_in_rule__Call__Group__3__Impl5092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group_3__0__Impl_in_rule__Call__Group_3__05131 = new BitSet(new long[]{0x00000000000001D0L});
    public static final BitSet FOLLOW_rule__Call__Group_3__1_in_rule__Call__Group_3__05134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__Call__Group_3__0__Impl5162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group_3__1__Impl_in_rule__Call__Group_3__15193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__ResultAssignment_3_1_in_rule__Call__Group_3__1__Impl5220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group__0__Impl_in_rule__Suite__Group__05254 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Suite__Group__1_in_rule__Suite__Group__05257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Suite__Group__0__Impl5285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group__1__Impl_in_rule__Suite__Group__15316 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Suite__Group__2_in_rule__Suite__Group__15319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__DefinitionAssignment_1_in_rule__Suite__Group__1__Impl5346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group__2__Impl_in_rule__Suite__Group__25376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__ParametersAssignment_2_in_rule__Suite__Group__2__Impl5403 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__0__Impl_in_rule__SuiteParameter__Group__05440 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__1_in_rule__SuiteParameter__Group__05443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__NameAssignment_0_in_rule__SuiteParameter__Group__0__Impl5470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__1__Impl_in_rule__SuiteParameter__Group__15500 = new BitSet(new long[]{0x00000000000001D0L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__2_in_rule__SuiteParameter__Group__15503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__SuiteParameter__Group__1__Impl5531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__2__Impl_in_rule__SuiteParameter__Group__25562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__ValueAssignment_2_in_rule__SuiteParameter__Group__2__Impl5589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__05625 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__05628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__NameAssignment_0_in_rule__Parameter__Group__0__Impl5655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__15685 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__Parameter__Group__2_in_rule__Parameter__Group__15688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Parameter__Group__1__Impl5716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__2__Impl_in_rule__Parameter__Group__25747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__ValueAssignment_2_in_rule__Parameter__Group__2__Impl5774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArbitraryParameterName__Group__0__Impl_in_rule__ArbitraryParameterName__Group__05810 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ArbitraryParameterName__Group__1_in_rule__ArbitraryParameterName__Group__05813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__ArbitraryParameterName__Group__0__Impl5841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArbitraryParameterName__Group__1__Impl_in_rule__ArbitraryParameterName__Group__15872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArbitraryParameterName__IdentifierAssignment_1_in_rule__ArbitraryParameterName__Group__1__Impl5899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__0__Impl_in_rule__MethodReference__Group__05933 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__1_in_rule__MethodReference__Group__05936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__TypeAssignment_0_in_rule__MethodReference__Group__0__Impl5963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__1__Impl_in_rule__MethodReference__Group__15993 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__2_in_rule__MethodReference__Group__15996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__MethodReference__Group__1__Impl6024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__2__Impl_in_rule__MethodReference__Group__26055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__MethodAssignment_2_in_rule__MethodReference__Group__2__Impl6082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__06118 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__06121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl6148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__16177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl6204 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__06239 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__06242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__QualifiedName__Group_1__0__Impl6270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__16301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl6328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__0__Impl_in_rule__QualifiedJavaClassName__Group__06361 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__1_in_rule__QualifiedJavaClassName__Group__06364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedJavaClassName__Group__0__Impl6391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__1__Impl_in_rule__QualifiedJavaClassName__Group__16420 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__2_in_rule__QualifiedJavaClassName__Group__16423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__QualifiedJavaClassName__Group__1__Impl6451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__2__Impl_in_rule__QualifiedJavaClassName__Group__26482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UPPERCASE_ID_in_rule__QualifiedJavaClassName__Group__2__Impl6509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__0__Impl_in_rule__QualifiedNameWithWildcard__Group__06544 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__1_in_rule__QualifiedNameWithWildcard__Group__06547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildcard__Group__0__Impl6574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__1__Impl_in_rule__QualifiedNameWithWildcard__Group__16603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__QualifiedNameWithWildcard__Group__1__Impl6632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_rule__Model__StatementsAssignment6674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__PackageDefinition__NameAssignment_16705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageStatement_in_rule__PackageDefinition__StatementsAssignment_36736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_rule__Import__ImportedNamespaceAssignment_16767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__TestDefinition__NameAssignment_16798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodReference_in_rule__TestDefinition__FixtureMethodAssignment_36829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__CallDefinition__NameAssignment_16860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodReference_in_rule__CallDefinition__FixtureMethodAssignment_36891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__NameAssignment_16922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_rule__SuiteDefinition__ParametersAssignment_2_16953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__DependenciesAssignment_3_16988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteStatement_in_rule__SuiteDefinition__StatementsAssignment_57023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__FinalizersAssignment_7_17058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_rule__VariableDefinition__NameAssignment_17093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__VariableDefinition__InitialValueAssignment_2_17124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__VariableEntity__NameAssignment7155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Test__DefinitionAssignment_17190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_rule__Test__ParametersAssignment_27225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_rule__Test__ResultAssignment_3_17256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Call__DefinitionAssignment_17291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_rule__Call__ParametersAssignment_27326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__Call__ResultAssignment_3_17357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Suite__DefinitionAssignment_17392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteParameter_in_rule__Suite__ParametersAssignment_27427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__SuiteParameter__NameAssignment_07462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__SuiteParameter__ValueAssignment_27497 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterName_in_rule__Parameter__NameAssignment_07528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_rule__Parameter__ValueAssignment_27559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FixedParameterName__AnnotationAssignment7594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ArbitraryParameterName__IdentifierAssignment_17629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_rule__IntegerValue__IntegerValueAssignment7660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DECIMAL_in_rule__DecimalValue__DecimalValueAssignment7691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringValue__StringValueAssignment7722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Variable__NameAssignment7757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UPPERCASE_ID_in_rule__EnumValue__EnumValueAssignment7796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_rule__MethodReference__TypeAssignment_07835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__MethodReference__MethodAssignment_27874 = new BitSet(new long[]{0x0000000000000002L});

}