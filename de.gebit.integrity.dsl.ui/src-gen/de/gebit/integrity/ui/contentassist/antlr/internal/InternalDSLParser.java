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

                if ( (LA1_0==14||LA1_0==17||LA1_0==33) ) {
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


    // $ANTLR start "entryRulePackageDefinition"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:116:1: entryRulePackageDefinition : rulePackageDefinition EOF ;
    public final void entryRulePackageDefinition() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:117:1: ( rulePackageDefinition EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:118:1: rulePackageDefinition EOF
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:125:1: rulePackageDefinition : ( ( rule__PackageDefinition__Group__0 ) ) ;
    public final void rulePackageDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:129:2: ( ( ( rule__PackageDefinition__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:130:1: ( ( rule__PackageDefinition__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:130:1: ( ( rule__PackageDefinition__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:131:1: ( rule__PackageDefinition__Group__0 )
            {
             before(grammarAccess.getPackageDefinitionAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:132:1: ( rule__PackageDefinition__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:132:2: rule__PackageDefinition__Group__0
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:144:1: entryRulePackageStatement : rulePackageStatement EOF ;
    public final void entryRulePackageStatement() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:145:1: ( rulePackageStatement EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:146:1: rulePackageStatement EOF
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:153:1: rulePackageStatement : ( ( rule__PackageStatement__Alternatives ) ) ;
    public final void rulePackageStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:157:2: ( ( ( rule__PackageStatement__Alternatives ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:158:1: ( ( rule__PackageStatement__Alternatives ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:158:1: ( ( rule__PackageStatement__Alternatives ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:159:1: ( rule__PackageStatement__Alternatives )
            {
             before(grammarAccess.getPackageStatementAccess().getAlternatives()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:160:1: ( rule__PackageStatement__Alternatives )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:160:2: rule__PackageStatement__Alternatives
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:172:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:173:1: ( ruleImport EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:174:1: ruleImport EOF
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:181:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:185:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:186:1: ( ( rule__Import__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:186:1: ( ( rule__Import__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:187:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:188:1: ( rule__Import__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:188:2: rule__Import__Group__0
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:200:1: entryRuleTestDefinition : ruleTestDefinition EOF ;
    public final void entryRuleTestDefinition() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:201:1: ( ruleTestDefinition EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:202:1: ruleTestDefinition EOF
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:209:1: ruleTestDefinition : ( ( rule__TestDefinition__Group__0 ) ) ;
    public final void ruleTestDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:213:2: ( ( ( rule__TestDefinition__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:214:1: ( ( rule__TestDefinition__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:214:1: ( ( rule__TestDefinition__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:215:1: ( rule__TestDefinition__Group__0 )
            {
             before(grammarAccess.getTestDefinitionAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:216:1: ( rule__TestDefinition__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:216:2: rule__TestDefinition__Group__0
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:228:1: entryRuleCallDefinition : ruleCallDefinition EOF ;
    public final void entryRuleCallDefinition() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:229:1: ( ruleCallDefinition EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:230:1: ruleCallDefinition EOF
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:237:1: ruleCallDefinition : ( ( rule__CallDefinition__Group__0 ) ) ;
    public final void ruleCallDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:241:2: ( ( ( rule__CallDefinition__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:242:1: ( ( rule__CallDefinition__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:242:1: ( ( rule__CallDefinition__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:243:1: ( rule__CallDefinition__Group__0 )
            {
             before(grammarAccess.getCallDefinitionAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:244:1: ( rule__CallDefinition__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:244:2: rule__CallDefinition__Group__0
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:256:1: entryRuleSuiteDefinition : ruleSuiteDefinition EOF ;
    public final void entryRuleSuiteDefinition() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:257:1: ( ruleSuiteDefinition EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:258:1: ruleSuiteDefinition EOF
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:265:1: ruleSuiteDefinition : ( ( rule__SuiteDefinition__Group__0 ) ) ;
    public final void ruleSuiteDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:269:2: ( ( ( rule__SuiteDefinition__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:270:1: ( ( rule__SuiteDefinition__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:270:1: ( ( rule__SuiteDefinition__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:271:1: ( rule__SuiteDefinition__Group__0 )
            {
             before(grammarAccess.getSuiteDefinitionAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:272:1: ( rule__SuiteDefinition__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:272:2: rule__SuiteDefinition__Group__0
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:284:1: entryRuleSuiteStatement : ruleSuiteStatement EOF ;
    public final void entryRuleSuiteStatement() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:285:1: ( ruleSuiteStatement EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:286:1: ruleSuiteStatement EOF
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:293:1: ruleSuiteStatement : ( ( rule__SuiteStatement__Alternatives ) ) ;
    public final void ruleSuiteStatement() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:297:2: ( ( ( rule__SuiteStatement__Alternatives ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:298:1: ( ( rule__SuiteStatement__Alternatives ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:298:1: ( ( rule__SuiteStatement__Alternatives ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:299:1: ( rule__SuiteStatement__Alternatives )
            {
             before(grammarAccess.getSuiteStatementAccess().getAlternatives()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:300:1: ( rule__SuiteStatement__Alternatives )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:300:2: rule__SuiteStatement__Alternatives
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:312:1: entryRuleSuiteStatementWithResult : ruleSuiteStatementWithResult EOF ;
    public final void entryRuleSuiteStatementWithResult() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:313:1: ( ruleSuiteStatementWithResult EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:314:1: ruleSuiteStatementWithResult EOF
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:321:1: ruleSuiteStatementWithResult : ( ( rule__SuiteStatementWithResult__Alternatives ) ) ;
    public final void ruleSuiteStatementWithResult() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:325:2: ( ( ( rule__SuiteStatementWithResult__Alternatives ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:326:1: ( ( rule__SuiteStatementWithResult__Alternatives ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:326:1: ( ( rule__SuiteStatementWithResult__Alternatives ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:327:1: ( rule__SuiteStatementWithResult__Alternatives )
            {
             before(grammarAccess.getSuiteStatementWithResultAccess().getAlternatives()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:328:1: ( rule__SuiteStatementWithResult__Alternatives )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:328:2: rule__SuiteStatementWithResult__Alternatives
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:340:1: entryRuleVariableDefinition : ruleVariableDefinition EOF ;
    public final void entryRuleVariableDefinition() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:341:1: ( ruleVariableDefinition EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:342:1: ruleVariableDefinition EOF
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:349:1: ruleVariableDefinition : ( ( rule__VariableDefinition__Group__0 ) ) ;
    public final void ruleVariableDefinition() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:353:2: ( ( ( rule__VariableDefinition__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:354:1: ( ( rule__VariableDefinition__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:354:1: ( ( rule__VariableDefinition__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:355:1: ( rule__VariableDefinition__Group__0 )
            {
             before(grammarAccess.getVariableDefinitionAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:356:1: ( rule__VariableDefinition__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:356:2: rule__VariableDefinition__Group__0
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:368:1: entryRuleVariableEntity : ruleVariableEntity EOF ;
    public final void entryRuleVariableEntity() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:369:1: ( ruleVariableEntity EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:370:1: ruleVariableEntity EOF
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:377:1: ruleVariableEntity : ( ( rule__VariableEntity__NameAssignment ) ) ;
    public final void ruleVariableEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:381:2: ( ( ( rule__VariableEntity__NameAssignment ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:382:1: ( ( rule__VariableEntity__NameAssignment ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:382:1: ( ( rule__VariableEntity__NameAssignment ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:383:1: ( rule__VariableEntity__NameAssignment )
            {
             before(grammarAccess.getVariableEntityAccess().getNameAssignment()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:384:1: ( rule__VariableEntity__NameAssignment )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:384:2: rule__VariableEntity__NameAssignment
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:396:1: entryRuleTest : ruleTest EOF ;
    public final void entryRuleTest() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:397:1: ( ruleTest EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:398:1: ruleTest EOF
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:405:1: ruleTest : ( ( rule__Test__Group__0 ) ) ;
    public final void ruleTest() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:409:2: ( ( ( rule__Test__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:410:1: ( ( rule__Test__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:410:1: ( ( rule__Test__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:411:1: ( rule__Test__Group__0 )
            {
             before(grammarAccess.getTestAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:412:1: ( rule__Test__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:412:2: rule__Test__Group__0
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:424:1: entryRuleTableTest : ruleTableTest EOF ;
    public final void entryRuleTableTest() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:425:1: ( ruleTableTest EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:426:1: ruleTableTest EOF
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:433:1: ruleTableTest : ( ( rule__TableTest__Group__0 ) ) ;
    public final void ruleTableTest() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:437:2: ( ( ( rule__TableTest__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:438:1: ( ( rule__TableTest__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:438:1: ( ( rule__TableTest__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:439:1: ( rule__TableTest__Group__0 )
            {
             before(grammarAccess.getTableTestAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:440:1: ( rule__TableTest__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:440:2: rule__TableTest__Group__0
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:452:1: entryRuleTableTestRow : ruleTableTestRow EOF ;
    public final void entryRuleTableTestRow() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:453:1: ( ruleTableTestRow EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:454:1: ruleTableTestRow EOF
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:461:1: ruleTableTestRow : ( ( rule__TableTestRow__Group__0 ) ) ;
    public final void ruleTableTestRow() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:465:2: ( ( ( rule__TableTestRow__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:466:1: ( ( rule__TableTestRow__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:466:1: ( ( rule__TableTestRow__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:467:1: ( rule__TableTestRow__Group__0 )
            {
             before(grammarAccess.getTableTestRowAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:468:1: ( rule__TableTestRow__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:468:2: rule__TableTestRow__Group__0
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:480:1: entryRuleParameterTableHeader : ruleParameterTableHeader EOF ;
    public final void entryRuleParameterTableHeader() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:481:1: ( ruleParameterTableHeader EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:482:1: ruleParameterTableHeader EOF
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:489:1: ruleParameterTableHeader : ( ( rule__ParameterTableHeader__Group__0 ) ) ;
    public final void ruleParameterTableHeader() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:493:2: ( ( ( rule__ParameterTableHeader__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:494:1: ( ( rule__ParameterTableHeader__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:494:1: ( ( rule__ParameterTableHeader__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:495:1: ( rule__ParameterTableHeader__Group__0 )
            {
             before(grammarAccess.getParameterTableHeaderAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:496:1: ( rule__ParameterTableHeader__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:496:2: rule__ParameterTableHeader__Group__0
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


    // $ANTLR start "entryRuleResultTableHeader"
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:508:1: entryRuleResultTableHeader : ruleResultTableHeader EOF ;
    public final void entryRuleResultTableHeader() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:509:1: ( ruleResultTableHeader EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:510:1: ruleResultTableHeader EOF
            {
             before(grammarAccess.getResultTableHeaderRule()); 
            pushFollow(FOLLOW_ruleResultTableHeader_in_entryRuleResultTableHeader1022);
            ruleResultTableHeader();

            state._fsp--;

             after(grammarAccess.getResultTableHeaderRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultTableHeader1029); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:517:1: ruleResultTableHeader : ( ( rule__ResultTableHeader__Group__0 ) ) ;
    public final void ruleResultTableHeader() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:521:2: ( ( ( rule__ResultTableHeader__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:522:1: ( ( rule__ResultTableHeader__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:522:1: ( ( rule__ResultTableHeader__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:523:1: ( rule__ResultTableHeader__Group__0 )
            {
             before(grammarAccess.getResultTableHeaderAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:524:1: ( rule__ResultTableHeader__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:524:2: rule__ResultTableHeader__Group__0
            {
            pushFollow(FOLLOW_rule__ResultTableHeader__Group__0_in_ruleResultTableHeader1055);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:536:1: entryRuleParameterTableValue : ruleParameterTableValue EOF ;
    public final void entryRuleParameterTableValue() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:537:1: ( ruleParameterTableValue EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:538:1: ruleParameterTableValue EOF
            {
             before(grammarAccess.getParameterTableValueRule()); 
            pushFollow(FOLLOW_ruleParameterTableValue_in_entryRuleParameterTableValue1082);
            ruleParameterTableValue();

            state._fsp--;

             after(grammarAccess.getParameterTableValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterTableValue1089); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:545:1: ruleParameterTableValue : ( ( rule__ParameterTableValue__Group__0 ) ) ;
    public final void ruleParameterTableValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:549:2: ( ( ( rule__ParameterTableValue__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:550:1: ( ( rule__ParameterTableValue__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:550:1: ( ( rule__ParameterTableValue__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:551:1: ( rule__ParameterTableValue__Group__0 )
            {
             before(grammarAccess.getParameterTableValueAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:552:1: ( rule__ParameterTableValue__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:552:2: rule__ParameterTableValue__Group__0
            {
            pushFollow(FOLLOW_rule__ParameterTableValue__Group__0_in_ruleParameterTableValue1115);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:564:1: entryRuleNamedResult : ruleNamedResult EOF ;
    public final void entryRuleNamedResult() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:565:1: ( ruleNamedResult EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:566:1: ruleNamedResult EOF
            {
             before(grammarAccess.getNamedResultRule()); 
            pushFollow(FOLLOW_ruleNamedResult_in_entryRuleNamedResult1142);
            ruleNamedResult();

            state._fsp--;

             after(grammarAccess.getNamedResultRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedResult1149); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:573:1: ruleNamedResult : ( ( rule__NamedResult__Group__0 ) ) ;
    public final void ruleNamedResult() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:577:2: ( ( ( rule__NamedResult__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:578:1: ( ( rule__NamedResult__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:578:1: ( ( rule__NamedResult__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:579:1: ( rule__NamedResult__Group__0 )
            {
             before(grammarAccess.getNamedResultAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:580:1: ( rule__NamedResult__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:580:2: rule__NamedResult__Group__0
            {
            pushFollow(FOLLOW_rule__NamedResult__Group__0_in_ruleNamedResult1175);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:592:1: entryRuleResultName : ruleResultName EOF ;
    public final void entryRuleResultName() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:593:1: ( ruleResultName EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:594:1: ruleResultName EOF
            {
             before(grammarAccess.getResultNameRule()); 
            pushFollow(FOLLOW_ruleResultName_in_entryRuleResultName1202);
            ruleResultName();

            state._fsp--;

             after(grammarAccess.getResultNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultName1209); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:601:1: ruleResultName : ( ( rule__ResultName__Alternatives ) ) ;
    public final void ruleResultName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:605:2: ( ( ( rule__ResultName__Alternatives ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:606:1: ( ( rule__ResultName__Alternatives ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:606:1: ( ( rule__ResultName__Alternatives ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:607:1: ( rule__ResultName__Alternatives )
            {
             before(grammarAccess.getResultNameAccess().getAlternatives()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:608:1: ( rule__ResultName__Alternatives )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:608:2: rule__ResultName__Alternatives
            {
            pushFollow(FOLLOW_rule__ResultName__Alternatives_in_ruleResultName1235);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:620:1: entryRuleFixedResultName : ruleFixedResultName EOF ;
    public final void entryRuleFixedResultName() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:621:1: ( ruleFixedResultName EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:622:1: ruleFixedResultName EOF
            {
             before(grammarAccess.getFixedResultNameRule()); 
            pushFollow(FOLLOW_ruleFixedResultName_in_entryRuleFixedResultName1262);
            ruleFixedResultName();

            state._fsp--;

             after(grammarAccess.getFixedResultNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFixedResultName1269); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:629:1: ruleFixedResultName : ( ( rule__FixedResultName__FieldAssignment ) ) ;
    public final void ruleFixedResultName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:633:2: ( ( ( rule__FixedResultName__FieldAssignment ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:634:1: ( ( rule__FixedResultName__FieldAssignment ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:634:1: ( ( rule__FixedResultName__FieldAssignment ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:635:1: ( rule__FixedResultName__FieldAssignment )
            {
             before(grammarAccess.getFixedResultNameAccess().getFieldAssignment()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:636:1: ( rule__FixedResultName__FieldAssignment )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:636:2: rule__FixedResultName__FieldAssignment
            {
            pushFollow(FOLLOW_rule__FixedResultName__FieldAssignment_in_ruleFixedResultName1295);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:648:1: entryRuleCall : ruleCall EOF ;
    public final void entryRuleCall() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:649:1: ( ruleCall EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:650:1: ruleCall EOF
            {
             before(grammarAccess.getCallRule()); 
            pushFollow(FOLLOW_ruleCall_in_entryRuleCall1322);
            ruleCall();

            state._fsp--;

             after(grammarAccess.getCallRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCall1329); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:657:1: ruleCall : ( ( rule__Call__Group__0 ) ) ;
    public final void ruleCall() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:661:2: ( ( ( rule__Call__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:662:1: ( ( rule__Call__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:662:1: ( ( rule__Call__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:663:1: ( rule__Call__Group__0 )
            {
             before(grammarAccess.getCallAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:664:1: ( rule__Call__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:664:2: rule__Call__Group__0
            {
            pushFollow(FOLLOW_rule__Call__Group__0_in_ruleCall1355);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:676:1: entryRuleSuite : ruleSuite EOF ;
    public final void entryRuleSuite() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:677:1: ( ruleSuite EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:678:1: ruleSuite EOF
            {
             before(grammarAccess.getSuiteRule()); 
            pushFollow(FOLLOW_ruleSuite_in_entryRuleSuite1382);
            ruleSuite();

            state._fsp--;

             after(grammarAccess.getSuiteRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuite1389); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:685:1: ruleSuite : ( ( rule__Suite__Group__0 ) ) ;
    public final void ruleSuite() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:689:2: ( ( ( rule__Suite__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:690:1: ( ( rule__Suite__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:690:1: ( ( rule__Suite__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:691:1: ( rule__Suite__Group__0 )
            {
             before(grammarAccess.getSuiteAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:692:1: ( rule__Suite__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:692:2: rule__Suite__Group__0
            {
            pushFollow(FOLLOW_rule__Suite__Group__0_in_ruleSuite1415);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:704:1: entryRuleSuiteParameter : ruleSuiteParameter EOF ;
    public final void entryRuleSuiteParameter() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:705:1: ( ruleSuiteParameter EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:706:1: ruleSuiteParameter EOF
            {
             before(grammarAccess.getSuiteParameterRule()); 
            pushFollow(FOLLOW_ruleSuiteParameter_in_entryRuleSuiteParameter1442);
            ruleSuiteParameter();

            state._fsp--;

             after(grammarAccess.getSuiteParameterRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteParameter1449); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:713:1: ruleSuiteParameter : ( ( rule__SuiteParameter__Group__0 ) ) ;
    public final void ruleSuiteParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:717:2: ( ( ( rule__SuiteParameter__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:718:1: ( ( rule__SuiteParameter__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:718:1: ( ( rule__SuiteParameter__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:719:1: ( rule__SuiteParameter__Group__0 )
            {
             before(grammarAccess.getSuiteParameterAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:720:1: ( rule__SuiteParameter__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:720:2: rule__SuiteParameter__Group__0
            {
            pushFollow(FOLLOW_rule__SuiteParameter__Group__0_in_ruleSuiteParameter1475);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:732:1: entryRuleParameter : ruleParameter EOF ;
    public final void entryRuleParameter() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:733:1: ( ruleParameter EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:734:1: ruleParameter EOF
            {
             before(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter1502);
            ruleParameter();

            state._fsp--;

             after(grammarAccess.getParameterRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter1509); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:741:1: ruleParameter : ( ( rule__Parameter__Group__0 ) ) ;
    public final void ruleParameter() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:745:2: ( ( ( rule__Parameter__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:746:1: ( ( rule__Parameter__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:746:1: ( ( rule__Parameter__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:747:1: ( rule__Parameter__Group__0 )
            {
             before(grammarAccess.getParameterAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:748:1: ( rule__Parameter__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:748:2: rule__Parameter__Group__0
            {
            pushFollow(FOLLOW_rule__Parameter__Group__0_in_ruleParameter1535);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:760:1: entryRuleParameterName : ruleParameterName EOF ;
    public final void entryRuleParameterName() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:761:1: ( ruleParameterName EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:762:1: ruleParameterName EOF
            {
             before(grammarAccess.getParameterNameRule()); 
            pushFollow(FOLLOW_ruleParameterName_in_entryRuleParameterName1562);
            ruleParameterName();

            state._fsp--;

             after(grammarAccess.getParameterNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterName1569); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:769:1: ruleParameterName : ( ( rule__ParameterName__Alternatives ) ) ;
    public final void ruleParameterName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:773:2: ( ( ( rule__ParameterName__Alternatives ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:774:1: ( ( rule__ParameterName__Alternatives ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:774:1: ( ( rule__ParameterName__Alternatives ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:775:1: ( rule__ParameterName__Alternatives )
            {
             before(grammarAccess.getParameterNameAccess().getAlternatives()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:776:1: ( rule__ParameterName__Alternatives )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:776:2: rule__ParameterName__Alternatives
            {
            pushFollow(FOLLOW_rule__ParameterName__Alternatives_in_ruleParameterName1595);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:788:1: entryRuleFixedParameterName : ruleFixedParameterName EOF ;
    public final void entryRuleFixedParameterName() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:789:1: ( ruleFixedParameterName EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:790:1: ruleFixedParameterName EOF
            {
             before(grammarAccess.getFixedParameterNameRule()); 
            pushFollow(FOLLOW_ruleFixedParameterName_in_entryRuleFixedParameterName1622);
            ruleFixedParameterName();

            state._fsp--;

             after(grammarAccess.getFixedParameterNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFixedParameterName1629); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:797:1: ruleFixedParameterName : ( ( rule__FixedParameterName__AnnotationAssignment ) ) ;
    public final void ruleFixedParameterName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:801:2: ( ( ( rule__FixedParameterName__AnnotationAssignment ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:802:1: ( ( rule__FixedParameterName__AnnotationAssignment ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:802:1: ( ( rule__FixedParameterName__AnnotationAssignment ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:803:1: ( rule__FixedParameterName__AnnotationAssignment )
            {
             before(grammarAccess.getFixedParameterNameAccess().getAnnotationAssignment()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:804:1: ( rule__FixedParameterName__AnnotationAssignment )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:804:2: rule__FixedParameterName__AnnotationAssignment
            {
            pushFollow(FOLLOW_rule__FixedParameterName__AnnotationAssignment_in_ruleFixedParameterName1655);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:816:1: entryRuleArbitraryParameterOrResultName : ruleArbitraryParameterOrResultName EOF ;
    public final void entryRuleArbitraryParameterOrResultName() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:817:1: ( ruleArbitraryParameterOrResultName EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:818:1: ruleArbitraryParameterOrResultName EOF
            {
             before(grammarAccess.getArbitraryParameterOrResultNameRule()); 
            pushFollow(FOLLOW_ruleArbitraryParameterOrResultName_in_entryRuleArbitraryParameterOrResultName1682);
            ruleArbitraryParameterOrResultName();

            state._fsp--;

             after(grammarAccess.getArbitraryParameterOrResultNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArbitraryParameterOrResultName1689); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:825:1: ruleArbitraryParameterOrResultName : ( ( rule__ArbitraryParameterOrResultName__Group__0 ) ) ;
    public final void ruleArbitraryParameterOrResultName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:829:2: ( ( ( rule__ArbitraryParameterOrResultName__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:830:1: ( ( rule__ArbitraryParameterOrResultName__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:830:1: ( ( rule__ArbitraryParameterOrResultName__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:831:1: ( rule__ArbitraryParameterOrResultName__Group__0 )
            {
             before(grammarAccess.getArbitraryParameterOrResultNameAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:832:1: ( rule__ArbitraryParameterOrResultName__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:832:2: rule__ArbitraryParameterOrResultName__Group__0
            {
            pushFollow(FOLLOW_rule__ArbitraryParameterOrResultName__Group__0_in_ruleArbitraryParameterOrResultName1715);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:844:1: entryRuleValueOrEnumValue : ruleValueOrEnumValue EOF ;
    public final void entryRuleValueOrEnumValue() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:845:1: ( ruleValueOrEnumValue EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:846:1: ruleValueOrEnumValue EOF
            {
             before(grammarAccess.getValueOrEnumValueRule()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_entryRuleValueOrEnumValue1742);
            ruleValueOrEnumValue();

            state._fsp--;

             after(grammarAccess.getValueOrEnumValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueOrEnumValue1749); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:853:1: ruleValueOrEnumValue : ( ( rule__ValueOrEnumValue__Alternatives ) ) ;
    public final void ruleValueOrEnumValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:857:2: ( ( ( rule__ValueOrEnumValue__Alternatives ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:858:1: ( ( rule__ValueOrEnumValue__Alternatives ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:858:1: ( ( rule__ValueOrEnumValue__Alternatives ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:859:1: ( rule__ValueOrEnumValue__Alternatives )
            {
             before(grammarAccess.getValueOrEnumValueAccess().getAlternatives()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:860:1: ( rule__ValueOrEnumValue__Alternatives )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:860:2: rule__ValueOrEnumValue__Alternatives
            {
            pushFollow(FOLLOW_rule__ValueOrEnumValue__Alternatives_in_ruleValueOrEnumValue1775);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:872:1: entryRuleValue : ruleValue EOF ;
    public final void entryRuleValue() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:873:1: ( ruleValue EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:874:1: ruleValue EOF
            {
             before(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue1802);
            ruleValue();

            state._fsp--;

             after(grammarAccess.getValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue1809); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:881:1: ruleValue : ( ( rule__Value__Alternatives ) ) ;
    public final void ruleValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:885:2: ( ( ( rule__Value__Alternatives ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:886:1: ( ( rule__Value__Alternatives ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:886:1: ( ( rule__Value__Alternatives ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:887:1: ( rule__Value__Alternatives )
            {
             before(grammarAccess.getValueAccess().getAlternatives()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:888:1: ( rule__Value__Alternatives )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:888:2: rule__Value__Alternatives
            {
            pushFollow(FOLLOW_rule__Value__Alternatives_in_ruleValue1835);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:900:1: entryRuleIntegerValue : ruleIntegerValue EOF ;
    public final void entryRuleIntegerValue() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:901:1: ( ruleIntegerValue EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:902:1: ruleIntegerValue EOF
            {
             before(grammarAccess.getIntegerValueRule()); 
            pushFollow(FOLLOW_ruleIntegerValue_in_entryRuleIntegerValue1862);
            ruleIntegerValue();

            state._fsp--;

             after(grammarAccess.getIntegerValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerValue1869); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:909:1: ruleIntegerValue : ( ( rule__IntegerValue__IntegerValueAssignment ) ) ;
    public final void ruleIntegerValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:913:2: ( ( ( rule__IntegerValue__IntegerValueAssignment ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:914:1: ( ( rule__IntegerValue__IntegerValueAssignment ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:914:1: ( ( rule__IntegerValue__IntegerValueAssignment ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:915:1: ( rule__IntegerValue__IntegerValueAssignment )
            {
             before(grammarAccess.getIntegerValueAccess().getIntegerValueAssignment()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:916:1: ( rule__IntegerValue__IntegerValueAssignment )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:916:2: rule__IntegerValue__IntegerValueAssignment
            {
            pushFollow(FOLLOW_rule__IntegerValue__IntegerValueAssignment_in_ruleIntegerValue1895);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:928:1: entryRuleDecimalValue : ruleDecimalValue EOF ;
    public final void entryRuleDecimalValue() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:929:1: ( ruleDecimalValue EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:930:1: ruleDecimalValue EOF
            {
             before(grammarAccess.getDecimalValueRule()); 
            pushFollow(FOLLOW_ruleDecimalValue_in_entryRuleDecimalValue1922);
            ruleDecimalValue();

            state._fsp--;

             after(grammarAccess.getDecimalValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalValue1929); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:937:1: ruleDecimalValue : ( ( rule__DecimalValue__DecimalValueAssignment ) ) ;
    public final void ruleDecimalValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:941:2: ( ( ( rule__DecimalValue__DecimalValueAssignment ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:942:1: ( ( rule__DecimalValue__DecimalValueAssignment ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:942:1: ( ( rule__DecimalValue__DecimalValueAssignment ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:943:1: ( rule__DecimalValue__DecimalValueAssignment )
            {
             before(grammarAccess.getDecimalValueAccess().getDecimalValueAssignment()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:944:1: ( rule__DecimalValue__DecimalValueAssignment )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:944:2: rule__DecimalValue__DecimalValueAssignment
            {
            pushFollow(FOLLOW_rule__DecimalValue__DecimalValueAssignment_in_ruleDecimalValue1955);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:956:1: entryRuleStringValue : ruleStringValue EOF ;
    public final void entryRuleStringValue() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:957:1: ( ruleStringValue EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:958:1: ruleStringValue EOF
            {
             before(grammarAccess.getStringValueRule()); 
            pushFollow(FOLLOW_ruleStringValue_in_entryRuleStringValue1982);
            ruleStringValue();

            state._fsp--;

             after(grammarAccess.getStringValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringValue1989); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:965:1: ruleStringValue : ( ( rule__StringValue__StringValueAssignment ) ) ;
    public final void ruleStringValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:969:2: ( ( ( rule__StringValue__StringValueAssignment ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:970:1: ( ( rule__StringValue__StringValueAssignment ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:970:1: ( ( rule__StringValue__StringValueAssignment ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:971:1: ( rule__StringValue__StringValueAssignment )
            {
             before(grammarAccess.getStringValueAccess().getStringValueAssignment()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:972:1: ( rule__StringValue__StringValueAssignment )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:972:2: rule__StringValue__StringValueAssignment
            {
            pushFollow(FOLLOW_rule__StringValue__StringValueAssignment_in_ruleStringValue2015);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:984:1: entryRuleVariable : ruleVariable EOF ;
    public final void entryRuleVariable() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:985:1: ( ruleVariable EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:986:1: ruleVariable EOF
            {
             before(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable2042);
            ruleVariable();

            state._fsp--;

             after(grammarAccess.getVariableRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable2049); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:993:1: ruleVariable : ( ( rule__Variable__NameAssignment ) ) ;
    public final void ruleVariable() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:997:2: ( ( ( rule__Variable__NameAssignment ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:998:1: ( ( rule__Variable__NameAssignment ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:998:1: ( ( rule__Variable__NameAssignment ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:999:1: ( rule__Variable__NameAssignment )
            {
             before(grammarAccess.getVariableAccess().getNameAssignment()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1000:1: ( rule__Variable__NameAssignment )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1000:2: rule__Variable__NameAssignment
            {
            pushFollow(FOLLOW_rule__Variable__NameAssignment_in_ruleVariable2075);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1012:1: entryRuleEnumValue : ruleEnumValue EOF ;
    public final void entryRuleEnumValue() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1013:1: ( ruleEnumValue EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1014:1: ruleEnumValue EOF
            {
             before(grammarAccess.getEnumValueRule()); 
            pushFollow(FOLLOW_ruleEnumValue_in_entryRuleEnumValue2102);
            ruleEnumValue();

            state._fsp--;

             after(grammarAccess.getEnumValueRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumValue2109); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1021:1: ruleEnumValue : ( ( rule__EnumValue__EnumValueAssignment ) ) ;
    public final void ruleEnumValue() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1025:2: ( ( ( rule__EnumValue__EnumValueAssignment ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1026:1: ( ( rule__EnumValue__EnumValueAssignment ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1026:1: ( ( rule__EnumValue__EnumValueAssignment ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1027:1: ( rule__EnumValue__EnumValueAssignment )
            {
             before(grammarAccess.getEnumValueAccess().getEnumValueAssignment()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1028:1: ( rule__EnumValue__EnumValueAssignment )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1028:2: rule__EnumValue__EnumValueAssignment
            {
            pushFollow(FOLLOW_rule__EnumValue__EnumValueAssignment_in_ruleEnumValue2135);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1040:1: entryRuleMethodReference : ruleMethodReference EOF ;
    public final void entryRuleMethodReference() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1041:1: ( ruleMethodReference EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1042:1: ruleMethodReference EOF
            {
             before(grammarAccess.getMethodReferenceRule()); 
            pushFollow(FOLLOW_ruleMethodReference_in_entryRuleMethodReference2162);
            ruleMethodReference();

            state._fsp--;

             after(grammarAccess.getMethodReferenceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodReference2169); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1049:1: ruleMethodReference : ( ( rule__MethodReference__Group__0 ) ) ;
    public final void ruleMethodReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1053:2: ( ( ( rule__MethodReference__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1054:1: ( ( rule__MethodReference__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1054:1: ( ( rule__MethodReference__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1055:1: ( rule__MethodReference__Group__0 )
            {
             before(grammarAccess.getMethodReferenceAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1056:1: ( rule__MethodReference__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1056:2: rule__MethodReference__Group__0
            {
            pushFollow(FOLLOW_rule__MethodReference__Group__0_in_ruleMethodReference2195);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1068:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1069:1: ( ruleQualifiedName EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1070:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2222);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName2229); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1077:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1081:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1082:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1082:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1083:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1084:1: ( rule__QualifiedName__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1084:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName2255);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1096:1: entryRuleQualifiedJavaClassName : ruleQualifiedJavaClassName EOF ;
    public final void entryRuleQualifiedJavaClassName() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1097:1: ( ruleQualifiedJavaClassName EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1098:1: ruleQualifiedJavaClassName EOF
            {
             before(grammarAccess.getQualifiedJavaClassNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_entryRuleQualifiedJavaClassName2282);
            ruleQualifiedJavaClassName();

            state._fsp--;

             after(grammarAccess.getQualifiedJavaClassNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedJavaClassName2289); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1105:1: ruleQualifiedJavaClassName : ( ( rule__QualifiedJavaClassName__Group__0 ) ) ;
    public final void ruleQualifiedJavaClassName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1109:2: ( ( ( rule__QualifiedJavaClassName__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1110:1: ( ( rule__QualifiedJavaClassName__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1110:1: ( ( rule__QualifiedJavaClassName__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1111:1: ( rule__QualifiedJavaClassName__Group__0 )
            {
             before(grammarAccess.getQualifiedJavaClassNameAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1112:1: ( rule__QualifiedJavaClassName__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1112:2: rule__QualifiedJavaClassName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__0_in_ruleQualifiedJavaClassName2315);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1124:1: entryRuleQualifiedNameWithWildcard : ruleQualifiedNameWithWildcard EOF ;
    public final void entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1125:1: ( ruleQualifiedNameWithWildcard EOF )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1126:1: ruleQualifiedNameWithWildcard EOF
            {
             before(grammarAccess.getQualifiedNameWithWildcardRule()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard2342);
            ruleQualifiedNameWithWildcard();

            state._fsp--;

             after(grammarAccess.getQualifiedNameWithWildcardRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard2349); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1133:1: ruleQualifiedNameWithWildcard : ( ( rule__QualifiedNameWithWildcard__Group__0 ) ) ;
    public final void ruleQualifiedNameWithWildcard() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1137:2: ( ( ( rule__QualifiedNameWithWildcard__Group__0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1138:1: ( ( rule__QualifiedNameWithWildcard__Group__0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1138:1: ( ( rule__QualifiedNameWithWildcard__Group__0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1139:1: ( rule__QualifiedNameWithWildcard__Group__0 )
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1140:1: ( rule__QualifiedNameWithWildcard__Group__0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1140:2: rule__QualifiedNameWithWildcard__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__0_in_ruleQualifiedNameWithWildcard2375);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1152:1: rule__Statement__Alternatives : ( ( rulePackageDefinition ) | ( ruleImport ) | ( ruleSuite ) );
    public final void rule__Statement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1156:1: ( ( rulePackageDefinition ) | ( ruleImport ) | ( ruleSuite ) )
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
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1157:1: ( rulePackageDefinition )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1157:1: ( rulePackageDefinition )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1158:1: rulePackageDefinition
                    {
                     before(grammarAccess.getStatementAccess().getPackageDefinitionParserRuleCall_0()); 
                    pushFollow(FOLLOW_rulePackageDefinition_in_rule__Statement__Alternatives2411);
                    rulePackageDefinition();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getPackageDefinitionParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1163:6: ( ruleImport )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1163:6: ( ruleImport )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1164:1: ruleImport
                    {
                     before(grammarAccess.getStatementAccess().getImportParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleImport_in_rule__Statement__Alternatives2428);
                    ruleImport();

                    state._fsp--;

                     after(grammarAccess.getStatementAccess().getImportParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1169:6: ( ruleSuite )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1169:6: ( ruleSuite )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1170:1: ruleSuite
                    {
                     before(grammarAccess.getStatementAccess().getSuiteParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleSuite_in_rule__Statement__Alternatives2445);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1180:1: rule__PackageStatement__Alternatives : ( ( ruleImport ) | ( ruleTestDefinition ) | ( ruleCallDefinition ) | ( ruleSuiteDefinition ) | ( ruleVariableDefinition ) );
    public final void rule__PackageStatement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1184:1: ( ( ruleImport ) | ( ruleTestDefinition ) | ( ruleCallDefinition ) | ( ruleSuiteDefinition ) | ( ruleVariableDefinition ) )
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
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1185:1: ( ruleImport )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1185:1: ( ruleImport )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1186:1: ruleImport
                    {
                     before(grammarAccess.getPackageStatementAccess().getImportParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleImport_in_rule__PackageStatement__Alternatives2477);
                    ruleImport();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getImportParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1191:6: ( ruleTestDefinition )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1191:6: ( ruleTestDefinition )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1192:1: ruleTestDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getTestDefinitionParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleTestDefinition_in_rule__PackageStatement__Alternatives2494);
                    ruleTestDefinition();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getTestDefinitionParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1197:6: ( ruleCallDefinition )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1197:6: ( ruleCallDefinition )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1198:1: ruleCallDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getCallDefinitionParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleCallDefinition_in_rule__PackageStatement__Alternatives2511);
                    ruleCallDefinition();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getCallDefinitionParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1203:6: ( ruleSuiteDefinition )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1203:6: ( ruleSuiteDefinition )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1204:1: ruleSuiteDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getSuiteDefinitionParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleSuiteDefinition_in_rule__PackageStatement__Alternatives2528);
                    ruleSuiteDefinition();

                    state._fsp--;

                     after(grammarAccess.getPackageStatementAccess().getSuiteDefinitionParserRuleCall_3()); 

                    }


                    }
                    break;
                case 5 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1209:6: ( ruleVariableDefinition )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1209:6: ( ruleVariableDefinition )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1210:1: ruleVariableDefinition
                    {
                     before(grammarAccess.getPackageStatementAccess().getVariableDefinitionParserRuleCall_4()); 
                    pushFollow(FOLLOW_ruleVariableDefinition_in_rule__PackageStatement__Alternatives2545);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1220:1: rule__SuiteStatement__Alternatives : ( ( ruleSuiteStatementWithResult ) | ( ruleCall ) | ( ruleVariableDefinition ) );
    public final void rule__SuiteStatement__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1224:1: ( ( ruleSuiteStatementWithResult ) | ( ruleCall ) | ( ruleVariableDefinition ) )
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
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1225:1: ( ruleSuiteStatementWithResult )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1225:1: ( ruleSuiteStatementWithResult )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1226:1: ruleSuiteStatementWithResult
                    {
                     before(grammarAccess.getSuiteStatementAccess().getSuiteStatementWithResultParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSuiteStatementWithResult_in_rule__SuiteStatement__Alternatives2577);
                    ruleSuiteStatementWithResult();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementAccess().getSuiteStatementWithResultParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1231:6: ( ruleCall )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1231:6: ( ruleCall )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1232:1: ruleCall
                    {
                     before(grammarAccess.getSuiteStatementAccess().getCallParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleCall_in_rule__SuiteStatement__Alternatives2594);
                    ruleCall();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementAccess().getCallParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1237:6: ( ruleVariableDefinition )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1237:6: ( ruleVariableDefinition )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1238:1: ruleVariableDefinition
                    {
                     before(grammarAccess.getSuiteStatementAccess().getVariableDefinitionParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleVariableDefinition_in_rule__SuiteStatement__Alternatives2611);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1248:1: rule__SuiteStatementWithResult__Alternatives : ( ( ruleSuite ) | ( ruleTest ) | ( ruleTableTest ) );
    public final void rule__SuiteStatementWithResult__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1252:1: ( ( ruleSuite ) | ( ruleTest ) | ( ruleTableTest ) )
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
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1253:1: ( ruleSuite )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1253:1: ( ruleSuite )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1254:1: ruleSuite
                    {
                     before(grammarAccess.getSuiteStatementWithResultAccess().getSuiteParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSuite_in_rule__SuiteStatementWithResult__Alternatives2643);
                    ruleSuite();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementWithResultAccess().getSuiteParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1259:6: ( ruleTest )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1259:6: ( ruleTest )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1260:1: ruleTest
                    {
                     before(grammarAccess.getSuiteStatementWithResultAccess().getTestParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleTest_in_rule__SuiteStatementWithResult__Alternatives2660);
                    ruleTest();

                    state._fsp--;

                     after(grammarAccess.getSuiteStatementWithResultAccess().getTestParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1265:6: ( ruleTableTest )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1265:6: ( ruleTableTest )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1266:1: ruleTableTest
                    {
                     before(grammarAccess.getSuiteStatementWithResultAccess().getTableTestParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleTableTest_in_rule__SuiteStatementWithResult__Alternatives2677);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1276:1: rule__TableTest__Alternatives_5 : ( ( ( rule__TableTest__Group_5_0__0 ) ) | ( '|' ) );
    public final void rule__TableTest__Alternatives_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1280:1: ( ( ( rule__TableTest__Group_5_0__0 ) ) | ( '|' ) )
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
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1281:1: ( ( rule__TableTest__Group_5_0__0 ) )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1281:1: ( ( rule__TableTest__Group_5_0__0 ) )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1282:1: ( rule__TableTest__Group_5_0__0 )
                    {
                     before(grammarAccess.getTableTestAccess().getGroup_5_0()); 
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1283:1: ( rule__TableTest__Group_5_0__0 )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1283:2: rule__TableTest__Group_5_0__0
                    {
                    pushFollow(FOLLOW_rule__TableTest__Group_5_0__0_in_rule__TableTest__Alternatives_52709);
                    rule__TableTest__Group_5_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTableTestAccess().getGroup_5_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1287:6: ( '|' )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1287:6: ( '|' )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1288:1: '|'
                    {
                     before(grammarAccess.getTableTestAccess().getVerticalLineKeyword_5_1()); 
                    match(input,13,FOLLOW_13_in_rule__TableTest__Alternatives_52728); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1300:1: rule__TableTestRow__Alternatives_2 : ( ( ( rule__TableTestRow__Group_2_0__0 ) ) | ( '|' ) );
    public final void rule__TableTestRow__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1304:1: ( ( ( rule__TableTestRow__Group_2_0__0 ) ) | ( '|' ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==13) ) {
                int LA7_1 = input.LA(2);

                if ( (LA7_1==EOF||LA7_1==13||LA7_1==22||LA7_1==26||LA7_1==28||(LA7_1>=30 && LA7_1<=31)||LA7_1==33) ) {
                    alt7=2;
                }
                else if ( (LA7_1==29) ) {
                    alt7=1;
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
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1305:1: ( ( rule__TableTestRow__Group_2_0__0 ) )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1305:1: ( ( rule__TableTestRow__Group_2_0__0 ) )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1306:1: ( rule__TableTestRow__Group_2_0__0 )
                    {
                     before(grammarAccess.getTableTestRowAccess().getGroup_2_0()); 
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1307:1: ( rule__TableTestRow__Group_2_0__0 )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1307:2: rule__TableTestRow__Group_2_0__0
                    {
                    pushFollow(FOLLOW_rule__TableTestRow__Group_2_0__0_in_rule__TableTestRow__Alternatives_22762);
                    rule__TableTestRow__Group_2_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTableTestRowAccess().getGroup_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1311:6: ( '|' )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1311:6: ( '|' )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1312:1: '|'
                    {
                     before(grammarAccess.getTableTestRowAccess().getVerticalLineKeyword_2_1()); 
                    match(input,13,FOLLOW_13_in_rule__TableTestRow__Alternatives_22781); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1324:1: rule__ResultName__Alternatives : ( ( ruleFixedResultName ) | ( ruleArbitraryParameterOrResultName ) );
    public final void rule__ResultName__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1328:1: ( ( ruleFixedResultName ) | ( ruleArbitraryParameterOrResultName ) )
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
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1329:1: ( ruleFixedResultName )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1329:1: ( ruleFixedResultName )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1330:1: ruleFixedResultName
                    {
                     before(grammarAccess.getResultNameAccess().getFixedResultNameParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleFixedResultName_in_rule__ResultName__Alternatives2815);
                    ruleFixedResultName();

                    state._fsp--;

                     after(grammarAccess.getResultNameAccess().getFixedResultNameParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1335:6: ( ruleArbitraryParameterOrResultName )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1335:6: ( ruleArbitraryParameterOrResultName )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1336:1: ruleArbitraryParameterOrResultName
                    {
                     before(grammarAccess.getResultNameAccess().getArbitraryParameterOrResultNameParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleArbitraryParameterOrResultName_in_rule__ResultName__Alternatives2832);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1346:1: rule__ParameterName__Alternatives : ( ( ruleFixedParameterName ) | ( ruleArbitraryParameterOrResultName ) );
    public final void rule__ParameterName__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1350:1: ( ( ruleFixedParameterName ) | ( ruleArbitraryParameterOrResultName ) )
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            else if ( (LA9_0==35) ) {
                alt9=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1351:1: ( ruleFixedParameterName )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1351:1: ( ruleFixedParameterName )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1352:1: ruleFixedParameterName
                    {
                     before(grammarAccess.getParameterNameAccess().getFixedParameterNameParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleFixedParameterName_in_rule__ParameterName__Alternatives2864);
                    ruleFixedParameterName();

                    state._fsp--;

                     after(grammarAccess.getParameterNameAccess().getFixedParameterNameParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1357:6: ( ruleArbitraryParameterOrResultName )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1357:6: ( ruleArbitraryParameterOrResultName )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1358:1: ruleArbitraryParameterOrResultName
                    {
                     before(grammarAccess.getParameterNameAccess().getArbitraryParameterOrResultNameParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleArbitraryParameterOrResultName_in_rule__ParameterName__Alternatives2881);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1368:1: rule__ValueOrEnumValue__Alternatives : ( ( ruleValue ) | ( ruleEnumValue ) );
    public final void rule__ValueOrEnumValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1372:1: ( ( ruleValue ) | ( ruleEnumValue ) )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==RULE_ID||(LA10_0>=RULE_INTEGER && LA10_0<=RULE_STRING)) ) {
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
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1373:1: ( ruleValue )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1373:1: ( ruleValue )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1374:1: ruleValue
                    {
                     before(grammarAccess.getValueOrEnumValueAccess().getValueParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleValue_in_rule__ValueOrEnumValue__Alternatives2913);
                    ruleValue();

                    state._fsp--;

                     after(grammarAccess.getValueOrEnumValueAccess().getValueParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1379:6: ( ruleEnumValue )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1379:6: ( ruleEnumValue )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1380:1: ruleEnumValue
                    {
                     before(grammarAccess.getValueOrEnumValueAccess().getEnumValueParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleEnumValue_in_rule__ValueOrEnumValue__Alternatives2930);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1390:1: rule__Value__Alternatives : ( ( ruleStringValue ) | ( ruleIntegerValue ) | ( ruleDecimalValue ) | ( ruleVariable ) );
    public final void rule__Value__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1394:1: ( ( ruleStringValue ) | ( ruleIntegerValue ) | ( ruleDecimalValue ) | ( ruleVariable ) )
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
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1395:1: ( ruleStringValue )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1395:1: ( ruleStringValue )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1396:1: ruleStringValue
                    {
                     before(grammarAccess.getValueAccess().getStringValueParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleStringValue_in_rule__Value__Alternatives2962);
                    ruleStringValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getStringValueParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1401:6: ( ruleIntegerValue )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1401:6: ( ruleIntegerValue )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1402:1: ruleIntegerValue
                    {
                     before(grammarAccess.getValueAccess().getIntegerValueParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleIntegerValue_in_rule__Value__Alternatives2979);
                    ruleIntegerValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getIntegerValueParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1407:6: ( ruleDecimalValue )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1407:6: ( ruleDecimalValue )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1408:1: ruleDecimalValue
                    {
                     before(grammarAccess.getValueAccess().getDecimalValueParserRuleCall_2()); 
                    pushFollow(FOLLOW_ruleDecimalValue_in_rule__Value__Alternatives2996);
                    ruleDecimalValue();

                    state._fsp--;

                     after(grammarAccess.getValueAccess().getDecimalValueParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1413:6: ( ruleVariable )
                    {
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1413:6: ( ruleVariable )
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1414:1: ruleVariable
                    {
                     before(grammarAccess.getValueAccess().getVariableParserRuleCall_3()); 
                    pushFollow(FOLLOW_ruleVariable_in_rule__Value__Alternatives3013);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1426:1: rule__PackageDefinition__Group__0 : rule__PackageDefinition__Group__0__Impl rule__PackageDefinition__Group__1 ;
    public final void rule__PackageDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1430:1: ( rule__PackageDefinition__Group__0__Impl rule__PackageDefinition__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1431:2: rule__PackageDefinition__Group__0__Impl rule__PackageDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__0__Impl_in_rule__PackageDefinition__Group__03043);
            rule__PackageDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDefinition__Group__1_in_rule__PackageDefinition__Group__03046);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1438:1: rule__PackageDefinition__Group__0__Impl : ( 'packagedef' ) ;
    public final void rule__PackageDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1442:1: ( ( 'packagedef' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1443:1: ( 'packagedef' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1443:1: ( 'packagedef' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1444:1: 'packagedef'
            {
             before(grammarAccess.getPackageDefinitionAccess().getPackagedefKeyword_0()); 
            match(input,14,FOLLOW_14_in_rule__PackageDefinition__Group__0__Impl3074); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1457:1: rule__PackageDefinition__Group__1 : rule__PackageDefinition__Group__1__Impl rule__PackageDefinition__Group__2 ;
    public final void rule__PackageDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1461:1: ( rule__PackageDefinition__Group__1__Impl rule__PackageDefinition__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1462:2: rule__PackageDefinition__Group__1__Impl rule__PackageDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__1__Impl_in_rule__PackageDefinition__Group__13105);
            rule__PackageDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDefinition__Group__2_in_rule__PackageDefinition__Group__13108);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1469:1: rule__PackageDefinition__Group__1__Impl : ( ( rule__PackageDefinition__NameAssignment_1 ) ) ;
    public final void rule__PackageDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1473:1: ( ( ( rule__PackageDefinition__NameAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1474:1: ( ( rule__PackageDefinition__NameAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1474:1: ( ( rule__PackageDefinition__NameAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1475:1: ( rule__PackageDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getPackageDefinitionAccess().getNameAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1476:1: ( rule__PackageDefinition__NameAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1476:2: rule__PackageDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__PackageDefinition__NameAssignment_1_in_rule__PackageDefinition__Group__1__Impl3135);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1486:1: rule__PackageDefinition__Group__2 : rule__PackageDefinition__Group__2__Impl rule__PackageDefinition__Group__3 ;
    public final void rule__PackageDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1490:1: ( rule__PackageDefinition__Group__2__Impl rule__PackageDefinition__Group__3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1491:2: rule__PackageDefinition__Group__2__Impl rule__PackageDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__2__Impl_in_rule__PackageDefinition__Group__23165);
            rule__PackageDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDefinition__Group__3_in_rule__PackageDefinition__Group__23168);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1498:1: rule__PackageDefinition__Group__2__Impl : ( 'with' ) ;
    public final void rule__PackageDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1502:1: ( ( 'with' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1503:1: ( 'with' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1503:1: ( 'with' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1504:1: 'with'
            {
             before(grammarAccess.getPackageDefinitionAccess().getWithKeyword_2()); 
            match(input,15,FOLLOW_15_in_rule__PackageDefinition__Group__2__Impl3196); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1517:1: rule__PackageDefinition__Group__3 : rule__PackageDefinition__Group__3__Impl rule__PackageDefinition__Group__4 ;
    public final void rule__PackageDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1521:1: ( rule__PackageDefinition__Group__3__Impl rule__PackageDefinition__Group__4 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1522:2: rule__PackageDefinition__Group__3__Impl rule__PackageDefinition__Group__4
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__3__Impl_in_rule__PackageDefinition__Group__33227);
            rule__PackageDefinition__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__PackageDefinition__Group__4_in_rule__PackageDefinition__Group__33230);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1529:1: rule__PackageDefinition__Group__3__Impl : ( ( rule__PackageDefinition__StatementsAssignment_3 )* ) ;
    public final void rule__PackageDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1533:1: ( ( ( rule__PackageDefinition__StatementsAssignment_3 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1534:1: ( ( rule__PackageDefinition__StatementsAssignment_3 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1534:1: ( ( rule__PackageDefinition__StatementsAssignment_3 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1535:1: ( rule__PackageDefinition__StatementsAssignment_3 )*
            {
             before(grammarAccess.getPackageDefinitionAccess().getStatementsAssignment_3()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1536:1: ( rule__PackageDefinition__StatementsAssignment_3 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=17 && LA12_0<=18)||(LA12_0>=20 && LA12_0<=21)||LA12_0==26) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1536:2: rule__PackageDefinition__StatementsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__PackageDefinition__StatementsAssignment_3_in_rule__PackageDefinition__Group__3__Impl3257);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1546:1: rule__PackageDefinition__Group__4 : rule__PackageDefinition__Group__4__Impl ;
    public final void rule__PackageDefinition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1550:1: ( rule__PackageDefinition__Group__4__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1551:2: rule__PackageDefinition__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__PackageDefinition__Group__4__Impl_in_rule__PackageDefinition__Group__43288);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1557:1: rule__PackageDefinition__Group__4__Impl : ( 'packageend' ) ;
    public final void rule__PackageDefinition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1561:1: ( ( 'packageend' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1562:1: ( 'packageend' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1562:1: ( 'packageend' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1563:1: 'packageend'
            {
             before(grammarAccess.getPackageDefinitionAccess().getPackageendKeyword_4()); 
            match(input,16,FOLLOW_16_in_rule__PackageDefinition__Group__4__Impl3316); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1586:1: rule__Import__Group__0 : rule__Import__Group__0__Impl rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1590:1: ( rule__Import__Group__0__Impl rule__Import__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1591:2: rule__Import__Group__0__Impl rule__Import__Group__1
            {
            pushFollow(FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__03357);
            rule__Import__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__03360);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1598:1: rule__Import__Group__0__Impl : ( 'import' ) ;
    public final void rule__Import__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1602:1: ( ( 'import' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1603:1: ( 'import' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1603:1: ( 'import' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1604:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__Import__Group__0__Impl3388); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1617:1: rule__Import__Group__1 : rule__Import__Group__1__Impl ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1621:1: ( rule__Import__Group__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1622:2: rule__Import__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__13419);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1628:1: rule__Import__Group__1__Impl : ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) ;
    public final void rule__Import__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1632:1: ( ( ( rule__Import__ImportedNamespaceAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1633:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1633:1: ( ( rule__Import__ImportedNamespaceAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1634:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1635:1: ( rule__Import__ImportedNamespaceAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1635:2: rule__Import__ImportedNamespaceAssignment_1
            {
            pushFollow(FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl3446);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1649:1: rule__TestDefinition__Group__0 : rule__TestDefinition__Group__0__Impl rule__TestDefinition__Group__1 ;
    public final void rule__TestDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1653:1: ( rule__TestDefinition__Group__0__Impl rule__TestDefinition__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1654:2: rule__TestDefinition__Group__0__Impl rule__TestDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__TestDefinition__Group__0__Impl_in_rule__TestDefinition__Group__03480);
            rule__TestDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TestDefinition__Group__1_in_rule__TestDefinition__Group__03483);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1661:1: rule__TestDefinition__Group__0__Impl : ( 'testdef' ) ;
    public final void rule__TestDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1665:1: ( ( 'testdef' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1666:1: ( 'testdef' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1666:1: ( 'testdef' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1667:1: 'testdef'
            {
             before(grammarAccess.getTestDefinitionAccess().getTestdefKeyword_0()); 
            match(input,18,FOLLOW_18_in_rule__TestDefinition__Group__0__Impl3511); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1680:1: rule__TestDefinition__Group__1 : rule__TestDefinition__Group__1__Impl rule__TestDefinition__Group__2 ;
    public final void rule__TestDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1684:1: ( rule__TestDefinition__Group__1__Impl rule__TestDefinition__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1685:2: rule__TestDefinition__Group__1__Impl rule__TestDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__TestDefinition__Group__1__Impl_in_rule__TestDefinition__Group__13542);
            rule__TestDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TestDefinition__Group__2_in_rule__TestDefinition__Group__13545);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1692:1: rule__TestDefinition__Group__1__Impl : ( ( rule__TestDefinition__NameAssignment_1 ) ) ;
    public final void rule__TestDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1696:1: ( ( ( rule__TestDefinition__NameAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1697:1: ( ( rule__TestDefinition__NameAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1697:1: ( ( rule__TestDefinition__NameAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1698:1: ( rule__TestDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getTestDefinitionAccess().getNameAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1699:1: ( rule__TestDefinition__NameAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1699:2: rule__TestDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__TestDefinition__NameAssignment_1_in_rule__TestDefinition__Group__1__Impl3572);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1709:1: rule__TestDefinition__Group__2 : rule__TestDefinition__Group__2__Impl rule__TestDefinition__Group__3 ;
    public final void rule__TestDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1713:1: ( rule__TestDefinition__Group__2__Impl rule__TestDefinition__Group__3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1714:2: rule__TestDefinition__Group__2__Impl rule__TestDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__TestDefinition__Group__2__Impl_in_rule__TestDefinition__Group__23602);
            rule__TestDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TestDefinition__Group__3_in_rule__TestDefinition__Group__23605);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1721:1: rule__TestDefinition__Group__2__Impl : ( 'uses' ) ;
    public final void rule__TestDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1725:1: ( ( 'uses' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1726:1: ( 'uses' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1726:1: ( 'uses' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1727:1: 'uses'
            {
             before(grammarAccess.getTestDefinitionAccess().getUsesKeyword_2()); 
            match(input,19,FOLLOW_19_in_rule__TestDefinition__Group__2__Impl3633); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1740:1: rule__TestDefinition__Group__3 : rule__TestDefinition__Group__3__Impl ;
    public final void rule__TestDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1744:1: ( rule__TestDefinition__Group__3__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1745:2: rule__TestDefinition__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__TestDefinition__Group__3__Impl_in_rule__TestDefinition__Group__33664);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1751:1: rule__TestDefinition__Group__3__Impl : ( ( rule__TestDefinition__FixtureMethodAssignment_3 ) ) ;
    public final void rule__TestDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1755:1: ( ( ( rule__TestDefinition__FixtureMethodAssignment_3 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1756:1: ( ( rule__TestDefinition__FixtureMethodAssignment_3 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1756:1: ( ( rule__TestDefinition__FixtureMethodAssignment_3 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1757:1: ( rule__TestDefinition__FixtureMethodAssignment_3 )
            {
             before(grammarAccess.getTestDefinitionAccess().getFixtureMethodAssignment_3()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1758:1: ( rule__TestDefinition__FixtureMethodAssignment_3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1758:2: rule__TestDefinition__FixtureMethodAssignment_3
            {
            pushFollow(FOLLOW_rule__TestDefinition__FixtureMethodAssignment_3_in_rule__TestDefinition__Group__3__Impl3691);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1776:1: rule__CallDefinition__Group__0 : rule__CallDefinition__Group__0__Impl rule__CallDefinition__Group__1 ;
    public final void rule__CallDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1780:1: ( rule__CallDefinition__Group__0__Impl rule__CallDefinition__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1781:2: rule__CallDefinition__Group__0__Impl rule__CallDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__CallDefinition__Group__0__Impl_in_rule__CallDefinition__Group__03729);
            rule__CallDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CallDefinition__Group__1_in_rule__CallDefinition__Group__03732);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1788:1: rule__CallDefinition__Group__0__Impl : ( 'calldef' ) ;
    public final void rule__CallDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1792:1: ( ( 'calldef' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1793:1: ( 'calldef' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1793:1: ( 'calldef' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1794:1: 'calldef'
            {
             before(grammarAccess.getCallDefinitionAccess().getCalldefKeyword_0()); 
            match(input,20,FOLLOW_20_in_rule__CallDefinition__Group__0__Impl3760); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1807:1: rule__CallDefinition__Group__1 : rule__CallDefinition__Group__1__Impl rule__CallDefinition__Group__2 ;
    public final void rule__CallDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1811:1: ( rule__CallDefinition__Group__1__Impl rule__CallDefinition__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1812:2: rule__CallDefinition__Group__1__Impl rule__CallDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__CallDefinition__Group__1__Impl_in_rule__CallDefinition__Group__13791);
            rule__CallDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CallDefinition__Group__2_in_rule__CallDefinition__Group__13794);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1819:1: rule__CallDefinition__Group__1__Impl : ( ( rule__CallDefinition__NameAssignment_1 ) ) ;
    public final void rule__CallDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1823:1: ( ( ( rule__CallDefinition__NameAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1824:1: ( ( rule__CallDefinition__NameAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1824:1: ( ( rule__CallDefinition__NameAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1825:1: ( rule__CallDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getCallDefinitionAccess().getNameAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1826:1: ( rule__CallDefinition__NameAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1826:2: rule__CallDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__CallDefinition__NameAssignment_1_in_rule__CallDefinition__Group__1__Impl3821);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1836:1: rule__CallDefinition__Group__2 : rule__CallDefinition__Group__2__Impl rule__CallDefinition__Group__3 ;
    public final void rule__CallDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1840:1: ( rule__CallDefinition__Group__2__Impl rule__CallDefinition__Group__3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1841:2: rule__CallDefinition__Group__2__Impl rule__CallDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__CallDefinition__Group__2__Impl_in_rule__CallDefinition__Group__23851);
            rule__CallDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__CallDefinition__Group__3_in_rule__CallDefinition__Group__23854);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1848:1: rule__CallDefinition__Group__2__Impl : ( 'uses' ) ;
    public final void rule__CallDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1852:1: ( ( 'uses' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1853:1: ( 'uses' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1853:1: ( 'uses' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1854:1: 'uses'
            {
             before(grammarAccess.getCallDefinitionAccess().getUsesKeyword_2()); 
            match(input,19,FOLLOW_19_in_rule__CallDefinition__Group__2__Impl3882); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1867:1: rule__CallDefinition__Group__3 : rule__CallDefinition__Group__3__Impl ;
    public final void rule__CallDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1871:1: ( rule__CallDefinition__Group__3__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1872:2: rule__CallDefinition__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__CallDefinition__Group__3__Impl_in_rule__CallDefinition__Group__33913);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1878:1: rule__CallDefinition__Group__3__Impl : ( ( rule__CallDefinition__FixtureMethodAssignment_3 ) ) ;
    public final void rule__CallDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1882:1: ( ( ( rule__CallDefinition__FixtureMethodAssignment_3 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1883:1: ( ( rule__CallDefinition__FixtureMethodAssignment_3 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1883:1: ( ( rule__CallDefinition__FixtureMethodAssignment_3 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1884:1: ( rule__CallDefinition__FixtureMethodAssignment_3 )
            {
             before(grammarAccess.getCallDefinitionAccess().getFixtureMethodAssignment_3()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1885:1: ( rule__CallDefinition__FixtureMethodAssignment_3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1885:2: rule__CallDefinition__FixtureMethodAssignment_3
            {
            pushFollow(FOLLOW_rule__CallDefinition__FixtureMethodAssignment_3_in_rule__CallDefinition__Group__3__Impl3940);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1903:1: rule__SuiteDefinition__Group__0 : rule__SuiteDefinition__Group__0__Impl rule__SuiteDefinition__Group__1 ;
    public final void rule__SuiteDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1907:1: ( rule__SuiteDefinition__Group__0__Impl rule__SuiteDefinition__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1908:2: rule__SuiteDefinition__Group__0__Impl rule__SuiteDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__0__Impl_in_rule__SuiteDefinition__Group__03978);
            rule__SuiteDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__1_in_rule__SuiteDefinition__Group__03981);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1915:1: rule__SuiteDefinition__Group__0__Impl : ( 'suitedef' ) ;
    public final void rule__SuiteDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1919:1: ( ( 'suitedef' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1920:1: ( 'suitedef' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1920:1: ( 'suitedef' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1921:1: 'suitedef'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getSuitedefKeyword_0()); 
            match(input,21,FOLLOW_21_in_rule__SuiteDefinition__Group__0__Impl4009); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1934:1: rule__SuiteDefinition__Group__1 : rule__SuiteDefinition__Group__1__Impl rule__SuiteDefinition__Group__2 ;
    public final void rule__SuiteDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1938:1: ( rule__SuiteDefinition__Group__1__Impl rule__SuiteDefinition__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1939:2: rule__SuiteDefinition__Group__1__Impl rule__SuiteDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__1__Impl_in_rule__SuiteDefinition__Group__14040);
            rule__SuiteDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__2_in_rule__SuiteDefinition__Group__14043);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1946:1: rule__SuiteDefinition__Group__1__Impl : ( ( rule__SuiteDefinition__NameAssignment_1 ) ) ;
    public final void rule__SuiteDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1950:1: ( ( ( rule__SuiteDefinition__NameAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1951:1: ( ( rule__SuiteDefinition__NameAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1951:1: ( ( rule__SuiteDefinition__NameAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1952:1: ( rule__SuiteDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getSuiteDefinitionAccess().getNameAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1953:1: ( rule__SuiteDefinition__NameAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1953:2: rule__SuiteDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__NameAssignment_1_in_rule__SuiteDefinition__Group__1__Impl4070);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1963:1: rule__SuiteDefinition__Group__2 : rule__SuiteDefinition__Group__2__Impl rule__SuiteDefinition__Group__3 ;
    public final void rule__SuiteDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1967:1: ( rule__SuiteDefinition__Group__2__Impl rule__SuiteDefinition__Group__3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1968:2: rule__SuiteDefinition__Group__2__Impl rule__SuiteDefinition__Group__3
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__2__Impl_in_rule__SuiteDefinition__Group__24100);
            rule__SuiteDefinition__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__3_in_rule__SuiteDefinition__Group__24103);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1975:1: rule__SuiteDefinition__Group__2__Impl : ( ( rule__SuiteDefinition__Group_2__0 )? ) ;
    public final void rule__SuiteDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1979:1: ( ( ( rule__SuiteDefinition__Group_2__0 )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1980:1: ( ( rule__SuiteDefinition__Group_2__0 )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1980:1: ( ( rule__SuiteDefinition__Group_2__0 )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1981:1: ( rule__SuiteDefinition__Group_2__0 )?
            {
             before(grammarAccess.getSuiteDefinitionAccess().getGroup_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1982:1: ( rule__SuiteDefinition__Group_2__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==23) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1982:2: rule__SuiteDefinition__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__SuiteDefinition__Group_2__0_in_rule__SuiteDefinition__Group__2__Impl4130);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1992:1: rule__SuiteDefinition__Group__3 : rule__SuiteDefinition__Group__3__Impl rule__SuiteDefinition__Group__4 ;
    public final void rule__SuiteDefinition__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1996:1: ( rule__SuiteDefinition__Group__3__Impl rule__SuiteDefinition__Group__4 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:1997:2: rule__SuiteDefinition__Group__3__Impl rule__SuiteDefinition__Group__4
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__3__Impl_in_rule__SuiteDefinition__Group__34161);
            rule__SuiteDefinition__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__4_in_rule__SuiteDefinition__Group__34164);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2004:1: rule__SuiteDefinition__Group__3__Impl : ( ( rule__SuiteDefinition__Group_3__0 )? ) ;
    public final void rule__SuiteDefinition__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2008:1: ( ( ( rule__SuiteDefinition__Group_3__0 )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2009:1: ( ( rule__SuiteDefinition__Group_3__0 )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2009:1: ( ( rule__SuiteDefinition__Group_3__0 )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2010:1: ( rule__SuiteDefinition__Group_3__0 )?
            {
             before(grammarAccess.getSuiteDefinitionAccess().getGroup_3()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2011:1: ( rule__SuiteDefinition__Group_3__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==24) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2011:2: rule__SuiteDefinition__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__SuiteDefinition__Group_3__0_in_rule__SuiteDefinition__Group__3__Impl4191);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2021:1: rule__SuiteDefinition__Group__4 : rule__SuiteDefinition__Group__4__Impl rule__SuiteDefinition__Group__5 ;
    public final void rule__SuiteDefinition__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2025:1: ( rule__SuiteDefinition__Group__4__Impl rule__SuiteDefinition__Group__5 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2026:2: rule__SuiteDefinition__Group__4__Impl rule__SuiteDefinition__Group__5
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__4__Impl_in_rule__SuiteDefinition__Group__44222);
            rule__SuiteDefinition__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__5_in_rule__SuiteDefinition__Group__44225);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2033:1: rule__SuiteDefinition__Group__4__Impl : ( 'with' ) ;
    public final void rule__SuiteDefinition__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2037:1: ( ( 'with' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2038:1: ( 'with' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2038:1: ( 'with' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2039:1: 'with'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getWithKeyword_4()); 
            match(input,15,FOLLOW_15_in_rule__SuiteDefinition__Group__4__Impl4253); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2052:1: rule__SuiteDefinition__Group__5 : rule__SuiteDefinition__Group__5__Impl rule__SuiteDefinition__Group__6 ;
    public final void rule__SuiteDefinition__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2056:1: ( rule__SuiteDefinition__Group__5__Impl rule__SuiteDefinition__Group__6 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2057:2: rule__SuiteDefinition__Group__5__Impl rule__SuiteDefinition__Group__6
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__5__Impl_in_rule__SuiteDefinition__Group__54284);
            rule__SuiteDefinition__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__6_in_rule__SuiteDefinition__Group__54287);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2064:1: rule__SuiteDefinition__Group__5__Impl : ( ( rule__SuiteDefinition__StatementsAssignment_5 )* ) ;
    public final void rule__SuiteDefinition__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2068:1: ( ( ( rule__SuiteDefinition__StatementsAssignment_5 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2069:1: ( ( rule__SuiteDefinition__StatementsAssignment_5 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2069:1: ( ( rule__SuiteDefinition__StatementsAssignment_5 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2070:1: ( rule__SuiteDefinition__StatementsAssignment_5 )*
            {
             before(grammarAccess.getSuiteDefinitionAccess().getStatementsAssignment_5()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2071:1: ( rule__SuiteDefinition__StatementsAssignment_5 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==26||LA15_0==28||(LA15_0>=30 && LA15_0<=31)||LA15_0==33) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2071:2: rule__SuiteDefinition__StatementsAssignment_5
            	    {
            	    pushFollow(FOLLOW_rule__SuiteDefinition__StatementsAssignment_5_in_rule__SuiteDefinition__Group__5__Impl4314);
            	    rule__SuiteDefinition__StatementsAssignment_5();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2081:1: rule__SuiteDefinition__Group__6 : rule__SuiteDefinition__Group__6__Impl rule__SuiteDefinition__Group__7 ;
    public final void rule__SuiteDefinition__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2085:1: ( rule__SuiteDefinition__Group__6__Impl rule__SuiteDefinition__Group__7 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2086:2: rule__SuiteDefinition__Group__6__Impl rule__SuiteDefinition__Group__7
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__6__Impl_in_rule__SuiteDefinition__Group__64345);
            rule__SuiteDefinition__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group__7_in_rule__SuiteDefinition__Group__64348);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2093:1: rule__SuiteDefinition__Group__6__Impl : ( 'suiteend' ) ;
    public final void rule__SuiteDefinition__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2097:1: ( ( 'suiteend' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2098:1: ( 'suiteend' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2098:1: ( 'suiteend' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2099:1: 'suiteend'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getSuiteendKeyword_6()); 
            match(input,22,FOLLOW_22_in_rule__SuiteDefinition__Group__6__Impl4376); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2112:1: rule__SuiteDefinition__Group__7 : rule__SuiteDefinition__Group__7__Impl ;
    public final void rule__SuiteDefinition__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2116:1: ( rule__SuiteDefinition__Group__7__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2117:2: rule__SuiteDefinition__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group__7__Impl_in_rule__SuiteDefinition__Group__74407);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2123:1: rule__SuiteDefinition__Group__7__Impl : ( ( rule__SuiteDefinition__Group_7__0 )? ) ;
    public final void rule__SuiteDefinition__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2127:1: ( ( ( rule__SuiteDefinition__Group_7__0 )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2128:1: ( ( rule__SuiteDefinition__Group_7__0 )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2128:1: ( ( rule__SuiteDefinition__Group_7__0 )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2129:1: ( rule__SuiteDefinition__Group_7__0 )?
            {
             before(grammarAccess.getSuiteDefinitionAccess().getGroup_7()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2130:1: ( rule__SuiteDefinition__Group_7__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==25) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2130:2: rule__SuiteDefinition__Group_7__0
                    {
                    pushFollow(FOLLOW_rule__SuiteDefinition__Group_7__0_in_rule__SuiteDefinition__Group__7__Impl4434);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2156:1: rule__SuiteDefinition__Group_2__0 : rule__SuiteDefinition__Group_2__0__Impl rule__SuiteDefinition__Group_2__1 ;
    public final void rule__SuiteDefinition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2160:1: ( rule__SuiteDefinition__Group_2__0__Impl rule__SuiteDefinition__Group_2__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2161:2: rule__SuiteDefinition__Group_2__0__Impl rule__SuiteDefinition__Group_2__1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_2__0__Impl_in_rule__SuiteDefinition__Group_2__04481);
            rule__SuiteDefinition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group_2__1_in_rule__SuiteDefinition__Group_2__04484);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2168:1: rule__SuiteDefinition__Group_2__0__Impl : ( 'gets' ) ;
    public final void rule__SuiteDefinition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2172:1: ( ( 'gets' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2173:1: ( 'gets' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2173:1: ( 'gets' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2174:1: 'gets'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getGetsKeyword_2_0()); 
            match(input,23,FOLLOW_23_in_rule__SuiteDefinition__Group_2__0__Impl4512); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2187:1: rule__SuiteDefinition__Group_2__1 : rule__SuiteDefinition__Group_2__1__Impl ;
    public final void rule__SuiteDefinition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2191:1: ( rule__SuiteDefinition__Group_2__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2192:2: rule__SuiteDefinition__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_2__1__Impl_in_rule__SuiteDefinition__Group_2__14543);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2198:1: rule__SuiteDefinition__Group_2__1__Impl : ( ( rule__SuiteDefinition__ParametersAssignment_2_1 )* ) ;
    public final void rule__SuiteDefinition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2202:1: ( ( ( rule__SuiteDefinition__ParametersAssignment_2_1 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2203:1: ( ( rule__SuiteDefinition__ParametersAssignment_2_1 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2203:1: ( ( rule__SuiteDefinition__ParametersAssignment_2_1 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2204:1: ( rule__SuiteDefinition__ParametersAssignment_2_1 )*
            {
             before(grammarAccess.getSuiteDefinitionAccess().getParametersAssignment_2_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2205:1: ( rule__SuiteDefinition__ParametersAssignment_2_1 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_ID) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2205:2: rule__SuiteDefinition__ParametersAssignment_2_1
            	    {
            	    pushFollow(FOLLOW_rule__SuiteDefinition__ParametersAssignment_2_1_in_rule__SuiteDefinition__Group_2__1__Impl4570);
            	    rule__SuiteDefinition__ParametersAssignment_2_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2219:1: rule__SuiteDefinition__Group_3__0 : rule__SuiteDefinition__Group_3__0__Impl rule__SuiteDefinition__Group_3__1 ;
    public final void rule__SuiteDefinition__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2223:1: ( rule__SuiteDefinition__Group_3__0__Impl rule__SuiteDefinition__Group_3__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2224:2: rule__SuiteDefinition__Group_3__0__Impl rule__SuiteDefinition__Group_3__1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_3__0__Impl_in_rule__SuiteDefinition__Group_3__04605);
            rule__SuiteDefinition__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group_3__1_in_rule__SuiteDefinition__Group_3__04608);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2231:1: rule__SuiteDefinition__Group_3__0__Impl : ( 'requires' ) ;
    public final void rule__SuiteDefinition__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2235:1: ( ( 'requires' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2236:1: ( 'requires' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2236:1: ( 'requires' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2237:1: 'requires'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getRequiresKeyword_3_0()); 
            match(input,24,FOLLOW_24_in_rule__SuiteDefinition__Group_3__0__Impl4636); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2250:1: rule__SuiteDefinition__Group_3__1 : rule__SuiteDefinition__Group_3__1__Impl ;
    public final void rule__SuiteDefinition__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2254:1: ( rule__SuiteDefinition__Group_3__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2255:2: rule__SuiteDefinition__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_3__1__Impl_in_rule__SuiteDefinition__Group_3__14667);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2261:1: rule__SuiteDefinition__Group_3__1__Impl : ( ( rule__SuiteDefinition__DependenciesAssignment_3_1 )* ) ;
    public final void rule__SuiteDefinition__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2265:1: ( ( ( rule__SuiteDefinition__DependenciesAssignment_3_1 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2266:1: ( ( rule__SuiteDefinition__DependenciesAssignment_3_1 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2266:1: ( ( rule__SuiteDefinition__DependenciesAssignment_3_1 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2267:1: ( rule__SuiteDefinition__DependenciesAssignment_3_1 )*
            {
             before(grammarAccess.getSuiteDefinitionAccess().getDependenciesAssignment_3_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2268:1: ( rule__SuiteDefinition__DependenciesAssignment_3_1 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2268:2: rule__SuiteDefinition__DependenciesAssignment_3_1
            	    {
            	    pushFollow(FOLLOW_rule__SuiteDefinition__DependenciesAssignment_3_1_in_rule__SuiteDefinition__Group_3__1__Impl4694);
            	    rule__SuiteDefinition__DependenciesAssignment_3_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2282:1: rule__SuiteDefinition__Group_7__0 : rule__SuiteDefinition__Group_7__0__Impl rule__SuiteDefinition__Group_7__1 ;
    public final void rule__SuiteDefinition__Group_7__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2286:1: ( rule__SuiteDefinition__Group_7__0__Impl rule__SuiteDefinition__Group_7__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2287:2: rule__SuiteDefinition__Group_7__0__Impl rule__SuiteDefinition__Group_7__1
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_7__0__Impl_in_rule__SuiteDefinition__Group_7__04729);
            rule__SuiteDefinition__Group_7__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteDefinition__Group_7__1_in_rule__SuiteDefinition__Group_7__04732);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2294:1: rule__SuiteDefinition__Group_7__0__Impl : ( 'concludedby' ) ;
    public final void rule__SuiteDefinition__Group_7__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2298:1: ( ( 'concludedby' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2299:1: ( 'concludedby' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2299:1: ( 'concludedby' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2300:1: 'concludedby'
            {
             before(grammarAccess.getSuiteDefinitionAccess().getConcludedbyKeyword_7_0()); 
            match(input,25,FOLLOW_25_in_rule__SuiteDefinition__Group_7__0__Impl4760); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2313:1: rule__SuiteDefinition__Group_7__1 : rule__SuiteDefinition__Group_7__1__Impl ;
    public final void rule__SuiteDefinition__Group_7__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2317:1: ( rule__SuiteDefinition__Group_7__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2318:2: rule__SuiteDefinition__Group_7__1__Impl
            {
            pushFollow(FOLLOW_rule__SuiteDefinition__Group_7__1__Impl_in_rule__SuiteDefinition__Group_7__14791);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2324:1: rule__SuiteDefinition__Group_7__1__Impl : ( ( rule__SuiteDefinition__FinalizersAssignment_7_1 )* ) ;
    public final void rule__SuiteDefinition__Group_7__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2328:1: ( ( ( rule__SuiteDefinition__FinalizersAssignment_7_1 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2329:1: ( ( rule__SuiteDefinition__FinalizersAssignment_7_1 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2329:1: ( ( rule__SuiteDefinition__FinalizersAssignment_7_1 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2330:1: ( rule__SuiteDefinition__FinalizersAssignment_7_1 )*
            {
             before(grammarAccess.getSuiteDefinitionAccess().getFinalizersAssignment_7_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2331:1: ( rule__SuiteDefinition__FinalizersAssignment_7_1 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2331:2: rule__SuiteDefinition__FinalizersAssignment_7_1
            	    {
            	    pushFollow(FOLLOW_rule__SuiteDefinition__FinalizersAssignment_7_1_in_rule__SuiteDefinition__Group_7__1__Impl4818);
            	    rule__SuiteDefinition__FinalizersAssignment_7_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2345:1: rule__VariableDefinition__Group__0 : rule__VariableDefinition__Group__0__Impl rule__VariableDefinition__Group__1 ;
    public final void rule__VariableDefinition__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2349:1: ( rule__VariableDefinition__Group__0__Impl rule__VariableDefinition__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2350:2: rule__VariableDefinition__Group__0__Impl rule__VariableDefinition__Group__1
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group__0__Impl_in_rule__VariableDefinition__Group__04853);
            rule__VariableDefinition__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDefinition__Group__1_in_rule__VariableDefinition__Group__04856);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2357:1: rule__VariableDefinition__Group__0__Impl : ( 'variable' ) ;
    public final void rule__VariableDefinition__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2361:1: ( ( 'variable' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2362:1: ( 'variable' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2362:1: ( 'variable' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2363:1: 'variable'
            {
             before(grammarAccess.getVariableDefinitionAccess().getVariableKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__VariableDefinition__Group__0__Impl4884); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2376:1: rule__VariableDefinition__Group__1 : rule__VariableDefinition__Group__1__Impl rule__VariableDefinition__Group__2 ;
    public final void rule__VariableDefinition__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2380:1: ( rule__VariableDefinition__Group__1__Impl rule__VariableDefinition__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2381:2: rule__VariableDefinition__Group__1__Impl rule__VariableDefinition__Group__2
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group__1__Impl_in_rule__VariableDefinition__Group__14915);
            rule__VariableDefinition__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDefinition__Group__2_in_rule__VariableDefinition__Group__14918);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2388:1: rule__VariableDefinition__Group__1__Impl : ( ( rule__VariableDefinition__NameAssignment_1 ) ) ;
    public final void rule__VariableDefinition__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2392:1: ( ( ( rule__VariableDefinition__NameAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2393:1: ( ( rule__VariableDefinition__NameAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2393:1: ( ( rule__VariableDefinition__NameAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2394:1: ( rule__VariableDefinition__NameAssignment_1 )
            {
             before(grammarAccess.getVariableDefinitionAccess().getNameAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2395:1: ( rule__VariableDefinition__NameAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2395:2: rule__VariableDefinition__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__VariableDefinition__NameAssignment_1_in_rule__VariableDefinition__Group__1__Impl4945);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2405:1: rule__VariableDefinition__Group__2 : rule__VariableDefinition__Group__2__Impl ;
    public final void rule__VariableDefinition__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2409:1: ( rule__VariableDefinition__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2410:2: rule__VariableDefinition__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group__2__Impl_in_rule__VariableDefinition__Group__24975);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2416:1: rule__VariableDefinition__Group__2__Impl : ( ( rule__VariableDefinition__Group_2__0 )? ) ;
    public final void rule__VariableDefinition__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2420:1: ( ( ( rule__VariableDefinition__Group_2__0 )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2421:1: ( ( rule__VariableDefinition__Group_2__0 )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2421:1: ( ( rule__VariableDefinition__Group_2__0 )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2422:1: ( rule__VariableDefinition__Group_2__0 )?
            {
             before(grammarAccess.getVariableDefinitionAccess().getGroup_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2423:1: ( rule__VariableDefinition__Group_2__0 )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==27) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2423:2: rule__VariableDefinition__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__VariableDefinition__Group_2__0_in_rule__VariableDefinition__Group__2__Impl5002);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2439:1: rule__VariableDefinition__Group_2__0 : rule__VariableDefinition__Group_2__0__Impl rule__VariableDefinition__Group_2__1 ;
    public final void rule__VariableDefinition__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2443:1: ( rule__VariableDefinition__Group_2__0__Impl rule__VariableDefinition__Group_2__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2444:2: rule__VariableDefinition__Group_2__0__Impl rule__VariableDefinition__Group_2__1
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group_2__0__Impl_in_rule__VariableDefinition__Group_2__05039);
            rule__VariableDefinition__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__VariableDefinition__Group_2__1_in_rule__VariableDefinition__Group_2__05042);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2451:1: rule__VariableDefinition__Group_2__0__Impl : ( 'initially' ) ;
    public final void rule__VariableDefinition__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2455:1: ( ( 'initially' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2456:1: ( 'initially' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2456:1: ( 'initially' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2457:1: 'initially'
            {
             before(grammarAccess.getVariableDefinitionAccess().getInitiallyKeyword_2_0()); 
            match(input,27,FOLLOW_27_in_rule__VariableDefinition__Group_2__0__Impl5070); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2470:1: rule__VariableDefinition__Group_2__1 : rule__VariableDefinition__Group_2__1__Impl ;
    public final void rule__VariableDefinition__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2474:1: ( rule__VariableDefinition__Group_2__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2475:2: rule__VariableDefinition__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__VariableDefinition__Group_2__1__Impl_in_rule__VariableDefinition__Group_2__15101);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2481:1: rule__VariableDefinition__Group_2__1__Impl : ( ( rule__VariableDefinition__InitialValueAssignment_2_1 ) ) ;
    public final void rule__VariableDefinition__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2485:1: ( ( ( rule__VariableDefinition__InitialValueAssignment_2_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2486:1: ( ( rule__VariableDefinition__InitialValueAssignment_2_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2486:1: ( ( rule__VariableDefinition__InitialValueAssignment_2_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2487:1: ( rule__VariableDefinition__InitialValueAssignment_2_1 )
            {
             before(grammarAccess.getVariableDefinitionAccess().getInitialValueAssignment_2_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2488:1: ( rule__VariableDefinition__InitialValueAssignment_2_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2488:2: rule__VariableDefinition__InitialValueAssignment_2_1
            {
            pushFollow(FOLLOW_rule__VariableDefinition__InitialValueAssignment_2_1_in_rule__VariableDefinition__Group_2__1__Impl5128);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2502:1: rule__Test__Group__0 : rule__Test__Group__0__Impl rule__Test__Group__1 ;
    public final void rule__Test__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2506:1: ( rule__Test__Group__0__Impl rule__Test__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2507:2: rule__Test__Group__0__Impl rule__Test__Group__1
            {
            pushFollow(FOLLOW_rule__Test__Group__0__Impl_in_rule__Test__Group__05162);
            rule__Test__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Test__Group__1_in_rule__Test__Group__05165);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2514:1: rule__Test__Group__0__Impl : ( 'test' ) ;
    public final void rule__Test__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2518:1: ( ( 'test' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2519:1: ( 'test' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2519:1: ( 'test' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2520:1: 'test'
            {
             before(grammarAccess.getTestAccess().getTestKeyword_0()); 
            match(input,28,FOLLOW_28_in_rule__Test__Group__0__Impl5193); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2533:1: rule__Test__Group__1 : rule__Test__Group__1__Impl rule__Test__Group__2 ;
    public final void rule__Test__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2537:1: ( rule__Test__Group__1__Impl rule__Test__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2538:2: rule__Test__Group__1__Impl rule__Test__Group__2
            {
            pushFollow(FOLLOW_rule__Test__Group__1__Impl_in_rule__Test__Group__15224);
            rule__Test__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Test__Group__2_in_rule__Test__Group__15227);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2545:1: rule__Test__Group__1__Impl : ( ( rule__Test__DefinitionAssignment_1 ) ) ;
    public final void rule__Test__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2549:1: ( ( ( rule__Test__DefinitionAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2550:1: ( ( rule__Test__DefinitionAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2550:1: ( ( rule__Test__DefinitionAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2551:1: ( rule__Test__DefinitionAssignment_1 )
            {
             before(grammarAccess.getTestAccess().getDefinitionAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2552:1: ( rule__Test__DefinitionAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2552:2: rule__Test__DefinitionAssignment_1
            {
            pushFollow(FOLLOW_rule__Test__DefinitionAssignment_1_in_rule__Test__Group__1__Impl5254);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2562:1: rule__Test__Group__2 : rule__Test__Group__2__Impl rule__Test__Group__3 ;
    public final void rule__Test__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2566:1: ( rule__Test__Group__2__Impl rule__Test__Group__3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2567:2: rule__Test__Group__2__Impl rule__Test__Group__3
            {
            pushFollow(FOLLOW_rule__Test__Group__2__Impl_in_rule__Test__Group__25284);
            rule__Test__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Test__Group__3_in_rule__Test__Group__25287);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2574:1: rule__Test__Group__2__Impl : ( ( rule__Test__ParametersAssignment_2 )* ) ;
    public final void rule__Test__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2578:1: ( ( ( rule__Test__ParametersAssignment_2 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2579:1: ( ( rule__Test__ParametersAssignment_2 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2579:1: ( ( rule__Test__ParametersAssignment_2 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2580:1: ( rule__Test__ParametersAssignment_2 )*
            {
             before(grammarAccess.getTestAccess().getParametersAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2581:1: ( rule__Test__ParametersAssignment_2 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==RULE_ID) ) {
                    int LA21_1 = input.LA(2);

                    if ( (LA21_1==34) ) {
                        alt21=1;
                    }


                }
                else if ( (LA21_0==35) ) {
                    int LA21_2 = input.LA(2);

                    if ( (LA21_2==RULE_ID) ) {
                        int LA21_5 = input.LA(3);

                        if ( (LA21_5==34) ) {
                            alt21=1;
                        }


                    }


                }


                switch (alt21) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2581:2: rule__Test__ParametersAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Test__ParametersAssignment_2_in_rule__Test__Group__2__Impl5314);
            	    rule__Test__ParametersAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop21;
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2591:1: rule__Test__Group__3 : rule__Test__Group__3__Impl rule__Test__Group__4 ;
    public final void rule__Test__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2595:1: ( rule__Test__Group__3__Impl rule__Test__Group__4 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2596:2: rule__Test__Group__3__Impl rule__Test__Group__4
            {
            pushFollow(FOLLOW_rule__Test__Group__3__Impl_in_rule__Test__Group__35345);
            rule__Test__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Test__Group__4_in_rule__Test__Group__35348);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2603:1: rule__Test__Group__3__Impl : ( ( rule__Test__ResultsAssignment_3 )* ) ;
    public final void rule__Test__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2607:1: ( ( ( rule__Test__ResultsAssignment_3 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2608:1: ( ( rule__Test__ResultsAssignment_3 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2608:1: ( ( rule__Test__ResultsAssignment_3 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2609:1: ( rule__Test__ResultsAssignment_3 )*
            {
             before(grammarAccess.getTestAccess().getResultsAssignment_3()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2610:1: ( rule__Test__ResultsAssignment_3 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_ID||LA22_0==35) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2610:2: rule__Test__ResultsAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__Test__ResultsAssignment_3_in_rule__Test__Group__3__Impl5375);
            	    rule__Test__ResultsAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2620:1: rule__Test__Group__4 : rule__Test__Group__4__Impl ;
    public final void rule__Test__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2624:1: ( rule__Test__Group__4__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2625:2: rule__Test__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Test__Group__4__Impl_in_rule__Test__Group__45406);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2631:1: rule__Test__Group__4__Impl : ( ( rule__Test__Group_4__0 )? ) ;
    public final void rule__Test__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2635:1: ( ( ( rule__Test__Group_4__0 )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2636:1: ( ( rule__Test__Group_4__0 )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2636:1: ( ( rule__Test__Group_4__0 )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2637:1: ( rule__Test__Group_4__0 )?
            {
             before(grammarAccess.getTestAccess().getGroup_4()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2638:1: ( rule__Test__Group_4__0 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==29) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2638:2: rule__Test__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Test__Group_4__0_in_rule__Test__Group__4__Impl5433);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2658:1: rule__Test__Group_4__0 : rule__Test__Group_4__0__Impl rule__Test__Group_4__1 ;
    public final void rule__Test__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2662:1: ( rule__Test__Group_4__0__Impl rule__Test__Group_4__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2663:2: rule__Test__Group_4__0__Impl rule__Test__Group_4__1
            {
            pushFollow(FOLLOW_rule__Test__Group_4__0__Impl_in_rule__Test__Group_4__05474);
            rule__Test__Group_4__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Test__Group_4__1_in_rule__Test__Group_4__05477);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2670:1: rule__Test__Group_4__0__Impl : ( '=' ) ;
    public final void rule__Test__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2674:1: ( ( '=' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2675:1: ( '=' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2675:1: ( '=' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2676:1: '='
            {
             before(grammarAccess.getTestAccess().getEqualsSignKeyword_4_0()); 
            match(input,29,FOLLOW_29_in_rule__Test__Group_4__0__Impl5505); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2689:1: rule__Test__Group_4__1 : rule__Test__Group_4__1__Impl ;
    public final void rule__Test__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2693:1: ( rule__Test__Group_4__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2694:2: rule__Test__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__Test__Group_4__1__Impl_in_rule__Test__Group_4__15536);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2700:1: rule__Test__Group_4__1__Impl : ( ( rule__Test__ResultAssignment_4_1 ) ) ;
    public final void rule__Test__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2704:1: ( ( ( rule__Test__ResultAssignment_4_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2705:1: ( ( rule__Test__ResultAssignment_4_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2705:1: ( ( rule__Test__ResultAssignment_4_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2706:1: ( rule__Test__ResultAssignment_4_1 )
            {
             before(grammarAccess.getTestAccess().getResultAssignment_4_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2707:1: ( rule__Test__ResultAssignment_4_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2707:2: rule__Test__ResultAssignment_4_1
            {
            pushFollow(FOLLOW_rule__Test__ResultAssignment_4_1_in_rule__Test__Group_4__1__Impl5563);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2721:1: rule__TableTest__Group__0 : rule__TableTest__Group__0__Impl rule__TableTest__Group__1 ;
    public final void rule__TableTest__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2725:1: ( rule__TableTest__Group__0__Impl rule__TableTest__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2726:2: rule__TableTest__Group__0__Impl rule__TableTest__Group__1
            {
            pushFollow(FOLLOW_rule__TableTest__Group__0__Impl_in_rule__TableTest__Group__05597);
            rule__TableTest__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group__1_in_rule__TableTest__Group__05600);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2733:1: rule__TableTest__Group__0__Impl : ( 'tabletest' ) ;
    public final void rule__TableTest__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2737:1: ( ( 'tabletest' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2738:1: ( 'tabletest' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2738:1: ( 'tabletest' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2739:1: 'tabletest'
            {
             before(grammarAccess.getTableTestAccess().getTabletestKeyword_0()); 
            match(input,30,FOLLOW_30_in_rule__TableTest__Group__0__Impl5628); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2752:1: rule__TableTest__Group__1 : rule__TableTest__Group__1__Impl rule__TableTest__Group__2 ;
    public final void rule__TableTest__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2756:1: ( rule__TableTest__Group__1__Impl rule__TableTest__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2757:2: rule__TableTest__Group__1__Impl rule__TableTest__Group__2
            {
            pushFollow(FOLLOW_rule__TableTest__Group__1__Impl_in_rule__TableTest__Group__15659);
            rule__TableTest__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group__2_in_rule__TableTest__Group__15662);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2764:1: rule__TableTest__Group__1__Impl : ( ( rule__TableTest__DefinitionAssignment_1 ) ) ;
    public final void rule__TableTest__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2768:1: ( ( ( rule__TableTest__DefinitionAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2769:1: ( ( rule__TableTest__DefinitionAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2769:1: ( ( rule__TableTest__DefinitionAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2770:1: ( rule__TableTest__DefinitionAssignment_1 )
            {
             before(grammarAccess.getTableTestAccess().getDefinitionAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2771:1: ( rule__TableTest__DefinitionAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2771:2: rule__TableTest__DefinitionAssignment_1
            {
            pushFollow(FOLLOW_rule__TableTest__DefinitionAssignment_1_in_rule__TableTest__Group__1__Impl5689);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2781:1: rule__TableTest__Group__2 : rule__TableTest__Group__2__Impl rule__TableTest__Group__3 ;
    public final void rule__TableTest__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2785:1: ( rule__TableTest__Group__2__Impl rule__TableTest__Group__3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2786:2: rule__TableTest__Group__2__Impl rule__TableTest__Group__3
            {
            pushFollow(FOLLOW_rule__TableTest__Group__2__Impl_in_rule__TableTest__Group__25719);
            rule__TableTest__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group__3_in_rule__TableTest__Group__25722);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2793:1: rule__TableTest__Group__2__Impl : ( ( rule__TableTest__ParametersAssignment_2 )* ) ;
    public final void rule__TableTest__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2797:1: ( ( ( rule__TableTest__ParametersAssignment_2 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2798:1: ( ( rule__TableTest__ParametersAssignment_2 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2798:1: ( ( rule__TableTest__ParametersAssignment_2 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2799:1: ( rule__TableTest__ParametersAssignment_2 )*
            {
             before(grammarAccess.getTableTestAccess().getParametersAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2800:1: ( rule__TableTest__ParametersAssignment_2 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==RULE_ID||LA24_0==35) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2800:2: rule__TableTest__ParametersAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__TableTest__ParametersAssignment_2_in_rule__TableTest__Group__2__Impl5749);
            	    rule__TableTest__ParametersAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2810:1: rule__TableTest__Group__3 : rule__TableTest__Group__3__Impl rule__TableTest__Group__4 ;
    public final void rule__TableTest__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2814:1: ( rule__TableTest__Group__3__Impl rule__TableTest__Group__4 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2815:2: rule__TableTest__Group__3__Impl rule__TableTest__Group__4
            {
            pushFollow(FOLLOW_rule__TableTest__Group__3__Impl_in_rule__TableTest__Group__35780);
            rule__TableTest__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group__4_in_rule__TableTest__Group__35783);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2822:1: rule__TableTest__Group__3__Impl : ( ( rule__TableTest__ParameterHeadersAssignment_3 )* ) ;
    public final void rule__TableTest__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2826:1: ( ( ( rule__TableTest__ParameterHeadersAssignment_3 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2827:1: ( ( rule__TableTest__ParameterHeadersAssignment_3 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2827:1: ( ( rule__TableTest__ParameterHeadersAssignment_3 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2828:1: ( rule__TableTest__ParameterHeadersAssignment_3 )*
            {
             before(grammarAccess.getTableTestAccess().getParameterHeadersAssignment_3()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2829:1: ( rule__TableTest__ParameterHeadersAssignment_3 )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==13) ) {
                    int LA25_1 = input.LA(2);

                    if ( (LA25_1==RULE_ID) ) {
                        int LA25_2 = input.LA(3);

                        if ( (LA25_2==13) ) {
                            alt25=1;
                        }


                    }
                    else if ( (LA25_1==35) ) {
                        int LA25_3 = input.LA(3);

                        if ( (LA25_3==RULE_ID) ) {
                            int LA25_6 = input.LA(4);

                            if ( (LA25_6==13) ) {
                                alt25=1;
                            }


                        }


                    }


                }


                switch (alt25) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2829:2: rule__TableTest__ParameterHeadersAssignment_3
            	    {
            	    pushFollow(FOLLOW_rule__TableTest__ParameterHeadersAssignment_3_in_rule__TableTest__Group__3__Impl5810);
            	    rule__TableTest__ParameterHeadersAssignment_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2839:1: rule__TableTest__Group__4 : rule__TableTest__Group__4__Impl rule__TableTest__Group__5 ;
    public final void rule__TableTest__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2843:1: ( rule__TableTest__Group__4__Impl rule__TableTest__Group__5 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2844:2: rule__TableTest__Group__4__Impl rule__TableTest__Group__5
            {
            pushFollow(FOLLOW_rule__TableTest__Group__4__Impl_in_rule__TableTest__Group__45841);
            rule__TableTest__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group__5_in_rule__TableTest__Group__45844);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2851:1: rule__TableTest__Group__4__Impl : ( ( rule__TableTest__ResultHeadersAssignment_4 )* ) ;
    public final void rule__TableTest__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2855:1: ( ( ( rule__TableTest__ResultHeadersAssignment_4 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2856:1: ( ( rule__TableTest__ResultHeadersAssignment_4 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2856:1: ( ( rule__TableTest__ResultHeadersAssignment_4 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2857:1: ( rule__TableTest__ResultHeadersAssignment_4 )*
            {
             before(grammarAccess.getTableTestAccess().getResultHeadersAssignment_4()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2858:1: ( rule__TableTest__ResultHeadersAssignment_4 )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==13) ) {
                    int LA26_1 = input.LA(2);

                    if ( (LA26_1==RULE_ID||LA26_1==35) ) {
                        alt26=1;
                    }


                }


                switch (alt26) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2858:2: rule__TableTest__ResultHeadersAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__TableTest__ResultHeadersAssignment_4_in_rule__TableTest__Group__4__Impl5871);
            	    rule__TableTest__ResultHeadersAssignment_4();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2868:1: rule__TableTest__Group__5 : rule__TableTest__Group__5__Impl rule__TableTest__Group__6 ;
    public final void rule__TableTest__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2872:1: ( rule__TableTest__Group__5__Impl rule__TableTest__Group__6 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2873:2: rule__TableTest__Group__5__Impl rule__TableTest__Group__6
            {
            pushFollow(FOLLOW_rule__TableTest__Group__5__Impl_in_rule__TableTest__Group__55902);
            rule__TableTest__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group__6_in_rule__TableTest__Group__55905);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2880:1: rule__TableTest__Group__5__Impl : ( ( rule__TableTest__Alternatives_5 ) ) ;
    public final void rule__TableTest__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2884:1: ( ( ( rule__TableTest__Alternatives_5 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2885:1: ( ( rule__TableTest__Alternatives_5 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2885:1: ( ( rule__TableTest__Alternatives_5 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2886:1: ( rule__TableTest__Alternatives_5 )
            {
             before(grammarAccess.getTableTestAccess().getAlternatives_5()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2887:1: ( rule__TableTest__Alternatives_5 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2887:2: rule__TableTest__Alternatives_5
            {
            pushFollow(FOLLOW_rule__TableTest__Alternatives_5_in_rule__TableTest__Group__5__Impl5932);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2897:1: rule__TableTest__Group__6 : rule__TableTest__Group__6__Impl ;
    public final void rule__TableTest__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2901:1: ( rule__TableTest__Group__6__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2902:2: rule__TableTest__Group__6__Impl
            {
            pushFollow(FOLLOW_rule__TableTest__Group__6__Impl_in_rule__TableTest__Group__65962);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2908:1: rule__TableTest__Group__6__Impl : ( ( ( rule__TableTest__RowsAssignment_6 ) ) ( ( rule__TableTest__RowsAssignment_6 )* ) ) ;
    public final void rule__TableTest__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2912:1: ( ( ( ( rule__TableTest__RowsAssignment_6 ) ) ( ( rule__TableTest__RowsAssignment_6 )* ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2913:1: ( ( ( rule__TableTest__RowsAssignment_6 ) ) ( ( rule__TableTest__RowsAssignment_6 )* ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2913:1: ( ( ( rule__TableTest__RowsAssignment_6 ) ) ( ( rule__TableTest__RowsAssignment_6 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2914:1: ( ( rule__TableTest__RowsAssignment_6 ) ) ( ( rule__TableTest__RowsAssignment_6 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2914:1: ( ( rule__TableTest__RowsAssignment_6 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2915:1: ( rule__TableTest__RowsAssignment_6 )
            {
             before(grammarAccess.getTableTestAccess().getRowsAssignment_6()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2916:1: ( rule__TableTest__RowsAssignment_6 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2916:2: rule__TableTest__RowsAssignment_6
            {
            pushFollow(FOLLOW_rule__TableTest__RowsAssignment_6_in_rule__TableTest__Group__6__Impl5991);
            rule__TableTest__RowsAssignment_6();

            state._fsp--;


            }

             after(grammarAccess.getTableTestAccess().getRowsAssignment_6()); 

            }

            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2919:1: ( ( rule__TableTest__RowsAssignment_6 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2920:1: ( rule__TableTest__RowsAssignment_6 )*
            {
             before(grammarAccess.getTableTestAccess().getRowsAssignment_6()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2921:1: ( rule__TableTest__RowsAssignment_6 )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==13) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2921:2: rule__TableTest__RowsAssignment_6
            	    {
            	    pushFollow(FOLLOW_rule__TableTest__RowsAssignment_6_in_rule__TableTest__Group__6__Impl6003);
            	    rule__TableTest__RowsAssignment_6();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop27;
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2946:1: rule__TableTest__Group_5_0__0 : rule__TableTest__Group_5_0__0__Impl rule__TableTest__Group_5_0__1 ;
    public final void rule__TableTest__Group_5_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2950:1: ( rule__TableTest__Group_5_0__0__Impl rule__TableTest__Group_5_0__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2951:2: rule__TableTest__Group_5_0__0__Impl rule__TableTest__Group_5_0__1
            {
            pushFollow(FOLLOW_rule__TableTest__Group_5_0__0__Impl_in_rule__TableTest__Group_5_0__06050);
            rule__TableTest__Group_5_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group_5_0__1_in_rule__TableTest__Group_5_0__06053);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2958:1: rule__TableTest__Group_5_0__0__Impl : ( '|' ) ;
    public final void rule__TableTest__Group_5_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2962:1: ( ( '|' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2963:1: ( '|' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2963:1: ( '|' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2964:1: '|'
            {
             before(grammarAccess.getTableTestAccess().getVerticalLineKeyword_5_0_0()); 
            match(input,13,FOLLOW_13_in_rule__TableTest__Group_5_0__0__Impl6081); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2977:1: rule__TableTest__Group_5_0__1 : rule__TableTest__Group_5_0__1__Impl rule__TableTest__Group_5_0__2 ;
    public final void rule__TableTest__Group_5_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2981:1: ( rule__TableTest__Group_5_0__1__Impl rule__TableTest__Group_5_0__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2982:2: rule__TableTest__Group_5_0__1__Impl rule__TableTest__Group_5_0__2
            {
            pushFollow(FOLLOW_rule__TableTest__Group_5_0__1__Impl_in_rule__TableTest__Group_5_0__16112);
            rule__TableTest__Group_5_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTest__Group_5_0__2_in_rule__TableTest__Group_5_0__16115);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2989:1: rule__TableTest__Group_5_0__1__Impl : ( '=' ) ;
    public final void rule__TableTest__Group_5_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2993:1: ( ( '=' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2994:1: ( '=' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2994:1: ( '=' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:2995:1: '='
            {
             before(grammarAccess.getTableTestAccess().getEqualsSignKeyword_5_0_1()); 
            match(input,29,FOLLOW_29_in_rule__TableTest__Group_5_0__1__Impl6143); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3008:1: rule__TableTest__Group_5_0__2 : rule__TableTest__Group_5_0__2__Impl ;
    public final void rule__TableTest__Group_5_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3012:1: ( rule__TableTest__Group_5_0__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3013:2: rule__TableTest__Group_5_0__2__Impl
            {
            pushFollow(FOLLOW_rule__TableTest__Group_5_0__2__Impl_in_rule__TableTest__Group_5_0__26174);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3019:1: rule__TableTest__Group_5_0__2__Impl : ( '|' ) ;
    public final void rule__TableTest__Group_5_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3023:1: ( ( '|' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3024:1: ( '|' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3024:1: ( '|' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3025:1: '|'
            {
             before(grammarAccess.getTableTestAccess().getVerticalLineKeyword_5_0_2()); 
            match(input,13,FOLLOW_13_in_rule__TableTest__Group_5_0__2__Impl6202); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3044:1: rule__TableTestRow__Group__0 : rule__TableTestRow__Group__0__Impl rule__TableTestRow__Group__1 ;
    public final void rule__TableTestRow__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3048:1: ( rule__TableTestRow__Group__0__Impl rule__TableTestRow__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3049:2: rule__TableTestRow__Group__0__Impl rule__TableTestRow__Group__1
            {
            pushFollow(FOLLOW_rule__TableTestRow__Group__0__Impl_in_rule__TableTestRow__Group__06239);
            rule__TableTestRow__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTestRow__Group__1_in_rule__TableTestRow__Group__06242);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3056:1: rule__TableTestRow__Group__0__Impl : ( () ) ;
    public final void rule__TableTestRow__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3060:1: ( ( () ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3061:1: ( () )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3061:1: ( () )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3062:1: ()
            {
             before(grammarAccess.getTableTestRowAccess().getTableTestRowAction_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3063:1: ()
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3065:1: 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3075:1: rule__TableTestRow__Group__1 : rule__TableTestRow__Group__1__Impl rule__TableTestRow__Group__2 ;
    public final void rule__TableTestRow__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3079:1: ( rule__TableTestRow__Group__1__Impl rule__TableTestRow__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3080:2: rule__TableTestRow__Group__1__Impl rule__TableTestRow__Group__2
            {
            pushFollow(FOLLOW_rule__TableTestRow__Group__1__Impl_in_rule__TableTestRow__Group__16300);
            rule__TableTestRow__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTestRow__Group__2_in_rule__TableTestRow__Group__16303);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3087:1: rule__TableTestRow__Group__1__Impl : ( ( rule__TableTestRow__ValuesAssignment_1 )* ) ;
    public final void rule__TableTestRow__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3091:1: ( ( ( rule__TableTestRow__ValuesAssignment_1 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3092:1: ( ( rule__TableTestRow__ValuesAssignment_1 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3092:1: ( ( rule__TableTestRow__ValuesAssignment_1 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3093:1: ( rule__TableTestRow__ValuesAssignment_1 )*
            {
             before(grammarAccess.getTableTestRowAccess().getValuesAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3094:1: ( rule__TableTestRow__ValuesAssignment_1 )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==13) ) {
                    int LA28_1 = input.LA(2);

                    if ( ((LA28_1>=RULE_ID && LA28_1<=RULE_STRING)) ) {
                        alt28=1;
                    }


                }


                switch (alt28) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3094:2: rule__TableTestRow__ValuesAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__TableTestRow__ValuesAssignment_1_in_rule__TableTestRow__Group__1__Impl6330);
            	    rule__TableTestRow__ValuesAssignment_1();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3104:1: rule__TableTestRow__Group__2 : rule__TableTestRow__Group__2__Impl ;
    public final void rule__TableTestRow__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3108:1: ( rule__TableTestRow__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3109:2: rule__TableTestRow__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__TableTestRow__Group__2__Impl_in_rule__TableTestRow__Group__26361);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3115:1: rule__TableTestRow__Group__2__Impl : ( ( rule__TableTestRow__Alternatives_2 ) ) ;
    public final void rule__TableTestRow__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3119:1: ( ( ( rule__TableTestRow__Alternatives_2 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3120:1: ( ( rule__TableTestRow__Alternatives_2 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3120:1: ( ( rule__TableTestRow__Alternatives_2 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3121:1: ( rule__TableTestRow__Alternatives_2 )
            {
             before(grammarAccess.getTableTestRowAccess().getAlternatives_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3122:1: ( rule__TableTestRow__Alternatives_2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3122:2: rule__TableTestRow__Alternatives_2
            {
            pushFollow(FOLLOW_rule__TableTestRow__Alternatives_2_in_rule__TableTestRow__Group__2__Impl6388);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3138:1: rule__TableTestRow__Group_2_0__0 : rule__TableTestRow__Group_2_0__0__Impl rule__TableTestRow__Group_2_0__1 ;
    public final void rule__TableTestRow__Group_2_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3142:1: ( rule__TableTestRow__Group_2_0__0__Impl rule__TableTestRow__Group_2_0__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3143:2: rule__TableTestRow__Group_2_0__0__Impl rule__TableTestRow__Group_2_0__1
            {
            pushFollow(FOLLOW_rule__TableTestRow__Group_2_0__0__Impl_in_rule__TableTestRow__Group_2_0__06424);
            rule__TableTestRow__Group_2_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTestRow__Group_2_0__1_in_rule__TableTestRow__Group_2_0__06427);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3150:1: rule__TableTestRow__Group_2_0__0__Impl : ( '|' ) ;
    public final void rule__TableTestRow__Group_2_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3154:1: ( ( '|' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3155:1: ( '|' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3155:1: ( '|' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3156:1: '|'
            {
             before(grammarAccess.getTableTestRowAccess().getVerticalLineKeyword_2_0_0()); 
            match(input,13,FOLLOW_13_in_rule__TableTestRow__Group_2_0__0__Impl6455); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3169:1: rule__TableTestRow__Group_2_0__1 : rule__TableTestRow__Group_2_0__1__Impl rule__TableTestRow__Group_2_0__2 ;
    public final void rule__TableTestRow__Group_2_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3173:1: ( rule__TableTestRow__Group_2_0__1__Impl rule__TableTestRow__Group_2_0__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3174:2: rule__TableTestRow__Group_2_0__1__Impl rule__TableTestRow__Group_2_0__2
            {
            pushFollow(FOLLOW_rule__TableTestRow__Group_2_0__1__Impl_in_rule__TableTestRow__Group_2_0__16486);
            rule__TableTestRow__Group_2_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTestRow__Group_2_0__2_in_rule__TableTestRow__Group_2_0__16489);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3181:1: rule__TableTestRow__Group_2_0__1__Impl : ( '=' ) ;
    public final void rule__TableTestRow__Group_2_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3185:1: ( ( '=' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3186:1: ( '=' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3186:1: ( '=' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3187:1: '='
            {
             before(grammarAccess.getTableTestRowAccess().getEqualsSignKeyword_2_0_1()); 
            match(input,29,FOLLOW_29_in_rule__TableTestRow__Group_2_0__1__Impl6517); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3200:1: rule__TableTestRow__Group_2_0__2 : rule__TableTestRow__Group_2_0__2__Impl rule__TableTestRow__Group_2_0__3 ;
    public final void rule__TableTestRow__Group_2_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3204:1: ( rule__TableTestRow__Group_2_0__2__Impl rule__TableTestRow__Group_2_0__3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3205:2: rule__TableTestRow__Group_2_0__2__Impl rule__TableTestRow__Group_2_0__3
            {
            pushFollow(FOLLOW_rule__TableTestRow__Group_2_0__2__Impl_in_rule__TableTestRow__Group_2_0__26548);
            rule__TableTestRow__Group_2_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TableTestRow__Group_2_0__3_in_rule__TableTestRow__Group_2_0__26551);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3212:1: rule__TableTestRow__Group_2_0__2__Impl : ( ( rule__TableTestRow__ResultAssignment_2_0_2 ) ) ;
    public final void rule__TableTestRow__Group_2_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3216:1: ( ( ( rule__TableTestRow__ResultAssignment_2_0_2 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3217:1: ( ( rule__TableTestRow__ResultAssignment_2_0_2 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3217:1: ( ( rule__TableTestRow__ResultAssignment_2_0_2 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3218:1: ( rule__TableTestRow__ResultAssignment_2_0_2 )
            {
             before(grammarAccess.getTableTestRowAccess().getResultAssignment_2_0_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3219:1: ( rule__TableTestRow__ResultAssignment_2_0_2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3219:2: rule__TableTestRow__ResultAssignment_2_0_2
            {
            pushFollow(FOLLOW_rule__TableTestRow__ResultAssignment_2_0_2_in_rule__TableTestRow__Group_2_0__2__Impl6578);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3229:1: rule__TableTestRow__Group_2_0__3 : rule__TableTestRow__Group_2_0__3__Impl ;
    public final void rule__TableTestRow__Group_2_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3233:1: ( rule__TableTestRow__Group_2_0__3__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3234:2: rule__TableTestRow__Group_2_0__3__Impl
            {
            pushFollow(FOLLOW_rule__TableTestRow__Group_2_0__3__Impl_in_rule__TableTestRow__Group_2_0__36608);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3240:1: rule__TableTestRow__Group_2_0__3__Impl : ( '|' ) ;
    public final void rule__TableTestRow__Group_2_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3244:1: ( ( '|' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3245:1: ( '|' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3245:1: ( '|' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3246:1: '|'
            {
             before(grammarAccess.getTableTestRowAccess().getVerticalLineKeyword_2_0_3()); 
            match(input,13,FOLLOW_13_in_rule__TableTestRow__Group_2_0__3__Impl6636); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3267:1: rule__ParameterTableHeader__Group__0 : rule__ParameterTableHeader__Group__0__Impl rule__ParameterTableHeader__Group__1 ;
    public final void rule__ParameterTableHeader__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3271:1: ( rule__ParameterTableHeader__Group__0__Impl rule__ParameterTableHeader__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3272:2: rule__ParameterTableHeader__Group__0__Impl rule__ParameterTableHeader__Group__1
            {
            pushFollow(FOLLOW_rule__ParameterTableHeader__Group__0__Impl_in_rule__ParameterTableHeader__Group__06675);
            rule__ParameterTableHeader__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParameterTableHeader__Group__1_in_rule__ParameterTableHeader__Group__06678);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3279:1: rule__ParameterTableHeader__Group__0__Impl : ( '|' ) ;
    public final void rule__ParameterTableHeader__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3283:1: ( ( '|' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3284:1: ( '|' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3284:1: ( '|' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3285:1: '|'
            {
             before(grammarAccess.getParameterTableHeaderAccess().getVerticalLineKeyword_0()); 
            match(input,13,FOLLOW_13_in_rule__ParameterTableHeader__Group__0__Impl6706); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3298:1: rule__ParameterTableHeader__Group__1 : rule__ParameterTableHeader__Group__1__Impl ;
    public final void rule__ParameterTableHeader__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3302:1: ( rule__ParameterTableHeader__Group__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3303:2: rule__ParameterTableHeader__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ParameterTableHeader__Group__1__Impl_in_rule__ParameterTableHeader__Group__16737);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3309:1: rule__ParameterTableHeader__Group__1__Impl : ( ( rule__ParameterTableHeader__NameAssignment_1 ) ) ;
    public final void rule__ParameterTableHeader__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3313:1: ( ( ( rule__ParameterTableHeader__NameAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3314:1: ( ( rule__ParameterTableHeader__NameAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3314:1: ( ( rule__ParameterTableHeader__NameAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3315:1: ( rule__ParameterTableHeader__NameAssignment_1 )
            {
             before(grammarAccess.getParameterTableHeaderAccess().getNameAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3316:1: ( rule__ParameterTableHeader__NameAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3316:2: rule__ParameterTableHeader__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ParameterTableHeader__NameAssignment_1_in_rule__ParameterTableHeader__Group__1__Impl6764);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3330:1: rule__ResultTableHeader__Group__0 : rule__ResultTableHeader__Group__0__Impl rule__ResultTableHeader__Group__1 ;
    public final void rule__ResultTableHeader__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3334:1: ( rule__ResultTableHeader__Group__0__Impl rule__ResultTableHeader__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3335:2: rule__ResultTableHeader__Group__0__Impl rule__ResultTableHeader__Group__1
            {
            pushFollow(FOLLOW_rule__ResultTableHeader__Group__0__Impl_in_rule__ResultTableHeader__Group__06798);
            rule__ResultTableHeader__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultTableHeader__Group__1_in_rule__ResultTableHeader__Group__06801);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3342:1: rule__ResultTableHeader__Group__0__Impl : ( '|' ) ;
    public final void rule__ResultTableHeader__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3346:1: ( ( '|' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3347:1: ( '|' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3347:1: ( '|' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3348:1: '|'
            {
             before(grammarAccess.getResultTableHeaderAccess().getVerticalLineKeyword_0()); 
            match(input,13,FOLLOW_13_in_rule__ResultTableHeader__Group__0__Impl6829); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3361:1: rule__ResultTableHeader__Group__1 : rule__ResultTableHeader__Group__1__Impl rule__ResultTableHeader__Group__2 ;
    public final void rule__ResultTableHeader__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3365:1: ( rule__ResultTableHeader__Group__1__Impl rule__ResultTableHeader__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3366:2: rule__ResultTableHeader__Group__1__Impl rule__ResultTableHeader__Group__2
            {
            pushFollow(FOLLOW_rule__ResultTableHeader__Group__1__Impl_in_rule__ResultTableHeader__Group__16860);
            rule__ResultTableHeader__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ResultTableHeader__Group__2_in_rule__ResultTableHeader__Group__16863);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3373:1: rule__ResultTableHeader__Group__1__Impl : ( ( rule__ResultTableHeader__NameAssignment_1 ) ) ;
    public final void rule__ResultTableHeader__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3377:1: ( ( ( rule__ResultTableHeader__NameAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3378:1: ( ( rule__ResultTableHeader__NameAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3378:1: ( ( rule__ResultTableHeader__NameAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3379:1: ( rule__ResultTableHeader__NameAssignment_1 )
            {
             before(grammarAccess.getResultTableHeaderAccess().getNameAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3380:1: ( rule__ResultTableHeader__NameAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3380:2: rule__ResultTableHeader__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__ResultTableHeader__NameAssignment_1_in_rule__ResultTableHeader__Group__1__Impl6890);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3390:1: rule__ResultTableHeader__Group__2 : rule__ResultTableHeader__Group__2__Impl ;
    public final void rule__ResultTableHeader__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3394:1: ( rule__ResultTableHeader__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3395:2: rule__ResultTableHeader__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__ResultTableHeader__Group__2__Impl_in_rule__ResultTableHeader__Group__26920);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3401:1: rule__ResultTableHeader__Group__2__Impl : ( '=' ) ;
    public final void rule__ResultTableHeader__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3405:1: ( ( '=' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3406:1: ( '=' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3406:1: ( '=' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3407:1: '='
            {
             before(grammarAccess.getResultTableHeaderAccess().getEqualsSignKeyword_2()); 
            match(input,29,FOLLOW_29_in_rule__ResultTableHeader__Group__2__Impl6948); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3426:1: rule__ParameterTableValue__Group__0 : rule__ParameterTableValue__Group__0__Impl rule__ParameterTableValue__Group__1 ;
    public final void rule__ParameterTableValue__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3430:1: ( rule__ParameterTableValue__Group__0__Impl rule__ParameterTableValue__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3431:2: rule__ParameterTableValue__Group__0__Impl rule__ParameterTableValue__Group__1
            {
            pushFollow(FOLLOW_rule__ParameterTableValue__Group__0__Impl_in_rule__ParameterTableValue__Group__06985);
            rule__ParameterTableValue__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ParameterTableValue__Group__1_in_rule__ParameterTableValue__Group__06988);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3438:1: rule__ParameterTableValue__Group__0__Impl : ( '|' ) ;
    public final void rule__ParameterTableValue__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3442:1: ( ( '|' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3443:1: ( '|' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3443:1: ( '|' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3444:1: '|'
            {
             before(grammarAccess.getParameterTableValueAccess().getVerticalLineKeyword_0()); 
            match(input,13,FOLLOW_13_in_rule__ParameterTableValue__Group__0__Impl7016); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3457:1: rule__ParameterTableValue__Group__1 : rule__ParameterTableValue__Group__1__Impl ;
    public final void rule__ParameterTableValue__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3461:1: ( rule__ParameterTableValue__Group__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3462:2: rule__ParameterTableValue__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ParameterTableValue__Group__1__Impl_in_rule__ParameterTableValue__Group__17047);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3468:1: rule__ParameterTableValue__Group__1__Impl : ( ( rule__ParameterTableValue__ValueAssignment_1 ) ) ;
    public final void rule__ParameterTableValue__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3472:1: ( ( ( rule__ParameterTableValue__ValueAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3473:1: ( ( rule__ParameterTableValue__ValueAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3473:1: ( ( rule__ParameterTableValue__ValueAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3474:1: ( rule__ParameterTableValue__ValueAssignment_1 )
            {
             before(grammarAccess.getParameterTableValueAccess().getValueAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3475:1: ( rule__ParameterTableValue__ValueAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3475:2: rule__ParameterTableValue__ValueAssignment_1
            {
            pushFollow(FOLLOW_rule__ParameterTableValue__ValueAssignment_1_in_rule__ParameterTableValue__Group__1__Impl7074);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3489:1: rule__NamedResult__Group__0 : rule__NamedResult__Group__0__Impl rule__NamedResult__Group__1 ;
    public final void rule__NamedResult__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3493:1: ( rule__NamedResult__Group__0__Impl rule__NamedResult__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3494:2: rule__NamedResult__Group__0__Impl rule__NamedResult__Group__1
            {
            pushFollow(FOLLOW_rule__NamedResult__Group__0__Impl_in_rule__NamedResult__Group__07108);
            rule__NamedResult__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NamedResult__Group__1_in_rule__NamedResult__Group__07111);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3501:1: rule__NamedResult__Group__0__Impl : ( ( rule__NamedResult__NameAssignment_0 ) ) ;
    public final void rule__NamedResult__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3505:1: ( ( ( rule__NamedResult__NameAssignment_0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3506:1: ( ( rule__NamedResult__NameAssignment_0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3506:1: ( ( rule__NamedResult__NameAssignment_0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3507:1: ( rule__NamedResult__NameAssignment_0 )
            {
             before(grammarAccess.getNamedResultAccess().getNameAssignment_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3508:1: ( rule__NamedResult__NameAssignment_0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3508:2: rule__NamedResult__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__NamedResult__NameAssignment_0_in_rule__NamedResult__Group__0__Impl7138);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3518:1: rule__NamedResult__Group__1 : rule__NamedResult__Group__1__Impl rule__NamedResult__Group__2 ;
    public final void rule__NamedResult__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3522:1: ( rule__NamedResult__Group__1__Impl rule__NamedResult__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3523:2: rule__NamedResult__Group__1__Impl rule__NamedResult__Group__2
            {
            pushFollow(FOLLOW_rule__NamedResult__Group__1__Impl_in_rule__NamedResult__Group__17168);
            rule__NamedResult__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__NamedResult__Group__2_in_rule__NamedResult__Group__17171);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3530:1: rule__NamedResult__Group__1__Impl : ( '=' ) ;
    public final void rule__NamedResult__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3534:1: ( ( '=' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3535:1: ( '=' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3535:1: ( '=' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3536:1: '='
            {
             before(grammarAccess.getNamedResultAccess().getEqualsSignKeyword_1()); 
            match(input,29,FOLLOW_29_in_rule__NamedResult__Group__1__Impl7199); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3549:1: rule__NamedResult__Group__2 : rule__NamedResult__Group__2__Impl ;
    public final void rule__NamedResult__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3553:1: ( rule__NamedResult__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3554:2: rule__NamedResult__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__NamedResult__Group__2__Impl_in_rule__NamedResult__Group__27230);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3560:1: rule__NamedResult__Group__2__Impl : ( ( rule__NamedResult__ValueAssignment_2 ) ) ;
    public final void rule__NamedResult__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3564:1: ( ( ( rule__NamedResult__ValueAssignment_2 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3565:1: ( ( rule__NamedResult__ValueAssignment_2 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3565:1: ( ( rule__NamedResult__ValueAssignment_2 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3566:1: ( rule__NamedResult__ValueAssignment_2 )
            {
             before(grammarAccess.getNamedResultAccess().getValueAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3567:1: ( rule__NamedResult__ValueAssignment_2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3567:2: rule__NamedResult__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__NamedResult__ValueAssignment_2_in_rule__NamedResult__Group__2__Impl7257);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3583:1: rule__Call__Group__0 : rule__Call__Group__0__Impl rule__Call__Group__1 ;
    public final void rule__Call__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3587:1: ( rule__Call__Group__0__Impl rule__Call__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3588:2: rule__Call__Group__0__Impl rule__Call__Group__1
            {
            pushFollow(FOLLOW_rule__Call__Group__0__Impl_in_rule__Call__Group__07293);
            rule__Call__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group__1_in_rule__Call__Group__07296);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3595:1: rule__Call__Group__0__Impl : ( 'call' ) ;
    public final void rule__Call__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3599:1: ( ( 'call' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3600:1: ( 'call' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3600:1: ( 'call' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3601:1: 'call'
            {
             before(grammarAccess.getCallAccess().getCallKeyword_0()); 
            match(input,31,FOLLOW_31_in_rule__Call__Group__0__Impl7324); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3614:1: rule__Call__Group__1 : rule__Call__Group__1__Impl rule__Call__Group__2 ;
    public final void rule__Call__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3618:1: ( rule__Call__Group__1__Impl rule__Call__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3619:2: rule__Call__Group__1__Impl rule__Call__Group__2
            {
            pushFollow(FOLLOW_rule__Call__Group__1__Impl_in_rule__Call__Group__17355);
            rule__Call__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group__2_in_rule__Call__Group__17358);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3626:1: rule__Call__Group__1__Impl : ( ( rule__Call__DefinitionAssignment_1 ) ) ;
    public final void rule__Call__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3630:1: ( ( ( rule__Call__DefinitionAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3631:1: ( ( rule__Call__DefinitionAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3631:1: ( ( rule__Call__DefinitionAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3632:1: ( rule__Call__DefinitionAssignment_1 )
            {
             before(grammarAccess.getCallAccess().getDefinitionAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3633:1: ( rule__Call__DefinitionAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3633:2: rule__Call__DefinitionAssignment_1
            {
            pushFollow(FOLLOW_rule__Call__DefinitionAssignment_1_in_rule__Call__Group__1__Impl7385);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3643:1: rule__Call__Group__2 : rule__Call__Group__2__Impl rule__Call__Group__3 ;
    public final void rule__Call__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3647:1: ( rule__Call__Group__2__Impl rule__Call__Group__3 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3648:2: rule__Call__Group__2__Impl rule__Call__Group__3
            {
            pushFollow(FOLLOW_rule__Call__Group__2__Impl_in_rule__Call__Group__27415);
            rule__Call__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group__3_in_rule__Call__Group__27418);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3655:1: rule__Call__Group__2__Impl : ( ( rule__Call__ParametersAssignment_2 )* ) ;
    public final void rule__Call__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3659:1: ( ( ( rule__Call__ParametersAssignment_2 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3660:1: ( ( rule__Call__ParametersAssignment_2 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3660:1: ( ( rule__Call__ParametersAssignment_2 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3661:1: ( rule__Call__ParametersAssignment_2 )*
            {
             before(grammarAccess.getCallAccess().getParametersAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3662:1: ( rule__Call__ParametersAssignment_2 )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_ID||LA29_0==35) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3662:2: rule__Call__ParametersAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Call__ParametersAssignment_2_in_rule__Call__Group__2__Impl7445);
            	    rule__Call__ParametersAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop29;
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3672:1: rule__Call__Group__3 : rule__Call__Group__3__Impl ;
    public final void rule__Call__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3676:1: ( rule__Call__Group__3__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3677:2: rule__Call__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__Call__Group__3__Impl_in_rule__Call__Group__37476);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3683:1: rule__Call__Group__3__Impl : ( ( rule__Call__Group_3__0 )? ) ;
    public final void rule__Call__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3687:1: ( ( ( rule__Call__Group_3__0 )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3688:1: ( ( rule__Call__Group_3__0 )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3688:1: ( ( rule__Call__Group_3__0 )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3689:1: ( rule__Call__Group_3__0 )?
            {
             before(grammarAccess.getCallAccess().getGroup_3()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3690:1: ( rule__Call__Group_3__0 )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==32) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3690:2: rule__Call__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__Call__Group_3__0_in_rule__Call__Group__3__Impl7503);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3708:1: rule__Call__Group_3__0 : rule__Call__Group_3__0__Impl rule__Call__Group_3__1 ;
    public final void rule__Call__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3712:1: ( rule__Call__Group_3__0__Impl rule__Call__Group_3__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3713:2: rule__Call__Group_3__0__Impl rule__Call__Group_3__1
            {
            pushFollow(FOLLOW_rule__Call__Group_3__0__Impl_in_rule__Call__Group_3__07542);
            rule__Call__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Call__Group_3__1_in_rule__Call__Group_3__07545);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3720:1: rule__Call__Group_3__0__Impl : ( 'sets' ) ;
    public final void rule__Call__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3724:1: ( ( 'sets' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3725:1: ( 'sets' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3725:1: ( 'sets' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3726:1: 'sets'
            {
             before(grammarAccess.getCallAccess().getSetsKeyword_3_0()); 
            match(input,32,FOLLOW_32_in_rule__Call__Group_3__0__Impl7573); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3739:1: rule__Call__Group_3__1 : rule__Call__Group_3__1__Impl ;
    public final void rule__Call__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3743:1: ( rule__Call__Group_3__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3744:2: rule__Call__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Call__Group_3__1__Impl_in_rule__Call__Group_3__17604);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3750:1: rule__Call__Group_3__1__Impl : ( ( rule__Call__ResultAssignment_3_1 ) ) ;
    public final void rule__Call__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3754:1: ( ( ( rule__Call__ResultAssignment_3_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3755:1: ( ( rule__Call__ResultAssignment_3_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3755:1: ( ( rule__Call__ResultAssignment_3_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3756:1: ( rule__Call__ResultAssignment_3_1 )
            {
             before(grammarAccess.getCallAccess().getResultAssignment_3_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3757:1: ( rule__Call__ResultAssignment_3_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3757:2: rule__Call__ResultAssignment_3_1
            {
            pushFollow(FOLLOW_rule__Call__ResultAssignment_3_1_in_rule__Call__Group_3__1__Impl7631);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3771:1: rule__Suite__Group__0 : rule__Suite__Group__0__Impl rule__Suite__Group__1 ;
    public final void rule__Suite__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3775:1: ( rule__Suite__Group__0__Impl rule__Suite__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3776:2: rule__Suite__Group__0__Impl rule__Suite__Group__1
            {
            pushFollow(FOLLOW_rule__Suite__Group__0__Impl_in_rule__Suite__Group__07665);
            rule__Suite__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Suite__Group__1_in_rule__Suite__Group__07668);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3783:1: rule__Suite__Group__0__Impl : ( 'suite' ) ;
    public final void rule__Suite__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3787:1: ( ( 'suite' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3788:1: ( 'suite' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3788:1: ( 'suite' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3789:1: 'suite'
            {
             before(grammarAccess.getSuiteAccess().getSuiteKeyword_0()); 
            match(input,33,FOLLOW_33_in_rule__Suite__Group__0__Impl7696); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3802:1: rule__Suite__Group__1 : rule__Suite__Group__1__Impl rule__Suite__Group__2 ;
    public final void rule__Suite__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3806:1: ( rule__Suite__Group__1__Impl rule__Suite__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3807:2: rule__Suite__Group__1__Impl rule__Suite__Group__2
            {
            pushFollow(FOLLOW_rule__Suite__Group__1__Impl_in_rule__Suite__Group__17727);
            rule__Suite__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Suite__Group__2_in_rule__Suite__Group__17730);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3814:1: rule__Suite__Group__1__Impl : ( ( rule__Suite__DefinitionAssignment_1 ) ) ;
    public final void rule__Suite__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3818:1: ( ( ( rule__Suite__DefinitionAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3819:1: ( ( rule__Suite__DefinitionAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3819:1: ( ( rule__Suite__DefinitionAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3820:1: ( rule__Suite__DefinitionAssignment_1 )
            {
             before(grammarAccess.getSuiteAccess().getDefinitionAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3821:1: ( rule__Suite__DefinitionAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3821:2: rule__Suite__DefinitionAssignment_1
            {
            pushFollow(FOLLOW_rule__Suite__DefinitionAssignment_1_in_rule__Suite__Group__1__Impl7757);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3831:1: rule__Suite__Group__2 : rule__Suite__Group__2__Impl ;
    public final void rule__Suite__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3835:1: ( rule__Suite__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3836:2: rule__Suite__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Suite__Group__2__Impl_in_rule__Suite__Group__27787);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3842:1: rule__Suite__Group__2__Impl : ( ( rule__Suite__ParametersAssignment_2 )* ) ;
    public final void rule__Suite__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3846:1: ( ( ( rule__Suite__ParametersAssignment_2 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3847:1: ( ( rule__Suite__ParametersAssignment_2 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3847:1: ( ( rule__Suite__ParametersAssignment_2 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3848:1: ( rule__Suite__ParametersAssignment_2 )*
            {
             before(grammarAccess.getSuiteAccess().getParametersAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3849:1: ( rule__Suite__ParametersAssignment_2 )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==RULE_ID) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3849:2: rule__Suite__ParametersAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Suite__ParametersAssignment_2_in_rule__Suite__Group__2__Impl7814);
            	    rule__Suite__ParametersAssignment_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop31;
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3865:1: rule__SuiteParameter__Group__0 : rule__SuiteParameter__Group__0__Impl rule__SuiteParameter__Group__1 ;
    public final void rule__SuiteParameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3869:1: ( rule__SuiteParameter__Group__0__Impl rule__SuiteParameter__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3870:2: rule__SuiteParameter__Group__0__Impl rule__SuiteParameter__Group__1
            {
            pushFollow(FOLLOW_rule__SuiteParameter__Group__0__Impl_in_rule__SuiteParameter__Group__07851);
            rule__SuiteParameter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteParameter__Group__1_in_rule__SuiteParameter__Group__07854);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3877:1: rule__SuiteParameter__Group__0__Impl : ( ( rule__SuiteParameter__NameAssignment_0 ) ) ;
    public final void rule__SuiteParameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3881:1: ( ( ( rule__SuiteParameter__NameAssignment_0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3882:1: ( ( rule__SuiteParameter__NameAssignment_0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3882:1: ( ( rule__SuiteParameter__NameAssignment_0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3883:1: ( rule__SuiteParameter__NameAssignment_0 )
            {
             before(grammarAccess.getSuiteParameterAccess().getNameAssignment_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3884:1: ( rule__SuiteParameter__NameAssignment_0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3884:2: rule__SuiteParameter__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__SuiteParameter__NameAssignment_0_in_rule__SuiteParameter__Group__0__Impl7881);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3894:1: rule__SuiteParameter__Group__1 : rule__SuiteParameter__Group__1__Impl rule__SuiteParameter__Group__2 ;
    public final void rule__SuiteParameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3898:1: ( rule__SuiteParameter__Group__1__Impl rule__SuiteParameter__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3899:2: rule__SuiteParameter__Group__1__Impl rule__SuiteParameter__Group__2
            {
            pushFollow(FOLLOW_rule__SuiteParameter__Group__1__Impl_in_rule__SuiteParameter__Group__17911);
            rule__SuiteParameter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__SuiteParameter__Group__2_in_rule__SuiteParameter__Group__17914);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3906:1: rule__SuiteParameter__Group__1__Impl : ( ':' ) ;
    public final void rule__SuiteParameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3910:1: ( ( ':' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3911:1: ( ':' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3911:1: ( ':' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3912:1: ':'
            {
             before(grammarAccess.getSuiteParameterAccess().getColonKeyword_1()); 
            match(input,34,FOLLOW_34_in_rule__SuiteParameter__Group__1__Impl7942); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3925:1: rule__SuiteParameter__Group__2 : rule__SuiteParameter__Group__2__Impl ;
    public final void rule__SuiteParameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3929:1: ( rule__SuiteParameter__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3930:2: rule__SuiteParameter__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__SuiteParameter__Group__2__Impl_in_rule__SuiteParameter__Group__27973);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3936:1: rule__SuiteParameter__Group__2__Impl : ( ( rule__SuiteParameter__ValueAssignment_2 ) ) ;
    public final void rule__SuiteParameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3940:1: ( ( ( rule__SuiteParameter__ValueAssignment_2 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3941:1: ( ( rule__SuiteParameter__ValueAssignment_2 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3941:1: ( ( rule__SuiteParameter__ValueAssignment_2 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3942:1: ( rule__SuiteParameter__ValueAssignment_2 )
            {
             before(grammarAccess.getSuiteParameterAccess().getValueAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3943:1: ( rule__SuiteParameter__ValueAssignment_2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3943:2: rule__SuiteParameter__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__SuiteParameter__ValueAssignment_2_in_rule__SuiteParameter__Group__2__Impl8000);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3959:1: rule__Parameter__Group__0 : rule__Parameter__Group__0__Impl rule__Parameter__Group__1 ;
    public final void rule__Parameter__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3963:1: ( rule__Parameter__Group__0__Impl rule__Parameter__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3964:2: rule__Parameter__Group__0__Impl rule__Parameter__Group__1
            {
            pushFollow(FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__08036);
            rule__Parameter__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__08039);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3971:1: rule__Parameter__Group__0__Impl : ( ( rule__Parameter__NameAssignment_0 ) ) ;
    public final void rule__Parameter__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3975:1: ( ( ( rule__Parameter__NameAssignment_0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3976:1: ( ( rule__Parameter__NameAssignment_0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3976:1: ( ( rule__Parameter__NameAssignment_0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3977:1: ( rule__Parameter__NameAssignment_0 )
            {
             before(grammarAccess.getParameterAccess().getNameAssignment_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3978:1: ( rule__Parameter__NameAssignment_0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3978:2: rule__Parameter__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Parameter__NameAssignment_0_in_rule__Parameter__Group__0__Impl8066);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3988:1: rule__Parameter__Group__1 : rule__Parameter__Group__1__Impl rule__Parameter__Group__2 ;
    public final void rule__Parameter__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3992:1: ( rule__Parameter__Group__1__Impl rule__Parameter__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:3993:2: rule__Parameter__Group__1__Impl rule__Parameter__Group__2
            {
            pushFollow(FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__18096);
            rule__Parameter__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Parameter__Group__2_in_rule__Parameter__Group__18099);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4000:1: rule__Parameter__Group__1__Impl : ( ':' ) ;
    public final void rule__Parameter__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4004:1: ( ( ':' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4005:1: ( ':' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4005:1: ( ':' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4006:1: ':'
            {
             before(grammarAccess.getParameterAccess().getColonKeyword_1()); 
            match(input,34,FOLLOW_34_in_rule__Parameter__Group__1__Impl8127); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4019:1: rule__Parameter__Group__2 : rule__Parameter__Group__2__Impl ;
    public final void rule__Parameter__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4023:1: ( rule__Parameter__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4024:2: rule__Parameter__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__Parameter__Group__2__Impl_in_rule__Parameter__Group__28158);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4030:1: rule__Parameter__Group__2__Impl : ( ( rule__Parameter__ValueAssignment_2 ) ) ;
    public final void rule__Parameter__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4034:1: ( ( ( rule__Parameter__ValueAssignment_2 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4035:1: ( ( rule__Parameter__ValueAssignment_2 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4035:1: ( ( rule__Parameter__ValueAssignment_2 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4036:1: ( rule__Parameter__ValueAssignment_2 )
            {
             before(grammarAccess.getParameterAccess().getValueAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4037:1: ( rule__Parameter__ValueAssignment_2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4037:2: rule__Parameter__ValueAssignment_2
            {
            pushFollow(FOLLOW_rule__Parameter__ValueAssignment_2_in_rule__Parameter__Group__2__Impl8185);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4053:1: rule__ArbitraryParameterOrResultName__Group__0 : rule__ArbitraryParameterOrResultName__Group__0__Impl rule__ArbitraryParameterOrResultName__Group__1 ;
    public final void rule__ArbitraryParameterOrResultName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4057:1: ( rule__ArbitraryParameterOrResultName__Group__0__Impl rule__ArbitraryParameterOrResultName__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4058:2: rule__ArbitraryParameterOrResultName__Group__0__Impl rule__ArbitraryParameterOrResultName__Group__1
            {
            pushFollow(FOLLOW_rule__ArbitraryParameterOrResultName__Group__0__Impl_in_rule__ArbitraryParameterOrResultName__Group__08221);
            rule__ArbitraryParameterOrResultName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ArbitraryParameterOrResultName__Group__1_in_rule__ArbitraryParameterOrResultName__Group__08224);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4065:1: rule__ArbitraryParameterOrResultName__Group__0__Impl : ( '+' ) ;
    public final void rule__ArbitraryParameterOrResultName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4069:1: ( ( '+' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4070:1: ( '+' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4070:1: ( '+' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4071:1: '+'
            {
             before(grammarAccess.getArbitraryParameterOrResultNameAccess().getPlusSignKeyword_0()); 
            match(input,35,FOLLOW_35_in_rule__ArbitraryParameterOrResultName__Group__0__Impl8252); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4084:1: rule__ArbitraryParameterOrResultName__Group__1 : rule__ArbitraryParameterOrResultName__Group__1__Impl ;
    public final void rule__ArbitraryParameterOrResultName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4088:1: ( rule__ArbitraryParameterOrResultName__Group__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4089:2: rule__ArbitraryParameterOrResultName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ArbitraryParameterOrResultName__Group__1__Impl_in_rule__ArbitraryParameterOrResultName__Group__18283);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4095:1: rule__ArbitraryParameterOrResultName__Group__1__Impl : ( ( rule__ArbitraryParameterOrResultName__IdentifierAssignment_1 ) ) ;
    public final void rule__ArbitraryParameterOrResultName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4099:1: ( ( ( rule__ArbitraryParameterOrResultName__IdentifierAssignment_1 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4100:1: ( ( rule__ArbitraryParameterOrResultName__IdentifierAssignment_1 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4100:1: ( ( rule__ArbitraryParameterOrResultName__IdentifierAssignment_1 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4101:1: ( rule__ArbitraryParameterOrResultName__IdentifierAssignment_1 )
            {
             before(grammarAccess.getArbitraryParameterOrResultNameAccess().getIdentifierAssignment_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4102:1: ( rule__ArbitraryParameterOrResultName__IdentifierAssignment_1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4102:2: rule__ArbitraryParameterOrResultName__IdentifierAssignment_1
            {
            pushFollow(FOLLOW_rule__ArbitraryParameterOrResultName__IdentifierAssignment_1_in_rule__ArbitraryParameterOrResultName__Group__1__Impl8310);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4116:1: rule__MethodReference__Group__0 : rule__MethodReference__Group__0__Impl rule__MethodReference__Group__1 ;
    public final void rule__MethodReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4120:1: ( rule__MethodReference__Group__0__Impl rule__MethodReference__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4121:2: rule__MethodReference__Group__0__Impl rule__MethodReference__Group__1
            {
            pushFollow(FOLLOW_rule__MethodReference__Group__0__Impl_in_rule__MethodReference__Group__08344);
            rule__MethodReference__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodReference__Group__1_in_rule__MethodReference__Group__08347);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4128:1: rule__MethodReference__Group__0__Impl : ( ( rule__MethodReference__TypeAssignment_0 ) ) ;
    public final void rule__MethodReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4132:1: ( ( ( rule__MethodReference__TypeAssignment_0 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4133:1: ( ( rule__MethodReference__TypeAssignment_0 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4133:1: ( ( rule__MethodReference__TypeAssignment_0 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4134:1: ( rule__MethodReference__TypeAssignment_0 )
            {
             before(grammarAccess.getMethodReferenceAccess().getTypeAssignment_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4135:1: ( rule__MethodReference__TypeAssignment_0 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4135:2: rule__MethodReference__TypeAssignment_0
            {
            pushFollow(FOLLOW_rule__MethodReference__TypeAssignment_0_in_rule__MethodReference__Group__0__Impl8374);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4145:1: rule__MethodReference__Group__1 : rule__MethodReference__Group__1__Impl rule__MethodReference__Group__2 ;
    public final void rule__MethodReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4149:1: ( rule__MethodReference__Group__1__Impl rule__MethodReference__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4150:2: rule__MethodReference__Group__1__Impl rule__MethodReference__Group__2
            {
            pushFollow(FOLLOW_rule__MethodReference__Group__1__Impl_in_rule__MethodReference__Group__18404);
            rule__MethodReference__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__MethodReference__Group__2_in_rule__MethodReference__Group__18407);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4157:1: rule__MethodReference__Group__1__Impl : ( '#' ) ;
    public final void rule__MethodReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4161:1: ( ( '#' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4162:1: ( '#' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4162:1: ( '#' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4163:1: '#'
            {
             before(grammarAccess.getMethodReferenceAccess().getNumberSignKeyword_1()); 
            match(input,36,FOLLOW_36_in_rule__MethodReference__Group__1__Impl8435); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4176:1: rule__MethodReference__Group__2 : rule__MethodReference__Group__2__Impl ;
    public final void rule__MethodReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4180:1: ( rule__MethodReference__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4181:2: rule__MethodReference__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__MethodReference__Group__2__Impl_in_rule__MethodReference__Group__28466);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4187:1: rule__MethodReference__Group__2__Impl : ( ( rule__MethodReference__MethodAssignment_2 ) ) ;
    public final void rule__MethodReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4191:1: ( ( ( rule__MethodReference__MethodAssignment_2 ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4192:1: ( ( rule__MethodReference__MethodAssignment_2 ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4192:1: ( ( rule__MethodReference__MethodAssignment_2 ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4193:1: ( rule__MethodReference__MethodAssignment_2 )
            {
             before(grammarAccess.getMethodReferenceAccess().getMethodAssignment_2()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4194:1: ( rule__MethodReference__MethodAssignment_2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4194:2: rule__MethodReference__MethodAssignment_2
            {
            pushFollow(FOLLOW_rule__MethodReference__MethodAssignment_2_in_rule__MethodReference__Group__2__Impl8493);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4210:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4214:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4215:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__08529);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__08532);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4222:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4226:1: ( ( RULE_ID ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4227:1: ( RULE_ID )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4227:1: ( RULE_ID )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4228:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl8559); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4239:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4243:1: ( rule__QualifiedName__Group__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4244:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__18588);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4250:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4254:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4255:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4255:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4256:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4257:1: ( rule__QualifiedName__Group_1__0 )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==37) ) {
                    int LA32_2 = input.LA(2);

                    if ( (LA32_2==RULE_ID) ) {
                        alt32=1;
                    }


                }


                switch (alt32) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4257:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl8615);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop32;
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4271:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4275:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4276:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__08650);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__08653);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4283:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4287:1: ( ( '.' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4288:1: ( '.' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4288:1: ( '.' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4289:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,37,FOLLOW_37_in_rule__QualifiedName__Group_1__0__Impl8681); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4302:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4306:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4307:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__18712);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4313:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4317:1: ( ( RULE_ID ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4318:1: ( RULE_ID )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4318:1: ( RULE_ID )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4319:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl8739); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4334:1: rule__QualifiedJavaClassName__Group__0 : rule__QualifiedJavaClassName__Group__0__Impl rule__QualifiedJavaClassName__Group__1 ;
    public final void rule__QualifiedJavaClassName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4338:1: ( rule__QualifiedJavaClassName__Group__0__Impl rule__QualifiedJavaClassName__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4339:2: rule__QualifiedJavaClassName__Group__0__Impl rule__QualifiedJavaClassName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__0__Impl_in_rule__QualifiedJavaClassName__Group__08772);
            rule__QualifiedJavaClassName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__1_in_rule__QualifiedJavaClassName__Group__08775);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4346:1: rule__QualifiedJavaClassName__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedJavaClassName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4350:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4351:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4351:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4352:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedJavaClassNameAccess().getQualifiedNameParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedJavaClassName__Group__0__Impl8802);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4363:1: rule__QualifiedJavaClassName__Group__1 : rule__QualifiedJavaClassName__Group__1__Impl rule__QualifiedJavaClassName__Group__2 ;
    public final void rule__QualifiedJavaClassName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4367:1: ( rule__QualifiedJavaClassName__Group__1__Impl rule__QualifiedJavaClassName__Group__2 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4368:2: rule__QualifiedJavaClassName__Group__1__Impl rule__QualifiedJavaClassName__Group__2
            {
            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__1__Impl_in_rule__QualifiedJavaClassName__Group__18831);
            rule__QualifiedJavaClassName__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__2_in_rule__QualifiedJavaClassName__Group__18834);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4375:1: rule__QualifiedJavaClassName__Group__1__Impl : ( '.' ) ;
    public final void rule__QualifiedJavaClassName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4379:1: ( ( '.' ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4380:1: ( '.' )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4380:1: ( '.' )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4381:1: '.'
            {
             before(grammarAccess.getQualifiedJavaClassNameAccess().getFullStopKeyword_1()); 
            match(input,37,FOLLOW_37_in_rule__QualifiedJavaClassName__Group__1__Impl8862); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4394:1: rule__QualifiedJavaClassName__Group__2 : rule__QualifiedJavaClassName__Group__2__Impl ;
    public final void rule__QualifiedJavaClassName__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4398:1: ( rule__QualifiedJavaClassName__Group__2__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4399:2: rule__QualifiedJavaClassName__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedJavaClassName__Group__2__Impl_in_rule__QualifiedJavaClassName__Group__28893);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4405:1: rule__QualifiedJavaClassName__Group__2__Impl : ( RULE_UPPERCASE_ID ) ;
    public final void rule__QualifiedJavaClassName__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4409:1: ( ( RULE_UPPERCASE_ID ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4410:1: ( RULE_UPPERCASE_ID )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4410:1: ( RULE_UPPERCASE_ID )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4411:1: RULE_UPPERCASE_ID
            {
             before(grammarAccess.getQualifiedJavaClassNameAccess().getUPPERCASE_IDTerminalRuleCall_2()); 
            match(input,RULE_UPPERCASE_ID,FOLLOW_RULE_UPPERCASE_ID_in_rule__QualifiedJavaClassName__Group__2__Impl8920); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4428:1: rule__QualifiedNameWithWildcard__Group__0 : rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 ;
    public final void rule__QualifiedNameWithWildcard__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4432:1: ( rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1 )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4433:2: rule__QualifiedNameWithWildcard__Group__0__Impl rule__QualifiedNameWithWildcard__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__0__Impl_in_rule__QualifiedNameWithWildcard__Group__08955);
            rule__QualifiedNameWithWildcard__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__1_in_rule__QualifiedNameWithWildcard__Group__08958);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4440:1: rule__QualifiedNameWithWildcard__Group__0__Impl : ( ruleQualifiedName ) ;
    public final void rule__QualifiedNameWithWildcard__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4444:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4445:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4445:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4446:1: ruleQualifiedName
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildcard__Group__0__Impl8985);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4457:1: rule__QualifiedNameWithWildcard__Group__1 : rule__QualifiedNameWithWildcard__Group__1__Impl ;
    public final void rule__QualifiedNameWithWildcard__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4461:1: ( rule__QualifiedNameWithWildcard__Group__1__Impl )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4462:2: rule__QualifiedNameWithWildcard__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedNameWithWildcard__Group__1__Impl_in_rule__QualifiedNameWithWildcard__Group__19014);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4468:1: rule__QualifiedNameWithWildcard__Group__1__Impl : ( ( '.*' )? ) ;
    public final void rule__QualifiedNameWithWildcard__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4472:1: ( ( ( '.*' )? ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4473:1: ( ( '.*' )? )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4473:1: ( ( '.*' )? )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4474:1: ( '.*' )?
            {
             before(grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4475:1: ( '.*' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==38) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4476:2: '.*'
                    {
                    match(input,38,FOLLOW_38_in_rule__QualifiedNameWithWildcard__Group__1__Impl9043); 

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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4492:1: rule__Model__StatementsAssignment : ( ruleStatement ) ;
    public final void rule__Model__StatementsAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4496:1: ( ( ruleStatement ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4497:1: ( ruleStatement )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4497:1: ( ruleStatement )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4498:1: ruleStatement
            {
             before(grammarAccess.getModelAccess().getStatementsStatementParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleStatement_in_rule__Model__StatementsAssignment9085);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4507:1: rule__PackageDefinition__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__PackageDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4511:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4512:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4512:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4513:1: ruleQualifiedName
            {
             before(grammarAccess.getPackageDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__PackageDefinition__NameAssignment_19116);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4522:1: rule__PackageDefinition__StatementsAssignment_3 : ( rulePackageStatement ) ;
    public final void rule__PackageDefinition__StatementsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4526:1: ( ( rulePackageStatement ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4527:1: ( rulePackageStatement )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4527:1: ( rulePackageStatement )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4528:1: rulePackageStatement
            {
             before(grammarAccess.getPackageDefinitionAccess().getStatementsPackageStatementParserRuleCall_3_0()); 
            pushFollow(FOLLOW_rulePackageStatement_in_rule__PackageDefinition__StatementsAssignment_39147);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4537:1: rule__Import__ImportedNamespaceAssignment_1 : ( ruleQualifiedNameWithWildcard ) ;
    public final void rule__Import__ImportedNamespaceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4541:1: ( ( ruleQualifiedNameWithWildcard ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4542:1: ( ruleQualifiedNameWithWildcard )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4542:1: ( ruleQualifiedNameWithWildcard )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4543:1: ruleQualifiedNameWithWildcard
            {
             before(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_rule__Import__ImportedNamespaceAssignment_19178);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4552:1: rule__TestDefinition__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__TestDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4556:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4557:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4557:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4558:1: ruleQualifiedName
            {
             before(grammarAccess.getTestDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__TestDefinition__NameAssignment_19209);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4567:1: rule__TestDefinition__FixtureMethodAssignment_3 : ( ruleMethodReference ) ;
    public final void rule__TestDefinition__FixtureMethodAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4571:1: ( ( ruleMethodReference ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4572:1: ( ruleMethodReference )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4572:1: ( ruleMethodReference )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4573:1: ruleMethodReference
            {
             before(grammarAccess.getTestDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleMethodReference_in_rule__TestDefinition__FixtureMethodAssignment_39240);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4582:1: rule__CallDefinition__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__CallDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4586:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4587:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4587:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4588:1: ruleQualifiedName
            {
             before(grammarAccess.getCallDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__CallDefinition__NameAssignment_19271);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4597:1: rule__CallDefinition__FixtureMethodAssignment_3 : ( ruleMethodReference ) ;
    public final void rule__CallDefinition__FixtureMethodAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4601:1: ( ( ruleMethodReference ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4602:1: ( ruleMethodReference )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4602:1: ( ruleMethodReference )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4603:1: ruleMethodReference
            {
             before(grammarAccess.getCallDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleMethodReference_in_rule__CallDefinition__FixtureMethodAssignment_39302);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4612:1: rule__SuiteDefinition__NameAssignment_1 : ( ruleQualifiedName ) ;
    public final void rule__SuiteDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4616:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4617:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4617:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4618:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__NameAssignment_19333);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4627:1: rule__SuiteDefinition__ParametersAssignment_2_1 : ( ruleVariableEntity ) ;
    public final void rule__SuiteDefinition__ParametersAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4631:1: ( ( ruleVariableEntity ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4632:1: ( ruleVariableEntity )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4632:1: ( ruleVariableEntity )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4633:1: ruleVariableEntity
            {
             before(grammarAccess.getSuiteDefinitionAccess().getParametersVariableEntityParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleVariableEntity_in_rule__SuiteDefinition__ParametersAssignment_2_19364);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4642:1: rule__SuiteDefinition__DependenciesAssignment_3_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__SuiteDefinition__DependenciesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4646:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4647:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4647:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4648:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSuiteDefinitionAccess().getDependenciesSuiteDefinitionCrossReference_3_1_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4649:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4650:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteDefinitionAccess().getDependenciesSuiteDefinitionQualifiedNameParserRuleCall_3_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__DependenciesAssignment_3_19399);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4661:1: rule__SuiteDefinition__StatementsAssignment_5 : ( ruleSuiteStatement ) ;
    public final void rule__SuiteDefinition__StatementsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4665:1: ( ( ruleSuiteStatement ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4666:1: ( ruleSuiteStatement )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4666:1: ( ruleSuiteStatement )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4667:1: ruleSuiteStatement
            {
             before(grammarAccess.getSuiteDefinitionAccess().getStatementsSuiteStatementParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleSuiteStatement_in_rule__SuiteDefinition__StatementsAssignment_59434);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4676:1: rule__SuiteDefinition__FinalizersAssignment_7_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__SuiteDefinition__FinalizersAssignment_7_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4680:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4681:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4681:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4682:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSuiteDefinitionAccess().getFinalizersSuiteDefinitionCrossReference_7_1_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4683:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4684:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteDefinitionAccess().getFinalizersSuiteDefinitionQualifiedNameParserRuleCall_7_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__FinalizersAssignment_7_19469);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4695:1: rule__VariableDefinition__NameAssignment_1 : ( ruleVariableEntity ) ;
    public final void rule__VariableDefinition__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4699:1: ( ( ruleVariableEntity ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4700:1: ( ruleVariableEntity )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4700:1: ( ruleVariableEntity )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4701:1: ruleVariableEntity
            {
             before(grammarAccess.getVariableDefinitionAccess().getNameVariableEntityParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleVariableEntity_in_rule__VariableDefinition__NameAssignment_19504);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4710:1: rule__VariableDefinition__InitialValueAssignment_2_1 : ( ruleValue ) ;
    public final void rule__VariableDefinition__InitialValueAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4714:1: ( ( ruleValue ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4715:1: ( ruleValue )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4715:1: ( ruleValue )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4716:1: ruleValue
            {
             before(grammarAccess.getVariableDefinitionAccess().getInitialValueValueParserRuleCall_2_1_0()); 
            pushFollow(FOLLOW_ruleValue_in_rule__VariableDefinition__InitialValueAssignment_2_19535);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4725:1: rule__VariableEntity__NameAssignment : ( ruleQualifiedName ) ;
    public final void rule__VariableEntity__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4729:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4730:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4730:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4731:1: ruleQualifiedName
            {
             before(grammarAccess.getVariableEntityAccess().getNameQualifiedNameParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__VariableEntity__NameAssignment9566);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4740:1: rule__Test__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Test__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4744:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4745:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4745:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4746:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getTestAccess().getDefinitionTestDefinitionCrossReference_1_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4747:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4748:1: ruleQualifiedName
            {
             before(grammarAccess.getTestAccess().getDefinitionTestDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Test__DefinitionAssignment_19601);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4759:1: rule__Test__ParametersAssignment_2 : ( ruleParameter ) ;
    public final void rule__Test__ParametersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4763:1: ( ( ruleParameter ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4764:1: ( ruleParameter )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4764:1: ( ruleParameter )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4765:1: ruleParameter
            {
             before(grammarAccess.getTestAccess().getParametersParameterParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleParameter_in_rule__Test__ParametersAssignment_29636);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4774:1: rule__Test__ResultsAssignment_3 : ( ruleNamedResult ) ;
    public final void rule__Test__ResultsAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4778:1: ( ( ruleNamedResult ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4779:1: ( ruleNamedResult )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4779:1: ( ruleNamedResult )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4780:1: ruleNamedResult
            {
             before(grammarAccess.getTestAccess().getResultsNamedResultParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleNamedResult_in_rule__Test__ResultsAssignment_39667);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4789:1: rule__Test__ResultAssignment_4_1 : ( ruleValueOrEnumValue ) ;
    public final void rule__Test__ResultAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4793:1: ( ( ruleValueOrEnumValue ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4794:1: ( ruleValueOrEnumValue )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4794:1: ( ruleValueOrEnumValue )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4795:1: ruleValueOrEnumValue
            {
             before(grammarAccess.getTestAccess().getResultValueOrEnumValueParserRuleCall_4_1_0()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_rule__Test__ResultAssignment_4_19698);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4804:1: rule__TableTest__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__TableTest__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4808:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4809:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4809:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4810:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getTableTestAccess().getDefinitionTestDefinitionCrossReference_1_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4811:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4812:1: ruleQualifiedName
            {
             before(grammarAccess.getTableTestAccess().getDefinitionTestDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__TableTest__DefinitionAssignment_19733);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4823:1: rule__TableTest__ParametersAssignment_2 : ( ruleParameter ) ;
    public final void rule__TableTest__ParametersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4827:1: ( ( ruleParameter ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4828:1: ( ruleParameter )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4828:1: ( ruleParameter )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4829:1: ruleParameter
            {
             before(grammarAccess.getTableTestAccess().getParametersParameterParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleParameter_in_rule__TableTest__ParametersAssignment_29768);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4838:1: rule__TableTest__ParameterHeadersAssignment_3 : ( ruleParameterTableHeader ) ;
    public final void rule__TableTest__ParameterHeadersAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4842:1: ( ( ruleParameterTableHeader ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4843:1: ( ruleParameterTableHeader )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4843:1: ( ruleParameterTableHeader )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4844:1: ruleParameterTableHeader
            {
             before(grammarAccess.getTableTestAccess().getParameterHeadersParameterTableHeaderParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleParameterTableHeader_in_rule__TableTest__ParameterHeadersAssignment_39799);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4853:1: rule__TableTest__ResultHeadersAssignment_4 : ( ruleResultTableHeader ) ;
    public final void rule__TableTest__ResultHeadersAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4857:1: ( ( ruleResultTableHeader ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4858:1: ( ruleResultTableHeader )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4858:1: ( ruleResultTableHeader )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4859:1: ruleResultTableHeader
            {
             before(grammarAccess.getTableTestAccess().getResultHeadersResultTableHeaderParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleResultTableHeader_in_rule__TableTest__ResultHeadersAssignment_49830);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4868:1: rule__TableTest__RowsAssignment_6 : ( ruleTableTestRow ) ;
    public final void rule__TableTest__RowsAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4872:1: ( ( ruleTableTestRow ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4873:1: ( ruleTableTestRow )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4873:1: ( ruleTableTestRow )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4874:1: ruleTableTestRow
            {
             before(grammarAccess.getTableTestAccess().getRowsTableTestRowParserRuleCall_6_0()); 
            pushFollow(FOLLOW_ruleTableTestRow_in_rule__TableTest__RowsAssignment_69861);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4883:1: rule__TableTestRow__ValuesAssignment_1 : ( ruleParameterTableValue ) ;
    public final void rule__TableTestRow__ValuesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4887:1: ( ( ruleParameterTableValue ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4888:1: ( ruleParameterTableValue )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4888:1: ( ruleParameterTableValue )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4889:1: ruleParameterTableValue
            {
             before(grammarAccess.getTableTestRowAccess().getValuesParameterTableValueParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleParameterTableValue_in_rule__TableTestRow__ValuesAssignment_19892);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4898:1: rule__TableTestRow__ResultAssignment_2_0_2 : ( ruleValueOrEnumValue ) ;
    public final void rule__TableTestRow__ResultAssignment_2_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4902:1: ( ( ruleValueOrEnumValue ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4903:1: ( ruleValueOrEnumValue )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4903:1: ( ruleValueOrEnumValue )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4904:1: ruleValueOrEnumValue
            {
             before(grammarAccess.getTableTestRowAccess().getResultValueOrEnumValueParserRuleCall_2_0_2_0()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_rule__TableTestRow__ResultAssignment_2_0_29923);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4913:1: rule__ParameterTableHeader__NameAssignment_1 : ( ruleParameterName ) ;
    public final void rule__ParameterTableHeader__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4917:1: ( ( ruleParameterName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4918:1: ( ruleParameterName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4918:1: ( ruleParameterName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4919:1: ruleParameterName
            {
             before(grammarAccess.getParameterTableHeaderAccess().getNameParameterNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleParameterName_in_rule__ParameterTableHeader__NameAssignment_19954);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4928:1: rule__ResultTableHeader__NameAssignment_1 : ( ruleResultName ) ;
    public final void rule__ResultTableHeader__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4932:1: ( ( ruleResultName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4933:1: ( ruleResultName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4933:1: ( ruleResultName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4934:1: ruleResultName
            {
             before(grammarAccess.getResultTableHeaderAccess().getNameResultNameParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleResultName_in_rule__ResultTableHeader__NameAssignment_19985);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4943:1: rule__ParameterTableValue__ValueAssignment_1 : ( ruleValueOrEnumValue ) ;
    public final void rule__ParameterTableValue__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4947:1: ( ( ruleValueOrEnumValue ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4948:1: ( ruleValueOrEnumValue )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4948:1: ( ruleValueOrEnumValue )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4949:1: ruleValueOrEnumValue
            {
             before(grammarAccess.getParameterTableValueAccess().getValueValueOrEnumValueParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_rule__ParameterTableValue__ValueAssignment_110016);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4958:1: rule__NamedResult__NameAssignment_0 : ( ruleResultName ) ;
    public final void rule__NamedResult__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4962:1: ( ( ruleResultName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4963:1: ( ruleResultName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4963:1: ( ruleResultName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4964:1: ruleResultName
            {
             before(grammarAccess.getNamedResultAccess().getNameResultNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleResultName_in_rule__NamedResult__NameAssignment_010047);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4973:1: rule__NamedResult__ValueAssignment_2 : ( ruleValueOrEnumValue ) ;
    public final void rule__NamedResult__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4977:1: ( ( ruleValueOrEnumValue ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4978:1: ( ruleValueOrEnumValue )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4978:1: ( ruleValueOrEnumValue )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4979:1: ruleValueOrEnumValue
            {
             before(grammarAccess.getNamedResultAccess().getValueValueOrEnumValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_rule__NamedResult__ValueAssignment_210078);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4988:1: rule__FixedResultName__FieldAssignment : ( ( RULE_ID ) ) ;
    public final void rule__FixedResultName__FieldAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4992:1: ( ( ( RULE_ID ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4993:1: ( ( RULE_ID ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4993:1: ( ( RULE_ID ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4994:1: ( RULE_ID )
            {
             before(grammarAccess.getFixedResultNameAccess().getFieldJvmFieldCrossReference_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4995:1: ( RULE_ID )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:4996:1: RULE_ID
            {
             before(grammarAccess.getFixedResultNameAccess().getFieldJvmFieldIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FixedResultName__FieldAssignment10113); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5007:1: rule__Call__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Call__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5011:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5012:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5012:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5013:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getCallAccess().getDefinitionCallDefinitionCrossReference_1_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5014:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5015:1: ruleQualifiedName
            {
             before(grammarAccess.getCallAccess().getDefinitionCallDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Call__DefinitionAssignment_110152);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5026:1: rule__Call__ParametersAssignment_2 : ( ruleParameter ) ;
    public final void rule__Call__ParametersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5030:1: ( ( ruleParameter ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5031:1: ( ruleParameter )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5031:1: ( ruleParameter )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5032:1: ruleParameter
            {
             before(grammarAccess.getCallAccess().getParametersParameterParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleParameter_in_rule__Call__ParametersAssignment_210187);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5041:1: rule__Call__ResultAssignment_3_1 : ( ruleVariable ) ;
    public final void rule__Call__ResultAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5045:1: ( ( ruleVariable ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5046:1: ( ruleVariable )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5046:1: ( ruleVariable )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5047:1: ruleVariable
            {
             before(grammarAccess.getCallAccess().getResultVariableParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleVariable_in_rule__Call__ResultAssignment_3_110218);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5056:1: rule__Suite__DefinitionAssignment_1 : ( ( ruleQualifiedName ) ) ;
    public final void rule__Suite__DefinitionAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5060:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5061:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5061:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5062:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSuiteAccess().getDefinitionSuiteDefinitionCrossReference_1_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5063:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5064:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteAccess().getDefinitionSuiteDefinitionQualifiedNameParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Suite__DefinitionAssignment_110253);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5075:1: rule__Suite__ParametersAssignment_2 : ( ruleSuiteParameter ) ;
    public final void rule__Suite__ParametersAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5079:1: ( ( ruleSuiteParameter ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5080:1: ( ruleSuiteParameter )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5080:1: ( ruleSuiteParameter )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5081:1: ruleSuiteParameter
            {
             before(grammarAccess.getSuiteAccess().getParametersSuiteParameterParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleSuiteParameter_in_rule__Suite__ParametersAssignment_210288);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5090:1: rule__SuiteParameter__NameAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__SuiteParameter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5094:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5095:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5095:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5096:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getSuiteParameterAccess().getNameVariableEntityCrossReference_0_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5097:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5098:1: ruleQualifiedName
            {
             before(grammarAccess.getSuiteParameterAccess().getNameVariableEntityQualifiedNameParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__SuiteParameter__NameAssignment_010323);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5109:1: rule__SuiteParameter__ValueAssignment_2 : ( ruleValue ) ;
    public final void rule__SuiteParameter__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5113:1: ( ( ruleValue ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5114:1: ( ruleValue )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5114:1: ( ruleValue )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5115:1: ruleValue
            {
             before(grammarAccess.getSuiteParameterAccess().getValueValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleValue_in_rule__SuiteParameter__ValueAssignment_210358);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5124:1: rule__Parameter__NameAssignment_0 : ( ruleParameterName ) ;
    public final void rule__Parameter__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5128:1: ( ( ruleParameterName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5129:1: ( ruleParameterName )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5129:1: ( ruleParameterName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5130:1: ruleParameterName
            {
             before(grammarAccess.getParameterAccess().getNameParameterNameParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleParameterName_in_rule__Parameter__NameAssignment_010389);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5139:1: rule__Parameter__ValueAssignment_2 : ( ruleValueOrEnumValue ) ;
    public final void rule__Parameter__ValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5143:1: ( ( ruleValueOrEnumValue ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5144:1: ( ruleValueOrEnumValue )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5144:1: ( ruleValueOrEnumValue )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5145:1: ruleValueOrEnumValue
            {
             before(grammarAccess.getParameterAccess().getValueValueOrEnumValueParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_rule__Parameter__ValueAssignment_210420);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5154:1: rule__FixedParameterName__AnnotationAssignment : ( ( RULE_ID ) ) ;
    public final void rule__FixedParameterName__AnnotationAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5158:1: ( ( ( RULE_ID ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5159:1: ( ( RULE_ID ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5159:1: ( ( RULE_ID ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5160:1: ( RULE_ID )
            {
             before(grammarAccess.getFixedParameterNameAccess().getAnnotationJvmAnnotationReferenceCrossReference_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5161:1: ( RULE_ID )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5162:1: RULE_ID
            {
             before(grammarAccess.getFixedParameterNameAccess().getAnnotationJvmAnnotationReferenceIDTerminalRuleCall_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__FixedParameterName__AnnotationAssignment10455); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5173:1: rule__ArbitraryParameterOrResultName__IdentifierAssignment_1 : ( RULE_ID ) ;
    public final void rule__ArbitraryParameterOrResultName__IdentifierAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5177:1: ( ( RULE_ID ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5178:1: ( RULE_ID )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5178:1: ( RULE_ID )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5179:1: RULE_ID
            {
             before(grammarAccess.getArbitraryParameterOrResultNameAccess().getIdentifierIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ArbitraryParameterOrResultName__IdentifierAssignment_110490); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5188:1: rule__IntegerValue__IntegerValueAssignment : ( RULE_INTEGER ) ;
    public final void rule__IntegerValue__IntegerValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5192:1: ( ( RULE_INTEGER ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5193:1: ( RULE_INTEGER )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5193:1: ( RULE_INTEGER )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5194:1: RULE_INTEGER
            {
             before(grammarAccess.getIntegerValueAccess().getIntegerValueINTEGERTerminalRuleCall_0()); 
            match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_rule__IntegerValue__IntegerValueAssignment10521); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5203:1: rule__DecimalValue__DecimalValueAssignment : ( RULE_DECIMAL ) ;
    public final void rule__DecimalValue__DecimalValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5207:1: ( ( RULE_DECIMAL ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5208:1: ( RULE_DECIMAL )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5208:1: ( RULE_DECIMAL )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5209:1: RULE_DECIMAL
            {
             before(grammarAccess.getDecimalValueAccess().getDecimalValueDECIMALTerminalRuleCall_0()); 
            match(input,RULE_DECIMAL,FOLLOW_RULE_DECIMAL_in_rule__DecimalValue__DecimalValueAssignment10552); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5218:1: rule__StringValue__StringValueAssignment : ( RULE_STRING ) ;
    public final void rule__StringValue__StringValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5222:1: ( ( RULE_STRING ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5223:1: ( RULE_STRING )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5223:1: ( RULE_STRING )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5224:1: RULE_STRING
            {
             before(grammarAccess.getStringValueAccess().getStringValueSTRINGTerminalRuleCall_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__StringValue__StringValueAssignment10583); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5233:1: rule__Variable__NameAssignment : ( ( ruleQualifiedName ) ) ;
    public final void rule__Variable__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5237:1: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5238:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5238:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5239:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getVariableAccess().getNameVariableEntityCrossReference_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5240:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5241:1: ruleQualifiedName
            {
             before(grammarAccess.getVariableAccess().getNameVariableEntityQualifiedNameParserRuleCall_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__Variable__NameAssignment10618);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5252:1: rule__EnumValue__EnumValueAssignment : ( ( RULE_UPPERCASE_ID ) ) ;
    public final void rule__EnumValue__EnumValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5256:1: ( ( ( RULE_UPPERCASE_ID ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5257:1: ( ( RULE_UPPERCASE_ID ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5257:1: ( ( RULE_UPPERCASE_ID ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5258:1: ( RULE_UPPERCASE_ID )
            {
             before(grammarAccess.getEnumValueAccess().getEnumValueJvmEnumerationLiteralCrossReference_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5259:1: ( RULE_UPPERCASE_ID )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5260:1: RULE_UPPERCASE_ID
            {
             before(grammarAccess.getEnumValueAccess().getEnumValueJvmEnumerationLiteralUPPERCASE_IDTerminalRuleCall_0_1()); 
            match(input,RULE_UPPERCASE_ID,FOLLOW_RULE_UPPERCASE_ID_in_rule__EnumValue__EnumValueAssignment10657); 
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5271:1: rule__MethodReference__TypeAssignment_0 : ( ( ruleQualifiedJavaClassName ) ) ;
    public final void rule__MethodReference__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5275:1: ( ( ( ruleQualifiedJavaClassName ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5276:1: ( ( ruleQualifiedJavaClassName ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5276:1: ( ( ruleQualifiedJavaClassName ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5277:1: ( ruleQualifiedJavaClassName )
            {
             before(grammarAccess.getMethodReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5278:1: ( ruleQualifiedJavaClassName )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5279:1: ruleQualifiedJavaClassName
            {
             before(grammarAccess.getMethodReferenceAccess().getTypeJvmTypeQualifiedJavaClassNameParserRuleCall_0_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_rule__MethodReference__TypeAssignment_010696);
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
    // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5290:1: rule__MethodReference__MethodAssignment_2 : ( ( RULE_ID ) ) ;
    public final void rule__MethodReference__MethodAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5294:1: ( ( ( RULE_ID ) ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5295:1: ( ( RULE_ID ) )
            {
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5295:1: ( ( RULE_ID ) )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5296:1: ( RULE_ID )
            {
             before(grammarAccess.getMethodReferenceAccess().getMethodJvmOperationCrossReference_2_0()); 
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5297:1: ( RULE_ID )
            // ../de.gebit.integrity.dsl.ui/src-gen/de/gebit/integrity/ui/contentassist/antlr/internal/InternalDSL.g:5298:1: RULE_ID
            {
             before(grammarAccess.getMethodReferenceAccess().getMethodJvmOperationIDTerminalRuleCall_2_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__MethodReference__MethodAssignment_210735); 
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
    public static final BitSet FOLLOW_ruleResultTableHeader_in_entryRuleResultTableHeader1022 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultTableHeader1029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultTableHeader__Group__0_in_ruleResultTableHeader1055 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableValue_in_entryRuleParameterTableValue1082 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterTableValue1089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableValue__Group__0_in_ruleParameterTableValue1115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedResult_in_entryRuleNamedResult1142 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedResult1149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedResult__Group__0_in_ruleNamedResult1175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultName_in_entryRuleResultName1202 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultName1209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultName__Alternatives_in_ruleResultName1235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedResultName_in_entryRuleFixedResultName1262 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFixedResultName1269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FixedResultName__FieldAssignment_in_ruleFixedResultName1295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_entryRuleCall1322 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCall1329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__0_in_ruleCall1355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_entryRuleSuite1382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuite1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group__0_in_ruleSuite1415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteParameter_in_entryRuleSuiteParameter1442 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteParameter1449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__0_in_ruleSuiteParameter1475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter1502 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter1509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__0_in_ruleParameter1535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterName_in_entryRuleParameterName1562 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterName1569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterName__Alternatives_in_ruleParameterName1595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedParameterName_in_entryRuleFixedParameterName1622 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFixedParameterName1629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__FixedParameterName__AnnotationAssignment_in_ruleFixedParameterName1655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterOrResultName_in_entryRuleArbitraryParameterOrResultName1682 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArbitraryParameterOrResultName1689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArbitraryParameterOrResultName__Group__0_in_ruleArbitraryParameterOrResultName1715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_entryRuleValueOrEnumValue1742 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueOrEnumValue1749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ValueOrEnumValue__Alternatives_in_ruleValueOrEnumValue1775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue1802 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue1809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Value__Alternatives_in_ruleValue1835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerValue_in_entryRuleIntegerValue1862 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerValue1869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__IntegerValue__IntegerValueAssignment_in_ruleIntegerValue1895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalValue_in_entryRuleDecimalValue1922 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalValue1929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__DecimalValue__DecimalValueAssignment_in_ruleDecimalValue1955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringValue_in_entryRuleStringValue1982 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringValue1989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__StringValue__StringValueAssignment_in_ruleStringValue2015 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable2042 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable2049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Variable__NameAssignment_in_ruleVariable2075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumValue_in_entryRuleEnumValue2102 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumValue2109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EnumValue__EnumValueAssignment_in_ruleEnumValue2135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodReference_in_entryRuleMethodReference2162 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodReference2169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__0_in_ruleMethodReference2195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName2222 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName2229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName2255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_entryRuleQualifiedJavaClassName2282 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedJavaClassName2289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__0_in_ruleQualifiedJavaClassName2315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard2342 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard2349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__0_in_ruleQualifiedNameWithWildcard2375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDefinition_in_rule__Statement__Alternatives2411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__Statement__Alternatives2428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_rule__Statement__Alternatives2445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__PackageStatement__Alternatives2477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestDefinition_in_rule__PackageStatement__Alternatives2494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallDefinition_in_rule__PackageStatement__Alternatives2511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteDefinition_in_rule__PackageStatement__Alternatives2528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_rule__PackageStatement__Alternatives2545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteStatementWithResult_in_rule__SuiteStatement__Alternatives2577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_rule__SuiteStatement__Alternatives2594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_rule__SuiteStatement__Alternatives2611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_rule__SuiteStatementWithResult__Alternatives2643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTest_in_rule__SuiteStatementWithResult__Alternatives2660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTableTest_in_rule__SuiteStatementWithResult__Alternatives2677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group_5_0__0_in_rule__TableTest__Alternatives_52709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__TableTest__Alternatives_52728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group_2_0__0_in_rule__TableTestRow__Alternatives_22762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__TableTestRow__Alternatives_22781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedResultName_in_rule__ResultName__Alternatives2815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterOrResultName_in_rule__ResultName__Alternatives2832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedParameterName_in_rule__ParameterName__Alternatives2864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterOrResultName_in_rule__ParameterName__Alternatives2881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__ValueOrEnumValue__Alternatives2913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumValue_in_rule__ValueOrEnumValue__Alternatives2930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringValue_in_rule__Value__Alternatives2962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerValue_in_rule__Value__Alternatives2979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalValue_in_rule__Value__Alternatives2996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__Value__Alternatives3013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__0__Impl_in_rule__PackageDefinition__Group__03043 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__1_in_rule__PackageDefinition__Group__03046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__PackageDefinition__Group__0__Impl3074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__1__Impl_in_rule__PackageDefinition__Group__13105 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__2_in_rule__PackageDefinition__Group__13108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__NameAssignment_1_in_rule__PackageDefinition__Group__1__Impl3135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__2__Impl_in_rule__PackageDefinition__Group__23165 = new BitSet(new long[]{0x0000000004370000L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__3_in_rule__PackageDefinition__Group__23168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__PackageDefinition__Group__2__Impl3196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__3__Impl_in_rule__PackageDefinition__Group__33227 = new BitSet(new long[]{0x0000000004370000L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__4_in_rule__PackageDefinition__Group__33230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__StatementsAssignment_3_in_rule__PackageDefinition__Group__3__Impl3257 = new BitSet(new long[]{0x0000000004360002L});
    public static final BitSet FOLLOW_rule__PackageDefinition__Group__4__Impl_in_rule__PackageDefinition__Group__43288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__PackageDefinition__Group__4__Impl3316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0__Impl_in_rule__Import__Group__03357 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__03360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Import__Group__0__Impl3388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__1__Impl_in_rule__Import__Group__13419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportedNamespaceAssignment_1_in_rule__Import__Group__1__Impl3446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__0__Impl_in_rule__TestDefinition__Group__03480 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__1_in_rule__TestDefinition__Group__03483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__TestDefinition__Group__0__Impl3511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__1__Impl_in_rule__TestDefinition__Group__13542 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__2_in_rule__TestDefinition__Group__13545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__NameAssignment_1_in_rule__TestDefinition__Group__1__Impl3572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__2__Impl_in_rule__TestDefinition__Group__23602 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__3_in_rule__TestDefinition__Group__23605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__TestDefinition__Group__2__Impl3633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__Group__3__Impl_in_rule__TestDefinition__Group__33664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TestDefinition__FixtureMethodAssignment_3_in_rule__TestDefinition__Group__3__Impl3691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__0__Impl_in_rule__CallDefinition__Group__03729 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__1_in_rule__CallDefinition__Group__03732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__CallDefinition__Group__0__Impl3760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__1__Impl_in_rule__CallDefinition__Group__13791 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__2_in_rule__CallDefinition__Group__13794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__NameAssignment_1_in_rule__CallDefinition__Group__1__Impl3821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__2__Impl_in_rule__CallDefinition__Group__23851 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__3_in_rule__CallDefinition__Group__23854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__CallDefinition__Group__2__Impl3882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__Group__3__Impl_in_rule__CallDefinition__Group__33913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CallDefinition__FixtureMethodAssignment_3_in_rule__CallDefinition__Group__3__Impl3940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__0__Impl_in_rule__SuiteDefinition__Group__03978 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__1_in_rule__SuiteDefinition__Group__03981 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__SuiteDefinition__Group__0__Impl4009 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__1__Impl_in_rule__SuiteDefinition__Group__14040 = new BitSet(new long[]{0x0000000001808000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__2_in_rule__SuiteDefinition__Group__14043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__NameAssignment_1_in_rule__SuiteDefinition__Group__1__Impl4070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__2__Impl_in_rule__SuiteDefinition__Group__24100 = new BitSet(new long[]{0x0000000001808000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__3_in_rule__SuiteDefinition__Group__24103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_2__0_in_rule__SuiteDefinition__Group__2__Impl4130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__3__Impl_in_rule__SuiteDefinition__Group__34161 = new BitSet(new long[]{0x0000000001808000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__4_in_rule__SuiteDefinition__Group__34164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_3__0_in_rule__SuiteDefinition__Group__3__Impl4191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__4__Impl_in_rule__SuiteDefinition__Group__44222 = new BitSet(new long[]{0x00000002D4764000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__5_in_rule__SuiteDefinition__Group__44225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__SuiteDefinition__Group__4__Impl4253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__5__Impl_in_rule__SuiteDefinition__Group__54284 = new BitSet(new long[]{0x00000002D4764000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__6_in_rule__SuiteDefinition__Group__54287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__StatementsAssignment_5_in_rule__SuiteDefinition__Group__5__Impl4314 = new BitSet(new long[]{0x00000002D4364002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__6__Impl_in_rule__SuiteDefinition__Group__64345 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__7_in_rule__SuiteDefinition__Group__64348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__SuiteDefinition__Group__6__Impl4376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group__7__Impl_in_rule__SuiteDefinition__Group__74407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_7__0_in_rule__SuiteDefinition__Group__7__Impl4434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_2__0__Impl_in_rule__SuiteDefinition__Group_2__04481 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_2__1_in_rule__SuiteDefinition__Group_2__04484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__SuiteDefinition__Group_2__0__Impl4512 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_2__1__Impl_in_rule__SuiteDefinition__Group_2__14543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__ParametersAssignment_2_1_in_rule__SuiteDefinition__Group_2__1__Impl4570 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_3__0__Impl_in_rule__SuiteDefinition__Group_3__04605 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_3__1_in_rule__SuiteDefinition__Group_3__04608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__SuiteDefinition__Group_3__0__Impl4636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_3__1__Impl_in_rule__SuiteDefinition__Group_3__14667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__DependenciesAssignment_3_1_in_rule__SuiteDefinition__Group_3__1__Impl4694 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_7__0__Impl_in_rule__SuiteDefinition__Group_7__04729 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_7__1_in_rule__SuiteDefinition__Group_7__04732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__SuiteDefinition__Group_7__0__Impl4760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__Group_7__1__Impl_in_rule__SuiteDefinition__Group_7__14791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteDefinition__FinalizersAssignment_7_1_in_rule__SuiteDefinition__Group_7__1__Impl4818 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__0__Impl_in_rule__VariableDefinition__Group__04853 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__1_in_rule__VariableDefinition__Group__04856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__VariableDefinition__Group__0__Impl4884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__1__Impl_in_rule__VariableDefinition__Group__14915 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__2_in_rule__VariableDefinition__Group__14918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__NameAssignment_1_in_rule__VariableDefinition__Group__1__Impl4945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group__2__Impl_in_rule__VariableDefinition__Group__24975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group_2__0_in_rule__VariableDefinition__Group__2__Impl5002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group_2__0__Impl_in_rule__VariableDefinition__Group_2__05039 = new BitSet(new long[]{0x00000000000001D0L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group_2__1_in_rule__VariableDefinition__Group_2__05042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__VariableDefinition__Group_2__0__Impl5070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__Group_2__1__Impl_in_rule__VariableDefinition__Group_2__15101 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__VariableDefinition__InitialValueAssignment_2_1_in_rule__VariableDefinition__Group_2__1__Impl5128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group__0__Impl_in_rule__Test__Group__05162 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Test__Group__1_in_rule__Test__Group__05165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__Test__Group__0__Impl5193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group__1__Impl_in_rule__Test__Group__15224 = new BitSet(new long[]{0x0000000820000010L});
    public static final BitSet FOLLOW_rule__Test__Group__2_in_rule__Test__Group__15227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__DefinitionAssignment_1_in_rule__Test__Group__1__Impl5254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group__2__Impl_in_rule__Test__Group__25284 = new BitSet(new long[]{0x0000000820000010L});
    public static final BitSet FOLLOW_rule__Test__Group__3_in_rule__Test__Group__25287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__ParametersAssignment_2_in_rule__Test__Group__2__Impl5314 = new BitSet(new long[]{0x0000000800000012L});
    public static final BitSet FOLLOW_rule__Test__Group__3__Impl_in_rule__Test__Group__35345 = new BitSet(new long[]{0x0000000820000010L});
    public static final BitSet FOLLOW_rule__Test__Group__4_in_rule__Test__Group__35348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__ResultsAssignment_3_in_rule__Test__Group__3__Impl5375 = new BitSet(new long[]{0x0000000800000012L});
    public static final BitSet FOLLOW_rule__Test__Group__4__Impl_in_rule__Test__Group__45406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group_4__0_in_rule__Test__Group__4__Impl5433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group_4__0__Impl_in_rule__Test__Group_4__05474 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__Test__Group_4__1_in_rule__Test__Group_4__05477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Test__Group_4__0__Impl5505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__Group_4__1__Impl_in_rule__Test__Group_4__15536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Test__ResultAssignment_4_1_in_rule__Test__Group_4__1__Impl5563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group__0__Impl_in_rule__TableTest__Group__05597 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TableTest__Group__1_in_rule__TableTest__Group__05600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__TableTest__Group__0__Impl5628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group__1__Impl_in_rule__TableTest__Group__15659 = new BitSet(new long[]{0x0000000800002010L});
    public static final BitSet FOLLOW_rule__TableTest__Group__2_in_rule__TableTest__Group__15662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__DefinitionAssignment_1_in_rule__TableTest__Group__1__Impl5689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group__2__Impl_in_rule__TableTest__Group__25719 = new BitSet(new long[]{0x0000000800002010L});
    public static final BitSet FOLLOW_rule__TableTest__Group__3_in_rule__TableTest__Group__25722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__ParametersAssignment_2_in_rule__TableTest__Group__2__Impl5749 = new BitSet(new long[]{0x0000000800000012L});
    public static final BitSet FOLLOW_rule__TableTest__Group__3__Impl_in_rule__TableTest__Group__35780 = new BitSet(new long[]{0x0000000800002010L});
    public static final BitSet FOLLOW_rule__TableTest__Group__4_in_rule__TableTest__Group__35783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__ParameterHeadersAssignment_3_in_rule__TableTest__Group__3__Impl5810 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_rule__TableTest__Group__4__Impl_in_rule__TableTest__Group__45841 = new BitSet(new long[]{0x0000000800002010L});
    public static final BitSet FOLLOW_rule__TableTest__Group__5_in_rule__TableTest__Group__45844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__ResultHeadersAssignment_4_in_rule__TableTest__Group__4__Impl5871 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_rule__TableTest__Group__5__Impl_in_rule__TableTest__Group__55902 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__TableTest__Group__6_in_rule__TableTest__Group__55905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Alternatives_5_in_rule__TableTest__Group__5__Impl5932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group__6__Impl_in_rule__TableTest__Group__65962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__RowsAssignment_6_in_rule__TableTest__Group__6__Impl5991 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_rule__TableTest__RowsAssignment_6_in_rule__TableTest__Group__6__Impl6003 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_rule__TableTest__Group_5_0__0__Impl_in_rule__TableTest__Group_5_0__06050 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__TableTest__Group_5_0__1_in_rule__TableTest__Group_5_0__06053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__TableTest__Group_5_0__0__Impl6081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group_5_0__1__Impl_in_rule__TableTest__Group_5_0__16112 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__TableTest__Group_5_0__2_in_rule__TableTest__Group_5_0__16115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__TableTest__Group_5_0__1__Impl6143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTest__Group_5_0__2__Impl_in_rule__TableTest__Group_5_0__26174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__TableTest__Group_5_0__2__Impl6202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group__0__Impl_in_rule__TableTestRow__Group__06239 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group__1_in_rule__TableTestRow__Group__06242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group__1__Impl_in_rule__TableTestRow__Group__16300 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group__2_in_rule__TableTestRow__Group__16303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__ValuesAssignment_1_in_rule__TableTestRow__Group__1__Impl6330 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group__2__Impl_in_rule__TableTestRow__Group__26361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Alternatives_2_in_rule__TableTestRow__Group__2__Impl6388 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group_2_0__0__Impl_in_rule__TableTestRow__Group_2_0__06424 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group_2_0__1_in_rule__TableTestRow__Group_2_0__06427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__TableTestRow__Group_2_0__0__Impl6455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group_2_0__1__Impl_in_rule__TableTestRow__Group_2_0__16486 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group_2_0__2_in_rule__TableTestRow__Group_2_0__16489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__TableTestRow__Group_2_0__1__Impl6517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group_2_0__2__Impl_in_rule__TableTestRow__Group_2_0__26548 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group_2_0__3_in_rule__TableTestRow__Group_2_0__26551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__ResultAssignment_2_0_2_in_rule__TableTestRow__Group_2_0__2__Impl6578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TableTestRow__Group_2_0__3__Impl_in_rule__TableTestRow__Group_2_0__36608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__TableTestRow__Group_2_0__3__Impl6636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableHeader__Group__0__Impl_in_rule__ParameterTableHeader__Group__06675 = new BitSet(new long[]{0x0000000800000010L});
    public static final BitSet FOLLOW_rule__ParameterTableHeader__Group__1_in_rule__ParameterTableHeader__Group__06678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__ParameterTableHeader__Group__0__Impl6706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableHeader__Group__1__Impl_in_rule__ParameterTableHeader__Group__16737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableHeader__NameAssignment_1_in_rule__ParameterTableHeader__Group__1__Impl6764 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultTableHeader__Group__0__Impl_in_rule__ResultTableHeader__Group__06798 = new BitSet(new long[]{0x0000000800000010L});
    public static final BitSet FOLLOW_rule__ResultTableHeader__Group__1_in_rule__ResultTableHeader__Group__06801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__ResultTableHeader__Group__0__Impl6829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultTableHeader__Group__1__Impl_in_rule__ResultTableHeader__Group__16860 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__ResultTableHeader__Group__2_in_rule__ResultTableHeader__Group__16863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultTableHeader__NameAssignment_1_in_rule__ResultTableHeader__Group__1__Impl6890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ResultTableHeader__Group__2__Impl_in_rule__ResultTableHeader__Group__26920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ResultTableHeader__Group__2__Impl6948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableValue__Group__0__Impl_in_rule__ParameterTableValue__Group__06985 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__ParameterTableValue__Group__1_in_rule__ParameterTableValue__Group__06988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__ParameterTableValue__Group__0__Impl7016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableValue__Group__1__Impl_in_rule__ParameterTableValue__Group__17047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ParameterTableValue__ValueAssignment_1_in_rule__ParameterTableValue__Group__1__Impl7074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedResult__Group__0__Impl_in_rule__NamedResult__Group__07108 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__NamedResult__Group__1_in_rule__NamedResult__Group__07111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedResult__NameAssignment_0_in_rule__NamedResult__Group__0__Impl7138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedResult__Group__1__Impl_in_rule__NamedResult__Group__17168 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__NamedResult__Group__2_in_rule__NamedResult__Group__17171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__NamedResult__Group__1__Impl7199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedResult__Group__2__Impl_in_rule__NamedResult__Group__27230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__NamedResult__ValueAssignment_2_in_rule__NamedResult__Group__2__Impl7257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__0__Impl_in_rule__Call__Group__07293 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Call__Group__1_in_rule__Call__Group__07296 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Call__Group__0__Impl7324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__1__Impl_in_rule__Call__Group__17355 = new BitSet(new long[]{0x0000000900000010L});
    public static final BitSet FOLLOW_rule__Call__Group__2_in_rule__Call__Group__17358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__DefinitionAssignment_1_in_rule__Call__Group__1__Impl7385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group__2__Impl_in_rule__Call__Group__27415 = new BitSet(new long[]{0x0000000900000010L});
    public static final BitSet FOLLOW_rule__Call__Group__3_in_rule__Call__Group__27418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__ParametersAssignment_2_in_rule__Call__Group__2__Impl7445 = new BitSet(new long[]{0x0000000800000012L});
    public static final BitSet FOLLOW_rule__Call__Group__3__Impl_in_rule__Call__Group__37476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group_3__0_in_rule__Call__Group__3__Impl7503 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group_3__0__Impl_in_rule__Call__Group_3__07542 = new BitSet(new long[]{0x00000000000001D0L});
    public static final BitSet FOLLOW_rule__Call__Group_3__1_in_rule__Call__Group_3__07545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__Call__Group_3__0__Impl7573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__Group_3__1__Impl_in_rule__Call__Group_3__17604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Call__ResultAssignment_3_1_in_rule__Call__Group_3__1__Impl7631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group__0__Impl_in_rule__Suite__Group__07665 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Suite__Group__1_in_rule__Suite__Group__07668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Suite__Group__0__Impl7696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group__1__Impl_in_rule__Suite__Group__17727 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Suite__Group__2_in_rule__Suite__Group__17730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__DefinitionAssignment_1_in_rule__Suite__Group__1__Impl7757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__Group__2__Impl_in_rule__Suite__Group__27787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Suite__ParametersAssignment_2_in_rule__Suite__Group__2__Impl7814 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__0__Impl_in_rule__SuiteParameter__Group__07851 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__1_in_rule__SuiteParameter__Group__07854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__NameAssignment_0_in_rule__SuiteParameter__Group__0__Impl7881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__1__Impl_in_rule__SuiteParameter__Group__17911 = new BitSet(new long[]{0x00000000000001D0L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__2_in_rule__SuiteParameter__Group__17914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__SuiteParameter__Group__1__Impl7942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__Group__2__Impl_in_rule__SuiteParameter__Group__27973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SuiteParameter__ValueAssignment_2_in_rule__SuiteParameter__Group__2__Impl8000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__0__Impl_in_rule__Parameter__Group__08036 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Parameter__Group__1_in_rule__Parameter__Group__08039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__NameAssignment_0_in_rule__Parameter__Group__0__Impl8066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__1__Impl_in_rule__Parameter__Group__18096 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_rule__Parameter__Group__2_in_rule__Parameter__Group__18099 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Parameter__Group__1__Impl8127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__Group__2__Impl_in_rule__Parameter__Group__28158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Parameter__ValueAssignment_2_in_rule__Parameter__Group__2__Impl8185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArbitraryParameterOrResultName__Group__0__Impl_in_rule__ArbitraryParameterOrResultName__Group__08221 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ArbitraryParameterOrResultName__Group__1_in_rule__ArbitraryParameterOrResultName__Group__08224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__ArbitraryParameterOrResultName__Group__0__Impl8252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArbitraryParameterOrResultName__Group__1__Impl_in_rule__ArbitraryParameterOrResultName__Group__18283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArbitraryParameterOrResultName__IdentifierAssignment_1_in_rule__ArbitraryParameterOrResultName__Group__1__Impl8310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__0__Impl_in_rule__MethodReference__Group__08344 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__1_in_rule__MethodReference__Group__08347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__TypeAssignment_0_in_rule__MethodReference__Group__0__Impl8374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__1__Impl_in_rule__MethodReference__Group__18404 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__2_in_rule__MethodReference__Group__18407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__MethodReference__Group__1__Impl8435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__Group__2__Impl_in_rule__MethodReference__Group__28466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__MethodReference__MethodAssignment_2_in_rule__MethodReference__Group__2__Impl8493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__08529 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__08532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl8559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__18588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl8615 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__08650 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__08653 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__QualifiedName__Group_1__0__Impl8681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__18712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl8739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__0__Impl_in_rule__QualifiedJavaClassName__Group__08772 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__1_in_rule__QualifiedJavaClassName__Group__08775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedJavaClassName__Group__0__Impl8802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__1__Impl_in_rule__QualifiedJavaClassName__Group__18831 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__2_in_rule__QualifiedJavaClassName__Group__18834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__QualifiedJavaClassName__Group__1__Impl8862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedJavaClassName__Group__2__Impl_in_rule__QualifiedJavaClassName__Group__28893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UPPERCASE_ID_in_rule__QualifiedJavaClassName__Group__2__Impl8920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__0__Impl_in_rule__QualifiedNameWithWildcard__Group__08955 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__1_in_rule__QualifiedNameWithWildcard__Group__08958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__QualifiedNameWithWildcard__Group__0__Impl8985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedNameWithWildcard__Group__1__Impl_in_rule__QualifiedNameWithWildcard__Group__19014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__QualifiedNameWithWildcard__Group__1__Impl9043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_rule__Model__StatementsAssignment9085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__PackageDefinition__NameAssignment_19116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageStatement_in_rule__PackageDefinition__StatementsAssignment_39147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_rule__Import__ImportedNamespaceAssignment_19178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__TestDefinition__NameAssignment_19209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodReference_in_rule__TestDefinition__FixtureMethodAssignment_39240 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__CallDefinition__NameAssignment_19271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodReference_in_rule__CallDefinition__FixtureMethodAssignment_39302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__NameAssignment_19333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_rule__SuiteDefinition__ParametersAssignment_2_19364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__DependenciesAssignment_3_19399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteStatement_in_rule__SuiteDefinition__StatementsAssignment_59434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__SuiteDefinition__FinalizersAssignment_7_19469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_rule__VariableDefinition__NameAssignment_19504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__VariableDefinition__InitialValueAssignment_2_19535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__VariableEntity__NameAssignment9566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Test__DefinitionAssignment_19601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_rule__Test__ParametersAssignment_29636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedResult_in_rule__Test__ResultsAssignment_39667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_rule__Test__ResultAssignment_4_19698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__TableTest__DefinitionAssignment_19733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_rule__TableTest__ParametersAssignment_29768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableHeader_in_rule__TableTest__ParameterHeadersAssignment_39799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultTableHeader_in_rule__TableTest__ResultHeadersAssignment_49830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTableTestRow_in_rule__TableTest__RowsAssignment_69861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableValue_in_rule__TableTestRow__ValuesAssignment_19892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_rule__TableTestRow__ResultAssignment_2_0_29923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterName_in_rule__ParameterTableHeader__NameAssignment_19954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultName_in_rule__ResultTableHeader__NameAssignment_19985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_rule__ParameterTableValue__ValueAssignment_110016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultName_in_rule__NamedResult__NameAssignment_010047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_rule__NamedResult__ValueAssignment_210078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FixedResultName__FieldAssignment10113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Call__DefinitionAssignment_110152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_rule__Call__ParametersAssignment_210187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_rule__Call__ResultAssignment_3_110218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Suite__DefinitionAssignment_110253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteParameter_in_rule__Suite__ParametersAssignment_210288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__SuiteParameter__NameAssignment_010323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_rule__SuiteParameter__ValueAssignment_210358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterName_in_rule__Parameter__NameAssignment_010389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_rule__Parameter__ValueAssignment_210420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__FixedParameterName__AnnotationAssignment10455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ArbitraryParameterOrResultName__IdentifierAssignment_110490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_rule__IntegerValue__IntegerValueAssignment10521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DECIMAL_in_rule__DecimalValue__DecimalValueAssignment10552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__StringValue__StringValueAssignment10583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__Variable__NameAssignment10618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UPPERCASE_ID_in_rule__EnumValue__EnumValueAssignment10657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_rule__MethodReference__TypeAssignment_010696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__MethodReference__MethodAssignment_210735 = new BitSet(new long[]{0x0000000000000002L});

}