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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SL_VISIBLE_COMMENT", "RULE_SL_VISIBLE_TITLE_COMMENT", "RULE_ML_VISIBLE_COMMENT", "RULE_ML_VISIBLE_TITLE_COMMENT", "RULE_DIVIDER", "RULE_STRING", "RULE_ID", "RULE_INTEGER", "RULE_DECIMAL", "RULE_BOOLEAN_TRUE", "RULE_BOOLEAN_FALSE", "RULE_ISODATE", "RULE_EURODATE", "RULE_USDATE", "RULE_ISOTIME", "RULE_TWENTYFOURHRSTIME", "RULE_TWELVEHRSTIME", "RULE_UPPERCASE_ID", "RULE_NEWLINE", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ISOTIMEZONE", "RULE_ANY_OTHER", "'packagedef'", "'with'", "'packageend'", "'import'", "'private'", "'forkdef'", "'uses'", "':'", "'variantdef'", "'testdef'", "'calldef'", "'single-run'", "'suitedef'", "'gets'", "'returns'", "'requires'", "'concludedby'", "'suiteend'", "'by default'", "'operationdef'", "'variable'", "'initially'", "'constant'", "'parameterized'", "'assign'", "'->'", "'in'", "'checkpoint'", "'test'", "'='", "'tabletest'", "'|'", "'call'", "'suite'", "'on'", "'+'", "'('", "'-'", "'*'", "'/'", "'%'", "'..'", "')'", "'['", "']'", "','", "'<'", "'>'", "'#'", "'null'", "'{'", "'}'", "'.'", "'.*'"
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
    public static final int T__80=80;
    public static final int T__46=46;
    public static final int T__81=81;
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
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;

    // delegates
    // delegators


        public InternalDSLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDSLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDSLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalDSL.g"; }



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
    // InternalDSL.g:67:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalDSL.g:68:2: (iv_ruleModel= ruleModel EOF )
            // InternalDSL.g:69:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:76:1: ruleModel returns [EObject current=null] : ( () ruleNL ( (lv_statements_2_0= ruleStatement ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_statements_2_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:79:28: ( ( () ruleNL ( (lv_statements_2_0= ruleStatement ) )* ) )
            // InternalDSL.g:80:1: ( () ruleNL ( (lv_statements_2_0= ruleStatement ) )* )
            {
            // InternalDSL.g:80:1: ( () ruleNL ( (lv_statements_2_0= ruleStatement ) )* )
            // InternalDSL.g:80:2: () ruleNL ( (lv_statements_2_0= ruleStatement ) )*
            {
            // InternalDSL.g:80:2: ()
            // InternalDSL.g:81:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getModelAccess().getModelAction_0(),
                        current);
                

            }

             
                    newCompositeNode(grammarAccess.getModelAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_3);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:94:1: ( (lv_statements_2_0= ruleStatement ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==28||(LA1_0>=31 && LA1_0<=33)||LA1_0==36) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalDSL.g:95:1: (lv_statements_2_0= ruleStatement )
            	    {
            	    // InternalDSL.g:95:1: (lv_statements_2_0= ruleStatement )
            	    // InternalDSL.g:96:3: lv_statements_2_0= ruleStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModelAccess().getStatementsStatementParserRuleCall_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_3);
            	    lv_statements_2_0=ruleStatement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModelRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"statements",
            	            		lv_statements_2_0, 
            	            		"de.gebit.integrity.DSL.Statement");
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
    // InternalDSL.g:120:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalDSL.g:121:2: (iv_ruleStatement= ruleStatement EOF )
            // InternalDSL.g:122:2: iv_ruleStatement= ruleStatement EOF
            {
             newCompositeNode(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:129:1: ruleStatement returns [EObject current=null] : (this_Import_0= ruleImport | this_PackageDefinition_1= rulePackageDefinition | this_ForkDefinition_2= ruleForkDefinition | this_VariantDefinition_3= ruleVariantDefinition ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_Import_0 = null;

        EObject this_PackageDefinition_1 = null;

        EObject this_ForkDefinition_2 = null;

        EObject this_VariantDefinition_3 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:132:28: ( (this_Import_0= ruleImport | this_PackageDefinition_1= rulePackageDefinition | this_ForkDefinition_2= ruleForkDefinition | this_VariantDefinition_3= ruleVariantDefinition ) )
            // InternalDSL.g:133:1: (this_Import_0= ruleImport | this_PackageDefinition_1= rulePackageDefinition | this_ForkDefinition_2= ruleForkDefinition | this_VariantDefinition_3= ruleVariantDefinition )
            {
            // InternalDSL.g:133:1: (this_Import_0= ruleImport | this_PackageDefinition_1= rulePackageDefinition | this_ForkDefinition_2= ruleForkDefinition | this_VariantDefinition_3= ruleVariantDefinition )
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
            case 33:
                {
                alt2=3;
                }
                break;
            case 36:
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
                    // InternalDSL.g:134:5: this_Import_0= ruleImport
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getImportParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Import_0=ruleImport();

                    state._fsp--;

                     
                            current = this_Import_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalDSL.g:144:5: this_PackageDefinition_1= rulePackageDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getPackageDefinitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_PackageDefinition_1=rulePackageDefinition();

                    state._fsp--;

                     
                            current = this_PackageDefinition_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalDSL.g:154:5: this_ForkDefinition_2= ruleForkDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getForkDefinitionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_ForkDefinition_2=ruleForkDefinition();

                    state._fsp--;

                     
                            current = this_ForkDefinition_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalDSL.g:164:5: this_VariantDefinition_3= ruleVariantDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getStatementAccess().getVariantDefinitionParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_2);
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
    // InternalDSL.g:180:1: entryRuleVisibleComment returns [EObject current=null] : iv_ruleVisibleComment= ruleVisibleComment EOF ;
    public final EObject entryRuleVisibleComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleComment = null;


        try {
            // InternalDSL.g:181:2: (iv_ruleVisibleComment= ruleVisibleComment EOF )
            // InternalDSL.g:182:2: iv_ruleVisibleComment= ruleVisibleComment EOF
            {
             newCompositeNode(grammarAccess.getVisibleCommentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVisibleComment=ruleVisibleComment();

            state._fsp--;

             current =iv_ruleVisibleComment; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:189:1: ruleVisibleComment returns [EObject current=null] : (this_VisibleSingleLineComment_0= ruleVisibleSingleLineComment | this_VisibleMultiLineComment_1= ruleVisibleMultiLineComment ) ;
    public final EObject ruleVisibleComment() throws RecognitionException {
        EObject current = null;

        EObject this_VisibleSingleLineComment_0 = null;

        EObject this_VisibleMultiLineComment_1 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:192:28: ( (this_VisibleSingleLineComment_0= ruleVisibleSingleLineComment | this_VisibleMultiLineComment_1= ruleVisibleMultiLineComment ) )
            // InternalDSL.g:193:1: (this_VisibleSingleLineComment_0= ruleVisibleSingleLineComment | this_VisibleMultiLineComment_1= ruleVisibleMultiLineComment )
            {
            // InternalDSL.g:193:1: (this_VisibleSingleLineComment_0= ruleVisibleSingleLineComment | this_VisibleMultiLineComment_1= ruleVisibleMultiLineComment )
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
                    // InternalDSL.g:194:5: this_VisibleSingleLineComment_0= ruleVisibleSingleLineComment
                    {
                     
                            newCompositeNode(grammarAccess.getVisibleCommentAccess().getVisibleSingleLineCommentParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VisibleSingleLineComment_0=ruleVisibleSingleLineComment();

                    state._fsp--;

                     
                            current = this_VisibleSingleLineComment_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalDSL.g:204:5: this_VisibleMultiLineComment_1= ruleVisibleMultiLineComment
                    {
                     
                            newCompositeNode(grammarAccess.getVisibleCommentAccess().getVisibleMultiLineCommentParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
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
    // InternalDSL.g:220:1: entryRuleVisibleSingleLineComment returns [EObject current=null] : iv_ruleVisibleSingleLineComment= ruleVisibleSingleLineComment EOF ;
    public final EObject entryRuleVisibleSingleLineComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleSingleLineComment = null;


        try {
            // InternalDSL.g:221:2: (iv_ruleVisibleSingleLineComment= ruleVisibleSingleLineComment EOF )
            // InternalDSL.g:222:2: iv_ruleVisibleSingleLineComment= ruleVisibleSingleLineComment EOF
            {
             newCompositeNode(grammarAccess.getVisibleSingleLineCommentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVisibleSingleLineComment=ruleVisibleSingleLineComment();

            state._fsp--;

             current =iv_ruleVisibleSingleLineComment; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:229:1: ruleVisibleSingleLineComment returns [EObject current=null] : (this_VisibleSingleLineNormalComment_0= ruleVisibleSingleLineNormalComment | this_VisibleSingleLineTitleComment_1= ruleVisibleSingleLineTitleComment ) ;
    public final EObject ruleVisibleSingleLineComment() throws RecognitionException {
        EObject current = null;

        EObject this_VisibleSingleLineNormalComment_0 = null;

        EObject this_VisibleSingleLineTitleComment_1 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:232:28: ( (this_VisibleSingleLineNormalComment_0= ruleVisibleSingleLineNormalComment | this_VisibleSingleLineTitleComment_1= ruleVisibleSingleLineTitleComment ) )
            // InternalDSL.g:233:1: (this_VisibleSingleLineNormalComment_0= ruleVisibleSingleLineNormalComment | this_VisibleSingleLineTitleComment_1= ruleVisibleSingleLineTitleComment )
            {
            // InternalDSL.g:233:1: (this_VisibleSingleLineNormalComment_0= ruleVisibleSingleLineNormalComment | this_VisibleSingleLineTitleComment_1= ruleVisibleSingleLineTitleComment )
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
                    // InternalDSL.g:234:5: this_VisibleSingleLineNormalComment_0= ruleVisibleSingleLineNormalComment
                    {
                     
                            newCompositeNode(grammarAccess.getVisibleSingleLineCommentAccess().getVisibleSingleLineNormalCommentParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VisibleSingleLineNormalComment_0=ruleVisibleSingleLineNormalComment();

                    state._fsp--;

                     
                            current = this_VisibleSingleLineNormalComment_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalDSL.g:244:5: this_VisibleSingleLineTitleComment_1= ruleVisibleSingleLineTitleComment
                    {
                     
                            newCompositeNode(grammarAccess.getVisibleSingleLineCommentAccess().getVisibleSingleLineTitleCommentParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
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
    // InternalDSL.g:260:1: entryRuleVisibleSingleLineNormalComment returns [EObject current=null] : iv_ruleVisibleSingleLineNormalComment= ruleVisibleSingleLineNormalComment EOF ;
    public final EObject entryRuleVisibleSingleLineNormalComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleSingleLineNormalComment = null;


        try {
            // InternalDSL.g:261:2: (iv_ruleVisibleSingleLineNormalComment= ruleVisibleSingleLineNormalComment EOF )
            // InternalDSL.g:262:2: iv_ruleVisibleSingleLineNormalComment= ruleVisibleSingleLineNormalComment EOF
            {
             newCompositeNode(grammarAccess.getVisibleSingleLineNormalCommentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVisibleSingleLineNormalComment=ruleVisibleSingleLineNormalComment();

            state._fsp--;

             current =iv_ruleVisibleSingleLineNormalComment; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:269:1: ruleVisibleSingleLineNormalComment returns [EObject current=null] : ( ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) ) ruleNL ) ;
    public final EObject ruleVisibleSingleLineNormalComment() throws RecognitionException {
        EObject current = null;

        Token lv_content_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:272:28: ( ( ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) ) ruleNL ) )
            // InternalDSL.g:273:1: ( ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) ) ruleNL )
            {
            // InternalDSL.g:273:1: ( ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) ) ruleNL )
            // InternalDSL.g:273:2: ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) ) ruleNL
            {
            // InternalDSL.g:273:2: ( (lv_content_0_0= RULE_SL_VISIBLE_COMMENT ) )
            // InternalDSL.g:274:1: (lv_content_0_0= RULE_SL_VISIBLE_COMMENT )
            {
            // InternalDSL.g:274:1: (lv_content_0_0= RULE_SL_VISIBLE_COMMENT )
            // InternalDSL.g:275:3: lv_content_0_0= RULE_SL_VISIBLE_COMMENT
            {
            lv_content_0_0=(Token)match(input,RULE_SL_VISIBLE_COMMENT,FOLLOW_4); 

            			newLeafNode(lv_content_0_0, grammarAccess.getVisibleSingleLineNormalCommentAccess().getContentSL_VISIBLE_COMMENTTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVisibleSingleLineNormalCommentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"content",
                    		lv_content_0_0, 
                    		"de.gebit.integrity.DSL.SL_VISIBLE_COMMENT");
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getVisibleSingleLineNormalCommentAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_2);
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
    // InternalDSL.g:307:1: entryRuleVisibleSingleLineTitleComment returns [EObject current=null] : iv_ruleVisibleSingleLineTitleComment= ruleVisibleSingleLineTitleComment EOF ;
    public final EObject entryRuleVisibleSingleLineTitleComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleSingleLineTitleComment = null;


        try {
            // InternalDSL.g:308:2: (iv_ruleVisibleSingleLineTitleComment= ruleVisibleSingleLineTitleComment EOF )
            // InternalDSL.g:309:2: iv_ruleVisibleSingleLineTitleComment= ruleVisibleSingleLineTitleComment EOF
            {
             newCompositeNode(grammarAccess.getVisibleSingleLineTitleCommentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVisibleSingleLineTitleComment=ruleVisibleSingleLineTitleComment();

            state._fsp--;

             current =iv_ruleVisibleSingleLineTitleComment; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:316:1: ruleVisibleSingleLineTitleComment returns [EObject current=null] : ( ( (lv_content_0_0= RULE_SL_VISIBLE_TITLE_COMMENT ) ) ruleNL ) ;
    public final EObject ruleVisibleSingleLineTitleComment() throws RecognitionException {
        EObject current = null;

        Token lv_content_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:319:28: ( ( ( (lv_content_0_0= RULE_SL_VISIBLE_TITLE_COMMENT ) ) ruleNL ) )
            // InternalDSL.g:320:1: ( ( (lv_content_0_0= RULE_SL_VISIBLE_TITLE_COMMENT ) ) ruleNL )
            {
            // InternalDSL.g:320:1: ( ( (lv_content_0_0= RULE_SL_VISIBLE_TITLE_COMMENT ) ) ruleNL )
            // InternalDSL.g:320:2: ( (lv_content_0_0= RULE_SL_VISIBLE_TITLE_COMMENT ) ) ruleNL
            {
            // InternalDSL.g:320:2: ( (lv_content_0_0= RULE_SL_VISIBLE_TITLE_COMMENT ) )
            // InternalDSL.g:321:1: (lv_content_0_0= RULE_SL_VISIBLE_TITLE_COMMENT )
            {
            // InternalDSL.g:321:1: (lv_content_0_0= RULE_SL_VISIBLE_TITLE_COMMENT )
            // InternalDSL.g:322:3: lv_content_0_0= RULE_SL_VISIBLE_TITLE_COMMENT
            {
            lv_content_0_0=(Token)match(input,RULE_SL_VISIBLE_TITLE_COMMENT,FOLLOW_4); 

            			newLeafNode(lv_content_0_0, grammarAccess.getVisibleSingleLineTitleCommentAccess().getContentSL_VISIBLE_TITLE_COMMENTTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVisibleSingleLineTitleCommentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"content",
                    		lv_content_0_0, 
                    		"de.gebit.integrity.DSL.SL_VISIBLE_TITLE_COMMENT");
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getVisibleSingleLineTitleCommentAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_2);
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
    // InternalDSL.g:354:1: entryRuleVisibleMultiLineComment returns [EObject current=null] : iv_ruleVisibleMultiLineComment= ruleVisibleMultiLineComment EOF ;
    public final EObject entryRuleVisibleMultiLineComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleMultiLineComment = null;


        try {
            // InternalDSL.g:355:2: (iv_ruleVisibleMultiLineComment= ruleVisibleMultiLineComment EOF )
            // InternalDSL.g:356:2: iv_ruleVisibleMultiLineComment= ruleVisibleMultiLineComment EOF
            {
             newCompositeNode(grammarAccess.getVisibleMultiLineCommentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVisibleMultiLineComment=ruleVisibleMultiLineComment();

            state._fsp--;

             current =iv_ruleVisibleMultiLineComment; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:363:1: ruleVisibleMultiLineComment returns [EObject current=null] : (this_VisibleMultiLineNormalComment_0= ruleVisibleMultiLineNormalComment | this_VisibleMultiLineTitleComment_1= ruleVisibleMultiLineTitleComment ) ;
    public final EObject ruleVisibleMultiLineComment() throws RecognitionException {
        EObject current = null;

        EObject this_VisibleMultiLineNormalComment_0 = null;

        EObject this_VisibleMultiLineTitleComment_1 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:366:28: ( (this_VisibleMultiLineNormalComment_0= ruleVisibleMultiLineNormalComment | this_VisibleMultiLineTitleComment_1= ruleVisibleMultiLineTitleComment ) )
            // InternalDSL.g:367:1: (this_VisibleMultiLineNormalComment_0= ruleVisibleMultiLineNormalComment | this_VisibleMultiLineTitleComment_1= ruleVisibleMultiLineTitleComment )
            {
            // InternalDSL.g:367:1: (this_VisibleMultiLineNormalComment_0= ruleVisibleMultiLineNormalComment | this_VisibleMultiLineTitleComment_1= ruleVisibleMultiLineTitleComment )
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
                    // InternalDSL.g:368:5: this_VisibleMultiLineNormalComment_0= ruleVisibleMultiLineNormalComment
                    {
                     
                            newCompositeNode(grammarAccess.getVisibleMultiLineCommentAccess().getVisibleMultiLineNormalCommentParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VisibleMultiLineNormalComment_0=ruleVisibleMultiLineNormalComment();

                    state._fsp--;

                     
                            current = this_VisibleMultiLineNormalComment_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalDSL.g:378:5: this_VisibleMultiLineTitleComment_1= ruleVisibleMultiLineTitleComment
                    {
                     
                            newCompositeNode(grammarAccess.getVisibleMultiLineCommentAccess().getVisibleMultiLineTitleCommentParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
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
    // InternalDSL.g:394:1: entryRuleVisibleMultiLineNormalComment returns [EObject current=null] : iv_ruleVisibleMultiLineNormalComment= ruleVisibleMultiLineNormalComment EOF ;
    public final EObject entryRuleVisibleMultiLineNormalComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleMultiLineNormalComment = null;


        try {
            // InternalDSL.g:395:2: (iv_ruleVisibleMultiLineNormalComment= ruleVisibleMultiLineNormalComment EOF )
            // InternalDSL.g:396:2: iv_ruleVisibleMultiLineNormalComment= ruleVisibleMultiLineNormalComment EOF
            {
             newCompositeNode(grammarAccess.getVisibleMultiLineNormalCommentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVisibleMultiLineNormalComment=ruleVisibleMultiLineNormalComment();

            state._fsp--;

             current =iv_ruleVisibleMultiLineNormalComment; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:403:1: ruleVisibleMultiLineNormalComment returns [EObject current=null] : ( ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) ) ruleNL ) ;
    public final EObject ruleVisibleMultiLineNormalComment() throws RecognitionException {
        EObject current = null;

        Token lv_content_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:406:28: ( ( ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) ) ruleNL ) )
            // InternalDSL.g:407:1: ( ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) ) ruleNL )
            {
            // InternalDSL.g:407:1: ( ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) ) ruleNL )
            // InternalDSL.g:407:2: ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) ) ruleNL
            {
            // InternalDSL.g:407:2: ( (lv_content_0_0= RULE_ML_VISIBLE_COMMENT ) )
            // InternalDSL.g:408:1: (lv_content_0_0= RULE_ML_VISIBLE_COMMENT )
            {
            // InternalDSL.g:408:1: (lv_content_0_0= RULE_ML_VISIBLE_COMMENT )
            // InternalDSL.g:409:3: lv_content_0_0= RULE_ML_VISIBLE_COMMENT
            {
            lv_content_0_0=(Token)match(input,RULE_ML_VISIBLE_COMMENT,FOLLOW_4); 

            			newLeafNode(lv_content_0_0, grammarAccess.getVisibleMultiLineNormalCommentAccess().getContentML_VISIBLE_COMMENTTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVisibleMultiLineNormalCommentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"content",
                    		lv_content_0_0, 
                    		"de.gebit.integrity.DSL.ML_VISIBLE_COMMENT");
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getVisibleMultiLineNormalCommentAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_2);
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
    // InternalDSL.g:441:1: entryRuleVisibleMultiLineTitleComment returns [EObject current=null] : iv_ruleVisibleMultiLineTitleComment= ruleVisibleMultiLineTitleComment EOF ;
    public final EObject entryRuleVisibleMultiLineTitleComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleMultiLineTitleComment = null;


        try {
            // InternalDSL.g:442:2: (iv_ruleVisibleMultiLineTitleComment= ruleVisibleMultiLineTitleComment EOF )
            // InternalDSL.g:443:2: iv_ruleVisibleMultiLineTitleComment= ruleVisibleMultiLineTitleComment EOF
            {
             newCompositeNode(grammarAccess.getVisibleMultiLineTitleCommentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVisibleMultiLineTitleComment=ruleVisibleMultiLineTitleComment();

            state._fsp--;

             current =iv_ruleVisibleMultiLineTitleComment; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:450:1: ruleVisibleMultiLineTitleComment returns [EObject current=null] : ( ( (lv_content_0_0= RULE_ML_VISIBLE_TITLE_COMMENT ) ) ruleNL ) ;
    public final EObject ruleVisibleMultiLineTitleComment() throws RecognitionException {
        EObject current = null;

        Token lv_content_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:453:28: ( ( ( (lv_content_0_0= RULE_ML_VISIBLE_TITLE_COMMENT ) ) ruleNL ) )
            // InternalDSL.g:454:1: ( ( (lv_content_0_0= RULE_ML_VISIBLE_TITLE_COMMENT ) ) ruleNL )
            {
            // InternalDSL.g:454:1: ( ( (lv_content_0_0= RULE_ML_VISIBLE_TITLE_COMMENT ) ) ruleNL )
            // InternalDSL.g:454:2: ( (lv_content_0_0= RULE_ML_VISIBLE_TITLE_COMMENT ) ) ruleNL
            {
            // InternalDSL.g:454:2: ( (lv_content_0_0= RULE_ML_VISIBLE_TITLE_COMMENT ) )
            // InternalDSL.g:455:1: (lv_content_0_0= RULE_ML_VISIBLE_TITLE_COMMENT )
            {
            // InternalDSL.g:455:1: (lv_content_0_0= RULE_ML_VISIBLE_TITLE_COMMENT )
            // InternalDSL.g:456:3: lv_content_0_0= RULE_ML_VISIBLE_TITLE_COMMENT
            {
            lv_content_0_0=(Token)match(input,RULE_ML_VISIBLE_TITLE_COMMENT,FOLLOW_4); 

            			newLeafNode(lv_content_0_0, grammarAccess.getVisibleMultiLineTitleCommentAccess().getContentML_VISIBLE_TITLE_COMMENTTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVisibleMultiLineTitleCommentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"content",
                    		lv_content_0_0, 
                    		"de.gebit.integrity.DSL.ML_VISIBLE_TITLE_COMMENT");
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getVisibleMultiLineTitleCommentAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_2);
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
    // InternalDSL.g:488:1: entryRuleVisibleDivider returns [EObject current=null] : iv_ruleVisibleDivider= ruleVisibleDivider EOF ;
    public final EObject entryRuleVisibleDivider() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVisibleDivider = null;


        try {
            // InternalDSL.g:489:2: (iv_ruleVisibleDivider= ruleVisibleDivider EOF )
            // InternalDSL.g:490:2: iv_ruleVisibleDivider= ruleVisibleDivider EOF
            {
             newCompositeNode(grammarAccess.getVisibleDividerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVisibleDivider=ruleVisibleDivider();

            state._fsp--;

             current =iv_ruleVisibleDivider; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:497:1: ruleVisibleDivider returns [EObject current=null] : ( ( (lv_content_0_0= RULE_DIVIDER ) ) ruleNL ) ;
    public final EObject ruleVisibleDivider() throws RecognitionException {
        EObject current = null;

        Token lv_content_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:500:28: ( ( ( (lv_content_0_0= RULE_DIVIDER ) ) ruleNL ) )
            // InternalDSL.g:501:1: ( ( (lv_content_0_0= RULE_DIVIDER ) ) ruleNL )
            {
            // InternalDSL.g:501:1: ( ( (lv_content_0_0= RULE_DIVIDER ) ) ruleNL )
            // InternalDSL.g:501:2: ( (lv_content_0_0= RULE_DIVIDER ) ) ruleNL
            {
            // InternalDSL.g:501:2: ( (lv_content_0_0= RULE_DIVIDER ) )
            // InternalDSL.g:502:1: (lv_content_0_0= RULE_DIVIDER )
            {
            // InternalDSL.g:502:1: (lv_content_0_0= RULE_DIVIDER )
            // InternalDSL.g:503:3: lv_content_0_0= RULE_DIVIDER
            {
            lv_content_0_0=(Token)match(input,RULE_DIVIDER,FOLLOW_4); 

            			newLeafNode(lv_content_0_0, grammarAccess.getVisibleDividerAccess().getContentDIVIDERTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getVisibleDividerRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"content",
                    		lv_content_0_0, 
                    		"de.gebit.integrity.DSL.DIVIDER");
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getVisibleDividerAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_2);
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
    // InternalDSL.g:535:1: entryRulePackageDefinition returns [EObject current=null] : iv_rulePackageDefinition= rulePackageDefinition EOF ;
    public final EObject entryRulePackageDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageDefinition = null;


        try {
            // InternalDSL.g:536:2: (iv_rulePackageDefinition= rulePackageDefinition EOF )
            // InternalDSL.g:537:2: iv_rulePackageDefinition= rulePackageDefinition EOF
            {
             newCompositeNode(grammarAccess.getPackageDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePackageDefinition=rulePackageDefinition();

            state._fsp--;

             current =iv_rulePackageDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:544:1: rulePackageDefinition returns [EObject current=null] : (otherlv_0= 'packagedef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= 'with' ruleNL ( (lv_statements_5_0= rulePackageStatement ) )* otherlv_6= 'packageend' ruleNL ) ;
    public final EObject rulePackageDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_statements_5_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:547:28: ( (otherlv_0= 'packagedef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= 'with' ruleNL ( (lv_statements_5_0= rulePackageStatement ) )* otherlv_6= 'packageend' ruleNL ) )
            // InternalDSL.g:548:1: (otherlv_0= 'packagedef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= 'with' ruleNL ( (lv_statements_5_0= rulePackageStatement ) )* otherlv_6= 'packageend' ruleNL )
            {
            // InternalDSL.g:548:1: (otherlv_0= 'packagedef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= 'with' ruleNL ( (lv_statements_5_0= rulePackageStatement ) )* otherlv_6= 'packageend' ruleNL )
            // InternalDSL.g:548:3: otherlv_0= 'packagedef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) otherlv_3= 'with' ruleNL ( (lv_statements_5_0= rulePackageStatement ) )* otherlv_6= 'packageend' ruleNL
            {
            otherlv_0=(Token)match(input,28,FOLLOW_5); 

                	newLeafNode(otherlv_0, grammarAccess.getPackageDefinitionAccess().getPackagedefKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getPackageDefinitionAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_5);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:560:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalDSL.g:561:1: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalDSL.g:561:1: (lv_name_2_0= ruleQualifiedName )
            // InternalDSL.g:562:3: lv_name_2_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getPackageDefinitionAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_6);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPackageDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"de.gebit.integrity.DSL.QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,29,FOLLOW_7); 

                	newLeafNode(otherlv_3, grammarAccess.getPackageDefinitionAccess().getWithKeyword_3());
                
             
                    newCompositeNode(grammarAccess.getPackageDefinitionAccess().getNLParserRuleCall_4()); 
                
            pushFollow(FOLLOW_8);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:590:1: ( (lv_statements_5_0= rulePackageStatement ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=31 && LA6_0<=33)||(LA6_0>=36 && LA6_0<=40)||(LA6_0>=47 && LA6_0<=48)||LA6_0==50) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalDSL.g:591:1: (lv_statements_5_0= rulePackageStatement )
            	    {
            	    // InternalDSL.g:591:1: (lv_statements_5_0= rulePackageStatement )
            	    // InternalDSL.g:592:3: lv_statements_5_0= rulePackageStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPackageDefinitionAccess().getStatementsPackageStatementParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_8);
            	    lv_statements_5_0=rulePackageStatement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPackageDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"statements",
            	            		lv_statements_5_0, 
            	            		"de.gebit.integrity.DSL.PackageStatement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_6=(Token)match(input,30,FOLLOW_4); 

                	newLeafNode(otherlv_6, grammarAccess.getPackageDefinitionAccess().getPackageendKeyword_6());
                
             
                    newCompositeNode(grammarAccess.getPackageDefinitionAccess().getNLParserRuleCall_7()); 
                
            pushFollow(FOLLOW_2);
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
    // InternalDSL.g:628:1: entryRulePackageStatement returns [EObject current=null] : iv_rulePackageStatement= rulePackageStatement EOF ;
    public final EObject entryRulePackageStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageStatement = null;


        try {
            // InternalDSL.g:629:2: (iv_rulePackageStatement= rulePackageStatement EOF )
            // InternalDSL.g:630:2: iv_rulePackageStatement= rulePackageStatement EOF
            {
             newCompositeNode(grammarAccess.getPackageStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePackageStatement=rulePackageStatement();

            state._fsp--;

             current =iv_rulePackageStatement; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:637:1: rulePackageStatement returns [EObject current=null] : (this_Import_0= ruleImport | this_ForkDefinition_1= ruleForkDefinition | this_VariantDefinition_2= ruleVariantDefinition | this_TestDefinition_3= ruleTestDefinition | this_CallDefinition_4= ruleCallDefinition | this_OperationDefinition_5= ruleOperationDefinition | this_SuiteDefinition_6= ruleSuiteDefinition | this_VariableDefinition_7= ruleVariableDefinition | this_ConstantDefinition_8= ruleConstantDefinition ) ;
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
            // InternalDSL.g:640:28: ( (this_Import_0= ruleImport | this_ForkDefinition_1= ruleForkDefinition | this_VariantDefinition_2= ruleVariantDefinition | this_TestDefinition_3= ruleTestDefinition | this_CallDefinition_4= ruleCallDefinition | this_OperationDefinition_5= ruleOperationDefinition | this_SuiteDefinition_6= ruleSuiteDefinition | this_VariableDefinition_7= ruleVariableDefinition | this_ConstantDefinition_8= ruleConstantDefinition ) )
            // InternalDSL.g:641:1: (this_Import_0= ruleImport | this_ForkDefinition_1= ruleForkDefinition | this_VariantDefinition_2= ruleVariantDefinition | this_TestDefinition_3= ruleTestDefinition | this_CallDefinition_4= ruleCallDefinition | this_OperationDefinition_5= ruleOperationDefinition | this_SuiteDefinition_6= ruleSuiteDefinition | this_VariableDefinition_7= ruleVariableDefinition | this_ConstantDefinition_8= ruleConstantDefinition )
            {
            // InternalDSL.g:641:1: (this_Import_0= ruleImport | this_ForkDefinition_1= ruleForkDefinition | this_VariantDefinition_2= ruleVariantDefinition | this_TestDefinition_3= ruleTestDefinition | this_CallDefinition_4= ruleCallDefinition | this_OperationDefinition_5= ruleOperationDefinition | this_SuiteDefinition_6= ruleSuiteDefinition | this_VariableDefinition_7= ruleVariableDefinition | this_ConstantDefinition_8= ruleConstantDefinition )
            int alt7=9;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // InternalDSL.g:642:5: this_Import_0= ruleImport
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getImportParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Import_0=ruleImport();

                    state._fsp--;

                     
                            current = this_Import_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalDSL.g:652:5: this_ForkDefinition_1= ruleForkDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getForkDefinitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_ForkDefinition_1=ruleForkDefinition();

                    state._fsp--;

                     
                            current = this_ForkDefinition_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalDSL.g:662:5: this_VariantDefinition_2= ruleVariantDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getVariantDefinitionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VariantDefinition_2=ruleVariantDefinition();

                    state._fsp--;

                     
                            current = this_VariantDefinition_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalDSL.g:672:5: this_TestDefinition_3= ruleTestDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getTestDefinitionParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_2);
                    this_TestDefinition_3=ruleTestDefinition();

                    state._fsp--;

                     
                            current = this_TestDefinition_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // InternalDSL.g:682:5: this_CallDefinition_4= ruleCallDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getCallDefinitionParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_2);
                    this_CallDefinition_4=ruleCallDefinition();

                    state._fsp--;

                     
                            current = this_CallDefinition_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // InternalDSL.g:692:5: this_OperationDefinition_5= ruleOperationDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getOperationDefinitionParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_2);
                    this_OperationDefinition_5=ruleOperationDefinition();

                    state._fsp--;

                     
                            current = this_OperationDefinition_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // InternalDSL.g:702:5: this_SuiteDefinition_6= ruleSuiteDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getSuiteDefinitionParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_2);
                    this_SuiteDefinition_6=ruleSuiteDefinition();

                    state._fsp--;

                     
                            current = this_SuiteDefinition_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // InternalDSL.g:712:5: this_VariableDefinition_7= ruleVariableDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getVariableDefinitionParserRuleCall_7()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VariableDefinition_7=ruleVariableDefinition();

                    state._fsp--;

                     
                            current = this_VariableDefinition_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // InternalDSL.g:722:5: this_ConstantDefinition_8= ruleConstantDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getPackageStatementAccess().getConstantDefinitionParserRuleCall_8()); 
                        
                    pushFollow(FOLLOW_2);
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
    // InternalDSL.g:738:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalDSL.g:739:2: (iv_ruleImport= ruleImport EOF )
            // InternalDSL.g:740:2: iv_ruleImport= ruleImport EOF
            {
             newCompositeNode(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:747:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ruleNL ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) ) ruleNL ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_2_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:750:28: ( (otherlv_0= 'import' ruleNL ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) ) ruleNL ) )
            // InternalDSL.g:751:1: (otherlv_0= 'import' ruleNL ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) ) ruleNL )
            {
            // InternalDSL.g:751:1: (otherlv_0= 'import' ruleNL ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) ) ruleNL )
            // InternalDSL.g:751:3: otherlv_0= 'import' ruleNL ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) ) ruleNL
            {
            otherlv_0=(Token)match(input,31,FOLLOW_5); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getImportAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_5);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:763:1: ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) )
            // InternalDSL.g:764:1: (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard )
            {
            // InternalDSL.g:764:1: (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard )
            // InternalDSL.g:765:3: lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard
            {
             
            	        newCompositeNode(grammarAccess.getImportAccess().getImportedNamespaceQualifiedNameWithWildcardParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_4);
            lv_importedNamespace_2_0=ruleQualifiedNameWithWildcard();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getImportRule());
            	        }
                   		set(
                   			current, 
                   			"importedNamespace",
                    		lv_importedNamespace_2_0, 
                    		"de.gebit.integrity.DSL.QualifiedNameWithWildcard");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getImportAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_2);
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
    // InternalDSL.g:797:1: entryRuleForkDefinition returns [EObject current=null] : iv_ruleForkDefinition= ruleForkDefinition EOF ;
    public final EObject entryRuleForkDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForkDefinition = null;


        try {
            // InternalDSL.g:798:2: (iv_ruleForkDefinition= ruleForkDefinition EOF )
            // InternalDSL.g:799:2: iv_ruleForkDefinition= ruleForkDefinition EOF
            {
             newCompositeNode(grammarAccess.getForkDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleForkDefinition=ruleForkDefinition();

            state._fsp--;

             current =iv_ruleForkDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:806:1: ruleForkDefinition returns [EObject current=null] : ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'forkdef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_5_0= RULE_STRING ) ) ruleNL )? (otherlv_7= 'uses' ruleNL ( (lv_forkerClass_9_0= ruleJavaClassReference ) ) ruleNL )? ( ( (lv_parameters_11_0= ruleForkParameter ) ) ruleNL )* ) ;
    public final EObject ruleForkDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_private_0_0=null;
        Token otherlv_1=null;
        Token lv_description_5_0=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_forkerClass_9_0 = null;

        EObject lv_parameters_11_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:809:28: ( ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'forkdef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_5_0= RULE_STRING ) ) ruleNL )? (otherlv_7= 'uses' ruleNL ( (lv_forkerClass_9_0= ruleJavaClassReference ) ) ruleNL )? ( ( (lv_parameters_11_0= ruleForkParameter ) ) ruleNL )* ) )
            // InternalDSL.g:810:1: ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'forkdef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_5_0= RULE_STRING ) ) ruleNL )? (otherlv_7= 'uses' ruleNL ( (lv_forkerClass_9_0= ruleJavaClassReference ) ) ruleNL )? ( ( (lv_parameters_11_0= ruleForkParameter ) ) ruleNL )* )
            {
            // InternalDSL.g:810:1: ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'forkdef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_5_0= RULE_STRING ) ) ruleNL )? (otherlv_7= 'uses' ruleNL ( (lv_forkerClass_9_0= ruleJavaClassReference ) ) ruleNL )? ( ( (lv_parameters_11_0= ruleForkParameter ) ) ruleNL )* )
            // InternalDSL.g:810:2: ( (lv_private_0_0= 'private' ) )? otherlv_1= 'forkdef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_5_0= RULE_STRING ) ) ruleNL )? (otherlv_7= 'uses' ruleNL ( (lv_forkerClass_9_0= ruleJavaClassReference ) ) ruleNL )? ( ( (lv_parameters_11_0= ruleForkParameter ) ) ruleNL )*
            {
            // InternalDSL.g:810:2: ( (lv_private_0_0= 'private' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==32) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalDSL.g:811:1: (lv_private_0_0= 'private' )
                    {
                    // InternalDSL.g:811:1: (lv_private_0_0= 'private' )
                    // InternalDSL.g:812:3: lv_private_0_0= 'private'
                    {
                    lv_private_0_0=(Token)match(input,32,FOLLOW_9); 

                            newLeafNode(lv_private_0_0, grammarAccess.getForkDefinitionAccess().getPrivatePrivateKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getForkDefinitionRule());
                    	        }
                           		setWithLastConsumed(current, "private", lv_private_0_0, "private");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,33,FOLLOW_5); 

                	newLeafNode(otherlv_1, grammarAccess.getForkDefinitionAccess().getForkdefKeyword_1());
                
             
                    newCompositeNode(grammarAccess.getForkDefinitionAccess().getNLParserRuleCall_2()); 
                
            pushFollow(FOLLOW_5);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:837:1: ( (lv_name_3_0= ruleQualifiedName ) )
            // InternalDSL.g:838:1: (lv_name_3_0= ruleQualifiedName )
            {
            // InternalDSL.g:838:1: (lv_name_3_0= ruleQualifiedName )
            // InternalDSL.g:839:3: lv_name_3_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getForkDefinitionAccess().getNameQualifiedNameParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_10);
            lv_name_3_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getForkDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"de.gebit.integrity.DSL.QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getForkDefinitionAccess().getNLParserRuleCall_4()); 
                
            pushFollow(FOLLOW_11);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:863:1: ( ( (lv_description_5_0= RULE_STRING ) ) ruleNL )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_STRING) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalDSL.g:863:2: ( (lv_description_5_0= RULE_STRING ) ) ruleNL
                    {
                    // InternalDSL.g:863:2: ( (lv_description_5_0= RULE_STRING ) )
                    // InternalDSL.g:864:1: (lv_description_5_0= RULE_STRING )
                    {
                    // InternalDSL.g:864:1: (lv_description_5_0= RULE_STRING )
                    // InternalDSL.g:865:3: lv_description_5_0= RULE_STRING
                    {
                    lv_description_5_0=(Token)match(input,RULE_STRING,FOLLOW_12); 

                    			newLeafNode(lv_description_5_0, grammarAccess.getForkDefinitionAccess().getDescriptionSTRINGTerminalRuleCall_5_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getForkDefinitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_5_0, 
                            		"de.gebit.integrity.DSL.STRING");
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getForkDefinitionAccess().getNLParserRuleCall_5_1()); 
                        
                    pushFollow(FOLLOW_13);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // InternalDSL.g:889:3: (otherlv_7= 'uses' ruleNL ( (lv_forkerClass_9_0= ruleJavaClassReference ) ) ruleNL )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==34) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalDSL.g:889:5: otherlv_7= 'uses' ruleNL ( (lv_forkerClass_9_0= ruleJavaClassReference ) ) ruleNL
                    {
                    otherlv_7=(Token)match(input,34,FOLLOW_5); 

                        	newLeafNode(otherlv_7, grammarAccess.getForkDefinitionAccess().getUsesKeyword_6_0());
                        
                     
                            newCompositeNode(grammarAccess.getForkDefinitionAccess().getNLParserRuleCall_6_1()); 
                        
                    pushFollow(FOLLOW_5);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalDSL.g:901:1: ( (lv_forkerClass_9_0= ruleJavaClassReference ) )
                    // InternalDSL.g:902:1: (lv_forkerClass_9_0= ruleJavaClassReference )
                    {
                    // InternalDSL.g:902:1: (lv_forkerClass_9_0= ruleJavaClassReference )
                    // InternalDSL.g:903:3: lv_forkerClass_9_0= ruleJavaClassReference
                    {
                     
                    	        newCompositeNode(grammarAccess.getForkDefinitionAccess().getForkerClassJavaClassReferenceParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FOLLOW_5);
                    lv_forkerClass_9_0=ruleJavaClassReference();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getForkDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"forkerClass",
                            		lv_forkerClass_9_0, 
                            		"de.gebit.integrity.DSL.JavaClassReference");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getForkDefinitionAccess().getNLParserRuleCall_6_3()); 
                        
                    pushFollow(FOLLOW_14);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // InternalDSL.g:927:3: ( ( (lv_parameters_11_0= ruleForkParameter ) ) ruleNL )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalDSL.g:927:4: ( (lv_parameters_11_0= ruleForkParameter ) ) ruleNL
            	    {
            	    // InternalDSL.g:927:4: ( (lv_parameters_11_0= ruleForkParameter ) )
            	    // InternalDSL.g:928:1: (lv_parameters_11_0= ruleForkParameter )
            	    {
            	    // InternalDSL.g:928:1: (lv_parameters_11_0= ruleForkParameter )
            	    // InternalDSL.g:929:3: lv_parameters_11_0= ruleForkParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getForkDefinitionAccess().getParametersForkParameterParserRuleCall_7_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_5);
            	    lv_parameters_11_0=ruleForkParameter();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getForkDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"parameters",
            	            		lv_parameters_11_0, 
            	            		"de.gebit.integrity.DSL.ForkParameter");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	     
            	            newCompositeNode(grammarAccess.getForkDefinitionAccess().getNLParserRuleCall_7_1()); 
            	        
            	    pushFollow(FOLLOW_14);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop11;
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
    // InternalDSL.g:961:1: entryRuleForkParameter returns [EObject current=null] : iv_ruleForkParameter= ruleForkParameter EOF ;
    public final EObject entryRuleForkParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForkParameter = null;


        try {
            // InternalDSL.g:962:2: (iv_ruleForkParameter= ruleForkParameter EOF )
            // InternalDSL.g:963:2: iv_ruleForkParameter= ruleForkParameter EOF
            {
             newCompositeNode(grammarAccess.getForkParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleForkParameter=ruleForkParameter();

            state._fsp--;

             current =iv_ruleForkParameter; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:970:1: ruleForkParameter returns [EObject current=null] : ( ( (lv_name_0_0= ruleFixedParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) ) ) ;
    public final EObject ruleForkParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:973:28: ( ( ( (lv_name_0_0= ruleFixedParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) ) ) )
            // InternalDSL.g:974:1: ( ( (lv_name_0_0= ruleFixedParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) ) )
            {
            // InternalDSL.g:974:1: ( ( (lv_name_0_0= ruleFixedParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) ) )
            // InternalDSL.g:974:2: ( (lv_name_0_0= ruleFixedParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) )
            {
            // InternalDSL.g:974:2: ( (lv_name_0_0= ruleFixedParameterName ) )
            // InternalDSL.g:975:1: (lv_name_0_0= ruleFixedParameterName )
            {
            // InternalDSL.g:975:1: (lv_name_0_0= ruleFixedParameterName )
            // InternalDSL.g:976:3: lv_name_0_0= ruleFixedParameterName
            {
             
            	        newCompositeNode(grammarAccess.getForkParameterAccess().getNameFixedParameterNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_15);
            lv_name_0_0=ruleFixedParameterName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getForkParameterRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"de.gebit.integrity.DSL.FixedParameterName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getForkParameterAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_16);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,35,FOLLOW_17); 

                	newLeafNode(otherlv_2, grammarAccess.getForkParameterAccess().getColonKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getForkParameterAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_17);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1012:1: ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) )
            // InternalDSL.g:1013:1: (lv_value_4_0= ruleValueOrEnumValueOrOperation )
            {
            // InternalDSL.g:1013:1: (lv_value_4_0= ruleValueOrEnumValueOrOperation )
            // InternalDSL.g:1014:3: lv_value_4_0= ruleValueOrEnumValueOrOperation
            {
             
            	        newCompositeNode(grammarAccess.getForkParameterAccess().getValueValueOrEnumValueOrOperationParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_value_4_0=ruleValueOrEnumValueOrOperation();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getForkParameterRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_4_0, 
                    		"de.gebit.integrity.DSL.ValueOrEnumValueOrOperation");
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
    // InternalDSL.g:1038:1: entryRuleVariantDefinition returns [EObject current=null] : iv_ruleVariantDefinition= ruleVariantDefinition EOF ;
    public final EObject entryRuleVariantDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariantDefinition = null;


        try {
            // InternalDSL.g:1039:2: (iv_ruleVariantDefinition= ruleVariantDefinition EOF )
            // InternalDSL.g:1040:2: iv_ruleVariantDefinition= ruleVariantDefinition EOF
            {
             newCompositeNode(grammarAccess.getVariantDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariantDefinition=ruleVariantDefinition();

            state._fsp--;

             current =iv_ruleVariantDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:1047:1: ruleVariantDefinition returns [EObject current=null] : (otherlv_0= 'variantdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )? ) ;
    public final EObject ruleVariantDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_description_4_0=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:1050:28: ( (otherlv_0= 'variantdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )? ) )
            // InternalDSL.g:1051:1: (otherlv_0= 'variantdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )? )
            {
            // InternalDSL.g:1051:1: (otherlv_0= 'variantdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )? )
            // InternalDSL.g:1051:3: otherlv_0= 'variantdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )?
            {
            otherlv_0=(Token)match(input,36,FOLLOW_5); 

                	newLeafNode(otherlv_0, grammarAccess.getVariantDefinitionAccess().getVariantdefKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getVariantDefinitionAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_5);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1063:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalDSL.g:1064:1: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalDSL.g:1064:1: (lv_name_2_0= ruleQualifiedName )
            // InternalDSL.g:1065:3: lv_name_2_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getVariantDefinitionAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_18);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVariantDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"de.gebit.integrity.DSL.QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getVariantDefinitionAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_19);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1089:1: ( ( (lv_description_4_0= RULE_STRING ) ) ruleNL )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_STRING) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalDSL.g:1089:2: ( (lv_description_4_0= RULE_STRING ) ) ruleNL
                    {
                    // InternalDSL.g:1089:2: ( (lv_description_4_0= RULE_STRING ) )
                    // InternalDSL.g:1090:1: (lv_description_4_0= RULE_STRING )
                    {
                    // InternalDSL.g:1090:1: (lv_description_4_0= RULE_STRING )
                    // InternalDSL.g:1091:3: lv_description_4_0= RULE_STRING
                    {
                    lv_description_4_0=(Token)match(input,RULE_STRING,FOLLOW_4); 

                    			newLeafNode(lv_description_4_0, grammarAccess.getVariantDefinitionAccess().getDescriptionSTRINGTerminalRuleCall_4_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVariantDefinitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_4_0, 
                            		"de.gebit.integrity.DSL.STRING");
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getVariantDefinitionAccess().getNLParserRuleCall_4_1()); 
                        
                    pushFollow(FOLLOW_2);
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
    // InternalDSL.g:1123:1: entryRuleTestDefinition returns [EObject current=null] : iv_ruleTestDefinition= ruleTestDefinition EOF ;
    public final EObject entryRuleTestDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestDefinition = null;


        try {
            // InternalDSL.g:1124:2: (iv_ruleTestDefinition= ruleTestDefinition EOF )
            // InternalDSL.g:1125:2: iv_ruleTestDefinition= ruleTestDefinition EOF
            {
             newCompositeNode(grammarAccess.getTestDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTestDefinition=ruleTestDefinition();

            state._fsp--;

             current =iv_ruleTestDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:1132:1: ruleTestDefinition returns [EObject current=null] : (otherlv_0= 'testdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL ) ;
    public final EObject ruleTestDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_fixtureMethod_6_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:1135:28: ( (otherlv_0= 'testdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL ) )
            // InternalDSL.g:1136:1: (otherlv_0= 'testdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL )
            {
            // InternalDSL.g:1136:1: (otherlv_0= 'testdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL )
            // InternalDSL.g:1136:3: otherlv_0= 'testdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL
            {
            otherlv_0=(Token)match(input,37,FOLLOW_5); 

                	newLeafNode(otherlv_0, grammarAccess.getTestDefinitionAccess().getTestdefKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getTestDefinitionAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_5);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1148:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalDSL.g:1149:1: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalDSL.g:1149:1: (lv_name_2_0= ruleQualifiedName )
            // InternalDSL.g:1150:3: lv_name_2_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getTestDefinitionAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_20);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTestDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"de.gebit.integrity.DSL.QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getTestDefinitionAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_21);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_4=(Token)match(input,34,FOLLOW_5); 

                	newLeafNode(otherlv_4, grammarAccess.getTestDefinitionAccess().getUsesKeyword_4());
                
             
                    newCompositeNode(grammarAccess.getTestDefinitionAccess().getNLParserRuleCall_5()); 
                
            pushFollow(FOLLOW_5);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1186:1: ( (lv_fixtureMethod_6_0= ruleMethodReference ) )
            // InternalDSL.g:1187:1: (lv_fixtureMethod_6_0= ruleMethodReference )
            {
            // InternalDSL.g:1187:1: (lv_fixtureMethod_6_0= ruleMethodReference )
            // InternalDSL.g:1188:3: lv_fixtureMethod_6_0= ruleMethodReference
            {
             
            	        newCompositeNode(grammarAccess.getTestDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_4);
            lv_fixtureMethod_6_0=ruleMethodReference();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTestDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"fixtureMethod",
                    		lv_fixtureMethod_6_0, 
                    		"de.gebit.integrity.DSL.MethodReference");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getTestDefinitionAccess().getNLParserRuleCall_7()); 
                
            pushFollow(FOLLOW_2);
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
    // InternalDSL.g:1220:1: entryRuleCallDefinition returns [EObject current=null] : iv_ruleCallDefinition= ruleCallDefinition EOF ;
    public final EObject entryRuleCallDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallDefinition = null;


        try {
            // InternalDSL.g:1221:2: (iv_ruleCallDefinition= ruleCallDefinition EOF )
            // InternalDSL.g:1222:2: iv_ruleCallDefinition= ruleCallDefinition EOF
            {
             newCompositeNode(grammarAccess.getCallDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCallDefinition=ruleCallDefinition();

            state._fsp--;

             current =iv_ruleCallDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:1229:1: ruleCallDefinition returns [EObject current=null] : (otherlv_0= 'calldef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL ) ;
    public final EObject ruleCallDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_fixtureMethod_6_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:1232:28: ( (otherlv_0= 'calldef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL ) )
            // InternalDSL.g:1233:1: (otherlv_0= 'calldef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL )
            {
            // InternalDSL.g:1233:1: (otherlv_0= 'calldef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL )
            // InternalDSL.g:1233:3: otherlv_0= 'calldef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_fixtureMethod_6_0= ruleMethodReference ) ) ruleNL
            {
            otherlv_0=(Token)match(input,38,FOLLOW_5); 

                	newLeafNode(otherlv_0, grammarAccess.getCallDefinitionAccess().getCalldefKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getCallDefinitionAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_5);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1245:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalDSL.g:1246:1: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalDSL.g:1246:1: (lv_name_2_0= ruleQualifiedName )
            // InternalDSL.g:1247:3: lv_name_2_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getCallDefinitionAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_20);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCallDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"de.gebit.integrity.DSL.QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getCallDefinitionAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_21);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_4=(Token)match(input,34,FOLLOW_5); 

                	newLeafNode(otherlv_4, grammarAccess.getCallDefinitionAccess().getUsesKeyword_4());
                
             
                    newCompositeNode(grammarAccess.getCallDefinitionAccess().getNLParserRuleCall_5()); 
                
            pushFollow(FOLLOW_5);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1283:1: ( (lv_fixtureMethod_6_0= ruleMethodReference ) )
            // InternalDSL.g:1284:1: (lv_fixtureMethod_6_0= ruleMethodReference )
            {
            // InternalDSL.g:1284:1: (lv_fixtureMethod_6_0= ruleMethodReference )
            // InternalDSL.g:1285:3: lv_fixtureMethod_6_0= ruleMethodReference
            {
             
            	        newCompositeNode(grammarAccess.getCallDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_4);
            lv_fixtureMethod_6_0=ruleMethodReference();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCallDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"fixtureMethod",
                    		lv_fixtureMethod_6_0, 
                    		"de.gebit.integrity.DSL.MethodReference");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getCallDefinitionAccess().getNLParserRuleCall_7()); 
                
            pushFollow(FOLLOW_2);
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
    // InternalDSL.g:1317:1: entryRuleSuiteDefinition returns [EObject current=null] : iv_ruleSuiteDefinition= ruleSuiteDefinition EOF ;
    public final EObject entryRuleSuiteDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteDefinition = null;


        try {
            // InternalDSL.g:1318:2: (iv_ruleSuiteDefinition= ruleSuiteDefinition EOF )
            // InternalDSL.g:1319:2: iv_ruleSuiteDefinition= ruleSuiteDefinition EOF
            {
             newCompositeNode(grammarAccess.getSuiteDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSuiteDefinition=ruleSuiteDefinition();

            state._fsp--;

             current =iv_ruleSuiteDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:1326:1: ruleSuiteDefinition returns [EObject current=null] : ( ( (lv_private_0_0= 'private' ) )? ( (lv_singleRun_1_0= 'single-run' ) )? otherlv_2= 'suitedef' ruleNL ( (lv_name_4_0= ruleQualifiedName ) ) ruleNL (otherlv_6= 'gets' ( ( (lv_parameters_7_0= ruleSuiteParameterDefinition ) ) ruleNL )+ )? (otherlv_9= 'returns' ( ( (lv_return_10_0= ruleSuiteReturnDefinition ) ) ruleNL )+ )? (otherlv_12= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? (otherlv_16= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? otherlv_20= 'with' ruleNL ( (lv_statements_22_0= ruleSuiteStatement ) )* otherlv_23= 'suiteend' ruleNL ) ;
    public final EObject ruleSuiteDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_private_0_0=null;
        Token lv_singleRun_1_0=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        Token otherlv_12=null;
        Token otherlv_16=null;
        Token otherlv_20=null;
        Token otherlv_23=null;
        AntlrDatatypeRuleToken lv_name_4_0 = null;

        EObject lv_parameters_7_0 = null;

        EObject lv_return_10_0 = null;

        EObject lv_statements_22_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:1329:28: ( ( ( (lv_private_0_0= 'private' ) )? ( (lv_singleRun_1_0= 'single-run' ) )? otherlv_2= 'suitedef' ruleNL ( (lv_name_4_0= ruleQualifiedName ) ) ruleNL (otherlv_6= 'gets' ( ( (lv_parameters_7_0= ruleSuiteParameterDefinition ) ) ruleNL )+ )? (otherlv_9= 'returns' ( ( (lv_return_10_0= ruleSuiteReturnDefinition ) ) ruleNL )+ )? (otherlv_12= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? (otherlv_16= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? otherlv_20= 'with' ruleNL ( (lv_statements_22_0= ruleSuiteStatement ) )* otherlv_23= 'suiteend' ruleNL ) )
            // InternalDSL.g:1330:1: ( ( (lv_private_0_0= 'private' ) )? ( (lv_singleRun_1_0= 'single-run' ) )? otherlv_2= 'suitedef' ruleNL ( (lv_name_4_0= ruleQualifiedName ) ) ruleNL (otherlv_6= 'gets' ( ( (lv_parameters_7_0= ruleSuiteParameterDefinition ) ) ruleNL )+ )? (otherlv_9= 'returns' ( ( (lv_return_10_0= ruleSuiteReturnDefinition ) ) ruleNL )+ )? (otherlv_12= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? (otherlv_16= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? otherlv_20= 'with' ruleNL ( (lv_statements_22_0= ruleSuiteStatement ) )* otherlv_23= 'suiteend' ruleNL )
            {
            // InternalDSL.g:1330:1: ( ( (lv_private_0_0= 'private' ) )? ( (lv_singleRun_1_0= 'single-run' ) )? otherlv_2= 'suitedef' ruleNL ( (lv_name_4_0= ruleQualifiedName ) ) ruleNL (otherlv_6= 'gets' ( ( (lv_parameters_7_0= ruleSuiteParameterDefinition ) ) ruleNL )+ )? (otherlv_9= 'returns' ( ( (lv_return_10_0= ruleSuiteReturnDefinition ) ) ruleNL )+ )? (otherlv_12= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? (otherlv_16= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? otherlv_20= 'with' ruleNL ( (lv_statements_22_0= ruleSuiteStatement ) )* otherlv_23= 'suiteend' ruleNL )
            // InternalDSL.g:1330:2: ( (lv_private_0_0= 'private' ) )? ( (lv_singleRun_1_0= 'single-run' ) )? otherlv_2= 'suitedef' ruleNL ( (lv_name_4_0= ruleQualifiedName ) ) ruleNL (otherlv_6= 'gets' ( ( (lv_parameters_7_0= ruleSuiteParameterDefinition ) ) ruleNL )+ )? (otherlv_9= 'returns' ( ( (lv_return_10_0= ruleSuiteReturnDefinition ) ) ruleNL )+ )? (otherlv_12= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? (otherlv_16= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? otherlv_20= 'with' ruleNL ( (lv_statements_22_0= ruleSuiteStatement ) )* otherlv_23= 'suiteend' ruleNL
            {
            // InternalDSL.g:1330:2: ( (lv_private_0_0= 'private' ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==32) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalDSL.g:1331:1: (lv_private_0_0= 'private' )
                    {
                    // InternalDSL.g:1331:1: (lv_private_0_0= 'private' )
                    // InternalDSL.g:1332:3: lv_private_0_0= 'private'
                    {
                    lv_private_0_0=(Token)match(input,32,FOLLOW_22); 

                            newLeafNode(lv_private_0_0, grammarAccess.getSuiteDefinitionAccess().getPrivatePrivateKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSuiteDefinitionRule());
                    	        }
                           		setWithLastConsumed(current, "private", lv_private_0_0, "private");
                    	    

                    }


                    }
                    break;

            }

            // InternalDSL.g:1345:3: ( (lv_singleRun_1_0= 'single-run' ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==39) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalDSL.g:1346:1: (lv_singleRun_1_0= 'single-run' )
                    {
                    // InternalDSL.g:1346:1: (lv_singleRun_1_0= 'single-run' )
                    // InternalDSL.g:1347:3: lv_singleRun_1_0= 'single-run'
                    {
                    lv_singleRun_1_0=(Token)match(input,39,FOLLOW_23); 

                            newLeafNode(lv_singleRun_1_0, grammarAccess.getSuiteDefinitionAccess().getSingleRunSingleRunKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSuiteDefinitionRule());
                    	        }
                           		setWithLastConsumed(current, "singleRun", lv_singleRun_1_0, "single-run");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,40,FOLLOW_5); 

                	newLeafNode(otherlv_2, grammarAccess.getSuiteDefinitionAccess().getSuitedefKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_5);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1372:1: ( (lv_name_4_0= ruleQualifiedName ) )
            // InternalDSL.g:1373:1: (lv_name_4_0= ruleQualifiedName )
            {
            // InternalDSL.g:1373:1: (lv_name_4_0= ruleQualifiedName )
            // InternalDSL.g:1374:3: lv_name_4_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNameQualifiedNameParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_24);
            lv_name_4_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSuiteDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_4_0, 
                    		"de.gebit.integrity.DSL.QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_5()); 
                
            pushFollow(FOLLOW_25);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1398:1: (otherlv_6= 'gets' ( ( (lv_parameters_7_0= ruleSuiteParameterDefinition ) ) ruleNL )+ )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==41) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalDSL.g:1398:3: otherlv_6= 'gets' ( ( (lv_parameters_7_0= ruleSuiteParameterDefinition ) ) ruleNL )+
                    {
                    otherlv_6=(Token)match(input,41,FOLLOW_5); 

                        	newLeafNode(otherlv_6, grammarAccess.getSuiteDefinitionAccess().getGetsKeyword_6_0());
                        
                    // InternalDSL.g:1402:1: ( ( (lv_parameters_7_0= ruleSuiteParameterDefinition ) ) ruleNL )+
                    int cnt15=0;
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==RULE_ID) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalDSL.g:1402:2: ( (lv_parameters_7_0= ruleSuiteParameterDefinition ) ) ruleNL
                    	    {
                    	    // InternalDSL.g:1402:2: ( (lv_parameters_7_0= ruleSuiteParameterDefinition ) )
                    	    // InternalDSL.g:1403:1: (lv_parameters_7_0= ruleSuiteParameterDefinition )
                    	    {
                    	    // InternalDSL.g:1403:1: (lv_parameters_7_0= ruleSuiteParameterDefinition )
                    	    // InternalDSL.g:1404:3: lv_parameters_7_0= ruleSuiteParameterDefinition
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getParametersSuiteParameterDefinitionParserRuleCall_6_1_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_26);
                    	    lv_parameters_7_0=ruleSuiteParameterDefinition();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSuiteDefinitionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"parameters",
                    	            		lv_parameters_7_0, 
                    	            		"de.gebit.integrity.DSL.SuiteParameterDefinition");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	     
                    	            newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_6_1_1()); 
                    	        
                    	    pushFollow(FOLLOW_26);
                    	    ruleNL();

                    	    state._fsp--;

                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt15 >= 1 ) break loop15;
                                EarlyExitException eee =
                                    new EarlyExitException(15, input);
                                throw eee;
                        }
                        cnt15++;
                    } while (true);


                    }
                    break;

            }

            // InternalDSL.g:1428:5: (otherlv_9= 'returns' ( ( (lv_return_10_0= ruleSuiteReturnDefinition ) ) ruleNL )+ )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==42) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalDSL.g:1428:7: otherlv_9= 'returns' ( ( (lv_return_10_0= ruleSuiteReturnDefinition ) ) ruleNL )+
                    {
                    otherlv_9=(Token)match(input,42,FOLLOW_5); 

                        	newLeafNode(otherlv_9, grammarAccess.getSuiteDefinitionAccess().getReturnsKeyword_7_0());
                        
                    // InternalDSL.g:1432:1: ( ( (lv_return_10_0= ruleSuiteReturnDefinition ) ) ruleNL )+
                    int cnt17=0;
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==RULE_ID) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // InternalDSL.g:1432:2: ( (lv_return_10_0= ruleSuiteReturnDefinition ) ) ruleNL
                    	    {
                    	    // InternalDSL.g:1432:2: ( (lv_return_10_0= ruleSuiteReturnDefinition ) )
                    	    // InternalDSL.g:1433:1: (lv_return_10_0= ruleSuiteReturnDefinition )
                    	    {
                    	    // InternalDSL.g:1433:1: (lv_return_10_0= ruleSuiteReturnDefinition )
                    	    // InternalDSL.g:1434:3: lv_return_10_0= ruleSuiteReturnDefinition
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getReturnSuiteReturnDefinitionParserRuleCall_7_1_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_27);
                    	    lv_return_10_0=ruleSuiteReturnDefinition();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSuiteDefinitionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"return",
                    	            		lv_return_10_0, 
                    	            		"de.gebit.integrity.DSL.SuiteReturnDefinition");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	     
                    	            newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_7_1_1()); 
                    	        
                    	    pushFollow(FOLLOW_27);
                    	    ruleNL();

                    	    state._fsp--;

                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt17 >= 1 ) break loop17;
                                EarlyExitException eee =
                                    new EarlyExitException(17, input);
                                throw eee;
                        }
                        cnt17++;
                    } while (true);


                    }
                    break;

            }

            // InternalDSL.g:1458:5: (otherlv_12= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==43) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalDSL.g:1458:7: otherlv_12= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )*
                    {
                    otherlv_12=(Token)match(input,43,FOLLOW_28); 

                        	newLeafNode(otherlv_12, grammarAccess.getSuiteDefinitionAccess().getRequiresKeyword_8_0());
                        
                     
                            newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_8_1()); 
                        
                    pushFollow(FOLLOW_28);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalDSL.g:1470:1: ( ( ( ruleQualifiedName ) ) ruleNL )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==RULE_ID) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalDSL.g:1470:2: ( ( ruleQualifiedName ) ) ruleNL
                    	    {
                    	    // InternalDSL.g:1470:2: ( ( ruleQualifiedName ) )
                    	    // InternalDSL.g:1471:1: ( ruleQualifiedName )
                    	    {
                    	    // InternalDSL.g:1471:1: ( ruleQualifiedName )
                    	    // InternalDSL.g:1472:3: ruleQualifiedName
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSuiteDefinitionRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getDependenciesSuiteDefinitionCrossReference_8_2_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_28);
                    	    ruleQualifiedName();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	     
                    	            newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_8_2_1()); 
                    	        
                    	    pushFollow(FOLLOW_28);
                    	    ruleNL();

                    	    state._fsp--;

                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalDSL.g:1493:5: (otherlv_16= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==44) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalDSL.g:1493:7: otherlv_16= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )*
                    {
                    otherlv_16=(Token)match(input,44,FOLLOW_29); 

                        	newLeafNode(otherlv_16, grammarAccess.getSuiteDefinitionAccess().getConcludedbyKeyword_9_0());
                        
                     
                            newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_9_1()); 
                        
                    pushFollow(FOLLOW_29);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalDSL.g:1505:1: ( ( ( ruleQualifiedName ) ) ruleNL )*
                    loop21:
                    do {
                        int alt21=2;
                        int LA21_0 = input.LA(1);

                        if ( (LA21_0==RULE_ID) ) {
                            alt21=1;
                        }


                        switch (alt21) {
                    	case 1 :
                    	    // InternalDSL.g:1505:2: ( ( ruleQualifiedName ) ) ruleNL
                    	    {
                    	    // InternalDSL.g:1505:2: ( ( ruleQualifiedName ) )
                    	    // InternalDSL.g:1506:1: ( ruleQualifiedName )
                    	    {
                    	    // InternalDSL.g:1506:1: ( ruleQualifiedName )
                    	    // InternalDSL.g:1507:3: ruleQualifiedName
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSuiteDefinitionRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getFinalizersSuiteDefinitionCrossReference_9_2_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_29);
                    	    ruleQualifiedName();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	     
                    	            newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_9_2_1()); 
                    	        
                    	    pushFollow(FOLLOW_29);
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
                    break;

            }

            otherlv_20=(Token)match(input,29,FOLLOW_30); 

                	newLeafNode(otherlv_20, grammarAccess.getSuiteDefinitionAccess().getWithKeyword_10());
                
             
                    newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_11()); 
                
            pushFollow(FOLLOW_31);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1540:1: ( (lv_statements_22_0= ruleSuiteStatement ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( ((LA23_0>=RULE_SL_VISIBLE_COMMENT && LA23_0<=RULE_DIVIDER)||LA23_0==32||LA23_0==48||LA23_0==50||LA23_0==52||(LA23_0>=55 && LA23_0<=56)||LA23_0==58||(LA23_0>=60 && LA23_0<=61)) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalDSL.g:1541:1: (lv_statements_22_0= ruleSuiteStatement )
            	    {
            	    // InternalDSL.g:1541:1: (lv_statements_22_0= ruleSuiteStatement )
            	    // InternalDSL.g:1542:3: lv_statements_22_0= ruleSuiteStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getStatementsSuiteStatementParserRuleCall_12_0()); 
            	    	    
            	    pushFollow(FOLLOW_31);
            	    lv_statements_22_0=ruleSuiteStatement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSuiteDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"statements",
            	            		lv_statements_22_0, 
            	            		"de.gebit.integrity.DSL.SuiteStatement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            otherlv_23=(Token)match(input,45,FOLLOW_4); 

                	newLeafNode(otherlv_23, grammarAccess.getSuiteDefinitionAccess().getSuiteendKeyword_13());
                
             
                    newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_14()); 
                
            pushFollow(FOLLOW_2);
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


    // $ANTLR start "entryRuleSuiteParameterDefinition"
    // InternalDSL.g:1578:1: entryRuleSuiteParameterDefinition returns [EObject current=null] : iv_ruleSuiteParameterDefinition= ruleSuiteParameterDefinition EOF ;
    public final EObject entryRuleSuiteParameterDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteParameterDefinition = null;


        try {
            // InternalDSL.g:1579:2: (iv_ruleSuiteParameterDefinition= ruleSuiteParameterDefinition EOF )
            // InternalDSL.g:1580:2: iv_ruleSuiteParameterDefinition= ruleSuiteParameterDefinition EOF
            {
             newCompositeNode(grammarAccess.getSuiteParameterDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSuiteParameterDefinition=ruleSuiteParameterDefinition();

            state._fsp--;

             current =iv_ruleSuiteParameterDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSuiteParameterDefinition"


    // $ANTLR start "ruleSuiteParameterDefinition"
    // InternalDSL.g:1587:1: ruleSuiteParameterDefinition returns [EObject current=null] : ( ( (lv_name_0_0= ruleVariableEntity ) ) ( ruleNL otherlv_2= 'by default' ( (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ) ;
    public final EObject ruleSuiteParameterDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_default_3_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:1590:28: ( ( ( (lv_name_0_0= ruleVariableEntity ) ) ( ruleNL otherlv_2= 'by default' ( (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ) )
            // InternalDSL.g:1591:1: ( ( (lv_name_0_0= ruleVariableEntity ) ) ( ruleNL otherlv_2= 'by default' ( (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection ) ) )? )
            {
            // InternalDSL.g:1591:1: ( ( (lv_name_0_0= ruleVariableEntity ) ) ( ruleNL otherlv_2= 'by default' ( (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection ) ) )? )
            // InternalDSL.g:1591:2: ( (lv_name_0_0= ruleVariableEntity ) ) ( ruleNL otherlv_2= 'by default' ( (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection ) ) )?
            {
            // InternalDSL.g:1591:2: ( (lv_name_0_0= ruleVariableEntity ) )
            // InternalDSL.g:1592:1: (lv_name_0_0= ruleVariableEntity )
            {
            // InternalDSL.g:1592:1: (lv_name_0_0= ruleVariableEntity )
            // InternalDSL.g:1593:3: lv_name_0_0= ruleVariableEntity
            {
             
            	        newCompositeNode(grammarAccess.getSuiteParameterDefinitionAccess().getNameVariableEntityParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_32);
            lv_name_0_0=ruleVariableEntity();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSuiteParameterDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"de.gebit.integrity.DSL.VariableEntity");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalDSL.g:1609:2: ( ruleNL otherlv_2= 'by default' ( (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection ) ) )?
            int alt24=2;
            alt24 = dfa24.predict(input);
            switch (alt24) {
                case 1 :
                    // InternalDSL.g:1610:5: ruleNL otherlv_2= 'by default' ( (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection ) )
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteParameterDefinitionAccess().getNLParserRuleCall_1_0()); 
                        
                    pushFollow(FOLLOW_33);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    otherlv_2=(Token)match(input,46,FOLLOW_17); 

                        	newLeafNode(otherlv_2, grammarAccess.getSuiteParameterDefinitionAccess().getByDefaultKeyword_1_1());
                        
                    // InternalDSL.g:1621:1: ( (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection ) )
                    // InternalDSL.g:1622:1: (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection )
                    {
                    // InternalDSL.g:1622:1: (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection )
                    // InternalDSL.g:1623:3: lv_default_3_0= ruleValueOrEnumValueOrOperationCollection
                    {
                     
                    	        newCompositeNode(grammarAccess.getSuiteParameterDefinitionAccess().getDefaultValueOrEnumValueOrOperationCollectionParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_default_3_0=ruleValueOrEnumValueOrOperationCollection();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSuiteParameterDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"default",
                            		lv_default_3_0, 
                            		"de.gebit.integrity.DSL.ValueOrEnumValueOrOperationCollection");
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
    // $ANTLR end "ruleSuiteParameterDefinition"


    // $ANTLR start "entryRuleSuiteReturnDefinition"
    // InternalDSL.g:1647:1: entryRuleSuiteReturnDefinition returns [EObject current=null] : iv_ruleSuiteReturnDefinition= ruleSuiteReturnDefinition EOF ;
    public final EObject entryRuleSuiteReturnDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteReturnDefinition = null;


        try {
            // InternalDSL.g:1648:2: (iv_ruleSuiteReturnDefinition= ruleSuiteReturnDefinition EOF )
            // InternalDSL.g:1649:2: iv_ruleSuiteReturnDefinition= ruleSuiteReturnDefinition EOF
            {
             newCompositeNode(grammarAccess.getSuiteReturnDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSuiteReturnDefinition=ruleSuiteReturnDefinition();

            state._fsp--;

             current =iv_ruleSuiteReturnDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSuiteReturnDefinition"


    // $ANTLR start "ruleSuiteReturnDefinition"
    // InternalDSL.g:1656:1: ruleSuiteReturnDefinition returns [EObject current=null] : ( (lv_name_0_0= ruleVariableEntity ) ) ;
    public final EObject ruleSuiteReturnDefinition() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:1659:28: ( ( (lv_name_0_0= ruleVariableEntity ) ) )
            // InternalDSL.g:1660:1: ( (lv_name_0_0= ruleVariableEntity ) )
            {
            // InternalDSL.g:1660:1: ( (lv_name_0_0= ruleVariableEntity ) )
            // InternalDSL.g:1661:1: (lv_name_0_0= ruleVariableEntity )
            {
            // InternalDSL.g:1661:1: (lv_name_0_0= ruleVariableEntity )
            // InternalDSL.g:1662:3: lv_name_0_0= ruleVariableEntity
            {
             
            	        newCompositeNode(grammarAccess.getSuiteReturnDefinitionAccess().getNameVariableEntityParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_name_0_0=ruleVariableEntity();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSuiteReturnDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"de.gebit.integrity.DSL.VariableEntity");
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
    // $ANTLR end "ruleSuiteReturnDefinition"


    // $ANTLR start "entryRuleOperationDefinition"
    // InternalDSL.g:1686:1: entryRuleOperationDefinition returns [EObject current=null] : iv_ruleOperationDefinition= ruleOperationDefinition EOF ;
    public final EObject entryRuleOperationDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationDefinition = null;


        try {
            // InternalDSL.g:1687:2: (iv_ruleOperationDefinition= ruleOperationDefinition EOF )
            // InternalDSL.g:1688:2: iv_ruleOperationDefinition= ruleOperationDefinition EOF
            {
             newCompositeNode(grammarAccess.getOperationDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperationDefinition=ruleOperationDefinition();

            state._fsp--;

             current =iv_ruleOperationDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:1695:1: ruleOperationDefinition returns [EObject current=null] : (otherlv_0= 'operationdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_operationType_6_0= ruleJavaClassReference ) ) ruleNL ) ;
    public final EObject ruleOperationDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_operationType_6_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:1698:28: ( (otherlv_0= 'operationdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_operationType_6_0= ruleJavaClassReference ) ) ruleNL ) )
            // InternalDSL.g:1699:1: (otherlv_0= 'operationdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_operationType_6_0= ruleJavaClassReference ) ) ruleNL )
            {
            // InternalDSL.g:1699:1: (otherlv_0= 'operationdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_operationType_6_0= ruleJavaClassReference ) ) ruleNL )
            // InternalDSL.g:1699:3: otherlv_0= 'operationdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_operationType_6_0= ruleJavaClassReference ) ) ruleNL
            {
            otherlv_0=(Token)match(input,47,FOLLOW_5); 

                	newLeafNode(otherlv_0, grammarAccess.getOperationDefinitionAccess().getOperationdefKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getOperationDefinitionAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_5);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1711:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalDSL.g:1712:1: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalDSL.g:1712:1: (lv_name_2_0= ruleQualifiedName )
            // InternalDSL.g:1713:3: lv_name_2_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getOperationDefinitionAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_20);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOperationDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"de.gebit.integrity.DSL.QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getOperationDefinitionAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_21);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_4=(Token)match(input,34,FOLLOW_5); 

                	newLeafNode(otherlv_4, grammarAccess.getOperationDefinitionAccess().getUsesKeyword_4());
                
             
                    newCompositeNode(grammarAccess.getOperationDefinitionAccess().getNLParserRuleCall_5()); 
                
            pushFollow(FOLLOW_5);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1749:1: ( (lv_operationType_6_0= ruleJavaClassReference ) )
            // InternalDSL.g:1750:1: (lv_operationType_6_0= ruleJavaClassReference )
            {
            // InternalDSL.g:1750:1: (lv_operationType_6_0= ruleJavaClassReference )
            // InternalDSL.g:1751:3: lv_operationType_6_0= ruleJavaClassReference
            {
             
            	        newCompositeNode(grammarAccess.getOperationDefinitionAccess().getOperationTypeJavaClassReferenceParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_4);
            lv_operationType_6_0=ruleJavaClassReference();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getOperationDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"operationType",
                    		lv_operationType_6_0, 
                    		"de.gebit.integrity.DSL.JavaClassReference");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getOperationDefinitionAccess().getNLParserRuleCall_7()); 
                
            pushFollow(FOLLOW_2);
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
    // InternalDSL.g:1783:1: entryRuleSuiteStatement returns [EObject current=null] : iv_ruleSuiteStatement= ruleSuiteStatement EOF ;
    public final EObject entryRuleSuiteStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteStatement = null;


        try {
            // InternalDSL.g:1784:2: (iv_ruleSuiteStatement= ruleSuiteStatement EOF )
            // InternalDSL.g:1785:2: iv_ruleSuiteStatement= ruleSuiteStatement EOF
            {
             newCompositeNode(grammarAccess.getSuiteStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSuiteStatement=ruleSuiteStatement();

            state._fsp--;

             current =iv_ruleSuiteStatement; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:1792:1: ruleSuiteStatement returns [EObject current=null] : (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_VariableDefinition_1= ruleVariableDefinition | this_ConstantDefinition_2= ruleConstantDefinition | this_VariableAssignment_3= ruleVariableAssignment | this_VisibleComment_4= ruleVisibleComment | this_VisibleDivider_5= ruleVisibleDivider ) ;
    public final EObject ruleSuiteStatement() throws RecognitionException {
        EObject current = null;

        EObject this_SuiteStatementWithResult_0 = null;

        EObject this_VariableDefinition_1 = null;

        EObject this_ConstantDefinition_2 = null;

        EObject this_VariableAssignment_3 = null;

        EObject this_VisibleComment_4 = null;

        EObject this_VisibleDivider_5 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:1795:28: ( (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_VariableDefinition_1= ruleVariableDefinition | this_ConstantDefinition_2= ruleConstantDefinition | this_VariableAssignment_3= ruleVariableAssignment | this_VisibleComment_4= ruleVisibleComment | this_VisibleDivider_5= ruleVisibleDivider ) )
            // InternalDSL.g:1796:1: (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_VariableDefinition_1= ruleVariableDefinition | this_ConstantDefinition_2= ruleConstantDefinition | this_VariableAssignment_3= ruleVariableAssignment | this_VisibleComment_4= ruleVisibleComment | this_VisibleDivider_5= ruleVisibleDivider )
            {
            // InternalDSL.g:1796:1: (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_VariableDefinition_1= ruleVariableDefinition | this_ConstantDefinition_2= ruleConstantDefinition | this_VariableAssignment_3= ruleVariableAssignment | this_VisibleComment_4= ruleVisibleComment | this_VisibleDivider_5= ruleVisibleDivider )
            int alt25=6;
            switch ( input.LA(1) ) {
            case 55:
            case 56:
            case 58:
            case 60:
            case 61:
                {
                alt25=1;
                }
                break;
            case 32:
                {
                int LA25_2 = input.LA(2);

                if ( (LA25_2==50) ) {
                    alt25=3;
                }
                else if ( (LA25_2==48) ) {
                    alt25=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 25, 2, input);

                    throw nvae;
                }
                }
                break;
            case 48:
                {
                alt25=2;
                }
                break;
            case 50:
                {
                alt25=3;
                }
                break;
            case 52:
                {
                alt25=4;
                }
                break;
            case RULE_SL_VISIBLE_COMMENT:
            case RULE_SL_VISIBLE_TITLE_COMMENT:
            case RULE_ML_VISIBLE_COMMENT:
            case RULE_ML_VISIBLE_TITLE_COMMENT:
                {
                alt25=5;
                }
                break;
            case RULE_DIVIDER:
                {
                alt25=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }

            switch (alt25) {
                case 1 :
                    // InternalDSL.g:1797:5: this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getSuiteStatementWithResultParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_SuiteStatementWithResult_0=ruleSuiteStatementWithResult();

                    state._fsp--;

                     
                            current = this_SuiteStatementWithResult_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalDSL.g:1807:5: this_VariableDefinition_1= ruleVariableDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getVariableDefinitionParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VariableDefinition_1=ruleVariableDefinition();

                    state._fsp--;

                     
                            current = this_VariableDefinition_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalDSL.g:1817:5: this_ConstantDefinition_2= ruleConstantDefinition
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getConstantDefinitionParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_ConstantDefinition_2=ruleConstantDefinition();

                    state._fsp--;

                     
                            current = this_ConstantDefinition_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalDSL.g:1827:5: this_VariableAssignment_3= ruleVariableAssignment
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getVariableAssignmentParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VariableAssignment_3=ruleVariableAssignment();

                    state._fsp--;

                     
                            current = this_VariableAssignment_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // InternalDSL.g:1837:5: this_VisibleComment_4= ruleVisibleComment
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getVisibleCommentParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VisibleComment_4=ruleVisibleComment();

                    state._fsp--;

                     
                            current = this_VisibleComment_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // InternalDSL.g:1847:5: this_VisibleDivider_5= ruleVisibleDivider
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getVisibleDividerParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VisibleDivider_5=ruleVisibleDivider();

                    state._fsp--;

                     
                            current = this_VisibleDivider_5; 
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
    // InternalDSL.g:1863:1: entryRuleSuiteStatementWithResult returns [EObject current=null] : iv_ruleSuiteStatementWithResult= ruleSuiteStatementWithResult EOF ;
    public final EObject entryRuleSuiteStatementWithResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteStatementWithResult = null;


        try {
            // InternalDSL.g:1864:2: (iv_ruleSuiteStatementWithResult= ruleSuiteStatementWithResult EOF )
            // InternalDSL.g:1865:2: iv_ruleSuiteStatementWithResult= ruleSuiteStatementWithResult EOF
            {
             newCompositeNode(grammarAccess.getSuiteStatementWithResultRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSuiteStatementWithResult=ruleSuiteStatementWithResult();

            state._fsp--;

             current =iv_ruleSuiteStatementWithResult; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:1872:1: ruleSuiteStatementWithResult returns [EObject current=null] : (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest | this_Call_3= ruleCall ) ;
    public final EObject ruleSuiteStatementWithResult() throws RecognitionException {
        EObject current = null;

        EObject this_Suite_0 = null;

        EObject this_Test_1 = null;

        EObject this_TableTest_2 = null;

        EObject this_Call_3 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:1875:28: ( (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest | this_Call_3= ruleCall ) )
            // InternalDSL.g:1876:1: (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest | this_Call_3= ruleCall )
            {
            // InternalDSL.g:1876:1: (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest | this_Call_3= ruleCall )
            int alt26=4;
            switch ( input.LA(1) ) {
            case 61:
                {
                alt26=1;
                }
                break;
            case 55:
            case 56:
                {
                alt26=2;
                }
                break;
            case 58:
                {
                alt26=3;
                }
                break;
            case 60:
                {
                alt26=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 26, 0, input);

                throw nvae;
            }

            switch (alt26) {
                case 1 :
                    // InternalDSL.g:1877:5: this_Suite_0= ruleSuite
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementWithResultAccess().getSuiteParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Suite_0=ruleSuite();

                    state._fsp--;

                     
                            current = this_Suite_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalDSL.g:1887:5: this_Test_1= ruleTest
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementWithResultAccess().getTestParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Test_1=ruleTest();

                    state._fsp--;

                     
                            current = this_Test_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalDSL.g:1897:5: this_TableTest_2= ruleTableTest
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementWithResultAccess().getTableTestParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_TableTest_2=ruleTableTest();

                    state._fsp--;

                     
                            current = this_TableTest_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalDSL.g:1907:5: this_Call_3= ruleCall
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementWithResultAccess().getCallParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_2);
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
    // InternalDSL.g:1923:1: entryRuleVariableDefinition returns [EObject current=null] : iv_ruleVariableDefinition= ruleVariableDefinition EOF ;
    public final EObject entryRuleVariableDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDefinition = null;


        try {
            // InternalDSL.g:1924:2: (iv_ruleVariableDefinition= ruleVariableDefinition EOF )
            // InternalDSL.g:1925:2: iv_ruleVariableDefinition= ruleVariableDefinition EOF
            {
             newCompositeNode(grammarAccess.getVariableDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableDefinition=ruleVariableDefinition();

            state._fsp--;

             current =iv_ruleVariableDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:1932:1: ruleVariableDefinition returns [EObject current=null] : ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'variable' ruleNL ( (lv_name_3_0= ruleVariableEntity ) ) ruleNL (otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ) ;
    public final EObject ruleVariableDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_private_0_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_name_3_0 = null;

        EObject lv_initialValue_7_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:1935:28: ( ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'variable' ruleNL ( (lv_name_3_0= ruleVariableEntity ) ) ruleNL (otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ) )
            // InternalDSL.g:1936:1: ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'variable' ruleNL ( (lv_name_3_0= ruleVariableEntity ) ) ruleNL (otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? )
            {
            // InternalDSL.g:1936:1: ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'variable' ruleNL ( (lv_name_3_0= ruleVariableEntity ) ) ruleNL (otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? )
            // InternalDSL.g:1936:2: ( (lv_private_0_0= 'private' ) )? otherlv_1= 'variable' ruleNL ( (lv_name_3_0= ruleVariableEntity ) ) ruleNL (otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )?
            {
            // InternalDSL.g:1936:2: ( (lv_private_0_0= 'private' ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==32) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalDSL.g:1937:1: (lv_private_0_0= 'private' )
                    {
                    // InternalDSL.g:1937:1: (lv_private_0_0= 'private' )
                    // InternalDSL.g:1938:3: lv_private_0_0= 'private'
                    {
                    lv_private_0_0=(Token)match(input,32,FOLLOW_34); 

                            newLeafNode(lv_private_0_0, grammarAccess.getVariableDefinitionAccess().getPrivatePrivateKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVariableDefinitionRule());
                    	        }
                           		setWithLastConsumed(current, "private", lv_private_0_0, "private");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,48,FOLLOW_5); 

                	newLeafNode(otherlv_1, grammarAccess.getVariableDefinitionAccess().getVariableKeyword_1());
                
             
                    newCompositeNode(grammarAccess.getVariableDefinitionAccess().getNLParserRuleCall_2()); 
                
            pushFollow(FOLLOW_5);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1963:1: ( (lv_name_3_0= ruleVariableEntity ) )
            // InternalDSL.g:1964:1: (lv_name_3_0= ruleVariableEntity )
            {
            // InternalDSL.g:1964:1: (lv_name_3_0= ruleVariableEntity )
            // InternalDSL.g:1965:3: lv_name_3_0= ruleVariableEntity
            {
             
            	        newCompositeNode(grammarAccess.getVariableDefinitionAccess().getNameVariableEntityParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_35);
            lv_name_3_0=ruleVariableEntity();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVariableDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"de.gebit.integrity.DSL.VariableEntity");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getVariableDefinitionAccess().getNLParserRuleCall_4()); 
                
            pushFollow(FOLLOW_36);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1989:1: (otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==49) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalDSL.g:1989:3: otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL
                    {
                    otherlv_5=(Token)match(input,49,FOLLOW_17); 

                        	newLeafNode(otherlv_5, grammarAccess.getVariableDefinitionAccess().getInitiallyKeyword_5_0());
                        
                     
                            newCompositeNode(grammarAccess.getVariableDefinitionAccess().getNLParserRuleCall_5_1()); 
                        
                    pushFollow(FOLLOW_17);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalDSL.g:2001:1: ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) )
                    // InternalDSL.g:2002:1: (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection )
                    {
                    // InternalDSL.g:2002:1: (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection )
                    // InternalDSL.g:2003:3: lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariableDefinitionAccess().getInitialValueValueOrEnumValueOrOperationCollectionParserRuleCall_5_2_0()); 
                    	    
                    pushFollow(FOLLOW_4);
                    lv_initialValue_7_0=ruleValueOrEnumValueOrOperationCollection();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVariableDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"initialValue",
                            		lv_initialValue_7_0, 
                            		"de.gebit.integrity.DSL.ValueOrEnumValueOrOperationCollection");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getVariableDefinitionAccess().getNLParserRuleCall_5_3()); 
                        
                    pushFollow(FOLLOW_2);
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
    // InternalDSL.g:2035:1: entryRuleConstantDefinition returns [EObject current=null] : iv_ruleConstantDefinition= ruleConstantDefinition EOF ;
    public final EObject entryRuleConstantDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantDefinition = null;


        try {
            // InternalDSL.g:2036:2: (iv_ruleConstantDefinition= ruleConstantDefinition EOF )
            // InternalDSL.g:2037:2: iv_ruleConstantDefinition= ruleConstantDefinition EOF
            {
             newCompositeNode(grammarAccess.getConstantDefinitionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstantDefinition=ruleConstantDefinition();

            state._fsp--;

             current =iv_ruleConstantDefinition; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:2044:1: ruleConstantDefinition returns [EObject current=null] : ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'constant' ruleNL ( (lv_name_3_0= ruleConstantEntity ) ) ruleNL ( ( ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_7_0= ruleVariantValue ) ) ruleNL )* ) ( ( (lv_parameterized_9_0= 'parameterized' ) ) ruleNL )? ) ;
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
            // InternalDSL.g:2047:28: ( ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'constant' ruleNL ( (lv_name_3_0= ruleConstantEntity ) ) ruleNL ( ( ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_7_0= ruleVariantValue ) ) ruleNL )* ) ( ( (lv_parameterized_9_0= 'parameterized' ) ) ruleNL )? ) )
            // InternalDSL.g:2048:1: ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'constant' ruleNL ( (lv_name_3_0= ruleConstantEntity ) ) ruleNL ( ( ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_7_0= ruleVariantValue ) ) ruleNL )* ) ( ( (lv_parameterized_9_0= 'parameterized' ) ) ruleNL )? )
            {
            // InternalDSL.g:2048:1: ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'constant' ruleNL ( (lv_name_3_0= ruleConstantEntity ) ) ruleNL ( ( ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_7_0= ruleVariantValue ) ) ruleNL )* ) ( ( (lv_parameterized_9_0= 'parameterized' ) ) ruleNL )? )
            // InternalDSL.g:2048:2: ( (lv_private_0_0= 'private' ) )? otherlv_1= 'constant' ruleNL ( (lv_name_3_0= ruleConstantEntity ) ) ruleNL ( ( ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_7_0= ruleVariantValue ) ) ruleNL )* ) ( ( (lv_parameterized_9_0= 'parameterized' ) ) ruleNL )?
            {
            // InternalDSL.g:2048:2: ( (lv_private_0_0= 'private' ) )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==32) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // InternalDSL.g:2049:1: (lv_private_0_0= 'private' )
                    {
                    // InternalDSL.g:2049:1: (lv_private_0_0= 'private' )
                    // InternalDSL.g:2050:3: lv_private_0_0= 'private'
                    {
                    lv_private_0_0=(Token)match(input,32,FOLLOW_37); 

                            newLeafNode(lv_private_0_0, grammarAccess.getConstantDefinitionAccess().getPrivatePrivateKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConstantDefinitionRule());
                    	        }
                           		setWithLastConsumed(current, "private", lv_private_0_0, "private");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,50,FOLLOW_5); 

                	newLeafNode(otherlv_1, grammarAccess.getConstantDefinitionAccess().getConstantKeyword_1());
                
             
                    newCompositeNode(grammarAccess.getConstantDefinitionAccess().getNLParserRuleCall_2()); 
                
            pushFollow(FOLLOW_5);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2075:1: ( (lv_name_3_0= ruleConstantEntity ) )
            // InternalDSL.g:2076:1: (lv_name_3_0= ruleConstantEntity )
            {
            // InternalDSL.g:2076:1: (lv_name_3_0= ruleConstantEntity )
            // InternalDSL.g:2077:3: lv_name_3_0= ruleConstantEntity
            {
             
            	        newCompositeNode(grammarAccess.getConstantDefinitionAccess().getNameConstantEntityParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_38);
            lv_name_3_0=ruleConstantEntity();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConstantDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"de.gebit.integrity.DSL.ConstantEntity");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getConstantDefinitionAccess().getNLParserRuleCall_4()); 
                
            pushFollow(FOLLOW_39);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2101:1: ( ( ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_7_0= ruleVariantValue ) ) ruleNL )* )
            // InternalDSL.g:2101:2: ( ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_7_0= ruleVariantValue ) ) ruleNL )*
            {
            // InternalDSL.g:2101:2: ( ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=RULE_STRING && LA30_0<=RULE_UPPERCASE_ID)||LA30_0==64||LA30_0==71||LA30_0==74||(LA30_0>=77 && LA30_0<=78)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalDSL.g:2101:3: ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL
                    {
                    // InternalDSL.g:2101:3: ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) )
                    // InternalDSL.g:2102:1: (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection )
                    {
                    // InternalDSL.g:2102:1: (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection )
                    // InternalDSL.g:2103:3: lv_value_5_0= ruleValueOrEnumValueOrOperationCollection
                    {
                     
                    	        newCompositeNode(grammarAccess.getConstantDefinitionAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_5_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_40);
                    lv_value_5_0=ruleValueOrEnumValueOrOperationCollection();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConstantDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_5_0, 
                            		"de.gebit.integrity.DSL.ValueOrEnumValueOrOperationCollection");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getConstantDefinitionAccess().getNLParserRuleCall_5_0_1()); 
                        
                    pushFollow(FOLLOW_41);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // InternalDSL.g:2127:3: ( ( (lv_variantValues_7_0= ruleVariantValue ) ) ruleNL )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==54) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalDSL.g:2127:4: ( (lv_variantValues_7_0= ruleVariantValue ) ) ruleNL
            	    {
            	    // InternalDSL.g:2127:4: ( (lv_variantValues_7_0= ruleVariantValue ) )
            	    // InternalDSL.g:2128:1: (lv_variantValues_7_0= ruleVariantValue )
            	    {
            	    // InternalDSL.g:2128:1: (lv_variantValues_7_0= ruleVariantValue )
            	    // InternalDSL.g:2129:3: lv_variantValues_7_0= ruleVariantValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConstantDefinitionAccess().getVariantValuesVariantValueParserRuleCall_5_1_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_40);
            	    lv_variantValues_7_0=ruleVariantValue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConstantDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"variantValues",
            	            		lv_variantValues_7_0, 
            	            		"de.gebit.integrity.DSL.VariantValue");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	     
            	            newCompositeNode(grammarAccess.getConstantDefinitionAccess().getNLParserRuleCall_5_1_1()); 
            	        
            	    pushFollow(FOLLOW_41);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }

            // InternalDSL.g:2153:4: ( ( (lv_parameterized_9_0= 'parameterized' ) ) ruleNL )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==51) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalDSL.g:2153:5: ( (lv_parameterized_9_0= 'parameterized' ) ) ruleNL
                    {
                    // InternalDSL.g:2153:5: ( (lv_parameterized_9_0= 'parameterized' ) )
                    // InternalDSL.g:2154:1: (lv_parameterized_9_0= 'parameterized' )
                    {
                    // InternalDSL.g:2154:1: (lv_parameterized_9_0= 'parameterized' )
                    // InternalDSL.g:2155:3: lv_parameterized_9_0= 'parameterized'
                    {
                    lv_parameterized_9_0=(Token)match(input,51,FOLLOW_4); 

                            newLeafNode(lv_parameterized_9_0, grammarAccess.getConstantDefinitionAccess().getParameterizedParameterizedKeyword_6_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConstantDefinitionRule());
                    	        }
                           		setWithLastConsumed(current, "parameterized", lv_parameterized_9_0, "parameterized");
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getConstantDefinitionAccess().getNLParserRuleCall_6_1()); 
                        
                    pushFollow(FOLLOW_2);
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
    // $ANTLR end "ruleConstantDefinition"


    // $ANTLR start "entryRuleVariableAssignment"
    // InternalDSL.g:2184:1: entryRuleVariableAssignment returns [EObject current=null] : iv_ruleVariableAssignment= ruleVariableAssignment EOF ;
    public final EObject entryRuleVariableAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableAssignment = null;


        try {
            // InternalDSL.g:2185:2: (iv_ruleVariableAssignment= ruleVariableAssignment EOF )
            // InternalDSL.g:2186:2: iv_ruleVariableAssignment= ruleVariableAssignment EOF
            {
             newCompositeNode(grammarAccess.getVariableAssignmentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableAssignment=ruleVariableAssignment();

            state._fsp--;

             current =iv_ruleVariableAssignment; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableAssignment"


    // $ANTLR start "ruleVariableAssignment"
    // InternalDSL.g:2193:1: ruleVariableAssignment returns [EObject current=null] : (otherlv_0= 'assign' ruleNL ( (lv_value_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL otherlv_4= '->' ruleNL ( (lv_target_6_0= ruleVariableVariable ) ) ruleNL ) ;
    public final EObject ruleVariableAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject lv_value_2_0 = null;

        EObject lv_target_6_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:2196:28: ( (otherlv_0= 'assign' ruleNL ( (lv_value_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL otherlv_4= '->' ruleNL ( (lv_target_6_0= ruleVariableVariable ) ) ruleNL ) )
            // InternalDSL.g:2197:1: (otherlv_0= 'assign' ruleNL ( (lv_value_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL otherlv_4= '->' ruleNL ( (lv_target_6_0= ruleVariableVariable ) ) ruleNL )
            {
            // InternalDSL.g:2197:1: (otherlv_0= 'assign' ruleNL ( (lv_value_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL otherlv_4= '->' ruleNL ( (lv_target_6_0= ruleVariableVariable ) ) ruleNL )
            // InternalDSL.g:2197:3: otherlv_0= 'assign' ruleNL ( (lv_value_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL otherlv_4= '->' ruleNL ( (lv_target_6_0= ruleVariableVariable ) ) ruleNL
            {
            otherlv_0=(Token)match(input,52,FOLLOW_17); 

                	newLeafNode(otherlv_0, grammarAccess.getVariableAssignmentAccess().getAssignKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getVariableAssignmentAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_17);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2209:1: ( (lv_value_2_0= ruleValueOrEnumValueOrOperationCollection ) )
            // InternalDSL.g:2210:1: (lv_value_2_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // InternalDSL.g:2210:1: (lv_value_2_0= ruleValueOrEnumValueOrOperationCollection )
            // InternalDSL.g:2211:3: lv_value_2_0= ruleValueOrEnumValueOrOperationCollection
            {
             
            	        newCompositeNode(grammarAccess.getVariableAssignmentAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_42);
            lv_value_2_0=ruleValueOrEnumValueOrOperationCollection();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVariableAssignmentRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_2_0, 
                    		"de.gebit.integrity.DSL.ValueOrEnumValueOrOperationCollection");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getVariableAssignmentAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_43);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_4=(Token)match(input,53,FOLLOW_5); 

                	newLeafNode(otherlv_4, grammarAccess.getVariableAssignmentAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
             
                    newCompositeNode(grammarAccess.getVariableAssignmentAccess().getNLParserRuleCall_5()); 
                
            pushFollow(FOLLOW_5);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2247:1: ( (lv_target_6_0= ruleVariableVariable ) )
            // InternalDSL.g:2248:1: (lv_target_6_0= ruleVariableVariable )
            {
            // InternalDSL.g:2248:1: (lv_target_6_0= ruleVariableVariable )
            // InternalDSL.g:2249:3: lv_target_6_0= ruleVariableVariable
            {
             
            	        newCompositeNode(grammarAccess.getVariableAssignmentAccess().getTargetVariableVariableParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_4);
            lv_target_6_0=ruleVariableVariable();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVariableAssignmentRule());
            	        }
                   		set(
                   			current, 
                   			"target",
                    		lv_target_6_0, 
                    		"de.gebit.integrity.DSL.VariableVariable");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getVariableAssignmentAccess().getNLParserRuleCall_7()); 
                
            pushFollow(FOLLOW_2);
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
    // $ANTLR end "ruleVariableAssignment"


    // $ANTLR start "entryRuleVariantValue"
    // InternalDSL.g:2281:1: entryRuleVariantValue returns [EObject current=null] : iv_ruleVariantValue= ruleVariantValue EOF ;
    public final EObject entryRuleVariantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariantValue = null;


        try {
            // InternalDSL.g:2282:2: (iv_ruleVariantValue= ruleVariantValue EOF )
            // InternalDSL.g:2283:2: iv_ruleVariantValue= ruleVariantValue EOF
            {
             newCompositeNode(grammarAccess.getVariantValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariantValue=ruleVariantValue();

            state._fsp--;

             current =iv_ruleVariantValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:2290:1: ruleVariantValue returns [EObject current=null] : (otherlv_0= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ otherlv_4= ':' ruleNL ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) ) ;
    public final EObject ruleVariantValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject lv_value_6_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:2293:28: ( (otherlv_0= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ otherlv_4= ':' ruleNL ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) ) )
            // InternalDSL.g:2294:1: (otherlv_0= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ otherlv_4= ':' ruleNL ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            {
            // InternalDSL.g:2294:1: (otherlv_0= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ otherlv_4= ':' ruleNL ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            // InternalDSL.g:2294:3: otherlv_0= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ otherlv_4= ':' ruleNL ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) )
            {
            otherlv_0=(Token)match(input,54,FOLLOW_5); 

                	newLeafNode(otherlv_0, grammarAccess.getVariantValueAccess().getInKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getVariantValueAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_5);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2306:1: ( ( ( ruleQualifiedName ) ) ruleNL )+
            int cnt33=0;
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( (LA33_0==RULE_ID) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalDSL.g:2306:2: ( ( ruleQualifiedName ) ) ruleNL
            	    {
            	    // InternalDSL.g:2306:2: ( ( ruleQualifiedName ) )
            	    // InternalDSL.g:2307:1: ( ruleQualifiedName )
            	    {
            	    // InternalDSL.g:2307:1: ( ruleQualifiedName )
            	    // InternalDSL.g:2308:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getVariantValueRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getVariantValueAccess().getNamesVariantDefinitionCrossReference_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_44);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	     
            	            newCompositeNode(grammarAccess.getVariantValueAccess().getNLParserRuleCall_2_1()); 
            	        
            	    pushFollow(FOLLOW_44);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt33 >= 1 ) break loop33;
                        EarlyExitException eee =
                            new EarlyExitException(33, input);
                        throw eee;
                }
                cnt33++;
            } while (true);

            otherlv_4=(Token)match(input,35,FOLLOW_17); 

                	newLeafNode(otherlv_4, grammarAccess.getVariantValueAccess().getColonKeyword_3());
                
             
                    newCompositeNode(grammarAccess.getVariantValueAccess().getNLParserRuleCall_4()); 
                
            pushFollow(FOLLOW_17);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2341:1: ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) )
            // InternalDSL.g:2342:1: (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // InternalDSL.g:2342:1: (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection )
            // InternalDSL.g:2343:3: lv_value_6_0= ruleValueOrEnumValueOrOperationCollection
            {
             
            	        newCompositeNode(grammarAccess.getVariantValueAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_value_6_0=ruleValueOrEnumValueOrOperationCollection();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVariantValueRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_6_0, 
                    		"de.gebit.integrity.DSL.ValueOrEnumValueOrOperationCollection");
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
    // InternalDSL.g:2367:1: entryRuleVariableEntity returns [EObject current=null] : iv_ruleVariableEntity= ruleVariableEntity EOF ;
    public final EObject entryRuleVariableEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableEntity = null;


        try {
            // InternalDSL.g:2368:2: (iv_ruleVariableEntity= ruleVariableEntity EOF )
            // InternalDSL.g:2369:2: iv_ruleVariableEntity= ruleVariableEntity EOF
            {
             newCompositeNode(grammarAccess.getVariableEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableEntity=ruleVariableEntity();

            state._fsp--;

             current =iv_ruleVariableEntity; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:2376:1: ruleVariableEntity returns [EObject current=null] : ( (lv_name_0_0= ruleQualifiedName ) ) ;
    public final EObject ruleVariableEntity() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:2379:28: ( ( (lv_name_0_0= ruleQualifiedName ) ) )
            // InternalDSL.g:2380:1: ( (lv_name_0_0= ruleQualifiedName ) )
            {
            // InternalDSL.g:2380:1: ( (lv_name_0_0= ruleQualifiedName ) )
            // InternalDSL.g:2381:1: (lv_name_0_0= ruleQualifiedName )
            {
            // InternalDSL.g:2381:1: (lv_name_0_0= ruleQualifiedName )
            // InternalDSL.g:2382:3: lv_name_0_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getVariableEntityAccess().getNameQualifiedNameParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_name_0_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVariableEntityRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"de.gebit.integrity.DSL.QualifiedName");
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
    // InternalDSL.g:2406:1: entryRuleConstantEntity returns [EObject current=null] : iv_ruleConstantEntity= ruleConstantEntity EOF ;
    public final EObject entryRuleConstantEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantEntity = null;


        try {
            // InternalDSL.g:2407:2: (iv_ruleConstantEntity= ruleConstantEntity EOF )
            // InternalDSL.g:2408:2: iv_ruleConstantEntity= ruleConstantEntity EOF
            {
             newCompositeNode(grammarAccess.getConstantEntityRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstantEntity=ruleConstantEntity();

            state._fsp--;

             current =iv_ruleConstantEntity; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:2415:1: ruleConstantEntity returns [EObject current=null] : ( (lv_name_0_0= ruleQualifiedName ) ) ;
    public final EObject ruleConstantEntity() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:2418:28: ( ( (lv_name_0_0= ruleQualifiedName ) ) )
            // InternalDSL.g:2419:1: ( (lv_name_0_0= ruleQualifiedName ) )
            {
            // InternalDSL.g:2419:1: ( (lv_name_0_0= ruleQualifiedName ) )
            // InternalDSL.g:2420:1: (lv_name_0_0= ruleQualifiedName )
            {
            // InternalDSL.g:2420:1: (lv_name_0_0= ruleQualifiedName )
            // InternalDSL.g:2421:3: lv_name_0_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getConstantEntityAccess().getNameQualifiedNameParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_name_0_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConstantEntityRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"de.gebit.integrity.DSL.QualifiedName");
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
    // InternalDSL.g:2447:1: entryRuleTest returns [EObject current=null] : iv_ruleTest= ruleTest EOF ;
    public final EObject entryRuleTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTest = null;


        try {
            // InternalDSL.g:2448:2: (iv_ruleTest= ruleTest EOF )
            // InternalDSL.g:2449:2: iv_ruleTest= ruleTest EOF
            {
             newCompositeNode(grammarAccess.getTestRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTest=ruleTest();

            state._fsp--;

             current =iv_ruleTest; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:2456:1: ruleTest returns [EObject current=null] : ( ( (lv_checkpoint_0_0= 'checkpoint' ) )? otherlv_1= 'test' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_5_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_7_0= ruleNamedResult ) ) )* ( ruleNL otherlv_9= '=' ruleNL ( (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL ) ;
    public final EObject ruleTest() throws RecognitionException {
        EObject current = null;

        Token lv_checkpoint_0_0=null;
        Token otherlv_1=null;
        Token otherlv_9=null;
        EObject lv_parameters_5_0 = null;

        EObject lv_results_7_0 = null;

        EObject lv_result_11_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:2459:28: ( ( ( (lv_checkpoint_0_0= 'checkpoint' ) )? otherlv_1= 'test' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_5_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_7_0= ruleNamedResult ) ) )* ( ruleNL otherlv_9= '=' ruleNL ( (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL ) )
            // InternalDSL.g:2460:1: ( ( (lv_checkpoint_0_0= 'checkpoint' ) )? otherlv_1= 'test' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_5_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_7_0= ruleNamedResult ) ) )* ( ruleNL otherlv_9= '=' ruleNL ( (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL )
            {
            // InternalDSL.g:2460:1: ( ( (lv_checkpoint_0_0= 'checkpoint' ) )? otherlv_1= 'test' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_5_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_7_0= ruleNamedResult ) ) )* ( ruleNL otherlv_9= '=' ruleNL ( (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL )
            // InternalDSL.g:2460:2: ( (lv_checkpoint_0_0= 'checkpoint' ) )? otherlv_1= 'test' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_5_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_7_0= ruleNamedResult ) ) )* ( ruleNL otherlv_9= '=' ruleNL ( (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL
            {
            // InternalDSL.g:2460:2: ( (lv_checkpoint_0_0= 'checkpoint' ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==55) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalDSL.g:2461:1: (lv_checkpoint_0_0= 'checkpoint' )
                    {
                    // InternalDSL.g:2461:1: (lv_checkpoint_0_0= 'checkpoint' )
                    // InternalDSL.g:2462:3: lv_checkpoint_0_0= 'checkpoint'
                    {
                    lv_checkpoint_0_0=(Token)match(input,55,FOLLOW_45); 

                            newLeafNode(lv_checkpoint_0_0, grammarAccess.getTestAccess().getCheckpointCheckpointKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTestRule());
                    	        }
                           		setWithLastConsumed(current, "checkpoint", lv_checkpoint_0_0, "checkpoint");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,56,FOLLOW_5); 

                	newLeafNode(otherlv_1, grammarAccess.getTestAccess().getTestKeyword_1());
                
             
                    newCompositeNode(grammarAccess.getTestAccess().getNLParserRuleCall_2()); 
                
            pushFollow(FOLLOW_5);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2487:1: ( ( ruleQualifiedName ) )
            // InternalDSL.g:2488:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:2488:1: ( ruleQualifiedName )
            // InternalDSL.g:2489:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTestRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTestAccess().getDefinitionTestDefinitionCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_46);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalDSL.g:2502:2: ( ruleNL ( (lv_parameters_5_0= ruleParameter ) ) )*
            loop35:
            do {
                int alt35=2;
                alt35 = dfa35.predict(input);
                switch (alt35) {
            	case 1 :
            	    // InternalDSL.g:2503:5: ruleNL ( (lv_parameters_5_0= ruleParameter ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getTestAccess().getNLParserRuleCall_4_0()); 
            	        
            	    pushFollow(FOLLOW_47);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // InternalDSL.g:2510:1: ( (lv_parameters_5_0= ruleParameter ) )
            	    // InternalDSL.g:2511:1: (lv_parameters_5_0= ruleParameter )
            	    {
            	    // InternalDSL.g:2511:1: (lv_parameters_5_0= ruleParameter )
            	    // InternalDSL.g:2512:3: lv_parameters_5_0= ruleParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTestAccess().getParametersParameterParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_46);
            	    lv_parameters_5_0=ruleParameter();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"parameters",
            	            		lv_parameters_5_0, 
            	            		"de.gebit.integrity.DSL.Parameter");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop35;
                }
            } while (true);

            // InternalDSL.g:2528:4: ( ruleNL ( (lv_results_7_0= ruleNamedResult ) ) )*
            loop36:
            do {
                int alt36=2;
                alt36 = dfa36.predict(input);
                switch (alt36) {
            	case 1 :
            	    // InternalDSL.g:2529:5: ruleNL ( (lv_results_7_0= ruleNamedResult ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getTestAccess().getNLParserRuleCall_5_0()); 
            	        
            	    pushFollow(FOLLOW_47);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // InternalDSL.g:2536:1: ( (lv_results_7_0= ruleNamedResult ) )
            	    // InternalDSL.g:2537:1: (lv_results_7_0= ruleNamedResult )
            	    {
            	    // InternalDSL.g:2537:1: (lv_results_7_0= ruleNamedResult )
            	    // InternalDSL.g:2538:3: lv_results_7_0= ruleNamedResult
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTestAccess().getResultsNamedResultParserRuleCall_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_46);
            	    lv_results_7_0=ruleNamedResult();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"results",
            	            		lv_results_7_0, 
            	            		"de.gebit.integrity.DSL.NamedResult");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            // InternalDSL.g:2554:4: ( ruleNL otherlv_9= '=' ruleNL ( (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection ) ) )?
            int alt37=2;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // InternalDSL.g:2555:5: ruleNL otherlv_9= '=' ruleNL ( (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection ) )
                    {
                     
                            newCompositeNode(grammarAccess.getTestAccess().getNLParserRuleCall_6_0()); 
                        
                    pushFollow(FOLLOW_48);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    otherlv_9=(Token)match(input,57,FOLLOW_17); 

                        	newLeafNode(otherlv_9, grammarAccess.getTestAccess().getEqualsSignKeyword_6_1());
                        
                     
                            newCompositeNode(grammarAccess.getTestAccess().getNLParserRuleCall_6_2()); 
                        
                    pushFollow(FOLLOW_17);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalDSL.g:2574:1: ( (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection ) )
                    // InternalDSL.g:2575:1: (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection )
                    {
                    // InternalDSL.g:2575:1: (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection )
                    // InternalDSL.g:2576:3: lv_result_11_0= ruleValueOrEnumValueOrOperationCollection
                    {
                     
                    	        newCompositeNode(grammarAccess.getTestAccess().getResultValueOrEnumValueOrOperationCollectionParserRuleCall_6_3_0()); 
                    	    
                    pushFollow(FOLLOW_4);
                    lv_result_11_0=ruleValueOrEnumValueOrOperationCollection();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTestRule());
                    	        }
                           		set(
                           			current, 
                           			"result",
                            		lv_result_11_0, 
                            		"de.gebit.integrity.DSL.ValueOrEnumValueOrOperationCollection");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

             
                    newCompositeNode(grammarAccess.getTestAccess().getNLParserRuleCall_7()); 
                
            pushFollow(FOLLOW_2);
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
    // InternalDSL.g:2608:1: entryRuleTableTest returns [EObject current=null] : iv_ruleTableTest= ruleTableTest EOF ;
    public final EObject entryRuleTableTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTableTest = null;


        try {
            // InternalDSL.g:2609:2: (iv_ruleTableTest= ruleTableTest EOF )
            // InternalDSL.g:2610:2: iv_ruleTableTest= ruleTableTest EOF
            {
             newCompositeNode(grammarAccess.getTableTestRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTableTest=ruleTableTest();

            state._fsp--;

             current =iv_ruleTableTest; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:2617:1: ruleTableTest returns [EObject current=null] : (otherlv_0= 'tabletest' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ruleNLFORCED ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )* otherlv_8= '|' ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )? ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+ ruleNLFORCED ) ;
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
            // InternalDSL.g:2620:28: ( (otherlv_0= 'tabletest' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ruleNLFORCED ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )* otherlv_8= '|' ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )? ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+ ruleNLFORCED ) )
            // InternalDSL.g:2621:1: (otherlv_0= 'tabletest' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ruleNLFORCED ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )* otherlv_8= '|' ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )? ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+ ruleNLFORCED )
            {
            // InternalDSL.g:2621:1: (otherlv_0= 'tabletest' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ruleNLFORCED ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )* otherlv_8= '|' ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )? ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+ ruleNLFORCED )
            // InternalDSL.g:2621:3: otherlv_0= 'tabletest' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ruleNLFORCED ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )* otherlv_8= '|' ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )? ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+ ruleNLFORCED
            {
            otherlv_0=(Token)match(input,58,FOLLOW_5); 

                	newLeafNode(otherlv_0, grammarAccess.getTableTestAccess().getTabletestKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getTableTestAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_5);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2633:1: ( ( ruleQualifiedName ) )
            // InternalDSL.g:2634:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:2634:1: ( ruleQualifiedName )
            // InternalDSL.g:2635:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTableTestRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTableTestAccess().getDefinitionTestDefinitionCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_47);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalDSL.g:2648:2: ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )*
            loop38:
            do {
                int alt38=2;
                alt38 = dfa38.predict(input);
                switch (alt38) {
            	case 1 :
            	    // InternalDSL.g:2649:5: ruleNL ( (lv_parameters_4_0= ruleParameter ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getTableTestAccess().getNLParserRuleCall_3_0()); 
            	        
            	    pushFollow(FOLLOW_47);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // InternalDSL.g:2656:1: ( (lv_parameters_4_0= ruleParameter ) )
            	    // InternalDSL.g:2657:1: (lv_parameters_4_0= ruleParameter )
            	    {
            	    // InternalDSL.g:2657:1: (lv_parameters_4_0= ruleParameter )
            	    // InternalDSL.g:2658:3: lv_parameters_4_0= ruleParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getParametersParameterParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_47);
            	    lv_parameters_4_0=ruleParameter();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTableTestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"parameters",
            	            		lv_parameters_4_0, 
            	            		"de.gebit.integrity.DSL.Parameter");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);

             
                    newCompositeNode(grammarAccess.getTableTestAccess().getNLFORCEDParserRuleCall_4()); 
                
            pushFollow(FOLLOW_49);
            ruleNLFORCED();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2682:1: ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==59) ) {
                    int LA39_1 = input.LA(2);

                    if ( (LA39_1==RULE_ID) ) {
                        int LA39_2 = input.LA(3);

                        if ( (LA39_2==59) ) {
                            alt39=1;
                        }


                    }
                    else if ( (LA39_1==63) ) {
                        int LA39_3 = input.LA(3);

                        if ( (LA39_3==RULE_ID) ) {
                            int LA39_6 = input.LA(4);

                            if ( (LA39_6==59) ) {
                                alt39=1;
                            }


                        }
                        else if ( (LA39_3==RULE_STRING) ) {
                            int LA39_7 = input.LA(4);

                            if ( (LA39_7==59) ) {
                                alt39=1;
                            }


                        }


                    }


                }


                switch (alt39) {
            	case 1 :
            	    // InternalDSL.g:2683:1: (lv_parameterHeaders_6_0= ruleParameterTableHeader )
            	    {
            	    // InternalDSL.g:2683:1: (lv_parameterHeaders_6_0= ruleParameterTableHeader )
            	    // InternalDSL.g:2684:3: lv_parameterHeaders_6_0= ruleParameterTableHeader
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getParameterHeadersParameterTableHeaderParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_49);
            	    lv_parameterHeaders_6_0=ruleParameterTableHeader();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTableTestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"parameterHeaders",
            	            		lv_parameterHeaders_6_0, 
            	            		"de.gebit.integrity.DSL.ParameterTableHeader");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);

            // InternalDSL.g:2700:3: ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==59) ) {
                    int LA40_1 = input.LA(2);

                    if ( (LA40_1==RULE_ID||LA40_1==63) ) {
                        alt40=1;
                    }


                }


                switch (alt40) {
            	case 1 :
            	    // InternalDSL.g:2701:1: (lv_resultHeaders_7_0= ruleResultTableHeader )
            	    {
            	    // InternalDSL.g:2701:1: (lv_resultHeaders_7_0= ruleResultTableHeader )
            	    // InternalDSL.g:2702:3: lv_resultHeaders_7_0= ruleResultTableHeader
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getResultHeadersResultTableHeaderParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_49);
            	    lv_resultHeaders_7_0=ruleResultTableHeader();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTableTestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"resultHeaders",
            	            		lv_resultHeaders_7_0, 
            	            		"de.gebit.integrity.DSL.ResultTableHeader");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);

            otherlv_8=(Token)match(input,59,FOLLOW_46); 

                	newLeafNode(otherlv_8, grammarAccess.getTableTestAccess().getVerticalLineKeyword_7());
                
            // InternalDSL.g:2722:1: ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==57) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalDSL.g:2722:2: ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|'
                    {
                    // InternalDSL.g:2722:2: ( (lv_defaultResultColumn_9_0= '=' ) )
                    // InternalDSL.g:2723:1: (lv_defaultResultColumn_9_0= '=' )
                    {
                    // InternalDSL.g:2723:1: (lv_defaultResultColumn_9_0= '=' )
                    // InternalDSL.g:2724:3: lv_defaultResultColumn_9_0= '='
                    {
                    lv_defaultResultColumn_9_0=(Token)match(input,57,FOLLOW_49); 

                            newLeafNode(lv_defaultResultColumn_9_0, grammarAccess.getTableTestAccess().getDefaultResultColumnEqualsSignKeyword_8_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTableTestRule());
                    	        }
                           		setWithLastConsumed(current, "defaultResultColumn", lv_defaultResultColumn_9_0, "=");
                    	    

                    }


                    }

                    otherlv_10=(Token)match(input,59,FOLLOW_47); 

                        	newLeafNode(otherlv_10, grammarAccess.getTableTestAccess().getVerticalLineKeyword_8_1());
                        

                    }
                    break;

            }

            // InternalDSL.g:2741:3: ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+
            int cnt42=0;
            loop42:
            do {
                int alt42=2;
                alt42 = dfa42.predict(input);
                switch (alt42) {
            	case 1 :
            	    // InternalDSL.g:2742:5: ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getTableTestAccess().getNLFORCEDParserRuleCall_9_0()); 
            	        
            	    pushFollow(FOLLOW_49);
            	    ruleNLFORCED();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // InternalDSL.g:2749:1: ( (lv_rows_12_0= ruleTableTestRow ) )
            	    // InternalDSL.g:2750:1: (lv_rows_12_0= ruleTableTestRow )
            	    {
            	    // InternalDSL.g:2750:1: (lv_rows_12_0= ruleTableTestRow )
            	    // InternalDSL.g:2751:3: lv_rows_12_0= ruleTableTestRow
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getRowsTableTestRowParserRuleCall_9_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_47);
            	    lv_rows_12_0=ruleTableTestRow();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTableTestRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"rows",
            	            		lv_rows_12_0, 
            	            		"de.gebit.integrity.DSL.TableTestRow");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt42 >= 1 ) break loop42;
                        EarlyExitException eee =
                            new EarlyExitException(42, input);
                        throw eee;
                }
                cnt42++;
            } while (true);

             
                    newCompositeNode(grammarAccess.getTableTestAccess().getNLFORCEDParserRuleCall_10()); 
                
            pushFollow(FOLLOW_2);
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
    // InternalDSL.g:2783:1: entryRuleTableTestRow returns [EObject current=null] : iv_ruleTableTestRow= ruleTableTestRow EOF ;
    public final EObject entryRuleTableTestRow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTableTestRow = null;


        try {
            // InternalDSL.g:2784:2: (iv_ruleTableTestRow= ruleTableTestRow EOF )
            // InternalDSL.g:2785:2: iv_ruleTableTestRow= ruleTableTestRow EOF
            {
             newCompositeNode(grammarAccess.getTableTestRowRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTableTestRow=ruleTableTestRow();

            state._fsp--;

             current =iv_ruleTableTestRow; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:2792:1: ruleTableTestRow returns [EObject current=null] : ( () ( (lv_values_1_0= ruleParameterTableValue ) )+ ) ;
    public final EObject ruleTableTestRow() throws RecognitionException {
        EObject current = null;

        EObject lv_values_1_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:2795:28: ( ( () ( (lv_values_1_0= ruleParameterTableValue ) )+ ) )
            // InternalDSL.g:2796:1: ( () ( (lv_values_1_0= ruleParameterTableValue ) )+ )
            {
            // InternalDSL.g:2796:1: ( () ( (lv_values_1_0= ruleParameterTableValue ) )+ )
            // InternalDSL.g:2796:2: () ( (lv_values_1_0= ruleParameterTableValue ) )+
            {
            // InternalDSL.g:2796:2: ()
            // InternalDSL.g:2797:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTableTestRowAccess().getTableTestRowAction_0(),
                        current);
                

            }

            // InternalDSL.g:2802:2: ( (lv_values_1_0= ruleParameterTableValue ) )+
            int cnt43=0;
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==59) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalDSL.g:2803:1: (lv_values_1_0= ruleParameterTableValue )
            	    {
            	    // InternalDSL.g:2803:1: (lv_values_1_0= ruleParameterTableValue )
            	    // InternalDSL.g:2804:3: lv_values_1_0= ruleParameterTableValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestRowAccess().getValuesParameterTableValueParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_50);
            	    lv_values_1_0=ruleParameterTableValue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTableTestRowRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"values",
            	            		lv_values_1_0, 
            	            		"de.gebit.integrity.DSL.ParameterTableValue");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


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


            }

             leaveRule(); 
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
    // InternalDSL.g:2828:1: entryRuleParameterTableHeader returns [EObject current=null] : iv_ruleParameterTableHeader= ruleParameterTableHeader EOF ;
    public final EObject entryRuleParameterTableHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterTableHeader = null;


        try {
            // InternalDSL.g:2829:2: (iv_ruleParameterTableHeader= ruleParameterTableHeader EOF )
            // InternalDSL.g:2830:2: iv_ruleParameterTableHeader= ruleParameterTableHeader EOF
            {
             newCompositeNode(grammarAccess.getParameterTableHeaderRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterTableHeader=ruleParameterTableHeader();

            state._fsp--;

             current =iv_ruleParameterTableHeader; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:2837:1: ruleParameterTableHeader returns [EObject current=null] : (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) (otherlv_2= '|' )? ) ;
    public final EObject ruleParameterTableHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:2840:28: ( (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) (otherlv_2= '|' )? ) )
            // InternalDSL.g:2841:1: (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) (otherlv_2= '|' )? )
            {
            // InternalDSL.g:2841:1: (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) (otherlv_2= '|' )? )
            // InternalDSL.g:2841:3: otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) (otherlv_2= '|' )?
            {
            otherlv_0=(Token)match(input,59,FOLLOW_47); 

                	newLeafNode(otherlv_0, grammarAccess.getParameterTableHeaderAccess().getVerticalLineKeyword_0());
                
            // InternalDSL.g:2845:1: ( (lv_name_1_0= ruleParameterName ) )
            // InternalDSL.g:2846:1: (lv_name_1_0= ruleParameterName )
            {
            // InternalDSL.g:2846:1: (lv_name_1_0= ruleParameterName )
            // InternalDSL.g:2847:3: lv_name_1_0= ruleParameterName
            {
             
            	        newCompositeNode(grammarAccess.getParameterTableHeaderAccess().getNameParameterNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_50);
            lv_name_1_0=ruleParameterName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getParameterTableHeaderRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"de.gebit.integrity.DSL.ParameterName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalDSL.g:2863:2: (otherlv_2= '|' )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==59) ) {
                int LA44_1 = input.LA(2);

                if ( (LA44_1==EOF||LA44_1==59) ) {
                    alt44=1;
                }
            }
            switch (alt44) {
                case 1 :
                    // InternalDSL.g:2863:4: otherlv_2= '|'
                    {
                    otherlv_2=(Token)match(input,59,FOLLOW_2); 

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
    // InternalDSL.g:2875:1: entryRuleResultTableHeader returns [EObject current=null] : iv_ruleResultTableHeader= ruleResultTableHeader EOF ;
    public final EObject entryRuleResultTableHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultTableHeader = null;


        try {
            // InternalDSL.g:2876:2: (iv_ruleResultTableHeader= ruleResultTableHeader EOF )
            // InternalDSL.g:2877:2: iv_ruleResultTableHeader= ruleResultTableHeader EOF
            {
             newCompositeNode(grammarAccess.getResultTableHeaderRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleResultTableHeader=ruleResultTableHeader();

            state._fsp--;

             current =iv_ruleResultTableHeader; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:2884:1: ruleResultTableHeader returns [EObject current=null] : (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' (otherlv_3= '|' )? ) ;
    public final EObject ruleResultTableHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:2887:28: ( (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' (otherlv_3= '|' )? ) )
            // InternalDSL.g:2888:1: (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' (otherlv_3= '|' )? )
            {
            // InternalDSL.g:2888:1: (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' (otherlv_3= '|' )? )
            // InternalDSL.g:2888:3: otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' (otherlv_3= '|' )?
            {
            otherlv_0=(Token)match(input,59,FOLLOW_47); 

                	newLeafNode(otherlv_0, grammarAccess.getResultTableHeaderAccess().getVerticalLineKeyword_0());
                
            // InternalDSL.g:2892:1: ( (lv_name_1_0= ruleResultName ) )
            // InternalDSL.g:2893:1: (lv_name_1_0= ruleResultName )
            {
            // InternalDSL.g:2893:1: (lv_name_1_0= ruleResultName )
            // InternalDSL.g:2894:3: lv_name_1_0= ruleResultName
            {
             
            	        newCompositeNode(grammarAccess.getResultTableHeaderAccess().getNameResultNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_48);
            lv_name_1_0=ruleResultName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getResultTableHeaderRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"de.gebit.integrity.DSL.ResultName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,57,FOLLOW_50); 

                	newLeafNode(otherlv_2, grammarAccess.getResultTableHeaderAccess().getEqualsSignKeyword_2());
                
            // InternalDSL.g:2914:1: (otherlv_3= '|' )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==59) ) {
                int LA45_1 = input.LA(2);

                if ( (LA45_1==EOF||LA45_1==59) ) {
                    alt45=1;
                }
            }
            switch (alt45) {
                case 1 :
                    // InternalDSL.g:2914:3: otherlv_3= '|'
                    {
                    otherlv_3=(Token)match(input,59,FOLLOW_2); 

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
    // InternalDSL.g:2926:1: entryRuleParameterTableValue returns [EObject current=null] : iv_ruleParameterTableValue= ruleParameterTableValue EOF ;
    public final EObject entryRuleParameterTableValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterTableValue = null;


        try {
            // InternalDSL.g:2927:2: (iv_ruleParameterTableValue= ruleParameterTableValue EOF )
            // InternalDSL.g:2928:2: iv_ruleParameterTableValue= ruleParameterTableValue EOF
            {
             newCompositeNode(grammarAccess.getParameterTableValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterTableValue=ruleParameterTableValue();

            state._fsp--;

             current =iv_ruleParameterTableValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:2935:1: ruleParameterTableValue returns [EObject current=null] : (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) ) (otherlv_2= '|' )? ) ;
    public final EObject ruleParameterTableValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:2938:28: ( (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) ) (otherlv_2= '|' )? ) )
            // InternalDSL.g:2939:1: (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) ) (otherlv_2= '|' )? )
            {
            // InternalDSL.g:2939:1: (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) ) (otherlv_2= '|' )? )
            // InternalDSL.g:2939:3: otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) ) (otherlv_2= '|' )?
            {
            otherlv_0=(Token)match(input,59,FOLLOW_17); 

                	newLeafNode(otherlv_0, grammarAccess.getParameterTableValueAccess().getVerticalLineKeyword_0());
                
            // InternalDSL.g:2943:1: ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) )
            // InternalDSL.g:2944:1: (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // InternalDSL.g:2944:1: (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection )
            // InternalDSL.g:2945:3: lv_value_1_0= ruleValueOrEnumValueOrOperationCollection
            {
             
            	        newCompositeNode(grammarAccess.getParameterTableValueAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_50);
            lv_value_1_0=ruleValueOrEnumValueOrOperationCollection();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getParameterTableValueRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_1_0, 
                    		"de.gebit.integrity.DSL.ValueOrEnumValueOrOperationCollection");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalDSL.g:2961:2: (otherlv_2= '|' )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==59) ) {
                int LA46_1 = input.LA(2);

                if ( (LA46_1==EOF||LA46_1==RULE_NEWLINE||LA46_1==59) ) {
                    alt46=1;
                }
            }
            switch (alt46) {
                case 1 :
                    // InternalDSL.g:2961:4: otherlv_2= '|'
                    {
                    otherlv_2=(Token)match(input,59,FOLLOW_2); 

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
    // InternalDSL.g:2973:1: entryRuleNamedResult returns [EObject current=null] : iv_ruleNamedResult= ruleNamedResult EOF ;
    public final EObject entryRuleNamedResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedResult = null;


        try {
            // InternalDSL.g:2974:2: (iv_ruleNamedResult= ruleNamedResult EOF )
            // InternalDSL.g:2975:2: iv_ruleNamedResult= ruleNamedResult EOF
            {
             newCompositeNode(grammarAccess.getNamedResultRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNamedResult=ruleNamedResult();

            state._fsp--;

             current =iv_ruleNamedResult; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:2982:1: ruleNamedResult returns [EObject current=null] : ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '=' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) ;
    public final EObject ruleNamedResult() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:2985:28: ( ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '=' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) )
            // InternalDSL.g:2986:1: ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '=' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            {
            // InternalDSL.g:2986:1: ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '=' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            // InternalDSL.g:2986:2: ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '=' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            {
            // InternalDSL.g:2986:2: ( (lv_name_0_0= ruleResultName ) )
            // InternalDSL.g:2987:1: (lv_name_0_0= ruleResultName )
            {
            // InternalDSL.g:2987:1: (lv_name_0_0= ruleResultName )
            // InternalDSL.g:2988:3: lv_name_0_0= ruleResultName
            {
             
            	        newCompositeNode(grammarAccess.getNamedResultAccess().getNameResultNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_51);
            lv_name_0_0=ruleResultName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNamedResultRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"de.gebit.integrity.DSL.ResultName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getNamedResultAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_48);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,57,FOLLOW_17); 

                	newLeafNode(otherlv_2, grammarAccess.getNamedResultAccess().getEqualsSignKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getNamedResultAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_17);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:3024:1: ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            // InternalDSL.g:3025:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // InternalDSL.g:3025:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            // InternalDSL.g:3026:3: lv_value_4_0= ruleValueOrEnumValueOrOperationCollection
            {
             
            	        newCompositeNode(grammarAccess.getNamedResultAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_value_4_0=ruleValueOrEnumValueOrOperationCollection();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNamedResultRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_4_0, 
                    		"de.gebit.integrity.DSL.ValueOrEnumValueOrOperationCollection");
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
    // InternalDSL.g:3050:1: entryRuleResultName returns [EObject current=null] : iv_ruleResultName= ruleResultName EOF ;
    public final EObject entryRuleResultName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultName = null;


        try {
            // InternalDSL.g:3051:2: (iv_ruleResultName= ruleResultName EOF )
            // InternalDSL.g:3052:2: iv_ruleResultName= ruleResultName EOF
            {
             newCompositeNode(grammarAccess.getResultNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleResultName=ruleResultName();

            state._fsp--;

             current =iv_ruleResultName; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:3059:1: ruleResultName returns [EObject current=null] : (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) ;
    public final EObject ruleResultName() throws RecognitionException {
        EObject current = null;

        EObject this_FixedResultName_0 = null;

        EObject this_ArbitraryParameterOrResultName_1 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:3062:28: ( (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) )
            // InternalDSL.g:3063:1: (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            {
            // InternalDSL.g:3063:1: (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==RULE_ID) ) {
                alt47=1;
            }
            else if ( (LA47_0==63) ) {
                alt47=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // InternalDSL.g:3064:5: this_FixedResultName_0= ruleFixedResultName
                    {
                     
                            newCompositeNode(grammarAccess.getResultNameAccess().getFixedResultNameParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_FixedResultName_0=ruleFixedResultName();

                    state._fsp--;

                     
                            current = this_FixedResultName_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalDSL.g:3074:5: this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName
                    {
                     
                            newCompositeNode(grammarAccess.getResultNameAccess().getArbitraryParameterOrResultNameParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
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
    // InternalDSL.g:3090:1: entryRuleFixedResultName returns [EObject current=null] : iv_ruleFixedResultName= ruleFixedResultName EOF ;
    public final EObject entryRuleFixedResultName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedResultName = null;


        try {
            // InternalDSL.g:3091:2: (iv_ruleFixedResultName= ruleFixedResultName EOF )
            // InternalDSL.g:3092:2: iv_ruleFixedResultName= ruleFixedResultName EOF
            {
             newCompositeNode(grammarAccess.getFixedResultNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFixedResultName=ruleFixedResultName();

            state._fsp--;

             current =iv_ruleFixedResultName; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:3099:1: ruleFixedResultName returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleFixedResultName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:3102:28: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalDSL.g:3103:1: ( (otherlv_0= RULE_ID ) )
            {
            // InternalDSL.g:3103:1: ( (otherlv_0= RULE_ID ) )
            // InternalDSL.g:3104:1: (otherlv_0= RULE_ID )
            {
            // InternalDSL.g:3104:1: (otherlv_0= RULE_ID )
            // InternalDSL.g:3105:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFixedResultNameRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

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
    // InternalDSL.g:3124:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // InternalDSL.g:3125:2: (iv_ruleCall= ruleCall EOF )
            // InternalDSL.g:3126:2: iv_ruleCall= ruleCall EOF
            {
             newCompositeNode(grammarAccess.getCallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCall=ruleCall();

            state._fsp--;

             current =iv_ruleCall; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:3133:1: ruleCall returns [EObject current=null] : (otherlv_0= 'call' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )* ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )? ruleNL ) ;
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
            // InternalDSL.g:3136:28: ( (otherlv_0= 'call' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )* ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )? ruleNL ) )
            // InternalDSL.g:3137:1: (otherlv_0= 'call' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )* ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )? ruleNL )
            {
            // InternalDSL.g:3137:1: (otherlv_0= 'call' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )* ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )? ruleNL )
            // InternalDSL.g:3137:3: otherlv_0= 'call' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )* ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )? ruleNL
            {
            otherlv_0=(Token)match(input,60,FOLLOW_52); 

                	newLeafNode(otherlv_0, grammarAccess.getCallAccess().getCallKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_52);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:3149:1: ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )?
            int alt48=2;
            alt48 = dfa48.predict(input);
            switch (alt48) {
                case 1 :
                    // InternalDSL.g:3149:2: ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL
                    {
                    // InternalDSL.g:3149:2: ( (lv_multiplier_2_0= ruleExecutionMultiplier ) )
                    // InternalDSL.g:3150:1: (lv_multiplier_2_0= ruleExecutionMultiplier )
                    {
                    // InternalDSL.g:3150:1: (lv_multiplier_2_0= ruleExecutionMultiplier )
                    // InternalDSL.g:3151:3: lv_multiplier_2_0= ruleExecutionMultiplier
                    {
                     
                    	        newCompositeNode(grammarAccess.getCallAccess().getMultiplierExecutionMultiplierParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_5);
                    lv_multiplier_2_0=ruleExecutionMultiplier();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCallRule());
                    	        }
                           		set(
                           			current, 
                           			"multiplier",
                            		lv_multiplier_2_0, 
                            		"de.gebit.integrity.DSL.ExecutionMultiplier");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_2_1()); 
                        
                    pushFollow(FOLLOW_5);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // InternalDSL.g:3175:3: ( ( ruleQualifiedName ) )
            // InternalDSL.g:3176:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:3176:1: ( ruleQualifiedName )
            // InternalDSL.g:3177:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCallRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getCallAccess().getDefinitionCallDefinitionCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_53);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalDSL.g:3190:2: ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )*
            loop49:
            do {
                int alt49=2;
                alt49 = dfa49.predict(input);
                switch (alt49) {
            	case 1 :
            	    // InternalDSL.g:3191:5: ruleNL ( (lv_parameters_6_0= ruleParameter ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_4_0()); 
            	        
            	    pushFollow(FOLLOW_47);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // InternalDSL.g:3198:1: ( (lv_parameters_6_0= ruleParameter ) )
            	    // InternalDSL.g:3199:1: (lv_parameters_6_0= ruleParameter )
            	    {
            	    // InternalDSL.g:3199:1: (lv_parameters_6_0= ruleParameter )
            	    // InternalDSL.g:3200:3: lv_parameters_6_0= ruleParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCallAccess().getParametersParameterParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_53);
            	    lv_parameters_6_0=ruleParameter();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCallRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"parameters",
            	            		lv_parameters_6_0, 
            	            		"de.gebit.integrity.DSL.Parameter");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);

            // InternalDSL.g:3216:4: ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )*
            loop50:
            do {
                int alt50=2;
                alt50 = dfa50.predict(input);
                switch (alt50) {
            	case 1 :
            	    // InternalDSL.g:3217:5: ruleNL ( (lv_results_8_0= ruleNamedCallResult ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_5_0()); 
            	        
            	    pushFollow(FOLLOW_47);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // InternalDSL.g:3224:1: ( (lv_results_8_0= ruleNamedCallResult ) )
            	    // InternalDSL.g:3225:1: (lv_results_8_0= ruleNamedCallResult )
            	    {
            	    // InternalDSL.g:3225:1: (lv_results_8_0= ruleNamedCallResult )
            	    // InternalDSL.g:3226:3: lv_results_8_0= ruleNamedCallResult
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCallAccess().getResultsNamedCallResultParserRuleCall_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_53);
            	    lv_results_8_0=ruleNamedCallResult();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCallRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"results",
            	            		lv_results_8_0, 
            	            		"de.gebit.integrity.DSL.NamedCallResult");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop50;
                }
            } while (true);

            // InternalDSL.g:3242:4: ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )?
            int alt51=2;
            alt51 = dfa51.predict(input);
            switch (alt51) {
                case 1 :
                    // InternalDSL.g:3243:5: ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) )
                    {
                     
                            newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_6_0()); 
                        
                    pushFollow(FOLLOW_43);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    otherlv_10=(Token)match(input,53,FOLLOW_5); 

                        	newLeafNode(otherlv_10, grammarAccess.getCallAccess().getHyphenMinusGreaterThanSignKeyword_6_1());
                        
                     
                            newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_6_2()); 
                        
                    pushFollow(FOLLOW_5);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalDSL.g:3262:1: ( (lv_result_12_0= ruleVariableVariable ) )
                    // InternalDSL.g:3263:1: (lv_result_12_0= ruleVariableVariable )
                    {
                    // InternalDSL.g:3263:1: (lv_result_12_0= ruleVariableVariable )
                    // InternalDSL.g:3264:3: lv_result_12_0= ruleVariableVariable
                    {
                     
                    	        newCompositeNode(grammarAccess.getCallAccess().getResultVariableVariableParserRuleCall_6_3_0()); 
                    	    
                    pushFollow(FOLLOW_4);
                    lv_result_12_0=ruleVariableVariable();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCallRule());
                    	        }
                           		set(
                           			current, 
                           			"result",
                            		lv_result_12_0, 
                            		"de.gebit.integrity.DSL.VariableVariable");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

             
                    newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_7()); 
                
            pushFollow(FOLLOW_2);
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
    // InternalDSL.g:3296:1: entryRuleNamedCallResult returns [EObject current=null] : iv_ruleNamedCallResult= ruleNamedCallResult EOF ;
    public final EObject entryRuleNamedCallResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedCallResult = null;


        try {
            // InternalDSL.g:3297:2: (iv_ruleNamedCallResult= ruleNamedCallResult EOF )
            // InternalDSL.g:3298:2: iv_ruleNamedCallResult= ruleNamedCallResult EOF
            {
             newCompositeNode(grammarAccess.getNamedCallResultRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNamedCallResult=ruleNamedCallResult();

            state._fsp--;

             current =iv_ruleNamedCallResult; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:3305:1: ruleNamedCallResult returns [EObject current=null] : ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) ) ;
    public final EObject ruleNamedCallResult() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_target_4_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:3308:28: ( ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) ) )
            // InternalDSL.g:3309:1: ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) )
            {
            // InternalDSL.g:3309:1: ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) )
            // InternalDSL.g:3309:2: ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) )
            {
            // InternalDSL.g:3309:2: ( (lv_name_0_0= ruleResultName ) )
            // InternalDSL.g:3310:1: (lv_name_0_0= ruleResultName )
            {
            // InternalDSL.g:3310:1: (lv_name_0_0= ruleResultName )
            // InternalDSL.g:3311:3: lv_name_0_0= ruleResultName
            {
             
            	        newCompositeNode(grammarAccess.getNamedCallResultAccess().getNameResultNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_42);
            lv_name_0_0=ruleResultName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNamedCallResultRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"de.gebit.integrity.DSL.ResultName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getNamedCallResultAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_43);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,53,FOLLOW_5); 

                	newLeafNode(otherlv_2, grammarAccess.getNamedCallResultAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getNamedCallResultAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_5);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:3347:1: ( (lv_target_4_0= ruleVariableVariable ) )
            // InternalDSL.g:3348:1: (lv_target_4_0= ruleVariableVariable )
            {
            // InternalDSL.g:3348:1: (lv_target_4_0= ruleVariableVariable )
            // InternalDSL.g:3349:3: lv_target_4_0= ruleVariableVariable
            {
             
            	        newCompositeNode(grammarAccess.getNamedCallResultAccess().getTargetVariableVariableParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_target_4_0=ruleVariableVariable();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNamedCallResultRule());
            	        }
                   		set(
                   			current, 
                   			"target",
                    		lv_target_4_0, 
                    		"de.gebit.integrity.DSL.VariableVariable");
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
    // InternalDSL.g:3373:1: entryRuleSuite returns [EObject current=null] : iv_ruleSuite= ruleSuite EOF ;
    public final EObject entryRuleSuite() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuite = null;


        try {
            // InternalDSL.g:3374:2: (iv_ruleSuite= ruleSuite EOF )
            // InternalDSL.g:3375:2: iv_ruleSuite= ruleSuite EOF
            {
             newCompositeNode(grammarAccess.getSuiteRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSuite=ruleSuite();

            state._fsp--;

             current =iv_ruleSuite; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:3382:1: ruleSuite returns [EObject current=null] : (otherlv_0= 'suite' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ruleNL ( ( (lv_parameters_6_0= ruleSuiteParameter ) ) ruleNL )* ( ( (lv_return_8_0= ruleSuiteReturn ) ) ruleNL )* (otherlv_10= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )? (otherlv_14= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ )? ) ;
    public final EObject ruleSuite() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_10=null;
        Token otherlv_14=null;
        EObject lv_multiplier_2_0 = null;

        EObject lv_parameters_6_0 = null;

        EObject lv_return_8_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:3385:28: ( (otherlv_0= 'suite' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ruleNL ( ( (lv_parameters_6_0= ruleSuiteParameter ) ) ruleNL )* ( ( (lv_return_8_0= ruleSuiteReturn ) ) ruleNL )* (otherlv_10= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )? (otherlv_14= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ )? ) )
            // InternalDSL.g:3386:1: (otherlv_0= 'suite' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ruleNL ( ( (lv_parameters_6_0= ruleSuiteParameter ) ) ruleNL )* ( ( (lv_return_8_0= ruleSuiteReturn ) ) ruleNL )* (otherlv_10= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )? (otherlv_14= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ )? )
            {
            // InternalDSL.g:3386:1: (otherlv_0= 'suite' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ruleNL ( ( (lv_parameters_6_0= ruleSuiteParameter ) ) ruleNL )* ( ( (lv_return_8_0= ruleSuiteReturn ) ) ruleNL )* (otherlv_10= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )? (otherlv_14= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ )? )
            // InternalDSL.g:3386:3: otherlv_0= 'suite' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ruleNL ( ( (lv_parameters_6_0= ruleSuiteParameter ) ) ruleNL )* ( ( (lv_return_8_0= ruleSuiteReturn ) ) ruleNL )* (otherlv_10= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )? (otherlv_14= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ )?
            {
            otherlv_0=(Token)match(input,61,FOLLOW_52); 

                	newLeafNode(otherlv_0, grammarAccess.getSuiteAccess().getSuiteKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_52);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:3398:1: ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )?
            int alt52=2;
            alt52 = dfa52.predict(input);
            switch (alt52) {
                case 1 :
                    // InternalDSL.g:3398:2: ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL
                    {
                    // InternalDSL.g:3398:2: ( (lv_multiplier_2_0= ruleExecutionMultiplier ) )
                    // InternalDSL.g:3399:1: (lv_multiplier_2_0= ruleExecutionMultiplier )
                    {
                    // InternalDSL.g:3399:1: (lv_multiplier_2_0= ruleExecutionMultiplier )
                    // InternalDSL.g:3400:3: lv_multiplier_2_0= ruleExecutionMultiplier
                    {
                     
                    	        newCompositeNode(grammarAccess.getSuiteAccess().getMultiplierExecutionMultiplierParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_5);
                    lv_multiplier_2_0=ruleExecutionMultiplier();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSuiteRule());
                    	        }
                           		set(
                           			current, 
                           			"multiplier",
                            		lv_multiplier_2_0, 
                            		"de.gebit.integrity.DSL.ExecutionMultiplier");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_2_1()); 
                        
                    pushFollow(FOLLOW_5);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // InternalDSL.g:3424:3: ( ( ruleQualifiedName ) )
            // InternalDSL.g:3425:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:3425:1: ( ruleQualifiedName )
            // InternalDSL.g:3426:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSuiteRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSuiteAccess().getDefinitionSuiteDefinitionCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_54);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_4()); 
                
            pushFollow(FOLLOW_55);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:3447:1: ( ( (lv_parameters_6_0= ruleSuiteParameter ) ) ruleNL )*
            loop53:
            do {
                int alt53=2;
                alt53 = dfa53.predict(input);
                switch (alt53) {
            	case 1 :
            	    // InternalDSL.g:3447:2: ( (lv_parameters_6_0= ruleSuiteParameter ) ) ruleNL
            	    {
            	    // InternalDSL.g:3447:2: ( (lv_parameters_6_0= ruleSuiteParameter ) )
            	    // InternalDSL.g:3448:1: (lv_parameters_6_0= ruleSuiteParameter )
            	    {
            	    // InternalDSL.g:3448:1: (lv_parameters_6_0= ruleSuiteParameter )
            	    // InternalDSL.g:3449:3: lv_parameters_6_0= ruleSuiteParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSuiteAccess().getParametersSuiteParameterParserRuleCall_5_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_54);
            	    lv_parameters_6_0=ruleSuiteParameter();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSuiteRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"parameters",
            	            		lv_parameters_6_0, 
            	            		"de.gebit.integrity.DSL.SuiteParameter");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	     
            	            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_5_1()); 
            	        
            	    pushFollow(FOLLOW_55);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);

            // InternalDSL.g:3473:3: ( ( (lv_return_8_0= ruleSuiteReturn ) ) ruleNL )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==RULE_ID) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalDSL.g:3473:4: ( (lv_return_8_0= ruleSuiteReturn ) ) ruleNL
            	    {
            	    // InternalDSL.g:3473:4: ( (lv_return_8_0= ruleSuiteReturn ) )
            	    // InternalDSL.g:3474:1: (lv_return_8_0= ruleSuiteReturn )
            	    {
            	    // InternalDSL.g:3474:1: (lv_return_8_0= ruleSuiteReturn )
            	    // InternalDSL.g:3475:3: lv_return_8_0= ruleSuiteReturn
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSuiteAccess().getReturnSuiteReturnParserRuleCall_6_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_54);
            	    lv_return_8_0=ruleSuiteReturn();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSuiteRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"return",
            	            		lv_return_8_0, 
            	            		"de.gebit.integrity.DSL.SuiteReturn");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	     
            	            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_6_1()); 
            	        
            	    pushFollow(FOLLOW_55);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            // InternalDSL.g:3499:3: (otherlv_10= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==62) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalDSL.g:3499:5: otherlv_10= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL
                    {
                    otherlv_10=(Token)match(input,62,FOLLOW_5); 

                        	newLeafNode(otherlv_10, grammarAccess.getSuiteAccess().getOnKeyword_7_0());
                        
                     
                            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_7_1()); 
                        
                    pushFollow(FOLLOW_5);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalDSL.g:3511:1: ( ( ruleQualifiedName ) )
                    // InternalDSL.g:3512:1: ( ruleQualifiedName )
                    {
                    // InternalDSL.g:3512:1: ( ruleQualifiedName )
                    // InternalDSL.g:3513:3: ruleQualifiedName
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSuiteRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getSuiteAccess().getForkForkDefinitionCrossReference_7_2_0()); 
                    	    
                    pushFollow(FOLLOW_56);
                    ruleQualifiedName();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_7_3()); 
                        
                    pushFollow(FOLLOW_57);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // InternalDSL.g:3534:3: (otherlv_14= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ )?
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==54) ) {
                alt57=1;
            }
            switch (alt57) {
                case 1 :
                    // InternalDSL.g:3534:5: otherlv_14= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+
                    {
                    otherlv_14=(Token)match(input,54,FOLLOW_5); 

                        	newLeafNode(otherlv_14, grammarAccess.getSuiteAccess().getInKeyword_8_0());
                        
                     
                            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_8_1()); 
                        
                    pushFollow(FOLLOW_5);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalDSL.g:3546:1: ( ( ( ruleQualifiedName ) ) ruleNL )+
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
                    	    // InternalDSL.g:3546:2: ( ( ruleQualifiedName ) ) ruleNL
                    	    {
                    	    // InternalDSL.g:3546:2: ( ( ruleQualifiedName ) )
                    	    // InternalDSL.g:3547:1: ( ruleQualifiedName )
                    	    {
                    	    // InternalDSL.g:3547:1: ( ruleQualifiedName )
                    	    // InternalDSL.g:3548:3: ruleQualifiedName
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSuiteRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteAccess().getVariantsVariantDefinitionCrossReference_8_2_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_5);
                    	    ruleQualifiedName();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	     
                    	            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_8_2_1()); 
                    	        
                    	    pushFollow(FOLLOW_58);
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
    // InternalDSL.g:3577:1: entryRuleSuiteParameter returns [EObject current=null] : iv_ruleSuiteParameter= ruleSuiteParameter EOF ;
    public final EObject entryRuleSuiteParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteParameter = null;


        try {
            // InternalDSL.g:3578:2: (iv_ruleSuiteParameter= ruleSuiteParameter EOF )
            // InternalDSL.g:3579:2: iv_ruleSuiteParameter= ruleSuiteParameter EOF
            {
             newCompositeNode(grammarAccess.getSuiteParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSuiteParameter=ruleSuiteParameter();

            state._fsp--;

             current =iv_ruleSuiteParameter; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:3586:1: ruleSuiteParameter returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) ;
    public final EObject ruleSuiteParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:3589:28: ( ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) )
            // InternalDSL.g:3590:1: ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            {
            // InternalDSL.g:3590:1: ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            // InternalDSL.g:3590:2: ( ( ruleQualifiedName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            {
            // InternalDSL.g:3590:2: ( ( ruleQualifiedName ) )
            // InternalDSL.g:3591:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:3591:1: ( ruleQualifiedName )
            // InternalDSL.g:3592:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSuiteParameterRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSuiteParameterAccess().getNameVariableOrConstantEntityCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_15);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getSuiteParameterAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_16);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,35,FOLLOW_17); 

                	newLeafNode(otherlv_2, grammarAccess.getSuiteParameterAccess().getColonKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getSuiteParameterAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_17);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:3625:1: ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            // InternalDSL.g:3626:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // InternalDSL.g:3626:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            // InternalDSL.g:3627:3: lv_value_4_0= ruleValueOrEnumValueOrOperationCollection
            {
             
            	        newCompositeNode(grammarAccess.getSuiteParameterAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_value_4_0=ruleValueOrEnumValueOrOperationCollection();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSuiteParameterRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_4_0, 
                    		"de.gebit.integrity.DSL.ValueOrEnumValueOrOperationCollection");
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


    // $ANTLR start "entryRuleSuiteReturn"
    // InternalDSL.g:3651:1: entryRuleSuiteReturn returns [EObject current=null] : iv_ruleSuiteReturn= ruleSuiteReturn EOF ;
    public final EObject entryRuleSuiteReturn() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteReturn = null;


        try {
            // InternalDSL.g:3652:2: (iv_ruleSuiteReturn= ruleSuiteReturn EOF )
            // InternalDSL.g:3653:2: iv_ruleSuiteReturn= ruleSuiteReturn EOF
            {
             newCompositeNode(grammarAccess.getSuiteReturnRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSuiteReturn=ruleSuiteReturn();

            state._fsp--;

             current =iv_ruleSuiteReturn; 
            match(input,EOF,FOLLOW_2); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSuiteReturn"


    // $ANTLR start "ruleSuiteReturn"
    // InternalDSL.g:3660:1: ruleSuiteReturn returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) ) ;
    public final EObject ruleSuiteReturn() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_target_4_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:3663:28: ( ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) ) )
            // InternalDSL.g:3664:1: ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) )
            {
            // InternalDSL.g:3664:1: ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) )
            // InternalDSL.g:3664:2: ( ( ruleQualifiedName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) )
            {
            // InternalDSL.g:3664:2: ( ( ruleQualifiedName ) )
            // InternalDSL.g:3665:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:3665:1: ( ruleQualifiedName )
            // InternalDSL.g:3666:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSuiteReturnRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSuiteReturnAccess().getNameSuiteReturnDefinitionCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_42);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getSuiteReturnAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_43);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,53,FOLLOW_5); 

                	newLeafNode(otherlv_2, grammarAccess.getSuiteReturnAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getSuiteReturnAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_5);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:3699:1: ( (lv_target_4_0= ruleVariableVariable ) )
            // InternalDSL.g:3700:1: (lv_target_4_0= ruleVariableVariable )
            {
            // InternalDSL.g:3700:1: (lv_target_4_0= ruleVariableVariable )
            // InternalDSL.g:3701:3: lv_target_4_0= ruleVariableVariable
            {
             
            	        newCompositeNode(grammarAccess.getSuiteReturnAccess().getTargetVariableVariableParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_target_4_0=ruleVariableVariable();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSuiteReturnRule());
            	        }
                   		set(
                   			current, 
                   			"target",
                    		lv_target_4_0, 
                    		"de.gebit.integrity.DSL.VariableVariable");
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
    // $ANTLR end "ruleSuiteReturn"


    // $ANTLR start "entryRuleParameter"
    // InternalDSL.g:3725:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalDSL.g:3726:2: (iv_ruleParameter= ruleParameter EOF )
            // InternalDSL.g:3727:2: iv_ruleParameter= ruleParameter EOF
            {
             newCompositeNode(grammarAccess.getParameterRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;

             current =iv_ruleParameter; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:3734:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= ruleParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:3737:28: ( ( ( (lv_name_0_0= ruleParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) )
            // InternalDSL.g:3738:1: ( ( (lv_name_0_0= ruleParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            {
            // InternalDSL.g:3738:1: ( ( (lv_name_0_0= ruleParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            // InternalDSL.g:3738:2: ( (lv_name_0_0= ruleParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            {
            // InternalDSL.g:3738:2: ( (lv_name_0_0= ruleParameterName ) )
            // InternalDSL.g:3739:1: (lv_name_0_0= ruleParameterName )
            {
            // InternalDSL.g:3739:1: (lv_name_0_0= ruleParameterName )
            // InternalDSL.g:3740:3: lv_name_0_0= ruleParameterName
            {
             
            	        newCompositeNode(grammarAccess.getParameterAccess().getNameParameterNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_15);
            lv_name_0_0=ruleParameterName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getParameterRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"de.gebit.integrity.DSL.ParameterName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getParameterAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_16);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,35,FOLLOW_17); 

                	newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getColonKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getParameterAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_17);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:3776:1: ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            // InternalDSL.g:3777:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // InternalDSL.g:3777:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            // InternalDSL.g:3778:3: lv_value_4_0= ruleValueOrEnumValueOrOperationCollection
            {
             
            	        newCompositeNode(grammarAccess.getParameterAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_value_4_0=ruleValueOrEnumValueOrOperationCollection();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getParameterRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_4_0, 
                    		"de.gebit.integrity.DSL.ValueOrEnumValueOrOperationCollection");
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
    // InternalDSL.g:3802:1: entryRuleParameterName returns [EObject current=null] : iv_ruleParameterName= ruleParameterName EOF ;
    public final EObject entryRuleParameterName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterName = null;


        try {
            // InternalDSL.g:3803:2: (iv_ruleParameterName= ruleParameterName EOF )
            // InternalDSL.g:3804:2: iv_ruleParameterName= ruleParameterName EOF
            {
             newCompositeNode(grammarAccess.getParameterNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParameterName=ruleParameterName();

            state._fsp--;

             current =iv_ruleParameterName; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:3811:1: ruleParameterName returns [EObject current=null] : (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) ;
    public final EObject ruleParameterName() throws RecognitionException {
        EObject current = null;

        EObject this_FixedParameterName_0 = null;

        EObject this_ArbitraryParameterOrResultName_1 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:3814:28: ( (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) )
            // InternalDSL.g:3815:1: (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            {
            // InternalDSL.g:3815:1: (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==RULE_ID) ) {
                alt58=1;
            }
            else if ( (LA58_0==63) ) {
                alt58=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // InternalDSL.g:3816:5: this_FixedParameterName_0= ruleFixedParameterName
                    {
                     
                            newCompositeNode(grammarAccess.getParameterNameAccess().getFixedParameterNameParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_FixedParameterName_0=ruleFixedParameterName();

                    state._fsp--;

                     
                            current = this_FixedParameterName_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalDSL.g:3826:5: this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName
                    {
                     
                            newCompositeNode(grammarAccess.getParameterNameAccess().getArbitraryParameterOrResultNameParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
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
    // InternalDSL.g:3842:1: entryRuleFixedParameterName returns [EObject current=null] : iv_ruleFixedParameterName= ruleFixedParameterName EOF ;
    public final EObject entryRuleFixedParameterName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedParameterName = null;


        try {
            // InternalDSL.g:3843:2: (iv_ruleFixedParameterName= ruleFixedParameterName EOF )
            // InternalDSL.g:3844:2: iv_ruleFixedParameterName= ruleFixedParameterName EOF
            {
             newCompositeNode(grammarAccess.getFixedParameterNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFixedParameterName=ruleFixedParameterName();

            state._fsp--;

             current =iv_ruleFixedParameterName; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:3851:1: ruleFixedParameterName returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleFixedParameterName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:3854:28: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalDSL.g:3855:1: ( (otherlv_0= RULE_ID ) )
            {
            // InternalDSL.g:3855:1: ( (otherlv_0= RULE_ID ) )
            // InternalDSL.g:3856:1: (otherlv_0= RULE_ID )
            {
            // InternalDSL.g:3856:1: (otherlv_0= RULE_ID )
            // InternalDSL.g:3857:3: otherlv_0= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFixedParameterNameRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

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
    // InternalDSL.g:3876:1: entryRuleArbitraryParameterOrResultName returns [EObject current=null] : iv_ruleArbitraryParameterOrResultName= ruleArbitraryParameterOrResultName EOF ;
    public final EObject entryRuleArbitraryParameterOrResultName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArbitraryParameterOrResultName = null;


        try {
            // InternalDSL.g:3877:2: (iv_ruleArbitraryParameterOrResultName= ruleArbitraryParameterOrResultName EOF )
            // InternalDSL.g:3878:2: iv_ruleArbitraryParameterOrResultName= ruleArbitraryParameterOrResultName EOF
            {
             newCompositeNode(grammarAccess.getArbitraryParameterOrResultNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArbitraryParameterOrResultName=ruleArbitraryParameterOrResultName();

            state._fsp--;

             current =iv_ruleArbitraryParameterOrResultName; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:3885:1: ruleArbitraryParameterOrResultName returns [EObject current=null] : (otherlv_0= '+' ( ( (lv_identifier_1_0= RULE_ID ) ) | ( (lv_stringIdentifier_2_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleArbitraryParameterOrResultName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_identifier_1_0=null;
        Token lv_stringIdentifier_2_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:3888:28: ( (otherlv_0= '+' ( ( (lv_identifier_1_0= RULE_ID ) ) | ( (lv_stringIdentifier_2_0= RULE_STRING ) ) ) ) )
            // InternalDSL.g:3889:1: (otherlv_0= '+' ( ( (lv_identifier_1_0= RULE_ID ) ) | ( (lv_stringIdentifier_2_0= RULE_STRING ) ) ) )
            {
            // InternalDSL.g:3889:1: (otherlv_0= '+' ( ( (lv_identifier_1_0= RULE_ID ) ) | ( (lv_stringIdentifier_2_0= RULE_STRING ) ) ) )
            // InternalDSL.g:3889:3: otherlv_0= '+' ( ( (lv_identifier_1_0= RULE_ID ) ) | ( (lv_stringIdentifier_2_0= RULE_STRING ) ) )
            {
            otherlv_0=(Token)match(input,63,FOLLOW_59); 

                	newLeafNode(otherlv_0, grammarAccess.getArbitraryParameterOrResultNameAccess().getPlusSignKeyword_0());
                
            // InternalDSL.g:3893:1: ( ( (lv_identifier_1_0= RULE_ID ) ) | ( (lv_stringIdentifier_2_0= RULE_STRING ) ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==RULE_ID) ) {
                alt59=1;
            }
            else if ( (LA59_0==RULE_STRING) ) {
                alt59=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // InternalDSL.g:3893:2: ( (lv_identifier_1_0= RULE_ID ) )
                    {
                    // InternalDSL.g:3893:2: ( (lv_identifier_1_0= RULE_ID ) )
                    // InternalDSL.g:3894:1: (lv_identifier_1_0= RULE_ID )
                    {
                    // InternalDSL.g:3894:1: (lv_identifier_1_0= RULE_ID )
                    // InternalDSL.g:3895:3: lv_identifier_1_0= RULE_ID
                    {
                    lv_identifier_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			newLeafNode(lv_identifier_1_0, grammarAccess.getArbitraryParameterOrResultNameAccess().getIdentifierIDTerminalRuleCall_1_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getArbitraryParameterOrResultNameRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"identifier",
                            		lv_identifier_1_0, 
                            		"de.gebit.integrity.DSL.ID");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalDSL.g:3912:6: ( (lv_stringIdentifier_2_0= RULE_STRING ) )
                    {
                    // InternalDSL.g:3912:6: ( (lv_stringIdentifier_2_0= RULE_STRING ) )
                    // InternalDSL.g:3913:1: (lv_stringIdentifier_2_0= RULE_STRING )
                    {
                    // InternalDSL.g:3913:1: (lv_stringIdentifier_2_0= RULE_STRING )
                    // InternalDSL.g:3914:3: lv_stringIdentifier_2_0= RULE_STRING
                    {
                    lv_stringIdentifier_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			newLeafNode(lv_stringIdentifier_2_0, grammarAccess.getArbitraryParameterOrResultNameAccess().getStringIdentifierSTRINGTerminalRuleCall_1_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getArbitraryParameterOrResultNameRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"stringIdentifier",
                            		lv_stringIdentifier_2_0, 
                            		"de.gebit.integrity.DSL.STRING");
                    	    

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
    // InternalDSL.g:3938:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // InternalDSL.g:3939:2: (iv_ruleOperation= ruleOperation EOF )
            // InternalDSL.g:3940:2: iv_ruleOperation= ruleOperation EOF
            {
             newCompositeNode(grammarAccess.getOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperation=ruleOperation();

            state._fsp--;

             current =iv_ruleOperation; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:3947:1: ruleOperation returns [EObject current=null] : (this_StandardOperation_0= ruleStandardOperation | this_CustomOperation_1= ruleCustomOperation ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        EObject this_StandardOperation_0 = null;

        EObject this_CustomOperation_1 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:3950:28: ( (this_StandardOperation_0= ruleStandardOperation | this_CustomOperation_1= ruleCustomOperation ) )
            // InternalDSL.g:3951:1: (this_StandardOperation_0= ruleStandardOperation | this_CustomOperation_1= ruleCustomOperation )
            {
            // InternalDSL.g:3951:1: (this_StandardOperation_0= ruleStandardOperation | this_CustomOperation_1= ruleCustomOperation )
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==64) ) {
                alt60=1;
            }
            else if ( (LA60_0==71) ) {
                alt60=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }
            switch (alt60) {
                case 1 :
                    // InternalDSL.g:3952:5: this_StandardOperation_0= ruleStandardOperation
                    {
                     
                            newCompositeNode(grammarAccess.getOperationAccess().getStandardOperationParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_StandardOperation_0=ruleStandardOperation();

                    state._fsp--;

                     
                            current = this_StandardOperation_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalDSL.g:3962:5: this_CustomOperation_1= ruleCustomOperation
                    {
                     
                            newCompositeNode(grammarAccess.getOperationAccess().getCustomOperationParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
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
    // InternalDSL.g:3978:1: entryRuleStandardOperation returns [EObject current=null] : iv_ruleStandardOperation= ruleStandardOperation EOF ;
    public final EObject entryRuleStandardOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStandardOperation = null;


        try {
            // InternalDSL.g:3979:2: (iv_ruleStandardOperation= ruleStandardOperation EOF )
            // InternalDSL.g:3980:2: iv_ruleStandardOperation= ruleStandardOperation EOF
            {
             newCompositeNode(grammarAccess.getStandardOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStandardOperation=ruleStandardOperation();

            state._fsp--;

             current =iv_ruleStandardOperation; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:3987:1: ruleStandardOperation returns [EObject current=null] : (otherlv_0= '(' ruleNL ( (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL )+ otherlv_8= ')' ) ;
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
            // InternalDSL.g:3990:28: ( (otherlv_0= '(' ruleNL ( (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL )+ otherlv_8= ')' ) )
            // InternalDSL.g:3991:1: (otherlv_0= '(' ruleNL ( (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL )+ otherlv_8= ')' )
            {
            // InternalDSL.g:3991:1: (otherlv_0= '(' ruleNL ( (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL )+ otherlv_8= ')' )
            // InternalDSL.g:3991:3: otherlv_0= '(' ruleNL ( (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL )+ otherlv_8= ')'
            {
            otherlv_0=(Token)match(input,64,FOLLOW_17); 

                	newLeafNode(otherlv_0, grammarAccess.getStandardOperationAccess().getLeftParenthesisKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getStandardOperationAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_17);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:4003:1: ( (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation ) )
            // InternalDSL.g:4004:1: (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation )
            {
            // InternalDSL.g:4004:1: (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation )
            // InternalDSL.g:4005:3: lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation
            {
             
            	        newCompositeNode(grammarAccess.getStandardOperationAccess().getFirstOperandValueOrEnumValueOrOperationParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_60);
            lv_firstOperand_2_0=ruleValueOrEnumValueOrOperation();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getStandardOperationRule());
            	        }
                   		set(
                   			current, 
                   			"firstOperand",
                    		lv_firstOperand_2_0, 
                    		"de.gebit.integrity.DSL.ValueOrEnumValueOrOperation");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getStandardOperationAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_61);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:4029:1: ( ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL )+
            int cnt62=0;
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==63||(LA62_0>=65 && LA62_0<=69)) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalDSL.g:4029:2: ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL
            	    {
            	    // InternalDSL.g:4029:2: ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) )
            	    // InternalDSL.g:4030:1: ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) )
            	    {
            	    // InternalDSL.g:4030:1: ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) )
            	    // InternalDSL.g:4031:1: (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' )
            	    {
            	    // InternalDSL.g:4031:1: (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' )
            	    int alt61=6;
            	    switch ( input.LA(1) ) {
            	    case 63:
            	        {
            	        alt61=1;
            	        }
            	        break;
            	    case 65:
            	        {
            	        alt61=2;
            	        }
            	        break;
            	    case 66:
            	        {
            	        alt61=3;
            	        }
            	        break;
            	    case 67:
            	        {
            	        alt61=4;
            	        }
            	        break;
            	    case 68:
            	        {
            	        alt61=5;
            	        }
            	        break;
            	    case 69:
            	        {
            	        alt61=6;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 61, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt61) {
            	        case 1 :
            	            // InternalDSL.g:4032:3: lv_operators_4_1= '+'
            	            {
            	            lv_operators_4_1=(Token)match(input,63,FOLLOW_17); 

            	                    newLeafNode(lv_operators_4_1, grammarAccess.getStandardOperationAccess().getOperatorsPlusSignKeyword_4_0_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getStandardOperationRule());
            	            	        }
            	                   		addWithLastConsumed(current, "operators", lv_operators_4_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // InternalDSL.g:4044:8: lv_operators_4_2= '-'
            	            {
            	            lv_operators_4_2=(Token)match(input,65,FOLLOW_17); 

            	                    newLeafNode(lv_operators_4_2, grammarAccess.getStandardOperationAccess().getOperatorsHyphenMinusKeyword_4_0_0_1());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getStandardOperationRule());
            	            	        }
            	                   		addWithLastConsumed(current, "operators", lv_operators_4_2, null);
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // InternalDSL.g:4056:8: lv_operators_4_3= '*'
            	            {
            	            lv_operators_4_3=(Token)match(input,66,FOLLOW_17); 

            	                    newLeafNode(lv_operators_4_3, grammarAccess.getStandardOperationAccess().getOperatorsAsteriskKeyword_4_0_0_2());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getStandardOperationRule());
            	            	        }
            	                   		addWithLastConsumed(current, "operators", lv_operators_4_3, null);
            	            	    

            	            }
            	            break;
            	        case 4 :
            	            // InternalDSL.g:4068:8: lv_operators_4_4= '/'
            	            {
            	            lv_operators_4_4=(Token)match(input,67,FOLLOW_17); 

            	                    newLeafNode(lv_operators_4_4, grammarAccess.getStandardOperationAccess().getOperatorsSolidusKeyword_4_0_0_3());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getStandardOperationRule());
            	            	        }
            	                   		addWithLastConsumed(current, "operators", lv_operators_4_4, null);
            	            	    

            	            }
            	            break;
            	        case 5 :
            	            // InternalDSL.g:4080:8: lv_operators_4_5= '%'
            	            {
            	            lv_operators_4_5=(Token)match(input,68,FOLLOW_17); 

            	                    newLeafNode(lv_operators_4_5, grammarAccess.getStandardOperationAccess().getOperatorsPercentSignKeyword_4_0_0_4());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getStandardOperationRule());
            	            	        }
            	                   		addWithLastConsumed(current, "operators", lv_operators_4_5, null);
            	            	    

            	            }
            	            break;
            	        case 6 :
            	            // InternalDSL.g:4092:8: lv_operators_4_6= '..'
            	            {
            	            lv_operators_4_6=(Token)match(input,69,FOLLOW_17); 

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
            	        
            	    pushFollow(FOLLOW_17);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // InternalDSL.g:4115:1: ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) )
            	    // InternalDSL.g:4116:1: (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation )
            	    {
            	    // InternalDSL.g:4116:1: (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation )
            	    // InternalDSL.g:4117:3: lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStandardOperationAccess().getMoreOperandsValueOrEnumValueOrOperationParserRuleCall_4_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_62);
            	    lv_moreOperands_6_0=ruleValueOrEnumValueOrOperation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getStandardOperationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"moreOperands",
            	            		lv_moreOperands_6_0, 
            	            		"de.gebit.integrity.DSL.ValueOrEnumValueOrOperation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	     
            	            newCompositeNode(grammarAccess.getStandardOperationAccess().getNLParserRuleCall_4_3()); 
            	        
            	    pushFollow(FOLLOW_63);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt62 >= 1 ) break loop62;
                        EarlyExitException eee =
                            new EarlyExitException(62, input);
                        throw eee;
                }
                cnt62++;
            } while (true);

            otherlv_8=(Token)match(input,70,FOLLOW_2); 

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
    // InternalDSL.g:4153:1: entryRuleCustomOperation returns [EObject current=null] : iv_ruleCustomOperation= ruleCustomOperation EOF ;
    public final EObject entryRuleCustomOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCustomOperation = null;


        try {
            // InternalDSL.g:4154:2: (iv_ruleCustomOperation= ruleCustomOperation EOF )
            // InternalDSL.g:4155:2: iv_ruleCustomOperation= ruleCustomOperation EOF
            {
             newCompositeNode(grammarAccess.getCustomOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCustomOperation=ruleCustomOperation();

            state._fsp--;

             current =iv_ruleCustomOperation; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:4162:1: ruleCustomOperation returns [EObject current=null] : (otherlv_0= '[' ruleNL ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL otherlv_9= ']' ) ;
    public final EObject ruleCustomOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        EObject lv_prefixOperand_2_0 = null;

        EObject lv_postfixOperand_7_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:4165:28: ( (otherlv_0= '[' ruleNL ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL otherlv_9= ']' ) )
            // InternalDSL.g:4166:1: (otherlv_0= '[' ruleNL ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL otherlv_9= ']' )
            {
            // InternalDSL.g:4166:1: (otherlv_0= '[' ruleNL ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL otherlv_9= ']' )
            // InternalDSL.g:4166:3: otherlv_0= '[' ruleNL ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL otherlv_9= ']'
            {
            otherlv_0=(Token)match(input,71,FOLLOW_17); 

                	newLeafNode(otherlv_0, grammarAccess.getCustomOperationAccess().getLeftSquareBracketKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getCustomOperationAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_17);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:4178:1: ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )?
            int alt63=2;
            alt63 = dfa63.predict(input);
            switch (alt63) {
                case 1 :
                    // InternalDSL.g:4178:2: ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL
                    {
                    // InternalDSL.g:4178:2: ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) )
                    // InternalDSL.g:4179:1: (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection )
                    {
                    // InternalDSL.g:4179:1: (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection )
                    // InternalDSL.g:4180:3: lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection
                    {
                     
                    	        newCompositeNode(grammarAccess.getCustomOperationAccess().getPrefixOperandValueOrEnumValueOrOperationCollectionParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_5);
                    lv_prefixOperand_2_0=ruleValueOrEnumValueOrOperationCollection();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCustomOperationRule());
                    	        }
                           		set(
                           			current, 
                           			"prefixOperand",
                            		lv_prefixOperand_2_0, 
                            		"de.gebit.integrity.DSL.ValueOrEnumValueOrOperationCollection");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getCustomOperationAccess().getNLParserRuleCall_2_1()); 
                        
                    pushFollow(FOLLOW_5);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // InternalDSL.g:4204:3: ( ( ruleQualifiedName ) )
            // InternalDSL.g:4205:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:4205:1: ( ruleQualifiedName )
            // InternalDSL.g:4206:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCustomOperationRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getCustomOperationAccess().getDefinitionOperationDefinitionCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_64);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalDSL.g:4219:2: ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )?
            int alt64=2;
            alt64 = dfa64.predict(input);
            switch (alt64) {
                case 1 :
                    // InternalDSL.g:4220:5: ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) )
                    {
                     
                            newCompositeNode(grammarAccess.getCustomOperationAccess().getNLParserRuleCall_4_0()); 
                        
                    pushFollow(FOLLOW_6);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    otherlv_6=(Token)match(input,29,FOLLOW_17); 

                        	newLeafNode(otherlv_6, grammarAccess.getCustomOperationAccess().getWithKeyword_4_1());
                        
                    // InternalDSL.g:4231:1: ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) )
                    // InternalDSL.g:4232:1: (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection )
                    {
                    // InternalDSL.g:4232:1: (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection )
                    // InternalDSL.g:4233:3: lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection
                    {
                     
                    	        newCompositeNode(grammarAccess.getCustomOperationAccess().getPostfixOperandValueOrEnumValueOrOperationCollectionParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FOLLOW_65);
                    lv_postfixOperand_7_0=ruleValueOrEnumValueOrOperationCollection();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCustomOperationRule());
                    	        }
                           		set(
                           			current, 
                           			"postfixOperand",
                            		lv_postfixOperand_7_0, 
                            		"de.gebit.integrity.DSL.ValueOrEnumValueOrOperationCollection");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

             
                    newCompositeNode(grammarAccess.getCustomOperationAccess().getNLParserRuleCall_5()); 
                
            pushFollow(FOLLOW_66);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_9=(Token)match(input,72,FOLLOW_2); 

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
    // InternalDSL.g:4269:1: entryRuleValueOrEnumValueOrOperationCollection returns [EObject current=null] : iv_ruleValueOrEnumValueOrOperationCollection= ruleValueOrEnumValueOrOperationCollection EOF ;
    public final EObject entryRuleValueOrEnumValueOrOperationCollection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueOrEnumValueOrOperationCollection = null;


        try {
            // InternalDSL.g:4270:2: (iv_ruleValueOrEnumValueOrOperationCollection= ruleValueOrEnumValueOrOperationCollection EOF )
            // InternalDSL.g:4271:2: iv_ruleValueOrEnumValueOrOperationCollection= ruleValueOrEnumValueOrOperationCollection EOF
            {
             newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationCollectionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValueOrEnumValueOrOperationCollection=ruleValueOrEnumValueOrOperationCollection();

            state._fsp--;

             current =iv_ruleValueOrEnumValueOrOperationCollection; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:4278:1: ruleValueOrEnumValueOrOperationCollection returns [EObject current=null] : ( ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) ) ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )* ) ;
    public final EObject ruleValueOrEnumValueOrOperationCollection() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_value_0_0 = null;

        EObject lv_moreValues_4_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:4281:28: ( ( ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) ) ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )* ) )
            // InternalDSL.g:4282:1: ( ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) ) ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )* )
            {
            // InternalDSL.g:4282:1: ( ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) ) ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )* )
            // InternalDSL.g:4282:2: ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) ) ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )*
            {
            // InternalDSL.g:4282:2: ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) )
            // InternalDSL.g:4283:1: (lv_value_0_0= ruleValueOrEnumValueOrOperation )
            {
            // InternalDSL.g:4283:1: (lv_value_0_0= ruleValueOrEnumValueOrOperation )
            // InternalDSL.g:4284:3: lv_value_0_0= ruleValueOrEnumValueOrOperation
            {
             
            	        newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getValueValueOrEnumValueOrOperationParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_67);
            lv_value_0_0=ruleValueOrEnumValueOrOperation();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getValueOrEnumValueOrOperationCollectionRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"de.gebit.integrity.DSL.ValueOrEnumValueOrOperation");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalDSL.g:4300:2: ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )*
            loop65:
            do {
                int alt65=2;
                alt65 = dfa65.predict(input);
                switch (alt65) {
            	case 1 :
            	    // InternalDSL.g:4301:5: ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getNLParserRuleCall_1_0()); 
            	        
            	    pushFollow(FOLLOW_68);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    otherlv_2=(Token)match(input,73,FOLLOW_17); 

            	        	newLeafNode(otherlv_2, grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getCommaKeyword_1_1());
            	        
            	     
            	            newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getNLParserRuleCall_1_2()); 
            	        
            	    pushFollow(FOLLOW_17);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // InternalDSL.g:4320:1: ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) )
            	    // InternalDSL.g:4321:1: (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation )
            	    {
            	    // InternalDSL.g:4321:1: (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation )
            	    // InternalDSL.g:4322:3: lv_moreValues_4_0= ruleValueOrEnumValueOrOperation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getMoreValuesValueOrEnumValueOrOperationParserRuleCall_1_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_67);
            	    lv_moreValues_4_0=ruleValueOrEnumValueOrOperation();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getValueOrEnumValueOrOperationCollectionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"moreValues",
            	            		lv_moreValues_4_0, 
            	            		"de.gebit.integrity.DSL.ValueOrEnumValueOrOperation");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop65;
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
    // InternalDSL.g:4346:1: entryRuleValueOrEnumValueOrOperation returns [EObject current=null] : iv_ruleValueOrEnumValueOrOperation= ruleValueOrEnumValueOrOperation EOF ;
    public final EObject entryRuleValueOrEnumValueOrOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueOrEnumValueOrOperation = null;


        try {
            // InternalDSL.g:4347:2: (iv_ruleValueOrEnumValueOrOperation= ruleValueOrEnumValueOrOperation EOF )
            // InternalDSL.g:4348:2: iv_ruleValueOrEnumValueOrOperation= ruleValueOrEnumValueOrOperation EOF
            {
             newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValueOrEnumValueOrOperation=ruleValueOrEnumValueOrOperation();

            state._fsp--;

             current =iv_ruleValueOrEnumValueOrOperation; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:4355:1: ruleValueOrEnumValueOrOperation returns [EObject current=null] : (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue | this_Operation_2= ruleOperation ) ;
    public final EObject ruleValueOrEnumValueOrOperation() throws RecognitionException {
        EObject current = null;

        EObject this_Value_0 = null;

        EObject this_EnumValue_1 = null;

        EObject this_Operation_2 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:4358:28: ( (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue | this_Operation_2= ruleOperation ) )
            // InternalDSL.g:4359:1: (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue | this_Operation_2= ruleOperation )
            {
            // InternalDSL.g:4359:1: (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue | this_Operation_2= ruleOperation )
            int alt66=3;
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
            case 74:
            case 77:
            case 78:
                {
                alt66=1;
                }
                break;
            case RULE_UPPERCASE_ID:
                {
                alt66=2;
                }
                break;
            case 64:
            case 71:
                {
                alt66=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }

            switch (alt66) {
                case 1 :
                    // InternalDSL.g:4360:5: this_Value_0= ruleValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationAccess().getValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Value_0=ruleValue();

                    state._fsp--;

                     
                            current = this_Value_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalDSL.g:4370:5: this_EnumValue_1= ruleEnumValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationAccess().getEnumValueParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_EnumValue_1=ruleEnumValue();

                    state._fsp--;

                     
                            current = this_EnumValue_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalDSL.g:4380:5: this_Operation_2= ruleOperation
                    {
                     
                            newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationAccess().getOperationParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
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
    // InternalDSL.g:4396:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // InternalDSL.g:4397:2: (iv_ruleValue= ruleValue EOF )
            // InternalDSL.g:4398:2: iv_ruleValue= ruleValue EOF
            {
             newCompositeNode(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValue=ruleValue();

            state._fsp--;

             current =iv_ruleValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:4405:1: ruleValue returns [EObject current=null] : (this_StaticValue_0= ruleStaticValue | this_Variable_1= ruleVariable | this_NestedObject_2= ruleNestedObject | this_TypedNestedObject_3= ruleTypedNestedObject ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        EObject this_StaticValue_0 = null;

        EObject this_Variable_1 = null;

        EObject this_NestedObject_2 = null;

        EObject this_TypedNestedObject_3 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:4408:28: ( (this_StaticValue_0= ruleStaticValue | this_Variable_1= ruleVariable | this_NestedObject_2= ruleNestedObject | this_TypedNestedObject_3= ruleTypedNestedObject ) )
            // InternalDSL.g:4409:1: (this_StaticValue_0= ruleStaticValue | this_Variable_1= ruleVariable | this_NestedObject_2= ruleNestedObject | this_TypedNestedObject_3= ruleTypedNestedObject )
            {
            // InternalDSL.g:4409:1: (this_StaticValue_0= ruleStaticValue | this_Variable_1= ruleVariable | this_NestedObject_2= ruleNestedObject | this_TypedNestedObject_3= ruleTypedNestedObject )
            int alt67=4;
            alt67 = dfa67.predict(input);
            switch (alt67) {
                case 1 :
                    // InternalDSL.g:4410:5: this_StaticValue_0= ruleStaticValue
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getStaticValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_StaticValue_0=ruleStaticValue();

                    state._fsp--;

                     
                            current = this_StaticValue_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalDSL.g:4420:5: this_Variable_1= ruleVariable
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getVariableParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Variable_1=ruleVariable();

                    state._fsp--;

                     
                            current = this_Variable_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalDSL.g:4430:5: this_NestedObject_2= ruleNestedObject
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getNestedObjectParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_NestedObject_2=ruleNestedObject();

                    state._fsp--;

                     
                            current = this_NestedObject_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalDSL.g:4440:5: this_TypedNestedObject_3= ruleTypedNestedObject
                    {
                     
                            newCompositeNode(grammarAccess.getValueAccess().getTypedNestedObjectParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_2);
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
    // InternalDSL.g:4456:1: entryRuleConstantValue returns [EObject current=null] : iv_ruleConstantValue= ruleConstantValue EOF ;
    public final EObject entryRuleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantValue = null;


        try {
            // InternalDSL.g:4457:2: (iv_ruleConstantValue= ruleConstantValue EOF )
            // InternalDSL.g:4458:2: iv_ruleConstantValue= ruleConstantValue EOF
            {
             newCompositeNode(grammarAccess.getConstantValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstantValue=ruleConstantValue();

            state._fsp--;

             current =iv_ruleConstantValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:4465:1: ruleConstantValue returns [EObject current=null] : (this_StaticValue_0= ruleStaticValue | this_Constant_1= ruleConstant ) ;
    public final EObject ruleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject this_StaticValue_0 = null;

        EObject this_Constant_1 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:4468:28: ( (this_StaticValue_0= ruleStaticValue | this_Constant_1= ruleConstant ) )
            // InternalDSL.g:4469:1: (this_StaticValue_0= ruleStaticValue | this_Constant_1= ruleConstant )
            {
            // InternalDSL.g:4469:1: (this_StaticValue_0= ruleStaticValue | this_Constant_1= ruleConstant )
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==RULE_STRING||(LA68_0>=RULE_INTEGER && LA68_0<=RULE_TWELVEHRSTIME)||LA68_0==74||LA68_0==77) ) {
                alt68=1;
            }
            else if ( (LA68_0==RULE_ID) ) {
                alt68=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 68, 0, input);

                throw nvae;
            }
            switch (alt68) {
                case 1 :
                    // InternalDSL.g:4470:5: this_StaticValue_0= ruleStaticValue
                    {
                     
                            newCompositeNode(grammarAccess.getConstantValueAccess().getStaticValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_StaticValue_0=ruleStaticValue();

                    state._fsp--;

                     
                            current = this_StaticValue_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalDSL.g:4480:5: this_Constant_1= ruleConstant
                    {
                     
                            newCompositeNode(grammarAccess.getConstantValueAccess().getConstantParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
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
    // InternalDSL.g:4496:1: entryRuleStaticValue returns [EObject current=null] : iv_ruleStaticValue= ruleStaticValue EOF ;
    public final EObject entryRuleStaticValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStaticValue = null;


        try {
            // InternalDSL.g:4497:2: (iv_ruleStaticValue= ruleStaticValue EOF )
            // InternalDSL.g:4498:2: iv_ruleStaticValue= ruleStaticValue EOF
            {
             newCompositeNode(grammarAccess.getStaticValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStaticValue=ruleStaticValue();

            state._fsp--;

             current =iv_ruleStaticValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:4505:1: ruleStaticValue returns [EObject current=null] : (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_BooleanValue_3= ruleBooleanValue | this_DateValue_4= ruleDateValue | this_TimeValue_5= ruleTimeValue | this_DateAndTimeValue_6= ruleDateAndTimeValue | this_NullValue_7= ruleNullValue | this_JavaConstantValue_8= ruleJavaConstantValue ) ;
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
            // InternalDSL.g:4508:28: ( (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_BooleanValue_3= ruleBooleanValue | this_DateValue_4= ruleDateValue | this_TimeValue_5= ruleTimeValue | this_DateAndTimeValue_6= ruleDateAndTimeValue | this_NullValue_7= ruleNullValue | this_JavaConstantValue_8= ruleJavaConstantValue ) )
            // InternalDSL.g:4509:1: (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_BooleanValue_3= ruleBooleanValue | this_DateValue_4= ruleDateValue | this_TimeValue_5= ruleTimeValue | this_DateAndTimeValue_6= ruleDateAndTimeValue | this_NullValue_7= ruleNullValue | this_JavaConstantValue_8= ruleJavaConstantValue )
            {
            // InternalDSL.g:4509:1: (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_BooleanValue_3= ruleBooleanValue | this_DateValue_4= ruleDateValue | this_TimeValue_5= ruleTimeValue | this_DateAndTimeValue_6= ruleDateAndTimeValue | this_NullValue_7= ruleNullValue | this_JavaConstantValue_8= ruleJavaConstantValue )
            int alt69=9;
            alt69 = dfa69.predict(input);
            switch (alt69) {
                case 1 :
                    // InternalDSL.g:4510:5: this_StringValue_0= ruleStringValue
                    {
                     
                            newCompositeNode(grammarAccess.getStaticValueAccess().getStringValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_StringValue_0=ruleStringValue();

                    state._fsp--;

                     
                            current = this_StringValue_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalDSL.g:4520:5: this_IntegerValue_1= ruleIntegerValue
                    {
                     
                            newCompositeNode(grammarAccess.getStaticValueAccess().getIntegerValueParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_IntegerValue_1=ruleIntegerValue();

                    state._fsp--;

                     
                            current = this_IntegerValue_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalDSL.g:4530:5: this_DecimalValue_2= ruleDecimalValue
                    {
                     
                            newCompositeNode(grammarAccess.getStaticValueAccess().getDecimalValueParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_DecimalValue_2=ruleDecimalValue();

                    state._fsp--;

                     
                            current = this_DecimalValue_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalDSL.g:4540:5: this_BooleanValue_3= ruleBooleanValue
                    {
                     
                            newCompositeNode(grammarAccess.getStaticValueAccess().getBooleanValueParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_2);
                    this_BooleanValue_3=ruleBooleanValue();

                    state._fsp--;

                     
                            current = this_BooleanValue_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // InternalDSL.g:4550:5: this_DateValue_4= ruleDateValue
                    {
                     
                            newCompositeNode(grammarAccess.getStaticValueAccess().getDateValueParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_2);
                    this_DateValue_4=ruleDateValue();

                    state._fsp--;

                     
                            current = this_DateValue_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // InternalDSL.g:4560:5: this_TimeValue_5= ruleTimeValue
                    {
                     
                            newCompositeNode(grammarAccess.getStaticValueAccess().getTimeValueParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_2);
                    this_TimeValue_5=ruleTimeValue();

                    state._fsp--;

                     
                            current = this_TimeValue_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // InternalDSL.g:4570:5: this_DateAndTimeValue_6= ruleDateAndTimeValue
                    {
                     
                            newCompositeNode(grammarAccess.getStaticValueAccess().getDateAndTimeValueParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_2);
                    this_DateAndTimeValue_6=ruleDateAndTimeValue();

                    state._fsp--;

                     
                            current = this_DateAndTimeValue_6; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 8 :
                    // InternalDSL.g:4580:5: this_NullValue_7= ruleNullValue
                    {
                     
                            newCompositeNode(grammarAccess.getStaticValueAccess().getNullValueParserRuleCall_7()); 
                        
                    pushFollow(FOLLOW_2);
                    this_NullValue_7=ruleNullValue();

                    state._fsp--;

                     
                            current = this_NullValue_7; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 9 :
                    // InternalDSL.g:4590:5: this_JavaConstantValue_8= ruleJavaConstantValue
                    {
                     
                            newCompositeNode(grammarAccess.getStaticValueAccess().getJavaConstantValueParserRuleCall_8()); 
                        
                    pushFollow(FOLLOW_2);
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
    // InternalDSL.g:4606:1: entryRuleIntegerValue returns [EObject current=null] : iv_ruleIntegerValue= ruleIntegerValue EOF ;
    public final EObject entryRuleIntegerValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerValue = null;


        try {
            // InternalDSL.g:4607:2: (iv_ruleIntegerValue= ruleIntegerValue EOF )
            // InternalDSL.g:4608:2: iv_ruleIntegerValue= ruleIntegerValue EOF
            {
             newCompositeNode(grammarAccess.getIntegerValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntegerValue=ruleIntegerValue();

            state._fsp--;

             current =iv_ruleIntegerValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:4615:1: ruleIntegerValue returns [EObject current=null] : ( (lv_integerValue_0_0= RULE_INTEGER ) ) ;
    public final EObject ruleIntegerValue() throws RecognitionException {
        EObject current = null;

        Token lv_integerValue_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:4618:28: ( ( (lv_integerValue_0_0= RULE_INTEGER ) ) )
            // InternalDSL.g:4619:1: ( (lv_integerValue_0_0= RULE_INTEGER ) )
            {
            // InternalDSL.g:4619:1: ( (lv_integerValue_0_0= RULE_INTEGER ) )
            // InternalDSL.g:4620:1: (lv_integerValue_0_0= RULE_INTEGER )
            {
            // InternalDSL.g:4620:1: (lv_integerValue_0_0= RULE_INTEGER )
            // InternalDSL.g:4621:3: lv_integerValue_0_0= RULE_INTEGER
            {
            lv_integerValue_0_0=(Token)match(input,RULE_INTEGER,FOLLOW_2); 

            			newLeafNode(lv_integerValue_0_0, grammarAccess.getIntegerValueAccess().getIntegerValueINTEGERTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIntegerValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"integerValue",
                    		lv_integerValue_0_0, 
                    		"de.gebit.integrity.DSL.INTEGER");
            	    

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
    // InternalDSL.g:4645:1: entryRuleDecimalValue returns [EObject current=null] : iv_ruleDecimalValue= ruleDecimalValue EOF ;
    public final EObject entryRuleDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecimalValue = null;


        try {
            // InternalDSL.g:4646:2: (iv_ruleDecimalValue= ruleDecimalValue EOF )
            // InternalDSL.g:4647:2: iv_ruleDecimalValue= ruleDecimalValue EOF
            {
             newCompositeNode(grammarAccess.getDecimalValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDecimalValue=ruleDecimalValue();

            state._fsp--;

             current =iv_ruleDecimalValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:4654:1: ruleDecimalValue returns [EObject current=null] : ( (lv_decimalValue_0_0= RULE_DECIMAL ) ) ;
    public final EObject ruleDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_decimalValue_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:4657:28: ( ( (lv_decimalValue_0_0= RULE_DECIMAL ) ) )
            // InternalDSL.g:4658:1: ( (lv_decimalValue_0_0= RULE_DECIMAL ) )
            {
            // InternalDSL.g:4658:1: ( (lv_decimalValue_0_0= RULE_DECIMAL ) )
            // InternalDSL.g:4659:1: (lv_decimalValue_0_0= RULE_DECIMAL )
            {
            // InternalDSL.g:4659:1: (lv_decimalValue_0_0= RULE_DECIMAL )
            // InternalDSL.g:4660:3: lv_decimalValue_0_0= RULE_DECIMAL
            {
            lv_decimalValue_0_0=(Token)match(input,RULE_DECIMAL,FOLLOW_2); 

            			newLeafNode(lv_decimalValue_0_0, grammarAccess.getDecimalValueAccess().getDecimalValueDECIMALTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDecimalValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"decimalValue",
                    		lv_decimalValue_0_0, 
                    		"de.gebit.integrity.DSL.DECIMAL");
            	    

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
    // InternalDSL.g:4684:1: entryRuleStringValue returns [EObject current=null] : iv_ruleStringValue= ruleStringValue EOF ;
    public final EObject entryRuleStringValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringValue = null;


        try {
            // InternalDSL.g:4685:2: (iv_ruleStringValue= ruleStringValue EOF )
            // InternalDSL.g:4686:2: iv_ruleStringValue= ruleStringValue EOF
            {
             newCompositeNode(grammarAccess.getStringValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringValue=ruleStringValue();

            state._fsp--;

             current =iv_ruleStringValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:4693:1: ruleStringValue returns [EObject current=null] : ( (lv_stringValue_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringValue() throws RecognitionException {
        EObject current = null;

        Token lv_stringValue_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:4696:28: ( ( (lv_stringValue_0_0= RULE_STRING ) ) )
            // InternalDSL.g:4697:1: ( (lv_stringValue_0_0= RULE_STRING ) )
            {
            // InternalDSL.g:4697:1: ( (lv_stringValue_0_0= RULE_STRING ) )
            // InternalDSL.g:4698:1: (lv_stringValue_0_0= RULE_STRING )
            {
            // InternalDSL.g:4698:1: (lv_stringValue_0_0= RULE_STRING )
            // InternalDSL.g:4699:3: lv_stringValue_0_0= RULE_STRING
            {
            lv_stringValue_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            			newLeafNode(lv_stringValue_0_0, grammarAccess.getStringValueAccess().getStringValueSTRINGTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getStringValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"stringValue",
                    		lv_stringValue_0_0, 
                    		"de.gebit.integrity.DSL.STRING");
            	    

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
    // InternalDSL.g:4723:1: entryRuleBooleanValue returns [EObject current=null] : iv_ruleBooleanValue= ruleBooleanValue EOF ;
    public final EObject entryRuleBooleanValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanValue = null;


        try {
            // InternalDSL.g:4724:2: (iv_ruleBooleanValue= ruleBooleanValue EOF )
            // InternalDSL.g:4725:2: iv_ruleBooleanValue= ruleBooleanValue EOF
            {
             newCompositeNode(grammarAccess.getBooleanValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBooleanValue=ruleBooleanValue();

            state._fsp--;

             current =iv_ruleBooleanValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:4732:1: ruleBooleanValue returns [EObject current=null] : ( ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) ) ) ;
    public final EObject ruleBooleanValue() throws RecognitionException {
        EObject current = null;

        Token lv_booleanValue_0_1=null;
        Token lv_booleanValue_0_2=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:4735:28: ( ( ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) ) ) )
            // InternalDSL.g:4736:1: ( ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) ) )
            {
            // InternalDSL.g:4736:1: ( ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) ) )
            // InternalDSL.g:4737:1: ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) )
            {
            // InternalDSL.g:4737:1: ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) )
            // InternalDSL.g:4738:1: (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE )
            {
            // InternalDSL.g:4738:1: (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE )
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_BOOLEAN_TRUE) ) {
                alt70=1;
            }
            else if ( (LA70_0==RULE_BOOLEAN_FALSE) ) {
                alt70=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }
            switch (alt70) {
                case 1 :
                    // InternalDSL.g:4739:3: lv_booleanValue_0_1= RULE_BOOLEAN_TRUE
                    {
                    lv_booleanValue_0_1=(Token)match(input,RULE_BOOLEAN_TRUE,FOLLOW_2); 

                    			newLeafNode(lv_booleanValue_0_1, grammarAccess.getBooleanValueAccess().getBooleanValueBOOLEAN_TRUETerminalRuleCall_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBooleanValueRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"booleanValue",
                            		lv_booleanValue_0_1, 
                            		"de.gebit.integrity.DSL.BOOLEAN_TRUE");
                    	    

                    }
                    break;
                case 2 :
                    // InternalDSL.g:4754:8: lv_booleanValue_0_2= RULE_BOOLEAN_FALSE
                    {
                    lv_booleanValue_0_2=(Token)match(input,RULE_BOOLEAN_FALSE,FOLLOW_2); 

                    			newLeafNode(lv_booleanValue_0_2, grammarAccess.getBooleanValueAccess().getBooleanValueBOOLEAN_FALSETerminalRuleCall_0_1()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBooleanValueRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"booleanValue",
                            		lv_booleanValue_0_2, 
                            		"de.gebit.integrity.DSL.BOOLEAN_FALSE");
                    	    

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
    // InternalDSL.g:4780:1: entryRuleDateValue returns [EObject current=null] : iv_ruleDateValue= ruleDateValue EOF ;
    public final EObject entryRuleDateValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateValue = null;


        try {
            // InternalDSL.g:4781:2: (iv_ruleDateValue= ruleDateValue EOF )
            // InternalDSL.g:4782:2: iv_ruleDateValue= ruleDateValue EOF
            {
             newCompositeNode(grammarAccess.getDateValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDateValue=ruleDateValue();

            state._fsp--;

             current =iv_ruleDateValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:4789:1: ruleDateValue returns [EObject current=null] : (this_IsoDateValue_0= ruleIsoDateValue | this_EuropeanDateValue_1= ruleEuropeanDateValue | this_USDateValue_2= ruleUSDateValue ) ;
    public final EObject ruleDateValue() throws RecognitionException {
        EObject current = null;

        EObject this_IsoDateValue_0 = null;

        EObject this_EuropeanDateValue_1 = null;

        EObject this_USDateValue_2 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:4792:28: ( (this_IsoDateValue_0= ruleIsoDateValue | this_EuropeanDateValue_1= ruleEuropeanDateValue | this_USDateValue_2= ruleUSDateValue ) )
            // InternalDSL.g:4793:1: (this_IsoDateValue_0= ruleIsoDateValue | this_EuropeanDateValue_1= ruleEuropeanDateValue | this_USDateValue_2= ruleUSDateValue )
            {
            // InternalDSL.g:4793:1: (this_IsoDateValue_0= ruleIsoDateValue | this_EuropeanDateValue_1= ruleEuropeanDateValue | this_USDateValue_2= ruleUSDateValue )
            int alt71=3;
            switch ( input.LA(1) ) {
            case RULE_ISODATE:
                {
                alt71=1;
                }
                break;
            case RULE_EURODATE:
                {
                alt71=2;
                }
                break;
            case RULE_USDATE:
                {
                alt71=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }

            switch (alt71) {
                case 1 :
                    // InternalDSL.g:4794:5: this_IsoDateValue_0= ruleIsoDateValue
                    {
                     
                            newCompositeNode(grammarAccess.getDateValueAccess().getIsoDateValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_IsoDateValue_0=ruleIsoDateValue();

                    state._fsp--;

                     
                            current = this_IsoDateValue_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalDSL.g:4804:5: this_EuropeanDateValue_1= ruleEuropeanDateValue
                    {
                     
                            newCompositeNode(grammarAccess.getDateValueAccess().getEuropeanDateValueParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_EuropeanDateValue_1=ruleEuropeanDateValue();

                    state._fsp--;

                     
                            current = this_EuropeanDateValue_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalDSL.g:4814:5: this_USDateValue_2= ruleUSDateValue
                    {
                     
                            newCompositeNode(grammarAccess.getDateValueAccess().getUSDateValueParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
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
    // InternalDSL.g:4830:1: entryRuleIsoDateValue returns [EObject current=null] : iv_ruleIsoDateValue= ruleIsoDateValue EOF ;
    public final EObject entryRuleIsoDateValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsoDateValue = null;


        try {
            // InternalDSL.g:4831:2: (iv_ruleIsoDateValue= ruleIsoDateValue EOF )
            // InternalDSL.g:4832:2: iv_ruleIsoDateValue= ruleIsoDateValue EOF
            {
             newCompositeNode(grammarAccess.getIsoDateValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIsoDateValue=ruleIsoDateValue();

            state._fsp--;

             current =iv_ruleIsoDateValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:4839:1: ruleIsoDateValue returns [EObject current=null] : ( (lv_dateValue_0_0= RULE_ISODATE ) ) ;
    public final EObject ruleIsoDateValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:4842:28: ( ( (lv_dateValue_0_0= RULE_ISODATE ) ) )
            // InternalDSL.g:4843:1: ( (lv_dateValue_0_0= RULE_ISODATE ) )
            {
            // InternalDSL.g:4843:1: ( (lv_dateValue_0_0= RULE_ISODATE ) )
            // InternalDSL.g:4844:1: (lv_dateValue_0_0= RULE_ISODATE )
            {
            // InternalDSL.g:4844:1: (lv_dateValue_0_0= RULE_ISODATE )
            // InternalDSL.g:4845:3: lv_dateValue_0_0= RULE_ISODATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_ISODATE,FOLLOW_2); 

            			newLeafNode(lv_dateValue_0_0, grammarAccess.getIsoDateValueAccess().getDateValueISODATETerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIsoDateValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"dateValue",
                    		lv_dateValue_0_0, 
                    		"de.gebit.integrity.DSL.ISODATE");
            	    

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
    // InternalDSL.g:4869:1: entryRuleEuropeanDateValue returns [EObject current=null] : iv_ruleEuropeanDateValue= ruleEuropeanDateValue EOF ;
    public final EObject entryRuleEuropeanDateValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEuropeanDateValue = null;


        try {
            // InternalDSL.g:4870:2: (iv_ruleEuropeanDateValue= ruleEuropeanDateValue EOF )
            // InternalDSL.g:4871:2: iv_ruleEuropeanDateValue= ruleEuropeanDateValue EOF
            {
             newCompositeNode(grammarAccess.getEuropeanDateValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEuropeanDateValue=ruleEuropeanDateValue();

            state._fsp--;

             current =iv_ruleEuropeanDateValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:4878:1: ruleEuropeanDateValue returns [EObject current=null] : ( (lv_dateValue_0_0= RULE_EURODATE ) ) ;
    public final EObject ruleEuropeanDateValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:4881:28: ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) )
            // InternalDSL.g:4882:1: ( (lv_dateValue_0_0= RULE_EURODATE ) )
            {
            // InternalDSL.g:4882:1: ( (lv_dateValue_0_0= RULE_EURODATE ) )
            // InternalDSL.g:4883:1: (lv_dateValue_0_0= RULE_EURODATE )
            {
            // InternalDSL.g:4883:1: (lv_dateValue_0_0= RULE_EURODATE )
            // InternalDSL.g:4884:3: lv_dateValue_0_0= RULE_EURODATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_EURODATE,FOLLOW_2); 

            			newLeafNode(lv_dateValue_0_0, grammarAccess.getEuropeanDateValueAccess().getDateValueEURODATETerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEuropeanDateValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"dateValue",
                    		lv_dateValue_0_0, 
                    		"de.gebit.integrity.DSL.EURODATE");
            	    

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
    // InternalDSL.g:4908:1: entryRuleUSDateValue returns [EObject current=null] : iv_ruleUSDateValue= ruleUSDateValue EOF ;
    public final EObject entryRuleUSDateValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUSDateValue = null;


        try {
            // InternalDSL.g:4909:2: (iv_ruleUSDateValue= ruleUSDateValue EOF )
            // InternalDSL.g:4910:2: iv_ruleUSDateValue= ruleUSDateValue EOF
            {
             newCompositeNode(grammarAccess.getUSDateValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUSDateValue=ruleUSDateValue();

            state._fsp--;

             current =iv_ruleUSDateValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:4917:1: ruleUSDateValue returns [EObject current=null] : ( (lv_dateValue_0_0= RULE_USDATE ) ) ;
    public final EObject ruleUSDateValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:4920:28: ( ( (lv_dateValue_0_0= RULE_USDATE ) ) )
            // InternalDSL.g:4921:1: ( (lv_dateValue_0_0= RULE_USDATE ) )
            {
            // InternalDSL.g:4921:1: ( (lv_dateValue_0_0= RULE_USDATE ) )
            // InternalDSL.g:4922:1: (lv_dateValue_0_0= RULE_USDATE )
            {
            // InternalDSL.g:4922:1: (lv_dateValue_0_0= RULE_USDATE )
            // InternalDSL.g:4923:3: lv_dateValue_0_0= RULE_USDATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_USDATE,FOLLOW_2); 

            			newLeafNode(lv_dateValue_0_0, grammarAccess.getUSDateValueAccess().getDateValueUSDATETerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUSDateValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"dateValue",
                    		lv_dateValue_0_0, 
                    		"de.gebit.integrity.DSL.USDATE");
            	    

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
    // InternalDSL.g:4947:1: entryRuleTimeValue returns [EObject current=null] : iv_ruleTimeValue= ruleTimeValue EOF ;
    public final EObject entryRuleTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeValue = null;


        try {
            // InternalDSL.g:4948:2: (iv_ruleTimeValue= ruleTimeValue EOF )
            // InternalDSL.g:4949:2: iv_ruleTimeValue= ruleTimeValue EOF
            {
             newCompositeNode(grammarAccess.getTimeValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeValue=ruleTimeValue();

            state._fsp--;

             current =iv_ruleTimeValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:4956:1: ruleTimeValue returns [EObject current=null] : (this_IsoTimeValue_0= ruleIsoTimeValue | this_Simple24HrsTimeValue_1= ruleSimple24HrsTimeValue | this_Simple12HrsTimeValue_2= ruleSimple12HrsTimeValue ) ;
    public final EObject ruleTimeValue() throws RecognitionException {
        EObject current = null;

        EObject this_IsoTimeValue_0 = null;

        EObject this_Simple24HrsTimeValue_1 = null;

        EObject this_Simple12HrsTimeValue_2 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:4959:28: ( (this_IsoTimeValue_0= ruleIsoTimeValue | this_Simple24HrsTimeValue_1= ruleSimple24HrsTimeValue | this_Simple12HrsTimeValue_2= ruleSimple12HrsTimeValue ) )
            // InternalDSL.g:4960:1: (this_IsoTimeValue_0= ruleIsoTimeValue | this_Simple24HrsTimeValue_1= ruleSimple24HrsTimeValue | this_Simple12HrsTimeValue_2= ruleSimple12HrsTimeValue )
            {
            // InternalDSL.g:4960:1: (this_IsoTimeValue_0= ruleIsoTimeValue | this_Simple24HrsTimeValue_1= ruleSimple24HrsTimeValue | this_Simple12HrsTimeValue_2= ruleSimple12HrsTimeValue )
            int alt72=3;
            switch ( input.LA(1) ) {
            case RULE_ISOTIME:
                {
                alt72=1;
                }
                break;
            case RULE_TWENTYFOURHRSTIME:
                {
                alt72=2;
                }
                break;
            case RULE_TWELVEHRSTIME:
                {
                alt72=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }

            switch (alt72) {
                case 1 :
                    // InternalDSL.g:4961:5: this_IsoTimeValue_0= ruleIsoTimeValue
                    {
                     
                            newCompositeNode(grammarAccess.getTimeValueAccess().getIsoTimeValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_IsoTimeValue_0=ruleIsoTimeValue();

                    state._fsp--;

                     
                            current = this_IsoTimeValue_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalDSL.g:4971:5: this_Simple24HrsTimeValue_1= ruleSimple24HrsTimeValue
                    {
                     
                            newCompositeNode(grammarAccess.getTimeValueAccess().getSimple24HrsTimeValueParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_Simple24HrsTimeValue_1=ruleSimple24HrsTimeValue();

                    state._fsp--;

                     
                            current = this_Simple24HrsTimeValue_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalDSL.g:4981:5: this_Simple12HrsTimeValue_2= ruleSimple12HrsTimeValue
                    {
                     
                            newCompositeNode(grammarAccess.getTimeValueAccess().getSimple12HrsTimeValueParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
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
    // InternalDSL.g:4997:1: entryRuleIsoTimeValue returns [EObject current=null] : iv_ruleIsoTimeValue= ruleIsoTimeValue EOF ;
    public final EObject entryRuleIsoTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsoTimeValue = null;


        try {
            // InternalDSL.g:4998:2: (iv_ruleIsoTimeValue= ruleIsoTimeValue EOF )
            // InternalDSL.g:4999:2: iv_ruleIsoTimeValue= ruleIsoTimeValue EOF
            {
             newCompositeNode(grammarAccess.getIsoTimeValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIsoTimeValue=ruleIsoTimeValue();

            state._fsp--;

             current =iv_ruleIsoTimeValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:5006:1: ruleIsoTimeValue returns [EObject current=null] : ( (lv_timeValue_0_0= RULE_ISOTIME ) ) ;
    public final EObject ruleIsoTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_timeValue_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5009:28: ( ( (lv_timeValue_0_0= RULE_ISOTIME ) ) )
            // InternalDSL.g:5010:1: ( (lv_timeValue_0_0= RULE_ISOTIME ) )
            {
            // InternalDSL.g:5010:1: ( (lv_timeValue_0_0= RULE_ISOTIME ) )
            // InternalDSL.g:5011:1: (lv_timeValue_0_0= RULE_ISOTIME )
            {
            // InternalDSL.g:5011:1: (lv_timeValue_0_0= RULE_ISOTIME )
            // InternalDSL.g:5012:3: lv_timeValue_0_0= RULE_ISOTIME
            {
            lv_timeValue_0_0=(Token)match(input,RULE_ISOTIME,FOLLOW_2); 

            			newLeafNode(lv_timeValue_0_0, grammarAccess.getIsoTimeValueAccess().getTimeValueISOTIMETerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIsoTimeValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"timeValue",
                    		lv_timeValue_0_0, 
                    		"de.gebit.integrity.DSL.ISOTIME");
            	    

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
    // InternalDSL.g:5036:1: entryRuleSimple24HrsTimeValue returns [EObject current=null] : iv_ruleSimple24HrsTimeValue= ruleSimple24HrsTimeValue EOF ;
    public final EObject entryRuleSimple24HrsTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimple24HrsTimeValue = null;


        try {
            // InternalDSL.g:5037:2: (iv_ruleSimple24HrsTimeValue= ruleSimple24HrsTimeValue EOF )
            // InternalDSL.g:5038:2: iv_ruleSimple24HrsTimeValue= ruleSimple24HrsTimeValue EOF
            {
             newCompositeNode(grammarAccess.getSimple24HrsTimeValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimple24HrsTimeValue=ruleSimple24HrsTimeValue();

            state._fsp--;

             current =iv_ruleSimple24HrsTimeValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:5045:1: ruleSimple24HrsTimeValue returns [EObject current=null] : ( (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME ) ) ;
    public final EObject ruleSimple24HrsTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_timeValue_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5048:28: ( ( (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME ) ) )
            // InternalDSL.g:5049:1: ( (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME ) )
            {
            // InternalDSL.g:5049:1: ( (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME ) )
            // InternalDSL.g:5050:1: (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME )
            {
            // InternalDSL.g:5050:1: (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME )
            // InternalDSL.g:5051:3: lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME
            {
            lv_timeValue_0_0=(Token)match(input,RULE_TWENTYFOURHRSTIME,FOLLOW_2); 

            			newLeafNode(lv_timeValue_0_0, grammarAccess.getSimple24HrsTimeValueAccess().getTimeValueTWENTYFOURHRSTIMETerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimple24HrsTimeValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"timeValue",
                    		lv_timeValue_0_0, 
                    		"de.gebit.integrity.DSL.TWENTYFOURHRSTIME");
            	    

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
    // InternalDSL.g:5075:1: entryRuleSimple12HrsTimeValue returns [EObject current=null] : iv_ruleSimple12HrsTimeValue= ruleSimple12HrsTimeValue EOF ;
    public final EObject entryRuleSimple12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimple12HrsTimeValue = null;


        try {
            // InternalDSL.g:5076:2: (iv_ruleSimple12HrsTimeValue= ruleSimple12HrsTimeValue EOF )
            // InternalDSL.g:5077:2: iv_ruleSimple12HrsTimeValue= ruleSimple12HrsTimeValue EOF
            {
             newCompositeNode(grammarAccess.getSimple12HrsTimeValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSimple12HrsTimeValue=ruleSimple12HrsTimeValue();

            state._fsp--;

             current =iv_ruleSimple12HrsTimeValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:5084:1: ruleSimple12HrsTimeValue returns [EObject current=null] : ( (lv_timeValue_0_0= RULE_TWELVEHRSTIME ) ) ;
    public final EObject ruleSimple12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_timeValue_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5087:28: ( ( (lv_timeValue_0_0= RULE_TWELVEHRSTIME ) ) )
            // InternalDSL.g:5088:1: ( (lv_timeValue_0_0= RULE_TWELVEHRSTIME ) )
            {
            // InternalDSL.g:5088:1: ( (lv_timeValue_0_0= RULE_TWELVEHRSTIME ) )
            // InternalDSL.g:5089:1: (lv_timeValue_0_0= RULE_TWELVEHRSTIME )
            {
            // InternalDSL.g:5089:1: (lv_timeValue_0_0= RULE_TWELVEHRSTIME )
            // InternalDSL.g:5090:3: lv_timeValue_0_0= RULE_TWELVEHRSTIME
            {
            lv_timeValue_0_0=(Token)match(input,RULE_TWELVEHRSTIME,FOLLOW_2); 

            			newLeafNode(lv_timeValue_0_0, grammarAccess.getSimple12HrsTimeValueAccess().getTimeValueTWELVEHRSTIMETerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getSimple12HrsTimeValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"timeValue",
                    		lv_timeValue_0_0, 
                    		"de.gebit.integrity.DSL.TWELVEHRSTIME");
            	    

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
    // InternalDSL.g:5114:1: entryRuleDateAndTimeValue returns [EObject current=null] : iv_ruleDateAndTimeValue= ruleDateAndTimeValue EOF ;
    public final EObject entryRuleDateAndTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateAndTimeValue = null;


        try {
            // InternalDSL.g:5115:2: (iv_ruleDateAndTimeValue= ruleDateAndTimeValue EOF )
            // InternalDSL.g:5116:2: iv_ruleDateAndTimeValue= ruleDateAndTimeValue EOF
            {
             newCompositeNode(grammarAccess.getDateAndTimeValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDateAndTimeValue=ruleDateAndTimeValue();

            state._fsp--;

             current =iv_ruleDateAndTimeValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:5123:1: ruleDateAndTimeValue returns [EObject current=null] : (this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue | this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue | this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue | this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue ) ;
    public final EObject ruleDateAndTimeValue() throws RecognitionException {
        EObject current = null;

        EObject this_IsoDateAndTimeValue_0 = null;

        EObject this_EuropeanDateAnd24HrsTimeValue_1 = null;

        EObject this_EuropeanDateAnd12HrsTimeValue_2 = null;

        EObject this_USDateAnd12HrsTimeValue_3 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:5126:28: ( (this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue | this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue | this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue | this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue ) )
            // InternalDSL.g:5127:1: (this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue | this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue | this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue | this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue )
            {
            // InternalDSL.g:5127:1: (this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue | this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue | this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue | this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue )
            int alt73=4;
            alt73 = dfa73.predict(input);
            switch (alt73) {
                case 1 :
                    // InternalDSL.g:5128:5: this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue
                    {
                     
                            newCompositeNode(grammarAccess.getDateAndTimeValueAccess().getIsoDateAndTimeValueParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_2);
                    this_IsoDateAndTimeValue_0=ruleIsoDateAndTimeValue();

                    state._fsp--;

                     
                            current = this_IsoDateAndTimeValue_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // InternalDSL.g:5138:5: this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue
                    {
                     
                            newCompositeNode(grammarAccess.getDateAndTimeValueAccess().getEuropeanDateAnd24HrsTimeValueParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_2);
                    this_EuropeanDateAnd24HrsTimeValue_1=ruleEuropeanDateAnd24HrsTimeValue();

                    state._fsp--;

                     
                            current = this_EuropeanDateAnd24HrsTimeValue_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // InternalDSL.g:5148:5: this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue
                    {
                     
                            newCompositeNode(grammarAccess.getDateAndTimeValueAccess().getEuropeanDateAnd12HrsTimeValueParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_2);
                    this_EuropeanDateAnd12HrsTimeValue_2=ruleEuropeanDateAnd12HrsTimeValue();

                    state._fsp--;

                     
                            current = this_EuropeanDateAnd12HrsTimeValue_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // InternalDSL.g:5158:5: this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue
                    {
                     
                            newCompositeNode(grammarAccess.getDateAndTimeValueAccess().getUSDateAnd12HrsTimeValueParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_2);
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
    // InternalDSL.g:5174:1: entryRuleIsoDateAndTimeValue returns [EObject current=null] : iv_ruleIsoDateAndTimeValue= ruleIsoDateAndTimeValue EOF ;
    public final EObject entryRuleIsoDateAndTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsoDateAndTimeValue = null;


        try {
            // InternalDSL.g:5175:2: (iv_ruleIsoDateAndTimeValue= ruleIsoDateAndTimeValue EOF )
            // InternalDSL.g:5176:2: iv_ruleIsoDateAndTimeValue= ruleIsoDateAndTimeValue EOF
            {
             newCompositeNode(grammarAccess.getIsoDateAndTimeValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIsoDateAndTimeValue=ruleIsoDateAndTimeValue();

            state._fsp--;

             current =iv_ruleIsoDateAndTimeValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:5183:1: ruleIsoDateAndTimeValue returns [EObject current=null] : ( ( (lv_dateValue_0_0= RULE_ISODATE ) ) ( (lv_timeValue_1_0= RULE_ISOTIME ) ) ) ;
    public final EObject ruleIsoDateAndTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;
        Token lv_timeValue_1_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5186:28: ( ( ( (lv_dateValue_0_0= RULE_ISODATE ) ) ( (lv_timeValue_1_0= RULE_ISOTIME ) ) ) )
            // InternalDSL.g:5187:1: ( ( (lv_dateValue_0_0= RULE_ISODATE ) ) ( (lv_timeValue_1_0= RULE_ISOTIME ) ) )
            {
            // InternalDSL.g:5187:1: ( ( (lv_dateValue_0_0= RULE_ISODATE ) ) ( (lv_timeValue_1_0= RULE_ISOTIME ) ) )
            // InternalDSL.g:5187:2: ( (lv_dateValue_0_0= RULE_ISODATE ) ) ( (lv_timeValue_1_0= RULE_ISOTIME ) )
            {
            // InternalDSL.g:5187:2: ( (lv_dateValue_0_0= RULE_ISODATE ) )
            // InternalDSL.g:5188:1: (lv_dateValue_0_0= RULE_ISODATE )
            {
            // InternalDSL.g:5188:1: (lv_dateValue_0_0= RULE_ISODATE )
            // InternalDSL.g:5189:3: lv_dateValue_0_0= RULE_ISODATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_ISODATE,FOLLOW_69); 

            			newLeafNode(lv_dateValue_0_0, grammarAccess.getIsoDateAndTimeValueAccess().getDateValueISODATETerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIsoDateAndTimeValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"dateValue",
                    		lv_dateValue_0_0, 
                    		"de.gebit.integrity.DSL.ISODATE");
            	    

            }


            }

            // InternalDSL.g:5205:2: ( (lv_timeValue_1_0= RULE_ISOTIME ) )
            // InternalDSL.g:5206:1: (lv_timeValue_1_0= RULE_ISOTIME )
            {
            // InternalDSL.g:5206:1: (lv_timeValue_1_0= RULE_ISOTIME )
            // InternalDSL.g:5207:3: lv_timeValue_1_0= RULE_ISOTIME
            {
            lv_timeValue_1_0=(Token)match(input,RULE_ISOTIME,FOLLOW_2); 

            			newLeafNode(lv_timeValue_1_0, grammarAccess.getIsoDateAndTimeValueAccess().getTimeValueISOTIMETerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getIsoDateAndTimeValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"timeValue",
                    		lv_timeValue_1_0, 
                    		"de.gebit.integrity.DSL.ISOTIME");
            	    

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
    // InternalDSL.g:5231:1: entryRuleEuropeanDateAnd24HrsTimeValue returns [EObject current=null] : iv_ruleEuropeanDateAnd24HrsTimeValue= ruleEuropeanDateAnd24HrsTimeValue EOF ;
    public final EObject entryRuleEuropeanDateAnd24HrsTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEuropeanDateAnd24HrsTimeValue = null;


        try {
            // InternalDSL.g:5232:2: (iv_ruleEuropeanDateAnd24HrsTimeValue= ruleEuropeanDateAnd24HrsTimeValue EOF )
            // InternalDSL.g:5233:2: iv_ruleEuropeanDateAnd24HrsTimeValue= ruleEuropeanDateAnd24HrsTimeValue EOF
            {
             newCompositeNode(grammarAccess.getEuropeanDateAnd24HrsTimeValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEuropeanDateAnd24HrsTimeValue=ruleEuropeanDateAnd24HrsTimeValue();

            state._fsp--;

             current =iv_ruleEuropeanDateAnd24HrsTimeValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:5240:1: ruleEuropeanDateAnd24HrsTimeValue returns [EObject current=null] : ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) ) ) ;
    public final EObject ruleEuropeanDateAnd24HrsTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;
        Token lv_timeValue_2_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5243:28: ( ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) ) ) )
            // InternalDSL.g:5244:1: ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) ) )
            {
            // InternalDSL.g:5244:1: ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) ) )
            // InternalDSL.g:5244:2: ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) )
            {
            // InternalDSL.g:5244:2: ( (lv_dateValue_0_0= RULE_EURODATE ) )
            // InternalDSL.g:5245:1: (lv_dateValue_0_0= RULE_EURODATE )
            {
            // InternalDSL.g:5245:1: (lv_dateValue_0_0= RULE_EURODATE )
            // InternalDSL.g:5246:3: lv_dateValue_0_0= RULE_EURODATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_EURODATE,FOLLOW_70); 

            			newLeafNode(lv_dateValue_0_0, grammarAccess.getEuropeanDateAnd24HrsTimeValueAccess().getDateValueEURODATETerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEuropeanDateAnd24HrsTimeValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"dateValue",
                    		lv_dateValue_0_0, 
                    		"de.gebit.integrity.DSL.EURODATE");
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getEuropeanDateAnd24HrsTimeValueAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_71);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:5270:1: ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) )
            // InternalDSL.g:5271:1: (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME )
            {
            // InternalDSL.g:5271:1: (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME )
            // InternalDSL.g:5272:3: lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME
            {
            lv_timeValue_2_0=(Token)match(input,RULE_TWENTYFOURHRSTIME,FOLLOW_2); 

            			newLeafNode(lv_timeValue_2_0, grammarAccess.getEuropeanDateAnd24HrsTimeValueAccess().getTimeValueTWENTYFOURHRSTIMETerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEuropeanDateAnd24HrsTimeValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"timeValue",
                    		lv_timeValue_2_0, 
                    		"de.gebit.integrity.DSL.TWENTYFOURHRSTIME");
            	    

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
    // InternalDSL.g:5296:1: entryRuleEuropeanDateAnd12HrsTimeValue returns [EObject current=null] : iv_ruleEuropeanDateAnd12HrsTimeValue= ruleEuropeanDateAnd12HrsTimeValue EOF ;
    public final EObject entryRuleEuropeanDateAnd12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEuropeanDateAnd12HrsTimeValue = null;


        try {
            // InternalDSL.g:5297:2: (iv_ruleEuropeanDateAnd12HrsTimeValue= ruleEuropeanDateAnd12HrsTimeValue EOF )
            // InternalDSL.g:5298:2: iv_ruleEuropeanDateAnd12HrsTimeValue= ruleEuropeanDateAnd12HrsTimeValue EOF
            {
             newCompositeNode(grammarAccess.getEuropeanDateAnd12HrsTimeValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEuropeanDateAnd12HrsTimeValue=ruleEuropeanDateAnd12HrsTimeValue();

            state._fsp--;

             current =iv_ruleEuropeanDateAnd12HrsTimeValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:5305:1: ruleEuropeanDateAnd12HrsTimeValue returns [EObject current=null] : ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) ) ;
    public final EObject ruleEuropeanDateAnd12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;
        Token lv_timeValue_2_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5308:28: ( ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) ) )
            // InternalDSL.g:5309:1: ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) )
            {
            // InternalDSL.g:5309:1: ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) )
            // InternalDSL.g:5309:2: ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) )
            {
            // InternalDSL.g:5309:2: ( (lv_dateValue_0_0= RULE_EURODATE ) )
            // InternalDSL.g:5310:1: (lv_dateValue_0_0= RULE_EURODATE )
            {
            // InternalDSL.g:5310:1: (lv_dateValue_0_0= RULE_EURODATE )
            // InternalDSL.g:5311:3: lv_dateValue_0_0= RULE_EURODATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_EURODATE,FOLLOW_72); 

            			newLeafNode(lv_dateValue_0_0, grammarAccess.getEuropeanDateAnd12HrsTimeValueAccess().getDateValueEURODATETerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEuropeanDateAnd12HrsTimeValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"dateValue",
                    		lv_dateValue_0_0, 
                    		"de.gebit.integrity.DSL.EURODATE");
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getEuropeanDateAnd12HrsTimeValueAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_73);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:5335:1: ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) )
            // InternalDSL.g:5336:1: (lv_timeValue_2_0= RULE_TWELVEHRSTIME )
            {
            // InternalDSL.g:5336:1: (lv_timeValue_2_0= RULE_TWELVEHRSTIME )
            // InternalDSL.g:5337:3: lv_timeValue_2_0= RULE_TWELVEHRSTIME
            {
            lv_timeValue_2_0=(Token)match(input,RULE_TWELVEHRSTIME,FOLLOW_2); 

            			newLeafNode(lv_timeValue_2_0, grammarAccess.getEuropeanDateAnd12HrsTimeValueAccess().getTimeValueTWELVEHRSTIMETerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getEuropeanDateAnd12HrsTimeValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"timeValue",
                    		lv_timeValue_2_0, 
                    		"de.gebit.integrity.DSL.TWELVEHRSTIME");
            	    

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
    // InternalDSL.g:5361:1: entryRuleUSDateAnd12HrsTimeValue returns [EObject current=null] : iv_ruleUSDateAnd12HrsTimeValue= ruleUSDateAnd12HrsTimeValue EOF ;
    public final EObject entryRuleUSDateAnd12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUSDateAnd12HrsTimeValue = null;


        try {
            // InternalDSL.g:5362:2: (iv_ruleUSDateAnd12HrsTimeValue= ruleUSDateAnd12HrsTimeValue EOF )
            // InternalDSL.g:5363:2: iv_ruleUSDateAnd12HrsTimeValue= ruleUSDateAnd12HrsTimeValue EOF
            {
             newCompositeNode(grammarAccess.getUSDateAnd12HrsTimeValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUSDateAnd12HrsTimeValue=ruleUSDateAnd12HrsTimeValue();

            state._fsp--;

             current =iv_ruleUSDateAnd12HrsTimeValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:5370:1: ruleUSDateAnd12HrsTimeValue returns [EObject current=null] : ( ( (lv_dateValue_0_0= RULE_USDATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) ) ;
    public final EObject ruleUSDateAnd12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;
        Token lv_timeValue_2_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5373:28: ( ( ( (lv_dateValue_0_0= RULE_USDATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) ) )
            // InternalDSL.g:5374:1: ( ( (lv_dateValue_0_0= RULE_USDATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) )
            {
            // InternalDSL.g:5374:1: ( ( (lv_dateValue_0_0= RULE_USDATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) )
            // InternalDSL.g:5374:2: ( (lv_dateValue_0_0= RULE_USDATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) )
            {
            // InternalDSL.g:5374:2: ( (lv_dateValue_0_0= RULE_USDATE ) )
            // InternalDSL.g:5375:1: (lv_dateValue_0_0= RULE_USDATE )
            {
            // InternalDSL.g:5375:1: (lv_dateValue_0_0= RULE_USDATE )
            // InternalDSL.g:5376:3: lv_dateValue_0_0= RULE_USDATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_USDATE,FOLLOW_72); 

            			newLeafNode(lv_dateValue_0_0, grammarAccess.getUSDateAnd12HrsTimeValueAccess().getDateValueUSDATETerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUSDateAnd12HrsTimeValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"dateValue",
                    		lv_dateValue_0_0, 
                    		"de.gebit.integrity.DSL.USDATE");
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getUSDateAnd12HrsTimeValueAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_73);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:5400:1: ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) )
            // InternalDSL.g:5401:1: (lv_timeValue_2_0= RULE_TWELVEHRSTIME )
            {
            // InternalDSL.g:5401:1: (lv_timeValue_2_0= RULE_TWELVEHRSTIME )
            // InternalDSL.g:5402:3: lv_timeValue_2_0= RULE_TWELVEHRSTIME
            {
            lv_timeValue_2_0=(Token)match(input,RULE_TWELVEHRSTIME,FOLLOW_2); 

            			newLeafNode(lv_timeValue_2_0, grammarAccess.getUSDateAnd12HrsTimeValueAccess().getTimeValueTWELVEHRSTIMETerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getUSDateAnd12HrsTimeValueRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"timeValue",
                    		lv_timeValue_2_0, 
                    		"de.gebit.integrity.DSL.TWELVEHRSTIME");
            	    

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
    // InternalDSL.g:5426:1: entryRuleJavaConstantValue returns [EObject current=null] : iv_ruleJavaConstantValue= ruleJavaConstantValue EOF ;
    public final EObject entryRuleJavaConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaConstantValue = null;


        try {
            // InternalDSL.g:5427:2: (iv_ruleJavaConstantValue= ruleJavaConstantValue EOF )
            // InternalDSL.g:5428:2: iv_ruleJavaConstantValue= ruleJavaConstantValue EOF
            {
             newCompositeNode(grammarAccess.getJavaConstantValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJavaConstantValue=ruleJavaConstantValue();

            state._fsp--;

             current =iv_ruleJavaConstantValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:5435:1: ruleJavaConstantValue returns [EObject current=null] : (otherlv_0= '<' ( (lv_constant_1_0= ruleJavaConstantReference ) ) otherlv_2= '>' ) ;
    public final EObject ruleJavaConstantValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_constant_1_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:5438:28: ( (otherlv_0= '<' ( (lv_constant_1_0= ruleJavaConstantReference ) ) otherlv_2= '>' ) )
            // InternalDSL.g:5439:1: (otherlv_0= '<' ( (lv_constant_1_0= ruleJavaConstantReference ) ) otherlv_2= '>' )
            {
            // InternalDSL.g:5439:1: (otherlv_0= '<' ( (lv_constant_1_0= ruleJavaConstantReference ) ) otherlv_2= '>' )
            // InternalDSL.g:5439:3: otherlv_0= '<' ( (lv_constant_1_0= ruleJavaConstantReference ) ) otherlv_2= '>'
            {
            otherlv_0=(Token)match(input,74,FOLLOW_5); 

                	newLeafNode(otherlv_0, grammarAccess.getJavaConstantValueAccess().getLessThanSignKeyword_0());
                
            // InternalDSL.g:5443:1: ( (lv_constant_1_0= ruleJavaConstantReference ) )
            // InternalDSL.g:5444:1: (lv_constant_1_0= ruleJavaConstantReference )
            {
            // InternalDSL.g:5444:1: (lv_constant_1_0= ruleJavaConstantReference )
            // InternalDSL.g:5445:3: lv_constant_1_0= ruleJavaConstantReference
            {
             
            	        newCompositeNode(grammarAccess.getJavaConstantValueAccess().getConstantJavaConstantReferenceParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_74);
            lv_constant_1_0=ruleJavaConstantReference();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getJavaConstantValueRule());
            	        }
                   		set(
                   			current, 
                   			"constant",
                    		lv_constant_1_0, 
                    		"de.gebit.integrity.DSL.JavaConstantReference");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,75,FOLLOW_2); 

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
    // InternalDSL.g:5473:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalDSL.g:5474:2: (iv_ruleVariable= ruleVariable EOF )
            // InternalDSL.g:5475:2: iv_ruleVariable= ruleVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:5482:1: ruleVariable returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) (otherlv_1= '#' ( (lv_attribute_2_0= ruleQualifiedName ) ) )? ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_attribute_2_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:5485:28: ( ( ( ( ruleQualifiedName ) ) (otherlv_1= '#' ( (lv_attribute_2_0= ruleQualifiedName ) ) )? ) )
            // InternalDSL.g:5486:1: ( ( ( ruleQualifiedName ) ) (otherlv_1= '#' ( (lv_attribute_2_0= ruleQualifiedName ) ) )? )
            {
            // InternalDSL.g:5486:1: ( ( ( ruleQualifiedName ) ) (otherlv_1= '#' ( (lv_attribute_2_0= ruleQualifiedName ) ) )? )
            // InternalDSL.g:5486:2: ( ( ruleQualifiedName ) ) (otherlv_1= '#' ( (lv_attribute_2_0= ruleQualifiedName ) ) )?
            {
            // InternalDSL.g:5486:2: ( ( ruleQualifiedName ) )
            // InternalDSL.g:5487:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:5487:1: ( ruleQualifiedName )
            // InternalDSL.g:5488:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getVariableRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getVariableAccess().getNameVariableOrConstantEntityCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_75);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalDSL.g:5501:2: (otherlv_1= '#' ( (lv_attribute_2_0= ruleQualifiedName ) ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==76) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalDSL.g:5501:4: otherlv_1= '#' ( (lv_attribute_2_0= ruleQualifiedName ) )
                    {
                    otherlv_1=(Token)match(input,76,FOLLOW_5); 

                        	newLeafNode(otherlv_1, grammarAccess.getVariableAccess().getNumberSignKeyword_1_0());
                        
                    // InternalDSL.g:5505:1: ( (lv_attribute_2_0= ruleQualifiedName ) )
                    // InternalDSL.g:5506:1: (lv_attribute_2_0= ruleQualifiedName )
                    {
                    // InternalDSL.g:5506:1: (lv_attribute_2_0= ruleQualifiedName )
                    // InternalDSL.g:5507:3: lv_attribute_2_0= ruleQualifiedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariableAccess().getAttributeQualifiedNameParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_2);
                    lv_attribute_2_0=ruleQualifiedName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVariableRule());
                    	        }
                           		set(
                           			current, 
                           			"attribute",
                            		lv_attribute_2_0, 
                            		"de.gebit.integrity.DSL.QualifiedName");
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
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleVariableVariable"
    // InternalDSL.g:5531:1: entryRuleVariableVariable returns [EObject current=null] : iv_ruleVariableVariable= ruleVariableVariable EOF ;
    public final EObject entryRuleVariableVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableVariable = null;


        try {
            // InternalDSL.g:5532:2: (iv_ruleVariableVariable= ruleVariableVariable EOF )
            // InternalDSL.g:5533:2: iv_ruleVariableVariable= ruleVariableVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableVariable=ruleVariableVariable();

            state._fsp--;

             current =iv_ruleVariableVariable; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:5540:1: ruleVariableVariable returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleVariableVariable() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5543:28: ( ( ( ruleQualifiedName ) ) )
            // InternalDSL.g:5544:1: ( ( ruleQualifiedName ) )
            {
            // InternalDSL.g:5544:1: ( ( ruleQualifiedName ) )
            // InternalDSL.g:5545:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:5545:1: ( ruleQualifiedName )
            // InternalDSL.g:5546:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getVariableVariableRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getVariableVariableAccess().getNameVariableEntityCrossReference_0()); 
            	    
            pushFollow(FOLLOW_2);
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
    // InternalDSL.g:5567:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalDSL.g:5568:2: (iv_ruleConstant= ruleConstant EOF )
            // InternalDSL.g:5569:2: iv_ruleConstant= ruleConstant EOF
            {
             newCompositeNode(grammarAccess.getConstantRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConstant=ruleConstant();

            state._fsp--;

             current =iv_ruleConstant; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:5576:1: ruleConstant returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5579:28: ( ( ( ruleQualifiedName ) ) )
            // InternalDSL.g:5580:1: ( ( ruleQualifiedName ) )
            {
            // InternalDSL.g:5580:1: ( ( ruleQualifiedName ) )
            // InternalDSL.g:5581:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:5581:1: ( ruleQualifiedName )
            // InternalDSL.g:5582:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getConstantRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getConstantAccess().getNameConstantEntityCrossReference_0()); 
            	    
            pushFollow(FOLLOW_2);
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
    // InternalDSL.g:5603:1: entryRuleNullValue returns [EObject current=null] : iv_ruleNullValue= ruleNullValue EOF ;
    public final EObject entryRuleNullValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullValue = null;


        try {
            // InternalDSL.g:5604:2: (iv_ruleNullValue= ruleNullValue EOF )
            // InternalDSL.g:5605:2: iv_ruleNullValue= ruleNullValue EOF
            {
             newCompositeNode(grammarAccess.getNullValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNullValue=ruleNullValue();

            state._fsp--;

             current =iv_ruleNullValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:5612:1: ruleNullValue returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5615:28: ( ( () otherlv_1= 'null' ) )
            // InternalDSL.g:5616:1: ( () otherlv_1= 'null' )
            {
            // InternalDSL.g:5616:1: ( () otherlv_1= 'null' )
            // InternalDSL.g:5616:2: () otherlv_1= 'null'
            {
            // InternalDSL.g:5616:2: ()
            // InternalDSL.g:5617:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNullValueAccess().getNullAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,77,FOLLOW_2); 

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
    // InternalDSL.g:5634:1: entryRuleEnumValue returns [EObject current=null] : iv_ruleEnumValue= ruleEnumValue EOF ;
    public final EObject entryRuleEnumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumValue = null;


        try {
            // InternalDSL.g:5635:2: (iv_ruleEnumValue= ruleEnumValue EOF )
            // InternalDSL.g:5636:2: iv_ruleEnumValue= ruleEnumValue EOF
            {
             newCompositeNode(grammarAccess.getEnumValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumValue=ruleEnumValue();

            state._fsp--;

             current =iv_ruleEnumValue; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:5643:1: ruleEnumValue returns [EObject current=null] : ( (otherlv_0= RULE_UPPERCASE_ID ) ) ;
    public final EObject ruleEnumValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5646:28: ( ( (otherlv_0= RULE_UPPERCASE_ID ) ) )
            // InternalDSL.g:5647:1: ( (otherlv_0= RULE_UPPERCASE_ID ) )
            {
            // InternalDSL.g:5647:1: ( (otherlv_0= RULE_UPPERCASE_ID ) )
            // InternalDSL.g:5648:1: (otherlv_0= RULE_UPPERCASE_ID )
            {
            // InternalDSL.g:5648:1: (otherlv_0= RULE_UPPERCASE_ID )
            // InternalDSL.g:5649:3: otherlv_0= RULE_UPPERCASE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getEnumValueRule());
            	        }
                    
            otherlv_0=(Token)match(input,RULE_UPPERCASE_ID,FOLLOW_2); 

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
    // InternalDSL.g:5668:1: entryRuleNestedObject returns [EObject current=null] : iv_ruleNestedObject= ruleNestedObject EOF ;
    public final EObject entryRuleNestedObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedObject = null;


        try {
            // InternalDSL.g:5669:2: (iv_ruleNestedObject= ruleNestedObject EOF )
            // InternalDSL.g:5670:2: iv_ruleNestedObject= ruleNestedObject EOF
            {
             newCompositeNode(grammarAccess.getNestedObjectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNestedObject=ruleNestedObject();

            state._fsp--;

             current =iv_ruleNestedObject; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:5677:1: ruleNestedObject returns [EObject current=null] : (otherlv_0= '{' ruleNL ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+ otherlv_4= '}' ) ;
    public final EObject ruleNestedObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject lv_attributes_2_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:5680:28: ( (otherlv_0= '{' ruleNL ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+ otherlv_4= '}' ) )
            // InternalDSL.g:5681:1: (otherlv_0= '{' ruleNL ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+ otherlv_4= '}' )
            {
            // InternalDSL.g:5681:1: (otherlv_0= '{' ruleNL ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+ otherlv_4= '}' )
            // InternalDSL.g:5681:3: otherlv_0= '{' ruleNL ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,78,FOLLOW_76); 

                	newLeafNode(otherlv_0, grammarAccess.getNestedObjectAccess().getLeftCurlyBracketKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getNestedObjectAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_76);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:5693:1: ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+
            int cnt75=0;
            loop75:
            do {
                int alt75=2;
                int LA75_0 = input.LA(1);

                if ( ((LA75_0>=RULE_STRING && LA75_0<=RULE_ID)) ) {
                    alt75=1;
                }


                switch (alt75) {
            	case 1 :
            	    // InternalDSL.g:5693:2: ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL
            	    {
            	    // InternalDSL.g:5693:2: ( (lv_attributes_2_0= ruleKeyValuePair ) )
            	    // InternalDSL.g:5694:1: (lv_attributes_2_0= ruleKeyValuePair )
            	    {
            	    // InternalDSL.g:5694:1: (lv_attributes_2_0= ruleKeyValuePair )
            	    // InternalDSL.g:5695:3: lv_attributes_2_0= ruleKeyValuePair
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getNestedObjectAccess().getAttributesKeyValuePairParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_77);
            	    lv_attributes_2_0=ruleKeyValuePair();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getNestedObjectRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"attributes",
            	            		lv_attributes_2_0, 
            	            		"de.gebit.integrity.DSL.KeyValuePair");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	     
            	            newCompositeNode(grammarAccess.getNestedObjectAccess().getNLParserRuleCall_2_1()); 
            	        
            	    pushFollow(FOLLOW_77);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt75 >= 1 ) break loop75;
                        EarlyExitException eee =
                            new EarlyExitException(75, input);
                        throw eee;
                }
                cnt75++;
            } while (true);

            otherlv_4=(Token)match(input,79,FOLLOW_2); 

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
    // InternalDSL.g:5731:1: entryRuleTypedNestedObject returns [EObject current=null] : iv_ruleTypedNestedObject= ruleTypedNestedObject EOF ;
    public final EObject entryRuleTypedNestedObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedNestedObject = null;


        try {
            // InternalDSL.g:5732:2: (iv_ruleTypedNestedObject= ruleTypedNestedObject EOF )
            // InternalDSL.g:5733:2: iv_ruleTypedNestedObject= ruleTypedNestedObject EOF
            {
             newCompositeNode(grammarAccess.getTypedNestedObjectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTypedNestedObject=ruleTypedNestedObject();

            state._fsp--;

             current =iv_ruleTypedNestedObject; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:5740:1: ruleTypedNestedObject returns [EObject current=null] : (otherlv_0= '<' ( (lv_type_1_0= ruleJavaClassReference ) ) otherlv_2= '>' ruleNL ( (lv_nestedObject_4_0= ruleNestedObject ) ) ) ;
    public final EObject ruleTypedNestedObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_type_1_0 = null;

        EObject lv_nestedObject_4_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:5743:28: ( (otherlv_0= '<' ( (lv_type_1_0= ruleJavaClassReference ) ) otherlv_2= '>' ruleNL ( (lv_nestedObject_4_0= ruleNestedObject ) ) ) )
            // InternalDSL.g:5744:1: (otherlv_0= '<' ( (lv_type_1_0= ruleJavaClassReference ) ) otherlv_2= '>' ruleNL ( (lv_nestedObject_4_0= ruleNestedObject ) ) )
            {
            // InternalDSL.g:5744:1: (otherlv_0= '<' ( (lv_type_1_0= ruleJavaClassReference ) ) otherlv_2= '>' ruleNL ( (lv_nestedObject_4_0= ruleNestedObject ) ) )
            // InternalDSL.g:5744:3: otherlv_0= '<' ( (lv_type_1_0= ruleJavaClassReference ) ) otherlv_2= '>' ruleNL ( (lv_nestedObject_4_0= ruleNestedObject ) )
            {
            otherlv_0=(Token)match(input,74,FOLLOW_5); 

                	newLeafNode(otherlv_0, grammarAccess.getTypedNestedObjectAccess().getLessThanSignKeyword_0());
                
            // InternalDSL.g:5748:1: ( (lv_type_1_0= ruleJavaClassReference ) )
            // InternalDSL.g:5749:1: (lv_type_1_0= ruleJavaClassReference )
            {
            // InternalDSL.g:5749:1: (lv_type_1_0= ruleJavaClassReference )
            // InternalDSL.g:5750:3: lv_type_1_0= ruleJavaClassReference
            {
             
            	        newCompositeNode(grammarAccess.getTypedNestedObjectAccess().getTypeJavaClassReferenceParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_74);
            lv_type_1_0=ruleJavaClassReference();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTypedNestedObjectRule());
            	        }
                   		set(
                   			current, 
                   			"type",
                    		lv_type_1_0, 
                    		"de.gebit.integrity.DSL.JavaClassReference");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,75,FOLLOW_78); 

                	newLeafNode(otherlv_2, grammarAccess.getTypedNestedObjectAccess().getGreaterThanSignKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getTypedNestedObjectAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_79);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:5778:1: ( (lv_nestedObject_4_0= ruleNestedObject ) )
            // InternalDSL.g:5779:1: (lv_nestedObject_4_0= ruleNestedObject )
            {
            // InternalDSL.g:5779:1: (lv_nestedObject_4_0= ruleNestedObject )
            // InternalDSL.g:5780:3: lv_nestedObject_4_0= ruleNestedObject
            {
             
            	        newCompositeNode(grammarAccess.getTypedNestedObjectAccess().getNestedObjectNestedObjectParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_nestedObject_4_0=ruleNestedObject();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTypedNestedObjectRule());
            	        }
                   		set(
                   			current, 
                   			"nestedObject",
                    		lv_nestedObject_4_0, 
                    		"de.gebit.integrity.DSL.NestedObject");
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
    // InternalDSL.g:5804:1: entryRuleKeyValuePair returns [EObject current=null] : iv_ruleKeyValuePair= ruleKeyValuePair EOF ;
    public final EObject entryRuleKeyValuePair() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValuePair = null;


        try {
            // InternalDSL.g:5805:2: (iv_ruleKeyValuePair= ruleKeyValuePair EOF )
            // InternalDSL.g:5806:2: iv_ruleKeyValuePair= ruleKeyValuePair EOF
            {
             newCompositeNode(grammarAccess.getKeyValuePairRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleKeyValuePair=ruleKeyValuePair();

            state._fsp--;

             current =iv_ruleKeyValuePair; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:5813:1: ruleKeyValuePair returns [EObject current=null] : ( ( ( (lv_identifier_0_0= RULE_ID ) ) | ( (lv_stringIdentifier_1_0= RULE_STRING ) ) ) ruleNL otherlv_3= ':' ruleNL ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ) ;
    public final EObject ruleKeyValuePair() throws RecognitionException {
        EObject current = null;

        Token lv_identifier_0_0=null;
        Token lv_stringIdentifier_1_0=null;
        Token otherlv_3=null;
        EObject lv_value_5_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:5816:28: ( ( ( ( (lv_identifier_0_0= RULE_ID ) ) | ( (lv_stringIdentifier_1_0= RULE_STRING ) ) ) ruleNL otherlv_3= ':' ruleNL ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ) )
            // InternalDSL.g:5817:1: ( ( ( (lv_identifier_0_0= RULE_ID ) ) | ( (lv_stringIdentifier_1_0= RULE_STRING ) ) ) ruleNL otherlv_3= ':' ruleNL ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            {
            // InternalDSL.g:5817:1: ( ( ( (lv_identifier_0_0= RULE_ID ) ) | ( (lv_stringIdentifier_1_0= RULE_STRING ) ) ) ruleNL otherlv_3= ':' ruleNL ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            // InternalDSL.g:5817:2: ( ( (lv_identifier_0_0= RULE_ID ) ) | ( (lv_stringIdentifier_1_0= RULE_STRING ) ) ) ruleNL otherlv_3= ':' ruleNL ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) )
            {
            // InternalDSL.g:5817:2: ( ( (lv_identifier_0_0= RULE_ID ) ) | ( (lv_stringIdentifier_1_0= RULE_STRING ) ) )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_ID) ) {
                alt76=1;
            }
            else if ( (LA76_0==RULE_STRING) ) {
                alt76=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // InternalDSL.g:5817:3: ( (lv_identifier_0_0= RULE_ID ) )
                    {
                    // InternalDSL.g:5817:3: ( (lv_identifier_0_0= RULE_ID ) )
                    // InternalDSL.g:5818:1: (lv_identifier_0_0= RULE_ID )
                    {
                    // InternalDSL.g:5818:1: (lv_identifier_0_0= RULE_ID )
                    // InternalDSL.g:5819:3: lv_identifier_0_0= RULE_ID
                    {
                    lv_identifier_0_0=(Token)match(input,RULE_ID,FOLLOW_15); 

                    			newLeafNode(lv_identifier_0_0, grammarAccess.getKeyValuePairAccess().getIdentifierIDTerminalRuleCall_0_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeyValuePairRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"identifier",
                            		lv_identifier_0_0, 
                            		"de.gebit.integrity.DSL.ID");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalDSL.g:5836:6: ( (lv_stringIdentifier_1_0= RULE_STRING ) )
                    {
                    // InternalDSL.g:5836:6: ( (lv_stringIdentifier_1_0= RULE_STRING ) )
                    // InternalDSL.g:5837:1: (lv_stringIdentifier_1_0= RULE_STRING )
                    {
                    // InternalDSL.g:5837:1: (lv_stringIdentifier_1_0= RULE_STRING )
                    // InternalDSL.g:5838:3: lv_stringIdentifier_1_0= RULE_STRING
                    {
                    lv_stringIdentifier_1_0=(Token)match(input,RULE_STRING,FOLLOW_15); 

                    			newLeafNode(lv_stringIdentifier_1_0, grammarAccess.getKeyValuePairAccess().getStringIdentifierSTRINGTerminalRuleCall_0_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeyValuePairRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"stringIdentifier",
                            		lv_stringIdentifier_1_0, 
                            		"de.gebit.integrity.DSL.STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

             
                    newCompositeNode(grammarAccess.getKeyValuePairAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_16);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_3=(Token)match(input,35,FOLLOW_17); 

                	newLeafNode(otherlv_3, grammarAccess.getKeyValuePairAccess().getColonKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getKeyValuePairAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_17);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:5874:1: ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) )
            // InternalDSL.g:5875:1: (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // InternalDSL.g:5875:1: (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection )
            // InternalDSL.g:5876:3: lv_value_5_0= ruleValueOrEnumValueOrOperationCollection
            {
             
            	        newCompositeNode(grammarAccess.getKeyValuePairAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_2);
            lv_value_5_0=ruleValueOrEnumValueOrOperationCollection();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getKeyValuePairRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_5_0, 
                    		"de.gebit.integrity.DSL.ValueOrEnumValueOrOperationCollection");
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
    // InternalDSL.g:5900:1: entryRuleJavaClassReference returns [EObject current=null] : iv_ruleJavaClassReference= ruleJavaClassReference EOF ;
    public final EObject entryRuleJavaClassReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaClassReference = null;


        try {
            // InternalDSL.g:5901:2: (iv_ruleJavaClassReference= ruleJavaClassReference EOF )
            // InternalDSL.g:5902:2: iv_ruleJavaClassReference= ruleJavaClassReference EOF
            {
             newCompositeNode(grammarAccess.getJavaClassReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJavaClassReference=ruleJavaClassReference();

            state._fsp--;

             current =iv_ruleJavaClassReference; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:5909:1: ruleJavaClassReference returns [EObject current=null] : ( ( ruleQualifiedJavaClassName ) ) ;
    public final EObject ruleJavaClassReference() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5912:28: ( ( ( ruleQualifiedJavaClassName ) ) )
            // InternalDSL.g:5913:1: ( ( ruleQualifiedJavaClassName ) )
            {
            // InternalDSL.g:5913:1: ( ( ruleQualifiedJavaClassName ) )
            // InternalDSL.g:5914:1: ( ruleQualifiedJavaClassName )
            {
            // InternalDSL.g:5914:1: ( ruleQualifiedJavaClassName )
            // InternalDSL.g:5915:3: ruleQualifiedJavaClassName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getJavaClassReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getJavaClassReferenceAccess().getTypeJvmTypeCrossReference_0()); 
            	    
            pushFollow(FOLLOW_2);
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
    // InternalDSL.g:5936:1: entryRuleMethodReference returns [EObject current=null] : iv_ruleMethodReference= ruleMethodReference EOF ;
    public final EObject entryRuleMethodReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodReference = null;


        try {
            // InternalDSL.g:5937:2: (iv_ruleMethodReference= ruleMethodReference EOF )
            // InternalDSL.g:5938:2: iv_ruleMethodReference= ruleMethodReference EOF
            {
             newCompositeNode(grammarAccess.getMethodReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMethodReference=ruleMethodReference();

            state._fsp--;

             current =iv_ruleMethodReference; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:5945:1: ruleMethodReference returns [EObject current=null] : ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleMethodReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5948:28: ( ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalDSL.g:5949:1: ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalDSL.g:5949:1: ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) )
            // InternalDSL.g:5949:2: ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) )
            {
            // InternalDSL.g:5949:2: ( ( ruleQualifiedJavaClassName ) )
            // InternalDSL.g:5950:1: ( ruleQualifiedJavaClassName )
            {
            // InternalDSL.g:5950:1: ( ruleQualifiedJavaClassName )
            // InternalDSL.g:5951:3: ruleQualifiedJavaClassName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMethodReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getMethodReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_80);
            ruleQualifiedJavaClassName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,76,FOLLOW_81); 

                	newLeafNode(otherlv_1, grammarAccess.getMethodReferenceAccess().getNumberSignKeyword_1());
                
            // InternalDSL.g:5968:1: ( (otherlv_2= RULE_ID ) )
            // InternalDSL.g:5969:1: (otherlv_2= RULE_ID )
            {
            // InternalDSL.g:5969:1: (otherlv_2= RULE_ID )
            // InternalDSL.g:5970:3: otherlv_2= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMethodReferenceRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

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
    // InternalDSL.g:5989:1: entryRuleJavaConstantReference returns [EObject current=null] : iv_ruleJavaConstantReference= ruleJavaConstantReference EOF ;
    public final EObject entryRuleJavaConstantReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaConstantReference = null;


        try {
            // InternalDSL.g:5990:2: (iv_ruleJavaConstantReference= ruleJavaConstantReference EOF )
            // InternalDSL.g:5991:2: iv_ruleJavaConstantReference= ruleJavaConstantReference EOF
            {
             newCompositeNode(grammarAccess.getJavaConstantReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleJavaConstantReference=ruleJavaConstantReference();

            state._fsp--;

             current =iv_ruleJavaConstantReference; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:5998:1: ruleJavaConstantReference returns [EObject current=null] : ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_UPPERCASE_ID ) ) ) ;
    public final EObject ruleJavaConstantReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:6001:28: ( ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_UPPERCASE_ID ) ) ) )
            // InternalDSL.g:6002:1: ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_UPPERCASE_ID ) ) )
            {
            // InternalDSL.g:6002:1: ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_UPPERCASE_ID ) ) )
            // InternalDSL.g:6002:2: ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_UPPERCASE_ID ) )
            {
            // InternalDSL.g:6002:2: ( ( ruleQualifiedJavaClassName ) )
            // InternalDSL.g:6003:1: ( ruleQualifiedJavaClassName )
            {
            // InternalDSL.g:6003:1: ( ruleQualifiedJavaClassName )
            // InternalDSL.g:6004:3: ruleQualifiedJavaClassName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getJavaConstantReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getJavaConstantReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_80);
            ruleQualifiedJavaClassName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,76,FOLLOW_82); 

                	newLeafNode(otherlv_1, grammarAccess.getJavaConstantReferenceAccess().getNumberSignKeyword_1());
                
            // InternalDSL.g:6021:1: ( (otherlv_2= RULE_UPPERCASE_ID ) )
            // InternalDSL.g:6022:1: (otherlv_2= RULE_UPPERCASE_ID )
            {
            // InternalDSL.g:6022:1: (otherlv_2= RULE_UPPERCASE_ID )
            // InternalDSL.g:6023:3: otherlv_2= RULE_UPPERCASE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getJavaConstantReferenceRule());
            	        }
                    
            otherlv_2=(Token)match(input,RULE_UPPERCASE_ID,FOLLOW_2); 

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
    // InternalDSL.g:6042:1: entryRuleExecutionMultiplier returns [EObject current=null] : iv_ruleExecutionMultiplier= ruleExecutionMultiplier EOF ;
    public final EObject entryRuleExecutionMultiplier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExecutionMultiplier = null;


        try {
            // InternalDSL.g:6043:2: (iv_ruleExecutionMultiplier= ruleExecutionMultiplier EOF )
            // InternalDSL.g:6044:2: iv_ruleExecutionMultiplier= ruleExecutionMultiplier EOF
            {
             newCompositeNode(grammarAccess.getExecutionMultiplierRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExecutionMultiplier=ruleExecutionMultiplier();

            state._fsp--;

             current =iv_ruleExecutionMultiplier; 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:6051:1: ruleExecutionMultiplier returns [EObject current=null] : ( ( (lv_count_0_0= ruleConstantValue ) ) otherlv_1= '*' ) ;
    public final EObject ruleExecutionMultiplier() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_count_0_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:6054:28: ( ( ( (lv_count_0_0= ruleConstantValue ) ) otherlv_1= '*' ) )
            // InternalDSL.g:6055:1: ( ( (lv_count_0_0= ruleConstantValue ) ) otherlv_1= '*' )
            {
            // InternalDSL.g:6055:1: ( ( (lv_count_0_0= ruleConstantValue ) ) otherlv_1= '*' )
            // InternalDSL.g:6055:2: ( (lv_count_0_0= ruleConstantValue ) ) otherlv_1= '*'
            {
            // InternalDSL.g:6055:2: ( (lv_count_0_0= ruleConstantValue ) )
            // InternalDSL.g:6056:1: (lv_count_0_0= ruleConstantValue )
            {
            // InternalDSL.g:6056:1: (lv_count_0_0= ruleConstantValue )
            // InternalDSL.g:6057:3: lv_count_0_0= ruleConstantValue
            {
             
            	        newCompositeNode(grammarAccess.getExecutionMultiplierAccess().getCountConstantValueParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_83);
            lv_count_0_0=ruleConstantValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExecutionMultiplierRule());
            	        }
                   		set(
                   			current, 
                   			"count",
                    		lv_count_0_0, 
                    		"de.gebit.integrity.DSL.ConstantValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,66,FOLLOW_2); 

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
    // InternalDSL.g:6085:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalDSL.g:6086:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalDSL.g:6087:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:6094:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:6097:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalDSL.g:6098:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalDSL.g:6098:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalDSL.g:6098:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_84); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // InternalDSL.g:6105:1: (kw= '.' this_ID_2= RULE_ID )*
            loop77:
            do {
                int alt77=2;
                int LA77_0 = input.LA(1);

                if ( (LA77_0==80) ) {
                    int LA77_2 = input.LA(2);

                    if ( (LA77_2==RULE_ID) ) {
                        alt77=1;
                    }


                }


                switch (alt77) {
            	case 1 :
            	    // InternalDSL.g:6106:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,80,FOLLOW_81); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_84); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop77;
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
    // InternalDSL.g:6126:1: entryRuleQualifiedJavaClassName returns [String current=null] : iv_ruleQualifiedJavaClassName= ruleQualifiedJavaClassName EOF ;
    public final String entryRuleQualifiedJavaClassName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedJavaClassName = null;


        try {
            // InternalDSL.g:6127:2: (iv_ruleQualifiedJavaClassName= ruleQualifiedJavaClassName EOF )
            // InternalDSL.g:6128:2: iv_ruleQualifiedJavaClassName= ruleQualifiedJavaClassName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedJavaClassNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedJavaClassName=ruleQualifiedJavaClassName();

            state._fsp--;

             current =iv_ruleQualifiedJavaClassName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:6135:1: ruleQualifiedJavaClassName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedJavaClassName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_UPPERCASE_ID_2=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:6138:28: ( (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID ) )
            // InternalDSL.g:6139:1: (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID )
            {
            // InternalDSL.g:6139:1: (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID )
            // InternalDSL.g:6140:5: this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID
            {
             
                    newCompositeNode(grammarAccess.getQualifiedJavaClassNameAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_85);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            kw=(Token)match(input,80,FOLLOW_82); 

                    current.merge(kw);
                    newLeafNode(kw, grammarAccess.getQualifiedJavaClassNameAccess().getFullStopKeyword_1()); 
                
            this_UPPERCASE_ID_2=(Token)match(input,RULE_UPPERCASE_ID,FOLLOW_2); 

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
    // InternalDSL.g:6171:1: entryRuleQualifiedNameWithWildcard returns [String current=null] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;


        try {
            // InternalDSL.g:6172:2: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // InternalDSL.g:6173:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameWithWildcardRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedNameWithWildcard=ruleQualifiedNameWithWildcard();

            state._fsp--;

             current =iv_ruleQualifiedNameWithWildcard.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:6180:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:6183:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // InternalDSL.g:6184:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // InternalDSL.g:6184:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // InternalDSL.g:6185:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_86);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:6195:1: (kw= '.*' )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==81) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalDSL.g:6196:2: kw= '.*'
                    {
                    kw=(Token)match(input,81,FOLLOW_2); 

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
    // InternalDSL.g:6209:1: entryRuleNL returns [String current=null] : iv_ruleNL= ruleNL EOF ;
    public final String entryRuleNL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNL = null;


        try {
            // InternalDSL.g:6210:2: (iv_ruleNL= ruleNL EOF )
            // InternalDSL.g:6211:2: iv_ruleNL= ruleNL EOF
            {
             newCompositeNode(grammarAccess.getNLRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNL=ruleNL();

            state._fsp--;

             current =iv_ruleNL.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:6218:1: ruleNL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? )* ;
    public final AntlrDatatypeRuleToken ruleNL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_NEWLINE_0=null;
        Token this_WS_1=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:6221:28: ( (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? )* )
            // InternalDSL.g:6222:1: (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? )*
            {
            // InternalDSL.g:6222:1: (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? )*
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==RULE_NEWLINE) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // InternalDSL.g:6222:6: this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )?
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_87); 

            	    		current.merge(this_NEWLINE_0);
            	        
            	     
            	        newLeafNode(this_NEWLINE_0, grammarAccess.getNLAccess().getNEWLINETerminalRuleCall_0()); 
            	        
            	    // InternalDSL.g:6229:1: (this_WS_1= RULE_WS )?
            	    int alt79=2;
            	    int LA79_0 = input.LA(1);

            	    if ( (LA79_0==RULE_WS) ) {
            	        alt79=1;
            	    }
            	    switch (alt79) {
            	        case 1 :
            	            // InternalDSL.g:6229:6: this_WS_1= RULE_WS
            	            {
            	            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_88); 

            	            		current.merge(this_WS_1);
            	                
            	             
            	                newLeafNode(this_WS_1, grammarAccess.getNLAccess().getWSTerminalRuleCall_1()); 
            	                

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop80;
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
    // InternalDSL.g:6244:1: entryRuleNLFORCED returns [String current=null] : iv_ruleNLFORCED= ruleNLFORCED EOF ;
    public final String entryRuleNLFORCED() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNLFORCED = null;


        try {
            // InternalDSL.g:6245:2: (iv_ruleNLFORCED= ruleNLFORCED EOF )
            // InternalDSL.g:6246:2: iv_ruleNLFORCED= ruleNLFORCED EOF
            {
             newCompositeNode(grammarAccess.getNLFORCEDRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNLFORCED=ruleNLFORCED();

            state._fsp--;

             current =iv_ruleNLFORCED.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

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
    // InternalDSL.g:6253:1: ruleNLFORCED returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? this_NL_2= ruleNL ) ;
    public final AntlrDatatypeRuleToken ruleNLFORCED() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_NEWLINE_0=null;
        Token this_WS_1=null;
        AntlrDatatypeRuleToken this_NL_2 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:6256:28: ( (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? this_NL_2= ruleNL ) )
            // InternalDSL.g:6257:1: (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? this_NL_2= ruleNL )
            {
            // InternalDSL.g:6257:1: (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? this_NL_2= ruleNL )
            // InternalDSL.g:6257:6: this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? this_NL_2= ruleNL
            {
            this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_89); 

            		current.merge(this_NEWLINE_0);
                
             
                newLeafNode(this_NEWLINE_0, grammarAccess.getNLFORCEDAccess().getNEWLINETerminalRuleCall_0()); 
                
            // InternalDSL.g:6264:1: (this_WS_1= RULE_WS )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==RULE_WS) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalDSL.g:6264:6: this_WS_1= RULE_WS
                    {
                    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_4); 

                    		current.merge(this_WS_1);
                        
                     
                        newLeafNode(this_WS_1, grammarAccess.getNLFORCEDAccess().getWSTerminalRuleCall_1()); 
                        

                    }
                    break;

            }

             
                    newCompositeNode(grammarAccess.getNLFORCEDAccess().getNLParserRuleCall_2()); 
                
            pushFollow(FOLLOW_2);
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
    protected DFA24 dfa24 = new DFA24(this);
    protected DFA35 dfa35 = new DFA35(this);
    protected DFA36 dfa36 = new DFA36(this);
    protected DFA37 dfa37 = new DFA37(this);
    protected DFA38 dfa38 = new DFA38(this);
    protected DFA42 dfa42 = new DFA42(this);
    protected DFA48 dfa48 = new DFA48(this);
    protected DFA49 dfa49 = new DFA49(this);
    protected DFA50 dfa50 = new DFA50(this);
    protected DFA51 dfa51 = new DFA51(this);
    protected DFA52 dfa52 = new DFA52(this);
    protected DFA53 dfa53 = new DFA53(this);
    protected DFA63 dfa63 = new DFA63(this);
    protected DFA64 dfa64 = new DFA64(this);
    protected DFA65 dfa65 = new DFA65(this);
    protected DFA67 dfa67 = new DFA67(this);
    protected DFA69 dfa69 = new DFA69(this);
    protected DFA73 dfa73 = new DFA73(this);
    static final String dfa_1s = "\13\uffff";
    static final String dfa_2s = "\1\37\1\uffff\1\41\10\uffff";
    static final String dfa_3s = "\1\62\1\uffff\1\62\10\uffff";
    static final String dfa_4s = "\1\uffff\1\1\1\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11";
    static final String dfa_5s = "\13\uffff}>";
    static final String[] dfa_6s = {
            "\1\1\1\2\1\3\2\uffff\1\4\1\5\1\6\2\10\6\uffff\1\7\1\11\1\uffff\1\12",
            "",
            "\1\3\5\uffff\2\10\7\uffff\1\11\1\uffff\1\12",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "641:1: (this_Import_0= ruleImport | this_ForkDefinition_1= ruleForkDefinition | this_VariantDefinition_2= ruleVariantDefinition | this_TestDefinition_3= ruleTestDefinition | this_CallDefinition_4= ruleCallDefinition | this_OperationDefinition_5= ruleOperationDefinition | this_SuiteDefinition_6= ruleSuiteDefinition | this_VariableDefinition_7= ruleVariableDefinition | this_ConstantDefinition_8= ruleConstantDefinition )";
        }
    }
    static final String dfa_7s = "\5\uffff";
    static final String dfa_8s = "\1\3\4\uffff";
    static final String dfa_9s = "\2\12\2\uffff\1\12";
    static final String dfa_10s = "\2\56\2\uffff\1\56";
    static final String dfa_11s = "\2\uffff\1\1\1\2\1\uffff";
    static final String dfa_12s = "\5\uffff}>";
    static final String[] dfa_13s = {
            "\1\3\13\uffff\1\1\6\uffff\1\3\14\uffff\3\3\1\uffff\1\2",
            "\1\3\13\uffff\1\1\1\4\5\uffff\1\3\14\uffff\3\3\1\uffff\1\2",
            "",
            "",
            "\1\3\13\uffff\1\1\6\uffff\1\3\14\uffff\3\3\1\uffff\1\2"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA24 extends DFA {

        public DFA24(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 24;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "1609:2: ( ruleNL otherlv_2= 'by default' ( (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection ) ) )?";
        }
    }
    static final String dfa_14s = "\2\4\3\uffff\1\4\5\uffff";
    static final String dfa_15s = "\2\4\1\26\1\11\1\uffff\1\4\1\26\1\uffff\3\26";
    static final String dfa_16s = "\2\77\1\71\1\12\1\uffff\1\77\1\71\1\uffff\3\71";
    static final String dfa_17s = "\4\uffff\1\2\2\uffff\1\1\3\uffff";
    static final String[] dfa_18s = {
            "\5\4\1\uffff\1\2\13\uffff\1\1\11\uffff\1\4\14\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\4\2\uffff\4\4\1\uffff\2\4\1\uffff\1\3",
            "\5\4\1\uffff\1\2\13\uffff\1\1\1\5\10\uffff\1\4\14\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\4\2\uffff\4\4\1\uffff\2\4\1\uffff\1\3",
            "\1\6\14\uffff\1\7\25\uffff\1\4",
            "\1\11\1\10",
            "",
            "\5\4\1\uffff\1\2\13\uffff\1\1\11\uffff\1\4\14\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\4\2\uffff\4\4\1\uffff\2\4\1\uffff\1\3",
            "\1\6\1\12\13\uffff\1\7\25\uffff\1\4",
            "",
            "\1\6\14\uffff\1\7\25\uffff\1\4",
            "\1\6\14\uffff\1\7\25\uffff\1\4",
            "\1\6\14\uffff\1\7\25\uffff\1\4"
    };
    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[][] dfa_18 = unpackEncodedStringArray(dfa_18s);

    class DFA35 extends DFA {

        public DFA35(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 35;
            this.eot = dfa_1;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_5;
            this.transition = dfa_18;
        }
        public String getDescription() {
            return "()* loopback of 2502:2: ( ruleNL ( (lv_parameters_5_0= ruleParameter ) ) )*";
        }
    }
    static final String dfa_19s = "\2\2\2\uffff\1\2";
    static final String dfa_20s = "\2\4\2\uffff\1\4";
    static final String dfa_21s = "\2\77\2\uffff\1\77";
    static final String dfa_22s = "\2\uffff\1\2\1\1\1\uffff";
    static final String[] dfa_23s = {
            "\5\2\1\uffff\1\3\13\uffff\1\1\11\uffff\1\2\14\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\1\2\2\uffff\4\2\1\uffff\2\2\1\uffff\1\3",
            "\5\2\1\uffff\1\3\13\uffff\1\1\1\4\10\uffff\1\2\14\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\1\2\2\uffff\4\2\1\uffff\2\2\1\uffff\1\3",
            "",
            "",
            "\5\2\1\uffff\1\3\13\uffff\1\1\11\uffff\1\2\14\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\1\2\2\uffff\4\2\1\uffff\2\2\1\uffff\1\3"
    };
    static final short[] dfa_19 = DFA.unpackEncodedString(dfa_19s);
    static final char[] dfa_20 = DFA.unpackEncodedStringToUnsignedChars(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final short[] dfa_22 = DFA.unpackEncodedString(dfa_22s);
    static final short[][] dfa_23 = unpackEncodedStringArray(dfa_23s);

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = dfa_7;
            this.eof = dfa_19;
            this.min = dfa_20;
            this.max = dfa_21;
            this.accept = dfa_22;
            this.special = dfa_12;
            this.transition = dfa_23;
        }
        public String getDescription() {
            return "()* loopback of 2528:4: ( ruleNL ( (lv_results_7_0= ruleNamedResult ) ) )*";
        }
    }
    static final String dfa_24s = "\2\3\2\uffff\1\3";
    static final String dfa_25s = "\2\75\2\uffff\1\75";
    static final String[] dfa_26s = {
            "\5\3\15\uffff\1\1\11\uffff\1\3\14\uffff\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\3\2\uffff\2\3\1\2\1\3\1\uffff\2\3",
            "\5\3\15\uffff\1\1\1\4\10\uffff\1\3\14\uffff\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\3\2\uffff\2\3\1\2\1\3\1\uffff\2\3",
            "",
            "",
            "\5\3\15\uffff\1\1\11\uffff\1\3\14\uffff\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\3\2\uffff\2\3\1\2\1\3\1\uffff\2\3"
    };
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final char[] dfa_25 = DFA.unpackEncodedStringToUnsignedChars(dfa_25s);
    static final short[][] dfa_26 = unpackEncodedStringArray(dfa_26s);

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = dfa_7;
            this.eof = dfa_24;
            this.min = dfa_20;
            this.max = dfa_25;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_26;
        }
        public String getDescription() {
            return "2554:4: ( ruleNL otherlv_9= '=' ruleNL ( (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection ) ) )?";
        }
    }
    static final String dfa_27s = "\7\uffff";
    static final String dfa_28s = "\2\12\1\uffff\2\12\1\uffff\1\12";
    static final String dfa_29s = "\2\77\1\uffff\2\77\1\uffff\1\77";
    static final String dfa_30s = "\2\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String dfa_31s = "\7\uffff}>";
    static final String[] dfa_32s = {
            "\1\2\13\uffff\1\1\50\uffff\1\2",
            "\1\2\13\uffff\1\4\1\3\43\uffff\1\5\3\uffff\1\2",
            "",
            "\1\2\13\uffff\1\4\44\uffff\1\5\3\uffff\1\2",
            "\1\2\13\uffff\1\4\1\6\43\uffff\1\5\3\uffff\1\2",
            "",
            "\1\2\13\uffff\1\4\44\uffff\1\5\3\uffff\1\2"
    };

    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final char[] dfa_28 = DFA.unpackEncodedStringToUnsignedChars(dfa_28s);
    static final char[] dfa_29 = DFA.unpackEncodedStringToUnsignedChars(dfa_29s);
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final short[] dfa_31 = DFA.unpackEncodedString(dfa_31s);
    static final short[][] dfa_32 = unpackEncodedStringArray(dfa_32s);

    class DFA38 extends DFA {

        public DFA38(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 38;
            this.eot = dfa_27;
            this.eof = dfa_27;
            this.min = dfa_28;
            this.max = dfa_29;
            this.accept = dfa_30;
            this.special = dfa_31;
            this.transition = dfa_32;
        }
        public String getDescription() {
            return "()* loopback of 2648:2: ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )*";
        }
    }
    static final String dfa_33s = "\1\uffff\3\4\2\uffff\1\4";
    static final String dfa_34s = "\1\26\3\4\2\uffff\1\4";
    static final String dfa_35s = "\1\26\3\75\2\uffff\1\75";
    static final String dfa_36s = "\4\uffff\1\2\1\1\1\uffff";
    static final String[] dfa_37s = {
            "\1\1",
            "\5\4\15\uffff\1\3\1\2\10\uffff\1\4\14\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\4\2\uffff\2\4\1\uffff\1\4\1\5\2\4",
            "\5\4\15\uffff\1\3\11\uffff\1\4\14\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\4\2\uffff\2\4\1\uffff\1\4\1\5\2\4",
            "\5\4\15\uffff\1\3\1\6\10\uffff\1\4\14\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\4\2\uffff\2\4\1\uffff\1\4\1\5\2\4",
            "",
            "",
            "\5\4\15\uffff\1\3\11\uffff\1\4\14\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\4\2\uffff\2\4\1\uffff\1\4\1\5\2\4"
    };
    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final char[] dfa_34 = DFA.unpackEncodedStringToUnsignedChars(dfa_34s);
    static final char[] dfa_35 = DFA.unpackEncodedStringToUnsignedChars(dfa_35s);
    static final short[] dfa_36 = DFA.unpackEncodedString(dfa_36s);
    static final short[][] dfa_37 = unpackEncodedStringArray(dfa_37s);

    class DFA42 extends DFA {

        public DFA42(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 42;
            this.eot = dfa_27;
            this.eof = dfa_33;
            this.min = dfa_34;
            this.max = dfa_35;
            this.accept = dfa_36;
            this.special = dfa_31;
            this.transition = dfa_37;
        }
        public String getDescription() {
            return "()+ loopback of 2741:3: ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+";
        }
    }
    static final String dfa_38s = "\6\uffff";
    static final String dfa_39s = "\2\uffff\1\4\2\uffff\1\4";
    static final String dfa_40s = "\1\11\1\uffff\1\4\1\12\1\uffff\1\4";
    static final String dfa_41s = "\1\115\1\uffff\1\120\1\12\1\uffff\1\120";
    static final String dfa_42s = "\1\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String dfa_43s = "\6\uffff}>";
    static final String[] dfa_44s = {
            "\1\1\1\2\12\1\65\uffff\1\1\2\uffff\1\1",
            "",
            "\5\4\1\uffff\1\4\13\uffff\1\4\11\uffff\1\4\14\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\2\4\1\uffff\2\4\1\uffff\1\4\1\uffff\2\4\1\uffff\1\4\2\uffff\1\1\15\uffff\1\3",
            "\1\5",
            "",
            "\5\4\1\uffff\1\4\13\uffff\1\4\11\uffff\1\4\14\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\2\4\1\uffff\2\4\1\uffff\1\4\1\uffff\2\4\1\uffff\1\4\2\uffff\1\1\15\uffff\1\3"
    };

    static final short[] dfa_38 = DFA.unpackEncodedString(dfa_38s);
    static final short[] dfa_39 = DFA.unpackEncodedString(dfa_39s);
    static final char[] dfa_40 = DFA.unpackEncodedStringToUnsignedChars(dfa_40s);
    static final char[] dfa_41 = DFA.unpackEncodedStringToUnsignedChars(dfa_41s);
    static final short[] dfa_42 = DFA.unpackEncodedString(dfa_42s);
    static final short[] dfa_43 = DFA.unpackEncodedString(dfa_43s);
    static final short[][] dfa_44 = unpackEncodedStringArray(dfa_44s);

    class DFA48 extends DFA {

        public DFA48(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 48;
            this.eot = dfa_38;
            this.eof = dfa_39;
            this.min = dfa_40;
            this.max = dfa_41;
            this.accept = dfa_42;
            this.special = dfa_43;
            this.transition = dfa_44;
        }
        public String getDescription() {
            return "3149:1: ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )?";
        }
    }
    static final String dfa_45s = "\2\77\1\65\1\12\1\uffff\1\77\1\65\1\uffff\3\65";
    static final String[] dfa_46s = {
            "\5\4\1\uffff\1\2\13\uffff\1\1\11\uffff\1\4\14\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\2\4\1\uffff\2\4\1\uffff\1\4\1\uffff\2\4\1\uffff\1\3",
            "\5\4\1\uffff\1\2\13\uffff\1\1\1\5\10\uffff\1\4\14\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\2\4\1\uffff\2\4\1\uffff\1\4\1\uffff\2\4\1\uffff\1\3",
            "\1\6\14\uffff\1\7\21\uffff\1\4",
            "\1\11\1\10",
            "",
            "\5\4\1\uffff\1\2\13\uffff\1\1\11\uffff\1\4\14\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\2\4\1\uffff\2\4\1\uffff\1\4\1\uffff\2\4\1\uffff\1\3",
            "\1\6\1\12\13\uffff\1\7\21\uffff\1\4",
            "",
            "\1\6\14\uffff\1\7\21\uffff\1\4",
            "\1\6\14\uffff\1\7\21\uffff\1\4",
            "\1\6\14\uffff\1\7\21\uffff\1\4"
    };
    static final char[] dfa_45 = DFA.unpackEncodedStringToUnsignedChars(dfa_45s);
    static final short[][] dfa_46 = unpackEncodedStringArray(dfa_46s);

    class DFA49 extends DFA {

        public DFA49(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 49;
            this.eot = dfa_1;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_45;
            this.accept = dfa_17;
            this.special = dfa_5;
            this.transition = dfa_46;
        }
        public String getDescription() {
            return "()* loopback of 3190:2: ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )*";
        }
    }
    static final String[] dfa_47s = {
            "\5\2\1\uffff\1\3\13\uffff\1\1\11\uffff\1\2\14\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\2\2\1\uffff\2\2\1\uffff\1\2\1\uffff\2\2\1\uffff\1\3",
            "\5\2\1\uffff\1\3\13\uffff\1\1\1\4\10\uffff\1\2\14\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\2\2\1\uffff\2\2\1\uffff\1\2\1\uffff\2\2\1\uffff\1\3",
            "",
            "",
            "\5\2\1\uffff\1\3\13\uffff\1\1\11\uffff\1\2\14\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\2\2\1\uffff\2\2\1\uffff\1\2\1\uffff\2\2\1\uffff\1\3"
    };
    static final short[][] dfa_47 = unpackEncodedStringArray(dfa_47s);

    class DFA50 extends DFA {

        public DFA50(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 50;
            this.eot = dfa_7;
            this.eof = dfa_19;
            this.min = dfa_20;
            this.max = dfa_21;
            this.accept = dfa_22;
            this.special = dfa_12;
            this.transition = dfa_47;
        }
        public String getDescription() {
            return "()* loopback of 3216:4: ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )*";
        }
    }
    static final String[] dfa_48s = {
            "\5\3\15\uffff\1\1\11\uffff\1\3\14\uffff\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\3\1\2\1\uffff\2\3\1\uffff\1\3\1\uffff\2\3",
            "\5\3\15\uffff\1\1\1\4\10\uffff\1\3\14\uffff\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\3\1\2\1\uffff\2\3\1\uffff\1\3\1\uffff\2\3",
            "",
            "",
            "\5\3\15\uffff\1\1\11\uffff\1\3\14\uffff\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\3\1\2\1\uffff\2\3\1\uffff\1\3\1\uffff\2\3"
    };
    static final short[][] dfa_48 = unpackEncodedStringArray(dfa_48s);

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = dfa_7;
            this.eof = dfa_24;
            this.min = dfa_20;
            this.max = dfa_25;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_48;
        }
        public String getDescription() {
            return "3242:4: ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )?";
        }
    }
    static final String[] dfa_49s = {
            "\1\1\1\2\12\1\65\uffff\1\1\2\uffff\1\1",
            "",
            "\5\4\1\uffff\1\4\13\uffff\1\4\11\uffff\1\4\14\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\4\1\uffff\3\4\1\uffff\1\4\1\uffff\3\4\3\uffff\1\1\15\uffff\1\3",
            "\1\5",
            "",
            "\5\4\1\uffff\1\4\13\uffff\1\4\11\uffff\1\4\14\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\4\1\uffff\3\4\1\uffff\1\4\1\uffff\3\4\3\uffff\1\1\15\uffff\1\3"
    };
    static final short[][] dfa_49 = unpackEncodedStringArray(dfa_49s);

    class DFA52 extends DFA {

        public DFA52(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 52;
            this.eot = dfa_38;
            this.eof = dfa_39;
            this.min = dfa_40;
            this.max = dfa_41;
            this.accept = dfa_42;
            this.special = dfa_43;
            this.transition = dfa_49;
        }
        public String getDescription() {
            return "3398:1: ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )?";
        }
    }
    static final String dfa_50s = "\10\uffff";
    static final String dfa_51s = "\1\2\7\uffff";
    static final String dfa_52s = "\1\4\1\26\1\uffff\1\12\1\26\1\uffff\2\26";
    static final String dfa_53s = "\1\76\1\120\1\uffff\1\12\1\65\1\uffff\1\120\1\65";
    static final String dfa_54s = "\2\uffff\1\2\2\uffff\1\1\2\uffff";
    static final String dfa_55s = "\10\uffff}>";
    static final String[] dfa_56s = {
            "\5\2\1\uffff\1\1\25\uffff\1\2\14\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\1\2\1\uffff\3\2\1\uffff\1\2\1\uffff\3\2",
            "\1\4\14\uffff\1\5\21\uffff\1\2\32\uffff\1\3",
            "",
            "\1\6",
            "\1\4\1\7\13\uffff\1\5\21\uffff\1\2",
            "",
            "\1\4\14\uffff\1\5\21\uffff\1\2\32\uffff\1\3",
            "\1\4\14\uffff\1\5\21\uffff\1\2"
    };

    static final short[] dfa_50 = DFA.unpackEncodedString(dfa_50s);
    static final short[] dfa_51 = DFA.unpackEncodedString(dfa_51s);
    static final char[] dfa_52 = DFA.unpackEncodedStringToUnsignedChars(dfa_52s);
    static final char[] dfa_53 = DFA.unpackEncodedStringToUnsignedChars(dfa_53s);
    static final short[] dfa_54 = DFA.unpackEncodedString(dfa_54s);
    static final short[] dfa_55 = DFA.unpackEncodedString(dfa_55s);
    static final short[][] dfa_56 = unpackEncodedStringArray(dfa_56s);

    class DFA53 extends DFA {

        public DFA53(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 53;
            this.eot = dfa_50;
            this.eof = dfa_51;
            this.min = dfa_52;
            this.max = dfa_53;
            this.accept = dfa_54;
            this.special = dfa_55;
            this.transition = dfa_56;
        }
        public String getDescription() {
            return "()* loopback of 3447:1: ( ( (lv_parameters_6_0= ruleSuiteParameter ) ) ruleNL )*";
        }
    }
    static final String dfa_57s = "\1\11\1\uffff\3\12\1\uffff\2\12";
    static final String dfa_58s = "\1\116\1\uffff\1\120\1\12\1\111\1\uffff\1\120\1\111";
    static final String dfa_59s = "\1\uffff\1\1\3\uffff\1\2\2\uffff";
    static final String[] dfa_60s = {
            "\1\1\1\2\13\1\52\uffff\1\1\6\uffff\1\1\2\uffff\1\1\2\uffff\2\1",
            "",
            "\1\1\13\uffff\1\4\6\uffff\1\5\52\uffff\1\5\1\1\2\uffff\1\1\3\uffff\1\3",
            "\1\6",
            "\1\1\13\uffff\1\4\1\7\5\uffff\1\5\52\uffff\1\5\1\1",
            "",
            "\1\1\13\uffff\1\4\6\uffff\1\5\52\uffff\1\5\1\1\2\uffff\1\1\3\uffff\1\3",
            "\1\1\13\uffff\1\4\6\uffff\1\5\52\uffff\1\5\1\1"
    };
    static final char[] dfa_57 = DFA.unpackEncodedStringToUnsignedChars(dfa_57s);
    static final char[] dfa_58 = DFA.unpackEncodedStringToUnsignedChars(dfa_58s);
    static final short[] dfa_59 = DFA.unpackEncodedString(dfa_59s);
    static final short[][] dfa_60 = unpackEncodedStringArray(dfa_60s);

    class DFA63 extends DFA {

        public DFA63(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 63;
            this.eot = dfa_50;
            this.eof = dfa_50;
            this.min = dfa_57;
            this.max = dfa_58;
            this.accept = dfa_59;
            this.special = dfa_55;
            this.transition = dfa_60;
        }
        public String getDescription() {
            return "4178:1: ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )?";
        }
    }
    static final String dfa_61s = "\2\26\2\uffff\1\26";
    static final String dfa_62s = "\2\110\2\uffff\1\110";
    static final String[] dfa_63s = {
            "\1\1\6\uffff\1\2\52\uffff\1\3",
            "\1\1\1\4\5\uffff\1\2\52\uffff\1\3",
            "",
            "",
            "\1\1\6\uffff\1\2\52\uffff\1\3"
    };
    static final char[] dfa_61 = DFA.unpackEncodedStringToUnsignedChars(dfa_61s);
    static final char[] dfa_62 = DFA.unpackEncodedStringToUnsignedChars(dfa_62s);
    static final short[][] dfa_63 = unpackEncodedStringArray(dfa_63s);

    class DFA64 extends DFA {

        public DFA64(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 64;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_61;
            this.max = dfa_62;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_63;
        }
        public String getDescription() {
            return "4219:2: ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )?";
        }
    }
    static final String dfa_64s = "\2\2\2\uffff\3\2";
    static final String dfa_65s = "\2\4\2\uffff\3\4";
    static final String dfa_66s = "\2\117\2\uffff\3\117";
    static final String dfa_67s = "\2\uffff\1\2\1\1\3\uffff";
    static final String[] dfa_68s = {
            "\7\2\13\uffff\1\1\6\uffff\5\2\2\uffff\5\2\1\uffff\4\2\1\uffff\2\2\1\uffff\16\2\10\uffff\1\2\1\3\5\uffff\1\2",
            "\7\2\13\uffff\1\5\1\4\5\uffff\5\2\2\uffff\5\2\1\uffff\4\2\1\uffff\2\2\1\uffff\16\2\10\uffff\1\2\1\3\5\uffff\1\2",
            "",
            "",
            "\7\2\13\uffff\1\5\6\uffff\5\2\2\uffff\5\2\1\uffff\4\2\1\uffff\2\2\1\uffff\16\2\10\uffff\1\2\1\3\5\uffff\1\2",
            "\7\2\13\uffff\1\5\1\6\5\uffff\5\2\2\uffff\5\2\1\uffff\4\2\1\uffff\2\2\1\uffff\16\2\10\uffff\1\2\1\3\5\uffff\1\2",
            "\7\2\13\uffff\1\5\6\uffff\5\2\2\uffff\5\2\1\uffff\4\2\1\uffff\2\2\1\uffff\16\2\10\uffff\1\2\1\3\5\uffff\1\2"
    };
    static final short[] dfa_64 = DFA.unpackEncodedString(dfa_64s);
    static final char[] dfa_65 = DFA.unpackEncodedStringToUnsignedChars(dfa_65s);
    static final char[] dfa_66 = DFA.unpackEncodedStringToUnsignedChars(dfa_66s);
    static final short[] dfa_67 = DFA.unpackEncodedString(dfa_67s);
    static final short[][] dfa_68 = unpackEncodedStringArray(dfa_68s);

    class DFA65 extends DFA {

        public DFA65(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 65;
            this.eot = dfa_27;
            this.eof = dfa_64;
            this.min = dfa_65;
            this.max = dfa_66;
            this.accept = dfa_67;
            this.special = dfa_31;
            this.transition = dfa_68;
        }
        public String getDescription() {
            return "()* loopback of 4300:2: ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )*";
        }
    }
    static final String dfa_69s = "\12\uffff";
    static final String dfa_70s = "\1\11\1\uffff\1\12\2\uffff\1\120\1\12\1\113\1\120\1\uffff";
    static final String dfa_71s = "\1\116\1\uffff\1\12\2\uffff\1\120\1\25\1\114\1\120\1\uffff";
    static final String dfa_72s = "\1\uffff\1\1\1\uffff\1\2\1\3\4\uffff\1\4";
    static final String dfa_73s = "\12\uffff}>";
    static final String[] dfa_74s = {
            "\1\1\1\3\12\1\65\uffff\1\2\2\uffff\1\1\1\4",
            "",
            "\1\5",
            "",
            "",
            "\1\6",
            "\1\10\12\uffff\1\7",
            "\1\11\1\1",
            "\1\6",
            ""
    };

    static final short[] dfa_69 = DFA.unpackEncodedString(dfa_69s);
    static final char[] dfa_70 = DFA.unpackEncodedStringToUnsignedChars(dfa_70s);
    static final char[] dfa_71 = DFA.unpackEncodedStringToUnsignedChars(dfa_71s);
    static final short[] dfa_72 = DFA.unpackEncodedString(dfa_72s);
    static final short[] dfa_73 = DFA.unpackEncodedString(dfa_73s);
    static final short[][] dfa_74 = unpackEncodedStringArray(dfa_74s);

    class DFA67 extends DFA {

        public DFA67(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 67;
            this.eot = dfa_69;
            this.eof = dfa_69;
            this.min = dfa_70;
            this.max = dfa_71;
            this.accept = dfa_72;
            this.special = dfa_73;
            this.transition = dfa_74;
        }
        public String getDescription() {
            return "4409:1: (this_StaticValue_0= ruleStaticValue | this_Variable_1= ruleVariable | this_NestedObject_2= ruleNestedObject | this_TypedNestedObject_3= ruleTypedNestedObject )";
        }
    }
    static final String dfa_75s = "\25\uffff";
    static final String dfa_76s = "\5\uffff\3\13\5\uffff\10\13";
    static final String dfa_77s = "\1\11\4\uffff\3\4\5\uffff\10\4";
    static final String dfa_78s = "\1\115\4\uffff\3\117\5\uffff\10\117";
    static final String dfa_79s = "\1\uffff\1\1\1\2\1\3\1\4\3\uffff\1\6\1\10\1\11\1\5\1\7\10\uffff";
    static final String dfa_80s = "\25\uffff}>";
    static final String[] dfa_81s = {
            "\1\1\1\uffff\1\2\1\3\2\4\1\5\1\6\1\7\3\10\65\uffff\1\12\2\uffff\1\11",
            "",
            "",
            "",
            "",
            "\7\13\7\uffff\1\14\3\uffff\1\13\5\uffff\6\13\2\uffff\5\13\1\uffff\4\13\1\uffff\2\13\1\uffff\16\13\1\uffff\6\13\1\uffff\2\13\5\uffff\1\13",
            "\7\13\10\uffff\2\14\1\uffff\1\15\5\uffff\6\13\2\uffff\5\13\1\uffff\4\13\1\uffff\2\13\1\uffff\16\13\1\uffff\6\13\1\uffff\2\13\5\uffff\1\13",
            "\7\13\11\uffff\1\14\1\uffff\1\16\5\uffff\6\13\2\uffff\5\13\1\uffff\4\13\1\uffff\2\13\1\uffff\16\13\1\uffff\6\13\1\uffff\2\13\5\uffff\1\13",
            "",
            "",
            "",
            "",
            "",
            "\7\13\10\uffff\2\14\1\uffff\1\20\1\17\4\uffff\6\13\2\uffff\5\13\1\uffff\4\13\1\uffff\2\13\1\uffff\16\13\1\uffff\6\13\1\uffff\2\13\5\uffff\1\13",
            "\7\13\11\uffff\1\14\1\uffff\1\22\1\21\4\uffff\6\13\2\uffff\5\13\1\uffff\4\13\1\uffff\2\13\1\uffff\16\13\1\uffff\6\13\1\uffff\2\13\5\uffff\1\13",
            "\7\13\10\uffff\2\14\1\uffff\1\20\5\uffff\6\13\2\uffff\5\13\1\uffff\4\13\1\uffff\2\13\1\uffff\16\13\1\uffff\6\13\1\uffff\2\13\5\uffff\1\13",
            "\7\13\10\uffff\2\14\1\uffff\1\20\1\23\4\uffff\6\13\2\uffff\5\13\1\uffff\4\13\1\uffff\2\13\1\uffff\16\13\1\uffff\6\13\1\uffff\2\13\5\uffff\1\13",
            "\7\13\11\uffff\1\14\1\uffff\1\22\5\uffff\6\13\2\uffff\5\13\1\uffff\4\13\1\uffff\2\13\1\uffff\16\13\1\uffff\6\13\1\uffff\2\13\5\uffff\1\13",
            "\7\13\11\uffff\1\14\1\uffff\1\22\1\24\4\uffff\6\13\2\uffff\5\13\1\uffff\4\13\1\uffff\2\13\1\uffff\16\13\1\uffff\6\13\1\uffff\2\13\5\uffff\1\13",
            "\7\13\10\uffff\2\14\1\uffff\1\20\5\uffff\6\13\2\uffff\5\13\1\uffff\4\13\1\uffff\2\13\1\uffff\16\13\1\uffff\6\13\1\uffff\2\13\5\uffff\1\13",
            "\7\13\11\uffff\1\14\1\uffff\1\22\5\uffff\6\13\2\uffff\5\13\1\uffff\4\13\1\uffff\2\13\1\uffff\16\13\1\uffff\6\13\1\uffff\2\13\5\uffff\1\13"
    };

    static final short[] dfa_75 = DFA.unpackEncodedString(dfa_75s);
    static final short[] dfa_76 = DFA.unpackEncodedString(dfa_76s);
    static final char[] dfa_77 = DFA.unpackEncodedStringToUnsignedChars(dfa_77s);
    static final char[] dfa_78 = DFA.unpackEncodedStringToUnsignedChars(dfa_78s);
    static final short[] dfa_79 = DFA.unpackEncodedString(dfa_79s);
    static final short[] dfa_80 = DFA.unpackEncodedString(dfa_80s);
    static final short[][] dfa_81 = unpackEncodedStringArray(dfa_81s);

    class DFA69 extends DFA {

        public DFA69(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 69;
            this.eot = dfa_75;
            this.eof = dfa_76;
            this.min = dfa_77;
            this.max = dfa_78;
            this.accept = dfa_79;
            this.special = dfa_80;
            this.transition = dfa_81;
        }
        public String getDescription() {
            return "4509:1: (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_BooleanValue_3= ruleBooleanValue | this_DateValue_4= ruleDateValue | this_TimeValue_5= ruleTimeValue | this_DateAndTimeValue_6= ruleDateAndTimeValue | this_NullValue_7= ruleNullValue | this_JavaConstantValue_8= ruleJavaConstantValue )";
        }
    }
    static final String dfa_82s = "\1\17\1\uffff\1\23\1\uffff\1\23\2\uffff\1\23";
    static final String dfa_83s = "\1\21\1\uffff\1\26\1\uffff\1\27\2\uffff\1\26";
    static final String dfa_84s = "\1\uffff\1\1\1\uffff\1\4\1\uffff\1\2\1\3\1\uffff";
    static final String[] dfa_85s = {
            "\1\1\1\2\1\3",
            "",
            "\1\5\1\6\1\uffff\1\4",
            "",
            "\1\5\1\6\1\uffff\1\4\1\7",
            "",
            "",
            "\1\5\1\6\1\uffff\1\4"
    };
    static final char[] dfa_82 = DFA.unpackEncodedStringToUnsignedChars(dfa_82s);
    static final char[] dfa_83 = DFA.unpackEncodedStringToUnsignedChars(dfa_83s);
    static final short[] dfa_84 = DFA.unpackEncodedString(dfa_84s);
    static final short[][] dfa_85 = unpackEncodedStringArray(dfa_85s);

    class DFA73 extends DFA {

        public DFA73(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 73;
            this.eot = dfa_50;
            this.eof = dfa_50;
            this.min = dfa_82;
            this.max = dfa_83;
            this.accept = dfa_84;
            this.special = dfa_55;
            this.transition = dfa_85;
        }
        public String getDescription() {
            return "5127:1: (this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue | this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue | this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue | this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000001390000002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000400400L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000581F3D0400000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x000581F3D0000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000400400600L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000400000602L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000400400400L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000400000402L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000800400000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000000007FFE00L,0x0000000000006481L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000400200L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000400400000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000018000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x00001E0020400000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x00001E0020000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x00001C0020400400L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000180020400400L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000100020400400L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000020400400L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x3595A1F3904001F0L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x3595A1F3900001F0L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000400000400002L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0002000000400000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x00480000007FFE00L,0x0000000000006481L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x00480000007FFE02L,0x0000000000006481L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0048000000400000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0048000000000002L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0020000000400000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000800400400L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x8200000000400400L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x8000000000400400L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0200000000400000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x00000000005FFE00L,0x0000000000002400L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x8020000000400400L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x4040000000400400L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x4040000000400402L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0040000000400000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000400402L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x8000000000400000L,0x000000000000003EL});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x8000000000000000L,0x000000000000003EL});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x8000000000400000L,0x000000000000007EL});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x8000000000000000L,0x000000000000007EL});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000020400000L,0x0000000000000100L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000400000L,0x0000000000000100L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000400002L,0x0000000000000200L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000480000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000500000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000002L,0x0000000000001000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000400600L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000400600L,0x0000000000008000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000400000L,0x0000000000004000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000002L,0x0000000000020000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000000C00000L});

}