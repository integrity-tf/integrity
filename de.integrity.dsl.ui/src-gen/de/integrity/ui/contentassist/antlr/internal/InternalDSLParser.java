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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_UPPERCASE_ID", "RULE_INTEGER", "RULE_DECIMAL", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'packagedef'", "'with'", "'packageend'", "'import'", "'testdef'", "'uses'", "'calldef'", "'suitedef'", "'suiteend'", "'gets'", "'requires'", "'concludedby'", "'variable'", "'initially'", "'test'", "'='", "'call'", "'sets'", "'suite'", "':'", "'#'", "'.'", "'.*'"
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


    // $ANTLR start "entryRuleValueOrEnumValue"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:536:1: entryRuleValueOrEnumValue : ruleValueOrEnumValue EOF ;
    public final void entryRuleValueOrEnumValue() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:537:1: ( ruleValueOrEnumValue EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:538:1: ruleValueOrEnumValue EOF
            {
             before(grammarAccess.getValueOrEnumValueRule()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_entryRuleValueOrEnumValue1082);
            ruleValueOrEnumValue();

            state._fsp--;

             after(grammarAccess.getValueOrEnumValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueOrEnumValue1089); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:545:1: ruleValueOrEnumValue : ( ( rule__ValueOrEnumValue__Alternatives ) ) ;
    public final void ruleValueOrEnumValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:549:2: ( ( ( rule__ValueOrEnumValue__Alternatives ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:550:1: ( ( rule__ValueOrEnumValue__Alternatives ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:550:1: ( ( rule__ValueOrEnumValue__Alternatives ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:551:1: ( rule__ValueOrEnumValue__Alternatives )
            {
             before(grammarAccess.getValueOrEnumValueAccess().getAlternatives()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:552:1: ( rule__ValueOrEnumValue__Alternatives )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:552:2: rule__ValueOrEnumValue__Alternatives
            {
            pushFollow(FOLLOW_rule__ValueOrEnumValue__Alternatives_in_ruleValueOrEnumValue1115);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:564:1: entryRuleValue : ruleValue EOF ;
    public final void entryRuleValue() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:565:1: ( ruleValue EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:566:1: ruleValue EOF
            {
             before(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue1142);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue1149); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:573:1: ruleValue : ( ( rule__Value__Alternatives ) ) ;
    public final void ruleValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:577:2: ( ( ( rule__Value__Alternatives ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:578:1: ( ( rule__Value__Alternatives ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:578:1: ( ( rule__Value__Alternatives ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:579:1: ( rule__Value__Alternatives )
            {
             before(grammarAccess.getValueAccess().getAlternatives()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:580:1: ( rule__Value__Alternatives )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:580:2: rule__Value__Alternatives
            {
            pushFollow(FOLLOW_rule__Value__Alternatives_in_ruleValue1175);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:592:1: entryRuleIntegerValue : ruleIntegerValue EOF ;
    public final void entryRuleIntegerValue() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:593:1: ( ruleIntegerValue EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:594:1: ruleIntegerValue EOF
            {
             before(grammarAccess.getIntegerValueRule()); 
            pushFollow(FOLLOW_ruleIntegerValue_in_entryRuleIntegerValue1202);
            ruleIntegerValue();

            state._fsp--;

             after(grammarAccess.getIntegerValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerValue1209); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:601:1: ruleIntegerValue : ( ( rule__IntegerValue__IntegerValueAssignment ) ) ;
    public final void ruleIntegerValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:605:2: ( ( ( rule__IntegerValue__IntegerValueAssignment ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:606:1: ( ( rule__IntegerValue__IntegerValueAssignment ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:606:1: ( ( rule__IntegerValue__IntegerValueAssignment ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:607:1: ( rule__IntegerValue__IntegerValueAssignment )
            {
             before(grammarAccess.getIntegerValueAccess().getIntegerValueAssignment()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:608:1: ( rule__IntegerValue__IntegerValueAssignment )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:608:2: rule__IntegerValue__IntegerValueAssignment
            {
            pushFollow(FOLLOW_rule__IntegerValue__IntegerValueAssignment_in_ruleIntegerValue1235);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:620:1: entryRuleDecimalValue : ruleDecimalValue EOF ;
    public final void entryRuleDecimalValue() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:621:1: ( ruleDecimalValue EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:622:1: ruleDecimalValue EOF
            {
             before(grammarAccess.getDecimalValueRule()); 
            pushFollow(FOLLOW_ruleDecimalValue_in_entryRuleDecimalValue1262);
            ruleDecimalValue();

            state._fsp--;

             after(grammarAccess.getDecimalValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalValue1269); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:629:1: ruleDecimalValue : ( ( rule__DecimalValue__DecimalValueAssignment ) ) ;
    public final void ruleDecimalValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:633:2: ( ( ( rule__DecimalValue__DecimalValueAssignment ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:634:1: ( ( rule__DecimalValue__DecimalValueAssignment ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:634:1: ( ( rule__DecimalValue__DecimalValueAssignment ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:635:1: ( rule__DecimalValue__DecimalValueAssignment )
            {
             before(grammarAccess.getDecimalValueAccess().getDecimalValueAssignment()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:636:1: ( rule__DecimalValue__DecimalValueAssignment )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:636:2: rule__DecimalValue__DecimalValueAssignment
            {
            pushFollow(FOLLOW_rule__DecimalValue__DecimalValueAssignment_in_ruleDecimalValue1295);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:648:1: entryRuleStringValue : ruleStringValue EOF ;
    public final void entryRuleStringValue() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:649:1: ( ruleStringValue EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:650:1: ruleStringValue EOF
            {
             before(grammarAccess.getStringValueRule()); 
            pushFollow(FOLLOW_ruleStringValue_in_entryRuleStringValue1322);
            ruleStringValue();

            state._fsp--;

             after(grammarAccess.getStringValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringValue1329); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:657:1: ruleStringValue : ( ( rule__StringValue__StringValueAssignment ) ) ;
    public final void ruleStringValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:661:2: ( ( ( rule__StringValue__StringValueAssignment ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:662:1: ( ( rule__StringValue__StringValueAssignment ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:662:1: ( ( rule__StringValue__StringValueAssignment ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:663:1: ( rule__StringValue__StringValueAssignment )
            {
             before(grammarAccess.getStringValueAccess().getStringValueAssignment()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:664:1: ( rule__StringValue__StringValueAssignment )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:664:2: rule__StringValue__StringValueAssignment
            {
            pushFollow(FOLLOW_rule__StringValue__StringValueAssignment_in_ruleStringValue1355);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:676:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:677:1: ( ruleVariable EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:678:1: ruleVariable EOF
            {
             before(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable1382);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getVariableRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable1389); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:685:1: ruleVariable : ( ( rule__Variable__NameAssignment ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:689:2: ( ( ( rule__Variable__NameAssignment ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:690:1: ( ( rule__Variable__NameAssignment ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:690:1: ( ( rule__Variable__NameAssignment ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:691:1: ( rule__Variable__NameAssignment )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:692:1: ( rule__Variable__NameAssignment )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:692:2: rule__Variable__NameAssignment
            {
            pushFollow(FOLLOW_rule__Variable__NameAssignment_in_ruleVariable1415);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:704:1: entryRuleEnumValue : ruleEnumValue EOF ;
    public final void entryRuleEnumValue() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:705:1: ( ruleEnumValue EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:706:1: ruleEnumValue EOF
            {
             before(grammarAccess.getEnumValueRule()); 
            pushFollow(FOLLOW_ruleEnumValue_in_entryRuleEnumValue1442);
            ruleEnumValue();

            state._fsp--;

             after(grammarAccess.getEnumValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumValue1449); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:713:1: ruleEnumValue : ( ( rule__EnumValue__EnumValueAssignment ) ) ;
    public final void ruleEnumValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:717:2: ( ( ( rule__EnumValue__EnumValueAssignment ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:718:1: ( ( rule__EnumValue__EnumValueAssignment ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:718:1: ( ( rule__EnumValue__EnumValueAssignment ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:719:1: ( rule__EnumValue__EnumValueAssignment )
            {
             before(grammarAccess.getEnumValueAccess().getEnumValueAssignment()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:720:1: ( rule__EnumValue__EnumValueAssignment )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:720:2: rule__EnumValue__EnumValueAssignment
            {
            pushFollow(FOLLOW_rule__EnumValue__EnumValueAssignment_in_ruleEnumValue1475);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:732:1: entryRuleMethodReference : ruleMethodReference EOF ;
    public final void entryRuleMethodReference() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:733:1: ( ruleMethodReference EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:734:1: ruleMethodReference EOF
            {
             before(grammarAccess.getMethodReferenceRule()); 
            pushFollow(FOLLOW_ruleMethodReference_in_entryRuleMethodReference1502);
            ruleMethodReference();

            state._fsp--;

             after(grammarAccess.getMethodReferenceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodReference1509); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:741:1: ruleMethodReference : ( ( rule__MethodReference__Group__0 ) ) ;
    public final void ruleMethodReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:745:2: ( ( ( rule__MethodReference__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:746:1: ( ( rule__MethodReference__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:746:1: ( ( rule__MethodReference__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:747:1: ( rule__MethodReference__Group__0 )
            {
             before(grammarAccess.getMethodReferenceAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:748:1: ( rule__MethodReference__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:748:2: rule__MethodReference__Group__0
            {
            pushFollow(FOLLOW_rule__MethodReference__Group__0_in_ruleMethodReference1535);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:760:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:761:1: ( ruleQualifiedName EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:762:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1562);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName1569); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:769:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:773:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:774:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:774:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:775:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:776:1: ( rule__QualifiedName__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:776:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName1595);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:788:1: entryRuleQualifiedJavaClassName : ruleQualifiedJavaClassName EOF ;
    public final void entryRuleQualifiedJavaClassName() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:789:1: ( ruleQualifiedJavaClassName EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:790:1: ruleQualifiedJavaClassName EOF
            {
             before(grammarAccess.getQualifiedJavaClassNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_entryRuleQualifiedJavaClassName1622);
            ruleQualifiedJavaClassName();

            state._fsp--;

             after(grammarAccess.getQualifiedJavaClassNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedJavaClassName1629); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:797:1: ruleQualifiedJavaClassName : ( ( rule__QualifiedJavaClassName__Group__0 ) ) ;
    public final void ruleQualifiedJavaClassName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:801:2: ( ( ( rule__QualifiedJavaClassName__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:802:1: ( ( rule__QualifiedJavaClassName__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:802:1: ( ( rule__QualifiedJavaClassName__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:803:1: ( rule__QualifiedJavaClassName__Group__0 )
            {
             before(grammarAccess.getQualifiedJavaClassNameAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:804:1: ( rule__QualifiedJavaClassName__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:804:2: rule__QualifiedJavaClassName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__0_in_ruleQualifiedJavaClassName1655);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:816:1: entryRuleQualifiedNameWithWildcard : ruleQualifiedNameWithWildcard EOF ;
    public final void entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:817:1: ( ruleQualifiedNameWithWildcard EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:818:1: ruleQualifiedNameWithWildcard EOF
            {
             before(grammarAccess.getQualifiedNameWithWildcardRule()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard1682);
            ruleQualifiedNameWithWildcard();

            state._fsp--;

             after(grammarAccess.getQualifiedNameWithWildcardRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard1689); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:825:1: ruleQualifiedNameWithWildcard : ( ( rule__QualifiedNameWithWildcard__Group__0 ) ) ;
    public final void ruleQualifiedNameWithWildcard() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:829:2: ( ( ( rule__QualifiedNameWithWildcard__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:830:1: ( ( rule__QualifiedNameWithWildcard__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:830:1: ( ( rule__QualifiedNameWithWildcard__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:831:1: ( rule__QualifiedNameWithWildcard__Group__0 )
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:832:1: ( rule__QualifiedNameWithWildcard__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:832:2: rule__QualifiedNameWithWildcard__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__0_in_ruleQualifiedNameWithWildcard1715);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:844:1: rule__Statement__Alternatives : ( ( rulePackageDefinition ) | ( ruleImport ) | ( ruleSuite ) );
    public final void rule__Statement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:848:1: ( ( rulePackageDefinition ) | ( ruleImport ) | ( ruleSuite ) )
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
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:849:1: ( rulePackageDefinition )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:849:1: ( rulePackageDefinition )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:850:1: rulePackageDefinition
                    {
                     before(grammarAccess.getStatementAccess().getPackageDefinitionParserRuleCall_0()); 
                    pushFollow(FOLLOW_rulePackageDefinition_in_rule__Statement__Alternatives1751);
                    rulePackageDefinition();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getPackageDefinitionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:855:6: ( ruleImport )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:855:6: ( ruleImport )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:856:1: ruleImport
                    {
                     before(grammarAccess.getStatementAccess().getImportParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleImport_in_rule__Statement__Alternatives1768);
                    ruleImport();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getImportParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:861:6: ( ruleSuite )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:861:6: ( ruleSuite )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:862:1: ruleSuite
                    {
                     before(grammarAccess.getStatementAccess().getSuiteParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleSuite_in_rule__Statement__Alternatives1785);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:872:1: rule__PackageStatement__Alternatives : ( ( ruleImport ) | ( ruleTestDefinition ) | ( ruleCallDefinition ) | ( ruleSuiteDefinition ) | ( ruleVariableDefinition ) );
    public final void rule__PackageStatement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:876:1: ( ( ruleImport ) | ( ruleTestDefinition ) | ( ruleCallDefinition ) | ( ruleSuiteDefinition ) | ( ruleVariableDefinition ) )
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
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:877:1: ( ruleImport )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:877:1: ( ruleImport )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:878:1: ruleImport
                    {
                     before(grammarAccess.getPackageStatementAccess().getImportParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleImport_in_rule__PackageStatement__Alternatives1817);
                    ruleImport();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getImportParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:883:6: ( ruleTestDefinition )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:883:6: ( ruleTestDefinition )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:884:1: ruleTestDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getTestDefinitionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleTestDefinition_in_rule__PackageStatement__Alternatives1834);
                    ruleTestDefinition();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getTestDefinitionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:889:6: ( ruleCallDefinition )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:889:6: ( ruleCallDefinition )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:890:1: ruleCallDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getCallDefinitionParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleCallDefinition_in_rule__PackageStatement__Alternatives1851);
                    ruleCallDefinition();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getCallDefinitionParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:895:6: ( ruleSuiteDefinition )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:895:6: ( ruleSuiteDefinition )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:896:1: ruleSuiteDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getSuiteDefinitionParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleSuiteDefinition_in_rule__PackageStatement__Alternatives1868);
                    ruleSuiteDefinition();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getSuiteDefinitionParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:901:6: ( ruleVariableDefinition )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:901:6: ( ruleVariableDefinition )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:902:1: ruleVariableDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getVariableDefinitionParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleVariableDefinition_in_rule__PackageStatement__Alternatives1885);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:912:1: rule__SuiteStatement__Alternatives : ( ( ruleSuiteStatementWithResult ) | ( ruleCall ) | ( ruleVariableDefinition ) );
    public final void rule__SuiteStatement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:916:1: ( ( ruleSuiteStatementWithResult ) | ( ruleCall ) | ( ruleVariableDefinition ) )
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
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:917:1: ( ruleSuiteStatementWithResult )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:917:1: ( ruleSuiteStatementWithResult )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:918:1: ruleSuiteStatementWithResult
                    {
                     before(grammarAccess.getSuiteStatementAccess().getSuiteStatementWithResultParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSuiteStatementWithResult_in_rule__SuiteStatement__Alternatives1917);
                    ruleSuiteStatementWithResult();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementAccess().getSuiteStatementWithResultParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:923:6: ( ruleCall )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:923:6: ( ruleCall )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:924:1: ruleCall
                    {
                     before(grammarAccess.getSuiteStatementAccess().getCallParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleCall_in_rule__SuiteStatement__Alternatives1934);
                    ruleCall();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementAccess().getCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:929:6: ( ruleVariableDefinition )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:929:6: ( ruleVariableDefinition )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:930:1: ruleVariableDefinition
                    {
                     before(grammarAccess.getSuiteStatementAccess().getVariableDefinitionParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleVariableDefinition_in_rule__SuiteStatement__Alternatives1951);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:940:1: rule__SuiteStatementWithResult__Alternatives : ( ( ruleSuite ) | ( ruleTest ) );
    public final void rule__SuiteStatementWithResult__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:944:1: ( ( ruleSuite ) | ( ruleTest ) )
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
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:945:1: ( ruleSuite )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:945:1: ( ruleSuite )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:946:1: ruleSuite
                    {
                     before(grammarAccess.getSuiteStatementWithResultAccess().getSuiteParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSuite_in_rule__SuiteStatementWithResult__Alternatives1983);
                    ruleSuite();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementWithResultAccess().getSuiteParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:951:6: ( ruleTest )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:951:6: ( ruleTest )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:952:1: ruleTest
                    {
                     before(grammarAccess.getSuiteStatementWithResultAccess().getTestParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleTest_in_rule__SuiteStatementWithResult__Alternatives2000);
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


    // $ANTLR start "rule__ValueOrEnumValue__Alternatives"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:962:1: rule__ValueOrEnumValue__Alternatives : ( ( ruleValue ) | ( ruleEnumValue ) );
    public final void rule__ValueOrEnumValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:966:1: ( ( ruleValue ) | ( ruleEnumValue ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID||(LA6_0>=RULE_INTEGER && LA6_0<=RULE_STRING)) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_UPPERCASE_ID) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:967:1: ( ruleValue )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:967:1: ( ruleValue )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:968:1: ruleValue
                    {
                     before(grammarAccess.getValueOrEnumValueAccess().getValueParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleValue_in_rule__ValueOrEnumValue__Alternatives2032);
                    ruleValue();

                    state._fsp--;

                     after(grammarAccess.getValueOrEnumValueAccess().getValueParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:973:6: ( ruleEnumValue )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:973:6: ( ruleEnumValue )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:974:1: ruleEnumValue
                    {
                     before(grammarAccess.getValueOrEnumValueAccess().getEnumValueParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleEnumValue_in_rule__ValueOrEnumValue__Alternatives2049);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:984:1: rule__Value__Alternatives : ( ( ruleStringValue ) | ( ruleIntegerValue ) | ( ruleDecimalValue ) | ( ruleVariable ) );
    public final void rule__Value__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:988:1: ( ( ruleStringValue ) | ( ruleIntegerValue ) | ( ruleDecimalValue ) | ( ruleVariable ) )
            int alt7=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt7=1;
                }
                break;
            case RULE_INTEGER:
                {
                alt7=2;
                }
                break;
            case RULE_DECIMAL:
                {
                alt7=3;
                }
                break;
            case RULE_ID:
                {
                alt7=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:989:1: ( ruleStringValue )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:989:1: ( ruleStringValue )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:990:1: ruleStringValue
                    {
                     before(grammarAccess.getValueAccess().getStringValueParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleStringValue_in_rule__Value__Alternatives2081);
                    ruleStringValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getStringValueParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:995:6: ( ruleIntegerValue )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:995:6: ( ruleIntegerValue )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:996:1: ruleIntegerValue
                    {
                     before(grammarAccess.getValueAccess().getIntegerValueParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleIntegerValue_in_rule__Value__Alternatives2098);
                    ruleIntegerValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getIntegerValueParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1001:6: ( ruleDecimalValue )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1001:6: ( ruleDecimalValue )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1002:1: ruleDecimalValue
                    {
                     before(grammarAccess.getValueAccess().getDecimalValueParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleDecimalValue_in_rule__Value__Alternatives2115);
                    ruleDecimalValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getDecimalValueParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1007:6: ( ruleVariable )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1007:6: ( ruleVariable )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1008:1: ruleVariable
                    {
                     before(grammarAccess.getValueAccess().getVariableParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleVariable_in_rule__Value__Alternatives2132);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1020:1: rule__PackageDefinition__Group__0 : rule__PackageDefinition__Group__0__Impl rule__PackageDefinition__Group__1 ;
    public final void rule__PackageDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1024:1: ( rule__PackageDefinition__Group__0__Impl rule__PackageDefinition__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1025:2: rule__PackageDefinition__Group__0__Impl rule__PackageDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__0__Impl_in_rule__PackageDefinition__Group__02162);
            rule__PackageDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDefinition__Group__1_in_rule__PackageDefinition__Group__02165);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1032:1: rule__PackageDefinition__Group__0__Impl : ( 'packagedef' ) ;
    public final void rule__PackageDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1036:1: ( ( 'packagedef' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1037:1: ( 'packagedef' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1037:1: ( 'packagedef' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1038:1: 'packagedef'
            {
             before(grammarAccess.getPackageDefinitionAccess().getPackagedefKeyword_0()); 
            match(input,13,FOLLOW_13_in_rule__PackageDefinition__Group__0__Impl2193); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1051:1: rule__PackageDefinition__Group__1 : rule__PackageDefinition__Group__1__Impl rule__PackageDefinition__Group__2 ;
    public final void rule__PackageDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1055:1: ( rule__PackageDefinition__Group__1__Impl rule__PackageDefinition__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1056:2: rule__PackageDefinition__Group__1__Impl rule__PackageDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__1__Impl_in_rule__PackageDefinition__Group__12224);
            rule__PackageDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDefinition__Group__2_in_rule__PackageDefinition__Group__12227);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1063:1: rule__PackageDefinition__Group__1__Impl : ( ( rule__PackageDefinition__NameAssignment_1 ) ) ;
    public final void rule__PackageDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1067:1: ( ( ( rule__PackageDefinition__NameAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1068:1: ( ( rule__PackageDefinition__NameAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1068:1: ( ( rule__PackageDefinition__NameAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1069:1: ( rule__PackageDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getPackageDefinitionAccess().getNameAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1070:1: ( rule__PackageDefinition__NameAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1070:2: rule__PackageDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__PackageDefinition__NameAssignment_1_in_rule__PackageDefinition__Group__1__Impl2254);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1080:1: rule__PackageDefinition__Group__2 : rule__PackageDefinition__Group__2__Impl rule__PackageDefinition__Group__3 ;
    public final void rule__PackageDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1084:1: ( rule__PackageDefinition__Group__2__Impl rule__PackageDefinition__Group__3 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1085:2: rule__PackageDefinition__Group__2__Impl rule__PackageDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__2__Impl_in_rule__PackageDefinition__Group__22284);
            rule__PackageDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDefinition__Group__3_in_rule__PackageDefinition__Group__22287);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1092:1: rule__PackageDefinition__Group__2__Impl : ( 'with' ) ;
    public final void rule__PackageDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1096:1: ( ( 'with' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1097:1: ( 'with' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1097:1: ( 'with' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1098:1: 'with'
            {
             before(grammarAccess.getPackageDefinitionAccess().getWithKeyword_2()); 
            match(input,14,FOLLOW_14_in_rule__PackageDefinition__Group__2__Impl2315); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1111:1: rule__PackageDefinition__Group__3 : rule__PackageDefinition__Group__3__Impl rule__PackageDefinition__Group__4 ;
    public final void rule__PackageDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1115:1: ( rule__PackageDefinition__Group__3__Impl rule__PackageDefinition__Group__4 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1116:2: rule__PackageDefinition__Group__3__Impl rule__PackageDefinition__Group__4
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__3__Impl_in_rule__PackageDefinition__Group__32346);
            rule__PackageDefinition__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDefinition__Group__4_in_rule__PackageDefinition__Group__32349);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1123:1: rule__PackageDefinition__Group__3__Impl : ( ( rule__PackageDefinition__StatementsAssignment_3 )* ) ;
    public final void rule__PackageDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1127:1: ( ( ( rule__PackageDefinition__StatementsAssignment_3 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1128:1: ( ( rule__PackageDefinition__StatementsAssignment_3 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1128:1: ( ( rule__PackageDefinition__StatementsAssignment_3 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1129:1: ( rule__PackageDefinition__StatementsAssignment_3 )*
            {
             before(grammarAccess.getPackageDefinitionAccess().getStatementsAssignment_3()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1130:1: ( rule__PackageDefinition__StatementsAssignment_3 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=16 && LA8_0<=17)||(LA8_0>=19 && LA8_0<=20)||LA8_0==25) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1130:2: rule__PackageDefinition__StatementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__PackageDefinition__StatementsAssignment_3_in_rule__PackageDefinition__Group__3__Impl2376);
            	    rule__PackageDefinition__StatementsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1140:1: rule__PackageDefinition__Group__4 : rule__PackageDefinition__Group__4__Impl ;
    public final void rule__PackageDefinition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1144:1: ( rule__PackageDefinition__Group__4__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1145:2: rule__PackageDefinition__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__4__Impl_in_rule__PackageDefinition__Group__42407);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1151:1: rule__PackageDefinition__Group__4__Impl : ( 'packageend' ) ;
    public final void rule__PackageDefinition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1155:1: ( ( 'packageend' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1156:1: ( 'packageend' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1156:1: ( 'packageend' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1157:1: 'packageend'
            {
             before(grammarAccess.getPackageDefinitionAccess().getPackageendKeyword_4()); 
            match(input,15,FOLLOW_15_in_rule__PackageDefinition__Group__4__Impl2435); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1180:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1184:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1185:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__02476);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__02479);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1192:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1196:1: ( ( 'import' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1197:1: ( 'import' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1197:1: ( 'import' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1198:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,16,FOLLOW_16_in_rule__Import__Group__0__Impl2507); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1211:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1215:1: ( rule__Import__Group__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1216:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__12538);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1222:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1226:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1227:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1227:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1228:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1229:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1229:2: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl2565);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1243:1: rule__TestDefinition__Group__0 : rule__TestDefinition__Group__0__Impl rule__TestDefinition__Group__1 ;
    public final void rule__TestDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1247:1: ( rule__TestDefinition__Group__0__Impl rule__TestDefinition__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1248:2: rule__TestDefinition__Group__0__Impl rule__TestDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__TestDefinition__Group__0__Impl_in_rule__TestDefinition__Group__02599);
            rule__TestDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TestDefinition__Group__1_in_rule__TestDefinition__Group__02602);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1255:1: rule__TestDefinition__Group__0__Impl : ( 'testdef' ) ;
    public final void rule__TestDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1259:1: ( ( 'testdef' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1260:1: ( 'testdef' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1260:1: ( 'testdef' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1261:1: 'testdef'
            {
             before(grammarAccess.getTestDefinitionAccess().getTestdefKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__TestDefinition__Group__0__Impl2630); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1274:1: rule__TestDefinition__Group__1 : rule__TestDefinition__Group__1__Impl rule__TestDefinition__Group__2 ;
    public final void rule__TestDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1278:1: ( rule__TestDefinition__Group__1__Impl rule__TestDefinition__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1279:2: rule__TestDefinition__Group__1__Impl rule__TestDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__TestDefinition__Group__1__Impl_in_rule__TestDefinition__Group__12661);
            rule__TestDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TestDefinition__Group__2_in_rule__TestDefinition__Group__12664);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1286:1: rule__TestDefinition__Group__1__Impl : ( ( rule__TestDefinition__NameAssignment_1 ) ) ;
    public final void rule__TestDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1290:1: ( ( ( rule__TestDefinition__NameAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1291:1: ( ( rule__TestDefinition__NameAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1291:1: ( ( rule__TestDefinition__NameAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1292:1: ( rule__TestDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getTestDefinitionAccess().getNameAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1293:1: ( rule__TestDefinition__NameAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1293:2: rule__TestDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__TestDefinition__NameAssignment_1_in_rule__TestDefinition__Group__1__Impl2691);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1303:1: rule__TestDefinition__Group__2 : rule__TestDefinition__Group__2__Impl rule__TestDefinition__Group__3 ;
    public final void rule__TestDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1307:1: ( rule__TestDefinition__Group__2__Impl rule__TestDefinition__Group__3 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1308:2: rule__TestDefinition__Group__2__Impl rule__TestDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__TestDefinition__Group__2__Impl_in_rule__TestDefinition__Group__22721);
            rule__TestDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TestDefinition__Group__3_in_rule__TestDefinition__Group__22724);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1315:1: rule__TestDefinition__Group__2__Impl : ( 'uses' ) ;
    public final void rule__TestDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1319:1: ( ( 'uses' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1320:1: ( 'uses' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1320:1: ( 'uses' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1321:1: 'uses'
            {
             before(grammarAccess.getTestDefinitionAccess().getUsesKeyword_2()); 
            match(input,18,FOLLOW_18_in_rule__TestDefinition__Group__2__Impl2752); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1334:1: rule__TestDefinition__Group__3 : rule__TestDefinition__Group__3__Impl ;
    public final void rule__TestDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1338:1: ( rule__TestDefinition__Group__3__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1339:2: rule__TestDefinition__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__TestDefinition__Group__3__Impl_in_rule__TestDefinition__Group__32783);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1345:1: rule__TestDefinition__Group__3__Impl : ( ( rule__TestDefinition__FixtureMethodAssignment_3 ) ) ;
    public final void rule__TestDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1349:1: ( ( ( rule__TestDefinition__FixtureMethodAssignment_3 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1350:1: ( ( rule__TestDefinition__FixtureMethodAssignment_3 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1350:1: ( ( rule__TestDefinition__FixtureMethodAssignment_3 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1351:1: ( rule__TestDefinition__FixtureMethodAssignment_3 )
            {
             before(grammarAccess.getTestDefinitionAccess().getFixtureMethodAssignment_3()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1352:1: ( rule__TestDefinition__FixtureMethodAssignment_3 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1352:2: rule__TestDefinition__FixtureMethodAssignment_3
            {
            pushFollow(FOLLOW_rule__TestDefinition__FixtureMethodAssignment_3_in_rule__TestDefinition__Group__3__Impl2810);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1370:1: rule__CallDefinition__Group__0 : rule__CallDefinition__Group__0__Impl rule__CallDefinition__Group__1 ;
    public final void rule__CallDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1374:1: ( rule__CallDefinition__Group__0__Impl rule__CallDefinition__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1375:2: rule__CallDefinition__Group__0__Impl rule__CallDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__CallDefinition__Group__0__Impl_in_rule__CallDefinition__Group__02848);
            rule__CallDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CallDefinition__Group__1_in_rule__CallDefinition__Group__02851);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1382:1: rule__CallDefinition__Group__0__Impl : ( 'calldef' ) ;
    public final void rule__CallDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1386:1: ( ( 'calldef' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1387:1: ( 'calldef' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1387:1: ( 'calldef' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1388:1: 'calldef'
            {
             before(grammarAccess.getCallDefinitionAccess().getCalldefKeyword_0()); 
            match(input,19,FOLLOW_19_in_rule__CallDefinition__Group__0__Impl2879); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1401:1: rule__CallDefinition__Group__1 : rule__CallDefinition__Group__1__Impl rule__CallDefinition__Group__2 ;
    public final void rule__CallDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1405:1: ( rule__CallDefinition__Group__1__Impl rule__CallDefinition__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1406:2: rule__CallDefinition__Group__1__Impl rule__CallDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__CallDefinition__Group__1__Impl_in_rule__CallDefinition__Group__12910);
            rule__CallDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CallDefinition__Group__2_in_rule__CallDefinition__Group__12913);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1413:1: rule__CallDefinition__Group__1__Impl : ( ( rule__CallDefinition__NameAssignment_1 ) ) ;
    public final void rule__CallDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1417:1: ( ( ( rule__CallDefinition__NameAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1418:1: ( ( rule__CallDefinition__NameAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1418:1: ( ( rule__CallDefinition__NameAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1419:1: ( rule__CallDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getCallDefinitionAccess().getNameAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1420:1: ( rule__CallDefinition__NameAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1420:2: rule__CallDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__CallDefinition__NameAssignment_1_in_rule__CallDefinition__Group__1__Impl2940);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1430:1: rule__CallDefinition__Group__2 : rule__CallDefinition__Group__2__Impl rule__CallDefinition__Group__3 ;
    public final void rule__CallDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1434:1: ( rule__CallDefinition__Group__2__Impl rule__CallDefinition__Group__3 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1435:2: rule__CallDefinition__Group__2__Impl rule__CallDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__CallDefinition__Group__2__Impl_in_rule__CallDefinition__Group__22970);
            rule__CallDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CallDefinition__Group__3_in_rule__CallDefinition__Group__22973);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1442:1: rule__CallDefinition__Group__2__Impl : ( 'uses' ) ;
    public final void rule__CallDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1446:1: ( ( 'uses' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1447:1: ( 'uses' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1447:1: ( 'uses' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1448:1: 'uses'
            {
             before(grammarAccess.getCallDefinitionAccess().getUsesKeyword_2()); 
            match(input,18,FOLLOW_18_in_rule__CallDefinition__Group__2__Impl3001); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1461:1: rule__CallDefinition__Group__3 : rule__CallDefinition__Group__3__Impl ;
    public final void rule__CallDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1465:1: ( rule__CallDefinition__Group__3__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1466:2: rule__CallDefinition__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__CallDefinition__Group__3__Impl_in_rule__CallDefinition__Group__33032);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1472:1: rule__CallDefinition__Group__3__Impl : ( ( rule__CallDefinition__FixtureMethodAssignment_3 ) ) ;
    public final void rule__CallDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1476:1: ( ( ( rule__CallDefinition__FixtureMethodAssignment_3 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1477:1: ( ( rule__CallDefinition__FixtureMethodAssignment_3 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1477:1: ( ( rule__CallDefinition__FixtureMethodAssignment_3 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1478:1: ( rule__CallDefinition__FixtureMethodAssignment_3 )
            {
             before(grammarAccess.getCallDefinitionAccess().getFixtureMethodAssignment_3()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1479:1: ( rule__CallDefinition__FixtureMethodAssignment_3 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1479:2: rule__CallDefinition__FixtureMethodAssignment_3
            {
            pushFollow(FOLLOW_rule__CallDefinition__FixtureMethodAssignment_3_in_rule__CallDefinition__Group__3__Impl3059);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1497:1: rule__SuiteDefinition__Group__0 : rule__SuiteDefinition__Group__0__Impl rule__SuiteDefinition__Group__1 ;
    public final void rule__SuiteDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1501:1: ( rule__SuiteDefinition__Group__0__Impl rule__SuiteDefinition__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1502:2: rule__SuiteDefinition__Group__0__Impl rule__SuiteDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__0__Impl_in_rule__SuiteDefinition__Group__03097);
            rule__SuiteDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__1_in_rule__SuiteDefinition__Group__03100);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1509:1: rule__SuiteDefinition__Group__0__Impl : ( 'suitedef' ) ;
    public final void rule__SuiteDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1513:1: ( ( 'suitedef' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1514:1: ( 'suitedef' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1514:1: ( 'suitedef' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1515:1: 'suitedef'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getSuitedefKeyword_0()); 
            match(input,20,FOLLOW_20_in_rule__SuiteDefinition__Group__0__Impl3128); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1528:1: rule__SuiteDefinition__Group__1 : rule__SuiteDefinition__Group__1__Impl rule__SuiteDefinition__Group__2 ;
    public final void rule__SuiteDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1532:1: ( rule__SuiteDefinition__Group__1__Impl rule__SuiteDefinition__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1533:2: rule__SuiteDefinition__Group__1__Impl rule__SuiteDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__1__Impl_in_rule__SuiteDefinition__Group__13159);
            rule__SuiteDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__2_in_rule__SuiteDefinition__Group__13162);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1540:1: rule__SuiteDefinition__Group__1__Impl : ( ( rule__SuiteDefinition__NameAssignment_1 ) ) ;
    public final void rule__SuiteDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1544:1: ( ( ( rule__SuiteDefinition__NameAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1545:1: ( ( rule__SuiteDefinition__NameAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1545:1: ( ( rule__SuiteDefinition__NameAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1546:1: ( rule__SuiteDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getSuiteDefinitionAccess().getNameAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1547:1: ( rule__SuiteDefinition__NameAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1547:2: rule__SuiteDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__NameAssignment_1_in_rule__SuiteDefinition__Group__1__Impl3189);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1557:1: rule__SuiteDefinition__Group__2 : rule__SuiteDefinition__Group__2__Impl rule__SuiteDefinition__Group__3 ;
    public final void rule__SuiteDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1561:1: ( rule__SuiteDefinition__Group__2__Impl rule__SuiteDefinition__Group__3 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1562:2: rule__SuiteDefinition__Group__2__Impl rule__SuiteDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__2__Impl_in_rule__SuiteDefinition__Group__23219);
            rule__SuiteDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__3_in_rule__SuiteDefinition__Group__23222);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1569:1: rule__SuiteDefinition__Group__2__Impl : ( ( rule__SuiteDefinition__Group_2__0 )? ) ;
    public final void rule__SuiteDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1573:1: ( ( ( rule__SuiteDefinition__Group_2__0 )? ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1574:1: ( ( rule__SuiteDefinition__Group_2__0 )? )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1574:1: ( ( rule__SuiteDefinition__Group_2__0 )? )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1575:1: ( rule__SuiteDefinition__Group_2__0 )?
            {
             before(grammarAccess.getSuiteDefinitionAccess().getGroup_2()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1576:1: ( rule__SuiteDefinition__Group_2__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==22) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1576:2: rule__SuiteDefinition__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__SuiteDefinition__Group_2__0_in_rule__SuiteDefinition__Group__2__Impl3249);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1586:1: rule__SuiteDefinition__Group__3 : rule__SuiteDefinition__Group__3__Impl rule__SuiteDefinition__Group__4 ;
    public final void rule__SuiteDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1590:1: ( rule__SuiteDefinition__Group__3__Impl rule__SuiteDefinition__Group__4 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1591:2: rule__SuiteDefinition__Group__3__Impl rule__SuiteDefinition__Group__4
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__3__Impl_in_rule__SuiteDefinition__Group__33280);
            rule__SuiteDefinition__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__4_in_rule__SuiteDefinition__Group__33283);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1598:1: rule__SuiteDefinition__Group__3__Impl : ( ( rule__SuiteDefinition__Group_3__0 )? ) ;
    public final void rule__SuiteDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1602:1: ( ( ( rule__SuiteDefinition__Group_3__0 )? ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1603:1: ( ( rule__SuiteDefinition__Group_3__0 )? )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1603:1: ( ( rule__SuiteDefinition__Group_3__0 )? )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1604:1: ( rule__SuiteDefinition__Group_3__0 )?
            {
             before(grammarAccess.getSuiteDefinitionAccess().getGroup_3()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1605:1: ( rule__SuiteDefinition__Group_3__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==23) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1605:2: rule__SuiteDefinition__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__SuiteDefinition__Group_3__0_in_rule__SuiteDefinition__Group__3__Impl3310);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1615:1: rule__SuiteDefinition__Group__4 : rule__SuiteDefinition__Group__4__Impl rule__SuiteDefinition__Group__5 ;
    public final void rule__SuiteDefinition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1619:1: ( rule__SuiteDefinition__Group__4__Impl rule__SuiteDefinition__Group__5 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1620:2: rule__SuiteDefinition__Group__4__Impl rule__SuiteDefinition__Group__5
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__4__Impl_in_rule__SuiteDefinition__Group__43341);
            rule__SuiteDefinition__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__5_in_rule__SuiteDefinition__Group__43344);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1627:1: rule__SuiteDefinition__Group__4__Impl : ( 'with' ) ;
    public final void rule__SuiteDefinition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1631:1: ( ( 'with' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1632:1: ( 'with' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1632:1: ( 'with' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1633:1: 'with'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getWithKeyword_4()); 
            match(input,14,FOLLOW_14_in_rule__SuiteDefinition__Group__4__Impl3372); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1646:1: rule__SuiteDefinition__Group__5 : rule__SuiteDefinition__Group__5__Impl rule__SuiteDefinition__Group__6 ;
    public final void rule__SuiteDefinition__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1650:1: ( rule__SuiteDefinition__Group__5__Impl rule__SuiteDefinition__Group__6 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1651:2: rule__SuiteDefinition__Group__5__Impl rule__SuiteDefinition__Group__6
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__5__Impl_in_rule__SuiteDefinition__Group__53403);
            rule__SuiteDefinition__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__6_in_rule__SuiteDefinition__Group__53406);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1658:1: rule__SuiteDefinition__Group__5__Impl : ( ( rule__SuiteDefinition__StatementsAssignment_5 )* ) ;
    public final void rule__SuiteDefinition__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1662:1: ( ( ( rule__SuiteDefinition__StatementsAssignment_5 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1663:1: ( ( rule__SuiteDefinition__StatementsAssignment_5 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1663:1: ( ( rule__SuiteDefinition__StatementsAssignment_5 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1664:1: ( rule__SuiteDefinition__StatementsAssignment_5 )*
            {
             before(grammarAccess.getSuiteDefinitionAccess().getStatementsAssignment_5()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1665:1: ( rule__SuiteDefinition__StatementsAssignment_5 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==25||LA11_0==27||LA11_0==29||LA11_0==31) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1665:2: rule__SuiteDefinition__StatementsAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__SuiteDefinition__StatementsAssignment_5_in_rule__SuiteDefinition__Group__5__Impl3433);
            	    rule__SuiteDefinition__StatementsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1675:1: rule__SuiteDefinition__Group__6 : rule__SuiteDefinition__Group__6__Impl rule__SuiteDefinition__Group__7 ;
    public final void rule__SuiteDefinition__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1679:1: ( rule__SuiteDefinition__Group__6__Impl rule__SuiteDefinition__Group__7 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1680:2: rule__SuiteDefinition__Group__6__Impl rule__SuiteDefinition__Group__7
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__6__Impl_in_rule__SuiteDefinition__Group__63464);
            rule__SuiteDefinition__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__7_in_rule__SuiteDefinition__Group__63467);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1687:1: rule__SuiteDefinition__Group__6__Impl : ( 'suiteend' ) ;
    public final void rule__SuiteDefinition__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1691:1: ( ( 'suiteend' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1692:1: ( 'suiteend' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1692:1: ( 'suiteend' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1693:1: 'suiteend'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getSuiteendKeyword_6()); 
            match(input,21,FOLLOW_21_in_rule__SuiteDefinition__Group__6__Impl3495); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1706:1: rule__SuiteDefinition__Group__7 : rule__SuiteDefinition__Group__7__Impl ;
    public final void rule__SuiteDefinition__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1710:1: ( rule__SuiteDefinition__Group__7__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1711:2: rule__SuiteDefinition__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__7__Impl_in_rule__SuiteDefinition__Group__73526);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1717:1: rule__SuiteDefinition__Group__7__Impl : ( ( rule__SuiteDefinition__Group_7__0 )? ) ;
    public final void rule__SuiteDefinition__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1721:1: ( ( ( rule__SuiteDefinition__Group_7__0 )? ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1722:1: ( ( rule__SuiteDefinition__Group_7__0 )? )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1722:1: ( ( rule__SuiteDefinition__Group_7__0 )? )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1723:1: ( rule__SuiteDefinition__Group_7__0 )?
            {
             before(grammarAccess.getSuiteDefinitionAccess().getGroup_7()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1724:1: ( rule__SuiteDefinition__Group_7__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==24) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1724:2: rule__SuiteDefinition__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__SuiteDefinition__Group_7__0_in_rule__SuiteDefinition__Group__7__Impl3553);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1750:1: rule__SuiteDefinition__Group_2__0 : rule__SuiteDefinition__Group_2__0__Impl rule__SuiteDefinition__Group_2__1 ;
    public final void rule__SuiteDefinition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1754:1: ( rule__SuiteDefinition__Group_2__0__Impl rule__SuiteDefinition__Group_2__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1755:2: rule__SuiteDefinition__Group_2__0__Impl rule__SuiteDefinition__Group_2__1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_2__0__Impl_in_rule__SuiteDefinition__Group_2__03600);
            rule__SuiteDefinition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group_2__1_in_rule__SuiteDefinition__Group_2__03603);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1762:1: rule__SuiteDefinition__Group_2__0__Impl : ( 'gets' ) ;
    public final void rule__SuiteDefinition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1766:1: ( ( 'gets' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1767:1: ( 'gets' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1767:1: ( 'gets' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1768:1: 'gets'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getGetsKeyword_2_0()); 
            match(input,22,FOLLOW_22_in_rule__SuiteDefinition__Group_2__0__Impl3631); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1781:1: rule__SuiteDefinition__Group_2__1 : rule__SuiteDefinition__Group_2__1__Impl ;
    public final void rule__SuiteDefinition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1785:1: ( rule__SuiteDefinition__Group_2__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1786:2: rule__SuiteDefinition__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_2__1__Impl_in_rule__SuiteDefinition__Group_2__13662);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1792:1: rule__SuiteDefinition__Group_2__1__Impl : ( ( rule__SuiteDefinition__ParametersAssignment_2_1 )* ) ;
    public final void rule__SuiteDefinition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1796:1: ( ( ( rule__SuiteDefinition__ParametersAssignment_2_1 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1797:1: ( ( rule__SuiteDefinition__ParametersAssignment_2_1 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1797:1: ( ( rule__SuiteDefinition__ParametersAssignment_2_1 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1798:1: ( rule__SuiteDefinition__ParametersAssignment_2_1 )*
            {
             before(grammarAccess.getSuiteDefinitionAccess().getParametersAssignment_2_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1799:1: ( rule__SuiteDefinition__ParametersAssignment_2_1 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==RULE_ID) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1799:2: rule__SuiteDefinition__ParametersAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_rule__SuiteDefinition__ParametersAssignment_2_1_in_rule__SuiteDefinition__Group_2__1__Impl3689);
            	    rule__SuiteDefinition__ParametersAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1813:1: rule__SuiteDefinition__Group_3__0 : rule__SuiteDefinition__Group_3__0__Impl rule__SuiteDefinition__Group_3__1 ;
    public final void rule__SuiteDefinition__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1817:1: ( rule__SuiteDefinition__Group_3__0__Impl rule__SuiteDefinition__Group_3__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1818:2: rule__SuiteDefinition__Group_3__0__Impl rule__SuiteDefinition__Group_3__1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_3__0__Impl_in_rule__SuiteDefinition__Group_3__03724);
            rule__SuiteDefinition__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group_3__1_in_rule__SuiteDefinition__Group_3__03727);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1825:1: rule__SuiteDefinition__Group_3__0__Impl : ( 'requires' ) ;
    public final void rule__SuiteDefinition__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1829:1: ( ( 'requires' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1830:1: ( 'requires' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1830:1: ( 'requires' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1831:1: 'requires'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getRequiresKeyword_3_0()); 
            match(input,23,FOLLOW_23_in_rule__SuiteDefinition__Group_3__0__Impl3755); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1844:1: rule__SuiteDefinition__Group_3__1 : rule__SuiteDefinition__Group_3__1__Impl ;
    public final void rule__SuiteDefinition__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1848:1: ( rule__SuiteDefinition__Group_3__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1849:2: rule__SuiteDefinition__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_3__1__Impl_in_rule__SuiteDefinition__Group_3__13786);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1855:1: rule__SuiteDefinition__Group_3__1__Impl : ( ( rule__SuiteDefinition__DependenciesAssignment_3_1 )* ) ;
    public final void rule__SuiteDefinition__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1859:1: ( ( ( rule__SuiteDefinition__DependenciesAssignment_3_1 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1860:1: ( ( rule__SuiteDefinition__DependenciesAssignment_3_1 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1860:1: ( ( rule__SuiteDefinition__DependenciesAssignment_3_1 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1861:1: ( rule__SuiteDefinition__DependenciesAssignment_3_1 )*
            {
             before(grammarAccess.getSuiteDefinitionAccess().getDependenciesAssignment_3_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1862:1: ( rule__SuiteDefinition__DependenciesAssignment_3_1 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1862:2: rule__SuiteDefinition__DependenciesAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_rule__SuiteDefinition__DependenciesAssignment_3_1_in_rule__SuiteDefinition__Group_3__1__Impl3813);
            	    rule__SuiteDefinition__DependenciesAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1876:1: rule__SuiteDefinition__Group_7__0 : rule__SuiteDefinition__Group_7__0__Impl rule__SuiteDefinition__Group_7__1 ;
    public final void rule__SuiteDefinition__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1880:1: ( rule__SuiteDefinition__Group_7__0__Impl rule__SuiteDefinition__Group_7__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1881:2: rule__SuiteDefinition__Group_7__0__Impl rule__SuiteDefinition__Group_7__1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_7__0__Impl_in_rule__SuiteDefinition__Group_7__03848);
            rule__SuiteDefinition__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group_7__1_in_rule__SuiteDefinition__Group_7__03851);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1888:1: rule__SuiteDefinition__Group_7__0__Impl : ( 'concludedby' ) ;
    public final void rule__SuiteDefinition__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1892:1: ( ( 'concludedby' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1893:1: ( 'concludedby' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1893:1: ( 'concludedby' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1894:1: 'concludedby'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getConcludedbyKeyword_7_0()); 
            match(input,24,FOLLOW_24_in_rule__SuiteDefinition__Group_7__0__Impl3879); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1907:1: rule__SuiteDefinition__Group_7__1 : rule__SuiteDefinition__Group_7__1__Impl ;
    public final void rule__SuiteDefinition__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1911:1: ( rule__SuiteDefinition__Group_7__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1912:2: rule__SuiteDefinition__Group_7__1__Impl
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_7__1__Impl_in_rule__SuiteDefinition__Group_7__13910);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1918:1: rule__SuiteDefinition__Group_7__1__Impl : ( ( rule__SuiteDefinition__FinalizersAssignment_7_1 )* ) ;
    public final void rule__SuiteDefinition__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1922:1: ( ( ( rule__SuiteDefinition__FinalizersAssignment_7_1 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1923:1: ( ( rule__SuiteDefinition__FinalizersAssignment_7_1 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1923:1: ( ( rule__SuiteDefinition__FinalizersAssignment_7_1 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1924:1: ( rule__SuiteDefinition__FinalizersAssignment_7_1 )*
            {
             before(grammarAccess.getSuiteDefinitionAccess().getFinalizersAssignment_7_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1925:1: ( rule__SuiteDefinition__FinalizersAssignment_7_1 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1925:2: rule__SuiteDefinition__FinalizersAssignment_7_1
            	    {
            	    pushFollow(FOLLOW_rule__SuiteDefinition__FinalizersAssignment_7_1_in_rule__SuiteDefinition__Group_7__1__Impl3937);
            	    rule__SuiteDefinition__FinalizersAssignment_7_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1939:1: rule__VariableDefinition__Group__0 : rule__VariableDefinition__Group__0__Impl rule__VariableDefinition__Group__1 ;
    public final void rule__VariableDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1943:1: ( rule__VariableDefinition__Group__0__Impl rule__VariableDefinition__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1944:2: rule__VariableDefinition__Group__0__Impl rule__VariableDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group__0__Impl_in_rule__VariableDefinition__Group__03972);
            rule__VariableDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDefinition__Group__1_in_rule__VariableDefinition__Group__03975);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1951:1: rule__VariableDefinition__Group__0__Impl : ( 'variable' ) ;
    public final void rule__VariableDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1955:1: ( ( 'variable' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1956:1: ( 'variable' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1956:1: ( 'variable' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1957:1: 'variable'
            {
             before(grammarAccess.getVariableDefinitionAccess().getVariableKeyword_0()); 
            match(input,25,FOLLOW_25_in_rule__VariableDefinition__Group__0__Impl4003); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1970:1: rule__VariableDefinition__Group__1 : rule__VariableDefinition__Group__1__Impl rule__VariableDefinition__Group__2 ;
    public final void rule__VariableDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1974:1: ( rule__VariableDefinition__Group__1__Impl rule__VariableDefinition__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1975:2: rule__VariableDefinition__Group__1__Impl rule__VariableDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group__1__Impl_in_rule__VariableDefinition__Group__14034);
            rule__VariableDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDefinition__Group__2_in_rule__VariableDefinition__Group__14037);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1982:1: rule__VariableDefinition__Group__1__Impl : ( ( rule__VariableDefinition__NameAssignment_1 ) ) ;
    public final void rule__VariableDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1986:1: ( ( ( rule__VariableDefinition__NameAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1987:1: ( ( rule__VariableDefinition__NameAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1987:1: ( ( rule__VariableDefinition__NameAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1988:1: ( rule__VariableDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getVariableDefinitionAccess().getNameAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1989:1: ( rule__VariableDefinition__NameAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1989:2: rule__VariableDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__VariableDefinition__NameAssignment_1_in_rule__VariableDefinition__Group__1__Impl4064);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1999:1: rule__VariableDefinition__Group__2 : rule__VariableDefinition__Group__2__Impl ;
    public final void rule__VariableDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2003:1: ( rule__VariableDefinition__Group__2__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2004:2: rule__VariableDefinition__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group__2__Impl_in_rule__VariableDefinition__Group__24094);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2010:1: rule__VariableDefinition__Group__2__Impl : ( ( rule__VariableDefinition__Group_2__0 )? ) ;
    public final void rule__VariableDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2014:1: ( ( ( rule__VariableDefinition__Group_2__0 )? ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2015:1: ( ( rule__VariableDefinition__Group_2__0 )? )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2015:1: ( ( rule__VariableDefinition__Group_2__0 )? )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2016:1: ( rule__VariableDefinition__Group_2__0 )?
            {
             before(grammarAccess.getVariableDefinitionAccess().getGroup_2()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2017:1: ( rule__VariableDefinition__Group_2__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==26) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2017:2: rule__VariableDefinition__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__VariableDefinition__Group_2__0_in_rule__VariableDefinition__Group__2__Impl4121);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2033:1: rule__VariableDefinition__Group_2__0 : rule__VariableDefinition__Group_2__0__Impl rule__VariableDefinition__Group_2__1 ;
    public final void rule__VariableDefinition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2037:1: ( rule__VariableDefinition__Group_2__0__Impl rule__VariableDefinition__Group_2__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2038:2: rule__VariableDefinition__Group_2__0__Impl rule__VariableDefinition__Group_2__1
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group_2__0__Impl_in_rule__VariableDefinition__Group_2__04158);
            rule__VariableDefinition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDefinition__Group_2__1_in_rule__VariableDefinition__Group_2__04161);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2045:1: rule__VariableDefinition__Group_2__0__Impl : ( 'initially' ) ;
    public final void rule__VariableDefinition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2049:1: ( ( 'initially' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2050:1: ( 'initially' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2050:1: ( 'initially' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2051:1: 'initially'
            {
             before(grammarAccess.getVariableDefinitionAccess().getInitiallyKeyword_2_0()); 
            match(input,26,FOLLOW_26_in_rule__VariableDefinition__Group_2__0__Impl4189); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2064:1: rule__VariableDefinition__Group_2__1 : rule__VariableDefinition__Group_2__1__Impl ;
    public final void rule__VariableDefinition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2068:1: ( rule__VariableDefinition__Group_2__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2069:2: rule__VariableDefinition__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group_2__1__Impl_in_rule__VariableDefinition__Group_2__14220);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2075:1: rule__VariableDefinition__Group_2__1__Impl : ( ( rule__VariableDefinition__InitialValueAssignment_2_1 ) ) ;
    public final void rule__VariableDefinition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2079:1: ( ( ( rule__VariableDefinition__InitialValueAssignment_2_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2080:1: ( ( rule__VariableDefinition__InitialValueAssignment_2_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2080:1: ( ( rule__VariableDefinition__InitialValueAssignment_2_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2081:1: ( rule__VariableDefinition__InitialValueAssignment_2_1 )
            {
             before(grammarAccess.getVariableDefinitionAccess().getInitialValueAssignment_2_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2082:1: ( rule__VariableDefinition__InitialValueAssignment_2_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2082:2: rule__VariableDefinition__InitialValueAssignment_2_1
            {
            pushFollow(FOLLOW_rule__VariableDefinition__InitialValueAssignment_2_1_in_rule__VariableDefinition__Group_2__1__Impl4247);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2096:1: rule__Test__Group__0 : rule__Test__Group__0__Impl rule__Test__Group__1 ;
    public final void rule__Test__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2100:1: ( rule__Test__Group__0__Impl rule__Test__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2101:2: rule__Test__Group__0__Impl rule__Test__Group__1
            {
            pushFollow(FOLLOW_rule__Test__Group__0__Impl_in_rule__Test__Group__04281);
            rule__Test__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Test__Group__1_in_rule__Test__Group__04284);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2108:1: rule__Test__Group__0__Impl : ( 'test' ) ;
    public final void rule__Test__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2112:1: ( ( 'test' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2113:1: ( 'test' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2113:1: ( 'test' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2114:1: 'test'
            {
             before(grammarAccess.getTestAccess().getTestKeyword_0()); 
            match(input,27,FOLLOW_27_in_rule__Test__Group__0__Impl4312); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2127:1: rule__Test__Group__1 : rule__Test__Group__1__Impl rule__Test__Group__2 ;
    public final void rule__Test__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2131:1: ( rule__Test__Group__1__Impl rule__Test__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2132:2: rule__Test__Group__1__Impl rule__Test__Group__2
            {
            pushFollow(FOLLOW_rule__Test__Group__1__Impl_in_rule__Test__Group__14343);
            rule__Test__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Test__Group__2_in_rule__Test__Group__14346);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2139:1: rule__Test__Group__1__Impl : ( ( rule__Test__DefinitionAssignment_1 ) ) ;
    public final void rule__Test__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2143:1: ( ( ( rule__Test__DefinitionAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2144:1: ( ( rule__Test__DefinitionAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2144:1: ( ( rule__Test__DefinitionAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2145:1: ( rule__Test__DefinitionAssignment_1 )
            {
             before(grammarAccess.getTestAccess().getDefinitionAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2146:1: ( rule__Test__DefinitionAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2146:2: rule__Test__DefinitionAssignment_1
            {
            pushFollow(FOLLOW_rule__Test__DefinitionAssignment_1_in_rule__Test__Group__1__Impl4373);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2156:1: rule__Test__Group__2 : rule__Test__Group__2__Impl rule__Test__Group__3 ;
    public final void rule__Test__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2160:1: ( rule__Test__Group__2__Impl rule__Test__Group__3 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2161:2: rule__Test__Group__2__Impl rule__Test__Group__3
            {
            pushFollow(FOLLOW_rule__Test__Group__2__Impl_in_rule__Test__Group__24403);
            rule__Test__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Test__Group__3_in_rule__Test__Group__24406);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2168:1: rule__Test__Group__2__Impl : ( ( rule__Test__ParametersAssignment_2 )* ) ;
    public final void rule__Test__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2172:1: ( ( ( rule__Test__ParametersAssignment_2 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2173:1: ( ( rule__Test__ParametersAssignment_2 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2173:1: ( ( rule__Test__ParametersAssignment_2 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2174:1: ( rule__Test__ParametersAssignment_2 )*
            {
             before(grammarAccess.getTestAccess().getParametersAssignment_2()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2175:1: ( rule__Test__ParametersAssignment_2 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_ID) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2175:2: rule__Test__ParametersAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Test__ParametersAssignment_2_in_rule__Test__Group__2__Impl4433);
            	    rule__Test__ParametersAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2185:1: rule__Test__Group__3 : rule__Test__Group__3__Impl ;
    public final void rule__Test__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2189:1: ( rule__Test__Group__3__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2190:2: rule__Test__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Test__Group__3__Impl_in_rule__Test__Group__34464);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2196:1: rule__Test__Group__3__Impl : ( ( rule__Test__Group_3__0 )? ) ;
    public final void rule__Test__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2200:1: ( ( ( rule__Test__Group_3__0 )? ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2201:1: ( ( rule__Test__Group_3__0 )? )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2201:1: ( ( rule__Test__Group_3__0 )? )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2202:1: ( rule__Test__Group_3__0 )?
            {
             before(grammarAccess.getTestAccess().getGroup_3()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2203:1: ( rule__Test__Group_3__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==28) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2203:2: rule__Test__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Test__Group_3__0_in_rule__Test__Group__3__Impl4491);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2221:1: rule__Test__Group_3__0 : rule__Test__Group_3__0__Impl rule__Test__Group_3__1 ;
    public final void rule__Test__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2225:1: ( rule__Test__Group_3__0__Impl rule__Test__Group_3__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2226:2: rule__Test__Group_3__0__Impl rule__Test__Group_3__1
            {
            pushFollow(FOLLOW_rule__Test__Group_3__0__Impl_in_rule__Test__Group_3__04530);
            rule__Test__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Test__Group_3__1_in_rule__Test__Group_3__04533);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2233:1: rule__Test__Group_3__0__Impl : ( '=' ) ;
    public final void rule__Test__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2237:1: ( ( '=' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2238:1: ( '=' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2238:1: ( '=' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2239:1: '='
            {
             before(grammarAccess.getTestAccess().getEqualsSignKeyword_3_0()); 
            match(input,28,FOLLOW_28_in_rule__Test__Group_3__0__Impl4561); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2252:1: rule__Test__Group_3__1 : rule__Test__Group_3__1__Impl ;
    public final void rule__Test__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2256:1: ( rule__Test__Group_3__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2257:2: rule__Test__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Test__Group_3__1__Impl_in_rule__Test__Group_3__14592);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2263:1: rule__Test__Group_3__1__Impl : ( ( rule__Test__ResultAssignment_3_1 ) ) ;
    public final void rule__Test__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2267:1: ( ( ( rule__Test__ResultAssignment_3_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2268:1: ( ( rule__Test__ResultAssignment_3_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2268:1: ( ( rule__Test__ResultAssignment_3_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2269:1: ( rule__Test__ResultAssignment_3_1 )
            {
             before(grammarAccess.getTestAccess().getResultAssignment_3_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2270:1: ( rule__Test__ResultAssignment_3_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2270:2: rule__Test__ResultAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Test__ResultAssignment_3_1_in_rule__Test__Group_3__1__Impl4619);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2284:1: rule__Call__Group__0 : rule__Call__Group__0__Impl rule__Call__Group__1 ;
    public final void rule__Call__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2288:1: ( rule__Call__Group__0__Impl rule__Call__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2289:2: rule__Call__Group__0__Impl rule__Call__Group__1
            {
            pushFollow(FOLLOW_rule__Call__Group__0__Impl_in_rule__Call__Group__04653);
            rule__Call__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group__1_in_rule__Call__Group__04656);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2296:1: rule__Call__Group__0__Impl : ( 'call' ) ;
    public final void rule__Call__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2300:1: ( ( 'call' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2301:1: ( 'call' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2301:1: ( 'call' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2302:1: 'call'
            {
             before(grammarAccess.getCallAccess().getCallKeyword_0()); 
            match(input,29,FOLLOW_29_in_rule__Call__Group__0__Impl4684); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2315:1: rule__Call__Group__1 : rule__Call__Group__1__Impl rule__Call__Group__2 ;
    public final void rule__Call__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2319:1: ( rule__Call__Group__1__Impl rule__Call__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2320:2: rule__Call__Group__1__Impl rule__Call__Group__2
            {
            pushFollow(FOLLOW_rule__Call__Group__1__Impl_in_rule__Call__Group__14715);
            rule__Call__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group__2_in_rule__Call__Group__14718);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2327:1: rule__Call__Group__1__Impl : ( ( rule__Call__DefinitionAssignment_1 ) ) ;
    public final void rule__Call__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2331:1: ( ( ( rule__Call__DefinitionAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2332:1: ( ( rule__Call__DefinitionAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2332:1: ( ( rule__Call__DefinitionAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2333:1: ( rule__Call__DefinitionAssignment_1 )
            {
             before(grammarAccess.getCallAccess().getDefinitionAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2334:1: ( rule__Call__DefinitionAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2334:2: rule__Call__DefinitionAssignment_1
            {
            pushFollow(FOLLOW_rule__Call__DefinitionAssignment_1_in_rule__Call__Group__1__Impl4745);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2344:1: rule__Call__Group__2 : rule__Call__Group__2__Impl rule__Call__Group__3 ;
    public final void rule__Call__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2348:1: ( rule__Call__Group__2__Impl rule__Call__Group__3 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2349:2: rule__Call__Group__2__Impl rule__Call__Group__3
            {
            pushFollow(FOLLOW_rule__Call__Group__2__Impl_in_rule__Call__Group__24775);
            rule__Call__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group__3_in_rule__Call__Group__24778);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2356:1: rule__Call__Group__2__Impl : ( ( rule__Call__ParametersAssignment_2 )* ) ;
    public final void rule__Call__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2360:1: ( ( ( rule__Call__ParametersAssignment_2 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2361:1: ( ( rule__Call__ParametersAssignment_2 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2361:1: ( ( rule__Call__ParametersAssignment_2 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2362:1: ( rule__Call__ParametersAssignment_2 )*
            {
             before(grammarAccess.getCallAccess().getParametersAssignment_2()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2363:1: ( rule__Call__ParametersAssignment_2 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2363:2: rule__Call__ParametersAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Call__ParametersAssignment_2_in_rule__Call__Group__2__Impl4805);
            	    rule__Call__ParametersAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2373:1: rule__Call__Group__3 : rule__Call__Group__3__Impl ;
    public final void rule__Call__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2377:1: ( rule__Call__Group__3__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2378:2: rule__Call__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Call__Group__3__Impl_in_rule__Call__Group__34836);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2384:1: rule__Call__Group__3__Impl : ( ( rule__Call__Group_3__0 )? ) ;
    public final void rule__Call__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2388:1: ( ( ( rule__Call__Group_3__0 )? ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2389:1: ( ( rule__Call__Group_3__0 )? )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2389:1: ( ( rule__Call__Group_3__0 )? )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2390:1: ( rule__Call__Group_3__0 )?
            {
             before(grammarAccess.getCallAccess().getGroup_3()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2391:1: ( rule__Call__Group_3__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==30) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2391:2: rule__Call__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Call__Group_3__0_in_rule__Call__Group__3__Impl4863);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2409:1: rule__Call__Group_3__0 : rule__Call__Group_3__0__Impl rule__Call__Group_3__1 ;
    public final void rule__Call__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2413:1: ( rule__Call__Group_3__0__Impl rule__Call__Group_3__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2414:2: rule__Call__Group_3__0__Impl rule__Call__Group_3__1
            {
            pushFollow(FOLLOW_rule__Call__Group_3__0__Impl_in_rule__Call__Group_3__04902);
            rule__Call__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group_3__1_in_rule__Call__Group_3__04905);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2421:1: rule__Call__Group_3__0__Impl : ( 'sets' ) ;
    public final void rule__Call__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2425:1: ( ( 'sets' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2426:1: ( 'sets' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2426:1: ( 'sets' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2427:1: 'sets'
            {
             before(grammarAccess.getCallAccess().getSetsKeyword_3_0()); 
            match(input,30,FOLLOW_30_in_rule__Call__Group_3__0__Impl4933); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2440:1: rule__Call__Group_3__1 : rule__Call__Group_3__1__Impl ;
    public final void rule__Call__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2444:1: ( rule__Call__Group_3__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2445:2: rule__Call__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Call__Group_3__1__Impl_in_rule__Call__Group_3__14964);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2451:1: rule__Call__Group_3__1__Impl : ( ( rule__Call__ResultAssignment_3_1 ) ) ;
    public final void rule__Call__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2455:1: ( ( ( rule__Call__ResultAssignment_3_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2456:1: ( ( rule__Call__ResultAssignment_3_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2456:1: ( ( rule__Call__ResultAssignment_3_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2457:1: ( rule__Call__ResultAssignment_3_1 )
            {
             before(grammarAccess.getCallAccess().getResultAssignment_3_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2458:1: ( rule__Call__ResultAssignment_3_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2458:2: rule__Call__ResultAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Call__ResultAssignment_3_1_in_rule__Call__Group_3__1__Impl4991);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2472:1: rule__Suite__Group__0 : rule__Suite__Group__0__Impl rule__Suite__Group__1 ;
    public final void rule__Suite__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2476:1: ( rule__Suite__Group__0__Impl rule__Suite__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2477:2: rule__Suite__Group__0__Impl rule__Suite__Group__1
            {
            pushFollow(FOLLOW_rule__Suite__Group__0__Impl_in_rule__Suite__Group__05025);
            rule__Suite__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Suite__Group__1_in_rule__Suite__Group__05028);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2484:1: rule__Suite__Group__0__Impl : ( 'suite' ) ;
    public final void rule__Suite__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2488:1: ( ( 'suite' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2489:1: ( 'suite' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2489:1: ( 'suite' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2490:1: 'suite'
            {
             before(grammarAccess.getSuiteAccess().getSuiteKeyword_0()); 
            match(input,31,FOLLOW_31_in_rule__Suite__Group__0__Impl5056); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2503:1: rule__Suite__Group__1 : rule__Suite__Group__1__Impl rule__Suite__Group__2 ;
    public final void rule__Suite__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2507:1: ( rule__Suite__Group__1__Impl rule__Suite__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2508:2: rule__Suite__Group__1__Impl rule__Suite__Group__2
            {
            pushFollow(FOLLOW_rule__Suite__Group__1__Impl_in_rule__Suite__Group__15087);
            rule__Suite__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Suite__Group__2_in_rule__Suite__Group__15090);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2515:1: rule__Suite__Group__1__Impl : ( ( rule__Suite__DefinitionAssignment_1 ) ) ;
    public final void rule__Suite__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2519:1: ( ( ( rule__Suite__DefinitionAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2520:1: ( ( rule__Suite__DefinitionAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2520:1: ( ( rule__Suite__DefinitionAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2521:1: ( rule__Suite__DefinitionAssignment_1 )
            {
             before(grammarAccess.getSuiteAccess().getDefinitionAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2522:1: ( rule__Suite__DefinitionAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2522:2: rule__Suite__DefinitionAssignment_1
            {
            pushFollow(FOLLOW_rule__Suite__DefinitionAssignment_1_in_rule__Suite__Group__1__Impl5117);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2532:1: rule__Suite__Group__2 : rule__Suite__Group__2__Impl ;
    public final void rule__Suite__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2536:1: ( rule__Suite__Group__2__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2537:2: rule__Suite__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Suite__Group__2__Impl_in_rule__Suite__Group__25147);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2543:1: rule__Suite__Group__2__Impl : ( ( rule__Suite__ParametersAssignment_2 )* ) ;
    public final void rule__Suite__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2547:1: ( ( ( rule__Suite__ParametersAssignment_2 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2548:1: ( ( rule__Suite__ParametersAssignment_2 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2548:1: ( ( rule__Suite__ParametersAssignment_2 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2549:1: ( rule__Suite__ParametersAssignment_2 )*
            {
             before(grammarAccess.getSuiteAccess().getParametersAssignment_2()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2550:1: ( rule__Suite__ParametersAssignment_2 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2550:2: rule__Suite__ParametersAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Suite__ParametersAssignment_2_in_rule__Suite__Group__2__Impl5174);
            	    rule__Suite__ParametersAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2566:1: rule__SuiteParameter__Group__0 : rule__SuiteParameter__Group__0__Impl rule__SuiteParameter__Group__1 ;
    public final void rule__SuiteParameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2570:1: ( rule__SuiteParameter__Group__0__Impl rule__SuiteParameter__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2571:2: rule__SuiteParameter__Group__0__Impl rule__SuiteParameter__Group__1
            {
            pushFollow(FOLLOW_rule__SuiteParameter__Group__0__Impl_in_rule__SuiteParameter__Group__05211);
            rule__SuiteParameter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteParameter__Group__1_in_rule__SuiteParameter__Group__05214);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2578:1: rule__SuiteParameter__Group__0__Impl : ( ( rule__SuiteParameter__NameAssignment_0 ) ) ;
    public final void rule__SuiteParameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2582:1: ( ( ( rule__SuiteParameter__NameAssignment_0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2583:1: ( ( rule__SuiteParameter__NameAssignment_0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2583:1: ( ( rule__SuiteParameter__NameAssignment_0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2584:1: ( rule__SuiteParameter__NameAssignment_0 )
            {
             before(grammarAccess.getSuiteParameterAccess().getNameAssignment_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2585:1: ( rule__SuiteParameter__NameAssignment_0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2585:2: rule__SuiteParameter__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__SuiteParameter__NameAssignment_0_in_rule__SuiteParameter__Group__0__Impl5241);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2595:1: rule__SuiteParameter__Group__1 : rule__SuiteParameter__Group__1__Impl rule__SuiteParameter__Group__2 ;
    public final void rule__SuiteParameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2599:1: ( rule__SuiteParameter__Group__1__Impl rule__SuiteParameter__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2600:2: rule__SuiteParameter__Group__1__Impl rule__SuiteParameter__Group__2
            {
            pushFollow(FOLLOW_rule__SuiteParameter__Group__1__Impl_in_rule__SuiteParameter__Group__15271);
            rule__SuiteParameter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteParameter__Group__2_in_rule__SuiteParameter__Group__15274);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2607:1: rule__SuiteParameter__Group__1__Impl : ( ':' ) ;
    public final void rule__SuiteParameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2611:1: ( ( ':' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2612:1: ( ':' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2612:1: ( ':' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2613:1: ':'
            {
             before(grammarAccess.getSuiteParameterAccess().getColonKeyword_1()); 
            match(input,32,FOLLOW_32_in_rule__SuiteParameter__Group__1__Impl5302); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2626:1: rule__SuiteParameter__Group__2 : rule__SuiteParameter__Group__2__Impl ;
    public final void rule__SuiteParameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2630:1: ( rule__SuiteParameter__Group__2__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2631:2: rule__SuiteParameter__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__SuiteParameter__Group__2__Impl_in_rule__SuiteParameter__Group__25333);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2637:1: rule__SuiteParameter__Group__2__Impl : ( ( rule__SuiteParameter__ValueAssignment_2 ) ) ;
    public final void rule__SuiteParameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2641:1: ( ( ( rule__SuiteParameter__ValueAssignment_2 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2642:1: ( ( rule__SuiteParameter__ValueAssignment_2 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2642:1: ( ( rule__SuiteParameter__ValueAssignment_2 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2643:1: ( rule__SuiteParameter__ValueAssignment_2 )
            {
             before(grammarAccess.getSuiteParameterAccess().getValueAssignment_2()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2644:1: ( rule__SuiteParameter__ValueAssignment_2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2644:2: rule__SuiteParameter__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__SuiteParameter__ValueAssignment_2_in_rule__SuiteParameter__Group__2__Impl5360);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2660:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2664:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2665:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
            {
            pushFollow(FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__05396);
            rule__Parameter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__05399);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2672:1: rule__Parameter__Group__0__Impl : ( ( rule__Parameter__NameAssignment_0 ) ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2676:1: ( ( ( rule__Parameter__NameAssignment_0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2677:1: ( ( rule__Parameter__NameAssignment_0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2677:1: ( ( rule__Parameter__NameAssignment_0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2678:1: ( rule__Parameter__NameAssignment_0 )
            {
             before(grammarAccess.getParameterAccess().getNameAssignment_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2679:1: ( rule__Parameter__NameAssignment_0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2679:2: rule__Parameter__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Parameter__NameAssignment_0_in_rule__Parameter__Group__0__Impl5426);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2689:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl rule__Parameter__Group__2 ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2693:1: ( rule__Parameter__Group__1__Impl rule__Parameter__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2694:2: rule__Parameter__Group__1__Impl rule__Parameter__Group__2
            {
            pushFollow(FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__15456);
            rule__Parameter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Parameter__Group__2_in_rule__Parameter__Group__15459);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2701:1: rule__Parameter__Group__1__Impl : ( ':' ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2705:1: ( ( ':' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2706:1: ( ':' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2706:1: ( ':' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2707:1: ':'
            {
             before(grammarAccess.getParameterAccess().getColonKeyword_1()); 
            match(input,32,FOLLOW_32_in_rule__Parameter__Group__1__Impl5487); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2720:1: rule__Parameter__Group__2 : rule__Parameter__Group__2__Impl ;
    public final void rule__Parameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2724:1: ( rule__Parameter__Group__2__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2725:2: rule__Parameter__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Parameter__Group__2__Impl_in_rule__Parameter__Group__25518);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2731:1: rule__Parameter__Group__2__Impl : ( ( rule__Parameter__ValueAssignment_2 ) ) ;
    public final void rule__Parameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2735:1: ( ( ( rule__Parameter__ValueAssignment_2 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2736:1: ( ( rule__Parameter__ValueAssignment_2 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2736:1: ( ( rule__Parameter__ValueAssignment_2 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2737:1: ( rule__Parameter__ValueAssignment_2 )
            {
             before(grammarAccess.getParameterAccess().getValueAssignment_2()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2738:1: ( rule__Parameter__ValueAssignment_2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2738:2: rule__Parameter__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__Parameter__ValueAssignment_2_in_rule__Parameter__Group__2__Impl5545);
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


    // $ANTLR start "rule__MethodReference__Group__0"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2754:1: rule__MethodReference__Group__0 : rule__MethodReference__Group__0__Impl rule__MethodReference__Group__1 ;
    public final void rule__MethodReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2758:1: ( rule__MethodReference__Group__0__Impl rule__MethodReference__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2759:2: rule__MethodReference__Group__0__Impl rule__MethodReference__Group__1
            {
            pushFollow(FOLLOW_rule__MethodReference__Group__0__Impl_in_rule__MethodReference__Group__05581);
            rule__MethodReference__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodReference__Group__1_in_rule__MethodReference__Group__05584);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2766:1: rule__MethodReference__Group__0__Impl : ( ( rule__MethodReference__TypeAssignment_0 ) ) ;
    public final void rule__MethodReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2770:1: ( ( ( rule__MethodReference__TypeAssignment_0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2771:1: ( ( rule__MethodReference__TypeAssignment_0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2771:1: ( ( rule__MethodReference__TypeAssignment_0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2772:1: ( rule__MethodReference__TypeAssignment_0 )
            {
             before(grammarAccess.getMethodReferenceAccess().getTypeAssignment_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2773:1: ( rule__MethodReference__TypeAssignment_0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2773:2: rule__MethodReference__TypeAssignment_0
            {
            pushFollow(FOLLOW_rule__MethodReference__TypeAssignment_0_in_rule__MethodReference__Group__0__Impl5611);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2783:1: rule__MethodReference__Group__1 : rule__MethodReference__Group__1__Impl rule__MethodReference__Group__2 ;
    public final void rule__MethodReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2787:1: ( rule__MethodReference__Group__1__Impl rule__MethodReference__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2788:2: rule__MethodReference__Group__1__Impl rule__MethodReference__Group__2
            {
            pushFollow(FOLLOW_rule__MethodReference__Group__1__Impl_in_rule__MethodReference__Group__15641);
            rule__MethodReference__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodReference__Group__2_in_rule__MethodReference__Group__15644);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2795:1: rule__MethodReference__Group__1__Impl : ( '#' ) ;
    public final void rule__MethodReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2799:1: ( ( '#' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2800:1: ( '#' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2800:1: ( '#' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2801:1: '#'
            {
             before(grammarAccess.getMethodReferenceAccess().getNumberSignKeyword_1()); 
            match(input,33,FOLLOW_33_in_rule__MethodReference__Group__1__Impl5672); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2814:1: rule__MethodReference__Group__2 : rule__MethodReference__Group__2__Impl ;
    public final void rule__MethodReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2818:1: ( rule__MethodReference__Group__2__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2819:2: rule__MethodReference__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__MethodReference__Group__2__Impl_in_rule__MethodReference__Group__25703);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2825:1: rule__MethodReference__Group__2__Impl : ( ( rule__MethodReference__MethodAssignment_2 ) ) ;
    public final void rule__MethodReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2829:1: ( ( ( rule__MethodReference__MethodAssignment_2 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2830:1: ( ( rule__MethodReference__MethodAssignment_2 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2830:1: ( ( rule__MethodReference__MethodAssignment_2 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2831:1: ( rule__MethodReference__MethodAssignment_2 )
            {
             before(grammarAccess.getMethodReferenceAccess().getMethodAssignment_2()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2832:1: ( rule__MethodReference__MethodAssignment_2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2832:2: rule__MethodReference__MethodAssignment_2
            {
            pushFollow(FOLLOW_rule__MethodReference__MethodAssignment_2_in_rule__MethodReference__Group__2__Impl5730);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2848:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2852:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2853:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__05766);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__05769);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2860:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2864:1: ( ( RULE_ID ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2865:1: ( RULE_ID )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2865:1: ( RULE_ID )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2866:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl5796); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2877:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2881:1: ( rule__QualifiedName__Group__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2882:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__15825);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2888:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2892:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2893:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2893:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2894:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2895:1: ( rule__QualifiedName__Group_1__0 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==34) ) {
                    int LA22_2 = input.LA(2);

                    if ( (LA22_2==RULE_ID) ) {
                        alt22=1;
                    }


                }


                switch (alt22) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2895:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl5852);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2909:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2913:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2914:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__05887);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__05890);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2921:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2925:1: ( ( '.' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2926:1: ( '.' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2926:1: ( '.' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2927:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,34,FOLLOW_34_in_rule__QualifiedName__Group_1__0__Impl5918); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2940:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2944:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2945:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__15949);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2951:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2955:1: ( ( RULE_ID ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2956:1: ( RULE_ID )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2956:1: ( RULE_ID )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2957:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl5976); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2972:1: rule__QualifiedJavaClassName__Group__0 : rule__QualifiedJavaClassName__Group__0__Impl rule__QualifiedJavaClassName__Group__1 ;
    public final void rule__QualifiedJavaClassName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2976:1: ( rule__QualifiedJavaClassName__Group__0__Impl rule__QualifiedJavaClassName__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2977:2: rule__QualifiedJavaClassName__Group__0__Impl rule__QualifiedJavaClassName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__0__Impl_in_rule__QualifiedJavaClassName__Group__06009);
            rule__QualifiedJavaClassName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__1_in_rule__QualifiedJavaClassName__Group__06012);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2984:1: rule__QualifiedJavaClassName__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedJavaClassName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2988:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2989:1: ( ruleQualifiedName )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2989:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2990:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedJavaClassNameAccess().getQualifiedNameParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedJavaClassName__Group__0__Impl6039);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3001:1: rule__QualifiedJavaClassName__Group__1 : rule__QualifiedJavaClassName__Group__1__Impl rule__QualifiedJavaClassName__Group__2 ;
    public final void rule__QualifiedJavaClassName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3005:1: ( rule__QualifiedJavaClassName__Group__1__Impl rule__QualifiedJavaClassName__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3006:2: rule__QualifiedJavaClassName__Group__1__Impl rule__QualifiedJavaClassName__Group__2
            {
            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__1__Impl_in_rule__QualifiedJavaClassName__Group__16068);
            rule__QualifiedJavaClassName__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__2_in_rule__QualifiedJavaClassName__Group__16071);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3013:1: rule__QualifiedJavaClassName__Group__1__Impl : ( '.' ) ;
    public final void rule__QualifiedJavaClassName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3017:1: ( ( '.' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3018:1: ( '.' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3018:1: ( '.' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3019:1: '.'
            {
             before(grammarAccess.getQualifiedJavaClassNameAccess().getFullStopKeyword_1()); 
            match(input,34,FOLLOW_34_in_rule__QualifiedJavaClassName__Group__1__Impl6099); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3032:1: rule__QualifiedJavaClassName__Group__2 : rule__QualifiedJavaClassName__Group__2__Impl ;
    public final void rule__QualifiedJavaClassName__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3036:1: ( rule__QualifiedJavaClassName__Group__2__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3037:2: rule__QualifiedJavaClassName__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__2__Impl_in_rule__QualifiedJavaClassName__Group__26130);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3043:1: rule__QualifiedJavaClassName__Group__2__Impl : ( RULE_UPPERCASE_ID ) ;
    public final void rule__QualifiedJavaClassName__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3047:1: ( ( RULE_UPPERCASE_ID ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3048:1: ( RULE_UPPERCASE_ID )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3048:1: ( RULE_UPPERCASE_ID )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3049:1: RULE_UPPERCASE_ID
            {
             before(grammarAccess.getQualifiedJavaClassNameAccess().getUPPERCASE_IDTerminalRuleCall_2()); 
            match(input,RULE_UPPERCASE_ID,FOLLOW_RULE_UPPERCASE_ID_in_rule__QualifiedJavaClassName__Group__2__Impl6157); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3066:1: rule__QualifiedNameWithWildcard__Group__0 : rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 ;
    public final void rule__QualifiedNameWithWildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3070:1: ( rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3071:2: rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__0__Impl_in_rule__QualifiedNameWithWildcard__Group__06192);
            rule__QualifiedNameWithWildcard__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__1_in_rule__QualifiedNameWithWildcard__Group__06195);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3078:1: rule__QualifiedNameWithWildcard__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedNameWithWildcard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3082:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3083:1: ( ruleQualifiedName )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3083:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3084:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildcard__Group__0__Impl6222);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3095:1: rule__QualifiedNameWithWildcard__Group__1 : rule__QualifiedNameWithWildcard__Group__1__Impl ;
    public final void rule__QualifiedNameWithWildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3099:1: ( rule__QualifiedNameWithWildcard__Group__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3100:2: rule__QualifiedNameWithWildcard__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__1__Impl_in_rule__QualifiedNameWithWildcard__Group__16251);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3106:1: rule__QualifiedNameWithWildcard__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__QualifiedNameWithWildcard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3110:1: ( ( ( '.*' )? ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3111:1: ( ( '.*' )? )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3111:1: ( ( '.*' )? )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3112:1: ( '.*' )?
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3113:1: ( '.*' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==35) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3114:2: '.*'
                    {
                    match(input,35,FOLLOW_35_in_rule__QualifiedNameWithWildcard__Group__1__Impl6280); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3130:1: rule__Model__StatementsAssignment : ( ruleStatement ) ;
    public final void rule__Model__StatementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3134:1: ( ( ruleStatement ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3135:1: ( ruleStatement )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3135:1: ( ruleStatement )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3136:1: ruleStatement
            {
             before(grammarAccess.getModelAccess().getStatementsStatementParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleStatement_in_rule__Model__StatementsAssignment6322);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3145:1: rule__PackageDefinition__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__PackageDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3149:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3150:1: ( ruleQualifiedName )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3150:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3151:1: ruleQualifiedName
            {
             before(grammarAccess.getPackageDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__PackageDefinition__NameAssignment_16353);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3160:1: rule__PackageDefinition__StatementsAssignment_3 : ( rulePackageStatement ) ;
    public final void rule__PackageDefinition__StatementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3164:1: ( ( rulePackageStatement ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3165:1: ( rulePackageStatement )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3165:1: ( rulePackageStatement )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3166:1: rulePackageStatement
            {
             before(grammarAccess.getPackageDefinitionAccess().getStatementsPackageStatementParserRuleCall_3_0()); 
            pushFollow(FOLLOW_rulePackageStatement_in_rule__PackageDefinition__StatementsAssignment_36384);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3175:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleQualifiedNameWithWildcard ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3179:1: ( ( ruleQualifiedNameWithWildcard ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3180:1: ( ruleQualifiedNameWithWildcard )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3180:1: ( ruleQualifiedNameWithWildcard )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3181:1: ruleQualifiedNameWithWildcard
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_rule__Import__ImportedNamespaceAssignment_16415);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3190:1: rule__TestDefinition__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__TestDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3194:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3195:1: ( ruleQualifiedName )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3195:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3196:1: ruleQualifiedName
            {
             before(grammarAccess.getTestDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__TestDefinition__NameAssignment_16446);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3205:1: rule__TestDefinition__FixtureMethodAssignment_3 : ( ruleMethodReference ) ;
    public final void rule__TestDefinition__FixtureMethodAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3209:1: ( ( ruleMethodReference ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3210:1: ( ruleMethodReference )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3210:1: ( ruleMethodReference )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3211:1: ruleMethodReference
            {
             before(grammarAccess.getTestDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleMethodReference_in_rule__TestDefinition__FixtureMethodAssignment_36477);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3220:1: rule__CallDefinition__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__CallDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3224:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3225:1: ( ruleQualifiedName )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3225:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3226:1: ruleQualifiedName
            {
             before(grammarAccess.getCallDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__CallDefinition__NameAssignment_16508);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3235:1: rule__CallDefinition__FixtureMethodAssignment_3 : ( ruleMethodReference ) ;
    public final void rule__CallDefinition__FixtureMethodAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3239:1: ( ( ruleMethodReference ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3240:1: ( ruleMethodReference )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3240:1: ( ruleMethodReference )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3241:1: ruleMethodReference
            {
             before(grammarAccess.getCallDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleMethodReference_in_rule__CallDefinition__FixtureMethodAssignment_36539);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3250:1: rule__SuiteDefinition__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__SuiteDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3254:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3255:1: ( ruleQualifiedName )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3255:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3256:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__NameAssignment_16570);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3265:1: rule__SuiteDefinition__ParametersAssignment_2_1 : ( ruleVariableEntity ) ;
    public final void rule__SuiteDefinition__ParametersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3269:1: ( ( ruleVariableEntity ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3270:1: ( ruleVariableEntity )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3270:1: ( ruleVariableEntity )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3271:1: ruleVariableEntity
            {
             before(grammarAccess.getSuiteDefinitionAccess().getParametersVariableEntityParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleVariableEntity_in_rule__SuiteDefinition__ParametersAssignment_2_16601);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3280:1: rule__SuiteDefinition__DependenciesAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__SuiteDefinition__DependenciesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3284:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3285:1: ( ( ruleQualifiedName ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3285:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3286:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSuiteDefinitionAccess().getDependenciesSuiteDefinitionCrossReference_3_1_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3287:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3288:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteDefinitionAccess().getDependenciesSuiteDefinitionQualifiedNameParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__DependenciesAssignment_3_16636);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3299:1: rule__SuiteDefinition__StatementsAssignment_5 : ( ruleSuiteStatement ) ;
    public final void rule__SuiteDefinition__StatementsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3303:1: ( ( ruleSuiteStatement ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3304:1: ( ruleSuiteStatement )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3304:1: ( ruleSuiteStatement )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3305:1: ruleSuiteStatement
            {
             before(grammarAccess.getSuiteDefinitionAccess().getStatementsSuiteStatementParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleSuiteStatement_in_rule__SuiteDefinition__StatementsAssignment_56671);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3314:1: rule__SuiteDefinition__FinalizersAssignment_7_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__SuiteDefinition__FinalizersAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3318:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3319:1: ( ( ruleQualifiedName ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3319:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3320:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSuiteDefinitionAccess().getFinalizersSuiteDefinitionCrossReference_7_1_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3321:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3322:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteDefinitionAccess().getFinalizersSuiteDefinitionQualifiedNameParserRuleCall_7_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__FinalizersAssignment_7_16706);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3333:1: rule__VariableDefinition__NameAssignment_1 : ( ruleVariableEntity ) ;
    public final void rule__VariableDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3337:1: ( ( ruleVariableEntity ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3338:1: ( ruleVariableEntity )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3338:1: ( ruleVariableEntity )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3339:1: ruleVariableEntity
            {
             before(grammarAccess.getVariableDefinitionAccess().getNameVariableEntityParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleVariableEntity_in_rule__VariableDefinition__NameAssignment_16741);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3348:1: rule__VariableDefinition__InitialValueAssignment_2_1 : ( ruleValue ) ;
    public final void rule__VariableDefinition__InitialValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3352:1: ( ( ruleValue ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3353:1: ( ruleValue )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3353:1: ( ruleValue )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3354:1: ruleValue
            {
             before(grammarAccess.getVariableDefinitionAccess().getInitialValueValueParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleValue_in_rule__VariableDefinition__InitialValueAssignment_2_16772);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3363:1: rule__VariableEntity__NameAssignment : ( ruleQualifiedName ) ;
    public final void rule__VariableEntity__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3367:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3368:1: ( ruleQualifiedName )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3368:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3369:1: ruleQualifiedName
            {
             before(grammarAccess.getVariableEntityAccess().getNameQualifiedNameParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__VariableEntity__NameAssignment6803);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3378:1: rule__Test__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Test__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3382:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3383:1: ( ( ruleQualifiedName ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3383:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3384:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getTestAccess().getDefinitionTestDefinitionCrossReference_1_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3385:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3386:1: ruleQualifiedName
            {
             before(grammarAccess.getTestAccess().getDefinitionTestDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Test__DefinitionAssignment_16838);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3397:1: rule__Test__ParametersAssignment_2 : ( ruleParameter ) ;
    public final void rule__Test__ParametersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3401:1: ( ( ruleParameter ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3402:1: ( ruleParameter )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3402:1: ( ruleParameter )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3403:1: ruleParameter
            {
             before(grammarAccess.getTestAccess().getParametersParameterParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleParameter_in_rule__Test__ParametersAssignment_26873);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3412:1: rule__Test__ResultAssignment_3_1 : ( ruleValueOrEnumValue ) ;
    public final void rule__Test__ResultAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3416:1: ( ( ruleValueOrEnumValue ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3417:1: ( ruleValueOrEnumValue )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3417:1: ( ruleValueOrEnumValue )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3418:1: ruleValueOrEnumValue
            {
             before(grammarAccess.getTestAccess().getResultValueOrEnumValueParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_rule__Test__ResultAssignment_3_16904);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3427:1: rule__Call__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Call__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3431:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3432:1: ( ( ruleQualifiedName ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3432:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3433:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getCallAccess().getDefinitionCallDefinitionCrossReference_1_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3434:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3435:1: ruleQualifiedName
            {
             before(grammarAccess.getCallAccess().getDefinitionCallDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Call__DefinitionAssignment_16939);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3446:1: rule__Call__ParametersAssignment_2 : ( ruleParameter ) ;
    public final void rule__Call__ParametersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3450:1: ( ( ruleParameter ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3451:1: ( ruleParameter )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3451:1: ( ruleParameter )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3452:1: ruleParameter
            {
             before(grammarAccess.getCallAccess().getParametersParameterParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleParameter_in_rule__Call__ParametersAssignment_26974);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3461:1: rule__Call__ResultAssignment_3_1 : ( ruleVariable ) ;
    public final void rule__Call__ResultAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3465:1: ( ( ruleVariable ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3466:1: ( ruleVariable )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3466:1: ( ruleVariable )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3467:1: ruleVariable
            {
             before(grammarAccess.getCallAccess().getResultVariableParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleVariable_in_rule__Call__ResultAssignment_3_17005);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3476:1: rule__Suite__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Suite__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3480:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3481:1: ( ( ruleQualifiedName ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3481:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3482:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSuiteAccess().getDefinitionSuiteDefinitionCrossReference_1_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3483:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3484:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteAccess().getDefinitionSuiteDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Suite__DefinitionAssignment_17040);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3495:1: rule__Suite__ParametersAssignment_2 : ( ruleSuiteParameter ) ;
    public final void rule__Suite__ParametersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3499:1: ( ( ruleSuiteParameter ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3500:1: ( ruleSuiteParameter )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3500:1: ( ruleSuiteParameter )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3501:1: ruleSuiteParameter
            {
             before(grammarAccess.getSuiteAccess().getParametersSuiteParameterParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleSuiteParameter_in_rule__Suite__ParametersAssignment_27075);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3510:1: rule__SuiteParameter__NameAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__SuiteParameter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3514:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3515:1: ( ( ruleQualifiedName ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3515:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3516:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSuiteParameterAccess().getNameVariableEntityCrossReference_0_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3517:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3518:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteParameterAccess().getNameVariableEntityQualifiedNameParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__SuiteParameter__NameAssignment_07110);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3529:1: rule__SuiteParameter__ValueAssignment_2 : ( ruleValue ) ;
    public final void rule__SuiteParameter__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3533:1: ( ( ruleValue ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3534:1: ( ruleValue )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3534:1: ( ruleValue )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3535:1: ruleValue
            {
             before(grammarAccess.getSuiteParameterAccess().getValueValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleValue_in_rule__SuiteParameter__ValueAssignment_27145);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3544:1: rule__Parameter__NameAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__Parameter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3548:1: ( ( ( RULE_ID ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3549:1: ( ( RULE_ID ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3549:1: ( ( RULE_ID ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3550:1: ( RULE_ID )
            {
             before(grammarAccess.getParameterAccess().getNameJvmAnnotationReferenceCrossReference_0_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3551:1: ( RULE_ID )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3552:1: RULE_ID
            {
             before(grammarAccess.getParameterAccess().getNameJvmAnnotationReferenceIDTerminalRuleCall_0_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Parameter__NameAssignment_07180); 
             after(grammarAccess.getParameterAccess().getNameJvmAnnotationReferenceIDTerminalRuleCall_0_0_1()); 

            }

             after(grammarAccess.getParameterAccess().getNameJvmAnnotationReferenceCrossReference_0_0()); 

            }


            }

        }
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3563:1: rule__Parameter__ValueAssignment_2 : ( ruleValueOrEnumValue ) ;
    public final void rule__Parameter__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3567:1: ( ( ruleValueOrEnumValue ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3568:1: ( ruleValueOrEnumValue )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3568:1: ( ruleValueOrEnumValue )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3569:1: ruleValueOrEnumValue
            {
             before(grammarAccess.getParameterAccess().getValueValueOrEnumValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_rule__Parameter__ValueAssignment_27215);
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


    // $ANTLR start "rule__IntegerValue__IntegerValueAssignment"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3578:1: rule__IntegerValue__IntegerValueAssignment : ( RULE_INTEGER ) ;
    public final void rule__IntegerValue__IntegerValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3582:1: ( ( RULE_INTEGER ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3583:1: ( RULE_INTEGER )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3583:1: ( RULE_INTEGER )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3584:1: RULE_INTEGER
            {
             before(grammarAccess.getIntegerValueAccess().getIntegerValueINTEGERTerminalRuleCall_0()); 
            match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_rule__IntegerValue__IntegerValueAssignment7246); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3593:1: rule__DecimalValue__DecimalValueAssignment : ( RULE_DECIMAL ) ;
    public final void rule__DecimalValue__DecimalValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3597:1: ( ( RULE_DECIMAL ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3598:1: ( RULE_DECIMAL )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3598:1: ( RULE_DECIMAL )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3599:1: RULE_DECIMAL
            {
             before(grammarAccess.getDecimalValueAccess().getDecimalValueDECIMALTerminalRuleCall_0()); 
            match(input,RULE_DECIMAL,FOLLOW_RULE_DECIMAL_in_rule__DecimalValue__DecimalValueAssignment7277); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3608:1: rule__StringValue__StringValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringValue__StringValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3612:1: ( ( RULE_STRING ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3613:1: ( RULE_STRING )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3613:1: ( RULE_STRING )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3614:1: RULE_STRING
            {
             before(grammarAccess.getStringValueAccess().getStringValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringValue__StringValueAssignment7308); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3623:1: rule__Variable__NameAssignment : ( ( ruleQualifiedName ) ) ;
    public final void rule__Variable__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3627:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3628:1: ( ( ruleQualifiedName ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3628:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3629:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getVariableAccess().getNameVariableEntityCrossReference_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3630:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3631:1: ruleQualifiedName
            {
             before(grammarAccess.getVariableAccess().getNameVariableEntityQualifiedNameParserRuleCall_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Variable__NameAssignment7343);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3642:1: rule__EnumValue__EnumValueAssignment : ( ( RULE_UPPERCASE_ID ) ) ;
    public final void rule__EnumValue__EnumValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3646:1: ( ( ( RULE_UPPERCASE_ID ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3647:1: ( ( RULE_UPPERCASE_ID ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3647:1: ( ( RULE_UPPERCASE_ID ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3648:1: ( RULE_UPPERCASE_ID )
            {
             before(grammarAccess.getEnumValueAccess().getEnumValueJvmEnumerationLiteralCrossReference_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3649:1: ( RULE_UPPERCASE_ID )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3650:1: RULE_UPPERCASE_ID
            {
             before(grammarAccess.getEnumValueAccess().getEnumValueJvmEnumerationLiteralUPPERCASE_IDTerminalRuleCall_0_1()); 
            match(input,RULE_UPPERCASE_ID,FOLLOW_RULE_UPPERCASE_ID_in_rule__EnumValue__EnumValueAssignment7382); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3661:1: rule__MethodReference__TypeAssignment_0 : ( ( ruleQualifiedJavaClassName ) ) ;
    public final void rule__MethodReference__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3665:1: ( ( ( ruleQualifiedJavaClassName ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3666:1: ( ( ruleQualifiedJavaClassName ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3666:1: ( ( ruleQualifiedJavaClassName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3667:1: ( ruleQualifiedJavaClassName )
            {
             before(grammarAccess.getMethodReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3668:1: ( ruleQualifiedJavaClassName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3669:1: ruleQualifiedJavaClassName
            {
             before(grammarAccess.getMethodReferenceAccess().getTypeJvmTypeQualifiedJavaClassNameParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_rule__MethodReference__TypeAssignment_07421);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3680:1: rule__MethodReference__MethodAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__MethodReference__MethodAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3684:1: ( ( ( RULE_ID ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3685:1: ( ( RULE_ID ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3685:1: ( ( RULE_ID ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3686:1: ( RULE_ID )
            {
             before(grammarAccess.getMethodReferenceAccess().getMethodJvmOperationCrossReference_2_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3687:1: ( RULE_ID )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3688:1: RULE_ID
            {
             before(grammarAccess.getMethodReferenceAccess().getMethodJvmOperationIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__MethodReference__MethodAssignment_27460); 
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
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_entryRuleValueOrEnumValue1082 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueOrEnumValue1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueOrEnumValue__Alternatives_in_ruleValueOrEnumValue1115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue1142 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue1149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Alternatives_in_ruleValue1175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerValue_in_entryRuleIntegerValue1202 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerValue1209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntegerValue__IntegerValueAssignment_in_ruleIntegerValue1235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalValue_in_entryRuleDecimalValue1262 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalValue1269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalValue__DecimalValueAssignment_in_ruleDecimalValue1295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringValue_in_entryRuleStringValue1322 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringValue1329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringValue__StringValueAssignment_in_ruleStringValue1355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable1382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__NameAssignment_in_ruleVariable1415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumValue_in_entryRuleEnumValue1442 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumValue1449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumValue__EnumValueAssignment_in_ruleEnumValue1475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodReference_in_entryRuleMethodReference1502 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodReference1509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__0_in_ruleMethodReference1535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1562 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName1569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName1595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_entryRuleQualifiedJavaClassName1622 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedJavaClassName1629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__0_in_ruleQualifiedJavaClassName1655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard1682 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard1689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__0_in_ruleQualifiedNameWithWildcard1715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDefinition_in_rule__Statement__Alternatives1751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__Statement__Alternatives1768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_rule__Statement__Alternatives1785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__PackageStatement__Alternatives1817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestDefinition_in_rule__PackageStatement__Alternatives1834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallDefinition_in_rule__PackageStatement__Alternatives1851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteDefinition_in_rule__PackageStatement__Alternatives1868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_rule__PackageStatement__Alternatives1885 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteStatementWithResult_in_rule__SuiteStatement__Alternatives1917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_rule__SuiteStatement__Alternatives1934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_rule__SuiteStatement__Alternatives1951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_rule__SuiteStatementWithResult__Alternatives1983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTest_in_rule__SuiteStatementWithResult__Alternatives2000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__ValueOrEnumValue__Alternatives2032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumValue_in_rule__ValueOrEnumValue__Alternatives2049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringValue_in_rule__Value__Alternatives2081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerValue_in_rule__Value__Alternatives2098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalValue_in_rule__Value__Alternatives2115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__Value__Alternatives2132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__0__Impl_in_rule__PackageDefinition__Group__02162 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__1_in_rule__PackageDefinition__Group__02165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__PackageDefinition__Group__0__Impl2193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__1__Impl_in_rule__PackageDefinition__Group__12224 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__2_in_rule__PackageDefinition__Group__12227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__NameAssignment_1_in_rule__PackageDefinition__Group__1__Impl2254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__2__Impl_in_rule__PackageDefinition__Group__22284 = new BitSet(new long[]{0x00000000021B8000L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__3_in_rule__PackageDefinition__Group__22287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__PackageDefinition__Group__2__Impl2315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__3__Impl_in_rule__PackageDefinition__Group__32346 = new BitSet(new long[]{0x00000000021B8000L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__4_in_rule__PackageDefinition__Group__32349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__StatementsAssignment_3_in_rule__PackageDefinition__Group__3__Impl2376 = new BitSet(new long[]{0x00000000021B0002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__4__Impl_in_rule__PackageDefinition__Group__42407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__PackageDefinition__Group__4__Impl2435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__02476 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__02479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Import__Group__0__Impl2507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__12538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl2565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__0__Impl_in_rule__TestDefinition__Group__02599 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__1_in_rule__TestDefinition__Group__02602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__TestDefinition__Group__0__Impl2630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__1__Impl_in_rule__TestDefinition__Group__12661 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__2_in_rule__TestDefinition__Group__12664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__NameAssignment_1_in_rule__TestDefinition__Group__1__Impl2691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__2__Impl_in_rule__TestDefinition__Group__22721 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__3_in_rule__TestDefinition__Group__22724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__TestDefinition__Group__2__Impl2752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__3__Impl_in_rule__TestDefinition__Group__32783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__FixtureMethodAssignment_3_in_rule__TestDefinition__Group__3__Impl2810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__0__Impl_in_rule__CallDefinition__Group__02848 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__1_in_rule__CallDefinition__Group__02851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__CallDefinition__Group__0__Impl2879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__1__Impl_in_rule__CallDefinition__Group__12910 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__2_in_rule__CallDefinition__Group__12913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__NameAssignment_1_in_rule__CallDefinition__Group__1__Impl2940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__2__Impl_in_rule__CallDefinition__Group__22970 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__3_in_rule__CallDefinition__Group__22973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__CallDefinition__Group__2__Impl3001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__3__Impl_in_rule__CallDefinition__Group__33032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__FixtureMethodAssignment_3_in_rule__CallDefinition__Group__3__Impl3059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__0__Impl_in_rule__SuiteDefinition__Group__03097 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__1_in_rule__SuiteDefinition__Group__03100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__SuiteDefinition__Group__0__Impl3128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__1__Impl_in_rule__SuiteDefinition__Group__13159 = new BitSet(new long[]{0x0000000000C04000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__2_in_rule__SuiteDefinition__Group__13162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__NameAssignment_1_in_rule__SuiteDefinition__Group__1__Impl3189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__2__Impl_in_rule__SuiteDefinition__Group__23219 = new BitSet(new long[]{0x0000000000C04000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__3_in_rule__SuiteDefinition__Group__23222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_2__0_in_rule__SuiteDefinition__Group__2__Impl3249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__3__Impl_in_rule__SuiteDefinition__Group__33280 = new BitSet(new long[]{0x0000000000C04000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__4_in_rule__SuiteDefinition__Group__33283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_3__0_in_rule__SuiteDefinition__Group__3__Impl3310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__4__Impl_in_rule__SuiteDefinition__Group__43341 = new BitSet(new long[]{0x00000000AA3B2000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__5_in_rule__SuiteDefinition__Group__43344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__SuiteDefinition__Group__4__Impl3372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__5__Impl_in_rule__SuiteDefinition__Group__53403 = new BitSet(new long[]{0x00000000AA3B2000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__6_in_rule__SuiteDefinition__Group__53406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__StatementsAssignment_5_in_rule__SuiteDefinition__Group__5__Impl3433 = new BitSet(new long[]{0x00000000AA1B2002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__6__Impl_in_rule__SuiteDefinition__Group__63464 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__7_in_rule__SuiteDefinition__Group__63467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__SuiteDefinition__Group__6__Impl3495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__7__Impl_in_rule__SuiteDefinition__Group__73526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_7__0_in_rule__SuiteDefinition__Group__7__Impl3553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_2__0__Impl_in_rule__SuiteDefinition__Group_2__03600 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_2__1_in_rule__SuiteDefinition__Group_2__03603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__SuiteDefinition__Group_2__0__Impl3631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_2__1__Impl_in_rule__SuiteDefinition__Group_2__13662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__ParametersAssignment_2_1_in_rule__SuiteDefinition__Group_2__1__Impl3689 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_3__0__Impl_in_rule__SuiteDefinition__Group_3__03724 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_3__1_in_rule__SuiteDefinition__Group_3__03727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__SuiteDefinition__Group_3__0__Impl3755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_3__1__Impl_in_rule__SuiteDefinition__Group_3__13786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__DependenciesAssignment_3_1_in_rule__SuiteDefinition__Group_3__1__Impl3813 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_7__0__Impl_in_rule__SuiteDefinition__Group_7__03848 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_7__1_in_rule__SuiteDefinition__Group_7__03851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__SuiteDefinition__Group_7__0__Impl3879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_7__1__Impl_in_rule__SuiteDefinition__Group_7__13910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__FinalizersAssignment_7_1_in_rule__SuiteDefinition__Group_7__1__Impl3937 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__0__Impl_in_rule__VariableDefinition__Group__03972 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__1_in_rule__VariableDefinition__Group__03975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__VariableDefinition__Group__0__Impl4003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__1__Impl_in_rule__VariableDefinition__Group__14034 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__2_in_rule__VariableDefinition__Group__14037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__NameAssignment_1_in_rule__VariableDefinition__Group__1__Impl4064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__2__Impl_in_rule__VariableDefinition__Group__24094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group_2__0_in_rule__VariableDefinition__Group__2__Impl4121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group_2__0__Impl_in_rule__VariableDefinition__Group_2__04158 = new BitSet(new long[]{0x00000000000001D0L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group_2__1_in_rule__VariableDefinition__Group_2__04161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__VariableDefinition__Group_2__0__Impl4189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group_2__1__Impl_in_rule__VariableDefinition__Group_2__14220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__InitialValueAssignment_2_1_in_rule__VariableDefinition__Group_2__1__Impl4247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group__0__Impl_in_rule__Test__Group__04281 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Test__Group__1_in_rule__Test__Group__04284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__Test__Group__0__Impl4312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group__1__Impl_in_rule__Test__Group__14343 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_rule__Test__Group__2_in_rule__Test__Group__14346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__DefinitionAssignment_1_in_rule__Test__Group__1__Impl4373 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group__2__Impl_in_rule__Test__Group__24403 = new BitSet(new long[]{0x0000000010000010L});
    public static final BitSet FOLLOW_rule__Test__Group__3_in_rule__Test__Group__24406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__ParametersAssignment_2_in_rule__Test__Group__2__Impl4433 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Test__Group__3__Impl_in_rule__Test__Group__34464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group_3__0_in_rule__Test__Group__3__Impl4491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group_3__0__Impl_in_rule__Test__Group_3__04530 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__Test__Group_3__1_in_rule__Test__Group_3__04533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Test__Group_3__0__Impl4561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group_3__1__Impl_in_rule__Test__Group_3__14592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__ResultAssignment_3_1_in_rule__Test__Group_3__1__Impl4619 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__0__Impl_in_rule__Call__Group__04653 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Call__Group__1_in_rule__Call__Group__04656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Call__Group__0__Impl4684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__1__Impl_in_rule__Call__Group__14715 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_rule__Call__Group__2_in_rule__Call__Group__14718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__DefinitionAssignment_1_in_rule__Call__Group__1__Impl4745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__2__Impl_in_rule__Call__Group__24775 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_rule__Call__Group__3_in_rule__Call__Group__24778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__ParametersAssignment_2_in_rule__Call__Group__2__Impl4805 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__Call__Group__3__Impl_in_rule__Call__Group__34836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group_3__0_in_rule__Call__Group__3__Impl4863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group_3__0__Impl_in_rule__Call__Group_3__04902 = new BitSet(new long[]{0x00000000000001D0L});
    public static final BitSet FOLLOW_rule__Call__Group_3__1_in_rule__Call__Group_3__04905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__Call__Group_3__0__Impl4933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group_3__1__Impl_in_rule__Call__Group_3__14964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__ResultAssignment_3_1_in_rule__Call__Group_3__1__Impl4991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group__0__Impl_in_rule__Suite__Group__05025 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Suite__Group__1_in_rule__Suite__Group__05028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Suite__Group__0__Impl5056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group__1__Impl_in_rule__Suite__Group__15087 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Suite__Group__2_in_rule__Suite__Group__15090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__DefinitionAssignment_1_in_rule__Suite__Group__1__Impl5117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group__2__Impl_in_rule__Suite__Group__25147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__ParametersAssignment_2_in_rule__Suite__Group__2__Impl5174 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__0__Impl_in_rule__SuiteParameter__Group__05211 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__1_in_rule__SuiteParameter__Group__05214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__NameAssignment_0_in_rule__SuiteParameter__Group__0__Impl5241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__1__Impl_in_rule__SuiteParameter__Group__15271 = new BitSet(new long[]{0x00000000000001D0L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__2_in_rule__SuiteParameter__Group__15274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__SuiteParameter__Group__1__Impl5302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__2__Impl_in_rule__SuiteParameter__Group__25333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__ValueAssignment_2_in_rule__SuiteParameter__Group__2__Impl5360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__05396 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__05399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__NameAssignment_0_in_rule__Parameter__Group__0__Impl5426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__15456 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__Parameter__Group__2_in_rule__Parameter__Group__15459 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Parameter__Group__1__Impl5487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__2__Impl_in_rule__Parameter__Group__25518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__ValueAssignment_2_in_rule__Parameter__Group__2__Impl5545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__0__Impl_in_rule__MethodReference__Group__05581 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__1_in_rule__MethodReference__Group__05584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__TypeAssignment_0_in_rule__MethodReference__Group__0__Impl5611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__1__Impl_in_rule__MethodReference__Group__15641 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__2_in_rule__MethodReference__Group__15644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__MethodReference__Group__1__Impl5672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__2__Impl_in_rule__MethodReference__Group__25703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__MethodAssignment_2_in_rule__MethodReference__Group__2__Impl5730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__05766 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__05769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl5796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__15825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl5852 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__05887 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__05890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__QualifiedName__Group_1__0__Impl5918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__15949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl5976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__0__Impl_in_rule__QualifiedJavaClassName__Group__06009 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__1_in_rule__QualifiedJavaClassName__Group__06012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedJavaClassName__Group__0__Impl6039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__1__Impl_in_rule__QualifiedJavaClassName__Group__16068 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__2_in_rule__QualifiedJavaClassName__Group__16071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__QualifiedJavaClassName__Group__1__Impl6099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__2__Impl_in_rule__QualifiedJavaClassName__Group__26130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UPPERCASE_ID_in_rule__QualifiedJavaClassName__Group__2__Impl6157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__0__Impl_in_rule__QualifiedNameWithWildcard__Group__06192 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__1_in_rule__QualifiedNameWithWildcard__Group__06195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildcard__Group__0__Impl6222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__1__Impl_in_rule__QualifiedNameWithWildcard__Group__16251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__QualifiedNameWithWildcard__Group__1__Impl6280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_rule__Model__StatementsAssignment6322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__PackageDefinition__NameAssignment_16353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageStatement_in_rule__PackageDefinition__StatementsAssignment_36384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_rule__Import__ImportedNamespaceAssignment_16415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__TestDefinition__NameAssignment_16446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodReference_in_rule__TestDefinition__FixtureMethodAssignment_36477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__CallDefinition__NameAssignment_16508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodReference_in_rule__CallDefinition__FixtureMethodAssignment_36539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__NameAssignment_16570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_rule__SuiteDefinition__ParametersAssignment_2_16601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__DependenciesAssignment_3_16636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteStatement_in_rule__SuiteDefinition__StatementsAssignment_56671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__FinalizersAssignment_7_16706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_rule__VariableDefinition__NameAssignment_16741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__VariableDefinition__InitialValueAssignment_2_16772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__VariableEntity__NameAssignment6803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Test__DefinitionAssignment_16838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_rule__Test__ParametersAssignment_26873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_rule__Test__ResultAssignment_3_16904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Call__DefinitionAssignment_16939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_rule__Call__ParametersAssignment_26974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__Call__ResultAssignment_3_17005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Suite__DefinitionAssignment_17040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteParameter_in_rule__Suite__ParametersAssignment_27075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__SuiteParameter__NameAssignment_07110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__SuiteParameter__ValueAssignment_27145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Parameter__NameAssignment_07180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_rule__Parameter__ValueAssignment_27215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_rule__IntegerValue__IntegerValueAssignment7246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DECIMAL_in_rule__DecimalValue__DecimalValueAssignment7277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringValue__StringValueAssignment7308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Variable__NameAssignment7343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UPPERCASE_ID_in_rule__EnumValue__EnumValueAssignment7382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_rule__MethodReference__TypeAssignment_07421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__MethodReference__MethodAssignment_27460 = new BitSet(new long[]{0x0000000000000002L});

}