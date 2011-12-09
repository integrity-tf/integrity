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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INTEGER", "RULE_DECIMAL", "RULE_STRING", "RULE_UPPERCASE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'packagedef'", "'with'", "'packageend'", "'import'", "'testdef'", "'uses'", "'calldef'", "'suitedef'", "'gets'", "'requires'", "'suiteend'", "'concludedby'", "'variable'", "'initially'", "'test'", "'='", "'call'", "'sets'", "'suite'", "':'", "'+'", "'#'", "'.'", "'.*'"
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
    public String getGrammarFileName() { return "../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g"; }



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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:69:2: iv_ruleModel= ruleModel EOF
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:76:1: ruleModel returns [EObject current=null] : ( (lv_statements_0_0= ruleStatement ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_statements_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:79:28: ( ( (lv_statements_0_0= ruleStatement ) )* )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:80:1: ( (lv_statements_0_0= ruleStatement ) )*
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:80:1: ( (lv_statements_0_0= ruleStatement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13||LA1_0==16||LA1_0==31) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:81:1: (lv_statements_0_0= ruleStatement )
            	    {
            	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:81:1: (lv_statements_0_0= ruleStatement )
            	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:82:3: lv_statements_0_0= ruleStatement
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:106:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:107:2: (iv_ruleStatement= ruleStatement EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:108:2: iv_ruleStatement= ruleStatement EOF
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:115:1: ruleStatement returns [EObject current=null] : (this_PackageDefinition_0= rulePackageDefinition | this_Import_1= ruleImport | this_Suite_2= ruleSuite ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_PackageDefinition_0 = null;

        EObject this_Import_1 = null;

        EObject this_Suite_2 = null;


         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:118:28: ( (this_PackageDefinition_0= rulePackageDefinition | this_Import_1= ruleImport | this_Suite_2= ruleSuite ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:119:1: (this_PackageDefinition_0= rulePackageDefinition | this_Import_1= ruleImport | this_Suite_2= ruleSuite )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:119:1: (this_PackageDefinition_0= rulePackageDefinition | this_Import_1= ruleImport | this_Suite_2= ruleSuite )
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
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:120:5: this_PackageDefinition_0= rulePackageDefinition
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
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:130:5: this_Import_1= ruleImport
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
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:140:5: this_Suite_2= ruleSuite
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:156:1: entryRulePackageDefinition returns [EObject current=null] : iv_rulePackageDefinition= rulePackageDefinition EOF ;
    public final EObject entryRulePackageDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDefinition = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:157:2: (iv_rulePackageDefinition= rulePackageDefinition EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:158:2: iv_rulePackageDefinition= rulePackageDefinition EOF
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:165:1: rulePackageDefinition returns [EObject current=null] : (otherlv_0= 'packagedef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'with' ( (lv_statements_3_0= rulePackageStatement ) )* otherlv_4= 'packageend' ) ;
    public final EObject rulePackageDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_statements_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:168:28: ( (otherlv_0= 'packagedef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'with' ( (lv_statements_3_0= rulePackageStatement ) )* otherlv_4= 'packageend' ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:169:1: (otherlv_0= 'packagedef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'with' ( (lv_statements_3_0= rulePackageStatement ) )* otherlv_4= 'packageend' )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:169:1: (otherlv_0= 'packagedef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'with' ( (lv_statements_3_0= rulePackageStatement ) )* otherlv_4= 'packageend' )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:169:3: otherlv_0= 'packagedef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'with' ( (lv_statements_3_0= rulePackageStatement ) )* otherlv_4= 'packageend'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_rulePackageDefinition359); 

                	newLeafNode(otherlv_0, grammarAccess.getPackageDefinitionAccess().getPackagedefKeyword_0());
                
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:173:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:174:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:174:1: (lv_name_1_0= ruleQualifiedName )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:175:3: lv_name_1_0= ruleQualifiedName
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
                
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:195:1: ( (lv_statements_3_0= rulePackageStatement ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=16 && LA3_0<=17)||(LA3_0>=19 && LA3_0<=20)||LA3_0==25) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:196:1: (lv_statements_3_0= rulePackageStatement )
            	    {
            	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:196:1: (lv_statements_3_0= rulePackageStatement )
            	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:197:3: lv_statements_3_0= rulePackageStatement
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:225:1: entryRulePackageStatement returns [EObject current=null] : iv_rulePackageStatement= rulePackageStatement EOF ;
    public final EObject entryRulePackageStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageStatement = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:226:2: (iv_rulePackageStatement= rulePackageStatement EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:227:2: iv_rulePackageStatement= rulePackageStatement EOF
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:234:1: rulePackageStatement returns [EObject current=null] : (this_Import_0= ruleImport | this_TestDefinition_1= ruleTestDefinition | this_CallDefinition_2= ruleCallDefinition | this_SuiteDefinition_3= ruleSuiteDefinition | this_VariableDefinition_4= ruleVariableDefinition ) ;
    public final EObject rulePackageStatement() throws RecognitionException {
        EObject current = null;

        EObject this_Import_0 = null;

        EObject this_TestDefinition_1 = null;

        EObject this_CallDefinition_2 = null;

        EObject this_SuiteDefinition_3 = null;

        EObject this_VariableDefinition_4 = null;


         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:237:28: ( (this_Import_0= ruleImport | this_TestDefinition_1= ruleTestDefinition | this_CallDefinition_2= ruleCallDefinition | this_SuiteDefinition_3= ruleSuiteDefinition | this_VariableDefinition_4= ruleVariableDefinition ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:238:1: (this_Import_0= ruleImport | this_TestDefinition_1= ruleTestDefinition | this_CallDefinition_2= ruleCallDefinition | this_SuiteDefinition_3= ruleSuiteDefinition | this_VariableDefinition_4= ruleVariableDefinition )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:238:1: (this_Import_0= ruleImport | this_TestDefinition_1= ruleTestDefinition | this_CallDefinition_2= ruleCallDefinition | this_SuiteDefinition_3= ruleSuiteDefinition | this_VariableDefinition_4= ruleVariableDefinition )
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
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:239:5: this_Import_0= ruleImport
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
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:249:5: this_TestDefinition_1= ruleTestDefinition
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
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:259:5: this_CallDefinition_2= ruleCallDefinition
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
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:269:5: this_SuiteDefinition_3= ruleSuiteDefinition
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
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:279:5: this_VariableDefinition_4= ruleVariableDefinition
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:295:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:296:2: (iv_ruleImport= ruleImport EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:297:2: iv_ruleImport= ruleImport EOF
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:304:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:307:28: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:308:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:308:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:308:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleImport709); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:312:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:313:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:313:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:314:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:338:1: entryRuleTestDefinition returns [EObject current=null] : iv_ruleTestDefinition= ruleTestDefinition EOF ;
    public final EObject entryRuleTestDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestDefinition = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:339:2: (iv_ruleTestDefinition= ruleTestDefinition EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:340:2: iv_ruleTestDefinition= ruleTestDefinition EOF
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:347:1: ruleTestDefinition returns [EObject current=null] : (otherlv_0= 'testdef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) ) ;
    public final EObject ruleTestDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_fixtureMethod_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:350:28: ( (otherlv_0= 'testdef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:351:1: (otherlv_0= 'testdef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:351:1: (otherlv_0= 'testdef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:351:3: otherlv_0= 'testdef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleTestDefinition813); 

                	newLeafNode(otherlv_0, grammarAccess.getTestDefinitionAccess().getTestdefKeyword_0());
                
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:355:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:356:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:356:1: (lv_name_1_0= ruleQualifiedName )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:357:3: lv_name_1_0= ruleQualifiedName
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
                
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:377:1: ( (lv_fixtureMethod_3_0= ruleMethodReference ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:378:1: (lv_fixtureMethod_3_0= ruleMethodReference )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:378:1: (lv_fixtureMethod_3_0= ruleMethodReference )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:379:3: lv_fixtureMethod_3_0= ruleMethodReference
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:403:1: entryRuleCallDefinition returns [EObject current=null] : iv_ruleCallDefinition= ruleCallDefinition EOF ;
    public final EObject entryRuleCallDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallDefinition = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:404:2: (iv_ruleCallDefinition= ruleCallDefinition EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:405:2: iv_ruleCallDefinition= ruleCallDefinition EOF
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:412:1: ruleCallDefinition returns [EObject current=null] : (otherlv_0= 'calldef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) ) ;
    public final EObject ruleCallDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_fixtureMethod_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:415:28: ( (otherlv_0= 'calldef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:416:1: (otherlv_0= 'calldef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:416:1: (otherlv_0= 'calldef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:416:3: otherlv_0= 'calldef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) )
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleCallDefinition950); 

                	newLeafNode(otherlv_0, grammarAccess.getCallDefinitionAccess().getCalldefKeyword_0());
                
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:420:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:421:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:421:1: (lv_name_1_0= ruleQualifiedName )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:422:3: lv_name_1_0= ruleQualifiedName
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
                
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:442:1: ( (lv_fixtureMethod_3_0= ruleMethodReference ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:443:1: (lv_fixtureMethod_3_0= ruleMethodReference )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:443:1: (lv_fixtureMethod_3_0= ruleMethodReference )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:444:3: lv_fixtureMethod_3_0= ruleMethodReference
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:468:1: entryRuleSuiteDefinition returns [EObject current=null] : iv_ruleSuiteDefinition= ruleSuiteDefinition EOF ;
    public final EObject entryRuleSuiteDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteDefinition = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:469:2: (iv_ruleSuiteDefinition= ruleSuiteDefinition EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:470:2: iv_ruleSuiteDefinition= ruleSuiteDefinition EOF
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:477:1: ruleSuiteDefinition returns [EObject current=null] : (otherlv_0= 'suitedef' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )* )? (otherlv_4= 'requires' ( ( ruleQualifiedName ) )* )? otherlv_6= 'with' ( (lv_statements_7_0= ruleSuiteStatement ) )* otherlv_8= 'suiteend' (otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )* )? ) ;
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
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:480:28: ( (otherlv_0= 'suitedef' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )* )? (otherlv_4= 'requires' ( ( ruleQualifiedName ) )* )? otherlv_6= 'with' ( (lv_statements_7_0= ruleSuiteStatement ) )* otherlv_8= 'suiteend' (otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )* )? ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:481:1: (otherlv_0= 'suitedef' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )* )? (otherlv_4= 'requires' ( ( ruleQualifiedName ) )* )? otherlv_6= 'with' ( (lv_statements_7_0= ruleSuiteStatement ) )* otherlv_8= 'suiteend' (otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )* )? )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:481:1: (otherlv_0= 'suitedef' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )* )? (otherlv_4= 'requires' ( ( ruleQualifiedName ) )* )? otherlv_6= 'with' ( (lv_statements_7_0= ruleSuiteStatement ) )* otherlv_8= 'suiteend' (otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )* )? )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:481:3: otherlv_0= 'suitedef' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )* )? (otherlv_4= 'requires' ( ( ruleQualifiedName ) )* )? otherlv_6= 'with' ( (lv_statements_7_0= ruleSuiteStatement ) )* otherlv_8= 'suiteend' (otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )* )?
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleSuiteDefinition1087); 

                	newLeafNode(otherlv_0, grammarAccess.getSuiteDefinitionAccess().getSuitedefKeyword_0());
                
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:485:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:486:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:486:1: (lv_name_1_0= ruleQualifiedName )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:487:3: lv_name_1_0= ruleQualifiedName
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

            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:503:2: (otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==21) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:503:4: otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )*
                    {
                    otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleSuiteDefinition1121); 

                        	newLeafNode(otherlv_2, grammarAccess.getSuiteDefinitionAccess().getGetsKeyword_2_0());
                        
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:507:1: ( (lv_parameters_3_0= ruleVariableEntity ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==RULE_ID) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:508:1: (lv_parameters_3_0= ruleVariableEntity )
                    	    {
                    	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:508:1: (lv_parameters_3_0= ruleVariableEntity )
                    	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:509:3: lv_parameters_3_0= ruleVariableEntity
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

            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:525:5: (otherlv_4= 'requires' ( ( ruleQualifiedName ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==22) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:525:7: otherlv_4= 'requires' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_4=(Token)match(input,22,FOLLOW_22_in_ruleSuiteDefinition1158); 

                        	newLeafNode(otherlv_4, grammarAccess.getSuiteDefinitionAccess().getRequiresKeyword_3_0());
                        
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:529:1: ( ( ruleQualifiedName ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==RULE_ID) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:530:1: ( ruleQualifiedName )
                    	    {
                    	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:530:1: ( ruleQualifiedName )
                    	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:531:3: ruleQualifiedName
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
                
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:548:1: ( (lv_statements_7_0= ruleSuiteStatement ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==25||LA9_0==27||LA9_0==29||LA9_0==31) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:549:1: (lv_statements_7_0= ruleSuiteStatement )
            	    {
            	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:549:1: (lv_statements_7_0= ruleSuiteStatement )
            	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:550:3: lv_statements_7_0= ruleSuiteStatement
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
                
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:570:1: (otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==24) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:570:3: otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_9=(Token)match(input,24,FOLLOW_24_in_ruleSuiteDefinition1243); 

                        	newLeafNode(otherlv_9, grammarAccess.getSuiteDefinitionAccess().getConcludedbyKeyword_7_0());
                        
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:574:1: ( ( ruleQualifiedName ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==RULE_ID) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:575:1: ( ruleQualifiedName )
                    	    {
                    	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:575:1: ( ruleQualifiedName )
                    	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:576:3: ruleQualifiedName
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:597:1: entryRuleSuiteStatement returns [EObject current=null] : iv_ruleSuiteStatement= ruleSuiteStatement EOF ;
    public final EObject entryRuleSuiteStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteStatement = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:598:2: (iv_ruleSuiteStatement= ruleSuiteStatement EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:599:2: iv_ruleSuiteStatement= ruleSuiteStatement EOF
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:606:1: ruleSuiteStatement returns [EObject current=null] : (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_Call_1= ruleCall | this_VariableDefinition_2= ruleVariableDefinition ) ;
    public final EObject ruleSuiteStatement() throws RecognitionException {
        EObject current = null;

        EObject this_SuiteStatementWithResult_0 = null;

        EObject this_Call_1 = null;

        EObject this_VariableDefinition_2 = null;


         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:609:28: ( (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_Call_1= ruleCall | this_VariableDefinition_2= ruleVariableDefinition ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:610:1: (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_Call_1= ruleCall | this_VariableDefinition_2= ruleVariableDefinition )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:610:1: (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_Call_1= ruleCall | this_VariableDefinition_2= ruleVariableDefinition )
            int alt12=3;
            switch ( input.LA(1) ) {
            case 27:
            case 31:
                {
                alt12=1;
                }
                break;
            case 29:
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
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:611:5: this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult
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
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:621:5: this_Call_1= ruleCall
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
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:631:5: this_VariableDefinition_2= ruleVariableDefinition
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:647:1: entryRuleSuiteStatementWithResult returns [EObject current=null] : iv_ruleSuiteStatementWithResult= ruleSuiteStatementWithResult EOF ;
    public final EObject entryRuleSuiteStatementWithResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteStatementWithResult = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:648:2: (iv_ruleSuiteStatementWithResult= ruleSuiteStatementWithResult EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:649:2: iv_ruleSuiteStatementWithResult= ruleSuiteStatementWithResult EOF
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:656:1: ruleSuiteStatementWithResult returns [EObject current=null] : (this_Suite_0= ruleSuite | this_Test_1= ruleTest ) ;
    public final EObject ruleSuiteStatementWithResult() throws RecognitionException {
        EObject current = null;

        EObject this_Suite_0 = null;

        EObject this_Test_1 = null;


         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:659:28: ( (this_Suite_0= ruleSuite | this_Test_1= ruleTest ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:660:1: (this_Suite_0= ruleSuite | this_Test_1= ruleTest )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:660:1: (this_Suite_0= ruleSuite | this_Test_1= ruleTest )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==31) ) {
                alt13=1;
            }
            else if ( (LA13_0==27) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:661:5: this_Suite_0= ruleSuite
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
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:671:5: this_Test_1= ruleTest
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementWithResultAccess().getTestParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleTest_in_ruleSuiteStatementWithResult1535);
                    this_Test_1=ruleTest();

                    state._fsp--;

                     
                            current = this_Test_1; 
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:687:1: entryRuleVariableDefinition returns [EObject current=null] : iv_ruleVariableDefinition= ruleVariableDefinition EOF ;
    public final EObject entryRuleVariableDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDefinition = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:688:2: (iv_ruleVariableDefinition= ruleVariableDefinition EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:689:2: iv_ruleVariableDefinition= ruleVariableDefinition EOF
            {
             newCompositeNode(grammarAccess.getVariableDefinitionRule()); 
            pushFollow(FOLLOW_ruleVariableDefinition_in_entryRuleVariableDefinition1570);
            iv_ruleVariableDefinition=ruleVariableDefinition();

            state._fsp--;

             current =iv_ruleVariableDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDefinition1580); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:696:1: ruleVariableDefinition returns [EObject current=null] : (otherlv_0= 'variable' ( (lv_name_1_0= ruleVariableEntity ) ) (otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) ) )? ) ;
    public final EObject ruleVariableDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_name_1_0 = null;

        EObject lv_initialValue_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:699:28: ( (otherlv_0= 'variable' ( (lv_name_1_0= ruleVariableEntity ) ) (otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) ) )? ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:700:1: (otherlv_0= 'variable' ( (lv_name_1_0= ruleVariableEntity ) ) (otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) ) )? )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:700:1: (otherlv_0= 'variable' ( (lv_name_1_0= ruleVariableEntity ) ) (otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) ) )? )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:700:3: otherlv_0= 'variable' ( (lv_name_1_0= ruleVariableEntity ) ) (otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) ) )?
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleVariableDefinition1617); 

                	newLeafNode(otherlv_0, grammarAccess.getVariableDefinitionAccess().getVariableKeyword_0());
                
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:704:1: ( (lv_name_1_0= ruleVariableEntity ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:705:1: (lv_name_1_0= ruleVariableEntity )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:705:1: (lv_name_1_0= ruleVariableEntity )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:706:3: lv_name_1_0= ruleVariableEntity
            {
             
            	        newCompositeNode(grammarAccess.getVariableDefinitionAccess().getNameVariableEntityParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleVariableEntity_in_ruleVariableDefinition1638);
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

            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:722:2: (otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==26) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:722:4: otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) )
                    {
                    otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleVariableDefinition1651); 

                        	newLeafNode(otherlv_2, grammarAccess.getVariableDefinitionAccess().getInitiallyKeyword_2_0());
                        
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:726:1: ( (lv_initialValue_3_0= ruleValue ) )
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:727:1: (lv_initialValue_3_0= ruleValue )
                    {
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:727:1: (lv_initialValue_3_0= ruleValue )
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:728:3: lv_initialValue_3_0= ruleValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariableDefinitionAccess().getInitialValueValueParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValue_in_ruleVariableDefinition1672);
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:752:1: entryRuleVariableEntity returns [EObject current=null] : iv_ruleVariableEntity= ruleVariableEntity EOF ;
    public final EObject entryRuleVariableEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableEntity = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:753:2: (iv_ruleVariableEntity= ruleVariableEntity EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:754:2: iv_ruleVariableEntity= ruleVariableEntity EOF
            {
             newCompositeNode(grammarAccess.getVariableEntityRule()); 
            pushFollow(FOLLOW_ruleVariableEntity_in_entryRuleVariableEntity1710);
            iv_ruleVariableEntity=ruleVariableEntity();

            state._fsp--;

             current =iv_ruleVariableEntity; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableEntity1720); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:761:1: ruleVariableEntity returns [EObject current=null] : ( (lv_name_0_0= ruleQualifiedName ) ) ;
    public final EObject ruleVariableEntity() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:764:28: ( ( (lv_name_0_0= ruleQualifiedName ) ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:765:1: ( (lv_name_0_0= ruleQualifiedName ) )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:765:1: ( (lv_name_0_0= ruleQualifiedName ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:766:1: (lv_name_0_0= ruleQualifiedName )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:766:1: (lv_name_0_0= ruleQualifiedName )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:767:3: lv_name_0_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getVariableEntityAccess().getNameQualifiedNameParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleVariableEntity1765);
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:791:1: entryRuleTest returns [EObject current=null] : iv_ruleTest= ruleTest EOF ;
    public final EObject entryRuleTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTest = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:792:2: (iv_ruleTest= ruleTest EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:793:2: iv_ruleTest= ruleTest EOF
            {
             newCompositeNode(grammarAccess.getTestRule()); 
            pushFollow(FOLLOW_ruleTest_in_entryRuleTest1800);
            iv_ruleTest=ruleTest();

            state._fsp--;

             current =iv_ruleTest; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTest1810); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:800:1: ruleTest returns [EObject current=null] : (otherlv_0= 'test' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* (otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) )? ) ;
    public final EObject ruleTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_parameters_2_0 = null;

        EObject lv_result_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:803:28: ( (otherlv_0= 'test' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* (otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) )? ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:804:1: (otherlv_0= 'test' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* (otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) )? )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:804:1: (otherlv_0= 'test' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* (otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) )? )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:804:3: otherlv_0= 'test' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* (otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) )?
            {
            otherlv_0=(Token)match(input,27,FOLLOW_27_in_ruleTest1847); 

                	newLeafNode(otherlv_0, grammarAccess.getTestAccess().getTestKeyword_0());
                
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:808:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:809:1: ( ruleQualifiedName )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:809:1: ( ruleQualifiedName )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:810:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTestRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTestAccess().getDefinitionTestDefinitionCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleTest1870);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:823:2: ( (lv_parameters_2_0= ruleParameter ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID||LA15_0==33) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:824:1: (lv_parameters_2_0= ruleParameter )
            	    {
            	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:824:1: (lv_parameters_2_0= ruleParameter )
            	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:825:3: lv_parameters_2_0= ruleParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTestAccess().getParametersParameterParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameter_in_ruleTest1891);
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

            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:841:3: (otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==28) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:841:5: otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) )
                    {
                    otherlv_3=(Token)match(input,28,FOLLOW_28_in_ruleTest1905); 

                        	newLeafNode(otherlv_3, grammarAccess.getTestAccess().getEqualsSignKeyword_3_0());
                        
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:845:1: ( (lv_result_4_0= ruleValueOrEnumValue ) )
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:846:1: (lv_result_4_0= ruleValueOrEnumValue )
                    {
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:846:1: (lv_result_4_0= ruleValueOrEnumValue )
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:847:3: lv_result_4_0= ruleValueOrEnumValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getTestAccess().getResultValueOrEnumValueParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueOrEnumValue_in_ruleTest1926);
                    lv_result_4_0=ruleValueOrEnumValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTestRule());
                    	        }
                           		set(
                           			current, 
                           			"result",
                            		lv_result_4_0, 
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


    // $ANTLR start "entryRuleCall"
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:871:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:872:2: (iv_ruleCall= ruleCall EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:873:2: iv_ruleCall= ruleCall EOF
            {
             newCompositeNode(grammarAccess.getCallRule()); 
            pushFollow(FOLLOW_ruleCall_in_entryRuleCall1964);
            iv_ruleCall=ruleCall();

            state._fsp--;

             current =iv_ruleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCall1974); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:880:1: ruleCall returns [EObject current=null] : (otherlv_0= 'call' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* (otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) ) )? ) ;
    public final EObject ruleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_parameters_2_0 = null;

        EObject lv_result_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:883:28: ( (otherlv_0= 'call' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* (otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) ) )? ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:884:1: (otherlv_0= 'call' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* (otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) ) )? )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:884:1: (otherlv_0= 'call' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* (otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) ) )? )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:884:3: otherlv_0= 'call' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* (otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) ) )?
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleCall2011); 

                	newLeafNode(otherlv_0, grammarAccess.getCallAccess().getCallKeyword_0());
                
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:888:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:889:1: ( ruleQualifiedName )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:889:1: ( ruleQualifiedName )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:890:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCallRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getCallAccess().getDefinitionCallDefinitionCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleCall2034);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:903:2: ( (lv_parameters_2_0= ruleParameter ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_ID||LA17_0==33) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:904:1: (lv_parameters_2_0= ruleParameter )
            	    {
            	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:904:1: (lv_parameters_2_0= ruleParameter )
            	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:905:3: lv_parameters_2_0= ruleParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCallAccess().getParametersParameterParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameter_in_ruleCall2055);
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
            	    break loop17;
                }
            } while (true);

            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:921:3: (otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==30) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:921:5: otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) )
                    {
                    otherlv_3=(Token)match(input,30,FOLLOW_30_in_ruleCall2069); 

                        	newLeafNode(otherlv_3, grammarAccess.getCallAccess().getSetsKeyword_3_0());
                        
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:925:1: ( (lv_result_4_0= ruleVariable ) )
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:926:1: (lv_result_4_0= ruleVariable )
                    {
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:926:1: (lv_result_4_0= ruleVariable )
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:927:3: lv_result_4_0= ruleVariable
                    {
                     
                    	        newCompositeNode(grammarAccess.getCallAccess().getResultVariableParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVariable_in_ruleCall2090);
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:951:1: entryRuleSuite returns [EObject current=null] : iv_ruleSuite= ruleSuite EOF ;
    public final EObject entryRuleSuite() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuite = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:952:2: (iv_ruleSuite= ruleSuite EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:953:2: iv_ruleSuite= ruleSuite EOF
            {
             newCompositeNode(grammarAccess.getSuiteRule()); 
            pushFollow(FOLLOW_ruleSuite_in_entryRuleSuite2128);
            iv_ruleSuite=ruleSuite();

            state._fsp--;

             current =iv_ruleSuite; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuite2138); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:960:1: ruleSuite returns [EObject current=null] : (otherlv_0= 'suite' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleSuiteParameter ) )* ) ;
    public final EObject ruleSuite() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_parameters_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:963:28: ( (otherlv_0= 'suite' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleSuiteParameter ) )* ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:964:1: (otherlv_0= 'suite' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleSuiteParameter ) )* )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:964:1: (otherlv_0= 'suite' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleSuiteParameter ) )* )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:964:3: otherlv_0= 'suite' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleSuiteParameter ) )*
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleSuite2175); 

                	newLeafNode(otherlv_0, grammarAccess.getSuiteAccess().getSuiteKeyword_0());
                
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:968:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:969:1: ( ruleQualifiedName )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:969:1: ( ruleQualifiedName )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:970:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSuiteRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSuiteAccess().getDefinitionSuiteDefinitionCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuite2198);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:983:2: ( (lv_parameters_2_0= ruleSuiteParameter ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:984:1: (lv_parameters_2_0= ruleSuiteParameter )
            	    {
            	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:984:1: (lv_parameters_2_0= ruleSuiteParameter )
            	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:985:3: lv_parameters_2_0= ruleSuiteParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSuiteAccess().getParametersSuiteParameterParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSuiteParameter_in_ruleSuite2219);
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
            	    break loop19;
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1009:1: entryRuleSuiteParameter returns [EObject current=null] : iv_ruleSuiteParameter= ruleSuiteParameter EOF ;
    public final EObject entryRuleSuiteParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteParameter = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1010:2: (iv_ruleSuiteParameter= ruleSuiteParameter EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1011:2: iv_ruleSuiteParameter= ruleSuiteParameter EOF
            {
             newCompositeNode(grammarAccess.getSuiteParameterRule()); 
            pushFollow(FOLLOW_ruleSuiteParameter_in_entryRuleSuiteParameter2256);
            iv_ruleSuiteParameter=ruleSuiteParameter();

            state._fsp--;

             current =iv_ruleSuiteParameter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteParameter2266); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1018:1: ruleSuiteParameter returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValue ) ) ) ;
    public final EObject ruleSuiteParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1021:28: ( ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValue ) ) ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1022:1: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValue ) ) )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1022:1: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValue ) ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1022:2: ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValue ) )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1022:2: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1023:1: ( ruleQualifiedName )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1023:1: ( ruleQualifiedName )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1024:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSuiteParameterRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSuiteParameterAccess().getNameVariableEntityCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuiteParameter2314);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,32,FOLLOW_32_in_ruleSuiteParameter2326); 

                	newLeafNode(otherlv_1, grammarAccess.getSuiteParameterAccess().getColonKeyword_1());
                
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1041:1: ( (lv_value_2_0= ruleValue ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1042:1: (lv_value_2_0= ruleValue )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1042:1: (lv_value_2_0= ruleValue )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1043:3: lv_value_2_0= ruleValue
            {
             
            	        newCompositeNode(grammarAccess.getSuiteParameterAccess().getValueValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleValue_in_ruleSuiteParameter2347);
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1067:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1068:2: (iv_ruleParameter= ruleParameter EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1069:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter2383);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter2393); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1076:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= ruleParameterName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValueOrEnumValue ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1079:28: ( ( ( (lv_name_0_0= ruleParameterName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValueOrEnumValue ) ) ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1080:1: ( ( (lv_name_0_0= ruleParameterName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValueOrEnumValue ) ) )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1080:1: ( ( (lv_name_0_0= ruleParameterName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValueOrEnumValue ) ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1080:2: ( (lv_name_0_0= ruleParameterName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValueOrEnumValue ) )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1080:2: ( (lv_name_0_0= ruleParameterName ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1081:1: (lv_name_0_0= ruleParameterName )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1081:1: (lv_name_0_0= ruleParameterName )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1082:3: lv_name_0_0= ruleParameterName
            {
             
            	        newCompositeNode(grammarAccess.getParameterAccess().getNameParameterNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleParameterName_in_ruleParameter2439);
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

            otherlv_1=(Token)match(input,32,FOLLOW_32_in_ruleParameter2451); 

                	newLeafNode(otherlv_1, grammarAccess.getParameterAccess().getColonKeyword_1());
                
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1102:1: ( (lv_value_2_0= ruleValueOrEnumValue ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1103:1: (lv_value_2_0= ruleValueOrEnumValue )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1103:1: (lv_value_2_0= ruleValueOrEnumValue )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1104:3: lv_value_2_0= ruleValueOrEnumValue
            {
             
            	        newCompositeNode(grammarAccess.getParameterAccess().getValueValueOrEnumValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_ruleParameter2472);
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1128:1: entryRuleParameterName returns [EObject current=null] : iv_ruleParameterName= ruleParameterName EOF ;
    public final EObject entryRuleParameterName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterName = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1129:2: (iv_ruleParameterName= ruleParameterName EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1130:2: iv_ruleParameterName= ruleParameterName EOF
            {
             newCompositeNode(grammarAccess.getParameterNameRule()); 
            pushFollow(FOLLOW_ruleParameterName_in_entryRuleParameterName2508);
            iv_ruleParameterName=ruleParameterName();

            state._fsp--;

             current =iv_ruleParameterName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterName2518); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1137:1: ruleParameterName returns [EObject current=null] : (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterName_1= ruleArbitraryParameterName ) ;
    public final EObject ruleParameterName() throws RecognitionException {
        EObject current = null;

        EObject this_FixedParameterName_0 = null;

        EObject this_ArbitraryParameterName_1 = null;


         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1140:28: ( (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterName_1= ruleArbitraryParameterName ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1141:1: (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterName_1= ruleArbitraryParameterName )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1141:1: (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterName_1= ruleArbitraryParameterName )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                alt20=1;
            }
            else if ( (LA20_0==33) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1142:5: this_FixedParameterName_0= ruleFixedParameterName
                    {
                     
                            newCompositeNode(grammarAccess.getParameterNameAccess().getFixedParameterNameParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleFixedParameterName_in_ruleParameterName2565);
                    this_FixedParameterName_0=ruleFixedParameterName();

                    state._fsp--;

                     
                            current = this_FixedParameterName_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1152:5: this_ArbitraryParameterName_1= ruleArbitraryParameterName
                    {
                     
                            newCompositeNode(grammarAccess.getParameterNameAccess().getArbitraryParameterNameParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleArbitraryParameterName_in_ruleParameterName2592);
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1168:1: entryRuleFixedParameterName returns [EObject current=null] : iv_ruleFixedParameterName= ruleFixedParameterName EOF ;
    public final EObject entryRuleFixedParameterName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedParameterName = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1169:2: (iv_ruleFixedParameterName= ruleFixedParameterName EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1170:2: iv_ruleFixedParameterName= ruleFixedParameterName EOF
            {
             newCompositeNode(grammarAccess.getFixedParameterNameRule()); 
            pushFollow(FOLLOW_ruleFixedParameterName_in_entryRuleFixedParameterName2627);
            iv_ruleFixedParameterName=ruleFixedParameterName();

            state._fsp--;

             current =iv_ruleFixedParameterName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFixedParameterName2637); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1177:1: ruleFixedParameterName returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleFixedParameterName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1180:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1181:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1181:1: ( (otherlv_0= RULE_ID ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1182:1: (otherlv_0= RULE_ID )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1182:1: (otherlv_0= RULE_ID )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1183:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFixedParameterNameRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFixedParameterName2681); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1202:1: entryRuleArbitraryParameterName returns [EObject current=null] : iv_ruleArbitraryParameterName= ruleArbitraryParameterName EOF ;
    public final EObject entryRuleArbitraryParameterName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArbitraryParameterName = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1203:2: (iv_ruleArbitraryParameterName= ruleArbitraryParameterName EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1204:2: iv_ruleArbitraryParameterName= ruleArbitraryParameterName EOF
            {
             newCompositeNode(grammarAccess.getArbitraryParameterNameRule()); 
            pushFollow(FOLLOW_ruleArbitraryParameterName_in_entryRuleArbitraryParameterName2716);
            iv_ruleArbitraryParameterName=ruleArbitraryParameterName();

            state._fsp--;

             current =iv_ruleArbitraryParameterName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArbitraryParameterName2726); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1211:1: ruleArbitraryParameterName returns [EObject current=null] : (otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) ) ) ;
    public final EObject ruleArbitraryParameterName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_identifier_1_0=null;

         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1214:28: ( (otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) ) ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1215:1: (otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) ) )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1215:1: (otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1215:3: otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_ruleArbitraryParameterName2763); 

                	newLeafNode(otherlv_0, grammarAccess.getArbitraryParameterNameAccess().getPlusSignKeyword_0());
                
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1219:1: ( (lv_identifier_1_0= RULE_ID ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1220:1: (lv_identifier_1_0= RULE_ID )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1220:1: (lv_identifier_1_0= RULE_ID )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1221:3: lv_identifier_1_0= RULE_ID
            {
            lv_identifier_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleArbitraryParameterName2780); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1245:1: entryRuleValueOrEnumValue returns [EObject current=null] : iv_ruleValueOrEnumValue= ruleValueOrEnumValue EOF ;
    public final EObject entryRuleValueOrEnumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueOrEnumValue = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1246:2: (iv_ruleValueOrEnumValue= ruleValueOrEnumValue EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1247:2: iv_ruleValueOrEnumValue= ruleValueOrEnumValue EOF
            {
             newCompositeNode(grammarAccess.getValueOrEnumValueRule()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_entryRuleValueOrEnumValue2821);
            iv_ruleValueOrEnumValue=ruleValueOrEnumValue();

            state._fsp--;

             current =iv_ruleValueOrEnumValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueOrEnumValue2831); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1254:1: ruleValueOrEnumValue returns [EObject current=null] : (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue ) ;
    public final EObject ruleValueOrEnumValue() throws RecognitionException {
        EObject current = null;

        EObject this_Value_0 = null;

        EObject this_EnumValue_1 = null;


         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1257:28: ( (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1258:1: (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1258:1: (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=RULE_ID && LA21_0<=RULE_STRING)) ) {
                alt21=1;
            }
            else if ( (LA21_0==RULE_UPPERCASE_ID) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1259:5: this_Value_0= ruleValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueOrEnumValueAccess().getValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleValue_in_ruleValueOrEnumValue2878);
                    this_Value_0=ruleValue();

                    state._fsp--;

                     
                            current = this_Value_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1269:5: this_EnumValue_1= ruleEnumValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueOrEnumValueAccess().getEnumValueParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEnumValue_in_ruleValueOrEnumValue2905);
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1285:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1286:2: (iv_ruleValue= ruleValue EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1287:2: iv_ruleValue= ruleValue EOF
            {
             newCompositeNode(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue2940);
            iv_ruleValue=ruleValue();

            state._fsp--;

             current =iv_ruleValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue2950); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1294:1: ruleValue returns [EObject current=null] : (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_Variable_3= ruleVariable ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        EObject this_StringValue_0 = null;

        EObject this_IntegerValue_1 = null;

        EObject this_DecimalValue_2 = null;

        EObject this_Variable_3 = null;


         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1297:28: ( (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_Variable_3= ruleVariable ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1298:1: (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_Variable_3= ruleVariable )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1298:1: (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_Variable_3= ruleVariable )
            int alt22=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt22=1;
                }
                break;
            case RULE_INTEGER:
                {
                alt22=2;
                }
                break;
            case RULE_DECIMAL:
                {
                alt22=3;
                }
                break;
            case RULE_ID:
                {
                alt22=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1299:5: this_StringValue_0= ruleStringValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getStringValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleStringValue_in_ruleValue2997);
                    this_StringValue_0=ruleStringValue();

                    state._fsp--;

                     
                            current = this_StringValue_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1309:5: this_IntegerValue_1= ruleIntegerValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getIntegerValueParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleIntegerValue_in_ruleValue3024);
                    this_IntegerValue_1=ruleIntegerValue();

                    state._fsp--;

                     
                            current = this_IntegerValue_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1319:5: this_DecimalValue_2= ruleDecimalValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getDecimalValueParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleDecimalValue_in_ruleValue3051);
                    this_DecimalValue_2=ruleDecimalValue();

                    state._fsp--;

                     
                            current = this_DecimalValue_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1329:5: this_Variable_3= ruleVariable
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getVariableParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleVariable_in_ruleValue3078);
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1345:1: entryRuleIntegerValue returns [EObject current=null] : iv_ruleIntegerValue= ruleIntegerValue EOF ;
    public final EObject entryRuleIntegerValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerValue = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1346:2: (iv_ruleIntegerValue= ruleIntegerValue EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1347:2: iv_ruleIntegerValue= ruleIntegerValue EOF
            {
             newCompositeNode(grammarAccess.getIntegerValueRule()); 
            pushFollow(FOLLOW_ruleIntegerValue_in_entryRuleIntegerValue3113);
            iv_ruleIntegerValue=ruleIntegerValue();

            state._fsp--;

             current =iv_ruleIntegerValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerValue3123); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1354:1: ruleIntegerValue returns [EObject current=null] : ( (lv_integerValue_0_0= RULE_INTEGER ) ) ;
    public final EObject ruleIntegerValue() throws RecognitionException {
        EObject current = null;

        Token lv_integerValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1357:28: ( ( (lv_integerValue_0_0= RULE_INTEGER ) ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1358:1: ( (lv_integerValue_0_0= RULE_INTEGER ) )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1358:1: ( (lv_integerValue_0_0= RULE_INTEGER ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1359:1: (lv_integerValue_0_0= RULE_INTEGER )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1359:1: (lv_integerValue_0_0= RULE_INTEGER )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1360:3: lv_integerValue_0_0= RULE_INTEGER
            {
            lv_integerValue_0_0=(Token)match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleIntegerValue3164); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1384:1: entryRuleDecimalValue returns [EObject current=null] : iv_ruleDecimalValue= ruleDecimalValue EOF ;
    public final EObject entryRuleDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecimalValue = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1385:2: (iv_ruleDecimalValue= ruleDecimalValue EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1386:2: iv_ruleDecimalValue= ruleDecimalValue EOF
            {
             newCompositeNode(grammarAccess.getDecimalValueRule()); 
            pushFollow(FOLLOW_ruleDecimalValue_in_entryRuleDecimalValue3204);
            iv_ruleDecimalValue=ruleDecimalValue();

            state._fsp--;

             current =iv_ruleDecimalValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalValue3214); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1393:1: ruleDecimalValue returns [EObject current=null] : ( (lv_decimalValue_0_0= RULE_DECIMAL ) ) ;
    public final EObject ruleDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_decimalValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1396:28: ( ( (lv_decimalValue_0_0= RULE_DECIMAL ) ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1397:1: ( (lv_decimalValue_0_0= RULE_DECIMAL ) )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1397:1: ( (lv_decimalValue_0_0= RULE_DECIMAL ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1398:1: (lv_decimalValue_0_0= RULE_DECIMAL )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1398:1: (lv_decimalValue_0_0= RULE_DECIMAL )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1399:3: lv_decimalValue_0_0= RULE_DECIMAL
            {
            lv_decimalValue_0_0=(Token)match(input,RULE_DECIMAL,FOLLOW_RULE_DECIMAL_in_ruleDecimalValue3255); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1423:1: entryRuleStringValue returns [EObject current=null] : iv_ruleStringValue= ruleStringValue EOF ;
    public final EObject entryRuleStringValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringValue = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1424:2: (iv_ruleStringValue= ruleStringValue EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1425:2: iv_ruleStringValue= ruleStringValue EOF
            {
             newCompositeNode(grammarAccess.getStringValueRule()); 
            pushFollow(FOLLOW_ruleStringValue_in_entryRuleStringValue3295);
            iv_ruleStringValue=ruleStringValue();

            state._fsp--;

             current =iv_ruleStringValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringValue3305); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1432:1: ruleStringValue returns [EObject current=null] : ( (lv_stringValue_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringValue() throws RecognitionException {
        EObject current = null;

        Token lv_stringValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1435:28: ( ( (lv_stringValue_0_0= RULE_STRING ) ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1436:1: ( (lv_stringValue_0_0= RULE_STRING ) )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1436:1: ( (lv_stringValue_0_0= RULE_STRING ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1437:1: (lv_stringValue_0_0= RULE_STRING )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1437:1: (lv_stringValue_0_0= RULE_STRING )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1438:3: lv_stringValue_0_0= RULE_STRING
            {
            lv_stringValue_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringValue3346); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1462:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1463:2: (iv_ruleVariable= ruleVariable EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1464:2: iv_ruleVariable= ruleVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable3386);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable3396); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1471:1: ruleVariable returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1474:28: ( ( ( ruleQualifiedName ) ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1475:1: ( ( ruleQualifiedName ) )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1475:1: ( ( ruleQualifiedName ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1476:1: ( ruleQualifiedName )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1476:1: ( ruleQualifiedName )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1477:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getVariableRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getVariableAccess().getNameVariableEntityCrossReference_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleVariable3443);
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1498:1: entryRuleEnumValue returns [EObject current=null] : iv_ruleEnumValue= ruleEnumValue EOF ;
    public final EObject entryRuleEnumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumValue = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1499:2: (iv_ruleEnumValue= ruleEnumValue EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1500:2: iv_ruleEnumValue= ruleEnumValue EOF
            {
             newCompositeNode(grammarAccess.getEnumValueRule()); 
            pushFollow(FOLLOW_ruleEnumValue_in_entryRuleEnumValue3478);
            iv_ruleEnumValue=ruleEnumValue();

            state._fsp--;

             current =iv_ruleEnumValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumValue3488); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1507:1: ruleEnumValue returns [EObject current=null] : ( (otherlv_0= RULE_UPPERCASE_ID ) ) ;
    public final EObject ruleEnumValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1510:28: ( ( (otherlv_0= RULE_UPPERCASE_ID ) ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1511:1: ( (otherlv_0= RULE_UPPERCASE_ID ) )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1511:1: ( (otherlv_0= RULE_UPPERCASE_ID ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1512:1: (otherlv_0= RULE_UPPERCASE_ID )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1512:1: (otherlv_0= RULE_UPPERCASE_ID )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1513:3: otherlv_0= RULE_UPPERCASE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumValueRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_UPPERCASE_ID,FOLLOW_RULE_UPPERCASE_ID_in_ruleEnumValue3532); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1532:1: entryRuleMethodReference returns [EObject current=null] : iv_ruleMethodReference= ruleMethodReference EOF ;
    public final EObject entryRuleMethodReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodReference = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1533:2: (iv_ruleMethodReference= ruleMethodReference EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1534:2: iv_ruleMethodReference= ruleMethodReference EOF
            {
             newCompositeNode(grammarAccess.getMethodReferenceRule()); 
            pushFollow(FOLLOW_ruleMethodReference_in_entryRuleMethodReference3567);
            iv_ruleMethodReference=ruleMethodReference();

            state._fsp--;

             current =iv_ruleMethodReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodReference3577); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1541:1: ruleMethodReference returns [EObject current=null] : ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleMethodReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1544:28: ( ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1545:1: ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1545:1: ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1545:2: ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1545:2: ( ( ruleQualifiedJavaClassName ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1546:1: ( ruleQualifiedJavaClassName )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1546:1: ( ruleQualifiedJavaClassName )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1547:3: ruleQualifiedJavaClassName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMethodReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getMethodReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_ruleMethodReference3625);
            ruleQualifiedJavaClassName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleMethodReference3637); 

                	newLeafNode(otherlv_1, grammarAccess.getMethodReferenceAccess().getNumberSignKeyword_1());
                
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1564:1: ( (otherlv_2= RULE_ID ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1565:1: (otherlv_2= RULE_ID )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1565:1: (otherlv_2= RULE_ID )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1566:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMethodReferenceRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMethodReference3657); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1585:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1586:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1587:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName3694);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName3705); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1594:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1597:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1598:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1598:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1598:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName3745); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1605:1: (kw= '.' this_ID_2= RULE_ID )*
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
            	    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1606:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,35,FOLLOW_35_in_ruleQualifiedName3764); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName3779); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop23;
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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1626:1: entryRuleQualifiedJavaClassName returns [String current=null] : iv_ruleQualifiedJavaClassName= ruleQualifiedJavaClassName EOF ;
    public final String entryRuleQualifiedJavaClassName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedJavaClassName = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1627:2: (iv_ruleQualifiedJavaClassName= ruleQualifiedJavaClassName EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1628:2: iv_ruleQualifiedJavaClassName= ruleQualifiedJavaClassName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedJavaClassNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_entryRuleQualifiedJavaClassName3827);
            iv_ruleQualifiedJavaClassName=ruleQualifiedJavaClassName();

            state._fsp--;

             current =iv_ruleQualifiedJavaClassName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedJavaClassName3838); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1635:1: ruleQualifiedJavaClassName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedJavaClassName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_UPPERCASE_ID_2=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1638:28: ( (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1639:1: (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1639:1: (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1640:5: this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID
            {
             
                    newCompositeNode(grammarAccess.getQualifiedJavaClassNameAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedJavaClassName3885);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            kw=(Token)match(input,35,FOLLOW_35_in_ruleQualifiedJavaClassName3903); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getQualifiedJavaClassNameAccess().getFullStopKeyword_1()); 
                
            this_UPPERCASE_ID_2=(Token)match(input,RULE_UPPERCASE_ID,FOLLOW_RULE_UPPERCASE_ID_in_ruleQualifiedJavaClassName3918); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1671:1: entryRuleQualifiedNameWithWildcard returns [String current=null] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;


        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1672:2: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1673:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard3964);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();

            state._fsp--;

             current =iv_ruleQualifiedNameWithWildcard.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard3975); 

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
    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1680:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1683:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1684:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1684:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1685:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard4022);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1695:1: (kw= '.*' )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==36) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../de.integrity.dsl/src-gen/de/integrity/parser/antlr/internal/InternalDSL.g:1696:2: kw= '.*'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_ruleQualifiedNameWithWildcard4041); 

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
    public static final BitSet FOLLOW_ruleStatement_in_ruleModel130 = new BitSet(new long[]{0x0000000080012002L});
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
    public static final BitSet FOLLOW_14_in_ruleSuiteDefinition1196 = new BitSet(new long[]{0x00000000AA9B2000L});
    public static final BitSet FOLLOW_ruleSuiteStatement_in_ruleSuiteDefinition1217 = new BitSet(new long[]{0x00000000AA9B2000L});
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
    public static final BitSet FOLLOW_ruleVariableDefinition_in_entryRuleVariableDefinition1570 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDefinition1580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleVariableDefinition1617 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_ruleVariableDefinition1638 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleVariableDefinition1651 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_ruleValue_in_ruleVariableDefinition1672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_entryRuleVariableEntity1710 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableEntity1720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleVariableEntity1765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTest_in_entryRuleTest1800 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTest1810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleTest1847 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTest1870 = new BitSet(new long[]{0x0000000210000012L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleTest1891 = new BitSet(new long[]{0x0000000210000012L});
    public static final BitSet FOLLOW_28_in_ruleTest1905 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_ruleTest1926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_entryRuleCall1964 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCall1974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleCall2011 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCall2034 = new BitSet(new long[]{0x0000000240000012L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleCall2055 = new BitSet(new long[]{0x0000000240000012L});
    public static final BitSet FOLLOW_30_in_ruleCall2069 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleCall2090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_entryRuleSuite2128 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuite2138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleSuite2175 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuite2198 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleSuiteParameter_in_ruleSuite2219 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleSuiteParameter_in_entryRuleSuiteParameter2256 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteParameter2266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuiteParameter2314 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleSuiteParameter2326 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_ruleValue_in_ruleSuiteParameter2347 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter2383 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter2393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterName_in_ruleParameter2439 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleParameter2451 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_ruleParameter2472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterName_in_entryRuleParameterName2508 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterName2518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedParameterName_in_ruleParameterName2565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterName_in_ruleParameterName2592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedParameterName_in_entryRuleFixedParameterName2627 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFixedParameterName2637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFixedParameterName2681 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterName_in_entryRuleArbitraryParameterName2716 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArbitraryParameterName2726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleArbitraryParameterName2763 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleArbitraryParameterName2780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_entryRuleValueOrEnumValue2821 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueOrEnumValue2831 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_ruleValueOrEnumValue2878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumValue_in_ruleValueOrEnumValue2905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue2940 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue2950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringValue_in_ruleValue2997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerValue_in_ruleValue3024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalValue_in_ruleValue3051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleValue3078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerValue_in_entryRuleIntegerValue3113 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerValue3123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleIntegerValue3164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalValue_in_entryRuleDecimalValue3204 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalValue3214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DECIMAL_in_ruleDecimalValue3255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringValue_in_entryRuleStringValue3295 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringValue3305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringValue3346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable3386 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable3396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleVariable3443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumValue_in_entryRuleEnumValue3478 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumValue3488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UPPERCASE_ID_in_ruleEnumValue3532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodReference_in_entryRuleMethodReference3567 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodReference3577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_ruleMethodReference3625 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleMethodReference3637 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMethodReference3657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName3694 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName3705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName3745 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_35_in_ruleQualifiedName3764 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName3779 = new BitSet(new long[]{0x0000000800000002L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_entryRuleQualifiedJavaClassName3827 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedJavaClassName3838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedJavaClassName3885 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35_in_ruleQualifiedJavaClassName3903 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_UPPERCASE_ID_in_ruleQualifiedJavaClassName3918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard3964 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard3975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard4022 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_36_in_ruleQualifiedNameWithWildcard4041 = new BitSet(new long[]{0x0000000000000002L});

}