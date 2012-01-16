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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SL_VISIBLE_COMMENT", "RULE_ML_VISIBLE_COMMENT", "RULE_STRING", "RULE_ID", "RULE_INTEGER", "RULE_DECIMAL", "RULE_UPPERCASE_ID", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'packagedef'", "'with'", "'packageend'", "'import'", "'forkdef'", "'testdef'", "'uses'", "'calldef'", "'suitedef'", "'gets'", "'requires'", "'suiteend'", "'concludedby'", "'variable'", "'initially'", "'constant'", "'test'", "'='", "'tabletest'", "'|'", "'call'", "'sets'", "'suite'", "'on'", "':'", "'+'", "'#'", "'.'", "'.*'"
    };
    public static final int RULE_ID=7;
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
    public static final int RULE_SL_VISIBLE_COMMENT=4;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int RULE_UPPERCASE_ID=10;
    public static final int RULE_DECIMAL=9;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int RULE_ML_VISIBLE_COMMENT=5;
    public static final int RULE_SL_COMMENT=12;
    public static final int RULE_ML_COMMENT=11;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_STRING=6;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=13;
    public static final int RULE_INTEGER=8;

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

                if ( (LA1_0==15||LA1_0==18||LA1_0==37) ) {
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
            case 15:
                {
                alt2=1;
                }
                break;
            case 18:
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


    // $ANTLR start "entryRuleVisibleSingleLineComment"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:156:1: entryRuleVisibleSingleLineComment returns [EObject current=null] : iv_ruleVisibleSingleLineComment= ruleVisibleSingleLineComment EOF ;
    public final EObject entryRuleVisibleSingleLineComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleSingleLineComment = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:157:2: (iv_ruleVisibleSingleLineComment= ruleVisibleSingleLineComment EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:158:2: iv_ruleVisibleSingleLineComment= ruleVisibleSingleLineComment EOF
            {
             newCompositeNode(grammarAccess.getVisibleSingleLineCommentRule()); 
            pushFollow(FOLLOW_ruleVisibleSingleLineComment_in_entryRuleVisibleSingleLineComment312);
            iv_ruleVisibleSingleLineComment=ruleVisibleSingleLineComment();

            state._fsp--;

             current =iv_ruleVisibleSingleLineComment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVisibleSingleLineComment322); 

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
    // $ANTLR end "entryRuleVisibleSingleLineComment"


    // $ANTLR start "ruleVisibleSingleLineComment"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:165:1: ruleVisibleSingleLineComment returns [EObject current=null] : ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) ) ;
    public final EObject ruleVisibleSingleLineComment() throws RecognitionException {
        EObject current = null;

        Token lv_content_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:168:28: ( ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:169:1: ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:169:1: ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:170:1: (lv_content_0_0= RULE_SL_VISIBLE_COMMENT )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:170:1: (lv_content_0_0= RULE_SL_VISIBLE_COMMENT )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:171:3: lv_content_0_0= RULE_SL_VISIBLE_COMMENT
            {
            lv_content_0_0=(Token)match(input,RULE_SL_VISIBLE_COMMENT,FOLLOW_RULE_SL_VISIBLE_COMMENT_in_ruleVisibleSingleLineComment363); 

            			newLeafNode(lv_content_0_0, grammarAccess.getVisibleSingleLineCommentAccess().getContentSL_VISIBLE_COMMENTTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVisibleSingleLineCommentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"content",
                    		lv_content_0_0, 
                    		"SL_VISIBLE_COMMENT");
            	    

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
    // $ANTLR end "ruleVisibleSingleLineComment"


    // $ANTLR start "entryRuleVisibleMultiLineComment"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:195:1: entryRuleVisibleMultiLineComment returns [EObject current=null] : iv_ruleVisibleMultiLineComment= ruleVisibleMultiLineComment EOF ;
    public final EObject entryRuleVisibleMultiLineComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleMultiLineComment = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:196:2: (iv_ruleVisibleMultiLineComment= ruleVisibleMultiLineComment EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:197:2: iv_ruleVisibleMultiLineComment= ruleVisibleMultiLineComment EOF
            {
             newCompositeNode(grammarAccess.getVisibleMultiLineCommentRule()); 
            pushFollow(FOLLOW_ruleVisibleMultiLineComment_in_entryRuleVisibleMultiLineComment403);
            iv_ruleVisibleMultiLineComment=ruleVisibleMultiLineComment();

            state._fsp--;

             current =iv_ruleVisibleMultiLineComment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVisibleMultiLineComment413); 

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
    // $ANTLR end "entryRuleVisibleMultiLineComment"


    // $ANTLR start "ruleVisibleMultiLineComment"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:204:1: ruleVisibleMultiLineComment returns [EObject current=null] : ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) ) ;
    public final EObject ruleVisibleMultiLineComment() throws RecognitionException {
        EObject current = null;

        Token lv_content_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:207:28: ( ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:208:1: ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:208:1: ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:209:1: (lv_content_0_0= RULE_ML_VISIBLE_COMMENT )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:209:1: (lv_content_0_0= RULE_ML_VISIBLE_COMMENT )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:210:3: lv_content_0_0= RULE_ML_VISIBLE_COMMENT
            {
            lv_content_0_0=(Token)match(input,RULE_ML_VISIBLE_COMMENT,FOLLOW_RULE_ML_VISIBLE_COMMENT_in_ruleVisibleMultiLineComment454); 

            			newLeafNode(lv_content_0_0, grammarAccess.getVisibleMultiLineCommentAccess().getContentML_VISIBLE_COMMENTTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVisibleMultiLineCommentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"content",
                    		lv_content_0_0, 
                    		"ML_VISIBLE_COMMENT");
            	    

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
    // $ANTLR end "ruleVisibleMultiLineComment"


    // $ANTLR start "entryRulePackageDefinition"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:234:1: entryRulePackageDefinition returns [EObject current=null] : iv_rulePackageDefinition= rulePackageDefinition EOF ;
    public final EObject entryRulePackageDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:235:2: (iv_rulePackageDefinition= rulePackageDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:236:2: iv_rulePackageDefinition= rulePackageDefinition EOF
            {
             newCompositeNode(grammarAccess.getPackageDefinitionRule()); 
            pushFollow(FOLLOW_rulePackageDefinition_in_entryRulePackageDefinition494);
            iv_rulePackageDefinition=rulePackageDefinition();

            state._fsp--;

             current =iv_rulePackageDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePackageDefinition504); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:243:1: rulePackageDefinition returns [EObject current=null] : (otherlv_0= 'packagedef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'with' ( (lv_statements_3_0= rulePackageStatement ) )* otherlv_4= 'packageend' ) ;
    public final EObject rulePackageDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_statements_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:246:28: ( (otherlv_0= 'packagedef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'with' ( (lv_statements_3_0= rulePackageStatement ) )* otherlv_4= 'packageend' ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:247:1: (otherlv_0= 'packagedef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'with' ( (lv_statements_3_0= rulePackageStatement ) )* otherlv_4= 'packageend' )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:247:1: (otherlv_0= 'packagedef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'with' ( (lv_statements_3_0= rulePackageStatement ) )* otherlv_4= 'packageend' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:247:3: otherlv_0= 'packagedef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'with' ( (lv_statements_3_0= rulePackageStatement ) )* otherlv_4= 'packageend'
            {
            otherlv_0=(Token)match(input,15,FOLLOW_15_in_rulePackageDefinition541); 

                	newLeafNode(otherlv_0, grammarAccess.getPackageDefinitionAccess().getPackagedefKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:251:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:252:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:252:1: (lv_name_1_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:253:3: lv_name_1_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getPackageDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_rulePackageDefinition562);
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

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_rulePackageDefinition574); 

                	newLeafNode(otherlv_2, grammarAccess.getPackageDefinitionAccess().getWithKeyword_2());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:273:1: ( (lv_statements_3_0= rulePackageStatement ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>=18 && LA3_0<=20)||(LA3_0>=22 && LA3_0<=23)||LA3_0==28||LA3_0==30) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:274:1: (lv_statements_3_0= rulePackageStatement )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:274:1: (lv_statements_3_0= rulePackageStatement )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:275:3: lv_statements_3_0= rulePackageStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPackageDefinitionAccess().getStatementsPackageStatementParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePackageStatement_in_rulePackageDefinition595);
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

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_rulePackageDefinition608); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:303:1: entryRulePackageStatement returns [EObject current=null] : iv_rulePackageStatement= rulePackageStatement EOF ;
    public final EObject entryRulePackageStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageStatement = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:304:2: (iv_rulePackageStatement= rulePackageStatement EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:305:2: iv_rulePackageStatement= rulePackageStatement EOF
            {
             newCompositeNode(grammarAccess.getPackageStatementRule()); 
            pushFollow(FOLLOW_rulePackageStatement_in_entryRulePackageStatement644);
            iv_rulePackageStatement=rulePackageStatement();

            state._fsp--;

             current =iv_rulePackageStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePackageStatement654); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:312:1: rulePackageStatement returns [EObject current=null] : (this_Import_0= ruleImport | this_ForkDefinition_1= ruleForkDefinition | this_TestDefinition_2= ruleTestDefinition | this_CallDefinition_3= ruleCallDefinition | this_SuiteDefinition_4= ruleSuiteDefinition | this_VariableDefinition_5= ruleVariableDefinition | this_ConstantDefinition_6= ruleConstantDefinition ) ;
    public final EObject rulePackageStatement() throws RecognitionException {
        EObject current = null;

        EObject this_Import_0 = null;

        EObject this_ForkDefinition_1 = null;

        EObject this_TestDefinition_2 = null;

        EObject this_CallDefinition_3 = null;

        EObject this_SuiteDefinition_4 = null;

        EObject this_VariableDefinition_5 = null;

        EObject this_ConstantDefinition_6 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:315:28: ( (this_Import_0= ruleImport | this_ForkDefinition_1= ruleForkDefinition | this_TestDefinition_2= ruleTestDefinition | this_CallDefinition_3= ruleCallDefinition | this_SuiteDefinition_4= ruleSuiteDefinition | this_VariableDefinition_5= ruleVariableDefinition | this_ConstantDefinition_6= ruleConstantDefinition ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:316:1: (this_Import_0= ruleImport | this_ForkDefinition_1= ruleForkDefinition | this_TestDefinition_2= ruleTestDefinition | this_CallDefinition_3= ruleCallDefinition | this_SuiteDefinition_4= ruleSuiteDefinition | this_VariableDefinition_5= ruleVariableDefinition | this_ConstantDefinition_6= ruleConstantDefinition )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:316:1: (this_Import_0= ruleImport | this_ForkDefinition_1= ruleForkDefinition | this_TestDefinition_2= ruleTestDefinition | this_CallDefinition_3= ruleCallDefinition | this_SuiteDefinition_4= ruleSuiteDefinition | this_VariableDefinition_5= ruleVariableDefinition | this_ConstantDefinition_6= ruleConstantDefinition )
            int alt4=7;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt4=1;
                }
                break;
            case 19:
                {
                alt4=2;
                }
                break;
            case 20:
                {
                alt4=3;
                }
                break;
            case 22:
                {
                alt4=4;
                }
                break;
            case 23:
                {
                alt4=5;
                }
                break;
            case 28:
                {
                alt4=6;
                }
                break;
            case 30:
                {
                alt4=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:317:5: this_Import_0= ruleImport
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getImportParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleImport_in_rulePackageStatement701);
                    this_Import_0=ruleImport();

                    state._fsp--;

                     
                            current = this_Import_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:327:5: this_ForkDefinition_1= ruleForkDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getForkDefinitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleForkDefinition_in_rulePackageStatement728);
                    this_ForkDefinition_1=ruleForkDefinition();

                    state._fsp--;

                     
                            current = this_ForkDefinition_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:337:5: this_TestDefinition_2= ruleTestDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getTestDefinitionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleTestDefinition_in_rulePackageStatement755);
                    this_TestDefinition_2=ruleTestDefinition();

                    state._fsp--;

                     
                            current = this_TestDefinition_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:347:5: this_CallDefinition_3= ruleCallDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getCallDefinitionParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleCallDefinition_in_rulePackageStatement782);
                    this_CallDefinition_3=ruleCallDefinition();

                    state._fsp--;

                     
                            current = this_CallDefinition_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:357:5: this_SuiteDefinition_4= ruleSuiteDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getSuiteDefinitionParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleSuiteDefinition_in_rulePackageStatement809);
                    this_SuiteDefinition_4=ruleSuiteDefinition();

                    state._fsp--;

                     
                            current = this_SuiteDefinition_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:367:5: this_VariableDefinition_5= ruleVariableDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getVariableDefinitionParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleVariableDefinition_in_rulePackageStatement836);
                    this_VariableDefinition_5=ruleVariableDefinition();

                    state._fsp--;

                     
                            current = this_VariableDefinition_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:377:5: this_ConstantDefinition_6= ruleConstantDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getConstantDefinitionParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleConstantDefinition_in_rulePackageStatement863);
                    this_ConstantDefinition_6=ruleConstantDefinition();

                    state._fsp--;

                     
                            current = this_ConstantDefinition_6; 
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:393:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:394:2: (iv_ruleImport= ruleImport EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:395:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport898);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport908); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:402:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:405:28: ( (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:406:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:406:1: (otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:406:3: otherlv_0= 'import' ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleImport945); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:410:1: ( (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:411:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:411:1: (lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:412:3: lv_importedNamespace_1_0= ruleQualifiedNameWithWildcard
            {
             
            	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_ruleImport966);
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


    // $ANTLR start "entryRuleForkDefinition"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:436:1: entryRuleForkDefinition returns [EObject current=null] : iv_ruleForkDefinition= ruleForkDefinition EOF ;
    public final EObject entryRuleForkDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForkDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:437:2: (iv_ruleForkDefinition= ruleForkDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:438:2: iv_ruleForkDefinition= ruleForkDefinition EOF
            {
             newCompositeNode(grammarAccess.getForkDefinitionRule()); 
            pushFollow(FOLLOW_ruleForkDefinition_in_entryRuleForkDefinition1002);
            iv_ruleForkDefinition=ruleForkDefinition();

            state._fsp--;

             current =iv_ruleForkDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleForkDefinition1012); 

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
    // $ANTLR end "entryRuleForkDefinition"


    // $ANTLR start "ruleForkDefinition"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:445:1: ruleForkDefinition returns [EObject current=null] : (otherlv_0= 'forkdef' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_description_2_0= RULE_STRING ) )? ) ;
    public final EObject ruleForkDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_description_2_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:448:28: ( (otherlv_0= 'forkdef' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_description_2_0= RULE_STRING ) )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:449:1: (otherlv_0= 'forkdef' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_description_2_0= RULE_STRING ) )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:449:1: (otherlv_0= 'forkdef' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_description_2_0= RULE_STRING ) )? )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:449:3: otherlv_0= 'forkdef' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_description_2_0= RULE_STRING ) )?
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleForkDefinition1049); 

                	newLeafNode(otherlv_0, grammarAccess.getForkDefinitionAccess().getForkdefKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:453:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:454:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:454:1: (lv_name_1_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:455:3: lv_name_1_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getForkDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleForkDefinition1070);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getForkDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:471:2: ( (lv_description_2_0= RULE_STRING ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_STRING) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:472:1: (lv_description_2_0= RULE_STRING )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:472:1: (lv_description_2_0= RULE_STRING )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:473:3: lv_description_2_0= RULE_STRING
                    {
                    lv_description_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleForkDefinition1087); 

                    			newLeafNode(lv_description_2_0, grammarAccess.getForkDefinitionAccess().getDescriptionSTRINGTerminalRuleCall_2_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getForkDefinitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_2_0, 
                            		"STRING");
                    	    

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
    // $ANTLR end "ruleForkDefinition"


    // $ANTLR start "entryRuleTestDefinition"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:497:1: entryRuleTestDefinition returns [EObject current=null] : iv_ruleTestDefinition= ruleTestDefinition EOF ;
    public final EObject entryRuleTestDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:498:2: (iv_ruleTestDefinition= ruleTestDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:499:2: iv_ruleTestDefinition= ruleTestDefinition EOF
            {
             newCompositeNode(grammarAccess.getTestDefinitionRule()); 
            pushFollow(FOLLOW_ruleTestDefinition_in_entryRuleTestDefinition1129);
            iv_ruleTestDefinition=ruleTestDefinition();

            state._fsp--;

             current =iv_ruleTestDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestDefinition1139); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:506:1: ruleTestDefinition returns [EObject current=null] : (otherlv_0= 'testdef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) ) ;
    public final EObject ruleTestDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_fixtureMethod_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:509:28: ( (otherlv_0= 'testdef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:510:1: (otherlv_0= 'testdef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:510:1: (otherlv_0= 'testdef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:510:3: otherlv_0= 'testdef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) )
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleTestDefinition1176); 

                	newLeafNode(otherlv_0, grammarAccess.getTestDefinitionAccess().getTestdefKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:514:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:515:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:515:1: (lv_name_1_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:516:3: lv_name_1_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getTestDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleTestDefinition1197);
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

            otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleTestDefinition1209); 

                	newLeafNode(otherlv_2, grammarAccess.getTestDefinitionAccess().getUsesKeyword_2());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:536:1: ( (lv_fixtureMethod_3_0= ruleMethodReference ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:537:1: (lv_fixtureMethod_3_0= ruleMethodReference )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:537:1: (lv_fixtureMethod_3_0= ruleMethodReference )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:538:3: lv_fixtureMethod_3_0= ruleMethodReference
            {
             
            	        newCompositeNode(grammarAccess.getTestDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleMethodReference_in_ruleTestDefinition1230);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:562:1: entryRuleCallDefinition returns [EObject current=null] : iv_ruleCallDefinition= ruleCallDefinition EOF ;
    public final EObject entryRuleCallDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:563:2: (iv_ruleCallDefinition= ruleCallDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:564:2: iv_ruleCallDefinition= ruleCallDefinition EOF
            {
             newCompositeNode(grammarAccess.getCallDefinitionRule()); 
            pushFollow(FOLLOW_ruleCallDefinition_in_entryRuleCallDefinition1266);
            iv_ruleCallDefinition=ruleCallDefinition();

            state._fsp--;

             current =iv_ruleCallDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallDefinition1276); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:571:1: ruleCallDefinition returns [EObject current=null] : (otherlv_0= 'calldef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) ) ;
    public final EObject ruleCallDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_fixtureMethod_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:574:28: ( (otherlv_0= 'calldef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:575:1: (otherlv_0= 'calldef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:575:1: (otherlv_0= 'calldef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:575:3: otherlv_0= 'calldef' ( (lv_name_1_0= ruleQualifiedName ) ) otherlv_2= 'uses' ( (lv_fixtureMethod_3_0= ruleMethodReference ) )
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleCallDefinition1313); 

                	newLeafNode(otherlv_0, grammarAccess.getCallDefinitionAccess().getCalldefKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:579:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:580:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:580:1: (lv_name_1_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:581:3: lv_name_1_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getCallDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleCallDefinition1334);
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

            otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleCallDefinition1346); 

                	newLeafNode(otherlv_2, grammarAccess.getCallDefinitionAccess().getUsesKeyword_2());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:601:1: ( (lv_fixtureMethod_3_0= ruleMethodReference ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:602:1: (lv_fixtureMethod_3_0= ruleMethodReference )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:602:1: (lv_fixtureMethod_3_0= ruleMethodReference )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:603:3: lv_fixtureMethod_3_0= ruleMethodReference
            {
             
            	        newCompositeNode(grammarAccess.getCallDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleMethodReference_in_ruleCallDefinition1367);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:627:1: entryRuleSuiteDefinition returns [EObject current=null] : iv_ruleSuiteDefinition= ruleSuiteDefinition EOF ;
    public final EObject entryRuleSuiteDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:628:2: (iv_ruleSuiteDefinition= ruleSuiteDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:629:2: iv_ruleSuiteDefinition= ruleSuiteDefinition EOF
            {
             newCompositeNode(grammarAccess.getSuiteDefinitionRule()); 
            pushFollow(FOLLOW_ruleSuiteDefinition_in_entryRuleSuiteDefinition1403);
            iv_ruleSuiteDefinition=ruleSuiteDefinition();

            state._fsp--;

             current =iv_ruleSuiteDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteDefinition1413); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:636:1: ruleSuiteDefinition returns [EObject current=null] : (otherlv_0= 'suitedef' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )* )? (otherlv_4= 'requires' ( ( ruleQualifiedName ) )* )? otherlv_6= 'with' ( (lv_statements_7_0= ruleSuiteStatement ) )* otherlv_8= 'suiteend' (otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )* )? ) ;
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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:639:28: ( (otherlv_0= 'suitedef' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )* )? (otherlv_4= 'requires' ( ( ruleQualifiedName ) )* )? otherlv_6= 'with' ( (lv_statements_7_0= ruleSuiteStatement ) )* otherlv_8= 'suiteend' (otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )* )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:640:1: (otherlv_0= 'suitedef' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )* )? (otherlv_4= 'requires' ( ( ruleQualifiedName ) )* )? otherlv_6= 'with' ( (lv_statements_7_0= ruleSuiteStatement ) )* otherlv_8= 'suiteend' (otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )* )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:640:1: (otherlv_0= 'suitedef' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )* )? (otherlv_4= 'requires' ( ( ruleQualifiedName ) )* )? otherlv_6= 'with' ( (lv_statements_7_0= ruleSuiteStatement ) )* otherlv_8= 'suiteend' (otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )* )? )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:640:3: otherlv_0= 'suitedef' ( (lv_name_1_0= ruleQualifiedName ) ) (otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )* )? (otherlv_4= 'requires' ( ( ruleQualifiedName ) )* )? otherlv_6= 'with' ( (lv_statements_7_0= ruleSuiteStatement ) )* otherlv_8= 'suiteend' (otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )* )?
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleSuiteDefinition1450); 

                	newLeafNode(otherlv_0, grammarAccess.getSuiteDefinitionAccess().getSuitedefKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:644:1: ( (lv_name_1_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:645:1: (lv_name_1_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:645:1: (lv_name_1_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:646:3: lv_name_1_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNameQualifiedNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuiteDefinition1471);
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

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:662:2: (otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==24) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:662:4: otherlv_2= 'gets' ( (lv_parameters_3_0= ruleVariableEntity ) )*
                    {
                    otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleSuiteDefinition1484); 

                        	newLeafNode(otherlv_2, grammarAccess.getSuiteDefinitionAccess().getGetsKeyword_2_0());
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:666:1: ( (lv_parameters_3_0= ruleVariableEntity ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==RULE_ID) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:667:1: (lv_parameters_3_0= ruleVariableEntity )
                    	    {
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:667:1: (lv_parameters_3_0= ruleVariableEntity )
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:668:3: lv_parameters_3_0= ruleVariableEntity
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getParametersVariableEntityParserRuleCall_2_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleVariableEntity_in_ruleSuiteDefinition1505);
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
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:684:5: (otherlv_4= 'requires' ( ( ruleQualifiedName ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==25) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:684:7: otherlv_4= 'requires' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_4=(Token)match(input,25,FOLLOW_25_in_ruleSuiteDefinition1521); 

                        	newLeafNode(otherlv_4, grammarAccess.getSuiteDefinitionAccess().getRequiresKeyword_3_0());
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:688:1: ( ( ruleQualifiedName ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==RULE_ID) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:689:1: ( ruleQualifiedName )
                    	    {
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:689:1: ( ruleQualifiedName )
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:690:3: ruleQualifiedName
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSuiteDefinitionRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getDependenciesSuiteDefinitionCrossReference_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuiteDefinition1544);
                    	    ruleQualifiedName();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,16,FOLLOW_16_in_ruleSuiteDefinition1559); 

                	newLeafNode(otherlv_6, grammarAccess.getSuiteDefinitionAccess().getWithKeyword_4());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:707:1: ( (lv_statements_7_0= ruleSuiteStatement ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>=RULE_SL_VISIBLE_COMMENT && LA10_0<=RULE_ML_VISIBLE_COMMENT)||LA10_0==28||(LA10_0>=30 && LA10_0<=31)||LA10_0==33||LA10_0==35||LA10_0==37) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:708:1: (lv_statements_7_0= ruleSuiteStatement )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:708:1: (lv_statements_7_0= ruleSuiteStatement )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:709:3: lv_statements_7_0= ruleSuiteStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getStatementsSuiteStatementParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSuiteStatement_in_ruleSuiteDefinition1580);
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
            	    break loop10;
                }
            } while (true);

            otherlv_8=(Token)match(input,26,FOLLOW_26_in_ruleSuiteDefinition1593); 

                	newLeafNode(otherlv_8, grammarAccess.getSuiteDefinitionAccess().getSuiteendKeyword_6());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:729:1: (otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==27) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:729:3: otherlv_9= 'concludedby' ( ( ruleQualifiedName ) )*
                    {
                    otherlv_9=(Token)match(input,27,FOLLOW_27_in_ruleSuiteDefinition1606); 

                        	newLeafNode(otherlv_9, grammarAccess.getSuiteDefinitionAccess().getConcludedbyKeyword_7_0());
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:733:1: ( ( ruleQualifiedName ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==RULE_ID) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:734:1: ( ruleQualifiedName )
                    	    {
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:734:1: ( ruleQualifiedName )
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:735:3: ruleQualifiedName
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSuiteDefinitionRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getFinalizersSuiteDefinitionCrossReference_7_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuiteDefinition1629);
                    	    ruleQualifiedName();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop11;
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:756:1: entryRuleSuiteStatement returns [EObject current=null] : iv_ruleSuiteStatement= ruleSuiteStatement EOF ;
    public final EObject entryRuleSuiteStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteStatement = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:757:2: (iv_ruleSuiteStatement= ruleSuiteStatement EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:758:2: iv_ruleSuiteStatement= ruleSuiteStatement EOF
            {
             newCompositeNode(grammarAccess.getSuiteStatementRule()); 
            pushFollow(FOLLOW_ruleSuiteStatement_in_entryRuleSuiteStatement1668);
            iv_ruleSuiteStatement=ruleSuiteStatement();

            state._fsp--;

             current =iv_ruleSuiteStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteStatement1678); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:765:1: ruleSuiteStatement returns [EObject current=null] : (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_Call_1= ruleCall | this_VariableDefinition_2= ruleVariableDefinition | this_ConstantDefinition_3= ruleConstantDefinition | this_VisibleSingleLineComment_4= ruleVisibleSingleLineComment | this_VisibleMultiLineComment_5= ruleVisibleMultiLineComment ) ;
    public final EObject ruleSuiteStatement() throws RecognitionException {
        EObject current = null;

        EObject this_SuiteStatementWithResult_0 = null;

        EObject this_Call_1 = null;

        EObject this_VariableDefinition_2 = null;

        EObject this_ConstantDefinition_3 = null;

        EObject this_VisibleSingleLineComment_4 = null;

        EObject this_VisibleMultiLineComment_5 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:768:28: ( (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_Call_1= ruleCall | this_VariableDefinition_2= ruleVariableDefinition | this_ConstantDefinition_3= ruleConstantDefinition | this_VisibleSingleLineComment_4= ruleVisibleSingleLineComment | this_VisibleMultiLineComment_5= ruleVisibleMultiLineComment ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:769:1: (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_Call_1= ruleCall | this_VariableDefinition_2= ruleVariableDefinition | this_ConstantDefinition_3= ruleConstantDefinition | this_VisibleSingleLineComment_4= ruleVisibleSingleLineComment | this_VisibleMultiLineComment_5= ruleVisibleMultiLineComment )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:769:1: (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_Call_1= ruleCall | this_VariableDefinition_2= ruleVariableDefinition | this_ConstantDefinition_3= ruleConstantDefinition | this_VisibleSingleLineComment_4= ruleVisibleSingleLineComment | this_VisibleMultiLineComment_5= ruleVisibleMultiLineComment )
            int alt13=6;
            switch ( input.LA(1) ) {
            case 31:
            case 33:
            case 37:
                {
                alt13=1;
                }
                break;
            case 35:
                {
                alt13=2;
                }
                break;
            case 28:
                {
                alt13=3;
                }
                break;
            case 30:
                {
                alt13=4;
                }
                break;
            case RULE_SL_VISIBLE_COMMENT:
                {
                alt13=5;
                }
                break;
            case RULE_ML_VISIBLE_COMMENT:
                {
                alt13=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }

            switch (alt13) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:770:5: this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getSuiteStatementWithResultParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSuiteStatementWithResult_in_ruleSuiteStatement1725);
                    this_SuiteStatementWithResult_0=ruleSuiteStatementWithResult();

                    state._fsp--;

                     
                            current = this_SuiteStatementWithResult_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:780:5: this_Call_1= ruleCall
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getCallParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleCall_in_ruleSuiteStatement1752);
                    this_Call_1=ruleCall();

                    state._fsp--;

                     
                            current = this_Call_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:790:5: this_VariableDefinition_2= ruleVariableDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getVariableDefinitionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleVariableDefinition_in_ruleSuiteStatement1779);
                    this_VariableDefinition_2=ruleVariableDefinition();

                    state._fsp--;

                     
                            current = this_VariableDefinition_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:800:5: this_ConstantDefinition_3= ruleConstantDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getConstantDefinitionParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleConstantDefinition_in_ruleSuiteStatement1806);
                    this_ConstantDefinition_3=ruleConstantDefinition();

                    state._fsp--;

                     
                            current = this_ConstantDefinition_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:810:5: this_VisibleSingleLineComment_4= ruleVisibleSingleLineComment
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getVisibleSingleLineCommentParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleVisibleSingleLineComment_in_ruleSuiteStatement1833);
                    this_VisibleSingleLineComment_4=ruleVisibleSingleLineComment();

                    state._fsp--;

                     
                            current = this_VisibleSingleLineComment_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:820:5: this_VisibleMultiLineComment_5= ruleVisibleMultiLineComment
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getVisibleMultiLineCommentParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleVisibleMultiLineComment_in_ruleSuiteStatement1860);
                    this_VisibleMultiLineComment_5=ruleVisibleMultiLineComment();

                    state._fsp--;

                     
                            current = this_VisibleMultiLineComment_5; 
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:836:1: entryRuleSuiteStatementWithResult returns [EObject current=null] : iv_ruleSuiteStatementWithResult= ruleSuiteStatementWithResult EOF ;
    public final EObject entryRuleSuiteStatementWithResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteStatementWithResult = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:837:2: (iv_ruleSuiteStatementWithResult= ruleSuiteStatementWithResult EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:838:2: iv_ruleSuiteStatementWithResult= ruleSuiteStatementWithResult EOF
            {
             newCompositeNode(grammarAccess.getSuiteStatementWithResultRule()); 
            pushFollow(FOLLOW_ruleSuiteStatementWithResult_in_entryRuleSuiteStatementWithResult1895);
            iv_ruleSuiteStatementWithResult=ruleSuiteStatementWithResult();

            state._fsp--;

             current =iv_ruleSuiteStatementWithResult; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteStatementWithResult1905); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:845:1: ruleSuiteStatementWithResult returns [EObject current=null] : (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest ) ;
    public final EObject ruleSuiteStatementWithResult() throws RecognitionException {
        EObject current = null;

        EObject this_Suite_0 = null;

        EObject this_Test_1 = null;

        EObject this_TableTest_2 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:848:28: ( (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:849:1: (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:849:1: (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest )
            int alt14=3;
            switch ( input.LA(1) ) {
            case 37:
                {
                alt14=1;
                }
                break;
            case 31:
                {
                alt14=2;
                }
                break;
            case 33:
                {
                alt14=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }

            switch (alt14) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:850:5: this_Suite_0= ruleSuite
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementWithResultAccess().getSuiteParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSuite_in_ruleSuiteStatementWithResult1952);
                    this_Suite_0=ruleSuite();

                    state._fsp--;

                     
                            current = this_Suite_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:860:5: this_Test_1= ruleTest
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementWithResultAccess().getTestParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleTest_in_ruleSuiteStatementWithResult1979);
                    this_Test_1=ruleTest();

                    state._fsp--;

                     
                            current = this_Test_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:870:5: this_TableTest_2= ruleTableTest
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementWithResultAccess().getTableTestParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleTableTest_in_ruleSuiteStatementWithResult2006);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:886:1: entryRuleVariableDefinition returns [EObject current=null] : iv_ruleVariableDefinition= ruleVariableDefinition EOF ;
    public final EObject entryRuleVariableDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:887:2: (iv_ruleVariableDefinition= ruleVariableDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:888:2: iv_ruleVariableDefinition= ruleVariableDefinition EOF
            {
             newCompositeNode(grammarAccess.getVariableDefinitionRule()); 
            pushFollow(FOLLOW_ruleVariableDefinition_in_entryRuleVariableDefinition2041);
            iv_ruleVariableDefinition=ruleVariableDefinition();

            state._fsp--;

             current =iv_ruleVariableDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDefinition2051); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:895:1: ruleVariableDefinition returns [EObject current=null] : (otherlv_0= 'variable' ( (lv_name_1_0= ruleVariableEntity ) ) (otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) ) )? ) ;
    public final EObject ruleVariableDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_name_1_0 = null;

        EObject lv_initialValue_3_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:898:28: ( (otherlv_0= 'variable' ( (lv_name_1_0= ruleVariableEntity ) ) (otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) ) )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:899:1: (otherlv_0= 'variable' ( (lv_name_1_0= ruleVariableEntity ) ) (otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) ) )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:899:1: (otherlv_0= 'variable' ( (lv_name_1_0= ruleVariableEntity ) ) (otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) ) )? )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:899:3: otherlv_0= 'variable' ( (lv_name_1_0= ruleVariableEntity ) ) (otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) ) )?
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleVariableDefinition2088); 

                	newLeafNode(otherlv_0, grammarAccess.getVariableDefinitionAccess().getVariableKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:903:1: ( (lv_name_1_0= ruleVariableEntity ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:904:1: (lv_name_1_0= ruleVariableEntity )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:904:1: (lv_name_1_0= ruleVariableEntity )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:905:3: lv_name_1_0= ruleVariableEntity
            {
             
            	        newCompositeNode(grammarAccess.getVariableDefinitionAccess().getNameVariableEntityParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleVariableEntity_in_ruleVariableDefinition2109);
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

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:921:2: (otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==29) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:921:4: otherlv_2= 'initially' ( (lv_initialValue_3_0= ruleValue ) )
                    {
                    otherlv_2=(Token)match(input,29,FOLLOW_29_in_ruleVariableDefinition2122); 

                        	newLeafNode(otherlv_2, grammarAccess.getVariableDefinitionAccess().getInitiallyKeyword_2_0());
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:925:1: ( (lv_initialValue_3_0= ruleValue ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:926:1: (lv_initialValue_3_0= ruleValue )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:926:1: (lv_initialValue_3_0= ruleValue )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:927:3: lv_initialValue_3_0= ruleValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariableDefinitionAccess().getInitialValueValueParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValue_in_ruleVariableDefinition2143);
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


    // $ANTLR start "entryRuleConstantDefinition"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:951:1: entryRuleConstantDefinition returns [EObject current=null] : iv_ruleConstantDefinition= ruleConstantDefinition EOF ;
    public final EObject entryRuleConstantDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:952:2: (iv_ruleConstantDefinition= ruleConstantDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:953:2: iv_ruleConstantDefinition= ruleConstantDefinition EOF
            {
             newCompositeNode(grammarAccess.getConstantDefinitionRule()); 
            pushFollow(FOLLOW_ruleConstantDefinition_in_entryRuleConstantDefinition2181);
            iv_ruleConstantDefinition=ruleConstantDefinition();

            state._fsp--;

             current =iv_ruleConstantDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstantDefinition2191); 

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
    // $ANTLR end "entryRuleConstantDefinition"


    // $ANTLR start "ruleConstantDefinition"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:960:1: ruleConstantDefinition returns [EObject current=null] : (otherlv_0= 'constant' ( (lv_name_1_0= ruleVariableEntity ) ) ( (lv_value_2_0= ruleValue ) ) ) ;
    public final EObject ruleConstantDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_name_1_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:963:28: ( (otherlv_0= 'constant' ( (lv_name_1_0= ruleVariableEntity ) ) ( (lv_value_2_0= ruleValue ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:964:1: (otherlv_0= 'constant' ( (lv_name_1_0= ruleVariableEntity ) ) ( (lv_value_2_0= ruleValue ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:964:1: (otherlv_0= 'constant' ( (lv_name_1_0= ruleVariableEntity ) ) ( (lv_value_2_0= ruleValue ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:964:3: otherlv_0= 'constant' ( (lv_name_1_0= ruleVariableEntity ) ) ( (lv_value_2_0= ruleValue ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleConstantDefinition2228); 

                	newLeafNode(otherlv_0, grammarAccess.getConstantDefinitionAccess().getConstantKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:968:1: ( (lv_name_1_0= ruleVariableEntity ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:969:1: (lv_name_1_0= ruleVariableEntity )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:969:1: (lv_name_1_0= ruleVariableEntity )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:970:3: lv_name_1_0= ruleVariableEntity
            {
             
            	        newCompositeNode(grammarAccess.getConstantDefinitionAccess().getNameVariableEntityParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleVariableEntity_in_ruleConstantDefinition2249);
            lv_name_1_0=ruleVariableEntity();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConstantDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"VariableEntity");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:986:2: ( (lv_value_2_0= ruleValue ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:987:1: (lv_value_2_0= ruleValue )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:987:1: (lv_value_2_0= ruleValue )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:988:3: lv_value_2_0= ruleValue
            {
             
            	        newCompositeNode(grammarAccess.getConstantDefinitionAccess().getValueValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleValue_in_ruleConstantDefinition2270);
            lv_value_2_0=ruleValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConstantDefinitionRule());
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
    // $ANTLR end "ruleConstantDefinition"


    // $ANTLR start "entryRuleVariableEntity"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1012:1: entryRuleVariableEntity returns [EObject current=null] : iv_ruleVariableEntity= ruleVariableEntity EOF ;
    public final EObject entryRuleVariableEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableEntity = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1013:2: (iv_ruleVariableEntity= ruleVariableEntity EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1014:2: iv_ruleVariableEntity= ruleVariableEntity EOF
            {
             newCompositeNode(grammarAccess.getVariableEntityRule()); 
            pushFollow(FOLLOW_ruleVariableEntity_in_entryRuleVariableEntity2306);
            iv_ruleVariableEntity=ruleVariableEntity();

            state._fsp--;

             current =iv_ruleVariableEntity; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableEntity2316); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1021:1: ruleVariableEntity returns [EObject current=null] : ( (lv_name_0_0= ruleQualifiedName ) ) ;
    public final EObject ruleVariableEntity() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1024:28: ( ( (lv_name_0_0= ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1025:1: ( (lv_name_0_0= ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1025:1: ( (lv_name_0_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1026:1: (lv_name_0_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1026:1: (lv_name_0_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1027:3: lv_name_0_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getVariableEntityAccess().getNameQualifiedNameParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleVariableEntity2361);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1051:1: entryRuleTest returns [EObject current=null] : iv_ruleTest= ruleTest EOF ;
    public final EObject entryRuleTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTest = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1052:2: (iv_ruleTest= ruleTest EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1053:2: iv_ruleTest= ruleTest EOF
            {
             newCompositeNode(grammarAccess.getTestRule()); 
            pushFollow(FOLLOW_ruleTest_in_entryRuleTest2396);
            iv_ruleTest=ruleTest();

            state._fsp--;

             current =iv_ruleTest; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTest2406); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1060:1: ruleTest returns [EObject current=null] : (otherlv_0= 'test' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_results_3_0= ruleNamedResult ) )* (otherlv_4= '=' ( (lv_result_5_0= ruleValueOrEnumValue ) ) )? ) ;
    public final EObject ruleTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject lv_parameters_2_0 = null;

        EObject lv_results_3_0 = null;

        EObject lv_result_5_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1063:28: ( (otherlv_0= 'test' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_results_3_0= ruleNamedResult ) )* (otherlv_4= '=' ( (lv_result_5_0= ruleValueOrEnumValue ) ) )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1064:1: (otherlv_0= 'test' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_results_3_0= ruleNamedResult ) )* (otherlv_4= '=' ( (lv_result_5_0= ruleValueOrEnumValue ) ) )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1064:1: (otherlv_0= 'test' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_results_3_0= ruleNamedResult ) )* (otherlv_4= '=' ( (lv_result_5_0= ruleValueOrEnumValue ) ) )? )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1064:3: otherlv_0= 'test' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_results_3_0= ruleNamedResult ) )* (otherlv_4= '=' ( (lv_result_5_0= ruleValueOrEnumValue ) ) )?
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleTest2443); 

                	newLeafNode(otherlv_0, grammarAccess.getTestAccess().getTestKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1068:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1069:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1069:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1070:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTestRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTestAccess().getDefinitionTestDefinitionCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleTest2466);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1083:2: ( (lv_parameters_2_0= ruleParameter ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==RULE_ID) ) {
                    int LA16_1 = input.LA(2);

                    if ( (LA16_1==39) ) {
                        alt16=1;
                    }


                }
                else if ( (LA16_0==40) ) {
                    int LA16_2 = input.LA(2);

                    if ( (LA16_2==RULE_ID) ) {
                        int LA16_5 = input.LA(3);

                        if ( (LA16_5==39) ) {
                            alt16=1;
                        }


                    }


                }


                switch (alt16) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1084:1: (lv_parameters_2_0= ruleParameter )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1084:1: (lv_parameters_2_0= ruleParameter )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1085:3: lv_parameters_2_0= ruleParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTestAccess().getParametersParameterParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameter_in_ruleTest2487);
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
            	    break loop16;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1101:3: ( (lv_results_3_0= ruleNamedResult ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==RULE_ID||LA17_0==40) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1102:1: (lv_results_3_0= ruleNamedResult )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1102:1: (lv_results_3_0= ruleNamedResult )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1103:3: lv_results_3_0= ruleNamedResult
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTestAccess().getResultsNamedResultParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleNamedResult_in_ruleTest2509);
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
            	    break loop17;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1119:3: (otherlv_4= '=' ( (lv_result_5_0= ruleValueOrEnumValue ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==32) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1119:5: otherlv_4= '=' ( (lv_result_5_0= ruleValueOrEnumValue ) )
                    {
                    otherlv_4=(Token)match(input,32,FOLLOW_32_in_ruleTest2523); 

                        	newLeafNode(otherlv_4, grammarAccess.getTestAccess().getEqualsSignKeyword_4_0());
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1123:1: ( (lv_result_5_0= ruleValueOrEnumValue ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1124:1: (lv_result_5_0= ruleValueOrEnumValue )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1124:1: (lv_result_5_0= ruleValueOrEnumValue )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1125:3: lv_result_5_0= ruleValueOrEnumValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getTestAccess().getResultValueOrEnumValueParserRuleCall_4_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueOrEnumValue_in_ruleTest2544);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1149:1: entryRuleTableTest returns [EObject current=null] : iv_ruleTableTest= ruleTableTest EOF ;
    public final EObject entryRuleTableTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTableTest = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1150:2: (iv_ruleTableTest= ruleTableTest EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1151:2: iv_ruleTableTest= ruleTableTest EOF
            {
             newCompositeNode(grammarAccess.getTableTestRule()); 
            pushFollow(FOLLOW_ruleTableTest_in_entryRuleTableTest2582);
            iv_ruleTableTest=ruleTableTest();

            state._fsp--;

             current =iv_ruleTableTest; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTableTest2592); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1158:1: ruleTableTest returns [EObject current=null] : (otherlv_0= 'tabletest' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_parameterHeaders_3_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_4_0= ruleResultTableHeader ) )* ( (otherlv_5= '|' otherlv_6= '=' otherlv_7= '|' ) | otherlv_8= '|' ) ( (lv_rows_9_0= ruleTableTestRow ) )+ ) ;
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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1161:28: ( (otherlv_0= 'tabletest' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_parameterHeaders_3_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_4_0= ruleResultTableHeader ) )* ( (otherlv_5= '|' otherlv_6= '=' otherlv_7= '|' ) | otherlv_8= '|' ) ( (lv_rows_9_0= ruleTableTestRow ) )+ ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1162:1: (otherlv_0= 'tabletest' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_parameterHeaders_3_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_4_0= ruleResultTableHeader ) )* ( (otherlv_5= '|' otherlv_6= '=' otherlv_7= '|' ) | otherlv_8= '|' ) ( (lv_rows_9_0= ruleTableTestRow ) )+ )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1162:1: (otherlv_0= 'tabletest' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_parameterHeaders_3_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_4_0= ruleResultTableHeader ) )* ( (otherlv_5= '|' otherlv_6= '=' otherlv_7= '|' ) | otherlv_8= '|' ) ( (lv_rows_9_0= ruleTableTestRow ) )+ )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1162:3: otherlv_0= 'tabletest' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* ( (lv_parameterHeaders_3_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_4_0= ruleResultTableHeader ) )* ( (otherlv_5= '|' otherlv_6= '=' otherlv_7= '|' ) | otherlv_8= '|' ) ( (lv_rows_9_0= ruleTableTestRow ) )+
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_ruleTableTest2629); 

                	newLeafNode(otherlv_0, grammarAccess.getTableTestAccess().getTabletestKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1166:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1167:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1167:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1168:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTableTestRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTableTestAccess().getDefinitionTestDefinitionCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleTableTest2652);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1181:2: ( (lv_parameters_2_0= ruleParameter ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID||LA19_0==40) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1182:1: (lv_parameters_2_0= ruleParameter )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1182:1: (lv_parameters_2_0= ruleParameter )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1183:3: lv_parameters_2_0= ruleParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getParametersParameterParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameter_in_ruleTableTest2673);
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
            	    break loop19;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1199:3: ( (lv_parameterHeaders_3_0= ruleParameterTableHeader ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==34) ) {
                    int LA20_1 = input.LA(2);

                    if ( (LA20_1==RULE_ID) ) {
                        int LA20_2 = input.LA(3);

                        if ( (LA20_2==34) ) {
                            alt20=1;
                        }


                    }
                    else if ( (LA20_1==40) ) {
                        int LA20_3 = input.LA(3);

                        if ( (LA20_3==RULE_ID) ) {
                            int LA20_6 = input.LA(4);

                            if ( (LA20_6==34) ) {
                                alt20=1;
                            }


                        }


                    }


                }


                switch (alt20) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1200:1: (lv_parameterHeaders_3_0= ruleParameterTableHeader )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1200:1: (lv_parameterHeaders_3_0= ruleParameterTableHeader )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1201:3: lv_parameterHeaders_3_0= ruleParameterTableHeader
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getParameterHeadersParameterTableHeaderParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameterTableHeader_in_ruleTableTest2695);
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
            	    break loop20;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1217:3: ( (lv_resultHeaders_4_0= ruleResultTableHeader ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==34) ) {
                    int LA21_1 = input.LA(2);

                    if ( (LA21_1==RULE_ID||LA21_1==40) ) {
                        alt21=1;
                    }


                }


                switch (alt21) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1218:1: (lv_resultHeaders_4_0= ruleResultTableHeader )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1218:1: (lv_resultHeaders_4_0= ruleResultTableHeader )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1219:3: lv_resultHeaders_4_0= ruleResultTableHeader
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getResultHeadersResultTableHeaderParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleResultTableHeader_in_ruleTableTest2717);
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
            	    break loop21;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1235:3: ( (otherlv_5= '|' otherlv_6= '=' otherlv_7= '|' ) | otherlv_8= '|' )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==34) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==32) ) {
                    alt22=1;
                }
                else if ( (LA22_1==34) ) {
                    alt22=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 22, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1235:4: (otherlv_5= '|' otherlv_6= '=' otherlv_7= '|' )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1235:4: (otherlv_5= '|' otherlv_6= '=' otherlv_7= '|' )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1235:6: otherlv_5= '|' otherlv_6= '=' otherlv_7= '|'
                    {
                    otherlv_5=(Token)match(input,34,FOLLOW_34_in_ruleTableTest2732); 

                        	newLeafNode(otherlv_5, grammarAccess.getTableTestAccess().getVerticalLineKeyword_5_0_0());
                        
                    otherlv_6=(Token)match(input,32,FOLLOW_32_in_ruleTableTest2744); 

                        	newLeafNode(otherlv_6, grammarAccess.getTableTestAccess().getEqualsSignKeyword_5_0_1());
                        
                    otherlv_7=(Token)match(input,34,FOLLOW_34_in_ruleTableTest2756); 

                        	newLeafNode(otherlv_7, grammarAccess.getTableTestAccess().getVerticalLineKeyword_5_0_2());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1248:7: otherlv_8= '|'
                    {
                    otherlv_8=(Token)match(input,34,FOLLOW_34_in_ruleTableTest2775); 

                        	newLeafNode(otherlv_8, grammarAccess.getTableTestAccess().getVerticalLineKeyword_5_1());
                        

                    }
                    break;

            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1252:2: ( (lv_rows_9_0= ruleTableTestRow ) )+
            int cnt23=0;
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==34) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1253:1: (lv_rows_9_0= ruleTableTestRow )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1253:1: (lv_rows_9_0= ruleTableTestRow )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1254:3: lv_rows_9_0= ruleTableTestRow
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getRowsTableTestRowParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTableTestRow_in_ruleTableTest2797);
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
            	    if ( cnt23 >= 1 ) break loop23;
                        EarlyExitException eee =
                            new EarlyExitException(23, input);
                        throw eee;
                }
                cnt23++;
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1278:1: entryRuleTableTestRow returns [EObject current=null] : iv_ruleTableTestRow= ruleTableTestRow EOF ;
    public final EObject entryRuleTableTestRow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTableTestRow = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1279:2: (iv_ruleTableTestRow= ruleTableTestRow EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1280:2: iv_ruleTableTestRow= ruleTableTestRow EOF
            {
             newCompositeNode(grammarAccess.getTableTestRowRule()); 
            pushFollow(FOLLOW_ruleTableTestRow_in_entryRuleTableTestRow2834);
            iv_ruleTableTestRow=ruleTableTestRow();

            state._fsp--;

             current =iv_ruleTableTestRow; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTableTestRow2844); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1287:1: ruleTableTestRow returns [EObject current=null] : ( () ( (lv_values_1_0= ruleParameterTableValue ) )* ( (otherlv_2= '|' otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) otherlv_5= '|' ) | otherlv_6= '|' ) ) ;
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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1290:28: ( ( () ( (lv_values_1_0= ruleParameterTableValue ) )* ( (otherlv_2= '|' otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) otherlv_5= '|' ) | otherlv_6= '|' ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1291:1: ( () ( (lv_values_1_0= ruleParameterTableValue ) )* ( (otherlv_2= '|' otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) otherlv_5= '|' ) | otherlv_6= '|' ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1291:1: ( () ( (lv_values_1_0= ruleParameterTableValue ) )* ( (otherlv_2= '|' otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) otherlv_5= '|' ) | otherlv_6= '|' ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1291:2: () ( (lv_values_1_0= ruleParameterTableValue ) )* ( (otherlv_2= '|' otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) otherlv_5= '|' ) | otherlv_6= '|' )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1291:2: ()
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1292:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTableTestRowAccess().getTableTestRowAction_0(),
                        current);
                

            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1297:2: ( (lv_values_1_0= ruleParameterTableValue ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==34) ) {
                    int LA24_1 = input.LA(2);

                    if ( ((LA24_1>=RULE_STRING && LA24_1<=RULE_UPPERCASE_ID)) ) {
                        alt24=1;
                    }


                }


                switch (alt24) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1298:1: (lv_values_1_0= ruleParameterTableValue )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1298:1: (lv_values_1_0= ruleParameterTableValue )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1299:3: lv_values_1_0= ruleParameterTableValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestRowAccess().getValuesParameterTableValueParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameterTableValue_in_ruleTableTestRow2899);
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
            	    break loop24;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1315:3: ( (otherlv_2= '|' otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) otherlv_5= '|' ) | otherlv_6= '|' )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==34) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==32) ) {
                    alt25=1;
                }
                else if ( (LA25_1==EOF||(LA25_1>=RULE_SL_VISIBLE_COMMENT && LA25_1<=RULE_ML_VISIBLE_COMMENT)||LA25_1==26||LA25_1==28||(LA25_1>=30 && LA25_1<=31)||(LA25_1>=33 && LA25_1<=35)||LA25_1==37) ) {
                    alt25=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1315:4: (otherlv_2= '|' otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) otherlv_5= '|' )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1315:4: (otherlv_2= '|' otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) otherlv_5= '|' )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1315:6: otherlv_2= '|' otherlv_3= '=' ( (lv_result_4_0= ruleValueOrEnumValue ) ) otherlv_5= '|'
                    {
                    otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleTableTestRow2914); 

                        	newLeafNode(otherlv_2, grammarAccess.getTableTestRowAccess().getVerticalLineKeyword_2_0_0());
                        
                    otherlv_3=(Token)match(input,32,FOLLOW_32_in_ruleTableTestRow2926); 

                        	newLeafNode(otherlv_3, grammarAccess.getTableTestRowAccess().getEqualsSignKeyword_2_0_1());
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1323:1: ( (lv_result_4_0= ruleValueOrEnumValue ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1324:1: (lv_result_4_0= ruleValueOrEnumValue )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1324:1: (lv_result_4_0= ruleValueOrEnumValue )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1325:3: lv_result_4_0= ruleValueOrEnumValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getTableTestRowAccess().getResultValueOrEnumValueParserRuleCall_2_0_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueOrEnumValue_in_ruleTableTestRow2947);
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

                    otherlv_5=(Token)match(input,34,FOLLOW_34_in_ruleTableTestRow2959); 

                        	newLeafNode(otherlv_5, grammarAccess.getTableTestRowAccess().getVerticalLineKeyword_2_0_3());
                        

                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1346:7: otherlv_6= '|'
                    {
                    otherlv_6=(Token)match(input,34,FOLLOW_34_in_ruleTableTestRow2978); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1358:1: entryRuleParameterTableHeader returns [EObject current=null] : iv_ruleParameterTableHeader= ruleParameterTableHeader EOF ;
    public final EObject entryRuleParameterTableHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterTableHeader = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1359:2: (iv_ruleParameterTableHeader= ruleParameterTableHeader EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1360:2: iv_ruleParameterTableHeader= ruleParameterTableHeader EOF
            {
             newCompositeNode(grammarAccess.getParameterTableHeaderRule()); 
            pushFollow(FOLLOW_ruleParameterTableHeader_in_entryRuleParameterTableHeader3015);
            iv_ruleParameterTableHeader=ruleParameterTableHeader();

            state._fsp--;

             current =iv_ruleParameterTableHeader; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterTableHeader3025); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1367:1: ruleParameterTableHeader returns [EObject current=null] : (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) ) ;
    public final EObject ruleParameterTableHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1370:28: ( (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1371:1: (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1371:1: (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1371:3: otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) )
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_ruleParameterTableHeader3062); 

                	newLeafNode(otherlv_0, grammarAccess.getParameterTableHeaderAccess().getVerticalLineKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1375:1: ( (lv_name_1_0= ruleParameterName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1376:1: (lv_name_1_0= ruleParameterName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1376:1: (lv_name_1_0= ruleParameterName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1377:3: lv_name_1_0= ruleParameterName
            {
             
            	        newCompositeNode(grammarAccess.getParameterTableHeaderAccess().getNameParameterNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleParameterName_in_ruleParameterTableHeader3083);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1401:1: entryRuleResultTableHeader returns [EObject current=null] : iv_ruleResultTableHeader= ruleResultTableHeader EOF ;
    public final EObject entryRuleResultTableHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultTableHeader = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1402:2: (iv_ruleResultTableHeader= ruleResultTableHeader EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1403:2: iv_ruleResultTableHeader= ruleResultTableHeader EOF
            {
             newCompositeNode(grammarAccess.getResultTableHeaderRule()); 
            pushFollow(FOLLOW_ruleResultTableHeader_in_entryRuleResultTableHeader3119);
            iv_ruleResultTableHeader=ruleResultTableHeader();

            state._fsp--;

             current =iv_ruleResultTableHeader; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultTableHeader3129); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1410:1: ruleResultTableHeader returns [EObject current=null] : (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' ) ;
    public final EObject ruleResultTableHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1413:28: ( (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1414:1: (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1414:1: (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1414:3: otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '='
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_ruleResultTableHeader3166); 

                	newLeafNode(otherlv_0, grammarAccess.getResultTableHeaderAccess().getVerticalLineKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1418:1: ( (lv_name_1_0= ruleResultName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1419:1: (lv_name_1_0= ruleResultName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1419:1: (lv_name_1_0= ruleResultName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1420:3: lv_name_1_0= ruleResultName
            {
             
            	        newCompositeNode(grammarAccess.getResultTableHeaderAccess().getNameResultNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleResultName_in_ruleResultTableHeader3187);
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

            otherlv_2=(Token)match(input,32,FOLLOW_32_in_ruleResultTableHeader3199); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1448:1: entryRuleParameterTableValue returns [EObject current=null] : iv_ruleParameterTableValue= ruleParameterTableValue EOF ;
    public final EObject entryRuleParameterTableValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterTableValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1449:2: (iv_ruleParameterTableValue= ruleParameterTableValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1450:2: iv_ruleParameterTableValue= ruleParameterTableValue EOF
            {
             newCompositeNode(grammarAccess.getParameterTableValueRule()); 
            pushFollow(FOLLOW_ruleParameterTableValue_in_entryRuleParameterTableValue3235);
            iv_ruleParameterTableValue=ruleParameterTableValue();

            state._fsp--;

             current =iv_ruleParameterTableValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterTableValue3245); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1457:1: ruleParameterTableValue returns [EObject current=null] : (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValue ) ) ) ;
    public final EObject ruleParameterTableValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1460:28: ( (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValue ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1461:1: (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValue ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1461:1: (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValue ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1461:3: otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValue ) )
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_ruleParameterTableValue3282); 

                	newLeafNode(otherlv_0, grammarAccess.getParameterTableValueAccess().getVerticalLineKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1465:1: ( (lv_value_1_0= ruleValueOrEnumValue ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1466:1: (lv_value_1_0= ruleValueOrEnumValue )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1466:1: (lv_value_1_0= ruleValueOrEnumValue )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1467:3: lv_value_1_0= ruleValueOrEnumValue
            {
             
            	        newCompositeNode(grammarAccess.getParameterTableValueAccess().getValueValueOrEnumValueParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_ruleParameterTableValue3303);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1491:1: entryRuleNamedResult returns [EObject current=null] : iv_ruleNamedResult= ruleNamedResult EOF ;
    public final EObject entryRuleNamedResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedResult = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1492:2: (iv_ruleNamedResult= ruleNamedResult EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1493:2: iv_ruleNamedResult= ruleNamedResult EOF
            {
             newCompositeNode(grammarAccess.getNamedResultRule()); 
            pushFollow(FOLLOW_ruleNamedResult_in_entryRuleNamedResult3339);
            iv_ruleNamedResult=ruleNamedResult();

            state._fsp--;

             current =iv_ruleNamedResult; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedResult3349); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1500:1: ruleNamedResult returns [EObject current=null] : ( ( (lv_name_0_0= ruleResultName ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValueOrEnumValue ) ) ) ;
    public final EObject ruleNamedResult() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1503:28: ( ( ( (lv_name_0_0= ruleResultName ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValueOrEnumValue ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1504:1: ( ( (lv_name_0_0= ruleResultName ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValueOrEnumValue ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1504:1: ( ( (lv_name_0_0= ruleResultName ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValueOrEnumValue ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1504:2: ( (lv_name_0_0= ruleResultName ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValueOrEnumValue ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1504:2: ( (lv_name_0_0= ruleResultName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1505:1: (lv_name_0_0= ruleResultName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1505:1: (lv_name_0_0= ruleResultName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1506:3: lv_name_0_0= ruleResultName
            {
             
            	        newCompositeNode(grammarAccess.getNamedResultAccess().getNameResultNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleResultName_in_ruleNamedResult3395);
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

            otherlv_1=(Token)match(input,32,FOLLOW_32_in_ruleNamedResult3407); 

                	newLeafNode(otherlv_1, grammarAccess.getNamedResultAccess().getEqualsSignKeyword_1());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1526:1: ( (lv_value_2_0= ruleValueOrEnumValue ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1527:1: (lv_value_2_0= ruleValueOrEnumValue )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1527:1: (lv_value_2_0= ruleValueOrEnumValue )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1528:3: lv_value_2_0= ruleValueOrEnumValue
            {
             
            	        newCompositeNode(grammarAccess.getNamedResultAccess().getValueValueOrEnumValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_ruleNamedResult3428);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1552:1: entryRuleResultName returns [EObject current=null] : iv_ruleResultName= ruleResultName EOF ;
    public final EObject entryRuleResultName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1553:2: (iv_ruleResultName= ruleResultName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1554:2: iv_ruleResultName= ruleResultName EOF
            {
             newCompositeNode(grammarAccess.getResultNameRule()); 
            pushFollow(FOLLOW_ruleResultName_in_entryRuleResultName3464);
            iv_ruleResultName=ruleResultName();

            state._fsp--;

             current =iv_ruleResultName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultName3474); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1561:1: ruleResultName returns [EObject current=null] : (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) ;
    public final EObject ruleResultName() throws RecognitionException {
        EObject current = null;

        EObject this_FixedResultName_0 = null;

        EObject this_ArbitraryParameterOrResultName_1 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1564:28: ( (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1565:1: (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1565:1: (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==RULE_ID) ) {
                alt26=1;
            }
            else if ( (LA26_0==40) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1566:5: this_FixedResultName_0= ruleFixedResultName
                    {
                     
                            newCompositeNode(grammarAccess.getResultNameAccess().getFixedResultNameParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleFixedResultName_in_ruleResultName3521);
                    this_FixedResultName_0=ruleFixedResultName();

                    state._fsp--;

                     
                            current = this_FixedResultName_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1576:5: this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName
                    {
                     
                            newCompositeNode(grammarAccess.getResultNameAccess().getArbitraryParameterOrResultNameParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleArbitraryParameterOrResultName_in_ruleResultName3548);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1592:1: entryRuleFixedResultName returns [EObject current=null] : iv_ruleFixedResultName= ruleFixedResultName EOF ;
    public final EObject entryRuleFixedResultName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedResultName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1593:2: (iv_ruleFixedResultName= ruleFixedResultName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1594:2: iv_ruleFixedResultName= ruleFixedResultName EOF
            {
             newCompositeNode(grammarAccess.getFixedResultNameRule()); 
            pushFollow(FOLLOW_ruleFixedResultName_in_entryRuleFixedResultName3583);
            iv_ruleFixedResultName=ruleFixedResultName();

            state._fsp--;

             current =iv_ruleFixedResultName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFixedResultName3593); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1601:1: ruleFixedResultName returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleFixedResultName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1604:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1605:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1605:1: ( (otherlv_0= RULE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1606:1: (otherlv_0= RULE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1606:1: (otherlv_0= RULE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1607:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFixedResultNameRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFixedResultName3637); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1626:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1627:2: (iv_ruleCall= ruleCall EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1628:2: iv_ruleCall= ruleCall EOF
            {
             newCompositeNode(grammarAccess.getCallRule()); 
            pushFollow(FOLLOW_ruleCall_in_entryRuleCall3672);
            iv_ruleCall=ruleCall();

            state._fsp--;

             current =iv_ruleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCall3682); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1635:1: ruleCall returns [EObject current=null] : (otherlv_0= 'call' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* (otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) ) )? ) ;
    public final EObject ruleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_parameters_2_0 = null;

        EObject lv_result_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1638:28: ( (otherlv_0= 'call' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* (otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) ) )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1639:1: (otherlv_0= 'call' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* (otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) ) )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1639:1: (otherlv_0= 'call' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* (otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) ) )? )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1639:3: otherlv_0= 'call' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleParameter ) )* (otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) ) )?
            {
            otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleCall3719); 

                	newLeafNode(otherlv_0, grammarAccess.getCallAccess().getCallKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1643:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1644:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1644:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1645:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCallRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getCallAccess().getDefinitionCallDefinitionCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleCall3742);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1658:2: ( (lv_parameters_2_0= ruleParameter ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_ID||LA27_0==40) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1659:1: (lv_parameters_2_0= ruleParameter )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1659:1: (lv_parameters_2_0= ruleParameter )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1660:3: lv_parameters_2_0= ruleParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCallAccess().getParametersParameterParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameter_in_ruleCall3763);
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
            	    break loop27;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1676:3: (otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==36) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1676:5: otherlv_3= 'sets' ( (lv_result_4_0= ruleVariable ) )
                    {
                    otherlv_3=(Token)match(input,36,FOLLOW_36_in_ruleCall3777); 

                        	newLeafNode(otherlv_3, grammarAccess.getCallAccess().getSetsKeyword_3_0());
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1680:1: ( (lv_result_4_0= ruleVariable ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1681:1: (lv_result_4_0= ruleVariable )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1681:1: (lv_result_4_0= ruleVariable )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1682:3: lv_result_4_0= ruleVariable
                    {
                     
                    	        newCompositeNode(grammarAccess.getCallAccess().getResultVariableParserRuleCall_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVariable_in_ruleCall3798);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1706:1: entryRuleSuite returns [EObject current=null] : iv_ruleSuite= ruleSuite EOF ;
    public final EObject entryRuleSuite() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuite = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1707:2: (iv_ruleSuite= ruleSuite EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1708:2: iv_ruleSuite= ruleSuite EOF
            {
             newCompositeNode(grammarAccess.getSuiteRule()); 
            pushFollow(FOLLOW_ruleSuite_in_entryRuleSuite3836);
            iv_ruleSuite=ruleSuite();

            state._fsp--;

             current =iv_ruleSuite; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuite3846); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1715:1: ruleSuite returns [EObject current=null] : (otherlv_0= 'suite' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleSuiteParameter ) )* (otherlv_3= 'on' ( ( ruleQualifiedName ) ) )? ) ;
    public final EObject ruleSuite() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_parameters_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1718:28: ( (otherlv_0= 'suite' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleSuiteParameter ) )* (otherlv_3= 'on' ( ( ruleQualifiedName ) ) )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1719:1: (otherlv_0= 'suite' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleSuiteParameter ) )* (otherlv_3= 'on' ( ( ruleQualifiedName ) ) )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1719:1: (otherlv_0= 'suite' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleSuiteParameter ) )* (otherlv_3= 'on' ( ( ruleQualifiedName ) ) )? )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1719:3: otherlv_0= 'suite' ( ( ruleQualifiedName ) ) ( (lv_parameters_2_0= ruleSuiteParameter ) )* (otherlv_3= 'on' ( ( ruleQualifiedName ) ) )?
            {
            otherlv_0=(Token)match(input,37,FOLLOW_37_in_ruleSuite3883); 

                	newLeafNode(otherlv_0, grammarAccess.getSuiteAccess().getSuiteKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1723:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1724:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1724:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1725:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSuiteRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSuiteAccess().getDefinitionSuiteDefinitionCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuite3906);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1738:2: ( (lv_parameters_2_0= ruleSuiteParameter ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==RULE_ID) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1739:1: (lv_parameters_2_0= ruleSuiteParameter )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1739:1: (lv_parameters_2_0= ruleSuiteParameter )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1740:3: lv_parameters_2_0= ruleSuiteParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSuiteAccess().getParametersSuiteParameterParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSuiteParameter_in_ruleSuite3927);
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
            	    break loop29;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1756:3: (otherlv_3= 'on' ( ( ruleQualifiedName ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==38) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1756:5: otherlv_3= 'on' ( ( ruleQualifiedName ) )
                    {
                    otherlv_3=(Token)match(input,38,FOLLOW_38_in_ruleSuite3941); 

                        	newLeafNode(otherlv_3, grammarAccess.getSuiteAccess().getOnKeyword_3_0());
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1760:1: ( ( ruleQualifiedName ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1761:1: ( ruleQualifiedName )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1761:1: ( ruleQualifiedName )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1762:3: ruleQualifiedName
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSuiteRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getSuiteAccess().getForkForkDefinitionCrossReference_3_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuite3964);
                    ruleQualifiedName();

                    state._fsp--;

                     
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
    // $ANTLR end "ruleSuite"


    // $ANTLR start "entryRuleSuiteParameter"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1783:1: entryRuleSuiteParameter returns [EObject current=null] : iv_ruleSuiteParameter= ruleSuiteParameter EOF ;
    public final EObject entryRuleSuiteParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteParameter = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1784:2: (iv_ruleSuiteParameter= ruleSuiteParameter EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1785:2: iv_ruleSuiteParameter= ruleSuiteParameter EOF
            {
             newCompositeNode(grammarAccess.getSuiteParameterRule()); 
            pushFollow(FOLLOW_ruleSuiteParameter_in_entryRuleSuiteParameter4002);
            iv_ruleSuiteParameter=ruleSuiteParameter();

            state._fsp--;

             current =iv_ruleSuiteParameter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteParameter4012); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1792:1: ruleSuiteParameter returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValue ) ) ) ;
    public final EObject ruleSuiteParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1795:28: ( ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValue ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1796:1: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValue ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1796:1: ( ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValue ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1796:2: ( ( ruleQualifiedName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValue ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1796:2: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1797:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1797:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1798:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSuiteParameterRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSuiteParameterAccess().getNameVariableEntityCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuiteParameter4060);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,39,FOLLOW_39_in_ruleSuiteParameter4072); 

                	newLeafNode(otherlv_1, grammarAccess.getSuiteParameterAccess().getColonKeyword_1());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1815:1: ( (lv_value_2_0= ruleValue ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1816:1: (lv_value_2_0= ruleValue )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1816:1: (lv_value_2_0= ruleValue )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1817:3: lv_value_2_0= ruleValue
            {
             
            	        newCompositeNode(grammarAccess.getSuiteParameterAccess().getValueValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleValue_in_ruleSuiteParameter4093);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1841:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1842:2: (iv_ruleParameter= ruleParameter EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1843:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter4129);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter4139); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1850:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= ruleParameterName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValueOrEnumValue ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1853:28: ( ( ( (lv_name_0_0= ruleParameterName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValueOrEnumValue ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1854:1: ( ( (lv_name_0_0= ruleParameterName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValueOrEnumValue ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1854:1: ( ( (lv_name_0_0= ruleParameterName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValueOrEnumValue ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1854:2: ( (lv_name_0_0= ruleParameterName ) ) otherlv_1= ':' ( (lv_value_2_0= ruleValueOrEnumValue ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1854:2: ( (lv_name_0_0= ruleParameterName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1855:1: (lv_name_0_0= ruleParameterName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1855:1: (lv_name_0_0= ruleParameterName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1856:3: lv_name_0_0= ruleParameterName
            {
             
            	        newCompositeNode(grammarAccess.getParameterAccess().getNameParameterNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleParameterName_in_ruleParameter4185);
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

            otherlv_1=(Token)match(input,39,FOLLOW_39_in_ruleParameter4197); 

                	newLeafNode(otherlv_1, grammarAccess.getParameterAccess().getColonKeyword_1());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1876:1: ( (lv_value_2_0= ruleValueOrEnumValue ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1877:1: (lv_value_2_0= ruleValueOrEnumValue )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1877:1: (lv_value_2_0= ruleValueOrEnumValue )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1878:3: lv_value_2_0= ruleValueOrEnumValue
            {
             
            	        newCompositeNode(grammarAccess.getParameterAccess().getValueValueOrEnumValueParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_ruleParameter4218);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1902:1: entryRuleParameterName returns [EObject current=null] : iv_ruleParameterName= ruleParameterName EOF ;
    public final EObject entryRuleParameterName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1903:2: (iv_ruleParameterName= ruleParameterName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1904:2: iv_ruleParameterName= ruleParameterName EOF
            {
             newCompositeNode(grammarAccess.getParameterNameRule()); 
            pushFollow(FOLLOW_ruleParameterName_in_entryRuleParameterName4254);
            iv_ruleParameterName=ruleParameterName();

            state._fsp--;

             current =iv_ruleParameterName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterName4264); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1911:1: ruleParameterName returns [EObject current=null] : (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) ;
    public final EObject ruleParameterName() throws RecognitionException {
        EObject current = null;

        EObject this_FixedParameterName_0 = null;

        EObject this_ArbitraryParameterOrResultName_1 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1914:28: ( (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1915:1: (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1915:1: (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==RULE_ID) ) {
                alt31=1;
            }
            else if ( (LA31_0==40) ) {
                alt31=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }
            switch (alt31) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1916:5: this_FixedParameterName_0= ruleFixedParameterName
                    {
                     
                            newCompositeNode(grammarAccess.getParameterNameAccess().getFixedParameterNameParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleFixedParameterName_in_ruleParameterName4311);
                    this_FixedParameterName_0=ruleFixedParameterName();

                    state._fsp--;

                     
                            current = this_FixedParameterName_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1926:5: this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName
                    {
                     
                            newCompositeNode(grammarAccess.getParameterNameAccess().getArbitraryParameterOrResultNameParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleArbitraryParameterOrResultName_in_ruleParameterName4338);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1942:1: entryRuleFixedParameterName returns [EObject current=null] : iv_ruleFixedParameterName= ruleFixedParameterName EOF ;
    public final EObject entryRuleFixedParameterName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedParameterName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1943:2: (iv_ruleFixedParameterName= ruleFixedParameterName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1944:2: iv_ruleFixedParameterName= ruleFixedParameterName EOF
            {
             newCompositeNode(grammarAccess.getFixedParameterNameRule()); 
            pushFollow(FOLLOW_ruleFixedParameterName_in_entryRuleFixedParameterName4373);
            iv_ruleFixedParameterName=ruleFixedParameterName();

            state._fsp--;

             current =iv_ruleFixedParameterName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFixedParameterName4383); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1951:1: ruleFixedParameterName returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleFixedParameterName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1954:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1955:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1955:1: ( (otherlv_0= RULE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1956:1: (otherlv_0= RULE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1956:1: (otherlv_0= RULE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1957:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFixedParameterNameRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFixedParameterName4427); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1976:1: entryRuleArbitraryParameterOrResultName returns [EObject current=null] : iv_ruleArbitraryParameterOrResultName= ruleArbitraryParameterOrResultName EOF ;
    public final EObject entryRuleArbitraryParameterOrResultName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArbitraryParameterOrResultName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1977:2: (iv_ruleArbitraryParameterOrResultName= ruleArbitraryParameterOrResultName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1978:2: iv_ruleArbitraryParameterOrResultName= ruleArbitraryParameterOrResultName EOF
            {
             newCompositeNode(grammarAccess.getArbitraryParameterOrResultNameRule()); 
            pushFollow(FOLLOW_ruleArbitraryParameterOrResultName_in_entryRuleArbitraryParameterOrResultName4462);
            iv_ruleArbitraryParameterOrResultName=ruleArbitraryParameterOrResultName();

            state._fsp--;

             current =iv_ruleArbitraryParameterOrResultName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArbitraryParameterOrResultName4472); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1985:1: ruleArbitraryParameterOrResultName returns [EObject current=null] : (otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) ) ) ;
    public final EObject ruleArbitraryParameterOrResultName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_identifier_1_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1988:28: ( (otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1989:1: (otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1989:1: (otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1989:3: otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,40,FOLLOW_40_in_ruleArbitraryParameterOrResultName4509); 

                	newLeafNode(otherlv_0, grammarAccess.getArbitraryParameterOrResultNameAccess().getPlusSignKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1993:1: ( (lv_identifier_1_0= RULE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1994:1: (lv_identifier_1_0= RULE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1994:1: (lv_identifier_1_0= RULE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1995:3: lv_identifier_1_0= RULE_ID
            {
            lv_identifier_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleArbitraryParameterOrResultName4526); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2019:1: entryRuleValueOrEnumValue returns [EObject current=null] : iv_ruleValueOrEnumValue= ruleValueOrEnumValue EOF ;
    public final EObject entryRuleValueOrEnumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueOrEnumValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2020:2: (iv_ruleValueOrEnumValue= ruleValueOrEnumValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2021:2: iv_ruleValueOrEnumValue= ruleValueOrEnumValue EOF
            {
             newCompositeNode(grammarAccess.getValueOrEnumValueRule()); 
            pushFollow(FOLLOW_ruleValueOrEnumValue_in_entryRuleValueOrEnumValue4567);
            iv_ruleValueOrEnumValue=ruleValueOrEnumValue();

            state._fsp--;

             current =iv_ruleValueOrEnumValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueOrEnumValue4577); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2028:1: ruleValueOrEnumValue returns [EObject current=null] : (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue ) ;
    public final EObject ruleValueOrEnumValue() throws RecognitionException {
        EObject current = null;

        EObject this_Value_0 = null;

        EObject this_EnumValue_1 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2031:28: ( (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2032:1: (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2032:1: (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=RULE_STRING && LA32_0<=RULE_DECIMAL)) ) {
                alt32=1;
            }
            else if ( (LA32_0==RULE_UPPERCASE_ID) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2033:5: this_Value_0= ruleValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueOrEnumValueAccess().getValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleValue_in_ruleValueOrEnumValue4624);
                    this_Value_0=ruleValue();

                    state._fsp--;

                     
                            current = this_Value_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2043:5: this_EnumValue_1= ruleEnumValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueOrEnumValueAccess().getEnumValueParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEnumValue_in_ruleValueOrEnumValue4651);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2059:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2060:2: (iv_ruleValue= ruleValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2061:2: iv_ruleValue= ruleValue EOF
            {
             newCompositeNode(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue4686);
            iv_ruleValue=ruleValue();

            state._fsp--;

             current =iv_ruleValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue4696); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2068:1: ruleValue returns [EObject current=null] : (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_Variable_3= ruleVariable ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        EObject this_StringValue_0 = null;

        EObject this_IntegerValue_1 = null;

        EObject this_DecimalValue_2 = null;

        EObject this_Variable_3 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2071:28: ( (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_Variable_3= ruleVariable ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2072:1: (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_Variable_3= ruleVariable )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2072:1: (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_Variable_3= ruleVariable )
            int alt33=4;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt33=1;
                }
                break;
            case RULE_INTEGER:
                {
                alt33=2;
                }
                break;
            case RULE_DECIMAL:
                {
                alt33=3;
                }
                break;
            case RULE_ID:
                {
                alt33=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2073:5: this_StringValue_0= ruleStringValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getStringValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleStringValue_in_ruleValue4743);
                    this_StringValue_0=ruleStringValue();

                    state._fsp--;

                     
                            current = this_StringValue_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2083:5: this_IntegerValue_1= ruleIntegerValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getIntegerValueParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleIntegerValue_in_ruleValue4770);
                    this_IntegerValue_1=ruleIntegerValue();

                    state._fsp--;

                     
                            current = this_IntegerValue_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2093:5: this_DecimalValue_2= ruleDecimalValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getDecimalValueParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleDecimalValue_in_ruleValue4797);
                    this_DecimalValue_2=ruleDecimalValue();

                    state._fsp--;

                     
                            current = this_DecimalValue_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2103:5: this_Variable_3= ruleVariable
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getVariableParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleVariable_in_ruleValue4824);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2119:1: entryRuleIntegerValue returns [EObject current=null] : iv_ruleIntegerValue= ruleIntegerValue EOF ;
    public final EObject entryRuleIntegerValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2120:2: (iv_ruleIntegerValue= ruleIntegerValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2121:2: iv_ruleIntegerValue= ruleIntegerValue EOF
            {
             newCompositeNode(grammarAccess.getIntegerValueRule()); 
            pushFollow(FOLLOW_ruleIntegerValue_in_entryRuleIntegerValue4859);
            iv_ruleIntegerValue=ruleIntegerValue();

            state._fsp--;

             current =iv_ruleIntegerValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerValue4869); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2128:1: ruleIntegerValue returns [EObject current=null] : ( (lv_integerValue_0_0= RULE_INTEGER ) ) ;
    public final EObject ruleIntegerValue() throws RecognitionException {
        EObject current = null;

        Token lv_integerValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2131:28: ( ( (lv_integerValue_0_0= RULE_INTEGER ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2132:1: ( (lv_integerValue_0_0= RULE_INTEGER ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2132:1: ( (lv_integerValue_0_0= RULE_INTEGER ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2133:1: (lv_integerValue_0_0= RULE_INTEGER )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2133:1: (lv_integerValue_0_0= RULE_INTEGER )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2134:3: lv_integerValue_0_0= RULE_INTEGER
            {
            lv_integerValue_0_0=(Token)match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleIntegerValue4910); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2158:1: entryRuleDecimalValue returns [EObject current=null] : iv_ruleDecimalValue= ruleDecimalValue EOF ;
    public final EObject entryRuleDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecimalValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2159:2: (iv_ruleDecimalValue= ruleDecimalValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2160:2: iv_ruleDecimalValue= ruleDecimalValue EOF
            {
             newCompositeNode(grammarAccess.getDecimalValueRule()); 
            pushFollow(FOLLOW_ruleDecimalValue_in_entryRuleDecimalValue4950);
            iv_ruleDecimalValue=ruleDecimalValue();

            state._fsp--;

             current =iv_ruleDecimalValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalValue4960); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2167:1: ruleDecimalValue returns [EObject current=null] : ( (lv_decimalValue_0_0= RULE_DECIMAL ) ) ;
    public final EObject ruleDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_decimalValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2170:28: ( ( (lv_decimalValue_0_0= RULE_DECIMAL ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2171:1: ( (lv_decimalValue_0_0= RULE_DECIMAL ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2171:1: ( (lv_decimalValue_0_0= RULE_DECIMAL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2172:1: (lv_decimalValue_0_0= RULE_DECIMAL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2172:1: (lv_decimalValue_0_0= RULE_DECIMAL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2173:3: lv_decimalValue_0_0= RULE_DECIMAL
            {
            lv_decimalValue_0_0=(Token)match(input,RULE_DECIMAL,FOLLOW_RULE_DECIMAL_in_ruleDecimalValue5001); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2197:1: entryRuleStringValue returns [EObject current=null] : iv_ruleStringValue= ruleStringValue EOF ;
    public final EObject entryRuleStringValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2198:2: (iv_ruleStringValue= ruleStringValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2199:2: iv_ruleStringValue= ruleStringValue EOF
            {
             newCompositeNode(grammarAccess.getStringValueRule()); 
            pushFollow(FOLLOW_ruleStringValue_in_entryRuleStringValue5041);
            iv_ruleStringValue=ruleStringValue();

            state._fsp--;

             current =iv_ruleStringValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringValue5051); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2206:1: ruleStringValue returns [EObject current=null] : ( (lv_stringValue_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringValue() throws RecognitionException {
        EObject current = null;

        Token lv_stringValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2209:28: ( ( (lv_stringValue_0_0= RULE_STRING ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2210:1: ( (lv_stringValue_0_0= RULE_STRING ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2210:1: ( (lv_stringValue_0_0= RULE_STRING ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2211:1: (lv_stringValue_0_0= RULE_STRING )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2211:1: (lv_stringValue_0_0= RULE_STRING )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2212:3: lv_stringValue_0_0= RULE_STRING
            {
            lv_stringValue_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringValue5092); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2236:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2237:2: (iv_ruleVariable= ruleVariable EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2238:2: iv_ruleVariable= ruleVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable5132);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable5142); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2245:1: ruleVariable returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2248:28: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2249:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2249:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2250:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2250:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2251:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getVariableRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getVariableAccess().getNameVariableEntityCrossReference_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleVariable5189);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2272:1: entryRuleEnumValue returns [EObject current=null] : iv_ruleEnumValue= ruleEnumValue EOF ;
    public final EObject entryRuleEnumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2273:2: (iv_ruleEnumValue= ruleEnumValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2274:2: iv_ruleEnumValue= ruleEnumValue EOF
            {
             newCompositeNode(grammarAccess.getEnumValueRule()); 
            pushFollow(FOLLOW_ruleEnumValue_in_entryRuleEnumValue5224);
            iv_ruleEnumValue=ruleEnumValue();

            state._fsp--;

             current =iv_ruleEnumValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumValue5234); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2281:1: ruleEnumValue returns [EObject current=null] : ( (otherlv_0= RULE_UPPERCASE_ID ) ) ;
    public final EObject ruleEnumValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2284:28: ( ( (otherlv_0= RULE_UPPERCASE_ID ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2285:1: ( (otherlv_0= RULE_UPPERCASE_ID ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2285:1: ( (otherlv_0= RULE_UPPERCASE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2286:1: (otherlv_0= RULE_UPPERCASE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2286:1: (otherlv_0= RULE_UPPERCASE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2287:3: otherlv_0= RULE_UPPERCASE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumValueRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_UPPERCASE_ID,FOLLOW_RULE_UPPERCASE_ID_in_ruleEnumValue5278); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2306:1: entryRuleMethodReference returns [EObject current=null] : iv_ruleMethodReference= ruleMethodReference EOF ;
    public final EObject entryRuleMethodReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodReference = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2307:2: (iv_ruleMethodReference= ruleMethodReference EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2308:2: iv_ruleMethodReference= ruleMethodReference EOF
            {
             newCompositeNode(grammarAccess.getMethodReferenceRule()); 
            pushFollow(FOLLOW_ruleMethodReference_in_entryRuleMethodReference5313);
            iv_ruleMethodReference=ruleMethodReference();

            state._fsp--;

             current =iv_ruleMethodReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodReference5323); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2315:1: ruleMethodReference returns [EObject current=null] : ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleMethodReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2318:28: ( ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2319:1: ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2319:1: ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2319:2: ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2319:2: ( ( ruleQualifiedJavaClassName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2320:1: ( ruleQualifiedJavaClassName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2320:1: ( ruleQualifiedJavaClassName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2321:3: ruleQualifiedJavaClassName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMethodReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getMethodReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_ruleMethodReference5371);
            ruleQualifiedJavaClassName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,41,FOLLOW_41_in_ruleMethodReference5383); 

                	newLeafNode(otherlv_1, grammarAccess.getMethodReferenceAccess().getNumberSignKeyword_1());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2338:1: ( (otherlv_2= RULE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2339:1: (otherlv_2= RULE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2339:1: (otherlv_2= RULE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2340:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMethodReferenceRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMethodReference5403); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2359:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2360:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2361:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName5440);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName5451); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2368:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2371:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2372:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2372:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2372:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName5491); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2379:1: (kw= '.' this_ID_2= RULE_ID )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==42) ) {
                    int LA34_2 = input.LA(2);

                    if ( (LA34_2==RULE_ID) ) {
                        alt34=1;
                    }


                }


                switch (alt34) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2380:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,42,FOLLOW_42_in_ruleQualifiedName5510); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName5525); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop34;
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2400:1: entryRuleQualifiedJavaClassName returns [String current=null] : iv_ruleQualifiedJavaClassName= ruleQualifiedJavaClassName EOF ;
    public final String entryRuleQualifiedJavaClassName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedJavaClassName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2401:2: (iv_ruleQualifiedJavaClassName= ruleQualifiedJavaClassName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2402:2: iv_ruleQualifiedJavaClassName= ruleQualifiedJavaClassName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedJavaClassNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_entryRuleQualifiedJavaClassName5573);
            iv_ruleQualifiedJavaClassName=ruleQualifiedJavaClassName();

            state._fsp--;

             current =iv_ruleQualifiedJavaClassName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedJavaClassName5584); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2409:1: ruleQualifiedJavaClassName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedJavaClassName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_UPPERCASE_ID_2=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2412:28: ( (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2413:1: (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2413:1: (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2414:5: this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID
            {
             
                    newCompositeNode(grammarAccess.getQualifiedJavaClassNameAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedJavaClassName5631);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            kw=(Token)match(input,42,FOLLOW_42_in_ruleQualifiedJavaClassName5649); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getQualifiedJavaClassNameAccess().getFullStopKeyword_1()); 
                
            this_UPPERCASE_ID_2=(Token)match(input,RULE_UPPERCASE_ID,FOLLOW_RULE_UPPERCASE_ID_in_ruleQualifiedJavaClassName5664); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2445:1: entryRuleQualifiedNameWithWildcard returns [String current=null] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2446:2: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2447:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard5710);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();

            state._fsp--;

             current =iv_ruleQualifiedNameWithWildcard.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard5721); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2454:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2457:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2458:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2458:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2459:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard5768);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2469:1: (kw= '.*' )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==43) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2470:2: kw= '.*'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleQualifiedNameWithWildcard5787); 

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
    public static final BitSet FOLLOW_ruleStatement_in_ruleModel130 = new BitSet(new long[]{0x0000002000048002L});
    public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement166 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatement176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDefinition_in_ruleStatement223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleStatement250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_ruleStatement277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleSingleLineComment_in_entryRuleVisibleSingleLineComment312 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVisibleSingleLineComment322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SL_VISIBLE_COMMENT_in_ruleVisibleSingleLineComment363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleMultiLineComment_in_entryRuleVisibleMultiLineComment403 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVisibleMultiLineComment413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ML_VISIBLE_COMMENT_in_ruleVisibleMultiLineComment454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDefinition_in_entryRulePackageDefinition494 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageDefinition504 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rulePackageDefinition541 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rulePackageDefinition562 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_rulePackageDefinition574 = new BitSet(new long[]{0x0000000050DE0000L});
    public static final BitSet FOLLOW_rulePackageStatement_in_rulePackageDefinition595 = new BitSet(new long[]{0x0000000050DE0000L});
    public static final BitSet FOLLOW_17_in_rulePackageDefinition608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageStatement_in_entryRulePackageStatement644 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageStatement654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rulePackageStatement701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForkDefinition_in_rulePackageStatement728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestDefinition_in_rulePackageStatement755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallDefinition_in_rulePackageStatement782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteDefinition_in_rulePackageStatement809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_rulePackageStatement836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantDefinition_in_rulePackageStatement863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport898 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleImport945 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_ruleImport966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForkDefinition_in_entryRuleForkDefinition1002 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleForkDefinition1012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleForkDefinition1049 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleForkDefinition1070 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleForkDefinition1087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestDefinition_in_entryRuleTestDefinition1129 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestDefinition1139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleTestDefinition1176 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTestDefinition1197 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleTestDefinition1209 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleMethodReference_in_ruleTestDefinition1230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallDefinition_in_entryRuleCallDefinition1266 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallDefinition1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleCallDefinition1313 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCallDefinition1334 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleCallDefinition1346 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleMethodReference_in_ruleCallDefinition1367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteDefinition_in_entryRuleSuiteDefinition1403 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteDefinition1413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleSuiteDefinition1450 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuiteDefinition1471 = new BitSet(new long[]{0x0000000003010000L});
    public static final BitSet FOLLOW_24_in_ruleSuiteDefinition1484 = new BitSet(new long[]{0x0000000002010080L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_ruleSuiteDefinition1505 = new BitSet(new long[]{0x0000000002010080L});
    public static final BitSet FOLLOW_25_in_ruleSuiteDefinition1521 = new BitSet(new long[]{0x0000000000010080L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuiteDefinition1544 = new BitSet(new long[]{0x0000000000010080L});
    public static final BitSet FOLLOW_16_in_ruleSuiteDefinition1559 = new BitSet(new long[]{0x0000002AD4DC8030L});
    public static final BitSet FOLLOW_ruleSuiteStatement_in_ruleSuiteDefinition1580 = new BitSet(new long[]{0x0000002AD4DC8030L});
    public static final BitSet FOLLOW_26_in_ruleSuiteDefinition1593 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleSuiteDefinition1606 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuiteDefinition1629 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_ruleSuiteStatement_in_entryRuleSuiteStatement1668 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteStatement1678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteStatementWithResult_in_ruleSuiteStatement1725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSuiteStatement1752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_ruleSuiteStatement1779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantDefinition_in_ruleSuiteStatement1806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleSingleLineComment_in_ruleSuiteStatement1833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleMultiLineComment_in_ruleSuiteStatement1860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteStatementWithResult_in_entryRuleSuiteStatementWithResult1895 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteStatementWithResult1905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_ruleSuiteStatementWithResult1952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTest_in_ruleSuiteStatementWithResult1979 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTableTest_in_ruleSuiteStatementWithResult2006 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_entryRuleVariableDefinition2041 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDefinition2051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleVariableDefinition2088 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_ruleVariableDefinition2109 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_29_in_ruleVariableDefinition2122 = new BitSet(new long[]{0x00000000000003C0L});
    public static final BitSet FOLLOW_ruleValue_in_ruleVariableDefinition2143 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantDefinition_in_entryRuleConstantDefinition2181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstantDefinition2191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleConstantDefinition2228 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_ruleConstantDefinition2249 = new BitSet(new long[]{0x00000000000003C0L});
    public static final BitSet FOLLOW_ruleValue_in_ruleConstantDefinition2270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_entryRuleVariableEntity2306 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableEntity2316 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleVariableEntity2361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTest_in_entryRuleTest2396 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTest2406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleTest2443 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTest2466 = new BitSet(new long[]{0x0000010100000082L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleTest2487 = new BitSet(new long[]{0x0000010100000082L});
    public static final BitSet FOLLOW_ruleNamedResult_in_ruleTest2509 = new BitSet(new long[]{0x0000010100000082L});
    public static final BitSet FOLLOW_32_in_ruleTest2523 = new BitSet(new long[]{0x00000000000007C0L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_ruleTest2544 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTableTest_in_entryRuleTableTest2582 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTableTest2592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleTableTest2629 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTableTest2652 = new BitSet(new long[]{0x0000010400000080L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleTableTest2673 = new BitSet(new long[]{0x0000010400000080L});
    public static final BitSet FOLLOW_ruleParameterTableHeader_in_ruleTableTest2695 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_ruleResultTableHeader_in_ruleTableTest2717 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleTableTest2732 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleTableTest2744 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleTableTest2756 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleTableTest2775 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_ruleTableTestRow_in_ruleTableTest2797 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_ruleTableTestRow_in_entryRuleTableTestRow2834 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTableTestRow2844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableValue_in_ruleTableTestRow2899 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleTableTestRow2914 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleTableTestRow2926 = new BitSet(new long[]{0x00000000000007C0L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_ruleTableTestRow2947 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleTableTestRow2959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleTableTestRow2978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableHeader_in_entryRuleParameterTableHeader3015 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterTableHeader3025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleParameterTableHeader3062 = new BitSet(new long[]{0x0000010000000080L});
    public static final BitSet FOLLOW_ruleParameterName_in_ruleParameterTableHeader3083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultTableHeader_in_entryRuleResultTableHeader3119 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultTableHeader3129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleResultTableHeader3166 = new BitSet(new long[]{0x0000010000000080L});
    public static final BitSet FOLLOW_ruleResultName_in_ruleResultTableHeader3187 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleResultTableHeader3199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableValue_in_entryRuleParameterTableValue3235 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterTableValue3245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleParameterTableValue3282 = new BitSet(new long[]{0x00000000000007C0L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_ruleParameterTableValue3303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedResult_in_entryRuleNamedResult3339 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedResult3349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultName_in_ruleNamedResult3395 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleNamedResult3407 = new BitSet(new long[]{0x00000000000007C0L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_ruleNamedResult3428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultName_in_entryRuleResultName3464 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultName3474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedResultName_in_ruleResultName3521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterOrResultName_in_ruleResultName3548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedResultName_in_entryRuleFixedResultName3583 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFixedResultName3593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFixedResultName3637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_entryRuleCall3672 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCall3682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleCall3719 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCall3742 = new BitSet(new long[]{0x0000011000000082L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleCall3763 = new BitSet(new long[]{0x0000011000000082L});
    public static final BitSet FOLLOW_36_in_ruleCall3777 = new BitSet(new long[]{0x00000000000003C0L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleCall3798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_entryRuleSuite3836 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuite3846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleSuite3883 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuite3906 = new BitSet(new long[]{0x0000004000000082L});
    public static final BitSet FOLLOW_ruleSuiteParameter_in_ruleSuite3927 = new BitSet(new long[]{0x0000004000000082L});
    public static final BitSet FOLLOW_38_in_ruleSuite3941 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuite3964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteParameter_in_entryRuleSuiteParameter4002 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteParameter4012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuiteParameter4060 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleSuiteParameter4072 = new BitSet(new long[]{0x00000000000003C0L});
    public static final BitSet FOLLOW_ruleValue_in_ruleSuiteParameter4093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter4129 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter4139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterName_in_ruleParameter4185 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleParameter4197 = new BitSet(new long[]{0x00000000000007C0L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_ruleParameter4218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterName_in_entryRuleParameterName4254 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterName4264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedParameterName_in_ruleParameterName4311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterOrResultName_in_ruleParameterName4338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedParameterName_in_entryRuleFixedParameterName4373 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFixedParameterName4383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFixedParameterName4427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterOrResultName_in_entryRuleArbitraryParameterOrResultName4462 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArbitraryParameterOrResultName4472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleArbitraryParameterOrResultName4509 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleArbitraryParameterOrResultName4526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValue_in_entryRuleValueOrEnumValue4567 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueOrEnumValue4577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_ruleValueOrEnumValue4624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumValue_in_ruleValueOrEnumValue4651 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue4686 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue4696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringValue_in_ruleValue4743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerValue_in_ruleValue4770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalValue_in_ruleValue4797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleValue4824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerValue_in_entryRuleIntegerValue4859 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerValue4869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleIntegerValue4910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalValue_in_entryRuleDecimalValue4950 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalValue4960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DECIMAL_in_ruleDecimalValue5001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringValue_in_entryRuleStringValue5041 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringValue5051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringValue5092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable5132 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable5142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleVariable5189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumValue_in_entryRuleEnumValue5224 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumValue5234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UPPERCASE_ID_in_ruleEnumValue5278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodReference_in_entryRuleMethodReference5313 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodReference5323 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_ruleMethodReference5371 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_41_in_ruleMethodReference5383 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMethodReference5403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName5440 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName5451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName5491 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_42_in_ruleQualifiedName5510 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName5525 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_entryRuleQualifiedJavaClassName5573 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedJavaClassName5584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedJavaClassName5631 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42_in_ruleQualifiedJavaClassName5649 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_UPPERCASE_ID_in_ruleQualifiedJavaClassName5664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard5710 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard5721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard5768 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleQualifiedNameWithWildcard5787 = new BitSet(new long[]{0x0000000000000002L});

}