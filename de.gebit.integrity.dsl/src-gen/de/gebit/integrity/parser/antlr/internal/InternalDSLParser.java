package de.gebit.integrity.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.gebit.integrity.services.DSLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDSLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INTEGER", "RULE_DECIMAL", "RULE_STRING", "RULE_UPPERCASE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'packagedef'", "'with'", "'packageend'", "'import'", "'testdef'", "'uses'", "'calldef'", "'suitedef'", "'gets'", "'requires'", "'suiteend'", "'concludedby'", "'variable'", "'initially'", "'test'", "'='", "'tabletest'", "'|'", "'call'", "'sets'", "'suite'", "':'", "'+'", "'#'", "'.'", "'.*'"
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
    public String getGrammarFileName() { return "../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g"; }



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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:68:2: (iv_ruleModel= ruleModel EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:69:2: iv_ruleModel= ruleModel EOF
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:76:1: ruleModel returns [EObject current=null] : ( (lv_statements_0_0= ruleStatement ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_statements_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:79:28: ( ( (lv_statements_0_0= ruleStatement ) )* )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:80:1: ( (lv_statements_0_0= ruleStatement ) )*
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:80:1: ( (lv_statements_0_0= ruleStatement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==13||LA1_0==16||LA1_0==33) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:81:1: (lv_statements_0_0= ruleStatement )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:81:1: (lv_statements_0_0= ruleStatement )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:82:3: lv_statements_0_0= ruleStatement
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:106:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:107:2: (iv_ruleStatement= ruleStatement EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:108:2: iv_ruleStatement= ruleStatement EOF
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:115:1: ruleStatement returns [EObject current=null] : (this_PackageDefinition_0= rulePackageDefinition | this_Import_1= ruleImport | this_Suite_2= ruleSuite ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_PackageDefinition_0 = null;

        EObject this_Import_1 = null;

        EObject this_Suite_2 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:118:28: ( (this_PackageDefinition_0= rulePackageDefinition | this_Import_1= ruleImport | this_Suite_2= ruleSuite ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:119:1: (this_PackageDefinition_0= rulePackageDefinition | this_Import_1= ruleImport | this_Suite_2= ruleSuite )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:119:1: (this_PackageDefinition_0= rulePackageDefinition | this_Import_1= ruleImport | this_Suite_2= ruleSuite )
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
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:120:5: this_PackageDefinition_0= rulePackageDefinition
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
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:130:5: this_Import_1= ruleImport
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
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:140:5: this_Suite_2= ruleSuite
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:156:1: entryRulePackageDefinition returns [EObject current=null] : iv_rulePackageDefinition= rulePackageDefinition EOF ;
    public final EObject entryRulePackageDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:157:2: (iv_rulePackageDefinition= rulePackageDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:158:2: iv_rulePackageDefinition= rulePackageDefinition EOF
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:165:1: rulePackageDefinition returns [EObject current=null] : (otherlv_0= 'packagedef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'with' ( (lv_statements_3_0= rulePackageStatement ) )* otherlv_4= 'packageend' ) ;
    public final EObject rulePackageDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_statements_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:168:28: ( (otherlv_0= 'packagedef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'with' ( (lv_statements_3_0= rulePackageStatement ) )* otherlv_4= 'packageend' ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:169:1: (otherlv_0= 'packagedef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'with' ( (lv_statements_3_0= rulePackageStatement ) )* otherlv_4= 'packageend' )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:169:1: (otherlv_0= 'packagedef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'with' ( (lv_statements_3_0= rulePackageStatement ) )* otherlv_4= 'packageend' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:169:3: otherlv_0= 'packagedef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'with' ( (lv_statements_3_0= rulePackageStatement ) )* otherlv_4= 'packageend'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_13_in_rulePackageDefinition359); 

                	newLeafNode(otherlv_0, grammarAccess.getPackageDefinitionAccess().getPackagedefKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:173:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:174:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:174:1: (lv_name_1_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:175:3: lv_name_1_0= ruleQualifiedName
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
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:195:1: ( (lv_statements_3_0= rulePackageStatement ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=16 && LA3_0<=17)||(LA3_0>=19 && LA3_0<=20)||LA3_0==25) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:196:1: (lv_statements_3_0= rulePackageStatement )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:196:1: (lv_statements_3_0= rulePackageStatement )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:197:3: lv_statements_3_0= rulePackageStatement
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:225:1: entryRulePackageStatement returns [EObject current=null] : iv_rulePackageStatement= rulePackageStatement EOF ;
    public final EObject entryRulePackageStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageStatement = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:226:2: (iv_rulePackageStatement= rulePackageStatement EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:227:2: iv_rulePackageStatement= rulePackageStatement EOF
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:234:1: rulePackageStatement returns [EObject current=null] : (this_Import_0= ruleImport | this_TestDefinition_1= ruleTestDefinition | this_CallDefinition_2= ruleCallDefinition | this_SuiteDefinition_3= ruleSuiteDefinition | this_VariableDefinition_4= ruleVariableDefinition ) ;
    public final EObject rulePackageStatement() throws RecognitionException {
        EObject current = null;

        EObject this_Import_0 = null;

        EObject this_TestDefinition_1 = null;

        EObject this_CallDefinition_2 = null;

        EObject this_SuiteDefinition_3 = null;

        EObject this_VariableDefinition_4 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:237:28: ( (this_Import_0= ruleImport | this_TestDefinition_1= ruleTestDefinition | this_CallDefinition_2= ruleCallDefinition | this_SuiteDefinition_3= ruleSuiteDefinition | this_VariableDefinition_4= ruleVariableDefinition ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:238:1: (this_Import_0= ruleImport | this_TestDefinition_1= ruleTestDefinition | this_CallDefinition_2= ruleCallDefinition | this_SuiteDefinition_3= ruleSuiteDefinition | this_VariableDefinition_4= ruleVariableDefinition )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:238:1: (this_Import_0= ruleImport | this_TestDefinition_1= ruleTestDefinition | this_CallDefinition_2= ruleCallDefinition | this_SuiteDefinition_3= ruleSuiteDefinition | this_VariableDefinition_4= ruleVariableDefinition )
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
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:239:5: this_Import_0= ruleImport
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
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:249:5: this_TestDefinition_1= ruleTestDefinition
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
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:259:5: this_CallDefinition_2= ruleCallDefinition
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
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:269:5: this_SuiteDefinition_3= ruleSuiteDefinition
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
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:279:5: this_VariableDefinition_4= ruleVariableDefinition
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:295:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:296:2: (iv_ruleImport= ruleImport EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:297:2: iv_ruleImport= ruleImport EOF
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:304:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:307:28: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:308:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:308:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:308:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleImport709); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:312:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:313:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:313:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:314:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:338:1: entryRuleTestDefinition returns [EObject current=null] : iv_ruleTestDefinition= ruleTestDefinition EOF ;
    public final EObject entryRuleTestDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:339:2: (iv_ruleTestDefinition= ruleTestDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:340:2: iv_ruleTestDefinition= ruleTestDefinition EOF
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:347:1: ruleTestDefinition returns [EObject current=null] : (otherlv_0= 'testdef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) ) ;
    public final EObject ruleTestDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_fixtureMethod_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:350:28: ( (otherlv_0= 'testdef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:351:1: (otherlv_0= 'testdef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:351:1: (otherlv_0= 'testdef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:351:3: otherlv_0= 'testdef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleTestDefinition813); 

                	newLeafNode(otherlv_0, grammarAccess.getTestDefinitionAccess().getTestdefKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:355:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:356:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:356:1: (lv_name_1_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:357:3: lv_name_1_0= ruleQualifiedName
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
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:377:1: ( (lv_fixtureMethod_3_0= ruleMethodReference ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:378:1: (lv_fixtureMethod_3_0= ruleMethodReference )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:378:1: (lv_fixtureMethod_3_0= ruleMethodReference )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:379:3: lv_fixtureMethod_3_0= ruleMethodReference
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:403:1: entryRuleCallDefinition returns [EObject current=null] : iv_ruleCallDefinition= ruleCallDefinition EOF ;
    public final EObject entryRuleCallDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:404:2: (iv_ruleCallDefinition= ruleCallDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:405:2: iv_ruleCallDefinition= ruleCallDefinition EOF
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:412:1: ruleCallDefinition returns [EObject current=null] : (otherlv_0= 'calldef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) ) ;
    public final EObject ruleCallDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_fixtureMethod_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:415:28: ( (otherlv_0= 'calldef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:416:1: (otherlv_0= 'calldef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:416:1: (otherlv_0= 'calldef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:416:3: otherlv_0= 'calldef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) )
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleCallDefinition950); 

                	newLeafNode(otherlv_0, grammarAccess.getCallDefinitionAccess().getCalldefKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:420:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:421:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:421:1: (lv_name_1_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:422:3: lv_name_1_0= ruleQualifiedName
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
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:442:1: ( (lv_fixtureMethod_3_0= ruleMethodReference ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:443:1: (lv_fixtureMethod_3_0= ruleMethodReference )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:443:1: (lv_fixtureMethod_3_0= ruleMethodReference )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:444:3: lv_fixtureMethod_3_0= ruleMethodReference
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:468:1: entryRuleSuiteDefinition returns [EObject current=null] : iv_ruleSuiteDefinition= ruleSuiteDefinition EOF ;
    public final EObject entryRuleSuiteDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:469:2: (iv_ruleSuiteDefinition= ruleSuiteDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:470:2: iv_ruleSuiteDefinition= ruleSuiteDefinition EOF
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:477:1: ruleSuiteDefinition returns [EObject current=null] : (otherlv_0= 'suitedef' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )* )? (otherlv_4= 'requires' ( ( ruleQualifiedName ) )* )? otherlv_6= 'with' ( (lv_statements_7_0= ruleSuiteStatement ) )* otherlv_8= 'suiteend' (otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )* )? ) ;
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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:480:28: ( (otherlv_0= 'suitedef' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )* )? (otherlv_4= 'requires' ( ( ruleQualifiedName ) )* )? otherlv_6= 'with' ( (lv_statements_7_0= ruleSuiteStatement ) )* otherlv_8= 'suiteend' (otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )* )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:481:1: (otherlv_0= 'suitedef' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )* )? (otherlv_4= 'requires' ( ( ruleQualifiedName ) )* )? otherlv_6= 'with' ( (lv_statements_7_0= ruleSuiteStatement ) )* otherlv_8= 'suiteend' (otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )* )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:481:1: (otherlv_0= 'suitedef' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )* )? (otherlv_4= 'requires' ( ( ruleQualifiedName ) )* )? otherlv_6= 'with' ( (lv_statements_7_0= ruleSuiteStatement ) )* otherlv_8= 'suiteend' (otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )* )? )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:481:3: otherlv_0= 'suitedef' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )* )? (otherlv_4= 'requires' ( ( ruleQualifiedName ) )* )? otherlv_6= 'with' ( (lv_statements_7_0= ruleSuiteStatement ) )* otherlv_8= 'suiteend' (otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )* )?
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleSuiteDefinition1087); 

                	newLeafNode(otherlv_0, grammarAccess.getSuiteDefinitionAccess().getSuitedefKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:485:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:486:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:486:1: (lv_name_1_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:487:3: lv_name_1_0= ruleQualifiedName
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

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:503:2: (otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )* )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==21) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:503:4: otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )*
                    {
                    otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleSuiteDefinition1121); 

                        	newLeafNode(otherlv_2, grammarAccess.getSuiteDefinitionAccess().getGetsKeyword_2_0());
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:507:1: ( (lv_parameters_3_0= ruleVariableEntity ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==RULE_ID) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:508:1: (lv_parameters_3_0= ruleVariableEntity )
                    	    {
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:508:1: (lv_parameters_3_0= ruleVariableEntity )
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:509:3: lv_parameters_3_0= ruleVariableEntity
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

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:525:5: (otherlv_4= 'requires' ( ( ruleQualifiedName ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==22) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:525:7: otherlv_4= 'requires' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_4=(Token)match(input,22,FOLLOW_22_in_ruleSuiteDefinition1158); 

                        	newLeafNode(otherlv_4, grammarAccess.getSuiteDefinitionAccess().getRequiresKeyword_3_0());
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:529:1: ( ( ruleQualifiedName ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==RULE_ID) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:530:1: ( ruleQualifiedName )
                    	    {
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:530:1: ( ruleQualifiedName )
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:531:3: ruleQualifiedName
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
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:548:1: ( (lv_statements_7_0= ruleSuiteStatement ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==25||LA9_0==27||LA9_0==29||LA9_0==31||LA9_0==33) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:549:1: (lv_statements_7_0= ruleSuiteStatement )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:549:1: (lv_statements_7_0= ruleSuiteStatement )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:550:3: lv_statements_7_0= ruleSuiteStatement
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
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:570:1: (otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==24) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:570:3: otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_9=(Token)match(input,24,FOLLOW_24_in_ruleSuiteDefinition1243); 

                        	newLeafNode(otherlv_9, grammarAccess.getSuiteDefinitionAccess().getConcludedbyKeyword_7_0());
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:574:1: ( ( ruleQualifiedName ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==RULE_ID) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:575:1: ( ruleQualifiedName )
                    	    {
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:575:1: ( ruleQualifiedName )
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:576:3: ruleQualifiedName
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:597:1: entryRuleSuiteStatement returns [EObject current=null] : iv_ruleSuiteStatement= ruleSuiteStatement EOF ;
    public final EObject entryRuleSuiteStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteStatement = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:598:2: (iv_ruleSuiteStatement= ruleSuiteStatement EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:599:2: iv_ruleSuiteStatement= ruleSuiteStatement EOF
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:606:1: ruleSuiteStatement returns [EObject current=null] : (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_Call_1= ruleCall | this_VariableDefinition_2= ruleVariableDefinition ) ;
    public final EObject ruleSuiteStatement() throws RecognitionException {
        EObject current = null;

        EObject this_SuiteStatementWithResult_0 = null;

        EObject this_Call_1 = null;

        EObject this_VariableDefinition_2 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:609:28: ( (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_Call_1= ruleCall | this_VariableDefinition_2= ruleVariableDefinition ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:610:1: (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_Call_1= ruleCall | this_VariableDefinition_2= ruleVariableDefinition )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:610:1: (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_Call_1= ruleCall | this_VariableDefinition_2= ruleVariableDefinition )
            int alt12=3;
            switch ( input.LA(1) ) {
            case 27:
            case 29:
            case 33:
                {
                alt12=1;
                }
                break;
            case 31:
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
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:611:5: this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult
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
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:621:5: this_Call_1= ruleCall
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
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:631:5: this_VariableDefinition_2= ruleVariableDefinition
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:647:1: entryRuleSuiteStatementWithResult returns [EObject current=null] : iv_ruleSuiteStatementWithResult= ruleSuiteStatementWithResult EOF ;
    public final EObject entryRuleSuiteStatementWithResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteStatementWithResult = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:648:2: (iv_ruleSuiteStatementWithResult= ruleSuiteStatementWithResult EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:649:2: iv_ruleSuiteStatementWithResult= ruleSuiteStatementWithResult EOF
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:656:1: ruleSuiteStatementWithResult returns [EObject current=null] : (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest ) ;
    public final EObject ruleSuiteStatementWithResult() throws RecognitionException {
        EObject current = null;

        EObject this_Suite_0 = null;

        EObject this_Test_1 = null;

        EObject this_TableTest_2 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:659:28: ( (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:660:1: (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:660:1: (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest )
            int alt13=3;
            switch ( input.LA(1) ) {
            case 33:
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
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:661:5: this_Suite_0= ruleSuite
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
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:671:5: this_Test_1= ruleTest
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
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:681:5: this_TableTest_2= ruleTableTest
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:697:1: entryRuleVariableDefinition returns [EObject current=null] : iv_ruleVariableDefinition= ruleVariableDefinition EOF ;
    public final EObject entryRuleVariableDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:698:2: (iv_ruleVariableDefinition= ruleVariableDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:699:2: iv_ruleVariableDefinition= ruleVariableDefinition EOF
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:706:1: ruleVariableDefinition returns [EObject current=null] : (otherlv_0= 'variable' ( (lv_name_1_0= ruleVariableEntity ) ) (otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) ) )? ) ;
    public final EObject ruleVariableDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_name_1_0 = null;

        EObject lv_initialValue_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:709:28: ( (otherlv_0= 'variable' ( (lv_name_1_0= ruleVariableEntity ) ) (otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) ) )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:710:1: (otherlv_0= 'variable' ( (lv_name_1_0= ruleVariableEntity ) ) (otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) ) )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:710:1: (otherlv_0= 'variable' ( (lv_name_1_0= ruleVariableEntity ) ) (otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) ) )? )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:710:3: otherlv_0= 'variable' ( (lv_name_1_0= ruleVariableEntity ) ) (otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) ) )?
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleVariableDefinition1644); 

                	newLeafNode(otherlv_0, grammarAccess.getVariableDefinitionAccess().getVariableKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:714:1: ( (lv_name_1_0= ruleVariableEntity ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:715:1: (lv_name_1_0= ruleVariableEntity )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:715:1: (lv_name_1_0= ruleVariableEntity )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:716:3: lv_name_1_0= ruleVariableEntity
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

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:732:2: (otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==26) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:732:4: otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) )
                    {
                    otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleVariableDefinition1678); 

                        	newLeafNode(otherlv_2, grammarAccess.getVariableDefinitionAccess().getInitiallyKeyword_2_0());
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:736:1: ( (lv_initialValue_3_0= ruleValue ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:737:1: (lv_initialValue_3_0= ruleValue )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:737:1: (lv_initialValue_3_0= ruleValue )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:738:3: lv_initialValue_3_0= ruleValue
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:762:1: entryRuleVariableEntity returns [EObject current=null] : iv_ruleVariableEntity= ruleVariableEntity EOF ;
    public final EObject entryRuleVariableEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableEntity = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:763:2: (iv_ruleVariableEntity= ruleVariableEntity EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:764:2: iv_ruleVariableEntity= ruleVariableEntity EOF
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:771:1: ruleVariableEntity returns [EObject current=null] : ( (lv_name_0_0= ruleQualifiedName ) ) ;
    public final EObject ruleVariableEntity() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:774:28: ( ( (lv_name_0_0= ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:775:1: ( (lv_name_0_0= ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:775:1: ( (lv_name_0_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:776:1: (lv_name_0_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:776:1: (lv_name_0_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:777:3: lv_name_0_0= ruleQualifiedName
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:801:1: entryRuleTest returns [EObject current=null] : iv_ruleTest= ruleTest EOF ;
    public final EObject entryRuleTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTest = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:802:2: (iv_ruleTest= ruleTest EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:803:2: iv_ruleTest= ruleTest EOF
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:810:1: ruleTest returns [EObject current=null] : (otherlv_0= 'test' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_results_3_0= ruleNamedResult ) )* (otherlv_4= '=' ( (lv_result_5_0= ruleValueOrEnumValue ) ) )? ) ;
    public final EObject ruleTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject lv_parameters_2_0 = null;

        EObject lv_results_3_0 = null;

        EObject lv_result_5_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:813:28: ( (otherlv_0= 'test' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_results_3_0= ruleNamedResult ) )* (otherlv_4= '=' ( (lv_result_5_0= ruleValueOrEnumValue ) ) )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:814:1: (otherlv_0= 'test' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_results_3_0= ruleNamedResult ) )* (otherlv_4= '=' ( (lv_result_5_0= ruleValueOrEnumValue ) ) )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:814:1: (otherlv_0= 'test' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_results_3_0= ruleNamedResult ) )* (otherlv_4= '=' ( (lv_result_5_0= ruleValueOrEnumValue ) ) )? )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:814:3: otherlv_0= 'test' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_results_3_0= ruleNamedResult ) )* (otherlv_4= '=' ( (lv_result_5_0= ruleValueOrEnumValue ) ) )?
            {
            otherlv_0=(Token)match(input,27,FOLLOW_27_in_ruleTest1874); 

                	newLeafNode(otherlv_0, grammarAccess.getTestAccess().getTestKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:818:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:819:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:819:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:820:3: ruleQualifiedName
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

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:833:2: ( (lv_parameters_2_0= ruleParameter ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==RULE_ID) ) {
                    int LA15_1 = input.LA(2);

                    if ( (LA15_1==34) ) {
                        alt15=1;
                    }


                }
                else if ( (LA15_0==35) ) {
                    int LA15_2 = input.LA(2);

                    if ( (LA15_2==RULE_ID) ) {
                        int LA15_5 = input.LA(3);

                        if ( (LA15_5==34) ) {
                            alt15=1;
                        }


                    }


                }


                switch (alt15) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:834:1: (lv_parameters_2_0= ruleParameter )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:834:1: (lv_parameters_2_0= ruleParameter )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:835:3: lv_parameters_2_0= ruleParameter
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

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:851:3: ( (lv_results_3_0= ruleNamedResult ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID||LA16_0==35) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:852:1: (lv_results_3_0= ruleNamedResult )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:852:1: (lv_results_3_0= ruleNamedResult )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:853:3: lv_results_3_0= ruleNamedResult
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTestAccess().getResultsNamedResultParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleNamedResult_in_ruleTest1940);
            	    lv_results_3_0=ruleNamedResult();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"results",
            	            		lv_results_3_0, 
            	            		"NamedResult");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:869:3: (otherlv_4= '=' ( (lv_result_5_0= ruleValueOrEnumValue ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==28) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:869:5: otherlv_4= '=' ( (lv_result_5_0= ruleValueOrEnumValue ) )
                    {
                    otherlv_4=(Token)match(input,28,FOLLOW_28_in_ruleTest1954); 

                        	newLeafNode(otherlv_4, grammarAccess.getTestAccess().getEqualsSignKeyword_4_0());
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:873:1: ( (lv_result_5_0= ruleValueOrEnumValue ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:874:1: (lv_result_5_0= ruleValueOrEnumValue )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:874:1: (lv_result_5_0= ruleValueOrEnumValue )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:875:3: lv_result_5_0= ruleValueOrEnumValue
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:899:1: entryRuleTableTest returns [EObject current=null] : iv_ruleTableTest= ruleTableTest EOF ;
    public final EObject entryRuleTableTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTableTest = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:900:2: (iv_ruleTableTest= ruleTableTest EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:901:2: iv_ruleTableTest= ruleTableTest EOF
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:908:1: ruleTableTest returns [EObject current=null] : (otherlv_0= 'tabletest' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_parameterHeaders_3_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_4_0= ruleResultTableHeader ) )* ( (otherlv_5= '|' otherlv_6= '=' otherlv_7= '|' ) | otherlv_8= '|' ) ( (lv_rows_9_0= ruleTableTestRow ) )+ ) ;
    public final EObject ruleTableTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_parameters_2_0 = null;

        EObject lv_parameterHeaders_3_0 = null;

        EObject lv_resultHeaders_4_0 = null;

        EObject lv_rows_9_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:911:28: ( (otherlv_0= 'tabletest' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_parameterHeaders_3_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_4_0= ruleResultTableHeader ) )* ( (otherlv_5= '|' otherlv_6= '=' otherlv_7= '|' ) | otherlv_8= '|' ) ( (lv_rows_9_0= ruleTableTestRow ) )+ ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:912:1: (otherlv_0= 'tabletest' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_parameterHeaders_3_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_4_0= ruleResultTableHeader ) )* ( (otherlv_5= '|' otherlv_6= '=' otherlv_7= '|' ) | otherlv_8= '|' ) ( (lv_rows_9_0= ruleTableTestRow ) )+ )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:912:1: (otherlv_0= 'tabletest' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_parameterHeaders_3_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_4_0= ruleResultTableHeader ) )* ( (otherlv_5= '|' otherlv_6= '=' otherlv_7= '|' ) | otherlv_8= '|' ) ( (lv_rows_9_0= ruleTableTestRow ) )+ )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:912:3: otherlv_0= 'tabletest' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_parameterHeaders_3_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_4_0= ruleResultTableHeader ) )* ( (otherlv_5= '|' otherlv_6= '=' otherlv_7= '|' ) | otherlv_8= '|' ) ( (lv_rows_9_0= ruleTableTestRow ) )+
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleTableTest2060); 

                	newLeafNode(otherlv_0, grammarAccess.getTableTestAccess().getTabletestKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:916:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:917:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:917:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:918:3: ruleQualifiedName
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

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:931:2: ( (lv_parameters_2_0= ruleParameter ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID||LA18_0==35) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:932:1: (lv_parameters_2_0= ruleParameter )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:932:1: (lv_parameters_2_0= ruleParameter )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:933:3: lv_parameters_2_0= ruleParameter
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

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:949:3: ( (lv_parameterHeaders_3_0= ruleParameterTableHeader ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==30) ) {
                    int LA19_1 = input.LA(2);

                    if ( (LA19_1==RULE_ID) ) {
                        int LA19_2 = input.LA(3);

                        if ( (LA19_2==30) ) {
                            alt19=1;
                        }


                    }
                    else if ( (LA19_1==35) ) {
                        int LA19_3 = input.LA(3);

                        if ( (LA19_3==RULE_ID) ) {
                            int LA19_6 = input.LA(4);

                            if ( (LA19_6==30) ) {
                                alt19=1;
                            }


                        }


                    }


                }


                switch (alt19) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:950:1: (lv_parameterHeaders_3_0= ruleParameterTableHeader )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:950:1: (lv_parameterHeaders_3_0= ruleParameterTableHeader )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:951:3: lv_parameterHeaders_3_0= ruleParameterTableHeader
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getParameterHeadersParameterTableHeaderParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameterTableHeader_in_ruleTableTest2126);
            	    lv_parameterHeaders_3_0=ruleParameterTableHeader();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTableTestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"parameterHeaders",
            	            		lv_parameterHeaders_3_0, 
            	            		"ParameterTableHeader");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:967:3: ( (lv_resultHeaders_4_0= ruleResultTableHeader ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==30) ) {
                    int LA20_1 = input.LA(2);

                    if ( (LA20_1==RULE_ID||LA20_1==35) ) {
                        alt20=1;
                    }


                }


                switch (alt20) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:968:1: (lv_resultHeaders_4_0= ruleResultTableHeader )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:968:1: (lv_resultHeaders_4_0= ruleResultTableHeader )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:969:3: lv_resultHeaders_4_0= ruleResultTableHeader
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getResultHeadersResultTableHeaderParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleResultTableHeader_in_ruleTableTest2148);
            	    lv_resultHeaders_4_0=ruleResultTableHeader();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTableTestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"resultHeaders",
            	            		lv_resultHeaders_4_0, 
            	            		"ResultTableHeader");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:985:3: ( (otherlv_5= '|' otherlv_6= '=' otherlv_7= '|' ) | otherlv_8= '|' )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==30) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==30) ) {
                    alt21=2;
                }
                else if ( (LA21_1==28) ) {
                    alt21=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 21, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:985:4: (otherlv_5= '|' otherlv_6= '=' otherlv_7= '|' )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:985:4: (otherlv_5= '|' otherlv_6= '=' otherlv_7= '|' )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:985:6: otherlv_5= '|' otherlv_6= '=' otherlv_7= '|'
                    {
                    otherlv_5=(Token)match(input,30,FOLLOW_30_in_ruleTableTest2163); 

                        	newLeafNode(otherlv_5, grammarAccess.getTableTestAccess().getVerticalLineKeyword_5_0_0());
                        
                    otherlv_6=(Token)match(input,28,FOLLOW_28_in_ruleTableTest2175); 

                        	newLeafNode(otherlv_6, grammarAccess.getTableTestAccess().getEqualsSignKeyword_5_0_1());
                        
                    otherlv_7=(Token)match(input,30,FOLLOW_30_in_ruleTableTest2187); 

                        	newLeafNode(otherlv_7, grammarAccess.getTableTestAccess().getVerticalLineKeyword_5_0_2());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:998:7: otherlv_8= '|'
                    {
                    otherlv_8=(Token)match(input,30,FOLLOW_30_in_ruleTableTest2206); 

                        	newLeafNode(otherlv_8, grammarAccess.getTableTestAccess().getVerticalLineKeyword_5_1());
                        

                    }
                    break;

            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1002:2: ( (lv_rows_9_0= ruleTableTestRow ) )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==30) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1003:1: (lv_rows_9_0= ruleTableTestRow )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1003:1: (lv_rows_9_0= ruleTableTestRow )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1004:3: lv_rows_9_0= ruleTableTestRow
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getRowsTableTestRowParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTableTestRow_in_ruleTableTest2228);
            	    lv_rows_9_0=ruleTableTestRow();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTableTestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"rows",
            	            		lv_rows_9_0, 
            	            		"TableTestRow");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt22 >= 1 ) break loop22;
                        EarlyExitException eee =
                            new EarlyExitException(22, input);
                        throw eee;
                }
                cnt22++;
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1028:1: entryRuleTableTestRow returns [EObject current=null] : iv_ruleTableTestRow= ruleTableTestRow EOF ;
    public final EObject entryRuleTableTestRow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTableTestRow = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1029:2: (iv_ruleTableTestRow= ruleTableTestRow EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1030:2: iv_ruleTableTestRow= ruleTableTestRow EOF
            {
             newCompositeNode(grammarAccess.getTableTestRowRule()); 
            pushFollow(FOLLOW_ruleTableTestRow_in_entryRuleTableTestRow2265);
            iv_ruleTableTestRow=ruleTableTestRow();

            state._fsp--;

             current =iv_ruleTableTestRow; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTableTestRow2275); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1037:1: ruleTableTestRow returns [EObject current=null] : ( () ( (lv_values_1_0= ruleParameterTableValue ) )* ( (otherlv_2= '|' otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) otherlv_5= '|' ) | otherlv_6= '|' ) ) ;
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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1040:28: ( ( () ( (lv_values_1_0= ruleParameterTableValue ) )* ( (otherlv_2= '|' otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) otherlv_5= '|' ) | otherlv_6= '|' ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1041:1: ( () ( (lv_values_1_0= ruleParameterTableValue ) )* ( (otherlv_2= '|' otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) otherlv_5= '|' ) | otherlv_6= '|' ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1041:1: ( () ( (lv_values_1_0= ruleParameterTableValue ) )* ( (otherlv_2= '|' otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) otherlv_5= '|' ) | otherlv_6= '|' ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1041:2: () ( (lv_values_1_0= ruleParameterTableValue ) )* ( (otherlv_2= '|' otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) otherlv_5= '|' ) | otherlv_6= '|' )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1041:2: ()
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1042:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTableTestRowAccess().getTableTestRowAction_0(),
                        current);
                

            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1047:2: ( (lv_values_1_0= ruleParameterTableValue ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==30) ) {
                    int LA23_1 = input.LA(2);

                    if ( ((LA23_1>=RULE_ID && LA23_1<=RULE_UPPERCASE_ID)) ) {
                        alt23=1;
                    }


                }


                switch (alt23) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1048:1: (lv_values_1_0= ruleParameterTableValue )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1048:1: (lv_values_1_0= ruleParameterTableValue )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1049:3: lv_values_1_0= ruleParameterTableValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestRowAccess().getValuesParameterTableValueParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameterTableValue_in_ruleTableTestRow2330);
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
            	    break loop23;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1065:3: ( (otherlv_2= '|' otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) otherlv_5= '|' ) | otherlv_6= '|' )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==30) ) {
                int LA24_1 = input.LA(2);

                if ( (LA24_1==EOF||LA24_1==23||LA24_1==25||LA24_1==27||(LA24_1>=29 && LA24_1<=31)||LA24_1==33) ) {
                    alt24=2;
                }
                else if ( (LA24_1==28) ) {
                    alt24=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 24, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1065:4: (otherlv_2= '|' otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) otherlv_5= '|' )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1065:4: (otherlv_2= '|' otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) otherlv_5= '|' )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1065:6: otherlv_2= '|' otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) otherlv_5= '|'
                    {
                    otherlv_2=(Token)match(input,30,FOLLOW_30_in_ruleTableTestRow2345); 

                        	newLeafNode(otherlv_2, grammarAccess.getTableTestRowAccess().getVerticalLineKeyword_2_0_0());
                        
                    otherlv_3=(Token)match(input,28,FOLLOW_28_in_ruleTableTestRow2357); 

                        	newLeafNode(otherlv_3, grammarAccess.getTableTestRowAccess().getEqualsSignKeyword_2_0_1());
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1073:1: ( (lv_result_4_0= ruleValueOrEnumValue ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1074:1: (lv_result_4_0= ruleValueOrEnumValue )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1074:1: (lv_result_4_0= ruleValueOrEnumValue )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1075:3: lv_result_4_0= ruleValueOrEnumValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getTableTestRowAccess().getResultValueOrEnumValueParserRuleCall_2_0_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueOrEnumValue_in_ruleTableTestRow2378);
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

                    otherlv_5=(Token)match(input,30,FOLLOW_30_in_ruleTableTestRow2390); 

                        	newLeafNode(otherlv_5, grammarAccess.getTableTestRowAccess().getVerticalLineKeyword_2_0_3());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1096:7: otherlv_6= '|'
                    {
                    otherlv_6=(Token)match(input,30,FOLLOW_30_in_ruleTableTestRow2409); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1108:1: entryRuleParameterTableHeader returns [EObject current=null] : iv_ruleParameterTableHeader= ruleParameterTableHeader EOF ;
    public final EObject entryRuleParameterTableHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterTableHeader = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1109:2: (iv_ruleParameterTableHeader= ruleParameterTableHeader EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1110:2: iv_ruleParameterTableHeader= ruleParameterTableHeader EOF
            {
             newCompositeNode(grammarAccess.getParameterTableHeaderRule()); 
            pushFollow(FOLLOW_ruleParameterTableHeader_in_entryRuleParameterTableHeader2446);
            iv_ruleParameterTableHeader=ruleParameterTableHeader();

            state._fsp--;

             current =iv_ruleParameterTableHeader; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterTableHeader2456); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1117:1: ruleParameterTableHeader returns [EObject current=null] : (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) ) ;
    public final EObject ruleParameterTableHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1120:28: ( (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1121:1: (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1121:1: (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1121:3: otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleParameterTableHeader2493); 

                	newLeafNode(otherlv_0, grammarAccess.getParameterTableHeaderAccess().getVerticalLineKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1125:1: ( (lv_name_1_0= ruleParameterName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1126:1: (lv_name_1_0= ruleParameterName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1126:1: (lv_name_1_0= ruleParameterName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1127:3: lv_name_1_0= ruleParameterName
            {
             
            	        newCompositeNode(grammarAccess.getParameterTableHeaderAccess().getNameParameterNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleParameterName_in_ruleParameterTableHeader2514);
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


    // $ANTLR start "entryRuleResultTableHeader"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1151:1: entryRuleResultTableHeader returns [EObject current=null] : iv_ruleResultTableHeader= ruleResultTableHeader EOF ;
    public final EObject entryRuleResultTableHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultTableHeader = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1152:2: (iv_ruleResultTableHeader= ruleResultTableHeader EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1153:2: iv_ruleResultTableHeader= ruleResultTableHeader EOF
            {
             newCompositeNode(grammarAccess.getResultTableHeaderRule()); 
            pushFollow(FOLLOW_ruleResultTableHeader_in_entryRuleResultTableHeader2550);
            iv_ruleResultTableHeader=ruleResultTableHeader();

            state._fsp--;

             current =iv_ruleResultTableHeader; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultTableHeader2560); 

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
    // $ANTLR end "entryRuleResultTableHeader"


    // $ANTLR start "ruleResultTableHeader"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1160:1: ruleResultTableHeader returns [EObject current=null] : (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' ) ;
    public final EObject ruleResultTableHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1163:28: ( (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1164:1: (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1164:1: (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1164:3: otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '='
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleResultTableHeader2597); 

                	newLeafNode(otherlv_0, grammarAccess.getResultTableHeaderAccess().getVerticalLineKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1168:1: ( (lv_name_1_0= ruleResultName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1169:1: (lv_name_1_0= ruleResultName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1169:1: (lv_name_1_0= ruleResultName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1170:3: lv_name_1_0= ruleResultName
            {
             
            	        newCompositeNode(grammarAccess.getResultTableHeaderAccess().getNameResultNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleResultName_in_ruleResultTableHeader2618);
            lv_name_1_0=ruleResultName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getResultTableHeaderRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"ResultName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleResultTableHeader2630); 

                	newLeafNode(otherlv_2, grammarAccess.getResultTableHeaderAccess().getEqualsSignKeyword_2());
                

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
    // $ANTLR end "ruleResultTableHeader"


    // $ANTLR start "entryRuleParameterTableValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1198:1: entryRuleParameterTableValue returns [EObject current=null] : iv_ruleParameterTableValue= ruleParameterTableValue EOF ;
    public final EObject entryRuleParameterTableValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterTableValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1199:2: (iv_ruleParameterTableValue= ruleParameterTableValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1200:2: iv_ruleParameterTableValue= ruleParameterTableValue EOF
            {
             newCompositeNode(grammarAccess.getParameterTableValueRule()); 
            pushFollow(FOLLOW_ruleParameterTableValue_in_entryRuleParameterTableValue2666);
            iv_ruleParameterTableValue=ruleParameterTableValue();

            state._fsp--;

             current =iv_ruleParameterTableValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterTableValue2676); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1207:1: ruleParameterTableValue returns [EObject current=null] : (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValue ) ) ) ;
    public final EObject ruleParameterTableValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1210:28: ( (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValue ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1211:1: (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValue ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1211:1: (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValue ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1211:3: otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValue ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleParameterTableValue2713); 

                	newLeafNode(otherlv_0, grammarAccess.getParameterTableValueAccess().getVerticalLineKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1215:1: ( (lv_value_1_0= ruleValueOrEnumValue ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1216:1: (lv_value_1_0= ruleValueOrEnumValue )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1216:1: (lv_value_1_0= ruleValueOrEnumValue )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1217:3: lv_value_1_0= ruleValueOrEnumValue
            {
             
            	        newCompositeNode(grammarAccess.getParameterTableValueAccess().getValueValueOrEnumValueParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_ruleParameterTableValue2734);
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


    // $ANTLR start "entryRuleNamedResult"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1241:1: entryRuleNamedResult returns [EObject current=null] : iv_ruleNamedResult= ruleNamedResult EOF ;
    public final EObject entryRuleNamedResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedResult = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1242:2: (iv_ruleNamedResult= ruleNamedResult EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1243:2: iv_ruleNamedResult= ruleNamedResult EOF
            {
             newCompositeNode(grammarAccess.getNamedResultRule()); 
            pushFollow(FOLLOW_ruleNamedResult_in_entryRuleNamedResult2770);
            iv_ruleNamedResult=ruleNamedResult();

            state._fsp--;

             current =iv_ruleNamedResult; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedResult2780); 

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
    // $ANTLR end "entryRuleNamedResult"


    // $ANTLR start "ruleNamedResult"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1250:1: ruleNamedResult returns [EObject current=null] : ( ( (lv_name_0_0= ruleResultName ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValueOrEnumValue ) ) ) ;
    public final EObject ruleNamedResult() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1253:28: ( ( ( (lv_name_0_0= ruleResultName ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValueOrEnumValue ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1254:1: ( ( (lv_name_0_0= ruleResultName ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValueOrEnumValue ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1254:1: ( ( (lv_name_0_0= ruleResultName ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValueOrEnumValue ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1254:2: ( (lv_name_0_0= ruleResultName ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValueOrEnumValue ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1254:2: ( (lv_name_0_0= ruleResultName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1255:1: (lv_name_0_0= ruleResultName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1255:1: (lv_name_0_0= ruleResultName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1256:3: lv_name_0_0= ruleResultName
            {
             
            	        newCompositeNode(grammarAccess.getNamedResultAccess().getNameResultNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleResultName_in_ruleNamedResult2826);
            lv_name_0_0=ruleResultName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNamedResultRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ResultName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleNamedResult2838); 

                	newLeafNode(otherlv_1, grammarAccess.getNamedResultAccess().getEqualsSignKeyword_1());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1276:1: ( (lv_value_2_0= ruleValueOrEnumValue ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1277:1: (lv_value_2_0= ruleValueOrEnumValue )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1277:1: (lv_value_2_0= ruleValueOrEnumValue )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1278:3: lv_value_2_0= ruleValueOrEnumValue
            {
             
            	        newCompositeNode(grammarAccess.getNamedResultAccess().getValueValueOrEnumValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_ruleNamedResult2859);
            lv_value_2_0=ruleValueOrEnumValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNamedResultRule());
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
    // $ANTLR end "ruleNamedResult"


    // $ANTLR start "entryRuleResultName"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1302:1: entryRuleResultName returns [EObject current=null] : iv_ruleResultName= ruleResultName EOF ;
    public final EObject entryRuleResultName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1303:2: (iv_ruleResultName= ruleResultName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1304:2: iv_ruleResultName= ruleResultName EOF
            {
             newCompositeNode(grammarAccess.getResultNameRule()); 
            pushFollow(FOLLOW_ruleResultName_in_entryRuleResultName2895);
            iv_ruleResultName=ruleResultName();

            state._fsp--;

             current =iv_ruleResultName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultName2905); 

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
    // $ANTLR end "entryRuleResultName"


    // $ANTLR start "ruleResultName"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1311:1: ruleResultName returns [EObject current=null] : (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) ;
    public final EObject ruleResultName() throws RecognitionException {
        EObject current = null;

        EObject this_FixedResultName_0 = null;

        EObject this_ArbitraryParameterOrResultName_1 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1314:28: ( (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1315:1: (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1315:1: (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                alt25=1;
            }
            else if ( (LA25_0==35) ) {
                alt25=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1316:5: this_FixedResultName_0= ruleFixedResultName
                    {
                     
                            newCompositeNode(grammarAccess.getResultNameAccess().getFixedResultNameParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleFixedResultName_in_ruleResultName2952);
                    this_FixedResultName_0=ruleFixedResultName();

                    state._fsp--;

                     
                            current = this_FixedResultName_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1326:5: this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName
                    {
                     
                            newCompositeNode(grammarAccess.getResultNameAccess().getArbitraryParameterOrResultNameParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleArbitraryParameterOrResultName_in_ruleResultName2979);
                    this_ArbitraryParameterOrResultName_1=ruleArbitraryParameterOrResultName();

                    state._fsp--;

                     
                            current = this_ArbitraryParameterOrResultName_1; 
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
    // $ANTLR end "ruleResultName"


    // $ANTLR start "entryRuleFixedResultName"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1342:1: entryRuleFixedResultName returns [EObject current=null] : iv_ruleFixedResultName= ruleFixedResultName EOF ;
    public final EObject entryRuleFixedResultName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedResultName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1343:2: (iv_ruleFixedResultName= ruleFixedResultName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1344:2: iv_ruleFixedResultName= ruleFixedResultName EOF
            {
             newCompositeNode(grammarAccess.getFixedResultNameRule()); 
            pushFollow(FOLLOW_ruleFixedResultName_in_entryRuleFixedResultName3014);
            iv_ruleFixedResultName=ruleFixedResultName();

            state._fsp--;

             current =iv_ruleFixedResultName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFixedResultName3024); 

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
    // $ANTLR end "entryRuleFixedResultName"


    // $ANTLR start "ruleFixedResultName"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1351:1: ruleFixedResultName returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleFixedResultName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1354:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1355:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1355:1: ( (otherlv_0= RULE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1356:1: (otherlv_0= RULE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1356:1: (otherlv_0= RULE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1357:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFixedResultNameRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFixedResultName3068); 

            		newLeafNode(otherlv_0, grammarAccess.getFixedResultNameAccess().getFieldJvmFieldCrossReference_0()); 
            	

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
    // $ANTLR end "ruleFixedResultName"


    // $ANTLR start "entryRuleCall"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1376:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1377:2: (iv_ruleCall= ruleCall EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1378:2: iv_ruleCall= ruleCall EOF
            {
             newCompositeNode(grammarAccess.getCallRule()); 
            pushFollow(FOLLOW_ruleCall_in_entryRuleCall3103);
            iv_ruleCall=ruleCall();

            state._fsp--;

             current =iv_ruleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCall3113); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1385:1: ruleCall returns [EObject current=null] : (otherlv_0= 'call' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* (otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) ) )? ) ;
    public final EObject ruleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_parameters_2_0 = null;

        EObject lv_result_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1388:28: ( (otherlv_0= 'call' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* (otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) ) )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1389:1: (otherlv_0= 'call' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* (otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) ) )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1389:1: (otherlv_0= 'call' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* (otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) ) )? )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1389:3: otherlv_0= 'call' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* (otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) ) )?
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleCall3150); 

                	newLeafNode(otherlv_0, grammarAccess.getCallAccess().getCallKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1393:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1394:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1394:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1395:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCallRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getCallAccess().getDefinitionCallDefinitionCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleCall3173);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1408:2: ( (lv_parameters_2_0= ruleParameter ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==RULE_ID||LA26_0==35) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1409:1: (lv_parameters_2_0= ruleParameter )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1409:1: (lv_parameters_2_0= ruleParameter )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1410:3: lv_parameters_2_0= ruleParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCallAccess().getParametersParameterParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameter_in_ruleCall3194);
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
            	    break loop26;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1426:3: (otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==32) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1426:5: otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) )
                    {
                    otherlv_3=(Token)match(input,32,FOLLOW_32_in_ruleCall3208); 

                        	newLeafNode(otherlv_3, grammarAccess.getCallAccess().getSetsKeyword_3_0());
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1430:1: ( (lv_result_4_0= ruleVariable ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1431:1: (lv_result_4_0= ruleVariable )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1431:1: (lv_result_4_0= ruleVariable )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1432:3: lv_result_4_0= ruleVariable
                    {
                     
                    	        newCompositeNode(grammarAccess.getCallAccess().getResultVariableParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVariable_in_ruleCall3229);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1456:1: entryRuleSuite returns [EObject current=null] : iv_ruleSuite= ruleSuite EOF ;
    public final EObject entryRuleSuite() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuite = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1457:2: (iv_ruleSuite= ruleSuite EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1458:2: iv_ruleSuite= ruleSuite EOF
            {
             newCompositeNode(grammarAccess.getSuiteRule()); 
            pushFollow(FOLLOW_ruleSuite_in_entryRuleSuite3267);
            iv_ruleSuite=ruleSuite();

            state._fsp--;

             current =iv_ruleSuite; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuite3277); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1465:1: ruleSuite returns [EObject current=null] : (otherlv_0= 'suite' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleSuiteParameter ) )* ) ;
    public final EObject ruleSuite() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_parameters_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1468:28: ( (otherlv_0= 'suite' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleSuiteParameter ) )* ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1469:1: (otherlv_0= 'suite' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleSuiteParameter ) )* )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1469:1: (otherlv_0= 'suite' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleSuiteParameter ) )* )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1469:3: otherlv_0= 'suite' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleSuiteParameter ) )*
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_ruleSuite3314); 

                	newLeafNode(otherlv_0, grammarAccess.getSuiteAccess().getSuiteKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1473:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1474:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1474:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1475:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSuiteRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSuiteAccess().getDefinitionSuiteDefinitionCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuite3337);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1488:2: ( (lv_parameters_2_0= ruleSuiteParameter ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_ID) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1489:1: (lv_parameters_2_0= ruleSuiteParameter )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1489:1: (lv_parameters_2_0= ruleSuiteParameter )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1490:3: lv_parameters_2_0= ruleSuiteParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSuiteAccess().getParametersSuiteParameterParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSuiteParameter_in_ruleSuite3358);
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
            	    break loop28;
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1514:1: entryRuleSuiteParameter returns [EObject current=null] : iv_ruleSuiteParameter= ruleSuiteParameter EOF ;
    public final EObject entryRuleSuiteParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteParameter = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1515:2: (iv_ruleSuiteParameter= ruleSuiteParameter EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1516:2: iv_ruleSuiteParameter= ruleSuiteParameter EOF
            {
             newCompositeNode(grammarAccess.getSuiteParameterRule()); 
            pushFollow(FOLLOW_ruleSuiteParameter_in_entryRuleSuiteParameter3395);
            iv_ruleSuiteParameter=ruleSuiteParameter();

            state._fsp--;

             current =iv_ruleSuiteParameter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteParameter3405); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1523:1: ruleSuiteParameter returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValue ) ) ) ;
    public final EObject ruleSuiteParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1526:28: ( ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValue ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1527:1: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValue ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1527:1: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValue ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1527:2: ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValue ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1527:2: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1528:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1528:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1529:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSuiteParameterRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSuiteParameterAccess().getNameVariableEntityCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuiteParameter3453);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleSuiteParameter3465); 

                	newLeafNode(otherlv_1, grammarAccess.getSuiteParameterAccess().getColonKeyword_1());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1546:1: ( (lv_value_2_0= ruleValue ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1547:1: (lv_value_2_0= ruleValue )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1547:1: (lv_value_2_0= ruleValue )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1548:3: lv_value_2_0= ruleValue
            {
             
            	        newCompositeNode(grammarAccess.getSuiteParameterAccess().getValueValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleValue_in_ruleSuiteParameter3486);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1572:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1573:2: (iv_ruleParameter= ruleParameter EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1574:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter3522);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter3532); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1581:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= ruleParameterName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValueOrEnumValue ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1584:28: ( ( ( (lv_name_0_0= ruleParameterName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValueOrEnumValue ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1585:1: ( ( (lv_name_0_0= ruleParameterName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValueOrEnumValue ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1585:1: ( ( (lv_name_0_0= ruleParameterName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValueOrEnumValue ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1585:2: ( (lv_name_0_0= ruleParameterName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValueOrEnumValue ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1585:2: ( (lv_name_0_0= ruleParameterName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1586:1: (lv_name_0_0= ruleParameterName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1586:1: (lv_name_0_0= ruleParameterName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1587:3: lv_name_0_0= ruleParameterName
            {
             
            	        newCompositeNode(grammarAccess.getParameterAccess().getNameParameterNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleParameterName_in_ruleParameter3578);
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

            otherlv_1=(Token)match(input,34,FOLLOW_34_in_ruleParameter3590); 

                	newLeafNode(otherlv_1, grammarAccess.getParameterAccess().getColonKeyword_1());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1607:1: ( (lv_value_2_0= ruleValueOrEnumValue ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1608:1: (lv_value_2_0= ruleValueOrEnumValue )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1608:1: (lv_value_2_0= ruleValueOrEnumValue )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1609:3: lv_value_2_0= ruleValueOrEnumValue
            {
             
            	        newCompositeNode(grammarAccess.getParameterAccess().getValueValueOrEnumValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_ruleParameter3611);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1633:1: entryRuleParameterName returns [EObject current=null] : iv_ruleParameterName= ruleParameterName EOF ;
    public final EObject entryRuleParameterName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1634:2: (iv_ruleParameterName= ruleParameterName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1635:2: iv_ruleParameterName= ruleParameterName EOF
            {
             newCompositeNode(grammarAccess.getParameterNameRule()); 
            pushFollow(FOLLOW_ruleParameterName_in_entryRuleParameterName3647);
            iv_ruleParameterName=ruleParameterName();

            state._fsp--;

             current =iv_ruleParameterName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterName3657); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1642:1: ruleParameterName returns [EObject current=null] : (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) ;
    public final EObject ruleParameterName() throws RecognitionException {
        EObject current = null;

        EObject this_FixedParameterName_0 = null;

        EObject this_ArbitraryParameterOrResultName_1 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1645:28: ( (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1646:1: (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1646:1: (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_ID) ) {
                alt29=1;
            }
            else if ( (LA29_0==35) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1647:5: this_FixedParameterName_0= ruleFixedParameterName
                    {
                     
                            newCompositeNode(grammarAccess.getParameterNameAccess().getFixedParameterNameParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleFixedParameterName_in_ruleParameterName3704);
                    this_FixedParameterName_0=ruleFixedParameterName();

                    state._fsp--;

                     
                            current = this_FixedParameterName_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1657:5: this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName
                    {
                     
                            newCompositeNode(grammarAccess.getParameterNameAccess().getArbitraryParameterOrResultNameParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleArbitraryParameterOrResultName_in_ruleParameterName3731);
                    this_ArbitraryParameterOrResultName_1=ruleArbitraryParameterOrResultName();

                    state._fsp--;

                     
                            current = this_ArbitraryParameterOrResultName_1; 
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1673:1: entryRuleFixedParameterName returns [EObject current=null] : iv_ruleFixedParameterName= ruleFixedParameterName EOF ;
    public final EObject entryRuleFixedParameterName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedParameterName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1674:2: (iv_ruleFixedParameterName= ruleFixedParameterName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1675:2: iv_ruleFixedParameterName= ruleFixedParameterName EOF
            {
             newCompositeNode(grammarAccess.getFixedParameterNameRule()); 
            pushFollow(FOLLOW_ruleFixedParameterName_in_entryRuleFixedParameterName3766);
            iv_ruleFixedParameterName=ruleFixedParameterName();

            state._fsp--;

             current =iv_ruleFixedParameterName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFixedParameterName3776); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1682:1: ruleFixedParameterName returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleFixedParameterName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1685:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1686:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1686:1: ( (otherlv_0= RULE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1687:1: (otherlv_0= RULE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1687:1: (otherlv_0= RULE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1688:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFixedParameterNameRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFixedParameterName3820); 

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


    // $ANTLR start "entryRuleArbitraryParameterOrResultName"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1707:1: entryRuleArbitraryParameterOrResultName returns [EObject current=null] : iv_ruleArbitraryParameterOrResultName= ruleArbitraryParameterOrResultName EOF ;
    public final EObject entryRuleArbitraryParameterOrResultName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArbitraryParameterOrResultName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1708:2: (iv_ruleArbitraryParameterOrResultName= ruleArbitraryParameterOrResultName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1709:2: iv_ruleArbitraryParameterOrResultName= ruleArbitraryParameterOrResultName EOF
            {
             newCompositeNode(grammarAccess.getArbitraryParameterOrResultNameRule()); 
            pushFollow(FOLLOW_ruleArbitraryParameterOrResultName_in_entryRuleArbitraryParameterOrResultName3855);
            iv_ruleArbitraryParameterOrResultName=ruleArbitraryParameterOrResultName();

            state._fsp--;

             current =iv_ruleArbitraryParameterOrResultName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArbitraryParameterOrResultName3865); 

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
    // $ANTLR end "entryRuleArbitraryParameterOrResultName"


    // $ANTLR start "ruleArbitraryParameterOrResultName"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1716:1: ruleArbitraryParameterOrResultName returns [EObject current=null] : (otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) ) ) ;
    public final EObject ruleArbitraryParameterOrResultName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_identifier_1_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1719:28: ( (otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1720:1: (otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1720:1: (otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1720:3: otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleArbitraryParameterOrResultName3902); 

                	newLeafNode(otherlv_0, grammarAccess.getArbitraryParameterOrResultNameAccess().getPlusSignKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1724:1: ( (lv_identifier_1_0= RULE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1725:1: (lv_identifier_1_0= RULE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1725:1: (lv_identifier_1_0= RULE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1726:3: lv_identifier_1_0= RULE_ID
            {
            lv_identifier_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleArbitraryParameterOrResultName3919); 

            			newLeafNode(lv_identifier_1_0, grammarAccess.getArbitraryParameterOrResultNameAccess().getIdentifierIDTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getArbitraryParameterOrResultNameRule());
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
    // $ANTLR end "ruleArbitraryParameterOrResultName"


    // $ANTLR start "entryRuleValueOrEnumValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1750:1: entryRuleValueOrEnumValue returns [EObject current=null] : iv_ruleValueOrEnumValue= ruleValueOrEnumValue EOF ;
    public final EObject entryRuleValueOrEnumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueOrEnumValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1751:2: (iv_ruleValueOrEnumValue= ruleValueOrEnumValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1752:2: iv_ruleValueOrEnumValue= ruleValueOrEnumValue EOF
            {
             newCompositeNode(grammarAccess.getValueOrEnumValueRule()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_entryRuleValueOrEnumValue3960);
            iv_ruleValueOrEnumValue=ruleValueOrEnumValue();

            state._fsp--;

             current =iv_ruleValueOrEnumValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueOrEnumValue3970); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1759:1: ruleValueOrEnumValue returns [EObject current=null] : (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue ) ;
    public final EObject ruleValueOrEnumValue() throws RecognitionException {
        EObject current = null;

        EObject this_Value_0 = null;

        EObject this_EnumValue_1 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1762:28: ( (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1763:1: (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1763:1: (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue )
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=RULE_ID && LA30_0<=RULE_STRING)) ) {
                alt30=1;
            }
            else if ( (LA30_0==RULE_UPPERCASE_ID) ) {
                alt30=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }
            switch (alt30) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1764:5: this_Value_0= ruleValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueOrEnumValueAccess().getValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleValue_in_ruleValueOrEnumValue4017);
                    this_Value_0=ruleValue();

                    state._fsp--;

                     
                            current = this_Value_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1774:5: this_EnumValue_1= ruleEnumValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueOrEnumValueAccess().getEnumValueParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEnumValue_in_ruleValueOrEnumValue4044);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1790:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1791:2: (iv_ruleValue= ruleValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1792:2: iv_ruleValue= ruleValue EOF
            {
             newCompositeNode(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue4079);
            iv_ruleValue=ruleValue();

            state._fsp--;

             current =iv_ruleValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue4089); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1799:1: ruleValue returns [EObject current=null] : (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_Variable_3= ruleVariable ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        EObject this_StringValue_0 = null;

        EObject this_IntegerValue_1 = null;

        EObject this_DecimalValue_2 = null;

        EObject this_Variable_3 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1802:28: ( (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_Variable_3= ruleVariable ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1803:1: (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_Variable_3= ruleVariable )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1803:1: (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_Variable_3= ruleVariable )
            int alt31=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt31=1;
                }
                break;
            case RULE_INTEGER:
                {
                alt31=2;
                }
                break;
            case RULE_DECIMAL:
                {
                alt31=3;
                }
                break;
            case RULE_ID:
                {
                alt31=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1804:5: this_StringValue_0= ruleStringValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getStringValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleStringValue_in_ruleValue4136);
                    this_StringValue_0=ruleStringValue();

                    state._fsp--;

                     
                            current = this_StringValue_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1814:5: this_IntegerValue_1= ruleIntegerValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getIntegerValueParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleIntegerValue_in_ruleValue4163);
                    this_IntegerValue_1=ruleIntegerValue();

                    state._fsp--;

                     
                            current = this_IntegerValue_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1824:5: this_DecimalValue_2= ruleDecimalValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getDecimalValueParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleDecimalValue_in_ruleValue4190);
                    this_DecimalValue_2=ruleDecimalValue();

                    state._fsp--;

                     
                            current = this_DecimalValue_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1834:5: this_Variable_3= ruleVariable
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getVariableParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleVariable_in_ruleValue4217);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1850:1: entryRuleIntegerValue returns [EObject current=null] : iv_ruleIntegerValue= ruleIntegerValue EOF ;
    public final EObject entryRuleIntegerValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1851:2: (iv_ruleIntegerValue= ruleIntegerValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1852:2: iv_ruleIntegerValue= ruleIntegerValue EOF
            {
             newCompositeNode(grammarAccess.getIntegerValueRule()); 
            pushFollow(FOLLOW_ruleIntegerValue_in_entryRuleIntegerValue4252);
            iv_ruleIntegerValue=ruleIntegerValue();

            state._fsp--;

             current =iv_ruleIntegerValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerValue4262); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1859:1: ruleIntegerValue returns [EObject current=null] : ( (lv_integerValue_0_0= RULE_INTEGER ) ) ;
    public final EObject ruleIntegerValue() throws RecognitionException {
        EObject current = null;

        Token lv_integerValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1862:28: ( ( (lv_integerValue_0_0= RULE_INTEGER ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1863:1: ( (lv_integerValue_0_0= RULE_INTEGER ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1863:1: ( (lv_integerValue_0_0= RULE_INTEGER ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1864:1: (lv_integerValue_0_0= RULE_INTEGER )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1864:1: (lv_integerValue_0_0= RULE_INTEGER )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1865:3: lv_integerValue_0_0= RULE_INTEGER
            {
            lv_integerValue_0_0=(Token)match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleIntegerValue4303); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1889:1: entryRuleDecimalValue returns [EObject current=null] : iv_ruleDecimalValue= ruleDecimalValue EOF ;
    public final EObject entryRuleDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecimalValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1890:2: (iv_ruleDecimalValue= ruleDecimalValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1891:2: iv_ruleDecimalValue= ruleDecimalValue EOF
            {
             newCompositeNode(grammarAccess.getDecimalValueRule()); 
            pushFollow(FOLLOW_ruleDecimalValue_in_entryRuleDecimalValue4343);
            iv_ruleDecimalValue=ruleDecimalValue();

            state._fsp--;

             current =iv_ruleDecimalValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalValue4353); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1898:1: ruleDecimalValue returns [EObject current=null] : ( (lv_decimalValue_0_0= RULE_DECIMAL ) ) ;
    public final EObject ruleDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_decimalValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1901:28: ( ( (lv_decimalValue_0_0= RULE_DECIMAL ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1902:1: ( (lv_decimalValue_0_0= RULE_DECIMAL ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1902:1: ( (lv_decimalValue_0_0= RULE_DECIMAL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1903:1: (lv_decimalValue_0_0= RULE_DECIMAL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1903:1: (lv_decimalValue_0_0= RULE_DECIMAL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1904:3: lv_decimalValue_0_0= RULE_DECIMAL
            {
            lv_decimalValue_0_0=(Token)match(input,RULE_DECIMAL,FOLLOW_RULE_DECIMAL_in_ruleDecimalValue4394); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1928:1: entryRuleStringValue returns [EObject current=null] : iv_ruleStringValue= ruleStringValue EOF ;
    public final EObject entryRuleStringValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1929:2: (iv_ruleStringValue= ruleStringValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1930:2: iv_ruleStringValue= ruleStringValue EOF
            {
             newCompositeNode(grammarAccess.getStringValueRule()); 
            pushFollow(FOLLOW_ruleStringValue_in_entryRuleStringValue4434);
            iv_ruleStringValue=ruleStringValue();

            state._fsp--;

             current =iv_ruleStringValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringValue4444); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1937:1: ruleStringValue returns [EObject current=null] : ( (lv_stringValue_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringValue() throws RecognitionException {
        EObject current = null;

        Token lv_stringValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1940:28: ( ( (lv_stringValue_0_0= RULE_STRING ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1941:1: ( (lv_stringValue_0_0= RULE_STRING ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1941:1: ( (lv_stringValue_0_0= RULE_STRING ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1942:1: (lv_stringValue_0_0= RULE_STRING )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1942:1: (lv_stringValue_0_0= RULE_STRING )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1943:3: lv_stringValue_0_0= RULE_STRING
            {
            lv_stringValue_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringValue4485); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1967:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1968:2: (iv_ruleVariable= ruleVariable EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1969:2: iv_ruleVariable= ruleVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable4525);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable4535); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1976:1: ruleVariable returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1979:28: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1980:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1980:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1981:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1981:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1982:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getVariableRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getVariableAccess().getNameVariableEntityCrossReference_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleVariable4582);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2003:1: entryRuleEnumValue returns [EObject current=null] : iv_ruleEnumValue= ruleEnumValue EOF ;
    public final EObject entryRuleEnumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2004:2: (iv_ruleEnumValue= ruleEnumValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2005:2: iv_ruleEnumValue= ruleEnumValue EOF
            {
             newCompositeNode(grammarAccess.getEnumValueRule()); 
            pushFollow(FOLLOW_ruleEnumValue_in_entryRuleEnumValue4617);
            iv_ruleEnumValue=ruleEnumValue();

            state._fsp--;

             current =iv_ruleEnumValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumValue4627); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2012:1: ruleEnumValue returns [EObject current=null] : ( (otherlv_0= RULE_UPPERCASE_ID ) ) ;
    public final EObject ruleEnumValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2015:28: ( ( (otherlv_0= RULE_UPPERCASE_ID ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2016:1: ( (otherlv_0= RULE_UPPERCASE_ID ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2016:1: ( (otherlv_0= RULE_UPPERCASE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2017:1: (otherlv_0= RULE_UPPERCASE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2017:1: (otherlv_0= RULE_UPPERCASE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2018:3: otherlv_0= RULE_UPPERCASE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumValueRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_UPPERCASE_ID,FOLLOW_RULE_UPPERCASE_ID_in_ruleEnumValue4671); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2037:1: entryRuleMethodReference returns [EObject current=null] : iv_ruleMethodReference= ruleMethodReference EOF ;
    public final EObject entryRuleMethodReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodReference = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2038:2: (iv_ruleMethodReference= ruleMethodReference EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2039:2: iv_ruleMethodReference= ruleMethodReference EOF
            {
             newCompositeNode(grammarAccess.getMethodReferenceRule()); 
            pushFollow(FOLLOW_ruleMethodReference_in_entryRuleMethodReference4706);
            iv_ruleMethodReference=ruleMethodReference();

            state._fsp--;

             current =iv_ruleMethodReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodReference4716); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2046:1: ruleMethodReference returns [EObject current=null] : ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleMethodReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2049:28: ( ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2050:1: ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2050:1: ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2050:2: ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2050:2: ( ( ruleQualifiedJavaClassName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2051:1: ( ruleQualifiedJavaClassName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2051:1: ( ruleQualifiedJavaClassName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2052:3: ruleQualifiedJavaClassName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMethodReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getMethodReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_ruleMethodReference4764);
            ruleQualifiedJavaClassName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,36,FOLLOW_36_in_ruleMethodReference4776); 

                	newLeafNode(otherlv_1, grammarAccess.getMethodReferenceAccess().getNumberSignKeyword_1());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2069:1: ( (otherlv_2= RULE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2070:1: (otherlv_2= RULE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2070:1: (otherlv_2= RULE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2071:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMethodReferenceRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMethodReference4796); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2090:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2091:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2092:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName4833);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName4844); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2099:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2102:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2103:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2103:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2103:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName4884); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2110:1: (kw= '.' this_ID_2= RULE_ID )*
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
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2111:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,37,FOLLOW_37_in_ruleQualifiedName4903); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName4918); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop32;
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2131:1: entryRuleQualifiedJavaClassName returns [String current=null] : iv_ruleQualifiedJavaClassName= ruleQualifiedJavaClassName EOF ;
    public final String entryRuleQualifiedJavaClassName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedJavaClassName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2132:2: (iv_ruleQualifiedJavaClassName= ruleQualifiedJavaClassName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2133:2: iv_ruleQualifiedJavaClassName= ruleQualifiedJavaClassName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedJavaClassNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_entryRuleQualifiedJavaClassName4966);
            iv_ruleQualifiedJavaClassName=ruleQualifiedJavaClassName();

            state._fsp--;

             current =iv_ruleQualifiedJavaClassName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedJavaClassName4977); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2140:1: ruleQualifiedJavaClassName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedJavaClassName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_UPPERCASE_ID_2=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2143:28: ( (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2144:1: (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2144:1: (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2145:5: this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID
            {
             
                    newCompositeNode(grammarAccess.getQualifiedJavaClassNameAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedJavaClassName5024);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            kw=(Token)match(input,37,FOLLOW_37_in_ruleQualifiedJavaClassName5042); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getQualifiedJavaClassNameAccess().getFullStopKeyword_1()); 
                
            this_UPPERCASE_ID_2=(Token)match(input,RULE_UPPERCASE_ID,FOLLOW_RULE_UPPERCASE_ID_in_ruleQualifiedJavaClassName5057); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2176:1: entryRuleQualifiedNameWithWildcard returns [String current=null] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2177:2: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2178:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard5103);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();

            state._fsp--;

             current =iv_ruleQualifiedNameWithWildcard.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard5114); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2185:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2188:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2189:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2189:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2190:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard5161);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2200:1: (kw= '.*' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==38) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2201:2: kw= '.*'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_ruleQualifiedNameWithWildcard5180); 

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
    public static final BitSet FOLLOW_ruleStatement_in_ruleModel130 = new BitSet(new long[]{0x0000000200012002L});
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
    public static final BitSet FOLLOW_14_in_ruleSuiteDefinition1196 = new BitSet(new long[]{0x00000002AA9B2000L});
    public static final BitSet FOLLOW_ruleSuiteStatement_in_ruleSuiteDefinition1217 = new BitSet(new long[]{0x00000002AA9B2000L});
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
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTest1897 = new BitSet(new long[]{0x0000000810000012L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleTest1918 = new BitSet(new long[]{0x0000000810000012L});
    public static final BitSet FOLLOW_ruleNamedResult_in_ruleTest1940 = new BitSet(new long[]{0x0000000810000012L});
    public static final BitSet FOLLOW_28_in_ruleTest1954 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_ruleTest1975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTableTest_in_entryRuleTableTest2013 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTableTest2023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleTableTest2060 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTableTest2083 = new BitSet(new long[]{0x0000000840000010L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleTableTest2104 = new BitSet(new long[]{0x0000000840000010L});
    public static final BitSet FOLLOW_ruleParameterTableHeader_in_ruleTableTest2126 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleResultTableHeader_in_ruleTableTest2148 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleTableTest2163 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleTableTest2175 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleTableTest2187 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleTableTest2206 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_ruleTableTestRow_in_ruleTableTest2228 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_ruleTableTestRow_in_entryRuleTableTestRow2265 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTableTestRow2275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableValue_in_ruleTableTestRow2330 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleTableTestRow2345 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleTableTestRow2357 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_ruleTableTestRow2378 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_30_in_ruleTableTestRow2390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleTableTestRow2409 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableHeader_in_entryRuleParameterTableHeader2446 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterTableHeader2456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleParameterTableHeader2493 = new BitSet(new long[]{0x0000000800000010L});
    public static final BitSet FOLLOW_ruleParameterName_in_ruleParameterTableHeader2514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultTableHeader_in_entryRuleResultTableHeader2550 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultTableHeader2560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleResultTableHeader2597 = new BitSet(new long[]{0x0000000800000010L});
    public static final BitSet FOLLOW_ruleResultName_in_ruleResultTableHeader2618 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleResultTableHeader2630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableValue_in_entryRuleParameterTableValue2666 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterTableValue2676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleParameterTableValue2713 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_ruleParameterTableValue2734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedResult_in_entryRuleNamedResult2770 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedResult2780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultName_in_ruleNamedResult2826 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleNamedResult2838 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_ruleNamedResult2859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultName_in_entryRuleResultName2895 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultName2905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedResultName_in_ruleResultName2952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterOrResultName_in_ruleResultName2979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedResultName_in_entryRuleFixedResultName3014 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFixedResultName3024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFixedResultName3068 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_entryRuleCall3103 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCall3113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleCall3150 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCall3173 = new BitSet(new long[]{0x0000000900000012L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleCall3194 = new BitSet(new long[]{0x0000000900000012L});
    public static final BitSet FOLLOW_32_in_ruleCall3208 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleCall3229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_entryRuleSuite3267 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuite3277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleSuite3314 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuite3337 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleSuiteParameter_in_ruleSuite3358 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleSuiteParameter_in_entryRuleSuiteParameter3395 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteParameter3405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuiteParameter3453 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleSuiteParameter3465 = new BitSet(new long[]{0x00000000000000F0L});
    public static final BitSet FOLLOW_ruleValue_in_ruleSuiteParameter3486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter3522 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter3532 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterName_in_ruleParameter3578 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleParameter3590 = new BitSet(new long[]{0x00000000000001F0L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_ruleParameter3611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterName_in_entryRuleParameterName3647 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterName3657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedParameterName_in_ruleParameterName3704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterOrResultName_in_ruleParameterName3731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedParameterName_in_entryRuleFixedParameterName3766 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFixedParameterName3776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFixedParameterName3820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterOrResultName_in_entryRuleArbitraryParameterOrResultName3855 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArbitraryParameterOrResultName3865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleArbitraryParameterOrResultName3902 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleArbitraryParameterOrResultName3919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_entryRuleValueOrEnumValue3960 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueOrEnumValue3970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_ruleValueOrEnumValue4017 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumValue_in_ruleValueOrEnumValue4044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue4079 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue4089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringValue_in_ruleValue4136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerValue_in_ruleValue4163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalValue_in_ruleValue4190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleValue4217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerValue_in_entryRuleIntegerValue4252 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerValue4262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleIntegerValue4303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalValue_in_entryRuleDecimalValue4343 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalValue4353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DECIMAL_in_ruleDecimalValue4394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringValue_in_entryRuleStringValue4434 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringValue4444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringValue4485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable4525 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable4535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleVariable4582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumValue_in_entryRuleEnumValue4617 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumValue4627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UPPERCASE_ID_in_ruleEnumValue4671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodReference_in_entryRuleMethodReference4706 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodReference4716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_ruleMethodReference4764 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36_in_ruleMethodReference4776 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMethodReference4796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName4833 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName4844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName4884 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_37_in_ruleQualifiedName4903 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName4918 = new BitSet(new long[]{0x0000002000000002L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_entryRuleQualifiedJavaClassName4966 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedJavaClassName4977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedJavaClassName5024 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37_in_ruleQualifiedJavaClassName5042 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_UPPERCASE_ID_in_ruleQualifiedJavaClassName5057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard5103 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard5114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard5161 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_ruleQualifiedNameWithWildcard5180 = new BitSet(new long[]{0x0000000000000002L});

}