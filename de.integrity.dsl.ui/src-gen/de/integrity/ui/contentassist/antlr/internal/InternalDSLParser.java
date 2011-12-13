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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_UPPERCASE_ID", "RULE_INTEGER", "RULE_DECIMAL", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'|'", "'packagedef'", "'with'", "'packageend'", "'import'", "'testdef'", "'uses'", "'calldef'", "'suitedef'", "'suiteend'", "'gets'", "'requires'", "'concludedby'", "'variable'", "'initially'", "'test'", "'='", "'tabletest'", "'call'", "'sets'", "'suite'", "':'", "'+'", "'#'", "'.'", "'.*'"
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
    public static final int T__37=37;
    public static final int T__38=38;
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

                if ( (LA1_0==14||LA1_0==17||LA1_0==33) ) {
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


    // $ANTLR start "entryRuleTableTest"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:424:1: entryRuleTableTest : ruleTableTest EOF ;
    public final void entryRuleTableTest() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:425:1: ( ruleTableTest EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:426:1: ruleTableTest EOF
            {
             before(grammarAccess.getTableTestRule()); 
            pushFollow(FOLLOW_ruleTableTest_in_entryRuleTableTest842);
            ruleTableTest();

            state._fsp--;

             after(grammarAccess.getTableTestRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTableTest849); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:433:1: ruleTableTest : ( ( rule__TableTest__Group__0 ) ) ;
    public final void ruleTableTest() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:437:2: ( ( ( rule__TableTest__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:438:1: ( ( rule__TableTest__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:438:1: ( ( rule__TableTest__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:439:1: ( rule__TableTest__Group__0 )
            {
             before(grammarAccess.getTableTestAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:440:1: ( rule__TableTest__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:440:2: rule__TableTest__Group__0
            {
            pushFollow(FOLLOW_rule__TableTest__Group__0_in_ruleTableTest875);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:452:1: entryRuleTableTestRow : ruleTableTestRow EOF ;
    public final void entryRuleTableTestRow() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:453:1: ( ruleTableTestRow EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:454:1: ruleTableTestRow EOF
            {
             before(grammarAccess.getTableTestRowRule()); 
            pushFollow(FOLLOW_ruleTableTestRow_in_entryRuleTableTestRow902);
            ruleTableTestRow();

            state._fsp--;

             after(grammarAccess.getTableTestRowRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTableTestRow909); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:461:1: ruleTableTestRow : ( ( rule__TableTestRow__Group__0 ) ) ;
    public final void ruleTableTestRow() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:465:2: ( ( ( rule__TableTestRow__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:466:1: ( ( rule__TableTestRow__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:466:1: ( ( rule__TableTestRow__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:467:1: ( rule__TableTestRow__Group__0 )
            {
             before(grammarAccess.getTableTestRowAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:468:1: ( rule__TableTestRow__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:468:2: rule__TableTestRow__Group__0
            {
            pushFollow(FOLLOW_rule__TableTestRow__Group__0_in_ruleTableTestRow935);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:480:1: entryRuleParameterTableHeader : ruleParameterTableHeader EOF ;
    public final void entryRuleParameterTableHeader() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:481:1: ( ruleParameterTableHeader EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:482:1: ruleParameterTableHeader EOF
            {
             before(grammarAccess.getParameterTableHeaderRule()); 
            pushFollow(FOLLOW_ruleParameterTableHeader_in_entryRuleParameterTableHeader962);
            ruleParameterTableHeader();

            state._fsp--;

             after(grammarAccess.getParameterTableHeaderRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterTableHeader969); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:489:1: ruleParameterTableHeader : ( ( rule__ParameterTableHeader__Group__0 ) ) ;
    public final void ruleParameterTableHeader() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:493:2: ( ( ( rule__ParameterTableHeader__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:494:1: ( ( rule__ParameterTableHeader__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:494:1: ( ( rule__ParameterTableHeader__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:495:1: ( rule__ParameterTableHeader__Group__0 )
            {
             before(grammarAccess.getParameterTableHeaderAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:496:1: ( rule__ParameterTableHeader__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:496:2: rule__ParameterTableHeader__Group__0
            {
            pushFollow(FOLLOW_rule__ParameterTableHeader__Group__0_in_ruleParameterTableHeader995);
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


    // $ANTLR start "entryRuleParameterTableValue"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:508:1: entryRuleParameterTableValue : ruleParameterTableValue EOF ;
    public final void entryRuleParameterTableValue() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:509:1: ( ruleParameterTableValue EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:510:1: ruleParameterTableValue EOF
            {
             before(grammarAccess.getParameterTableValueRule()); 
            pushFollow(FOLLOW_ruleParameterTableValue_in_entryRuleParameterTableValue1022);
            ruleParameterTableValue();

            state._fsp--;

             after(grammarAccess.getParameterTableValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterTableValue1029); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:517:1: ruleParameterTableValue : ( ( rule__ParameterTableValue__Group__0 ) ) ;
    public final void ruleParameterTableValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:521:2: ( ( ( rule__ParameterTableValue__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:522:1: ( ( rule__ParameterTableValue__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:522:1: ( ( rule__ParameterTableValue__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:523:1: ( rule__ParameterTableValue__Group__0 )
            {
             before(grammarAccess.getParameterTableValueAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:524:1: ( rule__ParameterTableValue__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:524:2: rule__ParameterTableValue__Group__0
            {
            pushFollow(FOLLOW_rule__ParameterTableValue__Group__0_in_ruleParameterTableValue1055);
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


    // $ANTLR start "entryRuleCall"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:536:1: entryRuleCall : ruleCall EOF ;
    public final void entryRuleCall() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:537:1: ( ruleCall EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:538:1: ruleCall EOF
            {
             before(grammarAccess.getCallRule()); 
            pushFollow(FOLLOW_ruleCall_in_entryRuleCall1082);
            ruleCall();

            state._fsp--;

             after(grammarAccess.getCallRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCall1089); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:545:1: ruleCall : ( ( rule__Call__Group__0 ) ) ;
    public final void ruleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:549:2: ( ( ( rule__Call__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:550:1: ( ( rule__Call__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:550:1: ( ( rule__Call__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:551:1: ( rule__Call__Group__0 )
            {
             before(grammarAccess.getCallAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:552:1: ( rule__Call__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:552:2: rule__Call__Group__0
            {
            pushFollow(FOLLOW_rule__Call__Group__0_in_ruleCall1115);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:564:1: entryRuleSuite : ruleSuite EOF ;
    public final void entryRuleSuite() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:565:1: ( ruleSuite EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:566:1: ruleSuite EOF
            {
             before(grammarAccess.getSuiteRule()); 
            pushFollow(FOLLOW_ruleSuite_in_entryRuleSuite1142);
            ruleSuite();

            state._fsp--;

             after(grammarAccess.getSuiteRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuite1149); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:573:1: ruleSuite : ( ( rule__Suite__Group__0 ) ) ;
    public final void ruleSuite() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:577:2: ( ( ( rule__Suite__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:578:1: ( ( rule__Suite__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:578:1: ( ( rule__Suite__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:579:1: ( rule__Suite__Group__0 )
            {
             before(grammarAccess.getSuiteAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:580:1: ( rule__Suite__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:580:2: rule__Suite__Group__0
            {
            pushFollow(FOLLOW_rule__Suite__Group__0_in_ruleSuite1175);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:592:1: entryRuleSuiteParameter : ruleSuiteParameter EOF ;
    public final void entryRuleSuiteParameter() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:593:1: ( ruleSuiteParameter EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:594:1: ruleSuiteParameter EOF
            {
             before(grammarAccess.getSuiteParameterRule()); 
            pushFollow(FOLLOW_ruleSuiteParameter_in_entryRuleSuiteParameter1202);
            ruleSuiteParameter();

            state._fsp--;

             after(grammarAccess.getSuiteParameterRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteParameter1209); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:601:1: ruleSuiteParameter : ( ( rule__SuiteParameter__Group__0 ) ) ;
    public final void ruleSuiteParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:605:2: ( ( ( rule__SuiteParameter__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:606:1: ( ( rule__SuiteParameter__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:606:1: ( ( rule__SuiteParameter__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:607:1: ( rule__SuiteParameter__Group__0 )
            {
             before(grammarAccess.getSuiteParameterAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:608:1: ( rule__SuiteParameter__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:608:2: rule__SuiteParameter__Group__0
            {
            pushFollow(FOLLOW_rule__SuiteParameter__Group__0_in_ruleSuiteParameter1235);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:620:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:621:1: ( ruleParameter EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:622:1: ruleParameter EOF
            {
             before(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter1262);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getParameterRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter1269); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:629:1: ruleParameter : ( ( rule__Parameter__Group__0 ) ) ;
    public final void ruleParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:633:2: ( ( ( rule__Parameter__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:634:1: ( ( rule__Parameter__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:634:1: ( ( rule__Parameter__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:635:1: ( rule__Parameter__Group__0 )
            {
             before(grammarAccess.getParameterAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:636:1: ( rule__Parameter__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:636:2: rule__Parameter__Group__0
            {
            pushFollow(FOLLOW_rule__Parameter__Group__0_in_ruleParameter1295);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:648:1: entryRuleParameterName : ruleParameterName EOF ;
    public final void entryRuleParameterName() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:649:1: ( ruleParameterName EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:650:1: ruleParameterName EOF
            {
             before(grammarAccess.getParameterNameRule()); 
            pushFollow(FOLLOW_ruleParameterName_in_entryRuleParameterName1322);
            ruleParameterName();

            state._fsp--;

             after(grammarAccess.getParameterNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterName1329); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:657:1: ruleParameterName : ( ( rule__ParameterName__Alternatives ) ) ;
    public final void ruleParameterName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:661:2: ( ( ( rule__ParameterName__Alternatives ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:662:1: ( ( rule__ParameterName__Alternatives ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:662:1: ( ( rule__ParameterName__Alternatives ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:663:1: ( rule__ParameterName__Alternatives )
            {
             before(grammarAccess.getParameterNameAccess().getAlternatives()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:664:1: ( rule__ParameterName__Alternatives )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:664:2: rule__ParameterName__Alternatives
            {
            pushFollow(FOLLOW_rule__ParameterName__Alternatives_in_ruleParameterName1355);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:676:1: entryRuleFixedParameterName : ruleFixedParameterName EOF ;
    public final void entryRuleFixedParameterName() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:677:1: ( ruleFixedParameterName EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:678:1: ruleFixedParameterName EOF
            {
             before(grammarAccess.getFixedParameterNameRule()); 
            pushFollow(FOLLOW_ruleFixedParameterName_in_entryRuleFixedParameterName1382);
            ruleFixedParameterName();

            state._fsp--;

             after(grammarAccess.getFixedParameterNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFixedParameterName1389); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:685:1: ruleFixedParameterName : ( ( rule__FixedParameterName__AnnotationAssignment ) ) ;
    public final void ruleFixedParameterName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:689:2: ( ( ( rule__FixedParameterName__AnnotationAssignment ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:690:1: ( ( rule__FixedParameterName__AnnotationAssignment ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:690:1: ( ( rule__FixedParameterName__AnnotationAssignment ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:691:1: ( rule__FixedParameterName__AnnotationAssignment )
            {
             before(grammarAccess.getFixedParameterNameAccess().getAnnotationAssignment()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:692:1: ( rule__FixedParameterName__AnnotationAssignment )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:692:2: rule__FixedParameterName__AnnotationAssignment
            {
            pushFollow(FOLLOW_rule__FixedParameterName__AnnotationAssignment_in_ruleFixedParameterName1415);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:704:1: entryRuleArbitraryParameterName : ruleArbitraryParameterName EOF ;
    public final void entryRuleArbitraryParameterName() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:705:1: ( ruleArbitraryParameterName EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:706:1: ruleArbitraryParameterName EOF
            {
             before(grammarAccess.getArbitraryParameterNameRule()); 
            pushFollow(FOLLOW_ruleArbitraryParameterName_in_entryRuleArbitraryParameterName1442);
            ruleArbitraryParameterName();

            state._fsp--;

             after(grammarAccess.getArbitraryParameterNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArbitraryParameterName1449); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:713:1: ruleArbitraryParameterName : ( ( rule__ArbitraryParameterName__Group__0 ) ) ;
    public final void ruleArbitraryParameterName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:717:2: ( ( ( rule__ArbitraryParameterName__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:718:1: ( ( rule__ArbitraryParameterName__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:718:1: ( ( rule__ArbitraryParameterName__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:719:1: ( rule__ArbitraryParameterName__Group__0 )
            {
             before(grammarAccess.getArbitraryParameterNameAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:720:1: ( rule__ArbitraryParameterName__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:720:2: rule__ArbitraryParameterName__Group__0
            {
            pushFollow(FOLLOW_rule__ArbitraryParameterName__Group__0_in_ruleArbitraryParameterName1475);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:732:1: entryRuleValueOrEnumValue : ruleValueOrEnumValue EOF ;
    public final void entryRuleValueOrEnumValue() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:733:1: ( ruleValueOrEnumValue EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:734:1: ruleValueOrEnumValue EOF
            {
             before(grammarAccess.getValueOrEnumValueRule()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_entryRuleValueOrEnumValue1502);
            ruleValueOrEnumValue();

            state._fsp--;

             after(grammarAccess.getValueOrEnumValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueOrEnumValue1509); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:741:1: ruleValueOrEnumValue : ( ( rule__ValueOrEnumValue__Alternatives ) ) ;
    public final void ruleValueOrEnumValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:745:2: ( ( ( rule__ValueOrEnumValue__Alternatives ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:746:1: ( ( rule__ValueOrEnumValue__Alternatives ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:746:1: ( ( rule__ValueOrEnumValue__Alternatives ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:747:1: ( rule__ValueOrEnumValue__Alternatives )
            {
             before(grammarAccess.getValueOrEnumValueAccess().getAlternatives()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:748:1: ( rule__ValueOrEnumValue__Alternatives )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:748:2: rule__ValueOrEnumValue__Alternatives
            {
            pushFollow(FOLLOW_rule__ValueOrEnumValue__Alternatives_in_ruleValueOrEnumValue1535);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:760:1: entryRuleValue : ruleValue EOF ;
    public final void entryRuleValue() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:761:1: ( ruleValue EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:762:1: ruleValue EOF
            {
             before(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue1562);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue1569); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:769:1: ruleValue : ( ( rule__Value__Alternatives ) ) ;
    public final void ruleValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:773:2: ( ( ( rule__Value__Alternatives ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:774:1: ( ( rule__Value__Alternatives ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:774:1: ( ( rule__Value__Alternatives ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:775:1: ( rule__Value__Alternatives )
            {
             before(grammarAccess.getValueAccess().getAlternatives()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:776:1: ( rule__Value__Alternatives )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:776:2: rule__Value__Alternatives
            {
            pushFollow(FOLLOW_rule__Value__Alternatives_in_ruleValue1595);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:788:1: entryRuleIntegerValue : ruleIntegerValue EOF ;
    public final void entryRuleIntegerValue() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:789:1: ( ruleIntegerValue EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:790:1: ruleIntegerValue EOF
            {
             before(grammarAccess.getIntegerValueRule()); 
            pushFollow(FOLLOW_ruleIntegerValue_in_entryRuleIntegerValue1622);
            ruleIntegerValue();

            state._fsp--;

             after(grammarAccess.getIntegerValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerValue1629); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:797:1: ruleIntegerValue : ( ( rule__IntegerValue__IntegerValueAssignment ) ) ;
    public final void ruleIntegerValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:801:2: ( ( ( rule__IntegerValue__IntegerValueAssignment ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:802:1: ( ( rule__IntegerValue__IntegerValueAssignment ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:802:1: ( ( rule__IntegerValue__IntegerValueAssignment ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:803:1: ( rule__IntegerValue__IntegerValueAssignment )
            {
             before(grammarAccess.getIntegerValueAccess().getIntegerValueAssignment()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:804:1: ( rule__IntegerValue__IntegerValueAssignment )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:804:2: rule__IntegerValue__IntegerValueAssignment
            {
            pushFollow(FOLLOW_rule__IntegerValue__IntegerValueAssignment_in_ruleIntegerValue1655);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:816:1: entryRuleDecimalValue : ruleDecimalValue EOF ;
    public final void entryRuleDecimalValue() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:817:1: ( ruleDecimalValue EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:818:1: ruleDecimalValue EOF
            {
             before(grammarAccess.getDecimalValueRule()); 
            pushFollow(FOLLOW_ruleDecimalValue_in_entryRuleDecimalValue1682);
            ruleDecimalValue();

            state._fsp--;

             after(grammarAccess.getDecimalValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalValue1689); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:825:1: ruleDecimalValue : ( ( rule__DecimalValue__DecimalValueAssignment ) ) ;
    public final void ruleDecimalValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:829:2: ( ( ( rule__DecimalValue__DecimalValueAssignment ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:830:1: ( ( rule__DecimalValue__DecimalValueAssignment ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:830:1: ( ( rule__DecimalValue__DecimalValueAssignment ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:831:1: ( rule__DecimalValue__DecimalValueAssignment )
            {
             before(grammarAccess.getDecimalValueAccess().getDecimalValueAssignment()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:832:1: ( rule__DecimalValue__DecimalValueAssignment )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:832:2: rule__DecimalValue__DecimalValueAssignment
            {
            pushFollow(FOLLOW_rule__DecimalValue__DecimalValueAssignment_in_ruleDecimalValue1715);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:844:1: entryRuleStringValue : ruleStringValue EOF ;
    public final void entryRuleStringValue() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:845:1: ( ruleStringValue EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:846:1: ruleStringValue EOF
            {
             before(grammarAccess.getStringValueRule()); 
            pushFollow(FOLLOW_ruleStringValue_in_entryRuleStringValue1742);
            ruleStringValue();

            state._fsp--;

             after(grammarAccess.getStringValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringValue1749); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:853:1: ruleStringValue : ( ( rule__StringValue__StringValueAssignment ) ) ;
    public final void ruleStringValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:857:2: ( ( ( rule__StringValue__StringValueAssignment ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:858:1: ( ( rule__StringValue__StringValueAssignment ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:858:1: ( ( rule__StringValue__StringValueAssignment ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:859:1: ( rule__StringValue__StringValueAssignment )
            {
             before(grammarAccess.getStringValueAccess().getStringValueAssignment()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:860:1: ( rule__StringValue__StringValueAssignment )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:860:2: rule__StringValue__StringValueAssignment
            {
            pushFollow(FOLLOW_rule__StringValue__StringValueAssignment_in_ruleStringValue1775);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:872:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:873:1: ( ruleVariable EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:874:1: ruleVariable EOF
            {
             before(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable1802);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getVariableRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable1809); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:881:1: ruleVariable : ( ( rule__Variable__NameAssignment ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:885:2: ( ( ( rule__Variable__NameAssignment ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:886:1: ( ( rule__Variable__NameAssignment ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:886:1: ( ( rule__Variable__NameAssignment ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:887:1: ( rule__Variable__NameAssignment )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:888:1: ( rule__Variable__NameAssignment )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:888:2: rule__Variable__NameAssignment
            {
            pushFollow(FOLLOW_rule__Variable__NameAssignment_in_ruleVariable1835);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:900:1: entryRuleEnumValue : ruleEnumValue EOF ;
    public final void entryRuleEnumValue() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:901:1: ( ruleEnumValue EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:902:1: ruleEnumValue EOF
            {
             before(grammarAccess.getEnumValueRule()); 
            pushFollow(FOLLOW_ruleEnumValue_in_entryRuleEnumValue1862);
            ruleEnumValue();

            state._fsp--;

             after(grammarAccess.getEnumValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumValue1869); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:909:1: ruleEnumValue : ( ( rule__EnumValue__EnumValueAssignment ) ) ;
    public final void ruleEnumValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:913:2: ( ( ( rule__EnumValue__EnumValueAssignment ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:914:1: ( ( rule__EnumValue__EnumValueAssignment ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:914:1: ( ( rule__EnumValue__EnumValueAssignment ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:915:1: ( rule__EnumValue__EnumValueAssignment )
            {
             before(grammarAccess.getEnumValueAccess().getEnumValueAssignment()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:916:1: ( rule__EnumValue__EnumValueAssignment )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:916:2: rule__EnumValue__EnumValueAssignment
            {
            pushFollow(FOLLOW_rule__EnumValue__EnumValueAssignment_in_ruleEnumValue1895);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:928:1: entryRuleMethodReference : ruleMethodReference EOF ;
    public final void entryRuleMethodReference() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:929:1: ( ruleMethodReference EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:930:1: ruleMethodReference EOF
            {
             before(grammarAccess.getMethodReferenceRule()); 
            pushFollow(FOLLOW_ruleMethodReference_in_entryRuleMethodReference1922);
            ruleMethodReference();

            state._fsp--;

             after(grammarAccess.getMethodReferenceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodReference1929); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:937:1: ruleMethodReference : ( ( rule__MethodReference__Group__0 ) ) ;
    public final void ruleMethodReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:941:2: ( ( ( rule__MethodReference__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:942:1: ( ( rule__MethodReference__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:942:1: ( ( rule__MethodReference__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:943:1: ( rule__MethodReference__Group__0 )
            {
             before(grammarAccess.getMethodReferenceAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:944:1: ( rule__MethodReference__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:944:2: rule__MethodReference__Group__0
            {
            pushFollow(FOLLOW_rule__MethodReference__Group__0_in_ruleMethodReference1955);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:956:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:957:1: ( ruleQualifiedName EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:958:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1982);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName1989); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:965:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:969:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:970:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:970:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:971:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:972:1: ( rule__QualifiedName__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:972:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName2015);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:984:1: entryRuleQualifiedJavaClassName : ruleQualifiedJavaClassName EOF ;
    public final void entryRuleQualifiedJavaClassName() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:985:1: ( ruleQualifiedJavaClassName EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:986:1: ruleQualifiedJavaClassName EOF
            {
             before(grammarAccess.getQualifiedJavaClassNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_entryRuleQualifiedJavaClassName2042);
            ruleQualifiedJavaClassName();

            state._fsp--;

             after(grammarAccess.getQualifiedJavaClassNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedJavaClassName2049); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:993:1: ruleQualifiedJavaClassName : ( ( rule__QualifiedJavaClassName__Group__0 ) ) ;
    public final void ruleQualifiedJavaClassName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:997:2: ( ( ( rule__QualifiedJavaClassName__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:998:1: ( ( rule__QualifiedJavaClassName__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:998:1: ( ( rule__QualifiedJavaClassName__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:999:1: ( rule__QualifiedJavaClassName__Group__0 )
            {
             before(grammarAccess.getQualifiedJavaClassNameAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1000:1: ( rule__QualifiedJavaClassName__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1000:2: rule__QualifiedJavaClassName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__0_in_ruleQualifiedJavaClassName2075);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1012:1: entryRuleQualifiedNameWithWildcard : ruleQualifiedNameWithWildcard EOF ;
    public final void entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1013:1: ( ruleQualifiedNameWithWildcard EOF )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1014:1: ruleQualifiedNameWithWildcard EOF
            {
             before(grammarAccess.getQualifiedNameWithWildcardRule()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard2102);
            ruleQualifiedNameWithWildcard();

            state._fsp--;

             after(grammarAccess.getQualifiedNameWithWildcardRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard2109); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1021:1: ruleQualifiedNameWithWildcard : ( ( rule__QualifiedNameWithWildcard__Group__0 ) ) ;
    public final void ruleQualifiedNameWithWildcard() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1025:2: ( ( ( rule__QualifiedNameWithWildcard__Group__0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1026:1: ( ( rule__QualifiedNameWithWildcard__Group__0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1026:1: ( ( rule__QualifiedNameWithWildcard__Group__0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1027:1: ( rule__QualifiedNameWithWildcard__Group__0 )
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1028:1: ( rule__QualifiedNameWithWildcard__Group__0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1028:2: rule__QualifiedNameWithWildcard__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__0_in_ruleQualifiedNameWithWildcard2135);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1040:1: rule__Statement__Alternatives : ( ( rulePackageDefinition ) | ( ruleImport ) | ( ruleSuite ) );
    public final void rule__Statement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1044:1: ( ( rulePackageDefinition ) | ( ruleImport ) | ( ruleSuite ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 14:
                {
                alt2=1;
                }
                break;
            case 17:
                {
                alt2=2;
                }
                break;
            case 33:
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
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1045:1: ( rulePackageDefinition )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1045:1: ( rulePackageDefinition )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1046:1: rulePackageDefinition
                    {
                     before(grammarAccess.getStatementAccess().getPackageDefinitionParserRuleCall_0()); 
                    pushFollow(FOLLOW_rulePackageDefinition_in_rule__Statement__Alternatives2171);
                    rulePackageDefinition();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getPackageDefinitionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1051:6: ( ruleImport )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1051:6: ( ruleImport )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1052:1: ruleImport
                    {
                     before(grammarAccess.getStatementAccess().getImportParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleImport_in_rule__Statement__Alternatives2188);
                    ruleImport();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getImportParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1057:6: ( ruleSuite )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1057:6: ( ruleSuite )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1058:1: ruleSuite
                    {
                     before(grammarAccess.getStatementAccess().getSuiteParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleSuite_in_rule__Statement__Alternatives2205);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1068:1: rule__PackageStatement__Alternatives : ( ( ruleImport ) | ( ruleTestDefinition ) | ( ruleCallDefinition ) | ( ruleSuiteDefinition ) | ( ruleVariableDefinition ) );
    public final void rule__PackageStatement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1072:1: ( ( ruleImport ) | ( ruleTestDefinition ) | ( ruleCallDefinition ) | ( ruleSuiteDefinition ) | ( ruleVariableDefinition ) )
            int alt3=5;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt3=1;
                }
                break;
            case 18:
                {
                alt3=2;
                }
                break;
            case 20:
                {
                alt3=3;
                }
                break;
            case 21:
                {
                alt3=4;
                }
                break;
            case 26:
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
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1073:1: ( ruleImport )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1073:1: ( ruleImport )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1074:1: ruleImport
                    {
                     before(grammarAccess.getPackageStatementAccess().getImportParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleImport_in_rule__PackageStatement__Alternatives2237);
                    ruleImport();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getImportParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1079:6: ( ruleTestDefinition )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1079:6: ( ruleTestDefinition )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1080:1: ruleTestDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getTestDefinitionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleTestDefinition_in_rule__PackageStatement__Alternatives2254);
                    ruleTestDefinition();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getTestDefinitionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1085:6: ( ruleCallDefinition )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1085:6: ( ruleCallDefinition )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1086:1: ruleCallDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getCallDefinitionParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleCallDefinition_in_rule__PackageStatement__Alternatives2271);
                    ruleCallDefinition();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getCallDefinitionParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1091:6: ( ruleSuiteDefinition )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1091:6: ( ruleSuiteDefinition )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1092:1: ruleSuiteDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getSuiteDefinitionParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleSuiteDefinition_in_rule__PackageStatement__Alternatives2288);
                    ruleSuiteDefinition();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getSuiteDefinitionParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1097:6: ( ruleVariableDefinition )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1097:6: ( ruleVariableDefinition )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1098:1: ruleVariableDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getVariableDefinitionParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleVariableDefinition_in_rule__PackageStatement__Alternatives2305);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1108:1: rule__SuiteStatement__Alternatives : ( ( ruleSuiteStatementWithResult ) | ( ruleCall ) | ( ruleVariableDefinition ) );
    public final void rule__SuiteStatement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1112:1: ( ( ruleSuiteStatementWithResult ) | ( ruleCall ) | ( ruleVariableDefinition ) )
            int alt4=3;
            switch ( input.LA(1) ) {
            case 28:
            case 30:
            case 33:
                {
                alt4=1;
                }
                break;
            case 31:
                {
                alt4=2;
                }
                break;
            case 26:
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
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1113:1: ( ruleSuiteStatementWithResult )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1113:1: ( ruleSuiteStatementWithResult )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1114:1: ruleSuiteStatementWithResult
                    {
                     before(grammarAccess.getSuiteStatementAccess().getSuiteStatementWithResultParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSuiteStatementWithResult_in_rule__SuiteStatement__Alternatives2337);
                    ruleSuiteStatementWithResult();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementAccess().getSuiteStatementWithResultParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1119:6: ( ruleCall )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1119:6: ( ruleCall )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1120:1: ruleCall
                    {
                     before(grammarAccess.getSuiteStatementAccess().getCallParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleCall_in_rule__SuiteStatement__Alternatives2354);
                    ruleCall();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementAccess().getCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1125:6: ( ruleVariableDefinition )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1125:6: ( ruleVariableDefinition )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1126:1: ruleVariableDefinition
                    {
                     before(grammarAccess.getSuiteStatementAccess().getVariableDefinitionParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleVariableDefinition_in_rule__SuiteStatement__Alternatives2371);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1136:1: rule__SuiteStatementWithResult__Alternatives : ( ( ruleSuite ) | ( ruleTest ) | ( ruleTableTest ) );
    public final void rule__SuiteStatementWithResult__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1140:1: ( ( ruleSuite ) | ( ruleTest ) | ( ruleTableTest ) )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt5=1;
                }
                break;
            case 28:
                {
                alt5=2;
                }
                break;
            case 30:
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
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1141:1: ( ruleSuite )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1141:1: ( ruleSuite )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1142:1: ruleSuite
                    {
                     before(grammarAccess.getSuiteStatementWithResultAccess().getSuiteParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSuite_in_rule__SuiteStatementWithResult__Alternatives2403);
                    ruleSuite();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementWithResultAccess().getSuiteParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1147:6: ( ruleTest )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1147:6: ( ruleTest )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1148:1: ruleTest
                    {
                     before(grammarAccess.getSuiteStatementWithResultAccess().getTestParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleTest_in_rule__SuiteStatementWithResult__Alternatives2420);
                    ruleTest();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementWithResultAccess().getTestParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1153:6: ( ruleTableTest )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1153:6: ( ruleTableTest )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1154:1: ruleTableTest
                    {
                     before(grammarAccess.getSuiteStatementWithResultAccess().getTableTestParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleTableTest_in_rule__SuiteStatementWithResult__Alternatives2437);
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


    // $ANTLR start "rule__TableTest__Alternatives_4"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1164:1: rule__TableTest__Alternatives_4 : ( ( ( rule__TableTest__Group_4_0__0 ) ) | ( '|' ) );
    public final void rule__TableTest__Alternatives_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1168:1: ( ( ( rule__TableTest__Group_4_0__0 ) ) | ( '|' ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==13) ) {
                int LA6_1 = input.LA(2);

                if ( (LA6_1==29) ) {
                    alt6=1;
                }
                else if ( (LA6_1==13) ) {
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
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1169:1: ( ( rule__TableTest__Group_4_0__0 ) )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1169:1: ( ( rule__TableTest__Group_4_0__0 ) )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1170:1: ( rule__TableTest__Group_4_0__0 )
                    {
                     before(grammarAccess.getTableTestAccess().getGroup_4_0()); 
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1171:1: ( rule__TableTest__Group_4_0__0 )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1171:2: rule__TableTest__Group_4_0__0
                    {
                    pushFollow(FOLLOW_rule__TableTest__Group_4_0__0_in_rule__TableTest__Alternatives_42469);
                    rule__TableTest__Group_4_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTableTestAccess().getGroup_4_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1175:6: ( '|' )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1175:6: ( '|' )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1176:1: '|'
                    {
                     before(grammarAccess.getTableTestAccess().getVerticalLineKeyword_4_1()); 
                    match(input,13,FOLLOW_13_in_rule__TableTest__Alternatives_42488); 
                     after(grammarAccess.getTableTestAccess().getVerticalLineKeyword_4_1()); 

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
    // $ANTLR end "rule__TableTest__Alternatives_4"


    // $ANTLR start "rule__TableTestRow__Alternatives_2"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1188:1: rule__TableTestRow__Alternatives_2 : ( ( ( rule__TableTestRow__Group_2_0__0 ) ) | ( '|' ) );
    public final void rule__TableTestRow__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1192:1: ( ( ( rule__TableTestRow__Group_2_0__0 ) ) | ( '|' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==13) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==29) ) {
                    alt7=1;
                }
                else if ( (LA7_1==EOF||LA7_1==13||LA7_1==22||LA7_1==26||LA7_1==28||(LA7_1>=30 && LA7_1<=31)||LA7_1==33) ) {
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
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1193:1: ( ( rule__TableTestRow__Group_2_0__0 ) )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1193:1: ( ( rule__TableTestRow__Group_2_0__0 ) )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1194:1: ( rule__TableTestRow__Group_2_0__0 )
                    {
                     before(grammarAccess.getTableTestRowAccess().getGroup_2_0()); 
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1195:1: ( rule__TableTestRow__Group_2_0__0 )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1195:2: rule__TableTestRow__Group_2_0__0
                    {
                    pushFollow(FOLLOW_rule__TableTestRow__Group_2_0__0_in_rule__TableTestRow__Alternatives_22522);
                    rule__TableTestRow__Group_2_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTableTestRowAccess().getGroup_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1199:6: ( '|' )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1199:6: ( '|' )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1200:1: '|'
                    {
                     before(grammarAccess.getTableTestRowAccess().getVerticalLineKeyword_2_1()); 
                    match(input,13,FOLLOW_13_in_rule__TableTestRow__Alternatives_22541); 
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


    // $ANTLR start "rule__ParameterName__Alternatives"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1212:1: rule__ParameterName__Alternatives : ( ( ruleFixedParameterName ) | ( ruleArbitraryParameterName ) );
    public final void rule__ParameterName__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1216:1: ( ( ruleFixedParameterName ) | ( ruleArbitraryParameterName ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            else if ( (LA8_0==35) ) {
                alt8=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1217:1: ( ruleFixedParameterName )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1217:1: ( ruleFixedParameterName )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1218:1: ruleFixedParameterName
                    {
                     before(grammarAccess.getParameterNameAccess().getFixedParameterNameParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleFixedParameterName_in_rule__ParameterName__Alternatives2575);
                    ruleFixedParameterName();

                    state._fsp--;

                     after(grammarAccess.getParameterNameAccess().getFixedParameterNameParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1223:6: ( ruleArbitraryParameterName )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1223:6: ( ruleArbitraryParameterName )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1224:1: ruleArbitraryParameterName
                    {
                     before(grammarAccess.getParameterNameAccess().getArbitraryParameterNameParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleArbitraryParameterName_in_rule__ParameterName__Alternatives2592);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1234:1: rule__ValueOrEnumValue__Alternatives : ( ( ruleValue ) | ( ruleEnumValue ) );
    public final void rule__ValueOrEnumValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1238:1: ( ( ruleValue ) | ( ruleEnumValue ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID||(LA9_0>=RULE_INTEGER && LA9_0<=RULE_STRING)) ) {
                alt9=1;
            }
            else if ( (LA9_0==RULE_UPPERCASE_ID) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1239:1: ( ruleValue )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1239:1: ( ruleValue )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1240:1: ruleValue
                    {
                     before(grammarAccess.getValueOrEnumValueAccess().getValueParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleValue_in_rule__ValueOrEnumValue__Alternatives2624);
                    ruleValue();

                    state._fsp--;

                     after(grammarAccess.getValueOrEnumValueAccess().getValueParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1245:6: ( ruleEnumValue )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1245:6: ( ruleEnumValue )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1246:1: ruleEnumValue
                    {
                     before(grammarAccess.getValueOrEnumValueAccess().getEnumValueParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleEnumValue_in_rule__ValueOrEnumValue__Alternatives2641);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1256:1: rule__Value__Alternatives : ( ( ruleStringValue ) | ( ruleIntegerValue ) | ( ruleDecimalValue ) | ( ruleVariable ) );
    public final void rule__Value__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1260:1: ( ( ruleStringValue ) | ( ruleIntegerValue ) | ( ruleDecimalValue ) | ( ruleVariable ) )
            int alt10=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt10=1;
                }
                break;
            case RULE_INTEGER:
                {
                alt10=2;
                }
                break;
            case RULE_DECIMAL:
                {
                alt10=3;
                }
                break;
            case RULE_ID:
                {
                alt10=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1261:1: ( ruleStringValue )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1261:1: ( ruleStringValue )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1262:1: ruleStringValue
                    {
                     before(grammarAccess.getValueAccess().getStringValueParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleStringValue_in_rule__Value__Alternatives2673);
                    ruleStringValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getStringValueParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1267:6: ( ruleIntegerValue )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1267:6: ( ruleIntegerValue )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1268:1: ruleIntegerValue
                    {
                     before(grammarAccess.getValueAccess().getIntegerValueParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleIntegerValue_in_rule__Value__Alternatives2690);
                    ruleIntegerValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getIntegerValueParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1273:6: ( ruleDecimalValue )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1273:6: ( ruleDecimalValue )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1274:1: ruleDecimalValue
                    {
                     before(grammarAccess.getValueAccess().getDecimalValueParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleDecimalValue_in_rule__Value__Alternatives2707);
                    ruleDecimalValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getDecimalValueParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1279:6: ( ruleVariable )
                    {
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1279:6: ( ruleVariable )
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1280:1: ruleVariable
                    {
                     before(grammarAccess.getValueAccess().getVariableParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleVariable_in_rule__Value__Alternatives2724);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1292:1: rule__PackageDefinition__Group__0 : rule__PackageDefinition__Group__0__Impl rule__PackageDefinition__Group__1 ;
    public final void rule__PackageDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1296:1: ( rule__PackageDefinition__Group__0__Impl rule__PackageDefinition__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1297:2: rule__PackageDefinition__Group__0__Impl rule__PackageDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__0__Impl_in_rule__PackageDefinition__Group__02754);
            rule__PackageDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDefinition__Group__1_in_rule__PackageDefinition__Group__02757);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1304:1: rule__PackageDefinition__Group__0__Impl : ( 'packagedef' ) ;
    public final void rule__PackageDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1308:1: ( ( 'packagedef' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1309:1: ( 'packagedef' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1309:1: ( 'packagedef' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1310:1: 'packagedef'
            {
             before(grammarAccess.getPackageDefinitionAccess().getPackagedefKeyword_0()); 
            match(input,14,FOLLOW_14_in_rule__PackageDefinition__Group__0__Impl2785); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1323:1: rule__PackageDefinition__Group__1 : rule__PackageDefinition__Group__1__Impl rule__PackageDefinition__Group__2 ;
    public final void rule__PackageDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1327:1: ( rule__PackageDefinition__Group__1__Impl rule__PackageDefinition__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1328:2: rule__PackageDefinition__Group__1__Impl rule__PackageDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__1__Impl_in_rule__PackageDefinition__Group__12816);
            rule__PackageDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDefinition__Group__2_in_rule__PackageDefinition__Group__12819);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1335:1: rule__PackageDefinition__Group__1__Impl : ( ( rule__PackageDefinition__NameAssignment_1 ) ) ;
    public final void rule__PackageDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1339:1: ( ( ( rule__PackageDefinition__NameAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1340:1: ( ( rule__PackageDefinition__NameAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1340:1: ( ( rule__PackageDefinition__NameAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1341:1: ( rule__PackageDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getPackageDefinitionAccess().getNameAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1342:1: ( rule__PackageDefinition__NameAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1342:2: rule__PackageDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__PackageDefinition__NameAssignment_1_in_rule__PackageDefinition__Group__1__Impl2846);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1352:1: rule__PackageDefinition__Group__2 : rule__PackageDefinition__Group__2__Impl rule__PackageDefinition__Group__3 ;
    public final void rule__PackageDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1356:1: ( rule__PackageDefinition__Group__2__Impl rule__PackageDefinition__Group__3 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1357:2: rule__PackageDefinition__Group__2__Impl rule__PackageDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__2__Impl_in_rule__PackageDefinition__Group__22876);
            rule__PackageDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDefinition__Group__3_in_rule__PackageDefinition__Group__22879);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1364:1: rule__PackageDefinition__Group__2__Impl : ( 'with' ) ;
    public final void rule__PackageDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1368:1: ( ( 'with' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1369:1: ( 'with' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1369:1: ( 'with' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1370:1: 'with'
            {
             before(grammarAccess.getPackageDefinitionAccess().getWithKeyword_2()); 
            match(input,15,FOLLOW_15_in_rule__PackageDefinition__Group__2__Impl2907); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1383:1: rule__PackageDefinition__Group__3 : rule__PackageDefinition__Group__3__Impl rule__PackageDefinition__Group__4 ;
    public final void rule__PackageDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1387:1: ( rule__PackageDefinition__Group__3__Impl rule__PackageDefinition__Group__4 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1388:2: rule__PackageDefinition__Group__3__Impl rule__PackageDefinition__Group__4
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__3__Impl_in_rule__PackageDefinition__Group__32938);
            rule__PackageDefinition__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDefinition__Group__4_in_rule__PackageDefinition__Group__32941);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1395:1: rule__PackageDefinition__Group__3__Impl : ( ( rule__PackageDefinition__StatementsAssignment_3 )* ) ;
    public final void rule__PackageDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1399:1: ( ( ( rule__PackageDefinition__StatementsAssignment_3 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1400:1: ( ( rule__PackageDefinition__StatementsAssignment_3 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1400:1: ( ( rule__PackageDefinition__StatementsAssignment_3 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1401:1: ( rule__PackageDefinition__StatementsAssignment_3 )*
            {
             before(grammarAccess.getPackageDefinitionAccess().getStatementsAssignment_3()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1402:1: ( rule__PackageDefinition__StatementsAssignment_3 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>=17 && LA11_0<=18)||(LA11_0>=20 && LA11_0<=21)||LA11_0==26) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1402:2: rule__PackageDefinition__StatementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__PackageDefinition__StatementsAssignment_3_in_rule__PackageDefinition__Group__3__Impl2968);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1412:1: rule__PackageDefinition__Group__4 : rule__PackageDefinition__Group__4__Impl ;
    public final void rule__PackageDefinition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1416:1: ( rule__PackageDefinition__Group__4__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1417:2: rule__PackageDefinition__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__4__Impl_in_rule__PackageDefinition__Group__42999);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1423:1: rule__PackageDefinition__Group__4__Impl : ( 'packageend' ) ;
    public final void rule__PackageDefinition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1427:1: ( ( 'packageend' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1428:1: ( 'packageend' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1428:1: ( 'packageend' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1429:1: 'packageend'
            {
             before(grammarAccess.getPackageDefinitionAccess().getPackageendKeyword_4()); 
            match(input,16,FOLLOW_16_in_rule__PackageDefinition__Group__4__Impl3027); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1452:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1456:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1457:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__03068);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__03071);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1464:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1468:1: ( ( 'import' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1469:1: ( 'import' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1469:1: ( 'import' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1470:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__Import__Group__0__Impl3099); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1483:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1487:1: ( rule__Import__Group__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1488:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__13130);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1494:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1498:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1499:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1499:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1500:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1501:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1501:2: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl3157);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1515:1: rule__TestDefinition__Group__0 : rule__TestDefinition__Group__0__Impl rule__TestDefinition__Group__1 ;
    public final void rule__TestDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1519:1: ( rule__TestDefinition__Group__0__Impl rule__TestDefinition__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1520:2: rule__TestDefinition__Group__0__Impl rule__TestDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__TestDefinition__Group__0__Impl_in_rule__TestDefinition__Group__03191);
            rule__TestDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TestDefinition__Group__1_in_rule__TestDefinition__Group__03194);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1527:1: rule__TestDefinition__Group__0__Impl : ( 'testdef' ) ;
    public final void rule__TestDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1531:1: ( ( 'testdef' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1532:1: ( 'testdef' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1532:1: ( 'testdef' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1533:1: 'testdef'
            {
             before(grammarAccess.getTestDefinitionAccess().getTestdefKeyword_0()); 
            match(input,18,FOLLOW_18_in_rule__TestDefinition__Group__0__Impl3222); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1546:1: rule__TestDefinition__Group__1 : rule__TestDefinition__Group__1__Impl rule__TestDefinition__Group__2 ;
    public final void rule__TestDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1550:1: ( rule__TestDefinition__Group__1__Impl rule__TestDefinition__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1551:2: rule__TestDefinition__Group__1__Impl rule__TestDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__TestDefinition__Group__1__Impl_in_rule__TestDefinition__Group__13253);
            rule__TestDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TestDefinition__Group__2_in_rule__TestDefinition__Group__13256);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1558:1: rule__TestDefinition__Group__1__Impl : ( ( rule__TestDefinition__NameAssignment_1 ) ) ;
    public final void rule__TestDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1562:1: ( ( ( rule__TestDefinition__NameAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1563:1: ( ( rule__TestDefinition__NameAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1563:1: ( ( rule__TestDefinition__NameAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1564:1: ( rule__TestDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getTestDefinitionAccess().getNameAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1565:1: ( rule__TestDefinition__NameAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1565:2: rule__TestDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__TestDefinition__NameAssignment_1_in_rule__TestDefinition__Group__1__Impl3283);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1575:1: rule__TestDefinition__Group__2 : rule__TestDefinition__Group__2__Impl rule__TestDefinition__Group__3 ;
    public final void rule__TestDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1579:1: ( rule__TestDefinition__Group__2__Impl rule__TestDefinition__Group__3 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1580:2: rule__TestDefinition__Group__2__Impl rule__TestDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__TestDefinition__Group__2__Impl_in_rule__TestDefinition__Group__23313);
            rule__TestDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TestDefinition__Group__3_in_rule__TestDefinition__Group__23316);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1587:1: rule__TestDefinition__Group__2__Impl : ( 'uses' ) ;
    public final void rule__TestDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1591:1: ( ( 'uses' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1592:1: ( 'uses' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1592:1: ( 'uses' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1593:1: 'uses'
            {
             before(grammarAccess.getTestDefinitionAccess().getUsesKeyword_2()); 
            match(input,19,FOLLOW_19_in_rule__TestDefinition__Group__2__Impl3344); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1606:1: rule__TestDefinition__Group__3 : rule__TestDefinition__Group__3__Impl ;
    public final void rule__TestDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1610:1: ( rule__TestDefinition__Group__3__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1611:2: rule__TestDefinition__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__TestDefinition__Group__3__Impl_in_rule__TestDefinition__Group__33375);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1617:1: rule__TestDefinition__Group__3__Impl : ( ( rule__TestDefinition__FixtureMethodAssignment_3 ) ) ;
    public final void rule__TestDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1621:1: ( ( ( rule__TestDefinition__FixtureMethodAssignment_3 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1622:1: ( ( rule__TestDefinition__FixtureMethodAssignment_3 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1622:1: ( ( rule__TestDefinition__FixtureMethodAssignment_3 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1623:1: ( rule__TestDefinition__FixtureMethodAssignment_3 )
            {
             before(grammarAccess.getTestDefinitionAccess().getFixtureMethodAssignment_3()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1624:1: ( rule__TestDefinition__FixtureMethodAssignment_3 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1624:2: rule__TestDefinition__FixtureMethodAssignment_3
            {
            pushFollow(FOLLOW_rule__TestDefinition__FixtureMethodAssignment_3_in_rule__TestDefinition__Group__3__Impl3402);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1642:1: rule__CallDefinition__Group__0 : rule__CallDefinition__Group__0__Impl rule__CallDefinition__Group__1 ;
    public final void rule__CallDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1646:1: ( rule__CallDefinition__Group__0__Impl rule__CallDefinition__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1647:2: rule__CallDefinition__Group__0__Impl rule__CallDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__CallDefinition__Group__0__Impl_in_rule__CallDefinition__Group__03440);
            rule__CallDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CallDefinition__Group__1_in_rule__CallDefinition__Group__03443);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1654:1: rule__CallDefinition__Group__0__Impl : ( 'calldef' ) ;
    public final void rule__CallDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1658:1: ( ( 'calldef' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1659:1: ( 'calldef' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1659:1: ( 'calldef' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1660:1: 'calldef'
            {
             before(grammarAccess.getCallDefinitionAccess().getCalldefKeyword_0()); 
            match(input,20,FOLLOW_20_in_rule__CallDefinition__Group__0__Impl3471); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1673:1: rule__CallDefinition__Group__1 : rule__CallDefinition__Group__1__Impl rule__CallDefinition__Group__2 ;
    public final void rule__CallDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1677:1: ( rule__CallDefinition__Group__1__Impl rule__CallDefinition__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1678:2: rule__CallDefinition__Group__1__Impl rule__CallDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__CallDefinition__Group__1__Impl_in_rule__CallDefinition__Group__13502);
            rule__CallDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CallDefinition__Group__2_in_rule__CallDefinition__Group__13505);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1685:1: rule__CallDefinition__Group__1__Impl : ( ( rule__CallDefinition__NameAssignment_1 ) ) ;
    public final void rule__CallDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1689:1: ( ( ( rule__CallDefinition__NameAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1690:1: ( ( rule__CallDefinition__NameAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1690:1: ( ( rule__CallDefinition__NameAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1691:1: ( rule__CallDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getCallDefinitionAccess().getNameAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1692:1: ( rule__CallDefinition__NameAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1692:2: rule__CallDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__CallDefinition__NameAssignment_1_in_rule__CallDefinition__Group__1__Impl3532);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1702:1: rule__CallDefinition__Group__2 : rule__CallDefinition__Group__2__Impl rule__CallDefinition__Group__3 ;
    public final void rule__CallDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1706:1: ( rule__CallDefinition__Group__2__Impl rule__CallDefinition__Group__3 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1707:2: rule__CallDefinition__Group__2__Impl rule__CallDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__CallDefinition__Group__2__Impl_in_rule__CallDefinition__Group__23562);
            rule__CallDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CallDefinition__Group__3_in_rule__CallDefinition__Group__23565);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1714:1: rule__CallDefinition__Group__2__Impl : ( 'uses' ) ;
    public final void rule__CallDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1718:1: ( ( 'uses' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1719:1: ( 'uses' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1719:1: ( 'uses' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1720:1: 'uses'
            {
             before(grammarAccess.getCallDefinitionAccess().getUsesKeyword_2()); 
            match(input,19,FOLLOW_19_in_rule__CallDefinition__Group__2__Impl3593); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1733:1: rule__CallDefinition__Group__3 : rule__CallDefinition__Group__3__Impl ;
    public final void rule__CallDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1737:1: ( rule__CallDefinition__Group__3__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1738:2: rule__CallDefinition__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__CallDefinition__Group__3__Impl_in_rule__CallDefinition__Group__33624);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1744:1: rule__CallDefinition__Group__3__Impl : ( ( rule__CallDefinition__FixtureMethodAssignment_3 ) ) ;
    public final void rule__CallDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1748:1: ( ( ( rule__CallDefinition__FixtureMethodAssignment_3 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1749:1: ( ( rule__CallDefinition__FixtureMethodAssignment_3 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1749:1: ( ( rule__CallDefinition__FixtureMethodAssignment_3 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1750:1: ( rule__CallDefinition__FixtureMethodAssignment_3 )
            {
             before(grammarAccess.getCallDefinitionAccess().getFixtureMethodAssignment_3()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1751:1: ( rule__CallDefinition__FixtureMethodAssignment_3 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1751:2: rule__CallDefinition__FixtureMethodAssignment_3
            {
            pushFollow(FOLLOW_rule__CallDefinition__FixtureMethodAssignment_3_in_rule__CallDefinition__Group__3__Impl3651);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1769:1: rule__SuiteDefinition__Group__0 : rule__SuiteDefinition__Group__0__Impl rule__SuiteDefinition__Group__1 ;
    public final void rule__SuiteDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1773:1: ( rule__SuiteDefinition__Group__0__Impl rule__SuiteDefinition__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1774:2: rule__SuiteDefinition__Group__0__Impl rule__SuiteDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__0__Impl_in_rule__SuiteDefinition__Group__03689);
            rule__SuiteDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__1_in_rule__SuiteDefinition__Group__03692);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1781:1: rule__SuiteDefinition__Group__0__Impl : ( 'suitedef' ) ;
    public final void rule__SuiteDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1785:1: ( ( 'suitedef' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1786:1: ( 'suitedef' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1786:1: ( 'suitedef' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1787:1: 'suitedef'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getSuitedefKeyword_0()); 
            match(input,21,FOLLOW_21_in_rule__SuiteDefinition__Group__0__Impl3720); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1800:1: rule__SuiteDefinition__Group__1 : rule__SuiteDefinition__Group__1__Impl rule__SuiteDefinition__Group__2 ;
    public final void rule__SuiteDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1804:1: ( rule__SuiteDefinition__Group__1__Impl rule__SuiteDefinition__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1805:2: rule__SuiteDefinition__Group__1__Impl rule__SuiteDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__1__Impl_in_rule__SuiteDefinition__Group__13751);
            rule__SuiteDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__2_in_rule__SuiteDefinition__Group__13754);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1812:1: rule__SuiteDefinition__Group__1__Impl : ( ( rule__SuiteDefinition__NameAssignment_1 ) ) ;
    public final void rule__SuiteDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1816:1: ( ( ( rule__SuiteDefinition__NameAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1817:1: ( ( rule__SuiteDefinition__NameAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1817:1: ( ( rule__SuiteDefinition__NameAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1818:1: ( rule__SuiteDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getSuiteDefinitionAccess().getNameAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1819:1: ( rule__SuiteDefinition__NameAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1819:2: rule__SuiteDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__NameAssignment_1_in_rule__SuiteDefinition__Group__1__Impl3781);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1829:1: rule__SuiteDefinition__Group__2 : rule__SuiteDefinition__Group__2__Impl rule__SuiteDefinition__Group__3 ;
    public final void rule__SuiteDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1833:1: ( rule__SuiteDefinition__Group__2__Impl rule__SuiteDefinition__Group__3 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1834:2: rule__SuiteDefinition__Group__2__Impl rule__SuiteDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__2__Impl_in_rule__SuiteDefinition__Group__23811);
            rule__SuiteDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__3_in_rule__SuiteDefinition__Group__23814);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1841:1: rule__SuiteDefinition__Group__2__Impl : ( ( rule__SuiteDefinition__Group_2__0 )? ) ;
    public final void rule__SuiteDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1845:1: ( ( ( rule__SuiteDefinition__Group_2__0 )? ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1846:1: ( ( rule__SuiteDefinition__Group_2__0 )? )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1846:1: ( ( rule__SuiteDefinition__Group_2__0 )? )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1847:1: ( rule__SuiteDefinition__Group_2__0 )?
            {
             before(grammarAccess.getSuiteDefinitionAccess().getGroup_2()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1848:1: ( rule__SuiteDefinition__Group_2__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1848:2: rule__SuiteDefinition__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__SuiteDefinition__Group_2__0_in_rule__SuiteDefinition__Group__2__Impl3841);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1858:1: rule__SuiteDefinition__Group__3 : rule__SuiteDefinition__Group__3__Impl rule__SuiteDefinition__Group__4 ;
    public final void rule__SuiteDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1862:1: ( rule__SuiteDefinition__Group__3__Impl rule__SuiteDefinition__Group__4 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1863:2: rule__SuiteDefinition__Group__3__Impl rule__SuiteDefinition__Group__4
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__3__Impl_in_rule__SuiteDefinition__Group__33872);
            rule__SuiteDefinition__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__4_in_rule__SuiteDefinition__Group__33875);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1870:1: rule__SuiteDefinition__Group__3__Impl : ( ( rule__SuiteDefinition__Group_3__0 )? ) ;
    public final void rule__SuiteDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1874:1: ( ( ( rule__SuiteDefinition__Group_3__0 )? ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1875:1: ( ( rule__SuiteDefinition__Group_3__0 )? )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1875:1: ( ( rule__SuiteDefinition__Group_3__0 )? )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1876:1: ( rule__SuiteDefinition__Group_3__0 )?
            {
             before(grammarAccess.getSuiteDefinitionAccess().getGroup_3()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1877:1: ( rule__SuiteDefinition__Group_3__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1877:2: rule__SuiteDefinition__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__SuiteDefinition__Group_3__0_in_rule__SuiteDefinition__Group__3__Impl3902);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1887:1: rule__SuiteDefinition__Group__4 : rule__SuiteDefinition__Group__4__Impl rule__SuiteDefinition__Group__5 ;
    public final void rule__SuiteDefinition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1891:1: ( rule__SuiteDefinition__Group__4__Impl rule__SuiteDefinition__Group__5 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1892:2: rule__SuiteDefinition__Group__4__Impl rule__SuiteDefinition__Group__5
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__4__Impl_in_rule__SuiteDefinition__Group__43933);
            rule__SuiteDefinition__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__5_in_rule__SuiteDefinition__Group__43936);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1899:1: rule__SuiteDefinition__Group__4__Impl : ( 'with' ) ;
    public final void rule__SuiteDefinition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1903:1: ( ( 'with' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1904:1: ( 'with' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1904:1: ( 'with' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1905:1: 'with'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getWithKeyword_4()); 
            match(input,15,FOLLOW_15_in_rule__SuiteDefinition__Group__4__Impl3964); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1918:1: rule__SuiteDefinition__Group__5 : rule__SuiteDefinition__Group__5__Impl rule__SuiteDefinition__Group__6 ;
    public final void rule__SuiteDefinition__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1922:1: ( rule__SuiteDefinition__Group__5__Impl rule__SuiteDefinition__Group__6 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1923:2: rule__SuiteDefinition__Group__5__Impl rule__SuiteDefinition__Group__6
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__5__Impl_in_rule__SuiteDefinition__Group__53995);
            rule__SuiteDefinition__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__6_in_rule__SuiteDefinition__Group__53998);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1930:1: rule__SuiteDefinition__Group__5__Impl : ( ( rule__SuiteDefinition__StatementsAssignment_5 )* ) ;
    public final void rule__SuiteDefinition__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1934:1: ( ( ( rule__SuiteDefinition__StatementsAssignment_5 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1935:1: ( ( rule__SuiteDefinition__StatementsAssignment_5 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1935:1: ( ( rule__SuiteDefinition__StatementsAssignment_5 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1936:1: ( rule__SuiteDefinition__StatementsAssignment_5 )*
            {
             before(grammarAccess.getSuiteDefinitionAccess().getStatementsAssignment_5()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1937:1: ( rule__SuiteDefinition__StatementsAssignment_5 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==26||LA14_0==28||(LA14_0>=30 && LA14_0<=31)||LA14_0==33) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1937:2: rule__SuiteDefinition__StatementsAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__SuiteDefinition__StatementsAssignment_5_in_rule__SuiteDefinition__Group__5__Impl4025);
            	    rule__SuiteDefinition__StatementsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1947:1: rule__SuiteDefinition__Group__6 : rule__SuiteDefinition__Group__6__Impl rule__SuiteDefinition__Group__7 ;
    public final void rule__SuiteDefinition__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1951:1: ( rule__SuiteDefinition__Group__6__Impl rule__SuiteDefinition__Group__7 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1952:2: rule__SuiteDefinition__Group__6__Impl rule__SuiteDefinition__Group__7
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__6__Impl_in_rule__SuiteDefinition__Group__64056);
            rule__SuiteDefinition__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__7_in_rule__SuiteDefinition__Group__64059);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1959:1: rule__SuiteDefinition__Group__6__Impl : ( 'suiteend' ) ;
    public final void rule__SuiteDefinition__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1963:1: ( ( 'suiteend' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1964:1: ( 'suiteend' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1964:1: ( 'suiteend' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1965:1: 'suiteend'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getSuiteendKeyword_6()); 
            match(input,22,FOLLOW_22_in_rule__SuiteDefinition__Group__6__Impl4087); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1978:1: rule__SuiteDefinition__Group__7 : rule__SuiteDefinition__Group__7__Impl ;
    public final void rule__SuiteDefinition__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1982:1: ( rule__SuiteDefinition__Group__7__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1983:2: rule__SuiteDefinition__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__7__Impl_in_rule__SuiteDefinition__Group__74118);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1989:1: rule__SuiteDefinition__Group__7__Impl : ( ( rule__SuiteDefinition__Group_7__0 )? ) ;
    public final void rule__SuiteDefinition__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1993:1: ( ( ( rule__SuiteDefinition__Group_7__0 )? ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1994:1: ( ( rule__SuiteDefinition__Group_7__0 )? )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1994:1: ( ( rule__SuiteDefinition__Group_7__0 )? )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1995:1: ( rule__SuiteDefinition__Group_7__0 )?
            {
             before(grammarAccess.getSuiteDefinitionAccess().getGroup_7()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1996:1: ( rule__SuiteDefinition__Group_7__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==25) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1996:2: rule__SuiteDefinition__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__SuiteDefinition__Group_7__0_in_rule__SuiteDefinition__Group__7__Impl4145);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2022:1: rule__SuiteDefinition__Group_2__0 : rule__SuiteDefinition__Group_2__0__Impl rule__SuiteDefinition__Group_2__1 ;
    public final void rule__SuiteDefinition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2026:1: ( rule__SuiteDefinition__Group_2__0__Impl rule__SuiteDefinition__Group_2__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2027:2: rule__SuiteDefinition__Group_2__0__Impl rule__SuiteDefinition__Group_2__1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_2__0__Impl_in_rule__SuiteDefinition__Group_2__04192);
            rule__SuiteDefinition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group_2__1_in_rule__SuiteDefinition__Group_2__04195);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2034:1: rule__SuiteDefinition__Group_2__0__Impl : ( 'gets' ) ;
    public final void rule__SuiteDefinition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2038:1: ( ( 'gets' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2039:1: ( 'gets' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2039:1: ( 'gets' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2040:1: 'gets'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getGetsKeyword_2_0()); 
            match(input,23,FOLLOW_23_in_rule__SuiteDefinition__Group_2__0__Impl4223); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2053:1: rule__SuiteDefinition__Group_2__1 : rule__SuiteDefinition__Group_2__1__Impl ;
    public final void rule__SuiteDefinition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2057:1: ( rule__SuiteDefinition__Group_2__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2058:2: rule__SuiteDefinition__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_2__1__Impl_in_rule__SuiteDefinition__Group_2__14254);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2064:1: rule__SuiteDefinition__Group_2__1__Impl : ( ( rule__SuiteDefinition__ParametersAssignment_2_1 )* ) ;
    public final void rule__SuiteDefinition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2068:1: ( ( ( rule__SuiteDefinition__ParametersAssignment_2_1 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2069:1: ( ( rule__SuiteDefinition__ParametersAssignment_2_1 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2069:1: ( ( rule__SuiteDefinition__ParametersAssignment_2_1 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2070:1: ( rule__SuiteDefinition__ParametersAssignment_2_1 )*
            {
             before(grammarAccess.getSuiteDefinitionAccess().getParametersAssignment_2_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2071:1: ( rule__SuiteDefinition__ParametersAssignment_2_1 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2071:2: rule__SuiteDefinition__ParametersAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_rule__SuiteDefinition__ParametersAssignment_2_1_in_rule__SuiteDefinition__Group_2__1__Impl4281);
            	    rule__SuiteDefinition__ParametersAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2085:1: rule__SuiteDefinition__Group_3__0 : rule__SuiteDefinition__Group_3__0__Impl rule__SuiteDefinition__Group_3__1 ;
    public final void rule__SuiteDefinition__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2089:1: ( rule__SuiteDefinition__Group_3__0__Impl rule__SuiteDefinition__Group_3__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2090:2: rule__SuiteDefinition__Group_3__0__Impl rule__SuiteDefinition__Group_3__1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_3__0__Impl_in_rule__SuiteDefinition__Group_3__04316);
            rule__SuiteDefinition__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group_3__1_in_rule__SuiteDefinition__Group_3__04319);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2097:1: rule__SuiteDefinition__Group_3__0__Impl : ( 'requires' ) ;
    public final void rule__SuiteDefinition__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2101:1: ( ( 'requires' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2102:1: ( 'requires' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2102:1: ( 'requires' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2103:1: 'requires'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getRequiresKeyword_3_0()); 
            match(input,24,FOLLOW_24_in_rule__SuiteDefinition__Group_3__0__Impl4347); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2116:1: rule__SuiteDefinition__Group_3__1 : rule__SuiteDefinition__Group_3__1__Impl ;
    public final void rule__SuiteDefinition__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2120:1: ( rule__SuiteDefinition__Group_3__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2121:2: rule__SuiteDefinition__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_3__1__Impl_in_rule__SuiteDefinition__Group_3__14378);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2127:1: rule__SuiteDefinition__Group_3__1__Impl : ( ( rule__SuiteDefinition__DependenciesAssignment_3_1 )* ) ;
    public final void rule__SuiteDefinition__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2131:1: ( ( ( rule__SuiteDefinition__DependenciesAssignment_3_1 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2132:1: ( ( rule__SuiteDefinition__DependenciesAssignment_3_1 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2132:1: ( ( rule__SuiteDefinition__DependenciesAssignment_3_1 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2133:1: ( rule__SuiteDefinition__DependenciesAssignment_3_1 )*
            {
             before(grammarAccess.getSuiteDefinitionAccess().getDependenciesAssignment_3_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2134:1: ( rule__SuiteDefinition__DependenciesAssignment_3_1 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_ID) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2134:2: rule__SuiteDefinition__DependenciesAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_rule__SuiteDefinition__DependenciesAssignment_3_1_in_rule__SuiteDefinition__Group_3__1__Impl4405);
            	    rule__SuiteDefinition__DependenciesAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2148:1: rule__SuiteDefinition__Group_7__0 : rule__SuiteDefinition__Group_7__0__Impl rule__SuiteDefinition__Group_7__1 ;
    public final void rule__SuiteDefinition__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2152:1: ( rule__SuiteDefinition__Group_7__0__Impl rule__SuiteDefinition__Group_7__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2153:2: rule__SuiteDefinition__Group_7__0__Impl rule__SuiteDefinition__Group_7__1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_7__0__Impl_in_rule__SuiteDefinition__Group_7__04440);
            rule__SuiteDefinition__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group_7__1_in_rule__SuiteDefinition__Group_7__04443);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2160:1: rule__SuiteDefinition__Group_7__0__Impl : ( 'concludedby' ) ;
    public final void rule__SuiteDefinition__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2164:1: ( ( 'concludedby' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2165:1: ( 'concludedby' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2165:1: ( 'concludedby' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2166:1: 'concludedby'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getConcludedbyKeyword_7_0()); 
            match(input,25,FOLLOW_25_in_rule__SuiteDefinition__Group_7__0__Impl4471); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2179:1: rule__SuiteDefinition__Group_7__1 : rule__SuiteDefinition__Group_7__1__Impl ;
    public final void rule__SuiteDefinition__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2183:1: ( rule__SuiteDefinition__Group_7__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2184:2: rule__SuiteDefinition__Group_7__1__Impl
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_7__1__Impl_in_rule__SuiteDefinition__Group_7__14502);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2190:1: rule__SuiteDefinition__Group_7__1__Impl : ( ( rule__SuiteDefinition__FinalizersAssignment_7_1 )* ) ;
    public final void rule__SuiteDefinition__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2194:1: ( ( ( rule__SuiteDefinition__FinalizersAssignment_7_1 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2195:1: ( ( rule__SuiteDefinition__FinalizersAssignment_7_1 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2195:1: ( ( rule__SuiteDefinition__FinalizersAssignment_7_1 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2196:1: ( rule__SuiteDefinition__FinalizersAssignment_7_1 )*
            {
             before(grammarAccess.getSuiteDefinitionAccess().getFinalizersAssignment_7_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2197:1: ( rule__SuiteDefinition__FinalizersAssignment_7_1 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2197:2: rule__SuiteDefinition__FinalizersAssignment_7_1
            	    {
            	    pushFollow(FOLLOW_rule__SuiteDefinition__FinalizersAssignment_7_1_in_rule__SuiteDefinition__Group_7__1__Impl4529);
            	    rule__SuiteDefinition__FinalizersAssignment_7_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2211:1: rule__VariableDefinition__Group__0 : rule__VariableDefinition__Group__0__Impl rule__VariableDefinition__Group__1 ;
    public final void rule__VariableDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2215:1: ( rule__VariableDefinition__Group__0__Impl rule__VariableDefinition__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2216:2: rule__VariableDefinition__Group__0__Impl rule__VariableDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group__0__Impl_in_rule__VariableDefinition__Group__04564);
            rule__VariableDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDefinition__Group__1_in_rule__VariableDefinition__Group__04567);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2223:1: rule__VariableDefinition__Group__0__Impl : ( 'variable' ) ;
    public final void rule__VariableDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2227:1: ( ( 'variable' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2228:1: ( 'variable' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2228:1: ( 'variable' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2229:1: 'variable'
            {
             before(grammarAccess.getVariableDefinitionAccess().getVariableKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__VariableDefinition__Group__0__Impl4595); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2242:1: rule__VariableDefinition__Group__1 : rule__VariableDefinition__Group__1__Impl rule__VariableDefinition__Group__2 ;
    public final void rule__VariableDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2246:1: ( rule__VariableDefinition__Group__1__Impl rule__VariableDefinition__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2247:2: rule__VariableDefinition__Group__1__Impl rule__VariableDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group__1__Impl_in_rule__VariableDefinition__Group__14626);
            rule__VariableDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDefinition__Group__2_in_rule__VariableDefinition__Group__14629);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2254:1: rule__VariableDefinition__Group__1__Impl : ( ( rule__VariableDefinition__NameAssignment_1 ) ) ;
    public final void rule__VariableDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2258:1: ( ( ( rule__VariableDefinition__NameAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2259:1: ( ( rule__VariableDefinition__NameAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2259:1: ( ( rule__VariableDefinition__NameAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2260:1: ( rule__VariableDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getVariableDefinitionAccess().getNameAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2261:1: ( rule__VariableDefinition__NameAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2261:2: rule__VariableDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__VariableDefinition__NameAssignment_1_in_rule__VariableDefinition__Group__1__Impl4656);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2271:1: rule__VariableDefinition__Group__2 : rule__VariableDefinition__Group__2__Impl ;
    public final void rule__VariableDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2275:1: ( rule__VariableDefinition__Group__2__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2276:2: rule__VariableDefinition__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group__2__Impl_in_rule__VariableDefinition__Group__24686);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2282:1: rule__VariableDefinition__Group__2__Impl : ( ( rule__VariableDefinition__Group_2__0 )? ) ;
    public final void rule__VariableDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2286:1: ( ( ( rule__VariableDefinition__Group_2__0 )? ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2287:1: ( ( rule__VariableDefinition__Group_2__0 )? )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2287:1: ( ( rule__VariableDefinition__Group_2__0 )? )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2288:1: ( rule__VariableDefinition__Group_2__0 )?
            {
             before(grammarAccess.getVariableDefinitionAccess().getGroup_2()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2289:1: ( rule__VariableDefinition__Group_2__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==27) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2289:2: rule__VariableDefinition__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__VariableDefinition__Group_2__0_in_rule__VariableDefinition__Group__2__Impl4713);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2305:1: rule__VariableDefinition__Group_2__0 : rule__VariableDefinition__Group_2__0__Impl rule__VariableDefinition__Group_2__1 ;
    public final void rule__VariableDefinition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2309:1: ( rule__VariableDefinition__Group_2__0__Impl rule__VariableDefinition__Group_2__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2310:2: rule__VariableDefinition__Group_2__0__Impl rule__VariableDefinition__Group_2__1
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group_2__0__Impl_in_rule__VariableDefinition__Group_2__04750);
            rule__VariableDefinition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDefinition__Group_2__1_in_rule__VariableDefinition__Group_2__04753);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2317:1: rule__VariableDefinition__Group_2__0__Impl : ( 'initially' ) ;
    public final void rule__VariableDefinition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2321:1: ( ( 'initially' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2322:1: ( 'initially' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2322:1: ( 'initially' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2323:1: 'initially'
            {
             before(grammarAccess.getVariableDefinitionAccess().getInitiallyKeyword_2_0()); 
            match(input,27,FOLLOW_27_in_rule__VariableDefinition__Group_2__0__Impl4781); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2336:1: rule__VariableDefinition__Group_2__1 : rule__VariableDefinition__Group_2__1__Impl ;
    public final void rule__VariableDefinition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2340:1: ( rule__VariableDefinition__Group_2__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2341:2: rule__VariableDefinition__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group_2__1__Impl_in_rule__VariableDefinition__Group_2__14812);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2347:1: rule__VariableDefinition__Group_2__1__Impl : ( ( rule__VariableDefinition__InitialValueAssignment_2_1 ) ) ;
    public final void rule__VariableDefinition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2351:1: ( ( ( rule__VariableDefinition__InitialValueAssignment_2_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2352:1: ( ( rule__VariableDefinition__InitialValueAssignment_2_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2352:1: ( ( rule__VariableDefinition__InitialValueAssignment_2_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2353:1: ( rule__VariableDefinition__InitialValueAssignment_2_1 )
            {
             before(grammarAccess.getVariableDefinitionAccess().getInitialValueAssignment_2_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2354:1: ( rule__VariableDefinition__InitialValueAssignment_2_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2354:2: rule__VariableDefinition__InitialValueAssignment_2_1
            {
            pushFollow(FOLLOW_rule__VariableDefinition__InitialValueAssignment_2_1_in_rule__VariableDefinition__Group_2__1__Impl4839);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2368:1: rule__Test__Group__0 : rule__Test__Group__0__Impl rule__Test__Group__1 ;
    public final void rule__Test__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2372:1: ( rule__Test__Group__0__Impl rule__Test__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2373:2: rule__Test__Group__0__Impl rule__Test__Group__1
            {
            pushFollow(FOLLOW_rule__Test__Group__0__Impl_in_rule__Test__Group__04873);
            rule__Test__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Test__Group__1_in_rule__Test__Group__04876);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2380:1: rule__Test__Group__0__Impl : ( 'test' ) ;
    public final void rule__Test__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2384:1: ( ( 'test' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2385:1: ( 'test' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2385:1: ( 'test' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2386:1: 'test'
            {
             before(grammarAccess.getTestAccess().getTestKeyword_0()); 
            match(input,28,FOLLOW_28_in_rule__Test__Group__0__Impl4904); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2399:1: rule__Test__Group__1 : rule__Test__Group__1__Impl rule__Test__Group__2 ;
    public final void rule__Test__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2403:1: ( rule__Test__Group__1__Impl rule__Test__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2404:2: rule__Test__Group__1__Impl rule__Test__Group__2
            {
            pushFollow(FOLLOW_rule__Test__Group__1__Impl_in_rule__Test__Group__14935);
            rule__Test__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Test__Group__2_in_rule__Test__Group__14938);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2411:1: rule__Test__Group__1__Impl : ( ( rule__Test__DefinitionAssignment_1 ) ) ;
    public final void rule__Test__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2415:1: ( ( ( rule__Test__DefinitionAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2416:1: ( ( rule__Test__DefinitionAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2416:1: ( ( rule__Test__DefinitionAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2417:1: ( rule__Test__DefinitionAssignment_1 )
            {
             before(grammarAccess.getTestAccess().getDefinitionAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2418:1: ( rule__Test__DefinitionAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2418:2: rule__Test__DefinitionAssignment_1
            {
            pushFollow(FOLLOW_rule__Test__DefinitionAssignment_1_in_rule__Test__Group__1__Impl4965);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2428:1: rule__Test__Group__2 : rule__Test__Group__2__Impl rule__Test__Group__3 ;
    public final void rule__Test__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2432:1: ( rule__Test__Group__2__Impl rule__Test__Group__3 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2433:2: rule__Test__Group__2__Impl rule__Test__Group__3
            {
            pushFollow(FOLLOW_rule__Test__Group__2__Impl_in_rule__Test__Group__24995);
            rule__Test__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Test__Group__3_in_rule__Test__Group__24998);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2440:1: rule__Test__Group__2__Impl : ( ( rule__Test__ParametersAssignment_2 )* ) ;
    public final void rule__Test__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2444:1: ( ( ( rule__Test__ParametersAssignment_2 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2445:1: ( ( rule__Test__ParametersAssignment_2 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2445:1: ( ( rule__Test__ParametersAssignment_2 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2446:1: ( rule__Test__ParametersAssignment_2 )*
            {
             before(grammarAccess.getTestAccess().getParametersAssignment_2()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2447:1: ( rule__Test__ParametersAssignment_2 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==RULE_ID||LA20_0==35) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2447:2: rule__Test__ParametersAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Test__ParametersAssignment_2_in_rule__Test__Group__2__Impl5025);
            	    rule__Test__ParametersAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2457:1: rule__Test__Group__3 : rule__Test__Group__3__Impl ;
    public final void rule__Test__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2461:1: ( rule__Test__Group__3__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2462:2: rule__Test__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Test__Group__3__Impl_in_rule__Test__Group__35056);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2468:1: rule__Test__Group__3__Impl : ( ( rule__Test__Group_3__0 )? ) ;
    public final void rule__Test__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2472:1: ( ( ( rule__Test__Group_3__0 )? ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2473:1: ( ( rule__Test__Group_3__0 )? )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2473:1: ( ( rule__Test__Group_3__0 )? )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2474:1: ( rule__Test__Group_3__0 )?
            {
             before(grammarAccess.getTestAccess().getGroup_3()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2475:1: ( rule__Test__Group_3__0 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==29) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2475:2: rule__Test__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Test__Group_3__0_in_rule__Test__Group__3__Impl5083);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2493:1: rule__Test__Group_3__0 : rule__Test__Group_3__0__Impl rule__Test__Group_3__1 ;
    public final void rule__Test__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2497:1: ( rule__Test__Group_3__0__Impl rule__Test__Group_3__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2498:2: rule__Test__Group_3__0__Impl rule__Test__Group_3__1
            {
            pushFollow(FOLLOW_rule__Test__Group_3__0__Impl_in_rule__Test__Group_3__05122);
            rule__Test__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Test__Group_3__1_in_rule__Test__Group_3__05125);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2505:1: rule__Test__Group_3__0__Impl : ( '=' ) ;
    public final void rule__Test__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2509:1: ( ( '=' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2510:1: ( '=' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2510:1: ( '=' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2511:1: '='
            {
             before(grammarAccess.getTestAccess().getEqualsSignKeyword_3_0()); 
            match(input,29,FOLLOW_29_in_rule__Test__Group_3__0__Impl5153); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2524:1: rule__Test__Group_3__1 : rule__Test__Group_3__1__Impl ;
    public final void rule__Test__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2528:1: ( rule__Test__Group_3__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2529:2: rule__Test__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Test__Group_3__1__Impl_in_rule__Test__Group_3__15184);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2535:1: rule__Test__Group_3__1__Impl : ( ( rule__Test__ResultAssignment_3_1 ) ) ;
    public final void rule__Test__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2539:1: ( ( ( rule__Test__ResultAssignment_3_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2540:1: ( ( rule__Test__ResultAssignment_3_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2540:1: ( ( rule__Test__ResultAssignment_3_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2541:1: ( rule__Test__ResultAssignment_3_1 )
            {
             before(grammarAccess.getTestAccess().getResultAssignment_3_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2542:1: ( rule__Test__ResultAssignment_3_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2542:2: rule__Test__ResultAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Test__ResultAssignment_3_1_in_rule__Test__Group_3__1__Impl5211);
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


    // $ANTLR start "rule__TableTest__Group__0"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2556:1: rule__TableTest__Group__0 : rule__TableTest__Group__0__Impl rule__TableTest__Group__1 ;
    public final void rule__TableTest__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2560:1: ( rule__TableTest__Group__0__Impl rule__TableTest__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2561:2: rule__TableTest__Group__0__Impl rule__TableTest__Group__1
            {
            pushFollow(FOLLOW_rule__TableTest__Group__0__Impl_in_rule__TableTest__Group__05245);
            rule__TableTest__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group__1_in_rule__TableTest__Group__05248);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2568:1: rule__TableTest__Group__0__Impl : ( 'tabletest' ) ;
    public final void rule__TableTest__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2572:1: ( ( 'tabletest' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2573:1: ( 'tabletest' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2573:1: ( 'tabletest' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2574:1: 'tabletest'
            {
             before(grammarAccess.getTableTestAccess().getTabletestKeyword_0()); 
            match(input,30,FOLLOW_30_in_rule__TableTest__Group__0__Impl5276); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2587:1: rule__TableTest__Group__1 : rule__TableTest__Group__1__Impl rule__TableTest__Group__2 ;
    public final void rule__TableTest__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2591:1: ( rule__TableTest__Group__1__Impl rule__TableTest__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2592:2: rule__TableTest__Group__1__Impl rule__TableTest__Group__2
            {
            pushFollow(FOLLOW_rule__TableTest__Group__1__Impl_in_rule__TableTest__Group__15307);
            rule__TableTest__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group__2_in_rule__TableTest__Group__15310);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2599:1: rule__TableTest__Group__1__Impl : ( ( rule__TableTest__DefinitionAssignment_1 ) ) ;
    public final void rule__TableTest__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2603:1: ( ( ( rule__TableTest__DefinitionAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2604:1: ( ( rule__TableTest__DefinitionAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2604:1: ( ( rule__TableTest__DefinitionAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2605:1: ( rule__TableTest__DefinitionAssignment_1 )
            {
             before(grammarAccess.getTableTestAccess().getDefinitionAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2606:1: ( rule__TableTest__DefinitionAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2606:2: rule__TableTest__DefinitionAssignment_1
            {
            pushFollow(FOLLOW_rule__TableTest__DefinitionAssignment_1_in_rule__TableTest__Group__1__Impl5337);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2616:1: rule__TableTest__Group__2 : rule__TableTest__Group__2__Impl rule__TableTest__Group__3 ;
    public final void rule__TableTest__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2620:1: ( rule__TableTest__Group__2__Impl rule__TableTest__Group__3 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2621:2: rule__TableTest__Group__2__Impl rule__TableTest__Group__3
            {
            pushFollow(FOLLOW_rule__TableTest__Group__2__Impl_in_rule__TableTest__Group__25367);
            rule__TableTest__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group__3_in_rule__TableTest__Group__25370);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2628:1: rule__TableTest__Group__2__Impl : ( ( rule__TableTest__ParametersAssignment_2 )* ) ;
    public final void rule__TableTest__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2632:1: ( ( ( rule__TableTest__ParametersAssignment_2 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2633:1: ( ( rule__TableTest__ParametersAssignment_2 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2633:1: ( ( rule__TableTest__ParametersAssignment_2 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2634:1: ( rule__TableTest__ParametersAssignment_2 )*
            {
             before(grammarAccess.getTableTestAccess().getParametersAssignment_2()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2635:1: ( rule__TableTest__ParametersAssignment_2 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_ID||LA22_0==35) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2635:2: rule__TableTest__ParametersAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__TableTest__ParametersAssignment_2_in_rule__TableTest__Group__2__Impl5397);
            	    rule__TableTest__ParametersAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2645:1: rule__TableTest__Group__3 : rule__TableTest__Group__3__Impl rule__TableTest__Group__4 ;
    public final void rule__TableTest__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2649:1: ( rule__TableTest__Group__3__Impl rule__TableTest__Group__4 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2650:2: rule__TableTest__Group__3__Impl rule__TableTest__Group__4
            {
            pushFollow(FOLLOW_rule__TableTest__Group__3__Impl_in_rule__TableTest__Group__35428);
            rule__TableTest__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group__4_in_rule__TableTest__Group__35431);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2657:1: rule__TableTest__Group__3__Impl : ( ( ( rule__TableTest__HeadersAssignment_3 ) ) ( ( rule__TableTest__HeadersAssignment_3 )* ) ) ;
    public final void rule__TableTest__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2661:1: ( ( ( ( rule__TableTest__HeadersAssignment_3 ) ) ( ( rule__TableTest__HeadersAssignment_3 )* ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2662:1: ( ( ( rule__TableTest__HeadersAssignment_3 ) ) ( ( rule__TableTest__HeadersAssignment_3 )* ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2662:1: ( ( ( rule__TableTest__HeadersAssignment_3 ) ) ( ( rule__TableTest__HeadersAssignment_3 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2663:1: ( ( rule__TableTest__HeadersAssignment_3 ) ) ( ( rule__TableTest__HeadersAssignment_3 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2663:1: ( ( rule__TableTest__HeadersAssignment_3 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2664:1: ( rule__TableTest__HeadersAssignment_3 )
            {
             before(grammarAccess.getTableTestAccess().getHeadersAssignment_3()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2665:1: ( rule__TableTest__HeadersAssignment_3 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2665:2: rule__TableTest__HeadersAssignment_3
            {
            pushFollow(FOLLOW_rule__TableTest__HeadersAssignment_3_in_rule__TableTest__Group__3__Impl5460);
            rule__TableTest__HeadersAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTableTestAccess().getHeadersAssignment_3()); 

            }

            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2668:1: ( ( rule__TableTest__HeadersAssignment_3 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2669:1: ( rule__TableTest__HeadersAssignment_3 )*
            {
             before(grammarAccess.getTableTestAccess().getHeadersAssignment_3()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2670:1: ( rule__TableTest__HeadersAssignment_3 )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==13) ) {
                    int LA23_1 = input.LA(2);

                    if ( (LA23_1==RULE_ID||LA23_1==35) ) {
                        alt23=1;
                    }


                }


                switch (alt23) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2670:2: rule__TableTest__HeadersAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__TableTest__HeadersAssignment_3_in_rule__TableTest__Group__3__Impl5472);
            	    rule__TableTest__HeadersAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

             after(grammarAccess.getTableTestAccess().getHeadersAssignment_3()); 

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
    // $ANTLR end "rule__TableTest__Group__3__Impl"


    // $ANTLR start "rule__TableTest__Group__4"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2681:1: rule__TableTest__Group__4 : rule__TableTest__Group__4__Impl rule__TableTest__Group__5 ;
    public final void rule__TableTest__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2685:1: ( rule__TableTest__Group__4__Impl rule__TableTest__Group__5 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2686:2: rule__TableTest__Group__4__Impl rule__TableTest__Group__5
            {
            pushFollow(FOLLOW_rule__TableTest__Group__4__Impl_in_rule__TableTest__Group__45505);
            rule__TableTest__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group__5_in_rule__TableTest__Group__45508);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2693:1: rule__TableTest__Group__4__Impl : ( ( rule__TableTest__Alternatives_4 ) ) ;
    public final void rule__TableTest__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2697:1: ( ( ( rule__TableTest__Alternatives_4 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2698:1: ( ( rule__TableTest__Alternatives_4 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2698:1: ( ( rule__TableTest__Alternatives_4 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2699:1: ( rule__TableTest__Alternatives_4 )
            {
             before(grammarAccess.getTableTestAccess().getAlternatives_4()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2700:1: ( rule__TableTest__Alternatives_4 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2700:2: rule__TableTest__Alternatives_4
            {
            pushFollow(FOLLOW_rule__TableTest__Alternatives_4_in_rule__TableTest__Group__4__Impl5535);
            rule__TableTest__Alternatives_4();

            state._fsp--;


            }

             after(grammarAccess.getTableTestAccess().getAlternatives_4()); 

            }


            }

        }
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2710:1: rule__TableTest__Group__5 : rule__TableTest__Group__5__Impl ;
    public final void rule__TableTest__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2714:1: ( rule__TableTest__Group__5__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2715:2: rule__TableTest__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__TableTest__Group__5__Impl_in_rule__TableTest__Group__55565);
            rule__TableTest__Group__5__Impl();

            state._fsp--;


            }

        }
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2721:1: rule__TableTest__Group__5__Impl : ( ( ( rule__TableTest__RowsAssignment_5 ) ) ( ( rule__TableTest__RowsAssignment_5 )* ) ) ;
    public final void rule__TableTest__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2725:1: ( ( ( ( rule__TableTest__RowsAssignment_5 ) ) ( ( rule__TableTest__RowsAssignment_5 )* ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2726:1: ( ( ( rule__TableTest__RowsAssignment_5 ) ) ( ( rule__TableTest__RowsAssignment_5 )* ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2726:1: ( ( ( rule__TableTest__RowsAssignment_5 ) ) ( ( rule__TableTest__RowsAssignment_5 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2727:1: ( ( rule__TableTest__RowsAssignment_5 ) ) ( ( rule__TableTest__RowsAssignment_5 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2727:1: ( ( rule__TableTest__RowsAssignment_5 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2728:1: ( rule__TableTest__RowsAssignment_5 )
            {
             before(grammarAccess.getTableTestAccess().getRowsAssignment_5()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2729:1: ( rule__TableTest__RowsAssignment_5 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2729:2: rule__TableTest__RowsAssignment_5
            {
            pushFollow(FOLLOW_rule__TableTest__RowsAssignment_5_in_rule__TableTest__Group__5__Impl5594);
            rule__TableTest__RowsAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getTableTestAccess().getRowsAssignment_5()); 

            }

            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2732:1: ( ( rule__TableTest__RowsAssignment_5 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2733:1: ( rule__TableTest__RowsAssignment_5 )*
            {
             before(grammarAccess.getTableTestAccess().getRowsAssignment_5()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2734:1: ( rule__TableTest__RowsAssignment_5 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==13) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2734:2: rule__TableTest__RowsAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__TableTest__RowsAssignment_5_in_rule__TableTest__Group__5__Impl5606);
            	    rule__TableTest__RowsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

             after(grammarAccess.getTableTestAccess().getRowsAssignment_5()); 

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
    // $ANTLR end "rule__TableTest__Group__5__Impl"


    // $ANTLR start "rule__TableTest__Group_4_0__0"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2757:1: rule__TableTest__Group_4_0__0 : rule__TableTest__Group_4_0__0__Impl rule__TableTest__Group_4_0__1 ;
    public final void rule__TableTest__Group_4_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2761:1: ( rule__TableTest__Group_4_0__0__Impl rule__TableTest__Group_4_0__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2762:2: rule__TableTest__Group_4_0__0__Impl rule__TableTest__Group_4_0__1
            {
            pushFollow(FOLLOW_rule__TableTest__Group_4_0__0__Impl_in_rule__TableTest__Group_4_0__05651);
            rule__TableTest__Group_4_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group_4_0__1_in_rule__TableTest__Group_4_0__05654);
            rule__TableTest__Group_4_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__Group_4_0__0"


    // $ANTLR start "rule__TableTest__Group_4_0__0__Impl"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2769:1: rule__TableTest__Group_4_0__0__Impl : ( '|' ) ;
    public final void rule__TableTest__Group_4_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2773:1: ( ( '|' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2774:1: ( '|' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2774:1: ( '|' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2775:1: '|'
            {
             before(grammarAccess.getTableTestAccess().getVerticalLineKeyword_4_0_0()); 
            match(input,13,FOLLOW_13_in_rule__TableTest__Group_4_0__0__Impl5682); 
             after(grammarAccess.getTableTestAccess().getVerticalLineKeyword_4_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__Group_4_0__0__Impl"


    // $ANTLR start "rule__TableTest__Group_4_0__1"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2788:1: rule__TableTest__Group_4_0__1 : rule__TableTest__Group_4_0__1__Impl rule__TableTest__Group_4_0__2 ;
    public final void rule__TableTest__Group_4_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2792:1: ( rule__TableTest__Group_4_0__1__Impl rule__TableTest__Group_4_0__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2793:2: rule__TableTest__Group_4_0__1__Impl rule__TableTest__Group_4_0__2
            {
            pushFollow(FOLLOW_rule__TableTest__Group_4_0__1__Impl_in_rule__TableTest__Group_4_0__15713);
            rule__TableTest__Group_4_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group_4_0__2_in_rule__TableTest__Group_4_0__15716);
            rule__TableTest__Group_4_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__Group_4_0__1"


    // $ANTLR start "rule__TableTest__Group_4_0__1__Impl"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2800:1: rule__TableTest__Group_4_0__1__Impl : ( '=' ) ;
    public final void rule__TableTest__Group_4_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2804:1: ( ( '=' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2805:1: ( '=' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2805:1: ( '=' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2806:1: '='
            {
             before(grammarAccess.getTableTestAccess().getEqualsSignKeyword_4_0_1()); 
            match(input,29,FOLLOW_29_in_rule__TableTest__Group_4_0__1__Impl5744); 
             after(grammarAccess.getTableTestAccess().getEqualsSignKeyword_4_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__Group_4_0__1__Impl"


    // $ANTLR start "rule__TableTest__Group_4_0__2"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2819:1: rule__TableTest__Group_4_0__2 : rule__TableTest__Group_4_0__2__Impl ;
    public final void rule__TableTest__Group_4_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2823:1: ( rule__TableTest__Group_4_0__2__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2824:2: rule__TableTest__Group_4_0__2__Impl
            {
            pushFollow(FOLLOW_rule__TableTest__Group_4_0__2__Impl_in_rule__TableTest__Group_4_0__25775);
            rule__TableTest__Group_4_0__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__Group_4_0__2"


    // $ANTLR start "rule__TableTest__Group_4_0__2__Impl"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2830:1: rule__TableTest__Group_4_0__2__Impl : ( '|' ) ;
    public final void rule__TableTest__Group_4_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2834:1: ( ( '|' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2835:1: ( '|' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2835:1: ( '|' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2836:1: '|'
            {
             before(grammarAccess.getTableTestAccess().getVerticalLineKeyword_4_0_2()); 
            match(input,13,FOLLOW_13_in_rule__TableTest__Group_4_0__2__Impl5803); 
             after(grammarAccess.getTableTestAccess().getVerticalLineKeyword_4_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__Group_4_0__2__Impl"


    // $ANTLR start "rule__TableTestRow__Group__0"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2855:1: rule__TableTestRow__Group__0 : rule__TableTestRow__Group__0__Impl rule__TableTestRow__Group__1 ;
    public final void rule__TableTestRow__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2859:1: ( rule__TableTestRow__Group__0__Impl rule__TableTestRow__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2860:2: rule__TableTestRow__Group__0__Impl rule__TableTestRow__Group__1
            {
            pushFollow(FOLLOW_rule__TableTestRow__Group__0__Impl_in_rule__TableTestRow__Group__05840);
            rule__TableTestRow__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTestRow__Group__1_in_rule__TableTestRow__Group__05843);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2867:1: rule__TableTestRow__Group__0__Impl : ( () ) ;
    public final void rule__TableTestRow__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2871:1: ( ( () ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2872:1: ( () )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2872:1: ( () )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2873:1: ()
            {
             before(grammarAccess.getTableTestRowAccess().getTableTestRowAction_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2874:1: ()
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2876:1: 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2886:1: rule__TableTestRow__Group__1 : rule__TableTestRow__Group__1__Impl rule__TableTestRow__Group__2 ;
    public final void rule__TableTestRow__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2890:1: ( rule__TableTestRow__Group__1__Impl rule__TableTestRow__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2891:2: rule__TableTestRow__Group__1__Impl rule__TableTestRow__Group__2
            {
            pushFollow(FOLLOW_rule__TableTestRow__Group__1__Impl_in_rule__TableTestRow__Group__15901);
            rule__TableTestRow__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTestRow__Group__2_in_rule__TableTestRow__Group__15904);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2898:1: rule__TableTestRow__Group__1__Impl : ( ( rule__TableTestRow__ValuesAssignment_1 )* ) ;
    public final void rule__TableTestRow__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2902:1: ( ( ( rule__TableTestRow__ValuesAssignment_1 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2903:1: ( ( rule__TableTestRow__ValuesAssignment_1 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2903:1: ( ( rule__TableTestRow__ValuesAssignment_1 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2904:1: ( rule__TableTestRow__ValuesAssignment_1 )*
            {
             before(grammarAccess.getTableTestRowAccess().getValuesAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2905:1: ( rule__TableTestRow__ValuesAssignment_1 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==13) ) {
                    int LA25_1 = input.LA(2);

                    if ( ((LA25_1>=RULE_ID && LA25_1<=RULE_STRING)) ) {
                        alt25=1;
                    }


                }


                switch (alt25) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2905:2: rule__TableTestRow__ValuesAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__TableTestRow__ValuesAssignment_1_in_rule__TableTestRow__Group__1__Impl5931);
            	    rule__TableTestRow__ValuesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2915:1: rule__TableTestRow__Group__2 : rule__TableTestRow__Group__2__Impl ;
    public final void rule__TableTestRow__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2919:1: ( rule__TableTestRow__Group__2__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2920:2: rule__TableTestRow__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__TableTestRow__Group__2__Impl_in_rule__TableTestRow__Group__25962);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2926:1: rule__TableTestRow__Group__2__Impl : ( ( rule__TableTestRow__Alternatives_2 ) ) ;
    public final void rule__TableTestRow__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2930:1: ( ( ( rule__TableTestRow__Alternatives_2 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2931:1: ( ( rule__TableTestRow__Alternatives_2 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2931:1: ( ( rule__TableTestRow__Alternatives_2 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2932:1: ( rule__TableTestRow__Alternatives_2 )
            {
             before(grammarAccess.getTableTestRowAccess().getAlternatives_2()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2933:1: ( rule__TableTestRow__Alternatives_2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2933:2: rule__TableTestRow__Alternatives_2
            {
            pushFollow(FOLLOW_rule__TableTestRow__Alternatives_2_in_rule__TableTestRow__Group__2__Impl5989);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2949:1: rule__TableTestRow__Group_2_0__0 : rule__TableTestRow__Group_2_0__0__Impl rule__TableTestRow__Group_2_0__1 ;
    public final void rule__TableTestRow__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2953:1: ( rule__TableTestRow__Group_2_0__0__Impl rule__TableTestRow__Group_2_0__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2954:2: rule__TableTestRow__Group_2_0__0__Impl rule__TableTestRow__Group_2_0__1
            {
            pushFollow(FOLLOW_rule__TableTestRow__Group_2_0__0__Impl_in_rule__TableTestRow__Group_2_0__06025);
            rule__TableTestRow__Group_2_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTestRow__Group_2_0__1_in_rule__TableTestRow__Group_2_0__06028);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2961:1: rule__TableTestRow__Group_2_0__0__Impl : ( '|' ) ;
    public final void rule__TableTestRow__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2965:1: ( ( '|' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2966:1: ( '|' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2966:1: ( '|' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2967:1: '|'
            {
             before(grammarAccess.getTableTestRowAccess().getVerticalLineKeyword_2_0_0()); 
            match(input,13,FOLLOW_13_in_rule__TableTestRow__Group_2_0__0__Impl6056); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2980:1: rule__TableTestRow__Group_2_0__1 : rule__TableTestRow__Group_2_0__1__Impl rule__TableTestRow__Group_2_0__2 ;
    public final void rule__TableTestRow__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2984:1: ( rule__TableTestRow__Group_2_0__1__Impl rule__TableTestRow__Group_2_0__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2985:2: rule__TableTestRow__Group_2_0__1__Impl rule__TableTestRow__Group_2_0__2
            {
            pushFollow(FOLLOW_rule__TableTestRow__Group_2_0__1__Impl_in_rule__TableTestRow__Group_2_0__16087);
            rule__TableTestRow__Group_2_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTestRow__Group_2_0__2_in_rule__TableTestRow__Group_2_0__16090);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2992:1: rule__TableTestRow__Group_2_0__1__Impl : ( '=' ) ;
    public final void rule__TableTestRow__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2996:1: ( ( '=' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2997:1: ( '=' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2997:1: ( '=' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2998:1: '='
            {
             before(grammarAccess.getTableTestRowAccess().getEqualsSignKeyword_2_0_1()); 
            match(input,29,FOLLOW_29_in_rule__TableTestRow__Group_2_0__1__Impl6118); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3011:1: rule__TableTestRow__Group_2_0__2 : rule__TableTestRow__Group_2_0__2__Impl rule__TableTestRow__Group_2_0__3 ;
    public final void rule__TableTestRow__Group_2_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3015:1: ( rule__TableTestRow__Group_2_0__2__Impl rule__TableTestRow__Group_2_0__3 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3016:2: rule__TableTestRow__Group_2_0__2__Impl rule__TableTestRow__Group_2_0__3
            {
            pushFollow(FOLLOW_rule__TableTestRow__Group_2_0__2__Impl_in_rule__TableTestRow__Group_2_0__26149);
            rule__TableTestRow__Group_2_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTestRow__Group_2_0__3_in_rule__TableTestRow__Group_2_0__26152);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3023:1: rule__TableTestRow__Group_2_0__2__Impl : ( ( rule__TableTestRow__ResultAssignment_2_0_2 ) ) ;
    public final void rule__TableTestRow__Group_2_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3027:1: ( ( ( rule__TableTestRow__ResultAssignment_2_0_2 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3028:1: ( ( rule__TableTestRow__ResultAssignment_2_0_2 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3028:1: ( ( rule__TableTestRow__ResultAssignment_2_0_2 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3029:1: ( rule__TableTestRow__ResultAssignment_2_0_2 )
            {
             before(grammarAccess.getTableTestRowAccess().getResultAssignment_2_0_2()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3030:1: ( rule__TableTestRow__ResultAssignment_2_0_2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3030:2: rule__TableTestRow__ResultAssignment_2_0_2
            {
            pushFollow(FOLLOW_rule__TableTestRow__ResultAssignment_2_0_2_in_rule__TableTestRow__Group_2_0__2__Impl6179);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3040:1: rule__TableTestRow__Group_2_0__3 : rule__TableTestRow__Group_2_0__3__Impl ;
    public final void rule__TableTestRow__Group_2_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3044:1: ( rule__TableTestRow__Group_2_0__3__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3045:2: rule__TableTestRow__Group_2_0__3__Impl
            {
            pushFollow(FOLLOW_rule__TableTestRow__Group_2_0__3__Impl_in_rule__TableTestRow__Group_2_0__36209);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3051:1: rule__TableTestRow__Group_2_0__3__Impl : ( '|' ) ;
    public final void rule__TableTestRow__Group_2_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3055:1: ( ( '|' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3056:1: ( '|' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3056:1: ( '|' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3057:1: '|'
            {
             before(grammarAccess.getTableTestRowAccess().getVerticalLineKeyword_2_0_3()); 
            match(input,13,FOLLOW_13_in_rule__TableTestRow__Group_2_0__3__Impl6237); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3078:1: rule__ParameterTableHeader__Group__0 : rule__ParameterTableHeader__Group__0__Impl rule__ParameterTableHeader__Group__1 ;
    public final void rule__ParameterTableHeader__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3082:1: ( rule__ParameterTableHeader__Group__0__Impl rule__ParameterTableHeader__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3083:2: rule__ParameterTableHeader__Group__0__Impl rule__ParameterTableHeader__Group__1
            {
            pushFollow(FOLLOW_rule__ParameterTableHeader__Group__0__Impl_in_rule__ParameterTableHeader__Group__06276);
            rule__ParameterTableHeader__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParameterTableHeader__Group__1_in_rule__ParameterTableHeader__Group__06279);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3090:1: rule__ParameterTableHeader__Group__0__Impl : ( '|' ) ;
    public final void rule__ParameterTableHeader__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3094:1: ( ( '|' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3095:1: ( '|' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3095:1: ( '|' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3096:1: '|'
            {
             before(grammarAccess.getParameterTableHeaderAccess().getVerticalLineKeyword_0()); 
            match(input,13,FOLLOW_13_in_rule__ParameterTableHeader__Group__0__Impl6307); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3109:1: rule__ParameterTableHeader__Group__1 : rule__ParameterTableHeader__Group__1__Impl ;
    public final void rule__ParameterTableHeader__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3113:1: ( rule__ParameterTableHeader__Group__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3114:2: rule__ParameterTableHeader__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ParameterTableHeader__Group__1__Impl_in_rule__ParameterTableHeader__Group__16338);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3120:1: rule__ParameterTableHeader__Group__1__Impl : ( ( rule__ParameterTableHeader__NameAssignment_1 ) ) ;
    public final void rule__ParameterTableHeader__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3124:1: ( ( ( rule__ParameterTableHeader__NameAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3125:1: ( ( rule__ParameterTableHeader__NameAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3125:1: ( ( rule__ParameterTableHeader__NameAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3126:1: ( rule__ParameterTableHeader__NameAssignment_1 )
            {
             before(grammarAccess.getParameterTableHeaderAccess().getNameAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3127:1: ( rule__ParameterTableHeader__NameAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3127:2: rule__ParameterTableHeader__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ParameterTableHeader__NameAssignment_1_in_rule__ParameterTableHeader__Group__1__Impl6365);
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


    // $ANTLR start "rule__ParameterTableValue__Group__0"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3141:1: rule__ParameterTableValue__Group__0 : rule__ParameterTableValue__Group__0__Impl rule__ParameterTableValue__Group__1 ;
    public final void rule__ParameterTableValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3145:1: ( rule__ParameterTableValue__Group__0__Impl rule__ParameterTableValue__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3146:2: rule__ParameterTableValue__Group__0__Impl rule__ParameterTableValue__Group__1
            {
            pushFollow(FOLLOW_rule__ParameterTableValue__Group__0__Impl_in_rule__ParameterTableValue__Group__06399);
            rule__ParameterTableValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParameterTableValue__Group__1_in_rule__ParameterTableValue__Group__06402);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3153:1: rule__ParameterTableValue__Group__0__Impl : ( '|' ) ;
    public final void rule__ParameterTableValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3157:1: ( ( '|' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3158:1: ( '|' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3158:1: ( '|' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3159:1: '|'
            {
             before(grammarAccess.getParameterTableValueAccess().getVerticalLineKeyword_0()); 
            match(input,13,FOLLOW_13_in_rule__ParameterTableValue__Group__0__Impl6430); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3172:1: rule__ParameterTableValue__Group__1 : rule__ParameterTableValue__Group__1__Impl ;
    public final void rule__ParameterTableValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3176:1: ( rule__ParameterTableValue__Group__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3177:2: rule__ParameterTableValue__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ParameterTableValue__Group__1__Impl_in_rule__ParameterTableValue__Group__16461);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3183:1: rule__ParameterTableValue__Group__1__Impl : ( ( rule__ParameterTableValue__ValueAssignment_1 ) ) ;
    public final void rule__ParameterTableValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3187:1: ( ( ( rule__ParameterTableValue__ValueAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3188:1: ( ( rule__ParameterTableValue__ValueAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3188:1: ( ( rule__ParameterTableValue__ValueAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3189:1: ( rule__ParameterTableValue__ValueAssignment_1 )
            {
             before(grammarAccess.getParameterTableValueAccess().getValueAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3190:1: ( rule__ParameterTableValue__ValueAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3190:2: rule__ParameterTableValue__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__ParameterTableValue__ValueAssignment_1_in_rule__ParameterTableValue__Group__1__Impl6488);
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


    // $ANTLR start "rule__Call__Group__0"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3204:1: rule__Call__Group__0 : rule__Call__Group__0__Impl rule__Call__Group__1 ;
    public final void rule__Call__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3208:1: ( rule__Call__Group__0__Impl rule__Call__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3209:2: rule__Call__Group__0__Impl rule__Call__Group__1
            {
            pushFollow(FOLLOW_rule__Call__Group__0__Impl_in_rule__Call__Group__06522);
            rule__Call__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group__1_in_rule__Call__Group__06525);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3216:1: rule__Call__Group__0__Impl : ( 'call' ) ;
    public final void rule__Call__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3220:1: ( ( 'call' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3221:1: ( 'call' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3221:1: ( 'call' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3222:1: 'call'
            {
             before(grammarAccess.getCallAccess().getCallKeyword_0()); 
            match(input,31,FOLLOW_31_in_rule__Call__Group__0__Impl6553); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3235:1: rule__Call__Group__1 : rule__Call__Group__1__Impl rule__Call__Group__2 ;
    public final void rule__Call__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3239:1: ( rule__Call__Group__1__Impl rule__Call__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3240:2: rule__Call__Group__1__Impl rule__Call__Group__2
            {
            pushFollow(FOLLOW_rule__Call__Group__1__Impl_in_rule__Call__Group__16584);
            rule__Call__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group__2_in_rule__Call__Group__16587);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3247:1: rule__Call__Group__1__Impl : ( ( rule__Call__DefinitionAssignment_1 ) ) ;
    public final void rule__Call__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3251:1: ( ( ( rule__Call__DefinitionAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3252:1: ( ( rule__Call__DefinitionAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3252:1: ( ( rule__Call__DefinitionAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3253:1: ( rule__Call__DefinitionAssignment_1 )
            {
             before(grammarAccess.getCallAccess().getDefinitionAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3254:1: ( rule__Call__DefinitionAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3254:2: rule__Call__DefinitionAssignment_1
            {
            pushFollow(FOLLOW_rule__Call__DefinitionAssignment_1_in_rule__Call__Group__1__Impl6614);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3264:1: rule__Call__Group__2 : rule__Call__Group__2__Impl rule__Call__Group__3 ;
    public final void rule__Call__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3268:1: ( rule__Call__Group__2__Impl rule__Call__Group__3 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3269:2: rule__Call__Group__2__Impl rule__Call__Group__3
            {
            pushFollow(FOLLOW_rule__Call__Group__2__Impl_in_rule__Call__Group__26644);
            rule__Call__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group__3_in_rule__Call__Group__26647);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3276:1: rule__Call__Group__2__Impl : ( ( rule__Call__ParametersAssignment_2 )* ) ;
    public final void rule__Call__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3280:1: ( ( ( rule__Call__ParametersAssignment_2 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3281:1: ( ( rule__Call__ParametersAssignment_2 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3281:1: ( ( rule__Call__ParametersAssignment_2 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3282:1: ( rule__Call__ParametersAssignment_2 )*
            {
             before(grammarAccess.getCallAccess().getParametersAssignment_2()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3283:1: ( rule__Call__ParametersAssignment_2 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_ID||LA26_0==35) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3283:2: rule__Call__ParametersAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Call__ParametersAssignment_2_in_rule__Call__Group__2__Impl6674);
            	    rule__Call__ParametersAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3293:1: rule__Call__Group__3 : rule__Call__Group__3__Impl ;
    public final void rule__Call__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3297:1: ( rule__Call__Group__3__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3298:2: rule__Call__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Call__Group__3__Impl_in_rule__Call__Group__36705);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3304:1: rule__Call__Group__3__Impl : ( ( rule__Call__Group_3__0 )? ) ;
    public final void rule__Call__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3308:1: ( ( ( rule__Call__Group_3__0 )? ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3309:1: ( ( rule__Call__Group_3__0 )? )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3309:1: ( ( rule__Call__Group_3__0 )? )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3310:1: ( rule__Call__Group_3__0 )?
            {
             before(grammarAccess.getCallAccess().getGroup_3()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3311:1: ( rule__Call__Group_3__0 )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==32) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3311:2: rule__Call__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Call__Group_3__0_in_rule__Call__Group__3__Impl6732);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3329:1: rule__Call__Group_3__0 : rule__Call__Group_3__0__Impl rule__Call__Group_3__1 ;
    public final void rule__Call__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3333:1: ( rule__Call__Group_3__0__Impl rule__Call__Group_3__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3334:2: rule__Call__Group_3__0__Impl rule__Call__Group_3__1
            {
            pushFollow(FOLLOW_rule__Call__Group_3__0__Impl_in_rule__Call__Group_3__06771);
            rule__Call__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group_3__1_in_rule__Call__Group_3__06774);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3341:1: rule__Call__Group_3__0__Impl : ( 'sets' ) ;
    public final void rule__Call__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3345:1: ( ( 'sets' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3346:1: ( 'sets' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3346:1: ( 'sets' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3347:1: 'sets'
            {
             before(grammarAccess.getCallAccess().getSetsKeyword_3_0()); 
            match(input,32,FOLLOW_32_in_rule__Call__Group_3__0__Impl6802); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3360:1: rule__Call__Group_3__1 : rule__Call__Group_3__1__Impl ;
    public final void rule__Call__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3364:1: ( rule__Call__Group_3__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3365:2: rule__Call__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Call__Group_3__1__Impl_in_rule__Call__Group_3__16833);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3371:1: rule__Call__Group_3__1__Impl : ( ( rule__Call__ResultAssignment_3_1 ) ) ;
    public final void rule__Call__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3375:1: ( ( ( rule__Call__ResultAssignment_3_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3376:1: ( ( rule__Call__ResultAssignment_3_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3376:1: ( ( rule__Call__ResultAssignment_3_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3377:1: ( rule__Call__ResultAssignment_3_1 )
            {
             before(grammarAccess.getCallAccess().getResultAssignment_3_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3378:1: ( rule__Call__ResultAssignment_3_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3378:2: rule__Call__ResultAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Call__ResultAssignment_3_1_in_rule__Call__Group_3__1__Impl6860);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3392:1: rule__Suite__Group__0 : rule__Suite__Group__0__Impl rule__Suite__Group__1 ;
    public final void rule__Suite__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3396:1: ( rule__Suite__Group__0__Impl rule__Suite__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3397:2: rule__Suite__Group__0__Impl rule__Suite__Group__1
            {
            pushFollow(FOLLOW_rule__Suite__Group__0__Impl_in_rule__Suite__Group__06894);
            rule__Suite__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Suite__Group__1_in_rule__Suite__Group__06897);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3404:1: rule__Suite__Group__0__Impl : ( 'suite' ) ;
    public final void rule__Suite__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3408:1: ( ( 'suite' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3409:1: ( 'suite' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3409:1: ( 'suite' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3410:1: 'suite'
            {
             before(grammarAccess.getSuiteAccess().getSuiteKeyword_0()); 
            match(input,33,FOLLOW_33_in_rule__Suite__Group__0__Impl6925); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3423:1: rule__Suite__Group__1 : rule__Suite__Group__1__Impl rule__Suite__Group__2 ;
    public final void rule__Suite__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3427:1: ( rule__Suite__Group__1__Impl rule__Suite__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3428:2: rule__Suite__Group__1__Impl rule__Suite__Group__2
            {
            pushFollow(FOLLOW_rule__Suite__Group__1__Impl_in_rule__Suite__Group__16956);
            rule__Suite__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Suite__Group__2_in_rule__Suite__Group__16959);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3435:1: rule__Suite__Group__1__Impl : ( ( rule__Suite__DefinitionAssignment_1 ) ) ;
    public final void rule__Suite__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3439:1: ( ( ( rule__Suite__DefinitionAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3440:1: ( ( rule__Suite__DefinitionAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3440:1: ( ( rule__Suite__DefinitionAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3441:1: ( rule__Suite__DefinitionAssignment_1 )
            {
             before(grammarAccess.getSuiteAccess().getDefinitionAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3442:1: ( rule__Suite__DefinitionAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3442:2: rule__Suite__DefinitionAssignment_1
            {
            pushFollow(FOLLOW_rule__Suite__DefinitionAssignment_1_in_rule__Suite__Group__1__Impl6986);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3452:1: rule__Suite__Group__2 : rule__Suite__Group__2__Impl ;
    public final void rule__Suite__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3456:1: ( rule__Suite__Group__2__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3457:2: rule__Suite__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Suite__Group__2__Impl_in_rule__Suite__Group__27016);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3463:1: rule__Suite__Group__2__Impl : ( ( rule__Suite__ParametersAssignment_2 )* ) ;
    public final void rule__Suite__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3467:1: ( ( ( rule__Suite__ParametersAssignment_2 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3468:1: ( ( rule__Suite__ParametersAssignment_2 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3468:1: ( ( rule__Suite__ParametersAssignment_2 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3469:1: ( rule__Suite__ParametersAssignment_2 )*
            {
             before(grammarAccess.getSuiteAccess().getParametersAssignment_2()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3470:1: ( rule__Suite__ParametersAssignment_2 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_ID) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3470:2: rule__Suite__ParametersAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Suite__ParametersAssignment_2_in_rule__Suite__Group__2__Impl7043);
            	    rule__Suite__ParametersAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3486:1: rule__SuiteParameter__Group__0 : rule__SuiteParameter__Group__0__Impl rule__SuiteParameter__Group__1 ;
    public final void rule__SuiteParameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3490:1: ( rule__SuiteParameter__Group__0__Impl rule__SuiteParameter__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3491:2: rule__SuiteParameter__Group__0__Impl rule__SuiteParameter__Group__1
            {
            pushFollow(FOLLOW_rule__SuiteParameter__Group__0__Impl_in_rule__SuiteParameter__Group__07080);
            rule__SuiteParameter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteParameter__Group__1_in_rule__SuiteParameter__Group__07083);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3498:1: rule__SuiteParameter__Group__0__Impl : ( ( rule__SuiteParameter__NameAssignment_0 ) ) ;
    public final void rule__SuiteParameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3502:1: ( ( ( rule__SuiteParameter__NameAssignment_0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3503:1: ( ( rule__SuiteParameter__NameAssignment_0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3503:1: ( ( rule__SuiteParameter__NameAssignment_0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3504:1: ( rule__SuiteParameter__NameAssignment_0 )
            {
             before(grammarAccess.getSuiteParameterAccess().getNameAssignment_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3505:1: ( rule__SuiteParameter__NameAssignment_0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3505:2: rule__SuiteParameter__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__SuiteParameter__NameAssignment_0_in_rule__SuiteParameter__Group__0__Impl7110);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3515:1: rule__SuiteParameter__Group__1 : rule__SuiteParameter__Group__1__Impl rule__SuiteParameter__Group__2 ;
    public final void rule__SuiteParameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3519:1: ( rule__SuiteParameter__Group__1__Impl rule__SuiteParameter__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3520:2: rule__SuiteParameter__Group__1__Impl rule__SuiteParameter__Group__2
            {
            pushFollow(FOLLOW_rule__SuiteParameter__Group__1__Impl_in_rule__SuiteParameter__Group__17140);
            rule__SuiteParameter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteParameter__Group__2_in_rule__SuiteParameter__Group__17143);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3527:1: rule__SuiteParameter__Group__1__Impl : ( ':' ) ;
    public final void rule__SuiteParameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3531:1: ( ( ':' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3532:1: ( ':' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3532:1: ( ':' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3533:1: ':'
            {
             before(grammarAccess.getSuiteParameterAccess().getColonKeyword_1()); 
            match(input,34,FOLLOW_34_in_rule__SuiteParameter__Group__1__Impl7171); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3546:1: rule__SuiteParameter__Group__2 : rule__SuiteParameter__Group__2__Impl ;
    public final void rule__SuiteParameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3550:1: ( rule__SuiteParameter__Group__2__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3551:2: rule__SuiteParameter__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__SuiteParameter__Group__2__Impl_in_rule__SuiteParameter__Group__27202);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3557:1: rule__SuiteParameter__Group__2__Impl : ( ( rule__SuiteParameter__ValueAssignment_2 ) ) ;
    public final void rule__SuiteParameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3561:1: ( ( ( rule__SuiteParameter__ValueAssignment_2 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3562:1: ( ( rule__SuiteParameter__ValueAssignment_2 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3562:1: ( ( rule__SuiteParameter__ValueAssignment_2 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3563:1: ( rule__SuiteParameter__ValueAssignment_2 )
            {
             before(grammarAccess.getSuiteParameterAccess().getValueAssignment_2()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3564:1: ( rule__SuiteParameter__ValueAssignment_2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3564:2: rule__SuiteParameter__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__SuiteParameter__ValueAssignment_2_in_rule__SuiteParameter__Group__2__Impl7229);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3580:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3584:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3585:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
            {
            pushFollow(FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__07265);
            rule__Parameter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__07268);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3592:1: rule__Parameter__Group__0__Impl : ( ( rule__Parameter__NameAssignment_0 ) ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3596:1: ( ( ( rule__Parameter__NameAssignment_0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3597:1: ( ( rule__Parameter__NameAssignment_0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3597:1: ( ( rule__Parameter__NameAssignment_0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3598:1: ( rule__Parameter__NameAssignment_0 )
            {
             before(grammarAccess.getParameterAccess().getNameAssignment_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3599:1: ( rule__Parameter__NameAssignment_0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3599:2: rule__Parameter__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Parameter__NameAssignment_0_in_rule__Parameter__Group__0__Impl7295);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3609:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl rule__Parameter__Group__2 ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3613:1: ( rule__Parameter__Group__1__Impl rule__Parameter__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3614:2: rule__Parameter__Group__1__Impl rule__Parameter__Group__2
            {
            pushFollow(FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__17325);
            rule__Parameter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Parameter__Group__2_in_rule__Parameter__Group__17328);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3621:1: rule__Parameter__Group__1__Impl : ( ':' ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3625:1: ( ( ':' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3626:1: ( ':' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3626:1: ( ':' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3627:1: ':'
            {
             before(grammarAccess.getParameterAccess().getColonKeyword_1()); 
            match(input,34,FOLLOW_34_in_rule__Parameter__Group__1__Impl7356); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3640:1: rule__Parameter__Group__2 : rule__Parameter__Group__2__Impl ;
    public final void rule__Parameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3644:1: ( rule__Parameter__Group__2__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3645:2: rule__Parameter__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Parameter__Group__2__Impl_in_rule__Parameter__Group__27387);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3651:1: rule__Parameter__Group__2__Impl : ( ( rule__Parameter__ValueAssignment_2 ) ) ;
    public final void rule__Parameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3655:1: ( ( ( rule__Parameter__ValueAssignment_2 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3656:1: ( ( rule__Parameter__ValueAssignment_2 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3656:1: ( ( rule__Parameter__ValueAssignment_2 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3657:1: ( rule__Parameter__ValueAssignment_2 )
            {
             before(grammarAccess.getParameterAccess().getValueAssignment_2()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3658:1: ( rule__Parameter__ValueAssignment_2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3658:2: rule__Parameter__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__Parameter__ValueAssignment_2_in_rule__Parameter__Group__2__Impl7414);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3674:1: rule__ArbitraryParameterName__Group__0 : rule__ArbitraryParameterName__Group__0__Impl rule__ArbitraryParameterName__Group__1 ;
    public final void rule__ArbitraryParameterName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3678:1: ( rule__ArbitraryParameterName__Group__0__Impl rule__ArbitraryParameterName__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3679:2: rule__ArbitraryParameterName__Group__0__Impl rule__ArbitraryParameterName__Group__1
            {
            pushFollow(FOLLOW_rule__ArbitraryParameterName__Group__0__Impl_in_rule__ArbitraryParameterName__Group__07450);
            rule__ArbitraryParameterName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ArbitraryParameterName__Group__1_in_rule__ArbitraryParameterName__Group__07453);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3686:1: rule__ArbitraryParameterName__Group__0__Impl : ( '+' ) ;
    public final void rule__ArbitraryParameterName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3690:1: ( ( '+' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3691:1: ( '+' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3691:1: ( '+' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3692:1: '+'
            {
             before(grammarAccess.getArbitraryParameterNameAccess().getPlusSignKeyword_0()); 
            match(input,35,FOLLOW_35_in_rule__ArbitraryParameterName__Group__0__Impl7481); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3705:1: rule__ArbitraryParameterName__Group__1 : rule__ArbitraryParameterName__Group__1__Impl ;
    public final void rule__ArbitraryParameterName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3709:1: ( rule__ArbitraryParameterName__Group__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3710:2: rule__ArbitraryParameterName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ArbitraryParameterName__Group__1__Impl_in_rule__ArbitraryParameterName__Group__17512);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3716:1: rule__ArbitraryParameterName__Group__1__Impl : ( ( rule__ArbitraryParameterName__IdentifierAssignment_1 ) ) ;
    public final void rule__ArbitraryParameterName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3720:1: ( ( ( rule__ArbitraryParameterName__IdentifierAssignment_1 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3721:1: ( ( rule__ArbitraryParameterName__IdentifierAssignment_1 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3721:1: ( ( rule__ArbitraryParameterName__IdentifierAssignment_1 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3722:1: ( rule__ArbitraryParameterName__IdentifierAssignment_1 )
            {
             before(grammarAccess.getArbitraryParameterNameAccess().getIdentifierAssignment_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3723:1: ( rule__ArbitraryParameterName__IdentifierAssignment_1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3723:2: rule__ArbitraryParameterName__IdentifierAssignment_1
            {
            pushFollow(FOLLOW_rule__ArbitraryParameterName__IdentifierAssignment_1_in_rule__ArbitraryParameterName__Group__1__Impl7539);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3737:1: rule__MethodReference__Group__0 : rule__MethodReference__Group__0__Impl rule__MethodReference__Group__1 ;
    public final void rule__MethodReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3741:1: ( rule__MethodReference__Group__0__Impl rule__MethodReference__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3742:2: rule__MethodReference__Group__0__Impl rule__MethodReference__Group__1
            {
            pushFollow(FOLLOW_rule__MethodReference__Group__0__Impl_in_rule__MethodReference__Group__07573);
            rule__MethodReference__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodReference__Group__1_in_rule__MethodReference__Group__07576);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3749:1: rule__MethodReference__Group__0__Impl : ( ( rule__MethodReference__TypeAssignment_0 ) ) ;
    public final void rule__MethodReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3753:1: ( ( ( rule__MethodReference__TypeAssignment_0 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3754:1: ( ( rule__MethodReference__TypeAssignment_0 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3754:1: ( ( rule__MethodReference__TypeAssignment_0 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3755:1: ( rule__MethodReference__TypeAssignment_0 )
            {
             before(grammarAccess.getMethodReferenceAccess().getTypeAssignment_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3756:1: ( rule__MethodReference__TypeAssignment_0 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3756:2: rule__MethodReference__TypeAssignment_0
            {
            pushFollow(FOLLOW_rule__MethodReference__TypeAssignment_0_in_rule__MethodReference__Group__0__Impl7603);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3766:1: rule__MethodReference__Group__1 : rule__MethodReference__Group__1__Impl rule__MethodReference__Group__2 ;
    public final void rule__MethodReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3770:1: ( rule__MethodReference__Group__1__Impl rule__MethodReference__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3771:2: rule__MethodReference__Group__1__Impl rule__MethodReference__Group__2
            {
            pushFollow(FOLLOW_rule__MethodReference__Group__1__Impl_in_rule__MethodReference__Group__17633);
            rule__MethodReference__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodReference__Group__2_in_rule__MethodReference__Group__17636);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3778:1: rule__MethodReference__Group__1__Impl : ( '#' ) ;
    public final void rule__MethodReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3782:1: ( ( '#' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3783:1: ( '#' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3783:1: ( '#' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3784:1: '#'
            {
             before(grammarAccess.getMethodReferenceAccess().getNumberSignKeyword_1()); 
            match(input,36,FOLLOW_36_in_rule__MethodReference__Group__1__Impl7664); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3797:1: rule__MethodReference__Group__2 : rule__MethodReference__Group__2__Impl ;
    public final void rule__MethodReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3801:1: ( rule__MethodReference__Group__2__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3802:2: rule__MethodReference__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__MethodReference__Group__2__Impl_in_rule__MethodReference__Group__27695);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3808:1: rule__MethodReference__Group__2__Impl : ( ( rule__MethodReference__MethodAssignment_2 ) ) ;
    public final void rule__MethodReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3812:1: ( ( ( rule__MethodReference__MethodAssignment_2 ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3813:1: ( ( rule__MethodReference__MethodAssignment_2 ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3813:1: ( ( rule__MethodReference__MethodAssignment_2 ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3814:1: ( rule__MethodReference__MethodAssignment_2 )
            {
             before(grammarAccess.getMethodReferenceAccess().getMethodAssignment_2()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3815:1: ( rule__MethodReference__MethodAssignment_2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3815:2: rule__MethodReference__MethodAssignment_2
            {
            pushFollow(FOLLOW_rule__MethodReference__MethodAssignment_2_in_rule__MethodReference__Group__2__Impl7722);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3831:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3835:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3836:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__07758);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__07761);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3843:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3847:1: ( ( RULE_ID ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3848:1: ( RULE_ID )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3848:1: ( RULE_ID )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3849:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl7788); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3860:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3864:1: ( rule__QualifiedName__Group__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3865:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__17817);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3871:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3875:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3876:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3876:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3877:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3878:1: ( rule__QualifiedName__Group_1__0 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==37) ) {
                    int LA29_2 = input.LA(2);

                    if ( (LA29_2==RULE_ID) ) {
                        alt29=1;
                    }


                }


                switch (alt29) {
            	case 1 :
            	    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3878:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl7844);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3892:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3896:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3897:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__07879);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__07882);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3904:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3908:1: ( ( '.' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3909:1: ( '.' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3909:1: ( '.' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3910:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,37,FOLLOW_37_in_rule__QualifiedName__Group_1__0__Impl7910); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3923:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3927:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3928:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__17941);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3934:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3938:1: ( ( RULE_ID ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3939:1: ( RULE_ID )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3939:1: ( RULE_ID )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3940:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl7968); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3955:1: rule__QualifiedJavaClassName__Group__0 : rule__QualifiedJavaClassName__Group__0__Impl rule__QualifiedJavaClassName__Group__1 ;
    public final void rule__QualifiedJavaClassName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3959:1: ( rule__QualifiedJavaClassName__Group__0__Impl rule__QualifiedJavaClassName__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3960:2: rule__QualifiedJavaClassName__Group__0__Impl rule__QualifiedJavaClassName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__0__Impl_in_rule__QualifiedJavaClassName__Group__08001);
            rule__QualifiedJavaClassName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__1_in_rule__QualifiedJavaClassName__Group__08004);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3967:1: rule__QualifiedJavaClassName__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedJavaClassName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3971:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3972:1: ( ruleQualifiedName )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3972:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3973:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedJavaClassNameAccess().getQualifiedNameParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedJavaClassName__Group__0__Impl8031);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3984:1: rule__QualifiedJavaClassName__Group__1 : rule__QualifiedJavaClassName__Group__1__Impl rule__QualifiedJavaClassName__Group__2 ;
    public final void rule__QualifiedJavaClassName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3988:1: ( rule__QualifiedJavaClassName__Group__1__Impl rule__QualifiedJavaClassName__Group__2 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3989:2: rule__QualifiedJavaClassName__Group__1__Impl rule__QualifiedJavaClassName__Group__2
            {
            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__1__Impl_in_rule__QualifiedJavaClassName__Group__18060);
            rule__QualifiedJavaClassName__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__2_in_rule__QualifiedJavaClassName__Group__18063);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3996:1: rule__QualifiedJavaClassName__Group__1__Impl : ( '.' ) ;
    public final void rule__QualifiedJavaClassName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4000:1: ( ( '.' ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4001:1: ( '.' )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4001:1: ( '.' )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4002:1: '.'
            {
             before(grammarAccess.getQualifiedJavaClassNameAccess().getFullStopKeyword_1()); 
            match(input,37,FOLLOW_37_in_rule__QualifiedJavaClassName__Group__1__Impl8091); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4015:1: rule__QualifiedJavaClassName__Group__2 : rule__QualifiedJavaClassName__Group__2__Impl ;
    public final void rule__QualifiedJavaClassName__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4019:1: ( rule__QualifiedJavaClassName__Group__2__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4020:2: rule__QualifiedJavaClassName__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__2__Impl_in_rule__QualifiedJavaClassName__Group__28122);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4026:1: rule__QualifiedJavaClassName__Group__2__Impl : ( RULE_UPPERCASE_ID ) ;
    public final void rule__QualifiedJavaClassName__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4030:1: ( ( RULE_UPPERCASE_ID ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4031:1: ( RULE_UPPERCASE_ID )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4031:1: ( RULE_UPPERCASE_ID )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4032:1: RULE_UPPERCASE_ID
            {
             before(grammarAccess.getQualifiedJavaClassNameAccess().getUPPERCASE_IDTerminalRuleCall_2()); 
            match(input,RULE_UPPERCASE_ID,FOLLOW_RULE_UPPERCASE_ID_in_rule__QualifiedJavaClassName__Group__2__Impl8149); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4049:1: rule__QualifiedNameWithWildcard__Group__0 : rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 ;
    public final void rule__QualifiedNameWithWildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4053:1: ( rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4054:2: rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__0__Impl_in_rule__QualifiedNameWithWildcard__Group__08184);
            rule__QualifiedNameWithWildcard__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__1_in_rule__QualifiedNameWithWildcard__Group__08187);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4061:1: rule__QualifiedNameWithWildcard__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedNameWithWildcard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4065:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4066:1: ( ruleQualifiedName )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4066:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4067:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildcard__Group__0__Impl8214);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4078:1: rule__QualifiedNameWithWildcard__Group__1 : rule__QualifiedNameWithWildcard__Group__1__Impl ;
    public final void rule__QualifiedNameWithWildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4082:1: ( rule__QualifiedNameWithWildcard__Group__1__Impl )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4083:2: rule__QualifiedNameWithWildcard__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__1__Impl_in_rule__QualifiedNameWithWildcard__Group__18243);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4089:1: rule__QualifiedNameWithWildcard__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__QualifiedNameWithWildcard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4093:1: ( ( ( '.*' )? ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4094:1: ( ( '.*' )? )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4094:1: ( ( '.*' )? )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4095:1: ( '.*' )?
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4096:1: ( '.*' )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==38) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4097:2: '.*'
                    {
                    match(input,38,FOLLOW_38_in_rule__QualifiedNameWithWildcard__Group__1__Impl8272); 

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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4113:1: rule__Model__StatementsAssignment : ( ruleStatement ) ;
    public final void rule__Model__StatementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4117:1: ( ( ruleStatement ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4118:1: ( ruleStatement )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4118:1: ( ruleStatement )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4119:1: ruleStatement
            {
             before(grammarAccess.getModelAccess().getStatementsStatementParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleStatement_in_rule__Model__StatementsAssignment8314);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4128:1: rule__PackageDefinition__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__PackageDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4132:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4133:1: ( ruleQualifiedName )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4133:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4134:1: ruleQualifiedName
            {
             before(grammarAccess.getPackageDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__PackageDefinition__NameAssignment_18345);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4143:1: rule__PackageDefinition__StatementsAssignment_3 : ( rulePackageStatement ) ;
    public final void rule__PackageDefinition__StatementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4147:1: ( ( rulePackageStatement ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4148:1: ( rulePackageStatement )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4148:1: ( rulePackageStatement )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4149:1: rulePackageStatement
            {
             before(grammarAccess.getPackageDefinitionAccess().getStatementsPackageStatementParserRuleCall_3_0()); 
            pushFollow(FOLLOW_rulePackageStatement_in_rule__PackageDefinition__StatementsAssignment_38376);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4158:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleQualifiedNameWithWildcard ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4162:1: ( ( ruleQualifiedNameWithWildcard ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4163:1: ( ruleQualifiedNameWithWildcard )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4163:1: ( ruleQualifiedNameWithWildcard )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4164:1: ruleQualifiedNameWithWildcard
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_rule__Import__ImportedNamespaceAssignment_18407);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4173:1: rule__TestDefinition__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__TestDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4177:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4178:1: ( ruleQualifiedName )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4178:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4179:1: ruleQualifiedName
            {
             before(grammarAccess.getTestDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__TestDefinition__NameAssignment_18438);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4188:1: rule__TestDefinition__FixtureMethodAssignment_3 : ( ruleMethodReference ) ;
    public final void rule__TestDefinition__FixtureMethodAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4192:1: ( ( ruleMethodReference ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4193:1: ( ruleMethodReference )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4193:1: ( ruleMethodReference )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4194:1: ruleMethodReference
            {
             before(grammarAccess.getTestDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleMethodReference_in_rule__TestDefinition__FixtureMethodAssignment_38469);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4203:1: rule__CallDefinition__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__CallDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4207:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4208:1: ( ruleQualifiedName )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4208:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4209:1: ruleQualifiedName
            {
             before(grammarAccess.getCallDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__CallDefinition__NameAssignment_18500);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4218:1: rule__CallDefinition__FixtureMethodAssignment_3 : ( ruleMethodReference ) ;
    public final void rule__CallDefinition__FixtureMethodAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4222:1: ( ( ruleMethodReference ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4223:1: ( ruleMethodReference )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4223:1: ( ruleMethodReference )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4224:1: ruleMethodReference
            {
             before(grammarAccess.getCallDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleMethodReference_in_rule__CallDefinition__FixtureMethodAssignment_38531);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4233:1: rule__SuiteDefinition__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__SuiteDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4237:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4238:1: ( ruleQualifiedName )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4238:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4239:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__NameAssignment_18562);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4248:1: rule__SuiteDefinition__ParametersAssignment_2_1 : ( ruleVariableEntity ) ;
    public final void rule__SuiteDefinition__ParametersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4252:1: ( ( ruleVariableEntity ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4253:1: ( ruleVariableEntity )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4253:1: ( ruleVariableEntity )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4254:1: ruleVariableEntity
            {
             before(grammarAccess.getSuiteDefinitionAccess().getParametersVariableEntityParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleVariableEntity_in_rule__SuiteDefinition__ParametersAssignment_2_18593);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4263:1: rule__SuiteDefinition__DependenciesAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__SuiteDefinition__DependenciesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4267:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4268:1: ( ( ruleQualifiedName ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4268:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4269:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSuiteDefinitionAccess().getDependenciesSuiteDefinitionCrossReference_3_1_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4270:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4271:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteDefinitionAccess().getDependenciesSuiteDefinitionQualifiedNameParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__DependenciesAssignment_3_18628);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4282:1: rule__SuiteDefinition__StatementsAssignment_5 : ( ruleSuiteStatement ) ;
    public final void rule__SuiteDefinition__StatementsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4286:1: ( ( ruleSuiteStatement ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4287:1: ( ruleSuiteStatement )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4287:1: ( ruleSuiteStatement )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4288:1: ruleSuiteStatement
            {
             before(grammarAccess.getSuiteDefinitionAccess().getStatementsSuiteStatementParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleSuiteStatement_in_rule__SuiteDefinition__StatementsAssignment_58663);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4297:1: rule__SuiteDefinition__FinalizersAssignment_7_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__SuiteDefinition__FinalizersAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4301:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4302:1: ( ( ruleQualifiedName ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4302:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4303:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSuiteDefinitionAccess().getFinalizersSuiteDefinitionCrossReference_7_1_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4304:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4305:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteDefinitionAccess().getFinalizersSuiteDefinitionQualifiedNameParserRuleCall_7_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__FinalizersAssignment_7_18698);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4316:1: rule__VariableDefinition__NameAssignment_1 : ( ruleVariableEntity ) ;
    public final void rule__VariableDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4320:1: ( ( ruleVariableEntity ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4321:1: ( ruleVariableEntity )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4321:1: ( ruleVariableEntity )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4322:1: ruleVariableEntity
            {
             before(grammarAccess.getVariableDefinitionAccess().getNameVariableEntityParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleVariableEntity_in_rule__VariableDefinition__NameAssignment_18733);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4331:1: rule__VariableDefinition__InitialValueAssignment_2_1 : ( ruleValue ) ;
    public final void rule__VariableDefinition__InitialValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4335:1: ( ( ruleValue ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4336:1: ( ruleValue )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4336:1: ( ruleValue )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4337:1: ruleValue
            {
             before(grammarAccess.getVariableDefinitionAccess().getInitialValueValueParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleValue_in_rule__VariableDefinition__InitialValueAssignment_2_18764);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4346:1: rule__VariableEntity__NameAssignment : ( ruleQualifiedName ) ;
    public final void rule__VariableEntity__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4350:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4351:1: ( ruleQualifiedName )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4351:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4352:1: ruleQualifiedName
            {
             before(grammarAccess.getVariableEntityAccess().getNameQualifiedNameParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__VariableEntity__NameAssignment8795);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4361:1: rule__Test__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Test__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4365:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4366:1: ( ( ruleQualifiedName ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4366:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4367:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getTestAccess().getDefinitionTestDefinitionCrossReference_1_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4368:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4369:1: ruleQualifiedName
            {
             before(grammarAccess.getTestAccess().getDefinitionTestDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Test__DefinitionAssignment_18830);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4380:1: rule__Test__ParametersAssignment_2 : ( ruleParameter ) ;
    public final void rule__Test__ParametersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4384:1: ( ( ruleParameter ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4385:1: ( ruleParameter )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4385:1: ( ruleParameter )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4386:1: ruleParameter
            {
             before(grammarAccess.getTestAccess().getParametersParameterParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleParameter_in_rule__Test__ParametersAssignment_28865);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4395:1: rule__Test__ResultAssignment_3_1 : ( ruleValueOrEnumValue ) ;
    public final void rule__Test__ResultAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4399:1: ( ( ruleValueOrEnumValue ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4400:1: ( ruleValueOrEnumValue )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4400:1: ( ruleValueOrEnumValue )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4401:1: ruleValueOrEnumValue
            {
             before(grammarAccess.getTestAccess().getResultValueOrEnumValueParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_rule__Test__ResultAssignment_3_18896);
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


    // $ANTLR start "rule__TableTest__DefinitionAssignment_1"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4410:1: rule__TableTest__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__TableTest__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4414:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4415:1: ( ( ruleQualifiedName ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4415:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4416:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getTableTestAccess().getDefinitionTestDefinitionCrossReference_1_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4417:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4418:1: ruleQualifiedName
            {
             before(grammarAccess.getTableTestAccess().getDefinitionTestDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__TableTest__DefinitionAssignment_18931);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4429:1: rule__TableTest__ParametersAssignment_2 : ( ruleParameter ) ;
    public final void rule__TableTest__ParametersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4433:1: ( ( ruleParameter ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4434:1: ( ruleParameter )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4434:1: ( ruleParameter )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4435:1: ruleParameter
            {
             before(grammarAccess.getTableTestAccess().getParametersParameterParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleParameter_in_rule__TableTest__ParametersAssignment_28966);
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


    // $ANTLR start "rule__TableTest__HeadersAssignment_3"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4444:1: rule__TableTest__HeadersAssignment_3 : ( ruleParameterTableHeader ) ;
    public final void rule__TableTest__HeadersAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4448:1: ( ( ruleParameterTableHeader ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4449:1: ( ruleParameterTableHeader )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4449:1: ( ruleParameterTableHeader )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4450:1: ruleParameterTableHeader
            {
             before(grammarAccess.getTableTestAccess().getHeadersParameterTableHeaderParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleParameterTableHeader_in_rule__TableTest__HeadersAssignment_38997);
            ruleParameterTableHeader();

            state._fsp--;

             after(grammarAccess.getTableTestAccess().getHeadersParameterTableHeaderParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__HeadersAssignment_3"


    // $ANTLR start "rule__TableTest__RowsAssignment_5"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4459:1: rule__TableTest__RowsAssignment_5 : ( ruleTableTestRow ) ;
    public final void rule__TableTest__RowsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4463:1: ( ( ruleTableTestRow ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4464:1: ( ruleTableTestRow )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4464:1: ( ruleTableTestRow )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4465:1: ruleTableTestRow
            {
             before(grammarAccess.getTableTestAccess().getRowsTableTestRowParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleTableTestRow_in_rule__TableTest__RowsAssignment_59028);
            ruleTableTestRow();

            state._fsp--;

             after(grammarAccess.getTableTestAccess().getRowsTableTestRowParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TableTest__RowsAssignment_5"


    // $ANTLR start "rule__TableTestRow__ValuesAssignment_1"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4474:1: rule__TableTestRow__ValuesAssignment_1 : ( ruleParameterTableValue ) ;
    public final void rule__TableTestRow__ValuesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4478:1: ( ( ruleParameterTableValue ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4479:1: ( ruleParameterTableValue )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4479:1: ( ruleParameterTableValue )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4480:1: ruleParameterTableValue
            {
             before(grammarAccess.getTableTestRowAccess().getValuesParameterTableValueParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleParameterTableValue_in_rule__TableTestRow__ValuesAssignment_19059);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4489:1: rule__TableTestRow__ResultAssignment_2_0_2 : ( ruleValueOrEnumValue ) ;
    public final void rule__TableTestRow__ResultAssignment_2_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4493:1: ( ( ruleValueOrEnumValue ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4494:1: ( ruleValueOrEnumValue )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4494:1: ( ruleValueOrEnumValue )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4495:1: ruleValueOrEnumValue
            {
             before(grammarAccess.getTableTestRowAccess().getResultValueOrEnumValueParserRuleCall_2_0_2_0()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_rule__TableTestRow__ResultAssignment_2_0_29090);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4504:1: rule__ParameterTableHeader__NameAssignment_1 : ( ruleParameterName ) ;
    public final void rule__ParameterTableHeader__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4508:1: ( ( ruleParameterName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4509:1: ( ruleParameterName )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4509:1: ( ruleParameterName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4510:1: ruleParameterName
            {
             before(grammarAccess.getParameterTableHeaderAccess().getNameParameterNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleParameterName_in_rule__ParameterTableHeader__NameAssignment_19121);
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


    // $ANTLR start "rule__ParameterTableValue__ValueAssignment_1"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4519:1: rule__ParameterTableValue__ValueAssignment_1 : ( ruleValueOrEnumValue ) ;
    public final void rule__ParameterTableValue__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4523:1: ( ( ruleValueOrEnumValue ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4524:1: ( ruleValueOrEnumValue )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4524:1: ( ruleValueOrEnumValue )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4525:1: ruleValueOrEnumValue
            {
             before(grammarAccess.getParameterTableValueAccess().getValueValueOrEnumValueParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_rule__ParameterTableValue__ValueAssignment_19152);
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


    // $ANTLR start "rule__Call__DefinitionAssignment_1"
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4534:1: rule__Call__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Call__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4538:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4539:1: ( ( ruleQualifiedName ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4539:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4540:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getCallAccess().getDefinitionCallDefinitionCrossReference_1_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4541:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4542:1: ruleQualifiedName
            {
             before(grammarAccess.getCallAccess().getDefinitionCallDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Call__DefinitionAssignment_19187);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4553:1: rule__Call__ParametersAssignment_2 : ( ruleParameter ) ;
    public final void rule__Call__ParametersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4557:1: ( ( ruleParameter ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4558:1: ( ruleParameter )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4558:1: ( ruleParameter )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4559:1: ruleParameter
            {
             before(grammarAccess.getCallAccess().getParametersParameterParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleParameter_in_rule__Call__ParametersAssignment_29222);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4568:1: rule__Call__ResultAssignment_3_1 : ( ruleVariable ) ;
    public final void rule__Call__ResultAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4572:1: ( ( ruleVariable ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4573:1: ( ruleVariable )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4573:1: ( ruleVariable )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4574:1: ruleVariable
            {
             before(grammarAccess.getCallAccess().getResultVariableParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleVariable_in_rule__Call__ResultAssignment_3_19253);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4583:1: rule__Suite__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Suite__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4587:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4588:1: ( ( ruleQualifiedName ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4588:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4589:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSuiteAccess().getDefinitionSuiteDefinitionCrossReference_1_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4590:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4591:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteAccess().getDefinitionSuiteDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Suite__DefinitionAssignment_19288);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4602:1: rule__Suite__ParametersAssignment_2 : ( ruleSuiteParameter ) ;
    public final void rule__Suite__ParametersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4606:1: ( ( ruleSuiteParameter ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4607:1: ( ruleSuiteParameter )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4607:1: ( ruleSuiteParameter )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4608:1: ruleSuiteParameter
            {
             before(grammarAccess.getSuiteAccess().getParametersSuiteParameterParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleSuiteParameter_in_rule__Suite__ParametersAssignment_29323);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4617:1: rule__SuiteParameter__NameAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__SuiteParameter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4621:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4622:1: ( ( ruleQualifiedName ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4622:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4623:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSuiteParameterAccess().getNameVariableEntityCrossReference_0_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4624:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4625:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteParameterAccess().getNameVariableEntityQualifiedNameParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__SuiteParameter__NameAssignment_09358);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4636:1: rule__SuiteParameter__ValueAssignment_2 : ( ruleValue ) ;
    public final void rule__SuiteParameter__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4640:1: ( ( ruleValue ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4641:1: ( ruleValue )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4641:1: ( ruleValue )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4642:1: ruleValue
            {
             before(grammarAccess.getSuiteParameterAccess().getValueValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleValue_in_rule__SuiteParameter__ValueAssignment_29393);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4651:1: rule__Parameter__NameAssignment_0 : ( ruleParameterName ) ;
    public final void rule__Parameter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4655:1: ( ( ruleParameterName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4656:1: ( ruleParameterName )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4656:1: ( ruleParameterName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4657:1: ruleParameterName
            {
             before(grammarAccess.getParameterAccess().getNameParameterNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleParameterName_in_rule__Parameter__NameAssignment_09424);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4666:1: rule__Parameter__ValueAssignment_2 : ( ruleValueOrEnumValue ) ;
    public final void rule__Parameter__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4670:1: ( ( ruleValueOrEnumValue ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4671:1: ( ruleValueOrEnumValue )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4671:1: ( ruleValueOrEnumValue )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4672:1: ruleValueOrEnumValue
            {
             before(grammarAccess.getParameterAccess().getValueValueOrEnumValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_rule__Parameter__ValueAssignment_29455);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4681:1: rule__FixedParameterName__AnnotationAssignment : ( ( RULE_ID ) ) ;
    public final void rule__FixedParameterName__AnnotationAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4685:1: ( ( ( RULE_ID ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4686:1: ( ( RULE_ID ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4686:1: ( ( RULE_ID ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4687:1: ( RULE_ID )
            {
             before(grammarAccess.getFixedParameterNameAccess().getAnnotationJvmAnnotationReferenceCrossReference_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4688:1: ( RULE_ID )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4689:1: RULE_ID
            {
             before(grammarAccess.getFixedParameterNameAccess().getAnnotationJvmAnnotationReferenceIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FixedParameterName__AnnotationAssignment9490); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4700:1: rule__ArbitraryParameterName__IdentifierAssignment_1 : ( RULE_ID ) ;
    public final void rule__ArbitraryParameterName__IdentifierAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4704:1: ( ( RULE_ID ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4705:1: ( RULE_ID )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4705:1: ( RULE_ID )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4706:1: RULE_ID
            {
             before(grammarAccess.getArbitraryParameterNameAccess().getIdentifierIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ArbitraryParameterName__IdentifierAssignment_19525); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4715:1: rule__IntegerValue__IntegerValueAssignment : ( RULE_INTEGER ) ;
    public final void rule__IntegerValue__IntegerValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4719:1: ( ( RULE_INTEGER ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4720:1: ( RULE_INTEGER )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4720:1: ( RULE_INTEGER )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4721:1: RULE_INTEGER
            {
             before(grammarAccess.getIntegerValueAccess().getIntegerValueINTEGERTerminalRuleCall_0()); 
            match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_rule__IntegerValue__IntegerValueAssignment9556); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4730:1: rule__DecimalValue__DecimalValueAssignment : ( RULE_DECIMAL ) ;
    public final void rule__DecimalValue__DecimalValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4734:1: ( ( RULE_DECIMAL ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4735:1: ( RULE_DECIMAL )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4735:1: ( RULE_DECIMAL )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4736:1: RULE_DECIMAL
            {
             before(grammarAccess.getDecimalValueAccess().getDecimalValueDECIMALTerminalRuleCall_0()); 
            match(input,RULE_DECIMAL,FOLLOW_RULE_DECIMAL_in_rule__DecimalValue__DecimalValueAssignment9587); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4745:1: rule__StringValue__StringValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringValue__StringValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4749:1: ( ( RULE_STRING ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4750:1: ( RULE_STRING )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4750:1: ( RULE_STRING )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4751:1: RULE_STRING
            {
             before(grammarAccess.getStringValueAccess().getStringValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringValue__StringValueAssignment9618); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4760:1: rule__Variable__NameAssignment : ( ( ruleQualifiedName ) ) ;
    public final void rule__Variable__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4764:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4765:1: ( ( ruleQualifiedName ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4765:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4766:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getVariableAccess().getNameVariableEntityCrossReference_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4767:1: ( ruleQualifiedName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4768:1: ruleQualifiedName
            {
             before(grammarAccess.getVariableAccess().getNameVariableEntityQualifiedNameParserRuleCall_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Variable__NameAssignment9653);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4779:1: rule__EnumValue__EnumValueAssignment : ( ( RULE_UPPERCASE_ID ) ) ;
    public final void rule__EnumValue__EnumValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4783:1: ( ( ( RULE_UPPERCASE_ID ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4784:1: ( ( RULE_UPPERCASE_ID ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4784:1: ( ( RULE_UPPERCASE_ID ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4785:1: ( RULE_UPPERCASE_ID )
            {
             before(grammarAccess.getEnumValueAccess().getEnumValueJvmEnumerationLiteralCrossReference_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4786:1: ( RULE_UPPERCASE_ID )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4787:1: RULE_UPPERCASE_ID
            {
             before(grammarAccess.getEnumValueAccess().getEnumValueJvmEnumerationLiteralUPPERCASE_IDTerminalRuleCall_0_1()); 
            match(input,RULE_UPPERCASE_ID,FOLLOW_RULE_UPPERCASE_ID_in_rule__EnumValue__EnumValueAssignment9692); 
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4798:1: rule__MethodReference__TypeAssignment_0 : ( ( ruleQualifiedJavaClassName ) ) ;
    public final void rule__MethodReference__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4802:1: ( ( ( ruleQualifiedJavaClassName ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4803:1: ( ( ruleQualifiedJavaClassName ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4803:1: ( ( ruleQualifiedJavaClassName ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4804:1: ( ruleQualifiedJavaClassName )
            {
             before(grammarAccess.getMethodReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4805:1: ( ruleQualifiedJavaClassName )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4806:1: ruleQualifiedJavaClassName
            {
             before(grammarAccess.getMethodReferenceAccess().getTypeJvmTypeQualifiedJavaClassNameParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_rule__MethodReference__TypeAssignment_09731);
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
    // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4817:1: rule__MethodReference__MethodAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__MethodReference__MethodAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4821:1: ( ( ( RULE_ID ) ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4822:1: ( ( RULE_ID ) )
            {
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4822:1: ( ( RULE_ID ) )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4823:1: ( RULE_ID )
            {
             before(grammarAccess.getMethodReferenceAccess().getMethodJvmOperationCrossReference_2_0()); 
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4824:1: ( RULE_ID )
            // ../de.integrity.dsl.ui/src-gen/de/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4825:1: RULE_ID
            {
             before(grammarAccess.getMethodReferenceAccess().getMethodJvmOperationIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__MethodReference__MethodAssignment_29770); 
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
    public static final BitSet FOLLOW_rule__Model__StatementsAssignment_in_ruleModel94 = new BitSet(new long[]{0x0000000200024002L});
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
    public static final BitSet FOLLOW_ruleTableTest_in_entryRuleTableTest842 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTableTest849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group__0_in_ruleTableTest875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTableTestRow_in_entryRuleTableTestRow902 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTableTestRow909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group__0_in_ruleTableTestRow935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableHeader_in_entryRuleParameterTableHeader962 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterTableHeader969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableHeader__Group__0_in_ruleParameterTableHeader995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableValue_in_entryRuleParameterTableValue1022 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterTableValue1029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableValue__Group__0_in_ruleParameterTableValue1055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_entryRuleCall1082 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCall1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__0_in_ruleCall1115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_entryRuleSuite1142 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuite1149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group__0_in_ruleSuite1175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteParameter_in_entryRuleSuiteParameter1202 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteParameter1209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__0_in_ruleSuiteParameter1235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter1262 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter1269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__0_in_ruleParameter1295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterName_in_entryRuleParameterName1322 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterName1329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterName__Alternatives_in_ruleParameterName1355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedParameterName_in_entryRuleFixedParameterName1382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFixedParameterName1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FixedParameterName__AnnotationAssignment_in_ruleFixedParameterName1415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterName_in_entryRuleArbitraryParameterName1442 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArbitraryParameterName1449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArbitraryParameterName__Group__0_in_ruleArbitraryParameterName1475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_entryRuleValueOrEnumValue1502 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueOrEnumValue1509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueOrEnumValue__Alternatives_in_ruleValueOrEnumValue1535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue1562 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue1569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Alternatives_in_ruleValue1595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerValue_in_entryRuleIntegerValue1622 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerValue1629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntegerValue__IntegerValueAssignment_in_ruleIntegerValue1655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalValue_in_entryRuleDecimalValue1682 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalValue1689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalValue__DecimalValueAssignment_in_ruleDecimalValue1715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringValue_in_entryRuleStringValue1742 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringValue1749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringValue__StringValueAssignment_in_ruleStringValue1775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable1802 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable1809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__NameAssignment_in_ruleVariable1835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumValue_in_entryRuleEnumValue1862 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumValue1869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumValue__EnumValueAssignment_in_ruleEnumValue1895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodReference_in_entryRuleMethodReference1922 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodReference1929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__0_in_ruleMethodReference1955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1982 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName1989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName2015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_entryRuleQualifiedJavaClassName2042 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedJavaClassName2049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__0_in_ruleQualifiedJavaClassName2075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard2102 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard2109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__0_in_ruleQualifiedNameWithWildcard2135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDefinition_in_rule__Statement__Alternatives2171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__Statement__Alternatives2188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_rule__Statement__Alternatives2205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__PackageStatement__Alternatives2237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestDefinition_in_rule__PackageStatement__Alternatives2254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallDefinition_in_rule__PackageStatement__Alternatives2271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteDefinition_in_rule__PackageStatement__Alternatives2288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_rule__PackageStatement__Alternatives2305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteStatementWithResult_in_rule__SuiteStatement__Alternatives2337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_rule__SuiteStatement__Alternatives2354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_rule__SuiteStatement__Alternatives2371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_rule__SuiteStatementWithResult__Alternatives2403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTest_in_rule__SuiteStatementWithResult__Alternatives2420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTableTest_in_rule__SuiteStatementWithResult__Alternatives2437 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group_4_0__0_in_rule__TableTest__Alternatives_42469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__TableTest__Alternatives_42488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group_2_0__0_in_rule__TableTestRow__Alternatives_22522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__TableTestRow__Alternatives_22541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedParameterName_in_rule__ParameterName__Alternatives2575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterName_in_rule__ParameterName__Alternatives2592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__ValueOrEnumValue__Alternatives2624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumValue_in_rule__ValueOrEnumValue__Alternatives2641 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringValue_in_rule__Value__Alternatives2673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerValue_in_rule__Value__Alternatives2690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalValue_in_rule__Value__Alternatives2707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__Value__Alternatives2724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__0__Impl_in_rule__PackageDefinition__Group__02754 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__1_in_rule__PackageDefinition__Group__02757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__PackageDefinition__Group__0__Impl2785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__1__Impl_in_rule__PackageDefinition__Group__12816 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__2_in_rule__PackageDefinition__Group__12819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__NameAssignment_1_in_rule__PackageDefinition__Group__1__Impl2846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__2__Impl_in_rule__PackageDefinition__Group__22876 = new BitSet(new long[]{0x0000000004370000L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__3_in_rule__PackageDefinition__Group__22879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__PackageDefinition__Group__2__Impl2907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__3__Impl_in_rule__PackageDefinition__Group__32938 = new BitSet(new long[]{0x0000000004370000L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__4_in_rule__PackageDefinition__Group__32941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__StatementsAssignment_3_in_rule__PackageDefinition__Group__3__Impl2968 = new BitSet(new long[]{0x0000000004360002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__4__Impl_in_rule__PackageDefinition__Group__42999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__PackageDefinition__Group__4__Impl3027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__03068 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__03071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Import__Group__0__Impl3099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__13130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl3157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__0__Impl_in_rule__TestDefinition__Group__03191 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__1_in_rule__TestDefinition__Group__03194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__TestDefinition__Group__0__Impl3222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__1__Impl_in_rule__TestDefinition__Group__13253 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__2_in_rule__TestDefinition__Group__13256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__NameAssignment_1_in_rule__TestDefinition__Group__1__Impl3283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__2__Impl_in_rule__TestDefinition__Group__23313 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__3_in_rule__TestDefinition__Group__23316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__TestDefinition__Group__2__Impl3344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__3__Impl_in_rule__TestDefinition__Group__33375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__FixtureMethodAssignment_3_in_rule__TestDefinition__Group__3__Impl3402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__0__Impl_in_rule__CallDefinition__Group__03440 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__1_in_rule__CallDefinition__Group__03443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__CallDefinition__Group__0__Impl3471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__1__Impl_in_rule__CallDefinition__Group__13502 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__2_in_rule__CallDefinition__Group__13505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__NameAssignment_1_in_rule__CallDefinition__Group__1__Impl3532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__2__Impl_in_rule__CallDefinition__Group__23562 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__3_in_rule__CallDefinition__Group__23565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__CallDefinition__Group__2__Impl3593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__3__Impl_in_rule__CallDefinition__Group__33624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__FixtureMethodAssignment_3_in_rule__CallDefinition__Group__3__Impl3651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__0__Impl_in_rule__SuiteDefinition__Group__03689 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__1_in_rule__SuiteDefinition__Group__03692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__SuiteDefinition__Group__0__Impl3720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__1__Impl_in_rule__SuiteDefinition__Group__13751 = new BitSet(new long[]{0x0000000001808000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__2_in_rule__SuiteDefinition__Group__13754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__NameAssignment_1_in_rule__SuiteDefinition__Group__1__Impl3781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__2__Impl_in_rule__SuiteDefinition__Group__23811 = new BitSet(new long[]{0x0000000001808000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__3_in_rule__SuiteDefinition__Group__23814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_2__0_in_rule__SuiteDefinition__Group__2__Impl3841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__3__Impl_in_rule__SuiteDefinition__Group__33872 = new BitSet(new long[]{0x0000000001808000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__4_in_rule__SuiteDefinition__Group__33875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_3__0_in_rule__SuiteDefinition__Group__3__Impl3902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__4__Impl_in_rule__SuiteDefinition__Group__43933 = new BitSet(new long[]{0x00000002D4764000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__5_in_rule__SuiteDefinition__Group__43936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__SuiteDefinition__Group__4__Impl3964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__5__Impl_in_rule__SuiteDefinition__Group__53995 = new BitSet(new long[]{0x00000002D4764000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__6_in_rule__SuiteDefinition__Group__53998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__StatementsAssignment_5_in_rule__SuiteDefinition__Group__5__Impl4025 = new BitSet(new long[]{0x00000002D4364002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__6__Impl_in_rule__SuiteDefinition__Group__64056 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__7_in_rule__SuiteDefinition__Group__64059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__SuiteDefinition__Group__6__Impl4087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__7__Impl_in_rule__SuiteDefinition__Group__74118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_7__0_in_rule__SuiteDefinition__Group__7__Impl4145 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_2__0__Impl_in_rule__SuiteDefinition__Group_2__04192 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_2__1_in_rule__SuiteDefinition__Group_2__04195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__SuiteDefinition__Group_2__0__Impl4223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_2__1__Impl_in_rule__SuiteDefinition__Group_2__14254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__ParametersAssignment_2_1_in_rule__SuiteDefinition__Group_2__1__Impl4281 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_3__0__Impl_in_rule__SuiteDefinition__Group_3__04316 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_3__1_in_rule__SuiteDefinition__Group_3__04319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__SuiteDefinition__Group_3__0__Impl4347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_3__1__Impl_in_rule__SuiteDefinition__Group_3__14378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__DependenciesAssignment_3_1_in_rule__SuiteDefinition__Group_3__1__Impl4405 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_7__0__Impl_in_rule__SuiteDefinition__Group_7__04440 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_7__1_in_rule__SuiteDefinition__Group_7__04443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__SuiteDefinition__Group_7__0__Impl4471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_7__1__Impl_in_rule__SuiteDefinition__Group_7__14502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__FinalizersAssignment_7_1_in_rule__SuiteDefinition__Group_7__1__Impl4529 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__0__Impl_in_rule__VariableDefinition__Group__04564 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__1_in_rule__VariableDefinition__Group__04567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__VariableDefinition__Group__0__Impl4595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__1__Impl_in_rule__VariableDefinition__Group__14626 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__2_in_rule__VariableDefinition__Group__14629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__NameAssignment_1_in_rule__VariableDefinition__Group__1__Impl4656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__2__Impl_in_rule__VariableDefinition__Group__24686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group_2__0_in_rule__VariableDefinition__Group__2__Impl4713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group_2__0__Impl_in_rule__VariableDefinition__Group_2__04750 = new BitSet(new long[]{0x00000000000001D0L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group_2__1_in_rule__VariableDefinition__Group_2__04753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__VariableDefinition__Group_2__0__Impl4781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group_2__1__Impl_in_rule__VariableDefinition__Group_2__14812 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__InitialValueAssignment_2_1_in_rule__VariableDefinition__Group_2__1__Impl4839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group__0__Impl_in_rule__Test__Group__04873 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Test__Group__1_in_rule__Test__Group__04876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Test__Group__0__Impl4904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group__1__Impl_in_rule__Test__Group__14935 = new BitSet(new long[]{0x0000000820000010L});
    public static final BitSet FOLLOW_rule__Test__Group__2_in_rule__Test__Group__14938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__DefinitionAssignment_1_in_rule__Test__Group__1__Impl4965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group__2__Impl_in_rule__Test__Group__24995 = new BitSet(new long[]{0x0000000820000010L});
    public static final BitSet FOLLOW_rule__Test__Group__3_in_rule__Test__Group__24998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__ParametersAssignment_2_in_rule__Test__Group__2__Impl5025 = new BitSet(new long[]{0x0000000800000012L});
    public static final BitSet FOLLOW_rule__Test__Group__3__Impl_in_rule__Test__Group__35056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group_3__0_in_rule__Test__Group__3__Impl5083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group_3__0__Impl_in_rule__Test__Group_3__05122 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__Test__Group_3__1_in_rule__Test__Group_3__05125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Test__Group_3__0__Impl5153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group_3__1__Impl_in_rule__Test__Group_3__15184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__ResultAssignment_3_1_in_rule__Test__Group_3__1__Impl5211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group__0__Impl_in_rule__TableTest__Group__05245 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TableTest__Group__1_in_rule__TableTest__Group__05248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__TableTest__Group__0__Impl5276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group__1__Impl_in_rule__TableTest__Group__15307 = new BitSet(new long[]{0x0000000800002010L});
    public static final BitSet FOLLOW_rule__TableTest__Group__2_in_rule__TableTest__Group__15310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__DefinitionAssignment_1_in_rule__TableTest__Group__1__Impl5337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group__2__Impl_in_rule__TableTest__Group__25367 = new BitSet(new long[]{0x0000000800002010L});
    public static final BitSet FOLLOW_rule__TableTest__Group__3_in_rule__TableTest__Group__25370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__ParametersAssignment_2_in_rule__TableTest__Group__2__Impl5397 = new BitSet(new long[]{0x0000000800000012L});
    public static final BitSet FOLLOW_rule__TableTest__Group__3__Impl_in_rule__TableTest__Group__35428 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__TableTest__Group__4_in_rule__TableTest__Group__35431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__HeadersAssignment_3_in_rule__TableTest__Group__3__Impl5460 = new BitSet(new long[]{0x0000000800002012L});
    public static final BitSet FOLLOW_rule__TableTest__HeadersAssignment_3_in_rule__TableTest__Group__3__Impl5472 = new BitSet(new long[]{0x0000000800002012L});
    public static final BitSet FOLLOW_rule__TableTest__Group__4__Impl_in_rule__TableTest__Group__45505 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__TableTest__Group__5_in_rule__TableTest__Group__45508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Alternatives_4_in_rule__TableTest__Group__4__Impl5535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group__5__Impl_in_rule__TableTest__Group__55565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__RowsAssignment_5_in_rule__TableTest__Group__5__Impl5594 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_rule__TableTest__RowsAssignment_5_in_rule__TableTest__Group__5__Impl5606 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_rule__TableTest__Group_4_0__0__Impl_in_rule__TableTest__Group_4_0__05651 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__TableTest__Group_4_0__1_in_rule__TableTest__Group_4_0__05654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__TableTest__Group_4_0__0__Impl5682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group_4_0__1__Impl_in_rule__TableTest__Group_4_0__15713 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__TableTest__Group_4_0__2_in_rule__TableTest__Group_4_0__15716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__TableTest__Group_4_0__1__Impl5744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group_4_0__2__Impl_in_rule__TableTest__Group_4_0__25775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__TableTest__Group_4_0__2__Impl5803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group__0__Impl_in_rule__TableTestRow__Group__05840 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group__1_in_rule__TableTestRow__Group__05843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group__1__Impl_in_rule__TableTestRow__Group__15901 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group__2_in_rule__TableTestRow__Group__15904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__ValuesAssignment_1_in_rule__TableTestRow__Group__1__Impl5931 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group__2__Impl_in_rule__TableTestRow__Group__25962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Alternatives_2_in_rule__TableTestRow__Group__2__Impl5989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group_2_0__0__Impl_in_rule__TableTestRow__Group_2_0__06025 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group_2_0__1_in_rule__TableTestRow__Group_2_0__06028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__TableTestRow__Group_2_0__0__Impl6056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group_2_0__1__Impl_in_rule__TableTestRow__Group_2_0__16087 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group_2_0__2_in_rule__TableTestRow__Group_2_0__16090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__TableTestRow__Group_2_0__1__Impl6118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group_2_0__2__Impl_in_rule__TableTestRow__Group_2_0__26149 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group_2_0__3_in_rule__TableTestRow__Group_2_0__26152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__ResultAssignment_2_0_2_in_rule__TableTestRow__Group_2_0__2__Impl6179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group_2_0__3__Impl_in_rule__TableTestRow__Group_2_0__36209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__TableTestRow__Group_2_0__3__Impl6237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableHeader__Group__0__Impl_in_rule__ParameterTableHeader__Group__06276 = new BitSet(new long[]{0x0000000800000010L});
    public static final BitSet FOLLOW_rule__ParameterTableHeader__Group__1_in_rule__ParameterTableHeader__Group__06279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__ParameterTableHeader__Group__0__Impl6307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableHeader__Group__1__Impl_in_rule__ParameterTableHeader__Group__16338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableHeader__NameAssignment_1_in_rule__ParameterTableHeader__Group__1__Impl6365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableValue__Group__0__Impl_in_rule__ParameterTableValue__Group__06399 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__ParameterTableValue__Group__1_in_rule__ParameterTableValue__Group__06402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__ParameterTableValue__Group__0__Impl6430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableValue__Group__1__Impl_in_rule__ParameterTableValue__Group__16461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableValue__ValueAssignment_1_in_rule__ParameterTableValue__Group__1__Impl6488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__0__Impl_in_rule__Call__Group__06522 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Call__Group__1_in_rule__Call__Group__06525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Call__Group__0__Impl6553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__1__Impl_in_rule__Call__Group__16584 = new BitSet(new long[]{0x0000000900000010L});
    public static final BitSet FOLLOW_rule__Call__Group__2_in_rule__Call__Group__16587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__DefinitionAssignment_1_in_rule__Call__Group__1__Impl6614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__2__Impl_in_rule__Call__Group__26644 = new BitSet(new long[]{0x0000000900000010L});
    public static final BitSet FOLLOW_rule__Call__Group__3_in_rule__Call__Group__26647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__ParametersAssignment_2_in_rule__Call__Group__2__Impl6674 = new BitSet(new long[]{0x0000000800000012L});
    public static final BitSet FOLLOW_rule__Call__Group__3__Impl_in_rule__Call__Group__36705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group_3__0_in_rule__Call__Group__3__Impl6732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group_3__0__Impl_in_rule__Call__Group_3__06771 = new BitSet(new long[]{0x00000000000001D0L});
    public static final BitSet FOLLOW_rule__Call__Group_3__1_in_rule__Call__Group_3__06774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Call__Group_3__0__Impl6802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group_3__1__Impl_in_rule__Call__Group_3__16833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__ResultAssignment_3_1_in_rule__Call__Group_3__1__Impl6860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group__0__Impl_in_rule__Suite__Group__06894 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Suite__Group__1_in_rule__Suite__Group__06897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Suite__Group__0__Impl6925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group__1__Impl_in_rule__Suite__Group__16956 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Suite__Group__2_in_rule__Suite__Group__16959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__DefinitionAssignment_1_in_rule__Suite__Group__1__Impl6986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group__2__Impl_in_rule__Suite__Group__27016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__ParametersAssignment_2_in_rule__Suite__Group__2__Impl7043 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__0__Impl_in_rule__SuiteParameter__Group__07080 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__1_in_rule__SuiteParameter__Group__07083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__NameAssignment_0_in_rule__SuiteParameter__Group__0__Impl7110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__1__Impl_in_rule__SuiteParameter__Group__17140 = new BitSet(new long[]{0x00000000000001D0L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__2_in_rule__SuiteParameter__Group__17143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__SuiteParameter__Group__1__Impl7171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__2__Impl_in_rule__SuiteParameter__Group__27202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__ValueAssignment_2_in_rule__SuiteParameter__Group__2__Impl7229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__07265 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__07268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__NameAssignment_0_in_rule__Parameter__Group__0__Impl7295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__17325 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__Parameter__Group__2_in_rule__Parameter__Group__17328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Parameter__Group__1__Impl7356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__2__Impl_in_rule__Parameter__Group__27387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__ValueAssignment_2_in_rule__Parameter__Group__2__Impl7414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArbitraryParameterName__Group__0__Impl_in_rule__ArbitraryParameterName__Group__07450 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ArbitraryParameterName__Group__1_in_rule__ArbitraryParameterName__Group__07453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ArbitraryParameterName__Group__0__Impl7481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArbitraryParameterName__Group__1__Impl_in_rule__ArbitraryParameterName__Group__17512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArbitraryParameterName__IdentifierAssignment_1_in_rule__ArbitraryParameterName__Group__1__Impl7539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__0__Impl_in_rule__MethodReference__Group__07573 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__1_in_rule__MethodReference__Group__07576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__TypeAssignment_0_in_rule__MethodReference__Group__0__Impl7603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__1__Impl_in_rule__MethodReference__Group__17633 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__2_in_rule__MethodReference__Group__17636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__MethodReference__Group__1__Impl7664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__2__Impl_in_rule__MethodReference__Group__27695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__MethodAssignment_2_in_rule__MethodReference__Group__2__Impl7722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__07758 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__07761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl7788 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__17817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl7844 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__07879 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__07882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__QualifiedName__Group_1__0__Impl7910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__17941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl7968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__0__Impl_in_rule__QualifiedJavaClassName__Group__08001 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__1_in_rule__QualifiedJavaClassName__Group__08004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedJavaClassName__Group__0__Impl8031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__1__Impl_in_rule__QualifiedJavaClassName__Group__18060 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__2_in_rule__QualifiedJavaClassName__Group__18063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__QualifiedJavaClassName__Group__1__Impl8091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__2__Impl_in_rule__QualifiedJavaClassName__Group__28122 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UPPERCASE_ID_in_rule__QualifiedJavaClassName__Group__2__Impl8149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__0__Impl_in_rule__QualifiedNameWithWildcard__Group__08184 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__1_in_rule__QualifiedNameWithWildcard__Group__08187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildcard__Group__0__Impl8214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__1__Impl_in_rule__QualifiedNameWithWildcard__Group__18243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__QualifiedNameWithWildcard__Group__1__Impl8272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_rule__Model__StatementsAssignment8314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__PackageDefinition__NameAssignment_18345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageStatement_in_rule__PackageDefinition__StatementsAssignment_38376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_rule__Import__ImportedNamespaceAssignment_18407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__TestDefinition__NameAssignment_18438 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodReference_in_rule__TestDefinition__FixtureMethodAssignment_38469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__CallDefinition__NameAssignment_18500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodReference_in_rule__CallDefinition__FixtureMethodAssignment_38531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__NameAssignment_18562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_rule__SuiteDefinition__ParametersAssignment_2_18593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__DependenciesAssignment_3_18628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteStatement_in_rule__SuiteDefinition__StatementsAssignment_58663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__FinalizersAssignment_7_18698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_rule__VariableDefinition__NameAssignment_18733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__VariableDefinition__InitialValueAssignment_2_18764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__VariableEntity__NameAssignment8795 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Test__DefinitionAssignment_18830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_rule__Test__ParametersAssignment_28865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_rule__Test__ResultAssignment_3_18896 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__TableTest__DefinitionAssignment_18931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_rule__TableTest__ParametersAssignment_28966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableHeader_in_rule__TableTest__HeadersAssignment_38997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTableTestRow_in_rule__TableTest__RowsAssignment_59028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableValue_in_rule__TableTestRow__ValuesAssignment_19059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_rule__TableTestRow__ResultAssignment_2_0_29090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterName_in_rule__ParameterTableHeader__NameAssignment_19121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_rule__ParameterTableValue__ValueAssignment_19152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Call__DefinitionAssignment_19187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_rule__Call__ParametersAssignment_29222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__Call__ResultAssignment_3_19253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Suite__DefinitionAssignment_19288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteParameter_in_rule__Suite__ParametersAssignment_29323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__SuiteParameter__NameAssignment_09358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__SuiteParameter__ValueAssignment_29393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterName_in_rule__Parameter__NameAssignment_09424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_rule__Parameter__ValueAssignment_29455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FixedParameterName__AnnotationAssignment9490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ArbitraryParameterName__IdentifierAssignment_19525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_rule__IntegerValue__IntegerValueAssignment9556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DECIMAL_in_rule__DecimalValue__DecimalValueAssignment9587 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringValue__StringValueAssignment9618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Variable__NameAssignment9653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UPPERCASE_ID_in_rule__EnumValue__EnumValueAssignment9692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_rule__MethodReference__TypeAssignment_09731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__MethodReference__MethodAssignment_29770 = new BitSet(new long[]{0x0000000000000002L});

}