package de.integrity.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.integrity.services.DSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDSLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INTEGER", "RULE_DECIMAL", "RULE_STRING", "RULE_UPPERCASE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'packagedef'", "'with'", "'packageend'", "'import'", "'testdef'", "'uses'", "'calldef'", "'suitedef'", "'gets'", "'requires'", "'suiteend'", "'concludedby'", "'variable'", "'initially'", "'test'", "'='", "'tabletest'", "'|'", "'+'", "'call'", "'sets'", "'suite'", "':'", "'#'", "'.'", "'.*'"
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
    public static final int RULE_STRING=7;
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
    public static final int RULE_UPPERCASE_ID=8;
    public static final int RULE_WS=11;
    public static final int RULE_DECIMAL=6;
    public static final int RULE_INTEGER=5;

    // delegates
    // delegators


        public InternalDSLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDSLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDSLParser.tokenNames; }
    public String getGrammarFileName() { return "../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g"; }



     	private DSLGrammarAccess grammarAccess;
     	
        public InternalDSLParser(TokenStream input, DSLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	}
       	
       	@Override
       	protected DSLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleModel"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel75);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel85); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:76:1: ruleModel returns [EObject current=null] : ( (lv_statements_0_0= ruleStatement ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_statements_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:79:28: ( ( (lv_statements_0_0= ruleStatement ) )* )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:80:1: ( (lv_statements_0_0= ruleStatement ) )*
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:80:1: ( (lv_statements_0_0= ruleStatement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13||LA1_0==16||LA1_0==34) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:81:1: (lv_statements_0_0= ruleStatement )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:81:1: (lv_statements_0_0= ruleStatement )
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:82:3: lv_statements_0_0= ruleStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getStatementsStatementParserRuleCall_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleStatement_in_ruleModel130);
            	    lv_statements_0_0=ruleStatement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"statements",
            	            		lv_statements_0_0, 
            	            		"Statement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleStatement"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:106:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:107:2: (iv_ruleStatement= ruleStatement EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:108:2: iv_ruleStatement= ruleStatement EOF
            {
             newCompositeNode(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_ruleStatement_in_entryRuleStatement166);
            iv_ruleStatement=ruleStatement();

            state._fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatement176); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:115:1: ruleStatement returns [EObject current=null] : (this_PackageDefinition_0= rulePackageDefinition | this_Import_1= ruleImport | this_Suite_2= ruleSuite ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_PackageDefinition_0 = null;

        EObject this_Import_1 = null;

        EObject this_Suite_2 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:118:28: ( (this_PackageDefinition_0= rulePackageDefinition | this_Import_1= ruleImport | this_Suite_2= ruleSuite ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:119:1: (this_PackageDefinition_0= rulePackageDefinition | this_Import_1= ruleImport | this_Suite_2= ruleSuite )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:119:1: (this_PackageDefinition_0= rulePackageDefinition | this_Import_1= ruleImport | this_Suite_2= ruleSuite )
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
            case 34:
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
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:120:5: this_PackageDefinition_0= rulePackageDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getPackageDefinitionParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulePackageDefinition_in_ruleStatement223);
                    this_PackageDefinition_0=rulePackageDefinition();

                    state._fsp--;

                     
                            current = this_PackageDefinition_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:130:5: this_Import_1= ruleImport
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getImportParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleImport_in_ruleStatement250);
                    this_Import_1=ruleImport();

                    state._fsp--;

                     
                            current = this_Import_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:140:5: this_Suite_2= ruleSuite
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getSuiteParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleSuite_in_ruleStatement277);
                    this_Suite_2=ruleSuite();

                    state._fsp--;

                     
                            current = this_Suite_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRulePackageDefinition"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:156:1: entryRulePackageDefinition returns [EObject current=null] : iv_rulePackageDefinition= rulePackageDefinition EOF ;
    public final EObject entryRulePackageDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:157:2: (iv_rulePackageDefinition= rulePackageDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:158:2: iv_rulePackageDefinition= rulePackageDefinition EOF
            {
             newCompositeNode(grammarAccess.getPackageDefinitionRule()); 
            pushFollow(FOLLOW_rulePackageDefinition_in_entryRulePackageDefinition312);
            iv_rulePackageDefinition=rulePackageDefinition();

            state._fsp--;

             current =iv_rulePackageDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePackageDefinition322); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePackageDefinition"


    // $ANTLR start "rulePackageDefinition"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:165:1: rulePackageDefinition returns [EObject current=null] : (otherlv_0= 'packagedef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'with' ( (lv_statements_3_0= rulePackageStatement ) )* otherlv_4= 'packageend' ) ;
    public final EObject rulePackageDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_statements_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:168:28: ( (otherlv_0= 'packagedef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'with' ( (lv_statements_3_0= rulePackageStatement ) )* otherlv_4= 'packageend' ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:169:1: (otherlv_0= 'packagedef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'with' ( (lv_statements_3_0= rulePackageStatement ) )* otherlv_4= 'packageend' )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:169:1: (otherlv_0= 'packagedef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'with' ( (lv_statements_3_0= rulePackageStatement ) )* otherlv_4= 'packageend' )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:169:3: otherlv_0= 'packagedef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'with' ( (lv_statements_3_0= rulePackageStatement ) )* otherlv_4= 'packageend'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_rulePackageDefinition359); 

                	newLeafNode(otherlv_0, grammarAccess.getPackageDefinitionAccess().getPackagedefKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:173:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:174:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:174:1: (lv_name_1_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:175:3: lv_name_1_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getPackageDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_rulePackageDefinition380);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPackageDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,14,FOLLOW_14_in_rulePackageDefinition392); 

                	newLeafNode(otherlv_2, grammarAccess.getPackageDefinitionAccess().getWithKeyword_2());
                
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:195:1: ( (lv_statements_3_0= rulePackageStatement ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=16 && LA3_0<=17)||(LA3_0>=19 && LA3_0<=20)||LA3_0==25) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:196:1: (lv_statements_3_0= rulePackageStatement )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:196:1: (lv_statements_3_0= rulePackageStatement )
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:197:3: lv_statements_3_0= rulePackageStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPackageDefinitionAccess().getStatementsPackageStatementParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePackageStatement_in_rulePackageDefinition413);
            	    lv_statements_3_0=rulePackageStatement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPackageDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"statements",
            	            		lv_statements_3_0, 
            	            		"PackageStatement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_4=(Token)match(input,15,FOLLOW_15_in_rulePackageDefinition426); 

                	newLeafNode(otherlv_4, grammarAccess.getPackageDefinitionAccess().getPackageendKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePackageDefinition"


    // $ANTLR start "entryRulePackageStatement"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:225:1: entryRulePackageStatement returns [EObject current=null] : iv_rulePackageStatement= rulePackageStatement EOF ;
    public final EObject entryRulePackageStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageStatement = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:226:2: (iv_rulePackageStatement= rulePackageStatement EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:227:2: iv_rulePackageStatement= rulePackageStatement EOF
            {
             newCompositeNode(grammarAccess.getPackageStatementRule()); 
            pushFollow(FOLLOW_rulePackageStatement_in_entryRulePackageStatement462);
            iv_rulePackageStatement=rulePackageStatement();

            state._fsp--;

             current =iv_rulePackageStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePackageStatement472); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePackageStatement"


    // $ANTLR start "rulePackageStatement"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:234:1: rulePackageStatement returns [EObject current=null] : (this_Import_0= ruleImport | this_TestDefinition_1= ruleTestDefinition | this_CallDefinition_2= ruleCallDefinition | this_SuiteDefinition_3= ruleSuiteDefinition | this_VariableDefinition_4= ruleVariableDefinition ) ;
    public final EObject rulePackageStatement() throws RecognitionException {
        EObject current = null;

        EObject this_Import_0 = null;

        EObject this_TestDefinition_1 = null;

        EObject this_CallDefinition_2 = null;

        EObject this_SuiteDefinition_3 = null;

        EObject this_VariableDefinition_4 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:237:28: ( (this_Import_0= ruleImport | this_TestDefinition_1= ruleTestDefinition | this_CallDefinition_2= ruleCallDefinition | this_SuiteDefinition_3= ruleSuiteDefinition | this_VariableDefinition_4= ruleVariableDefinition ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:238:1: (this_Import_0= ruleImport | this_TestDefinition_1= ruleTestDefinition | this_CallDefinition_2= ruleCallDefinition | this_SuiteDefinition_3= ruleSuiteDefinition | this_VariableDefinition_4= ruleVariableDefinition )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:238:1: (this_Import_0= ruleImport | this_TestDefinition_1= ruleTestDefinition | this_CallDefinition_2= ruleCallDefinition | this_SuiteDefinition_3= ruleSuiteDefinition | this_VariableDefinition_4= ruleVariableDefinition )
            int alt4=5;
            switch ( input.LA(1) ) {
            case 16:
                {
                alt4=1;
                }
                break;
            case 17:
                {
                alt4=2;
                }
                break;
            case 19:
                {
                alt4=3;
                }
                break;
            case 20:
                {
                alt4=4;
                }
                break;
            case 25:
                {
                alt4=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:239:5: this_Import_0= ruleImport
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getImportParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleImport_in_rulePackageStatement519);
                    this_Import_0=ruleImport();

                    state._fsp--;

                     
                            current = this_Import_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:249:5: this_TestDefinition_1= ruleTestDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getTestDefinitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleTestDefinition_in_rulePackageStatement546);
                    this_TestDefinition_1=ruleTestDefinition();

                    state._fsp--;

                     
                            current = this_TestDefinition_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:259:5: this_CallDefinition_2= ruleCallDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getCallDefinitionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleCallDefinition_in_rulePackageStatement573);
                    this_CallDefinition_2=ruleCallDefinition();

                    state._fsp--;

                     
                            current = this_CallDefinition_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:269:5: this_SuiteDefinition_3= ruleSuiteDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getSuiteDefinitionParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleSuiteDefinition_in_rulePackageStatement600);
                    this_SuiteDefinition_3=ruleSuiteDefinition();

                    state._fsp--;

                     
                            current = this_SuiteDefinition_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:279:5: this_VariableDefinition_4= ruleVariableDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getVariableDefinitionParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleVariableDefinition_in_rulePackageStatement627);
                    this_VariableDefinition_4=ruleVariableDefinition();

                    state._fsp--;

                     
                            current = this_VariableDefinition_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePackageStatement"


    // $ANTLR start "entryRuleImport"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:295:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:296:2: (iv_ruleImport= ruleImport EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:297:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport662);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport672); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:304:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:307:28: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:308:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:308:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:308:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleImport709); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:312:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:313:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:313:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:314:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard
            {
             
            	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_ruleImport730);
            lv_importedNamespace_1_0=ruleQualifiedNameWithWildcard();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getImportRule());
            	        }
                   		set(
                   			current, 
                   			"importedNamespace",
                    		lv_importedNamespace_1_0, 
                    		"QualifiedNameWithWildcard");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleTestDefinition"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:338:1: entryRuleTestDefinition returns [EObject current=null] : iv_ruleTestDefinition= ruleTestDefinition EOF ;
    public final EObject entryRuleTestDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:339:2: (iv_ruleTestDefinition= ruleTestDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:340:2: iv_ruleTestDefinition= ruleTestDefinition EOF
            {
             newCompositeNode(grammarAccess.getTestDefinitionRule()); 
            pushFollow(FOLLOW_ruleTestDefinition_in_entryRuleTestDefinition766);
            iv_ruleTestDefinition=ruleTestDefinition();

            state._fsp--;

             current =iv_ruleTestDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestDefinition776); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTestDefinition"


    // $ANTLR start "ruleTestDefinition"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:347:1: ruleTestDefinition returns [EObject current=null] : (otherlv_0= 'testdef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) ) ;
    public final EObject ruleTestDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_fixtureMethod_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:350:28: ( (otherlv_0= 'testdef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:351:1: (otherlv_0= 'testdef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:351:1: (otherlv_0= 'testdef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:351:3: otherlv_0= 'testdef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleTestDefinition813); 

                	newLeafNode(otherlv_0, grammarAccess.getTestDefinitionAccess().getTestdefKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:355:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:356:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:356:1: (lv_name_1_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:357:3: lv_name_1_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getTestDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleTestDefinition834);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTestDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleTestDefinition846); 

                	newLeafNode(otherlv_2, grammarAccess.getTestDefinitionAccess().getUsesKeyword_2());
                
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:377:1: ( (lv_fixtureMethod_3_0= ruleMethodReference ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:378:1: (lv_fixtureMethod_3_0= ruleMethodReference )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:378:1: (lv_fixtureMethod_3_0= ruleMethodReference )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:379:3: lv_fixtureMethod_3_0= ruleMethodReference
            {
             
            	        newCompositeNode(grammarAccess.getTestDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleMethodReference_in_ruleTestDefinition867);
            lv_fixtureMethod_3_0=ruleMethodReference();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTestDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"fixtureMethod",
                    		lv_fixtureMethod_3_0, 
                    		"MethodReference");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTestDefinition"


    // $ANTLR start "entryRuleCallDefinition"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:403:1: entryRuleCallDefinition returns [EObject current=null] : iv_ruleCallDefinition= ruleCallDefinition EOF ;
    public final EObject entryRuleCallDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:404:2: (iv_ruleCallDefinition= ruleCallDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:405:2: iv_ruleCallDefinition= ruleCallDefinition EOF
            {
             newCompositeNode(grammarAccess.getCallDefinitionRule()); 
            pushFollow(FOLLOW_ruleCallDefinition_in_entryRuleCallDefinition903);
            iv_ruleCallDefinition=ruleCallDefinition();

            state._fsp--;

             current =iv_ruleCallDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallDefinition913); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCallDefinition"


    // $ANTLR start "ruleCallDefinition"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:412:1: ruleCallDefinition returns [EObject current=null] : (otherlv_0= 'calldef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) ) ;
    public final EObject ruleCallDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_fixtureMethod_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:415:28: ( (otherlv_0= 'calldef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:416:1: (otherlv_0= 'calldef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:416:1: (otherlv_0= 'calldef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:416:3: otherlv_0= 'calldef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) )
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleCallDefinition950); 

                	newLeafNode(otherlv_0, grammarAccess.getCallDefinitionAccess().getCalldefKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:420:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:421:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:421:1: (lv_name_1_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:422:3: lv_name_1_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getCallDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleCallDefinition971);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCallDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleCallDefinition983); 

                	newLeafNode(otherlv_2, grammarAccess.getCallDefinitionAccess().getUsesKeyword_2());
                
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:442:1: ( (lv_fixtureMethod_3_0= ruleMethodReference ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:443:1: (lv_fixtureMethod_3_0= ruleMethodReference )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:443:1: (lv_fixtureMethod_3_0= ruleMethodReference )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:444:3: lv_fixtureMethod_3_0= ruleMethodReference
            {
             
            	        newCompositeNode(grammarAccess.getCallDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleMethodReference_in_ruleCallDefinition1004);
            lv_fixtureMethod_3_0=ruleMethodReference();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCallDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"fixtureMethod",
                    		lv_fixtureMethod_3_0, 
                    		"MethodReference");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCallDefinition"


    // $ANTLR start "entryRuleSuiteDefinition"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:468:1: entryRuleSuiteDefinition returns [EObject current=null] : iv_ruleSuiteDefinition= ruleSuiteDefinition EOF ;
    public final EObject entryRuleSuiteDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:469:2: (iv_ruleSuiteDefinition= ruleSuiteDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:470:2: iv_ruleSuiteDefinition= ruleSuiteDefinition EOF
            {
             newCompositeNode(grammarAccess.getSuiteDefinitionRule()); 
            pushFollow(FOLLOW_ruleSuiteDefinition_in_entryRuleSuiteDefinition1040);
            iv_ruleSuiteDefinition=ruleSuiteDefinition();

            state._fsp--;

             current =iv_ruleSuiteDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteDefinition1050); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSuiteDefinition"


    // $ANTLR start "ruleSuiteDefinition"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:477:1: ruleSuiteDefinition returns [EObject current=null] : (otherlv_0= 'suitedef' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )* )? (otherlv_4= 'requires' ( ( ruleQualifiedName ) )* )? otherlv_6= 'with' ( (lv_statements_7_0= ruleSuiteStatement ) )* otherlv_8= 'suiteend' (otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )* )? ) ;
    public final EObject ruleSuiteDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_parameters_3_0 = null;

        EObject lv_statements_7_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:480:28: ( (otherlv_0= 'suitedef' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )* )? (otherlv_4= 'requires' ( ( ruleQualifiedName ) )* )? otherlv_6= 'with' ( (lv_statements_7_0= ruleSuiteStatement ) )* otherlv_8= 'suiteend' (otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )* )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:481:1: (otherlv_0= 'suitedef' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )* )? (otherlv_4= 'requires' ( ( ruleQualifiedName ) )* )? otherlv_6= 'with' ( (lv_statements_7_0= ruleSuiteStatement ) )* otherlv_8= 'suiteend' (otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )* )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:481:1: (otherlv_0= 'suitedef' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )* )? (otherlv_4= 'requires' ( ( ruleQualifiedName ) )* )? otherlv_6= 'with' ( (lv_statements_7_0= ruleSuiteStatement ) )* otherlv_8= 'suiteend' (otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )* )? )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:481:3: otherlv_0= 'suitedef' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )* )? (otherlv_4= 'requires' ( ( ruleQualifiedName ) )* )? otherlv_6= 'with' ( (lv_statements_7_0= ruleSuiteStatement ) )* otherlv_8= 'suiteend' (otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )* )?
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleSuiteDefinition1087); 

                	newLeafNode(otherlv_0, grammarAccess.getSuiteDefinitionAccess().getSuitedefKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:485:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:486:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:486:1: (lv_name_1_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:487:3: lv_name_1_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuiteDefinition1108);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSuiteDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:503:2: (otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==21) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:503:4: otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )*
                    {
                    otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleSuiteDefinition1121); 

                        	newLeafNode(otherlv_2, grammarAccess.getSuiteDefinitionAccess().getGetsKeyword_2_0());
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:507:1: ( (lv_parameters_3_0= ruleVariableEntity ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==RULE_ID) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:508:1: (lv_parameters_3_0= ruleVariableEntity )
                    	    {
                    	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:508:1: (lv_parameters_3_0= ruleVariableEntity )
                    	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:509:3: lv_parameters_3_0= ruleVariableEntity
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getParametersVariableEntityParserRuleCall_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleVariableEntity_in_ruleSuiteDefinition1142);
                    	    lv_parameters_3_0=ruleVariableEntity();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSuiteDefinitionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"parameters",
                    	            		lv_parameters_3_0, 
                    	            		"VariableEntity");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:525:5: (otherlv_4= 'requires' ( ( ruleQualifiedName ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==22) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:525:7: otherlv_4= 'requires' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_4=(Token)match(input,22,FOLLOW_22_in_ruleSuiteDefinition1158); 

                        	newLeafNode(otherlv_4, grammarAccess.getSuiteDefinitionAccess().getRequiresKeyword_3_0());
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:529:1: ( ( ruleQualifiedName ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==RULE_ID) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:530:1: ( ruleQualifiedName )
                    	    {
                    	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:530:1: ( ruleQualifiedName )
                    	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:531:3: ruleQualifiedName
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSuiteDefinitionRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getDependenciesSuiteDefinitionCrossReference_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuiteDefinition1181);
                    	    ruleQualifiedName();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,14,FOLLOW_14_in_ruleSuiteDefinition1196); 

                	newLeafNode(otherlv_6, grammarAccess.getSuiteDefinitionAccess().getWithKeyword_4());
                
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:548:1: ( (lv_statements_7_0= ruleSuiteStatement ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==25||LA9_0==27||LA9_0==29||LA9_0==32||LA9_0==34) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:549:1: (lv_statements_7_0= ruleSuiteStatement )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:549:1: (lv_statements_7_0= ruleSuiteStatement )
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:550:3: lv_statements_7_0= ruleSuiteStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getStatementsSuiteStatementParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSuiteStatement_in_ruleSuiteDefinition1217);
            	    lv_statements_7_0=ruleSuiteStatement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSuiteDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"statements",
            	            		lv_statements_7_0, 
            	            		"SuiteStatement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_8=(Token)match(input,23,FOLLOW_23_in_ruleSuiteDefinition1230); 

                	newLeafNode(otherlv_8, grammarAccess.getSuiteDefinitionAccess().getSuiteendKeyword_6());
                
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:570:1: (otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==24) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:570:3: otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_9=(Token)match(input,24,FOLLOW_24_in_ruleSuiteDefinition1243); 

                        	newLeafNode(otherlv_9, grammarAccess.getSuiteDefinitionAccess().getConcludedbyKeyword_7_0());
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:574:1: ( ( ruleQualifiedName ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==RULE_ID) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:575:1: ( ruleQualifiedName )
                    	    {
                    	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:575:1: ( ruleQualifiedName )
                    	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:576:3: ruleQualifiedName
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSuiteDefinitionRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getFinalizersSuiteDefinitionCrossReference_7_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuiteDefinition1266);
                    	    ruleQualifiedName();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSuiteDefinition"


    // $ANTLR start "entryRuleSuiteStatement"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:597:1: entryRuleSuiteStatement returns [EObject current=null] : iv_ruleSuiteStatement= ruleSuiteStatement EOF ;
    public final EObject entryRuleSuiteStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteStatement = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:598:2: (iv_ruleSuiteStatement= ruleSuiteStatement EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:599:2: iv_ruleSuiteStatement= ruleSuiteStatement EOF
            {
             newCompositeNode(grammarAccess.getSuiteStatementRule()); 
            pushFollow(FOLLOW_ruleSuiteStatement_in_entryRuleSuiteStatement1305);
            iv_ruleSuiteStatement=ruleSuiteStatement();

            state._fsp--;

             current =iv_ruleSuiteStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteStatement1315); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSuiteStatement"


    // $ANTLR start "ruleSuiteStatement"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:606:1: ruleSuiteStatement returns [EObject current=null] : (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_Call_1= ruleCall | this_VariableDefinition_2= ruleVariableDefinition ) ;
    public final EObject ruleSuiteStatement() throws RecognitionException {
        EObject current = null;

        EObject this_SuiteStatementWithResult_0 = null;

        EObject this_Call_1 = null;

        EObject this_VariableDefinition_2 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:609:28: ( (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_Call_1= ruleCall | this_VariableDefinition_2= ruleVariableDefinition ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:610:1: (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_Call_1= ruleCall | this_VariableDefinition_2= ruleVariableDefinition )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:610:1: (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_Call_1= ruleCall | this_VariableDefinition_2= ruleVariableDefinition )
            int alt12=3;
            switch ( input.LA(1) ) {
            case 27:
            case 29:
            case 34:
                {
                alt12=1;
                }
                break;
            case 32:
                {
                alt12=2;
                }
                break;
            case 25:
                {
                alt12=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }

            switch (alt12) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:611:5: this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getSuiteStatementWithResultParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSuiteStatementWithResult_in_ruleSuiteStatement1362);
                    this_SuiteStatementWithResult_0=ruleSuiteStatementWithResult();

                    state._fsp--;

                     
                            current = this_SuiteStatementWithResult_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:621:5: this_Call_1= ruleCall
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getCallParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleCall_in_ruleSuiteStatement1389);
                    this_Call_1=ruleCall();

                    state._fsp--;

                     
                            current = this_Call_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:631:5: this_VariableDefinition_2= ruleVariableDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getVariableDefinitionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleVariableDefinition_in_ruleSuiteStatement1416);
                    this_VariableDefinition_2=ruleVariableDefinition();

                    state._fsp--;

                     
                            current = this_VariableDefinition_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSuiteStatement"


    // $ANTLR start "entryRuleSuiteStatementWithResult"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:647:1: entryRuleSuiteStatementWithResult returns [EObject current=null] : iv_ruleSuiteStatementWithResult= ruleSuiteStatementWithResult EOF ;
    public final EObject entryRuleSuiteStatementWithResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteStatementWithResult = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:648:2: (iv_ruleSuiteStatementWithResult= ruleSuiteStatementWithResult EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:649:2: iv_ruleSuiteStatementWithResult= ruleSuiteStatementWithResult EOF
            {
             newCompositeNode(grammarAccess.getSuiteStatementWithResultRule()); 
            pushFollow(FOLLOW_ruleSuiteStatementWithResult_in_entryRuleSuiteStatementWithResult1451);
            iv_ruleSuiteStatementWithResult=ruleSuiteStatementWithResult();

            state._fsp--;

             current =iv_ruleSuiteStatementWithResult; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteStatementWithResult1461); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSuiteStatementWithResult"


    // $ANTLR start "ruleSuiteStatementWithResult"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:656:1: ruleSuiteStatementWithResult returns [EObject current=null] : (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest ) ;
    public final EObject ruleSuiteStatementWithResult() throws RecognitionException {
        EObject current = null;

        EObject this_Suite_0 = null;

        EObject this_Test_1 = null;

        EObject this_TableTest_2 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:659:28: ( (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:660:1: (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:660:1: (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest )
            int alt13=3;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt13=1;
                }
                break;
            case 27:
                {
                alt13=2;
                }
                break;
            case 29:
                {
                alt13=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:661:5: this_Suite_0= ruleSuite
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementWithResultAccess().getSuiteParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSuite_in_ruleSuiteStatementWithResult1508);
                    this_Suite_0=ruleSuite();

                    state._fsp--;

                     
                            current = this_Suite_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:671:5: this_Test_1= ruleTest
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementWithResultAccess().getTestParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleTest_in_ruleSuiteStatementWithResult1535);
                    this_Test_1=ruleTest();

                    state._fsp--;

                     
                            current = this_Test_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:681:5: this_TableTest_2= ruleTableTest
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementWithResultAccess().getTableTestParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleTableTest_in_ruleSuiteStatementWithResult1562);
                    this_TableTest_2=ruleTableTest();

                    state._fsp--;

                     
                            current = this_TableTest_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSuiteStatementWithResult"


    // $ANTLR start "entryRuleVariableDefinition"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:697:1: entryRuleVariableDefinition returns [EObject current=null] : iv_ruleVariableDefinition= ruleVariableDefinition EOF ;
    public final EObject entryRuleVariableDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:698:2: (iv_ruleVariableDefinition= ruleVariableDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:699:2: iv_ruleVariableDefinition= ruleVariableDefinition EOF
            {
             newCompositeNode(grammarAccess.getVariableDefinitionRule()); 
            pushFollow(FOLLOW_ruleVariableDefinition_in_entryRuleVariableDefinition1597);
            iv_ruleVariableDefinition=ruleVariableDefinition();

            state._fsp--;

             current =iv_ruleVariableDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDefinition1607); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableDefinition"


    // $ANTLR start "ruleVariableDefinition"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:706:1: ruleVariableDefinition returns [EObject current=null] : (otherlv_0= 'variable' ( (lv_name_1_0= ruleVariableEntity ) ) (otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) ) )? ) ;
    public final EObject ruleVariableDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_name_1_0 = null;

        EObject lv_initialValue_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:709:28: ( (otherlv_0= 'variable' ( (lv_name_1_0= ruleVariableEntity ) ) (otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) ) )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:710:1: (otherlv_0= 'variable' ( (lv_name_1_0= ruleVariableEntity ) ) (otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) ) )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:710:1: (otherlv_0= 'variable' ( (lv_name_1_0= ruleVariableEntity ) ) (otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) ) )? )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:710:3: otherlv_0= 'variable' ( (lv_name_1_0= ruleVariableEntity ) ) (otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) ) )?
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleVariableDefinition1644); 

                	newLeafNode(otherlv_0, grammarAccess.getVariableDefinitionAccess().getVariableKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:714:1: ( (lv_name_1_0= ruleVariableEntity ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:715:1: (lv_name_1_0= ruleVariableEntity )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:715:1: (lv_name_1_0= ruleVariableEntity )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:716:3: lv_name_1_0= ruleVariableEntity
            {
             
            	        newCompositeNode(grammarAccess.getVariableDefinitionAccess().getNameVariableEntityParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleVariableEntity_in_ruleVariableDefinition1665);
            lv_name_1_0=ruleVariableEntity();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVariableDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"VariableEntity");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:732:2: (otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==26) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:732:4: otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) )
                    {
                    otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleVariableDefinition1678); 

                        	newLeafNode(otherlv_2, grammarAccess.getVariableDefinitionAccess().getInitiallyKeyword_2_0());
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:736:1: ( (lv_initialValue_3_0= ruleValue ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:737:1: (lv_initialValue_3_0= ruleValue )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:737:1: (lv_initialValue_3_0= ruleValue )
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:738:3: lv_initialValue_3_0= ruleValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariableDefinitionAccess().getInitialValueValueParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValue_in_ruleVariableDefinition1699);
                    lv_initialValue_3_0=ruleValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVariableDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"initialValue",
                            		lv_initialValue_3_0, 
                            		"Value");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableDefinition"


    // $ANTLR start "entryRuleVariableEntity"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:762:1: entryRuleVariableEntity returns [EObject current=null] : iv_ruleVariableEntity= ruleVariableEntity EOF ;
    public final EObject entryRuleVariableEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableEntity = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:763:2: (iv_ruleVariableEntity= ruleVariableEntity EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:764:2: iv_ruleVariableEntity= ruleVariableEntity EOF
            {
             newCompositeNode(grammarAccess.getVariableEntityRule()); 
            pushFollow(FOLLOW_ruleVariableEntity_in_entryRuleVariableEntity1737);
            iv_ruleVariableEntity=ruleVariableEntity();

            state._fsp--;

             current =iv_ruleVariableEntity; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableEntity1747); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableEntity"


    // $ANTLR start "ruleVariableEntity"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:771:1: ruleVariableEntity returns [EObject current=null] : ( (lv_name_0_0= ruleQualifiedName ) ) ;
    public final EObject ruleVariableEntity() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:774:28: ( ( (lv_name_0_0= ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:775:1: ( (lv_name_0_0= ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:775:1: ( (lv_name_0_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:776:1: (lv_name_0_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:776:1: (lv_name_0_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:777:3: lv_name_0_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getVariableEntityAccess().getNameQualifiedNameParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleVariableEntity1792);
            lv_name_0_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVariableEntityRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableEntity"


    // $ANTLR start "entryRuleTest"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:801:1: entryRuleTest returns [EObject current=null] : iv_ruleTest= ruleTest EOF ;
    public final EObject entryRuleTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTest = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:802:2: (iv_ruleTest= ruleTest EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:803:2: iv_ruleTest= ruleTest EOF
            {
             newCompositeNode(grammarAccess.getTestRule()); 
            pushFollow(FOLLOW_ruleTest_in_entryRuleTest1827);
            iv_ruleTest=ruleTest();

            state._fsp--;

             current =iv_ruleTest; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTest1837); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTest"


    // $ANTLR start "ruleTest"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:810:1: ruleTest returns [EObject current=null] : (otherlv_0= 'test' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_results_3_0= ruleNamedTestResult ) )* (otherlv_4= '=' ( (lv_result_5_0= ruleValueOrEnumValue ) ) )? ) ;
    public final EObject ruleTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject lv_parameters_2_0 = null;

        EObject lv_results_3_0 = null;

        EObject lv_result_5_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:813:28: ( (otherlv_0= 'test' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_results_3_0= ruleNamedTestResult ) )* (otherlv_4= '=' ( (lv_result_5_0= ruleValueOrEnumValue ) ) )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:814:1: (otherlv_0= 'test' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_results_3_0= ruleNamedTestResult ) )* (otherlv_4= '=' ( (lv_result_5_0= ruleValueOrEnumValue ) ) )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:814:1: (otherlv_0= 'test' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_results_3_0= ruleNamedTestResult ) )* (otherlv_4= '=' ( (lv_result_5_0= ruleValueOrEnumValue ) ) )? )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:814:3: otherlv_0= 'test' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_results_3_0= ruleNamedTestResult ) )* (otherlv_4= '=' ( (lv_result_5_0= ruleValueOrEnumValue ) ) )?
            {
            otherlv_0=(Token)match(input,27,FOLLOW_27_in_ruleTest1874); 

                	newLeafNode(otherlv_0, grammarAccess.getTestAccess().getTestKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:818:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:819:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:819:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:820:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTestRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTestAccess().getDefinitionTestDefinitionCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleTest1897);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:833:2: ( (lv_parameters_2_0= ruleParameter ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID) ) {
                    int LA15_1 = input.LA(2);

                    if ( (LA15_1==35) ) {
                        alt15=1;
                    }


                }
                else if ( (LA15_0==31) ) {
                    int LA15_2 = input.LA(2);

                    if ( (LA15_2==RULE_ID) ) {
                        int LA15_5 = input.LA(3);

                        if ( (LA15_5==35) ) {
                            alt15=1;
                        }


                    }


                }


                switch (alt15) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:834:1: (lv_parameters_2_0= ruleParameter )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:834:1: (lv_parameters_2_0= ruleParameter )
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:835:3: lv_parameters_2_0= ruleParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTestAccess().getParametersParameterParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameter_in_ruleTest1918);
            	    lv_parameters_2_0=ruleParameter();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"parameters",
            	            		lv_parameters_2_0, 
            	            		"Parameter");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:851:3: ( (lv_results_3_0= ruleNamedTestResult ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID||LA16_0==31) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:852:1: (lv_results_3_0= ruleNamedTestResult )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:852:1: (lv_results_3_0= ruleNamedTestResult )
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:853:3: lv_results_3_0= ruleNamedTestResult
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTestAccess().getResultsNamedTestResultParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleNamedTestResult_in_ruleTest1940);
            	    lv_results_3_0=ruleNamedTestResult();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"results",
            	            		lv_results_3_0, 
            	            		"NamedTestResult");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:869:3: (otherlv_4= '=' ( (lv_result_5_0= ruleValueOrEnumValue ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==28) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:869:5: otherlv_4= '=' ( (lv_result_5_0= ruleValueOrEnumValue ) )
                    {
                    otherlv_4=(Token)match(input,28,FOLLOW_28_in_ruleTest1954); 

                        	newLeafNode(otherlv_4, grammarAccess.getTestAccess().getEqualsSignKeyword_4_0());
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:873:1: ( (lv_result_5_0= ruleValueOrEnumValue ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:874:1: (lv_result_5_0= ruleValueOrEnumValue )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:874:1: (lv_result_5_0= ruleValueOrEnumValue )
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:875:3: lv_result_5_0= ruleValueOrEnumValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getTestAccess().getResultValueOrEnumValueParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueOrEnumValue_in_ruleTest1975);
                    lv_result_5_0=ruleValueOrEnumValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTestRule());
                    	        }
                           		set(
                           			current, 
                           			"result",
                            		lv_result_5_0, 
                            		"ValueOrEnumValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTest"


    // $ANTLR start "entryRuleTableTest"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:899:1: entryRuleTableTest returns [EObject current=null] : iv_ruleTableTest= ruleTableTest EOF ;
    public final EObject entryRuleTableTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTableTest = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:900:2: (iv_ruleTableTest= ruleTableTest EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:901:2: iv_ruleTableTest= ruleTableTest EOF
            {
             newCompositeNode(grammarAccess.getTableTestRule()); 
            pushFollow(FOLLOW_ruleTableTest_in_entryRuleTableTest2013);
            iv_ruleTableTest=ruleTableTest();

            state._fsp--;

             current =iv_ruleTableTest; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTableTest2023); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTableTest"


    // $ANTLR start "ruleTableTest"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:908:1: ruleTableTest returns [EObject current=null] : (otherlv_0= 'tabletest' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_headers_3_0= ruleParameterTableHeader ) )+ ( (otherlv_4= '|' otherlv_5= '=' otherlv_6= '|' ) | otherlv_7= '|' ) ( (lv_rows_8_0= ruleTableTestRow ) )+ ) ;
    public final EObject ruleTableTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_parameters_2_0 = null;

        EObject lv_headers_3_0 = null;

        EObject lv_rows_8_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:911:28: ( (otherlv_0= 'tabletest' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_headers_3_0= ruleParameterTableHeader ) )+ ( (otherlv_4= '|' otherlv_5= '=' otherlv_6= '|' ) | otherlv_7= '|' ) ( (lv_rows_8_0= ruleTableTestRow ) )+ ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:912:1: (otherlv_0= 'tabletest' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_headers_3_0= ruleParameterTableHeader ) )+ ( (otherlv_4= '|' otherlv_5= '=' otherlv_6= '|' ) | otherlv_7= '|' ) ( (lv_rows_8_0= ruleTableTestRow ) )+ )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:912:1: (otherlv_0= 'tabletest' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_headers_3_0= ruleParameterTableHeader ) )+ ( (otherlv_4= '|' otherlv_5= '=' otherlv_6= '|' ) | otherlv_7= '|' ) ( (lv_rows_8_0= ruleTableTestRow ) )+ )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:912:3: otherlv_0= 'tabletest' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_headers_3_0= ruleParameterTableHeader ) )+ ( (otherlv_4= '|' otherlv_5= '=' otherlv_6= '|' ) | otherlv_7= '|' ) ( (lv_rows_8_0= ruleTableTestRow ) )+
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleTableTest2060); 

                	newLeafNode(otherlv_0, grammarAccess.getTableTestAccess().getTabletestKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:916:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:917:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:917:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:918:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTableTestRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTableTestAccess().getDefinitionTestDefinitionCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleTableTest2083);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:931:2: ( (lv_parameters_2_0= ruleParameter ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID||LA18_0==31) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:932:1: (lv_parameters_2_0= ruleParameter )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:932:1: (lv_parameters_2_0= ruleParameter )
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:933:3: lv_parameters_2_0= ruleParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getParametersParameterParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameter_in_ruleTableTest2104);
            	    lv_parameters_2_0=ruleParameter();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTableTestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"parameters",
            	            		lv_parameters_2_0, 
            	            		"Parameter");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:949:3: ( (lv_headers_3_0= ruleParameterTableHeader ) )+
            int cnt19=0;
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==30) ) {
                    int LA19_1 = input.LA(2);

                    if ( (LA19_1==RULE_ID||LA19_1==31) ) {
                        alt19=1;
                    }


                }


                switch (alt19) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:950:1: (lv_headers_3_0= ruleParameterTableHeader )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:950:1: (lv_headers_3_0= ruleParameterTableHeader )
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:951:3: lv_headers_3_0= ruleParameterTableHeader
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getHeadersParameterTableHeaderParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameterTableHeader_in_ruleTableTest2126);
            	    lv_headers_3_0=ruleParameterTableHeader();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTableTestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"headers",
            	            		lv_headers_3_0, 
            	            		"ParameterTableHeader");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt19 >= 1 ) break loop19;
                        EarlyExitException eee =
                            new EarlyExitException(19, input);
                        throw eee;
                }
                cnt19++;
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:967:3: ( (otherlv_4= '|' otherlv_5= '=' otherlv_6= '|' ) | otherlv_7= '|' )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==30) ) {
                int LA20_1 = input.LA(2);

                if ( (LA20_1==28) ) {
                    alt20=1;
                }
                else if ( (LA20_1==30) ) {
                    alt20=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 20, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:967:4: (otherlv_4= '|' otherlv_5= '=' otherlv_6= '|' )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:967:4: (otherlv_4= '|' otherlv_5= '=' otherlv_6= '|' )
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:967:6: otherlv_4= '|' otherlv_5= '=' otherlv_6= '|'
                    {
                    otherlv_4=(Token)match(input,30,FOLLOW_30_in_ruleTableTest2141); 

                        	newLeafNode(otherlv_4, grammarAccess.getTableTestAccess().getVerticalLineKeyword_4_0_0());
                        
                    otherlv_5=(Token)match(input,28,FOLLOW_28_in_ruleTableTest2153); 

                        	newLeafNode(otherlv_5, grammarAccess.getTableTestAccess().getEqualsSignKeyword_4_0_1());
                        
                    otherlv_6=(Token)match(input,30,FOLLOW_30_in_ruleTableTest2165); 

                        	newLeafNode(otherlv_6, grammarAccess.getTableTestAccess().getVerticalLineKeyword_4_0_2());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:980:7: otherlv_7= '|'
                    {
                    otherlv_7=(Token)match(input,30,FOLLOW_30_in_ruleTableTest2184); 

                        	newLeafNode(otherlv_7, grammarAccess.getTableTestAccess().getVerticalLineKeyword_4_1());
                        

                    }
                    break;

            }

            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:984:2: ( (lv_rows_8_0= ruleTableTestRow ) )+
            int cnt21=0;
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==30) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:985:1: (lv_rows_8_0= ruleTableTestRow )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:985:1: (lv_rows_8_0= ruleTableTestRow )
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:986:3: lv_rows_8_0= ruleTableTestRow
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getRowsTableTestRowParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTableTestRow_in_ruleTableTest2206);
            	    lv_rows_8_0=ruleTableTestRow();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTableTestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"rows",
            	            		lv_rows_8_0, 
            	            		"TableTestRow");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTableTest"


    // $ANTLR start "entryRuleTableTestRow"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1010:1: entryRuleTableTestRow returns [EObject current=null] : iv_ruleTableTestRow= ruleTableTestRow EOF ;
    public final EObject entryRuleTableTestRow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTableTestRow = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1011:2: (iv_ruleTableTestRow= ruleTableTestRow EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1012:2: iv_ruleTableTestRow= ruleTableTestRow EOF
            {
             newCompositeNode(grammarAccess.getTableTestRowRule()); 
            pushFollow(FOLLOW_ruleTableTestRow_in_entryRuleTableTestRow2243);
            iv_ruleTableTestRow=ruleTableTestRow();

            state._fsp--;

             current =iv_ruleTableTestRow; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTableTestRow2253); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTableTestRow"


    // $ANTLR start "ruleTableTestRow"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1019:1: ruleTableTestRow returns [EObject current=null] : ( () ( (lv_values_1_0= ruleParameterTableValue ) )* ( (otherlv_2= '|' otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) otherlv_5= '|' ) | otherlv_6= '|' ) ) ;
    public final EObject ruleTableTestRow() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_values_1_0 = null;

        EObject lv_result_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1022:28: ( ( () ( (lv_values_1_0= ruleParameterTableValue ) )* ( (otherlv_2= '|' otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) otherlv_5= '|' ) | otherlv_6= '|' ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1023:1: ( () ( (lv_values_1_0= ruleParameterTableValue ) )* ( (otherlv_2= '|' otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) otherlv_5= '|' ) | otherlv_6= '|' ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1023:1: ( () ( (lv_values_1_0= ruleParameterTableValue ) )* ( (otherlv_2= '|' otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) otherlv_5= '|' ) | otherlv_6= '|' ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1023:2: () ( (lv_values_1_0= ruleParameterTableValue ) )* ( (otherlv_2= '|' otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) otherlv_5= '|' ) | otherlv_6= '|' )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1023:2: ()
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1024:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTableTestRowAccess().getTableTestRowAction_0(),
                        current);
                

            }

            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1029:2: ( (lv_values_1_0= ruleParameterTableValue ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==30) ) {
                    int LA22_1 = input.LA(2);

                    if ( ((LA22_1>=RULE_ID && LA22_1<=RULE_UPPERCASE_ID)) ) {
                        alt22=1;
                    }


                }


                switch (alt22) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1030:1: (lv_values_1_0= ruleParameterTableValue )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1030:1: (lv_values_1_0= ruleParameterTableValue )
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1031:3: lv_values_1_0= ruleParameterTableValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestRowAccess().getValuesParameterTableValueParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameterTableValue_in_ruleTableTestRow2308);
            	    lv_values_1_0=ruleParameterTableValue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTableTestRowRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"values",
            	            		lv_values_1_0, 
            	            		"ParameterTableValue");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1047:3: ( (otherlv_2= '|' otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) otherlv_5= '|' ) | otherlv_6= '|' )
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==30) ) {
                int LA23_1 = input.LA(2);

                if ( (LA23_1==28) ) {
                    alt23=1;
                }
                else if ( (LA23_1==EOF||LA23_1==23||LA23_1==25||LA23_1==27||(LA23_1>=29 && LA23_1<=30)||LA23_1==32||LA23_1==34) ) {
                    alt23=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 23, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }
            switch (alt23) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1047:4: (otherlv_2= '|' otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) otherlv_5= '|' )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1047:4: (otherlv_2= '|' otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) otherlv_5= '|' )
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1047:6: otherlv_2= '|' otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) otherlv_5= '|'
                    {
                    otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleTableTestRow2323); 

                        	newLeafNode(otherlv_2, grammarAccess.getTableTestRowAccess().getVerticalLineKeyword_2_0_0());
                        
                    otherlv_3=(Token)match(input,28,FOLLOW_28_in_ruleTableTestRow2335); 

                        	newLeafNode(otherlv_3, grammarAccess.getTableTestRowAccess().getEqualsSignKeyword_2_0_1());
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1055:1: ( (lv_result_4_0= ruleValueOrEnumValue ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1056:1: (lv_result_4_0= ruleValueOrEnumValue )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1056:1: (lv_result_4_0= ruleValueOrEnumValue )
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1057:3: lv_result_4_0= ruleValueOrEnumValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getTableTestRowAccess().getResultValueOrEnumValueParserRuleCall_2_0_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueOrEnumValue_in_ruleTableTestRow2356);
                    lv_result_4_0=ruleValueOrEnumValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTableTestRowRule());
                    	        }
                           		set(
                           			current, 
                           			"result",
                            		lv_result_4_0, 
                            		"ValueOrEnumValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_5=(Token)match(input,30,FOLLOW_30_in_ruleTableTestRow2368); 

                        	newLeafNode(otherlv_5, grammarAccess.getTableTestRowAccess().getVerticalLineKeyword_2_0_3());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1078:7: otherlv_6= '|'
                    {
                    otherlv_6=(Token)match(input,30,FOLLOW_30_in_ruleTableTestRow2387); 

                        	newLeafNode(otherlv_6, grammarAccess.getTableTestRowAccess().getVerticalLineKeyword_2_1());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTableTestRow"


    // $ANTLR start "entryRuleParameterTableHeader"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1090:1: entryRuleParameterTableHeader returns [EObject current=null] : iv_ruleParameterTableHeader= ruleParameterTableHeader EOF ;
    public final EObject entryRuleParameterTableHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterTableHeader = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1091:2: (iv_ruleParameterTableHeader= ruleParameterTableHeader EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1092:2: iv_ruleParameterTableHeader= ruleParameterTableHeader EOF
            {
             newCompositeNode(grammarAccess.getParameterTableHeaderRule()); 
            pushFollow(FOLLOW_ruleParameterTableHeader_in_entryRuleParameterTableHeader2424);
            iv_ruleParameterTableHeader=ruleParameterTableHeader();

            state._fsp--;

             current =iv_ruleParameterTableHeader; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterTableHeader2434); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterTableHeader"


    // $ANTLR start "ruleParameterTableHeader"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1099:1: ruleParameterTableHeader returns [EObject current=null] : (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) ) ;
    public final EObject ruleParameterTableHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1102:28: ( (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1103:1: (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1103:1: (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1103:3: otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleParameterTableHeader2471); 

                	newLeafNode(otherlv_0, grammarAccess.getParameterTableHeaderAccess().getVerticalLineKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1107:1: ( (lv_name_1_0= ruleParameterName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1108:1: (lv_name_1_0= ruleParameterName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1108:1: (lv_name_1_0= ruleParameterName )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1109:3: lv_name_1_0= ruleParameterName
            {
             
            	        newCompositeNode(grammarAccess.getParameterTableHeaderAccess().getNameParameterNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleParameterName_in_ruleParameterTableHeader2492);
            lv_name_1_0=ruleParameterName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getParameterTableHeaderRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ParameterName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterTableHeader"


    // $ANTLR start "entryRuleParameterTableValue"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1133:1: entryRuleParameterTableValue returns [EObject current=null] : iv_ruleParameterTableValue= ruleParameterTableValue EOF ;
    public final EObject entryRuleParameterTableValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterTableValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1134:2: (iv_ruleParameterTableValue= ruleParameterTableValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1135:2: iv_ruleParameterTableValue= ruleParameterTableValue EOF
            {
             newCompositeNode(grammarAccess.getParameterTableValueRule()); 
            pushFollow(FOLLOW_ruleParameterTableValue_in_entryRuleParameterTableValue2528);
            iv_ruleParameterTableValue=ruleParameterTableValue();

            state._fsp--;

             current =iv_ruleParameterTableValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterTableValue2538); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterTableValue"


    // $ANTLR start "ruleParameterTableValue"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1142:1: ruleParameterTableValue returns [EObject current=null] : (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValue ) ) ) ;
    public final EObject ruleParameterTableValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1145:28: ( (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValue ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1146:1: (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValue ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1146:1: (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValue ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1146:3: otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValue ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleParameterTableValue2575); 

                	newLeafNode(otherlv_0, grammarAccess.getParameterTableValueAccess().getVerticalLineKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1150:1: ( (lv_value_1_0= ruleValueOrEnumValue ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1151:1: (lv_value_1_0= ruleValueOrEnumValue )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1151:1: (lv_value_1_0= ruleValueOrEnumValue )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1152:3: lv_value_1_0= ruleValueOrEnumValue
            {
             
            	        newCompositeNode(grammarAccess.getParameterTableValueAccess().getValueValueOrEnumValueParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_ruleParameterTableValue2596);
            lv_value_1_0=ruleValueOrEnumValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getParameterTableValueRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"ValueOrEnumValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterTableValue"


    // $ANTLR start "entryRuleNamedTestResult"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1176:1: entryRuleNamedTestResult returns [EObject current=null] : iv_ruleNamedTestResult= ruleNamedTestResult EOF ;
    public final EObject entryRuleNamedTestResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedTestResult = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1177:2: (iv_ruleNamedTestResult= ruleNamedTestResult EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1178:2: iv_ruleNamedTestResult= ruleNamedTestResult EOF
            {
             newCompositeNode(grammarAccess.getNamedTestResultRule()); 
            pushFollow(FOLLOW_ruleNamedTestResult_in_entryRuleNamedTestResult2632);
            iv_ruleNamedTestResult=ruleNamedTestResult();

            state._fsp--;

             current =iv_ruleNamedTestResult; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedTestResult2642); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNamedTestResult"


    // $ANTLR start "ruleNamedTestResult"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1185:1: ruleNamedTestResult returns [EObject current=null] : ( ( (lv_name_0_0= ruleTestResultName ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValueOrEnumValue ) ) ) ;
    public final EObject ruleNamedTestResult() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1188:28: ( ( ( (lv_name_0_0= ruleTestResultName ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValueOrEnumValue ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1189:1: ( ( (lv_name_0_0= ruleTestResultName ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValueOrEnumValue ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1189:1: ( ( (lv_name_0_0= ruleTestResultName ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValueOrEnumValue ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1189:2: ( (lv_name_0_0= ruleTestResultName ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValueOrEnumValue ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1189:2: ( (lv_name_0_0= ruleTestResultName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1190:1: (lv_name_0_0= ruleTestResultName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1190:1: (lv_name_0_0= ruleTestResultName )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1191:3: lv_name_0_0= ruleTestResultName
            {
             
            	        newCompositeNode(grammarAccess.getNamedTestResultAccess().getNameTestResultNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleTestResultName_in_ruleNamedTestResult2688);
            lv_name_0_0=ruleTestResultName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNamedTestResultRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"TestResultName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleNamedTestResult2700); 

                	newLeafNode(otherlv_1, grammarAccess.getNamedTestResultAccess().getEqualsSignKeyword_1());
                
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1211:1: ( (lv_value_2_0= ruleValueOrEnumValue ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1212:1: (lv_value_2_0= ruleValueOrEnumValue )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1212:1: (lv_value_2_0= ruleValueOrEnumValue )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1213:3: lv_value_2_0= ruleValueOrEnumValue
            {
             
            	        newCompositeNode(grammarAccess.getNamedTestResultAccess().getValueValueOrEnumValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_ruleNamedTestResult2721);
            lv_value_2_0=ruleValueOrEnumValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNamedTestResultRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"ValueOrEnumValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNamedTestResult"


    // $ANTLR start "entryRuleTestResultName"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1237:1: entryRuleTestResultName returns [EObject current=null] : iv_ruleTestResultName= ruleTestResultName EOF ;
    public final EObject entryRuleTestResultName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestResultName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1238:2: (iv_ruleTestResultName= ruleTestResultName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1239:2: iv_ruleTestResultName= ruleTestResultName EOF
            {
             newCompositeNode(grammarAccess.getTestResultNameRule()); 
            pushFollow(FOLLOW_ruleTestResultName_in_entryRuleTestResultName2757);
            iv_ruleTestResultName=ruleTestResultName();

            state._fsp--;

             current =iv_ruleTestResultName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestResultName2767); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTestResultName"


    // $ANTLR start "ruleTestResultName"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1246:1: ruleTestResultName returns [EObject current=null] : (this_FixedTestResultName_0= ruleFixedTestResultName | this_ArbitraryTestResultName_1= ruleArbitraryTestResultName ) ;
    public final EObject ruleTestResultName() throws RecognitionException {
        EObject current = null;

        EObject this_FixedTestResultName_0 = null;

        EObject this_ArbitraryTestResultName_1 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1249:28: ( (this_FixedTestResultName_0= ruleFixedTestResultName | this_ArbitraryTestResultName_1= ruleArbitraryTestResultName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1250:1: (this_FixedTestResultName_0= ruleFixedTestResultName | this_ArbitraryTestResultName_1= ruleArbitraryTestResultName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1250:1: (this_FixedTestResultName_0= ruleFixedTestResultName | this_ArbitraryTestResultName_1= ruleArbitraryTestResultName )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID) ) {
                alt24=1;
            }
            else if ( (LA24_0==31) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1251:5: this_FixedTestResultName_0= ruleFixedTestResultName
                    {
                     
                            newCompositeNode(grammarAccess.getTestResultNameAccess().getFixedTestResultNameParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleFixedTestResultName_in_ruleTestResultName2814);
                    this_FixedTestResultName_0=ruleFixedTestResultName();

                    state._fsp--;

                     
                            current = this_FixedTestResultName_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1261:5: this_ArbitraryTestResultName_1= ruleArbitraryTestResultName
                    {
                     
                            newCompositeNode(grammarAccess.getTestResultNameAccess().getArbitraryTestResultNameParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleArbitraryTestResultName_in_ruleTestResultName2841);
                    this_ArbitraryTestResultName_1=ruleArbitraryTestResultName();

                    state._fsp--;

                     
                            current = this_ArbitraryTestResultName_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTestResultName"


    // $ANTLR start "entryRuleFixedTestResultName"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1277:1: entryRuleFixedTestResultName returns [EObject current=null] : iv_ruleFixedTestResultName= ruleFixedTestResultName EOF ;
    public final EObject entryRuleFixedTestResultName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedTestResultName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1278:2: (iv_ruleFixedTestResultName= ruleFixedTestResultName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1279:2: iv_ruleFixedTestResultName= ruleFixedTestResultName EOF
            {
             newCompositeNode(grammarAccess.getFixedTestResultNameRule()); 
            pushFollow(FOLLOW_ruleFixedTestResultName_in_entryRuleFixedTestResultName2876);
            iv_ruleFixedTestResultName=ruleFixedTestResultName();

            state._fsp--;

             current =iv_ruleFixedTestResultName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFixedTestResultName2886); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFixedTestResultName"


    // $ANTLR start "ruleFixedTestResultName"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1286:1: ruleFixedTestResultName returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleFixedTestResultName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1289:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1290:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1290:1: ( (otherlv_0= RULE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1291:1: (otherlv_0= RULE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1291:1: (otherlv_0= RULE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1292:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFixedTestResultNameRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFixedTestResultName2930); 

            		newLeafNode(otherlv_0, grammarAccess.getFixedTestResultNameAccess().getFieldJvmFieldCrossReference_0()); 
            	

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFixedTestResultName"


    // $ANTLR start "entryRuleArbitraryTestResultName"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1311:1: entryRuleArbitraryTestResultName returns [EObject current=null] : iv_ruleArbitraryTestResultName= ruleArbitraryTestResultName EOF ;
    public final EObject entryRuleArbitraryTestResultName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArbitraryTestResultName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1312:2: (iv_ruleArbitraryTestResultName= ruleArbitraryTestResultName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1313:2: iv_ruleArbitraryTestResultName= ruleArbitraryTestResultName EOF
            {
             newCompositeNode(grammarAccess.getArbitraryTestResultNameRule()); 
            pushFollow(FOLLOW_ruleArbitraryTestResultName_in_entryRuleArbitraryTestResultName2965);
            iv_ruleArbitraryTestResultName=ruleArbitraryTestResultName();

            state._fsp--;

             current =iv_ruleArbitraryTestResultName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArbitraryTestResultName2975); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArbitraryTestResultName"


    // $ANTLR start "ruleArbitraryTestResultName"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1320:1: ruleArbitraryTestResultName returns [EObject current=null] : (otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) ) ) ;
    public final EObject ruleArbitraryTestResultName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_identifier_1_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1323:28: ( (otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1324:1: (otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1324:1: (otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1324:3: otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleArbitraryTestResultName3012); 

                	newLeafNode(otherlv_0, grammarAccess.getArbitraryTestResultNameAccess().getPlusSignKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1328:1: ( (lv_identifier_1_0= RULE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1329:1: (lv_identifier_1_0= RULE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1329:1: (lv_identifier_1_0= RULE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1330:3: lv_identifier_1_0= RULE_ID
            {
            lv_identifier_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleArbitraryTestResultName3029); 

            			newLeafNode(lv_identifier_1_0, grammarAccess.getArbitraryTestResultNameAccess().getIdentifierIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getArbitraryTestResultNameRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"identifier",
                    		lv_identifier_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArbitraryTestResultName"


    // $ANTLR start "entryRuleCall"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1354:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1355:2: (iv_ruleCall= ruleCall EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1356:2: iv_ruleCall= ruleCall EOF
            {
             newCompositeNode(grammarAccess.getCallRule()); 
            pushFollow(FOLLOW_ruleCall_in_entryRuleCall3070);
            iv_ruleCall=ruleCall();

            state._fsp--;

             current =iv_ruleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCall3080); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCall"


    // $ANTLR start "ruleCall"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1363:1: ruleCall returns [EObject current=null] : (otherlv_0= 'call' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* (otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) ) )? ) ;
    public final EObject ruleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_parameters_2_0 = null;

        EObject lv_result_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1366:28: ( (otherlv_0= 'call' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* (otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) ) )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1367:1: (otherlv_0= 'call' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* (otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) ) )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1367:1: (otherlv_0= 'call' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* (otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) ) )? )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1367:3: otherlv_0= 'call' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* (otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) ) )?
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleCall3117); 

                	newLeafNode(otherlv_0, grammarAccess.getCallAccess().getCallKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1371:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1372:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1372:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1373:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCallRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getCallAccess().getDefinitionCallDefinitionCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleCall3140);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1386:2: ( (lv_parameters_2_0= ruleParameter ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_ID||LA25_0==31) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1387:1: (lv_parameters_2_0= ruleParameter )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1387:1: (lv_parameters_2_0= ruleParameter )
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1388:3: lv_parameters_2_0= ruleParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCallAccess().getParametersParameterParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameter_in_ruleCall3161);
            	    lv_parameters_2_0=ruleParameter();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCallRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"parameters",
            	            		lv_parameters_2_0, 
            	            		"Parameter");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1404:3: (otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==33) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1404:5: otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) )
                    {
                    otherlv_3=(Token)match(input,33,FOLLOW_33_in_ruleCall3175); 

                        	newLeafNode(otherlv_3, grammarAccess.getCallAccess().getSetsKeyword_3_0());
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1408:1: ( (lv_result_4_0= ruleVariable ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1409:1: (lv_result_4_0= ruleVariable )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1409:1: (lv_result_4_0= ruleVariable )
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1410:3: lv_result_4_0= ruleVariable
                    {
                     
                    	        newCompositeNode(grammarAccess.getCallAccess().getResultVariableParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVariable_in_ruleCall3196);
                    lv_result_4_0=ruleVariable();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCallRule());
                    	        }
                           		set(
                           			current, 
                           			"result",
                            		lv_result_4_0, 
                            		"Variable");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCall"


    // $ANTLR start "entryRuleSuite"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1434:1: entryRuleSuite returns [EObject current=null] : iv_ruleSuite= ruleSuite EOF ;
    public final EObject entryRuleSuite() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuite = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1435:2: (iv_ruleSuite= ruleSuite EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1436:2: iv_ruleSuite= ruleSuite EOF
            {
             newCompositeNode(grammarAccess.getSuiteRule()); 
            pushFollow(FOLLOW_ruleSuite_in_entryRuleSuite3234);
            iv_ruleSuite=ruleSuite();

            state._fsp--;

             current =iv_ruleSuite; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuite3244); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSuite"


    // $ANTLR start "ruleSuite"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1443:1: ruleSuite returns [EObject current=null] : (otherlv_0= 'suite' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleSuiteParameter ) )* ) ;
    public final EObject ruleSuite() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_parameters_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1446:28: ( (otherlv_0= 'suite' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleSuiteParameter ) )* ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1447:1: (otherlv_0= 'suite' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleSuiteParameter ) )* )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1447:1: (otherlv_0= 'suite' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleSuiteParameter ) )* )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1447:3: otherlv_0= 'suite' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleSuiteParameter ) )*
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_ruleSuite3281); 

                	newLeafNode(otherlv_0, grammarAccess.getSuiteAccess().getSuiteKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1451:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1452:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1452:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1453:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSuiteRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSuiteAccess().getDefinitionSuiteDefinitionCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuite3304);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1466:2: ( (lv_parameters_2_0= ruleSuiteParameter ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_ID) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1467:1: (lv_parameters_2_0= ruleSuiteParameter )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1467:1: (lv_parameters_2_0= ruleSuiteParameter )
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1468:3: lv_parameters_2_0= ruleSuiteParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSuiteAccess().getParametersSuiteParameterParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSuiteParameter_in_ruleSuite3325);
            	    lv_parameters_2_0=ruleSuiteParameter();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSuiteRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"parameters",
            	            		lv_parameters_2_0, 
            	            		"SuiteParameter");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSuite"


    // $ANTLR start "entryRuleSuiteParameter"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1492:1: entryRuleSuiteParameter returns [EObject current=null] : iv_ruleSuiteParameter= ruleSuiteParameter EOF ;
    public final EObject entryRuleSuiteParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteParameter = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1493:2: (iv_ruleSuiteParameter= ruleSuiteParameter EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1494:2: iv_ruleSuiteParameter= ruleSuiteParameter EOF
            {
             newCompositeNode(grammarAccess.getSuiteParameterRule()); 
            pushFollow(FOLLOW_ruleSuiteParameter_in_entryRuleSuiteParameter3362);
            iv_ruleSuiteParameter=ruleSuiteParameter();

            state._fsp--;

             current =iv_ruleSuiteParameter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteParameter3372); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSuiteParameter"


    // $ANTLR start "ruleSuiteParameter"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1501:1: ruleSuiteParameter returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValue ) ) ) ;
    public final EObject ruleSuiteParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1504:28: ( ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValue ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1505:1: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValue ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1505:1: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValue ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1505:2: ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValue ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1505:2: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1506:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1506:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1507:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSuiteParameterRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSuiteParameterAccess().getNameVariableEntityCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuiteParameter3420);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,35,FOLLOW_35_in_ruleSuiteParameter3432); 

                	newLeafNode(otherlv_1, grammarAccess.getSuiteParameterAccess().getColonKeyword_1());
                
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1524:1: ( (lv_value_2_0= ruleValue ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1525:1: (lv_value_2_0= ruleValue )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1525:1: (lv_value_2_0= ruleValue )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1526:3: lv_value_2_0= ruleValue
            {
             
            	        newCompositeNode(grammarAccess.getSuiteParameterAccess().getValueValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleValue_in_ruleSuiteParameter3453);
            lv_value_2_0=ruleValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSuiteParameterRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"Value");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSuiteParameter"


    // $ANTLR start "entryRuleParameter"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1550:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1551:2: (iv_ruleParameter= ruleParameter EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1552:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter3489);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter3499); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1559:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= ruleParameterName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValueOrEnumValue ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1562:28: ( ( ( (lv_name_0_0= ruleParameterName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValueOrEnumValue ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1563:1: ( ( (lv_name_0_0= ruleParameterName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValueOrEnumValue ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1563:1: ( ( (lv_name_0_0= ruleParameterName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValueOrEnumValue ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1563:2: ( (lv_name_0_0= ruleParameterName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValueOrEnumValue ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1563:2: ( (lv_name_0_0= ruleParameterName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1564:1: (lv_name_0_0= ruleParameterName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1564:1: (lv_name_0_0= ruleParameterName )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1565:3: lv_name_0_0= ruleParameterName
            {
             
            	        newCompositeNode(grammarAccess.getParameterAccess().getNameParameterNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleParameterName_in_ruleParameter3545);
            lv_name_0_0=ruleParameterName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getParameterRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ParameterName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,35,FOLLOW_35_in_ruleParameter3557); 

                	newLeafNode(otherlv_1, grammarAccess.getParameterAccess().getColonKeyword_1());
                
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1585:1: ( (lv_value_2_0= ruleValueOrEnumValue ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1586:1: (lv_value_2_0= ruleValueOrEnumValue )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1586:1: (lv_value_2_0= ruleValueOrEnumValue )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1587:3: lv_value_2_0= ruleValueOrEnumValue
            {
             
            	        newCompositeNode(grammarAccess.getParameterAccess().getValueValueOrEnumValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_ruleParameter3578);
            lv_value_2_0=ruleValueOrEnumValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getParameterRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"ValueOrEnumValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleParameterName"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1611:1: entryRuleParameterName returns [EObject current=null] : iv_ruleParameterName= ruleParameterName EOF ;
    public final EObject entryRuleParameterName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1612:2: (iv_ruleParameterName= ruleParameterName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1613:2: iv_ruleParameterName= ruleParameterName EOF
            {
             newCompositeNode(grammarAccess.getParameterNameRule()); 
            pushFollow(FOLLOW_ruleParameterName_in_entryRuleParameterName3614);
            iv_ruleParameterName=ruleParameterName();

            state._fsp--;

             current =iv_ruleParameterName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterName3624); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameterName"


    // $ANTLR start "ruleParameterName"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1620:1: ruleParameterName returns [EObject current=null] : (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterName_1= ruleArbitraryParameterName ) ;
    public final EObject ruleParameterName() throws RecognitionException {
        EObject current = null;

        EObject this_FixedParameterName_0 = null;

        EObject this_ArbitraryParameterName_1 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1623:28: ( (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterName_1= ruleArbitraryParameterName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1624:1: (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterName_1= ruleArbitraryParameterName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1624:1: (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterName_1= ruleArbitraryParameterName )
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==RULE_ID) ) {
                alt28=1;
            }
            else if ( (LA28_0==31) ) {
                alt28=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 28, 0, input);

                throw nvae;
            }
            switch (alt28) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1625:5: this_FixedParameterName_0= ruleFixedParameterName
                    {
                     
                            newCompositeNode(grammarAccess.getParameterNameAccess().getFixedParameterNameParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleFixedParameterName_in_ruleParameterName3671);
                    this_FixedParameterName_0=ruleFixedParameterName();

                    state._fsp--;

                     
                            current = this_FixedParameterName_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1635:5: this_ArbitraryParameterName_1= ruleArbitraryParameterName
                    {
                     
                            newCompositeNode(grammarAccess.getParameterNameAccess().getArbitraryParameterNameParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleArbitraryParameterName_in_ruleParameterName3698);
                    this_ArbitraryParameterName_1=ruleArbitraryParameterName();

                    state._fsp--;

                     
                            current = this_ArbitraryParameterName_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameterName"


    // $ANTLR start "entryRuleFixedParameterName"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1651:1: entryRuleFixedParameterName returns [EObject current=null] : iv_ruleFixedParameterName= ruleFixedParameterName EOF ;
    public final EObject entryRuleFixedParameterName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedParameterName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1652:2: (iv_ruleFixedParameterName= ruleFixedParameterName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1653:2: iv_ruleFixedParameterName= ruleFixedParameterName EOF
            {
             newCompositeNode(grammarAccess.getFixedParameterNameRule()); 
            pushFollow(FOLLOW_ruleFixedParameterName_in_entryRuleFixedParameterName3733);
            iv_ruleFixedParameterName=ruleFixedParameterName();

            state._fsp--;

             current =iv_ruleFixedParameterName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFixedParameterName3743); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFixedParameterName"


    // $ANTLR start "ruleFixedParameterName"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1660:1: ruleFixedParameterName returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleFixedParameterName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1663:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1664:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1664:1: ( (otherlv_0= RULE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1665:1: (otherlv_0= RULE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1665:1: (otherlv_0= RULE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1666:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFixedParameterNameRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFixedParameterName3787); 

            		newLeafNode(otherlv_0, grammarAccess.getFixedParameterNameAccess().getAnnotationJvmAnnotationReferenceCrossReference_0()); 
            	

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFixedParameterName"


    // $ANTLR start "entryRuleArbitraryParameterName"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1685:1: entryRuleArbitraryParameterName returns [EObject current=null] : iv_ruleArbitraryParameterName= ruleArbitraryParameterName EOF ;
    public final EObject entryRuleArbitraryParameterName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArbitraryParameterName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1686:2: (iv_ruleArbitraryParameterName= ruleArbitraryParameterName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1687:2: iv_ruleArbitraryParameterName= ruleArbitraryParameterName EOF
            {
             newCompositeNode(grammarAccess.getArbitraryParameterNameRule()); 
            pushFollow(FOLLOW_ruleArbitraryParameterName_in_entryRuleArbitraryParameterName3822);
            iv_ruleArbitraryParameterName=ruleArbitraryParameterName();

            state._fsp--;

             current =iv_ruleArbitraryParameterName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArbitraryParameterName3832); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArbitraryParameterName"


    // $ANTLR start "ruleArbitraryParameterName"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1694:1: ruleArbitraryParameterName returns [EObject current=null] : (otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) ) ) ;
    public final EObject ruleArbitraryParameterName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_identifier_1_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1697:28: ( (otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1698:1: (otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1698:1: (otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1698:3: otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleArbitraryParameterName3869); 

                	newLeafNode(otherlv_0, grammarAccess.getArbitraryParameterNameAccess().getPlusSignKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1702:1: ( (lv_identifier_1_0= RULE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1703:1: (lv_identifier_1_0= RULE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1703:1: (lv_identifier_1_0= RULE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1704:3: lv_identifier_1_0= RULE_ID
            {
            lv_identifier_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleArbitraryParameterName3886); 

            			newLeafNode(lv_identifier_1_0, grammarAccess.getArbitraryParameterNameAccess().getIdentifierIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getArbitraryParameterNameRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"identifier",
                    		lv_identifier_1_0, 
                    		"ID");
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArbitraryParameterName"


    // $ANTLR start "entryRuleValueOrEnumValue"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1728:1: entryRuleValueOrEnumValue returns [EObject current=null] : iv_ruleValueOrEnumValue= ruleValueOrEnumValue EOF ;
    public final EObject entryRuleValueOrEnumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueOrEnumValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1729:2: (iv_ruleValueOrEnumValue= ruleValueOrEnumValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1730:2: iv_ruleValueOrEnumValue= ruleValueOrEnumValue EOF
            {
             newCompositeNode(grammarAccess.getValueOrEnumValueRule()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_entryRuleValueOrEnumValue3927);
            iv_ruleValueOrEnumValue=ruleValueOrEnumValue();

            state._fsp--;

             current =iv_ruleValueOrEnumValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueOrEnumValue3937); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValueOrEnumValue"


    // $ANTLR start "ruleValueOrEnumValue"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1737:1: ruleValueOrEnumValue returns [EObject current=null] : (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue ) ;
    public final EObject ruleValueOrEnumValue() throws RecognitionException {
        EObject current = null;

        EObject this_Value_0 = null;

        EObject this_EnumValue_1 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1740:28: ( (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1741:1: (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1741:1: (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=RULE_ID && LA29_0<=RULE_STRING)) ) {
                alt29=1;
            }
            else if ( (LA29_0==RULE_UPPERCASE_ID) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1742:5: this_Value_0= ruleValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueOrEnumValueAccess().getValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleValue_in_ruleValueOrEnumValue3984);
                    this_Value_0=ruleValue();

                    state._fsp--;

                     
                            current = this_Value_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1752:5: this_EnumValue_1= ruleEnumValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueOrEnumValueAccess().getEnumValueParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEnumValue_in_ruleValueOrEnumValue4011);
                    this_EnumValue_1=ruleEnumValue();

                    state._fsp--;

                     
                            current = this_EnumValue_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValueOrEnumValue"


    // $ANTLR start "entryRuleValue"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1768:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1769:2: (iv_ruleValue= ruleValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1770:2: iv_ruleValue= ruleValue EOF
            {
             newCompositeNode(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue4046);
            iv_ruleValue=ruleValue();

            state._fsp--;

             current =iv_ruleValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue4056); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1777:1: ruleValue returns [EObject current=null] : (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_Variable_3= ruleVariable ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        EObject this_StringValue_0 = null;

        EObject this_IntegerValue_1 = null;

        EObject this_DecimalValue_2 = null;

        EObject this_Variable_3 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1780:28: ( (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_Variable_3= ruleVariable ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1781:1: (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_Variable_3= ruleVariable )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1781:1: (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_Variable_3= ruleVariable )
            int alt30=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt30=1;
                }
                break;
            case RULE_INTEGER:
                {
                alt30=2;
                }
                break;
            case RULE_DECIMAL:
                {
                alt30=3;
                }
                break;
            case RULE_ID:
                {
                alt30=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1782:5: this_StringValue_0= ruleStringValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getStringValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleStringValue_in_ruleValue4103);
                    this_StringValue_0=ruleStringValue();

                    state._fsp--;

                     
                            current = this_StringValue_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1792:5: this_IntegerValue_1= ruleIntegerValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getIntegerValueParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleIntegerValue_in_ruleValue4130);
                    this_IntegerValue_1=ruleIntegerValue();

                    state._fsp--;

                     
                            current = this_IntegerValue_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1802:5: this_DecimalValue_2= ruleDecimalValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getDecimalValueParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleDecimalValue_in_ruleValue4157);
                    this_DecimalValue_2=ruleDecimalValue();

                    state._fsp--;

                     
                            current = this_DecimalValue_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1812:5: this_Variable_3= ruleVariable
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getVariableParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleVariable_in_ruleValue4184);
                    this_Variable_3=ruleVariable();

                    state._fsp--;

                     
                            current = this_Variable_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleIntegerValue"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1828:1: entryRuleIntegerValue returns [EObject current=null] : iv_ruleIntegerValue= ruleIntegerValue EOF ;
    public final EObject entryRuleIntegerValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1829:2: (iv_ruleIntegerValue= ruleIntegerValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1830:2: iv_ruleIntegerValue= ruleIntegerValue EOF
            {
             newCompositeNode(grammarAccess.getIntegerValueRule()); 
            pushFollow(FOLLOW_ruleIntegerValue_in_entryRuleIntegerValue4219);
            iv_ruleIntegerValue=ruleIntegerValue();

            state._fsp--;

             current =iv_ruleIntegerValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerValue4229); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntegerValue"


    // $ANTLR start "ruleIntegerValue"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1837:1: ruleIntegerValue returns [EObject current=null] : ( (lv_integerValue_0_0= RULE_INTEGER ) ) ;
    public final EObject ruleIntegerValue() throws RecognitionException {
        EObject current = null;

        Token lv_integerValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1840:28: ( ( (lv_integerValue_0_0= RULE_INTEGER ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1841:1: ( (lv_integerValue_0_0= RULE_INTEGER ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1841:1: ( (lv_integerValue_0_0= RULE_INTEGER ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1842:1: (lv_integerValue_0_0= RULE_INTEGER )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1842:1: (lv_integerValue_0_0= RULE_INTEGER )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1843:3: lv_integerValue_0_0= RULE_INTEGER
            {
            lv_integerValue_0_0=(Token)match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleIntegerValue4270); 

            			newLeafNode(lv_integerValue_0_0, grammarAccess.getIntegerValueAccess().getIntegerValueINTEGERTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIntegerValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"integerValue",
                    		lv_integerValue_0_0, 
                    		"INTEGER");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntegerValue"


    // $ANTLR start "entryRuleDecimalValue"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1867:1: entryRuleDecimalValue returns [EObject current=null] : iv_ruleDecimalValue= ruleDecimalValue EOF ;
    public final EObject entryRuleDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecimalValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1868:2: (iv_ruleDecimalValue= ruleDecimalValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1869:2: iv_ruleDecimalValue= ruleDecimalValue EOF
            {
             newCompositeNode(grammarAccess.getDecimalValueRule()); 
            pushFollow(FOLLOW_ruleDecimalValue_in_entryRuleDecimalValue4310);
            iv_ruleDecimalValue=ruleDecimalValue();

            state._fsp--;

             current =iv_ruleDecimalValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalValue4320); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDecimalValue"


    // $ANTLR start "ruleDecimalValue"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1876:1: ruleDecimalValue returns [EObject current=null] : ( (lv_decimalValue_0_0= RULE_DECIMAL ) ) ;
    public final EObject ruleDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_decimalValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1879:28: ( ( (lv_decimalValue_0_0= RULE_DECIMAL ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1880:1: ( (lv_decimalValue_0_0= RULE_DECIMAL ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1880:1: ( (lv_decimalValue_0_0= RULE_DECIMAL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1881:1: (lv_decimalValue_0_0= RULE_DECIMAL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1881:1: (lv_decimalValue_0_0= RULE_DECIMAL )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1882:3: lv_decimalValue_0_0= RULE_DECIMAL
            {
            lv_decimalValue_0_0=(Token)match(input,RULE_DECIMAL,FOLLOW_RULE_DECIMAL_in_ruleDecimalValue4361); 

            			newLeafNode(lv_decimalValue_0_0, grammarAccess.getDecimalValueAccess().getDecimalValueDECIMALTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDecimalValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"decimalValue",
                    		lv_decimalValue_0_0, 
                    		"DECIMAL");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDecimalValue"


    // $ANTLR start "entryRuleStringValue"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1906:1: entryRuleStringValue returns [EObject current=null] : iv_ruleStringValue= ruleStringValue EOF ;
    public final EObject entryRuleStringValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1907:2: (iv_ruleStringValue= ruleStringValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1908:2: iv_ruleStringValue= ruleStringValue EOF
            {
             newCompositeNode(grammarAccess.getStringValueRule()); 
            pushFollow(FOLLOW_ruleStringValue_in_entryRuleStringValue4401);
            iv_ruleStringValue=ruleStringValue();

            state._fsp--;

             current =iv_ruleStringValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringValue4411); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringValue"


    // $ANTLR start "ruleStringValue"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1915:1: ruleStringValue returns [EObject current=null] : ( (lv_stringValue_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringValue() throws RecognitionException {
        EObject current = null;

        Token lv_stringValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1918:28: ( ( (lv_stringValue_0_0= RULE_STRING ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1919:1: ( (lv_stringValue_0_0= RULE_STRING ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1919:1: ( (lv_stringValue_0_0= RULE_STRING ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1920:1: (lv_stringValue_0_0= RULE_STRING )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1920:1: (lv_stringValue_0_0= RULE_STRING )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1921:3: lv_stringValue_0_0= RULE_STRING
            {
            lv_stringValue_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringValue4452); 

            			newLeafNode(lv_stringValue_0_0, grammarAccess.getStringValueAccess().getStringValueSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStringValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"stringValue",
                    		lv_stringValue_0_0, 
                    		"STRING");
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringValue"


    // $ANTLR start "entryRuleVariable"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1945:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1946:2: (iv_ruleVariable= ruleVariable EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1947:2: iv_ruleVariable= ruleVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable4492);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable4502); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1954:1: ruleVariable returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1957:28: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1958:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1958:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1959:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1959:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1960:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getVariableRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getVariableAccess().getNameVariableEntityCrossReference_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleVariable4549);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleEnumValue"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1981:1: entryRuleEnumValue returns [EObject current=null] : iv_ruleEnumValue= ruleEnumValue EOF ;
    public final EObject entryRuleEnumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1982:2: (iv_ruleEnumValue= ruleEnumValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1983:2: iv_ruleEnumValue= ruleEnumValue EOF
            {
             newCompositeNode(grammarAccess.getEnumValueRule()); 
            pushFollow(FOLLOW_ruleEnumValue_in_entryRuleEnumValue4584);
            iv_ruleEnumValue=ruleEnumValue();

            state._fsp--;

             current =iv_ruleEnumValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumValue4594); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumValue"


    // $ANTLR start "ruleEnumValue"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1990:1: ruleEnumValue returns [EObject current=null] : ( (otherlv_0= RULE_UPPERCASE_ID ) ) ;
    public final EObject ruleEnumValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1993:28: ( ( (otherlv_0= RULE_UPPERCASE_ID ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1994:1: ( (otherlv_0= RULE_UPPERCASE_ID ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1994:1: ( (otherlv_0= RULE_UPPERCASE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1995:1: (otherlv_0= RULE_UPPERCASE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1995:1: (otherlv_0= RULE_UPPERCASE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1996:3: otherlv_0= RULE_UPPERCASE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumValueRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_UPPERCASE_ID,FOLLOW_RULE_UPPERCASE_ID_in_ruleEnumValue4638); 

            		newLeafNode(otherlv_0, grammarAccess.getEnumValueAccess().getEnumValueJvmEnumerationLiteralCrossReference_0()); 
            	

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumValue"


    // $ANTLR start "entryRuleMethodReference"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2015:1: entryRuleMethodReference returns [EObject current=null] : iv_ruleMethodReference= ruleMethodReference EOF ;
    public final EObject entryRuleMethodReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodReference = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2016:2: (iv_ruleMethodReference= ruleMethodReference EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2017:2: iv_ruleMethodReference= ruleMethodReference EOF
            {
             newCompositeNode(grammarAccess.getMethodReferenceRule()); 
            pushFollow(FOLLOW_ruleMethodReference_in_entryRuleMethodReference4673);
            iv_ruleMethodReference=ruleMethodReference();

            state._fsp--;

             current =iv_ruleMethodReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodReference4683); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMethodReference"


    // $ANTLR start "ruleMethodReference"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2024:1: ruleMethodReference returns [EObject current=null] : ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleMethodReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2027:28: ( ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2028:1: ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2028:1: ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2028:2: ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2028:2: ( ( ruleQualifiedJavaClassName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2029:1: ( ruleQualifiedJavaClassName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2029:1: ( ruleQualifiedJavaClassName )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2030:3: ruleQualifiedJavaClassName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMethodReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getMethodReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_ruleMethodReference4731);
            ruleQualifiedJavaClassName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,36,FOLLOW_36_in_ruleMethodReference4743); 

                	newLeafNode(otherlv_1, grammarAccess.getMethodReferenceAccess().getNumberSignKeyword_1());
                
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2047:1: ( (otherlv_2= RULE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2048:1: (otherlv_2= RULE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2048:1: (otherlv_2= RULE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2049:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMethodReferenceRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMethodReference4763); 

            		newLeafNode(otherlv_2, grammarAccess.getMethodReferenceAccess().getMethodJvmOperationCrossReference_2_0()); 
            	

            }


            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMethodReference"


    // $ANTLR start "entryRuleQualifiedName"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2068:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2069:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2070:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName4800);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName4811); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2077:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2080:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2081:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2081:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2081:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName4851); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2088:1: (kw= '.' this_ID_2= RULE_ID )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==37) ) {
                    int LA31_2 = input.LA(2);

                    if ( (LA31_2==RULE_ID) ) {
                        alt31=1;
                    }


                }


                switch (alt31) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2089:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,37,FOLLOW_37_in_ruleQualifiedName4870); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName4885); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleQualifiedJavaClassName"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2109:1: entryRuleQualifiedJavaClassName returns [String current=null] : iv_ruleQualifiedJavaClassName= ruleQualifiedJavaClassName EOF ;
    public final String entryRuleQualifiedJavaClassName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedJavaClassName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2110:2: (iv_ruleQualifiedJavaClassName= ruleQualifiedJavaClassName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2111:2: iv_ruleQualifiedJavaClassName= ruleQualifiedJavaClassName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedJavaClassNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_entryRuleQualifiedJavaClassName4933);
            iv_ruleQualifiedJavaClassName=ruleQualifiedJavaClassName();

            state._fsp--;

             current =iv_ruleQualifiedJavaClassName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedJavaClassName4944); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedJavaClassName"


    // $ANTLR start "ruleQualifiedJavaClassName"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2118:1: ruleQualifiedJavaClassName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedJavaClassName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_UPPERCASE_ID_2=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2121:28: ( (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2122:1: (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2122:1: (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2123:5: this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID
            {
             
                    newCompositeNode(grammarAccess.getQualifiedJavaClassNameAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedJavaClassName4991);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            kw=(Token)match(input,37,FOLLOW_37_in_ruleQualifiedJavaClassName5009); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getQualifiedJavaClassNameAccess().getFullStopKeyword_1()); 
                
            this_UPPERCASE_ID_2=(Token)match(input,RULE_UPPERCASE_ID,FOLLOW_RULE_UPPERCASE_ID_in_ruleQualifiedJavaClassName5024); 

            		current.merge(this_UPPERCASE_ID_2);
                
             
                newLeafNode(this_UPPERCASE_ID_2, grammarAccess.getQualifiedJavaClassNameAccess().getUPPERCASE_IDTerminalRuleCall_2()); 
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedJavaClassName"


    // $ANTLR start "entryRuleQualifiedNameWithWildcard"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2154:1: entryRuleQualifiedNameWithWildcard returns [String current=null] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2155:2: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2156:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard5070);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();

            state._fsp--;

             current =iv_ruleQualifiedNameWithWildcard.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard5081); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedNameWithWildcard"


    // $ANTLR start "ruleQualifiedNameWithWildcard"
    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2163:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2166:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2167:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2167:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2168:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard5128);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2178:1: (kw= '.*' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==38) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:2179:2: kw= '.*'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleQualifiedNameWithWildcard5147); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getQualifiedNameWithWildcardAccess().getFullStopAsteriskKeyword_1()); 
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedNameWithWildcard"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleModel130 = new BitSet(new long[]{0x0000000400012002L});
    public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatement176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDefinition_in_ruleStatement223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleStatement250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_ruleStatement277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDefinition_in_entryRulePackageDefinition312 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageDefinition322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rulePackageDefinition359 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rulePackageDefinition380 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_rulePackageDefinition392 = new BitSet(new long[]{0x00000000021B8000L});
    public static final BitSet FOLLOW_rulePackageStatement_in_rulePackageDefinition413 = new BitSet(new long[]{0x00000000021B8000L});
    public static final BitSet FOLLOW_15_in_rulePackageDefinition426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageStatement_in_entryRulePackageStatement462 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageStatement472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rulePackageStatement519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestDefinition_in_rulePackageStatement546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallDefinition_in_rulePackageStatement573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteDefinition_in_rulePackageStatement600 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_rulePackageStatement627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport662 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleImport709 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_ruleImport730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestDefinition_in_entryRuleTestDefinition766 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestDefinition776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleTestDefinition813 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTestDefinition834 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleTestDefinition846 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMethodReference_in_ruleTestDefinition867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallDefinition_in_entryRuleCallDefinition903 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallDefinition913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleCallDefinition950 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCallDefinition971 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleCallDefinition983 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleMethodReference_in_ruleCallDefinition1004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteDefinition_in_entryRuleSuiteDefinition1040 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteDefinition1050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleSuiteDefinition1087 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuiteDefinition1108 = new BitSet(new long[]{0x0000000000604000L});
    public static final BitSet FOLLOW_21_in_ruleSuiteDefinition1121 = new BitSet(new long[]{0x0000000000404010L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_ruleSuiteDefinition1142 = new BitSet(new long[]{0x0000000000404010L});
    public static final BitSet FOLLOW_22_in_ruleSuiteDefinition1158 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuiteDefinition1181 = new BitSet(new long[]{0x0000000000004010L});
    public static final BitSet FOLLOW_14_in_ruleSuiteDefinition1196 = new BitSet(new long[]{0x000000052A9B2000L});
    public static final BitSet FOLLOW_ruleSuiteStatement_in_ruleSuiteDefinition1217 = new BitSet(new long[]{0x000000052A9B2000L});
    public static final BitSet FOLLOW_23_in_ruleSuiteDefinition1230 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_ruleSuiteDefinition1243 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuiteDefinition1266 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleSuiteStatement_in_entryRuleSuiteStatement1305 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteStatement1315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteStatementWithResult_in_ruleSuiteStatement1362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSuiteStatement1389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_ruleSuiteStatement1416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteStatementWithResult_in_entryRuleSuiteStatementWithResult1451 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteStatementWithResult1461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_ruleSuiteStatementWithResult1508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTest_in_ruleSuiteStatementWithResult1535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTableTest_in_ruleSuiteStatementWithResult1562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_entryRuleVariableDefinition1597 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDefinition1607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleVariableDefinition1644 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_ruleVariableDefinition1665 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleVariableDefinition1678 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_ruleValue_in_ruleVariableDefinition1699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_entryRuleVariableEntity1737 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableEntity1747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleVariableEntity1792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTest_in_entryRuleTest1827 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTest1837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleTest1874 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTest1897 = new BitSet(new long[]{0x0000000090000012L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleTest1918 = new BitSet(new long[]{0x0000000090000012L});
    public static final BitSet FOLLOW_ruleNamedTestResult_in_ruleTest1940 = new BitSet(new long[]{0x0000000090000012L});
    public static final BitSet FOLLOW_28_in_ruleTest1954 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_ruleTest1975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTableTest_in_entryRuleTableTest2013 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTableTest2023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleTableTest2060 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTableTest2083 = new BitSet(new long[]{0x00000000C0000010L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleTableTest2104 = new BitSet(new long[]{0x00000000C0000010L});
    public static final BitSet FOLLOW_ruleParameterTableHeader_in_ruleTableTest2126 = new BitSet(new long[]{0x00000000C0000010L});
    public static final BitSet FOLLOW_30_in_ruleTableTest2141 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleTableTest2153 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleTableTest2165 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleTableTest2184 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleTableTestRow_in_ruleTableTest2206 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_ruleTableTestRow_in_entryRuleTableTestRow2243 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTableTestRow2253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableValue_in_ruleTableTestRow2308 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleTableTestRow2323 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleTableTestRow2335 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_ruleTableTestRow2356 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleTableTestRow2368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleTableTestRow2387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableHeader_in_entryRuleParameterTableHeader2424 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterTableHeader2434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleParameterTableHeader2471 = new BitSet(new long[]{0x0000000080000010L});
    public static final BitSet FOLLOW_ruleParameterName_in_ruleParameterTableHeader2492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableValue_in_entryRuleParameterTableValue2528 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterTableValue2538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleParameterTableValue2575 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_ruleParameterTableValue2596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedTestResult_in_entryRuleNamedTestResult2632 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedTestResult2642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestResultName_in_ruleNamedTestResult2688 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleNamedTestResult2700 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_ruleNamedTestResult2721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestResultName_in_entryRuleTestResultName2757 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestResultName2767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedTestResultName_in_ruleTestResultName2814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryTestResultName_in_ruleTestResultName2841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedTestResultName_in_entryRuleFixedTestResultName2876 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFixedTestResultName2886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFixedTestResultName2930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryTestResultName_in_entryRuleArbitraryTestResultName2965 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArbitraryTestResultName2975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleArbitraryTestResultName3012 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleArbitraryTestResultName3029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_entryRuleCall3070 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCall3080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleCall3117 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCall3140 = new BitSet(new long[]{0x0000000280000012L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleCall3161 = new BitSet(new long[]{0x0000000280000012L});
    public static final BitSet FOLLOW_33_in_ruleCall3175 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleCall3196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_entryRuleSuite3234 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuite3244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleSuite3281 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuite3304 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleSuiteParameter_in_ruleSuite3325 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleSuiteParameter_in_entryRuleSuiteParameter3362 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteParameter3372 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuiteParameter3420 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleSuiteParameter3432 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_ruleValue_in_ruleSuiteParameter3453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter3489 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter3499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterName_in_ruleParameter3545 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleParameter3557 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_ruleParameter3578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterName_in_entryRuleParameterName3614 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterName3624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedParameterName_in_ruleParameterName3671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterName_in_ruleParameterName3698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedParameterName_in_entryRuleFixedParameterName3733 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFixedParameterName3743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFixedParameterName3787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterName_in_entryRuleArbitraryParameterName3822 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArbitraryParameterName3832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleArbitraryParameterName3869 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleArbitraryParameterName3886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_entryRuleValueOrEnumValue3927 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueOrEnumValue3937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_ruleValueOrEnumValue3984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumValue_in_ruleValueOrEnumValue4011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue4046 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue4056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringValue_in_ruleValue4103 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerValue_in_ruleValue4130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalValue_in_ruleValue4157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleValue4184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerValue_in_entryRuleIntegerValue4219 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerValue4229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleIntegerValue4270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalValue_in_entryRuleDecimalValue4310 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalValue4320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DECIMAL_in_ruleDecimalValue4361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringValue_in_entryRuleStringValue4401 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringValue4411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringValue4452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable4492 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable4502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleVariable4549 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumValue_in_entryRuleEnumValue4584 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumValue4594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UPPERCASE_ID_in_ruleEnumValue4638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodReference_in_entryRuleMethodReference4673 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodReference4683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_ruleMethodReference4731 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleMethodReference4743 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMethodReference4763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName4800 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName4811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName4851 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleQualifiedName4870 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName4885 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_entryRuleQualifiedJavaClassName4933 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedJavaClassName4944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedJavaClassName4991 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleQualifiedJavaClassName5009 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_UPPERCASE_ID_in_ruleQualifiedJavaClassName5024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard5070 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard5081 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard5128 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleQualifiedNameWithWildcard5147 = new BitSet(new long[]{0x0000000000000002L});

}