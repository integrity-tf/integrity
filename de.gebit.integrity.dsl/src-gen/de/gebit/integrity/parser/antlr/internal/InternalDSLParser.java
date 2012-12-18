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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SL_VISIBLE_COMMENT", "RULE_ML_VISIBLE_COMMENT", "RULE_DIVIDER", "RULE_STRING", "RULE_ID", "RULE_INTEGER", "RULE_DECIMAL", "RULE_BOOLEAN_TRUE", "RULE_BOOLEAN_FALSE", "RULE_ISODATE", "RULE_EURODATE", "RULE_USDATE", "RULE_ISOTIME", "RULE_TWENTYFOURHRSTIME", "RULE_TWELVEHRSTIME", "RULE_UPPERCASE_ID", "RULE_NEWLINE", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ISOTIMEZONE", "RULE_ANY_OTHER", "'packagedef'", "'with'", "'packageend'", "'import'", "'forkdef'", "'uses'", "':'", "'variantdef'", "'testdef'", "'calldef'", "'suitedef'", "'gets'", "'requires'", "'concludedby'", "'suiteend'", "'operationdef'", "'variable'", "'initially'", "'constant'", "'in'", "'test'", "'='", "'tabletest'", "'|'", "'call'", "'->'", "'suite'", "'on'", "'+'", "'('", "')'", "','", "'null'", "'{'", "'}'", "'#'", "'*'", "'.'", "'.*'"
    };
    public static final int RULE_ID=8;
    public static final int T__29=29;
    public static final int T__64=64;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__62=62;
    public static final int T__26=26;
    public static final int T__63=63;
    public static final int RULE_ANY_OTHER=25;
    public static final int RULE_TWENTYFOURHRSTIME=17;
    public static final int RULE_SL_VISIBLE_COMMENT=4;
    public static final int T__61=61;
    public static final int EOF=-1;
    public static final int T__60=60;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int RULE_BOOLEAN_FALSE=12;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_UPPERCASE_ID=19;
    public static final int T__59=59;
    public static final int RULE_DIVIDER=6;
    public static final int RULE_DECIMAL=10;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int RULE_NEWLINE=20;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int RULE_ISOTIMEZONE=24;
    public static final int RULE_ISOTIME=16;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_ML_VISIBLE_COMMENT=5;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_USDATE=15;
    public static final int RULE_EURODATE=14;
    public static final int RULE_SL_COMMENT=23;
    public static final int RULE_ML_COMMENT=22;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_BOOLEAN_TRUE=11;
    public static final int RULE_STRING=7;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int RULE_ISODATE=13;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_TWELVEHRSTIME=18;
    public static final int RULE_WS=21;
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:76:1: ruleModel returns [EObject current=null] : ( () ruleNL ( (lv_statements_2_0= ruleStatement ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_statements_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:79:28: ( ( () ruleNL ( (lv_statements_2_0= ruleStatement ) )* ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:80:1: ( () ruleNL ( (lv_statements_2_0= ruleStatement ) )* )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:80:1: ( () ruleNL ( (lv_statements_2_0= ruleStatement ) )* )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:80:2: () ruleNL ( (lv_statements_2_0= ruleStatement ) )*
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:80:2: ()
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:81:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getModelAccess().getModelAction_0(),
                        current);
                

            }

             
                    newCompositeNode(grammarAccess.getModelAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleModel135);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:94:1: ( (lv_statements_2_0= ruleStatement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==26||(LA1_0>=29 && LA1_0<=30)||LA1_0==33) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:95:1: (lv_statements_2_0= ruleStatement )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:95:1: (lv_statements_2_0= ruleStatement )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:96:3: lv_statements_2_0= ruleStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getStatementsStatementParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleStatement_in_ruleModel155);
            	    lv_statements_2_0=ruleStatement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"statements",
            	            		lv_statements_2_0, 
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:120:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:121:2: (iv_ruleStatement= ruleStatement EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:122:2: iv_ruleStatement= ruleStatement EOF
            {
             newCompositeNode(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_ruleStatement_in_entryRuleStatement192);
            iv_ruleStatement=ruleStatement();

            state._fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStatement202); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:129:1: ruleStatement returns [EObject current=null] : (this_Import_0= ruleImport | this_PackageDefinition_1= rulePackageDefinition | this_ForkDefinition_2= ruleForkDefinition | this_VariantDefinition_3= ruleVariantDefinition ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_Import_0 = null;

        EObject this_PackageDefinition_1 = null;

        EObject this_ForkDefinition_2 = null;

        EObject this_VariantDefinition_3 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:132:28: ( (this_Import_0= ruleImport | this_PackageDefinition_1= rulePackageDefinition | this_ForkDefinition_2= ruleForkDefinition | this_VariantDefinition_3= ruleVariantDefinition ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:133:1: (this_Import_0= ruleImport | this_PackageDefinition_1= rulePackageDefinition | this_ForkDefinition_2= ruleForkDefinition | this_VariantDefinition_3= ruleVariantDefinition )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:133:1: (this_Import_0= ruleImport | this_PackageDefinition_1= rulePackageDefinition | this_ForkDefinition_2= ruleForkDefinition | this_VariantDefinition_3= ruleVariantDefinition )
            int alt2=4;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt2=1;
                }
                break;
            case 26:
                {
                alt2=2;
                }
                break;
            case 30:
                {
                alt2=3;
                }
                break;
            case 33:
                {
                alt2=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:134:5: this_Import_0= ruleImport
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getImportParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleImport_in_ruleStatement249);
                    this_Import_0=ruleImport();

                    state._fsp--;

                     
                            current = this_Import_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:144:5: this_PackageDefinition_1= rulePackageDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getPackageDefinitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_rulePackageDefinition_in_ruleStatement276);
                    this_PackageDefinition_1=rulePackageDefinition();

                    state._fsp--;

                     
                            current = this_PackageDefinition_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:154:5: this_ForkDefinition_2= ruleForkDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getForkDefinitionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleForkDefinition_in_ruleStatement303);
                    this_ForkDefinition_2=ruleForkDefinition();

                    state._fsp--;

                     
                            current = this_ForkDefinition_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:164:5: this_VariantDefinition_3= ruleVariantDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getVariantDefinitionParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleVariantDefinition_in_ruleStatement330);
                    this_VariantDefinition_3=ruleVariantDefinition();

                    state._fsp--;

                     
                            current = this_VariantDefinition_3; 
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


    // $ANTLR start "entryRuleVisibleComment"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:180:1: entryRuleVisibleComment returns [EObject current=null] : iv_ruleVisibleComment= ruleVisibleComment EOF ;
    public final EObject entryRuleVisibleComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleComment = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:181:2: (iv_ruleVisibleComment= ruleVisibleComment EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:182:2: iv_ruleVisibleComment= ruleVisibleComment EOF
            {
             newCompositeNode(grammarAccess.getVisibleCommentRule()); 
            pushFollow(FOLLOW_ruleVisibleComment_in_entryRuleVisibleComment365);
            iv_ruleVisibleComment=ruleVisibleComment();

            state._fsp--;

             current =iv_ruleVisibleComment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVisibleComment375); 

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
    // $ANTLR end "entryRuleVisibleComment"


    // $ANTLR start "ruleVisibleComment"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:189:1: ruleVisibleComment returns [EObject current=null] : (this_VisibleSingleLineComment_0= ruleVisibleSingleLineComment | this_VisibleMultiLineComment_1= ruleVisibleMultiLineComment ) ;
    public final EObject ruleVisibleComment() throws RecognitionException {
        EObject current = null;

        EObject this_VisibleSingleLineComment_0 = null;

        EObject this_VisibleMultiLineComment_1 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:192:28: ( (this_VisibleSingleLineComment_0= ruleVisibleSingleLineComment | this_VisibleMultiLineComment_1= ruleVisibleMultiLineComment ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:193:1: (this_VisibleSingleLineComment_0= ruleVisibleSingleLineComment | this_VisibleMultiLineComment_1= ruleVisibleMultiLineComment )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:193:1: (this_VisibleSingleLineComment_0= ruleVisibleSingleLineComment | this_VisibleMultiLineComment_1= ruleVisibleMultiLineComment )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_SL_VISIBLE_COMMENT) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_ML_VISIBLE_COMMENT) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:194:5: this_VisibleSingleLineComment_0= ruleVisibleSingleLineComment
                    {
                     
                            newCompositeNode(grammarAccess.getVisibleCommentAccess().getVisibleSingleLineCommentParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleVisibleSingleLineComment_in_ruleVisibleComment422);
                    this_VisibleSingleLineComment_0=ruleVisibleSingleLineComment();

                    state._fsp--;

                     
                            current = this_VisibleSingleLineComment_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:204:5: this_VisibleMultiLineComment_1= ruleVisibleMultiLineComment
                    {
                     
                            newCompositeNode(grammarAccess.getVisibleCommentAccess().getVisibleMultiLineCommentParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleVisibleMultiLineComment_in_ruleVisibleComment449);
                    this_VisibleMultiLineComment_1=ruleVisibleMultiLineComment();

                    state._fsp--;

                     
                            current = this_VisibleMultiLineComment_1; 
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
    // $ANTLR end "ruleVisibleComment"


    // $ANTLR start "entryRuleVisibleSingleLineComment"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:220:1: entryRuleVisibleSingleLineComment returns [EObject current=null] : iv_ruleVisibleSingleLineComment= ruleVisibleSingleLineComment EOF ;
    public final EObject entryRuleVisibleSingleLineComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleSingleLineComment = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:221:2: (iv_ruleVisibleSingleLineComment= ruleVisibleSingleLineComment EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:222:2: iv_ruleVisibleSingleLineComment= ruleVisibleSingleLineComment EOF
            {
             newCompositeNode(grammarAccess.getVisibleSingleLineCommentRule()); 
            pushFollow(FOLLOW_ruleVisibleSingleLineComment_in_entryRuleVisibleSingleLineComment484);
            iv_ruleVisibleSingleLineComment=ruleVisibleSingleLineComment();

            state._fsp--;

             current =iv_ruleVisibleSingleLineComment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVisibleSingleLineComment494); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:229:1: ruleVisibleSingleLineComment returns [EObject current=null] : ( ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) ) ruleNL ) ;
    public final EObject ruleVisibleSingleLineComment() throws RecognitionException {
        EObject current = null;

        Token lv_content_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:232:28: ( ( ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) ) ruleNL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:233:1: ( ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) ) ruleNL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:233:1: ( ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) ) ruleNL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:233:2: ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) ) ruleNL
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:233:2: ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:234:1: (lv_content_0_0= RULE_SL_VISIBLE_COMMENT )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:234:1: (lv_content_0_0= RULE_SL_VISIBLE_COMMENT )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:235:3: lv_content_0_0= RULE_SL_VISIBLE_COMMENT
            {
            lv_content_0_0=(Token)match(input,RULE_SL_VISIBLE_COMMENT,FOLLOW_RULE_SL_VISIBLE_COMMENT_in_ruleVisibleSingleLineComment536); 

            			newLeafNode(lv_content_0_0, grammarAccess.getVisibleSingleLineCommentAccess().getContentSL_VISIBLE_COMMENTTerminalRuleCall_0_0()); 
            		

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

             
                    newCompositeNode(grammarAccess.getVisibleSingleLineCommentAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleVisibleSingleLineComment557);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:267:1: entryRuleVisibleMultiLineComment returns [EObject current=null] : iv_ruleVisibleMultiLineComment= ruleVisibleMultiLineComment EOF ;
    public final EObject entryRuleVisibleMultiLineComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleMultiLineComment = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:268:2: (iv_ruleVisibleMultiLineComment= ruleVisibleMultiLineComment EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:269:2: iv_ruleVisibleMultiLineComment= ruleVisibleMultiLineComment EOF
            {
             newCompositeNode(grammarAccess.getVisibleMultiLineCommentRule()); 
            pushFollow(FOLLOW_ruleVisibleMultiLineComment_in_entryRuleVisibleMultiLineComment592);
            iv_ruleVisibleMultiLineComment=ruleVisibleMultiLineComment();

            state._fsp--;

             current =iv_ruleVisibleMultiLineComment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVisibleMultiLineComment602); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:276:1: ruleVisibleMultiLineComment returns [EObject current=null] : ( ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) ) ruleNL ) ;
    public final EObject ruleVisibleMultiLineComment() throws RecognitionException {
        EObject current = null;

        Token lv_content_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:279:28: ( ( ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) ) ruleNL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:280:1: ( ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) ) ruleNL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:280:1: ( ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) ) ruleNL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:280:2: ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) ) ruleNL
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:280:2: ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:281:1: (lv_content_0_0= RULE_ML_VISIBLE_COMMENT )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:281:1: (lv_content_0_0= RULE_ML_VISIBLE_COMMENT )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:282:3: lv_content_0_0= RULE_ML_VISIBLE_COMMENT
            {
            lv_content_0_0=(Token)match(input,RULE_ML_VISIBLE_COMMENT,FOLLOW_RULE_ML_VISIBLE_COMMENT_in_ruleVisibleMultiLineComment644); 

            			newLeafNode(lv_content_0_0, grammarAccess.getVisibleMultiLineCommentAccess().getContentML_VISIBLE_COMMENTTerminalRuleCall_0_0()); 
            		

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

             
                    newCompositeNode(grammarAccess.getVisibleMultiLineCommentAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleVisibleMultiLineComment665);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                

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


    // $ANTLR start "entryRuleVisibleDivider"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:314:1: entryRuleVisibleDivider returns [EObject current=null] : iv_ruleVisibleDivider= ruleVisibleDivider EOF ;
    public final EObject entryRuleVisibleDivider() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleDivider = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:315:2: (iv_ruleVisibleDivider= ruleVisibleDivider EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:316:2: iv_ruleVisibleDivider= ruleVisibleDivider EOF
            {
             newCompositeNode(grammarAccess.getVisibleDividerRule()); 
            pushFollow(FOLLOW_ruleVisibleDivider_in_entryRuleVisibleDivider700);
            iv_ruleVisibleDivider=ruleVisibleDivider();

            state._fsp--;

             current =iv_ruleVisibleDivider; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVisibleDivider710); 

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
    // $ANTLR end "entryRuleVisibleDivider"


    // $ANTLR start "ruleVisibleDivider"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:323:1: ruleVisibleDivider returns [EObject current=null] : ( ( (lv_content_0_0= RULE_DIVIDER ) ) ruleNL ) ;
    public final EObject ruleVisibleDivider() throws RecognitionException {
        EObject current = null;

        Token lv_content_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:326:28: ( ( ( (lv_content_0_0= RULE_DIVIDER ) ) ruleNL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:327:1: ( ( (lv_content_0_0= RULE_DIVIDER ) ) ruleNL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:327:1: ( ( (lv_content_0_0= RULE_DIVIDER ) ) ruleNL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:327:2: ( (lv_content_0_0= RULE_DIVIDER ) ) ruleNL
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:327:2: ( (lv_content_0_0= RULE_DIVIDER ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:328:1: (lv_content_0_0= RULE_DIVIDER )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:328:1: (lv_content_0_0= RULE_DIVIDER )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:329:3: lv_content_0_0= RULE_DIVIDER
            {
            lv_content_0_0=(Token)match(input,RULE_DIVIDER,FOLLOW_RULE_DIVIDER_in_ruleVisibleDivider752); 

            			newLeafNode(lv_content_0_0, grammarAccess.getVisibleDividerAccess().getContentDIVIDERTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVisibleDividerRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"content",
                    		lv_content_0_0, 
                    		"DIVIDER");
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getVisibleDividerAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleVisibleDivider773);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                

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
    // $ANTLR end "ruleVisibleDivider"


    // $ANTLR start "entryRulePackageDefinition"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:361:1: entryRulePackageDefinition returns [EObject current=null] : iv_rulePackageDefinition= rulePackageDefinition EOF ;
    public final EObject entryRulePackageDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:362:2: (iv_rulePackageDefinition= rulePackageDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:363:2: iv_rulePackageDefinition= rulePackageDefinition EOF
            {
             newCompositeNode(grammarAccess.getPackageDefinitionRule()); 
            pushFollow(FOLLOW_rulePackageDefinition_in_entryRulePackageDefinition808);
            iv_rulePackageDefinition=rulePackageDefinition();

            state._fsp--;

             current =iv_rulePackageDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePackageDefinition818); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:370:1: rulePackageDefinition returns [EObject current=null] : (otherlv_0= 'packagedef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= 'with' ruleNL ( (lv_statements_5_0= rulePackageStatement ) )* otherlv_6= 'packageend' ruleNL ) ;
    public final EObject rulePackageDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_statements_5_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:373:28: ( (otherlv_0= 'packagedef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= 'with' ruleNL ( (lv_statements_5_0= rulePackageStatement ) )* otherlv_6= 'packageend' ruleNL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:374:1: (otherlv_0= 'packagedef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= 'with' ruleNL ( (lv_statements_5_0= rulePackageStatement ) )* otherlv_6= 'packageend' ruleNL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:374:1: (otherlv_0= 'packagedef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= 'with' ruleNL ( (lv_statements_5_0= rulePackageStatement ) )* otherlv_6= 'packageend' ruleNL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:374:3: otherlv_0= 'packagedef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= 'with' ruleNL ( (lv_statements_5_0= rulePackageStatement ) )* otherlv_6= 'packageend' ruleNL
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_rulePackageDefinition855); 

                	newLeafNode(otherlv_0, grammarAccess.getPackageDefinitionAccess().getPackagedefKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getPackageDefinitionAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_rulePackageDefinition871);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:386:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:387:1: (lv_name_2_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:387:1: (lv_name_2_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:388:3: lv_name_2_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getPackageDefinitionAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_rulePackageDefinition891);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPackageDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,27,FOLLOW_27_in_rulePackageDefinition903); 

                	newLeafNode(otherlv_3, grammarAccess.getPackageDefinitionAccess().getWithKeyword_3());
                
             
                    newCompositeNode(grammarAccess.getPackageDefinitionAccess().getNLParserRuleCall_4()); 
                
            pushFollow(FOLLOW_ruleNL_in_rulePackageDefinition919);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:416:1: ( (lv_statements_5_0= rulePackageStatement ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=29 && LA4_0<=30)||(LA4_0>=33 && LA4_0<=36)||(LA4_0>=41 && LA4_0<=42)||LA4_0==44) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:417:1: (lv_statements_5_0= rulePackageStatement )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:417:1: (lv_statements_5_0= rulePackageStatement )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:418:3: lv_statements_5_0= rulePackageStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPackageDefinitionAccess().getStatementsPackageStatementParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePackageStatement_in_rulePackageDefinition939);
            	    lv_statements_5_0=rulePackageStatement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPackageDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"statements",
            	            		lv_statements_5_0, 
            	            		"PackageStatement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_6=(Token)match(input,28,FOLLOW_28_in_rulePackageDefinition952); 

                	newLeafNode(otherlv_6, grammarAccess.getPackageDefinitionAccess().getPackageendKeyword_6());
                
             
                    newCompositeNode(grammarAccess.getPackageDefinitionAccess().getNLParserRuleCall_7()); 
                
            pushFollow(FOLLOW_ruleNL_in_rulePackageDefinition968);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:454:1: entryRulePackageStatement returns [EObject current=null] : iv_rulePackageStatement= rulePackageStatement EOF ;
    public final EObject entryRulePackageStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageStatement = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:455:2: (iv_rulePackageStatement= rulePackageStatement EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:456:2: iv_rulePackageStatement= rulePackageStatement EOF
            {
             newCompositeNode(grammarAccess.getPackageStatementRule()); 
            pushFollow(FOLLOW_rulePackageStatement_in_entryRulePackageStatement1003);
            iv_rulePackageStatement=rulePackageStatement();

            state._fsp--;

             current =iv_rulePackageStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePackageStatement1013); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:463:1: rulePackageStatement returns [EObject current=null] : (this_Import_0= ruleImport | this_ForkDefinition_1= ruleForkDefinition | this_VariantDefinition_2= ruleVariantDefinition | this_TestDefinition_3= ruleTestDefinition | this_CallDefinition_4= ruleCallDefinition | this_OperationDefinition_5= ruleOperationDefinition | this_SuiteDefinition_6= ruleSuiteDefinition | this_VariableDefinition_7= ruleVariableDefinition | this_ConstantDefinition_8= ruleConstantDefinition ) ;
    public final EObject rulePackageStatement() throws RecognitionException {
        EObject current = null;

        EObject this_Import_0 = null;

        EObject this_ForkDefinition_1 = null;

        EObject this_VariantDefinition_2 = null;

        EObject this_TestDefinition_3 = null;

        EObject this_CallDefinition_4 = null;

        EObject this_OperationDefinition_5 = null;

        EObject this_SuiteDefinition_6 = null;

        EObject this_VariableDefinition_7 = null;

        EObject this_ConstantDefinition_8 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:466:28: ( (this_Import_0= ruleImport | this_ForkDefinition_1= ruleForkDefinition | this_VariantDefinition_2= ruleVariantDefinition | this_TestDefinition_3= ruleTestDefinition | this_CallDefinition_4= ruleCallDefinition | this_OperationDefinition_5= ruleOperationDefinition | this_SuiteDefinition_6= ruleSuiteDefinition | this_VariableDefinition_7= ruleVariableDefinition | this_ConstantDefinition_8= ruleConstantDefinition ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:467:1: (this_Import_0= ruleImport | this_ForkDefinition_1= ruleForkDefinition | this_VariantDefinition_2= ruleVariantDefinition | this_TestDefinition_3= ruleTestDefinition | this_CallDefinition_4= ruleCallDefinition | this_OperationDefinition_5= ruleOperationDefinition | this_SuiteDefinition_6= ruleSuiteDefinition | this_VariableDefinition_7= ruleVariableDefinition | this_ConstantDefinition_8= ruleConstantDefinition )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:467:1: (this_Import_0= ruleImport | this_ForkDefinition_1= ruleForkDefinition | this_VariantDefinition_2= ruleVariantDefinition | this_TestDefinition_3= ruleTestDefinition | this_CallDefinition_4= ruleCallDefinition | this_OperationDefinition_5= ruleOperationDefinition | this_SuiteDefinition_6= ruleSuiteDefinition | this_VariableDefinition_7= ruleVariableDefinition | this_ConstantDefinition_8= ruleConstantDefinition )
            int alt5=9;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt5=1;
                }
                break;
            case 30:
                {
                alt5=2;
                }
                break;
            case 33:
                {
                alt5=3;
                }
                break;
            case 34:
                {
                alt5=4;
                }
                break;
            case 35:
                {
                alt5=5;
                }
                break;
            case 41:
                {
                alt5=6;
                }
                break;
            case 36:
                {
                alt5=7;
                }
                break;
            case 42:
                {
                alt5=8;
                }
                break;
            case 44:
                {
                alt5=9;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:468:5: this_Import_0= ruleImport
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getImportParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleImport_in_rulePackageStatement1060);
                    this_Import_0=ruleImport();

                    state._fsp--;

                     
                            current = this_Import_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:478:5: this_ForkDefinition_1= ruleForkDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getForkDefinitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleForkDefinition_in_rulePackageStatement1087);
                    this_ForkDefinition_1=ruleForkDefinition();

                    state._fsp--;

                     
                            current = this_ForkDefinition_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:488:5: this_VariantDefinition_2= ruleVariantDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getVariantDefinitionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleVariantDefinition_in_rulePackageStatement1114);
                    this_VariantDefinition_2=ruleVariantDefinition();

                    state._fsp--;

                     
                            current = this_VariantDefinition_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:498:5: this_TestDefinition_3= ruleTestDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getTestDefinitionParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleTestDefinition_in_rulePackageStatement1141);
                    this_TestDefinition_3=ruleTestDefinition();

                    state._fsp--;

                     
                            current = this_TestDefinition_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:508:5: this_CallDefinition_4= ruleCallDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getCallDefinitionParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleCallDefinition_in_rulePackageStatement1168);
                    this_CallDefinition_4=ruleCallDefinition();

                    state._fsp--;

                     
                            current = this_CallDefinition_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:518:5: this_OperationDefinition_5= ruleOperationDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getOperationDefinitionParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleOperationDefinition_in_rulePackageStatement1195);
                    this_OperationDefinition_5=ruleOperationDefinition();

                    state._fsp--;

                     
                            current = this_OperationDefinition_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:528:5: this_SuiteDefinition_6= ruleSuiteDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getSuiteDefinitionParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleSuiteDefinition_in_rulePackageStatement1222);
                    this_SuiteDefinition_6=ruleSuiteDefinition();

                    state._fsp--;

                     
                            current = this_SuiteDefinition_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:538:5: this_VariableDefinition_7= ruleVariableDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getVariableDefinitionParserRuleCall_7()); 
                        
                    pushFollow(FOLLOW_ruleVariableDefinition_in_rulePackageStatement1249);
                    this_VariableDefinition_7=ruleVariableDefinition();

                    state._fsp--;

                     
                            current = this_VariableDefinition_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:548:5: this_ConstantDefinition_8= ruleConstantDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getConstantDefinitionParserRuleCall_8()); 
                        
                    pushFollow(FOLLOW_ruleConstantDefinition_in_rulePackageStatement1276);
                    this_ConstantDefinition_8=ruleConstantDefinition();

                    state._fsp--;

                     
                            current = this_ConstantDefinition_8; 
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:564:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:565:2: (iv_ruleImport= ruleImport EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:566:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport1311);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport1321); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:573:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ruleNL ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) ) ruleNL ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:576:28: ( (otherlv_0= 'import' ruleNL ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) ) ruleNL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:577:1: (otherlv_0= 'import' ruleNL ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) ) ruleNL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:577:1: (otherlv_0= 'import' ruleNL ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) ) ruleNL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:577:3: otherlv_0= 'import' ruleNL ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) ) ruleNL
            {
            otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleImport1358); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getImportAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleImport1374);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:589:1: ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:590:1: (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:590:1: (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:591:3: lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard
            {
             
            	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_ruleImport1394);
            lv_importedNamespace_2_0=ruleQualifiedNameWithWildcard();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getImportRule());
            	        }
                   		set(
                   			current, 
                   			"importedNamespace",
                    		lv_importedNamespace_2_0, 
                    		"QualifiedNameWithWildcard");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getImportAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleImport1410);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:623:1: entryRuleForkDefinition returns [EObject current=null] : iv_ruleForkDefinition= ruleForkDefinition EOF ;
    public final EObject entryRuleForkDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForkDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:624:2: (iv_ruleForkDefinition= ruleForkDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:625:2: iv_ruleForkDefinition= ruleForkDefinition EOF
            {
             newCompositeNode(grammarAccess.getForkDefinitionRule()); 
            pushFollow(FOLLOW_ruleForkDefinition_in_entryRuleForkDefinition1445);
            iv_ruleForkDefinition=ruleForkDefinition();

            state._fsp--;

             current =iv_ruleForkDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleForkDefinition1455); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:632:1: ruleForkDefinition returns [EObject current=null] : (otherlv_0= 'forkdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )? (otherlv_6= 'uses' ruleNL ( (lv_forkerClass_8_0= ruleJavaClassReference ) ) ruleNL )? ( ( (lv_parameters_10_0= ruleForkParameter ) ) ruleNL )* ) ;
    public final EObject ruleForkDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_description_4_0=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_forkerClass_8_0 = null;

        EObject lv_parameters_10_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:635:28: ( (otherlv_0= 'forkdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )? (otherlv_6= 'uses' ruleNL ( (lv_forkerClass_8_0= ruleJavaClassReference ) ) ruleNL )? ( ( (lv_parameters_10_0= ruleForkParameter ) ) ruleNL )* ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:636:1: (otherlv_0= 'forkdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )? (otherlv_6= 'uses' ruleNL ( (lv_forkerClass_8_0= ruleJavaClassReference ) ) ruleNL )? ( ( (lv_parameters_10_0= ruleForkParameter ) ) ruleNL )* )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:636:1: (otherlv_0= 'forkdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )? (otherlv_6= 'uses' ruleNL ( (lv_forkerClass_8_0= ruleJavaClassReference ) ) ruleNL )? ( ( (lv_parameters_10_0= ruleForkParameter ) ) ruleNL )* )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:636:3: otherlv_0= 'forkdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )? (otherlv_6= 'uses' ruleNL ( (lv_forkerClass_8_0= ruleJavaClassReference ) ) ruleNL )? ( ( (lv_parameters_10_0= ruleForkParameter ) ) ruleNL )*
            {
            otherlv_0=(Token)match(input,30,FOLLOW_30_in_ruleForkDefinition1492); 

                	newLeafNode(otherlv_0, grammarAccess.getForkDefinitionAccess().getForkdefKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getForkDefinitionAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleForkDefinition1508);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:648:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:649:1: (lv_name_2_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:649:1: (lv_name_2_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:650:3: lv_name_2_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getForkDefinitionAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleForkDefinition1528);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getForkDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getForkDefinitionAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleForkDefinition1544);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:674:1: ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_STRING) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:674:2: ( (lv_description_4_0= RULE_STRING ) ) ruleNL
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:674:2: ( (lv_description_4_0= RULE_STRING ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:675:1: (lv_description_4_0= RULE_STRING )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:675:1: (lv_description_4_0= RULE_STRING )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:676:3: lv_description_4_0= RULE_STRING
                    {
                    lv_description_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleForkDefinition1561); 

                    			newLeafNode(lv_description_4_0, grammarAccess.getForkDefinitionAccess().getDescriptionSTRINGTerminalRuleCall_4_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getForkDefinitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_4_0, 
                            		"STRING");
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getForkDefinitionAccess().getNLParserRuleCall_4_1()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleForkDefinition1582);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:700:3: (otherlv_6= 'uses' ruleNL ( (lv_forkerClass_8_0= ruleJavaClassReference ) ) ruleNL )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==31) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:700:5: otherlv_6= 'uses' ruleNL ( (lv_forkerClass_8_0= ruleJavaClassReference ) ) ruleNL
                    {
                    otherlv_6=(Token)match(input,31,FOLLOW_31_in_ruleForkDefinition1596); 

                        	newLeafNode(otherlv_6, grammarAccess.getForkDefinitionAccess().getUsesKeyword_5_0());
                        
                     
                            newCompositeNode(grammarAccess.getForkDefinitionAccess().getNLParserRuleCall_5_1()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleForkDefinition1612);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:712:1: ( (lv_forkerClass_8_0= ruleJavaClassReference ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:713:1: (lv_forkerClass_8_0= ruleJavaClassReference )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:713:1: (lv_forkerClass_8_0= ruleJavaClassReference )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:714:3: lv_forkerClass_8_0= ruleJavaClassReference
                    {
                     
                    	        newCompositeNode(grammarAccess.getForkDefinitionAccess().getForkerClassJavaClassReferenceParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleJavaClassReference_in_ruleForkDefinition1632);
                    lv_forkerClass_8_0=ruleJavaClassReference();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getForkDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"forkerClass",
                            		lv_forkerClass_8_0, 
                            		"JavaClassReference");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getForkDefinitionAccess().getNLParserRuleCall_5_3()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleForkDefinition1648);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:738:3: ( ( (lv_parameters_10_0= ruleForkParameter ) ) ruleNL )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_ID) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:738:4: ( (lv_parameters_10_0= ruleForkParameter ) ) ruleNL
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:738:4: ( (lv_parameters_10_0= ruleForkParameter ) )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:739:1: (lv_parameters_10_0= ruleForkParameter )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:739:1: (lv_parameters_10_0= ruleForkParameter )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:740:3: lv_parameters_10_0= ruleForkParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getForkDefinitionAccess().getParametersForkParameterParserRuleCall_6_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleForkParameter_in_ruleForkDefinition1671);
            	    lv_parameters_10_0=ruleForkParameter();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getForkDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"parameters",
            	            		lv_parameters_10_0, 
            	            		"ForkParameter");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	     
            	            newCompositeNode(grammarAccess.getForkDefinitionAccess().getNLParserRuleCall_6_1()); 
            	        
            	    pushFollow(FOLLOW_ruleNL_in_ruleForkDefinition1687);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop8;
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
    // $ANTLR end "ruleForkDefinition"


    // $ANTLR start "entryRuleForkParameter"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:772:1: entryRuleForkParameter returns [EObject current=null] : iv_ruleForkParameter= ruleForkParameter EOF ;
    public final EObject entryRuleForkParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForkParameter = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:773:2: (iv_ruleForkParameter= ruleForkParameter EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:774:2: iv_ruleForkParameter= ruleForkParameter EOF
            {
             newCompositeNode(grammarAccess.getForkParameterRule()); 
            pushFollow(FOLLOW_ruleForkParameter_in_entryRuleForkParameter1724);
            iv_ruleForkParameter=ruleForkParameter();

            state._fsp--;

             current =iv_ruleForkParameter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleForkParameter1734); 

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
    // $ANTLR end "entryRuleForkParameter"


    // $ANTLR start "ruleForkParameter"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:781:1: ruleForkParameter returns [EObject current=null] : ( ( (lv_name_0_0= ruleFixedParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) ) ) ;
    public final EObject ruleForkParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:784:28: ( ( ( (lv_name_0_0= ruleFixedParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:785:1: ( ( (lv_name_0_0= ruleFixedParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:785:1: ( ( (lv_name_0_0= ruleFixedParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:785:2: ( (lv_name_0_0= ruleFixedParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:785:2: ( (lv_name_0_0= ruleFixedParameterName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:786:1: (lv_name_0_0= ruleFixedParameterName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:786:1: (lv_name_0_0= ruleFixedParameterName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:787:3: lv_name_0_0= ruleFixedParameterName
            {
             
            	        newCompositeNode(grammarAccess.getForkParameterAccess().getNameFixedParameterNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleFixedParameterName_in_ruleForkParameter1780);
            lv_name_0_0=ruleFixedParameterName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getForkParameterRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"FixedParameterName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getForkParameterAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleForkParameter1796);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,32,FOLLOW_32_in_ruleForkParameter1807); 

                	newLeafNode(otherlv_2, grammarAccess.getForkParameterAccess().getColonKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getForkParameterAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleForkParameter1823);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:823:1: ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:824:1: (lv_value_4_0= ruleValueOrEnumValueOrOperation )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:824:1: (lv_value_4_0= ruleValueOrEnumValueOrOperation )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:825:3: lv_value_4_0= ruleValueOrEnumValueOrOperation
            {
             
            	        newCompositeNode(grammarAccess.getForkParameterAccess().getValueValueOrEnumValueOrOperationParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleValueOrEnumValueOrOperation_in_ruleForkParameter1843);
            lv_value_4_0=ruleValueOrEnumValueOrOperation();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getForkParameterRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_4_0, 
                    		"ValueOrEnumValueOrOperation");
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
    // $ANTLR end "ruleForkParameter"


    // $ANTLR start "entryRuleVariantDefinition"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:849:1: entryRuleVariantDefinition returns [EObject current=null] : iv_ruleVariantDefinition= ruleVariantDefinition EOF ;
    public final EObject entryRuleVariantDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariantDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:850:2: (iv_ruleVariantDefinition= ruleVariantDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:851:2: iv_ruleVariantDefinition= ruleVariantDefinition EOF
            {
             newCompositeNode(grammarAccess.getVariantDefinitionRule()); 
            pushFollow(FOLLOW_ruleVariantDefinition_in_entryRuleVariantDefinition1879);
            iv_ruleVariantDefinition=ruleVariantDefinition();

            state._fsp--;

             current =iv_ruleVariantDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariantDefinition1889); 

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
    // $ANTLR end "entryRuleVariantDefinition"


    // $ANTLR start "ruleVariantDefinition"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:858:1: ruleVariantDefinition returns [EObject current=null] : (otherlv_0= 'variantdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )? ) ;
    public final EObject ruleVariantDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_description_4_0=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:861:28: ( (otherlv_0= 'variantdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:862:1: (otherlv_0= 'variantdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:862:1: (otherlv_0= 'variantdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )? )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:862:3: otherlv_0= 'variantdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )?
            {
            otherlv_0=(Token)match(input,33,FOLLOW_33_in_ruleVariantDefinition1926); 

                	newLeafNode(otherlv_0, grammarAccess.getVariantDefinitionAccess().getVariantdefKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getVariantDefinitionAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleVariantDefinition1942);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:874:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:875:1: (lv_name_2_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:875:1: (lv_name_2_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:876:3: lv_name_2_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getVariantDefinitionAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleVariantDefinition1962);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVariantDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getVariantDefinitionAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleVariantDefinition1978);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:900:1: ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_STRING) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:900:2: ( (lv_description_4_0= RULE_STRING ) ) ruleNL
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:900:2: ( (lv_description_4_0= RULE_STRING ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:901:1: (lv_description_4_0= RULE_STRING )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:901:1: (lv_description_4_0= RULE_STRING )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:902:3: lv_description_4_0= RULE_STRING
                    {
                    lv_description_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVariantDefinition1995); 

                    			newLeafNode(lv_description_4_0, grammarAccess.getVariantDefinitionAccess().getDescriptionSTRINGTerminalRuleCall_4_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVariantDefinitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_4_0, 
                            		"STRING");
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getVariantDefinitionAccess().getNLParserRuleCall_4_1()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleVariantDefinition2016);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

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
    // $ANTLR end "ruleVariantDefinition"


    // $ANTLR start "entryRuleTestDefinition"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:934:1: entryRuleTestDefinition returns [EObject current=null] : iv_ruleTestDefinition= ruleTestDefinition EOF ;
    public final EObject entryRuleTestDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:935:2: (iv_ruleTestDefinition= ruleTestDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:936:2: iv_ruleTestDefinition= ruleTestDefinition EOF
            {
             newCompositeNode(grammarAccess.getTestDefinitionRule()); 
            pushFollow(FOLLOW_ruleTestDefinition_in_entryRuleTestDefinition2053);
            iv_ruleTestDefinition=ruleTestDefinition();

            state._fsp--;

             current =iv_ruleTestDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestDefinition2063); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:943:1: ruleTestDefinition returns [EObject current=null] : (otherlv_0= 'testdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL ) ;
    public final EObject ruleTestDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_fixtureMethod_6_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:946:28: ( (otherlv_0= 'testdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:947:1: (otherlv_0= 'testdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:947:1: (otherlv_0= 'testdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:947:3: otherlv_0= 'testdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL
            {
            otherlv_0=(Token)match(input,34,FOLLOW_34_in_ruleTestDefinition2100); 

                	newLeafNode(otherlv_0, grammarAccess.getTestDefinitionAccess().getTestdefKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getTestDefinitionAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleTestDefinition2116);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:959:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:960:1: (lv_name_2_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:960:1: (lv_name_2_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:961:3: lv_name_2_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getTestDefinitionAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleTestDefinition2136);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTestDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getTestDefinitionAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleTestDefinition2152);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_4=(Token)match(input,31,FOLLOW_31_in_ruleTestDefinition2163); 

                	newLeafNode(otherlv_4, grammarAccess.getTestDefinitionAccess().getUsesKeyword_4());
                
             
                    newCompositeNode(grammarAccess.getTestDefinitionAccess().getNLParserRuleCall_5()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleTestDefinition2179);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:997:1: ( (lv_fixtureMethod_6_0= ruleMethodReference ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:998:1: (lv_fixtureMethod_6_0= ruleMethodReference )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:998:1: (lv_fixtureMethod_6_0= ruleMethodReference )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:999:3: lv_fixtureMethod_6_0= ruleMethodReference
            {
             
            	        newCompositeNode(grammarAccess.getTestDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleMethodReference_in_ruleTestDefinition2199);
            lv_fixtureMethod_6_0=ruleMethodReference();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTestDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"fixtureMethod",
                    		lv_fixtureMethod_6_0, 
                    		"MethodReference");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getTestDefinitionAccess().getNLParserRuleCall_7()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleTestDefinition2215);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1031:1: entryRuleCallDefinition returns [EObject current=null] : iv_ruleCallDefinition= ruleCallDefinition EOF ;
    public final EObject entryRuleCallDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1032:2: (iv_ruleCallDefinition= ruleCallDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1033:2: iv_ruleCallDefinition= ruleCallDefinition EOF
            {
             newCompositeNode(grammarAccess.getCallDefinitionRule()); 
            pushFollow(FOLLOW_ruleCallDefinition_in_entryRuleCallDefinition2250);
            iv_ruleCallDefinition=ruleCallDefinition();

            state._fsp--;

             current =iv_ruleCallDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallDefinition2260); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1040:1: ruleCallDefinition returns [EObject current=null] : (otherlv_0= 'calldef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL ) ;
    public final EObject ruleCallDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_fixtureMethod_6_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1043:28: ( (otherlv_0= 'calldef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1044:1: (otherlv_0= 'calldef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1044:1: (otherlv_0= 'calldef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1044:3: otherlv_0= 'calldef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL
            {
            otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleCallDefinition2297); 

                	newLeafNode(otherlv_0, grammarAccess.getCallDefinitionAccess().getCalldefKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getCallDefinitionAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleCallDefinition2313);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1056:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1057:1: (lv_name_2_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1057:1: (lv_name_2_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1058:3: lv_name_2_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getCallDefinitionAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleCallDefinition2333);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCallDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getCallDefinitionAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleCallDefinition2349);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_4=(Token)match(input,31,FOLLOW_31_in_ruleCallDefinition2360); 

                	newLeafNode(otherlv_4, grammarAccess.getCallDefinitionAccess().getUsesKeyword_4());
                
             
                    newCompositeNode(grammarAccess.getCallDefinitionAccess().getNLParserRuleCall_5()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleCallDefinition2376);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1094:1: ( (lv_fixtureMethod_6_0= ruleMethodReference ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1095:1: (lv_fixtureMethod_6_0= ruleMethodReference )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1095:1: (lv_fixtureMethod_6_0= ruleMethodReference )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1096:3: lv_fixtureMethod_6_0= ruleMethodReference
            {
             
            	        newCompositeNode(grammarAccess.getCallDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleMethodReference_in_ruleCallDefinition2396);
            lv_fixtureMethod_6_0=ruleMethodReference();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCallDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"fixtureMethod",
                    		lv_fixtureMethod_6_0, 
                    		"MethodReference");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getCallDefinitionAccess().getNLParserRuleCall_7()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleCallDefinition2412);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1128:1: entryRuleSuiteDefinition returns [EObject current=null] : iv_ruleSuiteDefinition= ruleSuiteDefinition EOF ;
    public final EObject entryRuleSuiteDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1129:2: (iv_ruleSuiteDefinition= ruleSuiteDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1130:2: iv_ruleSuiteDefinition= ruleSuiteDefinition EOF
            {
             newCompositeNode(grammarAccess.getSuiteDefinitionRule()); 
            pushFollow(FOLLOW_ruleSuiteDefinition_in_entryRuleSuiteDefinition2447);
            iv_ruleSuiteDefinition=ruleSuiteDefinition();

            state._fsp--;

             current =iv_ruleSuiteDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteDefinition2457); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1137:1: ruleSuiteDefinition returns [EObject current=null] : (otherlv_0= 'suitedef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL (otherlv_4= 'gets' ruleNL ( ( (lv_parameters_6_0= ruleVariableEntity ) ) ruleNL )* )? (otherlv_8= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? (otherlv_12= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? otherlv_16= 'with' ruleNL ( (lv_statements_18_0= ruleSuiteStatement ) )* otherlv_19= 'suiteend' ruleNL ) ;
    public final EObject ruleSuiteDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        Token otherlv_8=null;
        Token otherlv_12=null;
        Token otherlv_16=null;
        Token otherlv_19=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_parameters_6_0 = null;

        EObject lv_statements_18_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1140:28: ( (otherlv_0= 'suitedef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL (otherlv_4= 'gets' ruleNL ( ( (lv_parameters_6_0= ruleVariableEntity ) ) ruleNL )* )? (otherlv_8= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? (otherlv_12= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? otherlv_16= 'with' ruleNL ( (lv_statements_18_0= ruleSuiteStatement ) )* otherlv_19= 'suiteend' ruleNL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1141:1: (otherlv_0= 'suitedef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL (otherlv_4= 'gets' ruleNL ( ( (lv_parameters_6_0= ruleVariableEntity ) ) ruleNL )* )? (otherlv_8= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? (otherlv_12= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? otherlv_16= 'with' ruleNL ( (lv_statements_18_0= ruleSuiteStatement ) )* otherlv_19= 'suiteend' ruleNL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1141:1: (otherlv_0= 'suitedef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL (otherlv_4= 'gets' ruleNL ( ( (lv_parameters_6_0= ruleVariableEntity ) ) ruleNL )* )? (otherlv_8= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? (otherlv_12= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? otherlv_16= 'with' ruleNL ( (lv_statements_18_0= ruleSuiteStatement ) )* otherlv_19= 'suiteend' ruleNL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1141:3: otherlv_0= 'suitedef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL (otherlv_4= 'gets' ruleNL ( ( (lv_parameters_6_0= ruleVariableEntity ) ) ruleNL )* )? (otherlv_8= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? (otherlv_12= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? otherlv_16= 'with' ruleNL ( (lv_statements_18_0= ruleSuiteStatement ) )* otherlv_19= 'suiteend' ruleNL
            {
            otherlv_0=(Token)match(input,36,FOLLOW_36_in_ruleSuiteDefinition2494); 

                	newLeafNode(otherlv_0, grammarAccess.getSuiteDefinitionAccess().getSuitedefKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleSuiteDefinition2510);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1153:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1154:1: (lv_name_2_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1154:1: (lv_name_2_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1155:3: lv_name_2_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuiteDefinition2530);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSuiteDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleSuiteDefinition2546);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1179:1: (otherlv_4= 'gets' ruleNL ( ( (lv_parameters_6_0= ruleVariableEntity ) ) ruleNL )* )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==37) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1179:3: otherlv_4= 'gets' ruleNL ( ( (lv_parameters_6_0= ruleVariableEntity ) ) ruleNL )*
                    {
                    otherlv_4=(Token)match(input,37,FOLLOW_37_in_ruleSuiteDefinition2558); 

                        	newLeafNode(otherlv_4, grammarAccess.getSuiteDefinitionAccess().getGetsKeyword_4_0());
                        
                     
                            newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_4_1()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleSuiteDefinition2574);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1191:1: ( ( (lv_parameters_6_0= ruleVariableEntity ) ) ruleNL )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==RULE_ID) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1191:2: ( (lv_parameters_6_0= ruleVariableEntity ) ) ruleNL
                    	    {
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1191:2: ( (lv_parameters_6_0= ruleVariableEntity ) )
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1192:1: (lv_parameters_6_0= ruleVariableEntity )
                    	    {
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1192:1: (lv_parameters_6_0= ruleVariableEntity )
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1193:3: lv_parameters_6_0= ruleVariableEntity
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getParametersVariableEntityParserRuleCall_4_2_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleVariableEntity_in_ruleSuiteDefinition2595);
                    	    lv_parameters_6_0=ruleVariableEntity();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSuiteDefinitionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"parameters",
                    	            		lv_parameters_6_0, 
                    	            		"VariableEntity");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	     
                    	            newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_4_2_1()); 
                    	        
                    	    pushFollow(FOLLOW_ruleNL_in_ruleSuiteDefinition2611);
                    	    ruleNL();

                    	    state._fsp--;

                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1217:5: (otherlv_8= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==38) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1217:7: otherlv_8= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )*
                    {
                    otherlv_8=(Token)match(input,38,FOLLOW_38_in_ruleSuiteDefinition2627); 

                        	newLeafNode(otherlv_8, grammarAccess.getSuiteDefinitionAccess().getRequiresKeyword_5_0());
                        
                     
                            newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_5_1()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleSuiteDefinition2643);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1229:1: ( ( ( ruleQualifiedName ) ) ruleNL )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_ID) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1229:2: ( ( ruleQualifiedName ) ) ruleNL
                    	    {
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1229:2: ( ( ruleQualifiedName ) )
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1230:1: ( ruleQualifiedName )
                    	    {
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1230:1: ( ruleQualifiedName )
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1231:3: ruleQualifiedName
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSuiteDefinitionRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getDependenciesSuiteDefinitionCrossReference_5_2_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuiteDefinition2666);
                    	    ruleQualifiedName();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	     
                    	            newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_5_2_1()); 
                    	        
                    	    pushFollow(FOLLOW_ruleNL_in_ruleSuiteDefinition2682);
                    	    ruleNL();

                    	    state._fsp--;

                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }
                    break;

            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1252:5: (otherlv_12= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==39) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1252:7: otherlv_12= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )*
                    {
                    otherlv_12=(Token)match(input,39,FOLLOW_39_in_ruleSuiteDefinition2698); 

                        	newLeafNode(otherlv_12, grammarAccess.getSuiteDefinitionAccess().getConcludedbyKeyword_6_0());
                        
                     
                            newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_6_1()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleSuiteDefinition2714);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1264:1: ( ( ( ruleQualifiedName ) ) ruleNL )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==RULE_ID) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1264:2: ( ( ruleQualifiedName ) ) ruleNL
                    	    {
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1264:2: ( ( ruleQualifiedName ) )
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1265:1: ( ruleQualifiedName )
                    	    {
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1265:1: ( ruleQualifiedName )
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1266:3: ruleQualifiedName
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSuiteDefinitionRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getFinalizersSuiteDefinitionCrossReference_6_2_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuiteDefinition2737);
                    	    ruleQualifiedName();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	     
                    	            newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_6_2_1()); 
                    	        
                    	    pushFollow(FOLLOW_ruleNL_in_ruleSuiteDefinition2753);
                    	    ruleNL();

                    	    state._fsp--;

                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_16=(Token)match(input,27,FOLLOW_27_in_ruleSuiteDefinition2768); 

                	newLeafNode(otherlv_16, grammarAccess.getSuiteDefinitionAccess().getWithKeyword_7());
                
             
                    newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_8()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleSuiteDefinition2784);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1299:1: ( (lv_statements_18_0= ruleSuiteStatement ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=RULE_SL_VISIBLE_COMMENT && LA16_0<=RULE_DIVIDER)||LA16_0==42||LA16_0==44||LA16_0==46||LA16_0==48||LA16_0==50||LA16_0==52) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1300:1: (lv_statements_18_0= ruleSuiteStatement )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1300:1: (lv_statements_18_0= ruleSuiteStatement )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1301:3: lv_statements_18_0= ruleSuiteStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getStatementsSuiteStatementParserRuleCall_9_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSuiteStatement_in_ruleSuiteDefinition2804);
            	    lv_statements_18_0=ruleSuiteStatement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSuiteDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"statements",
            	            		lv_statements_18_0, 
            	            		"SuiteStatement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

            otherlv_19=(Token)match(input,40,FOLLOW_40_in_ruleSuiteDefinition2817); 

                	newLeafNode(otherlv_19, grammarAccess.getSuiteDefinitionAccess().getSuiteendKeyword_10());
                
             
                    newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_11()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleSuiteDefinition2833);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                

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


    // $ANTLR start "entryRuleOperationDefinition"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1337:1: entryRuleOperationDefinition returns [EObject current=null] : iv_ruleOperationDefinition= ruleOperationDefinition EOF ;
    public final EObject entryRuleOperationDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1338:2: (iv_ruleOperationDefinition= ruleOperationDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1339:2: iv_ruleOperationDefinition= ruleOperationDefinition EOF
            {
             newCompositeNode(grammarAccess.getOperationDefinitionRule()); 
            pushFollow(FOLLOW_ruleOperationDefinition_in_entryRuleOperationDefinition2868);
            iv_ruleOperationDefinition=ruleOperationDefinition();

            state._fsp--;

             current =iv_ruleOperationDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperationDefinition2878); 

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
    // $ANTLR end "entryRuleOperationDefinition"


    // $ANTLR start "ruleOperationDefinition"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1346:1: ruleOperationDefinition returns [EObject current=null] : (otherlv_0= 'operationdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( ( ruleQualifiedJavaClassName ) ) ruleNL ) ;
    public final EObject ruleOperationDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1349:28: ( (otherlv_0= 'operationdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( ( ruleQualifiedJavaClassName ) ) ruleNL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1350:1: (otherlv_0= 'operationdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( ( ruleQualifiedJavaClassName ) ) ruleNL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1350:1: (otherlv_0= 'operationdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( ( ruleQualifiedJavaClassName ) ) ruleNL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1350:3: otherlv_0= 'operationdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( ( ruleQualifiedJavaClassName ) ) ruleNL
            {
            otherlv_0=(Token)match(input,41,FOLLOW_41_in_ruleOperationDefinition2915); 

                	newLeafNode(otherlv_0, grammarAccess.getOperationDefinitionAccess().getOperationdefKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getOperationDefinitionAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleOperationDefinition2931);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1362:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1363:1: (lv_name_2_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1363:1: (lv_name_2_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1364:3: lv_name_2_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getOperationDefinitionAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleOperationDefinition2951);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOperationDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getOperationDefinitionAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleOperationDefinition2967);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_4=(Token)match(input,31,FOLLOW_31_in_ruleOperationDefinition2978); 

                	newLeafNode(otherlv_4, grammarAccess.getOperationDefinitionAccess().getUsesKeyword_4());
                
             
                    newCompositeNode(grammarAccess.getOperationDefinitionAccess().getNLParserRuleCall_5()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleOperationDefinition2994);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1400:1: ( ( ruleQualifiedJavaClassName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1401:1: ( ruleQualifiedJavaClassName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1401:1: ( ruleQualifiedJavaClassName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1402:3: ruleQualifiedJavaClassName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getOperationDefinitionRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getOperationDefinitionAccess().getOperationTypeJvmTypeCrossReference_6_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_ruleOperationDefinition3016);
            ruleQualifiedJavaClassName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getOperationDefinitionAccess().getNLParserRuleCall_7()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleOperationDefinition3032);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                

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
    // $ANTLR end "ruleOperationDefinition"


    // $ANTLR start "entryRuleSuiteStatement"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1431:1: entryRuleSuiteStatement returns [EObject current=null] : iv_ruleSuiteStatement= ruleSuiteStatement EOF ;
    public final EObject entryRuleSuiteStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteStatement = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1432:2: (iv_ruleSuiteStatement= ruleSuiteStatement EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1433:2: iv_ruleSuiteStatement= ruleSuiteStatement EOF
            {
             newCompositeNode(grammarAccess.getSuiteStatementRule()); 
            pushFollow(FOLLOW_ruleSuiteStatement_in_entryRuleSuiteStatement3067);
            iv_ruleSuiteStatement=ruleSuiteStatement();

            state._fsp--;

             current =iv_ruleSuiteStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteStatement3077); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1440:1: ruleSuiteStatement returns [EObject current=null] : (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_VariableDefinition_1= ruleVariableDefinition | this_ConstantDefinition_2= ruleConstantDefinition | this_VisibleComment_3= ruleVisibleComment | this_VisibleDivider_4= ruleVisibleDivider ) ;
    public final EObject ruleSuiteStatement() throws RecognitionException {
        EObject current = null;

        EObject this_SuiteStatementWithResult_0 = null;

        EObject this_VariableDefinition_1 = null;

        EObject this_ConstantDefinition_2 = null;

        EObject this_VisibleComment_3 = null;

        EObject this_VisibleDivider_4 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1443:28: ( (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_VariableDefinition_1= ruleVariableDefinition | this_ConstantDefinition_2= ruleConstantDefinition | this_VisibleComment_3= ruleVisibleComment | this_VisibleDivider_4= ruleVisibleDivider ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1444:1: (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_VariableDefinition_1= ruleVariableDefinition | this_ConstantDefinition_2= ruleConstantDefinition | this_VisibleComment_3= ruleVisibleComment | this_VisibleDivider_4= ruleVisibleDivider )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1444:1: (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_VariableDefinition_1= ruleVariableDefinition | this_ConstantDefinition_2= ruleConstantDefinition | this_VisibleComment_3= ruleVisibleComment | this_VisibleDivider_4= ruleVisibleDivider )
            int alt17=5;
            switch ( input.LA(1) ) {
            case 46:
            case 48:
            case 50:
            case 52:
                {
                alt17=1;
                }
                break;
            case 42:
                {
                alt17=2;
                }
                break;
            case 44:
                {
                alt17=3;
                }
                break;
            case RULE_SL_VISIBLE_COMMENT:
            case RULE_ML_VISIBLE_COMMENT:
                {
                alt17=4;
                }
                break;
            case RULE_DIVIDER:
                {
                alt17=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1445:5: this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getSuiteStatementWithResultParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSuiteStatementWithResult_in_ruleSuiteStatement3124);
                    this_SuiteStatementWithResult_0=ruleSuiteStatementWithResult();

                    state._fsp--;

                     
                            current = this_SuiteStatementWithResult_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1455:5: this_VariableDefinition_1= ruleVariableDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getVariableDefinitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleVariableDefinition_in_ruleSuiteStatement3151);
                    this_VariableDefinition_1=ruleVariableDefinition();

                    state._fsp--;

                     
                            current = this_VariableDefinition_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1465:5: this_ConstantDefinition_2= ruleConstantDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getConstantDefinitionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleConstantDefinition_in_ruleSuiteStatement3178);
                    this_ConstantDefinition_2=ruleConstantDefinition();

                    state._fsp--;

                     
                            current = this_ConstantDefinition_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1475:5: this_VisibleComment_3= ruleVisibleComment
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getVisibleCommentParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleVisibleComment_in_ruleSuiteStatement3205);
                    this_VisibleComment_3=ruleVisibleComment();

                    state._fsp--;

                     
                            current = this_VisibleComment_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1485:5: this_VisibleDivider_4= ruleVisibleDivider
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getVisibleDividerParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleVisibleDivider_in_ruleSuiteStatement3232);
                    this_VisibleDivider_4=ruleVisibleDivider();

                    state._fsp--;

                     
                            current = this_VisibleDivider_4; 
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1501:1: entryRuleSuiteStatementWithResult returns [EObject current=null] : iv_ruleSuiteStatementWithResult= ruleSuiteStatementWithResult EOF ;
    public final EObject entryRuleSuiteStatementWithResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteStatementWithResult = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1502:2: (iv_ruleSuiteStatementWithResult= ruleSuiteStatementWithResult EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1503:2: iv_ruleSuiteStatementWithResult= ruleSuiteStatementWithResult EOF
            {
             newCompositeNode(grammarAccess.getSuiteStatementWithResultRule()); 
            pushFollow(FOLLOW_ruleSuiteStatementWithResult_in_entryRuleSuiteStatementWithResult3267);
            iv_ruleSuiteStatementWithResult=ruleSuiteStatementWithResult();

            state._fsp--;

             current =iv_ruleSuiteStatementWithResult; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteStatementWithResult3277); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1510:1: ruleSuiteStatementWithResult returns [EObject current=null] : (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest | this_Call_3= ruleCall ) ;
    public final EObject ruleSuiteStatementWithResult() throws RecognitionException {
        EObject current = null;

        EObject this_Suite_0 = null;

        EObject this_Test_1 = null;

        EObject this_TableTest_2 = null;

        EObject this_Call_3 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1513:28: ( (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest | this_Call_3= ruleCall ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1514:1: (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest | this_Call_3= ruleCall )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1514:1: (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest | this_Call_3= ruleCall )
            int alt18=4;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt18=1;
                }
                break;
            case 46:
                {
                alt18=2;
                }
                break;
            case 48:
                {
                alt18=3;
                }
                break;
            case 50:
                {
                alt18=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }

            switch (alt18) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1515:5: this_Suite_0= ruleSuite
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementWithResultAccess().getSuiteParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSuite_in_ruleSuiteStatementWithResult3324);
                    this_Suite_0=ruleSuite();

                    state._fsp--;

                     
                            current = this_Suite_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1525:5: this_Test_1= ruleTest
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementWithResultAccess().getTestParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleTest_in_ruleSuiteStatementWithResult3351);
                    this_Test_1=ruleTest();

                    state._fsp--;

                     
                            current = this_Test_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1535:5: this_TableTest_2= ruleTableTest
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementWithResultAccess().getTableTestParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleTableTest_in_ruleSuiteStatementWithResult3378);
                    this_TableTest_2=ruleTableTest();

                    state._fsp--;

                     
                            current = this_TableTest_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1545:5: this_Call_3= ruleCall
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementWithResultAccess().getCallParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleCall_in_ruleSuiteStatementWithResult3405);
                    this_Call_3=ruleCall();

                    state._fsp--;

                     
                            current = this_Call_3; 
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1561:1: entryRuleVariableDefinition returns [EObject current=null] : iv_ruleVariableDefinition= ruleVariableDefinition EOF ;
    public final EObject entryRuleVariableDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1562:2: (iv_ruleVariableDefinition= ruleVariableDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1563:2: iv_ruleVariableDefinition= ruleVariableDefinition EOF
            {
             newCompositeNode(grammarAccess.getVariableDefinitionRule()); 
            pushFollow(FOLLOW_ruleVariableDefinition_in_entryRuleVariableDefinition3440);
            iv_ruleVariableDefinition=ruleVariableDefinition();

            state._fsp--;

             current =iv_ruleVariableDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDefinition3450); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1570:1: ruleVariableDefinition returns [EObject current=null] : (otherlv_0= 'variable' ruleNL ( (lv_name_2_0= ruleVariableEntity ) ) ruleNL (otherlv_4= 'initially' ruleNL ( (lv_initialValue_6_0= ruleValue ) ) ruleNL )? ) ;
    public final EObject ruleVariableDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject lv_name_2_0 = null;

        EObject lv_initialValue_6_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1573:28: ( (otherlv_0= 'variable' ruleNL ( (lv_name_2_0= ruleVariableEntity ) ) ruleNL (otherlv_4= 'initially' ruleNL ( (lv_initialValue_6_0= ruleValue ) ) ruleNL )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1574:1: (otherlv_0= 'variable' ruleNL ( (lv_name_2_0= ruleVariableEntity ) ) ruleNL (otherlv_4= 'initially' ruleNL ( (lv_initialValue_6_0= ruleValue ) ) ruleNL )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1574:1: (otherlv_0= 'variable' ruleNL ( (lv_name_2_0= ruleVariableEntity ) ) ruleNL (otherlv_4= 'initially' ruleNL ( (lv_initialValue_6_0= ruleValue ) ) ruleNL )? )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1574:3: otherlv_0= 'variable' ruleNL ( (lv_name_2_0= ruleVariableEntity ) ) ruleNL (otherlv_4= 'initially' ruleNL ( (lv_initialValue_6_0= ruleValue ) ) ruleNL )?
            {
            otherlv_0=(Token)match(input,42,FOLLOW_42_in_ruleVariableDefinition3487); 

                	newLeafNode(otherlv_0, grammarAccess.getVariableDefinitionAccess().getVariableKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getVariableDefinitionAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleVariableDefinition3503);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1586:1: ( (lv_name_2_0= ruleVariableEntity ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1587:1: (lv_name_2_0= ruleVariableEntity )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1587:1: (lv_name_2_0= ruleVariableEntity )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1588:3: lv_name_2_0= ruleVariableEntity
            {
             
            	        newCompositeNode(grammarAccess.getVariableDefinitionAccess().getNameVariableEntityParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleVariableEntity_in_ruleVariableDefinition3523);
            lv_name_2_0=ruleVariableEntity();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVariableDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"VariableEntity");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getVariableDefinitionAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleVariableDefinition3539);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1612:1: (otherlv_4= 'initially' ruleNL ( (lv_initialValue_6_0= ruleValue ) ) ruleNL )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==43) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1612:3: otherlv_4= 'initially' ruleNL ( (lv_initialValue_6_0= ruleValue ) ) ruleNL
                    {
                    otherlv_4=(Token)match(input,43,FOLLOW_43_in_ruleVariableDefinition3551); 

                        	newLeafNode(otherlv_4, grammarAccess.getVariableDefinitionAccess().getInitiallyKeyword_4_0());
                        
                     
                            newCompositeNode(grammarAccess.getVariableDefinitionAccess().getNLParserRuleCall_4_1()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleVariableDefinition3567);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1624:1: ( (lv_initialValue_6_0= ruleValue ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1625:1: (lv_initialValue_6_0= ruleValue )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1625:1: (lv_initialValue_6_0= ruleValue )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1626:3: lv_initialValue_6_0= ruleValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariableDefinitionAccess().getInitialValueValueParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValue_in_ruleVariableDefinition3587);
                    lv_initialValue_6_0=ruleValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVariableDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"initialValue",
                            		lv_initialValue_6_0, 
                            		"Value");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getVariableDefinitionAccess().getNLParserRuleCall_4_3()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleVariableDefinition3603);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1658:1: entryRuleConstantDefinition returns [EObject current=null] : iv_ruleConstantDefinition= ruleConstantDefinition EOF ;
    public final EObject entryRuleConstantDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1659:2: (iv_ruleConstantDefinition= ruleConstantDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1660:2: iv_ruleConstantDefinition= ruleConstantDefinition EOF
            {
             newCompositeNode(grammarAccess.getConstantDefinitionRule()); 
            pushFollow(FOLLOW_ruleConstantDefinition_in_entryRuleConstantDefinition3640);
            iv_ruleConstantDefinition=ruleConstantDefinition();

            state._fsp--;

             current =iv_ruleConstantDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstantDefinition3650); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1667:1: ruleConstantDefinition returns [EObject current=null] : (otherlv_0= 'constant' ruleNL ( (lv_name_2_0= ruleVariableEntity ) ) ruleNL ( ( (lv_value_4_0= ruleStaticValue ) ) ruleNL )? ( ( (lv_variantValues_6_0= ruleVariantValue ) ) ruleNL )* ) ;
    public final EObject ruleConstantDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_name_2_0 = null;

        EObject lv_value_4_0 = null;

        EObject lv_variantValues_6_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1670:28: ( (otherlv_0= 'constant' ruleNL ( (lv_name_2_0= ruleVariableEntity ) ) ruleNL ( ( (lv_value_4_0= ruleStaticValue ) ) ruleNL )? ( ( (lv_variantValues_6_0= ruleVariantValue ) ) ruleNL )* ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1671:1: (otherlv_0= 'constant' ruleNL ( (lv_name_2_0= ruleVariableEntity ) ) ruleNL ( ( (lv_value_4_0= ruleStaticValue ) ) ruleNL )? ( ( (lv_variantValues_6_0= ruleVariantValue ) ) ruleNL )* )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1671:1: (otherlv_0= 'constant' ruleNL ( (lv_name_2_0= ruleVariableEntity ) ) ruleNL ( ( (lv_value_4_0= ruleStaticValue ) ) ruleNL )? ( ( (lv_variantValues_6_0= ruleVariantValue ) ) ruleNL )* )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1671:3: otherlv_0= 'constant' ruleNL ( (lv_name_2_0= ruleVariableEntity ) ) ruleNL ( ( (lv_value_4_0= ruleStaticValue ) ) ruleNL )? ( ( (lv_variantValues_6_0= ruleVariantValue ) ) ruleNL )*
            {
            otherlv_0=(Token)match(input,44,FOLLOW_44_in_ruleConstantDefinition3687); 

                	newLeafNode(otherlv_0, grammarAccess.getConstantDefinitionAccess().getConstantKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getConstantDefinitionAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleConstantDefinition3703);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1683:1: ( (lv_name_2_0= ruleVariableEntity ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1684:1: (lv_name_2_0= ruleVariableEntity )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1684:1: (lv_name_2_0= ruleVariableEntity )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1685:3: lv_name_2_0= ruleVariableEntity
            {
             
            	        newCompositeNode(grammarAccess.getConstantDefinitionAccess().getNameVariableEntityParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleVariableEntity_in_ruleConstantDefinition3723);
            lv_name_2_0=ruleVariableEntity();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConstantDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"VariableEntity");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getConstantDefinitionAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleConstantDefinition3739);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1709:1: ( ( (lv_value_4_0= ruleStaticValue ) ) ruleNL )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_STRING||(LA20_0>=RULE_INTEGER && LA20_0<=RULE_TWELVEHRSTIME)||LA20_0==58) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1709:2: ( (lv_value_4_0= ruleStaticValue ) ) ruleNL
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1709:2: ( (lv_value_4_0= ruleStaticValue ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1710:1: (lv_value_4_0= ruleStaticValue )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1710:1: (lv_value_4_0= ruleStaticValue )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1711:3: lv_value_4_0= ruleStaticValue
                    {
                     
                    	        newCompositeNode(grammarAccess.getConstantDefinitionAccess().getValueStaticValueParserRuleCall_4_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleStaticValue_in_ruleConstantDefinition3760);
                    lv_value_4_0=ruleStaticValue();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConstantDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_4_0, 
                            		"StaticValue");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getConstantDefinitionAccess().getNLParserRuleCall_4_1()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleConstantDefinition3776);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1735:3: ( ( (lv_variantValues_6_0= ruleVariantValue ) ) ruleNL )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==45) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1735:4: ( (lv_variantValues_6_0= ruleVariantValue ) ) ruleNL
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1735:4: ( (lv_variantValues_6_0= ruleVariantValue ) )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1736:1: (lv_variantValues_6_0= ruleVariantValue )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1736:1: (lv_variantValues_6_0= ruleVariantValue )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1737:3: lv_variantValues_6_0= ruleVariantValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConstantDefinitionAccess().getVariantValuesVariantValueParserRuleCall_5_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleVariantValue_in_ruleConstantDefinition3799);
            	    lv_variantValues_6_0=ruleVariantValue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConstantDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"variantValues",
            	            		lv_variantValues_6_0, 
            	            		"VariantValue");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	     
            	            newCompositeNode(grammarAccess.getConstantDefinitionAccess().getNLParserRuleCall_5_1()); 
            	        
            	    pushFollow(FOLLOW_ruleNL_in_ruleConstantDefinition3815);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop21;
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
    // $ANTLR end "ruleConstantDefinition"


    // $ANTLR start "entryRuleVariantValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1769:1: entryRuleVariantValue returns [EObject current=null] : iv_ruleVariantValue= ruleVariantValue EOF ;
    public final EObject entryRuleVariantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariantValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1770:2: (iv_ruleVariantValue= ruleVariantValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1771:2: iv_ruleVariantValue= ruleVariantValue EOF
            {
             newCompositeNode(grammarAccess.getVariantValueRule()); 
            pushFollow(FOLLOW_ruleVariantValue_in_entryRuleVariantValue3852);
            iv_ruleVariantValue=ruleVariantValue();

            state._fsp--;

             current =iv_ruleVariantValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariantValue3862); 

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
    // $ANTLR end "entryRuleVariantValue"


    // $ANTLR start "ruleVariantValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1778:1: ruleVariantValue returns [EObject current=null] : (otherlv_0= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ otherlv_4= ':' ruleNL ( (lv_value_6_0= ruleStaticValue ) ) ) ;
    public final EObject ruleVariantValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject lv_value_6_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1781:28: ( (otherlv_0= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ otherlv_4= ':' ruleNL ( (lv_value_6_0= ruleStaticValue ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1782:1: (otherlv_0= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ otherlv_4= ':' ruleNL ( (lv_value_6_0= ruleStaticValue ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1782:1: (otherlv_0= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ otherlv_4= ':' ruleNL ( (lv_value_6_0= ruleStaticValue ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1782:3: otherlv_0= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ otherlv_4= ':' ruleNL ( (lv_value_6_0= ruleStaticValue ) )
            {
            otherlv_0=(Token)match(input,45,FOLLOW_45_in_ruleVariantValue3899); 

                	newLeafNode(otherlv_0, grammarAccess.getVariantValueAccess().getInKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getVariantValueAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleVariantValue3915);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1794:1: ( ( ( ruleQualifiedName ) ) ruleNL )+
            int cnt22=0;
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==RULE_ID) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1794:2: ( ( ruleQualifiedName ) ) ruleNL
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1794:2: ( ( ruleQualifiedName ) )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1795:1: ( ruleQualifiedName )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1795:1: ( ruleQualifiedName )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1796:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getVariantValueRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getVariantValueAccess().getNamesVariantDefinitionCrossReference_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleVariantValue3938);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	     
            	            newCompositeNode(grammarAccess.getVariantValueAccess().getNLParserRuleCall_2_1()); 
            	        
            	    pushFollow(FOLLOW_ruleNL_in_ruleVariantValue3954);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

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

            otherlv_4=(Token)match(input,32,FOLLOW_32_in_ruleVariantValue3967); 

                	newLeafNode(otherlv_4, grammarAccess.getVariantValueAccess().getColonKeyword_3());
                
             
                    newCompositeNode(grammarAccess.getVariantValueAccess().getNLParserRuleCall_4()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleVariantValue3983);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1829:1: ( (lv_value_6_0= ruleStaticValue ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1830:1: (lv_value_6_0= ruleStaticValue )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1830:1: (lv_value_6_0= ruleStaticValue )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1831:3: lv_value_6_0= ruleStaticValue
            {
             
            	        newCompositeNode(grammarAccess.getVariantValueAccess().getValueStaticValueParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleStaticValue_in_ruleVariantValue4003);
            lv_value_6_0=ruleStaticValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVariantValueRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_6_0, 
                    		"StaticValue");
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
    // $ANTLR end "ruleVariantValue"


    // $ANTLR start "entryRuleVariableEntity"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1855:1: entryRuleVariableEntity returns [EObject current=null] : iv_ruleVariableEntity= ruleVariableEntity EOF ;
    public final EObject entryRuleVariableEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableEntity = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1856:2: (iv_ruleVariableEntity= ruleVariableEntity EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1857:2: iv_ruleVariableEntity= ruleVariableEntity EOF
            {
             newCompositeNode(grammarAccess.getVariableEntityRule()); 
            pushFollow(FOLLOW_ruleVariableEntity_in_entryRuleVariableEntity4039);
            iv_ruleVariableEntity=ruleVariableEntity();

            state._fsp--;

             current =iv_ruleVariableEntity; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableEntity4049); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1864:1: ruleVariableEntity returns [EObject current=null] : ( (lv_name_0_0= ruleQualifiedName ) ) ;
    public final EObject ruleVariableEntity() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1867:28: ( ( (lv_name_0_0= ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1868:1: ( (lv_name_0_0= ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1868:1: ( (lv_name_0_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1869:1: (lv_name_0_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1869:1: (lv_name_0_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1870:3: lv_name_0_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getVariableEntityAccess().getNameQualifiedNameParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleVariableEntity4094);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1894:1: entryRuleTest returns [EObject current=null] : iv_ruleTest= ruleTest EOF ;
    public final EObject entryRuleTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTest = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1895:2: (iv_ruleTest= ruleTest EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1896:2: iv_ruleTest= ruleTest EOF
            {
             newCompositeNode(grammarAccess.getTestRule()); 
            pushFollow(FOLLOW_ruleTest_in_entryRuleTest4129);
            iv_ruleTest=ruleTest();

            state._fsp--;

             current =iv_ruleTest; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTest4139); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1903:1: ruleTest returns [EObject current=null] : (otherlv_0= 'test' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_6_0= ruleNamedResult ) ) )* ( ruleNL otherlv_8= '=' ruleNL ( (lv_result_10_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL ) ;
    public final EObject ruleTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_8=null;
        EObject lv_parameters_4_0 = null;

        EObject lv_results_6_0 = null;

        EObject lv_result_10_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1906:28: ( (otherlv_0= 'test' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_6_0= ruleNamedResult ) ) )* ( ruleNL otherlv_8= '=' ruleNL ( (lv_result_10_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1907:1: (otherlv_0= 'test' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_6_0= ruleNamedResult ) ) )* ( ruleNL otherlv_8= '=' ruleNL ( (lv_result_10_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1907:1: (otherlv_0= 'test' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_6_0= ruleNamedResult ) ) )* ( ruleNL otherlv_8= '=' ruleNL ( (lv_result_10_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1907:3: otherlv_0= 'test' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_6_0= ruleNamedResult ) ) )* ( ruleNL otherlv_8= '=' ruleNL ( (lv_result_10_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL
            {
            otherlv_0=(Token)match(input,46,FOLLOW_46_in_ruleTest4176); 

                	newLeafNode(otherlv_0, grammarAccess.getTestAccess().getTestKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getTestAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleTest4192);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1919:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1920:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1920:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1921:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTestRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTestAccess().getDefinitionTestDefinitionCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleTest4214);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1934:2: ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )*
            loop23:
            do {
                int alt23=2;
                alt23 = dfa23.predict(input);
                switch (alt23) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1935:5: ruleNL ( (lv_parameters_4_0= ruleParameter ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getTestAccess().getNLParserRuleCall_3_0()); 
            	        
            	    pushFollow(FOLLOW_ruleNL_in_ruleTest4231);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1942:1: ( (lv_parameters_4_0= ruleParameter ) )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1943:1: (lv_parameters_4_0= ruleParameter )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1943:1: (lv_parameters_4_0= ruleParameter )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1944:3: lv_parameters_4_0= ruleParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTestAccess().getParametersParameterParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameter_in_ruleTest4251);
            	    lv_parameters_4_0=ruleParameter();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"parameters",
            	            		lv_parameters_4_0, 
            	            		"Parameter");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1960:4: ( ruleNL ( (lv_results_6_0= ruleNamedResult ) ) )*
            loop24:
            do {
                int alt24=2;
                alt24 = dfa24.predict(input);
                switch (alt24) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1961:5: ruleNL ( (lv_results_6_0= ruleNamedResult ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getTestAccess().getNLParserRuleCall_4_0()); 
            	        
            	    pushFollow(FOLLOW_ruleNL_in_ruleTest4270);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1968:1: ( (lv_results_6_0= ruleNamedResult ) )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1969:1: (lv_results_6_0= ruleNamedResult )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1969:1: (lv_results_6_0= ruleNamedResult )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1970:3: lv_results_6_0= ruleNamedResult
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTestAccess().getResultsNamedResultParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleNamedResult_in_ruleTest4290);
            	    lv_results_6_0=ruleNamedResult();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"results",
            	            		lv_results_6_0, 
            	            		"NamedResult");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1986:4: ( ruleNL otherlv_8= '=' ruleNL ( (lv_result_10_0= ruleValueOrEnumValueOrOperationCollection ) ) )?
            int alt25=2;
            alt25 = dfa25.predict(input);
            switch (alt25) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1987:5: ruleNL otherlv_8= '=' ruleNL ( (lv_result_10_0= ruleValueOrEnumValueOrOperationCollection ) )
                    {
                     
                            newCompositeNode(grammarAccess.getTestAccess().getNLParserRuleCall_5_0()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleTest4309);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    otherlv_8=(Token)match(input,47,FOLLOW_47_in_ruleTest4320); 

                        	newLeafNode(otherlv_8, grammarAccess.getTestAccess().getEqualsSignKeyword_5_1());
                        
                     
                            newCompositeNode(grammarAccess.getTestAccess().getNLParserRuleCall_5_2()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleTest4336);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2006:1: ( (lv_result_10_0= ruleValueOrEnumValueOrOperationCollection ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2007:1: (lv_result_10_0= ruleValueOrEnumValueOrOperationCollection )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2007:1: (lv_result_10_0= ruleValueOrEnumValueOrOperationCollection )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2008:3: lv_result_10_0= ruleValueOrEnumValueOrOperationCollection
                    {
                     
                    	        newCompositeNode(grammarAccess.getTestAccess().getResultValueOrEnumValueOrOperationCollectionParserRuleCall_5_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleTest4356);
                    lv_result_10_0=ruleValueOrEnumValueOrOperationCollection();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTestRule());
                    	        }
                           		set(
                           			current, 
                           			"result",
                            		lv_result_10_0, 
                            		"ValueOrEnumValueOrOperationCollection");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

             
                    newCompositeNode(grammarAccess.getTestAccess().getNLParserRuleCall_6()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleTest4374);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2040:1: entryRuleTableTest returns [EObject current=null] : iv_ruleTableTest= ruleTableTest EOF ;
    public final EObject entryRuleTableTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTableTest = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2041:2: (iv_ruleTableTest= ruleTableTest EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2042:2: iv_ruleTableTest= ruleTableTest EOF
            {
             newCompositeNode(grammarAccess.getTableTestRule()); 
            pushFollow(FOLLOW_ruleTableTest_in_entryRuleTableTest4409);
            iv_ruleTableTest=ruleTableTest();

            state._fsp--;

             current =iv_ruleTableTest; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTableTest4419); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2049:1: ruleTableTest returns [EObject current=null] : (otherlv_0= 'tabletest' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ruleNLFORCED ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )* otherlv_8= '|' ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )? ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+ ruleNLFORCED ) ;
    public final EObject ruleTableTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_8=null;
        Token lv_defaultResultColumn_9_0=null;
        Token otherlv_10=null;
        EObject lv_parameters_4_0 = null;

        EObject lv_parameterHeaders_6_0 = null;

        EObject lv_resultHeaders_7_0 = null;

        EObject lv_rows_12_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2052:28: ( (otherlv_0= 'tabletest' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ruleNLFORCED ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )* otherlv_8= '|' ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )? ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+ ruleNLFORCED ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2053:1: (otherlv_0= 'tabletest' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ruleNLFORCED ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )* otherlv_8= '|' ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )? ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+ ruleNLFORCED )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2053:1: (otherlv_0= 'tabletest' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ruleNLFORCED ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )* otherlv_8= '|' ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )? ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+ ruleNLFORCED )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2053:3: otherlv_0= 'tabletest' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ruleNLFORCED ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )* otherlv_8= '|' ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )? ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+ ruleNLFORCED
            {
            otherlv_0=(Token)match(input,48,FOLLOW_48_in_ruleTableTest4456); 

                	newLeafNode(otherlv_0, grammarAccess.getTableTestAccess().getTabletestKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getTableTestAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleTableTest4472);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2065:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2066:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2066:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2067:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTableTestRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTableTestAccess().getDefinitionTestDefinitionCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleTableTest4494);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2080:2: ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )*
            loop26:
            do {
                int alt26=2;
                alt26 = dfa26.predict(input);
                switch (alt26) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2081:5: ruleNL ( (lv_parameters_4_0= ruleParameter ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getTableTestAccess().getNLParserRuleCall_3_0()); 
            	        
            	    pushFollow(FOLLOW_ruleNL_in_ruleTableTest4511);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2088:1: ( (lv_parameters_4_0= ruleParameter ) )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2089:1: (lv_parameters_4_0= ruleParameter )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2089:1: (lv_parameters_4_0= ruleParameter )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2090:3: lv_parameters_4_0= ruleParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getParametersParameterParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameter_in_ruleTableTest4531);
            	    lv_parameters_4_0=ruleParameter();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTableTestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"parameters",
            	            		lv_parameters_4_0, 
            	            		"Parameter");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

             
                    newCompositeNode(grammarAccess.getTableTestAccess().getNLFORCEDParserRuleCall_4()); 
                
            pushFollow(FOLLOW_ruleNLFORCED_in_ruleTableTest4549);
            ruleNLFORCED();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2114:1: ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==49) ) {
                    int LA27_1 = input.LA(2);

                    if ( (LA27_1==RULE_ID) ) {
                        int LA27_3 = input.LA(3);

                        if ( (LA27_3==49) ) {
                            alt27=1;
                        }


                    }
                    else if ( (LA27_1==54) ) {
                        int LA27_4 = input.LA(3);

                        if ( (LA27_4==RULE_ID) ) {
                            int LA27_6 = input.LA(4);

                            if ( (LA27_6==49) ) {
                                alt27=1;
                            }


                        }


                    }


                }


                switch (alt27) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2115:1: (lv_parameterHeaders_6_0= ruleParameterTableHeader )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2115:1: (lv_parameterHeaders_6_0= ruleParameterTableHeader )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2116:3: lv_parameterHeaders_6_0= ruleParameterTableHeader
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getParameterHeadersParameterTableHeaderParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameterTableHeader_in_ruleTableTest4569);
            	    lv_parameterHeaders_6_0=ruleParameterTableHeader();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTableTestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"parameterHeaders",
            	            		lv_parameterHeaders_6_0, 
            	            		"ParameterTableHeader");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2132:3: ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==49) ) {
                    int LA28_1 = input.LA(2);

                    if ( (LA28_1==RULE_ID||LA28_1==54) ) {
                        alt28=1;
                    }


                }


                switch (alt28) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2133:1: (lv_resultHeaders_7_0= ruleResultTableHeader )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2133:1: (lv_resultHeaders_7_0= ruleResultTableHeader )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2134:3: lv_resultHeaders_7_0= ruleResultTableHeader
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getResultHeadersResultTableHeaderParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleResultTableHeader_in_ruleTableTest4591);
            	    lv_resultHeaders_7_0=ruleResultTableHeader();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTableTestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"resultHeaders",
            	            		lv_resultHeaders_7_0, 
            	            		"ResultTableHeader");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            otherlv_8=(Token)match(input,49,FOLLOW_49_in_ruleTableTest4604); 

                	newLeafNode(otherlv_8, grammarAccess.getTableTestAccess().getVerticalLineKeyword_7());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2154:1: ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==47) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2154:2: ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|'
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2154:2: ( (lv_defaultResultColumn_9_0= '=' ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2155:1: (lv_defaultResultColumn_9_0= '=' )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2155:1: (lv_defaultResultColumn_9_0= '=' )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2156:3: lv_defaultResultColumn_9_0= '='
                    {
                    lv_defaultResultColumn_9_0=(Token)match(input,47,FOLLOW_47_in_ruleTableTest4623); 

                            newLeafNode(lv_defaultResultColumn_9_0, grammarAccess.getTableTestAccess().getDefaultResultColumnEqualsSignKeyword_8_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTableTestRule());
                    	        }
                           		setWithLastConsumed(current, "defaultResultColumn", lv_defaultResultColumn_9_0, "=");
                    	    

                    }


                    }

                    otherlv_10=(Token)match(input,49,FOLLOW_49_in_ruleTableTest4648); 

                        	newLeafNode(otherlv_10, grammarAccess.getTableTestAccess().getVerticalLineKeyword_8_1());
                        

                    }
                    break;

            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2173:3: ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+
            int cnt30=0;
            loop30:
            do {
                int alt30=2;
                alt30 = dfa30.predict(input);
                switch (alt30) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2174:5: ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getTableTestAccess().getNLFORCEDParserRuleCall_9_0()); 
            	        
            	    pushFollow(FOLLOW_ruleNLFORCED_in_ruleTableTest4667);
            	    ruleNLFORCED();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2181:1: ( (lv_rows_12_0= ruleTableTestRow ) )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2182:1: (lv_rows_12_0= ruleTableTestRow )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2182:1: (lv_rows_12_0= ruleTableTestRow )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2183:3: lv_rows_12_0= ruleTableTestRow
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getRowsTableTestRowParserRuleCall_9_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTableTestRow_in_ruleTableTest4687);
            	    lv_rows_12_0=ruleTableTestRow();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTableTestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"rows",
            	            		lv_rows_12_0, 
            	            		"TableTestRow");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt30 >= 1 ) break loop30;
                        EarlyExitException eee =
                            new EarlyExitException(30, input);
                        throw eee;
                }
                cnt30++;
            } while (true);

             
                    newCompositeNode(grammarAccess.getTableTestAccess().getNLFORCEDParserRuleCall_10()); 
                
            pushFollow(FOLLOW_ruleNLFORCED_in_ruleTableTest4705);
            ruleNLFORCED();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2215:1: entryRuleTableTestRow returns [EObject current=null] : iv_ruleTableTestRow= ruleTableTestRow EOF ;
    public final EObject entryRuleTableTestRow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTableTestRow = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2216:2: (iv_ruleTableTestRow= ruleTableTestRow EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2217:2: iv_ruleTableTestRow= ruleTableTestRow EOF
            {
             newCompositeNode(grammarAccess.getTableTestRowRule()); 
            pushFollow(FOLLOW_ruleTableTestRow_in_entryRuleTableTestRow4740);
            iv_ruleTableTestRow=ruleTableTestRow();

            state._fsp--;

             current =iv_ruleTableTestRow; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTableTestRow4750); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2224:1: ruleTableTestRow returns [EObject current=null] : ( () ( (lv_values_1_0= ruleParameterTableValue ) )+ ) ;
    public final EObject ruleTableTestRow() throws RecognitionException {
        EObject current = null;

        EObject lv_values_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2227:28: ( ( () ( (lv_values_1_0= ruleParameterTableValue ) )+ ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2228:1: ( () ( (lv_values_1_0= ruleParameterTableValue ) )+ )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2228:1: ( () ( (lv_values_1_0= ruleParameterTableValue ) )+ )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2228:2: () ( (lv_values_1_0= ruleParameterTableValue ) )+
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2228:2: ()
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2229:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTableTestRowAccess().getTableTestRowAction_0(),
                        current);
                

            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2234:2: ( (lv_values_1_0= ruleParameterTableValue ) )+
            int cnt31=0;
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==49) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2235:1: (lv_values_1_0= ruleParameterTableValue )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2235:1: (lv_values_1_0= ruleParameterTableValue )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2236:3: lv_values_1_0= ruleParameterTableValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestRowAccess().getValuesParameterTableValueParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameterTableValue_in_ruleTableTestRow4805);
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
            	    if ( cnt31 >= 1 ) break loop31;
                        EarlyExitException eee =
                            new EarlyExitException(31, input);
                        throw eee;
                }
                cnt31++;
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
    // $ANTLR end "ruleTableTestRow"


    // $ANTLR start "entryRuleParameterTableHeader"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2260:1: entryRuleParameterTableHeader returns [EObject current=null] : iv_ruleParameterTableHeader= ruleParameterTableHeader EOF ;
    public final EObject entryRuleParameterTableHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterTableHeader = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2261:2: (iv_ruleParameterTableHeader= ruleParameterTableHeader EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2262:2: iv_ruleParameterTableHeader= ruleParameterTableHeader EOF
            {
             newCompositeNode(grammarAccess.getParameterTableHeaderRule()); 
            pushFollow(FOLLOW_ruleParameterTableHeader_in_entryRuleParameterTableHeader4842);
            iv_ruleParameterTableHeader=ruleParameterTableHeader();

            state._fsp--;

             current =iv_ruleParameterTableHeader; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterTableHeader4852); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2269:1: ruleParameterTableHeader returns [EObject current=null] : (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) (otherlv_2= '|' )? ) ;
    public final EObject ruleParameterTableHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2272:28: ( (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) (otherlv_2= '|' )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2273:1: (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) (otherlv_2= '|' )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2273:1: (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) (otherlv_2= '|' )? )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2273:3: otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) (otherlv_2= '|' )?
            {
            otherlv_0=(Token)match(input,49,FOLLOW_49_in_ruleParameterTableHeader4889); 

                	newLeafNode(otherlv_0, grammarAccess.getParameterTableHeaderAccess().getVerticalLineKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2277:1: ( (lv_name_1_0= ruleParameterName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2278:1: (lv_name_1_0= ruleParameterName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2278:1: (lv_name_1_0= ruleParameterName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2279:3: lv_name_1_0= ruleParameterName
            {
             
            	        newCompositeNode(grammarAccess.getParameterTableHeaderAccess().getNameParameterNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleParameterName_in_ruleParameterTableHeader4910);
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

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2295:2: (otherlv_2= '|' )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==49) ) {
                int LA32_1 = input.LA(2);

                if ( (LA32_1==EOF||LA32_1==49) ) {
                    alt32=1;
                }
            }
            switch (alt32) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2295:4: otherlv_2= '|'
                    {
                    otherlv_2=(Token)match(input,49,FOLLOW_49_in_ruleParameterTableHeader4923); 

                        	newLeafNode(otherlv_2, grammarAccess.getParameterTableHeaderAccess().getVerticalLineKeyword_2());
                        

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
    // $ANTLR end "ruleParameterTableHeader"


    // $ANTLR start "entryRuleResultTableHeader"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2307:1: entryRuleResultTableHeader returns [EObject current=null] : iv_ruleResultTableHeader= ruleResultTableHeader EOF ;
    public final EObject entryRuleResultTableHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultTableHeader = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2308:2: (iv_ruleResultTableHeader= ruleResultTableHeader EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2309:2: iv_ruleResultTableHeader= ruleResultTableHeader EOF
            {
             newCompositeNode(grammarAccess.getResultTableHeaderRule()); 
            pushFollow(FOLLOW_ruleResultTableHeader_in_entryRuleResultTableHeader4961);
            iv_ruleResultTableHeader=ruleResultTableHeader();

            state._fsp--;

             current =iv_ruleResultTableHeader; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultTableHeader4971); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2316:1: ruleResultTableHeader returns [EObject current=null] : (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' (otherlv_3= '|' )? ) ;
    public final EObject ruleResultTableHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2319:28: ( (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' (otherlv_3= '|' )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2320:1: (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' (otherlv_3= '|' )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2320:1: (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' (otherlv_3= '|' )? )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2320:3: otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' (otherlv_3= '|' )?
            {
            otherlv_0=(Token)match(input,49,FOLLOW_49_in_ruleResultTableHeader5008); 

                	newLeafNode(otherlv_0, grammarAccess.getResultTableHeaderAccess().getVerticalLineKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2324:1: ( (lv_name_1_0= ruleResultName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2325:1: (lv_name_1_0= ruleResultName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2325:1: (lv_name_1_0= ruleResultName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2326:3: lv_name_1_0= ruleResultName
            {
             
            	        newCompositeNode(grammarAccess.getResultTableHeaderAccess().getNameResultNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleResultName_in_ruleResultTableHeader5029);
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

            otherlv_2=(Token)match(input,47,FOLLOW_47_in_ruleResultTableHeader5041); 

                	newLeafNode(otherlv_2, grammarAccess.getResultTableHeaderAccess().getEqualsSignKeyword_2());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2346:1: (otherlv_3= '|' )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==49) ) {
                int LA33_1 = input.LA(2);

                if ( (LA33_1==EOF||LA33_1==49) ) {
                    alt33=1;
                }
            }
            switch (alt33) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2346:3: otherlv_3= '|'
                    {
                    otherlv_3=(Token)match(input,49,FOLLOW_49_in_ruleResultTableHeader5054); 

                        	newLeafNode(otherlv_3, grammarAccess.getResultTableHeaderAccess().getVerticalLineKeyword_3());
                        

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
    // $ANTLR end "ruleResultTableHeader"


    // $ANTLR start "entryRuleParameterTableValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2358:1: entryRuleParameterTableValue returns [EObject current=null] : iv_ruleParameterTableValue= ruleParameterTableValue EOF ;
    public final EObject entryRuleParameterTableValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterTableValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2359:2: (iv_ruleParameterTableValue= ruleParameterTableValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2360:2: iv_ruleParameterTableValue= ruleParameterTableValue EOF
            {
             newCompositeNode(grammarAccess.getParameterTableValueRule()); 
            pushFollow(FOLLOW_ruleParameterTableValue_in_entryRuleParameterTableValue5092);
            iv_ruleParameterTableValue=ruleParameterTableValue();

            state._fsp--;

             current =iv_ruleParameterTableValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterTableValue5102); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2367:1: ruleParameterTableValue returns [EObject current=null] : (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) ) (otherlv_2= '|' )? ) ;
    public final EObject ruleParameterTableValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2370:28: ( (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) ) (otherlv_2= '|' )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2371:1: (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) ) (otherlv_2= '|' )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2371:1: (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) ) (otherlv_2= '|' )? )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2371:3: otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) ) (otherlv_2= '|' )?
            {
            otherlv_0=(Token)match(input,49,FOLLOW_49_in_ruleParameterTableValue5139); 

                	newLeafNode(otherlv_0, grammarAccess.getParameterTableValueAccess().getVerticalLineKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2375:1: ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2376:1: (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2376:1: (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2377:3: lv_value_1_0= ruleValueOrEnumValueOrOperationCollection
            {
             
            	        newCompositeNode(grammarAccess.getParameterTableValueAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleParameterTableValue5160);
            lv_value_1_0=ruleValueOrEnumValueOrOperationCollection();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getParameterTableValueRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"ValueOrEnumValueOrOperationCollection");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2393:2: (otherlv_2= '|' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==49) ) {
                int LA34_1 = input.LA(2);

                if ( (LA34_1==EOF||LA34_1==RULE_NEWLINE||LA34_1==49) ) {
                    alt34=1;
                }
            }
            switch (alt34) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2393:4: otherlv_2= '|'
                    {
                    otherlv_2=(Token)match(input,49,FOLLOW_49_in_ruleParameterTableValue5173); 

                        	newLeafNode(otherlv_2, grammarAccess.getParameterTableValueAccess().getVerticalLineKeyword_2());
                        

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
    // $ANTLR end "ruleParameterTableValue"


    // $ANTLR start "entryRuleNamedResult"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2405:1: entryRuleNamedResult returns [EObject current=null] : iv_ruleNamedResult= ruleNamedResult EOF ;
    public final EObject entryRuleNamedResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedResult = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2406:2: (iv_ruleNamedResult= ruleNamedResult EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2407:2: iv_ruleNamedResult= ruleNamedResult EOF
            {
             newCompositeNode(grammarAccess.getNamedResultRule()); 
            pushFollow(FOLLOW_ruleNamedResult_in_entryRuleNamedResult5211);
            iv_ruleNamedResult=ruleNamedResult();

            state._fsp--;

             current =iv_ruleNamedResult; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedResult5221); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2414:1: ruleNamedResult returns [EObject current=null] : ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '=' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) ;
    public final EObject ruleNamedResult() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2417:28: ( ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '=' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2418:1: ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '=' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2418:1: ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '=' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2418:2: ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '=' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2418:2: ( (lv_name_0_0= ruleResultName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2419:1: (lv_name_0_0= ruleResultName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2419:1: (lv_name_0_0= ruleResultName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2420:3: lv_name_0_0= ruleResultName
            {
             
            	        newCompositeNode(grammarAccess.getNamedResultAccess().getNameResultNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleResultName_in_ruleNamedResult5267);
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

             
                    newCompositeNode(grammarAccess.getNamedResultAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleNamedResult5283);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,47,FOLLOW_47_in_ruleNamedResult5294); 

                	newLeafNode(otherlv_2, grammarAccess.getNamedResultAccess().getEqualsSignKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getNamedResultAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleNamedResult5310);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2456:1: ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2457:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2457:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2458:3: lv_value_4_0= ruleValueOrEnumValueOrOperationCollection
            {
             
            	        newCompositeNode(grammarAccess.getNamedResultAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleNamedResult5330);
            lv_value_4_0=ruleValueOrEnumValueOrOperationCollection();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNamedResultRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_4_0, 
                    		"ValueOrEnumValueOrOperationCollection");
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2482:1: entryRuleResultName returns [EObject current=null] : iv_ruleResultName= ruleResultName EOF ;
    public final EObject entryRuleResultName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2483:2: (iv_ruleResultName= ruleResultName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2484:2: iv_ruleResultName= ruleResultName EOF
            {
             newCompositeNode(grammarAccess.getResultNameRule()); 
            pushFollow(FOLLOW_ruleResultName_in_entryRuleResultName5366);
            iv_ruleResultName=ruleResultName();

            state._fsp--;

             current =iv_ruleResultName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultName5376); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2491:1: ruleResultName returns [EObject current=null] : (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) ;
    public final EObject ruleResultName() throws RecognitionException {
        EObject current = null;

        EObject this_FixedResultName_0 = null;

        EObject this_ArbitraryParameterOrResultName_1 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2494:28: ( (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2495:1: (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2495:1: (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_ID) ) {
                alt35=1;
            }
            else if ( (LA35_0==54) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2496:5: this_FixedResultName_0= ruleFixedResultName
                    {
                     
                            newCompositeNode(grammarAccess.getResultNameAccess().getFixedResultNameParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleFixedResultName_in_ruleResultName5423);
                    this_FixedResultName_0=ruleFixedResultName();

                    state._fsp--;

                     
                            current = this_FixedResultName_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2506:5: this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName
                    {
                     
                            newCompositeNode(grammarAccess.getResultNameAccess().getArbitraryParameterOrResultNameParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleArbitraryParameterOrResultName_in_ruleResultName5450);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2522:1: entryRuleFixedResultName returns [EObject current=null] : iv_ruleFixedResultName= ruleFixedResultName EOF ;
    public final EObject entryRuleFixedResultName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedResultName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2523:2: (iv_ruleFixedResultName= ruleFixedResultName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2524:2: iv_ruleFixedResultName= ruleFixedResultName EOF
            {
             newCompositeNode(grammarAccess.getFixedResultNameRule()); 
            pushFollow(FOLLOW_ruleFixedResultName_in_entryRuleFixedResultName5485);
            iv_ruleFixedResultName=ruleFixedResultName();

            state._fsp--;

             current =iv_ruleFixedResultName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFixedResultName5495); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2531:1: ruleFixedResultName returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleFixedResultName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2534:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2535:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2535:1: ( (otherlv_0= RULE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2536:1: (otherlv_0= RULE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2536:1: (otherlv_0= RULE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2537:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFixedResultNameRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFixedResultName5539); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2556:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2557:2: (iv_ruleCall= ruleCall EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2558:2: iv_ruleCall= ruleCall EOF
            {
             newCompositeNode(grammarAccess.getCallRule()); 
            pushFollow(FOLLOW_ruleCall_in_entryRuleCall5574);
            iv_ruleCall=ruleCall();

            state._fsp--;

             current =iv_ruleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCall5584); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2565:1: ruleCall returns [EObject current=null] : (otherlv_0= 'call' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )* ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariable ) ) )? ruleNL ) ;
    public final EObject ruleCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_10=null;
        EObject lv_multiplier_2_0 = null;

        EObject lv_parameters_6_0 = null;

        EObject lv_results_8_0 = null;

        EObject lv_result_12_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2568:28: ( (otherlv_0= 'call' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )* ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariable ) ) )? ruleNL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2569:1: (otherlv_0= 'call' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )* ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariable ) ) )? ruleNL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2569:1: (otherlv_0= 'call' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )* ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariable ) ) )? ruleNL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2569:3: otherlv_0= 'call' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )* ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariable ) ) )? ruleNL
            {
            otherlv_0=(Token)match(input,50,FOLLOW_50_in_ruleCall5621); 

                	newLeafNode(otherlv_0, grammarAccess.getCallAccess().getCallKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleCall5637);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2581:1: ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_INTEGER) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2581:2: ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2581:2: ( (lv_multiplier_2_0= ruleExecutionMultiplier ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2582:1: (lv_multiplier_2_0= ruleExecutionMultiplier )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2582:1: (lv_multiplier_2_0= ruleExecutionMultiplier )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2583:3: lv_multiplier_2_0= ruleExecutionMultiplier
                    {
                     
                    	        newCompositeNode(grammarAccess.getCallAccess().getMultiplierExecutionMultiplierParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExecutionMultiplier_in_ruleCall5658);
                    lv_multiplier_2_0=ruleExecutionMultiplier();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCallRule());
                    	        }
                           		set(
                           			current, 
                           			"multiplier",
                            		lv_multiplier_2_0, 
                            		"ExecutionMultiplier");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_2_1()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleCall5674);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2607:3: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2608:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2608:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2609:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCallRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getCallAccess().getDefinitionCallDefinitionCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleCall5698);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2622:2: ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )*
            loop37:
            do {
                int alt37=2;
                alt37 = dfa37.predict(input);
                switch (alt37) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2623:5: ruleNL ( (lv_parameters_6_0= ruleParameter ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_4_0()); 
            	        
            	    pushFollow(FOLLOW_ruleNL_in_ruleCall5715);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2630:1: ( (lv_parameters_6_0= ruleParameter ) )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2631:1: (lv_parameters_6_0= ruleParameter )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2631:1: (lv_parameters_6_0= ruleParameter )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2632:3: lv_parameters_6_0= ruleParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCallAccess().getParametersParameterParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameter_in_ruleCall5735);
            	    lv_parameters_6_0=ruleParameter();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCallRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"parameters",
            	            		lv_parameters_6_0, 
            	            		"Parameter");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop37;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2648:4: ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )*
            loop38:
            do {
                int alt38=2;
                alt38 = dfa38.predict(input);
                switch (alt38) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2649:5: ruleNL ( (lv_results_8_0= ruleNamedCallResult ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_5_0()); 
            	        
            	    pushFollow(FOLLOW_ruleNL_in_ruleCall5754);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2656:1: ( (lv_results_8_0= ruleNamedCallResult ) )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2657:1: (lv_results_8_0= ruleNamedCallResult )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2657:1: (lv_results_8_0= ruleNamedCallResult )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2658:3: lv_results_8_0= ruleNamedCallResult
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCallAccess().getResultsNamedCallResultParserRuleCall_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleNamedCallResult_in_ruleCall5774);
            	    lv_results_8_0=ruleNamedCallResult();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCallRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"results",
            	            		lv_results_8_0, 
            	            		"NamedCallResult");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2674:4: ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariable ) ) )?
            int alt39=2;
            alt39 = dfa39.predict(input);
            switch (alt39) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2675:5: ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariable ) )
                    {
                     
                            newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_6_0()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleCall5793);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    otherlv_10=(Token)match(input,51,FOLLOW_51_in_ruleCall5804); 

                        	newLeafNode(otherlv_10, grammarAccess.getCallAccess().getHyphenMinusGreaterThanSignKeyword_6_1());
                        
                     
                            newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_6_2()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleCall5820);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2694:1: ( (lv_result_12_0= ruleVariable ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2695:1: (lv_result_12_0= ruleVariable )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2695:1: (lv_result_12_0= ruleVariable )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2696:3: lv_result_12_0= ruleVariable
                    {
                     
                    	        newCompositeNode(grammarAccess.getCallAccess().getResultVariableParserRuleCall_6_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVariable_in_ruleCall5840);
                    lv_result_12_0=ruleVariable();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCallRule());
                    	        }
                           		set(
                           			current, 
                           			"result",
                            		lv_result_12_0, 
                            		"Variable");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

             
                    newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_7()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleCall5858);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                

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


    // $ANTLR start "entryRuleNamedCallResult"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2728:1: entryRuleNamedCallResult returns [EObject current=null] : iv_ruleNamedCallResult= ruleNamedCallResult EOF ;
    public final EObject entryRuleNamedCallResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedCallResult = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2729:2: (iv_ruleNamedCallResult= ruleNamedCallResult EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2730:2: iv_ruleNamedCallResult= ruleNamedCallResult EOF
            {
             newCompositeNode(grammarAccess.getNamedCallResultRule()); 
            pushFollow(FOLLOW_ruleNamedCallResult_in_entryRuleNamedCallResult5893);
            iv_ruleNamedCallResult=ruleNamedCallResult();

            state._fsp--;

             current =iv_ruleNamedCallResult; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedCallResult5903); 

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
    // $ANTLR end "entryRuleNamedCallResult"


    // $ANTLR start "ruleNamedCallResult"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2737:1: ruleNamedCallResult returns [EObject current=null] : ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariable ) ) ) ;
    public final EObject ruleNamedCallResult() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_target_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2740:28: ( ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariable ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2741:1: ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariable ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2741:1: ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariable ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2741:2: ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariable ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2741:2: ( (lv_name_0_0= ruleResultName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2742:1: (lv_name_0_0= ruleResultName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2742:1: (lv_name_0_0= ruleResultName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2743:3: lv_name_0_0= ruleResultName
            {
             
            	        newCompositeNode(grammarAccess.getNamedCallResultAccess().getNameResultNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleResultName_in_ruleNamedCallResult5949);
            lv_name_0_0=ruleResultName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNamedCallResultRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ResultName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getNamedCallResultAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleNamedCallResult5965);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,51,FOLLOW_51_in_ruleNamedCallResult5976); 

                	newLeafNode(otherlv_2, grammarAccess.getNamedCallResultAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getNamedCallResultAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleNamedCallResult5992);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2779:1: ( (lv_target_4_0= ruleVariable ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2780:1: (lv_target_4_0= ruleVariable )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2780:1: (lv_target_4_0= ruleVariable )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2781:3: lv_target_4_0= ruleVariable
            {
             
            	        newCompositeNode(grammarAccess.getNamedCallResultAccess().getTargetVariableParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleVariable_in_ruleNamedCallResult6012);
            lv_target_4_0=ruleVariable();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNamedCallResultRule());
            	        }
                   		set(
                   			current, 
                   			"target",
                    		lv_target_4_0, 
                    		"Variable");
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
    // $ANTLR end "ruleNamedCallResult"


    // $ANTLR start "entryRuleSuite"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2805:1: entryRuleSuite returns [EObject current=null] : iv_ruleSuite= ruleSuite EOF ;
    public final EObject entryRuleSuite() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuite = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2806:2: (iv_ruleSuite= ruleSuite EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2807:2: iv_ruleSuite= ruleSuite EOF
            {
             newCompositeNode(grammarAccess.getSuiteRule()); 
            pushFollow(FOLLOW_ruleSuite_in_entryRuleSuite6048);
            iv_ruleSuite=ruleSuite();

            state._fsp--;

             current =iv_ruleSuite; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuite6058); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2814:1: ruleSuite returns [EObject current=null] : (otherlv_0= 'suite' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ruleNL ( ( (lv_parameters_6_0= ruleSuiteParameter ) ) ruleNL )* (otherlv_8= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )? (otherlv_12= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ )? ) ;
    public final EObject ruleSuite() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_8=null;
        Token otherlv_12=null;
        EObject lv_multiplier_2_0 = null;

        EObject lv_parameters_6_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2817:28: ( (otherlv_0= 'suite' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ruleNL ( ( (lv_parameters_6_0= ruleSuiteParameter ) ) ruleNL )* (otherlv_8= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )? (otherlv_12= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2818:1: (otherlv_0= 'suite' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ruleNL ( ( (lv_parameters_6_0= ruleSuiteParameter ) ) ruleNL )* (otherlv_8= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )? (otherlv_12= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2818:1: (otherlv_0= 'suite' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ruleNL ( ( (lv_parameters_6_0= ruleSuiteParameter ) ) ruleNL )* (otherlv_8= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )? (otherlv_12= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ )? )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2818:3: otherlv_0= 'suite' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ruleNL ( ( (lv_parameters_6_0= ruleSuiteParameter ) ) ruleNL )* (otherlv_8= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )? (otherlv_12= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ )?
            {
            otherlv_0=(Token)match(input,52,FOLLOW_52_in_ruleSuite6095); 

                	newLeafNode(otherlv_0, grammarAccess.getSuiteAccess().getSuiteKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleSuite6111);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2830:1: ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_INTEGER) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2830:2: ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2830:2: ( (lv_multiplier_2_0= ruleExecutionMultiplier ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2831:1: (lv_multiplier_2_0= ruleExecutionMultiplier )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2831:1: (lv_multiplier_2_0= ruleExecutionMultiplier )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2832:3: lv_multiplier_2_0= ruleExecutionMultiplier
                    {
                     
                    	        newCompositeNode(grammarAccess.getSuiteAccess().getMultiplierExecutionMultiplierParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExecutionMultiplier_in_ruleSuite6132);
                    lv_multiplier_2_0=ruleExecutionMultiplier();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSuiteRule());
                    	        }
                           		set(
                           			current, 
                           			"multiplier",
                            		lv_multiplier_2_0, 
                            		"ExecutionMultiplier");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_2_1()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleSuite6148);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2856:3: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2857:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2857:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2858:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSuiteRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSuiteAccess().getDefinitionSuiteDefinitionCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuite6172);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_4()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleSuite6188);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2879:1: ( ( (lv_parameters_6_0= ruleSuiteParameter ) ) ruleNL )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==RULE_ID) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2879:2: ( (lv_parameters_6_0= ruleSuiteParameter ) ) ruleNL
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2879:2: ( (lv_parameters_6_0= ruleSuiteParameter ) )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2880:1: (lv_parameters_6_0= ruleSuiteParameter )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2880:1: (lv_parameters_6_0= ruleSuiteParameter )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2881:3: lv_parameters_6_0= ruleSuiteParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSuiteAccess().getParametersSuiteParameterParserRuleCall_5_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSuiteParameter_in_ruleSuite6209);
            	    lv_parameters_6_0=ruleSuiteParameter();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSuiteRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"parameters",
            	            		lv_parameters_6_0, 
            	            		"SuiteParameter");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	     
            	            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_5_1()); 
            	        
            	    pushFollow(FOLLOW_ruleNL_in_ruleSuite6225);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2905:3: (otherlv_8= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==53) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2905:5: otherlv_8= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL
                    {
                    otherlv_8=(Token)match(input,53,FOLLOW_53_in_ruleSuite6239); 

                        	newLeafNode(otherlv_8, grammarAccess.getSuiteAccess().getOnKeyword_6_0());
                        
                     
                            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_6_1()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleSuite6255);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2917:1: ( ( ruleQualifiedName ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2918:1: ( ruleQualifiedName )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2918:1: ( ruleQualifiedName )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2919:3: ruleQualifiedName
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSuiteRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getSuiteAccess().getForkForkDefinitionCrossReference_6_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuite6277);
                    ruleQualifiedName();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_6_3()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleSuite6293);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2940:3: (otherlv_12= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==45) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2940:5: otherlv_12= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+
                    {
                    otherlv_12=(Token)match(input,45,FOLLOW_45_in_ruleSuite6307); 

                        	newLeafNode(otherlv_12, grammarAccess.getSuiteAccess().getInKeyword_7_0());
                        
                     
                            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_7_1()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleSuite6323);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2952:1: ( ( ( ruleQualifiedName ) ) ruleNL )+
                    int cnt43=0;
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==RULE_ID) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2952:2: ( ( ruleQualifiedName ) ) ruleNL
                    	    {
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2952:2: ( ( ruleQualifiedName ) )
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2953:1: ( ruleQualifiedName )
                    	    {
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2953:1: ( ruleQualifiedName )
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2954:3: ruleQualifiedName
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSuiteRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteAccess().getVariantsVariantDefinitionCrossReference_7_2_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuite6346);
                    	    ruleQualifiedName();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	     
                    	            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_7_2_1()); 
                    	        
                    	    pushFollow(FOLLOW_ruleNL_in_ruleSuite6362);
                    	    ruleNL();

                    	    state._fsp--;

                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt43 >= 1 ) break loop43;
                                EarlyExitException eee =
                                    new EarlyExitException(43, input);
                                throw eee;
                        }
                        cnt43++;
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
    // $ANTLR end "ruleSuite"


    // $ANTLR start "entryRuleSuiteParameter"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2983:1: entryRuleSuiteParameter returns [EObject current=null] : iv_ruleSuiteParameter= ruleSuiteParameter EOF ;
    public final EObject entryRuleSuiteParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteParameter = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2984:2: (iv_ruleSuiteParameter= ruleSuiteParameter EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2985:2: iv_ruleSuiteParameter= ruleSuiteParameter EOF
            {
             newCompositeNode(grammarAccess.getSuiteParameterRule()); 
            pushFollow(FOLLOW_ruleSuiteParameter_in_entryRuleSuiteParameter6401);
            iv_ruleSuiteParameter=ruleSuiteParameter();

            state._fsp--;

             current =iv_ruleSuiteParameter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteParameter6411); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2992:1: ruleSuiteParameter returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValue ) ) ) ;
    public final EObject ruleSuiteParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2995:28: ( ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValue ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2996:1: ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValue ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2996:1: ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValue ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2996:2: ( ( ruleQualifiedName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValue ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2996:2: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2997:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2997:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2998:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSuiteParameterRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSuiteParameterAccess().getNameVariableEntityCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuiteParameter6459);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getSuiteParameterAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleSuiteParameter6475);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,32,FOLLOW_32_in_ruleSuiteParameter6486); 

                	newLeafNode(otherlv_2, grammarAccess.getSuiteParameterAccess().getColonKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getSuiteParameterAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleSuiteParameter6502);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3031:1: ( (lv_value_4_0= ruleValue ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3032:1: (lv_value_4_0= ruleValue )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3032:1: (lv_value_4_0= ruleValue )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3033:3: lv_value_4_0= ruleValue
            {
             
            	        newCompositeNode(grammarAccess.getSuiteParameterAccess().getValueValueParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleValue_in_ruleSuiteParameter6522);
            lv_value_4_0=ruleValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSuiteParameterRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_4_0, 
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3057:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3058:2: (iv_ruleParameter= ruleParameter EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3059:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter6558);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter6568); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3066:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= ruleParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3069:28: ( ( ( (lv_name_0_0= ruleParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3070:1: ( ( (lv_name_0_0= ruleParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3070:1: ( ( (lv_name_0_0= ruleParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3070:2: ( (lv_name_0_0= ruleParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3070:2: ( (lv_name_0_0= ruleParameterName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3071:1: (lv_name_0_0= ruleParameterName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3071:1: (lv_name_0_0= ruleParameterName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3072:3: lv_name_0_0= ruleParameterName
            {
             
            	        newCompositeNode(grammarAccess.getParameterAccess().getNameParameterNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleParameterName_in_ruleParameter6614);
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

             
                    newCompositeNode(grammarAccess.getParameterAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleParameter6630);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,32,FOLLOW_32_in_ruleParameter6641); 

                	newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getColonKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getParameterAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleParameter6657);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3108:1: ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3109:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3109:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3110:3: lv_value_4_0= ruleValueOrEnumValueOrOperationCollection
            {
             
            	        newCompositeNode(grammarAccess.getParameterAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleParameter6677);
            lv_value_4_0=ruleValueOrEnumValueOrOperationCollection();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getParameterRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_4_0, 
                    		"ValueOrEnumValueOrOperationCollection");
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3134:1: entryRuleParameterName returns [EObject current=null] : iv_ruleParameterName= ruleParameterName EOF ;
    public final EObject entryRuleParameterName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3135:2: (iv_ruleParameterName= ruleParameterName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3136:2: iv_ruleParameterName= ruleParameterName EOF
            {
             newCompositeNode(grammarAccess.getParameterNameRule()); 
            pushFollow(FOLLOW_ruleParameterName_in_entryRuleParameterName6713);
            iv_ruleParameterName=ruleParameterName();

            state._fsp--;

             current =iv_ruleParameterName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterName6723); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3143:1: ruleParameterName returns [EObject current=null] : (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) ;
    public final EObject ruleParameterName() throws RecognitionException {
        EObject current = null;

        EObject this_FixedParameterName_0 = null;

        EObject this_ArbitraryParameterOrResultName_1 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3146:28: ( (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3147:1: (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3147:1: (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_ID) ) {
                alt45=1;
            }
            else if ( (LA45_0==54) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3148:5: this_FixedParameterName_0= ruleFixedParameterName
                    {
                     
                            newCompositeNode(grammarAccess.getParameterNameAccess().getFixedParameterNameParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleFixedParameterName_in_ruleParameterName6770);
                    this_FixedParameterName_0=ruleFixedParameterName();

                    state._fsp--;

                     
                            current = this_FixedParameterName_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3158:5: this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName
                    {
                     
                            newCompositeNode(grammarAccess.getParameterNameAccess().getArbitraryParameterOrResultNameParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleArbitraryParameterOrResultName_in_ruleParameterName6797);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3174:1: entryRuleFixedParameterName returns [EObject current=null] : iv_ruleFixedParameterName= ruleFixedParameterName EOF ;
    public final EObject entryRuleFixedParameterName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedParameterName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3175:2: (iv_ruleFixedParameterName= ruleFixedParameterName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3176:2: iv_ruleFixedParameterName= ruleFixedParameterName EOF
            {
             newCompositeNode(grammarAccess.getFixedParameterNameRule()); 
            pushFollow(FOLLOW_ruleFixedParameterName_in_entryRuleFixedParameterName6832);
            iv_ruleFixedParameterName=ruleFixedParameterName();

            state._fsp--;

             current =iv_ruleFixedParameterName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFixedParameterName6842); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3183:1: ruleFixedParameterName returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleFixedParameterName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3186:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3187:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3187:1: ( (otherlv_0= RULE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3188:1: (otherlv_0= RULE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3188:1: (otherlv_0= RULE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3189:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFixedParameterNameRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFixedParameterName6886); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3208:1: entryRuleArbitraryParameterOrResultName returns [EObject current=null] : iv_ruleArbitraryParameterOrResultName= ruleArbitraryParameterOrResultName EOF ;
    public final EObject entryRuleArbitraryParameterOrResultName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArbitraryParameterOrResultName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3209:2: (iv_ruleArbitraryParameterOrResultName= ruleArbitraryParameterOrResultName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3210:2: iv_ruleArbitraryParameterOrResultName= ruleArbitraryParameterOrResultName EOF
            {
             newCompositeNode(grammarAccess.getArbitraryParameterOrResultNameRule()); 
            pushFollow(FOLLOW_ruleArbitraryParameterOrResultName_in_entryRuleArbitraryParameterOrResultName6921);
            iv_ruleArbitraryParameterOrResultName=ruleArbitraryParameterOrResultName();

            state._fsp--;

             current =iv_ruleArbitraryParameterOrResultName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArbitraryParameterOrResultName6931); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3217:1: ruleArbitraryParameterOrResultName returns [EObject current=null] : (otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) ) ) ;
    public final EObject ruleArbitraryParameterOrResultName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_identifier_1_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3220:28: ( (otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3221:1: (otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3221:1: (otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3221:3: otherlv_0= '+' ( (lv_identifier_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,54,FOLLOW_54_in_ruleArbitraryParameterOrResultName6968); 

                	newLeafNode(otherlv_0, grammarAccess.getArbitraryParameterOrResultNameAccess().getPlusSignKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3225:1: ( (lv_identifier_1_0= RULE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3226:1: (lv_identifier_1_0= RULE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3226:1: (lv_identifier_1_0= RULE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3227:3: lv_identifier_1_0= RULE_ID
            {
            lv_identifier_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleArbitraryParameterOrResultName6985); 

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


    // $ANTLR start "entryRuleOperation"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3251:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3252:2: (iv_ruleOperation= ruleOperation EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3253:2: iv_ruleOperation= ruleOperation EOF
            {
             newCompositeNode(grammarAccess.getOperationRule()); 
            pushFollow(FOLLOW_ruleOperation_in_entryRuleOperation7026);
            iv_ruleOperation=ruleOperation();

            state._fsp--;

             current =iv_ruleOperation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperation7036); 

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
    // $ANTLR end "entryRuleOperation"


    // $ANTLR start "ruleOperation"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3260:1: ruleOperation returns [EObject current=null] : (otherlv_0= '(' ruleNL ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL otherlv_9= ')' ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        EObject lv_prefixOperand_2_0 = null;

        EObject lv_postfixOperand_7_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3263:28: ( (otherlv_0= '(' ruleNL ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL otherlv_9= ')' ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3264:1: (otherlv_0= '(' ruleNL ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL otherlv_9= ')' )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3264:1: (otherlv_0= '(' ruleNL ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL otherlv_9= ')' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3264:3: otherlv_0= '(' ruleNL ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL otherlv_9= ')'
            {
            otherlv_0=(Token)match(input,55,FOLLOW_55_in_ruleOperation7073); 

                	newLeafNode(otherlv_0, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getOperationAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleOperation7089);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3276:1: ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )?
            int alt46=2;
            alt46 = dfa46.predict(input);
            switch (alt46) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3276:2: ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3276:2: ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3277:1: (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3277:1: (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3278:3: lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection
                    {
                     
                    	        newCompositeNode(grammarAccess.getOperationAccess().getPrefixOperandValueOrEnumValueOrOperationCollectionParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleOperation7110);
                    lv_prefixOperand_2_0=ruleValueOrEnumValueOrOperationCollection();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOperationRule());
                    	        }
                           		set(
                           			current, 
                           			"prefixOperand",
                            		lv_prefixOperand_2_0, 
                            		"ValueOrEnumValueOrOperationCollection");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getOperationAccess().getNLParserRuleCall_2_1()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleOperation7126);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3302:3: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3303:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3303:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3304:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getOperationRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getOperationAccess().getDefinitionOperationDefinitionCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleOperation7150);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3317:2: ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )?
            int alt47=2;
            alt47 = dfa47.predict(input);
            switch (alt47) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3318:5: ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) )
                    {
                     
                            newCompositeNode(grammarAccess.getOperationAccess().getNLParserRuleCall_4_0()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleOperation7167);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    otherlv_6=(Token)match(input,27,FOLLOW_27_in_ruleOperation7178); 

                        	newLeafNode(otherlv_6, grammarAccess.getOperationAccess().getWithKeyword_4_1());
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3329:1: ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3330:1: (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3330:1: (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3331:3: lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection
                    {
                     
                    	        newCompositeNode(grammarAccess.getOperationAccess().getPostfixOperandValueOrEnumValueOrOperationCollectionParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleOperation7199);
                    lv_postfixOperand_7_0=ruleValueOrEnumValueOrOperationCollection();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getOperationRule());
                    	        }
                           		set(
                           			current, 
                           			"postfixOperand",
                            		lv_postfixOperand_7_0, 
                            		"ValueOrEnumValueOrOperationCollection");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

             
                    newCompositeNode(grammarAccess.getOperationAccess().getNLParserRuleCall_5()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleOperation7217);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_9=(Token)match(input,56,FOLLOW_56_in_ruleOperation7228); 

                	newLeafNode(otherlv_9, grammarAccess.getOperationAccess().getRightParenthesisKeyword_6());
                

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
    // $ANTLR end "ruleOperation"


    // $ANTLR start "entryRuleValueOrEnumValueOrOperationCollection"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3367:1: entryRuleValueOrEnumValueOrOperationCollection returns [EObject current=null] : iv_ruleValueOrEnumValueOrOperationCollection= ruleValueOrEnumValueOrOperationCollection EOF ;
    public final EObject entryRuleValueOrEnumValueOrOperationCollection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueOrEnumValueOrOperationCollection = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3368:2: (iv_ruleValueOrEnumValueOrOperationCollection= ruleValueOrEnumValueOrOperationCollection EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3369:2: iv_ruleValueOrEnumValueOrOperationCollection= ruleValueOrEnumValueOrOperationCollection EOF
            {
             newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationCollectionRule()); 
            pushFollow(FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_entryRuleValueOrEnumValueOrOperationCollection7264);
            iv_ruleValueOrEnumValueOrOperationCollection=ruleValueOrEnumValueOrOperationCollection();

            state._fsp--;

             current =iv_ruleValueOrEnumValueOrOperationCollection; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueOrEnumValueOrOperationCollection7274); 

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
    // $ANTLR end "entryRuleValueOrEnumValueOrOperationCollection"


    // $ANTLR start "ruleValueOrEnumValueOrOperationCollection"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3376:1: ruleValueOrEnumValueOrOperationCollection returns [EObject current=null] : ( ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) ) ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )* ) ;
    public final EObject ruleValueOrEnumValueOrOperationCollection() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_value_0_0 = null;

        EObject lv_moreValues_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3379:28: ( ( ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) ) ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )* ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3380:1: ( ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) ) ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )* )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3380:1: ( ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) ) ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )* )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3380:2: ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) ) ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )*
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3380:2: ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3381:1: (lv_value_0_0= ruleValueOrEnumValueOrOperation )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3381:1: (lv_value_0_0= ruleValueOrEnumValueOrOperation )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3382:3: lv_value_0_0= ruleValueOrEnumValueOrOperation
            {
             
            	        newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getValueValueOrEnumValueOrOperationParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleValueOrEnumValueOrOperation_in_ruleValueOrEnumValueOrOperationCollection7320);
            lv_value_0_0=ruleValueOrEnumValueOrOperation();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getValueOrEnumValueOrOperationCollectionRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"ValueOrEnumValueOrOperation");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3398:2: ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )*
            loop48:
            do {
                int alt48=2;
                alt48 = dfa48.predict(input);
                switch (alt48) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3399:5: ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getNLParserRuleCall_1_0()); 
            	        
            	    pushFollow(FOLLOW_ruleNL_in_ruleValueOrEnumValueOrOperationCollection7337);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    otherlv_2=(Token)match(input,57,FOLLOW_57_in_ruleValueOrEnumValueOrOperationCollection7348); 

            	        	newLeafNode(otherlv_2, grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getCommaKeyword_1_1());
            	        
            	     
            	            newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getNLParserRuleCall_1_2()); 
            	        
            	    pushFollow(FOLLOW_ruleNL_in_ruleValueOrEnumValueOrOperationCollection7364);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3418:1: ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3419:1: (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3419:1: (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3420:3: lv_moreValues_4_0= ruleValueOrEnumValueOrOperation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getMoreValuesValueOrEnumValueOrOperationParserRuleCall_1_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueOrEnumValueOrOperation_in_ruleValueOrEnumValueOrOperationCollection7384);
            	    lv_moreValues_4_0=ruleValueOrEnumValueOrOperation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getValueOrEnumValueOrOperationCollectionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"moreValues",
            	            		lv_moreValues_4_0, 
            	            		"ValueOrEnumValueOrOperation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop48;
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
    // $ANTLR end "ruleValueOrEnumValueOrOperationCollection"


    // $ANTLR start "entryRuleValueOrEnumValueOrOperation"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3444:1: entryRuleValueOrEnumValueOrOperation returns [EObject current=null] : iv_ruleValueOrEnumValueOrOperation= ruleValueOrEnumValueOrOperation EOF ;
    public final EObject entryRuleValueOrEnumValueOrOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueOrEnumValueOrOperation = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3445:2: (iv_ruleValueOrEnumValueOrOperation= ruleValueOrEnumValueOrOperation EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3446:2: iv_ruleValueOrEnumValueOrOperation= ruleValueOrEnumValueOrOperation EOF
            {
             newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationRule()); 
            pushFollow(FOLLOW_ruleValueOrEnumValueOrOperation_in_entryRuleValueOrEnumValueOrOperation7422);
            iv_ruleValueOrEnumValueOrOperation=ruleValueOrEnumValueOrOperation();

            state._fsp--;

             current =iv_ruleValueOrEnumValueOrOperation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueOrEnumValueOrOperation7432); 

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
    // $ANTLR end "entryRuleValueOrEnumValueOrOperation"


    // $ANTLR start "ruleValueOrEnumValueOrOperation"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3453:1: ruleValueOrEnumValueOrOperation returns [EObject current=null] : (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue | this_Operation_2= ruleOperation ) ;
    public final EObject ruleValueOrEnumValueOrOperation() throws RecognitionException {
        EObject current = null;

        EObject this_Value_0 = null;

        EObject this_EnumValue_1 = null;

        EObject this_Operation_2 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3456:28: ( (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue | this_Operation_2= ruleOperation ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3457:1: (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue | this_Operation_2= ruleOperation )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3457:1: (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue | this_Operation_2= ruleOperation )
            int alt49=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_ID:
            case RULE_INTEGER:
            case RULE_DECIMAL:
            case RULE_BOOLEAN_TRUE:
            case RULE_BOOLEAN_FALSE:
            case RULE_ISODATE:
            case RULE_EURODATE:
            case RULE_USDATE:
            case RULE_ISOTIME:
            case RULE_TWENTYFOURHRSTIME:
            case RULE_TWELVEHRSTIME:
            case 58:
            case 59:
                {
                alt49=1;
                }
                break;
            case RULE_UPPERCASE_ID:
                {
                alt49=2;
                }
                break;
            case 55:
                {
                alt49=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3458:5: this_Value_0= ruleValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationAccess().getValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleValue_in_ruleValueOrEnumValueOrOperation7479);
                    this_Value_0=ruleValue();

                    state._fsp--;

                     
                            current = this_Value_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3468:5: this_EnumValue_1= ruleEnumValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationAccess().getEnumValueParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEnumValue_in_ruleValueOrEnumValueOrOperation7506);
                    this_EnumValue_1=ruleEnumValue();

                    state._fsp--;

                     
                            current = this_EnumValue_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3478:5: this_Operation_2= ruleOperation
                    {
                     
                            newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationAccess().getOperationParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleOperation_in_ruleValueOrEnumValueOrOperation7533);
                    this_Operation_2=ruleOperation();

                    state._fsp--;

                     
                            current = this_Operation_2; 
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
    // $ANTLR end "ruleValueOrEnumValueOrOperation"


    // $ANTLR start "entryRuleValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3494:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3495:2: (iv_ruleValue= ruleValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3496:2: iv_ruleValue= ruleValue EOF
            {
             newCompositeNode(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue7568);
            iv_ruleValue=ruleValue();

            state._fsp--;

             current =iv_ruleValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue7578); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3503:1: ruleValue returns [EObject current=null] : (this_StaticValue_0= ruleStaticValue | this_Variable_1= ruleVariable | this_NestedObject_2= ruleNestedObject ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        EObject this_StaticValue_0 = null;

        EObject this_Variable_1 = null;

        EObject this_NestedObject_2 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3506:28: ( (this_StaticValue_0= ruleStaticValue | this_Variable_1= ruleVariable | this_NestedObject_2= ruleNestedObject ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3507:1: (this_StaticValue_0= ruleStaticValue | this_Variable_1= ruleVariable | this_NestedObject_2= ruleNestedObject )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3507:1: (this_StaticValue_0= ruleStaticValue | this_Variable_1= ruleVariable | this_NestedObject_2= ruleNestedObject )
            int alt50=3;
            switch ( input.LA(1) ) {
            case RULE_STRING:
            case RULE_INTEGER:
            case RULE_DECIMAL:
            case RULE_BOOLEAN_TRUE:
            case RULE_BOOLEAN_FALSE:
            case RULE_ISODATE:
            case RULE_EURODATE:
            case RULE_USDATE:
            case RULE_ISOTIME:
            case RULE_TWENTYFOURHRSTIME:
            case RULE_TWELVEHRSTIME:
            case 58:
                {
                alt50=1;
                }
                break;
            case RULE_ID:
                {
                alt50=2;
                }
                break;
            case 59:
                {
                alt50=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3508:5: this_StaticValue_0= ruleStaticValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getStaticValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleStaticValue_in_ruleValue7625);
                    this_StaticValue_0=ruleStaticValue();

                    state._fsp--;

                     
                            current = this_StaticValue_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3518:5: this_Variable_1= ruleVariable
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getVariableParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleVariable_in_ruleValue7652);
                    this_Variable_1=ruleVariable();

                    state._fsp--;

                     
                            current = this_Variable_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3528:5: this_NestedObject_2= ruleNestedObject
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getNestedObjectParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleNestedObject_in_ruleValue7679);
                    this_NestedObject_2=ruleNestedObject();

                    state._fsp--;

                     
                            current = this_NestedObject_2; 
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


    // $ANTLR start "entryRuleStaticValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3544:1: entryRuleStaticValue returns [EObject current=null] : iv_ruleStaticValue= ruleStaticValue EOF ;
    public final EObject entryRuleStaticValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStaticValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3545:2: (iv_ruleStaticValue= ruleStaticValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3546:2: iv_ruleStaticValue= ruleStaticValue EOF
            {
             newCompositeNode(grammarAccess.getStaticValueRule()); 
            pushFollow(FOLLOW_ruleStaticValue_in_entryRuleStaticValue7714);
            iv_ruleStaticValue=ruleStaticValue();

            state._fsp--;

             current =iv_ruleStaticValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStaticValue7724); 

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
    // $ANTLR end "entryRuleStaticValue"


    // $ANTLR start "ruleStaticValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3553:1: ruleStaticValue returns [EObject current=null] : (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_BooleanValue_3= ruleBooleanValue | this_DateValue_4= ruleDateValue | this_TimeValue_5= ruleTimeValue | this_DateAndTimeValue_6= ruleDateAndTimeValue | this_NullValue_7= ruleNullValue ) ;
    public final EObject ruleStaticValue() throws RecognitionException {
        EObject current = null;

        EObject this_StringValue_0 = null;

        EObject this_IntegerValue_1 = null;

        EObject this_DecimalValue_2 = null;

        EObject this_BooleanValue_3 = null;

        EObject this_DateValue_4 = null;

        EObject this_TimeValue_5 = null;

        EObject this_DateAndTimeValue_6 = null;

        EObject this_NullValue_7 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3556:28: ( (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_BooleanValue_3= ruleBooleanValue | this_DateValue_4= ruleDateValue | this_TimeValue_5= ruleTimeValue | this_DateAndTimeValue_6= ruleDateAndTimeValue | this_NullValue_7= ruleNullValue ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3557:1: (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_BooleanValue_3= ruleBooleanValue | this_DateValue_4= ruleDateValue | this_TimeValue_5= ruleTimeValue | this_DateAndTimeValue_6= ruleDateAndTimeValue | this_NullValue_7= ruleNullValue )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3557:1: (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_BooleanValue_3= ruleBooleanValue | this_DateValue_4= ruleDateValue | this_TimeValue_5= ruleTimeValue | this_DateAndTimeValue_6= ruleDateAndTimeValue | this_NullValue_7= ruleNullValue )
            int alt51=8;
            alt51 = dfa51.predict(input);
            switch (alt51) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3558:5: this_StringValue_0= ruleStringValue
                    {
                     
                            newCompositeNode(grammarAccess.getStaticValueAccess().getStringValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleStringValue_in_ruleStaticValue7771);
                    this_StringValue_0=ruleStringValue();

                    state._fsp--;

                     
                            current = this_StringValue_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3568:5: this_IntegerValue_1= ruleIntegerValue
                    {
                     
                            newCompositeNode(grammarAccess.getStaticValueAccess().getIntegerValueParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleIntegerValue_in_ruleStaticValue7798);
                    this_IntegerValue_1=ruleIntegerValue();

                    state._fsp--;

                     
                            current = this_IntegerValue_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3578:5: this_DecimalValue_2= ruleDecimalValue
                    {
                     
                            newCompositeNode(grammarAccess.getStaticValueAccess().getDecimalValueParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleDecimalValue_in_ruleStaticValue7825);
                    this_DecimalValue_2=ruleDecimalValue();

                    state._fsp--;

                     
                            current = this_DecimalValue_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3588:5: this_BooleanValue_3= ruleBooleanValue
                    {
                     
                            newCompositeNode(grammarAccess.getStaticValueAccess().getBooleanValueParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleBooleanValue_in_ruleStaticValue7852);
                    this_BooleanValue_3=ruleBooleanValue();

                    state._fsp--;

                     
                            current = this_BooleanValue_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3598:5: this_DateValue_4= ruleDateValue
                    {
                     
                            newCompositeNode(grammarAccess.getStaticValueAccess().getDateValueParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleDateValue_in_ruleStaticValue7879);
                    this_DateValue_4=ruleDateValue();

                    state._fsp--;

                     
                            current = this_DateValue_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3608:5: this_TimeValue_5= ruleTimeValue
                    {
                     
                            newCompositeNode(grammarAccess.getStaticValueAccess().getTimeValueParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleTimeValue_in_ruleStaticValue7906);
                    this_TimeValue_5=ruleTimeValue();

                    state._fsp--;

                     
                            current = this_TimeValue_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3618:5: this_DateAndTimeValue_6= ruleDateAndTimeValue
                    {
                     
                            newCompositeNode(grammarAccess.getStaticValueAccess().getDateAndTimeValueParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleDateAndTimeValue_in_ruleStaticValue7933);
                    this_DateAndTimeValue_6=ruleDateAndTimeValue();

                    state._fsp--;

                     
                            current = this_DateAndTimeValue_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3628:5: this_NullValue_7= ruleNullValue
                    {
                     
                            newCompositeNode(grammarAccess.getStaticValueAccess().getNullValueParserRuleCall_7()); 
                        
                    pushFollow(FOLLOW_ruleNullValue_in_ruleStaticValue7960);
                    this_NullValue_7=ruleNullValue();

                    state._fsp--;

                     
                            current = this_NullValue_7; 
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
    // $ANTLR end "ruleStaticValue"


    // $ANTLR start "entryRuleIntegerValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3644:1: entryRuleIntegerValue returns [EObject current=null] : iv_ruleIntegerValue= ruleIntegerValue EOF ;
    public final EObject entryRuleIntegerValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3645:2: (iv_ruleIntegerValue= ruleIntegerValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3646:2: iv_ruleIntegerValue= ruleIntegerValue EOF
            {
             newCompositeNode(grammarAccess.getIntegerValueRule()); 
            pushFollow(FOLLOW_ruleIntegerValue_in_entryRuleIntegerValue7995);
            iv_ruleIntegerValue=ruleIntegerValue();

            state._fsp--;

             current =iv_ruleIntegerValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerValue8005); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3653:1: ruleIntegerValue returns [EObject current=null] : ( (lv_integerValue_0_0= RULE_INTEGER ) ) ;
    public final EObject ruleIntegerValue() throws RecognitionException {
        EObject current = null;

        Token lv_integerValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3656:28: ( ( (lv_integerValue_0_0= RULE_INTEGER ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3657:1: ( (lv_integerValue_0_0= RULE_INTEGER ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3657:1: ( (lv_integerValue_0_0= RULE_INTEGER ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3658:1: (lv_integerValue_0_0= RULE_INTEGER )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3658:1: (lv_integerValue_0_0= RULE_INTEGER )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3659:3: lv_integerValue_0_0= RULE_INTEGER
            {
            lv_integerValue_0_0=(Token)match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleIntegerValue8046); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3683:1: entryRuleDecimalValue returns [EObject current=null] : iv_ruleDecimalValue= ruleDecimalValue EOF ;
    public final EObject entryRuleDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecimalValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3684:2: (iv_ruleDecimalValue= ruleDecimalValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3685:2: iv_ruleDecimalValue= ruleDecimalValue EOF
            {
             newCompositeNode(grammarAccess.getDecimalValueRule()); 
            pushFollow(FOLLOW_ruleDecimalValue_in_entryRuleDecimalValue8086);
            iv_ruleDecimalValue=ruleDecimalValue();

            state._fsp--;

             current =iv_ruleDecimalValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalValue8096); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3692:1: ruleDecimalValue returns [EObject current=null] : ( (lv_decimalValue_0_0= RULE_DECIMAL ) ) ;
    public final EObject ruleDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_decimalValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3695:28: ( ( (lv_decimalValue_0_0= RULE_DECIMAL ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3696:1: ( (lv_decimalValue_0_0= RULE_DECIMAL ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3696:1: ( (lv_decimalValue_0_0= RULE_DECIMAL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3697:1: (lv_decimalValue_0_0= RULE_DECIMAL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3697:1: (lv_decimalValue_0_0= RULE_DECIMAL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3698:3: lv_decimalValue_0_0= RULE_DECIMAL
            {
            lv_decimalValue_0_0=(Token)match(input,RULE_DECIMAL,FOLLOW_RULE_DECIMAL_in_ruleDecimalValue8137); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3722:1: entryRuleStringValue returns [EObject current=null] : iv_ruleStringValue= ruleStringValue EOF ;
    public final EObject entryRuleStringValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3723:2: (iv_ruleStringValue= ruleStringValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3724:2: iv_ruleStringValue= ruleStringValue EOF
            {
             newCompositeNode(grammarAccess.getStringValueRule()); 
            pushFollow(FOLLOW_ruleStringValue_in_entryRuleStringValue8177);
            iv_ruleStringValue=ruleStringValue();

            state._fsp--;

             current =iv_ruleStringValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringValue8187); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3731:1: ruleStringValue returns [EObject current=null] : ( (lv_stringValue_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringValue() throws RecognitionException {
        EObject current = null;

        Token lv_stringValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3734:28: ( ( (lv_stringValue_0_0= RULE_STRING ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3735:1: ( (lv_stringValue_0_0= RULE_STRING ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3735:1: ( (lv_stringValue_0_0= RULE_STRING ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3736:1: (lv_stringValue_0_0= RULE_STRING )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3736:1: (lv_stringValue_0_0= RULE_STRING )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3737:3: lv_stringValue_0_0= RULE_STRING
            {
            lv_stringValue_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringValue8228); 

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


    // $ANTLR start "entryRuleBooleanValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3761:1: entryRuleBooleanValue returns [EObject current=null] : iv_ruleBooleanValue= ruleBooleanValue EOF ;
    public final EObject entryRuleBooleanValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3762:2: (iv_ruleBooleanValue= ruleBooleanValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3763:2: iv_ruleBooleanValue= ruleBooleanValue EOF
            {
             newCompositeNode(grammarAccess.getBooleanValueRule()); 
            pushFollow(FOLLOW_ruleBooleanValue_in_entryRuleBooleanValue8268);
            iv_ruleBooleanValue=ruleBooleanValue();

            state._fsp--;

             current =iv_ruleBooleanValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanValue8278); 

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
    // $ANTLR end "entryRuleBooleanValue"


    // $ANTLR start "ruleBooleanValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3770:1: ruleBooleanValue returns [EObject current=null] : ( ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) ) ) ;
    public final EObject ruleBooleanValue() throws RecognitionException {
        EObject current = null;

        Token lv_booleanValue_0_1=null;
        Token lv_booleanValue_0_2=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3773:28: ( ( ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3774:1: ( ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3774:1: ( ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3775:1: ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3775:1: ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3776:1: (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3776:1: (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==RULE_BOOLEAN_TRUE) ) {
                alt52=1;
            }
            else if ( (LA52_0==RULE_BOOLEAN_FALSE) ) {
                alt52=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3777:3: lv_booleanValue_0_1= RULE_BOOLEAN_TRUE
                    {
                    lv_booleanValue_0_1=(Token)match(input,RULE_BOOLEAN_TRUE,FOLLOW_RULE_BOOLEAN_TRUE_in_ruleBooleanValue8321); 

                    			newLeafNode(lv_booleanValue_0_1, grammarAccess.getBooleanValueAccess().getBooleanValueBOOLEAN_TRUETerminalRuleCall_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBooleanValueRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"booleanValue",
                            		lv_booleanValue_0_1, 
                            		"BOOLEAN_TRUE");
                    	    

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3792:8: lv_booleanValue_0_2= RULE_BOOLEAN_FALSE
                    {
                    lv_booleanValue_0_2=(Token)match(input,RULE_BOOLEAN_FALSE,FOLLOW_RULE_BOOLEAN_FALSE_in_ruleBooleanValue8341); 

                    			newLeafNode(lv_booleanValue_0_2, grammarAccess.getBooleanValueAccess().getBooleanValueBOOLEAN_FALSETerminalRuleCall_0_1()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBooleanValueRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"booleanValue",
                            		lv_booleanValue_0_2, 
                            		"BOOLEAN_FALSE");
                    	    

                    }
                    break;

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
    // $ANTLR end "ruleBooleanValue"


    // $ANTLR start "entryRuleDateValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3818:1: entryRuleDateValue returns [EObject current=null] : iv_ruleDateValue= ruleDateValue EOF ;
    public final EObject entryRuleDateValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3819:2: (iv_ruleDateValue= ruleDateValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3820:2: iv_ruleDateValue= ruleDateValue EOF
            {
             newCompositeNode(grammarAccess.getDateValueRule()); 
            pushFollow(FOLLOW_ruleDateValue_in_entryRuleDateValue8384);
            iv_ruleDateValue=ruleDateValue();

            state._fsp--;

             current =iv_ruleDateValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDateValue8394); 

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
    // $ANTLR end "entryRuleDateValue"


    // $ANTLR start "ruleDateValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3827:1: ruleDateValue returns [EObject current=null] : (this_IsoDateValue_0= ruleIsoDateValue | this_EuropeanDateValue_1= ruleEuropeanDateValue | this_USDateValue_2= ruleUSDateValue ) ;
    public final EObject ruleDateValue() throws RecognitionException {
        EObject current = null;

        EObject this_IsoDateValue_0 = null;

        EObject this_EuropeanDateValue_1 = null;

        EObject this_USDateValue_2 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3830:28: ( (this_IsoDateValue_0= ruleIsoDateValue | this_EuropeanDateValue_1= ruleEuropeanDateValue | this_USDateValue_2= ruleUSDateValue ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3831:1: (this_IsoDateValue_0= ruleIsoDateValue | this_EuropeanDateValue_1= ruleEuropeanDateValue | this_USDateValue_2= ruleUSDateValue )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3831:1: (this_IsoDateValue_0= ruleIsoDateValue | this_EuropeanDateValue_1= ruleEuropeanDateValue | this_USDateValue_2= ruleUSDateValue )
            int alt53=3;
            switch ( input.LA(1) ) {
            case RULE_ISODATE:
                {
                alt53=1;
                }
                break;
            case RULE_EURODATE:
                {
                alt53=2;
                }
                break;
            case RULE_USDATE:
                {
                alt53=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3832:5: this_IsoDateValue_0= ruleIsoDateValue
                    {
                     
                            newCompositeNode(grammarAccess.getDateValueAccess().getIsoDateValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleIsoDateValue_in_ruleDateValue8441);
                    this_IsoDateValue_0=ruleIsoDateValue();

                    state._fsp--;

                     
                            current = this_IsoDateValue_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3842:5: this_EuropeanDateValue_1= ruleEuropeanDateValue
                    {
                     
                            newCompositeNode(grammarAccess.getDateValueAccess().getEuropeanDateValueParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEuropeanDateValue_in_ruleDateValue8468);
                    this_EuropeanDateValue_1=ruleEuropeanDateValue();

                    state._fsp--;

                     
                            current = this_EuropeanDateValue_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3852:5: this_USDateValue_2= ruleUSDateValue
                    {
                     
                            newCompositeNode(grammarAccess.getDateValueAccess().getUSDateValueParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleUSDateValue_in_ruleDateValue8495);
                    this_USDateValue_2=ruleUSDateValue();

                    state._fsp--;

                     
                            current = this_USDateValue_2; 
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
    // $ANTLR end "ruleDateValue"


    // $ANTLR start "entryRuleIsoDateValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3868:1: entryRuleIsoDateValue returns [EObject current=null] : iv_ruleIsoDateValue= ruleIsoDateValue EOF ;
    public final EObject entryRuleIsoDateValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsoDateValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3869:2: (iv_ruleIsoDateValue= ruleIsoDateValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3870:2: iv_ruleIsoDateValue= ruleIsoDateValue EOF
            {
             newCompositeNode(grammarAccess.getIsoDateValueRule()); 
            pushFollow(FOLLOW_ruleIsoDateValue_in_entryRuleIsoDateValue8530);
            iv_ruleIsoDateValue=ruleIsoDateValue();

            state._fsp--;

             current =iv_ruleIsoDateValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIsoDateValue8540); 

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
    // $ANTLR end "entryRuleIsoDateValue"


    // $ANTLR start "ruleIsoDateValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3877:1: ruleIsoDateValue returns [EObject current=null] : ( (lv_dateValue_0_0= RULE_ISODATE ) ) ;
    public final EObject ruleIsoDateValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3880:28: ( ( (lv_dateValue_0_0= RULE_ISODATE ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3881:1: ( (lv_dateValue_0_0= RULE_ISODATE ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3881:1: ( (lv_dateValue_0_0= RULE_ISODATE ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3882:1: (lv_dateValue_0_0= RULE_ISODATE )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3882:1: (lv_dateValue_0_0= RULE_ISODATE )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3883:3: lv_dateValue_0_0= RULE_ISODATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_ISODATE,FOLLOW_RULE_ISODATE_in_ruleIsoDateValue8581); 

            			newLeafNode(lv_dateValue_0_0, grammarAccess.getIsoDateValueAccess().getDateValueISODATETerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIsoDateValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"dateValue",
                    		lv_dateValue_0_0, 
                    		"ISODATE");
            	    

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
    // $ANTLR end "ruleIsoDateValue"


    // $ANTLR start "entryRuleEuropeanDateValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3907:1: entryRuleEuropeanDateValue returns [EObject current=null] : iv_ruleEuropeanDateValue= ruleEuropeanDateValue EOF ;
    public final EObject entryRuleEuropeanDateValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEuropeanDateValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3908:2: (iv_ruleEuropeanDateValue= ruleEuropeanDateValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3909:2: iv_ruleEuropeanDateValue= ruleEuropeanDateValue EOF
            {
             newCompositeNode(grammarAccess.getEuropeanDateValueRule()); 
            pushFollow(FOLLOW_ruleEuropeanDateValue_in_entryRuleEuropeanDateValue8621);
            iv_ruleEuropeanDateValue=ruleEuropeanDateValue();

            state._fsp--;

             current =iv_ruleEuropeanDateValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEuropeanDateValue8631); 

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
    // $ANTLR end "entryRuleEuropeanDateValue"


    // $ANTLR start "ruleEuropeanDateValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3916:1: ruleEuropeanDateValue returns [EObject current=null] : ( (lv_dateValue_0_0= RULE_EURODATE ) ) ;
    public final EObject ruleEuropeanDateValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3919:28: ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3920:1: ( (lv_dateValue_0_0= RULE_EURODATE ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3920:1: ( (lv_dateValue_0_0= RULE_EURODATE ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3921:1: (lv_dateValue_0_0= RULE_EURODATE )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3921:1: (lv_dateValue_0_0= RULE_EURODATE )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3922:3: lv_dateValue_0_0= RULE_EURODATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_EURODATE,FOLLOW_RULE_EURODATE_in_ruleEuropeanDateValue8672); 

            			newLeafNode(lv_dateValue_0_0, grammarAccess.getEuropeanDateValueAccess().getDateValueEURODATETerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEuropeanDateValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"dateValue",
                    		lv_dateValue_0_0, 
                    		"EURODATE");
            	    

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
    // $ANTLR end "ruleEuropeanDateValue"


    // $ANTLR start "entryRuleUSDateValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3946:1: entryRuleUSDateValue returns [EObject current=null] : iv_ruleUSDateValue= ruleUSDateValue EOF ;
    public final EObject entryRuleUSDateValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUSDateValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3947:2: (iv_ruleUSDateValue= ruleUSDateValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3948:2: iv_ruleUSDateValue= ruleUSDateValue EOF
            {
             newCompositeNode(grammarAccess.getUSDateValueRule()); 
            pushFollow(FOLLOW_ruleUSDateValue_in_entryRuleUSDateValue8712);
            iv_ruleUSDateValue=ruleUSDateValue();

            state._fsp--;

             current =iv_ruleUSDateValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUSDateValue8722); 

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
    // $ANTLR end "entryRuleUSDateValue"


    // $ANTLR start "ruleUSDateValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3955:1: ruleUSDateValue returns [EObject current=null] : ( (lv_dateValue_0_0= RULE_USDATE ) ) ;
    public final EObject ruleUSDateValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3958:28: ( ( (lv_dateValue_0_0= RULE_USDATE ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3959:1: ( (lv_dateValue_0_0= RULE_USDATE ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3959:1: ( (lv_dateValue_0_0= RULE_USDATE ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3960:1: (lv_dateValue_0_0= RULE_USDATE )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3960:1: (lv_dateValue_0_0= RULE_USDATE )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3961:3: lv_dateValue_0_0= RULE_USDATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_USDATE,FOLLOW_RULE_USDATE_in_ruleUSDateValue8763); 

            			newLeafNode(lv_dateValue_0_0, grammarAccess.getUSDateValueAccess().getDateValueUSDATETerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUSDateValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"dateValue",
                    		lv_dateValue_0_0, 
                    		"USDATE");
            	    

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
    // $ANTLR end "ruleUSDateValue"


    // $ANTLR start "entryRuleTimeValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3985:1: entryRuleTimeValue returns [EObject current=null] : iv_ruleTimeValue= ruleTimeValue EOF ;
    public final EObject entryRuleTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3986:2: (iv_ruleTimeValue= ruleTimeValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3987:2: iv_ruleTimeValue= ruleTimeValue EOF
            {
             newCompositeNode(grammarAccess.getTimeValueRule()); 
            pushFollow(FOLLOW_ruleTimeValue_in_entryRuleTimeValue8803);
            iv_ruleTimeValue=ruleTimeValue();

            state._fsp--;

             current =iv_ruleTimeValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimeValue8813); 

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
    // $ANTLR end "entryRuleTimeValue"


    // $ANTLR start "ruleTimeValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3994:1: ruleTimeValue returns [EObject current=null] : (this_IsoTimeValue_0= ruleIsoTimeValue | this_Simple24HrsTimeValue_1= ruleSimple24HrsTimeValue | this_Simple12HrsTimeValue_2= ruleSimple12HrsTimeValue ) ;
    public final EObject ruleTimeValue() throws RecognitionException {
        EObject current = null;

        EObject this_IsoTimeValue_0 = null;

        EObject this_Simple24HrsTimeValue_1 = null;

        EObject this_Simple12HrsTimeValue_2 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3997:28: ( (this_IsoTimeValue_0= ruleIsoTimeValue | this_Simple24HrsTimeValue_1= ruleSimple24HrsTimeValue | this_Simple12HrsTimeValue_2= ruleSimple12HrsTimeValue ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3998:1: (this_IsoTimeValue_0= ruleIsoTimeValue | this_Simple24HrsTimeValue_1= ruleSimple24HrsTimeValue | this_Simple12HrsTimeValue_2= ruleSimple12HrsTimeValue )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3998:1: (this_IsoTimeValue_0= ruleIsoTimeValue | this_Simple24HrsTimeValue_1= ruleSimple24HrsTimeValue | this_Simple12HrsTimeValue_2= ruleSimple12HrsTimeValue )
            int alt54=3;
            switch ( input.LA(1) ) {
            case RULE_ISOTIME:
                {
                alt54=1;
                }
                break;
            case RULE_TWENTYFOURHRSTIME:
                {
                alt54=2;
                }
                break;
            case RULE_TWELVEHRSTIME:
                {
                alt54=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3999:5: this_IsoTimeValue_0= ruleIsoTimeValue
                    {
                     
                            newCompositeNode(grammarAccess.getTimeValueAccess().getIsoTimeValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleIsoTimeValue_in_ruleTimeValue8860);
                    this_IsoTimeValue_0=ruleIsoTimeValue();

                    state._fsp--;

                     
                            current = this_IsoTimeValue_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4009:5: this_Simple24HrsTimeValue_1= ruleSimple24HrsTimeValue
                    {
                     
                            newCompositeNode(grammarAccess.getTimeValueAccess().getSimple24HrsTimeValueParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleSimple24HrsTimeValue_in_ruleTimeValue8887);
                    this_Simple24HrsTimeValue_1=ruleSimple24HrsTimeValue();

                    state._fsp--;

                     
                            current = this_Simple24HrsTimeValue_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4019:5: this_Simple12HrsTimeValue_2= ruleSimple12HrsTimeValue
                    {
                     
                            newCompositeNode(grammarAccess.getTimeValueAccess().getSimple12HrsTimeValueParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleSimple12HrsTimeValue_in_ruleTimeValue8914);
                    this_Simple12HrsTimeValue_2=ruleSimple12HrsTimeValue();

                    state._fsp--;

                     
                            current = this_Simple12HrsTimeValue_2; 
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
    // $ANTLR end "ruleTimeValue"


    // $ANTLR start "entryRuleIsoTimeValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4035:1: entryRuleIsoTimeValue returns [EObject current=null] : iv_ruleIsoTimeValue= ruleIsoTimeValue EOF ;
    public final EObject entryRuleIsoTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsoTimeValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4036:2: (iv_ruleIsoTimeValue= ruleIsoTimeValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4037:2: iv_ruleIsoTimeValue= ruleIsoTimeValue EOF
            {
             newCompositeNode(grammarAccess.getIsoTimeValueRule()); 
            pushFollow(FOLLOW_ruleIsoTimeValue_in_entryRuleIsoTimeValue8949);
            iv_ruleIsoTimeValue=ruleIsoTimeValue();

            state._fsp--;

             current =iv_ruleIsoTimeValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIsoTimeValue8959); 

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
    // $ANTLR end "entryRuleIsoTimeValue"


    // $ANTLR start "ruleIsoTimeValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4044:1: ruleIsoTimeValue returns [EObject current=null] : ( (lv_timeValue_0_0= RULE_ISOTIME ) ) ;
    public final EObject ruleIsoTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_timeValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4047:28: ( ( (lv_timeValue_0_0= RULE_ISOTIME ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4048:1: ( (lv_timeValue_0_0= RULE_ISOTIME ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4048:1: ( (lv_timeValue_0_0= RULE_ISOTIME ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4049:1: (lv_timeValue_0_0= RULE_ISOTIME )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4049:1: (lv_timeValue_0_0= RULE_ISOTIME )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4050:3: lv_timeValue_0_0= RULE_ISOTIME
            {
            lv_timeValue_0_0=(Token)match(input,RULE_ISOTIME,FOLLOW_RULE_ISOTIME_in_ruleIsoTimeValue9000); 

            			newLeafNode(lv_timeValue_0_0, grammarAccess.getIsoTimeValueAccess().getTimeValueISOTIMETerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIsoTimeValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"timeValue",
                    		lv_timeValue_0_0, 
                    		"ISOTIME");
            	    

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
    // $ANTLR end "ruleIsoTimeValue"


    // $ANTLR start "entryRuleSimple24HrsTimeValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4074:1: entryRuleSimple24HrsTimeValue returns [EObject current=null] : iv_ruleSimple24HrsTimeValue= ruleSimple24HrsTimeValue EOF ;
    public final EObject entryRuleSimple24HrsTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimple24HrsTimeValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4075:2: (iv_ruleSimple24HrsTimeValue= ruleSimple24HrsTimeValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4076:2: iv_ruleSimple24HrsTimeValue= ruleSimple24HrsTimeValue EOF
            {
             newCompositeNode(grammarAccess.getSimple24HrsTimeValueRule()); 
            pushFollow(FOLLOW_ruleSimple24HrsTimeValue_in_entryRuleSimple24HrsTimeValue9040);
            iv_ruleSimple24HrsTimeValue=ruleSimple24HrsTimeValue();

            state._fsp--;

             current =iv_ruleSimple24HrsTimeValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimple24HrsTimeValue9050); 

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
    // $ANTLR end "entryRuleSimple24HrsTimeValue"


    // $ANTLR start "ruleSimple24HrsTimeValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4083:1: ruleSimple24HrsTimeValue returns [EObject current=null] : ( (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME ) ) ;
    public final EObject ruleSimple24HrsTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_timeValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4086:28: ( ( (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4087:1: ( (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4087:1: ( (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4088:1: (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4088:1: (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4089:3: lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME
            {
            lv_timeValue_0_0=(Token)match(input,RULE_TWENTYFOURHRSTIME,FOLLOW_RULE_TWENTYFOURHRSTIME_in_ruleSimple24HrsTimeValue9091); 

            			newLeafNode(lv_timeValue_0_0, grammarAccess.getSimple24HrsTimeValueAccess().getTimeValueTWENTYFOURHRSTIMETerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimple24HrsTimeValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"timeValue",
                    		lv_timeValue_0_0, 
                    		"TWENTYFOURHRSTIME");
            	    

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
    // $ANTLR end "ruleSimple24HrsTimeValue"


    // $ANTLR start "entryRuleSimple12HrsTimeValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4113:1: entryRuleSimple12HrsTimeValue returns [EObject current=null] : iv_ruleSimple12HrsTimeValue= ruleSimple12HrsTimeValue EOF ;
    public final EObject entryRuleSimple12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimple12HrsTimeValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4114:2: (iv_ruleSimple12HrsTimeValue= ruleSimple12HrsTimeValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4115:2: iv_ruleSimple12HrsTimeValue= ruleSimple12HrsTimeValue EOF
            {
             newCompositeNode(grammarAccess.getSimple12HrsTimeValueRule()); 
            pushFollow(FOLLOW_ruleSimple12HrsTimeValue_in_entryRuleSimple12HrsTimeValue9131);
            iv_ruleSimple12HrsTimeValue=ruleSimple12HrsTimeValue();

            state._fsp--;

             current =iv_ruleSimple12HrsTimeValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimple12HrsTimeValue9141); 

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
    // $ANTLR end "entryRuleSimple12HrsTimeValue"


    // $ANTLR start "ruleSimple12HrsTimeValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4122:1: ruleSimple12HrsTimeValue returns [EObject current=null] : ( (lv_timeValue_0_0= RULE_TWELVEHRSTIME ) ) ;
    public final EObject ruleSimple12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_timeValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4125:28: ( ( (lv_timeValue_0_0= RULE_TWELVEHRSTIME ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4126:1: ( (lv_timeValue_0_0= RULE_TWELVEHRSTIME ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4126:1: ( (lv_timeValue_0_0= RULE_TWELVEHRSTIME ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4127:1: (lv_timeValue_0_0= RULE_TWELVEHRSTIME )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4127:1: (lv_timeValue_0_0= RULE_TWELVEHRSTIME )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4128:3: lv_timeValue_0_0= RULE_TWELVEHRSTIME
            {
            lv_timeValue_0_0=(Token)match(input,RULE_TWELVEHRSTIME,FOLLOW_RULE_TWELVEHRSTIME_in_ruleSimple12HrsTimeValue9182); 

            			newLeafNode(lv_timeValue_0_0, grammarAccess.getSimple12HrsTimeValueAccess().getTimeValueTWELVEHRSTIMETerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimple12HrsTimeValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"timeValue",
                    		lv_timeValue_0_0, 
                    		"TWELVEHRSTIME");
            	    

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
    // $ANTLR end "ruleSimple12HrsTimeValue"


    // $ANTLR start "entryRuleDateAndTimeValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4152:1: entryRuleDateAndTimeValue returns [EObject current=null] : iv_ruleDateAndTimeValue= ruleDateAndTimeValue EOF ;
    public final EObject entryRuleDateAndTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateAndTimeValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4153:2: (iv_ruleDateAndTimeValue= ruleDateAndTimeValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4154:2: iv_ruleDateAndTimeValue= ruleDateAndTimeValue EOF
            {
             newCompositeNode(grammarAccess.getDateAndTimeValueRule()); 
            pushFollow(FOLLOW_ruleDateAndTimeValue_in_entryRuleDateAndTimeValue9222);
            iv_ruleDateAndTimeValue=ruleDateAndTimeValue();

            state._fsp--;

             current =iv_ruleDateAndTimeValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDateAndTimeValue9232); 

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
    // $ANTLR end "entryRuleDateAndTimeValue"


    // $ANTLR start "ruleDateAndTimeValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4161:1: ruleDateAndTimeValue returns [EObject current=null] : (this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue | this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue | this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue | this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue ) ;
    public final EObject ruleDateAndTimeValue() throws RecognitionException {
        EObject current = null;

        EObject this_IsoDateAndTimeValue_0 = null;

        EObject this_EuropeanDateAnd24HrsTimeValue_1 = null;

        EObject this_EuropeanDateAnd12HrsTimeValue_2 = null;

        EObject this_USDateAnd12HrsTimeValue_3 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4164:28: ( (this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue | this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue | this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue | this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4165:1: (this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue | this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue | this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue | this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4165:1: (this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue | this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue | this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue | this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue )
            int alt55=4;
            alt55 = dfa55.predict(input);
            switch (alt55) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4166:5: this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue
                    {
                     
                            newCompositeNode(grammarAccess.getDateAndTimeValueAccess().getIsoDateAndTimeValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleIsoDateAndTimeValue_in_ruleDateAndTimeValue9279);
                    this_IsoDateAndTimeValue_0=ruleIsoDateAndTimeValue();

                    state._fsp--;

                     
                            current = this_IsoDateAndTimeValue_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4176:5: this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue
                    {
                     
                            newCompositeNode(grammarAccess.getDateAndTimeValueAccess().getEuropeanDateAnd24HrsTimeValueParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEuropeanDateAnd24HrsTimeValue_in_ruleDateAndTimeValue9306);
                    this_EuropeanDateAnd24HrsTimeValue_1=ruleEuropeanDateAnd24HrsTimeValue();

                    state._fsp--;

                     
                            current = this_EuropeanDateAnd24HrsTimeValue_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4186:5: this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue
                    {
                     
                            newCompositeNode(grammarAccess.getDateAndTimeValueAccess().getEuropeanDateAnd12HrsTimeValueParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleEuropeanDateAnd12HrsTimeValue_in_ruleDateAndTimeValue9333);
                    this_EuropeanDateAnd12HrsTimeValue_2=ruleEuropeanDateAnd12HrsTimeValue();

                    state._fsp--;

                     
                            current = this_EuropeanDateAnd12HrsTimeValue_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4196:5: this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue
                    {
                     
                            newCompositeNode(grammarAccess.getDateAndTimeValueAccess().getUSDateAnd12HrsTimeValueParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleUSDateAnd12HrsTimeValue_in_ruleDateAndTimeValue9360);
                    this_USDateAnd12HrsTimeValue_3=ruleUSDateAnd12HrsTimeValue();

                    state._fsp--;

                     
                            current = this_USDateAnd12HrsTimeValue_3; 
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
    // $ANTLR end "ruleDateAndTimeValue"


    // $ANTLR start "entryRuleIsoDateAndTimeValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4212:1: entryRuleIsoDateAndTimeValue returns [EObject current=null] : iv_ruleIsoDateAndTimeValue= ruleIsoDateAndTimeValue EOF ;
    public final EObject entryRuleIsoDateAndTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsoDateAndTimeValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4213:2: (iv_ruleIsoDateAndTimeValue= ruleIsoDateAndTimeValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4214:2: iv_ruleIsoDateAndTimeValue= ruleIsoDateAndTimeValue EOF
            {
             newCompositeNode(grammarAccess.getIsoDateAndTimeValueRule()); 
            pushFollow(FOLLOW_ruleIsoDateAndTimeValue_in_entryRuleIsoDateAndTimeValue9395);
            iv_ruleIsoDateAndTimeValue=ruleIsoDateAndTimeValue();

            state._fsp--;

             current =iv_ruleIsoDateAndTimeValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIsoDateAndTimeValue9405); 

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
    // $ANTLR end "entryRuleIsoDateAndTimeValue"


    // $ANTLR start "ruleIsoDateAndTimeValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4221:1: ruleIsoDateAndTimeValue returns [EObject current=null] : ( ( (lv_dateValue_0_0= RULE_ISODATE ) ) ( (lv_timeValue_1_0= RULE_ISOTIME ) ) ) ;
    public final EObject ruleIsoDateAndTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;
        Token lv_timeValue_1_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4224:28: ( ( ( (lv_dateValue_0_0= RULE_ISODATE ) ) ( (lv_timeValue_1_0= RULE_ISOTIME ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4225:1: ( ( (lv_dateValue_0_0= RULE_ISODATE ) ) ( (lv_timeValue_1_0= RULE_ISOTIME ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4225:1: ( ( (lv_dateValue_0_0= RULE_ISODATE ) ) ( (lv_timeValue_1_0= RULE_ISOTIME ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4225:2: ( (lv_dateValue_0_0= RULE_ISODATE ) ) ( (lv_timeValue_1_0= RULE_ISOTIME ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4225:2: ( (lv_dateValue_0_0= RULE_ISODATE ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4226:1: (lv_dateValue_0_0= RULE_ISODATE )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4226:1: (lv_dateValue_0_0= RULE_ISODATE )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4227:3: lv_dateValue_0_0= RULE_ISODATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_ISODATE,FOLLOW_RULE_ISODATE_in_ruleIsoDateAndTimeValue9447); 

            			newLeafNode(lv_dateValue_0_0, grammarAccess.getIsoDateAndTimeValueAccess().getDateValueISODATETerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIsoDateAndTimeValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"dateValue",
                    		lv_dateValue_0_0, 
                    		"ISODATE");
            	    

            }


            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4243:2: ( (lv_timeValue_1_0= RULE_ISOTIME ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4244:1: (lv_timeValue_1_0= RULE_ISOTIME )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4244:1: (lv_timeValue_1_0= RULE_ISOTIME )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4245:3: lv_timeValue_1_0= RULE_ISOTIME
            {
            lv_timeValue_1_0=(Token)match(input,RULE_ISOTIME,FOLLOW_RULE_ISOTIME_in_ruleIsoDateAndTimeValue9469); 

            			newLeafNode(lv_timeValue_1_0, grammarAccess.getIsoDateAndTimeValueAccess().getTimeValueISOTIMETerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIsoDateAndTimeValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"timeValue",
                    		lv_timeValue_1_0, 
                    		"ISOTIME");
            	    

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
    // $ANTLR end "ruleIsoDateAndTimeValue"


    // $ANTLR start "entryRuleEuropeanDateAnd24HrsTimeValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4269:1: entryRuleEuropeanDateAnd24HrsTimeValue returns [EObject current=null] : iv_ruleEuropeanDateAnd24HrsTimeValue= ruleEuropeanDateAnd24HrsTimeValue EOF ;
    public final EObject entryRuleEuropeanDateAnd24HrsTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEuropeanDateAnd24HrsTimeValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4270:2: (iv_ruleEuropeanDateAnd24HrsTimeValue= ruleEuropeanDateAnd24HrsTimeValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4271:2: iv_ruleEuropeanDateAnd24HrsTimeValue= ruleEuropeanDateAnd24HrsTimeValue EOF
            {
             newCompositeNode(grammarAccess.getEuropeanDateAnd24HrsTimeValueRule()); 
            pushFollow(FOLLOW_ruleEuropeanDateAnd24HrsTimeValue_in_entryRuleEuropeanDateAnd24HrsTimeValue9510);
            iv_ruleEuropeanDateAnd24HrsTimeValue=ruleEuropeanDateAnd24HrsTimeValue();

            state._fsp--;

             current =iv_ruleEuropeanDateAnd24HrsTimeValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEuropeanDateAnd24HrsTimeValue9520); 

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
    // $ANTLR end "entryRuleEuropeanDateAnd24HrsTimeValue"


    // $ANTLR start "ruleEuropeanDateAnd24HrsTimeValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4278:1: ruleEuropeanDateAnd24HrsTimeValue returns [EObject current=null] : ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) ) ) ;
    public final EObject ruleEuropeanDateAnd24HrsTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;
        Token lv_timeValue_2_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4281:28: ( ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4282:1: ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4282:1: ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4282:2: ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4282:2: ( (lv_dateValue_0_0= RULE_EURODATE ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4283:1: (lv_dateValue_0_0= RULE_EURODATE )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4283:1: (lv_dateValue_0_0= RULE_EURODATE )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4284:3: lv_dateValue_0_0= RULE_EURODATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_EURODATE,FOLLOW_RULE_EURODATE_in_ruleEuropeanDateAnd24HrsTimeValue9562); 

            			newLeafNode(lv_dateValue_0_0, grammarAccess.getEuropeanDateAnd24HrsTimeValueAccess().getDateValueEURODATETerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEuropeanDateAnd24HrsTimeValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"dateValue",
                    		lv_dateValue_0_0, 
                    		"EURODATE");
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getEuropeanDateAnd24HrsTimeValueAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleEuropeanDateAnd24HrsTimeValue9583);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4308:1: ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4309:1: (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4309:1: (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4310:3: lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME
            {
            lv_timeValue_2_0=(Token)match(input,RULE_TWENTYFOURHRSTIME,FOLLOW_RULE_TWENTYFOURHRSTIME_in_ruleEuropeanDateAnd24HrsTimeValue9599); 

            			newLeafNode(lv_timeValue_2_0, grammarAccess.getEuropeanDateAnd24HrsTimeValueAccess().getTimeValueTWENTYFOURHRSTIMETerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEuropeanDateAnd24HrsTimeValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"timeValue",
                    		lv_timeValue_2_0, 
                    		"TWENTYFOURHRSTIME");
            	    

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
    // $ANTLR end "ruleEuropeanDateAnd24HrsTimeValue"


    // $ANTLR start "entryRuleEuropeanDateAnd12HrsTimeValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4334:1: entryRuleEuropeanDateAnd12HrsTimeValue returns [EObject current=null] : iv_ruleEuropeanDateAnd12HrsTimeValue= ruleEuropeanDateAnd12HrsTimeValue EOF ;
    public final EObject entryRuleEuropeanDateAnd12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEuropeanDateAnd12HrsTimeValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4335:2: (iv_ruleEuropeanDateAnd12HrsTimeValue= ruleEuropeanDateAnd12HrsTimeValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4336:2: iv_ruleEuropeanDateAnd12HrsTimeValue= ruleEuropeanDateAnd12HrsTimeValue EOF
            {
             newCompositeNode(grammarAccess.getEuropeanDateAnd12HrsTimeValueRule()); 
            pushFollow(FOLLOW_ruleEuropeanDateAnd12HrsTimeValue_in_entryRuleEuropeanDateAnd12HrsTimeValue9640);
            iv_ruleEuropeanDateAnd12HrsTimeValue=ruleEuropeanDateAnd12HrsTimeValue();

            state._fsp--;

             current =iv_ruleEuropeanDateAnd12HrsTimeValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEuropeanDateAnd12HrsTimeValue9650); 

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
    // $ANTLR end "entryRuleEuropeanDateAnd12HrsTimeValue"


    // $ANTLR start "ruleEuropeanDateAnd12HrsTimeValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4343:1: ruleEuropeanDateAnd12HrsTimeValue returns [EObject current=null] : ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) ) ;
    public final EObject ruleEuropeanDateAnd12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;
        Token lv_timeValue_2_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4346:28: ( ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4347:1: ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4347:1: ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4347:2: ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4347:2: ( (lv_dateValue_0_0= RULE_EURODATE ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4348:1: (lv_dateValue_0_0= RULE_EURODATE )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4348:1: (lv_dateValue_0_0= RULE_EURODATE )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4349:3: lv_dateValue_0_0= RULE_EURODATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_EURODATE,FOLLOW_RULE_EURODATE_in_ruleEuropeanDateAnd12HrsTimeValue9692); 

            			newLeafNode(lv_dateValue_0_0, grammarAccess.getEuropeanDateAnd12HrsTimeValueAccess().getDateValueEURODATETerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEuropeanDateAnd12HrsTimeValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"dateValue",
                    		lv_dateValue_0_0, 
                    		"EURODATE");
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getEuropeanDateAnd12HrsTimeValueAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleEuropeanDateAnd12HrsTimeValue9713);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4373:1: ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4374:1: (lv_timeValue_2_0= RULE_TWELVEHRSTIME )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4374:1: (lv_timeValue_2_0= RULE_TWELVEHRSTIME )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4375:3: lv_timeValue_2_0= RULE_TWELVEHRSTIME
            {
            lv_timeValue_2_0=(Token)match(input,RULE_TWELVEHRSTIME,FOLLOW_RULE_TWELVEHRSTIME_in_ruleEuropeanDateAnd12HrsTimeValue9729); 

            			newLeafNode(lv_timeValue_2_0, grammarAccess.getEuropeanDateAnd12HrsTimeValueAccess().getTimeValueTWELVEHRSTIMETerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEuropeanDateAnd12HrsTimeValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"timeValue",
                    		lv_timeValue_2_0, 
                    		"TWELVEHRSTIME");
            	    

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
    // $ANTLR end "ruleEuropeanDateAnd12HrsTimeValue"


    // $ANTLR start "entryRuleUSDateAnd12HrsTimeValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4399:1: entryRuleUSDateAnd12HrsTimeValue returns [EObject current=null] : iv_ruleUSDateAnd12HrsTimeValue= ruleUSDateAnd12HrsTimeValue EOF ;
    public final EObject entryRuleUSDateAnd12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUSDateAnd12HrsTimeValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4400:2: (iv_ruleUSDateAnd12HrsTimeValue= ruleUSDateAnd12HrsTimeValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4401:2: iv_ruleUSDateAnd12HrsTimeValue= ruleUSDateAnd12HrsTimeValue EOF
            {
             newCompositeNode(grammarAccess.getUSDateAnd12HrsTimeValueRule()); 
            pushFollow(FOLLOW_ruleUSDateAnd12HrsTimeValue_in_entryRuleUSDateAnd12HrsTimeValue9770);
            iv_ruleUSDateAnd12HrsTimeValue=ruleUSDateAnd12HrsTimeValue();

            state._fsp--;

             current =iv_ruleUSDateAnd12HrsTimeValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUSDateAnd12HrsTimeValue9780); 

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
    // $ANTLR end "entryRuleUSDateAnd12HrsTimeValue"


    // $ANTLR start "ruleUSDateAnd12HrsTimeValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4408:1: ruleUSDateAnd12HrsTimeValue returns [EObject current=null] : ( ( (lv_dateValue_0_0= RULE_USDATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) ) ;
    public final EObject ruleUSDateAnd12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;
        Token lv_timeValue_2_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4411:28: ( ( ( (lv_dateValue_0_0= RULE_USDATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4412:1: ( ( (lv_dateValue_0_0= RULE_USDATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4412:1: ( ( (lv_dateValue_0_0= RULE_USDATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4412:2: ( (lv_dateValue_0_0= RULE_USDATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4412:2: ( (lv_dateValue_0_0= RULE_USDATE ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4413:1: (lv_dateValue_0_0= RULE_USDATE )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4413:1: (lv_dateValue_0_0= RULE_USDATE )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4414:3: lv_dateValue_0_0= RULE_USDATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_USDATE,FOLLOW_RULE_USDATE_in_ruleUSDateAnd12HrsTimeValue9822); 

            			newLeafNode(lv_dateValue_0_0, grammarAccess.getUSDateAnd12HrsTimeValueAccess().getDateValueUSDATETerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUSDateAnd12HrsTimeValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"dateValue",
                    		lv_dateValue_0_0, 
                    		"USDATE");
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getUSDateAnd12HrsTimeValueAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleUSDateAnd12HrsTimeValue9843);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4438:1: ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4439:1: (lv_timeValue_2_0= RULE_TWELVEHRSTIME )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4439:1: (lv_timeValue_2_0= RULE_TWELVEHRSTIME )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4440:3: lv_timeValue_2_0= RULE_TWELVEHRSTIME
            {
            lv_timeValue_2_0=(Token)match(input,RULE_TWELVEHRSTIME,FOLLOW_RULE_TWELVEHRSTIME_in_ruleUSDateAnd12HrsTimeValue9859); 

            			newLeafNode(lv_timeValue_2_0, grammarAccess.getUSDateAnd12HrsTimeValueAccess().getTimeValueTWELVEHRSTIMETerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUSDateAnd12HrsTimeValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"timeValue",
                    		lv_timeValue_2_0, 
                    		"TWELVEHRSTIME");
            	    

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
    // $ANTLR end "ruleUSDateAnd12HrsTimeValue"


    // $ANTLR start "entryRuleVariable"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4464:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4465:2: (iv_ruleVariable= ruleVariable EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4466:2: iv_ruleVariable= ruleVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable9900);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable9910); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4473:1: ruleVariable returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4476:28: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4477:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4477:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4478:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4478:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4479:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getVariableRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getVariableAccess().getNameVariableEntityCrossReference_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleVariable9957);
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


    // $ANTLR start "entryRuleNullValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4500:1: entryRuleNullValue returns [EObject current=null] : iv_ruleNullValue= ruleNullValue EOF ;
    public final EObject entryRuleNullValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4501:2: (iv_ruleNullValue= ruleNullValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4502:2: iv_ruleNullValue= ruleNullValue EOF
            {
             newCompositeNode(grammarAccess.getNullValueRule()); 
            pushFollow(FOLLOW_ruleNullValue_in_entryRuleNullValue9992);
            iv_ruleNullValue=ruleNullValue();

            state._fsp--;

             current =iv_ruleNullValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullValue10002); 

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
    // $ANTLR end "entryRuleNullValue"


    // $ANTLR start "ruleNullValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4509:1: ruleNullValue returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4512:28: ( ( () otherlv_1= 'null' ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4513:1: ( () otherlv_1= 'null' )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4513:1: ( () otherlv_1= 'null' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4513:2: () otherlv_1= 'null'
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4513:2: ()
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4514:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNullValueAccess().getNullAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,58,FOLLOW_58_in_ruleNullValue10048); 

                	newLeafNode(otherlv_1, grammarAccess.getNullValueAccess().getNullKeyword_1());
                

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
    // $ANTLR end "ruleNullValue"


    // $ANTLR start "entryRuleEnumValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4531:1: entryRuleEnumValue returns [EObject current=null] : iv_ruleEnumValue= ruleEnumValue EOF ;
    public final EObject entryRuleEnumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4532:2: (iv_ruleEnumValue= ruleEnumValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4533:2: iv_ruleEnumValue= ruleEnumValue EOF
            {
             newCompositeNode(grammarAccess.getEnumValueRule()); 
            pushFollow(FOLLOW_ruleEnumValue_in_entryRuleEnumValue10084);
            iv_ruleEnumValue=ruleEnumValue();

            state._fsp--;

             current =iv_ruleEnumValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumValue10094); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4540:1: ruleEnumValue returns [EObject current=null] : ( (otherlv_0= RULE_UPPERCASE_ID ) ) ;
    public final EObject ruleEnumValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4543:28: ( ( (otherlv_0= RULE_UPPERCASE_ID ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4544:1: ( (otherlv_0= RULE_UPPERCASE_ID ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4544:1: ( (otherlv_0= RULE_UPPERCASE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4545:1: (otherlv_0= RULE_UPPERCASE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4545:1: (otherlv_0= RULE_UPPERCASE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4546:3: otherlv_0= RULE_UPPERCASE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumValueRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_UPPERCASE_ID,FOLLOW_RULE_UPPERCASE_ID_in_ruleEnumValue10138); 

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


    // $ANTLR start "entryRuleNestedObject"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4565:1: entryRuleNestedObject returns [EObject current=null] : iv_ruleNestedObject= ruleNestedObject EOF ;
    public final EObject entryRuleNestedObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedObject = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4566:2: (iv_ruleNestedObject= ruleNestedObject EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4567:2: iv_ruleNestedObject= ruleNestedObject EOF
            {
             newCompositeNode(grammarAccess.getNestedObjectRule()); 
            pushFollow(FOLLOW_ruleNestedObject_in_entryRuleNestedObject10173);
            iv_ruleNestedObject=ruleNestedObject();

            state._fsp--;

             current =iv_ruleNestedObject; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNestedObject10183); 

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
    // $ANTLR end "entryRuleNestedObject"


    // $ANTLR start "ruleNestedObject"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4574:1: ruleNestedObject returns [EObject current=null] : (otherlv_0= '{' ruleNL ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+ otherlv_4= '}' ) ;
    public final EObject ruleNestedObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject lv_attributes_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4577:28: ( (otherlv_0= '{' ruleNL ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+ otherlv_4= '}' ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4578:1: (otherlv_0= '{' ruleNL ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+ otherlv_4= '}' )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4578:1: (otherlv_0= '{' ruleNL ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+ otherlv_4= '}' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4578:3: otherlv_0= '{' ruleNL ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,59,FOLLOW_59_in_ruleNestedObject10220); 

                	newLeafNode(otherlv_0, grammarAccess.getNestedObjectAccess().getLeftCurlyBracketKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getNestedObjectAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleNestedObject10236);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4590:1: ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+
            int cnt56=0;
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( (LA56_0==RULE_ID) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4590:2: ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4590:2: ( (lv_attributes_2_0= ruleKeyValuePair ) )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4591:1: (lv_attributes_2_0= ruleKeyValuePair )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4591:1: (lv_attributes_2_0= ruleKeyValuePair )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4592:3: lv_attributes_2_0= ruleKeyValuePair
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getNestedObjectAccess().getAttributesKeyValuePairParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleKeyValuePair_in_ruleNestedObject10257);
            	    lv_attributes_2_0=ruleKeyValuePair();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getNestedObjectRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"attributes",
            	            		lv_attributes_2_0, 
            	            		"KeyValuePair");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	     
            	            newCompositeNode(grammarAccess.getNestedObjectAccess().getNLParserRuleCall_2_1()); 
            	        
            	    pushFollow(FOLLOW_ruleNL_in_ruleNestedObject10273);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt56 >= 1 ) break loop56;
                        EarlyExitException eee =
                            new EarlyExitException(56, input);
                        throw eee;
                }
                cnt56++;
            } while (true);

            otherlv_4=(Token)match(input,60,FOLLOW_60_in_ruleNestedObject10286); 

                	newLeafNode(otherlv_4, grammarAccess.getNestedObjectAccess().getRightCurlyBracketKeyword_3());
                

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
    // $ANTLR end "ruleNestedObject"


    // $ANTLR start "entryRuleKeyValuePair"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4628:1: entryRuleKeyValuePair returns [EObject current=null] : iv_ruleKeyValuePair= ruleKeyValuePair EOF ;
    public final EObject entryRuleKeyValuePair() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValuePair = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4629:2: (iv_ruleKeyValuePair= ruleKeyValuePair EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4630:2: iv_ruleKeyValuePair= ruleKeyValuePair EOF
            {
             newCompositeNode(grammarAccess.getKeyValuePairRule()); 
            pushFollow(FOLLOW_ruleKeyValuePair_in_entryRuleKeyValuePair10322);
            iv_ruleKeyValuePair=ruleKeyValuePair();

            state._fsp--;

             current =iv_ruleKeyValuePair; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyValuePair10332); 

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
    // $ANTLR end "entryRuleKeyValuePair"


    // $ANTLR start "ruleKeyValuePair"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4637:1: ruleKeyValuePair returns [EObject current=null] : ( ( (lv_identifier_0_0= RULE_ID ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) ;
    public final EObject ruleKeyValuePair() throws RecognitionException {
        EObject current = null;

        Token lv_identifier_0_0=null;
        Token otherlv_2=null;
        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4640:28: ( ( ( (lv_identifier_0_0= RULE_ID ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4641:1: ( ( (lv_identifier_0_0= RULE_ID ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4641:1: ( ( (lv_identifier_0_0= RULE_ID ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4641:2: ( (lv_identifier_0_0= RULE_ID ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4641:2: ( (lv_identifier_0_0= RULE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4642:1: (lv_identifier_0_0= RULE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4642:1: (lv_identifier_0_0= RULE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4643:3: lv_identifier_0_0= RULE_ID
            {
            lv_identifier_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKeyValuePair10374); 

            			newLeafNode(lv_identifier_0_0, grammarAccess.getKeyValuePairAccess().getIdentifierIDTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getKeyValuePairRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"identifier",
                    		lv_identifier_0_0, 
                    		"ID");
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getKeyValuePairAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleKeyValuePair10395);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,32,FOLLOW_32_in_ruleKeyValuePair10406); 

                	newLeafNode(otherlv_2, grammarAccess.getKeyValuePairAccess().getColonKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getKeyValuePairAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleKeyValuePair10422);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4679:1: ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4680:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4680:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4681:3: lv_value_4_0= ruleValueOrEnumValueOrOperationCollection
            {
             
            	        newCompositeNode(grammarAccess.getKeyValuePairAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleKeyValuePair10442);
            lv_value_4_0=ruleValueOrEnumValueOrOperationCollection();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getKeyValuePairRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_4_0, 
                    		"ValueOrEnumValueOrOperationCollection");
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
    // $ANTLR end "ruleKeyValuePair"


    // $ANTLR start "entryRuleJavaClassReference"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4705:1: entryRuleJavaClassReference returns [EObject current=null] : iv_ruleJavaClassReference= ruleJavaClassReference EOF ;
    public final EObject entryRuleJavaClassReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaClassReference = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4706:2: (iv_ruleJavaClassReference= ruleJavaClassReference EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4707:2: iv_ruleJavaClassReference= ruleJavaClassReference EOF
            {
             newCompositeNode(grammarAccess.getJavaClassReferenceRule()); 
            pushFollow(FOLLOW_ruleJavaClassReference_in_entryRuleJavaClassReference10478);
            iv_ruleJavaClassReference=ruleJavaClassReference();

            state._fsp--;

             current =iv_ruleJavaClassReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJavaClassReference10488); 

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
    // $ANTLR end "entryRuleJavaClassReference"


    // $ANTLR start "ruleJavaClassReference"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4714:1: ruleJavaClassReference returns [EObject current=null] : ( ( ruleQualifiedJavaClassName ) ) ;
    public final EObject ruleJavaClassReference() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4717:28: ( ( ( ruleQualifiedJavaClassName ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4718:1: ( ( ruleQualifiedJavaClassName ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4718:1: ( ( ruleQualifiedJavaClassName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4719:1: ( ruleQualifiedJavaClassName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4719:1: ( ruleQualifiedJavaClassName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4720:3: ruleQualifiedJavaClassName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getJavaClassReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getJavaClassReferenceAccess().getTypeJvmTypeCrossReference_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_ruleJavaClassReference10535);
            ruleQualifiedJavaClassName();

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
    // $ANTLR end "ruleJavaClassReference"


    // $ANTLR start "entryRuleMethodReference"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4741:1: entryRuleMethodReference returns [EObject current=null] : iv_ruleMethodReference= ruleMethodReference EOF ;
    public final EObject entryRuleMethodReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodReference = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4742:2: (iv_ruleMethodReference= ruleMethodReference EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4743:2: iv_ruleMethodReference= ruleMethodReference EOF
            {
             newCompositeNode(grammarAccess.getMethodReferenceRule()); 
            pushFollow(FOLLOW_ruleMethodReference_in_entryRuleMethodReference10570);
            iv_ruleMethodReference=ruleMethodReference();

            state._fsp--;

             current =iv_ruleMethodReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodReference10580); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4750:1: ruleMethodReference returns [EObject current=null] : ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleMethodReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4753:28: ( ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4754:1: ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4754:1: ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4754:2: ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4754:2: ( ( ruleQualifiedJavaClassName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4755:1: ( ruleQualifiedJavaClassName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4755:1: ( ruleQualifiedJavaClassName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4756:3: ruleQualifiedJavaClassName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMethodReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getMethodReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_ruleMethodReference10628);
            ruleQualifiedJavaClassName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,61,FOLLOW_61_in_ruleMethodReference10640); 

                	newLeafNode(otherlv_1, grammarAccess.getMethodReferenceAccess().getNumberSignKeyword_1());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4773:1: ( (otherlv_2= RULE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4774:1: (otherlv_2= RULE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4774:1: (otherlv_2= RULE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4775:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMethodReferenceRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMethodReference10660); 

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


    // $ANTLR start "entryRuleExecutionMultiplier"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4794:1: entryRuleExecutionMultiplier returns [EObject current=null] : iv_ruleExecutionMultiplier= ruleExecutionMultiplier EOF ;
    public final EObject entryRuleExecutionMultiplier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExecutionMultiplier = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4795:2: (iv_ruleExecutionMultiplier= ruleExecutionMultiplier EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4796:2: iv_ruleExecutionMultiplier= ruleExecutionMultiplier EOF
            {
             newCompositeNode(grammarAccess.getExecutionMultiplierRule()); 
            pushFollow(FOLLOW_ruleExecutionMultiplier_in_entryRuleExecutionMultiplier10696);
            iv_ruleExecutionMultiplier=ruleExecutionMultiplier();

            state._fsp--;

             current =iv_ruleExecutionMultiplier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExecutionMultiplier10706); 

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
    // $ANTLR end "entryRuleExecutionMultiplier"


    // $ANTLR start "ruleExecutionMultiplier"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4803:1: ruleExecutionMultiplier returns [EObject current=null] : ( ( (lv_count_0_0= RULE_INTEGER ) ) otherlv_1= '*' ) ;
    public final EObject ruleExecutionMultiplier() throws RecognitionException {
        EObject current = null;

        Token lv_count_0_0=null;
        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4806:28: ( ( ( (lv_count_0_0= RULE_INTEGER ) ) otherlv_1= '*' ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4807:1: ( ( (lv_count_0_0= RULE_INTEGER ) ) otherlv_1= '*' )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4807:1: ( ( (lv_count_0_0= RULE_INTEGER ) ) otherlv_1= '*' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4807:2: ( (lv_count_0_0= RULE_INTEGER ) ) otherlv_1= '*'
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4807:2: ( (lv_count_0_0= RULE_INTEGER ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4808:1: (lv_count_0_0= RULE_INTEGER )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4808:1: (lv_count_0_0= RULE_INTEGER )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4809:3: lv_count_0_0= RULE_INTEGER
            {
            lv_count_0_0=(Token)match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleExecutionMultiplier10748); 

            			newLeafNode(lv_count_0_0, grammarAccess.getExecutionMultiplierAccess().getCountINTEGERTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getExecutionMultiplierRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"count",
                    		lv_count_0_0, 
                    		"INTEGER");
            	    

            }


            }

            otherlv_1=(Token)match(input,62,FOLLOW_62_in_ruleExecutionMultiplier10765); 

                	newLeafNode(otherlv_1, grammarAccess.getExecutionMultiplierAccess().getAsteriskKeyword_1());
                

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
    // $ANTLR end "ruleExecutionMultiplier"


    // $ANTLR start "entryRuleQualifiedName"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4837:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4838:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4839:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10802);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName10813); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4846:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4849:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4850:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4850:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4850:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName10853); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4857:1: (kw= '.' this_ID_2= RULE_ID )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==63) ) {
                    int LA57_2 = input.LA(2);

                    if ( (LA57_2==RULE_ID) ) {
                        alt57=1;
                    }


                }


                switch (alt57) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4858:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,63,FOLLOW_63_in_ruleQualifiedName10872); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName10887); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop57;
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4878:1: entryRuleQualifiedJavaClassName returns [String current=null] : iv_ruleQualifiedJavaClassName= ruleQualifiedJavaClassName EOF ;
    public final String entryRuleQualifiedJavaClassName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedJavaClassName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4879:2: (iv_ruleQualifiedJavaClassName= ruleQualifiedJavaClassName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4880:2: iv_ruleQualifiedJavaClassName= ruleQualifiedJavaClassName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedJavaClassNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_entryRuleQualifiedJavaClassName10935);
            iv_ruleQualifiedJavaClassName=ruleQualifiedJavaClassName();

            state._fsp--;

             current =iv_ruleQualifiedJavaClassName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedJavaClassName10946); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4887:1: ruleQualifiedJavaClassName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedJavaClassName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_UPPERCASE_ID_2=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4890:28: ( (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4891:1: (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4891:1: (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4892:5: this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID
            {
             
                    newCompositeNode(grammarAccess.getQualifiedJavaClassNameAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedJavaClassName10993);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            kw=(Token)match(input,63,FOLLOW_63_in_ruleQualifiedJavaClassName11011); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getQualifiedJavaClassNameAccess().getFullStopKeyword_1()); 
                
            this_UPPERCASE_ID_2=(Token)match(input,RULE_UPPERCASE_ID,FOLLOW_RULE_UPPERCASE_ID_in_ruleQualifiedJavaClassName11026); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4923:1: entryRuleQualifiedNameWithWildcard returns [String current=null] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4924:2: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4925:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard11072);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();

            state._fsp--;

             current =iv_ruleQualifiedNameWithWildcard.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard11083); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4932:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4935:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4936:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4936:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4937:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard11130);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4947:1: (kw= '.*' )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==64) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4948:2: kw= '.*'
                    {
                    kw=(Token)match(input,64,FOLLOW_64_in_ruleQualifiedNameWithWildcard11149); 

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


    // $ANTLR start "entryRuleNL"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4961:1: entryRuleNL returns [String current=null] : iv_ruleNL= ruleNL EOF ;
    public final String entryRuleNL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNL = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4962:2: (iv_ruleNL= ruleNL EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4963:2: iv_ruleNL= ruleNL EOF
            {
             newCompositeNode(grammarAccess.getNLRule()); 
            pushFollow(FOLLOW_ruleNL_in_entryRuleNL11192);
            iv_ruleNL=ruleNL();

            state._fsp--;

             current =iv_ruleNL.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNL11203); 

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
    // $ANTLR end "entryRuleNL"


    // $ANTLR start "ruleNL"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4970:1: ruleNL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? )* ;
    public final AntlrDatatypeRuleToken ruleNL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_NEWLINE_0=null;
        Token this_WS_1=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4973:28: ( (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? )* )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4974:1: (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? )*
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4974:1: (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? )*
            loop60:
            do {
                int alt60=2;
                int LA60_0 = input.LA(1);

                if ( (LA60_0==RULE_NEWLINE) ) {
                    alt60=1;
                }


                switch (alt60) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4974:6: this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )?
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleNL11243); 

            	    		current.merge(this_NEWLINE_0);
            	        
            	     
            	        newLeafNode(this_NEWLINE_0, grammarAccess.getNLAccess().getNEWLINETerminalRuleCall_0()); 
            	        
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4981:1: (this_WS_1= RULE_WS )?
            	    int alt59=2;
            	    int LA59_0 = input.LA(1);

            	    if ( (LA59_0==RULE_WS) ) {
            	        alt59=1;
            	    }
            	    switch (alt59) {
            	        case 1 :
            	            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4981:6: this_WS_1= RULE_WS
            	            {
            	            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleNL11264); 

            	            		current.merge(this_WS_1);
            	                
            	             
            	                newLeafNode(this_WS_1, grammarAccess.getNLAccess().getWSTerminalRuleCall_1()); 
            	                

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop60;
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
    // $ANTLR end "ruleNL"


    // $ANTLR start "entryRuleNLFORCED"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4996:1: entryRuleNLFORCED returns [String current=null] : iv_ruleNLFORCED= ruleNLFORCED EOF ;
    public final String entryRuleNLFORCED() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNLFORCED = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4997:2: (iv_ruleNLFORCED= ruleNLFORCED EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4998:2: iv_ruleNLFORCED= ruleNLFORCED EOF
            {
             newCompositeNode(grammarAccess.getNLFORCEDRule()); 
            pushFollow(FOLLOW_ruleNLFORCED_in_entryRuleNLFORCED11313);
            iv_ruleNLFORCED=ruleNLFORCED();

            state._fsp--;

             current =iv_ruleNLFORCED.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNLFORCED11324); 

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
    // $ANTLR end "entryRuleNLFORCED"


    // $ANTLR start "ruleNLFORCED"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5005:1: ruleNLFORCED returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? this_NL_2= ruleNL ) ;
    public final AntlrDatatypeRuleToken ruleNLFORCED() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_NEWLINE_0=null;
        Token this_WS_1=null;
        AntlrDatatypeRuleToken this_NL_2 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5008:28: ( (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? this_NL_2= ruleNL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5009:1: (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? this_NL_2= ruleNL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5009:1: (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? this_NL_2= ruleNL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5009:6: this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? this_NL_2= ruleNL
            {
            this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleNLFORCED11364); 

            		current.merge(this_NEWLINE_0);
                
             
                newLeafNode(this_NEWLINE_0, grammarAccess.getNLFORCEDAccess().getNEWLINETerminalRuleCall_0()); 
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5016:1: (this_WS_1= RULE_WS )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==RULE_WS) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5016:6: this_WS_1= RULE_WS
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleNLFORCED11385); 

                    		current.merge(this_WS_1);
                        
                     
                        newLeafNode(this_WS_1, grammarAccess.getNLFORCEDAccess().getWSTerminalRuleCall_1()); 
                        

                    }
                    break;

            }

             
                    newCompositeNode(grammarAccess.getNLFORCEDAccess().getNLParserRuleCall_2()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleNLFORCED11414);
            this_NL_2=ruleNL();

            state._fsp--;


            		current.merge(this_NL_2);
                
             
                    afterParserOrEnumRuleCall();
                

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
    // $ANTLR end "ruleNLFORCED"

    // Delegated rules


    protected DFA23 dfa23 = new DFA23(this);
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA25 dfa25 = new DFA25(this);
    protected DFA26 dfa26 = new DFA26(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA38 dfa38 = new DFA38(this);
    protected DFA39 dfa39 = new DFA39(this);
    protected DFA46 dfa46 = new DFA46(this);
    protected DFA47 dfa47 = new DFA47(this);
    protected DFA48 dfa48 = new DFA48(this);
    protected DFA51 dfa51 = new DFA51(this);
    protected DFA55 dfa55 = new DFA55(this);
    static final String DFA23_eotS =
        "\12\uffff";
    static final String DFA23_eofS =
        "\2\4\3\uffff\1\4\4\uffff";
    static final String DFA23_minS =
        "\2\4\1\24\1\10\1\uffff\1\4\1\24\1\uffff\2\24";
    static final String DFA23_maxS =
        "\2\66\1\57\1\10\1\uffff\1\66\1\57\1\uffff\2\57";
    static final String DFA23_acceptS =
        "\4\uffff\1\2\2\uffff\1\1\2\uffff";
    static final String DFA23_specialS =
        "\12\uffff}>";
    static final String[] DFA23_transitionS = {
            "\3\4\1\uffff\1\2\13\uffff\1\1\23\uffff\1\4\1\uffff\1\4\1\uffff"+
            "\1\4\1\uffff\3\4\1\uffff\1\4\1\uffff\1\4\1\uffff\1\3",
            "\3\4\1\uffff\1\2\13\uffff\1\1\1\5\22\uffff\1\4\1\uffff\1\4"+
            "\1\uffff\1\4\1\uffff\3\4\1\uffff\1\4\1\uffff\1\4\1\uffff\1\3",
            "\1\6\13\uffff\1\7\16\uffff\1\4",
            "\1\10",
            "",
            "\3\4\1\uffff\1\2\13\uffff\1\1\23\uffff\1\4\1\uffff\1\4\1\uffff"+
            "\1\4\1\uffff\3\4\1\uffff\1\4\1\uffff\1\4\1\uffff\1\3",
            "\1\6\1\11\12\uffff\1\7\16\uffff\1\4",
            "",
            "\1\6\13\uffff\1\7\16\uffff\1\4",
            "\1\6\13\uffff\1\7\16\uffff\1\4"
    };

    static final short[] DFA23_eot = DFA.unpackEncodedString(DFA23_eotS);
    static final short[] DFA23_eof = DFA.unpackEncodedString(DFA23_eofS);
    static final char[] DFA23_min = DFA.unpackEncodedStringToUnsignedChars(DFA23_minS);
    static final char[] DFA23_max = DFA.unpackEncodedStringToUnsignedChars(DFA23_maxS);
    static final short[] DFA23_accept = DFA.unpackEncodedString(DFA23_acceptS);
    static final short[] DFA23_special = DFA.unpackEncodedString(DFA23_specialS);
    static final short[][] DFA23_transition;

    static {
        int numStates = DFA23_transitionS.length;
        DFA23_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA23_transition[i] = DFA.unpackEncodedString(DFA23_transitionS[i]);
        }
    }

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = DFA23_eot;
            this.eof = DFA23_eof;
            this.min = DFA23_min;
            this.max = DFA23_max;
            this.accept = DFA23_accept;
            this.special = DFA23_special;
            this.transition = DFA23_transition;
        }
        public String getDescription() {
            return "()* loopback of 1934:2: ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )*";
        }
    }
    static final String DFA24_eotS =
        "\5\uffff";
    static final String DFA24_eofS =
        "\2\2\2\uffff\1\2";
    static final String DFA24_minS =
        "\2\4\2\uffff\1\4";
    static final String DFA24_maxS =
        "\2\66\2\uffff\1\66";
    static final String DFA24_acceptS =
        "\2\uffff\1\2\1\1\1\uffff";
    static final String DFA24_specialS =
        "\5\uffff}>";
    static final String[] DFA24_transitionS = {
            "\3\2\1\uffff\1\3\13\uffff\1\1\23\uffff\1\2\1\uffff\1\2\1\uffff"+
            "\1\2\1\uffff\3\2\1\uffff\1\2\1\uffff\1\2\1\uffff\1\3",
            "\3\2\1\uffff\1\3\13\uffff\1\1\1\4\22\uffff\1\2\1\uffff\1\2"+
            "\1\uffff\1\2\1\uffff\3\2\1\uffff\1\2\1\uffff\1\2\1\uffff\1\3",
            "",
            "",
            "\3\2\1\uffff\1\3\13\uffff\1\1\23\uffff\1\2\1\uffff\1\2\1\uffff"+
            "\1\2\1\uffff\3\2\1\uffff\1\2\1\uffff\1\2\1\uffff\1\3"
    };

    static final short[] DFA24_eot = DFA.unpackEncodedString(DFA24_eotS);
    static final short[] DFA24_eof = DFA.unpackEncodedString(DFA24_eofS);
    static final char[] DFA24_min = DFA.unpackEncodedStringToUnsignedChars(DFA24_minS);
    static final char[] DFA24_max = DFA.unpackEncodedStringToUnsignedChars(DFA24_maxS);
    static final short[] DFA24_accept = DFA.unpackEncodedString(DFA24_acceptS);
    static final short[] DFA24_special = DFA.unpackEncodedString(DFA24_specialS);
    static final short[][] DFA24_transition;

    static {
        int numStates = DFA24_transitionS.length;
        DFA24_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA24_transition[i] = DFA.unpackEncodedString(DFA24_transitionS[i]);
        }
    }

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = DFA24_eot;
            this.eof = DFA24_eof;
            this.min = DFA24_min;
            this.max = DFA24_max;
            this.accept = DFA24_accept;
            this.special = DFA24_special;
            this.transition = DFA24_transition;
        }
        public String getDescription() {
            return "()* loopback of 1960:4: ( ruleNL ( (lv_results_6_0= ruleNamedResult ) ) )*";
        }
    }
    static final String DFA25_eotS =
        "\5\uffff";
    static final String DFA25_eofS =
        "\2\3\2\uffff\1\3";
    static final String DFA25_minS =
        "\2\4\2\uffff\1\4";
    static final String DFA25_maxS =
        "\2\64\2\uffff\1\64";
    static final String DFA25_acceptS =
        "\2\uffff\1\1\1\2\1\uffff";
    static final String DFA25_specialS =
        "\5\uffff}>";
    static final String[] DFA25_transitionS = {
            "\3\3\15\uffff\1\1\23\uffff\1\3\1\uffff\1\3\1\uffff\1\3\1\uffff"+
            "\1\3\1\2\1\3\1\uffff\1\3\1\uffff\1\3",
            "\3\3\15\uffff\1\1\1\4\22\uffff\1\3\1\uffff\1\3\1\uffff\1\3"+
            "\1\uffff\1\3\1\2\1\3\1\uffff\1\3\1\uffff\1\3",
            "",
            "",
            "\3\3\15\uffff\1\1\23\uffff\1\3\1\uffff\1\3\1\uffff\1\3\1\uffff"+
            "\1\3\1\2\1\3\1\uffff\1\3\1\uffff\1\3"
    };

    static final short[] DFA25_eot = DFA.unpackEncodedString(DFA25_eotS);
    static final short[] DFA25_eof = DFA.unpackEncodedString(DFA25_eofS);
    static final char[] DFA25_min = DFA.unpackEncodedStringToUnsignedChars(DFA25_minS);
    static final char[] DFA25_max = DFA.unpackEncodedStringToUnsignedChars(DFA25_maxS);
    static final short[] DFA25_accept = DFA.unpackEncodedString(DFA25_acceptS);
    static final short[] DFA25_special = DFA.unpackEncodedString(DFA25_specialS);
    static final short[][] DFA25_transition;

    static {
        int numStates = DFA25_transitionS.length;
        DFA25_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA25_transition[i] = DFA.unpackEncodedString(DFA25_transitionS[i]);
        }
    }

    class DFA25 extends DFA {

        public DFA25(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 25;
            this.eot = DFA25_eot;
            this.eof = DFA25_eof;
            this.min = DFA25_min;
            this.max = DFA25_max;
            this.accept = DFA25_accept;
            this.special = DFA25_special;
            this.transition = DFA25_transition;
        }
        public String getDescription() {
            return "1986:4: ( ruleNL otherlv_8= '=' ruleNL ( (lv_result_10_0= ruleValueOrEnumValueOrOperationCollection ) ) )?";
        }
    }
    static final String DFA26_eotS =
        "\7\uffff";
    static final String DFA26_eofS =
        "\7\uffff";
    static final String DFA26_minS =
        "\2\10\1\uffff\2\10\1\uffff\1\10";
    static final String DFA26_maxS =
        "\2\66\1\uffff\2\66\1\uffff\1\66";
    static final String DFA26_acceptS =
        "\2\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String DFA26_specialS =
        "\7\uffff}>";
    static final String[] DFA26_transitionS = {
            "\1\2\13\uffff\1\1\41\uffff\1\2",
            "\1\2\13\uffff\1\4\1\3\33\uffff\1\5\4\uffff\1\2",
            "",
            "\1\2\13\uffff\1\4\34\uffff\1\5\4\uffff\1\2",
            "\1\2\13\uffff\1\4\1\6\33\uffff\1\5\4\uffff\1\2",
            "",
            "\1\2\13\uffff\1\4\34\uffff\1\5\4\uffff\1\2"
    };

    static final short[] DFA26_eot = DFA.unpackEncodedString(DFA26_eotS);
    static final short[] DFA26_eof = DFA.unpackEncodedString(DFA26_eofS);
    static final char[] DFA26_min = DFA.unpackEncodedStringToUnsignedChars(DFA26_minS);
    static final char[] DFA26_max = DFA.unpackEncodedStringToUnsignedChars(DFA26_maxS);
    static final short[] DFA26_accept = DFA.unpackEncodedString(DFA26_acceptS);
    static final short[] DFA26_special = DFA.unpackEncodedString(DFA26_specialS);
    static final short[][] DFA26_transition;

    static {
        int numStates = DFA26_transitionS.length;
        DFA26_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA26_transition[i] = DFA.unpackEncodedString(DFA26_transitionS[i]);
        }
    }

    class DFA26 extends DFA {

        public DFA26(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 26;
            this.eot = DFA26_eot;
            this.eof = DFA26_eof;
            this.min = DFA26_min;
            this.max = DFA26_max;
            this.accept = DFA26_accept;
            this.special = DFA26_special;
            this.transition = DFA26_transition;
        }
        public String getDescription() {
            return "()* loopback of 2080:2: ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )*";
        }
    }
    static final String DFA30_eotS =
        "\7\uffff";
    static final String DFA30_eofS =
        "\1\uffff\3\4\2\uffff\1\4";
    static final String DFA30_minS =
        "\1\24\3\4\2\uffff\1\4";
    static final String DFA30_maxS =
        "\1\24\3\64\2\uffff\1\64";
    static final String DFA30_acceptS =
        "\4\uffff\1\2\1\1\1\uffff";
    static final String DFA30_specialS =
        "\7\uffff}>";
    static final String[] DFA30_transitionS = {
            "\1\1",
            "\3\4\15\uffff\1\3\1\2\22\uffff\1\4\1\uffff\1\4\1\uffff\1\4"+
            "\1\uffff\1\4\1\uffff\1\4\1\5\1\4\1\uffff\1\4",
            "\3\4\15\uffff\1\3\23\uffff\1\4\1\uffff\1\4\1\uffff\1\4\1\uffff"+
            "\1\4\1\uffff\1\4\1\5\1\4\1\uffff\1\4",
            "\3\4\15\uffff\1\3\1\6\22\uffff\1\4\1\uffff\1\4\1\uffff\1\4"+
            "\1\uffff\1\4\1\uffff\1\4\1\5\1\4\1\uffff\1\4",
            "",
            "",
            "\3\4\15\uffff\1\3\23\uffff\1\4\1\uffff\1\4\1\uffff\1\4\1\uffff"+
            "\1\4\1\uffff\1\4\1\5\1\4\1\uffff\1\4"
    };

    static final short[] DFA30_eot = DFA.unpackEncodedString(DFA30_eotS);
    static final short[] DFA30_eof = DFA.unpackEncodedString(DFA30_eofS);
    static final char[] DFA30_min = DFA.unpackEncodedStringToUnsignedChars(DFA30_minS);
    static final char[] DFA30_max = DFA.unpackEncodedStringToUnsignedChars(DFA30_maxS);
    static final short[] DFA30_accept = DFA.unpackEncodedString(DFA30_acceptS);
    static final short[] DFA30_special = DFA.unpackEncodedString(DFA30_specialS);
    static final short[][] DFA30_transition;

    static {
        int numStates = DFA30_transitionS.length;
        DFA30_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA30_transition[i] = DFA.unpackEncodedString(DFA30_transitionS[i]);
        }
    }

    class DFA30 extends DFA {

        public DFA30(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 30;
            this.eot = DFA30_eot;
            this.eof = DFA30_eof;
            this.min = DFA30_min;
            this.max = DFA30_max;
            this.accept = DFA30_accept;
            this.special = DFA30_special;
            this.transition = DFA30_transition;
        }
        public String getDescription() {
            return "()+ loopback of 2173:3: ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+";
        }
    }
    static final String DFA37_eotS =
        "\12\uffff";
    static final String DFA37_eofS =
        "\2\4\3\uffff\1\4\4\uffff";
    static final String DFA37_minS =
        "\2\4\1\24\1\10\1\uffff\1\4\1\24\1\uffff\2\24";
    static final String DFA37_maxS =
        "\2\66\1\63\1\10\1\uffff\1\66\1\63\1\uffff\2\63";
    static final String DFA37_acceptS =
        "\4\uffff\1\2\2\uffff\1\1\2\uffff";
    static final String DFA37_specialS =
        "\12\uffff}>";
    static final String[] DFA37_transitionS = {
            "\3\4\1\uffff\1\2\13\uffff\1\1\23\uffff\1\4\1\uffff\1\4\1\uffff"+
            "\1\4\1\uffff\1\4\1\uffff\1\4\1\uffff\3\4\1\uffff\1\3",
            "\3\4\1\uffff\1\2\13\uffff\1\1\1\5\22\uffff\1\4\1\uffff\1\4"+
            "\1\uffff\1\4\1\uffff\1\4\1\uffff\1\4\1\uffff\3\4\1\uffff\1\3",
            "\1\6\13\uffff\1\7\22\uffff\1\4",
            "\1\10",
            "",
            "\3\4\1\uffff\1\2\13\uffff\1\1\23\uffff\1\4\1\uffff\1\4\1\uffff"+
            "\1\4\1\uffff\1\4\1\uffff\1\4\1\uffff\3\4\1\uffff\1\3",
            "\1\6\1\11\12\uffff\1\7\22\uffff\1\4",
            "",
            "\1\6\13\uffff\1\7\22\uffff\1\4",
            "\1\6\13\uffff\1\7\22\uffff\1\4"
    };

    static final short[] DFA37_eot = DFA.unpackEncodedString(DFA37_eotS);
    static final short[] DFA37_eof = DFA.unpackEncodedString(DFA37_eofS);
    static final char[] DFA37_min = DFA.unpackEncodedStringToUnsignedChars(DFA37_minS);
    static final char[] DFA37_max = DFA.unpackEncodedStringToUnsignedChars(DFA37_maxS);
    static final short[] DFA37_accept = DFA.unpackEncodedString(DFA37_acceptS);
    static final short[] DFA37_special = DFA.unpackEncodedString(DFA37_specialS);
    static final short[][] DFA37_transition;

    static {
        int numStates = DFA37_transitionS.length;
        DFA37_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA37_transition[i] = DFA.unpackEncodedString(DFA37_transitionS[i]);
        }
    }

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = DFA37_eot;
            this.eof = DFA37_eof;
            this.min = DFA37_min;
            this.max = DFA37_max;
            this.accept = DFA37_accept;
            this.special = DFA37_special;
            this.transition = DFA37_transition;
        }
        public String getDescription() {
            return "()* loopback of 2622:2: ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )*";
        }
    }
    static final String DFA38_eotS =
        "\5\uffff";
    static final String DFA38_eofS =
        "\2\2\2\uffff\1\2";
    static final String DFA38_minS =
        "\2\4\2\uffff\1\4";
    static final String DFA38_maxS =
        "\2\66\2\uffff\1\66";
    static final String DFA38_acceptS =
        "\2\uffff\1\2\1\1\1\uffff";
    static final String DFA38_specialS =
        "\5\uffff}>";
    static final String[] DFA38_transitionS = {
            "\3\2\1\uffff\1\3\13\uffff\1\1\23\uffff\1\2\1\uffff\1\2\1\uffff"+
            "\1\2\1\uffff\1\2\1\uffff\1\2\1\uffff\3\2\1\uffff\1\3",
            "\3\2\1\uffff\1\3\13\uffff\1\1\1\4\22\uffff\1\2\1\uffff\1\2"+
            "\1\uffff\1\2\1\uffff\1\2\1\uffff\1\2\1\uffff\3\2\1\uffff\1\3",
            "",
            "",
            "\3\2\1\uffff\1\3\13\uffff\1\1\23\uffff\1\2\1\uffff\1\2\1\uffff"+
            "\1\2\1\uffff\1\2\1\uffff\1\2\1\uffff\3\2\1\uffff\1\3"
    };

    static final short[] DFA38_eot = DFA.unpackEncodedString(DFA38_eotS);
    static final short[] DFA38_eof = DFA.unpackEncodedString(DFA38_eofS);
    static final char[] DFA38_min = DFA.unpackEncodedStringToUnsignedChars(DFA38_minS);
    static final char[] DFA38_max = DFA.unpackEncodedStringToUnsignedChars(DFA38_maxS);
    static final short[] DFA38_accept = DFA.unpackEncodedString(DFA38_acceptS);
    static final short[] DFA38_special = DFA.unpackEncodedString(DFA38_specialS);
    static final short[][] DFA38_transition;

    static {
        int numStates = DFA38_transitionS.length;
        DFA38_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA38_transition[i] = DFA.unpackEncodedString(DFA38_transitionS[i]);
        }
    }

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = DFA38_eot;
            this.eof = DFA38_eof;
            this.min = DFA38_min;
            this.max = DFA38_max;
            this.accept = DFA38_accept;
            this.special = DFA38_special;
            this.transition = DFA38_transition;
        }
        public String getDescription() {
            return "()* loopback of 2648:4: ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )*";
        }
    }
    static final String DFA39_eotS =
        "\5\uffff";
    static final String DFA39_eofS =
        "\2\3\2\uffff\1\3";
    static final String DFA39_minS =
        "\2\4\2\uffff\1\4";
    static final String DFA39_maxS =
        "\2\64\2\uffff\1\64";
    static final String DFA39_acceptS =
        "\2\uffff\1\1\1\2\1\uffff";
    static final String DFA39_specialS =
        "\5\uffff}>";
    static final String[] DFA39_transitionS = {
            "\3\3\15\uffff\1\1\23\uffff\1\3\1\uffff\1\3\1\uffff\1\3\1\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\3\1\2\1\3",
            "\3\3\15\uffff\1\1\1\4\22\uffff\1\3\1\uffff\1\3\1\uffff\1\3"+
            "\1\uffff\1\3\1\uffff\1\3\1\uffff\1\3\1\2\1\3",
            "",
            "",
            "\3\3\15\uffff\1\1\23\uffff\1\3\1\uffff\1\3\1\uffff\1\3\1\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\3\1\2\1\3"
    };

    static final short[] DFA39_eot = DFA.unpackEncodedString(DFA39_eotS);
    static final short[] DFA39_eof = DFA.unpackEncodedString(DFA39_eofS);
    static final char[] DFA39_min = DFA.unpackEncodedStringToUnsignedChars(DFA39_minS);
    static final char[] DFA39_max = DFA.unpackEncodedStringToUnsignedChars(DFA39_maxS);
    static final short[] DFA39_accept = DFA.unpackEncodedString(DFA39_acceptS);
    static final short[] DFA39_special = DFA.unpackEncodedString(DFA39_specialS);
    static final short[][] DFA39_transition;

    static {
        int numStates = DFA39_transitionS.length;
        DFA39_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA39_transition[i] = DFA.unpackEncodedString(DFA39_transitionS[i]);
        }
    }

    class DFA39 extends DFA {

        public DFA39(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 39;
            this.eot = DFA39_eot;
            this.eof = DFA39_eof;
            this.min = DFA39_min;
            this.max = DFA39_max;
            this.accept = DFA39_accept;
            this.special = DFA39_special;
            this.transition = DFA39_transition;
        }
        public String getDescription() {
            return "2674:4: ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariable ) ) )?";
        }
    }
    static final String DFA46_eotS =
        "\10\uffff";
    static final String DFA46_eofS =
        "\10\uffff";
    static final String DFA46_minS =
        "\1\7\1\uffff\3\10\1\uffff\2\10";
    static final String DFA46_maxS =
        "\1\73\1\uffff\1\77\1\10\1\71\1\uffff\1\77\1\71";
    static final String DFA46_acceptS =
        "\1\uffff\1\1\3\uffff\1\2\2\uffff";
    static final String DFA46_specialS =
        "\10\uffff}>";
    static final String[] DFA46_transitionS = {
            "\1\1\1\2\13\1\43\uffff\1\1\2\uffff\2\1",
            "",
            "\1\1\13\uffff\1\4\6\uffff\1\5\34\uffff\1\5\1\1\5\uffff\1\3",
            "\1\6",
            "\1\1\13\uffff\1\4\1\7\5\uffff\1\5\34\uffff\1\5\1\1",
            "",
            "\1\1\13\uffff\1\4\6\uffff\1\5\34\uffff\1\5\1\1\5\uffff\1\3",
            "\1\1\13\uffff\1\4\6\uffff\1\5\34\uffff\1\5\1\1"
    };

    static final short[] DFA46_eot = DFA.unpackEncodedString(DFA46_eotS);
    static final short[] DFA46_eof = DFA.unpackEncodedString(DFA46_eofS);
    static final char[] DFA46_min = DFA.unpackEncodedStringToUnsignedChars(DFA46_minS);
    static final char[] DFA46_max = DFA.unpackEncodedStringToUnsignedChars(DFA46_maxS);
    static final short[] DFA46_accept = DFA.unpackEncodedString(DFA46_acceptS);
    static final short[] DFA46_special = DFA.unpackEncodedString(DFA46_specialS);
    static final short[][] DFA46_transition;

    static {
        int numStates = DFA46_transitionS.length;
        DFA46_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA46_transition[i] = DFA.unpackEncodedString(DFA46_transitionS[i]);
        }
    }

    class DFA46 extends DFA {

        public DFA46(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 46;
            this.eot = DFA46_eot;
            this.eof = DFA46_eof;
            this.min = DFA46_min;
            this.max = DFA46_max;
            this.accept = DFA46_accept;
            this.special = DFA46_special;
            this.transition = DFA46_transition;
        }
        public String getDescription() {
            return "3276:1: ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )?";
        }
    }
    static final String DFA47_eotS =
        "\5\uffff";
    static final String DFA47_eofS =
        "\5\uffff";
    static final String DFA47_minS =
        "\2\24\2\uffff\1\24";
    static final String DFA47_maxS =
        "\2\70\2\uffff\1\70";
    static final String DFA47_acceptS =
        "\2\uffff\1\1\1\2\1\uffff";
    static final String DFA47_specialS =
        "\5\uffff}>";
    static final String[] DFA47_transitionS = {
            "\1\1\6\uffff\1\2\34\uffff\1\3",
            "\1\1\1\4\5\uffff\1\2\34\uffff\1\3",
            "",
            "",
            "\1\1\6\uffff\1\2\34\uffff\1\3"
    };

    static final short[] DFA47_eot = DFA.unpackEncodedString(DFA47_eotS);
    static final short[] DFA47_eof = DFA.unpackEncodedString(DFA47_eofS);
    static final char[] DFA47_min = DFA.unpackEncodedStringToUnsignedChars(DFA47_minS);
    static final char[] DFA47_max = DFA.unpackEncodedStringToUnsignedChars(DFA47_maxS);
    static final short[] DFA47_accept = DFA.unpackEncodedString(DFA47_acceptS);
    static final short[] DFA47_special = DFA.unpackEncodedString(DFA47_specialS);
    static final short[][] DFA47_transition;

    static {
        int numStates = DFA47_transitionS.length;
        DFA47_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA47_transition[i] = DFA.unpackEncodedString(DFA47_transitionS[i]);
        }
    }

    class DFA47 extends DFA {

        public DFA47(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 47;
            this.eot = DFA47_eot;
            this.eof = DFA47_eof;
            this.min = DFA47_min;
            this.max = DFA47_max;
            this.accept = DFA47_accept;
            this.special = DFA47_special;
            this.transition = DFA47_transition;
        }
        public String getDescription() {
            return "3317:2: ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )?";
        }
    }
    static final String DFA48_eotS =
        "\7\uffff";
    static final String DFA48_eofS =
        "\2\2\2\uffff\3\2";
    static final String DFA48_minS =
        "\2\4\2\uffff\3\4";
    static final String DFA48_maxS =
        "\2\74\2\uffff\3\74";
    static final String DFA48_acceptS =
        "\2\uffff\1\2\1\1\3\uffff";
    static final String DFA48_specialS =
        "\7\uffff}>";
    static final String[] DFA48_transitionS = {
            "\3\2\1\uffff\1\2\13\uffff\1\1\23\uffff\1\2\1\uffff\1\2\1\uffff"+
            "\1\2\1\uffff\7\2\1\uffff\1\2\1\uffff\1\2\1\3\2\uffff\1\2",
            "\3\2\1\uffff\1\2\13\uffff\1\5\1\4\22\uffff\1\2\1\uffff\1\2"+
            "\1\uffff\1\2\1\uffff\7\2\1\uffff\1\2\1\uffff\1\2\1\3\2\uffff"+
            "\1\2",
            "",
            "",
            "\3\2\1\uffff\1\2\13\uffff\1\5\23\uffff\1\2\1\uffff\1\2\1\uffff"+
            "\1\2\1\uffff\7\2\1\uffff\1\2\1\uffff\1\2\1\3\2\uffff\1\2",
            "\3\2\1\uffff\1\2\13\uffff\1\5\1\6\22\uffff\1\2\1\uffff\1\2"+
            "\1\uffff\1\2\1\uffff\7\2\1\uffff\1\2\1\uffff\1\2\1\3\2\uffff"+
            "\1\2",
            "\3\2\1\uffff\1\2\13\uffff\1\5\23\uffff\1\2\1\uffff\1\2\1\uffff"+
            "\1\2\1\uffff\7\2\1\uffff\1\2\1\uffff\1\2\1\3\2\uffff\1\2"
    };

    static final short[] DFA48_eot = DFA.unpackEncodedString(DFA48_eotS);
    static final short[] DFA48_eof = DFA.unpackEncodedString(DFA48_eofS);
    static final char[] DFA48_min = DFA.unpackEncodedStringToUnsignedChars(DFA48_minS);
    static final char[] DFA48_max = DFA.unpackEncodedStringToUnsignedChars(DFA48_maxS);
    static final short[] DFA48_accept = DFA.unpackEncodedString(DFA48_acceptS);
    static final short[] DFA48_special = DFA.unpackEncodedString(DFA48_specialS);
    static final short[][] DFA48_transition;

    static {
        int numStates = DFA48_transitionS.length;
        DFA48_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA48_transition[i] = DFA.unpackEncodedString(DFA48_transitionS[i]);
        }
    }

    class DFA48 extends DFA {

        public DFA48(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 48;
            this.eot = DFA48_eot;
            this.eof = DFA48_eof;
            this.min = DFA48_min;
            this.max = DFA48_max;
            this.accept = DFA48_accept;
            this.special = DFA48_special;
            this.transition = DFA48_transition;
        }
        public String getDescription() {
            return "()* loopback of 3398:2: ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )*";
        }
    }
    static final String DFA51_eotS =
        "\24\uffff";
    static final String DFA51_eofS =
        "\5\uffff\3\13\4\uffff\10\13";
    static final String DFA51_minS =
        "\1\7\4\uffff\3\4\4\uffff\10\4";
    static final String DFA51_maxS =
        "\1\72\4\uffff\3\74\4\uffff\10\74";
    static final String DFA51_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\3\uffff\1\6\1\10\1\7\1\5\10\uffff";
    static final String DFA51_specialS =
        "\24\uffff}>";
    static final String[] DFA51_transitionS = {
            "\1\1\1\uffff\1\2\1\3\2\4\1\5\1\6\1\7\3\10\47\uffff\1\11",
            "",
            "",
            "",
            "",
            "\3\13\1\uffff\1\13\7\uffff\1\12\3\uffff\1\13\5\uffff\1\13"+
            "\1\uffff\3\13\2\uffff\4\13\3\uffff\3\13\1\uffff\13\13\1\uffff"+
            "\2\13\2\uffff\1\13",
            "\3\13\1\uffff\1\13\10\uffff\2\12\1\uffff\1\14\5\uffff\1\13"+
            "\1\uffff\3\13\2\uffff\4\13\3\uffff\3\13\1\uffff\13\13\1\uffff"+
            "\2\13\2\uffff\1\13",
            "\3\13\1\uffff\1\13\11\uffff\1\12\1\uffff\1\15\5\uffff\1\13"+
            "\1\uffff\3\13\2\uffff\4\13\3\uffff\3\13\1\uffff\13\13\1\uffff"+
            "\2\13\2\uffff\1\13",
            "",
            "",
            "",
            "",
            "\3\13\1\uffff\1\13\10\uffff\2\12\1\uffff\1\17\1\16\4\uffff"+
            "\1\13\1\uffff\3\13\2\uffff\4\13\3\uffff\3\13\1\uffff\13\13\1"+
            "\uffff\2\13\2\uffff\1\13",
            "\3\13\1\uffff\1\13\11\uffff\1\12\1\uffff\1\21\1\20\4\uffff"+
            "\1\13\1\uffff\3\13\2\uffff\4\13\3\uffff\3\13\1\uffff\13\13\1"+
            "\uffff\2\13\2\uffff\1\13",
            "\3\13\1\uffff\1\13\10\uffff\2\12\1\uffff\1\17\5\uffff\1\13"+
            "\1\uffff\3\13\2\uffff\4\13\3\uffff\3\13\1\uffff\13\13\1\uffff"+
            "\2\13\2\uffff\1\13",
            "\3\13\1\uffff\1\13\10\uffff\2\12\1\uffff\1\17\1\22\4\uffff"+
            "\1\13\1\uffff\3\13\2\uffff\4\13\3\uffff\3\13\1\uffff\13\13\1"+
            "\uffff\2\13\2\uffff\1\13",
            "\3\13\1\uffff\1\13\11\uffff\1\12\1\uffff\1\21\5\uffff\1\13"+
            "\1\uffff\3\13\2\uffff\4\13\3\uffff\3\13\1\uffff\13\13\1\uffff"+
            "\2\13\2\uffff\1\13",
            "\3\13\1\uffff\1\13\11\uffff\1\12\1\uffff\1\21\1\23\4\uffff"+
            "\1\13\1\uffff\3\13\2\uffff\4\13\3\uffff\3\13\1\uffff\13\13\1"+
            "\uffff\2\13\2\uffff\1\13",
            "\3\13\1\uffff\1\13\10\uffff\2\12\1\uffff\1\17\5\uffff\1\13"+
            "\1\uffff\3\13\2\uffff\4\13\3\uffff\3\13\1\uffff\13\13\1\uffff"+
            "\2\13\2\uffff\1\13",
            "\3\13\1\uffff\1\13\11\uffff\1\12\1\uffff\1\21\5\uffff\1\13"+
            "\1\uffff\3\13\2\uffff\4\13\3\uffff\3\13\1\uffff\13\13\1\uffff"+
            "\2\13\2\uffff\1\13"
    };

    static final short[] DFA51_eot = DFA.unpackEncodedString(DFA51_eotS);
    static final short[] DFA51_eof = DFA.unpackEncodedString(DFA51_eofS);
    static final char[] DFA51_min = DFA.unpackEncodedStringToUnsignedChars(DFA51_minS);
    static final char[] DFA51_max = DFA.unpackEncodedStringToUnsignedChars(DFA51_maxS);
    static final short[] DFA51_accept = DFA.unpackEncodedString(DFA51_acceptS);
    static final short[] DFA51_special = DFA.unpackEncodedString(DFA51_specialS);
    static final short[][] DFA51_transition;

    static {
        int numStates = DFA51_transitionS.length;
        DFA51_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA51_transition[i] = DFA.unpackEncodedString(DFA51_transitionS[i]);
        }
    }

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = DFA51_eot;
            this.eof = DFA51_eof;
            this.min = DFA51_min;
            this.max = DFA51_max;
            this.accept = DFA51_accept;
            this.special = DFA51_special;
            this.transition = DFA51_transition;
        }
        public String getDescription() {
            return "3557:1: (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_BooleanValue_3= ruleBooleanValue | this_DateValue_4= ruleDateValue | this_TimeValue_5= ruleTimeValue | this_DateAndTimeValue_6= ruleDateAndTimeValue | this_NullValue_7= ruleNullValue )";
        }
    }
    static final String DFA55_eotS =
        "\10\uffff";
    static final String DFA55_eofS =
        "\10\uffff";
    static final String DFA55_minS =
        "\1\15\1\uffff\1\21\1\uffff\1\21\2\uffff\1\21";
    static final String DFA55_maxS =
        "\1\17\1\uffff\1\24\1\uffff\1\25\2\uffff\1\24";
    static final String DFA55_acceptS =
        "\1\uffff\1\1\1\uffff\1\4\1\uffff\1\3\1\2\1\uffff";
    static final String DFA55_specialS =
        "\10\uffff}>";
    static final String[] DFA55_transitionS = {
            "\1\1\1\2\1\3",
            "",
            "\1\6\1\5\1\uffff\1\4",
            "",
            "\1\6\1\5\1\uffff\1\4\1\7",
            "",
            "",
            "\1\6\1\5\1\uffff\1\4"
    };

    static final short[] DFA55_eot = DFA.unpackEncodedString(DFA55_eotS);
    static final short[] DFA55_eof = DFA.unpackEncodedString(DFA55_eofS);
    static final char[] DFA55_min = DFA.unpackEncodedStringToUnsignedChars(DFA55_minS);
    static final char[] DFA55_max = DFA.unpackEncodedStringToUnsignedChars(DFA55_maxS);
    static final short[] DFA55_accept = DFA.unpackEncodedString(DFA55_acceptS);
    static final short[] DFA55_special = DFA.unpackEncodedString(DFA55_specialS);
    static final short[][] DFA55_transition;

    static {
        int numStates = DFA55_transitionS.length;
        DFA55_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA55_transition[i] = DFA.unpackEncodedString(DFA55_transitionS[i]);
        }
    }

    class DFA55 extends DFA {

        public DFA55(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 55;
            this.eot = DFA55_eot;
            this.eof = DFA55_eof;
            this.min = DFA55_min;
            this.max = DFA55_max;
            this.accept = DFA55_accept;
            this.special = DFA55_special;
            this.transition = DFA55_transition;
        }
        public String getDescription() {
            return "4165:1: (this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue | this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue | this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue | this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue )";
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNL_in_ruleModel135 = new BitSet(new long[]{0x0000000264000002L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleModel155 = new BitSet(new long[]{0x0000000264000002L});
    public static final BitSet FOLLOW_ruleStatement_in_entryRuleStatement192 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStatement202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleStatement249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDefinition_in_ruleStatement276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForkDefinition_in_ruleStatement303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariantDefinition_in_ruleStatement330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleComment_in_entryRuleVisibleComment365 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVisibleComment375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleSingleLineComment_in_ruleVisibleComment422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleMultiLineComment_in_ruleVisibleComment449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleSingleLineComment_in_entryRuleVisibleSingleLineComment484 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVisibleSingleLineComment494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SL_VISIBLE_COMMENT_in_ruleVisibleSingleLineComment536 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVisibleSingleLineComment557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleMultiLineComment_in_entryRuleVisibleMultiLineComment592 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVisibleMultiLineComment602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ML_VISIBLE_COMMENT_in_ruleVisibleMultiLineComment644 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVisibleMultiLineComment665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleDivider_in_entryRuleVisibleDivider700 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVisibleDivider710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DIVIDER_in_ruleVisibleDivider752 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVisibleDivider773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDefinition_in_entryRulePackageDefinition808 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageDefinition818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rulePackageDefinition855 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_rulePackageDefinition871 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rulePackageDefinition891 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_rulePackageDefinition903 = new BitSet(new long[]{0x0000161E74100000L});
    public static final BitSet FOLLOW_ruleNL_in_rulePackageDefinition919 = new BitSet(new long[]{0x0000161E74000000L});
    public static final BitSet FOLLOW_rulePackageStatement_in_rulePackageDefinition939 = new BitSet(new long[]{0x0000161E74000000L});
    public static final BitSet FOLLOW_28_in_rulePackageDefinition952 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleNL_in_rulePackageDefinition968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageStatement_in_entryRulePackageStatement1003 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageStatement1013 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rulePackageStatement1060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForkDefinition_in_rulePackageStatement1087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariantDefinition_in_rulePackageStatement1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestDefinition_in_rulePackageStatement1141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallDefinition_in_rulePackageStatement1168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationDefinition_in_rulePackageStatement1195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteDefinition_in_rulePackageStatement1222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_rulePackageStatement1249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantDefinition_in_rulePackageStatement1276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport1311 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport1321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleImport1358 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleImport1374 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_ruleImport1394 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleImport1410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForkDefinition_in_entryRuleForkDefinition1445 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleForkDefinition1455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleForkDefinition1492 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleForkDefinition1508 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleForkDefinition1528 = new BitSet(new long[]{0x0000000080100180L});
    public static final BitSet FOLLOW_ruleNL_in_ruleForkDefinition1544 = new BitSet(new long[]{0x0000000080000182L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleForkDefinition1561 = new BitSet(new long[]{0x0000000080100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleForkDefinition1582 = new BitSet(new long[]{0x0000000080000102L});
    public static final BitSet FOLLOW_31_in_ruleForkDefinition1596 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleForkDefinition1612 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleJavaClassReference_in_ruleForkDefinition1632 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleForkDefinition1648 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_ruleForkParameter_in_ruleForkDefinition1671 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleForkDefinition1687 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_ruleForkParameter_in_entryRuleForkParameter1724 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleForkParameter1734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedParameterName_in_ruleForkParameter1780 = new BitSet(new long[]{0x0000000100100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleForkParameter1796 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleForkParameter1807 = new BitSet(new long[]{0x0C800000001FFF80L});
    public static final BitSet FOLLOW_ruleNL_in_ruleForkParameter1823 = new BitSet(new long[]{0x0C800000001FFF80L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperation_in_ruleForkParameter1843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariantDefinition_in_entryRuleVariantDefinition1879 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariantDefinition1889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleVariantDefinition1926 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVariantDefinition1942 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleVariantDefinition1962 = new BitSet(new long[]{0x0000000000100080L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVariantDefinition1978 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVariantDefinition1995 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVariantDefinition2016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestDefinition_in_entryRuleTestDefinition2053 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestDefinition2063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleTestDefinition2100 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleTestDefinition2116 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTestDefinition2136 = new BitSet(new long[]{0x0000000080100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleTestDefinition2152 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleTestDefinition2163 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleTestDefinition2179 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleMethodReference_in_ruleTestDefinition2199 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleTestDefinition2215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallDefinition_in_entryRuleCallDefinition2250 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallDefinition2260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleCallDefinition2297 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleCallDefinition2313 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCallDefinition2333 = new BitSet(new long[]{0x0000000080100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleCallDefinition2349 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleCallDefinition2360 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleCallDefinition2376 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleMethodReference_in_ruleCallDefinition2396 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleCallDefinition2412 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteDefinition_in_entryRuleSuiteDefinition2447 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteDefinition2457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleSuiteDefinition2494 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuiteDefinition2510 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuiteDefinition2530 = new BitSet(new long[]{0x000000E008100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuiteDefinition2546 = new BitSet(new long[]{0x000000E008000000L});
    public static final BitSet FOLLOW_37_in_ruleSuiteDefinition2558 = new BitSet(new long[]{0x000000C008100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuiteDefinition2574 = new BitSet(new long[]{0x000000C008100100L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_ruleSuiteDefinition2595 = new BitSet(new long[]{0x000000C008100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuiteDefinition2611 = new BitSet(new long[]{0x000000C008100100L});
    public static final BitSet FOLLOW_38_in_ruleSuiteDefinition2627 = new BitSet(new long[]{0x0000008008100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuiteDefinition2643 = new BitSet(new long[]{0x0000008008100100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuiteDefinition2666 = new BitSet(new long[]{0x0000008008100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuiteDefinition2682 = new BitSet(new long[]{0x0000008008100100L});
    public static final BitSet FOLLOW_39_in_ruleSuiteDefinition2698 = new BitSet(new long[]{0x0000000008100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuiteDefinition2714 = new BitSet(new long[]{0x0000000008100100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuiteDefinition2737 = new BitSet(new long[]{0x0000000008100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuiteDefinition2753 = new BitSet(new long[]{0x0000000008100100L});
    public static final BitSet FOLLOW_27_in_ruleSuiteDefinition2768 = new BitSet(new long[]{0x0015571E64100070L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuiteDefinition2784 = new BitSet(new long[]{0x0015571E64000070L});
    public static final BitSet FOLLOW_ruleSuiteStatement_in_ruleSuiteDefinition2804 = new BitSet(new long[]{0x0015571E64000070L});
    public static final BitSet FOLLOW_40_in_ruleSuiteDefinition2817 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuiteDefinition2833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationDefinition_in_entryRuleOperationDefinition2868 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperationDefinition2878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleOperationDefinition2915 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleOperationDefinition2931 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleOperationDefinition2951 = new BitSet(new long[]{0x0000000080100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleOperationDefinition2967 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31_in_ruleOperationDefinition2978 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleOperationDefinition2994 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_ruleOperationDefinition3016 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleOperationDefinition3032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteStatement_in_entryRuleSuiteStatement3067 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteStatement3077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteStatementWithResult_in_ruleSuiteStatement3124 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_ruleSuiteStatement3151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantDefinition_in_ruleSuiteStatement3178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleComment_in_ruleSuiteStatement3205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleDivider_in_ruleSuiteStatement3232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteStatementWithResult_in_entryRuleSuiteStatementWithResult3267 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteStatementWithResult3277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_ruleSuiteStatementWithResult3324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTest_in_ruleSuiteStatementWithResult3351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTableTest_in_ruleSuiteStatementWithResult3378 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSuiteStatementWithResult3405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_entryRuleVariableDefinition3440 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDefinition3450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleVariableDefinition3487 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVariableDefinition3503 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_ruleVariableDefinition3523 = new BitSet(new long[]{0x0000080000100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVariableDefinition3539 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleVariableDefinition3551 = new BitSet(new long[]{0x0C0000000017FF80L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVariableDefinition3567 = new BitSet(new long[]{0x0C0000000017FF80L});
    public static final BitSet FOLLOW_ruleValue_in_ruleVariableDefinition3587 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVariableDefinition3603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantDefinition_in_entryRuleConstantDefinition3640 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstantDefinition3650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleConstantDefinition3687 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleConstantDefinition3703 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_ruleConstantDefinition3723 = new BitSet(new long[]{0x040020000017FE80L});
    public static final BitSet FOLLOW_ruleNL_in_ruleConstantDefinition3739 = new BitSet(new long[]{0x040020000007FE82L});
    public static final BitSet FOLLOW_ruleStaticValue_in_ruleConstantDefinition3760 = new BitSet(new long[]{0x0000200000100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleConstantDefinition3776 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_ruleVariantValue_in_ruleConstantDefinition3799 = new BitSet(new long[]{0x0000200000100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleConstantDefinition3815 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_ruleVariantValue_in_entryRuleVariantValue3852 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariantValue3862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleVariantValue3899 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVariantValue3915 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleVariantValue3938 = new BitSet(new long[]{0x0000000100100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVariantValue3954 = new BitSet(new long[]{0x0000000100100100L});
    public static final BitSet FOLLOW_32_in_ruleVariantValue3967 = new BitSet(new long[]{0x040000000017FE80L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVariantValue3983 = new BitSet(new long[]{0x040000000007FE80L});
    public static final BitSet FOLLOW_ruleStaticValue_in_ruleVariantValue4003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_entryRuleVariableEntity4039 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableEntity4049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleVariableEntity4094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTest_in_entryRuleTest4129 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTest4139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleTest4176 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleTest4192 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTest4214 = new BitSet(new long[]{0x0040800000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleTest4231 = new BitSet(new long[]{0x0040000000100100L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleTest4251 = new BitSet(new long[]{0x0040800000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleTest4270 = new BitSet(new long[]{0x0040000000100100L});
    public static final BitSet FOLLOW_ruleNamedResult_in_ruleTest4290 = new BitSet(new long[]{0x0040800000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleTest4309 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleTest4320 = new BitSet(new long[]{0x0C800000001FFF80L});
    public static final BitSet FOLLOW_ruleNL_in_ruleTest4336 = new BitSet(new long[]{0x0C800000001FFF80L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleTest4356 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleTest4374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTableTest_in_entryRuleTableTest4409 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTableTest4419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_ruleTableTest4456 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleTableTest4472 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTableTest4494 = new BitSet(new long[]{0x0040000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleTableTest4511 = new BitSet(new long[]{0x0040000000100100L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleTableTest4531 = new BitSet(new long[]{0x0040000000100100L});
    public static final BitSet FOLLOW_ruleNLFORCED_in_ruleTableTest4549 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ruleParameterTableHeader_in_ruleTableTest4569 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ruleResultTableHeader_in_ruleTableTest4591 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleTableTest4604 = new BitSet(new long[]{0x0040800000100100L});
    public static final BitSet FOLLOW_47_in_ruleTableTest4623 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_49_in_ruleTableTest4648 = new BitSet(new long[]{0x0040000000100100L});
    public static final BitSet FOLLOW_ruleNLFORCED_in_ruleTableTest4667 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_ruleTableTestRow_in_ruleTableTest4687 = new BitSet(new long[]{0x0040000000100100L});
    public static final BitSet FOLLOW_ruleNLFORCED_in_ruleTableTest4705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTableTestRow_in_entryRuleTableTestRow4740 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTableTestRow4750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableValue_in_ruleTableTestRow4805 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableHeader_in_entryRuleParameterTableHeader4842 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterTableHeader4852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleParameterTableHeader4889 = new BitSet(new long[]{0x0040000000100100L});
    public static final BitSet FOLLOW_ruleParameterName_in_ruleParameterTableHeader4910 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_ruleParameterTableHeader4923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultTableHeader_in_entryRuleResultTableHeader4961 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultTableHeader4971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleResultTableHeader5008 = new BitSet(new long[]{0x0040000000100100L});
    public static final BitSet FOLLOW_ruleResultName_in_ruleResultTableHeader5029 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleResultTableHeader5041 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_ruleResultTableHeader5054 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableValue_in_entryRuleParameterTableValue5092 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterTableValue5102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleParameterTableValue5139 = new BitSet(new long[]{0x0C800000001FFF80L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleParameterTableValue5160 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_ruleParameterTableValue5173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedResult_in_entryRuleNamedResult5211 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedResult5221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultName_in_ruleNamedResult5267 = new BitSet(new long[]{0x0000800000100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleNamedResult5283 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleNamedResult5294 = new BitSet(new long[]{0x0C800000001FFF80L});
    public static final BitSet FOLLOW_ruleNL_in_ruleNamedResult5310 = new BitSet(new long[]{0x0C800000001FFF80L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleNamedResult5330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultName_in_entryRuleResultName5366 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultName5376 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedResultName_in_ruleResultName5423 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterOrResultName_in_ruleResultName5450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedResultName_in_entryRuleFixedResultName5485 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFixedResultName5495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFixedResultName5539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_entryRuleCall5574 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCall5584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleCall5621 = new BitSet(new long[]{0x0000000000100300L});
    public static final BitSet FOLLOW_ruleNL_in_ruleCall5637 = new BitSet(new long[]{0x0000000000100300L});
    public static final BitSet FOLLOW_ruleExecutionMultiplier_in_ruleCall5658 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleCall5674 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCall5698 = new BitSet(new long[]{0x0048000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleCall5715 = new BitSet(new long[]{0x0040000000100100L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleCall5735 = new BitSet(new long[]{0x0048000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleCall5754 = new BitSet(new long[]{0x0040000000100100L});
    public static final BitSet FOLLOW_ruleNamedCallResult_in_ruleCall5774 = new BitSet(new long[]{0x0048000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleCall5793 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleCall5804 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleCall5820 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleCall5840 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleCall5858 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedCallResult_in_entryRuleNamedCallResult5893 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedCallResult5903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultName_in_ruleNamedCallResult5949 = new BitSet(new long[]{0x0008000000100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleNamedCallResult5965 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleNamedCallResult5976 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleNamedCallResult5992 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleNamedCallResult6012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_entryRuleSuite6048 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuite6058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleSuite6095 = new BitSet(new long[]{0x0000000000100300L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuite6111 = new BitSet(new long[]{0x0000000000100300L});
    public static final BitSet FOLLOW_ruleExecutionMultiplier_in_ruleSuite6132 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuite6148 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuite6172 = new BitSet(new long[]{0x0020200000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuite6188 = new BitSet(new long[]{0x0020200000100102L});
    public static final BitSet FOLLOW_ruleSuiteParameter_in_ruleSuite6209 = new BitSet(new long[]{0x0020200000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuite6225 = new BitSet(new long[]{0x0020200000100102L});
    public static final BitSet FOLLOW_53_in_ruleSuite6239 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuite6255 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuite6277 = new BitSet(new long[]{0x0000200000100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuite6293 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_45_in_ruleSuite6307 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuite6323 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuite6346 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuite6362 = new BitSet(new long[]{0x0000000000100102L});
    public static final BitSet FOLLOW_ruleSuiteParameter_in_entryRuleSuiteParameter6401 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteParameter6411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuiteParameter6459 = new BitSet(new long[]{0x0000000100100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuiteParameter6475 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleSuiteParameter6486 = new BitSet(new long[]{0x0C0000000017FF80L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuiteParameter6502 = new BitSet(new long[]{0x0C0000000017FF80L});
    public static final BitSet FOLLOW_ruleValue_in_ruleSuiteParameter6522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter6558 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter6568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterName_in_ruleParameter6614 = new BitSet(new long[]{0x0000000100100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleParameter6630 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleParameter6641 = new BitSet(new long[]{0x0C800000001FFF80L});
    public static final BitSet FOLLOW_ruleNL_in_ruleParameter6657 = new BitSet(new long[]{0x0C800000001FFF80L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleParameter6677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterName_in_entryRuleParameterName6713 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterName6723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedParameterName_in_ruleParameterName6770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterOrResultName_in_ruleParameterName6797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedParameterName_in_entryRuleFixedParameterName6832 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFixedParameterName6842 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFixedParameterName6886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterOrResultName_in_entryRuleArbitraryParameterOrResultName6921 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArbitraryParameterOrResultName6931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleArbitraryParameterOrResultName6968 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleArbitraryParameterOrResultName6985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperation_in_entryRuleOperation7026 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperation7036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleOperation7073 = new BitSet(new long[]{0x0C800000001FFF80L});
    public static final BitSet FOLLOW_ruleNL_in_ruleOperation7089 = new BitSet(new long[]{0x0C800000001FFF80L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleOperation7110 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleOperation7126 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleOperation7150 = new BitSet(new long[]{0x0100000008100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleOperation7167 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleOperation7178 = new BitSet(new long[]{0x0C800000001FFF80L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleOperation7199 = new BitSet(new long[]{0x0100000000100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleOperation7217 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_56_in_ruleOperation7228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_entryRuleValueOrEnumValueOrOperationCollection7264 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueOrEnumValueOrOperationCollection7274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperation_in_ruleValueOrEnumValueOrOperationCollection7320 = new BitSet(new long[]{0x0200000000100002L});
    public static final BitSet FOLLOW_ruleNL_in_ruleValueOrEnumValueOrOperationCollection7337 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_57_in_ruleValueOrEnumValueOrOperationCollection7348 = new BitSet(new long[]{0x0C800000001FFF80L});
    public static final BitSet FOLLOW_ruleNL_in_ruleValueOrEnumValueOrOperationCollection7364 = new BitSet(new long[]{0x0C800000001FFF80L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperation_in_ruleValueOrEnumValueOrOperationCollection7384 = new BitSet(new long[]{0x0200000000100002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperation_in_entryRuleValueOrEnumValueOrOperation7422 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueOrEnumValueOrOperation7432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_ruleValueOrEnumValueOrOperation7479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumValue_in_ruleValueOrEnumValueOrOperation7506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperation_in_ruleValueOrEnumValueOrOperation7533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue7568 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue7578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticValue_in_ruleValue7625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleValue7652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNestedObject_in_ruleValue7679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticValue_in_entryRuleStaticValue7714 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStaticValue7724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringValue_in_ruleStaticValue7771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerValue_in_ruleStaticValue7798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalValue_in_ruleStaticValue7825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanValue_in_ruleStaticValue7852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateValue_in_ruleStaticValue7879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeValue_in_ruleStaticValue7906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateAndTimeValue_in_ruleStaticValue7933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullValue_in_ruleStaticValue7960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerValue_in_entryRuleIntegerValue7995 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerValue8005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleIntegerValue8046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalValue_in_entryRuleDecimalValue8086 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalValue8096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DECIMAL_in_ruleDecimalValue8137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringValue_in_entryRuleStringValue8177 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringValue8187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringValue8228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanValue_in_entryRuleBooleanValue8268 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanValue8278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOLEAN_TRUE_in_ruleBooleanValue8321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOLEAN_FALSE_in_ruleBooleanValue8341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateValue_in_entryRuleDateValue8384 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDateValue8394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIsoDateValue_in_ruleDateValue8441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEuropeanDateValue_in_ruleDateValue8468 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUSDateValue_in_ruleDateValue8495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIsoDateValue_in_entryRuleIsoDateValue8530 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIsoDateValue8540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ISODATE_in_ruleIsoDateValue8581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEuropeanDateValue_in_entryRuleEuropeanDateValue8621 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEuropeanDateValue8631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EURODATE_in_ruleEuropeanDateValue8672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUSDateValue_in_entryRuleUSDateValue8712 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUSDateValue8722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_USDATE_in_ruleUSDateValue8763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeValue_in_entryRuleTimeValue8803 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimeValue8813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIsoTimeValue_in_ruleTimeValue8860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimple24HrsTimeValue_in_ruleTimeValue8887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimple12HrsTimeValue_in_ruleTimeValue8914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIsoTimeValue_in_entryRuleIsoTimeValue8949 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIsoTimeValue8959 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ISOTIME_in_ruleIsoTimeValue9000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimple24HrsTimeValue_in_entryRuleSimple24HrsTimeValue9040 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimple24HrsTimeValue9050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TWENTYFOURHRSTIME_in_ruleSimple24HrsTimeValue9091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimple12HrsTimeValue_in_entryRuleSimple12HrsTimeValue9131 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimple12HrsTimeValue9141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TWELVEHRSTIME_in_ruleSimple12HrsTimeValue9182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateAndTimeValue_in_entryRuleDateAndTimeValue9222 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDateAndTimeValue9232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIsoDateAndTimeValue_in_ruleDateAndTimeValue9279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEuropeanDateAnd24HrsTimeValue_in_ruleDateAndTimeValue9306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEuropeanDateAnd12HrsTimeValue_in_ruleDateAndTimeValue9333 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUSDateAnd12HrsTimeValue_in_ruleDateAndTimeValue9360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIsoDateAndTimeValue_in_entryRuleIsoDateAndTimeValue9395 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIsoDateAndTimeValue9405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ISODATE_in_ruleIsoDateAndTimeValue9447 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_RULE_ISOTIME_in_ruleIsoDateAndTimeValue9469 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEuropeanDateAnd24HrsTimeValue_in_entryRuleEuropeanDateAnd24HrsTimeValue9510 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEuropeanDateAnd24HrsTimeValue9520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EURODATE_in_ruleEuropeanDateAnd24HrsTimeValue9562 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleEuropeanDateAnd24HrsTimeValue9583 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_RULE_TWENTYFOURHRSTIME_in_ruleEuropeanDateAnd24HrsTimeValue9599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEuropeanDateAnd12HrsTimeValue_in_entryRuleEuropeanDateAnd12HrsTimeValue9640 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEuropeanDateAnd12HrsTimeValue9650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EURODATE_in_ruleEuropeanDateAnd12HrsTimeValue9692 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleEuropeanDateAnd12HrsTimeValue9713 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_RULE_TWELVEHRSTIME_in_ruleEuropeanDateAnd12HrsTimeValue9729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUSDateAnd12HrsTimeValue_in_entryRuleUSDateAnd12HrsTimeValue9770 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUSDateAnd12HrsTimeValue9780 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_USDATE_in_ruleUSDateAnd12HrsTimeValue9822 = new BitSet(new long[]{0x0000000000140000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleUSDateAnd12HrsTimeValue9843 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_RULE_TWELVEHRSTIME_in_ruleUSDateAnd12HrsTimeValue9859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable9900 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable9910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleVariable9957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullValue_in_entryRuleNullValue9992 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullValue10002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleNullValue10048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumValue_in_entryRuleEnumValue10084 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumValue10094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UPPERCASE_ID_in_ruleEnumValue10138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNestedObject_in_entryRuleNestedObject10173 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNestedObject10183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleNestedObject10220 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleNestedObject10236 = new BitSet(new long[]{0x0000000000100100L});
    public static final BitSet FOLLOW_ruleKeyValuePair_in_ruleNestedObject10257 = new BitSet(new long[]{0x1000000000100100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleNestedObject10273 = new BitSet(new long[]{0x1000000000100100L});
    public static final BitSet FOLLOW_60_in_ruleNestedObject10286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyValuePair_in_entryRuleKeyValuePair10322 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyValuePair10332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKeyValuePair10374 = new BitSet(new long[]{0x0000000100100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleKeyValuePair10395 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_32_in_ruleKeyValuePair10406 = new BitSet(new long[]{0x0C800000001FFF80L});
    public static final BitSet FOLLOW_ruleNL_in_ruleKeyValuePair10422 = new BitSet(new long[]{0x0C800000001FFF80L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleKeyValuePair10442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaClassReference_in_entryRuleJavaClassReference10478 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJavaClassReference10488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_ruleJavaClassReference10535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodReference_in_entryRuleMethodReference10570 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodReference10580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_ruleMethodReference10628 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_ruleMethodReference10640 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMethodReference10660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecutionMultiplier_in_entryRuleExecutionMultiplier10696 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExecutionMultiplier10706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleExecutionMultiplier10748 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_62_in_ruleExecutionMultiplier10765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName10802 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName10813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName10853 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleQualifiedName10872 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName10887 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_entryRuleQualifiedJavaClassName10935 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedJavaClassName10946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedJavaClassName10993 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_63_in_ruleQualifiedJavaClassName11011 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RULE_UPPERCASE_ID_in_ruleQualifiedJavaClassName11026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard11072 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard11083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard11130 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000001L});
    public static final BitSet FOLLOW_64_in_ruleQualifiedNameWithWildcard11149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNL_in_entryRuleNL11192 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNL11203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleNL11243 = new BitSet(new long[]{0x0000000000300002L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleNL11264 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleNLFORCED_in_entryRuleNLFORCED11313 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNLFORCED11324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleNLFORCED11364 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleNLFORCED11385 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleNLFORCED11414 = new BitSet(new long[]{0x0000000000000002L});

}