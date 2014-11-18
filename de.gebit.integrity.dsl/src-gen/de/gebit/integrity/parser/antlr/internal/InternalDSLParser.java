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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SL_VISIBLE_COMMENT", "RULE_SL_VISIBLE_TITLE_COMMENT", "RULE_ML_VISIBLE_COMMENT", "RULE_ML_VISIBLE_TITLE_COMMENT", "RULE_DIVIDER", "RULE_STRING", "RULE_ID", "RULE_INTEGER", "RULE_DECIMAL", "RULE_BOOLEAN_TRUE", "RULE_BOOLEAN_FALSE", "RULE_ISODATE", "RULE_EURODATE", "RULE_USDATE", "RULE_ISOTIME", "RULE_TWENTYFOURHRSTIME", "RULE_TWELVEHRSTIME", "RULE_UPPERCASE_ID", "RULE_NEWLINE", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ISOTIMEZONE", "RULE_ANY_OTHER", "'packagedef'", "'with'", "'packageend'", "'import'", "'forkdef'", "'uses'", "':'", "'variantdef'", "'testdef'", "'calldef'", "'suitedef'", "'gets'", "'requires'", "'concludedby'", "'suiteend'", "'operationdef'", "'private'", "'variable'", "'initially'", "'constant'", "'parameterized'", "'in'", "'test'", "'='", "'tabletest'", "'|'", "'call'", "'->'", "'suite'", "'on'", "'+'", "'('", "'-'", "'*'", "'/'", "'%'", "'..'", "')'", "'['", "']'", "','", "'<'", "'>'", "'null'", "'{'", "'}'", "'#'", "'.'", "'.*'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_ID=10;
    public static final int RULE_SL_VISIBLE_TITLE_COMMENT=5;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__29=29;
    public static final int T__64=64;
    public static final int T__28=28;
    public static final int T__65=65;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int RULE_ANY_OTHER=27;
    public static final int RULE_TWENTYFOURHRSTIME=19;
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
    public static final int RULE_BOOLEAN_FALSE=14;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_UPPERCASE_ID=21;
    public static final int T__59=59;
    public static final int RULE_DIVIDER=8;
    public static final int RULE_DECIMAL=12;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int RULE_NEWLINE=22;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int RULE_ISOTIMEZONE=26;
    public static final int RULE_ISOTIME=18;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_ML_VISIBLE_TITLE_COMMENT=7;
    public static final int RULE_ML_VISIBLE_COMMENT=6;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_USDATE=17;
    public static final int RULE_EURODATE=16;
    public static final int RULE_SL_COMMENT=25;
    public static final int RULE_ML_COMMENT=24;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_BOOLEAN_TRUE=13;
    public static final int RULE_STRING=9;
    public static final int T__32=32;
    public static final int T__71=71;
    public static final int T__33=33;
    public static final int T__72=72;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int RULE_ISODATE=15;
    public static final int T__70=70;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_TWELVEHRSTIME=20;
    public static final int RULE_WS=23;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int RULE_INTEGER=11;

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

                if ( (LA1_0==28||(LA1_0>=31 && LA1_0<=32)||LA1_0==35) ) {
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
            case 31:
                {
                alt2=1;
                }
                break;
            case 28:
                {
                alt2=2;
                }
                break;
            case 32:
                {
                alt2=3;
                }
                break;
            case 35:
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

            if ( ((LA3_0>=RULE_SL_VISIBLE_COMMENT && LA3_0<=RULE_SL_VISIBLE_TITLE_COMMENT)) ) {
                alt3=1;
            }
            else if ( ((LA3_0>=RULE_ML_VISIBLE_COMMENT && LA3_0<=RULE_ML_VISIBLE_TITLE_COMMENT)) ) {
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:229:1: ruleVisibleSingleLineComment returns [EObject current=null] : (this_VisibleSingleLineNormalComment_0= ruleVisibleSingleLineNormalComment | this_VisibleSingleLineTitleComment_1= ruleVisibleSingleLineTitleComment ) ;
    public final EObject ruleVisibleSingleLineComment() throws RecognitionException {
        EObject current = null;

        EObject this_VisibleSingleLineNormalComment_0 = null;

        EObject this_VisibleSingleLineTitleComment_1 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:232:28: ( (this_VisibleSingleLineNormalComment_0= ruleVisibleSingleLineNormalComment | this_VisibleSingleLineTitleComment_1= ruleVisibleSingleLineTitleComment ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:233:1: (this_VisibleSingleLineNormalComment_0= ruleVisibleSingleLineNormalComment | this_VisibleSingleLineTitleComment_1= ruleVisibleSingleLineTitleComment )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:233:1: (this_VisibleSingleLineNormalComment_0= ruleVisibleSingleLineNormalComment | this_VisibleSingleLineTitleComment_1= ruleVisibleSingleLineTitleComment )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_SL_VISIBLE_COMMENT) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_SL_VISIBLE_TITLE_COMMENT) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:234:5: this_VisibleSingleLineNormalComment_0= ruleVisibleSingleLineNormalComment
                    {
                     
                            newCompositeNode(grammarAccess.getVisibleSingleLineCommentAccess().getVisibleSingleLineNormalCommentParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleVisibleSingleLineNormalComment_in_ruleVisibleSingleLineComment541);
                    this_VisibleSingleLineNormalComment_0=ruleVisibleSingleLineNormalComment();

                    state._fsp--;

                     
                            current = this_VisibleSingleLineNormalComment_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:244:5: this_VisibleSingleLineTitleComment_1= ruleVisibleSingleLineTitleComment
                    {
                     
                            newCompositeNode(grammarAccess.getVisibleSingleLineCommentAccess().getVisibleSingleLineTitleCommentParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleVisibleSingleLineTitleComment_in_ruleVisibleSingleLineComment568);
                    this_VisibleSingleLineTitleComment_1=ruleVisibleSingleLineTitleComment();

                    state._fsp--;

                     
                            current = this_VisibleSingleLineTitleComment_1; 
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
    // $ANTLR end "ruleVisibleSingleLineComment"


    // $ANTLR start "entryRuleVisibleSingleLineNormalComment"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:260:1: entryRuleVisibleSingleLineNormalComment returns [EObject current=null] : iv_ruleVisibleSingleLineNormalComment= ruleVisibleSingleLineNormalComment EOF ;
    public final EObject entryRuleVisibleSingleLineNormalComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleSingleLineNormalComment = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:261:2: (iv_ruleVisibleSingleLineNormalComment= ruleVisibleSingleLineNormalComment EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:262:2: iv_ruleVisibleSingleLineNormalComment= ruleVisibleSingleLineNormalComment EOF
            {
             newCompositeNode(grammarAccess.getVisibleSingleLineNormalCommentRule()); 
            pushFollow(FOLLOW_ruleVisibleSingleLineNormalComment_in_entryRuleVisibleSingleLineNormalComment603);
            iv_ruleVisibleSingleLineNormalComment=ruleVisibleSingleLineNormalComment();

            state._fsp--;

             current =iv_ruleVisibleSingleLineNormalComment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVisibleSingleLineNormalComment613); 

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
    // $ANTLR end "entryRuleVisibleSingleLineNormalComment"


    // $ANTLR start "ruleVisibleSingleLineNormalComment"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:269:1: ruleVisibleSingleLineNormalComment returns [EObject current=null] : ( ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) ) ruleNL ) ;
    public final EObject ruleVisibleSingleLineNormalComment() throws RecognitionException {
        EObject current = null;

        Token lv_content_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:272:28: ( ( ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) ) ruleNL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:273:1: ( ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) ) ruleNL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:273:1: ( ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) ) ruleNL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:273:2: ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) ) ruleNL
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:273:2: ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:274:1: (lv_content_0_0= RULE_SL_VISIBLE_COMMENT )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:274:1: (lv_content_0_0= RULE_SL_VISIBLE_COMMENT )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:275:3: lv_content_0_0= RULE_SL_VISIBLE_COMMENT
            {
            lv_content_0_0=(Token)match(input,RULE_SL_VISIBLE_COMMENT,FOLLOW_RULE_SL_VISIBLE_COMMENT_in_ruleVisibleSingleLineNormalComment655); 

            			newLeafNode(lv_content_0_0, grammarAccess.getVisibleSingleLineNormalCommentAccess().getContentSL_VISIBLE_COMMENTTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVisibleSingleLineNormalCommentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"content",
                    		lv_content_0_0, 
                    		"SL_VISIBLE_COMMENT");
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getVisibleSingleLineNormalCommentAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleVisibleSingleLineNormalComment676);
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
    // $ANTLR end "ruleVisibleSingleLineNormalComment"


    // $ANTLR start "entryRuleVisibleSingleLineTitleComment"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:307:1: entryRuleVisibleSingleLineTitleComment returns [EObject current=null] : iv_ruleVisibleSingleLineTitleComment= ruleVisibleSingleLineTitleComment EOF ;
    public final EObject entryRuleVisibleSingleLineTitleComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleSingleLineTitleComment = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:308:2: (iv_ruleVisibleSingleLineTitleComment= ruleVisibleSingleLineTitleComment EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:309:2: iv_ruleVisibleSingleLineTitleComment= ruleVisibleSingleLineTitleComment EOF
            {
             newCompositeNode(grammarAccess.getVisibleSingleLineTitleCommentRule()); 
            pushFollow(FOLLOW_ruleVisibleSingleLineTitleComment_in_entryRuleVisibleSingleLineTitleComment711);
            iv_ruleVisibleSingleLineTitleComment=ruleVisibleSingleLineTitleComment();

            state._fsp--;

             current =iv_ruleVisibleSingleLineTitleComment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVisibleSingleLineTitleComment721); 

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
    // $ANTLR end "entryRuleVisibleSingleLineTitleComment"


    // $ANTLR start "ruleVisibleSingleLineTitleComment"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:316:1: ruleVisibleSingleLineTitleComment returns [EObject current=null] : ( ( (lv_content_0_0= RULE_SL_VISIBLE_TITLE_COMMENT ) ) ruleNL ) ;
    public final EObject ruleVisibleSingleLineTitleComment() throws RecognitionException {
        EObject current = null;

        Token lv_content_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:319:28: ( ( ( (lv_content_0_0= RULE_SL_VISIBLE_TITLE_COMMENT ) ) ruleNL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:320:1: ( ( (lv_content_0_0= RULE_SL_VISIBLE_TITLE_COMMENT ) ) ruleNL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:320:1: ( ( (lv_content_0_0= RULE_SL_VISIBLE_TITLE_COMMENT ) ) ruleNL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:320:2: ( (lv_content_0_0= RULE_SL_VISIBLE_TITLE_COMMENT ) ) ruleNL
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:320:2: ( (lv_content_0_0= RULE_SL_VISIBLE_TITLE_COMMENT ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:321:1: (lv_content_0_0= RULE_SL_VISIBLE_TITLE_COMMENT )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:321:1: (lv_content_0_0= RULE_SL_VISIBLE_TITLE_COMMENT )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:322:3: lv_content_0_0= RULE_SL_VISIBLE_TITLE_COMMENT
            {
            lv_content_0_0=(Token)match(input,RULE_SL_VISIBLE_TITLE_COMMENT,FOLLOW_RULE_SL_VISIBLE_TITLE_COMMENT_in_ruleVisibleSingleLineTitleComment763); 

            			newLeafNode(lv_content_0_0, grammarAccess.getVisibleSingleLineTitleCommentAccess().getContentSL_VISIBLE_TITLE_COMMENTTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVisibleSingleLineTitleCommentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"content",
                    		lv_content_0_0, 
                    		"SL_VISIBLE_TITLE_COMMENT");
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getVisibleSingleLineTitleCommentAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleVisibleSingleLineTitleComment784);
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
    // $ANTLR end "ruleVisibleSingleLineTitleComment"


    // $ANTLR start "entryRuleVisibleMultiLineComment"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:354:1: entryRuleVisibleMultiLineComment returns [EObject current=null] : iv_ruleVisibleMultiLineComment= ruleVisibleMultiLineComment EOF ;
    public final EObject entryRuleVisibleMultiLineComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleMultiLineComment = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:355:2: (iv_ruleVisibleMultiLineComment= ruleVisibleMultiLineComment EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:356:2: iv_ruleVisibleMultiLineComment= ruleVisibleMultiLineComment EOF
            {
             newCompositeNode(grammarAccess.getVisibleMultiLineCommentRule()); 
            pushFollow(FOLLOW_ruleVisibleMultiLineComment_in_entryRuleVisibleMultiLineComment819);
            iv_ruleVisibleMultiLineComment=ruleVisibleMultiLineComment();

            state._fsp--;

             current =iv_ruleVisibleMultiLineComment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVisibleMultiLineComment829); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:363:1: ruleVisibleMultiLineComment returns [EObject current=null] : (this_VisibleMultiLineNormalComment_0= ruleVisibleMultiLineNormalComment | this_VisibleMultiLineTitleComment_1= ruleVisibleMultiLineTitleComment ) ;
    public final EObject ruleVisibleMultiLineComment() throws RecognitionException {
        EObject current = null;

        EObject this_VisibleMultiLineNormalComment_0 = null;

        EObject this_VisibleMultiLineTitleComment_1 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:366:28: ( (this_VisibleMultiLineNormalComment_0= ruleVisibleMultiLineNormalComment | this_VisibleMultiLineTitleComment_1= ruleVisibleMultiLineTitleComment ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:367:1: (this_VisibleMultiLineNormalComment_0= ruleVisibleMultiLineNormalComment | this_VisibleMultiLineTitleComment_1= ruleVisibleMultiLineTitleComment )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:367:1: (this_VisibleMultiLineNormalComment_0= ruleVisibleMultiLineNormalComment | this_VisibleMultiLineTitleComment_1= ruleVisibleMultiLineTitleComment )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ML_VISIBLE_COMMENT) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ML_VISIBLE_TITLE_COMMENT) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:368:5: this_VisibleMultiLineNormalComment_0= ruleVisibleMultiLineNormalComment
                    {
                     
                            newCompositeNode(grammarAccess.getVisibleMultiLineCommentAccess().getVisibleMultiLineNormalCommentParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleVisibleMultiLineNormalComment_in_ruleVisibleMultiLineComment876);
                    this_VisibleMultiLineNormalComment_0=ruleVisibleMultiLineNormalComment();

                    state._fsp--;

                     
                            current = this_VisibleMultiLineNormalComment_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:378:5: this_VisibleMultiLineTitleComment_1= ruleVisibleMultiLineTitleComment
                    {
                     
                            newCompositeNode(grammarAccess.getVisibleMultiLineCommentAccess().getVisibleMultiLineTitleCommentParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleVisibleMultiLineTitleComment_in_ruleVisibleMultiLineComment903);
                    this_VisibleMultiLineTitleComment_1=ruleVisibleMultiLineTitleComment();

                    state._fsp--;

                     
                            current = this_VisibleMultiLineTitleComment_1; 
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
    // $ANTLR end "ruleVisibleMultiLineComment"


    // $ANTLR start "entryRuleVisibleMultiLineNormalComment"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:394:1: entryRuleVisibleMultiLineNormalComment returns [EObject current=null] : iv_ruleVisibleMultiLineNormalComment= ruleVisibleMultiLineNormalComment EOF ;
    public final EObject entryRuleVisibleMultiLineNormalComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleMultiLineNormalComment = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:395:2: (iv_ruleVisibleMultiLineNormalComment= ruleVisibleMultiLineNormalComment EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:396:2: iv_ruleVisibleMultiLineNormalComment= ruleVisibleMultiLineNormalComment EOF
            {
             newCompositeNode(grammarAccess.getVisibleMultiLineNormalCommentRule()); 
            pushFollow(FOLLOW_ruleVisibleMultiLineNormalComment_in_entryRuleVisibleMultiLineNormalComment938);
            iv_ruleVisibleMultiLineNormalComment=ruleVisibleMultiLineNormalComment();

            state._fsp--;

             current =iv_ruleVisibleMultiLineNormalComment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVisibleMultiLineNormalComment948); 

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
    // $ANTLR end "entryRuleVisibleMultiLineNormalComment"


    // $ANTLR start "ruleVisibleMultiLineNormalComment"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:403:1: ruleVisibleMultiLineNormalComment returns [EObject current=null] : ( ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) ) ruleNL ) ;
    public final EObject ruleVisibleMultiLineNormalComment() throws RecognitionException {
        EObject current = null;

        Token lv_content_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:406:28: ( ( ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) ) ruleNL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:407:1: ( ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) ) ruleNL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:407:1: ( ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) ) ruleNL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:407:2: ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) ) ruleNL
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:407:2: ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:408:1: (lv_content_0_0= RULE_ML_VISIBLE_COMMENT )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:408:1: (lv_content_0_0= RULE_ML_VISIBLE_COMMENT )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:409:3: lv_content_0_0= RULE_ML_VISIBLE_COMMENT
            {
            lv_content_0_0=(Token)match(input,RULE_ML_VISIBLE_COMMENT,FOLLOW_RULE_ML_VISIBLE_COMMENT_in_ruleVisibleMultiLineNormalComment990); 

            			newLeafNode(lv_content_0_0, grammarAccess.getVisibleMultiLineNormalCommentAccess().getContentML_VISIBLE_COMMENTTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVisibleMultiLineNormalCommentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"content",
                    		lv_content_0_0, 
                    		"ML_VISIBLE_COMMENT");
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getVisibleMultiLineNormalCommentAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleVisibleMultiLineNormalComment1011);
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
    // $ANTLR end "ruleVisibleMultiLineNormalComment"


    // $ANTLR start "entryRuleVisibleMultiLineTitleComment"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:441:1: entryRuleVisibleMultiLineTitleComment returns [EObject current=null] : iv_ruleVisibleMultiLineTitleComment= ruleVisibleMultiLineTitleComment EOF ;
    public final EObject entryRuleVisibleMultiLineTitleComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleMultiLineTitleComment = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:442:2: (iv_ruleVisibleMultiLineTitleComment= ruleVisibleMultiLineTitleComment EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:443:2: iv_ruleVisibleMultiLineTitleComment= ruleVisibleMultiLineTitleComment EOF
            {
             newCompositeNode(grammarAccess.getVisibleMultiLineTitleCommentRule()); 
            pushFollow(FOLLOW_ruleVisibleMultiLineTitleComment_in_entryRuleVisibleMultiLineTitleComment1046);
            iv_ruleVisibleMultiLineTitleComment=ruleVisibleMultiLineTitleComment();

            state._fsp--;

             current =iv_ruleVisibleMultiLineTitleComment; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVisibleMultiLineTitleComment1056); 

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
    // $ANTLR end "entryRuleVisibleMultiLineTitleComment"


    // $ANTLR start "ruleVisibleMultiLineTitleComment"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:450:1: ruleVisibleMultiLineTitleComment returns [EObject current=null] : ( ( (lv_content_0_0= RULE_ML_VISIBLE_TITLE_COMMENT ) ) ruleNL ) ;
    public final EObject ruleVisibleMultiLineTitleComment() throws RecognitionException {
        EObject current = null;

        Token lv_content_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:453:28: ( ( ( (lv_content_0_0= RULE_ML_VISIBLE_TITLE_COMMENT ) ) ruleNL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:454:1: ( ( (lv_content_0_0= RULE_ML_VISIBLE_TITLE_COMMENT ) ) ruleNL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:454:1: ( ( (lv_content_0_0= RULE_ML_VISIBLE_TITLE_COMMENT ) ) ruleNL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:454:2: ( (lv_content_0_0= RULE_ML_VISIBLE_TITLE_COMMENT ) ) ruleNL
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:454:2: ( (lv_content_0_0= RULE_ML_VISIBLE_TITLE_COMMENT ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:455:1: (lv_content_0_0= RULE_ML_VISIBLE_TITLE_COMMENT )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:455:1: (lv_content_0_0= RULE_ML_VISIBLE_TITLE_COMMENT )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:456:3: lv_content_0_0= RULE_ML_VISIBLE_TITLE_COMMENT
            {
            lv_content_0_0=(Token)match(input,RULE_ML_VISIBLE_TITLE_COMMENT,FOLLOW_RULE_ML_VISIBLE_TITLE_COMMENT_in_ruleVisibleMultiLineTitleComment1098); 

            			newLeafNode(lv_content_0_0, grammarAccess.getVisibleMultiLineTitleCommentAccess().getContentML_VISIBLE_TITLE_COMMENTTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVisibleMultiLineTitleCommentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"content",
                    		lv_content_0_0, 
                    		"ML_VISIBLE_TITLE_COMMENT");
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getVisibleMultiLineTitleCommentAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleVisibleMultiLineTitleComment1119);
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
    // $ANTLR end "ruleVisibleMultiLineTitleComment"


    // $ANTLR start "entryRuleVisibleDivider"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:488:1: entryRuleVisibleDivider returns [EObject current=null] : iv_ruleVisibleDivider= ruleVisibleDivider EOF ;
    public final EObject entryRuleVisibleDivider() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleDivider = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:489:2: (iv_ruleVisibleDivider= ruleVisibleDivider EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:490:2: iv_ruleVisibleDivider= ruleVisibleDivider EOF
            {
             newCompositeNode(grammarAccess.getVisibleDividerRule()); 
            pushFollow(FOLLOW_ruleVisibleDivider_in_entryRuleVisibleDivider1154);
            iv_ruleVisibleDivider=ruleVisibleDivider();

            state._fsp--;

             current =iv_ruleVisibleDivider; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVisibleDivider1164); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:497:1: ruleVisibleDivider returns [EObject current=null] : ( ( (lv_content_0_0= RULE_DIVIDER ) ) ruleNL ) ;
    public final EObject ruleVisibleDivider() throws RecognitionException {
        EObject current = null;

        Token lv_content_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:500:28: ( ( ( (lv_content_0_0= RULE_DIVIDER ) ) ruleNL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:501:1: ( ( (lv_content_0_0= RULE_DIVIDER ) ) ruleNL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:501:1: ( ( (lv_content_0_0= RULE_DIVIDER ) ) ruleNL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:501:2: ( (lv_content_0_0= RULE_DIVIDER ) ) ruleNL
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:501:2: ( (lv_content_0_0= RULE_DIVIDER ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:502:1: (lv_content_0_0= RULE_DIVIDER )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:502:1: (lv_content_0_0= RULE_DIVIDER )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:503:3: lv_content_0_0= RULE_DIVIDER
            {
            lv_content_0_0=(Token)match(input,RULE_DIVIDER,FOLLOW_RULE_DIVIDER_in_ruleVisibleDivider1206); 

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
                
            pushFollow(FOLLOW_ruleNL_in_ruleVisibleDivider1227);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:535:1: entryRulePackageDefinition returns [EObject current=null] : iv_rulePackageDefinition= rulePackageDefinition EOF ;
    public final EObject entryRulePackageDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:536:2: (iv_rulePackageDefinition= rulePackageDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:537:2: iv_rulePackageDefinition= rulePackageDefinition EOF
            {
             newCompositeNode(grammarAccess.getPackageDefinitionRule()); 
            pushFollow(FOLLOW_rulePackageDefinition_in_entryRulePackageDefinition1262);
            iv_rulePackageDefinition=rulePackageDefinition();

            state._fsp--;

             current =iv_rulePackageDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePackageDefinition1272); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:544:1: rulePackageDefinition returns [EObject current=null] : (otherlv_0= 'packagedef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= 'with' ruleNL ( (lv_statements_5_0= rulePackageStatement ) )* otherlv_6= 'packageend' ruleNL ) ;
    public final EObject rulePackageDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_statements_5_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:547:28: ( (otherlv_0= 'packagedef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= 'with' ruleNL ( (lv_statements_5_0= rulePackageStatement ) )* otherlv_6= 'packageend' ruleNL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:548:1: (otherlv_0= 'packagedef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= 'with' ruleNL ( (lv_statements_5_0= rulePackageStatement ) )* otherlv_6= 'packageend' ruleNL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:548:1: (otherlv_0= 'packagedef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= 'with' ruleNL ( (lv_statements_5_0= rulePackageStatement ) )* otherlv_6= 'packageend' ruleNL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:548:3: otherlv_0= 'packagedef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= 'with' ruleNL ( (lv_statements_5_0= rulePackageStatement ) )* otherlv_6= 'packageend' ruleNL
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_rulePackageDefinition1309); 

                	newLeafNode(otherlv_0, grammarAccess.getPackageDefinitionAccess().getPackagedefKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getPackageDefinitionAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_rulePackageDefinition1325);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:560:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:561:1: (lv_name_2_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:561:1: (lv_name_2_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:562:3: lv_name_2_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getPackageDefinitionAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_rulePackageDefinition1345);
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

            otherlv_3=(Token)match(input,29,FOLLOW_29_in_rulePackageDefinition1357); 

                	newLeafNode(otherlv_3, grammarAccess.getPackageDefinitionAccess().getWithKeyword_3());
                
             
                    newCompositeNode(grammarAccess.getPackageDefinitionAccess().getNLParserRuleCall_4()); 
                
            pushFollow(FOLLOW_ruleNL_in_rulePackageDefinition1373);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:590:1: ( (lv_statements_5_0= rulePackageStatement ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=31 && LA6_0<=32)||(LA6_0>=35 && LA6_0<=38)||(LA6_0>=43 && LA6_0<=45)||LA6_0==47) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:591:1: (lv_statements_5_0= rulePackageStatement )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:591:1: (lv_statements_5_0= rulePackageStatement )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:592:3: lv_statements_5_0= rulePackageStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPackageDefinitionAccess().getStatementsPackageStatementParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_rulePackageStatement_in_rulePackageDefinition1393);
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
            	    break loop6;
                }
            } while (true);

            otherlv_6=(Token)match(input,30,FOLLOW_30_in_rulePackageDefinition1406); 

                	newLeafNode(otherlv_6, grammarAccess.getPackageDefinitionAccess().getPackageendKeyword_6());
                
             
                    newCompositeNode(grammarAccess.getPackageDefinitionAccess().getNLParserRuleCall_7()); 
                
            pushFollow(FOLLOW_ruleNL_in_rulePackageDefinition1422);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:628:1: entryRulePackageStatement returns [EObject current=null] : iv_rulePackageStatement= rulePackageStatement EOF ;
    public final EObject entryRulePackageStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageStatement = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:629:2: (iv_rulePackageStatement= rulePackageStatement EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:630:2: iv_rulePackageStatement= rulePackageStatement EOF
            {
             newCompositeNode(grammarAccess.getPackageStatementRule()); 
            pushFollow(FOLLOW_rulePackageStatement_in_entryRulePackageStatement1457);
            iv_rulePackageStatement=rulePackageStatement();

            state._fsp--;

             current =iv_rulePackageStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePackageStatement1467); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:637:1: rulePackageStatement returns [EObject current=null] : (this_Import_0= ruleImport | this_ForkDefinition_1= ruleForkDefinition | this_VariantDefinition_2= ruleVariantDefinition | this_TestDefinition_3= ruleTestDefinition | this_CallDefinition_4= ruleCallDefinition | this_OperationDefinition_5= ruleOperationDefinition | this_SuiteDefinition_6= ruleSuiteDefinition | this_VariableDefinition_7= ruleVariableDefinition | this_ConstantDefinition_8= ruleConstantDefinition ) ;
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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:640:28: ( (this_Import_0= ruleImport | this_ForkDefinition_1= ruleForkDefinition | this_VariantDefinition_2= ruleVariantDefinition | this_TestDefinition_3= ruleTestDefinition | this_CallDefinition_4= ruleCallDefinition | this_OperationDefinition_5= ruleOperationDefinition | this_SuiteDefinition_6= ruleSuiteDefinition | this_VariableDefinition_7= ruleVariableDefinition | this_ConstantDefinition_8= ruleConstantDefinition ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:641:1: (this_Import_0= ruleImport | this_ForkDefinition_1= ruleForkDefinition | this_VariantDefinition_2= ruleVariantDefinition | this_TestDefinition_3= ruleTestDefinition | this_CallDefinition_4= ruleCallDefinition | this_OperationDefinition_5= ruleOperationDefinition | this_SuiteDefinition_6= ruleSuiteDefinition | this_VariableDefinition_7= ruleVariableDefinition | this_ConstantDefinition_8= ruleConstantDefinition )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:641:1: (this_Import_0= ruleImport | this_ForkDefinition_1= ruleForkDefinition | this_VariantDefinition_2= ruleVariantDefinition | this_TestDefinition_3= ruleTestDefinition | this_CallDefinition_4= ruleCallDefinition | this_OperationDefinition_5= ruleOperationDefinition | this_SuiteDefinition_6= ruleSuiteDefinition | this_VariableDefinition_7= ruleVariableDefinition | this_ConstantDefinition_8= ruleConstantDefinition )
            int alt7=9;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:642:5: this_Import_0= ruleImport
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getImportParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleImport_in_rulePackageStatement1514);
                    this_Import_0=ruleImport();

                    state._fsp--;

                     
                            current = this_Import_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:652:5: this_ForkDefinition_1= ruleForkDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getForkDefinitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleForkDefinition_in_rulePackageStatement1541);
                    this_ForkDefinition_1=ruleForkDefinition();

                    state._fsp--;

                     
                            current = this_ForkDefinition_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:662:5: this_VariantDefinition_2= ruleVariantDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getVariantDefinitionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleVariantDefinition_in_rulePackageStatement1568);
                    this_VariantDefinition_2=ruleVariantDefinition();

                    state._fsp--;

                     
                            current = this_VariantDefinition_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:672:5: this_TestDefinition_3= ruleTestDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getTestDefinitionParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleTestDefinition_in_rulePackageStatement1595);
                    this_TestDefinition_3=ruleTestDefinition();

                    state._fsp--;

                     
                            current = this_TestDefinition_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:682:5: this_CallDefinition_4= ruleCallDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getCallDefinitionParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleCallDefinition_in_rulePackageStatement1622);
                    this_CallDefinition_4=ruleCallDefinition();

                    state._fsp--;

                     
                            current = this_CallDefinition_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:692:5: this_OperationDefinition_5= ruleOperationDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getOperationDefinitionParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleOperationDefinition_in_rulePackageStatement1649);
                    this_OperationDefinition_5=ruleOperationDefinition();

                    state._fsp--;

                     
                            current = this_OperationDefinition_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:702:5: this_SuiteDefinition_6= ruleSuiteDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getSuiteDefinitionParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleSuiteDefinition_in_rulePackageStatement1676);
                    this_SuiteDefinition_6=ruleSuiteDefinition();

                    state._fsp--;

                     
                            current = this_SuiteDefinition_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:712:5: this_VariableDefinition_7= ruleVariableDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getVariableDefinitionParserRuleCall_7()); 
                        
                    pushFollow(FOLLOW_ruleVariableDefinition_in_rulePackageStatement1703);
                    this_VariableDefinition_7=ruleVariableDefinition();

                    state._fsp--;

                     
                            current = this_VariableDefinition_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:722:5: this_ConstantDefinition_8= ruleConstantDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getConstantDefinitionParserRuleCall_8()); 
                        
                    pushFollow(FOLLOW_ruleConstantDefinition_in_rulePackageStatement1730);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:738:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:739:2: (iv_ruleImport= ruleImport EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:740:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport1765);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport1775); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:747:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ruleNL ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) ) ruleNL ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:750:28: ( (otherlv_0= 'import' ruleNL ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) ) ruleNL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:751:1: (otherlv_0= 'import' ruleNL ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) ) ruleNL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:751:1: (otherlv_0= 'import' ruleNL ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) ) ruleNL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:751:3: otherlv_0= 'import' ruleNL ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) ) ruleNL
            {
            otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleImport1812); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getImportAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleImport1828);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:763:1: ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:764:1: (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:764:1: (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:765:3: lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard
            {
             
            	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_ruleImport1848);
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
                
            pushFollow(FOLLOW_ruleNL_in_ruleImport1864);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:797:1: entryRuleForkDefinition returns [EObject current=null] : iv_ruleForkDefinition= ruleForkDefinition EOF ;
    public final EObject entryRuleForkDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForkDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:798:2: (iv_ruleForkDefinition= ruleForkDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:799:2: iv_ruleForkDefinition= ruleForkDefinition EOF
            {
             newCompositeNode(grammarAccess.getForkDefinitionRule()); 
            pushFollow(FOLLOW_ruleForkDefinition_in_entryRuleForkDefinition1899);
            iv_ruleForkDefinition=ruleForkDefinition();

            state._fsp--;

             current =iv_ruleForkDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleForkDefinition1909); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:806:1: ruleForkDefinition returns [EObject current=null] : (otherlv_0= 'forkdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )? (otherlv_6= 'uses' ruleNL ( (lv_forkerClass_8_0= ruleJavaClassReference ) ) ruleNL )? ( ( (lv_parameters_10_0= ruleForkParameter ) ) ruleNL )* ) ;
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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:809:28: ( (otherlv_0= 'forkdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )? (otherlv_6= 'uses' ruleNL ( (lv_forkerClass_8_0= ruleJavaClassReference ) ) ruleNL )? ( ( (lv_parameters_10_0= ruleForkParameter ) ) ruleNL )* ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:810:1: (otherlv_0= 'forkdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )? (otherlv_6= 'uses' ruleNL ( (lv_forkerClass_8_0= ruleJavaClassReference ) ) ruleNL )? ( ( (lv_parameters_10_0= ruleForkParameter ) ) ruleNL )* )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:810:1: (otherlv_0= 'forkdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )? (otherlv_6= 'uses' ruleNL ( (lv_forkerClass_8_0= ruleJavaClassReference ) ) ruleNL )? ( ( (lv_parameters_10_0= ruleForkParameter ) ) ruleNL )* )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:810:3: otherlv_0= 'forkdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )? (otherlv_6= 'uses' ruleNL ( (lv_forkerClass_8_0= ruleJavaClassReference ) ) ruleNL )? ( ( (lv_parameters_10_0= ruleForkParameter ) ) ruleNL )*
            {
            otherlv_0=(Token)match(input,32,FOLLOW_32_in_ruleForkDefinition1946); 

                	newLeafNode(otherlv_0, grammarAccess.getForkDefinitionAccess().getForkdefKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getForkDefinitionAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleForkDefinition1962);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:822:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:823:1: (lv_name_2_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:823:1: (lv_name_2_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:824:3: lv_name_2_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getForkDefinitionAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleForkDefinition1982);
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
                
            pushFollow(FOLLOW_ruleNL_in_ruleForkDefinition1998);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:848:1: ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_STRING) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:848:2: ( (lv_description_4_0= RULE_STRING ) ) ruleNL
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:848:2: ( (lv_description_4_0= RULE_STRING ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:849:1: (lv_description_4_0= RULE_STRING )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:849:1: (lv_description_4_0= RULE_STRING )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:850:3: lv_description_4_0= RULE_STRING
                    {
                    lv_description_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleForkDefinition2015); 

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
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleForkDefinition2036);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:874:3: (otherlv_6= 'uses' ruleNL ( (lv_forkerClass_8_0= ruleJavaClassReference ) ) ruleNL )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==33) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:874:5: otherlv_6= 'uses' ruleNL ( (lv_forkerClass_8_0= ruleJavaClassReference ) ) ruleNL
                    {
                    otherlv_6=(Token)match(input,33,FOLLOW_33_in_ruleForkDefinition2050); 

                        	newLeafNode(otherlv_6, grammarAccess.getForkDefinitionAccess().getUsesKeyword_5_0());
                        
                     
                            newCompositeNode(grammarAccess.getForkDefinitionAccess().getNLParserRuleCall_5_1()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleForkDefinition2066);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:886:1: ( (lv_forkerClass_8_0= ruleJavaClassReference ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:887:1: (lv_forkerClass_8_0= ruleJavaClassReference )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:887:1: (lv_forkerClass_8_0= ruleJavaClassReference )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:888:3: lv_forkerClass_8_0= ruleJavaClassReference
                    {
                     
                    	        newCompositeNode(grammarAccess.getForkDefinitionAccess().getForkerClassJavaClassReferenceParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleJavaClassReference_in_ruleForkDefinition2086);
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
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleForkDefinition2102);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:912:3: ( ( (lv_parameters_10_0= ruleForkParameter ) ) ruleNL )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_ID) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:912:4: ( (lv_parameters_10_0= ruleForkParameter ) ) ruleNL
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:912:4: ( (lv_parameters_10_0= ruleForkParameter ) )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:913:1: (lv_parameters_10_0= ruleForkParameter )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:913:1: (lv_parameters_10_0= ruleForkParameter )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:914:3: lv_parameters_10_0= ruleForkParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getForkDefinitionAccess().getParametersForkParameterParserRuleCall_6_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleForkParameter_in_ruleForkDefinition2125);
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
            	        
            	    pushFollow(FOLLOW_ruleNL_in_ruleForkDefinition2141);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:946:1: entryRuleForkParameter returns [EObject current=null] : iv_ruleForkParameter= ruleForkParameter EOF ;
    public final EObject entryRuleForkParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForkParameter = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:947:2: (iv_ruleForkParameter= ruleForkParameter EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:948:2: iv_ruleForkParameter= ruleForkParameter EOF
            {
             newCompositeNode(grammarAccess.getForkParameterRule()); 
            pushFollow(FOLLOW_ruleForkParameter_in_entryRuleForkParameter2178);
            iv_ruleForkParameter=ruleForkParameter();

            state._fsp--;

             current =iv_ruleForkParameter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleForkParameter2188); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:955:1: ruleForkParameter returns [EObject current=null] : ( ( (lv_name_0_0= ruleFixedParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) ) ) ;
    public final EObject ruleForkParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:958:28: ( ( ( (lv_name_0_0= ruleFixedParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:959:1: ( ( (lv_name_0_0= ruleFixedParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:959:1: ( ( (lv_name_0_0= ruleFixedParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:959:2: ( (lv_name_0_0= ruleFixedParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:959:2: ( (lv_name_0_0= ruleFixedParameterName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:960:1: (lv_name_0_0= ruleFixedParameterName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:960:1: (lv_name_0_0= ruleFixedParameterName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:961:3: lv_name_0_0= ruleFixedParameterName
            {
             
            	        newCompositeNode(grammarAccess.getForkParameterAccess().getNameFixedParameterNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleFixedParameterName_in_ruleForkParameter2234);
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
                
            pushFollow(FOLLOW_ruleNL_in_ruleForkParameter2250);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleForkParameter2261); 

                	newLeafNode(otherlv_2, grammarAccess.getForkParameterAccess().getColonKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getForkParameterAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleForkParameter2277);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:997:1: ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:998:1: (lv_value_4_0= ruleValueOrEnumValueOrOperation )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:998:1: (lv_value_4_0= ruleValueOrEnumValueOrOperation )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:999:3: lv_value_4_0= ruleValueOrEnumValueOrOperation
            {
             
            	        newCompositeNode(grammarAccess.getForkParameterAccess().getValueValueOrEnumValueOrOperationParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleValueOrEnumValueOrOperation_in_ruleForkParameter2297);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1023:1: entryRuleVariantDefinition returns [EObject current=null] : iv_ruleVariantDefinition= ruleVariantDefinition EOF ;
    public final EObject entryRuleVariantDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariantDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1024:2: (iv_ruleVariantDefinition= ruleVariantDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1025:2: iv_ruleVariantDefinition= ruleVariantDefinition EOF
            {
             newCompositeNode(grammarAccess.getVariantDefinitionRule()); 
            pushFollow(FOLLOW_ruleVariantDefinition_in_entryRuleVariantDefinition2333);
            iv_ruleVariantDefinition=ruleVariantDefinition();

            state._fsp--;

             current =iv_ruleVariantDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariantDefinition2343); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1032:1: ruleVariantDefinition returns [EObject current=null] : (otherlv_0= 'variantdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )? ) ;
    public final EObject ruleVariantDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_description_4_0=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1035:28: ( (otherlv_0= 'variantdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1036:1: (otherlv_0= 'variantdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1036:1: (otherlv_0= 'variantdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )? )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1036:3: otherlv_0= 'variantdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )?
            {
            otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleVariantDefinition2380); 

                	newLeafNode(otherlv_0, grammarAccess.getVariantDefinitionAccess().getVariantdefKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getVariantDefinitionAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleVariantDefinition2396);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1048:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1049:1: (lv_name_2_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1049:1: (lv_name_2_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1050:3: lv_name_2_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getVariantDefinitionAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleVariantDefinition2416);
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
                
            pushFollow(FOLLOW_ruleNL_in_ruleVariantDefinition2432);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1074:1: ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_STRING) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1074:2: ( (lv_description_4_0= RULE_STRING ) ) ruleNL
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1074:2: ( (lv_description_4_0= RULE_STRING ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1075:1: (lv_description_4_0= RULE_STRING )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1075:1: (lv_description_4_0= RULE_STRING )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1076:3: lv_description_4_0= RULE_STRING
                    {
                    lv_description_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVariantDefinition2449); 

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
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleVariantDefinition2470);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1108:1: entryRuleTestDefinition returns [EObject current=null] : iv_ruleTestDefinition= ruleTestDefinition EOF ;
    public final EObject entryRuleTestDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1109:2: (iv_ruleTestDefinition= ruleTestDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1110:2: iv_ruleTestDefinition= ruleTestDefinition EOF
            {
             newCompositeNode(grammarAccess.getTestDefinitionRule()); 
            pushFollow(FOLLOW_ruleTestDefinition_in_entryRuleTestDefinition2507);
            iv_ruleTestDefinition=ruleTestDefinition();

            state._fsp--;

             current =iv_ruleTestDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTestDefinition2517); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1117:1: ruleTestDefinition returns [EObject current=null] : (otherlv_0= 'testdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL ) ;
    public final EObject ruleTestDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_fixtureMethod_6_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1120:28: ( (otherlv_0= 'testdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1121:1: (otherlv_0= 'testdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1121:1: (otherlv_0= 'testdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1121:3: otherlv_0= 'testdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL
            {
            otherlv_0=(Token)match(input,36,FOLLOW_36_in_ruleTestDefinition2554); 

                	newLeafNode(otherlv_0, grammarAccess.getTestDefinitionAccess().getTestdefKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getTestDefinitionAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleTestDefinition2570);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1133:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1134:1: (lv_name_2_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1134:1: (lv_name_2_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1135:3: lv_name_2_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getTestDefinitionAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleTestDefinition2590);
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
                
            pushFollow(FOLLOW_ruleNL_in_ruleTestDefinition2606);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleTestDefinition2617); 

                	newLeafNode(otherlv_4, grammarAccess.getTestDefinitionAccess().getUsesKeyword_4());
                
             
                    newCompositeNode(grammarAccess.getTestDefinitionAccess().getNLParserRuleCall_5()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleTestDefinition2633);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1171:1: ( (lv_fixtureMethod_6_0= ruleMethodReference ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1172:1: (lv_fixtureMethod_6_0= ruleMethodReference )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1172:1: (lv_fixtureMethod_6_0= ruleMethodReference )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1173:3: lv_fixtureMethod_6_0= ruleMethodReference
            {
             
            	        newCompositeNode(grammarAccess.getTestDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleMethodReference_in_ruleTestDefinition2653);
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
                
            pushFollow(FOLLOW_ruleNL_in_ruleTestDefinition2669);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1205:1: entryRuleCallDefinition returns [EObject current=null] : iv_ruleCallDefinition= ruleCallDefinition EOF ;
    public final EObject entryRuleCallDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1206:2: (iv_ruleCallDefinition= ruleCallDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1207:2: iv_ruleCallDefinition= ruleCallDefinition EOF
            {
             newCompositeNode(grammarAccess.getCallDefinitionRule()); 
            pushFollow(FOLLOW_ruleCallDefinition_in_entryRuleCallDefinition2704);
            iv_ruleCallDefinition=ruleCallDefinition();

            state._fsp--;

             current =iv_ruleCallDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCallDefinition2714); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1214:1: ruleCallDefinition returns [EObject current=null] : (otherlv_0= 'calldef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL ) ;
    public final EObject ruleCallDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_fixtureMethod_6_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1217:28: ( (otherlv_0= 'calldef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1218:1: (otherlv_0= 'calldef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1218:1: (otherlv_0= 'calldef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1218:3: otherlv_0= 'calldef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL
            {
            otherlv_0=(Token)match(input,37,FOLLOW_37_in_ruleCallDefinition2751); 

                	newLeafNode(otherlv_0, grammarAccess.getCallDefinitionAccess().getCalldefKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getCallDefinitionAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleCallDefinition2767);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1230:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1231:1: (lv_name_2_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1231:1: (lv_name_2_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1232:3: lv_name_2_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getCallDefinitionAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleCallDefinition2787);
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
                
            pushFollow(FOLLOW_ruleNL_in_ruleCallDefinition2803);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleCallDefinition2814); 

                	newLeafNode(otherlv_4, grammarAccess.getCallDefinitionAccess().getUsesKeyword_4());
                
             
                    newCompositeNode(grammarAccess.getCallDefinitionAccess().getNLParserRuleCall_5()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleCallDefinition2830);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1268:1: ( (lv_fixtureMethod_6_0= ruleMethodReference ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1269:1: (lv_fixtureMethod_6_0= ruleMethodReference )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1269:1: (lv_fixtureMethod_6_0= ruleMethodReference )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1270:3: lv_fixtureMethod_6_0= ruleMethodReference
            {
             
            	        newCompositeNode(grammarAccess.getCallDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleMethodReference_in_ruleCallDefinition2850);
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
                
            pushFollow(FOLLOW_ruleNL_in_ruleCallDefinition2866);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1302:1: entryRuleSuiteDefinition returns [EObject current=null] : iv_ruleSuiteDefinition= ruleSuiteDefinition EOF ;
    public final EObject entryRuleSuiteDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1303:2: (iv_ruleSuiteDefinition= ruleSuiteDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1304:2: iv_ruleSuiteDefinition= ruleSuiteDefinition EOF
            {
             newCompositeNode(grammarAccess.getSuiteDefinitionRule()); 
            pushFollow(FOLLOW_ruleSuiteDefinition_in_entryRuleSuiteDefinition2901);
            iv_ruleSuiteDefinition=ruleSuiteDefinition();

            state._fsp--;

             current =iv_ruleSuiteDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteDefinition2911); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1311:1: ruleSuiteDefinition returns [EObject current=null] : (otherlv_0= 'suitedef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL (otherlv_4= 'gets' ruleNL ( ( (lv_parameters_6_0= ruleVariableEntity ) ) ruleNL )* )? (otherlv_8= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? (otherlv_12= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? otherlv_16= 'with' ruleNL ( (lv_statements_18_0= ruleSuiteStatement ) )* otherlv_19= 'suiteend' ruleNL ) ;
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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1314:28: ( (otherlv_0= 'suitedef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL (otherlv_4= 'gets' ruleNL ( ( (lv_parameters_6_0= ruleVariableEntity ) ) ruleNL )* )? (otherlv_8= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? (otherlv_12= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? otherlv_16= 'with' ruleNL ( (lv_statements_18_0= ruleSuiteStatement ) )* otherlv_19= 'suiteend' ruleNL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1315:1: (otherlv_0= 'suitedef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL (otherlv_4= 'gets' ruleNL ( ( (lv_parameters_6_0= ruleVariableEntity ) ) ruleNL )* )? (otherlv_8= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? (otherlv_12= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? otherlv_16= 'with' ruleNL ( (lv_statements_18_0= ruleSuiteStatement ) )* otherlv_19= 'suiteend' ruleNL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1315:1: (otherlv_0= 'suitedef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL (otherlv_4= 'gets' ruleNL ( ( (lv_parameters_6_0= ruleVariableEntity ) ) ruleNL )* )? (otherlv_8= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? (otherlv_12= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? otherlv_16= 'with' ruleNL ( (lv_statements_18_0= ruleSuiteStatement ) )* otherlv_19= 'suiteend' ruleNL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1315:3: otherlv_0= 'suitedef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL (otherlv_4= 'gets' ruleNL ( ( (lv_parameters_6_0= ruleVariableEntity ) ) ruleNL )* )? (otherlv_8= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? (otherlv_12= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? otherlv_16= 'with' ruleNL ( (lv_statements_18_0= ruleSuiteStatement ) )* otherlv_19= 'suiteend' ruleNL
            {
            otherlv_0=(Token)match(input,38,FOLLOW_38_in_ruleSuiteDefinition2948); 

                	newLeafNode(otherlv_0, grammarAccess.getSuiteDefinitionAccess().getSuitedefKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleSuiteDefinition2964);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1327:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1328:1: (lv_name_2_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1328:1: (lv_name_2_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1329:3: lv_name_2_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuiteDefinition2984);
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
                
            pushFollow(FOLLOW_ruleNL_in_ruleSuiteDefinition3000);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1353:1: (otherlv_4= 'gets' ruleNL ( ( (lv_parameters_6_0= ruleVariableEntity ) ) ruleNL )* )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==39) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1353:3: otherlv_4= 'gets' ruleNL ( ( (lv_parameters_6_0= ruleVariableEntity ) ) ruleNL )*
                    {
                    otherlv_4=(Token)match(input,39,FOLLOW_39_in_ruleSuiteDefinition3012); 

                        	newLeafNode(otherlv_4, grammarAccess.getSuiteDefinitionAccess().getGetsKeyword_4_0());
                        
                     
                            newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_4_1()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleSuiteDefinition3028);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1365:1: ( ( (lv_parameters_6_0= ruleVariableEntity ) ) ruleNL )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( (LA12_0==RULE_ID) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1365:2: ( (lv_parameters_6_0= ruleVariableEntity ) ) ruleNL
                    	    {
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1365:2: ( (lv_parameters_6_0= ruleVariableEntity ) )
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1366:1: (lv_parameters_6_0= ruleVariableEntity )
                    	    {
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1366:1: (lv_parameters_6_0= ruleVariableEntity )
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1367:3: lv_parameters_6_0= ruleVariableEntity
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getParametersVariableEntityParserRuleCall_4_2_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleVariableEntity_in_ruleSuiteDefinition3049);
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
                    	        
                    	    pushFollow(FOLLOW_ruleNL_in_ruleSuiteDefinition3065);
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

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1391:5: (otherlv_8= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==40) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1391:7: otherlv_8= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )*
                    {
                    otherlv_8=(Token)match(input,40,FOLLOW_40_in_ruleSuiteDefinition3081); 

                        	newLeafNode(otherlv_8, grammarAccess.getSuiteDefinitionAccess().getRequiresKeyword_5_0());
                        
                     
                            newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_5_1()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleSuiteDefinition3097);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1403:1: ( ( ( ruleQualifiedName ) ) ruleNL )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==RULE_ID) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1403:2: ( ( ruleQualifiedName ) ) ruleNL
                    	    {
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1403:2: ( ( ruleQualifiedName ) )
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1404:1: ( ruleQualifiedName )
                    	    {
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1404:1: ( ruleQualifiedName )
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1405:3: ruleQualifiedName
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSuiteDefinitionRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getDependenciesSuiteDefinitionCrossReference_5_2_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuiteDefinition3120);
                    	    ruleQualifiedName();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	     
                    	            newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_5_2_1()); 
                    	        
                    	    pushFollow(FOLLOW_ruleNL_in_ruleSuiteDefinition3136);
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

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1426:5: (otherlv_12= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==41) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1426:7: otherlv_12= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )*
                    {
                    otherlv_12=(Token)match(input,41,FOLLOW_41_in_ruleSuiteDefinition3152); 

                        	newLeafNode(otherlv_12, grammarAccess.getSuiteDefinitionAccess().getConcludedbyKeyword_6_0());
                        
                     
                            newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_6_1()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleSuiteDefinition3168);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1438:1: ( ( ( ruleQualifiedName ) ) ruleNL )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==RULE_ID) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1438:2: ( ( ruleQualifiedName ) ) ruleNL
                    	    {
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1438:2: ( ( ruleQualifiedName ) )
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1439:1: ( ruleQualifiedName )
                    	    {
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1439:1: ( ruleQualifiedName )
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1440:3: ruleQualifiedName
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSuiteDefinitionRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getFinalizersSuiteDefinitionCrossReference_6_2_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuiteDefinition3191);
                    	    ruleQualifiedName();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	     
                    	            newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_6_2_1()); 
                    	        
                    	    pushFollow(FOLLOW_ruleNL_in_ruleSuiteDefinition3207);
                    	    ruleNL();

                    	    state._fsp--;

                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_16=(Token)match(input,29,FOLLOW_29_in_ruleSuiteDefinition3222); 

                	newLeafNode(otherlv_16, grammarAccess.getSuiteDefinitionAccess().getWithKeyword_7());
                
             
                    newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_8()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleSuiteDefinition3238);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1473:1: ( (lv_statements_18_0= ruleSuiteStatement ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=RULE_SL_VISIBLE_COMMENT && LA18_0<=RULE_DIVIDER)||(LA18_0>=44 && LA18_0<=45)||LA18_0==47||LA18_0==50||LA18_0==52||LA18_0==54||LA18_0==56) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1474:1: (lv_statements_18_0= ruleSuiteStatement )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1474:1: (lv_statements_18_0= ruleSuiteStatement )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1475:3: lv_statements_18_0= ruleSuiteStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getStatementsSuiteStatementParserRuleCall_9_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSuiteStatement_in_ruleSuiteDefinition3258);
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
            	    break loop18;
                }
            } while (true);

            otherlv_19=(Token)match(input,42,FOLLOW_42_in_ruleSuiteDefinition3271); 

                	newLeafNode(otherlv_19, grammarAccess.getSuiteDefinitionAccess().getSuiteendKeyword_10());
                
             
                    newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_11()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleSuiteDefinition3287);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1511:1: entryRuleOperationDefinition returns [EObject current=null] : iv_ruleOperationDefinition= ruleOperationDefinition EOF ;
    public final EObject entryRuleOperationDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1512:2: (iv_ruleOperationDefinition= ruleOperationDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1513:2: iv_ruleOperationDefinition= ruleOperationDefinition EOF
            {
             newCompositeNode(grammarAccess.getOperationDefinitionRule()); 
            pushFollow(FOLLOW_ruleOperationDefinition_in_entryRuleOperationDefinition3322);
            iv_ruleOperationDefinition=ruleOperationDefinition();

            state._fsp--;

             current =iv_ruleOperationDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperationDefinition3332); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1520:1: ruleOperationDefinition returns [EObject current=null] : (otherlv_0= 'operationdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_operationType_6_0= ruleJavaClassReference ) ) ruleNL ) ;
    public final EObject ruleOperationDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_operationType_6_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1523:28: ( (otherlv_0= 'operationdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_operationType_6_0= ruleJavaClassReference ) ) ruleNL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1524:1: (otherlv_0= 'operationdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_operationType_6_0= ruleJavaClassReference ) ) ruleNL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1524:1: (otherlv_0= 'operationdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_operationType_6_0= ruleJavaClassReference ) ) ruleNL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1524:3: otherlv_0= 'operationdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_operationType_6_0= ruleJavaClassReference ) ) ruleNL
            {
            otherlv_0=(Token)match(input,43,FOLLOW_43_in_ruleOperationDefinition3369); 

                	newLeafNode(otherlv_0, grammarAccess.getOperationDefinitionAccess().getOperationdefKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getOperationDefinitionAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleOperationDefinition3385);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1536:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1537:1: (lv_name_2_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1537:1: (lv_name_2_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1538:3: lv_name_2_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getOperationDefinitionAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleOperationDefinition3405);
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
                
            pushFollow(FOLLOW_ruleNL_in_ruleOperationDefinition3421);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_4=(Token)match(input,33,FOLLOW_33_in_ruleOperationDefinition3432); 

                	newLeafNode(otherlv_4, grammarAccess.getOperationDefinitionAccess().getUsesKeyword_4());
                
             
                    newCompositeNode(grammarAccess.getOperationDefinitionAccess().getNLParserRuleCall_5()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleOperationDefinition3448);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1574:1: ( (lv_operationType_6_0= ruleJavaClassReference ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1575:1: (lv_operationType_6_0= ruleJavaClassReference )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1575:1: (lv_operationType_6_0= ruleJavaClassReference )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1576:3: lv_operationType_6_0= ruleJavaClassReference
            {
             
            	        newCompositeNode(grammarAccess.getOperationDefinitionAccess().getOperationTypeJavaClassReferenceParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleJavaClassReference_in_ruleOperationDefinition3468);
            lv_operationType_6_0=ruleJavaClassReference();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOperationDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"operationType",
                    		lv_operationType_6_0, 
                    		"JavaClassReference");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getOperationDefinitionAccess().getNLParserRuleCall_7()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleOperationDefinition3484);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1608:1: entryRuleSuiteStatement returns [EObject current=null] : iv_ruleSuiteStatement= ruleSuiteStatement EOF ;
    public final EObject entryRuleSuiteStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteStatement = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1609:2: (iv_ruleSuiteStatement= ruleSuiteStatement EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1610:2: iv_ruleSuiteStatement= ruleSuiteStatement EOF
            {
             newCompositeNode(grammarAccess.getSuiteStatementRule()); 
            pushFollow(FOLLOW_ruleSuiteStatement_in_entryRuleSuiteStatement3519);
            iv_ruleSuiteStatement=ruleSuiteStatement();

            state._fsp--;

             current =iv_ruleSuiteStatement; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteStatement3529); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1617:1: ruleSuiteStatement returns [EObject current=null] : (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_VariableDefinition_1= ruleVariableDefinition | this_ConstantDefinition_2= ruleConstantDefinition | this_VisibleComment_3= ruleVisibleComment | this_VisibleDivider_4= ruleVisibleDivider ) ;
    public final EObject ruleSuiteStatement() throws RecognitionException {
        EObject current = null;

        EObject this_SuiteStatementWithResult_0 = null;

        EObject this_VariableDefinition_1 = null;

        EObject this_ConstantDefinition_2 = null;

        EObject this_VisibleComment_3 = null;

        EObject this_VisibleDivider_4 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1620:28: ( (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_VariableDefinition_1= ruleVariableDefinition | this_ConstantDefinition_2= ruleConstantDefinition | this_VisibleComment_3= ruleVisibleComment | this_VisibleDivider_4= ruleVisibleDivider ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1621:1: (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_VariableDefinition_1= ruleVariableDefinition | this_ConstantDefinition_2= ruleConstantDefinition | this_VisibleComment_3= ruleVisibleComment | this_VisibleDivider_4= ruleVisibleDivider )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1621:1: (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_VariableDefinition_1= ruleVariableDefinition | this_ConstantDefinition_2= ruleConstantDefinition | this_VisibleComment_3= ruleVisibleComment | this_VisibleDivider_4= ruleVisibleDivider )
            int alt19=5;
            switch ( input.LA(1) ) {
            case 50:
            case 52:
            case 54:
            case 56:
                {
                alt19=1;
                }
                break;
            case 44:
                {
                int LA19_2 = input.LA(2);

                if ( (LA19_2==47) ) {
                    alt19=3;
                }
                else if ( (LA19_2==45) ) {
                    alt19=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 19, 2, input);

                    throw nvae;
                }
                }
                break;
            case 45:
                {
                alt19=2;
                }
                break;
            case 47:
                {
                alt19=3;
                }
                break;
            case RULE_SL_VISIBLE_COMMENT:
            case RULE_SL_VISIBLE_TITLE_COMMENT:
            case RULE_ML_VISIBLE_COMMENT:
            case RULE_ML_VISIBLE_TITLE_COMMENT:
                {
                alt19=4;
                }
                break;
            case RULE_DIVIDER:
                {
                alt19=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1622:5: this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getSuiteStatementWithResultParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSuiteStatementWithResult_in_ruleSuiteStatement3576);
                    this_SuiteStatementWithResult_0=ruleSuiteStatementWithResult();

                    state._fsp--;

                     
                            current = this_SuiteStatementWithResult_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1632:5: this_VariableDefinition_1= ruleVariableDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getVariableDefinitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleVariableDefinition_in_ruleSuiteStatement3603);
                    this_VariableDefinition_1=ruleVariableDefinition();

                    state._fsp--;

                     
                            current = this_VariableDefinition_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1642:5: this_ConstantDefinition_2= ruleConstantDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getConstantDefinitionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleConstantDefinition_in_ruleSuiteStatement3630);
                    this_ConstantDefinition_2=ruleConstantDefinition();

                    state._fsp--;

                     
                            current = this_ConstantDefinition_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1652:5: this_VisibleComment_3= ruleVisibleComment
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getVisibleCommentParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleVisibleComment_in_ruleSuiteStatement3657);
                    this_VisibleComment_3=ruleVisibleComment();

                    state._fsp--;

                     
                            current = this_VisibleComment_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1662:5: this_VisibleDivider_4= ruleVisibleDivider
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getVisibleDividerParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleVisibleDivider_in_ruleSuiteStatement3684);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1678:1: entryRuleSuiteStatementWithResult returns [EObject current=null] : iv_ruleSuiteStatementWithResult= ruleSuiteStatementWithResult EOF ;
    public final EObject entryRuleSuiteStatementWithResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteStatementWithResult = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1679:2: (iv_ruleSuiteStatementWithResult= ruleSuiteStatementWithResult EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1680:2: iv_ruleSuiteStatementWithResult= ruleSuiteStatementWithResult EOF
            {
             newCompositeNode(grammarAccess.getSuiteStatementWithResultRule()); 
            pushFollow(FOLLOW_ruleSuiteStatementWithResult_in_entryRuleSuiteStatementWithResult3719);
            iv_ruleSuiteStatementWithResult=ruleSuiteStatementWithResult();

            state._fsp--;

             current =iv_ruleSuiteStatementWithResult; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteStatementWithResult3729); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1687:1: ruleSuiteStatementWithResult returns [EObject current=null] : (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest | this_Call_3= ruleCall ) ;
    public final EObject ruleSuiteStatementWithResult() throws RecognitionException {
        EObject current = null;

        EObject this_Suite_0 = null;

        EObject this_Test_1 = null;

        EObject this_TableTest_2 = null;

        EObject this_Call_3 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1690:28: ( (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest | this_Call_3= ruleCall ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1691:1: (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest | this_Call_3= ruleCall )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1691:1: (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest | this_Call_3= ruleCall )
            int alt20=4;
            switch ( input.LA(1) ) {
            case 56:
                {
                alt20=1;
                }
                break;
            case 50:
                {
                alt20=2;
                }
                break;
            case 52:
                {
                alt20=3;
                }
                break;
            case 54:
                {
                alt20=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1692:5: this_Suite_0= ruleSuite
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementWithResultAccess().getSuiteParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleSuite_in_ruleSuiteStatementWithResult3776);
                    this_Suite_0=ruleSuite();

                    state._fsp--;

                     
                            current = this_Suite_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1702:5: this_Test_1= ruleTest
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementWithResultAccess().getTestParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleTest_in_ruleSuiteStatementWithResult3803);
                    this_Test_1=ruleTest();

                    state._fsp--;

                     
                            current = this_Test_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1712:5: this_TableTest_2= ruleTableTest
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementWithResultAccess().getTableTestParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleTableTest_in_ruleSuiteStatementWithResult3830);
                    this_TableTest_2=ruleTableTest();

                    state._fsp--;

                     
                            current = this_TableTest_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1722:5: this_Call_3= ruleCall
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementWithResultAccess().getCallParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleCall_in_ruleSuiteStatementWithResult3857);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1738:1: entryRuleVariableDefinition returns [EObject current=null] : iv_ruleVariableDefinition= ruleVariableDefinition EOF ;
    public final EObject entryRuleVariableDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1739:2: (iv_ruleVariableDefinition= ruleVariableDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1740:2: iv_ruleVariableDefinition= ruleVariableDefinition EOF
            {
             newCompositeNode(grammarAccess.getVariableDefinitionRule()); 
            pushFollow(FOLLOW_ruleVariableDefinition_in_entryRuleVariableDefinition3892);
            iv_ruleVariableDefinition=ruleVariableDefinition();

            state._fsp--;

             current =iv_ruleVariableDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableDefinition3902); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1747:1: ruleVariableDefinition returns [EObject current=null] : ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'variable' ruleNL ( (lv_name_3_0= ruleVariableEntity ) ) ruleNL (otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ) ;
    public final EObject ruleVariableDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_private_0_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_name_3_0 = null;

        EObject lv_initialValue_7_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1750:28: ( ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'variable' ruleNL ( (lv_name_3_0= ruleVariableEntity ) ) ruleNL (otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1751:1: ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'variable' ruleNL ( (lv_name_3_0= ruleVariableEntity ) ) ruleNL (otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1751:1: ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'variable' ruleNL ( (lv_name_3_0= ruleVariableEntity ) ) ruleNL (otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1751:2: ( (lv_private_0_0= 'private' ) )? otherlv_1= 'variable' ruleNL ( (lv_name_3_0= ruleVariableEntity ) ) ruleNL (otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )?
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1751:2: ( (lv_private_0_0= 'private' ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==44) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1752:1: (lv_private_0_0= 'private' )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1752:1: (lv_private_0_0= 'private' )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1753:3: lv_private_0_0= 'private'
                    {
                    lv_private_0_0=(Token)match(input,44,FOLLOW_44_in_ruleVariableDefinition3945); 

                            newLeafNode(lv_private_0_0, grammarAccess.getVariableDefinitionAccess().getPrivatePrivateKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVariableDefinitionRule());
                    	        }
                           		setWithLastConsumed(current, "private", lv_private_0_0, "private");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,45,FOLLOW_45_in_ruleVariableDefinition3971); 

                	newLeafNode(otherlv_1, grammarAccess.getVariableDefinitionAccess().getVariableKeyword_1());
                
             
                    newCompositeNode(grammarAccess.getVariableDefinitionAccess().getNLParserRuleCall_2()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleVariableDefinition3987);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1778:1: ( (lv_name_3_0= ruleVariableEntity ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1779:1: (lv_name_3_0= ruleVariableEntity )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1779:1: (lv_name_3_0= ruleVariableEntity )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1780:3: lv_name_3_0= ruleVariableEntity
            {
             
            	        newCompositeNode(grammarAccess.getVariableDefinitionAccess().getNameVariableEntityParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleVariableEntity_in_ruleVariableDefinition4007);
            lv_name_3_0=ruleVariableEntity();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVariableDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"VariableEntity");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getVariableDefinitionAccess().getNLParserRuleCall_4()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleVariableDefinition4023);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1804:1: (otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==46) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1804:3: otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL
                    {
                    otherlv_5=(Token)match(input,46,FOLLOW_46_in_ruleVariableDefinition4035); 

                        	newLeafNode(otherlv_5, grammarAccess.getVariableDefinitionAccess().getInitiallyKeyword_5_0());
                        
                     
                            newCompositeNode(grammarAccess.getVariableDefinitionAccess().getNLParserRuleCall_5_1()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleVariableDefinition4051);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1816:1: ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1817:1: (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1817:1: (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1818:3: lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariableDefinitionAccess().getInitialValueValueOrEnumValueOrOperationCollectionParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleVariableDefinition4071);
                    lv_initialValue_7_0=ruleValueOrEnumValueOrOperationCollection();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVariableDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"initialValue",
                            		lv_initialValue_7_0, 
                            		"ValueOrEnumValueOrOperationCollection");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getVariableDefinitionAccess().getNLParserRuleCall_5_3()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleVariableDefinition4087);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1850:1: entryRuleConstantDefinition returns [EObject current=null] : iv_ruleConstantDefinition= ruleConstantDefinition EOF ;
    public final EObject entryRuleConstantDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantDefinition = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1851:2: (iv_ruleConstantDefinition= ruleConstantDefinition EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1852:2: iv_ruleConstantDefinition= ruleConstantDefinition EOF
            {
             newCompositeNode(grammarAccess.getConstantDefinitionRule()); 
            pushFollow(FOLLOW_ruleConstantDefinition_in_entryRuleConstantDefinition4124);
            iv_ruleConstantDefinition=ruleConstantDefinition();

            state._fsp--;

             current =iv_ruleConstantDefinition; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstantDefinition4134); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1859:1: ruleConstantDefinition returns [EObject current=null] : ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'constant' ruleNL ( (lv_name_3_0= ruleConstantEntity ) ) ruleNL ( ( ( ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_7_0= ruleVariantValue ) ) ruleNL )* ) | ( ( (lv_parameterized_9_0= 'parameterized' ) ) ruleNL ) ) ) ;
    public final EObject ruleConstantDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_private_0_0=null;
        Token otherlv_1=null;
        Token lv_parameterized_9_0=null;
        EObject lv_name_3_0 = null;

        EObject lv_value_5_0 = null;

        EObject lv_variantValues_7_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1862:28: ( ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'constant' ruleNL ( (lv_name_3_0= ruleConstantEntity ) ) ruleNL ( ( ( ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_7_0= ruleVariantValue ) ) ruleNL )* ) | ( ( (lv_parameterized_9_0= 'parameterized' ) ) ruleNL ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1863:1: ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'constant' ruleNL ( (lv_name_3_0= ruleConstantEntity ) ) ruleNL ( ( ( ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_7_0= ruleVariantValue ) ) ruleNL )* ) | ( ( (lv_parameterized_9_0= 'parameterized' ) ) ruleNL ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1863:1: ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'constant' ruleNL ( (lv_name_3_0= ruleConstantEntity ) ) ruleNL ( ( ( ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_7_0= ruleVariantValue ) ) ruleNL )* ) | ( ( (lv_parameterized_9_0= 'parameterized' ) ) ruleNL ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1863:2: ( (lv_private_0_0= 'private' ) )? otherlv_1= 'constant' ruleNL ( (lv_name_3_0= ruleConstantEntity ) ) ruleNL ( ( ( ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_7_0= ruleVariantValue ) ) ruleNL )* ) | ( ( (lv_parameterized_9_0= 'parameterized' ) ) ruleNL ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1863:2: ( (lv_private_0_0= 'private' ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==44) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1864:1: (lv_private_0_0= 'private' )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1864:1: (lv_private_0_0= 'private' )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1865:3: lv_private_0_0= 'private'
                    {
                    lv_private_0_0=(Token)match(input,44,FOLLOW_44_in_ruleConstantDefinition4177); 

                            newLeafNode(lv_private_0_0, grammarAccess.getConstantDefinitionAccess().getPrivatePrivateKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConstantDefinitionRule());
                    	        }
                           		setWithLastConsumed(current, "private", lv_private_0_0, "private");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,47,FOLLOW_47_in_ruleConstantDefinition4203); 

                	newLeafNode(otherlv_1, grammarAccess.getConstantDefinitionAccess().getConstantKeyword_1());
                
             
                    newCompositeNode(grammarAccess.getConstantDefinitionAccess().getNLParserRuleCall_2()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleConstantDefinition4219);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1890:1: ( (lv_name_3_0= ruleConstantEntity ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1891:1: (lv_name_3_0= ruleConstantEntity )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1891:1: (lv_name_3_0= ruleConstantEntity )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1892:3: lv_name_3_0= ruleConstantEntity
            {
             
            	        newCompositeNode(grammarAccess.getConstantDefinitionAccess().getNameConstantEntityParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleConstantEntity_in_ruleConstantDefinition4239);
            lv_name_3_0=ruleConstantEntity();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConstantDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"ConstantEntity");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getConstantDefinitionAccess().getNLParserRuleCall_4()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleConstantDefinition4255);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1916:1: ( ( ( ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_7_0= ruleVariantValue ) ) ruleNL )* ) | ( ( (lv_parameterized_9_0= 'parameterized' ) ) ruleNL ) )
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==EOF||(LA26_0>=RULE_SL_VISIBLE_COMMENT && LA26_0<=RULE_UPPERCASE_ID)||(LA26_0>=30 && LA26_0<=32)||(LA26_0>=35 && LA26_0<=38)||(LA26_0>=42 && LA26_0<=45)||LA26_0==47||(LA26_0>=49 && LA26_0<=50)||LA26_0==52||LA26_0==54||LA26_0==56||LA26_0==59||LA26_0==66||LA26_0==69||(LA26_0>=71 && LA26_0<=72)) ) {
                alt26=1;
            }
            else if ( (LA26_0==48) ) {
                alt26=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }
            switch (alt26) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1916:2: ( ( ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_7_0= ruleVariantValue ) ) ruleNL )* )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1916:2: ( ( ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_7_0= ruleVariantValue ) ) ruleNL )* )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1916:3: ( ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_7_0= ruleVariantValue ) ) ruleNL )*
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1916:3: ( ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )?
                    int alt24=2;
                    int LA24_0 = input.LA(1);

                    if ( ((LA24_0>=RULE_STRING && LA24_0<=RULE_UPPERCASE_ID)||LA24_0==59||LA24_0==66||LA24_0==69||(LA24_0>=71 && LA24_0<=72)) ) {
                        alt24=1;
                    }
                    switch (alt24) {
                        case 1 :
                            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1916:4: ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL
                            {
                            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1916:4: ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) )
                            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1917:1: (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection )
                            {
                            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1917:1: (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection )
                            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1918:3: lv_value_5_0= ruleValueOrEnumValueOrOperationCollection
                            {
                             
                            	        newCompositeNode(grammarAccess.getConstantDefinitionAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_5_0_0_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleConstantDefinition4278);
                            lv_value_5_0=ruleValueOrEnumValueOrOperationCollection();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getConstantDefinitionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"value",
                                    		lv_value_5_0, 
                                    		"ValueOrEnumValueOrOperationCollection");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                             
                                    newCompositeNode(grammarAccess.getConstantDefinitionAccess().getNLParserRuleCall_5_0_0_1()); 
                                
                            pushFollow(FOLLOW_ruleNL_in_ruleConstantDefinition4294);
                            ruleNL();

                            state._fsp--;

                             
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;

                    }

                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1942:3: ( ( (lv_variantValues_7_0= ruleVariantValue ) ) ruleNL )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==49) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1942:4: ( (lv_variantValues_7_0= ruleVariantValue ) ) ruleNL
                    	    {
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1942:4: ( (lv_variantValues_7_0= ruleVariantValue ) )
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1943:1: (lv_variantValues_7_0= ruleVariantValue )
                    	    {
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1943:1: (lv_variantValues_7_0= ruleVariantValue )
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1944:3: lv_variantValues_7_0= ruleVariantValue
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getConstantDefinitionAccess().getVariantValuesVariantValueParserRuleCall_5_0_1_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleVariantValue_in_ruleConstantDefinition4317);
                    	    lv_variantValues_7_0=ruleVariantValue();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getConstantDefinitionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"variantValues",
                    	            		lv_variantValues_7_0, 
                    	            		"VariantValue");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	     
                    	            newCompositeNode(grammarAccess.getConstantDefinitionAccess().getNLParserRuleCall_5_0_1_1()); 
                    	        
                    	    pushFollow(FOLLOW_ruleNL_in_ruleConstantDefinition4333);
                    	    ruleNL();

                    	    state._fsp--;

                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1969:6: ( ( (lv_parameterized_9_0= 'parameterized' ) ) ruleNL )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1969:6: ( ( (lv_parameterized_9_0= 'parameterized' ) ) ruleNL )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1969:7: ( (lv_parameterized_9_0= 'parameterized' ) ) ruleNL
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1969:7: ( (lv_parameterized_9_0= 'parameterized' ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1970:1: (lv_parameterized_9_0= 'parameterized' )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1970:1: (lv_parameterized_9_0= 'parameterized' )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:1971:3: lv_parameterized_9_0= 'parameterized'
                    {
                    lv_parameterized_9_0=(Token)match(input,48,FOLLOW_48_in_ruleConstantDefinition4360); 

                            newLeafNode(lv_parameterized_9_0, grammarAccess.getConstantDefinitionAccess().getParameterizedParameterizedKeyword_5_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConstantDefinitionRule());
                    	        }
                           		setWithLastConsumed(current, "parameterized", lv_parameterized_9_0, "parameterized");
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getConstantDefinitionAccess().getNLParserRuleCall_5_1_1()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleConstantDefinition4389);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

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
    // $ANTLR end "ruleConstantDefinition"


    // $ANTLR start "entryRuleVariantValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2000:1: entryRuleVariantValue returns [EObject current=null] : iv_ruleVariantValue= ruleVariantValue EOF ;
    public final EObject entryRuleVariantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariantValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2001:2: (iv_ruleVariantValue= ruleVariantValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2002:2: iv_ruleVariantValue= ruleVariantValue EOF
            {
             newCompositeNode(grammarAccess.getVariantValueRule()); 
            pushFollow(FOLLOW_ruleVariantValue_in_entryRuleVariantValue4426);
            iv_ruleVariantValue=ruleVariantValue();

            state._fsp--;

             current =iv_ruleVariantValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariantValue4436); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2009:1: ruleVariantValue returns [EObject current=null] : (otherlv_0= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ otherlv_4= ':' ruleNL ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) ) ;
    public final EObject ruleVariantValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject lv_value_6_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2012:28: ( (otherlv_0= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ otherlv_4= ':' ruleNL ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2013:1: (otherlv_0= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ otherlv_4= ':' ruleNL ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2013:1: (otherlv_0= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ otherlv_4= ':' ruleNL ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2013:3: otherlv_0= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ otherlv_4= ':' ruleNL ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) )
            {
            otherlv_0=(Token)match(input,49,FOLLOW_49_in_ruleVariantValue4473); 

                	newLeafNode(otherlv_0, grammarAccess.getVariantValueAccess().getInKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getVariantValueAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleVariantValue4489);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2025:1: ( ( ( ruleQualifiedName ) ) ruleNL )+
            int cnt27=0;
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==RULE_ID) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2025:2: ( ( ruleQualifiedName ) ) ruleNL
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2025:2: ( ( ruleQualifiedName ) )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2026:1: ( ruleQualifiedName )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2026:1: ( ruleQualifiedName )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2027:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getVariantValueRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getVariantValueAccess().getNamesVariantDefinitionCrossReference_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleVariantValue4512);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	     
            	            newCompositeNode(grammarAccess.getVariantValueAccess().getNLParserRuleCall_2_1()); 
            	        
            	    pushFollow(FOLLOW_ruleNL_in_ruleVariantValue4528);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt27 >= 1 ) break loop27;
                        EarlyExitException eee =
                            new EarlyExitException(27, input);
                        throw eee;
                }
                cnt27++;
            } while (true);

            otherlv_4=(Token)match(input,34,FOLLOW_34_in_ruleVariantValue4541); 

                	newLeafNode(otherlv_4, grammarAccess.getVariantValueAccess().getColonKeyword_3());
                
             
                    newCompositeNode(grammarAccess.getVariantValueAccess().getNLParserRuleCall_4()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleVariantValue4557);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2060:1: ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2061:1: (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2061:1: (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2062:3: lv_value_6_0= ruleValueOrEnumValueOrOperationCollection
            {
             
            	        newCompositeNode(grammarAccess.getVariantValueAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleVariantValue4577);
            lv_value_6_0=ruleValueOrEnumValueOrOperationCollection();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVariantValueRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_6_0, 
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
    // $ANTLR end "ruleVariantValue"


    // $ANTLR start "entryRuleVariableEntity"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2086:1: entryRuleVariableEntity returns [EObject current=null] : iv_ruleVariableEntity= ruleVariableEntity EOF ;
    public final EObject entryRuleVariableEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableEntity = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2087:2: (iv_ruleVariableEntity= ruleVariableEntity EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2088:2: iv_ruleVariableEntity= ruleVariableEntity EOF
            {
             newCompositeNode(grammarAccess.getVariableEntityRule()); 
            pushFollow(FOLLOW_ruleVariableEntity_in_entryRuleVariableEntity4613);
            iv_ruleVariableEntity=ruleVariableEntity();

            state._fsp--;

             current =iv_ruleVariableEntity; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableEntity4623); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2095:1: ruleVariableEntity returns [EObject current=null] : ( (lv_name_0_0= ruleQualifiedName ) ) ;
    public final EObject ruleVariableEntity() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2098:28: ( ( (lv_name_0_0= ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2099:1: ( (lv_name_0_0= ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2099:1: ( (lv_name_0_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2100:1: (lv_name_0_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2100:1: (lv_name_0_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2101:3: lv_name_0_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getVariableEntityAccess().getNameQualifiedNameParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleVariableEntity4668);
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


    // $ANTLR start "entryRuleConstantEntity"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2125:1: entryRuleConstantEntity returns [EObject current=null] : iv_ruleConstantEntity= ruleConstantEntity EOF ;
    public final EObject entryRuleConstantEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantEntity = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2126:2: (iv_ruleConstantEntity= ruleConstantEntity EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2127:2: iv_ruleConstantEntity= ruleConstantEntity EOF
            {
             newCompositeNode(grammarAccess.getConstantEntityRule()); 
            pushFollow(FOLLOW_ruleConstantEntity_in_entryRuleConstantEntity4703);
            iv_ruleConstantEntity=ruleConstantEntity();

            state._fsp--;

             current =iv_ruleConstantEntity; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstantEntity4713); 

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
    // $ANTLR end "entryRuleConstantEntity"


    // $ANTLR start "ruleConstantEntity"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2134:1: ruleConstantEntity returns [EObject current=null] : ( (lv_name_0_0= ruleQualifiedName ) ) ;
    public final EObject ruleConstantEntity() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2137:28: ( ( (lv_name_0_0= ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2138:1: ( (lv_name_0_0= ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2138:1: ( (lv_name_0_0= ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2139:1: (lv_name_0_0= ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2139:1: (lv_name_0_0= ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2140:3: lv_name_0_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getConstantEntityAccess().getNameQualifiedNameParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleConstantEntity4758);
            lv_name_0_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConstantEntityRule());
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
    // $ANTLR end "ruleConstantEntity"


    // $ANTLR start "entryRuleTest"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2166:1: entryRuleTest returns [EObject current=null] : iv_ruleTest= ruleTest EOF ;
    public final EObject entryRuleTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTest = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2167:2: (iv_ruleTest= ruleTest EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2168:2: iv_ruleTest= ruleTest EOF
            {
             newCompositeNode(grammarAccess.getTestRule()); 
            pushFollow(FOLLOW_ruleTest_in_entryRuleTest4795);
            iv_ruleTest=ruleTest();

            state._fsp--;

             current =iv_ruleTest; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTest4805); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2175:1: ruleTest returns [EObject current=null] : (otherlv_0= 'test' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_6_0= ruleNamedResult ) ) )* ( ruleNL otherlv_8= '=' ruleNL ( (lv_result_10_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL ) ;
    public final EObject ruleTest() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_8=null;
        EObject lv_parameters_4_0 = null;

        EObject lv_results_6_0 = null;

        EObject lv_result_10_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2178:28: ( (otherlv_0= 'test' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_6_0= ruleNamedResult ) ) )* ( ruleNL otherlv_8= '=' ruleNL ( (lv_result_10_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2179:1: (otherlv_0= 'test' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_6_0= ruleNamedResult ) ) )* ( ruleNL otherlv_8= '=' ruleNL ( (lv_result_10_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2179:1: (otherlv_0= 'test' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_6_0= ruleNamedResult ) ) )* ( ruleNL otherlv_8= '=' ruleNL ( (lv_result_10_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2179:3: otherlv_0= 'test' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_6_0= ruleNamedResult ) ) )* ( ruleNL otherlv_8= '=' ruleNL ( (lv_result_10_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL
            {
            otherlv_0=(Token)match(input,50,FOLLOW_50_in_ruleTest4842); 

                	newLeafNode(otherlv_0, grammarAccess.getTestAccess().getTestKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getTestAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleTest4858);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2191:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2192:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2192:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2193:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTestRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTestAccess().getDefinitionTestDefinitionCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleTest4880);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2206:2: ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )*
            loop28:
            do {
                int alt28=2;
                alt28 = dfa28.predict(input);
                switch (alt28) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2207:5: ruleNL ( (lv_parameters_4_0= ruleParameter ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getTestAccess().getNLParserRuleCall_3_0()); 
            	        
            	    pushFollow(FOLLOW_ruleNL_in_ruleTest4897);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2214:1: ( (lv_parameters_4_0= ruleParameter ) )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2215:1: (lv_parameters_4_0= ruleParameter )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2215:1: (lv_parameters_4_0= ruleParameter )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2216:3: lv_parameters_4_0= ruleParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTestAccess().getParametersParameterParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameter_in_ruleTest4917);
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
            	    break loop28;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2232:4: ( ruleNL ( (lv_results_6_0= ruleNamedResult ) ) )*
            loop29:
            do {
                int alt29=2;
                alt29 = dfa29.predict(input);
                switch (alt29) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2233:5: ruleNL ( (lv_results_6_0= ruleNamedResult ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getTestAccess().getNLParserRuleCall_4_0()); 
            	        
            	    pushFollow(FOLLOW_ruleNL_in_ruleTest4936);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2240:1: ( (lv_results_6_0= ruleNamedResult ) )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2241:1: (lv_results_6_0= ruleNamedResult )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2241:1: (lv_results_6_0= ruleNamedResult )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2242:3: lv_results_6_0= ruleNamedResult
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTestAccess().getResultsNamedResultParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleNamedResult_in_ruleTest4956);
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
            	    break loop29;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2258:4: ( ruleNL otherlv_8= '=' ruleNL ( (lv_result_10_0= ruleValueOrEnumValueOrOperationCollection ) ) )?
            int alt30=2;
            alt30 = dfa30.predict(input);
            switch (alt30) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2259:5: ruleNL otherlv_8= '=' ruleNL ( (lv_result_10_0= ruleValueOrEnumValueOrOperationCollection ) )
                    {
                     
                            newCompositeNode(grammarAccess.getTestAccess().getNLParserRuleCall_5_0()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleTest4975);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    otherlv_8=(Token)match(input,51,FOLLOW_51_in_ruleTest4986); 

                        	newLeafNode(otherlv_8, grammarAccess.getTestAccess().getEqualsSignKeyword_5_1());
                        
                     
                            newCompositeNode(grammarAccess.getTestAccess().getNLParserRuleCall_5_2()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleTest5002);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2278:1: ( (lv_result_10_0= ruleValueOrEnumValueOrOperationCollection ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2279:1: (lv_result_10_0= ruleValueOrEnumValueOrOperationCollection )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2279:1: (lv_result_10_0= ruleValueOrEnumValueOrOperationCollection )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2280:3: lv_result_10_0= ruleValueOrEnumValueOrOperationCollection
                    {
                     
                    	        newCompositeNode(grammarAccess.getTestAccess().getResultValueOrEnumValueOrOperationCollectionParserRuleCall_5_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleTest5022);
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
                
            pushFollow(FOLLOW_ruleNL_in_ruleTest5040);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2312:1: entryRuleTableTest returns [EObject current=null] : iv_ruleTableTest= ruleTableTest EOF ;
    public final EObject entryRuleTableTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTableTest = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2313:2: (iv_ruleTableTest= ruleTableTest EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2314:2: iv_ruleTableTest= ruleTableTest EOF
            {
             newCompositeNode(grammarAccess.getTableTestRule()); 
            pushFollow(FOLLOW_ruleTableTest_in_entryRuleTableTest5075);
            iv_ruleTableTest=ruleTableTest();

            state._fsp--;

             current =iv_ruleTableTest; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTableTest5085); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2321:1: ruleTableTest returns [EObject current=null] : (otherlv_0= 'tabletest' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ruleNLFORCED ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )* otherlv_8= '|' ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )? ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+ ruleNLFORCED ) ;
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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2324:28: ( (otherlv_0= 'tabletest' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ruleNLFORCED ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )* otherlv_8= '|' ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )? ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+ ruleNLFORCED ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2325:1: (otherlv_0= 'tabletest' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ruleNLFORCED ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )* otherlv_8= '|' ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )? ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+ ruleNLFORCED )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2325:1: (otherlv_0= 'tabletest' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ruleNLFORCED ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )* otherlv_8= '|' ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )? ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+ ruleNLFORCED )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2325:3: otherlv_0= 'tabletest' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ruleNLFORCED ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )* otherlv_8= '|' ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )? ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+ ruleNLFORCED
            {
            otherlv_0=(Token)match(input,52,FOLLOW_52_in_ruleTableTest5122); 

                	newLeafNode(otherlv_0, grammarAccess.getTableTestAccess().getTabletestKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getTableTestAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleTableTest5138);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2337:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2338:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2338:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2339:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTableTestRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTableTestAccess().getDefinitionTestDefinitionCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleTableTest5160);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2352:2: ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )*
            loop31:
            do {
                int alt31=2;
                alt31 = dfa31.predict(input);
                switch (alt31) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2353:5: ruleNL ( (lv_parameters_4_0= ruleParameter ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getTableTestAccess().getNLParserRuleCall_3_0()); 
            	        
            	    pushFollow(FOLLOW_ruleNL_in_ruleTableTest5177);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2360:1: ( (lv_parameters_4_0= ruleParameter ) )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2361:1: (lv_parameters_4_0= ruleParameter )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2361:1: (lv_parameters_4_0= ruleParameter )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2362:3: lv_parameters_4_0= ruleParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getParametersParameterParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameter_in_ruleTableTest5197);
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
            	    break loop31;
                }
            } while (true);

             
                    newCompositeNode(grammarAccess.getTableTestAccess().getNLFORCEDParserRuleCall_4()); 
                
            pushFollow(FOLLOW_ruleNLFORCED_in_ruleTableTest5215);
            ruleNLFORCED();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2386:1: ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==53) ) {
                    int LA32_1 = input.LA(2);

                    if ( (LA32_1==RULE_ID) ) {
                        int LA32_2 = input.LA(3);

                        if ( (LA32_2==53) ) {
                            alt32=1;
                        }


                    }
                    else if ( (LA32_1==58) ) {
                        int LA32_3 = input.LA(3);

                        if ( (LA32_3==RULE_ID) ) {
                            int LA32_6 = input.LA(4);

                            if ( (LA32_6==53) ) {
                                alt32=1;
                            }


                        }
                        else if ( (LA32_3==RULE_STRING) ) {
                            int LA32_7 = input.LA(4);

                            if ( (LA32_7==53) ) {
                                alt32=1;
                            }


                        }


                    }


                }


                switch (alt32) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2387:1: (lv_parameterHeaders_6_0= ruleParameterTableHeader )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2387:1: (lv_parameterHeaders_6_0= ruleParameterTableHeader )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2388:3: lv_parameterHeaders_6_0= ruleParameterTableHeader
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getParameterHeadersParameterTableHeaderParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameterTableHeader_in_ruleTableTest5235);
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
            	    break loop32;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2404:3: ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==53) ) {
                    int LA33_1 = input.LA(2);

                    if ( (LA33_1==RULE_ID||LA33_1==58) ) {
                        alt33=1;
                    }


                }


                switch (alt33) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2405:1: (lv_resultHeaders_7_0= ruleResultTableHeader )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2405:1: (lv_resultHeaders_7_0= ruleResultTableHeader )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2406:3: lv_resultHeaders_7_0= ruleResultTableHeader
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getResultHeadersResultTableHeaderParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleResultTableHeader_in_ruleTableTest5257);
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
            	    break loop33;
                }
            } while (true);

            otherlv_8=(Token)match(input,53,FOLLOW_53_in_ruleTableTest5270); 

                	newLeafNode(otherlv_8, grammarAccess.getTableTestAccess().getVerticalLineKeyword_7());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2426:1: ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==51) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2426:2: ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|'
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2426:2: ( (lv_defaultResultColumn_9_0= '=' ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2427:1: (lv_defaultResultColumn_9_0= '=' )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2427:1: (lv_defaultResultColumn_9_0= '=' )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2428:3: lv_defaultResultColumn_9_0= '='
                    {
                    lv_defaultResultColumn_9_0=(Token)match(input,51,FOLLOW_51_in_ruleTableTest5289); 

                            newLeafNode(lv_defaultResultColumn_9_0, grammarAccess.getTableTestAccess().getDefaultResultColumnEqualsSignKeyword_8_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTableTestRule());
                    	        }
                           		setWithLastConsumed(current, "defaultResultColumn", lv_defaultResultColumn_9_0, "=");
                    	    

                    }


                    }

                    otherlv_10=(Token)match(input,53,FOLLOW_53_in_ruleTableTest5314); 

                        	newLeafNode(otherlv_10, grammarAccess.getTableTestAccess().getVerticalLineKeyword_8_1());
                        

                    }
                    break;

            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2445:3: ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+
            int cnt35=0;
            loop35:
            do {
                int alt35=2;
                alt35 = dfa35.predict(input);
                switch (alt35) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2446:5: ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getTableTestAccess().getNLFORCEDParserRuleCall_9_0()); 
            	        
            	    pushFollow(FOLLOW_ruleNLFORCED_in_ruleTableTest5333);
            	    ruleNLFORCED();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2453:1: ( (lv_rows_12_0= ruleTableTestRow ) )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2454:1: (lv_rows_12_0= ruleTableTestRow )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2454:1: (lv_rows_12_0= ruleTableTestRow )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2455:3: lv_rows_12_0= ruleTableTestRow
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getRowsTableTestRowParserRuleCall_9_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTableTestRow_in_ruleTableTest5353);
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
            	    if ( cnt35 >= 1 ) break loop35;
                        EarlyExitException eee =
                            new EarlyExitException(35, input);
                        throw eee;
                }
                cnt35++;
            } while (true);

             
                    newCompositeNode(grammarAccess.getTableTestAccess().getNLFORCEDParserRuleCall_10()); 
                
            pushFollow(FOLLOW_ruleNLFORCED_in_ruleTableTest5371);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2487:1: entryRuleTableTestRow returns [EObject current=null] : iv_ruleTableTestRow= ruleTableTestRow EOF ;
    public final EObject entryRuleTableTestRow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTableTestRow = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2488:2: (iv_ruleTableTestRow= ruleTableTestRow EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2489:2: iv_ruleTableTestRow= ruleTableTestRow EOF
            {
             newCompositeNode(grammarAccess.getTableTestRowRule()); 
            pushFollow(FOLLOW_ruleTableTestRow_in_entryRuleTableTestRow5406);
            iv_ruleTableTestRow=ruleTableTestRow();

            state._fsp--;

             current =iv_ruleTableTestRow; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTableTestRow5416); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2496:1: ruleTableTestRow returns [EObject current=null] : ( () ( (lv_values_1_0= ruleParameterTableValue ) )+ ) ;
    public final EObject ruleTableTestRow() throws RecognitionException {
        EObject current = null;

        EObject lv_values_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2499:28: ( ( () ( (lv_values_1_0= ruleParameterTableValue ) )+ ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2500:1: ( () ( (lv_values_1_0= ruleParameterTableValue ) )+ )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2500:1: ( () ( (lv_values_1_0= ruleParameterTableValue ) )+ )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2500:2: () ( (lv_values_1_0= ruleParameterTableValue ) )+
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2500:2: ()
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2501:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTableTestRowAccess().getTableTestRowAction_0(),
                        current);
                

            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2506:2: ( (lv_values_1_0= ruleParameterTableValue ) )+
            int cnt36=0;
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==53) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2507:1: (lv_values_1_0= ruleParameterTableValue )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2507:1: (lv_values_1_0= ruleParameterTableValue )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2508:3: lv_values_1_0= ruleParameterTableValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestRowAccess().getValuesParameterTableValueParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameterTableValue_in_ruleTableTestRow5471);
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
            	    if ( cnt36 >= 1 ) break loop36;
                        EarlyExitException eee =
                            new EarlyExitException(36, input);
                        throw eee;
                }
                cnt36++;
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2532:1: entryRuleParameterTableHeader returns [EObject current=null] : iv_ruleParameterTableHeader= ruleParameterTableHeader EOF ;
    public final EObject entryRuleParameterTableHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterTableHeader = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2533:2: (iv_ruleParameterTableHeader= ruleParameterTableHeader EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2534:2: iv_ruleParameterTableHeader= ruleParameterTableHeader EOF
            {
             newCompositeNode(grammarAccess.getParameterTableHeaderRule()); 
            pushFollow(FOLLOW_ruleParameterTableHeader_in_entryRuleParameterTableHeader5508);
            iv_ruleParameterTableHeader=ruleParameterTableHeader();

            state._fsp--;

             current =iv_ruleParameterTableHeader; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterTableHeader5518); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2541:1: ruleParameterTableHeader returns [EObject current=null] : (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) (otherlv_2= '|' )? ) ;
    public final EObject ruleParameterTableHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2544:28: ( (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) (otherlv_2= '|' )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2545:1: (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) (otherlv_2= '|' )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2545:1: (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) (otherlv_2= '|' )? )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2545:3: otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) (otherlv_2= '|' )?
            {
            otherlv_0=(Token)match(input,53,FOLLOW_53_in_ruleParameterTableHeader5555); 

                	newLeafNode(otherlv_0, grammarAccess.getParameterTableHeaderAccess().getVerticalLineKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2549:1: ( (lv_name_1_0= ruleParameterName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2550:1: (lv_name_1_0= ruleParameterName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2550:1: (lv_name_1_0= ruleParameterName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2551:3: lv_name_1_0= ruleParameterName
            {
             
            	        newCompositeNode(grammarAccess.getParameterTableHeaderAccess().getNameParameterNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleParameterName_in_ruleParameterTableHeader5576);
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

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2567:2: (otherlv_2= '|' )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==53) ) {
                int LA37_1 = input.LA(2);

                if ( (LA37_1==EOF||LA37_1==53) ) {
                    alt37=1;
                }
            }
            switch (alt37) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2567:4: otherlv_2= '|'
                    {
                    otherlv_2=(Token)match(input,53,FOLLOW_53_in_ruleParameterTableHeader5589); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2579:1: entryRuleResultTableHeader returns [EObject current=null] : iv_ruleResultTableHeader= ruleResultTableHeader EOF ;
    public final EObject entryRuleResultTableHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultTableHeader = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2580:2: (iv_ruleResultTableHeader= ruleResultTableHeader EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2581:2: iv_ruleResultTableHeader= ruleResultTableHeader EOF
            {
             newCompositeNode(grammarAccess.getResultTableHeaderRule()); 
            pushFollow(FOLLOW_ruleResultTableHeader_in_entryRuleResultTableHeader5627);
            iv_ruleResultTableHeader=ruleResultTableHeader();

            state._fsp--;

             current =iv_ruleResultTableHeader; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultTableHeader5637); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2588:1: ruleResultTableHeader returns [EObject current=null] : (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' (otherlv_3= '|' )? ) ;
    public final EObject ruleResultTableHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2591:28: ( (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' (otherlv_3= '|' )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2592:1: (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' (otherlv_3= '|' )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2592:1: (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' (otherlv_3= '|' )? )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2592:3: otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' (otherlv_3= '|' )?
            {
            otherlv_0=(Token)match(input,53,FOLLOW_53_in_ruleResultTableHeader5674); 

                	newLeafNode(otherlv_0, grammarAccess.getResultTableHeaderAccess().getVerticalLineKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2596:1: ( (lv_name_1_0= ruleResultName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2597:1: (lv_name_1_0= ruleResultName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2597:1: (lv_name_1_0= ruleResultName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2598:3: lv_name_1_0= ruleResultName
            {
             
            	        newCompositeNode(grammarAccess.getResultTableHeaderAccess().getNameResultNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleResultName_in_ruleResultTableHeader5695);
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

            otherlv_2=(Token)match(input,51,FOLLOW_51_in_ruleResultTableHeader5707); 

                	newLeafNode(otherlv_2, grammarAccess.getResultTableHeaderAccess().getEqualsSignKeyword_2());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2618:1: (otherlv_3= '|' )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==53) ) {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==EOF||LA38_1==53) ) {
                    alt38=1;
                }
            }
            switch (alt38) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2618:3: otherlv_3= '|'
                    {
                    otherlv_3=(Token)match(input,53,FOLLOW_53_in_ruleResultTableHeader5720); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2630:1: entryRuleParameterTableValue returns [EObject current=null] : iv_ruleParameterTableValue= ruleParameterTableValue EOF ;
    public final EObject entryRuleParameterTableValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterTableValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2631:2: (iv_ruleParameterTableValue= ruleParameterTableValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2632:2: iv_ruleParameterTableValue= ruleParameterTableValue EOF
            {
             newCompositeNode(grammarAccess.getParameterTableValueRule()); 
            pushFollow(FOLLOW_ruleParameterTableValue_in_entryRuleParameterTableValue5758);
            iv_ruleParameterTableValue=ruleParameterTableValue();

            state._fsp--;

             current =iv_ruleParameterTableValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterTableValue5768); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2639:1: ruleParameterTableValue returns [EObject current=null] : (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) ) (otherlv_2= '|' )? ) ;
    public final EObject ruleParameterTableValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2642:28: ( (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) ) (otherlv_2= '|' )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2643:1: (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) ) (otherlv_2= '|' )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2643:1: (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) ) (otherlv_2= '|' )? )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2643:3: otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) ) (otherlv_2= '|' )?
            {
            otherlv_0=(Token)match(input,53,FOLLOW_53_in_ruleParameterTableValue5805); 

                	newLeafNode(otherlv_0, grammarAccess.getParameterTableValueAccess().getVerticalLineKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2647:1: ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2648:1: (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2648:1: (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2649:3: lv_value_1_0= ruleValueOrEnumValueOrOperationCollection
            {
             
            	        newCompositeNode(grammarAccess.getParameterTableValueAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleParameterTableValue5826);
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

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2665:2: (otherlv_2= '|' )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==53) ) {
                int LA39_1 = input.LA(2);

                if ( (LA39_1==EOF||LA39_1==RULE_NEWLINE||LA39_1==53) ) {
                    alt39=1;
                }
            }
            switch (alt39) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2665:4: otherlv_2= '|'
                    {
                    otherlv_2=(Token)match(input,53,FOLLOW_53_in_ruleParameterTableValue5839); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2677:1: entryRuleNamedResult returns [EObject current=null] : iv_ruleNamedResult= ruleNamedResult EOF ;
    public final EObject entryRuleNamedResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedResult = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2678:2: (iv_ruleNamedResult= ruleNamedResult EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2679:2: iv_ruleNamedResult= ruleNamedResult EOF
            {
             newCompositeNode(grammarAccess.getNamedResultRule()); 
            pushFollow(FOLLOW_ruleNamedResult_in_entryRuleNamedResult5877);
            iv_ruleNamedResult=ruleNamedResult();

            state._fsp--;

             current =iv_ruleNamedResult; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedResult5887); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2686:1: ruleNamedResult returns [EObject current=null] : ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '=' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) ;
    public final EObject ruleNamedResult() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2689:28: ( ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '=' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2690:1: ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '=' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2690:1: ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '=' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2690:2: ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '=' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2690:2: ( (lv_name_0_0= ruleResultName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2691:1: (lv_name_0_0= ruleResultName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2691:1: (lv_name_0_0= ruleResultName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2692:3: lv_name_0_0= ruleResultName
            {
             
            	        newCompositeNode(grammarAccess.getNamedResultAccess().getNameResultNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleResultName_in_ruleNamedResult5933);
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
                
            pushFollow(FOLLOW_ruleNL_in_ruleNamedResult5949);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,51,FOLLOW_51_in_ruleNamedResult5960); 

                	newLeafNode(otherlv_2, grammarAccess.getNamedResultAccess().getEqualsSignKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getNamedResultAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleNamedResult5976);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2728:1: ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2729:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2729:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2730:3: lv_value_4_0= ruleValueOrEnumValueOrOperationCollection
            {
             
            	        newCompositeNode(grammarAccess.getNamedResultAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleNamedResult5996);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2754:1: entryRuleResultName returns [EObject current=null] : iv_ruleResultName= ruleResultName EOF ;
    public final EObject entryRuleResultName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2755:2: (iv_ruleResultName= ruleResultName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2756:2: iv_ruleResultName= ruleResultName EOF
            {
             newCompositeNode(grammarAccess.getResultNameRule()); 
            pushFollow(FOLLOW_ruleResultName_in_entryRuleResultName6032);
            iv_ruleResultName=ruleResultName();

            state._fsp--;

             current =iv_ruleResultName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleResultName6042); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2763:1: ruleResultName returns [EObject current=null] : (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) ;
    public final EObject ruleResultName() throws RecognitionException {
        EObject current = null;

        EObject this_FixedResultName_0 = null;

        EObject this_ArbitraryParameterOrResultName_1 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2766:28: ( (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2767:1: (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2767:1: (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==RULE_ID) ) {
                alt40=1;
            }
            else if ( (LA40_0==58) ) {
                alt40=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }
            switch (alt40) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2768:5: this_FixedResultName_0= ruleFixedResultName
                    {
                     
                            newCompositeNode(grammarAccess.getResultNameAccess().getFixedResultNameParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleFixedResultName_in_ruleResultName6089);
                    this_FixedResultName_0=ruleFixedResultName();

                    state._fsp--;

                     
                            current = this_FixedResultName_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2778:5: this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName
                    {
                     
                            newCompositeNode(grammarAccess.getResultNameAccess().getArbitraryParameterOrResultNameParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleArbitraryParameterOrResultName_in_ruleResultName6116);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2794:1: entryRuleFixedResultName returns [EObject current=null] : iv_ruleFixedResultName= ruleFixedResultName EOF ;
    public final EObject entryRuleFixedResultName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedResultName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2795:2: (iv_ruleFixedResultName= ruleFixedResultName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2796:2: iv_ruleFixedResultName= ruleFixedResultName EOF
            {
             newCompositeNode(grammarAccess.getFixedResultNameRule()); 
            pushFollow(FOLLOW_ruleFixedResultName_in_entryRuleFixedResultName6151);
            iv_ruleFixedResultName=ruleFixedResultName();

            state._fsp--;

             current =iv_ruleFixedResultName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFixedResultName6161); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2803:1: ruleFixedResultName returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleFixedResultName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2806:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2807:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2807:1: ( (otherlv_0= RULE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2808:1: (otherlv_0= RULE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2808:1: (otherlv_0= RULE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2809:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFixedResultNameRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFixedResultName6205); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2828:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2829:2: (iv_ruleCall= ruleCall EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2830:2: iv_ruleCall= ruleCall EOF
            {
             newCompositeNode(grammarAccess.getCallRule()); 
            pushFollow(FOLLOW_ruleCall_in_entryRuleCall6240);
            iv_ruleCall=ruleCall();

            state._fsp--;

             current =iv_ruleCall; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCall6250); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2837:1: ruleCall returns [EObject current=null] : (otherlv_0= 'call' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )* ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )? ruleNL ) ;
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
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2840:28: ( (otherlv_0= 'call' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )* ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )? ruleNL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2841:1: (otherlv_0= 'call' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )* ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )? ruleNL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2841:1: (otherlv_0= 'call' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )* ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )? ruleNL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2841:3: otherlv_0= 'call' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )* ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )? ruleNL
            {
            otherlv_0=(Token)match(input,54,FOLLOW_54_in_ruleCall6287); 

                	newLeafNode(otherlv_0, grammarAccess.getCallAccess().getCallKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleCall6303);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2853:1: ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )?
            int alt41=2;
            alt41 = dfa41.predict(input);
            switch (alt41) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2853:2: ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2853:2: ( (lv_multiplier_2_0= ruleExecutionMultiplier ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2854:1: (lv_multiplier_2_0= ruleExecutionMultiplier )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2854:1: (lv_multiplier_2_0= ruleExecutionMultiplier )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2855:3: lv_multiplier_2_0= ruleExecutionMultiplier
                    {
                     
                    	        newCompositeNode(grammarAccess.getCallAccess().getMultiplierExecutionMultiplierParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExecutionMultiplier_in_ruleCall6324);
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
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleCall6340);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2879:3: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2880:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2880:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2881:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCallRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getCallAccess().getDefinitionCallDefinitionCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleCall6364);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2894:2: ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )*
            loop42:
            do {
                int alt42=2;
                alt42 = dfa42.predict(input);
                switch (alt42) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2895:5: ruleNL ( (lv_parameters_6_0= ruleParameter ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_4_0()); 
            	        
            	    pushFollow(FOLLOW_ruleNL_in_ruleCall6381);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2902:1: ( (lv_parameters_6_0= ruleParameter ) )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2903:1: (lv_parameters_6_0= ruleParameter )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2903:1: (lv_parameters_6_0= ruleParameter )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2904:3: lv_parameters_6_0= ruleParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCallAccess().getParametersParameterParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleParameter_in_ruleCall6401);
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
            	    break loop42;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2920:4: ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )*
            loop43:
            do {
                int alt43=2;
                alt43 = dfa43.predict(input);
                switch (alt43) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2921:5: ruleNL ( (lv_results_8_0= ruleNamedCallResult ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_5_0()); 
            	        
            	    pushFollow(FOLLOW_ruleNL_in_ruleCall6420);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2928:1: ( (lv_results_8_0= ruleNamedCallResult ) )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2929:1: (lv_results_8_0= ruleNamedCallResult )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2929:1: (lv_results_8_0= ruleNamedCallResult )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2930:3: lv_results_8_0= ruleNamedCallResult
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCallAccess().getResultsNamedCallResultParserRuleCall_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleNamedCallResult_in_ruleCall6440);
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
            	    break loop43;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2946:4: ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )?
            int alt44=2;
            alt44 = dfa44.predict(input);
            switch (alt44) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2947:5: ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) )
                    {
                     
                            newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_6_0()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleCall6459);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    otherlv_10=(Token)match(input,55,FOLLOW_55_in_ruleCall6470); 

                        	newLeafNode(otherlv_10, grammarAccess.getCallAccess().getHyphenMinusGreaterThanSignKeyword_6_1());
                        
                     
                            newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_6_2()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleCall6486);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2966:1: ( (lv_result_12_0= ruleVariableVariable ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2967:1: (lv_result_12_0= ruleVariableVariable )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2967:1: (lv_result_12_0= ruleVariableVariable )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:2968:3: lv_result_12_0= ruleVariableVariable
                    {
                     
                    	        newCompositeNode(grammarAccess.getCallAccess().getResultVariableVariableParserRuleCall_6_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleVariableVariable_in_ruleCall6506);
                    lv_result_12_0=ruleVariableVariable();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCallRule());
                    	        }
                           		set(
                           			current, 
                           			"result",
                            		lv_result_12_0, 
                            		"VariableVariable");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

             
                    newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_7()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleCall6524);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3000:1: entryRuleNamedCallResult returns [EObject current=null] : iv_ruleNamedCallResult= ruleNamedCallResult EOF ;
    public final EObject entryRuleNamedCallResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedCallResult = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3001:2: (iv_ruleNamedCallResult= ruleNamedCallResult EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3002:2: iv_ruleNamedCallResult= ruleNamedCallResult EOF
            {
             newCompositeNode(grammarAccess.getNamedCallResultRule()); 
            pushFollow(FOLLOW_ruleNamedCallResult_in_entryRuleNamedCallResult6559);
            iv_ruleNamedCallResult=ruleNamedCallResult();

            state._fsp--;

             current =iv_ruleNamedCallResult; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNamedCallResult6569); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3009:1: ruleNamedCallResult returns [EObject current=null] : ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) ) ;
    public final EObject ruleNamedCallResult() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_target_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3012:28: ( ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3013:1: ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3013:1: ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3013:2: ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3013:2: ( (lv_name_0_0= ruleResultName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3014:1: (lv_name_0_0= ruleResultName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3014:1: (lv_name_0_0= ruleResultName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3015:3: lv_name_0_0= ruleResultName
            {
             
            	        newCompositeNode(grammarAccess.getNamedCallResultAccess().getNameResultNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleResultName_in_ruleNamedCallResult6615);
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
                
            pushFollow(FOLLOW_ruleNL_in_ruleNamedCallResult6631);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,55,FOLLOW_55_in_ruleNamedCallResult6642); 

                	newLeafNode(otherlv_2, grammarAccess.getNamedCallResultAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getNamedCallResultAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleNamedCallResult6658);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3051:1: ( (lv_target_4_0= ruleVariableVariable ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3052:1: (lv_target_4_0= ruleVariableVariable )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3052:1: (lv_target_4_0= ruleVariableVariable )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3053:3: lv_target_4_0= ruleVariableVariable
            {
             
            	        newCompositeNode(grammarAccess.getNamedCallResultAccess().getTargetVariableVariableParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleVariableVariable_in_ruleNamedCallResult6678);
            lv_target_4_0=ruleVariableVariable();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNamedCallResultRule());
            	        }
                   		set(
                   			current, 
                   			"target",
                    		lv_target_4_0, 
                    		"VariableVariable");
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3077:1: entryRuleSuite returns [EObject current=null] : iv_ruleSuite= ruleSuite EOF ;
    public final EObject entryRuleSuite() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuite = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3078:2: (iv_ruleSuite= ruleSuite EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3079:2: iv_ruleSuite= ruleSuite EOF
            {
             newCompositeNode(grammarAccess.getSuiteRule()); 
            pushFollow(FOLLOW_ruleSuite_in_entryRuleSuite6714);
            iv_ruleSuite=ruleSuite();

            state._fsp--;

             current =iv_ruleSuite; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuite6724); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3086:1: ruleSuite returns [EObject current=null] : (otherlv_0= 'suite' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ruleNL ( ( (lv_parameters_6_0= ruleSuiteParameter ) ) ruleNL )* (otherlv_8= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )? (otherlv_12= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ )? ) ;
    public final EObject ruleSuite() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_8=null;
        Token otherlv_12=null;
        EObject lv_multiplier_2_0 = null;

        EObject lv_parameters_6_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3089:28: ( (otherlv_0= 'suite' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ruleNL ( ( (lv_parameters_6_0= ruleSuiteParameter ) ) ruleNL )* (otherlv_8= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )? (otherlv_12= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3090:1: (otherlv_0= 'suite' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ruleNL ( ( (lv_parameters_6_0= ruleSuiteParameter ) ) ruleNL )* (otherlv_8= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )? (otherlv_12= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3090:1: (otherlv_0= 'suite' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ruleNL ( ( (lv_parameters_6_0= ruleSuiteParameter ) ) ruleNL )* (otherlv_8= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )? (otherlv_12= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ )? )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3090:3: otherlv_0= 'suite' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ruleNL ( ( (lv_parameters_6_0= ruleSuiteParameter ) ) ruleNL )* (otherlv_8= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )? (otherlv_12= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ )?
            {
            otherlv_0=(Token)match(input,56,FOLLOW_56_in_ruleSuite6761); 

                	newLeafNode(otherlv_0, grammarAccess.getSuiteAccess().getSuiteKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleSuite6777);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3102:1: ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )?
            int alt45=2;
            alt45 = dfa45.predict(input);
            switch (alt45) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3102:2: ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3102:2: ( (lv_multiplier_2_0= ruleExecutionMultiplier ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3103:1: (lv_multiplier_2_0= ruleExecutionMultiplier )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3103:1: (lv_multiplier_2_0= ruleExecutionMultiplier )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3104:3: lv_multiplier_2_0= ruleExecutionMultiplier
                    {
                     
                    	        newCompositeNode(grammarAccess.getSuiteAccess().getMultiplierExecutionMultiplierParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExecutionMultiplier_in_ruleSuite6798);
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
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleSuite6814);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3128:3: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3129:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3129:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3130:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSuiteRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSuiteAccess().getDefinitionSuiteDefinitionCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuite6838);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_4()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleSuite6854);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3151:1: ( ( (lv_parameters_6_0= ruleSuiteParameter ) ) ruleNL )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==RULE_ID) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3151:2: ( (lv_parameters_6_0= ruleSuiteParameter ) ) ruleNL
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3151:2: ( (lv_parameters_6_0= ruleSuiteParameter ) )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3152:1: (lv_parameters_6_0= ruleSuiteParameter )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3152:1: (lv_parameters_6_0= ruleSuiteParameter )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3153:3: lv_parameters_6_0= ruleSuiteParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSuiteAccess().getParametersSuiteParameterParserRuleCall_5_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSuiteParameter_in_ruleSuite6875);
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
            	        
            	    pushFollow(FOLLOW_ruleNL_in_ruleSuite6891);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3177:3: (otherlv_8= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==57) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3177:5: otherlv_8= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL
                    {
                    otherlv_8=(Token)match(input,57,FOLLOW_57_in_ruleSuite6905); 

                        	newLeafNode(otherlv_8, grammarAccess.getSuiteAccess().getOnKeyword_6_0());
                        
                     
                            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_6_1()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleSuite6921);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3189:1: ( ( ruleQualifiedName ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3190:1: ( ruleQualifiedName )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3190:1: ( ruleQualifiedName )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3191:3: ruleQualifiedName
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSuiteRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getSuiteAccess().getForkForkDefinitionCrossReference_6_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuite6943);
                    ruleQualifiedName();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_6_3()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleSuite6959);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3212:3: (otherlv_12= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==49) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3212:5: otherlv_12= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+
                    {
                    otherlv_12=(Token)match(input,49,FOLLOW_49_in_ruleSuite6973); 

                        	newLeafNode(otherlv_12, grammarAccess.getSuiteAccess().getInKeyword_7_0());
                        
                     
                            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_7_1()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleSuite6989);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3224:1: ( ( ( ruleQualifiedName ) ) ruleNL )+
                    int cnt48=0;
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==RULE_ID) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3224:2: ( ( ruleQualifiedName ) ) ruleNL
                    	    {
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3224:2: ( ( ruleQualifiedName ) )
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3225:1: ( ruleQualifiedName )
                    	    {
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3225:1: ( ruleQualifiedName )
                    	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3226:3: ruleQualifiedName
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSuiteRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteAccess().getVariantsVariantDefinitionCrossReference_7_2_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuite7012);
                    	    ruleQualifiedName();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	     
                    	            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_7_2_1()); 
                    	        
                    	    pushFollow(FOLLOW_ruleNL_in_ruleSuite7028);
                    	    ruleNL();

                    	    state._fsp--;

                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt48 >= 1 ) break loop48;
                                EarlyExitException eee =
                                    new EarlyExitException(48, input);
                                throw eee;
                        }
                        cnt48++;
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3255:1: entryRuleSuiteParameter returns [EObject current=null] : iv_ruleSuiteParameter= ruleSuiteParameter EOF ;
    public final EObject entryRuleSuiteParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteParameter = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3256:2: (iv_ruleSuiteParameter= ruleSuiteParameter EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3257:2: iv_ruleSuiteParameter= ruleSuiteParameter EOF
            {
             newCompositeNode(grammarAccess.getSuiteParameterRule()); 
            pushFollow(FOLLOW_ruleSuiteParameter_in_entryRuleSuiteParameter7067);
            iv_ruleSuiteParameter=ruleSuiteParameter();

            state._fsp--;

             current =iv_ruleSuiteParameter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSuiteParameter7077); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3264:1: ruleSuiteParameter returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) ;
    public final EObject ruleSuiteParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3267:28: ( ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3268:1: ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3268:1: ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3268:2: ( ( ruleQualifiedName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3268:2: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3269:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3269:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3270:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSuiteParameterRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSuiteParameterAccess().getNameVariableOrConstantEntityCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleSuiteParameter7125);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getSuiteParameterAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleSuiteParameter7141);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleSuiteParameter7152); 

                	newLeafNode(otherlv_2, grammarAccess.getSuiteParameterAccess().getColonKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getSuiteParameterAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleSuiteParameter7168);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3303:1: ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3304:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3304:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3305:3: lv_value_4_0= ruleValueOrEnumValueOrOperationCollection
            {
             
            	        newCompositeNode(grammarAccess.getSuiteParameterAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleSuiteParameter7188);
            lv_value_4_0=ruleValueOrEnumValueOrOperationCollection();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSuiteParameterRule());
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
    // $ANTLR end "ruleSuiteParameter"


    // $ANTLR start "entryRuleParameter"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3329:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3330:2: (iv_ruleParameter= ruleParameter EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3331:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_ruleParameter_in_entryRuleParameter7224);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameter7234); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3338:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= ruleParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3341:28: ( ( ( (lv_name_0_0= ruleParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3342:1: ( ( (lv_name_0_0= ruleParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3342:1: ( ( (lv_name_0_0= ruleParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3342:2: ( (lv_name_0_0= ruleParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3342:2: ( (lv_name_0_0= ruleParameterName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3343:1: (lv_name_0_0= ruleParameterName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3343:1: (lv_name_0_0= ruleParameterName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3344:3: lv_name_0_0= ruleParameterName
            {
             
            	        newCompositeNode(grammarAccess.getParameterAccess().getNameParameterNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleParameterName_in_ruleParameter7280);
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
                
            pushFollow(FOLLOW_ruleNL_in_ruleParameter7296);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,34,FOLLOW_34_in_ruleParameter7307); 

                	newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getColonKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getParameterAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleParameter7323);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3380:1: ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3381:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3381:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3382:3: lv_value_4_0= ruleValueOrEnumValueOrOperationCollection
            {
             
            	        newCompositeNode(grammarAccess.getParameterAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleParameter7343);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3406:1: entryRuleParameterName returns [EObject current=null] : iv_ruleParameterName= ruleParameterName EOF ;
    public final EObject entryRuleParameterName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3407:2: (iv_ruleParameterName= ruleParameterName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3408:2: iv_ruleParameterName= ruleParameterName EOF
            {
             newCompositeNode(grammarAccess.getParameterNameRule()); 
            pushFollow(FOLLOW_ruleParameterName_in_entryRuleParameterName7379);
            iv_ruleParameterName=ruleParameterName();

            state._fsp--;

             current =iv_ruleParameterName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterName7389); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3415:1: ruleParameterName returns [EObject current=null] : (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) ;
    public final EObject ruleParameterName() throws RecognitionException {
        EObject current = null;

        EObject this_FixedParameterName_0 = null;

        EObject this_ArbitraryParameterOrResultName_1 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3418:28: ( (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3419:1: (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3419:1: (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_ID) ) {
                alt50=1;
            }
            else if ( (LA50_0==58) ) {
                alt50=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }
            switch (alt50) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3420:5: this_FixedParameterName_0= ruleFixedParameterName
                    {
                     
                            newCompositeNode(grammarAccess.getParameterNameAccess().getFixedParameterNameParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleFixedParameterName_in_ruleParameterName7436);
                    this_FixedParameterName_0=ruleFixedParameterName();

                    state._fsp--;

                     
                            current = this_FixedParameterName_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3430:5: this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName
                    {
                     
                            newCompositeNode(grammarAccess.getParameterNameAccess().getArbitraryParameterOrResultNameParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleArbitraryParameterOrResultName_in_ruleParameterName7463);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3446:1: entryRuleFixedParameterName returns [EObject current=null] : iv_ruleFixedParameterName= ruleFixedParameterName EOF ;
    public final EObject entryRuleFixedParameterName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedParameterName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3447:2: (iv_ruleFixedParameterName= ruleFixedParameterName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3448:2: iv_ruleFixedParameterName= ruleFixedParameterName EOF
            {
             newCompositeNode(grammarAccess.getFixedParameterNameRule()); 
            pushFollow(FOLLOW_ruleFixedParameterName_in_entryRuleFixedParameterName7498);
            iv_ruleFixedParameterName=ruleFixedParameterName();

            state._fsp--;

             current =iv_ruleFixedParameterName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFixedParameterName7508); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3455:1: ruleFixedParameterName returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleFixedParameterName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3458:28: ( ( (otherlv_0= RULE_ID ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3459:1: ( (otherlv_0= RULE_ID ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3459:1: ( (otherlv_0= RULE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3460:1: (otherlv_0= RULE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3460:1: (otherlv_0= RULE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3461:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFixedParameterNameRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleFixedParameterName7552); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3480:1: entryRuleArbitraryParameterOrResultName returns [EObject current=null] : iv_ruleArbitraryParameterOrResultName= ruleArbitraryParameterOrResultName EOF ;
    public final EObject entryRuleArbitraryParameterOrResultName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArbitraryParameterOrResultName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3481:2: (iv_ruleArbitraryParameterOrResultName= ruleArbitraryParameterOrResultName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3482:2: iv_ruleArbitraryParameterOrResultName= ruleArbitraryParameterOrResultName EOF
            {
             newCompositeNode(grammarAccess.getArbitraryParameterOrResultNameRule()); 
            pushFollow(FOLLOW_ruleArbitraryParameterOrResultName_in_entryRuleArbitraryParameterOrResultName7587);
            iv_ruleArbitraryParameterOrResultName=ruleArbitraryParameterOrResultName();

            state._fsp--;

             current =iv_ruleArbitraryParameterOrResultName; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleArbitraryParameterOrResultName7597); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3489:1: ruleArbitraryParameterOrResultName returns [EObject current=null] : (otherlv_0= '+' ( ( (lv_identifier_1_0= RULE_ID ) ) | ( (lv_stringIdentifier_2_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleArbitraryParameterOrResultName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_identifier_1_0=null;
        Token lv_stringIdentifier_2_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3492:28: ( (otherlv_0= '+' ( ( (lv_identifier_1_0= RULE_ID ) ) | ( (lv_stringIdentifier_2_0= RULE_STRING ) ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3493:1: (otherlv_0= '+' ( ( (lv_identifier_1_0= RULE_ID ) ) | ( (lv_stringIdentifier_2_0= RULE_STRING ) ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3493:1: (otherlv_0= '+' ( ( (lv_identifier_1_0= RULE_ID ) ) | ( (lv_stringIdentifier_2_0= RULE_STRING ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3493:3: otherlv_0= '+' ( ( (lv_identifier_1_0= RULE_ID ) ) | ( (lv_stringIdentifier_2_0= RULE_STRING ) ) )
            {
            otherlv_0=(Token)match(input,58,FOLLOW_58_in_ruleArbitraryParameterOrResultName7634); 

                	newLeafNode(otherlv_0, grammarAccess.getArbitraryParameterOrResultNameAccess().getPlusSignKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3497:1: ( ( (lv_identifier_1_0= RULE_ID ) ) | ( (lv_stringIdentifier_2_0= RULE_STRING ) ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==RULE_ID) ) {
                alt51=1;
            }
            else if ( (LA51_0==RULE_STRING) ) {
                alt51=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3497:2: ( (lv_identifier_1_0= RULE_ID ) )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3497:2: ( (lv_identifier_1_0= RULE_ID ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3498:1: (lv_identifier_1_0= RULE_ID )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3498:1: (lv_identifier_1_0= RULE_ID )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3499:3: lv_identifier_1_0= RULE_ID
                    {
                    lv_identifier_1_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleArbitraryParameterOrResultName7652); 

                    			newLeafNode(lv_identifier_1_0, grammarAccess.getArbitraryParameterOrResultNameAccess().getIdentifierIDTerminalRuleCall_1_0_0()); 
                    		

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
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3516:6: ( (lv_stringIdentifier_2_0= RULE_STRING ) )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3516:6: ( (lv_stringIdentifier_2_0= RULE_STRING ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3517:1: (lv_stringIdentifier_2_0= RULE_STRING )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3517:1: (lv_stringIdentifier_2_0= RULE_STRING )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3518:3: lv_stringIdentifier_2_0= RULE_STRING
                    {
                    lv_stringIdentifier_2_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleArbitraryParameterOrResultName7680); 

                    			newLeafNode(lv_stringIdentifier_2_0, grammarAccess.getArbitraryParameterOrResultNameAccess().getStringIdentifierSTRINGTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getArbitraryParameterOrResultNameRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"stringIdentifier",
                            		lv_stringIdentifier_2_0, 
                            		"STRING");
                    	    

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
    // $ANTLR end "ruleArbitraryParameterOrResultName"


    // $ANTLR start "entryRuleOperation"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3542:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3543:2: (iv_ruleOperation= ruleOperation EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3544:2: iv_ruleOperation= ruleOperation EOF
            {
             newCompositeNode(grammarAccess.getOperationRule()); 
            pushFollow(FOLLOW_ruleOperation_in_entryRuleOperation7722);
            iv_ruleOperation=ruleOperation();

            state._fsp--;

             current =iv_ruleOperation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleOperation7732); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3551:1: ruleOperation returns [EObject current=null] : (this_StandardOperation_0= ruleStandardOperation | this_CustomOperation_1= ruleCustomOperation ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        EObject this_StandardOperation_0 = null;

        EObject this_CustomOperation_1 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3554:28: ( (this_StandardOperation_0= ruleStandardOperation | this_CustomOperation_1= ruleCustomOperation ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3555:1: (this_StandardOperation_0= ruleStandardOperation | this_CustomOperation_1= ruleCustomOperation )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3555:1: (this_StandardOperation_0= ruleStandardOperation | this_CustomOperation_1= ruleCustomOperation )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==59) ) {
                alt52=1;
            }
            else if ( (LA52_0==66) ) {
                alt52=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3556:5: this_StandardOperation_0= ruleStandardOperation
                    {
                     
                            newCompositeNode(grammarAccess.getOperationAccess().getStandardOperationParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleStandardOperation_in_ruleOperation7779);
                    this_StandardOperation_0=ruleStandardOperation();

                    state._fsp--;

                     
                            current = this_StandardOperation_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3566:5: this_CustomOperation_1= ruleCustomOperation
                    {
                     
                            newCompositeNode(grammarAccess.getOperationAccess().getCustomOperationParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleCustomOperation_in_ruleOperation7806);
                    this_CustomOperation_1=ruleCustomOperation();

                    state._fsp--;

                     
                            current = this_CustomOperation_1; 
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
    // $ANTLR end "ruleOperation"


    // $ANTLR start "entryRuleStandardOperation"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3582:1: entryRuleStandardOperation returns [EObject current=null] : iv_ruleStandardOperation= ruleStandardOperation EOF ;
    public final EObject entryRuleStandardOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStandardOperation = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3583:2: (iv_ruleStandardOperation= ruleStandardOperation EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3584:2: iv_ruleStandardOperation= ruleStandardOperation EOF
            {
             newCompositeNode(grammarAccess.getStandardOperationRule()); 
            pushFollow(FOLLOW_ruleStandardOperation_in_entryRuleStandardOperation7841);
            iv_ruleStandardOperation=ruleStandardOperation();

            state._fsp--;

             current =iv_ruleStandardOperation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStandardOperation7851); 

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
    // $ANTLR end "entryRuleStandardOperation"


    // $ANTLR start "ruleStandardOperation"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3591:1: ruleStandardOperation returns [EObject current=null] : (otherlv_0= '(' ruleNL ( (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL )+ otherlv_8= ')' ) ;
    public final EObject ruleStandardOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_operators_4_1=null;
        Token lv_operators_4_2=null;
        Token lv_operators_4_3=null;
        Token lv_operators_4_4=null;
        Token lv_operators_4_5=null;
        Token lv_operators_4_6=null;
        Token otherlv_8=null;
        EObject lv_firstOperand_2_0 = null;

        EObject lv_moreOperands_6_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3594:28: ( (otherlv_0= '(' ruleNL ( (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL )+ otherlv_8= ')' ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3595:1: (otherlv_0= '(' ruleNL ( (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL )+ otherlv_8= ')' )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3595:1: (otherlv_0= '(' ruleNL ( (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL )+ otherlv_8= ')' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3595:3: otherlv_0= '(' ruleNL ( (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL )+ otherlv_8= ')'
            {
            otherlv_0=(Token)match(input,59,FOLLOW_59_in_ruleStandardOperation7888); 

                	newLeafNode(otherlv_0, grammarAccess.getStandardOperationAccess().getLeftParenthesisKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getStandardOperationAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleStandardOperation7904);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3607:1: ( (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3608:1: (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3608:1: (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3609:3: lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation
            {
             
            	        newCompositeNode(grammarAccess.getStandardOperationAccess().getFirstOperandValueOrEnumValueOrOperationParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleValueOrEnumValueOrOperation_in_ruleStandardOperation7924);
            lv_firstOperand_2_0=ruleValueOrEnumValueOrOperation();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getStandardOperationRule());
            	        }
                   		set(
                   			current, 
                   			"firstOperand",
                    		lv_firstOperand_2_0, 
                    		"ValueOrEnumValueOrOperation");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getStandardOperationAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleStandardOperation7940);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3633:1: ( ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL )+
            int cnt54=0;
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==58||(LA54_0>=60 && LA54_0<=64)) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3633:2: ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3633:2: ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3634:1: ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3634:1: ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3635:1: (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3635:1: (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' )
            	    int alt53=6;
            	    switch ( input.LA(1) ) {
            	    case 58:
            	        {
            	        alt53=1;
            	        }
            	        break;
            	    case 60:
            	        {
            	        alt53=2;
            	        }
            	        break;
            	    case 61:
            	        {
            	        alt53=3;
            	        }
            	        break;
            	    case 62:
            	        {
            	        alt53=4;
            	        }
            	        break;
            	    case 63:
            	        {
            	        alt53=5;
            	        }
            	        break;
            	    case 64:
            	        {
            	        alt53=6;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 53, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt53) {
            	        case 1 :
            	            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3636:3: lv_operators_4_1= '+'
            	            {
            	            lv_operators_4_1=(Token)match(input,58,FOLLOW_58_in_ruleStandardOperation7960); 

            	                    newLeafNode(lv_operators_4_1, grammarAccess.getStandardOperationAccess().getOperatorsPlusSignKeyword_4_0_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getStandardOperationRule());
            	            	        }
            	                   		addWithLastConsumed(current, "operators", lv_operators_4_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3648:8: lv_operators_4_2= '-'
            	            {
            	            lv_operators_4_2=(Token)match(input,60,FOLLOW_60_in_ruleStandardOperation7989); 

            	                    newLeafNode(lv_operators_4_2, grammarAccess.getStandardOperationAccess().getOperatorsHyphenMinusKeyword_4_0_0_1());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getStandardOperationRule());
            	            	        }
            	                   		addWithLastConsumed(current, "operators", lv_operators_4_2, null);
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3660:8: lv_operators_4_3= '*'
            	            {
            	            lv_operators_4_3=(Token)match(input,61,FOLLOW_61_in_ruleStandardOperation8018); 

            	                    newLeafNode(lv_operators_4_3, grammarAccess.getStandardOperationAccess().getOperatorsAsteriskKeyword_4_0_0_2());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getStandardOperationRule());
            	            	        }
            	                   		addWithLastConsumed(current, "operators", lv_operators_4_3, null);
            	            	    

            	            }
            	            break;
            	        case 4 :
            	            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3672:8: lv_operators_4_4= '/'
            	            {
            	            lv_operators_4_4=(Token)match(input,62,FOLLOW_62_in_ruleStandardOperation8047); 

            	                    newLeafNode(lv_operators_4_4, grammarAccess.getStandardOperationAccess().getOperatorsSolidusKeyword_4_0_0_3());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getStandardOperationRule());
            	            	        }
            	                   		addWithLastConsumed(current, "operators", lv_operators_4_4, null);
            	            	    

            	            }
            	            break;
            	        case 5 :
            	            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3684:8: lv_operators_4_5= '%'
            	            {
            	            lv_operators_4_5=(Token)match(input,63,FOLLOW_63_in_ruleStandardOperation8076); 

            	                    newLeafNode(lv_operators_4_5, grammarAccess.getStandardOperationAccess().getOperatorsPercentSignKeyword_4_0_0_4());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getStandardOperationRule());
            	            	        }
            	                   		addWithLastConsumed(current, "operators", lv_operators_4_5, null);
            	            	    

            	            }
            	            break;
            	        case 6 :
            	            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3696:8: lv_operators_4_6= '..'
            	            {
            	            lv_operators_4_6=(Token)match(input,64,FOLLOW_64_in_ruleStandardOperation8105); 

            	                    newLeafNode(lv_operators_4_6, grammarAccess.getStandardOperationAccess().getOperatorsFullStopFullStopKeyword_4_0_0_5());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getStandardOperationRule());
            	            	        }
            	                   		addWithLastConsumed(current, "operators", lv_operators_4_6, null);
            	            	    

            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	            newCompositeNode(grammarAccess.getStandardOperationAccess().getNLParserRuleCall_4_1()); 
            	        
            	    pushFollow(FOLLOW_ruleNL_in_ruleStandardOperation8137);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3719:1: ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3720:1: (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3720:1: (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3721:3: lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStandardOperationAccess().getMoreOperandsValueOrEnumValueOrOperationParserRuleCall_4_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueOrEnumValueOrOperation_in_ruleStandardOperation8157);
            	    lv_moreOperands_6_0=ruleValueOrEnumValueOrOperation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStandardOperationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"moreOperands",
            	            		lv_moreOperands_6_0, 
            	            		"ValueOrEnumValueOrOperation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	     
            	            newCompositeNode(grammarAccess.getStandardOperationAccess().getNLParserRuleCall_4_3()); 
            	        
            	    pushFollow(FOLLOW_ruleNL_in_ruleStandardOperation8173);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt54 >= 1 ) break loop54;
                        EarlyExitException eee =
                            new EarlyExitException(54, input);
                        throw eee;
                }
                cnt54++;
            } while (true);

            otherlv_8=(Token)match(input,65,FOLLOW_65_in_ruleStandardOperation8186); 

                	newLeafNode(otherlv_8, grammarAccess.getStandardOperationAccess().getRightParenthesisKeyword_5());
                

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
    // $ANTLR end "ruleStandardOperation"


    // $ANTLR start "entryRuleCustomOperation"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3757:1: entryRuleCustomOperation returns [EObject current=null] : iv_ruleCustomOperation= ruleCustomOperation EOF ;
    public final EObject entryRuleCustomOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCustomOperation = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3758:2: (iv_ruleCustomOperation= ruleCustomOperation EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3759:2: iv_ruleCustomOperation= ruleCustomOperation EOF
            {
             newCompositeNode(grammarAccess.getCustomOperationRule()); 
            pushFollow(FOLLOW_ruleCustomOperation_in_entryRuleCustomOperation8222);
            iv_ruleCustomOperation=ruleCustomOperation();

            state._fsp--;

             current =iv_ruleCustomOperation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCustomOperation8232); 

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
    // $ANTLR end "entryRuleCustomOperation"


    // $ANTLR start "ruleCustomOperation"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3766:1: ruleCustomOperation returns [EObject current=null] : (otherlv_0= '[' ruleNL ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL otherlv_9= ']' ) ;
    public final EObject ruleCustomOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        EObject lv_prefixOperand_2_0 = null;

        EObject lv_postfixOperand_7_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3769:28: ( (otherlv_0= '[' ruleNL ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL otherlv_9= ']' ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3770:1: (otherlv_0= '[' ruleNL ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL otherlv_9= ']' )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3770:1: (otherlv_0= '[' ruleNL ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL otherlv_9= ']' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3770:3: otherlv_0= '[' ruleNL ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL otherlv_9= ']'
            {
            otherlv_0=(Token)match(input,66,FOLLOW_66_in_ruleCustomOperation8269); 

                	newLeafNode(otherlv_0, grammarAccess.getCustomOperationAccess().getLeftSquareBracketKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getCustomOperationAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleCustomOperation8285);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3782:1: ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )?
            int alt55=2;
            alt55 = dfa55.predict(input);
            switch (alt55) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3782:2: ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3782:2: ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3783:1: (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3783:1: (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3784:3: lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection
                    {
                     
                    	        newCompositeNode(grammarAccess.getCustomOperationAccess().getPrefixOperandValueOrEnumValueOrOperationCollectionParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleCustomOperation8306);
                    lv_prefixOperand_2_0=ruleValueOrEnumValueOrOperationCollection();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCustomOperationRule());
                    	        }
                           		set(
                           			current, 
                           			"prefixOperand",
                            		lv_prefixOperand_2_0, 
                            		"ValueOrEnumValueOrOperationCollection");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getCustomOperationAccess().getNLParserRuleCall_2_1()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleCustomOperation8322);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3808:3: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3809:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3809:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3810:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCustomOperationRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getCustomOperationAccess().getDefinitionOperationDefinitionCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleCustomOperation8346);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3823:2: ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )?
            int alt56=2;
            alt56 = dfa56.predict(input);
            switch (alt56) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3824:5: ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) )
                    {
                     
                            newCompositeNode(grammarAccess.getCustomOperationAccess().getNLParserRuleCall_4_0()); 
                        
                    pushFollow(FOLLOW_ruleNL_in_ruleCustomOperation8363);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    otherlv_6=(Token)match(input,29,FOLLOW_29_in_ruleCustomOperation8374); 

                        	newLeafNode(otherlv_6, grammarAccess.getCustomOperationAccess().getWithKeyword_4_1());
                        
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3835:1: ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3836:1: (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3836:1: (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3837:3: lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection
                    {
                     
                    	        newCompositeNode(grammarAccess.getCustomOperationAccess().getPostfixOperandValueOrEnumValueOrOperationCollectionParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleCustomOperation8395);
                    lv_postfixOperand_7_0=ruleValueOrEnumValueOrOperationCollection();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCustomOperationRule());
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

             
                    newCompositeNode(grammarAccess.getCustomOperationAccess().getNLParserRuleCall_5()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleCustomOperation8413);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_9=(Token)match(input,67,FOLLOW_67_in_ruleCustomOperation8424); 

                	newLeafNode(otherlv_9, grammarAccess.getCustomOperationAccess().getRightSquareBracketKeyword_6());
                

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
    // $ANTLR end "ruleCustomOperation"


    // $ANTLR start "entryRuleValueOrEnumValueOrOperationCollection"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3873:1: entryRuleValueOrEnumValueOrOperationCollection returns [EObject current=null] : iv_ruleValueOrEnumValueOrOperationCollection= ruleValueOrEnumValueOrOperationCollection EOF ;
    public final EObject entryRuleValueOrEnumValueOrOperationCollection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueOrEnumValueOrOperationCollection = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3874:2: (iv_ruleValueOrEnumValueOrOperationCollection= ruleValueOrEnumValueOrOperationCollection EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3875:2: iv_ruleValueOrEnumValueOrOperationCollection= ruleValueOrEnumValueOrOperationCollection EOF
            {
             newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationCollectionRule()); 
            pushFollow(FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_entryRuleValueOrEnumValueOrOperationCollection8460);
            iv_ruleValueOrEnumValueOrOperationCollection=ruleValueOrEnumValueOrOperationCollection();

            state._fsp--;

             current =iv_ruleValueOrEnumValueOrOperationCollection; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueOrEnumValueOrOperationCollection8470); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3882:1: ruleValueOrEnumValueOrOperationCollection returns [EObject current=null] : ( ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) ) ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )* ) ;
    public final EObject ruleValueOrEnumValueOrOperationCollection() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_value_0_0 = null;

        EObject lv_moreValues_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3885:28: ( ( ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) ) ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )* ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3886:1: ( ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) ) ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )* )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3886:1: ( ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) ) ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )* )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3886:2: ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) ) ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )*
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3886:2: ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3887:1: (lv_value_0_0= ruleValueOrEnumValueOrOperation )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3887:1: (lv_value_0_0= ruleValueOrEnumValueOrOperation )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3888:3: lv_value_0_0= ruleValueOrEnumValueOrOperation
            {
             
            	        newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getValueValueOrEnumValueOrOperationParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleValueOrEnumValueOrOperation_in_ruleValueOrEnumValueOrOperationCollection8516);
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

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3904:2: ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )*
            loop57:
            do {
                int alt57=2;
                alt57 = dfa57.predict(input);
                switch (alt57) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3905:5: ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getNLParserRuleCall_1_0()); 
            	        
            	    pushFollow(FOLLOW_ruleNL_in_ruleValueOrEnumValueOrOperationCollection8533);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    otherlv_2=(Token)match(input,68,FOLLOW_68_in_ruleValueOrEnumValueOrOperationCollection8544); 

            	        	newLeafNode(otherlv_2, grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getCommaKeyword_1_1());
            	        
            	     
            	            newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getNLParserRuleCall_1_2()); 
            	        
            	    pushFollow(FOLLOW_ruleNL_in_ruleValueOrEnumValueOrOperationCollection8560);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3924:1: ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3925:1: (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3925:1: (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3926:3: lv_moreValues_4_0= ruleValueOrEnumValueOrOperation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getMoreValuesValueOrEnumValueOrOperationParserRuleCall_1_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleValueOrEnumValueOrOperation_in_ruleValueOrEnumValueOrOperationCollection8580);
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
    // $ANTLR end "ruleValueOrEnumValueOrOperationCollection"


    // $ANTLR start "entryRuleValueOrEnumValueOrOperation"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3950:1: entryRuleValueOrEnumValueOrOperation returns [EObject current=null] : iv_ruleValueOrEnumValueOrOperation= ruleValueOrEnumValueOrOperation EOF ;
    public final EObject entryRuleValueOrEnumValueOrOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueOrEnumValueOrOperation = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3951:2: (iv_ruleValueOrEnumValueOrOperation= ruleValueOrEnumValueOrOperation EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3952:2: iv_ruleValueOrEnumValueOrOperation= ruleValueOrEnumValueOrOperation EOF
            {
             newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationRule()); 
            pushFollow(FOLLOW_ruleValueOrEnumValueOrOperation_in_entryRuleValueOrEnumValueOrOperation8618);
            iv_ruleValueOrEnumValueOrOperation=ruleValueOrEnumValueOrOperation();

            state._fsp--;

             current =iv_ruleValueOrEnumValueOrOperation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValueOrEnumValueOrOperation8628); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3959:1: ruleValueOrEnumValueOrOperation returns [EObject current=null] : (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue | this_Operation_2= ruleOperation ) ;
    public final EObject ruleValueOrEnumValueOrOperation() throws RecognitionException {
        EObject current = null;

        EObject this_Value_0 = null;

        EObject this_EnumValue_1 = null;

        EObject this_Operation_2 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3962:28: ( (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue | this_Operation_2= ruleOperation ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3963:1: (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue | this_Operation_2= ruleOperation )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3963:1: (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue | this_Operation_2= ruleOperation )
            int alt58=3;
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
            case 69:
            case 71:
            case 72:
                {
                alt58=1;
                }
                break;
            case RULE_UPPERCASE_ID:
                {
                alt58=2;
                }
                break;
            case 59:
            case 66:
                {
                alt58=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3964:5: this_Value_0= ruleValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationAccess().getValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleValue_in_ruleValueOrEnumValueOrOperation8675);
                    this_Value_0=ruleValue();

                    state._fsp--;

                     
                            current = this_Value_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3974:5: this_EnumValue_1= ruleEnumValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationAccess().getEnumValueParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEnumValue_in_ruleValueOrEnumValueOrOperation8702);
                    this_EnumValue_1=ruleEnumValue();

                    state._fsp--;

                     
                            current = this_EnumValue_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:3984:5: this_Operation_2= ruleOperation
                    {
                     
                            newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationAccess().getOperationParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleOperation_in_ruleValueOrEnumValueOrOperation8729);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4000:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4001:2: (iv_ruleValue= ruleValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4002:2: iv_ruleValue= ruleValue EOF
            {
             newCompositeNode(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_ruleValue_in_entryRuleValue8764);
            iv_ruleValue=ruleValue();

            state._fsp--;

             current =iv_ruleValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValue8774); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4009:1: ruleValue returns [EObject current=null] : (this_StaticValue_0= ruleStaticValue | this_Variable_1= ruleVariable | this_NestedObject_2= ruleNestedObject | this_TypedNestedObject_3= ruleTypedNestedObject ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        EObject this_StaticValue_0 = null;

        EObject this_Variable_1 = null;

        EObject this_NestedObject_2 = null;

        EObject this_TypedNestedObject_3 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4012:28: ( (this_StaticValue_0= ruleStaticValue | this_Variable_1= ruleVariable | this_NestedObject_2= ruleNestedObject | this_TypedNestedObject_3= ruleTypedNestedObject ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4013:1: (this_StaticValue_0= ruleStaticValue | this_Variable_1= ruleVariable | this_NestedObject_2= ruleNestedObject | this_TypedNestedObject_3= ruleTypedNestedObject )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4013:1: (this_StaticValue_0= ruleStaticValue | this_Variable_1= ruleVariable | this_NestedObject_2= ruleNestedObject | this_TypedNestedObject_3= ruleTypedNestedObject )
            int alt59=4;
            alt59 = dfa59.predict(input);
            switch (alt59) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4014:5: this_StaticValue_0= ruleStaticValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getStaticValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleStaticValue_in_ruleValue8821);
                    this_StaticValue_0=ruleStaticValue();

                    state._fsp--;

                     
                            current = this_StaticValue_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4024:5: this_Variable_1= ruleVariable
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getVariableParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleVariable_in_ruleValue8848);
                    this_Variable_1=ruleVariable();

                    state._fsp--;

                     
                            current = this_Variable_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4034:5: this_NestedObject_2= ruleNestedObject
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getNestedObjectParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleNestedObject_in_ruleValue8875);
                    this_NestedObject_2=ruleNestedObject();

                    state._fsp--;

                     
                            current = this_NestedObject_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4044:5: this_TypedNestedObject_3= ruleTypedNestedObject
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getTypedNestedObjectParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleTypedNestedObject_in_ruleValue8902);
                    this_TypedNestedObject_3=ruleTypedNestedObject();

                    state._fsp--;

                     
                            current = this_TypedNestedObject_3; 
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


    // $ANTLR start "entryRuleConstantValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4060:1: entryRuleConstantValue returns [EObject current=null] : iv_ruleConstantValue= ruleConstantValue EOF ;
    public final EObject entryRuleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4061:2: (iv_ruleConstantValue= ruleConstantValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4062:2: iv_ruleConstantValue= ruleConstantValue EOF
            {
             newCompositeNode(grammarAccess.getConstantValueRule()); 
            pushFollow(FOLLOW_ruleConstantValue_in_entryRuleConstantValue8937);
            iv_ruleConstantValue=ruleConstantValue();

            state._fsp--;

             current =iv_ruleConstantValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstantValue8947); 

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
    // $ANTLR end "entryRuleConstantValue"


    // $ANTLR start "ruleConstantValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4069:1: ruleConstantValue returns [EObject current=null] : (this_StaticValue_0= ruleStaticValue | this_Constant_1= ruleConstant ) ;
    public final EObject ruleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject this_StaticValue_0 = null;

        EObject this_Constant_1 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4072:28: ( (this_StaticValue_0= ruleStaticValue | this_Constant_1= ruleConstant ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4073:1: (this_StaticValue_0= ruleStaticValue | this_Constant_1= ruleConstant )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4073:1: (this_StaticValue_0= ruleStaticValue | this_Constant_1= ruleConstant )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==RULE_STRING||(LA60_0>=RULE_INTEGER && LA60_0<=RULE_TWELVEHRSTIME)||LA60_0==69||LA60_0==71) ) {
                alt60=1;
            }
            else if ( (LA60_0==RULE_ID) ) {
                alt60=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4074:5: this_StaticValue_0= ruleStaticValue
                    {
                     
                            newCompositeNode(grammarAccess.getConstantValueAccess().getStaticValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleStaticValue_in_ruleConstantValue8994);
                    this_StaticValue_0=ruleStaticValue();

                    state._fsp--;

                     
                            current = this_StaticValue_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4084:5: this_Constant_1= ruleConstant
                    {
                     
                            newCompositeNode(grammarAccess.getConstantValueAccess().getConstantParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleConstant_in_ruleConstantValue9021);
                    this_Constant_1=ruleConstant();

                    state._fsp--;

                     
                            current = this_Constant_1; 
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
    // $ANTLR end "ruleConstantValue"


    // $ANTLR start "entryRuleStaticValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4100:1: entryRuleStaticValue returns [EObject current=null] : iv_ruleStaticValue= ruleStaticValue EOF ;
    public final EObject entryRuleStaticValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStaticValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4101:2: (iv_ruleStaticValue= ruleStaticValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4102:2: iv_ruleStaticValue= ruleStaticValue EOF
            {
             newCompositeNode(grammarAccess.getStaticValueRule()); 
            pushFollow(FOLLOW_ruleStaticValue_in_entryRuleStaticValue9056);
            iv_ruleStaticValue=ruleStaticValue();

            state._fsp--;

             current =iv_ruleStaticValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStaticValue9066); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4109:1: ruleStaticValue returns [EObject current=null] : (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_BooleanValue_3= ruleBooleanValue | this_DateValue_4= ruleDateValue | this_TimeValue_5= ruleTimeValue | this_DateAndTimeValue_6= ruleDateAndTimeValue | this_NullValue_7= ruleNullValue | this_JavaConstantValue_8= ruleJavaConstantValue ) ;
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

        EObject this_JavaConstantValue_8 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4112:28: ( (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_BooleanValue_3= ruleBooleanValue | this_DateValue_4= ruleDateValue | this_TimeValue_5= ruleTimeValue | this_DateAndTimeValue_6= ruleDateAndTimeValue | this_NullValue_7= ruleNullValue | this_JavaConstantValue_8= ruleJavaConstantValue ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4113:1: (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_BooleanValue_3= ruleBooleanValue | this_DateValue_4= ruleDateValue | this_TimeValue_5= ruleTimeValue | this_DateAndTimeValue_6= ruleDateAndTimeValue | this_NullValue_7= ruleNullValue | this_JavaConstantValue_8= ruleJavaConstantValue )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4113:1: (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_BooleanValue_3= ruleBooleanValue | this_DateValue_4= ruleDateValue | this_TimeValue_5= ruleTimeValue | this_DateAndTimeValue_6= ruleDateAndTimeValue | this_NullValue_7= ruleNullValue | this_JavaConstantValue_8= ruleJavaConstantValue )
            int alt61=9;
            alt61 = dfa61.predict(input);
            switch (alt61) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4114:5: this_StringValue_0= ruleStringValue
                    {
                     
                            newCompositeNode(grammarAccess.getStaticValueAccess().getStringValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleStringValue_in_ruleStaticValue9113);
                    this_StringValue_0=ruleStringValue();

                    state._fsp--;

                     
                            current = this_StringValue_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4124:5: this_IntegerValue_1= ruleIntegerValue
                    {
                     
                            newCompositeNode(grammarAccess.getStaticValueAccess().getIntegerValueParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleIntegerValue_in_ruleStaticValue9140);
                    this_IntegerValue_1=ruleIntegerValue();

                    state._fsp--;

                     
                            current = this_IntegerValue_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4134:5: this_DecimalValue_2= ruleDecimalValue
                    {
                     
                            newCompositeNode(grammarAccess.getStaticValueAccess().getDecimalValueParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleDecimalValue_in_ruleStaticValue9167);
                    this_DecimalValue_2=ruleDecimalValue();

                    state._fsp--;

                     
                            current = this_DecimalValue_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4144:5: this_BooleanValue_3= ruleBooleanValue
                    {
                     
                            newCompositeNode(grammarAccess.getStaticValueAccess().getBooleanValueParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleBooleanValue_in_ruleStaticValue9194);
                    this_BooleanValue_3=ruleBooleanValue();

                    state._fsp--;

                     
                            current = this_BooleanValue_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4154:5: this_DateValue_4= ruleDateValue
                    {
                     
                            newCompositeNode(grammarAccess.getStaticValueAccess().getDateValueParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleDateValue_in_ruleStaticValue9221);
                    this_DateValue_4=ruleDateValue();

                    state._fsp--;

                     
                            current = this_DateValue_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4164:5: this_TimeValue_5= ruleTimeValue
                    {
                     
                            newCompositeNode(grammarAccess.getStaticValueAccess().getTimeValueParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleTimeValue_in_ruleStaticValue9248);
                    this_TimeValue_5=ruleTimeValue();

                    state._fsp--;

                     
                            current = this_TimeValue_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4174:5: this_DateAndTimeValue_6= ruleDateAndTimeValue
                    {
                     
                            newCompositeNode(grammarAccess.getStaticValueAccess().getDateAndTimeValueParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_ruleDateAndTimeValue_in_ruleStaticValue9275);
                    this_DateAndTimeValue_6=ruleDateAndTimeValue();

                    state._fsp--;

                     
                            current = this_DateAndTimeValue_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4184:5: this_NullValue_7= ruleNullValue
                    {
                     
                            newCompositeNode(grammarAccess.getStaticValueAccess().getNullValueParserRuleCall_7()); 
                        
                    pushFollow(FOLLOW_ruleNullValue_in_ruleStaticValue9302);
                    this_NullValue_7=ruleNullValue();

                    state._fsp--;

                     
                            current = this_NullValue_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4194:5: this_JavaConstantValue_8= ruleJavaConstantValue
                    {
                     
                            newCompositeNode(grammarAccess.getStaticValueAccess().getJavaConstantValueParserRuleCall_8()); 
                        
                    pushFollow(FOLLOW_ruleJavaConstantValue_in_ruleStaticValue9329);
                    this_JavaConstantValue_8=ruleJavaConstantValue();

                    state._fsp--;

                     
                            current = this_JavaConstantValue_8; 
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4210:1: entryRuleIntegerValue returns [EObject current=null] : iv_ruleIntegerValue= ruleIntegerValue EOF ;
    public final EObject entryRuleIntegerValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4211:2: (iv_ruleIntegerValue= ruleIntegerValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4212:2: iv_ruleIntegerValue= ruleIntegerValue EOF
            {
             newCompositeNode(grammarAccess.getIntegerValueRule()); 
            pushFollow(FOLLOW_ruleIntegerValue_in_entryRuleIntegerValue9364);
            iv_ruleIntegerValue=ruleIntegerValue();

            state._fsp--;

             current =iv_ruleIntegerValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIntegerValue9374); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4219:1: ruleIntegerValue returns [EObject current=null] : ( (lv_integerValue_0_0= RULE_INTEGER ) ) ;
    public final EObject ruleIntegerValue() throws RecognitionException {
        EObject current = null;

        Token lv_integerValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4222:28: ( ( (lv_integerValue_0_0= RULE_INTEGER ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4223:1: ( (lv_integerValue_0_0= RULE_INTEGER ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4223:1: ( (lv_integerValue_0_0= RULE_INTEGER ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4224:1: (lv_integerValue_0_0= RULE_INTEGER )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4224:1: (lv_integerValue_0_0= RULE_INTEGER )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4225:3: lv_integerValue_0_0= RULE_INTEGER
            {
            lv_integerValue_0_0=(Token)match(input,RULE_INTEGER,FOLLOW_RULE_INTEGER_in_ruleIntegerValue9415); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4249:1: entryRuleDecimalValue returns [EObject current=null] : iv_ruleDecimalValue= ruleDecimalValue EOF ;
    public final EObject entryRuleDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecimalValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4250:2: (iv_ruleDecimalValue= ruleDecimalValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4251:2: iv_ruleDecimalValue= ruleDecimalValue EOF
            {
             newCompositeNode(grammarAccess.getDecimalValueRule()); 
            pushFollow(FOLLOW_ruleDecimalValue_in_entryRuleDecimalValue9455);
            iv_ruleDecimalValue=ruleDecimalValue();

            state._fsp--;

             current =iv_ruleDecimalValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDecimalValue9465); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4258:1: ruleDecimalValue returns [EObject current=null] : ( (lv_decimalValue_0_0= RULE_DECIMAL ) ) ;
    public final EObject ruleDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_decimalValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4261:28: ( ( (lv_decimalValue_0_0= RULE_DECIMAL ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4262:1: ( (lv_decimalValue_0_0= RULE_DECIMAL ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4262:1: ( (lv_decimalValue_0_0= RULE_DECIMAL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4263:1: (lv_decimalValue_0_0= RULE_DECIMAL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4263:1: (lv_decimalValue_0_0= RULE_DECIMAL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4264:3: lv_decimalValue_0_0= RULE_DECIMAL
            {
            lv_decimalValue_0_0=(Token)match(input,RULE_DECIMAL,FOLLOW_RULE_DECIMAL_in_ruleDecimalValue9506); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4288:1: entryRuleStringValue returns [EObject current=null] : iv_ruleStringValue= ruleStringValue EOF ;
    public final EObject entryRuleStringValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4289:2: (iv_ruleStringValue= ruleStringValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4290:2: iv_ruleStringValue= ruleStringValue EOF
            {
             newCompositeNode(grammarAccess.getStringValueRule()); 
            pushFollow(FOLLOW_ruleStringValue_in_entryRuleStringValue9546);
            iv_ruleStringValue=ruleStringValue();

            state._fsp--;

             current =iv_ruleStringValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringValue9556); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4297:1: ruleStringValue returns [EObject current=null] : ( (lv_stringValue_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringValue() throws RecognitionException {
        EObject current = null;

        Token lv_stringValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4300:28: ( ( (lv_stringValue_0_0= RULE_STRING ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4301:1: ( (lv_stringValue_0_0= RULE_STRING ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4301:1: ( (lv_stringValue_0_0= RULE_STRING ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4302:1: (lv_stringValue_0_0= RULE_STRING )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4302:1: (lv_stringValue_0_0= RULE_STRING )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4303:3: lv_stringValue_0_0= RULE_STRING
            {
            lv_stringValue_0_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleStringValue9597); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4327:1: entryRuleBooleanValue returns [EObject current=null] : iv_ruleBooleanValue= ruleBooleanValue EOF ;
    public final EObject entryRuleBooleanValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4328:2: (iv_ruleBooleanValue= ruleBooleanValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4329:2: iv_ruleBooleanValue= ruleBooleanValue EOF
            {
             newCompositeNode(grammarAccess.getBooleanValueRule()); 
            pushFollow(FOLLOW_ruleBooleanValue_in_entryRuleBooleanValue9637);
            iv_ruleBooleanValue=ruleBooleanValue();

            state._fsp--;

             current =iv_ruleBooleanValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanValue9647); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4336:1: ruleBooleanValue returns [EObject current=null] : ( ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) ) ) ;
    public final EObject ruleBooleanValue() throws RecognitionException {
        EObject current = null;

        Token lv_booleanValue_0_1=null;
        Token lv_booleanValue_0_2=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4339:28: ( ( ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4340:1: ( ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4340:1: ( ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4341:1: ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4341:1: ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4342:1: (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4342:1: (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==RULE_BOOLEAN_TRUE) ) {
                alt62=1;
            }
            else if ( (LA62_0==RULE_BOOLEAN_FALSE) ) {
                alt62=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4343:3: lv_booleanValue_0_1= RULE_BOOLEAN_TRUE
                    {
                    lv_booleanValue_0_1=(Token)match(input,RULE_BOOLEAN_TRUE,FOLLOW_RULE_BOOLEAN_TRUE_in_ruleBooleanValue9690); 

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
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4358:8: lv_booleanValue_0_2= RULE_BOOLEAN_FALSE
                    {
                    lv_booleanValue_0_2=(Token)match(input,RULE_BOOLEAN_FALSE,FOLLOW_RULE_BOOLEAN_FALSE_in_ruleBooleanValue9710); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4384:1: entryRuleDateValue returns [EObject current=null] : iv_ruleDateValue= ruleDateValue EOF ;
    public final EObject entryRuleDateValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4385:2: (iv_ruleDateValue= ruleDateValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4386:2: iv_ruleDateValue= ruleDateValue EOF
            {
             newCompositeNode(grammarAccess.getDateValueRule()); 
            pushFollow(FOLLOW_ruleDateValue_in_entryRuleDateValue9753);
            iv_ruleDateValue=ruleDateValue();

            state._fsp--;

             current =iv_ruleDateValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDateValue9763); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4393:1: ruleDateValue returns [EObject current=null] : (this_IsoDateValue_0= ruleIsoDateValue | this_EuropeanDateValue_1= ruleEuropeanDateValue | this_USDateValue_2= ruleUSDateValue ) ;
    public final EObject ruleDateValue() throws RecognitionException {
        EObject current = null;

        EObject this_IsoDateValue_0 = null;

        EObject this_EuropeanDateValue_1 = null;

        EObject this_USDateValue_2 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4396:28: ( (this_IsoDateValue_0= ruleIsoDateValue | this_EuropeanDateValue_1= ruleEuropeanDateValue | this_USDateValue_2= ruleUSDateValue ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4397:1: (this_IsoDateValue_0= ruleIsoDateValue | this_EuropeanDateValue_1= ruleEuropeanDateValue | this_USDateValue_2= ruleUSDateValue )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4397:1: (this_IsoDateValue_0= ruleIsoDateValue | this_EuropeanDateValue_1= ruleEuropeanDateValue | this_USDateValue_2= ruleUSDateValue )
            int alt63=3;
            switch ( input.LA(1) ) {
            case RULE_ISODATE:
                {
                alt63=1;
                }
                break;
            case RULE_EURODATE:
                {
                alt63=2;
                }
                break;
            case RULE_USDATE:
                {
                alt63=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }

            switch (alt63) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4398:5: this_IsoDateValue_0= ruleIsoDateValue
                    {
                     
                            newCompositeNode(grammarAccess.getDateValueAccess().getIsoDateValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleIsoDateValue_in_ruleDateValue9810);
                    this_IsoDateValue_0=ruleIsoDateValue();

                    state._fsp--;

                     
                            current = this_IsoDateValue_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4408:5: this_EuropeanDateValue_1= ruleEuropeanDateValue
                    {
                     
                            newCompositeNode(grammarAccess.getDateValueAccess().getEuropeanDateValueParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEuropeanDateValue_in_ruleDateValue9837);
                    this_EuropeanDateValue_1=ruleEuropeanDateValue();

                    state._fsp--;

                     
                            current = this_EuropeanDateValue_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4418:5: this_USDateValue_2= ruleUSDateValue
                    {
                     
                            newCompositeNode(grammarAccess.getDateValueAccess().getUSDateValueParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleUSDateValue_in_ruleDateValue9864);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4434:1: entryRuleIsoDateValue returns [EObject current=null] : iv_ruleIsoDateValue= ruleIsoDateValue EOF ;
    public final EObject entryRuleIsoDateValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsoDateValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4435:2: (iv_ruleIsoDateValue= ruleIsoDateValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4436:2: iv_ruleIsoDateValue= ruleIsoDateValue EOF
            {
             newCompositeNode(grammarAccess.getIsoDateValueRule()); 
            pushFollow(FOLLOW_ruleIsoDateValue_in_entryRuleIsoDateValue9899);
            iv_ruleIsoDateValue=ruleIsoDateValue();

            state._fsp--;

             current =iv_ruleIsoDateValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIsoDateValue9909); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4443:1: ruleIsoDateValue returns [EObject current=null] : ( (lv_dateValue_0_0= RULE_ISODATE ) ) ;
    public final EObject ruleIsoDateValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4446:28: ( ( (lv_dateValue_0_0= RULE_ISODATE ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4447:1: ( (lv_dateValue_0_0= RULE_ISODATE ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4447:1: ( (lv_dateValue_0_0= RULE_ISODATE ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4448:1: (lv_dateValue_0_0= RULE_ISODATE )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4448:1: (lv_dateValue_0_0= RULE_ISODATE )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4449:3: lv_dateValue_0_0= RULE_ISODATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_ISODATE,FOLLOW_RULE_ISODATE_in_ruleIsoDateValue9950); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4473:1: entryRuleEuropeanDateValue returns [EObject current=null] : iv_ruleEuropeanDateValue= ruleEuropeanDateValue EOF ;
    public final EObject entryRuleEuropeanDateValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEuropeanDateValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4474:2: (iv_ruleEuropeanDateValue= ruleEuropeanDateValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4475:2: iv_ruleEuropeanDateValue= ruleEuropeanDateValue EOF
            {
             newCompositeNode(grammarAccess.getEuropeanDateValueRule()); 
            pushFollow(FOLLOW_ruleEuropeanDateValue_in_entryRuleEuropeanDateValue9990);
            iv_ruleEuropeanDateValue=ruleEuropeanDateValue();

            state._fsp--;

             current =iv_ruleEuropeanDateValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEuropeanDateValue10000); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4482:1: ruleEuropeanDateValue returns [EObject current=null] : ( (lv_dateValue_0_0= RULE_EURODATE ) ) ;
    public final EObject ruleEuropeanDateValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4485:28: ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4486:1: ( (lv_dateValue_0_0= RULE_EURODATE ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4486:1: ( (lv_dateValue_0_0= RULE_EURODATE ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4487:1: (lv_dateValue_0_0= RULE_EURODATE )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4487:1: (lv_dateValue_0_0= RULE_EURODATE )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4488:3: lv_dateValue_0_0= RULE_EURODATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_EURODATE,FOLLOW_RULE_EURODATE_in_ruleEuropeanDateValue10041); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4512:1: entryRuleUSDateValue returns [EObject current=null] : iv_ruleUSDateValue= ruleUSDateValue EOF ;
    public final EObject entryRuleUSDateValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUSDateValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4513:2: (iv_ruleUSDateValue= ruleUSDateValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4514:2: iv_ruleUSDateValue= ruleUSDateValue EOF
            {
             newCompositeNode(grammarAccess.getUSDateValueRule()); 
            pushFollow(FOLLOW_ruleUSDateValue_in_entryRuleUSDateValue10081);
            iv_ruleUSDateValue=ruleUSDateValue();

            state._fsp--;

             current =iv_ruleUSDateValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUSDateValue10091); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4521:1: ruleUSDateValue returns [EObject current=null] : ( (lv_dateValue_0_0= RULE_USDATE ) ) ;
    public final EObject ruleUSDateValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4524:28: ( ( (lv_dateValue_0_0= RULE_USDATE ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4525:1: ( (lv_dateValue_0_0= RULE_USDATE ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4525:1: ( (lv_dateValue_0_0= RULE_USDATE ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4526:1: (lv_dateValue_0_0= RULE_USDATE )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4526:1: (lv_dateValue_0_0= RULE_USDATE )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4527:3: lv_dateValue_0_0= RULE_USDATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_USDATE,FOLLOW_RULE_USDATE_in_ruleUSDateValue10132); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4551:1: entryRuleTimeValue returns [EObject current=null] : iv_ruleTimeValue= ruleTimeValue EOF ;
    public final EObject entryRuleTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4552:2: (iv_ruleTimeValue= ruleTimeValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4553:2: iv_ruleTimeValue= ruleTimeValue EOF
            {
             newCompositeNode(grammarAccess.getTimeValueRule()); 
            pushFollow(FOLLOW_ruleTimeValue_in_entryRuleTimeValue10172);
            iv_ruleTimeValue=ruleTimeValue();

            state._fsp--;

             current =iv_ruleTimeValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTimeValue10182); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4560:1: ruleTimeValue returns [EObject current=null] : (this_IsoTimeValue_0= ruleIsoTimeValue | this_Simple24HrsTimeValue_1= ruleSimple24HrsTimeValue | this_Simple12HrsTimeValue_2= ruleSimple12HrsTimeValue ) ;
    public final EObject ruleTimeValue() throws RecognitionException {
        EObject current = null;

        EObject this_IsoTimeValue_0 = null;

        EObject this_Simple24HrsTimeValue_1 = null;

        EObject this_Simple12HrsTimeValue_2 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4563:28: ( (this_IsoTimeValue_0= ruleIsoTimeValue | this_Simple24HrsTimeValue_1= ruleSimple24HrsTimeValue | this_Simple12HrsTimeValue_2= ruleSimple12HrsTimeValue ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4564:1: (this_IsoTimeValue_0= ruleIsoTimeValue | this_Simple24HrsTimeValue_1= ruleSimple24HrsTimeValue | this_Simple12HrsTimeValue_2= ruleSimple12HrsTimeValue )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4564:1: (this_IsoTimeValue_0= ruleIsoTimeValue | this_Simple24HrsTimeValue_1= ruleSimple24HrsTimeValue | this_Simple12HrsTimeValue_2= ruleSimple12HrsTimeValue )
            int alt64=3;
            switch ( input.LA(1) ) {
            case RULE_ISOTIME:
                {
                alt64=1;
                }
                break;
            case RULE_TWENTYFOURHRSTIME:
                {
                alt64=2;
                }
                break;
            case RULE_TWELVEHRSTIME:
                {
                alt64=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 64, 0, input);

                throw nvae;
            }

            switch (alt64) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4565:5: this_IsoTimeValue_0= ruleIsoTimeValue
                    {
                     
                            newCompositeNode(grammarAccess.getTimeValueAccess().getIsoTimeValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleIsoTimeValue_in_ruleTimeValue10229);
                    this_IsoTimeValue_0=ruleIsoTimeValue();

                    state._fsp--;

                     
                            current = this_IsoTimeValue_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4575:5: this_Simple24HrsTimeValue_1= ruleSimple24HrsTimeValue
                    {
                     
                            newCompositeNode(grammarAccess.getTimeValueAccess().getSimple24HrsTimeValueParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleSimple24HrsTimeValue_in_ruleTimeValue10256);
                    this_Simple24HrsTimeValue_1=ruleSimple24HrsTimeValue();

                    state._fsp--;

                     
                            current = this_Simple24HrsTimeValue_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4585:5: this_Simple12HrsTimeValue_2= ruleSimple12HrsTimeValue
                    {
                     
                            newCompositeNode(grammarAccess.getTimeValueAccess().getSimple12HrsTimeValueParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleSimple12HrsTimeValue_in_ruleTimeValue10283);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4601:1: entryRuleIsoTimeValue returns [EObject current=null] : iv_ruleIsoTimeValue= ruleIsoTimeValue EOF ;
    public final EObject entryRuleIsoTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsoTimeValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4602:2: (iv_ruleIsoTimeValue= ruleIsoTimeValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4603:2: iv_ruleIsoTimeValue= ruleIsoTimeValue EOF
            {
             newCompositeNode(grammarAccess.getIsoTimeValueRule()); 
            pushFollow(FOLLOW_ruleIsoTimeValue_in_entryRuleIsoTimeValue10318);
            iv_ruleIsoTimeValue=ruleIsoTimeValue();

            state._fsp--;

             current =iv_ruleIsoTimeValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIsoTimeValue10328); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4610:1: ruleIsoTimeValue returns [EObject current=null] : ( (lv_timeValue_0_0= RULE_ISOTIME ) ) ;
    public final EObject ruleIsoTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_timeValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4613:28: ( ( (lv_timeValue_0_0= RULE_ISOTIME ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4614:1: ( (lv_timeValue_0_0= RULE_ISOTIME ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4614:1: ( (lv_timeValue_0_0= RULE_ISOTIME ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4615:1: (lv_timeValue_0_0= RULE_ISOTIME )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4615:1: (lv_timeValue_0_0= RULE_ISOTIME )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4616:3: lv_timeValue_0_0= RULE_ISOTIME
            {
            lv_timeValue_0_0=(Token)match(input,RULE_ISOTIME,FOLLOW_RULE_ISOTIME_in_ruleIsoTimeValue10369); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4640:1: entryRuleSimple24HrsTimeValue returns [EObject current=null] : iv_ruleSimple24HrsTimeValue= ruleSimple24HrsTimeValue EOF ;
    public final EObject entryRuleSimple24HrsTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimple24HrsTimeValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4641:2: (iv_ruleSimple24HrsTimeValue= ruleSimple24HrsTimeValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4642:2: iv_ruleSimple24HrsTimeValue= ruleSimple24HrsTimeValue EOF
            {
             newCompositeNode(grammarAccess.getSimple24HrsTimeValueRule()); 
            pushFollow(FOLLOW_ruleSimple24HrsTimeValue_in_entryRuleSimple24HrsTimeValue10409);
            iv_ruleSimple24HrsTimeValue=ruleSimple24HrsTimeValue();

            state._fsp--;

             current =iv_ruleSimple24HrsTimeValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimple24HrsTimeValue10419); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4649:1: ruleSimple24HrsTimeValue returns [EObject current=null] : ( (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME ) ) ;
    public final EObject ruleSimple24HrsTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_timeValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4652:28: ( ( (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4653:1: ( (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4653:1: ( (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4654:1: (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4654:1: (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4655:3: lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME
            {
            lv_timeValue_0_0=(Token)match(input,RULE_TWENTYFOURHRSTIME,FOLLOW_RULE_TWENTYFOURHRSTIME_in_ruleSimple24HrsTimeValue10460); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4679:1: entryRuleSimple12HrsTimeValue returns [EObject current=null] : iv_ruleSimple12HrsTimeValue= ruleSimple12HrsTimeValue EOF ;
    public final EObject entryRuleSimple12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimple12HrsTimeValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4680:2: (iv_ruleSimple12HrsTimeValue= ruleSimple12HrsTimeValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4681:2: iv_ruleSimple12HrsTimeValue= ruleSimple12HrsTimeValue EOF
            {
             newCompositeNode(grammarAccess.getSimple12HrsTimeValueRule()); 
            pushFollow(FOLLOW_ruleSimple12HrsTimeValue_in_entryRuleSimple12HrsTimeValue10500);
            iv_ruleSimple12HrsTimeValue=ruleSimple12HrsTimeValue();

            state._fsp--;

             current =iv_ruleSimple12HrsTimeValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimple12HrsTimeValue10510); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4688:1: ruleSimple12HrsTimeValue returns [EObject current=null] : ( (lv_timeValue_0_0= RULE_TWELVEHRSTIME ) ) ;
    public final EObject ruleSimple12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_timeValue_0_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4691:28: ( ( (lv_timeValue_0_0= RULE_TWELVEHRSTIME ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4692:1: ( (lv_timeValue_0_0= RULE_TWELVEHRSTIME ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4692:1: ( (lv_timeValue_0_0= RULE_TWELVEHRSTIME ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4693:1: (lv_timeValue_0_0= RULE_TWELVEHRSTIME )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4693:1: (lv_timeValue_0_0= RULE_TWELVEHRSTIME )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4694:3: lv_timeValue_0_0= RULE_TWELVEHRSTIME
            {
            lv_timeValue_0_0=(Token)match(input,RULE_TWELVEHRSTIME,FOLLOW_RULE_TWELVEHRSTIME_in_ruleSimple12HrsTimeValue10551); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4718:1: entryRuleDateAndTimeValue returns [EObject current=null] : iv_ruleDateAndTimeValue= ruleDateAndTimeValue EOF ;
    public final EObject entryRuleDateAndTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateAndTimeValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4719:2: (iv_ruleDateAndTimeValue= ruleDateAndTimeValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4720:2: iv_ruleDateAndTimeValue= ruleDateAndTimeValue EOF
            {
             newCompositeNode(grammarAccess.getDateAndTimeValueRule()); 
            pushFollow(FOLLOW_ruleDateAndTimeValue_in_entryRuleDateAndTimeValue10591);
            iv_ruleDateAndTimeValue=ruleDateAndTimeValue();

            state._fsp--;

             current =iv_ruleDateAndTimeValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDateAndTimeValue10601); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4727:1: ruleDateAndTimeValue returns [EObject current=null] : (this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue | this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue | this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue | this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue ) ;
    public final EObject ruleDateAndTimeValue() throws RecognitionException {
        EObject current = null;

        EObject this_IsoDateAndTimeValue_0 = null;

        EObject this_EuropeanDateAnd24HrsTimeValue_1 = null;

        EObject this_EuropeanDateAnd12HrsTimeValue_2 = null;

        EObject this_USDateAnd12HrsTimeValue_3 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4730:28: ( (this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue | this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue | this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue | this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4731:1: (this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue | this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue | this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue | this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4731:1: (this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue | this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue | this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue | this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue )
            int alt65=4;
            alt65 = dfa65.predict(input);
            switch (alt65) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4732:5: this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue
                    {
                     
                            newCompositeNode(grammarAccess.getDateAndTimeValueAccess().getIsoDateAndTimeValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleIsoDateAndTimeValue_in_ruleDateAndTimeValue10648);
                    this_IsoDateAndTimeValue_0=ruleIsoDateAndTimeValue();

                    state._fsp--;

                     
                            current = this_IsoDateAndTimeValue_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4742:5: this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue
                    {
                     
                            newCompositeNode(grammarAccess.getDateAndTimeValueAccess().getEuropeanDateAnd24HrsTimeValueParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleEuropeanDateAnd24HrsTimeValue_in_ruleDateAndTimeValue10675);
                    this_EuropeanDateAnd24HrsTimeValue_1=ruleEuropeanDateAnd24HrsTimeValue();

                    state._fsp--;

                     
                            current = this_EuropeanDateAnd24HrsTimeValue_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4752:5: this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue
                    {
                     
                            newCompositeNode(grammarAccess.getDateAndTimeValueAccess().getEuropeanDateAnd12HrsTimeValueParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleEuropeanDateAnd12HrsTimeValue_in_ruleDateAndTimeValue10702);
                    this_EuropeanDateAnd12HrsTimeValue_2=ruleEuropeanDateAnd12HrsTimeValue();

                    state._fsp--;

                     
                            current = this_EuropeanDateAnd12HrsTimeValue_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4762:5: this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue
                    {
                     
                            newCompositeNode(grammarAccess.getDateAndTimeValueAccess().getUSDateAnd12HrsTimeValueParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleUSDateAnd12HrsTimeValue_in_ruleDateAndTimeValue10729);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4778:1: entryRuleIsoDateAndTimeValue returns [EObject current=null] : iv_ruleIsoDateAndTimeValue= ruleIsoDateAndTimeValue EOF ;
    public final EObject entryRuleIsoDateAndTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsoDateAndTimeValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4779:2: (iv_ruleIsoDateAndTimeValue= ruleIsoDateAndTimeValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4780:2: iv_ruleIsoDateAndTimeValue= ruleIsoDateAndTimeValue EOF
            {
             newCompositeNode(grammarAccess.getIsoDateAndTimeValueRule()); 
            pushFollow(FOLLOW_ruleIsoDateAndTimeValue_in_entryRuleIsoDateAndTimeValue10764);
            iv_ruleIsoDateAndTimeValue=ruleIsoDateAndTimeValue();

            state._fsp--;

             current =iv_ruleIsoDateAndTimeValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIsoDateAndTimeValue10774); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4787:1: ruleIsoDateAndTimeValue returns [EObject current=null] : ( ( (lv_dateValue_0_0= RULE_ISODATE ) ) ( (lv_timeValue_1_0= RULE_ISOTIME ) ) ) ;
    public final EObject ruleIsoDateAndTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;
        Token lv_timeValue_1_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4790:28: ( ( ( (lv_dateValue_0_0= RULE_ISODATE ) ) ( (lv_timeValue_1_0= RULE_ISOTIME ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4791:1: ( ( (lv_dateValue_0_0= RULE_ISODATE ) ) ( (lv_timeValue_1_0= RULE_ISOTIME ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4791:1: ( ( (lv_dateValue_0_0= RULE_ISODATE ) ) ( (lv_timeValue_1_0= RULE_ISOTIME ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4791:2: ( (lv_dateValue_0_0= RULE_ISODATE ) ) ( (lv_timeValue_1_0= RULE_ISOTIME ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4791:2: ( (lv_dateValue_0_0= RULE_ISODATE ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4792:1: (lv_dateValue_0_0= RULE_ISODATE )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4792:1: (lv_dateValue_0_0= RULE_ISODATE )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4793:3: lv_dateValue_0_0= RULE_ISODATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_ISODATE,FOLLOW_RULE_ISODATE_in_ruleIsoDateAndTimeValue10816); 

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

            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4809:2: ( (lv_timeValue_1_0= RULE_ISOTIME ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4810:1: (lv_timeValue_1_0= RULE_ISOTIME )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4810:1: (lv_timeValue_1_0= RULE_ISOTIME )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4811:3: lv_timeValue_1_0= RULE_ISOTIME
            {
            lv_timeValue_1_0=(Token)match(input,RULE_ISOTIME,FOLLOW_RULE_ISOTIME_in_ruleIsoDateAndTimeValue10838); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4835:1: entryRuleEuropeanDateAnd24HrsTimeValue returns [EObject current=null] : iv_ruleEuropeanDateAnd24HrsTimeValue= ruleEuropeanDateAnd24HrsTimeValue EOF ;
    public final EObject entryRuleEuropeanDateAnd24HrsTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEuropeanDateAnd24HrsTimeValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4836:2: (iv_ruleEuropeanDateAnd24HrsTimeValue= ruleEuropeanDateAnd24HrsTimeValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4837:2: iv_ruleEuropeanDateAnd24HrsTimeValue= ruleEuropeanDateAnd24HrsTimeValue EOF
            {
             newCompositeNode(grammarAccess.getEuropeanDateAnd24HrsTimeValueRule()); 
            pushFollow(FOLLOW_ruleEuropeanDateAnd24HrsTimeValue_in_entryRuleEuropeanDateAnd24HrsTimeValue10879);
            iv_ruleEuropeanDateAnd24HrsTimeValue=ruleEuropeanDateAnd24HrsTimeValue();

            state._fsp--;

             current =iv_ruleEuropeanDateAnd24HrsTimeValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEuropeanDateAnd24HrsTimeValue10889); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4844:1: ruleEuropeanDateAnd24HrsTimeValue returns [EObject current=null] : ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) ) ) ;
    public final EObject ruleEuropeanDateAnd24HrsTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;
        Token lv_timeValue_2_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4847:28: ( ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4848:1: ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4848:1: ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4848:2: ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4848:2: ( (lv_dateValue_0_0= RULE_EURODATE ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4849:1: (lv_dateValue_0_0= RULE_EURODATE )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4849:1: (lv_dateValue_0_0= RULE_EURODATE )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4850:3: lv_dateValue_0_0= RULE_EURODATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_EURODATE,FOLLOW_RULE_EURODATE_in_ruleEuropeanDateAnd24HrsTimeValue10931); 

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
                
            pushFollow(FOLLOW_ruleNL_in_ruleEuropeanDateAnd24HrsTimeValue10952);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4874:1: ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4875:1: (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4875:1: (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4876:3: lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME
            {
            lv_timeValue_2_0=(Token)match(input,RULE_TWENTYFOURHRSTIME,FOLLOW_RULE_TWENTYFOURHRSTIME_in_ruleEuropeanDateAnd24HrsTimeValue10968); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4900:1: entryRuleEuropeanDateAnd12HrsTimeValue returns [EObject current=null] : iv_ruleEuropeanDateAnd12HrsTimeValue= ruleEuropeanDateAnd12HrsTimeValue EOF ;
    public final EObject entryRuleEuropeanDateAnd12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEuropeanDateAnd12HrsTimeValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4901:2: (iv_ruleEuropeanDateAnd12HrsTimeValue= ruleEuropeanDateAnd12HrsTimeValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4902:2: iv_ruleEuropeanDateAnd12HrsTimeValue= ruleEuropeanDateAnd12HrsTimeValue EOF
            {
             newCompositeNode(grammarAccess.getEuropeanDateAnd12HrsTimeValueRule()); 
            pushFollow(FOLLOW_ruleEuropeanDateAnd12HrsTimeValue_in_entryRuleEuropeanDateAnd12HrsTimeValue11009);
            iv_ruleEuropeanDateAnd12HrsTimeValue=ruleEuropeanDateAnd12HrsTimeValue();

            state._fsp--;

             current =iv_ruleEuropeanDateAnd12HrsTimeValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEuropeanDateAnd12HrsTimeValue11019); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4909:1: ruleEuropeanDateAnd12HrsTimeValue returns [EObject current=null] : ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) ) ;
    public final EObject ruleEuropeanDateAnd12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;
        Token lv_timeValue_2_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4912:28: ( ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4913:1: ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4913:1: ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4913:2: ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4913:2: ( (lv_dateValue_0_0= RULE_EURODATE ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4914:1: (lv_dateValue_0_0= RULE_EURODATE )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4914:1: (lv_dateValue_0_0= RULE_EURODATE )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4915:3: lv_dateValue_0_0= RULE_EURODATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_EURODATE,FOLLOW_RULE_EURODATE_in_ruleEuropeanDateAnd12HrsTimeValue11061); 

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
                
            pushFollow(FOLLOW_ruleNL_in_ruleEuropeanDateAnd12HrsTimeValue11082);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4939:1: ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4940:1: (lv_timeValue_2_0= RULE_TWELVEHRSTIME )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4940:1: (lv_timeValue_2_0= RULE_TWELVEHRSTIME )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4941:3: lv_timeValue_2_0= RULE_TWELVEHRSTIME
            {
            lv_timeValue_2_0=(Token)match(input,RULE_TWELVEHRSTIME,FOLLOW_RULE_TWELVEHRSTIME_in_ruleEuropeanDateAnd12HrsTimeValue11098); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4965:1: entryRuleUSDateAnd12HrsTimeValue returns [EObject current=null] : iv_ruleUSDateAnd12HrsTimeValue= ruleUSDateAnd12HrsTimeValue EOF ;
    public final EObject entryRuleUSDateAnd12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUSDateAnd12HrsTimeValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4966:2: (iv_ruleUSDateAnd12HrsTimeValue= ruleUSDateAnd12HrsTimeValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4967:2: iv_ruleUSDateAnd12HrsTimeValue= ruleUSDateAnd12HrsTimeValue EOF
            {
             newCompositeNode(grammarAccess.getUSDateAnd12HrsTimeValueRule()); 
            pushFollow(FOLLOW_ruleUSDateAnd12HrsTimeValue_in_entryRuleUSDateAnd12HrsTimeValue11139);
            iv_ruleUSDateAnd12HrsTimeValue=ruleUSDateAnd12HrsTimeValue();

            state._fsp--;

             current =iv_ruleUSDateAnd12HrsTimeValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUSDateAnd12HrsTimeValue11149); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4974:1: ruleUSDateAnd12HrsTimeValue returns [EObject current=null] : ( ( (lv_dateValue_0_0= RULE_USDATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) ) ;
    public final EObject ruleUSDateAnd12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;
        Token lv_timeValue_2_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4977:28: ( ( ( (lv_dateValue_0_0= RULE_USDATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4978:1: ( ( (lv_dateValue_0_0= RULE_USDATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4978:1: ( ( (lv_dateValue_0_0= RULE_USDATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4978:2: ( (lv_dateValue_0_0= RULE_USDATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4978:2: ( (lv_dateValue_0_0= RULE_USDATE ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4979:1: (lv_dateValue_0_0= RULE_USDATE )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4979:1: (lv_dateValue_0_0= RULE_USDATE )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:4980:3: lv_dateValue_0_0= RULE_USDATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_USDATE,FOLLOW_RULE_USDATE_in_ruleUSDateAnd12HrsTimeValue11191); 

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
                
            pushFollow(FOLLOW_ruleNL_in_ruleUSDateAnd12HrsTimeValue11212);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5004:1: ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5005:1: (lv_timeValue_2_0= RULE_TWELVEHRSTIME )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5005:1: (lv_timeValue_2_0= RULE_TWELVEHRSTIME )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5006:3: lv_timeValue_2_0= RULE_TWELVEHRSTIME
            {
            lv_timeValue_2_0=(Token)match(input,RULE_TWELVEHRSTIME,FOLLOW_RULE_TWELVEHRSTIME_in_ruleUSDateAnd12HrsTimeValue11228); 

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


    // $ANTLR start "entryRuleJavaConstantValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5030:1: entryRuleJavaConstantValue returns [EObject current=null] : iv_ruleJavaConstantValue= ruleJavaConstantValue EOF ;
    public final EObject entryRuleJavaConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaConstantValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5031:2: (iv_ruleJavaConstantValue= ruleJavaConstantValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5032:2: iv_ruleJavaConstantValue= ruleJavaConstantValue EOF
            {
             newCompositeNode(grammarAccess.getJavaConstantValueRule()); 
            pushFollow(FOLLOW_ruleJavaConstantValue_in_entryRuleJavaConstantValue11269);
            iv_ruleJavaConstantValue=ruleJavaConstantValue();

            state._fsp--;

             current =iv_ruleJavaConstantValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJavaConstantValue11279); 

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
    // $ANTLR end "entryRuleJavaConstantValue"


    // $ANTLR start "ruleJavaConstantValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5039:1: ruleJavaConstantValue returns [EObject current=null] : (otherlv_0= '<' ( (lv_constant_1_0= ruleJavaConstantReference ) ) otherlv_2= '>' ) ;
    public final EObject ruleJavaConstantValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_constant_1_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5042:28: ( (otherlv_0= '<' ( (lv_constant_1_0= ruleJavaConstantReference ) ) otherlv_2= '>' ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5043:1: (otherlv_0= '<' ( (lv_constant_1_0= ruleJavaConstantReference ) ) otherlv_2= '>' )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5043:1: (otherlv_0= '<' ( (lv_constant_1_0= ruleJavaConstantReference ) ) otherlv_2= '>' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5043:3: otherlv_0= '<' ( (lv_constant_1_0= ruleJavaConstantReference ) ) otherlv_2= '>'
            {
            otherlv_0=(Token)match(input,69,FOLLOW_69_in_ruleJavaConstantValue11316); 

                	newLeafNode(otherlv_0, grammarAccess.getJavaConstantValueAccess().getLessThanSignKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5047:1: ( (lv_constant_1_0= ruleJavaConstantReference ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5048:1: (lv_constant_1_0= ruleJavaConstantReference )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5048:1: (lv_constant_1_0= ruleJavaConstantReference )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5049:3: lv_constant_1_0= ruleJavaConstantReference
            {
             
            	        newCompositeNode(grammarAccess.getJavaConstantValueAccess().getConstantJavaConstantReferenceParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleJavaConstantReference_in_ruleJavaConstantValue11337);
            lv_constant_1_0=ruleJavaConstantReference();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getJavaConstantValueRule());
            	        }
                   		set(
                   			current, 
                   			"constant",
                    		lv_constant_1_0, 
                    		"JavaConstantReference");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,70,FOLLOW_70_in_ruleJavaConstantValue11349); 

                	newLeafNode(otherlv_2, grammarAccess.getJavaConstantValueAccess().getGreaterThanSignKeyword_2());
                

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
    // $ANTLR end "ruleJavaConstantValue"


    // $ANTLR start "entryRuleVariable"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5077:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5078:2: (iv_ruleVariable= ruleVariable EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5079:2: iv_ruleVariable= ruleVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable11385);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable11395); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5086:1: ruleVariable returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5089:28: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5090:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5090:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5091:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5091:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5092:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getVariableRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getVariableAccess().getNameVariableOrConstantEntityCrossReference_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleVariable11442);
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


    // $ANTLR start "entryRuleVariableVariable"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5113:1: entryRuleVariableVariable returns [EObject current=null] : iv_ruleVariableVariable= ruleVariableVariable EOF ;
    public final EObject entryRuleVariableVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableVariable = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5114:2: (iv_ruleVariableVariable= ruleVariableVariable EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5115:2: iv_ruleVariableVariable= ruleVariableVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableVariableRule()); 
            pushFollow(FOLLOW_ruleVariableVariable_in_entryRuleVariableVariable11477);
            iv_ruleVariableVariable=ruleVariableVariable();

            state._fsp--;

             current =iv_ruleVariableVariable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableVariable11487); 

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
    // $ANTLR end "entryRuleVariableVariable"


    // $ANTLR start "ruleVariableVariable"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5122:1: ruleVariableVariable returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleVariableVariable() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5125:28: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5126:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5126:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5127:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5127:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5128:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getVariableVariableRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getVariableVariableAccess().getNameVariableEntityCrossReference_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleVariableVariable11534);
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
    // $ANTLR end "ruleVariableVariable"


    // $ANTLR start "entryRuleConstant"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5149:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5150:2: (iv_ruleConstant= ruleConstant EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5151:2: iv_ruleConstant= ruleConstant EOF
            {
             newCompositeNode(grammarAccess.getConstantRule()); 
            pushFollow(FOLLOW_ruleConstant_in_entryRuleConstant11569);
            iv_ruleConstant=ruleConstant();

            state._fsp--;

             current =iv_ruleConstant; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstant11579); 

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
    // $ANTLR end "entryRuleConstant"


    // $ANTLR start "ruleConstant"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5158:1: ruleConstant returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5161:28: ( ( ( ruleQualifiedName ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5162:1: ( ( ruleQualifiedName ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5162:1: ( ( ruleQualifiedName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5163:1: ( ruleQualifiedName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5163:1: ( ruleQualifiedName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5164:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConstantRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConstantAccess().getNameConstantEntityCrossReference_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleConstant11626);
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
    // $ANTLR end "ruleConstant"


    // $ANTLR start "entryRuleNullValue"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5185:1: entryRuleNullValue returns [EObject current=null] : iv_ruleNullValue= ruleNullValue EOF ;
    public final EObject entryRuleNullValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5186:2: (iv_ruleNullValue= ruleNullValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5187:2: iv_ruleNullValue= ruleNullValue EOF
            {
             newCompositeNode(grammarAccess.getNullValueRule()); 
            pushFollow(FOLLOW_ruleNullValue_in_entryRuleNullValue11661);
            iv_ruleNullValue=ruleNullValue();

            state._fsp--;

             current =iv_ruleNullValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullValue11671); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5194:1: ruleNullValue returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5197:28: ( ( () otherlv_1= 'null' ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5198:1: ( () otherlv_1= 'null' )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5198:1: ( () otherlv_1= 'null' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5198:2: () otherlv_1= 'null'
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5198:2: ()
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5199:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNullValueAccess().getNullAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,71,FOLLOW_71_in_ruleNullValue11717); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5216:1: entryRuleEnumValue returns [EObject current=null] : iv_ruleEnumValue= ruleEnumValue EOF ;
    public final EObject entryRuleEnumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumValue = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5217:2: (iv_ruleEnumValue= ruleEnumValue EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5218:2: iv_ruleEnumValue= ruleEnumValue EOF
            {
             newCompositeNode(grammarAccess.getEnumValueRule()); 
            pushFollow(FOLLOW_ruleEnumValue_in_entryRuleEnumValue11753);
            iv_ruleEnumValue=ruleEnumValue();

            state._fsp--;

             current =iv_ruleEnumValue; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEnumValue11763); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5225:1: ruleEnumValue returns [EObject current=null] : ( (otherlv_0= RULE_UPPERCASE_ID ) ) ;
    public final EObject ruleEnumValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5228:28: ( ( (otherlv_0= RULE_UPPERCASE_ID ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5229:1: ( (otherlv_0= RULE_UPPERCASE_ID ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5229:1: ( (otherlv_0= RULE_UPPERCASE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5230:1: (otherlv_0= RULE_UPPERCASE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5230:1: (otherlv_0= RULE_UPPERCASE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5231:3: otherlv_0= RULE_UPPERCASE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumValueRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_UPPERCASE_ID,FOLLOW_RULE_UPPERCASE_ID_in_ruleEnumValue11807); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5250:1: entryRuleNestedObject returns [EObject current=null] : iv_ruleNestedObject= ruleNestedObject EOF ;
    public final EObject entryRuleNestedObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedObject = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5251:2: (iv_ruleNestedObject= ruleNestedObject EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5252:2: iv_ruleNestedObject= ruleNestedObject EOF
            {
             newCompositeNode(grammarAccess.getNestedObjectRule()); 
            pushFollow(FOLLOW_ruleNestedObject_in_entryRuleNestedObject11842);
            iv_ruleNestedObject=ruleNestedObject();

            state._fsp--;

             current =iv_ruleNestedObject; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNestedObject11852); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5259:1: ruleNestedObject returns [EObject current=null] : (otherlv_0= '{' ruleNL ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+ otherlv_4= '}' ) ;
    public final EObject ruleNestedObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject lv_attributes_2_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5262:28: ( (otherlv_0= '{' ruleNL ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+ otherlv_4= '}' ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5263:1: (otherlv_0= '{' ruleNL ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+ otherlv_4= '}' )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5263:1: (otherlv_0= '{' ruleNL ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+ otherlv_4= '}' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5263:3: otherlv_0= '{' ruleNL ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,72,FOLLOW_72_in_ruleNestedObject11889); 

                	newLeafNode(otherlv_0, grammarAccess.getNestedObjectAccess().getLeftCurlyBracketKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getNestedObjectAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleNestedObject11905);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5275:1: ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+
            int cnt66=0;
            loop66:
            do {
                int alt66=2;
                int LA66_0 = input.LA(1);

                if ( ((LA66_0>=RULE_STRING && LA66_0<=RULE_ID)) ) {
                    alt66=1;
                }


                switch (alt66) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5275:2: ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5275:2: ( (lv_attributes_2_0= ruleKeyValuePair ) )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5276:1: (lv_attributes_2_0= ruleKeyValuePair )
            	    {
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5276:1: (lv_attributes_2_0= ruleKeyValuePair )
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5277:3: lv_attributes_2_0= ruleKeyValuePair
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getNestedObjectAccess().getAttributesKeyValuePairParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleKeyValuePair_in_ruleNestedObject11926);
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
            	        
            	    pushFollow(FOLLOW_ruleNL_in_ruleNestedObject11942);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt66 >= 1 ) break loop66;
                        EarlyExitException eee =
                            new EarlyExitException(66, input);
                        throw eee;
                }
                cnt66++;
            } while (true);

            otherlv_4=(Token)match(input,73,FOLLOW_73_in_ruleNestedObject11955); 

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


    // $ANTLR start "entryRuleTypedNestedObject"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5313:1: entryRuleTypedNestedObject returns [EObject current=null] : iv_ruleTypedNestedObject= ruleTypedNestedObject EOF ;
    public final EObject entryRuleTypedNestedObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedNestedObject = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5314:2: (iv_ruleTypedNestedObject= ruleTypedNestedObject EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5315:2: iv_ruleTypedNestedObject= ruleTypedNestedObject EOF
            {
             newCompositeNode(grammarAccess.getTypedNestedObjectRule()); 
            pushFollow(FOLLOW_ruleTypedNestedObject_in_entryRuleTypedNestedObject11991);
            iv_ruleTypedNestedObject=ruleTypedNestedObject();

            state._fsp--;

             current =iv_ruleTypedNestedObject; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypedNestedObject12001); 

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
    // $ANTLR end "entryRuleTypedNestedObject"


    // $ANTLR start "ruleTypedNestedObject"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5322:1: ruleTypedNestedObject returns [EObject current=null] : (otherlv_0= '<' ( (lv_type_1_0= ruleJavaClassReference ) ) otherlv_2= '>' ruleNL ( (lv_nestedObject_4_0= ruleNestedObject ) ) ) ;
    public final EObject ruleTypedNestedObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_type_1_0 = null;

        EObject lv_nestedObject_4_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5325:28: ( (otherlv_0= '<' ( (lv_type_1_0= ruleJavaClassReference ) ) otherlv_2= '>' ruleNL ( (lv_nestedObject_4_0= ruleNestedObject ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5326:1: (otherlv_0= '<' ( (lv_type_1_0= ruleJavaClassReference ) ) otherlv_2= '>' ruleNL ( (lv_nestedObject_4_0= ruleNestedObject ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5326:1: (otherlv_0= '<' ( (lv_type_1_0= ruleJavaClassReference ) ) otherlv_2= '>' ruleNL ( (lv_nestedObject_4_0= ruleNestedObject ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5326:3: otherlv_0= '<' ( (lv_type_1_0= ruleJavaClassReference ) ) otherlv_2= '>' ruleNL ( (lv_nestedObject_4_0= ruleNestedObject ) )
            {
            otherlv_0=(Token)match(input,69,FOLLOW_69_in_ruleTypedNestedObject12038); 

                	newLeafNode(otherlv_0, grammarAccess.getTypedNestedObjectAccess().getLessThanSignKeyword_0());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5330:1: ( (lv_type_1_0= ruleJavaClassReference ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5331:1: (lv_type_1_0= ruleJavaClassReference )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5331:1: (lv_type_1_0= ruleJavaClassReference )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5332:3: lv_type_1_0= ruleJavaClassReference
            {
             
            	        newCompositeNode(grammarAccess.getTypedNestedObjectAccess().getTypeJavaClassReferenceParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleJavaClassReference_in_ruleTypedNestedObject12059);
            lv_type_1_0=ruleJavaClassReference();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTypedNestedObjectRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_1_0, 
                    		"JavaClassReference");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,70,FOLLOW_70_in_ruleTypedNestedObject12071); 

                	newLeafNode(otherlv_2, grammarAccess.getTypedNestedObjectAccess().getGreaterThanSignKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getTypedNestedObjectAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleTypedNestedObject12087);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5360:1: ( (lv_nestedObject_4_0= ruleNestedObject ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5361:1: (lv_nestedObject_4_0= ruleNestedObject )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5361:1: (lv_nestedObject_4_0= ruleNestedObject )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5362:3: lv_nestedObject_4_0= ruleNestedObject
            {
             
            	        newCompositeNode(grammarAccess.getTypedNestedObjectAccess().getNestedObjectNestedObjectParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleNestedObject_in_ruleTypedNestedObject12107);
            lv_nestedObject_4_0=ruleNestedObject();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTypedNestedObjectRule());
            	        }
                   		set(
                   			current, 
                   			"nestedObject",
                    		lv_nestedObject_4_0, 
                    		"NestedObject");
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
    // $ANTLR end "ruleTypedNestedObject"


    // $ANTLR start "entryRuleKeyValuePair"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5386:1: entryRuleKeyValuePair returns [EObject current=null] : iv_ruleKeyValuePair= ruleKeyValuePair EOF ;
    public final EObject entryRuleKeyValuePair() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValuePair = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5387:2: (iv_ruleKeyValuePair= ruleKeyValuePair EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5388:2: iv_ruleKeyValuePair= ruleKeyValuePair EOF
            {
             newCompositeNode(grammarAccess.getKeyValuePairRule()); 
            pushFollow(FOLLOW_ruleKeyValuePair_in_entryRuleKeyValuePair12143);
            iv_ruleKeyValuePair=ruleKeyValuePair();

            state._fsp--;

             current =iv_ruleKeyValuePair; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyValuePair12153); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5395:1: ruleKeyValuePair returns [EObject current=null] : ( ( ( (lv_identifier_0_0= RULE_ID ) ) | ( (lv_stringIdentifier_1_0= RULE_STRING ) ) ) ruleNL otherlv_3= ':' ruleNL ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ) ;
    public final EObject ruleKeyValuePair() throws RecognitionException {
        EObject current = null;

        Token lv_identifier_0_0=null;
        Token lv_stringIdentifier_1_0=null;
        Token otherlv_3=null;
        EObject lv_value_5_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5398:28: ( ( ( ( (lv_identifier_0_0= RULE_ID ) ) | ( (lv_stringIdentifier_1_0= RULE_STRING ) ) ) ruleNL otherlv_3= ':' ruleNL ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5399:1: ( ( ( (lv_identifier_0_0= RULE_ID ) ) | ( (lv_stringIdentifier_1_0= RULE_STRING ) ) ) ruleNL otherlv_3= ':' ruleNL ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5399:1: ( ( ( (lv_identifier_0_0= RULE_ID ) ) | ( (lv_stringIdentifier_1_0= RULE_STRING ) ) ) ruleNL otherlv_3= ':' ruleNL ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5399:2: ( ( (lv_identifier_0_0= RULE_ID ) ) | ( (lv_stringIdentifier_1_0= RULE_STRING ) ) ) ruleNL otherlv_3= ':' ruleNL ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5399:2: ( ( (lv_identifier_0_0= RULE_ID ) ) | ( (lv_stringIdentifier_1_0= RULE_STRING ) ) )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==RULE_ID) ) {
                alt67=1;
            }
            else if ( (LA67_0==RULE_STRING) ) {
                alt67=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5399:3: ( (lv_identifier_0_0= RULE_ID ) )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5399:3: ( (lv_identifier_0_0= RULE_ID ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5400:1: (lv_identifier_0_0= RULE_ID )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5400:1: (lv_identifier_0_0= RULE_ID )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5401:3: lv_identifier_0_0= RULE_ID
                    {
                    lv_identifier_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleKeyValuePair12196); 

                    			newLeafNode(lv_identifier_0_0, grammarAccess.getKeyValuePairAccess().getIdentifierIDTerminalRuleCall_0_0_0()); 
                    		

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


                    }
                    break;
                case 2 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5418:6: ( (lv_stringIdentifier_1_0= RULE_STRING ) )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5418:6: ( (lv_stringIdentifier_1_0= RULE_STRING ) )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5419:1: (lv_stringIdentifier_1_0= RULE_STRING )
                    {
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5419:1: (lv_stringIdentifier_1_0= RULE_STRING )
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5420:3: lv_stringIdentifier_1_0= RULE_STRING
                    {
                    lv_stringIdentifier_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleKeyValuePair12224); 

                    			newLeafNode(lv_stringIdentifier_1_0, grammarAccess.getKeyValuePairAccess().getStringIdentifierSTRINGTerminalRuleCall_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeyValuePairRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"stringIdentifier",
                            		lv_stringIdentifier_1_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

             
                    newCompositeNode(grammarAccess.getKeyValuePairAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleKeyValuePair12246);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_3=(Token)match(input,34,FOLLOW_34_in_ruleKeyValuePair12257); 

                	newLeafNode(otherlv_3, grammarAccess.getKeyValuePairAccess().getColonKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getKeyValuePairAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleKeyValuePair12273);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5456:1: ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5457:1: (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5457:1: (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5458:3: lv_value_5_0= ruleValueOrEnumValueOrOperationCollection
            {
             
            	        newCompositeNode(grammarAccess.getKeyValuePairAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleKeyValuePair12293);
            lv_value_5_0=ruleValueOrEnumValueOrOperationCollection();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getKeyValuePairRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_5_0, 
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5482:1: entryRuleJavaClassReference returns [EObject current=null] : iv_ruleJavaClassReference= ruleJavaClassReference EOF ;
    public final EObject entryRuleJavaClassReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaClassReference = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5483:2: (iv_ruleJavaClassReference= ruleJavaClassReference EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5484:2: iv_ruleJavaClassReference= ruleJavaClassReference EOF
            {
             newCompositeNode(grammarAccess.getJavaClassReferenceRule()); 
            pushFollow(FOLLOW_ruleJavaClassReference_in_entryRuleJavaClassReference12329);
            iv_ruleJavaClassReference=ruleJavaClassReference();

            state._fsp--;

             current =iv_ruleJavaClassReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJavaClassReference12339); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5491:1: ruleJavaClassReference returns [EObject current=null] : ( ( ruleQualifiedJavaClassName ) ) ;
    public final EObject ruleJavaClassReference() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5494:28: ( ( ( ruleQualifiedJavaClassName ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5495:1: ( ( ruleQualifiedJavaClassName ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5495:1: ( ( ruleQualifiedJavaClassName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5496:1: ( ruleQualifiedJavaClassName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5496:1: ( ruleQualifiedJavaClassName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5497:3: ruleQualifiedJavaClassName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getJavaClassReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getJavaClassReferenceAccess().getTypeJvmTypeCrossReference_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_ruleJavaClassReference12386);
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5518:1: entryRuleMethodReference returns [EObject current=null] : iv_ruleMethodReference= ruleMethodReference EOF ;
    public final EObject entryRuleMethodReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodReference = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5519:2: (iv_ruleMethodReference= ruleMethodReference EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5520:2: iv_ruleMethodReference= ruleMethodReference EOF
            {
             newCompositeNode(grammarAccess.getMethodReferenceRule()); 
            pushFollow(FOLLOW_ruleMethodReference_in_entryRuleMethodReference12421);
            iv_ruleMethodReference=ruleMethodReference();

            state._fsp--;

             current =iv_ruleMethodReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMethodReference12431); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5527:1: ruleMethodReference returns [EObject current=null] : ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleMethodReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5530:28: ( ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5531:1: ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5531:1: ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5531:2: ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5531:2: ( ( ruleQualifiedJavaClassName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5532:1: ( ruleQualifiedJavaClassName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5532:1: ( ruleQualifiedJavaClassName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5533:3: ruleQualifiedJavaClassName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMethodReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getMethodReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_ruleMethodReference12479);
            ruleQualifiedJavaClassName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,74,FOLLOW_74_in_ruleMethodReference12491); 

                	newLeafNode(otherlv_1, grammarAccess.getMethodReferenceAccess().getNumberSignKeyword_1());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5550:1: ( (otherlv_2= RULE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5551:1: (otherlv_2= RULE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5551:1: (otherlv_2= RULE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5552:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMethodReferenceRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleMethodReference12511); 

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


    // $ANTLR start "entryRuleJavaConstantReference"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5571:1: entryRuleJavaConstantReference returns [EObject current=null] : iv_ruleJavaConstantReference= ruleJavaConstantReference EOF ;
    public final EObject entryRuleJavaConstantReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaConstantReference = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5572:2: (iv_ruleJavaConstantReference= ruleJavaConstantReference EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5573:2: iv_ruleJavaConstantReference= ruleJavaConstantReference EOF
            {
             newCompositeNode(grammarAccess.getJavaConstantReferenceRule()); 
            pushFollow(FOLLOW_ruleJavaConstantReference_in_entryRuleJavaConstantReference12547);
            iv_ruleJavaConstantReference=ruleJavaConstantReference();

            state._fsp--;

             current =iv_ruleJavaConstantReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleJavaConstantReference12557); 

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
    // $ANTLR end "entryRuleJavaConstantReference"


    // $ANTLR start "ruleJavaConstantReference"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5580:1: ruleJavaConstantReference returns [EObject current=null] : ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_UPPERCASE_ID ) ) ) ;
    public final EObject ruleJavaConstantReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5583:28: ( ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_UPPERCASE_ID ) ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5584:1: ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_UPPERCASE_ID ) ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5584:1: ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_UPPERCASE_ID ) ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5584:2: ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_UPPERCASE_ID ) )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5584:2: ( ( ruleQualifiedJavaClassName ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5585:1: ( ruleQualifiedJavaClassName )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5585:1: ( ruleQualifiedJavaClassName )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5586:3: ruleQualifiedJavaClassName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getJavaConstantReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getJavaConstantReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_ruleJavaConstantReference12605);
            ruleQualifiedJavaClassName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,74,FOLLOW_74_in_ruleJavaConstantReference12617); 

                	newLeafNode(otherlv_1, grammarAccess.getJavaConstantReferenceAccess().getNumberSignKeyword_1());
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5603:1: ( (otherlv_2= RULE_UPPERCASE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5604:1: (otherlv_2= RULE_UPPERCASE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5604:1: (otherlv_2= RULE_UPPERCASE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5605:3: otherlv_2= RULE_UPPERCASE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getJavaConstantReferenceRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_UPPERCASE_ID,FOLLOW_RULE_UPPERCASE_ID_in_ruleJavaConstantReference12637); 

            		newLeafNode(otherlv_2, grammarAccess.getJavaConstantReferenceAccess().getConstantJvmFieldCrossReference_2_0()); 
            	

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
    // $ANTLR end "ruleJavaConstantReference"


    // $ANTLR start "entryRuleExecutionMultiplier"
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5624:1: entryRuleExecutionMultiplier returns [EObject current=null] : iv_ruleExecutionMultiplier= ruleExecutionMultiplier EOF ;
    public final EObject entryRuleExecutionMultiplier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExecutionMultiplier = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5625:2: (iv_ruleExecutionMultiplier= ruleExecutionMultiplier EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5626:2: iv_ruleExecutionMultiplier= ruleExecutionMultiplier EOF
            {
             newCompositeNode(grammarAccess.getExecutionMultiplierRule()); 
            pushFollow(FOLLOW_ruleExecutionMultiplier_in_entryRuleExecutionMultiplier12673);
            iv_ruleExecutionMultiplier=ruleExecutionMultiplier();

            state._fsp--;

             current =iv_ruleExecutionMultiplier; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExecutionMultiplier12683); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5633:1: ruleExecutionMultiplier returns [EObject current=null] : ( ( (lv_count_0_0= ruleConstantValue ) ) otherlv_1= '*' ) ;
    public final EObject ruleExecutionMultiplier() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_count_0_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5636:28: ( ( ( (lv_count_0_0= ruleConstantValue ) ) otherlv_1= '*' ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5637:1: ( ( (lv_count_0_0= ruleConstantValue ) ) otherlv_1= '*' )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5637:1: ( ( (lv_count_0_0= ruleConstantValue ) ) otherlv_1= '*' )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5637:2: ( (lv_count_0_0= ruleConstantValue ) ) otherlv_1= '*'
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5637:2: ( (lv_count_0_0= ruleConstantValue ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5638:1: (lv_count_0_0= ruleConstantValue )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5638:1: (lv_count_0_0= ruleConstantValue )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5639:3: lv_count_0_0= ruleConstantValue
            {
             
            	        newCompositeNode(grammarAccess.getExecutionMultiplierAccess().getCountConstantValueParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleConstantValue_in_ruleExecutionMultiplier12729);
            lv_count_0_0=ruleConstantValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExecutionMultiplierRule());
            	        }
                   		set(
                   			current, 
                   			"count",
                    		lv_count_0_0, 
                    		"ConstantValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,61,FOLLOW_61_in_ruleExecutionMultiplier12741); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5667:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5668:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5669:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName12778);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName12789); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5676:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5679:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5680:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5680:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5680:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName12829); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5687:1: (kw= '.' this_ID_2= RULE_ID )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( (LA68_0==75) ) {
                    int LA68_2 = input.LA(2);

                    if ( (LA68_2==RULE_ID) ) {
                        alt68=1;
                    }


                }


                switch (alt68) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5688:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,75,FOLLOW_75_in_ruleQualifiedName12848); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName12863); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop68;
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5708:1: entryRuleQualifiedJavaClassName returns [String current=null] : iv_ruleQualifiedJavaClassName= ruleQualifiedJavaClassName EOF ;
    public final String entryRuleQualifiedJavaClassName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedJavaClassName = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5709:2: (iv_ruleQualifiedJavaClassName= ruleQualifiedJavaClassName EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5710:2: iv_ruleQualifiedJavaClassName= ruleQualifiedJavaClassName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedJavaClassNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedJavaClassName_in_entryRuleQualifiedJavaClassName12911);
            iv_ruleQualifiedJavaClassName=ruleQualifiedJavaClassName();

            state._fsp--;

             current =iv_ruleQualifiedJavaClassName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedJavaClassName12922); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5717:1: ruleQualifiedJavaClassName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedJavaClassName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_UPPERCASE_ID_2=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5720:28: ( (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5721:1: (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5721:1: (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5722:5: this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID
            {
             
                    newCompositeNode(grammarAccess.getQualifiedJavaClassNameAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedJavaClassName12969);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            kw=(Token)match(input,75,FOLLOW_75_in_ruleQualifiedJavaClassName12987); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getQualifiedJavaClassNameAccess().getFullStopKeyword_1()); 
                
            this_UPPERCASE_ID_2=(Token)match(input,RULE_UPPERCASE_ID,FOLLOW_RULE_UPPERCASE_ID_in_ruleQualifiedJavaClassName13002); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5753:1: entryRuleQualifiedNameWithWildcard returns [String current=null] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5754:2: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5755:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); 
            pushFollow(FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard13048);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();

            state._fsp--;

             current =iv_ruleQualifiedNameWithWildcard.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard13059); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5762:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5765:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5766:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5766:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5767:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard13106);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5777:1: (kw= '.*' )?
            int alt69=2;
            int LA69_0 = input.LA(1);

            if ( (LA69_0==76) ) {
                alt69=1;
            }
            switch (alt69) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5778:2: kw= '.*'
                    {
                    kw=(Token)match(input,76,FOLLOW_76_in_ruleQualifiedNameWithWildcard13125); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5791:1: entryRuleNL returns [String current=null] : iv_ruleNL= ruleNL EOF ;
    public final String entryRuleNL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNL = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5792:2: (iv_ruleNL= ruleNL EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5793:2: iv_ruleNL= ruleNL EOF
            {
             newCompositeNode(grammarAccess.getNLRule()); 
            pushFollow(FOLLOW_ruleNL_in_entryRuleNL13168);
            iv_ruleNL=ruleNL();

            state._fsp--;

             current =iv_ruleNL.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNL13179); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5800:1: ruleNL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? )* ;
    public final AntlrDatatypeRuleToken ruleNL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_NEWLINE_0=null;
        Token this_WS_1=null;

         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5803:28: ( (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? )* )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5804:1: (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? )*
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5804:1: (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==RULE_NEWLINE) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5804:6: this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )?
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleNL13219); 

            	    		current.merge(this_NEWLINE_0);
            	        
            	     
            	        newLeafNode(this_NEWLINE_0, grammarAccess.getNLAccess().getNEWLINETerminalRuleCall_0()); 
            	        
            	    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5811:1: (this_WS_1= RULE_WS )?
            	    int alt70=2;
            	    int LA70_0 = input.LA(1);

            	    if ( (LA70_0==RULE_WS) ) {
            	        alt70=1;
            	    }
            	    switch (alt70) {
            	        case 1 :
            	            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5811:6: this_WS_1= RULE_WS
            	            {
            	            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleNL13240); 

            	            		current.merge(this_WS_1);
            	                
            	             
            	                newLeafNode(this_WS_1, grammarAccess.getNLAccess().getWSTerminalRuleCall_1()); 
            	                

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop71;
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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5826:1: entryRuleNLFORCED returns [String current=null] : iv_ruleNLFORCED= ruleNLFORCED EOF ;
    public final String entryRuleNLFORCED() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNLFORCED = null;


        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5827:2: (iv_ruleNLFORCED= ruleNLFORCED EOF )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5828:2: iv_ruleNLFORCED= ruleNLFORCED EOF
            {
             newCompositeNode(grammarAccess.getNLFORCEDRule()); 
            pushFollow(FOLLOW_ruleNLFORCED_in_entryRuleNLFORCED13289);
            iv_ruleNLFORCED=ruleNLFORCED();

            state._fsp--;

             current =iv_ruleNLFORCED.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNLFORCED13300); 

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
    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5835:1: ruleNLFORCED returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? this_NL_2= ruleNL ) ;
    public final AntlrDatatypeRuleToken ruleNLFORCED() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_NEWLINE_0=null;
        Token this_WS_1=null;
        AntlrDatatypeRuleToken this_NL_2 = null;


         enterRule(); 
            
        try {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5838:28: ( (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? this_NL_2= ruleNL ) )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5839:1: (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? this_NL_2= ruleNL )
            {
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5839:1: (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? this_NL_2= ruleNL )
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5839:6: this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? this_NL_2= ruleNL
            {
            this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_RULE_NEWLINE_in_ruleNLFORCED13340); 

            		current.merge(this_NEWLINE_0);
                
             
                newLeafNode(this_NEWLINE_0, grammarAccess.getNLFORCEDAccess().getNEWLINETerminalRuleCall_0()); 
                
            // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5846:1: (this_WS_1= RULE_WS )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==RULE_WS) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // ../de.gebit.integrity.dsl/src-gen/de/gebit/integrity/parser/antlr/internal/InternalDSL.g:5846:6: this_WS_1= RULE_WS
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleNLFORCED13361); 

                    		current.merge(this_WS_1);
                        
                     
                        newLeafNode(this_WS_1, grammarAccess.getNLFORCEDAccess().getWSTerminalRuleCall_1()); 
                        

                    }
                    break;

            }

             
                    newCompositeNode(grammarAccess.getNLFORCEDAccess().getNLParserRuleCall_2()); 
                
            pushFollow(FOLLOW_ruleNL_in_ruleNLFORCED13390);
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


    protected DFA7 dfa7 = new DFA7(this);
    protected DFA28 dfa28 = new DFA28(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA30 dfa30 = new DFA30(this);
    protected DFA31 dfa31 = new DFA31(this);
    protected DFA35 dfa35 = new DFA35(this);
    protected DFA41 dfa41 = new DFA41(this);
    protected DFA42 dfa42 = new DFA42(this);
    protected DFA43 dfa43 = new DFA43(this);
    protected DFA44 dfa44 = new DFA44(this);
    protected DFA45 dfa45 = new DFA45(this);
    protected DFA55 dfa55 = new DFA55(this);
    protected DFA56 dfa56 = new DFA56(this);
    protected DFA57 dfa57 = new DFA57(this);
    protected DFA59 dfa59 = new DFA59(this);
    protected DFA61 dfa61 = new DFA61(this);
    protected DFA65 dfa65 = new DFA65(this);
    static final String DFA7_eotS =
        "\13\uffff";
    static final String DFA7_eofS =
        "\13\uffff";
    static final String DFA7_minS =
        "\1\37\7\uffff\1\55\2\uffff";
    static final String DFA7_maxS =
        "\1\57\7\uffff\1\57\2\uffff";
    static final String DFA7_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\uffff\1\10\1\11";
    static final String DFA7_specialS =
        "\13\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\1\1\2\2\uffff\1\3\1\4\1\5\1\7\4\uffff\1\6\1\10\1\11\1\uffff"+
            "\1\12",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\11\1\uffff\1\12",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "641:1: (this_Import_0= ruleImport | this_ForkDefinition_1= ruleForkDefinition | this_VariantDefinition_2= ruleVariantDefinition | this_TestDefinition_3= ruleTestDefinition | this_CallDefinition_4= ruleCallDefinition | this_OperationDefinition_5= ruleOperationDefinition | this_SuiteDefinition_6= ruleSuiteDefinition | this_VariableDefinition_7= ruleVariableDefinition | this_ConstantDefinition_8= ruleConstantDefinition )";
        }
    }
    static final String DFA28_eotS =
        "\13\uffff";
    static final String DFA28_eofS =
        "\2\4\3\uffff\1\4\5\uffff";
    static final String DFA28_minS =
        "\2\4\1\26\1\11\1\uffff\1\4\1\26\1\uffff\3\26";
    static final String DFA28_maxS =
        "\2\72\1\63\1\12\1\uffff\1\72\1\63\1\uffff\3\63";
    static final String DFA28_acceptS =
        "\4\uffff\1\2\2\uffff\1\1\3\uffff";
    static final String DFA28_specialS =
        "\13\uffff}>";
    static final String[] DFA28_transitionS = {
            "\5\4\1\uffff\1\2\13\uffff\1\1\23\uffff\1\4\1\uffff\2\4\1\uffff"+
            "\1\4\2\uffff\3\4\1\uffff\1\4\1\uffff\1\4\1\uffff\1\3",
            "\5\4\1\uffff\1\2\13\uffff\1\1\1\5\22\uffff\1\4\1\uffff\2\4"+
            "\1\uffff\1\4\2\uffff\3\4\1\uffff\1\4\1\uffff\1\4\1\uffff\1\3",
            "\1\6\13\uffff\1\7\20\uffff\1\4",
            "\1\11\1\10",
            "",
            "\5\4\1\uffff\1\2\13\uffff\1\1\23\uffff\1\4\1\uffff\2\4\1\uffff"+
            "\1\4\2\uffff\3\4\1\uffff\1\4\1\uffff\1\4\1\uffff\1\3",
            "\1\6\1\12\12\uffff\1\7\20\uffff\1\4",
            "",
            "\1\6\13\uffff\1\7\20\uffff\1\4",
            "\1\6\13\uffff\1\7\20\uffff\1\4",
            "\1\6\13\uffff\1\7\20\uffff\1\4"
    };

    static final short[] DFA28_eot = DFA.unpackEncodedString(DFA28_eotS);
    static final short[] DFA28_eof = DFA.unpackEncodedString(DFA28_eofS);
    static final char[] DFA28_min = DFA.unpackEncodedStringToUnsignedChars(DFA28_minS);
    static final char[] DFA28_max = DFA.unpackEncodedStringToUnsignedChars(DFA28_maxS);
    static final short[] DFA28_accept = DFA.unpackEncodedString(DFA28_acceptS);
    static final short[] DFA28_special = DFA.unpackEncodedString(DFA28_specialS);
    static final short[][] DFA28_transition;

    static {
        int numStates = DFA28_transitionS.length;
        DFA28_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA28_transition[i] = DFA.unpackEncodedString(DFA28_transitionS[i]);
        }
    }

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = DFA28_eot;
            this.eof = DFA28_eof;
            this.min = DFA28_min;
            this.max = DFA28_max;
            this.accept = DFA28_accept;
            this.special = DFA28_special;
            this.transition = DFA28_transition;
        }
        public String getDescription() {
            return "()* loopback of 2206:2: ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )*";
        }
    }
    static final String DFA29_eotS =
        "\5\uffff";
    static final String DFA29_eofS =
        "\2\2\2\uffff\1\2";
    static final String DFA29_minS =
        "\2\4\2\uffff\1\4";
    static final String DFA29_maxS =
        "\2\72\2\uffff\1\72";
    static final String DFA29_acceptS =
        "\2\uffff\1\2\1\1\1\uffff";
    static final String DFA29_specialS =
        "\5\uffff}>";
    static final String[] DFA29_transitionS = {
            "\5\2\1\uffff\1\3\13\uffff\1\1\23\uffff\1\2\1\uffff\2\2\1\uffff"+
            "\1\2\2\uffff\3\2\1\uffff\1\2\1\uffff\1\2\1\uffff\1\3",
            "\5\2\1\uffff\1\3\13\uffff\1\1\1\4\22\uffff\1\2\1\uffff\2\2"+
            "\1\uffff\1\2\2\uffff\3\2\1\uffff\1\2\1\uffff\1\2\1\uffff\1\3",
            "",
            "",
            "\5\2\1\uffff\1\3\13\uffff\1\1\23\uffff\1\2\1\uffff\2\2\1\uffff"+
            "\1\2\2\uffff\3\2\1\uffff\1\2\1\uffff\1\2\1\uffff\1\3"
    };

    static final short[] DFA29_eot = DFA.unpackEncodedString(DFA29_eotS);
    static final short[] DFA29_eof = DFA.unpackEncodedString(DFA29_eofS);
    static final char[] DFA29_min = DFA.unpackEncodedStringToUnsignedChars(DFA29_minS);
    static final char[] DFA29_max = DFA.unpackEncodedStringToUnsignedChars(DFA29_maxS);
    static final short[] DFA29_accept = DFA.unpackEncodedString(DFA29_acceptS);
    static final short[] DFA29_special = DFA.unpackEncodedString(DFA29_specialS);
    static final short[][] DFA29_transition;

    static {
        int numStates = DFA29_transitionS.length;
        DFA29_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA29_transition[i] = DFA.unpackEncodedString(DFA29_transitionS[i]);
        }
    }

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = DFA29_eot;
            this.eof = DFA29_eof;
            this.min = DFA29_min;
            this.max = DFA29_max;
            this.accept = DFA29_accept;
            this.special = DFA29_special;
            this.transition = DFA29_transition;
        }
        public String getDescription() {
            return "()* loopback of 2232:4: ( ruleNL ( (lv_results_6_0= ruleNamedResult ) ) )*";
        }
    }
    static final String DFA30_eotS =
        "\5\uffff";
    static final String DFA30_eofS =
        "\2\3\2\uffff\1\3";
    static final String DFA30_minS =
        "\2\4\2\uffff\1\4";
    static final String DFA30_maxS =
        "\2\70\2\uffff\1\70";
    static final String DFA30_acceptS =
        "\2\uffff\1\1\1\2\1\uffff";
    static final String DFA30_specialS =
        "\5\uffff}>";
    static final String[] DFA30_transitionS = {
            "\5\3\15\uffff\1\1\23\uffff\1\3\1\uffff\2\3\1\uffff\1\3\2\uffff"+
            "\1\3\1\2\1\3\1\uffff\1\3\1\uffff\1\3",
            "\5\3\15\uffff\1\1\1\4\22\uffff\1\3\1\uffff\2\3\1\uffff\1\3"+
            "\2\uffff\1\3\1\2\1\3\1\uffff\1\3\1\uffff\1\3",
            "",
            "",
            "\5\3\15\uffff\1\1\23\uffff\1\3\1\uffff\2\3\1\uffff\1\3\2\uffff"+
            "\1\3\1\2\1\3\1\uffff\1\3\1\uffff\1\3"
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
            return "2258:4: ( ruleNL otherlv_8= '=' ruleNL ( (lv_result_10_0= ruleValueOrEnumValueOrOperationCollection ) ) )?";
        }
    }
    static final String DFA31_eotS =
        "\7\uffff";
    static final String DFA31_eofS =
        "\7\uffff";
    static final String DFA31_minS =
        "\2\12\1\uffff\2\12\1\uffff\1\12";
    static final String DFA31_maxS =
        "\2\72\1\uffff\2\72\1\uffff\1\72";
    static final String DFA31_acceptS =
        "\2\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String DFA31_specialS =
        "\7\uffff}>";
    static final String[] DFA31_transitionS = {
            "\1\2\13\uffff\1\1\43\uffff\1\2",
            "\1\2\13\uffff\1\4\1\3\35\uffff\1\5\4\uffff\1\2",
            "",
            "\1\2\13\uffff\1\4\36\uffff\1\5\4\uffff\1\2",
            "\1\2\13\uffff\1\4\1\6\35\uffff\1\5\4\uffff\1\2",
            "",
            "\1\2\13\uffff\1\4\36\uffff\1\5\4\uffff\1\2"
    };

    static final short[] DFA31_eot = DFA.unpackEncodedString(DFA31_eotS);
    static final short[] DFA31_eof = DFA.unpackEncodedString(DFA31_eofS);
    static final char[] DFA31_min = DFA.unpackEncodedStringToUnsignedChars(DFA31_minS);
    static final char[] DFA31_max = DFA.unpackEncodedStringToUnsignedChars(DFA31_maxS);
    static final short[] DFA31_accept = DFA.unpackEncodedString(DFA31_acceptS);
    static final short[] DFA31_special = DFA.unpackEncodedString(DFA31_specialS);
    static final short[][] DFA31_transition;

    static {
        int numStates = DFA31_transitionS.length;
        DFA31_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA31_transition[i] = DFA.unpackEncodedString(DFA31_transitionS[i]);
        }
    }

    class DFA31 extends DFA {

        public DFA31(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 31;
            this.eot = DFA31_eot;
            this.eof = DFA31_eof;
            this.min = DFA31_min;
            this.max = DFA31_max;
            this.accept = DFA31_accept;
            this.special = DFA31_special;
            this.transition = DFA31_transition;
        }
        public String getDescription() {
            return "()* loopback of 2352:2: ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )*";
        }
    }
    static final String DFA35_eotS =
        "\7\uffff";
    static final String DFA35_eofS =
        "\1\uffff\3\5\2\uffff\1\5";
    static final String DFA35_minS =
        "\1\26\3\4\2\uffff\1\4";
    static final String DFA35_maxS =
        "\1\26\3\70\2\uffff\1\70";
    static final String DFA35_acceptS =
        "\4\uffff\1\1\1\2\1\uffff";
    static final String DFA35_specialS =
        "\7\uffff}>";
    static final String[] DFA35_transitionS = {
            "\1\1",
            "\5\5\15\uffff\1\3\1\2\22\uffff\1\5\1\uffff\2\5\1\uffff\1\5"+
            "\2\uffff\1\5\1\uffff\1\5\1\4\1\5\1\uffff\1\5",
            "\5\5\15\uffff\1\3\23\uffff\1\5\1\uffff\2\5\1\uffff\1\5\2\uffff"+
            "\1\5\1\uffff\1\5\1\4\1\5\1\uffff\1\5",
            "\5\5\15\uffff\1\3\1\6\22\uffff\1\5\1\uffff\2\5\1\uffff\1\5"+
            "\2\uffff\1\5\1\uffff\1\5\1\4\1\5\1\uffff\1\5",
            "",
            "",
            "\5\5\15\uffff\1\3\23\uffff\1\5\1\uffff\2\5\1\uffff\1\5\2\uffff"+
            "\1\5\1\uffff\1\5\1\4\1\5\1\uffff\1\5"
    };

    static final short[] DFA35_eot = DFA.unpackEncodedString(DFA35_eotS);
    static final short[] DFA35_eof = DFA.unpackEncodedString(DFA35_eofS);
    static final char[] DFA35_min = DFA.unpackEncodedStringToUnsignedChars(DFA35_minS);
    static final char[] DFA35_max = DFA.unpackEncodedStringToUnsignedChars(DFA35_maxS);
    static final short[] DFA35_accept = DFA.unpackEncodedString(DFA35_acceptS);
    static final short[] DFA35_special = DFA.unpackEncodedString(DFA35_specialS);
    static final short[][] DFA35_transition;

    static {
        int numStates = DFA35_transitionS.length;
        DFA35_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA35_transition[i] = DFA.unpackEncodedString(DFA35_transitionS[i]);
        }
    }

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = DFA35_eot;
            this.eof = DFA35_eof;
            this.min = DFA35_min;
            this.max = DFA35_max;
            this.accept = DFA35_accept;
            this.special = DFA35_special;
            this.transition = DFA35_transition;
        }
        public String getDescription() {
            return "()+ loopback of 2445:3: ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+";
        }
    }
    static final String DFA41_eotS =
        "\6\uffff";
    static final String DFA41_eofS =
        "\2\uffff\1\4\2\uffff\1\4";
    static final String DFA41_minS =
        "\1\11\1\uffff\1\4\1\12\1\uffff\1\4";
    static final String DFA41_maxS =
        "\1\107\1\uffff\1\113\1\12\1\uffff\1\113";
    static final String DFA41_acceptS =
        "\1\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String DFA41_specialS =
        "\6\uffff}>";
    static final String[] DFA41_transitionS = {
            "\1\1\1\2\12\1\60\uffff\1\1\1\uffff\1\1",
            "",
            "\5\4\1\uffff\1\4\13\uffff\1\4\23\uffff\1\4\1\uffff\2\4\1\uffff"+
            "\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\3\4\1\uffff\1\4\2\uffff"+
            "\1\1\15\uffff\1\3",
            "\1\5",
            "",
            "\5\4\1\uffff\1\4\13\uffff\1\4\23\uffff\1\4\1\uffff\2\4\1\uffff"+
            "\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\3\4\1\uffff\1\4\2\uffff"+
            "\1\1\15\uffff\1\3"
    };

    static final short[] DFA41_eot = DFA.unpackEncodedString(DFA41_eotS);
    static final short[] DFA41_eof = DFA.unpackEncodedString(DFA41_eofS);
    static final char[] DFA41_min = DFA.unpackEncodedStringToUnsignedChars(DFA41_minS);
    static final char[] DFA41_max = DFA.unpackEncodedStringToUnsignedChars(DFA41_maxS);
    static final short[] DFA41_accept = DFA.unpackEncodedString(DFA41_acceptS);
    static final short[] DFA41_special = DFA.unpackEncodedString(DFA41_specialS);
    static final short[][] DFA41_transition;

    static {
        int numStates = DFA41_transitionS.length;
        DFA41_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA41_transition[i] = DFA.unpackEncodedString(DFA41_transitionS[i]);
        }
    }

    class DFA41 extends DFA {

        public DFA41(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 41;
            this.eot = DFA41_eot;
            this.eof = DFA41_eof;
            this.min = DFA41_min;
            this.max = DFA41_max;
            this.accept = DFA41_accept;
            this.special = DFA41_special;
            this.transition = DFA41_transition;
        }
        public String getDescription() {
            return "2853:1: ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )?";
        }
    }
    static final String DFA42_eotS =
        "\13\uffff";
    static final String DFA42_eofS =
        "\2\4\3\uffff\1\4\5\uffff";
    static final String DFA42_minS =
        "\2\4\1\26\1\11\1\uffff\1\4\1\26\1\uffff\3\26";
    static final String DFA42_maxS =
        "\2\72\1\67\1\12\1\uffff\1\72\1\67\1\uffff\3\67";
    static final String DFA42_acceptS =
        "\4\uffff\1\2\2\uffff\1\1\3\uffff";
    static final String DFA42_specialS =
        "\13\uffff}>";
    static final String[] DFA42_transitionS = {
            "\5\4\1\uffff\1\2\13\uffff\1\1\23\uffff\1\4\1\uffff\2\4\1\uffff"+
            "\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\3\4\1\uffff\1\3",
            "\5\4\1\uffff\1\2\13\uffff\1\1\1\5\22\uffff\1\4\1\uffff\2\4"+
            "\1\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\3\4\1\uffff\1\3",
            "\1\6\13\uffff\1\7\24\uffff\1\4",
            "\1\11\1\10",
            "",
            "\5\4\1\uffff\1\2\13\uffff\1\1\23\uffff\1\4\1\uffff\2\4\1\uffff"+
            "\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\3\4\1\uffff\1\3",
            "\1\6\1\12\12\uffff\1\7\24\uffff\1\4",
            "",
            "\1\6\13\uffff\1\7\24\uffff\1\4",
            "\1\6\13\uffff\1\7\24\uffff\1\4",
            "\1\6\13\uffff\1\7\24\uffff\1\4"
    };

    static final short[] DFA42_eot = DFA.unpackEncodedString(DFA42_eotS);
    static final short[] DFA42_eof = DFA.unpackEncodedString(DFA42_eofS);
    static final char[] DFA42_min = DFA.unpackEncodedStringToUnsignedChars(DFA42_minS);
    static final char[] DFA42_max = DFA.unpackEncodedStringToUnsignedChars(DFA42_maxS);
    static final short[] DFA42_accept = DFA.unpackEncodedString(DFA42_acceptS);
    static final short[] DFA42_special = DFA.unpackEncodedString(DFA42_specialS);
    static final short[][] DFA42_transition;

    static {
        int numStates = DFA42_transitionS.length;
        DFA42_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA42_transition[i] = DFA.unpackEncodedString(DFA42_transitionS[i]);
        }
    }

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = DFA42_eot;
            this.eof = DFA42_eof;
            this.min = DFA42_min;
            this.max = DFA42_max;
            this.accept = DFA42_accept;
            this.special = DFA42_special;
            this.transition = DFA42_transition;
        }
        public String getDescription() {
            return "()* loopback of 2894:2: ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )*";
        }
    }
    static final String DFA43_eotS =
        "\5\uffff";
    static final String DFA43_eofS =
        "\2\2\2\uffff\1\2";
    static final String DFA43_minS =
        "\2\4\2\uffff\1\4";
    static final String DFA43_maxS =
        "\2\72\2\uffff\1\72";
    static final String DFA43_acceptS =
        "\2\uffff\1\2\1\1\1\uffff";
    static final String DFA43_specialS =
        "\5\uffff}>";
    static final String[] DFA43_transitionS = {
            "\5\2\1\uffff\1\3\13\uffff\1\1\23\uffff\1\2\1\uffff\2\2\1\uffff"+
            "\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\3\2\1\uffff\1\3",
            "\5\2\1\uffff\1\3\13\uffff\1\1\1\4\22\uffff\1\2\1\uffff\2\2"+
            "\1\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\3\2\1\uffff\1\3",
            "",
            "",
            "\5\2\1\uffff\1\3\13\uffff\1\1\23\uffff\1\2\1\uffff\2\2\1\uffff"+
            "\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\3\2\1\uffff\1\3"
    };

    static final short[] DFA43_eot = DFA.unpackEncodedString(DFA43_eotS);
    static final short[] DFA43_eof = DFA.unpackEncodedString(DFA43_eofS);
    static final char[] DFA43_min = DFA.unpackEncodedStringToUnsignedChars(DFA43_minS);
    static final char[] DFA43_max = DFA.unpackEncodedStringToUnsignedChars(DFA43_maxS);
    static final short[] DFA43_accept = DFA.unpackEncodedString(DFA43_acceptS);
    static final short[] DFA43_special = DFA.unpackEncodedString(DFA43_specialS);
    static final short[][] DFA43_transition;

    static {
        int numStates = DFA43_transitionS.length;
        DFA43_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA43_transition[i] = DFA.unpackEncodedString(DFA43_transitionS[i]);
        }
    }

    class DFA43 extends DFA {

        public DFA43(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 43;
            this.eot = DFA43_eot;
            this.eof = DFA43_eof;
            this.min = DFA43_min;
            this.max = DFA43_max;
            this.accept = DFA43_accept;
            this.special = DFA43_special;
            this.transition = DFA43_transition;
        }
        public String getDescription() {
            return "()* loopback of 2920:4: ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )*";
        }
    }
    static final String DFA44_eotS =
        "\5\uffff";
    static final String DFA44_eofS =
        "\2\3\2\uffff\1\3";
    static final String DFA44_minS =
        "\2\4\2\uffff\1\4";
    static final String DFA44_maxS =
        "\2\70\2\uffff\1\70";
    static final String DFA44_acceptS =
        "\2\uffff\1\1\1\2\1\uffff";
    static final String DFA44_specialS =
        "\5\uffff}>";
    static final String[] DFA44_transitionS = {
            "\5\3\15\uffff\1\1\23\uffff\1\3\1\uffff\2\3\1\uffff\1\3\2\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\3\1\2\1\3",
            "\5\3\15\uffff\1\1\1\4\22\uffff\1\3\1\uffff\2\3\1\uffff\1\3"+
            "\2\uffff\1\3\1\uffff\1\3\1\uffff\1\3\1\2\1\3",
            "",
            "",
            "\5\3\15\uffff\1\1\23\uffff\1\3\1\uffff\2\3\1\uffff\1\3\2\uffff"+
            "\1\3\1\uffff\1\3\1\uffff\1\3\1\2\1\3"
    };

    static final short[] DFA44_eot = DFA.unpackEncodedString(DFA44_eotS);
    static final short[] DFA44_eof = DFA.unpackEncodedString(DFA44_eofS);
    static final char[] DFA44_min = DFA.unpackEncodedStringToUnsignedChars(DFA44_minS);
    static final char[] DFA44_max = DFA.unpackEncodedStringToUnsignedChars(DFA44_maxS);
    static final short[] DFA44_accept = DFA.unpackEncodedString(DFA44_acceptS);
    static final short[] DFA44_special = DFA.unpackEncodedString(DFA44_specialS);
    static final short[][] DFA44_transition;

    static {
        int numStates = DFA44_transitionS.length;
        DFA44_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA44_transition[i] = DFA.unpackEncodedString(DFA44_transitionS[i]);
        }
    }

    class DFA44 extends DFA {

        public DFA44(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 44;
            this.eot = DFA44_eot;
            this.eof = DFA44_eof;
            this.min = DFA44_min;
            this.max = DFA44_max;
            this.accept = DFA44_accept;
            this.special = DFA44_special;
            this.transition = DFA44_transition;
        }
        public String getDescription() {
            return "2946:4: ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )?";
        }
    }
    static final String DFA45_eotS =
        "\6\uffff";
    static final String DFA45_eofS =
        "\2\uffff\1\4\2\uffff\1\4";
    static final String DFA45_minS =
        "\1\11\1\uffff\1\4\1\12\1\uffff\1\4";
    static final String DFA45_maxS =
        "\1\107\1\uffff\1\113\1\12\1\uffff\1\113";
    static final String DFA45_acceptS =
        "\1\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String DFA45_specialS =
        "\6\uffff}>";
    static final String[] DFA45_transitionS = {
            "\1\1\1\2\12\1\60\uffff\1\1\1\uffff\1\1",
            "",
            "\5\4\1\uffff\1\4\13\uffff\1\4\23\uffff\1\4\1\uffff\2\4\1\uffff"+
            "\1\4\1\uffff\2\4\1\uffff\1\4\1\uffff\1\4\1\uffff\2\4\3\uffff"+
            "\1\1\15\uffff\1\3",
            "\1\5",
            "",
            "\5\4\1\uffff\1\4\13\uffff\1\4\23\uffff\1\4\1\uffff\2\4\1\uffff"+
            "\1\4\1\uffff\2\4\1\uffff\1\4\1\uffff\1\4\1\uffff\2\4\3\uffff"+
            "\1\1\15\uffff\1\3"
    };

    static final short[] DFA45_eot = DFA.unpackEncodedString(DFA45_eotS);
    static final short[] DFA45_eof = DFA.unpackEncodedString(DFA45_eofS);
    static final char[] DFA45_min = DFA.unpackEncodedStringToUnsignedChars(DFA45_minS);
    static final char[] DFA45_max = DFA.unpackEncodedStringToUnsignedChars(DFA45_maxS);
    static final short[] DFA45_accept = DFA.unpackEncodedString(DFA45_acceptS);
    static final short[] DFA45_special = DFA.unpackEncodedString(DFA45_specialS);
    static final short[][] DFA45_transition;

    static {
        int numStates = DFA45_transitionS.length;
        DFA45_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA45_transition[i] = DFA.unpackEncodedString(DFA45_transitionS[i]);
        }
    }

    class DFA45 extends DFA {

        public DFA45(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 45;
            this.eot = DFA45_eot;
            this.eof = DFA45_eof;
            this.min = DFA45_min;
            this.max = DFA45_max;
            this.accept = DFA45_accept;
            this.special = DFA45_special;
            this.transition = DFA45_transition;
        }
        public String getDescription() {
            return "3102:1: ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )?";
        }
    }
    static final String DFA55_eotS =
        "\10\uffff";
    static final String DFA55_eofS =
        "\10\uffff";
    static final String DFA55_minS =
        "\1\11\1\uffff\3\12\1\uffff\2\12";
    static final String DFA55_maxS =
        "\1\110\1\uffff\1\113\1\12\1\104\1\uffff\1\113\1\104";
    static final String DFA55_acceptS =
        "\1\uffff\1\1\3\uffff\1\2\2\uffff";
    static final String DFA55_specialS =
        "\10\uffff}>";
    static final String[] DFA55_transitionS = {
            "\1\1\1\2\13\1\45\uffff\1\1\6\uffff\1\1\2\uffff\1\1\1\uffff"+
            "\2\1",
            "",
            "\1\1\13\uffff\1\4\6\uffff\1\5\45\uffff\1\5\1\1\6\uffff\1\3",
            "\1\6",
            "\1\1\13\uffff\1\4\1\7\5\uffff\1\5\45\uffff\1\5\1\1",
            "",
            "\1\1\13\uffff\1\4\6\uffff\1\5\45\uffff\1\5\1\1\6\uffff\1\3",
            "\1\1\13\uffff\1\4\6\uffff\1\5\45\uffff\1\5\1\1"
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
            return "3782:1: ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )?";
        }
    }
    static final String DFA56_eotS =
        "\5\uffff";
    static final String DFA56_eofS =
        "\5\uffff";
    static final String DFA56_minS =
        "\2\26\2\uffff\1\26";
    static final String DFA56_maxS =
        "\2\103\2\uffff\1\103";
    static final String DFA56_acceptS =
        "\2\uffff\1\1\1\2\1\uffff";
    static final String DFA56_specialS =
        "\5\uffff}>";
    static final String[] DFA56_transitionS = {
            "\1\1\6\uffff\1\2\45\uffff\1\3",
            "\1\1\1\4\5\uffff\1\2\45\uffff\1\3",
            "",
            "",
            "\1\1\6\uffff\1\2\45\uffff\1\3"
    };

    static final short[] DFA56_eot = DFA.unpackEncodedString(DFA56_eotS);
    static final short[] DFA56_eof = DFA.unpackEncodedString(DFA56_eofS);
    static final char[] DFA56_min = DFA.unpackEncodedStringToUnsignedChars(DFA56_minS);
    static final char[] DFA56_max = DFA.unpackEncodedStringToUnsignedChars(DFA56_maxS);
    static final short[] DFA56_accept = DFA.unpackEncodedString(DFA56_acceptS);
    static final short[] DFA56_special = DFA.unpackEncodedString(DFA56_specialS);
    static final short[][] DFA56_transition;

    static {
        int numStates = DFA56_transitionS.length;
        DFA56_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA56_transition[i] = DFA.unpackEncodedString(DFA56_transitionS[i]);
        }
    }

    class DFA56 extends DFA {

        public DFA56(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 56;
            this.eot = DFA56_eot;
            this.eof = DFA56_eof;
            this.min = DFA56_min;
            this.max = DFA56_max;
            this.accept = DFA56_accept;
            this.special = DFA56_special;
            this.transition = DFA56_transition;
        }
        public String getDescription() {
            return "3823:2: ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )?";
        }
    }
    static final String DFA57_eotS =
        "\7\uffff";
    static final String DFA57_eofS =
        "\2\2\2\uffff\3\2";
    static final String DFA57_minS =
        "\2\4\2\uffff\3\4";
    static final String DFA57_maxS =
        "\2\111\2\uffff\3\111";
    static final String DFA57_acceptS =
        "\2\uffff\1\2\1\1\3\uffff";
    static final String DFA57_specialS =
        "\7\uffff}>";
    static final String[] DFA57_transitionS = {
            "\7\2\13\uffff\1\1\7\uffff\3\2\2\uffff\4\2\3\uffff\4\2\1\uffff"+
            "\1\2\1\uffff\12\2\10\uffff\1\2\1\3\4\uffff\1\2",
            "\7\2\13\uffff\1\5\1\4\6\uffff\3\2\2\uffff\4\2\3\uffff\4\2"+
            "\1\uffff\1\2\1\uffff\12\2\10\uffff\1\2\1\3\4\uffff\1\2",
            "",
            "",
            "\7\2\13\uffff\1\5\7\uffff\3\2\2\uffff\4\2\3\uffff\4\2\1\uffff"+
            "\1\2\1\uffff\12\2\10\uffff\1\2\1\3\4\uffff\1\2",
            "\7\2\13\uffff\1\5\1\6\6\uffff\3\2\2\uffff\4\2\3\uffff\4\2"+
            "\1\uffff\1\2\1\uffff\12\2\10\uffff\1\2\1\3\4\uffff\1\2",
            "\7\2\13\uffff\1\5\7\uffff\3\2\2\uffff\4\2\3\uffff\4\2\1\uffff"+
            "\1\2\1\uffff\12\2\10\uffff\1\2\1\3\4\uffff\1\2"
    };

    static final short[] DFA57_eot = DFA.unpackEncodedString(DFA57_eotS);
    static final short[] DFA57_eof = DFA.unpackEncodedString(DFA57_eofS);
    static final char[] DFA57_min = DFA.unpackEncodedStringToUnsignedChars(DFA57_minS);
    static final char[] DFA57_max = DFA.unpackEncodedStringToUnsignedChars(DFA57_maxS);
    static final short[] DFA57_accept = DFA.unpackEncodedString(DFA57_acceptS);
    static final short[] DFA57_special = DFA.unpackEncodedString(DFA57_specialS);
    static final short[][] DFA57_transition;

    static {
        int numStates = DFA57_transitionS.length;
        DFA57_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA57_transition[i] = DFA.unpackEncodedString(DFA57_transitionS[i]);
        }
    }

    class DFA57 extends DFA {

        public DFA57(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 57;
            this.eot = DFA57_eot;
            this.eof = DFA57_eof;
            this.min = DFA57_min;
            this.max = DFA57_max;
            this.accept = DFA57_accept;
            this.special = DFA57_special;
            this.transition = DFA57_transition;
        }
        public String getDescription() {
            return "()* loopback of 3904:2: ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )*";
        }
    }
    static final String DFA59_eotS =
        "\12\uffff";
    static final String DFA59_eofS =
        "\12\uffff";
    static final String DFA59_minS =
        "\1\11\1\uffff\1\12\2\uffff\1\113\1\12\1\113\1\106\1\uffff";
    static final String DFA59_maxS =
        "\1\110\1\uffff\1\12\2\uffff\1\113\1\25\1\113\1\112\1\uffff";
    static final String DFA59_acceptS =
        "\1\uffff\1\1\1\uffff\1\2\1\3\4\uffff\1\4";
    static final String DFA59_specialS =
        "\12\uffff}>";
    static final String[] DFA59_transitionS = {
            "\1\1\1\3\12\1\60\uffff\1\2\1\uffff\1\1\1\4",
            "",
            "\1\5",
            "",
            "",
            "\1\6",
            "\1\7\12\uffff\1\10",
            "\1\6",
            "\1\11\3\uffff\1\1",
            ""
    };

    static final short[] DFA59_eot = DFA.unpackEncodedString(DFA59_eotS);
    static final short[] DFA59_eof = DFA.unpackEncodedString(DFA59_eofS);
    static final char[] DFA59_min = DFA.unpackEncodedStringToUnsignedChars(DFA59_minS);
    static final char[] DFA59_max = DFA.unpackEncodedStringToUnsignedChars(DFA59_maxS);
    static final short[] DFA59_accept = DFA.unpackEncodedString(DFA59_acceptS);
    static final short[] DFA59_special = DFA.unpackEncodedString(DFA59_specialS);
    static final short[][] DFA59_transition;

    static {
        int numStates = DFA59_transitionS.length;
        DFA59_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA59_transition[i] = DFA.unpackEncodedString(DFA59_transitionS[i]);
        }
    }

    class DFA59 extends DFA {

        public DFA59(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 59;
            this.eot = DFA59_eot;
            this.eof = DFA59_eof;
            this.min = DFA59_min;
            this.max = DFA59_max;
            this.accept = DFA59_accept;
            this.special = DFA59_special;
            this.transition = DFA59_transition;
        }
        public String getDescription() {
            return "4013:1: (this_StaticValue_0= ruleStaticValue | this_Variable_1= ruleVariable | this_NestedObject_2= ruleNestedObject | this_TypedNestedObject_3= ruleTypedNestedObject )";
        }
    }
    static final String DFA61_eotS =
        "\25\uffff";
    static final String DFA61_eofS =
        "\5\uffff\3\13\5\uffff\10\13";
    static final String DFA61_minS =
        "\1\11\4\uffff\3\4\5\uffff\10\4";
    static final String DFA61_maxS =
        "\1\107\4\uffff\3\111\5\uffff\10\111";
    static final String DFA61_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\3\uffff\1\6\1\10\1\11\1\5\1\7\10\uffff";
    static final String DFA61_specialS =
        "\25\uffff}>";
    static final String[] DFA61_transitionS = {
            "\1\1\1\uffff\1\2\1\3\2\4\1\5\1\6\1\7\3\10\60\uffff\1\12\1\uffff"+
            "\1\11",
            "",
            "",
            "",
            "",
            "\7\13\7\uffff\1\14\3\uffff\1\13\5\uffff\1\13\1\uffff\3\13"+
            "\2\uffff\4\13\3\uffff\4\13\1\uffff\1\13\1\uffff\12\13\1\uffff"+
            "\6\13\1\uffff\2\13\4\uffff\1\13",
            "\7\13\10\uffff\2\14\1\uffff\1\15\5\uffff\1\13\1\uffff\3\13"+
            "\2\uffff\4\13\3\uffff\4\13\1\uffff\1\13\1\uffff\12\13\1\uffff"+
            "\6\13\1\uffff\2\13\4\uffff\1\13",
            "\7\13\11\uffff\1\14\1\uffff\1\16\5\uffff\1\13\1\uffff\3\13"+
            "\2\uffff\4\13\3\uffff\4\13\1\uffff\1\13\1\uffff\12\13\1\uffff"+
            "\6\13\1\uffff\2\13\4\uffff\1\13",
            "",
            "",
            "",
            "",
            "",
            "\7\13\10\uffff\2\14\1\uffff\1\20\1\17\4\uffff\1\13\1\uffff"+
            "\3\13\2\uffff\4\13\3\uffff\4\13\1\uffff\1\13\1\uffff\12\13\1"+
            "\uffff\6\13\1\uffff\2\13\4\uffff\1\13",
            "\7\13\11\uffff\1\14\1\uffff\1\22\1\21\4\uffff\1\13\1\uffff"+
            "\3\13\2\uffff\4\13\3\uffff\4\13\1\uffff\1\13\1\uffff\12\13\1"+
            "\uffff\6\13\1\uffff\2\13\4\uffff\1\13",
            "\7\13\10\uffff\2\14\1\uffff\1\20\5\uffff\1\13\1\uffff\3\13"+
            "\2\uffff\4\13\3\uffff\4\13\1\uffff\1\13\1\uffff\12\13\1\uffff"+
            "\6\13\1\uffff\2\13\4\uffff\1\13",
            "\7\13\10\uffff\2\14\1\uffff\1\20\1\23\4\uffff\1\13\1\uffff"+
            "\3\13\2\uffff\4\13\3\uffff\4\13\1\uffff\1\13\1\uffff\12\13\1"+
            "\uffff\6\13\1\uffff\2\13\4\uffff\1\13",
            "\7\13\11\uffff\1\14\1\uffff\1\22\5\uffff\1\13\1\uffff\3\13"+
            "\2\uffff\4\13\3\uffff\4\13\1\uffff\1\13\1\uffff\12\13\1\uffff"+
            "\6\13\1\uffff\2\13\4\uffff\1\13",
            "\7\13\11\uffff\1\14\1\uffff\1\22\1\24\4\uffff\1\13\1\uffff"+
            "\3\13\2\uffff\4\13\3\uffff\4\13\1\uffff\1\13\1\uffff\12\13\1"+
            "\uffff\6\13\1\uffff\2\13\4\uffff\1\13",
            "\7\13\10\uffff\2\14\1\uffff\1\20\5\uffff\1\13\1\uffff\3\13"+
            "\2\uffff\4\13\3\uffff\4\13\1\uffff\1\13\1\uffff\12\13\1\uffff"+
            "\6\13\1\uffff\2\13\4\uffff\1\13",
            "\7\13\11\uffff\1\14\1\uffff\1\22\5\uffff\1\13\1\uffff\3\13"+
            "\2\uffff\4\13\3\uffff\4\13\1\uffff\1\13\1\uffff\12\13\1\uffff"+
            "\6\13\1\uffff\2\13\4\uffff\1\13"
    };

    static final short[] DFA61_eot = DFA.unpackEncodedString(DFA61_eotS);
    static final short[] DFA61_eof = DFA.unpackEncodedString(DFA61_eofS);
    static final char[] DFA61_min = DFA.unpackEncodedStringToUnsignedChars(DFA61_minS);
    static final char[] DFA61_max = DFA.unpackEncodedStringToUnsignedChars(DFA61_maxS);
    static final short[] DFA61_accept = DFA.unpackEncodedString(DFA61_acceptS);
    static final short[] DFA61_special = DFA.unpackEncodedString(DFA61_specialS);
    static final short[][] DFA61_transition;

    static {
        int numStates = DFA61_transitionS.length;
        DFA61_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA61_transition[i] = DFA.unpackEncodedString(DFA61_transitionS[i]);
        }
    }

    class DFA61 extends DFA {

        public DFA61(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 61;
            this.eot = DFA61_eot;
            this.eof = DFA61_eof;
            this.min = DFA61_min;
            this.max = DFA61_max;
            this.accept = DFA61_accept;
            this.special = DFA61_special;
            this.transition = DFA61_transition;
        }
        public String getDescription() {
            return "4113:1: (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_BooleanValue_3= ruleBooleanValue | this_DateValue_4= ruleDateValue | this_TimeValue_5= ruleTimeValue | this_DateAndTimeValue_6= ruleDateAndTimeValue | this_NullValue_7= ruleNullValue | this_JavaConstantValue_8= ruleJavaConstantValue )";
        }
    }
    static final String DFA65_eotS =
        "\10\uffff";
    static final String DFA65_eofS =
        "\10\uffff";
    static final String DFA65_minS =
        "\1\17\1\uffff\1\23\1\uffff\1\23\2\uffff\1\23";
    static final String DFA65_maxS =
        "\1\21\1\uffff\1\26\1\uffff\1\27\2\uffff\1\26";
    static final String DFA65_acceptS =
        "\1\uffff\1\1\1\uffff\1\4\1\uffff\1\2\1\3\1\uffff";
    static final String DFA65_specialS =
        "\10\uffff}>";
    static final String[] DFA65_transitionS = {
            "\1\1\1\2\1\3",
            "",
            "\1\5\1\6\1\uffff\1\4",
            "",
            "\1\5\1\6\1\uffff\1\4\1\7",
            "",
            "",
            "\1\5\1\6\1\uffff\1\4"
    };

    static final short[] DFA65_eot = DFA.unpackEncodedString(DFA65_eotS);
    static final short[] DFA65_eof = DFA.unpackEncodedString(DFA65_eofS);
    static final char[] DFA65_min = DFA.unpackEncodedStringToUnsignedChars(DFA65_minS);
    static final char[] DFA65_max = DFA.unpackEncodedStringToUnsignedChars(DFA65_maxS);
    static final short[] DFA65_accept = DFA.unpackEncodedString(DFA65_acceptS);
    static final short[] DFA65_special = DFA.unpackEncodedString(DFA65_specialS);
    static final short[][] DFA65_transition;

    static {
        int numStates = DFA65_transitionS.length;
        DFA65_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA65_transition[i] = DFA.unpackEncodedString(DFA65_transitionS[i]);
        }
    }

    class DFA65 extends DFA {

        public DFA65(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 65;
            this.eot = DFA65_eot;
            this.eof = DFA65_eof;
            this.min = DFA65_min;
            this.max = DFA65_max;
            this.accept = DFA65_accept;
            this.special = DFA65_special;
            this.transition = DFA65_transition;
        }
        public String getDescription() {
            return "4731:1: (this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue | this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue | this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue | this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue )";
        }
    }
 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNL_in_ruleModel135 = new BitSet(new long[]{0x0000000990000002L});
    public static final BitSet FOLLOW_ruleStatement_in_ruleModel155 = new BitSet(new long[]{0x0000000990000002L});
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
    public static final BitSet FOLLOW_ruleVisibleSingleLineNormalComment_in_ruleVisibleSingleLineComment541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleSingleLineTitleComment_in_ruleVisibleSingleLineComment568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleSingleLineNormalComment_in_entryRuleVisibleSingleLineNormalComment603 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVisibleSingleLineNormalComment613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SL_VISIBLE_COMMENT_in_ruleVisibleSingleLineNormalComment655 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVisibleSingleLineNormalComment676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleSingleLineTitleComment_in_entryRuleVisibleSingleLineTitleComment711 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVisibleSingleLineTitleComment721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_SL_VISIBLE_TITLE_COMMENT_in_ruleVisibleSingleLineTitleComment763 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVisibleSingleLineTitleComment784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleMultiLineComment_in_entryRuleVisibleMultiLineComment819 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVisibleMultiLineComment829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleMultiLineNormalComment_in_ruleVisibleMultiLineComment876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleMultiLineTitleComment_in_ruleVisibleMultiLineComment903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleMultiLineNormalComment_in_entryRuleVisibleMultiLineNormalComment938 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVisibleMultiLineNormalComment948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ML_VISIBLE_COMMENT_in_ruleVisibleMultiLineNormalComment990 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVisibleMultiLineNormalComment1011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleMultiLineTitleComment_in_entryRuleVisibleMultiLineTitleComment1046 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVisibleMultiLineTitleComment1056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ML_VISIBLE_TITLE_COMMENT_in_ruleVisibleMultiLineTitleComment1098 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVisibleMultiLineTitleComment1119 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleDivider_in_entryRuleVisibleDivider1154 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVisibleDivider1164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DIVIDER_in_ruleVisibleDivider1206 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVisibleDivider1227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageDefinition_in_entryRulePackageDefinition1262 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageDefinition1272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rulePackageDefinition1309 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_rulePackageDefinition1325 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rulePackageDefinition1345 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_rulePackageDefinition1357 = new BitSet(new long[]{0x0000B879D0400000L});
    public static final BitSet FOLLOW_ruleNL_in_rulePackageDefinition1373 = new BitSet(new long[]{0x0000B879D0000000L});
    public static final BitSet FOLLOW_rulePackageStatement_in_rulePackageDefinition1393 = new BitSet(new long[]{0x0000B879D0000000L});
    public static final BitSet FOLLOW_30_in_rulePackageDefinition1406 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleNL_in_rulePackageDefinition1422 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePackageStatement_in_entryRulePackageStatement1457 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePackageStatement1467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rulePackageStatement1514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForkDefinition_in_rulePackageStatement1541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariantDefinition_in_rulePackageStatement1568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestDefinition_in_rulePackageStatement1595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallDefinition_in_rulePackageStatement1622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationDefinition_in_rulePackageStatement1649 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteDefinition_in_rulePackageStatement1676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_rulePackageStatement1703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantDefinition_in_rulePackageStatement1730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport1765 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport1775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleImport1812 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleImport1828 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_ruleImport1848 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleImport1864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleForkDefinition_in_entryRuleForkDefinition1899 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleForkDefinition1909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleForkDefinition1946 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleForkDefinition1962 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleForkDefinition1982 = new BitSet(new long[]{0x0000000200400600L});
    public static final BitSet FOLLOW_ruleNL_in_ruleForkDefinition1998 = new BitSet(new long[]{0x0000000200000602L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleForkDefinition2015 = new BitSet(new long[]{0x0000000200400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleForkDefinition2036 = new BitSet(new long[]{0x0000000200000402L});
    public static final BitSet FOLLOW_33_in_ruleForkDefinition2050 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleForkDefinition2066 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleJavaClassReference_in_ruleForkDefinition2086 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleForkDefinition2102 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_ruleForkParameter_in_ruleForkDefinition2125 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleForkDefinition2141 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_ruleForkParameter_in_entryRuleForkParameter2178 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleForkParameter2188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedParameterName_in_ruleForkParameter2234 = new BitSet(new long[]{0x0000000400400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleForkParameter2250 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleForkParameter2261 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleNL_in_ruleForkParameter2277 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperation_in_ruleForkParameter2297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariantDefinition_in_entryRuleVariantDefinition2333 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariantDefinition2343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleVariantDefinition2380 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVariantDefinition2396 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleVariantDefinition2416 = new BitSet(new long[]{0x0000000000400200L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVariantDefinition2432 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVariantDefinition2449 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVariantDefinition2470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTestDefinition_in_entryRuleTestDefinition2507 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTestDefinition2517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_ruleTestDefinition2554 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleTestDefinition2570 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTestDefinition2590 = new BitSet(new long[]{0x0000000200400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleTestDefinition2606 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleTestDefinition2617 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleTestDefinition2633 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleMethodReference_in_ruleTestDefinition2653 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleTestDefinition2669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCallDefinition_in_entryRuleCallDefinition2704 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCallDefinition2714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleCallDefinition2751 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleCallDefinition2767 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCallDefinition2787 = new BitSet(new long[]{0x0000000200400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleCallDefinition2803 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleCallDefinition2814 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleCallDefinition2830 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleMethodReference_in_ruleCallDefinition2850 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleCallDefinition2866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteDefinition_in_entryRuleSuiteDefinition2901 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteDefinition2911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_ruleSuiteDefinition2948 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuiteDefinition2964 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuiteDefinition2984 = new BitSet(new long[]{0x0000038020400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuiteDefinition3000 = new BitSet(new long[]{0x0000038020000000L});
    public static final BitSet FOLLOW_39_in_ruleSuiteDefinition3012 = new BitSet(new long[]{0x0000030020400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuiteDefinition3028 = new BitSet(new long[]{0x0000030020400400L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_ruleSuiteDefinition3049 = new BitSet(new long[]{0x0000030020400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuiteDefinition3065 = new BitSet(new long[]{0x0000030020400400L});
    public static final BitSet FOLLOW_40_in_ruleSuiteDefinition3081 = new BitSet(new long[]{0x0000020020400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuiteDefinition3097 = new BitSet(new long[]{0x0000020020400400L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuiteDefinition3120 = new BitSet(new long[]{0x0000020020400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuiteDefinition3136 = new BitSet(new long[]{0x0000020020400400L});
    public static final BitSet FOLLOW_41_in_ruleSuiteDefinition3152 = new BitSet(new long[]{0x0000000020400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuiteDefinition3168 = new BitSet(new long[]{0x0000000020400400L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuiteDefinition3191 = new BitSet(new long[]{0x0000000020400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuiteDefinition3207 = new BitSet(new long[]{0x0000000020400400L});
    public static final BitSet FOLLOW_29_in_ruleSuiteDefinition3222 = new BitSet(new long[]{0x0154BC79904001F0L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuiteDefinition3238 = new BitSet(new long[]{0x0154BC79900001F0L});
    public static final BitSet FOLLOW_ruleSuiteStatement_in_ruleSuiteDefinition3258 = new BitSet(new long[]{0x0154BC79900001F0L});
    public static final BitSet FOLLOW_42_in_ruleSuiteDefinition3271 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuiteDefinition3287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperationDefinition_in_entryRuleOperationDefinition3322 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperationDefinition3332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleOperationDefinition3369 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleOperationDefinition3385 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleOperationDefinition3405 = new BitSet(new long[]{0x0000000200400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleOperationDefinition3421 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_33_in_ruleOperationDefinition3432 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleOperationDefinition3448 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleJavaClassReference_in_ruleOperationDefinition3468 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleOperationDefinition3484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteStatement_in_entryRuleSuiteStatement3519 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteStatement3529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteStatementWithResult_in_ruleSuiteStatement3576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_ruleSuiteStatement3603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantDefinition_in_ruleSuiteStatement3630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleComment_in_ruleSuiteStatement3657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVisibleDivider_in_ruleSuiteStatement3684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuiteStatementWithResult_in_entryRuleSuiteStatementWithResult3719 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteStatementWithResult3729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_ruleSuiteStatementWithResult3776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTest_in_ruleSuiteStatementWithResult3803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTableTest_in_ruleSuiteStatementWithResult3830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_ruleSuiteStatementWithResult3857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableDefinition_in_entryRuleVariableDefinition3892 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableDefinition3902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleVariableDefinition3945 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45_in_ruleVariableDefinition3971 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVariableDefinition3987 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_ruleVariableDefinition4007 = new BitSet(new long[]{0x0000400000400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVariableDefinition4023 = new BitSet(new long[]{0x0000400000000002L});
    public static final BitSet FOLLOW_46_in_ruleVariableDefinition4035 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVariableDefinition4051 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleVariableDefinition4071 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVariableDefinition4087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantDefinition_in_entryRuleConstantDefinition4124 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstantDefinition4134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleConstantDefinition4177 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47_in_ruleConstantDefinition4203 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleConstantDefinition4219 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleConstantEntity_in_ruleConstantDefinition4239 = new BitSet(new long[]{0x08030000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleNL_in_ruleConstantDefinition4255 = new BitSet(new long[]{0x08030000007FFE02L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleConstantDefinition4278 = new BitSet(new long[]{0x0002000000400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleConstantDefinition4294 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_ruleVariantValue_in_ruleConstantDefinition4317 = new BitSet(new long[]{0x0002000000400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleConstantDefinition4333 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_48_in_ruleConstantDefinition4360 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleConstantDefinition4389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariantValue_in_entryRuleVariantValue4426 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariantValue4436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_ruleVariantValue4473 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVariantValue4489 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleVariantValue4512 = new BitSet(new long[]{0x0000000400400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVariantValue4528 = new BitSet(new long[]{0x0000000400400400L});
    public static final BitSet FOLLOW_34_in_ruleVariantValue4541 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleNL_in_ruleVariantValue4557 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleVariantValue4577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableEntity_in_entryRuleVariableEntity4613 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableEntity4623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleVariableEntity4668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantEntity_in_entryRuleConstantEntity4703 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstantEntity4713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleConstantEntity4758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTest_in_entryRuleTest4795 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTest4805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_ruleTest4842 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleTest4858 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTest4880 = new BitSet(new long[]{0x0408000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleTest4897 = new BitSet(new long[]{0x0400000000400400L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleTest4917 = new BitSet(new long[]{0x0408000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleTest4936 = new BitSet(new long[]{0x0400000000400400L});
    public static final BitSet FOLLOW_ruleNamedResult_in_ruleTest4956 = new BitSet(new long[]{0x0408000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleTest4975 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleTest4986 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleNL_in_ruleTest5002 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleTest5022 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleTest5040 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTableTest_in_entryRuleTableTest5075 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTableTest5085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_ruleTableTest5122 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleTableTest5138 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTableTest5160 = new BitSet(new long[]{0x0400000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleTableTest5177 = new BitSet(new long[]{0x0400000000400400L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleTableTest5197 = new BitSet(new long[]{0x0400000000400400L});
    public static final BitSet FOLLOW_ruleNLFORCED_in_ruleTableTest5215 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_ruleParameterTableHeader_in_ruleTableTest5235 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_ruleResultTableHeader_in_ruleTableTest5257 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleTableTest5270 = new BitSet(new long[]{0x0408000000400400L});
    public static final BitSet FOLLOW_51_in_ruleTableTest5289 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_53_in_ruleTableTest5314 = new BitSet(new long[]{0x0400000000400400L});
    public static final BitSet FOLLOW_ruleNLFORCED_in_ruleTableTest5333 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_ruleTableTestRow_in_ruleTableTest5353 = new BitSet(new long[]{0x0400000000400400L});
    public static final BitSet FOLLOW_ruleNLFORCED_in_ruleTableTest5371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTableTestRow_in_entryRuleTableTestRow5406 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTableTestRow5416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableValue_in_ruleTableTestRow5471 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableHeader_in_entryRuleParameterTableHeader5508 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterTableHeader5518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleParameterTableHeader5555 = new BitSet(new long[]{0x0400000000400400L});
    public static final BitSet FOLLOW_ruleParameterName_in_ruleParameterTableHeader5576 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_53_in_ruleParameterTableHeader5589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultTableHeader_in_entryRuleResultTableHeader5627 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultTableHeader5637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleResultTableHeader5674 = new BitSet(new long[]{0x0400000000400400L});
    public static final BitSet FOLLOW_ruleResultName_in_ruleResultTableHeader5695 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleResultTableHeader5707 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_53_in_ruleResultTableHeader5720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterTableValue_in_entryRuleParameterTableValue5758 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterTableValue5768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_ruleParameterTableValue5805 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleParameterTableValue5826 = new BitSet(new long[]{0x0020000000000002L});
    public static final BitSet FOLLOW_53_in_ruleParameterTableValue5839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedResult_in_entryRuleNamedResult5877 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedResult5887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultName_in_ruleNamedResult5933 = new BitSet(new long[]{0x0008000000400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleNamedResult5949 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_51_in_ruleNamedResult5960 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleNL_in_ruleNamedResult5976 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleNamedResult5996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultName_in_entryRuleResultName6032 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleResultName6042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedResultName_in_ruleResultName6089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterOrResultName_in_ruleResultName6116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedResultName_in_entryRuleFixedResultName6151 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFixedResultName6161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFixedResultName6205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCall_in_entryRuleCall6240 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCall6250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleCall6287 = new BitSet(new long[]{0x00000000005FFE00L,0x00000000000000A0L});
    public static final BitSet FOLLOW_ruleNL_in_ruleCall6303 = new BitSet(new long[]{0x00000000005FFE00L,0x00000000000000A0L});
    public static final BitSet FOLLOW_ruleExecutionMultiplier_in_ruleCall6324 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleCall6340 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCall6364 = new BitSet(new long[]{0x0480000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleCall6381 = new BitSet(new long[]{0x0400000000400400L});
    public static final BitSet FOLLOW_ruleParameter_in_ruleCall6401 = new BitSet(new long[]{0x0480000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleCall6420 = new BitSet(new long[]{0x0400000000400400L});
    public static final BitSet FOLLOW_ruleNamedCallResult_in_ruleCall6440 = new BitSet(new long[]{0x0480000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleCall6459 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_ruleCall6470 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleCall6486 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleVariableVariable_in_ruleCall6506 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleCall6524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNamedCallResult_in_entryRuleNamedCallResult6559 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNamedCallResult6569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleResultName_in_ruleNamedCallResult6615 = new BitSet(new long[]{0x0080000000400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleNamedCallResult6631 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_55_in_ruleNamedCallResult6642 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleNamedCallResult6658 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleVariableVariable_in_ruleNamedCallResult6678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSuite_in_entryRuleSuite6714 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuite6724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleSuite6761 = new BitSet(new long[]{0x00000000005FFE00L,0x00000000000000A0L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuite6777 = new BitSet(new long[]{0x00000000005FFE00L,0x00000000000000A0L});
    public static final BitSet FOLLOW_ruleExecutionMultiplier_in_ruleSuite6798 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuite6814 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuite6838 = new BitSet(new long[]{0x0202000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuite6854 = new BitSet(new long[]{0x0202000000400402L});
    public static final BitSet FOLLOW_ruleSuiteParameter_in_ruleSuite6875 = new BitSet(new long[]{0x0202000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuite6891 = new BitSet(new long[]{0x0202000000400402L});
    public static final BitSet FOLLOW_57_in_ruleSuite6905 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuite6921 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuite6943 = new BitSet(new long[]{0x0002000000400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuite6959 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_ruleSuite6973 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuite6989 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuite7012 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuite7028 = new BitSet(new long[]{0x0000000000400402L});
    public static final BitSet FOLLOW_ruleSuiteParameter_in_entryRuleSuiteParameter7067 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSuiteParameter7077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleSuiteParameter7125 = new BitSet(new long[]{0x0000000400400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuiteParameter7141 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleSuiteParameter7152 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleNL_in_ruleSuiteParameter7168 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleSuiteParameter7188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameter_in_entryRuleParameter7224 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameter7234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterName_in_ruleParameter7280 = new BitSet(new long[]{0x0000000400400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleParameter7296 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleParameter7307 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleNL_in_ruleParameter7323 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleParameter7343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleParameterName_in_entryRuleParameterName7379 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterName7389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedParameterName_in_ruleParameterName7436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterOrResultName_in_ruleParameterName7463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFixedParameterName_in_entryRuleFixedParameterName7498 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFixedParameterName7508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleFixedParameterName7552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArbitraryParameterOrResultName_in_entryRuleArbitraryParameterOrResultName7587 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArbitraryParameterOrResultName7597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleArbitraryParameterOrResultName7634 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleArbitraryParameterOrResultName7652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleArbitraryParameterOrResultName7680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperation_in_entryRuleOperation7722 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleOperation7732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStandardOperation_in_ruleOperation7779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCustomOperation_in_ruleOperation7806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStandardOperation_in_entryRuleStandardOperation7841 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStandardOperation7851 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleStandardOperation7888 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleNL_in_ruleStandardOperation7904 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperation_in_ruleStandardOperation7924 = new BitSet(new long[]{0xF400000000400000L,0x0000000000000001L});
    public static final BitSet FOLLOW_ruleNL_in_ruleStandardOperation7940 = new BitSet(new long[]{0xF400000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_58_in_ruleStandardOperation7960 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_60_in_ruleStandardOperation7989 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_61_in_ruleStandardOperation8018 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_62_in_ruleStandardOperation8047 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_63_in_ruleStandardOperation8076 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_64_in_ruleStandardOperation8105 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleNL_in_ruleStandardOperation8137 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperation_in_ruleStandardOperation8157 = new BitSet(new long[]{0xF400000000400000L,0x0000000000000003L});
    public static final BitSet FOLLOW_ruleNL_in_ruleStandardOperation8173 = new BitSet(new long[]{0xF400000000000000L,0x0000000000000003L});
    public static final BitSet FOLLOW_65_in_ruleStandardOperation8186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCustomOperation_in_entryRuleCustomOperation8222 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCustomOperation8232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleCustomOperation8269 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleNL_in_ruleCustomOperation8285 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleCustomOperation8306 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleNL_in_ruleCustomOperation8322 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleCustomOperation8346 = new BitSet(new long[]{0x0000000020400000L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleNL_in_ruleCustomOperation8363 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleCustomOperation8374 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleCustomOperation8395 = new BitSet(new long[]{0x0000000000400000L,0x0000000000000008L});
    public static final BitSet FOLLOW_ruleNL_in_ruleCustomOperation8413 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_67_in_ruleCustomOperation8424 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_entryRuleValueOrEnumValueOrOperationCollection8460 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueOrEnumValueOrOperationCollection8470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperation_in_ruleValueOrEnumValueOrOperationCollection8516 = new BitSet(new long[]{0x0000000000400002L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleNL_in_ruleValueOrEnumValueOrOperationCollection8533 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ruleValueOrEnumValueOrOperationCollection8544 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleNL_in_ruleValueOrEnumValueOrOperationCollection8560 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperation_in_ruleValueOrEnumValueOrOperationCollection8580 = new BitSet(new long[]{0x0000000000400002L,0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperation_in_entryRuleValueOrEnumValueOrOperation8618 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValueOrEnumValueOrOperation8628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_ruleValueOrEnumValueOrOperation8675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumValue_in_ruleValueOrEnumValueOrOperation8702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleOperation_in_ruleValueOrEnumValueOrOperation8729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValue_in_entryRuleValue8764 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValue8774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticValue_in_ruleValue8821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleValue8848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNestedObject_in_ruleValue8875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypedNestedObject_in_ruleValue8902 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantValue_in_entryRuleConstantValue8937 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstantValue8947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticValue_in_ruleConstantValue8994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_ruleConstantValue9021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStaticValue_in_entryRuleStaticValue9056 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStaticValue9066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringValue_in_ruleStaticValue9113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerValue_in_ruleStaticValue9140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalValue_in_ruleStaticValue9167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanValue_in_ruleStaticValue9194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateValue_in_ruleStaticValue9221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeValue_in_ruleStaticValue9248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateAndTimeValue_in_ruleStaticValue9275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullValue_in_ruleStaticValue9302 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaConstantValue_in_ruleStaticValue9329 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIntegerValue_in_entryRuleIntegerValue9364 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIntegerValue9374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INTEGER_in_ruleIntegerValue9415 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDecimalValue_in_entryRuleDecimalValue9455 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDecimalValue9465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_DECIMAL_in_ruleDecimalValue9506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringValue_in_entryRuleStringValue9546 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringValue9556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleStringValue9597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanValue_in_entryRuleBooleanValue9637 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanValue9647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOLEAN_TRUE_in_ruleBooleanValue9690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_BOOLEAN_FALSE_in_ruleBooleanValue9710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateValue_in_entryRuleDateValue9753 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDateValue9763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIsoDateValue_in_ruleDateValue9810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEuropeanDateValue_in_ruleDateValue9837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUSDateValue_in_ruleDateValue9864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIsoDateValue_in_entryRuleIsoDateValue9899 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIsoDateValue9909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ISODATE_in_ruleIsoDateValue9950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEuropeanDateValue_in_entryRuleEuropeanDateValue9990 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEuropeanDateValue10000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EURODATE_in_ruleEuropeanDateValue10041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUSDateValue_in_entryRuleUSDateValue10081 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUSDateValue10091 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_USDATE_in_ruleUSDateValue10132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTimeValue_in_entryRuleTimeValue10172 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTimeValue10182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIsoTimeValue_in_ruleTimeValue10229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimple24HrsTimeValue_in_ruleTimeValue10256 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimple12HrsTimeValue_in_ruleTimeValue10283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIsoTimeValue_in_entryRuleIsoTimeValue10318 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIsoTimeValue10328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ISOTIME_in_ruleIsoTimeValue10369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimple24HrsTimeValue_in_entryRuleSimple24HrsTimeValue10409 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimple24HrsTimeValue10419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TWENTYFOURHRSTIME_in_ruleSimple24HrsTimeValue10460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimple12HrsTimeValue_in_entryRuleSimple12HrsTimeValue10500 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimple12HrsTimeValue10510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_TWELVEHRSTIME_in_ruleSimple12HrsTimeValue10551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDateAndTimeValue_in_entryRuleDateAndTimeValue10591 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDateAndTimeValue10601 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIsoDateAndTimeValue_in_ruleDateAndTimeValue10648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEuropeanDateAnd24HrsTimeValue_in_ruleDateAndTimeValue10675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEuropeanDateAnd12HrsTimeValue_in_ruleDateAndTimeValue10702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUSDateAnd12HrsTimeValue_in_ruleDateAndTimeValue10729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIsoDateAndTimeValue_in_entryRuleIsoDateAndTimeValue10764 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIsoDateAndTimeValue10774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ISODATE_in_ruleIsoDateAndTimeValue10816 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_RULE_ISOTIME_in_ruleIsoDateAndTimeValue10838 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEuropeanDateAnd24HrsTimeValue_in_entryRuleEuropeanDateAnd24HrsTimeValue10879 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEuropeanDateAnd24HrsTimeValue10889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EURODATE_in_ruleEuropeanDateAnd24HrsTimeValue10931 = new BitSet(new long[]{0x0000000000480000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleEuropeanDateAnd24HrsTimeValue10952 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RULE_TWENTYFOURHRSTIME_in_ruleEuropeanDateAnd24HrsTimeValue10968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEuropeanDateAnd12HrsTimeValue_in_entryRuleEuropeanDateAnd12HrsTimeValue11009 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEuropeanDateAnd12HrsTimeValue11019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_EURODATE_in_ruleEuropeanDateAnd12HrsTimeValue11061 = new BitSet(new long[]{0x0000000000500000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleEuropeanDateAnd12HrsTimeValue11082 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RULE_TWELVEHRSTIME_in_ruleEuropeanDateAnd12HrsTimeValue11098 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUSDateAnd12HrsTimeValue_in_entryRuleUSDateAnd12HrsTimeValue11139 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUSDateAnd12HrsTimeValue11149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_USDATE_in_ruleUSDateAnd12HrsTimeValue11191 = new BitSet(new long[]{0x0000000000500000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleUSDateAnd12HrsTimeValue11212 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_RULE_TWELVEHRSTIME_in_ruleUSDateAnd12HrsTimeValue11228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaConstantValue_in_entryRuleJavaConstantValue11269 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJavaConstantValue11279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleJavaConstantValue11316 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleJavaConstantReference_in_ruleJavaConstantValue11337 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleJavaConstantValue11349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable11385 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable11395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleVariable11442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariableVariable_in_entryRuleVariableVariable11477 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableVariable11487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleVariableVariable11534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstant_in_entryRuleConstant11569 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstant11579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleConstant11626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullValue_in_entryRuleNullValue11661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullValue11671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleNullValue11717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEnumValue_in_entryRuleEnumValue11753 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEnumValue11763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UPPERCASE_ID_in_ruleEnumValue11807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNestedObject_in_entryRuleNestedObject11842 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNestedObject11852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_72_in_ruleNestedObject11889 = new BitSet(new long[]{0x0000000000400600L});
    public static final BitSet FOLLOW_ruleNL_in_ruleNestedObject11905 = new BitSet(new long[]{0x0000000000400600L});
    public static final BitSet FOLLOW_ruleKeyValuePair_in_ruleNestedObject11926 = new BitSet(new long[]{0x0000000000400600L,0x0000000000000200L});
    public static final BitSet FOLLOW_ruleNL_in_ruleNestedObject11942 = new BitSet(new long[]{0x0000000000400600L,0x0000000000000200L});
    public static final BitSet FOLLOW_73_in_ruleNestedObject11955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypedNestedObject_in_entryRuleTypedNestedObject11991 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypedNestedObject12001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleTypedNestedObject12038 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_ruleJavaClassReference_in_ruleTypedNestedObject12059 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_70_in_ruleTypedNestedObject12071 = new BitSet(new long[]{0x0000000000400000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleNL_in_ruleTypedNestedObject12087 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_ruleNestedObject_in_ruleTypedNestedObject12107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyValuePair_in_entryRuleKeyValuePair12143 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyValuePair12153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleKeyValuePair12196 = new BitSet(new long[]{0x0000000400400000L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleKeyValuePair12224 = new BitSet(new long[]{0x0000000400400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleKeyValuePair12246 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_ruleKeyValuePair12257 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleNL_in_ruleKeyValuePair12273 = new BitSet(new long[]{0x08000000007FFE00L,0x00000000000001A4L});
    public static final BitSet FOLLOW_ruleValueOrEnumValueOrOperationCollection_in_ruleKeyValuePair12293 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaClassReference_in_entryRuleJavaClassReference12329 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJavaClassReference12339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_ruleJavaClassReference12386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMethodReference_in_entryRuleMethodReference12421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMethodReference12431 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_ruleMethodReference12479 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_ruleMethodReference12491 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleMethodReference12511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJavaConstantReference_in_entryRuleJavaConstantReference12547 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJavaConstantReference12557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_ruleJavaConstantReference12605 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_74_in_ruleJavaConstantReference12617 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_RULE_UPPERCASE_ID_in_ruleJavaConstantReference12637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExecutionMultiplier_in_entryRuleExecutionMultiplier12673 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExecutionMultiplier12683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstantValue_in_ruleExecutionMultiplier12729 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_61_in_ruleExecutionMultiplier12741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName12778 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName12789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName12829 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_ruleQualifiedName12848 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName12863 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000800L});
    public static final BitSet FOLLOW_ruleQualifiedJavaClassName_in_entryRuleQualifiedJavaClassName12911 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedJavaClassName12922 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedJavaClassName12969 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_ruleQualifiedJavaClassName12987 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_RULE_UPPERCASE_ID_in_ruleQualifiedJavaClassName13002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedNameWithWildcard_in_entryRuleQualifiedNameWithWildcard13048 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedNameWithWildcard13059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleQualifiedNameWithWildcard13106 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_ruleQualifiedNameWithWildcard13125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNL_in_entryRuleNL13168 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNL13179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleNL13219 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleNL13240 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleNLFORCED_in_entryRuleNLFORCED13289 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNLFORCED13300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_NEWLINE_in_ruleNLFORCED13340 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleNLFORCED13361 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleNL_in_ruleNLFORCED13390 = new BitSet(new long[]{0x0000000000000002L});

}