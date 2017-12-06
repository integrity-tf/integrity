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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_SL_VISIBLE_COMMENT", "RULE_SL_VISIBLE_TITLE_COMMENT", "RULE_ML_VISIBLE_COMMENT", "RULE_ML_VISIBLE_TITLE_COMMENT", "RULE_DIVIDER", "RULE_STRING", "RULE_ID", "RULE_INTEGER", "RULE_DECIMAL", "RULE_BOOLEAN_TRUE", "RULE_BOOLEAN_FALSE", "RULE_ISODATE", "RULE_EURODATE", "RULE_USDATE", "RULE_ISOTIME", "RULE_TWENTYFOURHRSTIME", "RULE_TWELVEHRSTIME", "RULE_UPPERCASE_ID", "RULE_ML_DOC_COMMENT", "RULE_NEWLINE", "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_ISOTIMEZONE", "RULE_ANY_OTHER", "'packagedef'", "'with'", "'packageend'", "'import'", "'private'", "'forkdef'", "'uses'", "'based on'", "':'", "'variantdef'", "'testdef'", "'calldef'", "'single-run'", "'inlined'", "'suitedef'", "'gets'", "'returns'", "'requires'", "'concludedby'", "'suiteend'", "'by default'", "'operationdef'", "'variable'", "'initially'", "'constant'", "'parameterized'", "'assign'", "'->'", "'in'", "'checkpoint'", "'test'", "'='", "'tabletest'", "'|'", "'call'", "'timeset'", "'live'", "'progressing'", "'x'", "'on'", "'master'", "','", "'suite'", "'+'", "'('", "'-'", "'*'", "'/'", "'%'", "'..'", "')'", "'['", "']'", "'<'", "'>'", "'#'", "'null'", "'{'", "'}'", "'.'", "'.*'"
    };
    public static final int RULE_ISOTIME=18;
    public static final int T__50=50;
    public static final int RULE_DIVIDER=8;
    public static final int RULE_UPPERCASE_ID=21;
    public static final int RULE_ML_DOC_COMMENT=22;
    public static final int T__59=59;
    public static final int RULE_BOOLEAN_TRUE=13;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_ML_VISIBLE_COMMENT=6;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=10;
    public static final int RULE_TWENTYFOURHRSTIME=19;
    public static final int RULE_ISOTIMEZONE=27;
    public static final int RULE_DECIMAL=12;
    public static final int T__29=29;
    public static final int RULE_ISODATE=15;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=25;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int RULE_SL_VISIBLE_COMMENT=4;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int RULE_USDATE=17;
    public static final int T__63=63;
    public static final int RULE_BOOLEAN_FALSE=14;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_NEWLINE=23;
    public static final int RULE_STRING=9;
    public static final int RULE_SL_VISIBLE_TITLE_COMMENT=5;
    public static final int RULE_SL_COMMENT=26;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int T__34=34;
    public static final int T__78=78;
    public static final int T__35=35;
    public static final int T__79=79;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int RULE_TWELVEHRSTIME=20;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=24;
    public static final int RULE_ANY_OTHER=28;
    public static final int RULE_EURODATE=16;
    public static final int RULE_ML_VISIBLE_TITLE_COMMENT=7;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__88=88;
    public static final int T__45=45;
    public static final int T__89=89;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__84=84;
    public static final int T__41=41;
    public static final int T__85=85;
    public static final int RULE_INTEGER=11;
    public static final int T__42=42;
    public static final int T__86=86;
    public static final int T__43=43;
    public static final int T__87=87;

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

                if ( (LA1_0==RULE_ML_DOC_COMMENT||LA1_0==29||(LA1_0>=32 && LA1_0<=34)||LA1_0==38) ) {
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
            alt2 = dfa2.predict(input);
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
    // InternalDSL.g:544:1: rulePackageDefinition returns [EObject current=null] : ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'packagedef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'with' ruleNL ( (lv_statements_6_0= rulePackageStatement ) )* otherlv_7= 'packageend' ruleNL ) ;
    public final EObject rulePackageDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_documentation_0_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_statements_6_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:547:28: ( ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'packagedef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'with' ruleNL ( (lv_statements_6_0= rulePackageStatement ) )* otherlv_7= 'packageend' ruleNL ) )
            // InternalDSL.g:548:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'packagedef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'with' ruleNL ( (lv_statements_6_0= rulePackageStatement ) )* otherlv_7= 'packageend' ruleNL )
            {
            // InternalDSL.g:548:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'packagedef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'with' ruleNL ( (lv_statements_6_0= rulePackageStatement ) )* otherlv_7= 'packageend' ruleNL )
            // InternalDSL.g:548:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'packagedef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) otherlv_4= 'with' ruleNL ( (lv_statements_6_0= rulePackageStatement ) )* otherlv_7= 'packageend' ruleNL
            {
            // InternalDSL.g:548:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ML_DOC_COMMENT) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalDSL.g:549:1: (lv_documentation_0_0= ruleDocumentationComment )
                    {
                    // InternalDSL.g:549:1: (lv_documentation_0_0= ruleDocumentationComment )
                    // InternalDSL.g:550:3: lv_documentation_0_0= ruleDocumentationComment
                    {
                     
                    	        newCompositeNode(grammarAccess.getPackageDefinitionAccess().getDocumentationDocumentationCommentParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_5);
                    lv_documentation_0_0=ruleDocumentationComment();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPackageDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"documentation",
                            		lv_documentation_0_0, 
                            		"de.gebit.integrity.DSL.DocumentationComment");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,29,FOLLOW_6); 

                	newLeafNode(otherlv_1, grammarAccess.getPackageDefinitionAccess().getPackagedefKeyword_1());
                
             
                    newCompositeNode(grammarAccess.getPackageDefinitionAccess().getNLParserRuleCall_2()); 
                
            pushFollow(FOLLOW_6);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:578:1: ( (lv_name_3_0= ruleQualifiedName ) )
            // InternalDSL.g:579:1: (lv_name_3_0= ruleQualifiedName )
            {
            // InternalDSL.g:579:1: (lv_name_3_0= ruleQualifiedName )
            // InternalDSL.g:580:3: lv_name_3_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getPackageDefinitionAccess().getNameQualifiedNameParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_7);
            lv_name_3_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPackageDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"de.gebit.integrity.DSL.QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,30,FOLLOW_8); 

                	newLeafNode(otherlv_4, grammarAccess.getPackageDefinitionAccess().getWithKeyword_4());
                
             
                    newCompositeNode(grammarAccess.getPackageDefinitionAccess().getNLParserRuleCall_5()); 
                
            pushFollow(FOLLOW_9);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:608:1: ( (lv_statements_6_0= rulePackageStatement ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==RULE_ML_DOC_COMMENT||(LA7_0>=32 && LA7_0<=34)||(LA7_0>=38 && LA7_0<=43)||(LA7_0>=50 && LA7_0<=51)||LA7_0==53) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalDSL.g:609:1: (lv_statements_6_0= rulePackageStatement )
            	    {
            	    // InternalDSL.g:609:1: (lv_statements_6_0= rulePackageStatement )
            	    // InternalDSL.g:610:3: lv_statements_6_0= rulePackageStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPackageDefinitionAccess().getStatementsPackageStatementParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_9);
            	    lv_statements_6_0=rulePackageStatement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPackageDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"statements",
            	            		lv_statements_6_0, 
            	            		"de.gebit.integrity.DSL.PackageStatement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_7=(Token)match(input,31,FOLLOW_4); 

                	newLeafNode(otherlv_7, grammarAccess.getPackageDefinitionAccess().getPackageendKeyword_7());
                
             
                    newCompositeNode(grammarAccess.getPackageDefinitionAccess().getNLParserRuleCall_8()); 
                
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
    // InternalDSL.g:646:1: entryRulePackageStatement returns [EObject current=null] : iv_rulePackageStatement= rulePackageStatement EOF ;
    public final EObject entryRulePackageStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePackageStatement = null;


        try {
            // InternalDSL.g:647:2: (iv_rulePackageStatement= rulePackageStatement EOF )
            // InternalDSL.g:648:2: iv_rulePackageStatement= rulePackageStatement EOF
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
    // InternalDSL.g:655:1: rulePackageStatement returns [EObject current=null] : (this_Import_0= ruleImport | this_ForkDefinition_1= ruleForkDefinition | this_VariantDefinition_2= ruleVariantDefinition | this_TestDefinition_3= ruleTestDefinition | this_CallDefinition_4= ruleCallDefinition | this_OperationDefinition_5= ruleOperationDefinition | this_SuiteDefinition_6= ruleSuiteDefinition | this_VariableDefinition_7= ruleVariableDefinition | this_ConstantDefinition_8= ruleConstantDefinition ) ;
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
            // InternalDSL.g:658:28: ( (this_Import_0= ruleImport | this_ForkDefinition_1= ruleForkDefinition | this_VariantDefinition_2= ruleVariantDefinition | this_TestDefinition_3= ruleTestDefinition | this_CallDefinition_4= ruleCallDefinition | this_OperationDefinition_5= ruleOperationDefinition | this_SuiteDefinition_6= ruleSuiteDefinition | this_VariableDefinition_7= ruleVariableDefinition | this_ConstantDefinition_8= ruleConstantDefinition ) )
            // InternalDSL.g:659:1: (this_Import_0= ruleImport | this_ForkDefinition_1= ruleForkDefinition | this_VariantDefinition_2= ruleVariantDefinition | this_TestDefinition_3= ruleTestDefinition | this_CallDefinition_4= ruleCallDefinition | this_OperationDefinition_5= ruleOperationDefinition | this_SuiteDefinition_6= ruleSuiteDefinition | this_VariableDefinition_7= ruleVariableDefinition | this_ConstantDefinition_8= ruleConstantDefinition )
            {
            // InternalDSL.g:659:1: (this_Import_0= ruleImport | this_ForkDefinition_1= ruleForkDefinition | this_VariantDefinition_2= ruleVariantDefinition | this_TestDefinition_3= ruleTestDefinition | this_CallDefinition_4= ruleCallDefinition | this_OperationDefinition_5= ruleOperationDefinition | this_SuiteDefinition_6= ruleSuiteDefinition | this_VariableDefinition_7= ruleVariableDefinition | this_ConstantDefinition_8= ruleConstantDefinition )
            int alt8=9;
            alt8 = dfa8.predict(input);
            switch (alt8) {
                case 1 :
                    // InternalDSL.g:660:5: this_Import_0= ruleImport
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
                    // InternalDSL.g:670:5: this_ForkDefinition_1= ruleForkDefinition
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
                    // InternalDSL.g:680:5: this_VariantDefinition_2= ruleVariantDefinition
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
                    // InternalDSL.g:690:5: this_TestDefinition_3= ruleTestDefinition
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
                    // InternalDSL.g:700:5: this_CallDefinition_4= ruleCallDefinition
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
                    // InternalDSL.g:710:5: this_OperationDefinition_5= ruleOperationDefinition
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
                    // InternalDSL.g:720:5: this_SuiteDefinition_6= ruleSuiteDefinition
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
                    // InternalDSL.g:730:5: this_VariableDefinition_7= ruleVariableDefinition
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
                    // InternalDSL.g:740:5: this_ConstantDefinition_8= ruleConstantDefinition
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
    // InternalDSL.g:756:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalDSL.g:757:2: (iv_ruleImport= ruleImport EOF )
            // InternalDSL.g:758:2: iv_ruleImport= ruleImport EOF
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
    // InternalDSL.g:765:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ruleNL ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) ) ruleNL ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_importedNamespace_2_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:768:28: ( (otherlv_0= 'import' ruleNL ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) ) ruleNL ) )
            // InternalDSL.g:769:1: (otherlv_0= 'import' ruleNL ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) ) ruleNL )
            {
            // InternalDSL.g:769:1: (otherlv_0= 'import' ruleNL ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) ) ruleNL )
            // InternalDSL.g:769:3: otherlv_0= 'import' ruleNL ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) ) ruleNL
            {
            otherlv_0=(Token)match(input,32,FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getImportAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_6);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:781:1: ( (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard ) )
            // InternalDSL.g:782:1: (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard )
            {
            // InternalDSL.g:782:1: (lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard )
            // InternalDSL.g:783:3: lv_importedNamespace_2_0= ruleQualifiedNameWithWildcard
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
    // InternalDSL.g:815:1: entryRuleForkDefinition returns [EObject current=null] : iv_ruleForkDefinition= ruleForkDefinition EOF ;
    public final EObject entryRuleForkDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForkDefinition = null;


        try {
            // InternalDSL.g:816:2: (iv_ruleForkDefinition= ruleForkDefinition EOF )
            // InternalDSL.g:817:2: iv_ruleForkDefinition= ruleForkDefinition EOF
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
    // InternalDSL.g:824:1: ruleForkDefinition returns [EObject current=null] : ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? otherlv_2= 'forkdef' ruleNL ( (lv_name_4_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_6_0= RULE_STRING ) ) ruleNL )? ( ( (otherlv_8= 'uses' ruleNL ( (lv_forkerClass_10_0= ruleJavaClassReference ) ) ) | (otherlv_11= 'based on' ruleNL ( ( ruleQualifiedName ) ) ) ) ruleNL )? ( ( (lv_parameters_15_0= ruleForkParameter ) ) ruleNL )* ) ;
    public final EObject ruleForkDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_private_1_0=null;
        Token otherlv_2=null;
        Token lv_description_6_0=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        EObject lv_documentation_0_0 = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;

        EObject lv_forkerClass_10_0 = null;

        EObject lv_parameters_15_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:827:28: ( ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? otherlv_2= 'forkdef' ruleNL ( (lv_name_4_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_6_0= RULE_STRING ) ) ruleNL )? ( ( (otherlv_8= 'uses' ruleNL ( (lv_forkerClass_10_0= ruleJavaClassReference ) ) ) | (otherlv_11= 'based on' ruleNL ( ( ruleQualifiedName ) ) ) ) ruleNL )? ( ( (lv_parameters_15_0= ruleForkParameter ) ) ruleNL )* ) )
            // InternalDSL.g:828:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? otherlv_2= 'forkdef' ruleNL ( (lv_name_4_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_6_0= RULE_STRING ) ) ruleNL )? ( ( (otherlv_8= 'uses' ruleNL ( (lv_forkerClass_10_0= ruleJavaClassReference ) ) ) | (otherlv_11= 'based on' ruleNL ( ( ruleQualifiedName ) ) ) ) ruleNL )? ( ( (lv_parameters_15_0= ruleForkParameter ) ) ruleNL )* )
            {
            // InternalDSL.g:828:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? otherlv_2= 'forkdef' ruleNL ( (lv_name_4_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_6_0= RULE_STRING ) ) ruleNL )? ( ( (otherlv_8= 'uses' ruleNL ( (lv_forkerClass_10_0= ruleJavaClassReference ) ) ) | (otherlv_11= 'based on' ruleNL ( ( ruleQualifiedName ) ) ) ) ruleNL )? ( ( (lv_parameters_15_0= ruleForkParameter ) ) ruleNL )* )
            // InternalDSL.g:828:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? otherlv_2= 'forkdef' ruleNL ( (lv_name_4_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_6_0= RULE_STRING ) ) ruleNL )? ( ( (otherlv_8= 'uses' ruleNL ( (lv_forkerClass_10_0= ruleJavaClassReference ) ) ) | (otherlv_11= 'based on' ruleNL ( ( ruleQualifiedName ) ) ) ) ruleNL )? ( ( (lv_parameters_15_0= ruleForkParameter ) ) ruleNL )*
            {
            // InternalDSL.g:828:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ML_DOC_COMMENT) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalDSL.g:829:1: (lv_documentation_0_0= ruleDocumentationComment )
                    {
                    // InternalDSL.g:829:1: (lv_documentation_0_0= ruleDocumentationComment )
                    // InternalDSL.g:830:3: lv_documentation_0_0= ruleDocumentationComment
                    {
                     
                    	        newCompositeNode(grammarAccess.getForkDefinitionAccess().getDocumentationDocumentationCommentParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_10);
                    lv_documentation_0_0=ruleDocumentationComment();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getForkDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"documentation",
                            		lv_documentation_0_0, 
                            		"de.gebit.integrity.DSL.DocumentationComment");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalDSL.g:846:3: ( (lv_private_1_0= 'private' ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==33) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalDSL.g:847:1: (lv_private_1_0= 'private' )
                    {
                    // InternalDSL.g:847:1: (lv_private_1_0= 'private' )
                    // InternalDSL.g:848:3: lv_private_1_0= 'private'
                    {
                    lv_private_1_0=(Token)match(input,33,FOLLOW_11); 

                            newLeafNode(lv_private_1_0, grammarAccess.getForkDefinitionAccess().getPrivatePrivateKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getForkDefinitionRule());
                    	        }
                           		setWithLastConsumed(current, "private", lv_private_1_0, "private");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,34,FOLLOW_6); 

                	newLeafNode(otherlv_2, grammarAccess.getForkDefinitionAccess().getForkdefKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getForkDefinitionAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_6);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:873:1: ( (lv_name_4_0= ruleQualifiedName ) )
            // InternalDSL.g:874:1: (lv_name_4_0= ruleQualifiedName )
            {
            // InternalDSL.g:874:1: (lv_name_4_0= ruleQualifiedName )
            // InternalDSL.g:875:3: lv_name_4_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getForkDefinitionAccess().getNameQualifiedNameParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_12);
            lv_name_4_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getForkDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_4_0, 
                    		"de.gebit.integrity.DSL.QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getForkDefinitionAccess().getNLParserRuleCall_5()); 
                
            pushFollow(FOLLOW_13);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:899:1: ( ( (lv_description_6_0= RULE_STRING ) ) ruleNL )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_STRING) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalDSL.g:899:2: ( (lv_description_6_0= RULE_STRING ) ) ruleNL
                    {
                    // InternalDSL.g:899:2: ( (lv_description_6_0= RULE_STRING ) )
                    // InternalDSL.g:900:1: (lv_description_6_0= RULE_STRING )
                    {
                    // InternalDSL.g:900:1: (lv_description_6_0= RULE_STRING )
                    // InternalDSL.g:901:3: lv_description_6_0= RULE_STRING
                    {
                    lv_description_6_0=(Token)match(input,RULE_STRING,FOLLOW_14); 

                    			newLeafNode(lv_description_6_0, grammarAccess.getForkDefinitionAccess().getDescriptionSTRINGTerminalRuleCall_6_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getForkDefinitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_6_0, 
                            		"de.gebit.integrity.DSL.STRING");
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getForkDefinitionAccess().getNLParserRuleCall_6_1()); 
                        
                    pushFollow(FOLLOW_15);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // InternalDSL.g:925:3: ( ( (otherlv_8= 'uses' ruleNL ( (lv_forkerClass_10_0= ruleJavaClassReference ) ) ) | (otherlv_11= 'based on' ruleNL ( ( ruleQualifiedName ) ) ) ) ruleNL )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=35 && LA13_0<=36)) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalDSL.g:925:4: ( (otherlv_8= 'uses' ruleNL ( (lv_forkerClass_10_0= ruleJavaClassReference ) ) ) | (otherlv_11= 'based on' ruleNL ( ( ruleQualifiedName ) ) ) ) ruleNL
                    {
                    // InternalDSL.g:925:4: ( (otherlv_8= 'uses' ruleNL ( (lv_forkerClass_10_0= ruleJavaClassReference ) ) ) | (otherlv_11= 'based on' ruleNL ( ( ruleQualifiedName ) ) ) )
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==35) ) {
                        alt12=1;
                    }
                    else if ( (LA12_0==36) ) {
                        alt12=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 0, input);

                        throw nvae;
                    }
                    switch (alt12) {
                        case 1 :
                            // InternalDSL.g:925:5: (otherlv_8= 'uses' ruleNL ( (lv_forkerClass_10_0= ruleJavaClassReference ) ) )
                            {
                            // InternalDSL.g:925:5: (otherlv_8= 'uses' ruleNL ( (lv_forkerClass_10_0= ruleJavaClassReference ) ) )
                            // InternalDSL.g:925:7: otherlv_8= 'uses' ruleNL ( (lv_forkerClass_10_0= ruleJavaClassReference ) )
                            {
                            otherlv_8=(Token)match(input,35,FOLLOW_6); 

                                	newLeafNode(otherlv_8, grammarAccess.getForkDefinitionAccess().getUsesKeyword_7_0_0_0());
                                
                             
                                    newCompositeNode(grammarAccess.getForkDefinitionAccess().getNLParserRuleCall_7_0_0_1()); 
                                
                            pushFollow(FOLLOW_6);
                            ruleNL();

                            state._fsp--;

                             
                                    afterParserOrEnumRuleCall();
                                
                            // InternalDSL.g:937:1: ( (lv_forkerClass_10_0= ruleJavaClassReference ) )
                            // InternalDSL.g:938:1: (lv_forkerClass_10_0= ruleJavaClassReference )
                            {
                            // InternalDSL.g:938:1: (lv_forkerClass_10_0= ruleJavaClassReference )
                            // InternalDSL.g:939:3: lv_forkerClass_10_0= ruleJavaClassReference
                            {
                             
                            	        newCompositeNode(grammarAccess.getForkDefinitionAccess().getForkerClassJavaClassReferenceParserRuleCall_7_0_0_2_0()); 
                            	    
                            pushFollow(FOLLOW_6);
                            lv_forkerClass_10_0=ruleJavaClassReference();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getForkDefinitionRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"forkerClass",
                                    		lv_forkerClass_10_0, 
                                    		"de.gebit.integrity.DSL.JavaClassReference");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalDSL.g:956:6: (otherlv_11= 'based on' ruleNL ( ( ruleQualifiedName ) ) )
                            {
                            // InternalDSL.g:956:6: (otherlv_11= 'based on' ruleNL ( ( ruleQualifiedName ) ) )
                            // InternalDSL.g:956:8: otherlv_11= 'based on' ruleNL ( ( ruleQualifiedName ) )
                            {
                            otherlv_11=(Token)match(input,36,FOLLOW_6); 

                                	newLeafNode(otherlv_11, grammarAccess.getForkDefinitionAccess().getBasedOnKeyword_7_0_1_0());
                                
                             
                                    newCompositeNode(grammarAccess.getForkDefinitionAccess().getNLParserRuleCall_7_0_1_1()); 
                                
                            pushFollow(FOLLOW_6);
                            ruleNL();

                            state._fsp--;

                             
                                    afterParserOrEnumRuleCall();
                                
                            // InternalDSL.g:968:1: ( ( ruleQualifiedName ) )
                            // InternalDSL.g:969:1: ( ruleQualifiedName )
                            {
                            // InternalDSL.g:969:1: ( ruleQualifiedName )
                            // InternalDSL.g:970:3: ruleQualifiedName
                            {

                            			if (current==null) {
                            	            current = createModelElement(grammarAccess.getForkDefinitionRule());
                            	        }
                                    
                             
                            	        newCompositeNode(grammarAccess.getForkDefinitionAccess().getBaseForkForkDefinitionCrossReference_7_0_1_2_0()); 
                            	    
                            pushFollow(FOLLOW_6);
                            ruleQualifiedName();

                            state._fsp--;

                             
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }


                            }
                            break;

                    }

                     
                            newCompositeNode(grammarAccess.getForkDefinitionAccess().getNLParserRuleCall_7_1()); 
                        
                    pushFollow(FOLLOW_16);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // InternalDSL.g:991:3: ( ( (lv_parameters_15_0= ruleForkParameter ) ) ruleNL )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalDSL.g:991:4: ( (lv_parameters_15_0= ruleForkParameter ) ) ruleNL
            	    {
            	    // InternalDSL.g:991:4: ( (lv_parameters_15_0= ruleForkParameter ) )
            	    // InternalDSL.g:992:1: (lv_parameters_15_0= ruleForkParameter )
            	    {
            	    // InternalDSL.g:992:1: (lv_parameters_15_0= ruleForkParameter )
            	    // InternalDSL.g:993:3: lv_parameters_15_0= ruleForkParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getForkDefinitionAccess().getParametersForkParameterParserRuleCall_8_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_6);
            	    lv_parameters_15_0=ruleForkParameter();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getForkDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"parameters",
            	            		lv_parameters_15_0, 
            	            		"de.gebit.integrity.DSL.ForkParameter");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	     
            	            newCompositeNode(grammarAccess.getForkDefinitionAccess().getNLParserRuleCall_8_1()); 
            	        
            	    pushFollow(FOLLOW_16);
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


            }

             leaveRule(); 
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
    // InternalDSL.g:1025:1: entryRuleForkParameter returns [EObject current=null] : iv_ruleForkParameter= ruleForkParameter EOF ;
    public final EObject entryRuleForkParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForkParameter = null;


        try {
            // InternalDSL.g:1026:2: (iv_ruleForkParameter= ruleForkParameter EOF )
            // InternalDSL.g:1027:2: iv_ruleForkParameter= ruleForkParameter EOF
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
    // InternalDSL.g:1034:1: ruleForkParameter returns [EObject current=null] : ( ( (lv_name_0_0= ruleFixedParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) ) ) ;
    public final EObject ruleForkParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:1037:28: ( ( ( (lv_name_0_0= ruleFixedParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) ) ) )
            // InternalDSL.g:1038:1: ( ( (lv_name_0_0= ruleFixedParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) ) )
            {
            // InternalDSL.g:1038:1: ( ( (lv_name_0_0= ruleFixedParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) ) )
            // InternalDSL.g:1038:2: ( (lv_name_0_0= ruleFixedParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) )
            {
            // InternalDSL.g:1038:2: ( (lv_name_0_0= ruleFixedParameterName ) )
            // InternalDSL.g:1039:1: (lv_name_0_0= ruleFixedParameterName )
            {
            // InternalDSL.g:1039:1: (lv_name_0_0= ruleFixedParameterName )
            // InternalDSL.g:1040:3: lv_name_0_0= ruleFixedParameterName
            {
             
            	        newCompositeNode(grammarAccess.getForkParameterAccess().getNameFixedParameterNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_17);
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
                
            pushFollow(FOLLOW_18);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,37,FOLLOW_19); 

                	newLeafNode(otherlv_2, grammarAccess.getForkParameterAccess().getColonKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getForkParameterAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_19);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1076:1: ( (lv_value_4_0= ruleValueOrEnumValueOrOperation ) )
            // InternalDSL.g:1077:1: (lv_value_4_0= ruleValueOrEnumValueOrOperation )
            {
            // InternalDSL.g:1077:1: (lv_value_4_0= ruleValueOrEnumValueOrOperation )
            // InternalDSL.g:1078:3: lv_value_4_0= ruleValueOrEnumValueOrOperation
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
    // InternalDSL.g:1102:1: entryRuleVariantDefinition returns [EObject current=null] : iv_ruleVariantDefinition= ruleVariantDefinition EOF ;
    public final EObject entryRuleVariantDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariantDefinition = null;


        try {
            // InternalDSL.g:1103:2: (iv_ruleVariantDefinition= ruleVariantDefinition EOF )
            // InternalDSL.g:1104:2: iv_ruleVariantDefinition= ruleVariantDefinition EOF
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
    // InternalDSL.g:1111:1: ruleVariantDefinition returns [EObject current=null] : ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'variantdef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_5_0= RULE_STRING ) ) ruleNL )? ) ;
    public final EObject ruleVariantDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_description_5_0=null;
        EObject lv_documentation_0_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:1114:28: ( ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'variantdef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_5_0= RULE_STRING ) ) ruleNL )? ) )
            // InternalDSL.g:1115:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'variantdef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_5_0= RULE_STRING ) ) ruleNL )? )
            {
            // InternalDSL.g:1115:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'variantdef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_5_0= RULE_STRING ) ) ruleNL )? )
            // InternalDSL.g:1115:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'variantdef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL ( ( (lv_description_5_0= RULE_STRING ) ) ruleNL )?
            {
            // InternalDSL.g:1115:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==RULE_ML_DOC_COMMENT) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalDSL.g:1116:1: (lv_documentation_0_0= ruleDocumentationComment )
                    {
                    // InternalDSL.g:1116:1: (lv_documentation_0_0= ruleDocumentationComment )
                    // InternalDSL.g:1117:3: lv_documentation_0_0= ruleDocumentationComment
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariantDefinitionAccess().getDocumentationDocumentationCommentParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_20);
                    lv_documentation_0_0=ruleDocumentationComment();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVariantDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"documentation",
                            		lv_documentation_0_0, 
                            		"de.gebit.integrity.DSL.DocumentationComment");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,38,FOLLOW_6); 

                	newLeafNode(otherlv_1, grammarAccess.getVariantDefinitionAccess().getVariantdefKeyword_1());
                
             
                    newCompositeNode(grammarAccess.getVariantDefinitionAccess().getNLParserRuleCall_2()); 
                
            pushFollow(FOLLOW_6);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1145:1: ( (lv_name_3_0= ruleQualifiedName ) )
            // InternalDSL.g:1146:1: (lv_name_3_0= ruleQualifiedName )
            {
            // InternalDSL.g:1146:1: (lv_name_3_0= ruleQualifiedName )
            // InternalDSL.g:1147:3: lv_name_3_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getVariantDefinitionAccess().getNameQualifiedNameParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_21);
            lv_name_3_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getVariantDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"de.gebit.integrity.DSL.QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getVariantDefinitionAccess().getNLParserRuleCall_4()); 
                
            pushFollow(FOLLOW_22);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1171:1: ( ( (lv_description_5_0= RULE_STRING ) ) ruleNL )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_STRING) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalDSL.g:1171:2: ( (lv_description_5_0= RULE_STRING ) ) ruleNL
                    {
                    // InternalDSL.g:1171:2: ( (lv_description_5_0= RULE_STRING ) )
                    // InternalDSL.g:1172:1: (lv_description_5_0= RULE_STRING )
                    {
                    // InternalDSL.g:1172:1: (lv_description_5_0= RULE_STRING )
                    // InternalDSL.g:1173:3: lv_description_5_0= RULE_STRING
                    {
                    lv_description_5_0=(Token)match(input,RULE_STRING,FOLLOW_4); 

                    			newLeafNode(lv_description_5_0, grammarAccess.getVariantDefinitionAccess().getDescriptionSTRINGTerminalRuleCall_5_0_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVariantDefinitionRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"description",
                            		lv_description_5_0, 
                            		"de.gebit.integrity.DSL.STRING");
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getVariantDefinitionAccess().getNLParserRuleCall_5_1()); 
                        
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
    // InternalDSL.g:1205:1: entryRuleTestDefinition returns [EObject current=null] : iv_ruleTestDefinition= ruleTestDefinition EOF ;
    public final EObject entryRuleTestDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTestDefinition = null;


        try {
            // InternalDSL.g:1206:2: (iv_ruleTestDefinition= ruleTestDefinition EOF )
            // InternalDSL.g:1207:2: iv_ruleTestDefinition= ruleTestDefinition EOF
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
    // InternalDSL.g:1214:1: ruleTestDefinition returns [EObject current=null] : ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'testdef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL otherlv_5= 'uses' ruleNL ( (lv_fixtureMethod_7_0= ruleMethodReference ) ) ruleNL ) ;
    public final EObject ruleTestDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_documentation_0_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_fixtureMethod_7_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:1217:28: ( ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'testdef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL otherlv_5= 'uses' ruleNL ( (lv_fixtureMethod_7_0= ruleMethodReference ) ) ruleNL ) )
            // InternalDSL.g:1218:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'testdef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL otherlv_5= 'uses' ruleNL ( (lv_fixtureMethod_7_0= ruleMethodReference ) ) ruleNL )
            {
            // InternalDSL.g:1218:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'testdef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL otherlv_5= 'uses' ruleNL ( (lv_fixtureMethod_7_0= ruleMethodReference ) ) ruleNL )
            // InternalDSL.g:1218:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'testdef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL otherlv_5= 'uses' ruleNL ( (lv_fixtureMethod_7_0= ruleMethodReference ) ) ruleNL
            {
            // InternalDSL.g:1218:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_ML_DOC_COMMENT) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalDSL.g:1219:1: (lv_documentation_0_0= ruleDocumentationComment )
                    {
                    // InternalDSL.g:1219:1: (lv_documentation_0_0= ruleDocumentationComment )
                    // InternalDSL.g:1220:3: lv_documentation_0_0= ruleDocumentationComment
                    {
                     
                    	        newCompositeNode(grammarAccess.getTestDefinitionAccess().getDocumentationDocumentationCommentParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_23);
                    lv_documentation_0_0=ruleDocumentationComment();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTestDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"documentation",
                            		lv_documentation_0_0, 
                            		"de.gebit.integrity.DSL.DocumentationComment");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,39,FOLLOW_6); 

                	newLeafNode(otherlv_1, grammarAccess.getTestDefinitionAccess().getTestdefKeyword_1());
                
             
                    newCompositeNode(grammarAccess.getTestDefinitionAccess().getNLParserRuleCall_2()); 
                
            pushFollow(FOLLOW_6);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1248:1: ( (lv_name_3_0= ruleQualifiedName ) )
            // InternalDSL.g:1249:1: (lv_name_3_0= ruleQualifiedName )
            {
            // InternalDSL.g:1249:1: (lv_name_3_0= ruleQualifiedName )
            // InternalDSL.g:1250:3: lv_name_3_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getTestDefinitionAccess().getNameQualifiedNameParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_24);
            lv_name_3_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTestDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"de.gebit.integrity.DSL.QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getTestDefinitionAccess().getNLParserRuleCall_4()); 
                
            pushFollow(FOLLOW_25);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_5=(Token)match(input,35,FOLLOW_6); 

                	newLeafNode(otherlv_5, grammarAccess.getTestDefinitionAccess().getUsesKeyword_5());
                
             
                    newCompositeNode(grammarAccess.getTestDefinitionAccess().getNLParserRuleCall_6()); 
                
            pushFollow(FOLLOW_6);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1286:1: ( (lv_fixtureMethod_7_0= ruleMethodReference ) )
            // InternalDSL.g:1287:1: (lv_fixtureMethod_7_0= ruleMethodReference )
            {
            // InternalDSL.g:1287:1: (lv_fixtureMethod_7_0= ruleMethodReference )
            // InternalDSL.g:1288:3: lv_fixtureMethod_7_0= ruleMethodReference
            {
             
            	        newCompositeNode(grammarAccess.getTestDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_4);
            lv_fixtureMethod_7_0=ruleMethodReference();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTestDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"fixtureMethod",
                    		lv_fixtureMethod_7_0, 
                    		"de.gebit.integrity.DSL.MethodReference");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getTestDefinitionAccess().getNLParserRuleCall_8()); 
                
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
    // InternalDSL.g:1320:1: entryRuleCallDefinition returns [EObject current=null] : iv_ruleCallDefinition= ruleCallDefinition EOF ;
    public final EObject entryRuleCallDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCallDefinition = null;


        try {
            // InternalDSL.g:1321:2: (iv_ruleCallDefinition= ruleCallDefinition EOF )
            // InternalDSL.g:1322:2: iv_ruleCallDefinition= ruleCallDefinition EOF
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
    // InternalDSL.g:1329:1: ruleCallDefinition returns [EObject current=null] : ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'calldef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL otherlv_5= 'uses' ruleNL ( (lv_fixtureMethod_7_0= ruleMethodReference ) ) ruleNL ) ;
    public final EObject ruleCallDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_documentation_0_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_fixtureMethod_7_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:1332:28: ( ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'calldef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL otherlv_5= 'uses' ruleNL ( (lv_fixtureMethod_7_0= ruleMethodReference ) ) ruleNL ) )
            // InternalDSL.g:1333:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'calldef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL otherlv_5= 'uses' ruleNL ( (lv_fixtureMethod_7_0= ruleMethodReference ) ) ruleNL )
            {
            // InternalDSL.g:1333:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'calldef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL otherlv_5= 'uses' ruleNL ( (lv_fixtureMethod_7_0= ruleMethodReference ) ) ruleNL )
            // InternalDSL.g:1333:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )? otherlv_1= 'calldef' ruleNL ( (lv_name_3_0= ruleQualifiedName ) ) ruleNL otherlv_5= 'uses' ruleNL ( (lv_fixtureMethod_7_0= ruleMethodReference ) ) ruleNL
            {
            // InternalDSL.g:1333:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_ML_DOC_COMMENT) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalDSL.g:1334:1: (lv_documentation_0_0= ruleDocumentationComment )
                    {
                    // InternalDSL.g:1334:1: (lv_documentation_0_0= ruleDocumentationComment )
                    // InternalDSL.g:1335:3: lv_documentation_0_0= ruleDocumentationComment
                    {
                     
                    	        newCompositeNode(grammarAccess.getCallDefinitionAccess().getDocumentationDocumentationCommentParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_26);
                    lv_documentation_0_0=ruleDocumentationComment();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCallDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"documentation",
                            		lv_documentation_0_0, 
                            		"de.gebit.integrity.DSL.DocumentationComment");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,40,FOLLOW_6); 

                	newLeafNode(otherlv_1, grammarAccess.getCallDefinitionAccess().getCalldefKeyword_1());
                
             
                    newCompositeNode(grammarAccess.getCallDefinitionAccess().getNLParserRuleCall_2()); 
                
            pushFollow(FOLLOW_6);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1363:1: ( (lv_name_3_0= ruleQualifiedName ) )
            // InternalDSL.g:1364:1: (lv_name_3_0= ruleQualifiedName )
            {
            // InternalDSL.g:1364:1: (lv_name_3_0= ruleQualifiedName )
            // InternalDSL.g:1365:3: lv_name_3_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getCallDefinitionAccess().getNameQualifiedNameParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_24);
            lv_name_3_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCallDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_3_0, 
                    		"de.gebit.integrity.DSL.QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getCallDefinitionAccess().getNLParserRuleCall_4()); 
                
            pushFollow(FOLLOW_25);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_5=(Token)match(input,35,FOLLOW_6); 

                	newLeafNode(otherlv_5, grammarAccess.getCallDefinitionAccess().getUsesKeyword_5());
                
             
                    newCompositeNode(grammarAccess.getCallDefinitionAccess().getNLParserRuleCall_6()); 
                
            pushFollow(FOLLOW_6);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1401:1: ( (lv_fixtureMethod_7_0= ruleMethodReference ) )
            // InternalDSL.g:1402:1: (lv_fixtureMethod_7_0= ruleMethodReference )
            {
            // InternalDSL.g:1402:1: (lv_fixtureMethod_7_0= ruleMethodReference )
            // InternalDSL.g:1403:3: lv_fixtureMethod_7_0= ruleMethodReference
            {
             
            	        newCompositeNode(grammarAccess.getCallDefinitionAccess().getFixtureMethodMethodReferenceParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_4);
            lv_fixtureMethod_7_0=ruleMethodReference();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCallDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"fixtureMethod",
                    		lv_fixtureMethod_7_0, 
                    		"de.gebit.integrity.DSL.MethodReference");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getCallDefinitionAccess().getNLParserRuleCall_8()); 
                
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
    // InternalDSL.g:1435:1: entryRuleSuiteDefinition returns [EObject current=null] : iv_ruleSuiteDefinition= ruleSuiteDefinition EOF ;
    public final EObject entryRuleSuiteDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteDefinition = null;


        try {
            // InternalDSL.g:1436:2: (iv_ruleSuiteDefinition= ruleSuiteDefinition EOF )
            // InternalDSL.g:1437:2: iv_ruleSuiteDefinition= ruleSuiteDefinition EOF
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
    // InternalDSL.g:1444:1: ruleSuiteDefinition returns [EObject current=null] : ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? ( (lv_singleRun_2_0= 'single-run' ) )? ( (lv_inlined_3_0= 'inlined' ) )? otherlv_4= 'suitedef' ruleNL ( (lv_name_6_0= ruleQualifiedName ) ) ruleNL (otherlv_8= 'gets' ( ( (lv_parameters_9_0= ruleSuiteParameterDefinition ) ) ruleNL )+ )? (otherlv_11= 'returns' ( ( (lv_return_12_0= ruleSuiteReturnDefinition ) ) ruleNL )+ )? (otherlv_14= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? (otherlv_18= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? otherlv_22= 'with' ruleNL ( (lv_statements_24_0= ruleSuiteStatement ) )* otherlv_25= 'suiteend' ruleNL ) ;
    public final EObject ruleSuiteDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_private_1_0=null;
        Token lv_singleRun_2_0=null;
        Token lv_inlined_3_0=null;
        Token otherlv_4=null;
        Token otherlv_8=null;
        Token otherlv_11=null;
        Token otherlv_14=null;
        Token otherlv_18=null;
        Token otherlv_22=null;
        Token otherlv_25=null;
        EObject lv_documentation_0_0 = null;

        AntlrDatatypeRuleToken lv_name_6_0 = null;

        EObject lv_parameters_9_0 = null;

        EObject lv_return_12_0 = null;

        EObject lv_statements_24_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:1447:28: ( ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? ( (lv_singleRun_2_0= 'single-run' ) )? ( (lv_inlined_3_0= 'inlined' ) )? otherlv_4= 'suitedef' ruleNL ( (lv_name_6_0= ruleQualifiedName ) ) ruleNL (otherlv_8= 'gets' ( ( (lv_parameters_9_0= ruleSuiteParameterDefinition ) ) ruleNL )+ )? (otherlv_11= 'returns' ( ( (lv_return_12_0= ruleSuiteReturnDefinition ) ) ruleNL )+ )? (otherlv_14= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? (otherlv_18= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? otherlv_22= 'with' ruleNL ( (lv_statements_24_0= ruleSuiteStatement ) )* otherlv_25= 'suiteend' ruleNL ) )
            // InternalDSL.g:1448:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? ( (lv_singleRun_2_0= 'single-run' ) )? ( (lv_inlined_3_0= 'inlined' ) )? otherlv_4= 'suitedef' ruleNL ( (lv_name_6_0= ruleQualifiedName ) ) ruleNL (otherlv_8= 'gets' ( ( (lv_parameters_9_0= ruleSuiteParameterDefinition ) ) ruleNL )+ )? (otherlv_11= 'returns' ( ( (lv_return_12_0= ruleSuiteReturnDefinition ) ) ruleNL )+ )? (otherlv_14= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? (otherlv_18= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? otherlv_22= 'with' ruleNL ( (lv_statements_24_0= ruleSuiteStatement ) )* otherlv_25= 'suiteend' ruleNL )
            {
            // InternalDSL.g:1448:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? ( (lv_singleRun_2_0= 'single-run' ) )? ( (lv_inlined_3_0= 'inlined' ) )? otherlv_4= 'suitedef' ruleNL ( (lv_name_6_0= ruleQualifiedName ) ) ruleNL (otherlv_8= 'gets' ( ( (lv_parameters_9_0= ruleSuiteParameterDefinition ) ) ruleNL )+ )? (otherlv_11= 'returns' ( ( (lv_return_12_0= ruleSuiteReturnDefinition ) ) ruleNL )+ )? (otherlv_14= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? (otherlv_18= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? otherlv_22= 'with' ruleNL ( (lv_statements_24_0= ruleSuiteStatement ) )* otherlv_25= 'suiteend' ruleNL )
            // InternalDSL.g:1448:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? ( (lv_singleRun_2_0= 'single-run' ) )? ( (lv_inlined_3_0= 'inlined' ) )? otherlv_4= 'suitedef' ruleNL ( (lv_name_6_0= ruleQualifiedName ) ) ruleNL (otherlv_8= 'gets' ( ( (lv_parameters_9_0= ruleSuiteParameterDefinition ) ) ruleNL )+ )? (otherlv_11= 'returns' ( ( (lv_return_12_0= ruleSuiteReturnDefinition ) ) ruleNL )+ )? (otherlv_14= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? (otherlv_18= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )? otherlv_22= 'with' ruleNL ( (lv_statements_24_0= ruleSuiteStatement ) )* otherlv_25= 'suiteend' ruleNL
            {
            // InternalDSL.g:1448:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_ML_DOC_COMMENT) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalDSL.g:1449:1: (lv_documentation_0_0= ruleDocumentationComment )
                    {
                    // InternalDSL.g:1449:1: (lv_documentation_0_0= ruleDocumentationComment )
                    // InternalDSL.g:1450:3: lv_documentation_0_0= ruleDocumentationComment
                    {
                     
                    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getDocumentationDocumentationCommentParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_27);
                    lv_documentation_0_0=ruleDocumentationComment();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSuiteDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"documentation",
                            		lv_documentation_0_0, 
                            		"de.gebit.integrity.DSL.DocumentationComment");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalDSL.g:1466:3: ( (lv_private_1_0= 'private' ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==33) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalDSL.g:1467:1: (lv_private_1_0= 'private' )
                    {
                    // InternalDSL.g:1467:1: (lv_private_1_0= 'private' )
                    // InternalDSL.g:1468:3: lv_private_1_0= 'private'
                    {
                    lv_private_1_0=(Token)match(input,33,FOLLOW_28); 

                            newLeafNode(lv_private_1_0, grammarAccess.getSuiteDefinitionAccess().getPrivatePrivateKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSuiteDefinitionRule());
                    	        }
                           		setWithLastConsumed(current, "private", lv_private_1_0, "private");
                    	    

                    }


                    }
                    break;

            }

            // InternalDSL.g:1481:3: ( (lv_singleRun_2_0= 'single-run' ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==41) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalDSL.g:1482:1: (lv_singleRun_2_0= 'single-run' )
                    {
                    // InternalDSL.g:1482:1: (lv_singleRun_2_0= 'single-run' )
                    // InternalDSL.g:1483:3: lv_singleRun_2_0= 'single-run'
                    {
                    lv_singleRun_2_0=(Token)match(input,41,FOLLOW_29); 

                            newLeafNode(lv_singleRun_2_0, grammarAccess.getSuiteDefinitionAccess().getSingleRunSingleRunKeyword_2_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSuiteDefinitionRule());
                    	        }
                           		setWithLastConsumed(current, "singleRun", lv_singleRun_2_0, "single-run");
                    	    

                    }


                    }
                    break;

            }

            // InternalDSL.g:1496:3: ( (lv_inlined_3_0= 'inlined' ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==42) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalDSL.g:1497:1: (lv_inlined_3_0= 'inlined' )
                    {
                    // InternalDSL.g:1497:1: (lv_inlined_3_0= 'inlined' )
                    // InternalDSL.g:1498:3: lv_inlined_3_0= 'inlined'
                    {
                    lv_inlined_3_0=(Token)match(input,42,FOLLOW_30); 

                            newLeafNode(lv_inlined_3_0, grammarAccess.getSuiteDefinitionAccess().getInlinedInlinedKeyword_3_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSuiteDefinitionRule());
                    	        }
                           		setWithLastConsumed(current, "inlined", lv_inlined_3_0, "inlined");
                    	    

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,43,FOLLOW_6); 

                	newLeafNode(otherlv_4, grammarAccess.getSuiteDefinitionAccess().getSuitedefKeyword_4());
                
             
                    newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_5()); 
                
            pushFollow(FOLLOW_6);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1523:1: ( (lv_name_6_0= ruleQualifiedName ) )
            // InternalDSL.g:1524:1: (lv_name_6_0= ruleQualifiedName )
            {
            // InternalDSL.g:1524:1: (lv_name_6_0= ruleQualifiedName )
            // InternalDSL.g:1525:3: lv_name_6_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNameQualifiedNameParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_31);
            lv_name_6_0=ruleQualifiedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getSuiteDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_6_0, 
                    		"de.gebit.integrity.DSL.QualifiedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_7()); 
                
            pushFollow(FOLLOW_32);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1549:1: (otherlv_8= 'gets' ( ( (lv_parameters_9_0= ruleSuiteParameterDefinition ) ) ruleNL )+ )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==44) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalDSL.g:1549:3: otherlv_8= 'gets' ( ( (lv_parameters_9_0= ruleSuiteParameterDefinition ) ) ruleNL )+
                    {
                    otherlv_8=(Token)match(input,44,FOLLOW_6); 

                        	newLeafNode(otherlv_8, grammarAccess.getSuiteDefinitionAccess().getGetsKeyword_8_0());
                        
                    // InternalDSL.g:1553:1: ( ( (lv_parameters_9_0= ruleSuiteParameterDefinition ) ) ruleNL )+
                    int cnt23=0;
                    loop23:
                    do {
                        int alt23=2;
                        int LA23_0 = input.LA(1);

                        if ( (LA23_0==RULE_ID) ) {
                            alt23=1;
                        }


                        switch (alt23) {
                    	case 1 :
                    	    // InternalDSL.g:1553:2: ( (lv_parameters_9_0= ruleSuiteParameterDefinition ) ) ruleNL
                    	    {
                    	    // InternalDSL.g:1553:2: ( (lv_parameters_9_0= ruleSuiteParameterDefinition ) )
                    	    // InternalDSL.g:1554:1: (lv_parameters_9_0= ruleSuiteParameterDefinition )
                    	    {
                    	    // InternalDSL.g:1554:1: (lv_parameters_9_0= ruleSuiteParameterDefinition )
                    	    // InternalDSL.g:1555:3: lv_parameters_9_0= ruleSuiteParameterDefinition
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getParametersSuiteParameterDefinitionParserRuleCall_8_1_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_33);
                    	    lv_parameters_9_0=ruleSuiteParameterDefinition();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSuiteDefinitionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"parameters",
                    	            		lv_parameters_9_0, 
                    	            		"de.gebit.integrity.DSL.SuiteParameterDefinition");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	     
                    	            newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_8_1_1()); 
                    	        
                    	    pushFollow(FOLLOW_33);
                    	    ruleNL();

                    	    state._fsp--;

                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

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
                    break;

            }

            // InternalDSL.g:1579:5: (otherlv_11= 'returns' ( ( (lv_return_12_0= ruleSuiteReturnDefinition ) ) ruleNL )+ )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==45) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalDSL.g:1579:7: otherlv_11= 'returns' ( ( (lv_return_12_0= ruleSuiteReturnDefinition ) ) ruleNL )+
                    {
                    otherlv_11=(Token)match(input,45,FOLLOW_6); 

                        	newLeafNode(otherlv_11, grammarAccess.getSuiteDefinitionAccess().getReturnsKeyword_9_0());
                        
                    // InternalDSL.g:1583:1: ( ( (lv_return_12_0= ruleSuiteReturnDefinition ) ) ruleNL )+
                    int cnt25=0;
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==RULE_ID) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // InternalDSL.g:1583:2: ( (lv_return_12_0= ruleSuiteReturnDefinition ) ) ruleNL
                    	    {
                    	    // InternalDSL.g:1583:2: ( (lv_return_12_0= ruleSuiteReturnDefinition ) )
                    	    // InternalDSL.g:1584:1: (lv_return_12_0= ruleSuiteReturnDefinition )
                    	    {
                    	    // InternalDSL.g:1584:1: (lv_return_12_0= ruleSuiteReturnDefinition )
                    	    // InternalDSL.g:1585:3: lv_return_12_0= ruleSuiteReturnDefinition
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getReturnSuiteReturnDefinitionParserRuleCall_9_1_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_34);
                    	    lv_return_12_0=ruleSuiteReturnDefinition();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getSuiteDefinitionRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"return",
                    	            		lv_return_12_0, 
                    	            		"de.gebit.integrity.DSL.SuiteReturnDefinition");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	     
                    	            newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_9_1_1()); 
                    	        
                    	    pushFollow(FOLLOW_34);
                    	    ruleNL();

                    	    state._fsp--;

                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt25 >= 1 ) break loop25;
                                EarlyExitException eee =
                                    new EarlyExitException(25, input);
                                throw eee;
                        }
                        cnt25++;
                    } while (true);


                    }
                    break;

            }

            // InternalDSL.g:1609:5: (otherlv_14= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==46) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalDSL.g:1609:7: otherlv_14= 'requires' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )*
                    {
                    otherlv_14=(Token)match(input,46,FOLLOW_35); 

                        	newLeafNode(otherlv_14, grammarAccess.getSuiteDefinitionAccess().getRequiresKeyword_10_0());
                        
                     
                            newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_10_1()); 
                        
                    pushFollow(FOLLOW_35);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalDSL.g:1621:1: ( ( ( ruleQualifiedName ) ) ruleNL )*
                    loop27:
                    do {
                        int alt27=2;
                        int LA27_0 = input.LA(1);

                        if ( (LA27_0==RULE_ID) ) {
                            alt27=1;
                        }


                        switch (alt27) {
                    	case 1 :
                    	    // InternalDSL.g:1621:2: ( ( ruleQualifiedName ) ) ruleNL
                    	    {
                    	    // InternalDSL.g:1621:2: ( ( ruleQualifiedName ) )
                    	    // InternalDSL.g:1622:1: ( ruleQualifiedName )
                    	    {
                    	    // InternalDSL.g:1622:1: ( ruleQualifiedName )
                    	    // InternalDSL.g:1623:3: ruleQualifiedName
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSuiteDefinitionRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getDependenciesSuiteDefinitionCrossReference_10_2_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_35);
                    	    ruleQualifiedName();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	     
                    	            newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_10_2_1()); 
                    	        
                    	    pushFollow(FOLLOW_35);
                    	    ruleNL();

                    	    state._fsp--;

                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop27;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalDSL.g:1644:5: (otherlv_18= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )* )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==47) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalDSL.g:1644:7: otherlv_18= 'concludedby' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )*
                    {
                    otherlv_18=(Token)match(input,47,FOLLOW_36); 

                        	newLeafNode(otherlv_18, grammarAccess.getSuiteDefinitionAccess().getConcludedbyKeyword_11_0());
                        
                     
                            newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_11_1()); 
                        
                    pushFollow(FOLLOW_36);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalDSL.g:1656:1: ( ( ( ruleQualifiedName ) ) ruleNL )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==RULE_ID) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // InternalDSL.g:1656:2: ( ( ruleQualifiedName ) ) ruleNL
                    	    {
                    	    // InternalDSL.g:1656:2: ( ( ruleQualifiedName ) )
                    	    // InternalDSL.g:1657:1: ( ruleQualifiedName )
                    	    {
                    	    // InternalDSL.g:1657:1: ( ruleQualifiedName )
                    	    // InternalDSL.g:1658:3: ruleQualifiedName
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSuiteDefinitionRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getFinalizersSuiteDefinitionCrossReference_11_2_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_36);
                    	    ruleQualifiedName();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	     
                    	            newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_11_2_1()); 
                    	        
                    	    pushFollow(FOLLOW_36);
                    	    ruleNL();

                    	    state._fsp--;

                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop29;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_22=(Token)match(input,30,FOLLOW_37); 

                	newLeafNode(otherlv_22, grammarAccess.getSuiteDefinitionAccess().getWithKeyword_12());
                
             
                    newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_13()); 
                
            pushFollow(FOLLOW_38);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1691:1: ( (lv_statements_24_0= ruleSuiteStatement ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( ((LA31_0>=RULE_SL_VISIBLE_COMMENT && LA31_0<=RULE_DIVIDER)||LA31_0==RULE_ML_DOC_COMMENT||LA31_0==33||LA31_0==42||LA31_0==51||LA31_0==53||LA31_0==55||(LA31_0>=58 && LA31_0<=59)||LA31_0==61||(LA31_0>=63 && LA31_0<=64)||LA31_0==71) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalDSL.g:1692:1: (lv_statements_24_0= ruleSuiteStatement )
            	    {
            	    // InternalDSL.g:1692:1: (lv_statements_24_0= ruleSuiteStatement )
            	    // InternalDSL.g:1693:3: lv_statements_24_0= ruleSuiteStatement
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getStatementsSuiteStatementParserRuleCall_14_0()); 
            	    	    
            	    pushFollow(FOLLOW_38);
            	    lv_statements_24_0=ruleSuiteStatement();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSuiteDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"statements",
            	            		lv_statements_24_0, 
            	            		"de.gebit.integrity.DSL.SuiteStatement");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            otherlv_25=(Token)match(input,48,FOLLOW_4); 

                	newLeafNode(otherlv_25, grammarAccess.getSuiteDefinitionAccess().getSuiteendKeyword_15());
                
             
                    newCompositeNode(grammarAccess.getSuiteDefinitionAccess().getNLParserRuleCall_16()); 
                
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
    // InternalDSL.g:1729:1: entryRuleSuiteParameterDefinition returns [EObject current=null] : iv_ruleSuiteParameterDefinition= ruleSuiteParameterDefinition EOF ;
    public final EObject entryRuleSuiteParameterDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteParameterDefinition = null;


        try {
            // InternalDSL.g:1730:2: (iv_ruleSuiteParameterDefinition= ruleSuiteParameterDefinition EOF )
            // InternalDSL.g:1731:2: iv_ruleSuiteParameterDefinition= ruleSuiteParameterDefinition EOF
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
    // InternalDSL.g:1738:1: ruleSuiteParameterDefinition returns [EObject current=null] : ( ( (lv_name_0_0= ruleVariableEntity ) ) ( ruleNL otherlv_2= 'by default' ( (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ) ;
    public final EObject ruleSuiteParameterDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_default_3_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:1741:28: ( ( ( (lv_name_0_0= ruleVariableEntity ) ) ( ruleNL otherlv_2= 'by default' ( (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ) )
            // InternalDSL.g:1742:1: ( ( (lv_name_0_0= ruleVariableEntity ) ) ( ruleNL otherlv_2= 'by default' ( (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection ) ) )? )
            {
            // InternalDSL.g:1742:1: ( ( (lv_name_0_0= ruleVariableEntity ) ) ( ruleNL otherlv_2= 'by default' ( (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection ) ) )? )
            // InternalDSL.g:1742:2: ( (lv_name_0_0= ruleVariableEntity ) ) ( ruleNL otherlv_2= 'by default' ( (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection ) ) )?
            {
            // InternalDSL.g:1742:2: ( (lv_name_0_0= ruleVariableEntity ) )
            // InternalDSL.g:1743:1: (lv_name_0_0= ruleVariableEntity )
            {
            // InternalDSL.g:1743:1: (lv_name_0_0= ruleVariableEntity )
            // InternalDSL.g:1744:3: lv_name_0_0= ruleVariableEntity
            {
             
            	        newCompositeNode(grammarAccess.getSuiteParameterDefinitionAccess().getNameVariableEntityParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_39);
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

            // InternalDSL.g:1760:2: ( ruleNL otherlv_2= 'by default' ( (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection ) ) )?
            int alt32=2;
            alt32 = dfa32.predict(input);
            switch (alt32) {
                case 1 :
                    // InternalDSL.g:1761:5: ruleNL otherlv_2= 'by default' ( (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection ) )
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteParameterDefinitionAccess().getNLParserRuleCall_1_0()); 
                        
                    pushFollow(FOLLOW_40);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    otherlv_2=(Token)match(input,49,FOLLOW_19); 

                        	newLeafNode(otherlv_2, grammarAccess.getSuiteParameterDefinitionAccess().getByDefaultKeyword_1_1());
                        
                    // InternalDSL.g:1772:1: ( (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection ) )
                    // InternalDSL.g:1773:1: (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection )
                    {
                    // InternalDSL.g:1773:1: (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection )
                    // InternalDSL.g:1774:3: lv_default_3_0= ruleValueOrEnumValueOrOperationCollection
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
    // InternalDSL.g:1798:1: entryRuleSuiteReturnDefinition returns [EObject current=null] : iv_ruleSuiteReturnDefinition= ruleSuiteReturnDefinition EOF ;
    public final EObject entryRuleSuiteReturnDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteReturnDefinition = null;


        try {
            // InternalDSL.g:1799:2: (iv_ruleSuiteReturnDefinition= ruleSuiteReturnDefinition EOF )
            // InternalDSL.g:1800:2: iv_ruleSuiteReturnDefinition= ruleSuiteReturnDefinition EOF
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
    // InternalDSL.g:1807:1: ruleSuiteReturnDefinition returns [EObject current=null] : ( (lv_name_0_0= ruleVariableEntity ) ) ;
    public final EObject ruleSuiteReturnDefinition() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:1810:28: ( ( (lv_name_0_0= ruleVariableEntity ) ) )
            // InternalDSL.g:1811:1: ( (lv_name_0_0= ruleVariableEntity ) )
            {
            // InternalDSL.g:1811:1: ( (lv_name_0_0= ruleVariableEntity ) )
            // InternalDSL.g:1812:1: (lv_name_0_0= ruleVariableEntity )
            {
            // InternalDSL.g:1812:1: (lv_name_0_0= ruleVariableEntity )
            // InternalDSL.g:1813:3: lv_name_0_0= ruleVariableEntity
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
    // InternalDSL.g:1837:1: entryRuleOperationDefinition returns [EObject current=null] : iv_ruleOperationDefinition= ruleOperationDefinition EOF ;
    public final EObject entryRuleOperationDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationDefinition = null;


        try {
            // InternalDSL.g:1838:2: (iv_ruleOperationDefinition= ruleOperationDefinition EOF )
            // InternalDSL.g:1839:2: iv_ruleOperationDefinition= ruleOperationDefinition EOF
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
    // InternalDSL.g:1846:1: ruleOperationDefinition returns [EObject current=null] : (otherlv_0= 'operationdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_operationType_6_0= ruleJavaClassReference ) ) ruleNL ) ;
    public final EObject ruleOperationDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_operationType_6_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:1849:28: ( (otherlv_0= 'operationdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_operationType_6_0= ruleJavaClassReference ) ) ruleNL ) )
            // InternalDSL.g:1850:1: (otherlv_0= 'operationdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_operationType_6_0= ruleJavaClassReference ) ) ruleNL )
            {
            // InternalDSL.g:1850:1: (otherlv_0= 'operationdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_operationType_6_0= ruleJavaClassReference ) ) ruleNL )
            // InternalDSL.g:1850:3: otherlv_0= 'operationdef' ruleNL ( (lv_name_2_0= ruleQualifiedName ) ) ruleNL otherlv_4= 'uses' ruleNL ( (lv_operationType_6_0= ruleJavaClassReference ) ) ruleNL
            {
            otherlv_0=(Token)match(input,50,FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getOperationDefinitionAccess().getOperationdefKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getOperationDefinitionAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_6);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1862:1: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalDSL.g:1863:1: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalDSL.g:1863:1: (lv_name_2_0= ruleQualifiedName )
            // InternalDSL.g:1864:3: lv_name_2_0= ruleQualifiedName
            {
             
            	        newCompositeNode(grammarAccess.getOperationDefinitionAccess().getNameQualifiedNameParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_24);
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
                
            pushFollow(FOLLOW_25);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_4=(Token)match(input,35,FOLLOW_6); 

                	newLeafNode(otherlv_4, grammarAccess.getOperationDefinitionAccess().getUsesKeyword_4());
                
             
                    newCompositeNode(grammarAccess.getOperationDefinitionAccess().getNLParserRuleCall_5()); 
                
            pushFollow(FOLLOW_6);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:1900:1: ( (lv_operationType_6_0= ruleJavaClassReference ) )
            // InternalDSL.g:1901:1: (lv_operationType_6_0= ruleJavaClassReference )
            {
            // InternalDSL.g:1901:1: (lv_operationType_6_0= ruleJavaClassReference )
            // InternalDSL.g:1902:3: lv_operationType_6_0= ruleJavaClassReference
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
    // InternalDSL.g:1934:1: entryRuleSuiteStatement returns [EObject current=null] : iv_ruleSuiteStatement= ruleSuiteStatement EOF ;
    public final EObject entryRuleSuiteStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteStatement = null;


        try {
            // InternalDSL.g:1935:2: (iv_ruleSuiteStatement= ruleSuiteStatement EOF )
            // InternalDSL.g:1936:2: iv_ruleSuiteStatement= ruleSuiteStatement EOF
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
    // InternalDSL.g:1943:1: ruleSuiteStatement returns [EObject current=null] : (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_VariableDefinition_1= ruleVariableDefinition | this_ConstantDefinition_2= ruleConstantDefinition | this_VariableAssignment_3= ruleVariableAssignment | this_TimeSet_4= ruleTimeSet | this_VisibleComment_5= ruleVisibleComment | this_VisibleDivider_6= ruleVisibleDivider ) ;
    public final EObject ruleSuiteStatement() throws RecognitionException {
        EObject current = null;

        EObject this_SuiteStatementWithResult_0 = null;

        EObject this_VariableDefinition_1 = null;

        EObject this_ConstantDefinition_2 = null;

        EObject this_VariableAssignment_3 = null;

        EObject this_TimeSet_4 = null;

        EObject this_VisibleComment_5 = null;

        EObject this_VisibleDivider_6 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:1946:28: ( (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_VariableDefinition_1= ruleVariableDefinition | this_ConstantDefinition_2= ruleConstantDefinition | this_VariableAssignment_3= ruleVariableAssignment | this_TimeSet_4= ruleTimeSet | this_VisibleComment_5= ruleVisibleComment | this_VisibleDivider_6= ruleVisibleDivider ) )
            // InternalDSL.g:1947:1: (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_VariableDefinition_1= ruleVariableDefinition | this_ConstantDefinition_2= ruleConstantDefinition | this_VariableAssignment_3= ruleVariableAssignment | this_TimeSet_4= ruleTimeSet | this_VisibleComment_5= ruleVisibleComment | this_VisibleDivider_6= ruleVisibleDivider )
            {
            // InternalDSL.g:1947:1: (this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult | this_VariableDefinition_1= ruleVariableDefinition | this_ConstantDefinition_2= ruleConstantDefinition | this_VariableAssignment_3= ruleVariableAssignment | this_TimeSet_4= ruleTimeSet | this_VisibleComment_5= ruleVisibleComment | this_VisibleDivider_6= ruleVisibleDivider )
            int alt33=7;
            switch ( input.LA(1) ) {
            case 42:
            case 58:
            case 59:
            case 61:
            case 63:
            case 71:
                {
                alt33=1;
                }
                break;
            case 33:
                {
                int LA33_2 = input.LA(2);

                if ( (LA33_2==51) ) {
                    alt33=2;
                }
                else if ( (LA33_2==53) ) {
                    alt33=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 2, input);

                    throw nvae;
                }
                }
                break;
            case 51:
                {
                alt33=2;
                }
                break;
            case RULE_ML_DOC_COMMENT:
            case 53:
                {
                alt33=3;
                }
                break;
            case 55:
                {
                alt33=4;
                }
                break;
            case 64:
                {
                alt33=5;
                }
                break;
            case RULE_SL_VISIBLE_COMMENT:
            case RULE_SL_VISIBLE_TITLE_COMMENT:
            case RULE_ML_VISIBLE_COMMENT:
            case RULE_ML_VISIBLE_TITLE_COMMENT:
                {
                alt33=6;
                }
                break;
            case RULE_DIVIDER:
                {
                alt33=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // InternalDSL.g:1948:5: this_SuiteStatementWithResult_0= ruleSuiteStatementWithResult
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
                    // InternalDSL.g:1958:5: this_VariableDefinition_1= ruleVariableDefinition
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
                    // InternalDSL.g:1968:5: this_ConstantDefinition_2= ruleConstantDefinition
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
                    // InternalDSL.g:1978:5: this_VariableAssignment_3= ruleVariableAssignment
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
                    // InternalDSL.g:1988:5: this_TimeSet_4= ruleTimeSet
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getTimeSetParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_2);
                    this_TimeSet_4=ruleTimeSet();

                    state._fsp--;

                     
                            current = this_TimeSet_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // InternalDSL.g:1998:5: this_VisibleComment_5= ruleVisibleComment
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getVisibleCommentParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VisibleComment_5=ruleVisibleComment();

                    state._fsp--;

                     
                            current = this_VisibleComment_5; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 7 :
                    // InternalDSL.g:2008:5: this_VisibleDivider_6= ruleVisibleDivider
                    {
                     
                            newCompositeNode(grammarAccess.getSuiteStatementAccess().getVisibleDividerParserRuleCall_6()); 
                        
                    pushFollow(FOLLOW_2);
                    this_VisibleDivider_6=ruleVisibleDivider();

                    state._fsp--;

                     
                            current = this_VisibleDivider_6; 
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
    // InternalDSL.g:2024:1: entryRuleSuiteStatementWithResult returns [EObject current=null] : iv_ruleSuiteStatementWithResult= ruleSuiteStatementWithResult EOF ;
    public final EObject entryRuleSuiteStatementWithResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteStatementWithResult = null;


        try {
            // InternalDSL.g:2025:2: (iv_ruleSuiteStatementWithResult= ruleSuiteStatementWithResult EOF )
            // InternalDSL.g:2026:2: iv_ruleSuiteStatementWithResult= ruleSuiteStatementWithResult EOF
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
    // InternalDSL.g:2033:1: ruleSuiteStatementWithResult returns [EObject current=null] : (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest | this_Call_3= ruleCall ) ;
    public final EObject ruleSuiteStatementWithResult() throws RecognitionException {
        EObject current = null;

        EObject this_Suite_0 = null;

        EObject this_Test_1 = null;

        EObject this_TableTest_2 = null;

        EObject this_Call_3 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:2036:28: ( (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest | this_Call_3= ruleCall ) )
            // InternalDSL.g:2037:1: (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest | this_Call_3= ruleCall )
            {
            // InternalDSL.g:2037:1: (this_Suite_0= ruleSuite | this_Test_1= ruleTest | this_TableTest_2= ruleTableTest | this_Call_3= ruleCall )
            int alt34=4;
            switch ( input.LA(1) ) {
            case 42:
            case 71:
                {
                alt34=1;
                }
                break;
            case 58:
            case 59:
                {
                alt34=2;
                }
                break;
            case 61:
                {
                alt34=3;
                }
                break;
            case 63:
                {
                alt34=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // InternalDSL.g:2038:5: this_Suite_0= ruleSuite
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
                    // InternalDSL.g:2048:5: this_Test_1= ruleTest
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
                    // InternalDSL.g:2058:5: this_TableTest_2= ruleTableTest
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
                    // InternalDSL.g:2068:5: this_Call_3= ruleCall
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
    // InternalDSL.g:2084:1: entryRuleVariableDefinition returns [EObject current=null] : iv_ruleVariableDefinition= ruleVariableDefinition EOF ;
    public final EObject entryRuleVariableDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDefinition = null;


        try {
            // InternalDSL.g:2085:2: (iv_ruleVariableDefinition= ruleVariableDefinition EOF )
            // InternalDSL.g:2086:2: iv_ruleVariableDefinition= ruleVariableDefinition EOF
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
    // InternalDSL.g:2093:1: ruleVariableDefinition returns [EObject current=null] : ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'variable' ruleNL ( (lv_name_3_0= ruleVariableEntity ) ) ruleNL (otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ) ;
    public final EObject ruleVariableDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_private_0_0=null;
        Token otherlv_1=null;
        Token otherlv_5=null;
        EObject lv_name_3_0 = null;

        EObject lv_initialValue_7_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:2096:28: ( ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'variable' ruleNL ( (lv_name_3_0= ruleVariableEntity ) ) ruleNL (otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ) )
            // InternalDSL.g:2097:1: ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'variable' ruleNL ( (lv_name_3_0= ruleVariableEntity ) ) ruleNL (otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? )
            {
            // InternalDSL.g:2097:1: ( ( (lv_private_0_0= 'private' ) )? otherlv_1= 'variable' ruleNL ( (lv_name_3_0= ruleVariableEntity ) ) ruleNL (otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? )
            // InternalDSL.g:2097:2: ( (lv_private_0_0= 'private' ) )? otherlv_1= 'variable' ruleNL ( (lv_name_3_0= ruleVariableEntity ) ) ruleNL (otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )?
            {
            // InternalDSL.g:2097:2: ( (lv_private_0_0= 'private' ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==33) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalDSL.g:2098:1: (lv_private_0_0= 'private' )
                    {
                    // InternalDSL.g:2098:1: (lv_private_0_0= 'private' )
                    // InternalDSL.g:2099:3: lv_private_0_0= 'private'
                    {
                    lv_private_0_0=(Token)match(input,33,FOLLOW_41); 

                            newLeafNode(lv_private_0_0, grammarAccess.getVariableDefinitionAccess().getPrivatePrivateKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getVariableDefinitionRule());
                    	        }
                           		setWithLastConsumed(current, "private", lv_private_0_0, "private");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,51,FOLLOW_6); 

                	newLeafNode(otherlv_1, grammarAccess.getVariableDefinitionAccess().getVariableKeyword_1());
                
             
                    newCompositeNode(grammarAccess.getVariableDefinitionAccess().getNLParserRuleCall_2()); 
                
            pushFollow(FOLLOW_6);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2124:1: ( (lv_name_3_0= ruleVariableEntity ) )
            // InternalDSL.g:2125:1: (lv_name_3_0= ruleVariableEntity )
            {
            // InternalDSL.g:2125:1: (lv_name_3_0= ruleVariableEntity )
            // InternalDSL.g:2126:3: lv_name_3_0= ruleVariableEntity
            {
             
            	        newCompositeNode(grammarAccess.getVariableDefinitionAccess().getNameVariableEntityParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_42);
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
                
            pushFollow(FOLLOW_43);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2150:1: (otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==52) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalDSL.g:2150:3: otherlv_5= 'initially' ruleNL ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL
                    {
                    otherlv_5=(Token)match(input,52,FOLLOW_19); 

                        	newLeafNode(otherlv_5, grammarAccess.getVariableDefinitionAccess().getInitiallyKeyword_5_0());
                        
                     
                            newCompositeNode(grammarAccess.getVariableDefinitionAccess().getNLParserRuleCall_5_1()); 
                        
                    pushFollow(FOLLOW_19);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalDSL.g:2162:1: ( (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection ) )
                    // InternalDSL.g:2163:1: (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection )
                    {
                    // InternalDSL.g:2163:1: (lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection )
                    // InternalDSL.g:2164:3: lv_initialValue_7_0= ruleValueOrEnumValueOrOperationCollection
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
    // InternalDSL.g:2196:1: entryRuleConstantDefinition returns [EObject current=null] : iv_ruleConstantDefinition= ruleConstantDefinition EOF ;
    public final EObject entryRuleConstantDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantDefinition = null;


        try {
            // InternalDSL.g:2197:2: (iv_ruleConstantDefinition= ruleConstantDefinition EOF )
            // InternalDSL.g:2198:2: iv_ruleConstantDefinition= ruleConstantDefinition EOF
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
    // InternalDSL.g:2205:1: ruleConstantDefinition returns [EObject current=null] : ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? otherlv_2= 'constant' ruleNL ( (lv_name_4_0= ruleConstantEntity ) ) ruleNL ( ( ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_8_0= ruleVariantValue ) ) ruleNL )* ) ( ( (lv_parameterized_10_0= 'parameterized' ) ) ruleNL )? ) ;
    public final EObject ruleConstantDefinition() throws RecognitionException {
        EObject current = null;

        Token lv_private_1_0=null;
        Token otherlv_2=null;
        Token lv_parameterized_10_0=null;
        EObject lv_documentation_0_0 = null;

        EObject lv_name_4_0 = null;

        EObject lv_value_6_0 = null;

        EObject lv_variantValues_8_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:2208:28: ( ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? otherlv_2= 'constant' ruleNL ( (lv_name_4_0= ruleConstantEntity ) ) ruleNL ( ( ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_8_0= ruleVariantValue ) ) ruleNL )* ) ( ( (lv_parameterized_10_0= 'parameterized' ) ) ruleNL )? ) )
            // InternalDSL.g:2209:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? otherlv_2= 'constant' ruleNL ( (lv_name_4_0= ruleConstantEntity ) ) ruleNL ( ( ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_8_0= ruleVariantValue ) ) ruleNL )* ) ( ( (lv_parameterized_10_0= 'parameterized' ) ) ruleNL )? )
            {
            // InternalDSL.g:2209:1: ( ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? otherlv_2= 'constant' ruleNL ( (lv_name_4_0= ruleConstantEntity ) ) ruleNL ( ( ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_8_0= ruleVariantValue ) ) ruleNL )* ) ( ( (lv_parameterized_10_0= 'parameterized' ) ) ruleNL )? )
            // InternalDSL.g:2209:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )? ( (lv_private_1_0= 'private' ) )? otherlv_2= 'constant' ruleNL ( (lv_name_4_0= ruleConstantEntity ) ) ruleNL ( ( ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_8_0= ruleVariantValue ) ) ruleNL )* ) ( ( (lv_parameterized_10_0= 'parameterized' ) ) ruleNL )?
            {
            // InternalDSL.g:2209:2: ( (lv_documentation_0_0= ruleDocumentationComment ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_ML_DOC_COMMENT) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalDSL.g:2210:1: (lv_documentation_0_0= ruleDocumentationComment )
                    {
                    // InternalDSL.g:2210:1: (lv_documentation_0_0= ruleDocumentationComment )
                    // InternalDSL.g:2211:3: lv_documentation_0_0= ruleDocumentationComment
                    {
                     
                    	        newCompositeNode(grammarAccess.getConstantDefinitionAccess().getDocumentationDocumentationCommentParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_44);
                    lv_documentation_0_0=ruleDocumentationComment();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConstantDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"documentation",
                            		lv_documentation_0_0, 
                            		"de.gebit.integrity.DSL.DocumentationComment");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // InternalDSL.g:2227:3: ( (lv_private_1_0= 'private' ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==33) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalDSL.g:2228:1: (lv_private_1_0= 'private' )
                    {
                    // InternalDSL.g:2228:1: (lv_private_1_0= 'private' )
                    // InternalDSL.g:2229:3: lv_private_1_0= 'private'
                    {
                    lv_private_1_0=(Token)match(input,33,FOLLOW_45); 

                            newLeafNode(lv_private_1_0, grammarAccess.getConstantDefinitionAccess().getPrivatePrivateKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConstantDefinitionRule());
                    	        }
                           		setWithLastConsumed(current, "private", lv_private_1_0, "private");
                    	    

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,53,FOLLOW_6); 

                	newLeafNode(otherlv_2, grammarAccess.getConstantDefinitionAccess().getConstantKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getConstantDefinitionAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_6);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2254:1: ( (lv_name_4_0= ruleConstantEntity ) )
            // InternalDSL.g:2255:1: (lv_name_4_0= ruleConstantEntity )
            {
            // InternalDSL.g:2255:1: (lv_name_4_0= ruleConstantEntity )
            // InternalDSL.g:2256:3: lv_name_4_0= ruleConstantEntity
            {
             
            	        newCompositeNode(grammarAccess.getConstantDefinitionAccess().getNameConstantEntityParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_46);
            lv_name_4_0=ruleConstantEntity();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConstantDefinitionRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_4_0, 
                    		"de.gebit.integrity.DSL.ConstantEntity");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getConstantDefinitionAccess().getNLParserRuleCall_5()); 
                
            pushFollow(FOLLOW_47);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2280:1: ( ( ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_8_0= ruleVariantValue ) ) ruleNL )* )
            // InternalDSL.g:2280:2: ( ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( (lv_variantValues_8_0= ruleVariantValue ) ) ruleNL )*
            {
            // InternalDSL.g:2280:2: ( ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( ((LA39_0>=RULE_STRING && LA39_0<=RULE_UPPERCASE_ID)||LA39_0==73||LA39_0==80||LA39_0==82||(LA39_0>=85 && LA39_0<=86)) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalDSL.g:2280:3: ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL
                    {
                    // InternalDSL.g:2280:3: ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) )
                    // InternalDSL.g:2281:1: (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection )
                    {
                    // InternalDSL.g:2281:1: (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection )
                    // InternalDSL.g:2282:3: lv_value_6_0= ruleValueOrEnumValueOrOperationCollection
                    {
                     
                    	        newCompositeNode(grammarAccess.getConstantDefinitionAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_6_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_48);
                    lv_value_6_0=ruleValueOrEnumValueOrOperationCollection();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConstantDefinitionRule());
                    	        }
                           		set(
                           			current, 
                           			"value",
                            		lv_value_6_0, 
                            		"de.gebit.integrity.DSL.ValueOrEnumValueOrOperationCollection");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getConstantDefinitionAccess().getNLParserRuleCall_6_0_1()); 
                        
                    pushFollow(FOLLOW_49);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // InternalDSL.g:2306:3: ( ( (lv_variantValues_8_0= ruleVariantValue ) ) ruleNL )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==57) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalDSL.g:2306:4: ( (lv_variantValues_8_0= ruleVariantValue ) ) ruleNL
            	    {
            	    // InternalDSL.g:2306:4: ( (lv_variantValues_8_0= ruleVariantValue ) )
            	    // InternalDSL.g:2307:1: (lv_variantValues_8_0= ruleVariantValue )
            	    {
            	    // InternalDSL.g:2307:1: (lv_variantValues_8_0= ruleVariantValue )
            	    // InternalDSL.g:2308:3: lv_variantValues_8_0= ruleVariantValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConstantDefinitionAccess().getVariantValuesVariantValueParserRuleCall_6_1_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_48);
            	    lv_variantValues_8_0=ruleVariantValue();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConstantDefinitionRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"variantValues",
            	            		lv_variantValues_8_0, 
            	            		"de.gebit.integrity.DSL.VariantValue");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	     
            	            newCompositeNode(grammarAccess.getConstantDefinitionAccess().getNLParserRuleCall_6_1_1()); 
            	        
            	    pushFollow(FOLLOW_49);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


            }

            // InternalDSL.g:2332:4: ( ( (lv_parameterized_10_0= 'parameterized' ) ) ruleNL )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==54) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalDSL.g:2332:5: ( (lv_parameterized_10_0= 'parameterized' ) ) ruleNL
                    {
                    // InternalDSL.g:2332:5: ( (lv_parameterized_10_0= 'parameterized' ) )
                    // InternalDSL.g:2333:1: (lv_parameterized_10_0= 'parameterized' )
                    {
                    // InternalDSL.g:2333:1: (lv_parameterized_10_0= 'parameterized' )
                    // InternalDSL.g:2334:3: lv_parameterized_10_0= 'parameterized'
                    {
                    lv_parameterized_10_0=(Token)match(input,54,FOLLOW_4); 

                            newLeafNode(lv_parameterized_10_0, grammarAccess.getConstantDefinitionAccess().getParameterizedParameterizedKeyword_7_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getConstantDefinitionRule());
                    	        }
                           		setWithLastConsumed(current, "parameterized", lv_parameterized_10_0, "parameterized");
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getConstantDefinitionAccess().getNLParserRuleCall_7_1()); 
                        
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
    // InternalDSL.g:2363:1: entryRuleVariableAssignment returns [EObject current=null] : iv_ruleVariableAssignment= ruleVariableAssignment EOF ;
    public final EObject entryRuleVariableAssignment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableAssignment = null;


        try {
            // InternalDSL.g:2364:2: (iv_ruleVariableAssignment= ruleVariableAssignment EOF )
            // InternalDSL.g:2365:2: iv_ruleVariableAssignment= ruleVariableAssignment EOF
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
    // InternalDSL.g:2372:1: ruleVariableAssignment returns [EObject current=null] : (otherlv_0= 'assign' ruleNL ( (lv_value_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL otherlv_4= '->' ruleNL ( (lv_target_6_0= ruleVariableVariable ) ) ruleNL ) ;
    public final EObject ruleVariableAssignment() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject lv_value_2_0 = null;

        EObject lv_target_6_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:2375:28: ( (otherlv_0= 'assign' ruleNL ( (lv_value_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL otherlv_4= '->' ruleNL ( (lv_target_6_0= ruleVariableVariable ) ) ruleNL ) )
            // InternalDSL.g:2376:1: (otherlv_0= 'assign' ruleNL ( (lv_value_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL otherlv_4= '->' ruleNL ( (lv_target_6_0= ruleVariableVariable ) ) ruleNL )
            {
            // InternalDSL.g:2376:1: (otherlv_0= 'assign' ruleNL ( (lv_value_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL otherlv_4= '->' ruleNL ( (lv_target_6_0= ruleVariableVariable ) ) ruleNL )
            // InternalDSL.g:2376:3: otherlv_0= 'assign' ruleNL ( (lv_value_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL otherlv_4= '->' ruleNL ( (lv_target_6_0= ruleVariableVariable ) ) ruleNL
            {
            otherlv_0=(Token)match(input,55,FOLLOW_19); 

                	newLeafNode(otherlv_0, grammarAccess.getVariableAssignmentAccess().getAssignKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getVariableAssignmentAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_19);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2388:1: ( (lv_value_2_0= ruleValueOrEnumValueOrOperationCollection ) )
            // InternalDSL.g:2389:1: (lv_value_2_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // InternalDSL.g:2389:1: (lv_value_2_0= ruleValueOrEnumValueOrOperationCollection )
            // InternalDSL.g:2390:3: lv_value_2_0= ruleValueOrEnumValueOrOperationCollection
            {
             
            	        newCompositeNode(grammarAccess.getVariableAssignmentAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_50);
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
                
            pushFollow(FOLLOW_51);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_4=(Token)match(input,56,FOLLOW_6); 

                	newLeafNode(otherlv_4, grammarAccess.getVariableAssignmentAccess().getHyphenMinusGreaterThanSignKeyword_4());
                
             
                    newCompositeNode(grammarAccess.getVariableAssignmentAccess().getNLParserRuleCall_5()); 
                
            pushFollow(FOLLOW_6);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2426:1: ( (lv_target_6_0= ruleVariableVariable ) )
            // InternalDSL.g:2427:1: (lv_target_6_0= ruleVariableVariable )
            {
            // InternalDSL.g:2427:1: (lv_target_6_0= ruleVariableVariable )
            // InternalDSL.g:2428:3: lv_target_6_0= ruleVariableVariable
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
    // InternalDSL.g:2460:1: entryRuleVariantValue returns [EObject current=null] : iv_ruleVariantValue= ruleVariantValue EOF ;
    public final EObject entryRuleVariantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariantValue = null;


        try {
            // InternalDSL.g:2461:2: (iv_ruleVariantValue= ruleVariantValue EOF )
            // InternalDSL.g:2462:2: iv_ruleVariantValue= ruleVariantValue EOF
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
    // InternalDSL.g:2469:1: ruleVariantValue returns [EObject current=null] : (otherlv_0= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ otherlv_4= ':' ruleNL ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) ) ;
    public final EObject ruleVariantValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject lv_value_6_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:2472:28: ( (otherlv_0= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ otherlv_4= ':' ruleNL ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) ) )
            // InternalDSL.g:2473:1: (otherlv_0= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ otherlv_4= ':' ruleNL ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            {
            // InternalDSL.g:2473:1: (otherlv_0= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ otherlv_4= ':' ruleNL ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            // InternalDSL.g:2473:3: otherlv_0= 'in' ruleNL ( ( ( ruleQualifiedName ) ) ruleNL )+ otherlv_4= ':' ruleNL ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) )
            {
            otherlv_0=(Token)match(input,57,FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getVariantValueAccess().getInKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getVariantValueAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_6);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2485:1: ( ( ( ruleQualifiedName ) ) ruleNL )+
            int cnt42=0;
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==RULE_ID) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalDSL.g:2485:2: ( ( ruleQualifiedName ) ) ruleNL
            	    {
            	    // InternalDSL.g:2485:2: ( ( ruleQualifiedName ) )
            	    // InternalDSL.g:2486:1: ( ruleQualifiedName )
            	    {
            	    // InternalDSL.g:2486:1: ( ruleQualifiedName )
            	    // InternalDSL.g:2487:3: ruleQualifiedName
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getVariantValueRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getVariantValueAccess().getNamesVariantDefinitionCrossReference_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_52);
            	    ruleQualifiedName();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	     
            	            newCompositeNode(grammarAccess.getVariantValueAccess().getNLParserRuleCall_2_1()); 
            	        
            	    pushFollow(FOLLOW_52);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

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

            otherlv_4=(Token)match(input,37,FOLLOW_19); 

                	newLeafNode(otherlv_4, grammarAccess.getVariantValueAccess().getColonKeyword_3());
                
             
                    newCompositeNode(grammarAccess.getVariantValueAccess().getNLParserRuleCall_4()); 
                
            pushFollow(FOLLOW_19);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2520:1: ( (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection ) )
            // InternalDSL.g:2521:1: (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // InternalDSL.g:2521:1: (lv_value_6_0= ruleValueOrEnumValueOrOperationCollection )
            // InternalDSL.g:2522:3: lv_value_6_0= ruleValueOrEnumValueOrOperationCollection
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
    // InternalDSL.g:2546:1: entryRuleVariableEntity returns [EObject current=null] : iv_ruleVariableEntity= ruleVariableEntity EOF ;
    public final EObject entryRuleVariableEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableEntity = null;


        try {
            // InternalDSL.g:2547:2: (iv_ruleVariableEntity= ruleVariableEntity EOF )
            // InternalDSL.g:2548:2: iv_ruleVariableEntity= ruleVariableEntity EOF
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
    // InternalDSL.g:2555:1: ruleVariableEntity returns [EObject current=null] : ( (lv_name_0_0= ruleQualifiedName ) ) ;
    public final EObject ruleVariableEntity() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:2558:28: ( ( (lv_name_0_0= ruleQualifiedName ) ) )
            // InternalDSL.g:2559:1: ( (lv_name_0_0= ruleQualifiedName ) )
            {
            // InternalDSL.g:2559:1: ( (lv_name_0_0= ruleQualifiedName ) )
            // InternalDSL.g:2560:1: (lv_name_0_0= ruleQualifiedName )
            {
            // InternalDSL.g:2560:1: (lv_name_0_0= ruleQualifiedName )
            // InternalDSL.g:2561:3: lv_name_0_0= ruleQualifiedName
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
    // InternalDSL.g:2585:1: entryRuleConstantEntity returns [EObject current=null] : iv_ruleConstantEntity= ruleConstantEntity EOF ;
    public final EObject entryRuleConstantEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantEntity = null;


        try {
            // InternalDSL.g:2586:2: (iv_ruleConstantEntity= ruleConstantEntity EOF )
            // InternalDSL.g:2587:2: iv_ruleConstantEntity= ruleConstantEntity EOF
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
    // InternalDSL.g:2594:1: ruleConstantEntity returns [EObject current=null] : ( (lv_name_0_0= ruleQualifiedName ) ) ;
    public final EObject ruleConstantEntity() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:2597:28: ( ( (lv_name_0_0= ruleQualifiedName ) ) )
            // InternalDSL.g:2598:1: ( (lv_name_0_0= ruleQualifiedName ) )
            {
            // InternalDSL.g:2598:1: ( (lv_name_0_0= ruleQualifiedName ) )
            // InternalDSL.g:2599:1: (lv_name_0_0= ruleQualifiedName )
            {
            // InternalDSL.g:2599:1: (lv_name_0_0= ruleQualifiedName )
            // InternalDSL.g:2600:3: lv_name_0_0= ruleQualifiedName
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
    // InternalDSL.g:2626:1: entryRuleTest returns [EObject current=null] : iv_ruleTest= ruleTest EOF ;
    public final EObject entryRuleTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTest = null;


        try {
            // InternalDSL.g:2627:2: (iv_ruleTest= ruleTest EOF )
            // InternalDSL.g:2628:2: iv_ruleTest= ruleTest EOF
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
    // InternalDSL.g:2635:1: ruleTest returns [EObject current=null] : ( ( (lv_checkpoint_0_0= 'checkpoint' ) )? otherlv_1= 'test' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_5_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_7_0= ruleNamedResult ) ) )* ( ruleNL otherlv_9= '=' ruleNL ( (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL ) ;
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
            // InternalDSL.g:2638:28: ( ( ( (lv_checkpoint_0_0= 'checkpoint' ) )? otherlv_1= 'test' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_5_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_7_0= ruleNamedResult ) ) )* ( ruleNL otherlv_9= '=' ruleNL ( (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL ) )
            // InternalDSL.g:2639:1: ( ( (lv_checkpoint_0_0= 'checkpoint' ) )? otherlv_1= 'test' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_5_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_7_0= ruleNamedResult ) ) )* ( ruleNL otherlv_9= '=' ruleNL ( (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL )
            {
            // InternalDSL.g:2639:1: ( ( (lv_checkpoint_0_0= 'checkpoint' ) )? otherlv_1= 'test' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_5_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_7_0= ruleNamedResult ) ) )* ( ruleNL otherlv_9= '=' ruleNL ( (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL )
            // InternalDSL.g:2639:2: ( (lv_checkpoint_0_0= 'checkpoint' ) )? otherlv_1= 'test' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_5_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_7_0= ruleNamedResult ) ) )* ( ruleNL otherlv_9= '=' ruleNL ( (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL
            {
            // InternalDSL.g:2639:2: ( (lv_checkpoint_0_0= 'checkpoint' ) )?
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==58) ) {
                alt43=1;
            }
            switch (alt43) {
                case 1 :
                    // InternalDSL.g:2640:1: (lv_checkpoint_0_0= 'checkpoint' )
                    {
                    // InternalDSL.g:2640:1: (lv_checkpoint_0_0= 'checkpoint' )
                    // InternalDSL.g:2641:3: lv_checkpoint_0_0= 'checkpoint'
                    {
                    lv_checkpoint_0_0=(Token)match(input,58,FOLLOW_53); 

                            newLeafNode(lv_checkpoint_0_0, grammarAccess.getTestAccess().getCheckpointCheckpointKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTestRule());
                    	        }
                           		setWithLastConsumed(current, "checkpoint", lv_checkpoint_0_0, "checkpoint");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,59,FOLLOW_6); 

                	newLeafNode(otherlv_1, grammarAccess.getTestAccess().getTestKeyword_1());
                
             
                    newCompositeNode(grammarAccess.getTestAccess().getNLParserRuleCall_2()); 
                
            pushFollow(FOLLOW_6);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2666:1: ( ( ruleQualifiedName ) )
            // InternalDSL.g:2667:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:2667:1: ( ruleQualifiedName )
            // InternalDSL.g:2668:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTestRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTestAccess().getDefinitionTestDefinitionCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_54);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalDSL.g:2681:2: ( ruleNL ( (lv_parameters_5_0= ruleParameter ) ) )*
            loop44:
            do {
                int alt44=2;
                alt44 = dfa44.predict(input);
                switch (alt44) {
            	case 1 :
            	    // InternalDSL.g:2682:5: ruleNL ( (lv_parameters_5_0= ruleParameter ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getTestAccess().getNLParserRuleCall_4_0()); 
            	        
            	    pushFollow(FOLLOW_55);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // InternalDSL.g:2689:1: ( (lv_parameters_5_0= ruleParameter ) )
            	    // InternalDSL.g:2690:1: (lv_parameters_5_0= ruleParameter )
            	    {
            	    // InternalDSL.g:2690:1: (lv_parameters_5_0= ruleParameter )
            	    // InternalDSL.g:2691:3: lv_parameters_5_0= ruleParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTestAccess().getParametersParameterParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_54);
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
            	    break loop44;
                }
            } while (true);

            // InternalDSL.g:2707:4: ( ruleNL ( (lv_results_7_0= ruleNamedResult ) ) )*
            loop45:
            do {
                int alt45=2;
                alt45 = dfa45.predict(input);
                switch (alt45) {
            	case 1 :
            	    // InternalDSL.g:2708:5: ruleNL ( (lv_results_7_0= ruleNamedResult ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getTestAccess().getNLParserRuleCall_5_0()); 
            	        
            	    pushFollow(FOLLOW_55);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // InternalDSL.g:2715:1: ( (lv_results_7_0= ruleNamedResult ) )
            	    // InternalDSL.g:2716:1: (lv_results_7_0= ruleNamedResult )
            	    {
            	    // InternalDSL.g:2716:1: (lv_results_7_0= ruleNamedResult )
            	    // InternalDSL.g:2717:3: lv_results_7_0= ruleNamedResult
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTestAccess().getResultsNamedResultParserRuleCall_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_54);
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
            	    break loop45;
                }
            } while (true);

            // InternalDSL.g:2733:4: ( ruleNL otherlv_9= '=' ruleNL ( (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection ) ) )?
            int alt46=2;
            alt46 = dfa46.predict(input);
            switch (alt46) {
                case 1 :
                    // InternalDSL.g:2734:5: ruleNL otherlv_9= '=' ruleNL ( (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection ) )
                    {
                     
                            newCompositeNode(grammarAccess.getTestAccess().getNLParserRuleCall_6_0()); 
                        
                    pushFollow(FOLLOW_56);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    otherlv_9=(Token)match(input,60,FOLLOW_19); 

                        	newLeafNode(otherlv_9, grammarAccess.getTestAccess().getEqualsSignKeyword_6_1());
                        
                     
                            newCompositeNode(grammarAccess.getTestAccess().getNLParserRuleCall_6_2()); 
                        
                    pushFollow(FOLLOW_19);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalDSL.g:2753:1: ( (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection ) )
                    // InternalDSL.g:2754:1: (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection )
                    {
                    // InternalDSL.g:2754:1: (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection )
                    // InternalDSL.g:2755:3: lv_result_11_0= ruleValueOrEnumValueOrOperationCollection
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
    // InternalDSL.g:2787:1: entryRuleTableTest returns [EObject current=null] : iv_ruleTableTest= ruleTableTest EOF ;
    public final EObject entryRuleTableTest() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTableTest = null;


        try {
            // InternalDSL.g:2788:2: (iv_ruleTableTest= ruleTableTest EOF )
            // InternalDSL.g:2789:2: iv_ruleTableTest= ruleTableTest EOF
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
    // InternalDSL.g:2796:1: ruleTableTest returns [EObject current=null] : (otherlv_0= 'tabletest' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ruleNLFORCED ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )* otherlv_8= '|' ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )? ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+ ruleNLFORCED ) ;
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
            // InternalDSL.g:2799:28: ( (otherlv_0= 'tabletest' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ruleNLFORCED ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )* otherlv_8= '|' ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )? ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+ ruleNLFORCED ) )
            // InternalDSL.g:2800:1: (otherlv_0= 'tabletest' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ruleNLFORCED ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )* otherlv_8= '|' ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )? ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+ ruleNLFORCED )
            {
            // InternalDSL.g:2800:1: (otherlv_0= 'tabletest' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ruleNLFORCED ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )* otherlv_8= '|' ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )? ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+ ruleNLFORCED )
            // InternalDSL.g:2800:3: otherlv_0= 'tabletest' ruleNL ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )* ruleNLFORCED ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )* ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )* otherlv_8= '|' ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )? ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+ ruleNLFORCED
            {
            otherlv_0=(Token)match(input,61,FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getTableTestAccess().getTabletestKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getTableTestAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_6);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2812:1: ( ( ruleQualifiedName ) )
            // InternalDSL.g:2813:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:2813:1: ( ruleQualifiedName )
            // InternalDSL.g:2814:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTableTestRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTableTestAccess().getDefinitionTestDefinitionCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_55);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalDSL.g:2827:2: ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )*
            loop47:
            do {
                int alt47=2;
                alt47 = dfa47.predict(input);
                switch (alt47) {
            	case 1 :
            	    // InternalDSL.g:2828:5: ruleNL ( (lv_parameters_4_0= ruleParameter ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getTableTestAccess().getNLParserRuleCall_3_0()); 
            	        
            	    pushFollow(FOLLOW_55);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // InternalDSL.g:2835:1: ( (lv_parameters_4_0= ruleParameter ) )
            	    // InternalDSL.g:2836:1: (lv_parameters_4_0= ruleParameter )
            	    {
            	    // InternalDSL.g:2836:1: (lv_parameters_4_0= ruleParameter )
            	    // InternalDSL.g:2837:3: lv_parameters_4_0= ruleParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getParametersParameterParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_55);
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
            	    break loop47;
                }
            } while (true);

             
                    newCompositeNode(grammarAccess.getTableTestAccess().getNLFORCEDParserRuleCall_4()); 
                
            pushFollow(FOLLOW_57);
            ruleNLFORCED();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:2861:1: ( (lv_parameterHeaders_6_0= ruleParameterTableHeader ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==62) ) {
                    int LA48_1 = input.LA(2);

                    if ( (LA48_1==RULE_ID) ) {
                        int LA48_2 = input.LA(3);

                        if ( (LA48_2==62) ) {
                            alt48=1;
                        }


                    }
                    else if ( (LA48_1==72) ) {
                        int LA48_3 = input.LA(3);

                        if ( (LA48_3==RULE_ID) ) {
                            int LA48_6 = input.LA(4);

                            if ( (LA48_6==62) ) {
                                alt48=1;
                            }


                        }
                        else if ( (LA48_3==RULE_STRING) ) {
                            int LA48_7 = input.LA(4);

                            if ( (LA48_7==62) ) {
                                alt48=1;
                            }


                        }


                    }


                }


                switch (alt48) {
            	case 1 :
            	    // InternalDSL.g:2862:1: (lv_parameterHeaders_6_0= ruleParameterTableHeader )
            	    {
            	    // InternalDSL.g:2862:1: (lv_parameterHeaders_6_0= ruleParameterTableHeader )
            	    // InternalDSL.g:2863:3: lv_parameterHeaders_6_0= ruleParameterTableHeader
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getParameterHeadersParameterTableHeaderParserRuleCall_5_0()); 
            	    	    
            	    pushFollow(FOLLOW_57);
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
            	    break loop48;
                }
            } while (true);

            // InternalDSL.g:2879:3: ( (lv_resultHeaders_7_0= ruleResultTableHeader ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==62) ) {
                    int LA49_1 = input.LA(2);

                    if ( (LA49_1==RULE_ID||LA49_1==72) ) {
                        alt49=1;
                    }


                }


                switch (alt49) {
            	case 1 :
            	    // InternalDSL.g:2880:1: (lv_resultHeaders_7_0= ruleResultTableHeader )
            	    {
            	    // InternalDSL.g:2880:1: (lv_resultHeaders_7_0= ruleResultTableHeader )
            	    // InternalDSL.g:2881:3: lv_resultHeaders_7_0= ruleResultTableHeader
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getResultHeadersResultTableHeaderParserRuleCall_6_0()); 
            	    	    
            	    pushFollow(FOLLOW_57);
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
            	    break loop49;
                }
            } while (true);

            otherlv_8=(Token)match(input,62,FOLLOW_54); 

                	newLeafNode(otherlv_8, grammarAccess.getTableTestAccess().getVerticalLineKeyword_7());
                
            // InternalDSL.g:2901:1: ( ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|' )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==60) ) {
                alt50=1;
            }
            switch (alt50) {
                case 1 :
                    // InternalDSL.g:2901:2: ( (lv_defaultResultColumn_9_0= '=' ) ) otherlv_10= '|'
                    {
                    // InternalDSL.g:2901:2: ( (lv_defaultResultColumn_9_0= '=' ) )
                    // InternalDSL.g:2902:1: (lv_defaultResultColumn_9_0= '=' )
                    {
                    // InternalDSL.g:2902:1: (lv_defaultResultColumn_9_0= '=' )
                    // InternalDSL.g:2903:3: lv_defaultResultColumn_9_0= '='
                    {
                    lv_defaultResultColumn_9_0=(Token)match(input,60,FOLLOW_57); 

                            newLeafNode(lv_defaultResultColumn_9_0, grammarAccess.getTableTestAccess().getDefaultResultColumnEqualsSignKeyword_8_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTableTestRule());
                    	        }
                           		setWithLastConsumed(current, "defaultResultColumn", lv_defaultResultColumn_9_0, "=");
                    	    

                    }


                    }

                    otherlv_10=(Token)match(input,62,FOLLOW_55); 

                        	newLeafNode(otherlv_10, grammarAccess.getTableTestAccess().getVerticalLineKeyword_8_1());
                        

                    }
                    break;

            }

            // InternalDSL.g:2920:3: ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+
            int cnt51=0;
            loop51:
            do {
                int alt51=2;
                alt51 = dfa51.predict(input);
                switch (alt51) {
            	case 1 :
            	    // InternalDSL.g:2921:5: ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getTableTestAccess().getNLFORCEDParserRuleCall_9_0()); 
            	        
            	    pushFollow(FOLLOW_57);
            	    ruleNLFORCED();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // InternalDSL.g:2928:1: ( (lv_rows_12_0= ruleTableTestRow ) )
            	    // InternalDSL.g:2929:1: (lv_rows_12_0= ruleTableTestRow )
            	    {
            	    // InternalDSL.g:2929:1: (lv_rows_12_0= ruleTableTestRow )
            	    // InternalDSL.g:2930:3: lv_rows_12_0= ruleTableTestRow
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestAccess().getRowsTableTestRowParserRuleCall_9_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_55);
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
            	    if ( cnt51 >= 1 ) break loop51;
                        EarlyExitException eee =
                            new EarlyExitException(51, input);
                        throw eee;
                }
                cnt51++;
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
    // InternalDSL.g:2962:1: entryRuleTableTestRow returns [EObject current=null] : iv_ruleTableTestRow= ruleTableTestRow EOF ;
    public final EObject entryRuleTableTestRow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTableTestRow = null;


        try {
            // InternalDSL.g:2963:2: (iv_ruleTableTestRow= ruleTableTestRow EOF )
            // InternalDSL.g:2964:2: iv_ruleTableTestRow= ruleTableTestRow EOF
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
    // InternalDSL.g:2971:1: ruleTableTestRow returns [EObject current=null] : ( () ( (lv_values_1_0= ruleParameterTableValue ) )+ ) ;
    public final EObject ruleTableTestRow() throws RecognitionException {
        EObject current = null;

        EObject lv_values_1_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:2974:28: ( ( () ( (lv_values_1_0= ruleParameterTableValue ) )+ ) )
            // InternalDSL.g:2975:1: ( () ( (lv_values_1_0= ruleParameterTableValue ) )+ )
            {
            // InternalDSL.g:2975:1: ( () ( (lv_values_1_0= ruleParameterTableValue ) )+ )
            // InternalDSL.g:2975:2: () ( (lv_values_1_0= ruleParameterTableValue ) )+
            {
            // InternalDSL.g:2975:2: ()
            // InternalDSL.g:2976:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTableTestRowAccess().getTableTestRowAction_0(),
                        current);
                

            }

            // InternalDSL.g:2981:2: ( (lv_values_1_0= ruleParameterTableValue ) )+
            int cnt52=0;
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==62) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalDSL.g:2982:1: (lv_values_1_0= ruleParameterTableValue )
            	    {
            	    // InternalDSL.g:2982:1: (lv_values_1_0= ruleParameterTableValue )
            	    // InternalDSL.g:2983:3: lv_values_1_0= ruleParameterTableValue
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTableTestRowAccess().getValuesParameterTableValueParserRuleCall_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_58);
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
            	    if ( cnt52 >= 1 ) break loop52;
                        EarlyExitException eee =
                            new EarlyExitException(52, input);
                        throw eee;
                }
                cnt52++;
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
    // InternalDSL.g:3007:1: entryRuleParameterTableHeader returns [EObject current=null] : iv_ruleParameterTableHeader= ruleParameterTableHeader EOF ;
    public final EObject entryRuleParameterTableHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterTableHeader = null;


        try {
            // InternalDSL.g:3008:2: (iv_ruleParameterTableHeader= ruleParameterTableHeader EOF )
            // InternalDSL.g:3009:2: iv_ruleParameterTableHeader= ruleParameterTableHeader EOF
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
    // InternalDSL.g:3016:1: ruleParameterTableHeader returns [EObject current=null] : (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) (otherlv_2= '|' )? ) ;
    public final EObject ruleParameterTableHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:3019:28: ( (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) (otherlv_2= '|' )? ) )
            // InternalDSL.g:3020:1: (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) (otherlv_2= '|' )? )
            {
            // InternalDSL.g:3020:1: (otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) (otherlv_2= '|' )? )
            // InternalDSL.g:3020:3: otherlv_0= '|' ( (lv_name_1_0= ruleParameterName ) ) (otherlv_2= '|' )?
            {
            otherlv_0=(Token)match(input,62,FOLLOW_55); 

                	newLeafNode(otherlv_0, grammarAccess.getParameterTableHeaderAccess().getVerticalLineKeyword_0());
                
            // InternalDSL.g:3024:1: ( (lv_name_1_0= ruleParameterName ) )
            // InternalDSL.g:3025:1: (lv_name_1_0= ruleParameterName )
            {
            // InternalDSL.g:3025:1: (lv_name_1_0= ruleParameterName )
            // InternalDSL.g:3026:3: lv_name_1_0= ruleParameterName
            {
             
            	        newCompositeNode(grammarAccess.getParameterTableHeaderAccess().getNameParameterNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_58);
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

            // InternalDSL.g:3042:2: (otherlv_2= '|' )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==62) ) {
                int LA53_1 = input.LA(2);

                if ( (LA53_1==EOF||LA53_1==62) ) {
                    alt53=1;
                }
            }
            switch (alt53) {
                case 1 :
                    // InternalDSL.g:3042:4: otherlv_2= '|'
                    {
                    otherlv_2=(Token)match(input,62,FOLLOW_2); 

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
    // InternalDSL.g:3054:1: entryRuleResultTableHeader returns [EObject current=null] : iv_ruleResultTableHeader= ruleResultTableHeader EOF ;
    public final EObject entryRuleResultTableHeader() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultTableHeader = null;


        try {
            // InternalDSL.g:3055:2: (iv_ruleResultTableHeader= ruleResultTableHeader EOF )
            // InternalDSL.g:3056:2: iv_ruleResultTableHeader= ruleResultTableHeader EOF
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
    // InternalDSL.g:3063:1: ruleResultTableHeader returns [EObject current=null] : (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' (otherlv_3= '|' )? ) ;
    public final EObject ruleResultTableHeader() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        EObject lv_name_1_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:3066:28: ( (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' (otherlv_3= '|' )? ) )
            // InternalDSL.g:3067:1: (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' (otherlv_3= '|' )? )
            {
            // InternalDSL.g:3067:1: (otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' (otherlv_3= '|' )? )
            // InternalDSL.g:3067:3: otherlv_0= '|' ( (lv_name_1_0= ruleResultName ) ) otherlv_2= '=' (otherlv_3= '|' )?
            {
            otherlv_0=(Token)match(input,62,FOLLOW_55); 

                	newLeafNode(otherlv_0, grammarAccess.getResultTableHeaderAccess().getVerticalLineKeyword_0());
                
            // InternalDSL.g:3071:1: ( (lv_name_1_0= ruleResultName ) )
            // InternalDSL.g:3072:1: (lv_name_1_0= ruleResultName )
            {
            // InternalDSL.g:3072:1: (lv_name_1_0= ruleResultName )
            // InternalDSL.g:3073:3: lv_name_1_0= ruleResultName
            {
             
            	        newCompositeNode(grammarAccess.getResultTableHeaderAccess().getNameResultNameParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_56);
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

            otherlv_2=(Token)match(input,60,FOLLOW_58); 

                	newLeafNode(otherlv_2, grammarAccess.getResultTableHeaderAccess().getEqualsSignKeyword_2());
                
            // InternalDSL.g:3093:1: (otherlv_3= '|' )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==62) ) {
                int LA54_1 = input.LA(2);

                if ( (LA54_1==EOF||LA54_1==62) ) {
                    alt54=1;
                }
            }
            switch (alt54) {
                case 1 :
                    // InternalDSL.g:3093:3: otherlv_3= '|'
                    {
                    otherlv_3=(Token)match(input,62,FOLLOW_2); 

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
    // InternalDSL.g:3105:1: entryRuleParameterTableValue returns [EObject current=null] : iv_ruleParameterTableValue= ruleParameterTableValue EOF ;
    public final EObject entryRuleParameterTableValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterTableValue = null;


        try {
            // InternalDSL.g:3106:2: (iv_ruleParameterTableValue= ruleParameterTableValue EOF )
            // InternalDSL.g:3107:2: iv_ruleParameterTableValue= ruleParameterTableValue EOF
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
    // InternalDSL.g:3114:1: ruleParameterTableValue returns [EObject current=null] : (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) ) (otherlv_2= '|' )? ) ;
    public final EObject ruleParameterTableValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_value_1_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:3117:28: ( (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) ) (otherlv_2= '|' )? ) )
            // InternalDSL.g:3118:1: (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) ) (otherlv_2= '|' )? )
            {
            // InternalDSL.g:3118:1: (otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) ) (otherlv_2= '|' )? )
            // InternalDSL.g:3118:3: otherlv_0= '|' ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) ) (otherlv_2= '|' )?
            {
            otherlv_0=(Token)match(input,62,FOLLOW_19); 

                	newLeafNode(otherlv_0, grammarAccess.getParameterTableValueAccess().getVerticalLineKeyword_0());
                
            // InternalDSL.g:3122:1: ( (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection ) )
            // InternalDSL.g:3123:1: (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // InternalDSL.g:3123:1: (lv_value_1_0= ruleValueOrEnumValueOrOperationCollection )
            // InternalDSL.g:3124:3: lv_value_1_0= ruleValueOrEnumValueOrOperationCollection
            {
             
            	        newCompositeNode(grammarAccess.getParameterTableValueAccess().getValueValueOrEnumValueOrOperationCollectionParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_58);
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

            // InternalDSL.g:3140:2: (otherlv_2= '|' )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==62) ) {
                int LA55_1 = input.LA(2);

                if ( (LA55_1==EOF||LA55_1==RULE_NEWLINE||LA55_1==62) ) {
                    alt55=1;
                }
            }
            switch (alt55) {
                case 1 :
                    // InternalDSL.g:3140:4: otherlv_2= '|'
                    {
                    otherlv_2=(Token)match(input,62,FOLLOW_2); 

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
    // InternalDSL.g:3152:1: entryRuleNamedResult returns [EObject current=null] : iv_ruleNamedResult= ruleNamedResult EOF ;
    public final EObject entryRuleNamedResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedResult = null;


        try {
            // InternalDSL.g:3153:2: (iv_ruleNamedResult= ruleNamedResult EOF )
            // InternalDSL.g:3154:2: iv_ruleNamedResult= ruleNamedResult EOF
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
    // InternalDSL.g:3161:1: ruleNamedResult returns [EObject current=null] : ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '=' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) ;
    public final EObject ruleNamedResult() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:3164:28: ( ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '=' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) )
            // InternalDSL.g:3165:1: ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '=' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            {
            // InternalDSL.g:3165:1: ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '=' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            // InternalDSL.g:3165:2: ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '=' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            {
            // InternalDSL.g:3165:2: ( (lv_name_0_0= ruleResultName ) )
            // InternalDSL.g:3166:1: (lv_name_0_0= ruleResultName )
            {
            // InternalDSL.g:3166:1: (lv_name_0_0= ruleResultName )
            // InternalDSL.g:3167:3: lv_name_0_0= ruleResultName
            {
             
            	        newCompositeNode(grammarAccess.getNamedResultAccess().getNameResultNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_59);
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
                
            pushFollow(FOLLOW_56);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,60,FOLLOW_19); 

                	newLeafNode(otherlv_2, grammarAccess.getNamedResultAccess().getEqualsSignKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getNamedResultAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_19);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:3203:1: ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            // InternalDSL.g:3204:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // InternalDSL.g:3204:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            // InternalDSL.g:3205:3: lv_value_4_0= ruleValueOrEnumValueOrOperationCollection
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
    // InternalDSL.g:3229:1: entryRuleResultName returns [EObject current=null] : iv_ruleResultName= ruleResultName EOF ;
    public final EObject entryRuleResultName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResultName = null;


        try {
            // InternalDSL.g:3230:2: (iv_ruleResultName= ruleResultName EOF )
            // InternalDSL.g:3231:2: iv_ruleResultName= ruleResultName EOF
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
    // InternalDSL.g:3238:1: ruleResultName returns [EObject current=null] : (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) ;
    public final EObject ruleResultName() throws RecognitionException {
        EObject current = null;

        EObject this_FixedResultName_0 = null;

        EObject this_ArbitraryParameterOrResultName_1 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:3241:28: ( (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) )
            // InternalDSL.g:3242:1: (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            {
            // InternalDSL.g:3242:1: (this_FixedResultName_0= ruleFixedResultName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==RULE_ID) ) {
                alt56=1;
            }
            else if ( (LA56_0==72) ) {
                alt56=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // InternalDSL.g:3243:5: this_FixedResultName_0= ruleFixedResultName
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
                    // InternalDSL.g:3253:5: this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName
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
    // InternalDSL.g:3269:1: entryRuleFixedResultName returns [EObject current=null] : iv_ruleFixedResultName= ruleFixedResultName EOF ;
    public final EObject entryRuleFixedResultName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedResultName = null;


        try {
            // InternalDSL.g:3270:2: (iv_ruleFixedResultName= ruleFixedResultName EOF )
            // InternalDSL.g:3271:2: iv_ruleFixedResultName= ruleFixedResultName EOF
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
    // InternalDSL.g:3278:1: ruleFixedResultName returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleFixedResultName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:3281:28: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalDSL.g:3282:1: ( (otherlv_0= RULE_ID ) )
            {
            // InternalDSL.g:3282:1: ( (otherlv_0= RULE_ID ) )
            // InternalDSL.g:3283:1: (otherlv_0= RULE_ID )
            {
            // InternalDSL.g:3283:1: (otherlv_0= RULE_ID )
            // InternalDSL.g:3284:3: otherlv_0= RULE_ID
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
    // InternalDSL.g:3303:1: entryRuleCall returns [EObject current=null] : iv_ruleCall= ruleCall EOF ;
    public final EObject entryRuleCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCall = null;


        try {
            // InternalDSL.g:3304:2: (iv_ruleCall= ruleCall EOF )
            // InternalDSL.g:3305:2: iv_ruleCall= ruleCall EOF
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
    // InternalDSL.g:3312:1: ruleCall returns [EObject current=null] : (otherlv_0= 'call' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )* ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )? ruleNL ) ;
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
            // InternalDSL.g:3315:28: ( (otherlv_0= 'call' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )* ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )? ruleNL ) )
            // InternalDSL.g:3316:1: (otherlv_0= 'call' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )* ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )? ruleNL )
            {
            // InternalDSL.g:3316:1: (otherlv_0= 'call' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )* ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )? ruleNL )
            // InternalDSL.g:3316:3: otherlv_0= 'call' ruleNL ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )* ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )* ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )? ruleNL
            {
            otherlv_0=(Token)match(input,63,FOLLOW_60); 

                	newLeafNode(otherlv_0, grammarAccess.getCallAccess().getCallKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_60);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:3328:1: ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )?
            int alt57=2;
            alt57 = dfa57.predict(input);
            switch (alt57) {
                case 1 :
                    // InternalDSL.g:3328:2: ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL
                    {
                    // InternalDSL.g:3328:2: ( (lv_multiplier_2_0= ruleExecutionMultiplier ) )
                    // InternalDSL.g:3329:1: (lv_multiplier_2_0= ruleExecutionMultiplier )
                    {
                    // InternalDSL.g:3329:1: (lv_multiplier_2_0= ruleExecutionMultiplier )
                    // InternalDSL.g:3330:3: lv_multiplier_2_0= ruleExecutionMultiplier
                    {
                     
                    	        newCompositeNode(grammarAccess.getCallAccess().getMultiplierExecutionMultiplierParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_6);
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
                        
                    pushFollow(FOLLOW_6);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // InternalDSL.g:3354:3: ( ( ruleQualifiedName ) )
            // InternalDSL.g:3355:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:3355:1: ( ruleQualifiedName )
            // InternalDSL.g:3356:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCallRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getCallAccess().getDefinitionCallDefinitionCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_61);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalDSL.g:3369:2: ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )*
            loop58:
            do {
                int alt58=2;
                alt58 = dfa58.predict(input);
                switch (alt58) {
            	case 1 :
            	    // InternalDSL.g:3370:5: ruleNL ( (lv_parameters_6_0= ruleParameter ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_4_0()); 
            	        
            	    pushFollow(FOLLOW_55);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // InternalDSL.g:3377:1: ( (lv_parameters_6_0= ruleParameter ) )
            	    // InternalDSL.g:3378:1: (lv_parameters_6_0= ruleParameter )
            	    {
            	    // InternalDSL.g:3378:1: (lv_parameters_6_0= ruleParameter )
            	    // InternalDSL.g:3379:3: lv_parameters_6_0= ruleParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCallAccess().getParametersParameterParserRuleCall_4_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_61);
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
            	    break loop58;
                }
            } while (true);

            // InternalDSL.g:3395:4: ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )*
            loop59:
            do {
                int alt59=2;
                alt59 = dfa59.predict(input);
                switch (alt59) {
            	case 1 :
            	    // InternalDSL.g:3396:5: ruleNL ( (lv_results_8_0= ruleNamedCallResult ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_5_0()); 
            	        
            	    pushFollow(FOLLOW_55);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // InternalDSL.g:3403:1: ( (lv_results_8_0= ruleNamedCallResult ) )
            	    // InternalDSL.g:3404:1: (lv_results_8_0= ruleNamedCallResult )
            	    {
            	    // InternalDSL.g:3404:1: (lv_results_8_0= ruleNamedCallResult )
            	    // InternalDSL.g:3405:3: lv_results_8_0= ruleNamedCallResult
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCallAccess().getResultsNamedCallResultParserRuleCall_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_61);
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
            	    break loop59;
                }
            } while (true);

            // InternalDSL.g:3421:4: ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )?
            int alt60=2;
            alt60 = dfa60.predict(input);
            switch (alt60) {
                case 1 :
                    // InternalDSL.g:3422:5: ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) )
                    {
                     
                            newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_6_0()); 
                        
                    pushFollow(FOLLOW_51);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    otherlv_10=(Token)match(input,56,FOLLOW_6); 

                        	newLeafNode(otherlv_10, grammarAccess.getCallAccess().getHyphenMinusGreaterThanSignKeyword_6_1());
                        
                     
                            newCompositeNode(grammarAccess.getCallAccess().getNLParserRuleCall_6_2()); 
                        
                    pushFollow(FOLLOW_6);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalDSL.g:3441:1: ( (lv_result_12_0= ruleVariableVariable ) )
                    // InternalDSL.g:3442:1: (lv_result_12_0= ruleVariableVariable )
                    {
                    // InternalDSL.g:3442:1: (lv_result_12_0= ruleVariableVariable )
                    // InternalDSL.g:3443:3: lv_result_12_0= ruleVariableVariable
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
    // InternalDSL.g:3475:1: entryRuleNamedCallResult returns [EObject current=null] : iv_ruleNamedCallResult= ruleNamedCallResult EOF ;
    public final EObject entryRuleNamedCallResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNamedCallResult = null;


        try {
            // InternalDSL.g:3476:2: (iv_ruleNamedCallResult= ruleNamedCallResult EOF )
            // InternalDSL.g:3477:2: iv_ruleNamedCallResult= ruleNamedCallResult EOF
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
    // InternalDSL.g:3484:1: ruleNamedCallResult returns [EObject current=null] : ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) ) ;
    public final EObject ruleNamedCallResult() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_target_4_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:3487:28: ( ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) ) )
            // InternalDSL.g:3488:1: ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) )
            {
            // InternalDSL.g:3488:1: ( ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) )
            // InternalDSL.g:3488:2: ( (lv_name_0_0= ruleResultName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) )
            {
            // InternalDSL.g:3488:2: ( (lv_name_0_0= ruleResultName ) )
            // InternalDSL.g:3489:1: (lv_name_0_0= ruleResultName )
            {
            // InternalDSL.g:3489:1: (lv_name_0_0= ruleResultName )
            // InternalDSL.g:3490:3: lv_name_0_0= ruleResultName
            {
             
            	        newCompositeNode(grammarAccess.getNamedCallResultAccess().getNameResultNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_50);
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
                
            pushFollow(FOLLOW_51);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,56,FOLLOW_6); 

                	newLeafNode(otherlv_2, grammarAccess.getNamedCallResultAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getNamedCallResultAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_6);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:3526:1: ( (lv_target_4_0= ruleVariableVariable ) )
            // InternalDSL.g:3527:1: (lv_target_4_0= ruleVariableVariable )
            {
            // InternalDSL.g:3527:1: (lv_target_4_0= ruleVariableVariable )
            // InternalDSL.g:3528:3: lv_target_4_0= ruleVariableVariable
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


    // $ANTLR start "entryRuleTimeSet"
    // InternalDSL.g:3552:1: entryRuleTimeSet returns [EObject current=null] : iv_ruleTimeSet= ruleTimeSet EOF ;
    public final EObject entryRuleTimeSet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeSet = null;


        try {
            // InternalDSL.g:3553:2: (iv_ruleTimeSet= ruleTimeSet EOF )
            // InternalDSL.g:3554:2: iv_ruleTimeSet= ruleTimeSet EOF
            {
             newCompositeNode(grammarAccess.getTimeSetRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeSet=ruleTimeSet();

            state._fsp--;

             current =iv_ruleTimeSet; 
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
    // $ANTLR end "entryRuleTimeSet"


    // $ANTLR start "ruleTimeSet"
    // InternalDSL.g:3561:1: ruleTimeSet returns [EObject current=null] : (otherlv_0= 'timeset' ruleNL ( ( ( (lv_live_2_0= 'live' ) ) ruleNL ) | ( ( (lv_startTime_4_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( (lv_progressionMode_6_0= 'progressing' ) ) ruleNL ( (lv_progressionFactor_8_0= ruleValueOrEnumValueOrOperation ) )? otherlv_9= 'x' ruleNL )? ) ) (otherlv_11= 'on' ruleNL ( ( ( ( ruleQualifiedName ) ) | ( (lv_masterFork_14_0= 'master' ) ) ) (otherlv_15= ',' )? ruleNL )+ )? ) ;
    public final EObject ruleTimeSet() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_live_2_0=null;
        Token lv_progressionMode_6_0=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token lv_masterFork_14_0=null;
        Token otherlv_15=null;
        EObject lv_startTime_4_0 = null;

        EObject lv_progressionFactor_8_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:3564:28: ( (otherlv_0= 'timeset' ruleNL ( ( ( (lv_live_2_0= 'live' ) ) ruleNL ) | ( ( (lv_startTime_4_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( (lv_progressionMode_6_0= 'progressing' ) ) ruleNL ( (lv_progressionFactor_8_0= ruleValueOrEnumValueOrOperation ) )? otherlv_9= 'x' ruleNL )? ) ) (otherlv_11= 'on' ruleNL ( ( ( ( ruleQualifiedName ) ) | ( (lv_masterFork_14_0= 'master' ) ) ) (otherlv_15= ',' )? ruleNL )+ )? ) )
            // InternalDSL.g:3565:1: (otherlv_0= 'timeset' ruleNL ( ( ( (lv_live_2_0= 'live' ) ) ruleNL ) | ( ( (lv_startTime_4_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( (lv_progressionMode_6_0= 'progressing' ) ) ruleNL ( (lv_progressionFactor_8_0= ruleValueOrEnumValueOrOperation ) )? otherlv_9= 'x' ruleNL )? ) ) (otherlv_11= 'on' ruleNL ( ( ( ( ruleQualifiedName ) ) | ( (lv_masterFork_14_0= 'master' ) ) ) (otherlv_15= ',' )? ruleNL )+ )? )
            {
            // InternalDSL.g:3565:1: (otherlv_0= 'timeset' ruleNL ( ( ( (lv_live_2_0= 'live' ) ) ruleNL ) | ( ( (lv_startTime_4_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( (lv_progressionMode_6_0= 'progressing' ) ) ruleNL ( (lv_progressionFactor_8_0= ruleValueOrEnumValueOrOperation ) )? otherlv_9= 'x' ruleNL )? ) ) (otherlv_11= 'on' ruleNL ( ( ( ( ruleQualifiedName ) ) | ( (lv_masterFork_14_0= 'master' ) ) ) (otherlv_15= ',' )? ruleNL )+ )? )
            // InternalDSL.g:3565:3: otherlv_0= 'timeset' ruleNL ( ( ( (lv_live_2_0= 'live' ) ) ruleNL ) | ( ( (lv_startTime_4_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( (lv_progressionMode_6_0= 'progressing' ) ) ruleNL ( (lv_progressionFactor_8_0= ruleValueOrEnumValueOrOperation ) )? otherlv_9= 'x' ruleNL )? ) ) (otherlv_11= 'on' ruleNL ( ( ( ( ruleQualifiedName ) ) | ( (lv_masterFork_14_0= 'master' ) ) ) (otherlv_15= ',' )? ruleNL )+ )?
            {
            otherlv_0=(Token)match(input,64,FOLLOW_62); 

                	newLeafNode(otherlv_0, grammarAccess.getTimeSetAccess().getTimesetKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getTimeSetAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_62);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:3577:1: ( ( ( (lv_live_2_0= 'live' ) ) ruleNL ) | ( ( (lv_startTime_4_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( (lv_progressionMode_6_0= 'progressing' ) ) ruleNL ( (lv_progressionFactor_8_0= ruleValueOrEnumValueOrOperation ) )? otherlv_9= 'x' ruleNL )? ) )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==65) ) {
                alt63=1;
            }
            else if ( ((LA63_0>=RULE_STRING && LA63_0<=RULE_UPPERCASE_ID)||LA63_0==73||LA63_0==80||LA63_0==82||(LA63_0>=85 && LA63_0<=86)) ) {
                alt63=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // InternalDSL.g:3577:2: ( ( (lv_live_2_0= 'live' ) ) ruleNL )
                    {
                    // InternalDSL.g:3577:2: ( ( (lv_live_2_0= 'live' ) ) ruleNL )
                    // InternalDSL.g:3577:3: ( (lv_live_2_0= 'live' ) ) ruleNL
                    {
                    // InternalDSL.g:3577:3: ( (lv_live_2_0= 'live' ) )
                    // InternalDSL.g:3578:1: (lv_live_2_0= 'live' )
                    {
                    // InternalDSL.g:3578:1: (lv_live_2_0= 'live' )
                    // InternalDSL.g:3579:3: lv_live_2_0= 'live'
                    {
                    lv_live_2_0=(Token)match(input,65,FOLLOW_63); 

                            newLeafNode(lv_live_2_0, grammarAccess.getTimeSetAccess().getLiveLiveKeyword_2_0_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getTimeSetRule());
                    	        }
                           		setWithLastConsumed(current, "live", lv_live_2_0, "live");
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getTimeSetAccess().getNLParserRuleCall_2_0_1()); 
                        
                    pushFollow(FOLLOW_64);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }


                    }
                    break;
                case 2 :
                    // InternalDSL.g:3601:6: ( ( (lv_startTime_4_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( (lv_progressionMode_6_0= 'progressing' ) ) ruleNL ( (lv_progressionFactor_8_0= ruleValueOrEnumValueOrOperation ) )? otherlv_9= 'x' ruleNL )? )
                    {
                    // InternalDSL.g:3601:6: ( ( (lv_startTime_4_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( (lv_progressionMode_6_0= 'progressing' ) ) ruleNL ( (lv_progressionFactor_8_0= ruleValueOrEnumValueOrOperation ) )? otherlv_9= 'x' ruleNL )? )
                    // InternalDSL.g:3601:7: ( (lv_startTime_4_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( (lv_progressionMode_6_0= 'progressing' ) ) ruleNL ( (lv_progressionFactor_8_0= ruleValueOrEnumValueOrOperation ) )? otherlv_9= 'x' ruleNL )?
                    {
                    // InternalDSL.g:3601:7: ( (lv_startTime_4_0= ruleValueOrEnumValueOrOperation ) )
                    // InternalDSL.g:3602:1: (lv_startTime_4_0= ruleValueOrEnumValueOrOperation )
                    {
                    // InternalDSL.g:3602:1: (lv_startTime_4_0= ruleValueOrEnumValueOrOperation )
                    // InternalDSL.g:3603:3: lv_startTime_4_0= ruleValueOrEnumValueOrOperation
                    {
                     
                    	        newCompositeNode(grammarAccess.getTimeSetAccess().getStartTimeValueOrEnumValueOrOperationParserRuleCall_2_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_65);
                    lv_startTime_4_0=ruleValueOrEnumValueOrOperation();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTimeSetRule());
                    	        }
                           		set(
                           			current, 
                           			"startTime",
                            		lv_startTime_4_0, 
                            		"de.gebit.integrity.DSL.ValueOrEnumValueOrOperation");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getTimeSetAccess().getNLParserRuleCall_2_1_1()); 
                        
                    pushFollow(FOLLOW_66);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalDSL.g:3627:1: ( ( (lv_progressionMode_6_0= 'progressing' ) ) ruleNL ( (lv_progressionFactor_8_0= ruleValueOrEnumValueOrOperation ) )? otherlv_9= 'x' ruleNL )?
                    int alt62=2;
                    int LA62_0 = input.LA(1);

                    if ( (LA62_0==66) ) {
                        alt62=1;
                    }
                    switch (alt62) {
                        case 1 :
                            // InternalDSL.g:3627:2: ( (lv_progressionMode_6_0= 'progressing' ) ) ruleNL ( (lv_progressionFactor_8_0= ruleValueOrEnumValueOrOperation ) )? otherlv_9= 'x' ruleNL
                            {
                            // InternalDSL.g:3627:2: ( (lv_progressionMode_6_0= 'progressing' ) )
                            // InternalDSL.g:3628:1: (lv_progressionMode_6_0= 'progressing' )
                            {
                            // InternalDSL.g:3628:1: (lv_progressionMode_6_0= 'progressing' )
                            // InternalDSL.g:3629:3: lv_progressionMode_6_0= 'progressing'
                            {
                            lv_progressionMode_6_0=(Token)match(input,66,FOLLOW_67); 

                                    newLeafNode(lv_progressionMode_6_0, grammarAccess.getTimeSetAccess().getProgressionModeProgressingKeyword_2_1_2_0_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getTimeSetRule());
                            	        }
                                   		setWithLastConsumed(current, "progressionMode", lv_progressionMode_6_0, "progressing");
                            	    

                            }


                            }

                             
                                    newCompositeNode(grammarAccess.getTimeSetAccess().getNLParserRuleCall_2_1_2_1()); 
                                
                            pushFollow(FOLLOW_67);
                            ruleNL();

                            state._fsp--;

                             
                                    afterParserOrEnumRuleCall();
                                
                            // InternalDSL.g:3650:1: ( (lv_progressionFactor_8_0= ruleValueOrEnumValueOrOperation ) )?
                            int alt61=2;
                            int LA61_0 = input.LA(1);

                            if ( ((LA61_0>=RULE_STRING && LA61_0<=RULE_UPPERCASE_ID)||LA61_0==73||LA61_0==80||LA61_0==82||(LA61_0>=85 && LA61_0<=86)) ) {
                                alt61=1;
                            }
                            switch (alt61) {
                                case 1 :
                                    // InternalDSL.g:3651:1: (lv_progressionFactor_8_0= ruleValueOrEnumValueOrOperation )
                                    {
                                    // InternalDSL.g:3651:1: (lv_progressionFactor_8_0= ruleValueOrEnumValueOrOperation )
                                    // InternalDSL.g:3652:3: lv_progressionFactor_8_0= ruleValueOrEnumValueOrOperation
                                    {
                                     
                                    	        newCompositeNode(grammarAccess.getTimeSetAccess().getProgressionFactorValueOrEnumValueOrOperationParserRuleCall_2_1_2_2_0()); 
                                    	    
                                    pushFollow(FOLLOW_68);
                                    lv_progressionFactor_8_0=ruleValueOrEnumValueOrOperation();

                                    state._fsp--;


                                    	        if (current==null) {
                                    	            current = createModelElementForParent(grammarAccess.getTimeSetRule());
                                    	        }
                                           		set(
                                           			current, 
                                           			"progressionFactor",
                                            		lv_progressionFactor_8_0, 
                                            		"de.gebit.integrity.DSL.ValueOrEnumValueOrOperation");
                                    	        afterParserOrEnumRuleCall();
                                    	    

                                    }


                                    }
                                    break;

                            }

                            otherlv_9=(Token)match(input,67,FOLLOW_63); 

                                	newLeafNode(otherlv_9, grammarAccess.getTimeSetAccess().getXKeyword_2_1_2_3());
                                
                             
                                    newCompositeNode(grammarAccess.getTimeSetAccess().getNLParserRuleCall_2_1_2_4()); 
                                
                            pushFollow(FOLLOW_64);
                            ruleNL();

                            state._fsp--;

                             
                                    afterParserOrEnumRuleCall();
                                

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // InternalDSL.g:3680:5: (otherlv_11= 'on' ruleNL ( ( ( ( ruleQualifiedName ) ) | ( (lv_masterFork_14_0= 'master' ) ) ) (otherlv_15= ',' )? ruleNL )+ )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==68) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalDSL.g:3680:7: otherlv_11= 'on' ruleNL ( ( ( ( ruleQualifiedName ) ) | ( (lv_masterFork_14_0= 'master' ) ) ) (otherlv_15= ',' )? ruleNL )+
                    {
                    otherlv_11=(Token)match(input,68,FOLLOW_69); 

                        	newLeafNode(otherlv_11, grammarAccess.getTimeSetAccess().getOnKeyword_3_0());
                        
                     
                            newCompositeNode(grammarAccess.getTimeSetAccess().getNLParserRuleCall_3_1()); 
                        
                    pushFollow(FOLLOW_69);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalDSL.g:3692:1: ( ( ( ( ruleQualifiedName ) ) | ( (lv_masterFork_14_0= 'master' ) ) ) (otherlv_15= ',' )? ruleNL )+
                    int cnt66=0;
                    loop66:
                    do {
                        int alt66=2;
                        int LA66_0 = input.LA(1);

                        if ( (LA66_0==RULE_ID||LA66_0==69) ) {
                            alt66=1;
                        }


                        switch (alt66) {
                    	case 1 :
                    	    // InternalDSL.g:3692:2: ( ( ( ruleQualifiedName ) ) | ( (lv_masterFork_14_0= 'master' ) ) ) (otherlv_15= ',' )? ruleNL
                    	    {
                    	    // InternalDSL.g:3692:2: ( ( ( ruleQualifiedName ) ) | ( (lv_masterFork_14_0= 'master' ) ) )
                    	    int alt64=2;
                    	    int LA64_0 = input.LA(1);

                    	    if ( (LA64_0==RULE_ID) ) {
                    	        alt64=1;
                    	    }
                    	    else if ( (LA64_0==69) ) {
                    	        alt64=2;
                    	    }
                    	    else {
                    	        NoViableAltException nvae =
                    	            new NoViableAltException("", 64, 0, input);

                    	        throw nvae;
                    	    }
                    	    switch (alt64) {
                    	        case 1 :
                    	            // InternalDSL.g:3692:3: ( ( ruleQualifiedName ) )
                    	            {
                    	            // InternalDSL.g:3692:3: ( ( ruleQualifiedName ) )
                    	            // InternalDSL.g:3693:1: ( ruleQualifiedName )
                    	            {
                    	            // InternalDSL.g:3693:1: ( ruleQualifiedName )
                    	            // InternalDSL.g:3694:3: ruleQualifiedName
                    	            {

                    	            			if (current==null) {
                    	            	            current = createModelElement(grammarAccess.getTimeSetRule());
                    	            	        }
                    	                    
                    	             
                    	            	        newCompositeNode(grammarAccess.getTimeSetAccess().getForksForkDefinitionCrossReference_3_2_0_0_0()); 
                    	            	    
                    	            pushFollow(FOLLOW_70);
                    	            ruleQualifiedName();

                    	            state._fsp--;

                    	             
                    	            	        afterParserOrEnumRuleCall();
                    	            	    

                    	            }


                    	            }


                    	            }
                    	            break;
                    	        case 2 :
                    	            // InternalDSL.g:3708:6: ( (lv_masterFork_14_0= 'master' ) )
                    	            {
                    	            // InternalDSL.g:3708:6: ( (lv_masterFork_14_0= 'master' ) )
                    	            // InternalDSL.g:3709:1: (lv_masterFork_14_0= 'master' )
                    	            {
                    	            // InternalDSL.g:3709:1: (lv_masterFork_14_0= 'master' )
                    	            // InternalDSL.g:3710:3: lv_masterFork_14_0= 'master'
                    	            {
                    	            lv_masterFork_14_0=(Token)match(input,69,FOLLOW_70); 

                    	                    newLeafNode(lv_masterFork_14_0, grammarAccess.getTimeSetAccess().getMasterForkMasterKeyword_3_2_0_1_0());
                    	                

                    	            	        if (current==null) {
                    	            	            current = createModelElement(grammarAccess.getTimeSetRule());
                    	            	        }
                    	                   		setWithLastConsumed(current, "masterFork", lv_masterFork_14_0, "master");
                    	            	    

                    	            }


                    	            }


                    	            }
                    	            break;

                    	    }

                    	    // InternalDSL.g:3723:3: (otherlv_15= ',' )?
                    	    int alt65=2;
                    	    int LA65_0 = input.LA(1);

                    	    if ( (LA65_0==70) ) {
                    	        alt65=1;
                    	    }
                    	    switch (alt65) {
                    	        case 1 :
                    	            // InternalDSL.g:3723:5: otherlv_15= ','
                    	            {
                    	            otherlv_15=(Token)match(input,70,FOLLOW_69); 

                    	                	newLeafNode(otherlv_15, grammarAccess.getTimeSetAccess().getCommaKeyword_3_2_1());
                    	                

                    	            }
                    	            break;

                    	    }

                    	     
                    	            newCompositeNode(grammarAccess.getTimeSetAccess().getNLParserRuleCall_3_2_2()); 
                    	        
                    	    pushFollow(FOLLOW_71);
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
    // $ANTLR end "ruleTimeSet"


    // $ANTLR start "entryRuleSuite"
    // InternalDSL.g:3743:1: entryRuleSuite returns [EObject current=null] : iv_ruleSuite= ruleSuite EOF ;
    public final EObject entryRuleSuite() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuite = null;


        try {
            // InternalDSL.g:3744:2: (iv_ruleSuite= ruleSuite EOF )
            // InternalDSL.g:3745:2: iv_ruleSuite= ruleSuite EOF
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
    // InternalDSL.g:3752:1: ruleSuite returns [EObject current=null] : ( ( (lv_inlined_0_0= 'inlined' ) )? otherlv_1= 'suite' ruleNL ( ( (lv_multiplier_3_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ruleNL ( ( (lv_parameters_7_0= ruleSuiteParameter ) ) ruleNL )* ( ( (lv_return_9_0= ruleSuiteReturn ) ) ruleNL )* (otherlv_11= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )? (otherlv_15= 'in' ruleNL ( ( ( ruleQualifiedName ) ) (otherlv_18= ',' )? ruleNL )+ )? ) ;
    public final EObject ruleSuite() throws RecognitionException {
        EObject current = null;

        Token lv_inlined_0_0=null;
        Token otherlv_1=null;
        Token otherlv_11=null;
        Token otherlv_15=null;
        Token otherlv_18=null;
        EObject lv_multiplier_3_0 = null;

        EObject lv_parameters_7_0 = null;

        EObject lv_return_9_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:3755:28: ( ( ( (lv_inlined_0_0= 'inlined' ) )? otherlv_1= 'suite' ruleNL ( ( (lv_multiplier_3_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ruleNL ( ( (lv_parameters_7_0= ruleSuiteParameter ) ) ruleNL )* ( ( (lv_return_9_0= ruleSuiteReturn ) ) ruleNL )* (otherlv_11= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )? (otherlv_15= 'in' ruleNL ( ( ( ruleQualifiedName ) ) (otherlv_18= ',' )? ruleNL )+ )? ) )
            // InternalDSL.g:3756:1: ( ( (lv_inlined_0_0= 'inlined' ) )? otherlv_1= 'suite' ruleNL ( ( (lv_multiplier_3_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ruleNL ( ( (lv_parameters_7_0= ruleSuiteParameter ) ) ruleNL )* ( ( (lv_return_9_0= ruleSuiteReturn ) ) ruleNL )* (otherlv_11= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )? (otherlv_15= 'in' ruleNL ( ( ( ruleQualifiedName ) ) (otherlv_18= ',' )? ruleNL )+ )? )
            {
            // InternalDSL.g:3756:1: ( ( (lv_inlined_0_0= 'inlined' ) )? otherlv_1= 'suite' ruleNL ( ( (lv_multiplier_3_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ruleNL ( ( (lv_parameters_7_0= ruleSuiteParameter ) ) ruleNL )* ( ( (lv_return_9_0= ruleSuiteReturn ) ) ruleNL )* (otherlv_11= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )? (otherlv_15= 'in' ruleNL ( ( ( ruleQualifiedName ) ) (otherlv_18= ',' )? ruleNL )+ )? )
            // InternalDSL.g:3756:2: ( (lv_inlined_0_0= 'inlined' ) )? otherlv_1= 'suite' ruleNL ( ( (lv_multiplier_3_0= ruleExecutionMultiplier ) ) ruleNL )? ( ( ruleQualifiedName ) ) ruleNL ( ( (lv_parameters_7_0= ruleSuiteParameter ) ) ruleNL )* ( ( (lv_return_9_0= ruleSuiteReturn ) ) ruleNL )* (otherlv_11= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )? (otherlv_15= 'in' ruleNL ( ( ( ruleQualifiedName ) ) (otherlv_18= ',' )? ruleNL )+ )?
            {
            // InternalDSL.g:3756:2: ( (lv_inlined_0_0= 'inlined' ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==42) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalDSL.g:3757:1: (lv_inlined_0_0= 'inlined' )
                    {
                    // InternalDSL.g:3757:1: (lv_inlined_0_0= 'inlined' )
                    // InternalDSL.g:3758:3: lv_inlined_0_0= 'inlined'
                    {
                    lv_inlined_0_0=(Token)match(input,42,FOLLOW_72); 

                            newLeafNode(lv_inlined_0_0, grammarAccess.getSuiteAccess().getInlinedInlinedKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSuiteRule());
                    	        }
                           		setWithLastConsumed(current, "inlined", lv_inlined_0_0, "inlined");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,71,FOLLOW_60); 

                	newLeafNode(otherlv_1, grammarAccess.getSuiteAccess().getSuiteKeyword_1());
                
             
                    newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_2()); 
                
            pushFollow(FOLLOW_60);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:3783:1: ( ( (lv_multiplier_3_0= ruleExecutionMultiplier ) ) ruleNL )?
            int alt69=2;
            alt69 = dfa69.predict(input);
            switch (alt69) {
                case 1 :
                    // InternalDSL.g:3783:2: ( (lv_multiplier_3_0= ruleExecutionMultiplier ) ) ruleNL
                    {
                    // InternalDSL.g:3783:2: ( (lv_multiplier_3_0= ruleExecutionMultiplier ) )
                    // InternalDSL.g:3784:1: (lv_multiplier_3_0= ruleExecutionMultiplier )
                    {
                    // InternalDSL.g:3784:1: (lv_multiplier_3_0= ruleExecutionMultiplier )
                    // InternalDSL.g:3785:3: lv_multiplier_3_0= ruleExecutionMultiplier
                    {
                     
                    	        newCompositeNode(grammarAccess.getSuiteAccess().getMultiplierExecutionMultiplierParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_6);
                    lv_multiplier_3_0=ruleExecutionMultiplier();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSuiteRule());
                    	        }
                           		set(
                           			current, 
                           			"multiplier",
                            		lv_multiplier_3_0, 
                            		"de.gebit.integrity.DSL.ExecutionMultiplier");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_3_1()); 
                        
                    pushFollow(FOLLOW_6);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // InternalDSL.g:3809:3: ( ( ruleQualifiedName ) )
            // InternalDSL.g:3810:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:3810:1: ( ruleQualifiedName )
            // InternalDSL.g:3811:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSuiteRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSuiteAccess().getDefinitionSuiteDefinitionCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_73);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_5()); 
                
            pushFollow(FOLLOW_74);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:3832:1: ( ( (lv_parameters_7_0= ruleSuiteParameter ) ) ruleNL )*
            loop70:
            do {
                int alt70=2;
                alt70 = dfa70.predict(input);
                switch (alt70) {
            	case 1 :
            	    // InternalDSL.g:3832:2: ( (lv_parameters_7_0= ruleSuiteParameter ) ) ruleNL
            	    {
            	    // InternalDSL.g:3832:2: ( (lv_parameters_7_0= ruleSuiteParameter ) )
            	    // InternalDSL.g:3833:1: (lv_parameters_7_0= ruleSuiteParameter )
            	    {
            	    // InternalDSL.g:3833:1: (lv_parameters_7_0= ruleSuiteParameter )
            	    // InternalDSL.g:3834:3: lv_parameters_7_0= ruleSuiteParameter
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSuiteAccess().getParametersSuiteParameterParserRuleCall_6_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_73);
            	    lv_parameters_7_0=ruleSuiteParameter();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSuiteRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"parameters",
            	            		lv_parameters_7_0, 
            	            		"de.gebit.integrity.DSL.SuiteParameter");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	     
            	            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_6_1()); 
            	        
            	    pushFollow(FOLLOW_74);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop70;
                }
            } while (true);

            // InternalDSL.g:3858:3: ( ( (lv_return_9_0= ruleSuiteReturn ) ) ruleNL )*
            loop71:
            do {
                int alt71=2;
                int LA71_0 = input.LA(1);

                if ( (LA71_0==RULE_ID) ) {
                    alt71=1;
                }


                switch (alt71) {
            	case 1 :
            	    // InternalDSL.g:3858:4: ( (lv_return_9_0= ruleSuiteReturn ) ) ruleNL
            	    {
            	    // InternalDSL.g:3858:4: ( (lv_return_9_0= ruleSuiteReturn ) )
            	    // InternalDSL.g:3859:1: (lv_return_9_0= ruleSuiteReturn )
            	    {
            	    // InternalDSL.g:3859:1: (lv_return_9_0= ruleSuiteReturn )
            	    // InternalDSL.g:3860:3: lv_return_9_0= ruleSuiteReturn
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getSuiteAccess().getReturnSuiteReturnParserRuleCall_7_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_73);
            	    lv_return_9_0=ruleSuiteReturn();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getSuiteRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"return",
            	            		lv_return_9_0, 
            	            		"de.gebit.integrity.DSL.SuiteReturn");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	     
            	            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_7_1()); 
            	        
            	    pushFollow(FOLLOW_74);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop71;
                }
            } while (true);

            // InternalDSL.g:3884:3: (otherlv_11= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==68) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // InternalDSL.g:3884:5: otherlv_11= 'on' ruleNL ( ( ruleQualifiedName ) ) ruleNL
                    {
                    otherlv_11=(Token)match(input,68,FOLLOW_6); 

                        	newLeafNode(otherlv_11, grammarAccess.getSuiteAccess().getOnKeyword_8_0());
                        
                     
                            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_8_1()); 
                        
                    pushFollow(FOLLOW_6);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalDSL.g:3896:1: ( ( ruleQualifiedName ) )
                    // InternalDSL.g:3897:1: ( ruleQualifiedName )
                    {
                    // InternalDSL.g:3897:1: ( ruleQualifiedName )
                    // InternalDSL.g:3898:3: ruleQualifiedName
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getSuiteRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getSuiteAccess().getForkForkDefinitionCrossReference_8_2_0()); 
                    	    
                    pushFollow(FOLLOW_75);
                    ruleQualifiedName();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                     
                            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_8_3()); 
                        
                    pushFollow(FOLLOW_76);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // InternalDSL.g:3919:3: (otherlv_15= 'in' ruleNL ( ( ( ruleQualifiedName ) ) (otherlv_18= ',' )? ruleNL )+ )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==57) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalDSL.g:3919:5: otherlv_15= 'in' ruleNL ( ( ( ruleQualifiedName ) ) (otherlv_18= ',' )? ruleNL )+
                    {
                    otherlv_15=(Token)match(input,57,FOLLOW_6); 

                        	newLeafNode(otherlv_15, grammarAccess.getSuiteAccess().getInKeyword_9_0());
                        
                     
                            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_9_1()); 
                        
                    pushFollow(FOLLOW_6);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    // InternalDSL.g:3931:1: ( ( ( ruleQualifiedName ) ) (otherlv_18= ',' )? ruleNL )+
                    int cnt74=0;
                    loop74:
                    do {
                        int alt74=2;
                        int LA74_0 = input.LA(1);

                        if ( (LA74_0==RULE_ID) ) {
                            alt74=1;
                        }


                        switch (alt74) {
                    	case 1 :
                    	    // InternalDSL.g:3931:2: ( ( ruleQualifiedName ) ) (otherlv_18= ',' )? ruleNL
                    	    {
                    	    // InternalDSL.g:3931:2: ( ( ruleQualifiedName ) )
                    	    // InternalDSL.g:3932:1: ( ruleQualifiedName )
                    	    {
                    	    // InternalDSL.g:3932:1: ( ruleQualifiedName )
                    	    // InternalDSL.g:3933:3: ruleQualifiedName
                    	    {

                    	    			if (current==null) {
                    	    	            current = createModelElement(grammarAccess.getSuiteRule());
                    	    	        }
                    	            
                    	     
                    	    	        newCompositeNode(grammarAccess.getSuiteAccess().getVariantsVariantDefinitionCrossReference_9_2_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_77);
                    	    ruleQualifiedName();

                    	    state._fsp--;

                    	     
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	    // InternalDSL.g:3946:2: (otherlv_18= ',' )?
                    	    int alt73=2;
                    	    int LA73_0 = input.LA(1);

                    	    if ( (LA73_0==70) ) {
                    	        alt73=1;
                    	    }
                    	    switch (alt73) {
                    	        case 1 :
                    	            // InternalDSL.g:3946:4: otherlv_18= ','
                    	            {
                    	            otherlv_18=(Token)match(input,70,FOLLOW_6); 

                    	                	newLeafNode(otherlv_18, grammarAccess.getSuiteAccess().getCommaKeyword_9_2_1());
                    	                

                    	            }
                    	            break;

                    	    }

                    	     
                    	            newCompositeNode(grammarAccess.getSuiteAccess().getNLParserRuleCall_9_2_2()); 
                    	        
                    	    pushFollow(FOLLOW_78);
                    	    ruleNL();

                    	    state._fsp--;

                    	     
                    	            afterParserOrEnumRuleCall();
                    	        

                    	    }
                    	    break;

                    	default :
                    	    if ( cnt74 >= 1 ) break loop74;
                                EarlyExitException eee =
                                    new EarlyExitException(74, input);
                                throw eee;
                        }
                        cnt74++;
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
    // InternalDSL.g:3966:1: entryRuleSuiteParameter returns [EObject current=null] : iv_ruleSuiteParameter= ruleSuiteParameter EOF ;
    public final EObject entryRuleSuiteParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteParameter = null;


        try {
            // InternalDSL.g:3967:2: (iv_ruleSuiteParameter= ruleSuiteParameter EOF )
            // InternalDSL.g:3968:2: iv_ruleSuiteParameter= ruleSuiteParameter EOF
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
    // InternalDSL.g:3975:1: ruleSuiteParameter returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) ;
    public final EObject ruleSuiteParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:3978:28: ( ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) )
            // InternalDSL.g:3979:1: ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            {
            // InternalDSL.g:3979:1: ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            // InternalDSL.g:3979:2: ( ( ruleQualifiedName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            {
            // InternalDSL.g:3979:2: ( ( ruleQualifiedName ) )
            // InternalDSL.g:3980:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:3980:1: ( ruleQualifiedName )
            // InternalDSL.g:3981:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSuiteParameterRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSuiteParameterAccess().getNameVariableOrConstantEntityCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_17);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getSuiteParameterAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_18);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,37,FOLLOW_19); 

                	newLeafNode(otherlv_2, grammarAccess.getSuiteParameterAccess().getColonKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getSuiteParameterAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_19);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:4014:1: ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            // InternalDSL.g:4015:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // InternalDSL.g:4015:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            // InternalDSL.g:4016:3: lv_value_4_0= ruleValueOrEnumValueOrOperationCollection
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
    // InternalDSL.g:4040:1: entryRuleSuiteReturn returns [EObject current=null] : iv_ruleSuiteReturn= ruleSuiteReturn EOF ;
    public final EObject entryRuleSuiteReturn() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuiteReturn = null;


        try {
            // InternalDSL.g:4041:2: (iv_ruleSuiteReturn= ruleSuiteReturn EOF )
            // InternalDSL.g:4042:2: iv_ruleSuiteReturn= ruleSuiteReturn EOF
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
    // InternalDSL.g:4049:1: ruleSuiteReturn returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) ) ;
    public final EObject ruleSuiteReturn() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_target_4_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:4052:28: ( ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) ) )
            // InternalDSL.g:4053:1: ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) )
            {
            // InternalDSL.g:4053:1: ( ( ( ruleQualifiedName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) ) )
            // InternalDSL.g:4053:2: ( ( ruleQualifiedName ) ) ruleNL otherlv_2= '->' ruleNL ( (lv_target_4_0= ruleVariableVariable ) )
            {
            // InternalDSL.g:4053:2: ( ( ruleQualifiedName ) )
            // InternalDSL.g:4054:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:4054:1: ( ruleQualifiedName )
            // InternalDSL.g:4055:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getSuiteReturnRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getSuiteReturnAccess().getNameSuiteReturnDefinitionCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_50);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getSuiteReturnAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_51);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,56,FOLLOW_6); 

                	newLeafNode(otherlv_2, grammarAccess.getSuiteReturnAccess().getHyphenMinusGreaterThanSignKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getSuiteReturnAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_6);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:4088:1: ( (lv_target_4_0= ruleVariableVariable ) )
            // InternalDSL.g:4089:1: (lv_target_4_0= ruleVariableVariable )
            {
            // InternalDSL.g:4089:1: (lv_target_4_0= ruleVariableVariable )
            // InternalDSL.g:4090:3: lv_target_4_0= ruleVariableVariable
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
    // InternalDSL.g:4114:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalDSL.g:4115:2: (iv_ruleParameter= ruleParameter EOF )
            // InternalDSL.g:4116:2: iv_ruleParameter= ruleParameter EOF
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
    // InternalDSL.g:4123:1: ruleParameter returns [EObject current=null] : ( ( (lv_name_0_0= ruleParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_name_0_0 = null;

        EObject lv_value_4_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:4126:28: ( ( ( (lv_name_0_0= ruleParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) ) )
            // InternalDSL.g:4127:1: ( ( (lv_name_0_0= ruleParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            {
            // InternalDSL.g:4127:1: ( ( (lv_name_0_0= ruleParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            // InternalDSL.g:4127:2: ( (lv_name_0_0= ruleParameterName ) ) ruleNL otherlv_2= ':' ruleNL ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            {
            // InternalDSL.g:4127:2: ( (lv_name_0_0= ruleParameterName ) )
            // InternalDSL.g:4128:1: (lv_name_0_0= ruleParameterName )
            {
            // InternalDSL.g:4128:1: (lv_name_0_0= ruleParameterName )
            // InternalDSL.g:4129:3: lv_name_0_0= ruleParameterName
            {
             
            	        newCompositeNode(grammarAccess.getParameterAccess().getNameParameterNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_17);
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
                
            pushFollow(FOLLOW_18);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_2=(Token)match(input,37,FOLLOW_19); 

                	newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getColonKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getParameterAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_19);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:4165:1: ( (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection ) )
            // InternalDSL.g:4166:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // InternalDSL.g:4166:1: (lv_value_4_0= ruleValueOrEnumValueOrOperationCollection )
            // InternalDSL.g:4167:3: lv_value_4_0= ruleValueOrEnumValueOrOperationCollection
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
    // InternalDSL.g:4191:1: entryRuleParameterName returns [EObject current=null] : iv_ruleParameterName= ruleParameterName EOF ;
    public final EObject entryRuleParameterName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterName = null;


        try {
            // InternalDSL.g:4192:2: (iv_ruleParameterName= ruleParameterName EOF )
            // InternalDSL.g:4193:2: iv_ruleParameterName= ruleParameterName EOF
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
    // InternalDSL.g:4200:1: ruleParameterName returns [EObject current=null] : (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) ;
    public final EObject ruleParameterName() throws RecognitionException {
        EObject current = null;

        EObject this_FixedParameterName_0 = null;

        EObject this_ArbitraryParameterOrResultName_1 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:4203:28: ( (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName ) )
            // InternalDSL.g:4204:1: (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            {
            // InternalDSL.g:4204:1: (this_FixedParameterName_0= ruleFixedParameterName | this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_ID) ) {
                alt76=1;
            }
            else if ( (LA76_0==72) ) {
                alt76=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // InternalDSL.g:4205:5: this_FixedParameterName_0= ruleFixedParameterName
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
                    // InternalDSL.g:4215:5: this_ArbitraryParameterOrResultName_1= ruleArbitraryParameterOrResultName
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
    // InternalDSL.g:4231:1: entryRuleFixedParameterName returns [EObject current=null] : iv_ruleFixedParameterName= ruleFixedParameterName EOF ;
    public final EObject entryRuleFixedParameterName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFixedParameterName = null;


        try {
            // InternalDSL.g:4232:2: (iv_ruleFixedParameterName= ruleFixedParameterName EOF )
            // InternalDSL.g:4233:2: iv_ruleFixedParameterName= ruleFixedParameterName EOF
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
    // InternalDSL.g:4240:1: ruleFixedParameterName returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleFixedParameterName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:4243:28: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalDSL.g:4244:1: ( (otherlv_0= RULE_ID ) )
            {
            // InternalDSL.g:4244:1: ( (otherlv_0= RULE_ID ) )
            // InternalDSL.g:4245:1: (otherlv_0= RULE_ID )
            {
            // InternalDSL.g:4245:1: (otherlv_0= RULE_ID )
            // InternalDSL.g:4246:3: otherlv_0= RULE_ID
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
    // InternalDSL.g:4265:1: entryRuleArbitraryParameterOrResultName returns [EObject current=null] : iv_ruleArbitraryParameterOrResultName= ruleArbitraryParameterOrResultName EOF ;
    public final EObject entryRuleArbitraryParameterOrResultName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArbitraryParameterOrResultName = null;


        try {
            // InternalDSL.g:4266:2: (iv_ruleArbitraryParameterOrResultName= ruleArbitraryParameterOrResultName EOF )
            // InternalDSL.g:4267:2: iv_ruleArbitraryParameterOrResultName= ruleArbitraryParameterOrResultName EOF
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
    // InternalDSL.g:4274:1: ruleArbitraryParameterOrResultName returns [EObject current=null] : (otherlv_0= '+' ( ( (lv_identifier_1_0= RULE_ID ) ) | ( (lv_stringIdentifier_2_0= RULE_STRING ) ) ) ) ;
    public final EObject ruleArbitraryParameterOrResultName() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_identifier_1_0=null;
        Token lv_stringIdentifier_2_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:4277:28: ( (otherlv_0= '+' ( ( (lv_identifier_1_0= RULE_ID ) ) | ( (lv_stringIdentifier_2_0= RULE_STRING ) ) ) ) )
            // InternalDSL.g:4278:1: (otherlv_0= '+' ( ( (lv_identifier_1_0= RULE_ID ) ) | ( (lv_stringIdentifier_2_0= RULE_STRING ) ) ) )
            {
            // InternalDSL.g:4278:1: (otherlv_0= '+' ( ( (lv_identifier_1_0= RULE_ID ) ) | ( (lv_stringIdentifier_2_0= RULE_STRING ) ) ) )
            // InternalDSL.g:4278:3: otherlv_0= '+' ( ( (lv_identifier_1_0= RULE_ID ) ) | ( (lv_stringIdentifier_2_0= RULE_STRING ) ) )
            {
            otherlv_0=(Token)match(input,72,FOLLOW_79); 

                	newLeafNode(otherlv_0, grammarAccess.getArbitraryParameterOrResultNameAccess().getPlusSignKeyword_0());
                
            // InternalDSL.g:4282:1: ( ( (lv_identifier_1_0= RULE_ID ) ) | ( (lv_stringIdentifier_2_0= RULE_STRING ) ) )
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==RULE_ID) ) {
                alt77=1;
            }
            else if ( (LA77_0==RULE_STRING) ) {
                alt77=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }
            switch (alt77) {
                case 1 :
                    // InternalDSL.g:4282:2: ( (lv_identifier_1_0= RULE_ID ) )
                    {
                    // InternalDSL.g:4282:2: ( (lv_identifier_1_0= RULE_ID ) )
                    // InternalDSL.g:4283:1: (lv_identifier_1_0= RULE_ID )
                    {
                    // InternalDSL.g:4283:1: (lv_identifier_1_0= RULE_ID )
                    // InternalDSL.g:4284:3: lv_identifier_1_0= RULE_ID
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
                    // InternalDSL.g:4301:6: ( (lv_stringIdentifier_2_0= RULE_STRING ) )
                    {
                    // InternalDSL.g:4301:6: ( (lv_stringIdentifier_2_0= RULE_STRING ) )
                    // InternalDSL.g:4302:1: (lv_stringIdentifier_2_0= RULE_STRING )
                    {
                    // InternalDSL.g:4302:1: (lv_stringIdentifier_2_0= RULE_STRING )
                    // InternalDSL.g:4303:3: lv_stringIdentifier_2_0= RULE_STRING
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
    // InternalDSL.g:4327:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // InternalDSL.g:4328:2: (iv_ruleOperation= ruleOperation EOF )
            // InternalDSL.g:4329:2: iv_ruleOperation= ruleOperation EOF
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
    // InternalDSL.g:4336:1: ruleOperation returns [EObject current=null] : (this_StandardOperation_0= ruleStandardOperation | this_CustomOperation_1= ruleCustomOperation ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        EObject this_StandardOperation_0 = null;

        EObject this_CustomOperation_1 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:4339:28: ( (this_StandardOperation_0= ruleStandardOperation | this_CustomOperation_1= ruleCustomOperation ) )
            // InternalDSL.g:4340:1: (this_StandardOperation_0= ruleStandardOperation | this_CustomOperation_1= ruleCustomOperation )
            {
            // InternalDSL.g:4340:1: (this_StandardOperation_0= ruleStandardOperation | this_CustomOperation_1= ruleCustomOperation )
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==73) ) {
                alt78=1;
            }
            else if ( (LA78_0==80) ) {
                alt78=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }
            switch (alt78) {
                case 1 :
                    // InternalDSL.g:4341:5: this_StandardOperation_0= ruleStandardOperation
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
                    // InternalDSL.g:4351:5: this_CustomOperation_1= ruleCustomOperation
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
    // InternalDSL.g:4367:1: entryRuleStandardOperation returns [EObject current=null] : iv_ruleStandardOperation= ruleStandardOperation EOF ;
    public final EObject entryRuleStandardOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStandardOperation = null;


        try {
            // InternalDSL.g:4368:2: (iv_ruleStandardOperation= ruleStandardOperation EOF )
            // InternalDSL.g:4369:2: iv_ruleStandardOperation= ruleStandardOperation EOF
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
    // InternalDSL.g:4376:1: ruleStandardOperation returns [EObject current=null] : (otherlv_0= '(' ruleNL ( (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL )+ otherlv_8= ')' ) ;
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
            // InternalDSL.g:4379:28: ( (otherlv_0= '(' ruleNL ( (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL )+ otherlv_8= ')' ) )
            // InternalDSL.g:4380:1: (otherlv_0= '(' ruleNL ( (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL )+ otherlv_8= ')' )
            {
            // InternalDSL.g:4380:1: (otherlv_0= '(' ruleNL ( (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL )+ otherlv_8= ')' )
            // InternalDSL.g:4380:3: otherlv_0= '(' ruleNL ( (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation ) ) ruleNL ( ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL )+ otherlv_8= ')'
            {
            otherlv_0=(Token)match(input,73,FOLLOW_19); 

                	newLeafNode(otherlv_0, grammarAccess.getStandardOperationAccess().getLeftParenthesisKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getStandardOperationAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_19);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:4392:1: ( (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation ) )
            // InternalDSL.g:4393:1: (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation )
            {
            // InternalDSL.g:4393:1: (lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation )
            // InternalDSL.g:4394:3: lv_firstOperand_2_0= ruleValueOrEnumValueOrOperation
            {
             
            	        newCompositeNode(grammarAccess.getStandardOperationAccess().getFirstOperandValueOrEnumValueOrOperationParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_80);
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
                
            pushFollow(FOLLOW_81);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:4418:1: ( ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL )+
            int cnt80=0;
            loop80:
            do {
                int alt80=2;
                int LA80_0 = input.LA(1);

                if ( (LA80_0==72||(LA80_0>=74 && LA80_0<=78)) ) {
                    alt80=1;
                }


                switch (alt80) {
            	case 1 :
            	    // InternalDSL.g:4418:2: ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) ) ruleNL ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) ) ruleNL
            	    {
            	    // InternalDSL.g:4418:2: ( ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) ) )
            	    // InternalDSL.g:4419:1: ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) )
            	    {
            	    // InternalDSL.g:4419:1: ( (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' ) )
            	    // InternalDSL.g:4420:1: (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' )
            	    {
            	    // InternalDSL.g:4420:1: (lv_operators_4_1= '+' | lv_operators_4_2= '-' | lv_operators_4_3= '*' | lv_operators_4_4= '/' | lv_operators_4_5= '%' | lv_operators_4_6= '..' )
            	    int alt79=6;
            	    switch ( input.LA(1) ) {
            	    case 72:
            	        {
            	        alt79=1;
            	        }
            	        break;
            	    case 74:
            	        {
            	        alt79=2;
            	        }
            	        break;
            	    case 75:
            	        {
            	        alt79=3;
            	        }
            	        break;
            	    case 76:
            	        {
            	        alt79=4;
            	        }
            	        break;
            	    case 77:
            	        {
            	        alt79=5;
            	        }
            	        break;
            	    case 78:
            	        {
            	        alt79=6;
            	        }
            	        break;
            	    default:
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 79, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt79) {
            	        case 1 :
            	            // InternalDSL.g:4421:3: lv_operators_4_1= '+'
            	            {
            	            lv_operators_4_1=(Token)match(input,72,FOLLOW_19); 

            	                    newLeafNode(lv_operators_4_1, grammarAccess.getStandardOperationAccess().getOperatorsPlusSignKeyword_4_0_0_0());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getStandardOperationRule());
            	            	        }
            	                   		addWithLastConsumed(current, "operators", lv_operators_4_1, null);
            	            	    

            	            }
            	            break;
            	        case 2 :
            	            // InternalDSL.g:4433:8: lv_operators_4_2= '-'
            	            {
            	            lv_operators_4_2=(Token)match(input,74,FOLLOW_19); 

            	                    newLeafNode(lv_operators_4_2, grammarAccess.getStandardOperationAccess().getOperatorsHyphenMinusKeyword_4_0_0_1());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getStandardOperationRule());
            	            	        }
            	                   		addWithLastConsumed(current, "operators", lv_operators_4_2, null);
            	            	    

            	            }
            	            break;
            	        case 3 :
            	            // InternalDSL.g:4445:8: lv_operators_4_3= '*'
            	            {
            	            lv_operators_4_3=(Token)match(input,75,FOLLOW_19); 

            	                    newLeafNode(lv_operators_4_3, grammarAccess.getStandardOperationAccess().getOperatorsAsteriskKeyword_4_0_0_2());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getStandardOperationRule());
            	            	        }
            	                   		addWithLastConsumed(current, "operators", lv_operators_4_3, null);
            	            	    

            	            }
            	            break;
            	        case 4 :
            	            // InternalDSL.g:4457:8: lv_operators_4_4= '/'
            	            {
            	            lv_operators_4_4=(Token)match(input,76,FOLLOW_19); 

            	                    newLeafNode(lv_operators_4_4, grammarAccess.getStandardOperationAccess().getOperatorsSolidusKeyword_4_0_0_3());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getStandardOperationRule());
            	            	        }
            	                   		addWithLastConsumed(current, "operators", lv_operators_4_4, null);
            	            	    

            	            }
            	            break;
            	        case 5 :
            	            // InternalDSL.g:4469:8: lv_operators_4_5= '%'
            	            {
            	            lv_operators_4_5=(Token)match(input,77,FOLLOW_19); 

            	                    newLeafNode(lv_operators_4_5, grammarAccess.getStandardOperationAccess().getOperatorsPercentSignKeyword_4_0_0_4());
            	                

            	            	        if (current==null) {
            	            	            current = createModelElement(grammarAccess.getStandardOperationRule());
            	            	        }
            	                   		addWithLastConsumed(current, "operators", lv_operators_4_5, null);
            	            	    

            	            }
            	            break;
            	        case 6 :
            	            // InternalDSL.g:4481:8: lv_operators_4_6= '..'
            	            {
            	            lv_operators_4_6=(Token)match(input,78,FOLLOW_19); 

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
            	        
            	    pushFollow(FOLLOW_19);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // InternalDSL.g:4504:1: ( (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation ) )
            	    // InternalDSL.g:4505:1: (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation )
            	    {
            	    // InternalDSL.g:4505:1: (lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation )
            	    // InternalDSL.g:4506:3: lv_moreOperands_6_0= ruleValueOrEnumValueOrOperation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getStandardOperationAccess().getMoreOperandsValueOrEnumValueOrOperationParserRuleCall_4_2_0()); 
            	    	    
            	    pushFollow(FOLLOW_82);
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
            	        
            	    pushFollow(FOLLOW_83);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt80 >= 1 ) break loop80;
                        EarlyExitException eee =
                            new EarlyExitException(80, input);
                        throw eee;
                }
                cnt80++;
            } while (true);

            otherlv_8=(Token)match(input,79,FOLLOW_2); 

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
    // InternalDSL.g:4542:1: entryRuleCustomOperation returns [EObject current=null] : iv_ruleCustomOperation= ruleCustomOperation EOF ;
    public final EObject entryRuleCustomOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCustomOperation = null;


        try {
            // InternalDSL.g:4543:2: (iv_ruleCustomOperation= ruleCustomOperation EOF )
            // InternalDSL.g:4544:2: iv_ruleCustomOperation= ruleCustomOperation EOF
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
    // InternalDSL.g:4551:1: ruleCustomOperation returns [EObject current=null] : (otherlv_0= '[' ruleNL ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL otherlv_9= ']' ) ;
    public final EObject ruleCustomOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        EObject lv_prefixOperand_2_0 = null;

        EObject lv_postfixOperand_7_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:4554:28: ( (otherlv_0= '[' ruleNL ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL otherlv_9= ']' ) )
            // InternalDSL.g:4555:1: (otherlv_0= '[' ruleNL ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL otherlv_9= ']' )
            {
            // InternalDSL.g:4555:1: (otherlv_0= '[' ruleNL ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL otherlv_9= ']' )
            // InternalDSL.g:4555:3: otherlv_0= '[' ruleNL ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )? ( ( ruleQualifiedName ) ) ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )? ruleNL otherlv_9= ']'
            {
            otherlv_0=(Token)match(input,80,FOLLOW_19); 

                	newLeafNode(otherlv_0, grammarAccess.getCustomOperationAccess().getLeftSquareBracketKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getCustomOperationAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_19);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:4567:1: ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )?
            int alt81=2;
            alt81 = dfa81.predict(input);
            switch (alt81) {
                case 1 :
                    // InternalDSL.g:4567:2: ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL
                    {
                    // InternalDSL.g:4567:2: ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) )
                    // InternalDSL.g:4568:1: (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection )
                    {
                    // InternalDSL.g:4568:1: (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection )
                    // InternalDSL.g:4569:3: lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection
                    {
                     
                    	        newCompositeNode(grammarAccess.getCustomOperationAccess().getPrefixOperandValueOrEnumValueOrOperationCollectionParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_6);
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
                        
                    pushFollow(FOLLOW_6);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            // InternalDSL.g:4593:3: ( ( ruleQualifiedName ) )
            // InternalDSL.g:4594:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:4594:1: ( ruleQualifiedName )
            // InternalDSL.g:4595:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCustomOperationRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getCustomOperationAccess().getDefinitionOperationDefinitionCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_84);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalDSL.g:4608:2: ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )?
            int alt82=2;
            alt82 = dfa82.predict(input);
            switch (alt82) {
                case 1 :
                    // InternalDSL.g:4609:5: ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) )
                    {
                     
                            newCompositeNode(grammarAccess.getCustomOperationAccess().getNLParserRuleCall_4_0()); 
                        
                    pushFollow(FOLLOW_7);
                    ruleNL();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        
                    otherlv_6=(Token)match(input,30,FOLLOW_19); 

                        	newLeafNode(otherlv_6, grammarAccess.getCustomOperationAccess().getWithKeyword_4_1());
                        
                    // InternalDSL.g:4620:1: ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) )
                    // InternalDSL.g:4621:1: (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection )
                    {
                    // InternalDSL.g:4621:1: (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection )
                    // InternalDSL.g:4622:3: lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection
                    {
                     
                    	        newCompositeNode(grammarAccess.getCustomOperationAccess().getPostfixOperandValueOrEnumValueOrOperationCollectionParserRuleCall_4_2_0()); 
                    	    
                    pushFollow(FOLLOW_85);
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
                
            pushFollow(FOLLOW_86);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_9=(Token)match(input,81,FOLLOW_2); 

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
    // InternalDSL.g:4658:1: entryRuleValueOrEnumValueOrOperationCollection returns [EObject current=null] : iv_ruleValueOrEnumValueOrOperationCollection= ruleValueOrEnumValueOrOperationCollection EOF ;
    public final EObject entryRuleValueOrEnumValueOrOperationCollection() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueOrEnumValueOrOperationCollection = null;


        try {
            // InternalDSL.g:4659:2: (iv_ruleValueOrEnumValueOrOperationCollection= ruleValueOrEnumValueOrOperationCollection EOF )
            // InternalDSL.g:4660:2: iv_ruleValueOrEnumValueOrOperationCollection= ruleValueOrEnumValueOrOperationCollection EOF
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
    // InternalDSL.g:4667:1: ruleValueOrEnumValueOrOperationCollection returns [EObject current=null] : ( ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) ) ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )* ) ;
    public final EObject ruleValueOrEnumValueOrOperationCollection() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject lv_value_0_0 = null;

        EObject lv_moreValues_4_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:4670:28: ( ( ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) ) ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )* ) )
            // InternalDSL.g:4671:1: ( ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) ) ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )* )
            {
            // InternalDSL.g:4671:1: ( ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) ) ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )* )
            // InternalDSL.g:4671:2: ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) ) ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )*
            {
            // InternalDSL.g:4671:2: ( (lv_value_0_0= ruleValueOrEnumValueOrOperation ) )
            // InternalDSL.g:4672:1: (lv_value_0_0= ruleValueOrEnumValueOrOperation )
            {
            // InternalDSL.g:4672:1: (lv_value_0_0= ruleValueOrEnumValueOrOperation )
            // InternalDSL.g:4673:3: lv_value_0_0= ruleValueOrEnumValueOrOperation
            {
             
            	        newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getValueValueOrEnumValueOrOperationParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_87);
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

            // InternalDSL.g:4689:2: ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )*
            loop83:
            do {
                int alt83=2;
                alt83 = dfa83.predict(input);
                switch (alt83) {
            	case 1 :
            	    // InternalDSL.g:4690:5: ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) )
            	    {
            	     
            	            newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getNLParserRuleCall_1_0()); 
            	        
            	    pushFollow(FOLLOW_88);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    otherlv_2=(Token)match(input,70,FOLLOW_19); 

            	        	newLeafNode(otherlv_2, grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getCommaKeyword_1_1());
            	        
            	     
            	            newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getNLParserRuleCall_1_2()); 
            	        
            	    pushFollow(FOLLOW_19);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        
            	    // InternalDSL.g:4709:1: ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) )
            	    // InternalDSL.g:4710:1: (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation )
            	    {
            	    // InternalDSL.g:4710:1: (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation )
            	    // InternalDSL.g:4711:3: lv_moreValues_4_0= ruleValueOrEnumValueOrOperation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getValueOrEnumValueOrOperationCollectionAccess().getMoreValuesValueOrEnumValueOrOperationParserRuleCall_1_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_87);
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
            	    break loop83;
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
    // InternalDSL.g:4735:1: entryRuleValueOrEnumValueOrOperation returns [EObject current=null] : iv_ruleValueOrEnumValueOrOperation= ruleValueOrEnumValueOrOperation EOF ;
    public final EObject entryRuleValueOrEnumValueOrOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValueOrEnumValueOrOperation = null;


        try {
            // InternalDSL.g:4736:2: (iv_ruleValueOrEnumValueOrOperation= ruleValueOrEnumValueOrOperation EOF )
            // InternalDSL.g:4737:2: iv_ruleValueOrEnumValueOrOperation= ruleValueOrEnumValueOrOperation EOF
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
    // InternalDSL.g:4744:1: ruleValueOrEnumValueOrOperation returns [EObject current=null] : (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue | this_Operation_2= ruleOperation ) ;
    public final EObject ruleValueOrEnumValueOrOperation() throws RecognitionException {
        EObject current = null;

        EObject this_Value_0 = null;

        EObject this_EnumValue_1 = null;

        EObject this_Operation_2 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:4747:28: ( (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue | this_Operation_2= ruleOperation ) )
            // InternalDSL.g:4748:1: (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue | this_Operation_2= ruleOperation )
            {
            // InternalDSL.g:4748:1: (this_Value_0= ruleValue | this_EnumValue_1= ruleEnumValue | this_Operation_2= ruleOperation )
            int alt84=3;
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
            case 82:
            case 85:
            case 86:
                {
                alt84=1;
                }
                break;
            case RULE_UPPERCASE_ID:
                {
                alt84=2;
                }
                break;
            case 73:
            case 80:
                {
                alt84=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 84, 0, input);

                throw nvae;
            }

            switch (alt84) {
                case 1 :
                    // InternalDSL.g:4749:5: this_Value_0= ruleValue
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
                    // InternalDSL.g:4759:5: this_EnumValue_1= ruleEnumValue
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
                    // InternalDSL.g:4769:5: this_Operation_2= ruleOperation
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
    // InternalDSL.g:4785:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // InternalDSL.g:4786:2: (iv_ruleValue= ruleValue EOF )
            // InternalDSL.g:4787:2: iv_ruleValue= ruleValue EOF
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
    // InternalDSL.g:4794:1: ruleValue returns [EObject current=null] : (this_StaticValue_0= ruleStaticValue | this_Variable_1= ruleVariable | this_NestedObject_2= ruleNestedObject | this_TypedNestedObject_3= ruleTypedNestedObject ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        EObject this_StaticValue_0 = null;

        EObject this_Variable_1 = null;

        EObject this_NestedObject_2 = null;

        EObject this_TypedNestedObject_3 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:4797:28: ( (this_StaticValue_0= ruleStaticValue | this_Variable_1= ruleVariable | this_NestedObject_2= ruleNestedObject | this_TypedNestedObject_3= ruleTypedNestedObject ) )
            // InternalDSL.g:4798:1: (this_StaticValue_0= ruleStaticValue | this_Variable_1= ruleVariable | this_NestedObject_2= ruleNestedObject | this_TypedNestedObject_3= ruleTypedNestedObject )
            {
            // InternalDSL.g:4798:1: (this_StaticValue_0= ruleStaticValue | this_Variable_1= ruleVariable | this_NestedObject_2= ruleNestedObject | this_TypedNestedObject_3= ruleTypedNestedObject )
            int alt85=4;
            alt85 = dfa85.predict(input);
            switch (alt85) {
                case 1 :
                    // InternalDSL.g:4799:5: this_StaticValue_0= ruleStaticValue
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
                    // InternalDSL.g:4809:5: this_Variable_1= ruleVariable
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
                    // InternalDSL.g:4819:5: this_NestedObject_2= ruleNestedObject
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
                    // InternalDSL.g:4829:5: this_TypedNestedObject_3= ruleTypedNestedObject
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
    // InternalDSL.g:4845:1: entryRuleConstantValue returns [EObject current=null] : iv_ruleConstantValue= ruleConstantValue EOF ;
    public final EObject entryRuleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstantValue = null;


        try {
            // InternalDSL.g:4846:2: (iv_ruleConstantValue= ruleConstantValue EOF )
            // InternalDSL.g:4847:2: iv_ruleConstantValue= ruleConstantValue EOF
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
    // InternalDSL.g:4854:1: ruleConstantValue returns [EObject current=null] : (this_StaticValue_0= ruleStaticValue | this_Constant_1= ruleConstant ) ;
    public final EObject ruleConstantValue() throws RecognitionException {
        EObject current = null;

        EObject this_StaticValue_0 = null;

        EObject this_Constant_1 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:4857:28: ( (this_StaticValue_0= ruleStaticValue | this_Constant_1= ruleConstant ) )
            // InternalDSL.g:4858:1: (this_StaticValue_0= ruleStaticValue | this_Constant_1= ruleConstant )
            {
            // InternalDSL.g:4858:1: (this_StaticValue_0= ruleStaticValue | this_Constant_1= ruleConstant )
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==RULE_STRING||(LA86_0>=RULE_INTEGER && LA86_0<=RULE_TWELVEHRSTIME)||LA86_0==82||LA86_0==85) ) {
                alt86=1;
            }
            else if ( (LA86_0==RULE_ID) ) {
                alt86=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }
            switch (alt86) {
                case 1 :
                    // InternalDSL.g:4859:5: this_StaticValue_0= ruleStaticValue
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
                    // InternalDSL.g:4869:5: this_Constant_1= ruleConstant
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
    // InternalDSL.g:4885:1: entryRuleStaticValue returns [EObject current=null] : iv_ruleStaticValue= ruleStaticValue EOF ;
    public final EObject entryRuleStaticValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStaticValue = null;


        try {
            // InternalDSL.g:4886:2: (iv_ruleStaticValue= ruleStaticValue EOF )
            // InternalDSL.g:4887:2: iv_ruleStaticValue= ruleStaticValue EOF
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
    // InternalDSL.g:4894:1: ruleStaticValue returns [EObject current=null] : (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_BooleanValue_3= ruleBooleanValue | this_DateValue_4= ruleDateValue | this_TimeValue_5= ruleTimeValue | this_DateAndTimeValue_6= ruleDateAndTimeValue | this_NullValue_7= ruleNullValue | this_JavaConstantValue_8= ruleJavaConstantValue ) ;
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
            // InternalDSL.g:4897:28: ( (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_BooleanValue_3= ruleBooleanValue | this_DateValue_4= ruleDateValue | this_TimeValue_5= ruleTimeValue | this_DateAndTimeValue_6= ruleDateAndTimeValue | this_NullValue_7= ruleNullValue | this_JavaConstantValue_8= ruleJavaConstantValue ) )
            // InternalDSL.g:4898:1: (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_BooleanValue_3= ruleBooleanValue | this_DateValue_4= ruleDateValue | this_TimeValue_5= ruleTimeValue | this_DateAndTimeValue_6= ruleDateAndTimeValue | this_NullValue_7= ruleNullValue | this_JavaConstantValue_8= ruleJavaConstantValue )
            {
            // InternalDSL.g:4898:1: (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_BooleanValue_3= ruleBooleanValue | this_DateValue_4= ruleDateValue | this_TimeValue_5= ruleTimeValue | this_DateAndTimeValue_6= ruleDateAndTimeValue | this_NullValue_7= ruleNullValue | this_JavaConstantValue_8= ruleJavaConstantValue )
            int alt87=9;
            alt87 = dfa87.predict(input);
            switch (alt87) {
                case 1 :
                    // InternalDSL.g:4899:5: this_StringValue_0= ruleStringValue
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
                    // InternalDSL.g:4909:5: this_IntegerValue_1= ruleIntegerValue
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
                    // InternalDSL.g:4919:5: this_DecimalValue_2= ruleDecimalValue
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
                    // InternalDSL.g:4929:5: this_BooleanValue_3= ruleBooleanValue
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
                    // InternalDSL.g:4939:5: this_DateValue_4= ruleDateValue
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
                    // InternalDSL.g:4949:5: this_TimeValue_5= ruleTimeValue
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
                    // InternalDSL.g:4959:5: this_DateAndTimeValue_6= ruleDateAndTimeValue
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
                    // InternalDSL.g:4969:5: this_NullValue_7= ruleNullValue
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
                    // InternalDSL.g:4979:5: this_JavaConstantValue_8= ruleJavaConstantValue
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
    // InternalDSL.g:4995:1: entryRuleIntegerValue returns [EObject current=null] : iv_ruleIntegerValue= ruleIntegerValue EOF ;
    public final EObject entryRuleIntegerValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntegerValue = null;


        try {
            // InternalDSL.g:4996:2: (iv_ruleIntegerValue= ruleIntegerValue EOF )
            // InternalDSL.g:4997:2: iv_ruleIntegerValue= ruleIntegerValue EOF
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
    // InternalDSL.g:5004:1: ruleIntegerValue returns [EObject current=null] : ( (lv_integerValue_0_0= RULE_INTEGER ) ) ;
    public final EObject ruleIntegerValue() throws RecognitionException {
        EObject current = null;

        Token lv_integerValue_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5007:28: ( ( (lv_integerValue_0_0= RULE_INTEGER ) ) )
            // InternalDSL.g:5008:1: ( (lv_integerValue_0_0= RULE_INTEGER ) )
            {
            // InternalDSL.g:5008:1: ( (lv_integerValue_0_0= RULE_INTEGER ) )
            // InternalDSL.g:5009:1: (lv_integerValue_0_0= RULE_INTEGER )
            {
            // InternalDSL.g:5009:1: (lv_integerValue_0_0= RULE_INTEGER )
            // InternalDSL.g:5010:3: lv_integerValue_0_0= RULE_INTEGER
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
    // InternalDSL.g:5034:1: entryRuleDecimalValue returns [EObject current=null] : iv_ruleDecimalValue= ruleDecimalValue EOF ;
    public final EObject entryRuleDecimalValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecimalValue = null;


        try {
            // InternalDSL.g:5035:2: (iv_ruleDecimalValue= ruleDecimalValue EOF )
            // InternalDSL.g:5036:2: iv_ruleDecimalValue= ruleDecimalValue EOF
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
    // InternalDSL.g:5043:1: ruleDecimalValue returns [EObject current=null] : ( (lv_decimalValue_0_0= RULE_DECIMAL ) ) ;
    public final EObject ruleDecimalValue() throws RecognitionException {
        EObject current = null;

        Token lv_decimalValue_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5046:28: ( ( (lv_decimalValue_0_0= RULE_DECIMAL ) ) )
            // InternalDSL.g:5047:1: ( (lv_decimalValue_0_0= RULE_DECIMAL ) )
            {
            // InternalDSL.g:5047:1: ( (lv_decimalValue_0_0= RULE_DECIMAL ) )
            // InternalDSL.g:5048:1: (lv_decimalValue_0_0= RULE_DECIMAL )
            {
            // InternalDSL.g:5048:1: (lv_decimalValue_0_0= RULE_DECIMAL )
            // InternalDSL.g:5049:3: lv_decimalValue_0_0= RULE_DECIMAL
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
    // InternalDSL.g:5073:1: entryRuleStringValue returns [EObject current=null] : iv_ruleStringValue= ruleStringValue EOF ;
    public final EObject entryRuleStringValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringValue = null;


        try {
            // InternalDSL.g:5074:2: (iv_ruleStringValue= ruleStringValue EOF )
            // InternalDSL.g:5075:2: iv_ruleStringValue= ruleStringValue EOF
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
    // InternalDSL.g:5082:1: ruleStringValue returns [EObject current=null] : ( (lv_stringValue_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringValue() throws RecognitionException {
        EObject current = null;

        Token lv_stringValue_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5085:28: ( ( (lv_stringValue_0_0= RULE_STRING ) ) )
            // InternalDSL.g:5086:1: ( (lv_stringValue_0_0= RULE_STRING ) )
            {
            // InternalDSL.g:5086:1: ( (lv_stringValue_0_0= RULE_STRING ) )
            // InternalDSL.g:5087:1: (lv_stringValue_0_0= RULE_STRING )
            {
            // InternalDSL.g:5087:1: (lv_stringValue_0_0= RULE_STRING )
            // InternalDSL.g:5088:3: lv_stringValue_0_0= RULE_STRING
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
    // InternalDSL.g:5112:1: entryRuleBooleanValue returns [EObject current=null] : iv_ruleBooleanValue= ruleBooleanValue EOF ;
    public final EObject entryRuleBooleanValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanValue = null;


        try {
            // InternalDSL.g:5113:2: (iv_ruleBooleanValue= ruleBooleanValue EOF )
            // InternalDSL.g:5114:2: iv_ruleBooleanValue= ruleBooleanValue EOF
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
    // InternalDSL.g:5121:1: ruleBooleanValue returns [EObject current=null] : ( ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) ) ) ;
    public final EObject ruleBooleanValue() throws RecognitionException {
        EObject current = null;

        Token lv_booleanValue_0_1=null;
        Token lv_booleanValue_0_2=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5124:28: ( ( ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) ) ) )
            // InternalDSL.g:5125:1: ( ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) ) )
            {
            // InternalDSL.g:5125:1: ( ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) ) )
            // InternalDSL.g:5126:1: ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) )
            {
            // InternalDSL.g:5126:1: ( (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE ) )
            // InternalDSL.g:5127:1: (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE )
            {
            // InternalDSL.g:5127:1: (lv_booleanValue_0_1= RULE_BOOLEAN_TRUE | lv_booleanValue_0_2= RULE_BOOLEAN_FALSE )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==RULE_BOOLEAN_TRUE) ) {
                alt88=1;
            }
            else if ( (LA88_0==RULE_BOOLEAN_FALSE) ) {
                alt88=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }
            switch (alt88) {
                case 1 :
                    // InternalDSL.g:5128:3: lv_booleanValue_0_1= RULE_BOOLEAN_TRUE
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
                    // InternalDSL.g:5143:8: lv_booleanValue_0_2= RULE_BOOLEAN_FALSE
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
    // InternalDSL.g:5169:1: entryRuleDateValue returns [EObject current=null] : iv_ruleDateValue= ruleDateValue EOF ;
    public final EObject entryRuleDateValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateValue = null;


        try {
            // InternalDSL.g:5170:2: (iv_ruleDateValue= ruleDateValue EOF )
            // InternalDSL.g:5171:2: iv_ruleDateValue= ruleDateValue EOF
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
    // InternalDSL.g:5178:1: ruleDateValue returns [EObject current=null] : (this_IsoDateValue_0= ruleIsoDateValue | this_EuropeanDateValue_1= ruleEuropeanDateValue | this_USDateValue_2= ruleUSDateValue ) ;
    public final EObject ruleDateValue() throws RecognitionException {
        EObject current = null;

        EObject this_IsoDateValue_0 = null;

        EObject this_EuropeanDateValue_1 = null;

        EObject this_USDateValue_2 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:5181:28: ( (this_IsoDateValue_0= ruleIsoDateValue | this_EuropeanDateValue_1= ruleEuropeanDateValue | this_USDateValue_2= ruleUSDateValue ) )
            // InternalDSL.g:5182:1: (this_IsoDateValue_0= ruleIsoDateValue | this_EuropeanDateValue_1= ruleEuropeanDateValue | this_USDateValue_2= ruleUSDateValue )
            {
            // InternalDSL.g:5182:1: (this_IsoDateValue_0= ruleIsoDateValue | this_EuropeanDateValue_1= ruleEuropeanDateValue | this_USDateValue_2= ruleUSDateValue )
            int alt89=3;
            switch ( input.LA(1) ) {
            case RULE_ISODATE:
                {
                alt89=1;
                }
                break;
            case RULE_EURODATE:
                {
                alt89=2;
                }
                break;
            case RULE_USDATE:
                {
                alt89=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }

            switch (alt89) {
                case 1 :
                    // InternalDSL.g:5183:5: this_IsoDateValue_0= ruleIsoDateValue
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
                    // InternalDSL.g:5193:5: this_EuropeanDateValue_1= ruleEuropeanDateValue
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
                    // InternalDSL.g:5203:5: this_USDateValue_2= ruleUSDateValue
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
    // InternalDSL.g:5219:1: entryRuleIsoDateValue returns [EObject current=null] : iv_ruleIsoDateValue= ruleIsoDateValue EOF ;
    public final EObject entryRuleIsoDateValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsoDateValue = null;


        try {
            // InternalDSL.g:5220:2: (iv_ruleIsoDateValue= ruleIsoDateValue EOF )
            // InternalDSL.g:5221:2: iv_ruleIsoDateValue= ruleIsoDateValue EOF
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
    // InternalDSL.g:5228:1: ruleIsoDateValue returns [EObject current=null] : ( (lv_dateValue_0_0= RULE_ISODATE ) ) ;
    public final EObject ruleIsoDateValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5231:28: ( ( (lv_dateValue_0_0= RULE_ISODATE ) ) )
            // InternalDSL.g:5232:1: ( (lv_dateValue_0_0= RULE_ISODATE ) )
            {
            // InternalDSL.g:5232:1: ( (lv_dateValue_0_0= RULE_ISODATE ) )
            // InternalDSL.g:5233:1: (lv_dateValue_0_0= RULE_ISODATE )
            {
            // InternalDSL.g:5233:1: (lv_dateValue_0_0= RULE_ISODATE )
            // InternalDSL.g:5234:3: lv_dateValue_0_0= RULE_ISODATE
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
    // InternalDSL.g:5258:1: entryRuleEuropeanDateValue returns [EObject current=null] : iv_ruleEuropeanDateValue= ruleEuropeanDateValue EOF ;
    public final EObject entryRuleEuropeanDateValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEuropeanDateValue = null;


        try {
            // InternalDSL.g:5259:2: (iv_ruleEuropeanDateValue= ruleEuropeanDateValue EOF )
            // InternalDSL.g:5260:2: iv_ruleEuropeanDateValue= ruleEuropeanDateValue EOF
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
    // InternalDSL.g:5267:1: ruleEuropeanDateValue returns [EObject current=null] : ( (lv_dateValue_0_0= RULE_EURODATE ) ) ;
    public final EObject ruleEuropeanDateValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5270:28: ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) )
            // InternalDSL.g:5271:1: ( (lv_dateValue_0_0= RULE_EURODATE ) )
            {
            // InternalDSL.g:5271:1: ( (lv_dateValue_0_0= RULE_EURODATE ) )
            // InternalDSL.g:5272:1: (lv_dateValue_0_0= RULE_EURODATE )
            {
            // InternalDSL.g:5272:1: (lv_dateValue_0_0= RULE_EURODATE )
            // InternalDSL.g:5273:3: lv_dateValue_0_0= RULE_EURODATE
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
    // InternalDSL.g:5297:1: entryRuleUSDateValue returns [EObject current=null] : iv_ruleUSDateValue= ruleUSDateValue EOF ;
    public final EObject entryRuleUSDateValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUSDateValue = null;


        try {
            // InternalDSL.g:5298:2: (iv_ruleUSDateValue= ruleUSDateValue EOF )
            // InternalDSL.g:5299:2: iv_ruleUSDateValue= ruleUSDateValue EOF
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
    // InternalDSL.g:5306:1: ruleUSDateValue returns [EObject current=null] : ( (lv_dateValue_0_0= RULE_USDATE ) ) ;
    public final EObject ruleUSDateValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5309:28: ( ( (lv_dateValue_0_0= RULE_USDATE ) ) )
            // InternalDSL.g:5310:1: ( (lv_dateValue_0_0= RULE_USDATE ) )
            {
            // InternalDSL.g:5310:1: ( (lv_dateValue_0_0= RULE_USDATE ) )
            // InternalDSL.g:5311:1: (lv_dateValue_0_0= RULE_USDATE )
            {
            // InternalDSL.g:5311:1: (lv_dateValue_0_0= RULE_USDATE )
            // InternalDSL.g:5312:3: lv_dateValue_0_0= RULE_USDATE
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
    // InternalDSL.g:5336:1: entryRuleTimeValue returns [EObject current=null] : iv_ruleTimeValue= ruleTimeValue EOF ;
    public final EObject entryRuleTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeValue = null;


        try {
            // InternalDSL.g:5337:2: (iv_ruleTimeValue= ruleTimeValue EOF )
            // InternalDSL.g:5338:2: iv_ruleTimeValue= ruleTimeValue EOF
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
    // InternalDSL.g:5345:1: ruleTimeValue returns [EObject current=null] : (this_IsoTimeValue_0= ruleIsoTimeValue | this_Simple24HrsTimeValue_1= ruleSimple24HrsTimeValue | this_Simple12HrsTimeValue_2= ruleSimple12HrsTimeValue ) ;
    public final EObject ruleTimeValue() throws RecognitionException {
        EObject current = null;

        EObject this_IsoTimeValue_0 = null;

        EObject this_Simple24HrsTimeValue_1 = null;

        EObject this_Simple12HrsTimeValue_2 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:5348:28: ( (this_IsoTimeValue_0= ruleIsoTimeValue | this_Simple24HrsTimeValue_1= ruleSimple24HrsTimeValue | this_Simple12HrsTimeValue_2= ruleSimple12HrsTimeValue ) )
            // InternalDSL.g:5349:1: (this_IsoTimeValue_0= ruleIsoTimeValue | this_Simple24HrsTimeValue_1= ruleSimple24HrsTimeValue | this_Simple12HrsTimeValue_2= ruleSimple12HrsTimeValue )
            {
            // InternalDSL.g:5349:1: (this_IsoTimeValue_0= ruleIsoTimeValue | this_Simple24HrsTimeValue_1= ruleSimple24HrsTimeValue | this_Simple12HrsTimeValue_2= ruleSimple12HrsTimeValue )
            int alt90=3;
            switch ( input.LA(1) ) {
            case RULE_ISOTIME:
                {
                alt90=1;
                }
                break;
            case RULE_TWENTYFOURHRSTIME:
                {
                alt90=2;
                }
                break;
            case RULE_TWELVEHRSTIME:
                {
                alt90=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }

            switch (alt90) {
                case 1 :
                    // InternalDSL.g:5350:5: this_IsoTimeValue_0= ruleIsoTimeValue
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
                    // InternalDSL.g:5360:5: this_Simple24HrsTimeValue_1= ruleSimple24HrsTimeValue
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
                    // InternalDSL.g:5370:5: this_Simple12HrsTimeValue_2= ruleSimple12HrsTimeValue
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
    // InternalDSL.g:5386:1: entryRuleIsoTimeValue returns [EObject current=null] : iv_ruleIsoTimeValue= ruleIsoTimeValue EOF ;
    public final EObject entryRuleIsoTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsoTimeValue = null;


        try {
            // InternalDSL.g:5387:2: (iv_ruleIsoTimeValue= ruleIsoTimeValue EOF )
            // InternalDSL.g:5388:2: iv_ruleIsoTimeValue= ruleIsoTimeValue EOF
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
    // InternalDSL.g:5395:1: ruleIsoTimeValue returns [EObject current=null] : ( (lv_timeValue_0_0= RULE_ISOTIME ) ) ;
    public final EObject ruleIsoTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_timeValue_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5398:28: ( ( (lv_timeValue_0_0= RULE_ISOTIME ) ) )
            // InternalDSL.g:5399:1: ( (lv_timeValue_0_0= RULE_ISOTIME ) )
            {
            // InternalDSL.g:5399:1: ( (lv_timeValue_0_0= RULE_ISOTIME ) )
            // InternalDSL.g:5400:1: (lv_timeValue_0_0= RULE_ISOTIME )
            {
            // InternalDSL.g:5400:1: (lv_timeValue_0_0= RULE_ISOTIME )
            // InternalDSL.g:5401:3: lv_timeValue_0_0= RULE_ISOTIME
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
    // InternalDSL.g:5425:1: entryRuleSimple24HrsTimeValue returns [EObject current=null] : iv_ruleSimple24HrsTimeValue= ruleSimple24HrsTimeValue EOF ;
    public final EObject entryRuleSimple24HrsTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimple24HrsTimeValue = null;


        try {
            // InternalDSL.g:5426:2: (iv_ruleSimple24HrsTimeValue= ruleSimple24HrsTimeValue EOF )
            // InternalDSL.g:5427:2: iv_ruleSimple24HrsTimeValue= ruleSimple24HrsTimeValue EOF
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
    // InternalDSL.g:5434:1: ruleSimple24HrsTimeValue returns [EObject current=null] : ( (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME ) ) ;
    public final EObject ruleSimple24HrsTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_timeValue_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5437:28: ( ( (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME ) ) )
            // InternalDSL.g:5438:1: ( (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME ) )
            {
            // InternalDSL.g:5438:1: ( (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME ) )
            // InternalDSL.g:5439:1: (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME )
            {
            // InternalDSL.g:5439:1: (lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME )
            // InternalDSL.g:5440:3: lv_timeValue_0_0= RULE_TWENTYFOURHRSTIME
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
    // InternalDSL.g:5464:1: entryRuleSimple12HrsTimeValue returns [EObject current=null] : iv_ruleSimple12HrsTimeValue= ruleSimple12HrsTimeValue EOF ;
    public final EObject entryRuleSimple12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimple12HrsTimeValue = null;


        try {
            // InternalDSL.g:5465:2: (iv_ruleSimple12HrsTimeValue= ruleSimple12HrsTimeValue EOF )
            // InternalDSL.g:5466:2: iv_ruleSimple12HrsTimeValue= ruleSimple12HrsTimeValue EOF
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
    // InternalDSL.g:5473:1: ruleSimple12HrsTimeValue returns [EObject current=null] : ( (lv_timeValue_0_0= RULE_TWELVEHRSTIME ) ) ;
    public final EObject ruleSimple12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_timeValue_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5476:28: ( ( (lv_timeValue_0_0= RULE_TWELVEHRSTIME ) ) )
            // InternalDSL.g:5477:1: ( (lv_timeValue_0_0= RULE_TWELVEHRSTIME ) )
            {
            // InternalDSL.g:5477:1: ( (lv_timeValue_0_0= RULE_TWELVEHRSTIME ) )
            // InternalDSL.g:5478:1: (lv_timeValue_0_0= RULE_TWELVEHRSTIME )
            {
            // InternalDSL.g:5478:1: (lv_timeValue_0_0= RULE_TWELVEHRSTIME )
            // InternalDSL.g:5479:3: lv_timeValue_0_0= RULE_TWELVEHRSTIME
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
    // InternalDSL.g:5503:1: entryRuleDateAndTimeValue returns [EObject current=null] : iv_ruleDateAndTimeValue= ruleDateAndTimeValue EOF ;
    public final EObject entryRuleDateAndTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDateAndTimeValue = null;


        try {
            // InternalDSL.g:5504:2: (iv_ruleDateAndTimeValue= ruleDateAndTimeValue EOF )
            // InternalDSL.g:5505:2: iv_ruleDateAndTimeValue= ruleDateAndTimeValue EOF
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
    // InternalDSL.g:5512:1: ruleDateAndTimeValue returns [EObject current=null] : (this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue | this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue | this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue | this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue ) ;
    public final EObject ruleDateAndTimeValue() throws RecognitionException {
        EObject current = null;

        EObject this_IsoDateAndTimeValue_0 = null;

        EObject this_EuropeanDateAnd24HrsTimeValue_1 = null;

        EObject this_EuropeanDateAnd12HrsTimeValue_2 = null;

        EObject this_USDateAnd12HrsTimeValue_3 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:5515:28: ( (this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue | this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue | this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue | this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue ) )
            // InternalDSL.g:5516:1: (this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue | this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue | this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue | this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue )
            {
            // InternalDSL.g:5516:1: (this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue | this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue | this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue | this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue )
            int alt91=4;
            alt91 = dfa91.predict(input);
            switch (alt91) {
                case 1 :
                    // InternalDSL.g:5517:5: this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue
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
                    // InternalDSL.g:5527:5: this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue
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
                    // InternalDSL.g:5537:5: this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue
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
                    // InternalDSL.g:5547:5: this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue
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
    // InternalDSL.g:5563:1: entryRuleIsoDateAndTimeValue returns [EObject current=null] : iv_ruleIsoDateAndTimeValue= ruleIsoDateAndTimeValue EOF ;
    public final EObject entryRuleIsoDateAndTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIsoDateAndTimeValue = null;


        try {
            // InternalDSL.g:5564:2: (iv_ruleIsoDateAndTimeValue= ruleIsoDateAndTimeValue EOF )
            // InternalDSL.g:5565:2: iv_ruleIsoDateAndTimeValue= ruleIsoDateAndTimeValue EOF
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
    // InternalDSL.g:5572:1: ruleIsoDateAndTimeValue returns [EObject current=null] : ( ( (lv_dateValue_0_0= RULE_ISODATE ) ) ( (lv_timeValue_1_0= RULE_ISOTIME ) ) ) ;
    public final EObject ruleIsoDateAndTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;
        Token lv_timeValue_1_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5575:28: ( ( ( (lv_dateValue_0_0= RULE_ISODATE ) ) ( (lv_timeValue_1_0= RULE_ISOTIME ) ) ) )
            // InternalDSL.g:5576:1: ( ( (lv_dateValue_0_0= RULE_ISODATE ) ) ( (lv_timeValue_1_0= RULE_ISOTIME ) ) )
            {
            // InternalDSL.g:5576:1: ( ( (lv_dateValue_0_0= RULE_ISODATE ) ) ( (lv_timeValue_1_0= RULE_ISOTIME ) ) )
            // InternalDSL.g:5576:2: ( (lv_dateValue_0_0= RULE_ISODATE ) ) ( (lv_timeValue_1_0= RULE_ISOTIME ) )
            {
            // InternalDSL.g:5576:2: ( (lv_dateValue_0_0= RULE_ISODATE ) )
            // InternalDSL.g:5577:1: (lv_dateValue_0_0= RULE_ISODATE )
            {
            // InternalDSL.g:5577:1: (lv_dateValue_0_0= RULE_ISODATE )
            // InternalDSL.g:5578:3: lv_dateValue_0_0= RULE_ISODATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_ISODATE,FOLLOW_89); 

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

            // InternalDSL.g:5594:2: ( (lv_timeValue_1_0= RULE_ISOTIME ) )
            // InternalDSL.g:5595:1: (lv_timeValue_1_0= RULE_ISOTIME )
            {
            // InternalDSL.g:5595:1: (lv_timeValue_1_0= RULE_ISOTIME )
            // InternalDSL.g:5596:3: lv_timeValue_1_0= RULE_ISOTIME
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
    // InternalDSL.g:5620:1: entryRuleEuropeanDateAnd24HrsTimeValue returns [EObject current=null] : iv_ruleEuropeanDateAnd24HrsTimeValue= ruleEuropeanDateAnd24HrsTimeValue EOF ;
    public final EObject entryRuleEuropeanDateAnd24HrsTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEuropeanDateAnd24HrsTimeValue = null;


        try {
            // InternalDSL.g:5621:2: (iv_ruleEuropeanDateAnd24HrsTimeValue= ruleEuropeanDateAnd24HrsTimeValue EOF )
            // InternalDSL.g:5622:2: iv_ruleEuropeanDateAnd24HrsTimeValue= ruleEuropeanDateAnd24HrsTimeValue EOF
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
    // InternalDSL.g:5629:1: ruleEuropeanDateAnd24HrsTimeValue returns [EObject current=null] : ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) ) ) ;
    public final EObject ruleEuropeanDateAnd24HrsTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;
        Token lv_timeValue_2_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5632:28: ( ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) ) ) )
            // InternalDSL.g:5633:1: ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) ) )
            {
            // InternalDSL.g:5633:1: ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) ) )
            // InternalDSL.g:5633:2: ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) )
            {
            // InternalDSL.g:5633:2: ( (lv_dateValue_0_0= RULE_EURODATE ) )
            // InternalDSL.g:5634:1: (lv_dateValue_0_0= RULE_EURODATE )
            {
            // InternalDSL.g:5634:1: (lv_dateValue_0_0= RULE_EURODATE )
            // InternalDSL.g:5635:3: lv_dateValue_0_0= RULE_EURODATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_EURODATE,FOLLOW_90); 

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
                
            pushFollow(FOLLOW_91);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:5659:1: ( (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME ) )
            // InternalDSL.g:5660:1: (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME )
            {
            // InternalDSL.g:5660:1: (lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME )
            // InternalDSL.g:5661:3: lv_timeValue_2_0= RULE_TWENTYFOURHRSTIME
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
    // InternalDSL.g:5685:1: entryRuleEuropeanDateAnd12HrsTimeValue returns [EObject current=null] : iv_ruleEuropeanDateAnd12HrsTimeValue= ruleEuropeanDateAnd12HrsTimeValue EOF ;
    public final EObject entryRuleEuropeanDateAnd12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEuropeanDateAnd12HrsTimeValue = null;


        try {
            // InternalDSL.g:5686:2: (iv_ruleEuropeanDateAnd12HrsTimeValue= ruleEuropeanDateAnd12HrsTimeValue EOF )
            // InternalDSL.g:5687:2: iv_ruleEuropeanDateAnd12HrsTimeValue= ruleEuropeanDateAnd12HrsTimeValue EOF
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
    // InternalDSL.g:5694:1: ruleEuropeanDateAnd12HrsTimeValue returns [EObject current=null] : ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) ) ;
    public final EObject ruleEuropeanDateAnd12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;
        Token lv_timeValue_2_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5697:28: ( ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) ) )
            // InternalDSL.g:5698:1: ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) )
            {
            // InternalDSL.g:5698:1: ( ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) )
            // InternalDSL.g:5698:2: ( (lv_dateValue_0_0= RULE_EURODATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) )
            {
            // InternalDSL.g:5698:2: ( (lv_dateValue_0_0= RULE_EURODATE ) )
            // InternalDSL.g:5699:1: (lv_dateValue_0_0= RULE_EURODATE )
            {
            // InternalDSL.g:5699:1: (lv_dateValue_0_0= RULE_EURODATE )
            // InternalDSL.g:5700:3: lv_dateValue_0_0= RULE_EURODATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_EURODATE,FOLLOW_92); 

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
                
            pushFollow(FOLLOW_93);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:5724:1: ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) )
            // InternalDSL.g:5725:1: (lv_timeValue_2_0= RULE_TWELVEHRSTIME )
            {
            // InternalDSL.g:5725:1: (lv_timeValue_2_0= RULE_TWELVEHRSTIME )
            // InternalDSL.g:5726:3: lv_timeValue_2_0= RULE_TWELVEHRSTIME
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
    // InternalDSL.g:5750:1: entryRuleUSDateAnd12HrsTimeValue returns [EObject current=null] : iv_ruleUSDateAnd12HrsTimeValue= ruleUSDateAnd12HrsTimeValue EOF ;
    public final EObject entryRuleUSDateAnd12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUSDateAnd12HrsTimeValue = null;


        try {
            // InternalDSL.g:5751:2: (iv_ruleUSDateAnd12HrsTimeValue= ruleUSDateAnd12HrsTimeValue EOF )
            // InternalDSL.g:5752:2: iv_ruleUSDateAnd12HrsTimeValue= ruleUSDateAnd12HrsTimeValue EOF
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
    // InternalDSL.g:5759:1: ruleUSDateAnd12HrsTimeValue returns [EObject current=null] : ( ( (lv_dateValue_0_0= RULE_USDATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) ) ;
    public final EObject ruleUSDateAnd12HrsTimeValue() throws RecognitionException {
        EObject current = null;

        Token lv_dateValue_0_0=null;
        Token lv_timeValue_2_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5762:28: ( ( ( (lv_dateValue_0_0= RULE_USDATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) ) )
            // InternalDSL.g:5763:1: ( ( (lv_dateValue_0_0= RULE_USDATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) )
            {
            // InternalDSL.g:5763:1: ( ( (lv_dateValue_0_0= RULE_USDATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) ) )
            // InternalDSL.g:5763:2: ( (lv_dateValue_0_0= RULE_USDATE ) ) ruleNL ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) )
            {
            // InternalDSL.g:5763:2: ( (lv_dateValue_0_0= RULE_USDATE ) )
            // InternalDSL.g:5764:1: (lv_dateValue_0_0= RULE_USDATE )
            {
            // InternalDSL.g:5764:1: (lv_dateValue_0_0= RULE_USDATE )
            // InternalDSL.g:5765:3: lv_dateValue_0_0= RULE_USDATE
            {
            lv_dateValue_0_0=(Token)match(input,RULE_USDATE,FOLLOW_92); 

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
                
            pushFollow(FOLLOW_93);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:5789:1: ( (lv_timeValue_2_0= RULE_TWELVEHRSTIME ) )
            // InternalDSL.g:5790:1: (lv_timeValue_2_0= RULE_TWELVEHRSTIME )
            {
            // InternalDSL.g:5790:1: (lv_timeValue_2_0= RULE_TWELVEHRSTIME )
            // InternalDSL.g:5791:3: lv_timeValue_2_0= RULE_TWELVEHRSTIME
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
    // InternalDSL.g:5815:1: entryRuleJavaConstantValue returns [EObject current=null] : iv_ruleJavaConstantValue= ruleJavaConstantValue EOF ;
    public final EObject entryRuleJavaConstantValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaConstantValue = null;


        try {
            // InternalDSL.g:5816:2: (iv_ruleJavaConstantValue= ruleJavaConstantValue EOF )
            // InternalDSL.g:5817:2: iv_ruleJavaConstantValue= ruleJavaConstantValue EOF
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
    // InternalDSL.g:5824:1: ruleJavaConstantValue returns [EObject current=null] : (otherlv_0= '<' ( (lv_constant_1_0= ruleJavaConstantReference ) ) otherlv_2= '>' ) ;
    public final EObject ruleJavaConstantValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_constant_1_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:5827:28: ( (otherlv_0= '<' ( (lv_constant_1_0= ruleJavaConstantReference ) ) otherlv_2= '>' ) )
            // InternalDSL.g:5828:1: (otherlv_0= '<' ( (lv_constant_1_0= ruleJavaConstantReference ) ) otherlv_2= '>' )
            {
            // InternalDSL.g:5828:1: (otherlv_0= '<' ( (lv_constant_1_0= ruleJavaConstantReference ) ) otherlv_2= '>' )
            // InternalDSL.g:5828:3: otherlv_0= '<' ( (lv_constant_1_0= ruleJavaConstantReference ) ) otherlv_2= '>'
            {
            otherlv_0=(Token)match(input,82,FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getJavaConstantValueAccess().getLessThanSignKeyword_0());
                
            // InternalDSL.g:5832:1: ( (lv_constant_1_0= ruleJavaConstantReference ) )
            // InternalDSL.g:5833:1: (lv_constant_1_0= ruleJavaConstantReference )
            {
            // InternalDSL.g:5833:1: (lv_constant_1_0= ruleJavaConstantReference )
            // InternalDSL.g:5834:3: lv_constant_1_0= ruleJavaConstantReference
            {
             
            	        newCompositeNode(grammarAccess.getJavaConstantValueAccess().getConstantJavaConstantReferenceParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_94);
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

            otherlv_2=(Token)match(input,83,FOLLOW_2); 

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
    // InternalDSL.g:5862:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalDSL.g:5863:2: (iv_ruleVariable= ruleVariable EOF )
            // InternalDSL.g:5864:2: iv_ruleVariable= ruleVariable EOF
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
    // InternalDSL.g:5871:1: ruleVariable returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) (otherlv_1= '#' ( (lv_attribute_2_0= ruleQualifiedName ) ) )? ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_attribute_2_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:5874:28: ( ( ( ( ruleQualifiedName ) ) (otherlv_1= '#' ( (lv_attribute_2_0= ruleQualifiedName ) ) )? ) )
            // InternalDSL.g:5875:1: ( ( ( ruleQualifiedName ) ) (otherlv_1= '#' ( (lv_attribute_2_0= ruleQualifiedName ) ) )? )
            {
            // InternalDSL.g:5875:1: ( ( ( ruleQualifiedName ) ) (otherlv_1= '#' ( (lv_attribute_2_0= ruleQualifiedName ) ) )? )
            // InternalDSL.g:5875:2: ( ( ruleQualifiedName ) ) (otherlv_1= '#' ( (lv_attribute_2_0= ruleQualifiedName ) ) )?
            {
            // InternalDSL.g:5875:2: ( ( ruleQualifiedName ) )
            // InternalDSL.g:5876:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:5876:1: ( ruleQualifiedName )
            // InternalDSL.g:5877:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getVariableRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getVariableAccess().getNameVariableOrConstantEntityCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_95);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // InternalDSL.g:5890:2: (otherlv_1= '#' ( (lv_attribute_2_0= ruleQualifiedName ) ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==84) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // InternalDSL.g:5890:4: otherlv_1= '#' ( (lv_attribute_2_0= ruleQualifiedName ) )
                    {
                    otherlv_1=(Token)match(input,84,FOLLOW_6); 

                        	newLeafNode(otherlv_1, grammarAccess.getVariableAccess().getNumberSignKeyword_1_0());
                        
                    // InternalDSL.g:5894:1: ( (lv_attribute_2_0= ruleQualifiedName ) )
                    // InternalDSL.g:5895:1: (lv_attribute_2_0= ruleQualifiedName )
                    {
                    // InternalDSL.g:5895:1: (lv_attribute_2_0= ruleQualifiedName )
                    // InternalDSL.g:5896:3: lv_attribute_2_0= ruleQualifiedName
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
    // InternalDSL.g:5920:1: entryRuleVariableVariable returns [EObject current=null] : iv_ruleVariableVariable= ruleVariableVariable EOF ;
    public final EObject entryRuleVariableVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableVariable = null;


        try {
            // InternalDSL.g:5921:2: (iv_ruleVariableVariable= ruleVariableVariable EOF )
            // InternalDSL.g:5922:2: iv_ruleVariableVariable= ruleVariableVariable EOF
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
    // InternalDSL.g:5929:1: ruleVariableVariable returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleVariableVariable() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5932:28: ( ( ( ruleQualifiedName ) ) )
            // InternalDSL.g:5933:1: ( ( ruleQualifiedName ) )
            {
            // InternalDSL.g:5933:1: ( ( ruleQualifiedName ) )
            // InternalDSL.g:5934:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:5934:1: ( ruleQualifiedName )
            // InternalDSL.g:5935:3: ruleQualifiedName
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
    // InternalDSL.g:5956:1: entryRuleConstant returns [EObject current=null] : iv_ruleConstant= ruleConstant EOF ;
    public final EObject entryRuleConstant() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstant = null;


        try {
            // InternalDSL.g:5957:2: (iv_ruleConstant= ruleConstant EOF )
            // InternalDSL.g:5958:2: iv_ruleConstant= ruleConstant EOF
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
    // InternalDSL.g:5965:1: ruleConstant returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleConstant() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalDSL.g:5968:28: ( ( ( ruleQualifiedName ) ) )
            // InternalDSL.g:5969:1: ( ( ruleQualifiedName ) )
            {
            // InternalDSL.g:5969:1: ( ( ruleQualifiedName ) )
            // InternalDSL.g:5970:1: ( ruleQualifiedName )
            {
            // InternalDSL.g:5970:1: ( ruleQualifiedName )
            // InternalDSL.g:5971:3: ruleQualifiedName
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
    // InternalDSL.g:5992:1: entryRuleNullValue returns [EObject current=null] : iv_ruleNullValue= ruleNullValue EOF ;
    public final EObject entryRuleNullValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullValue = null;


        try {
            // InternalDSL.g:5993:2: (iv_ruleNullValue= ruleNullValue EOF )
            // InternalDSL.g:5994:2: iv_ruleNullValue= ruleNullValue EOF
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
    // InternalDSL.g:6001:1: ruleNullValue returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:6004:28: ( ( () otherlv_1= 'null' ) )
            // InternalDSL.g:6005:1: ( () otherlv_1= 'null' )
            {
            // InternalDSL.g:6005:1: ( () otherlv_1= 'null' )
            // InternalDSL.g:6005:2: () otherlv_1= 'null'
            {
            // InternalDSL.g:6005:2: ()
            // InternalDSL.g:6006:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNullValueAccess().getNullAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,85,FOLLOW_2); 

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
    // InternalDSL.g:6023:1: entryRuleEnumValue returns [EObject current=null] : iv_ruleEnumValue= ruleEnumValue EOF ;
    public final EObject entryRuleEnumValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumValue = null;


        try {
            // InternalDSL.g:6024:2: (iv_ruleEnumValue= ruleEnumValue EOF )
            // InternalDSL.g:6025:2: iv_ruleEnumValue= ruleEnumValue EOF
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
    // InternalDSL.g:6032:1: ruleEnumValue returns [EObject current=null] : ( (otherlv_0= RULE_UPPERCASE_ID ) ) ;
    public final EObject ruleEnumValue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:6035:28: ( ( (otherlv_0= RULE_UPPERCASE_ID ) ) )
            // InternalDSL.g:6036:1: ( (otherlv_0= RULE_UPPERCASE_ID ) )
            {
            // InternalDSL.g:6036:1: ( (otherlv_0= RULE_UPPERCASE_ID ) )
            // InternalDSL.g:6037:1: (otherlv_0= RULE_UPPERCASE_ID )
            {
            // InternalDSL.g:6037:1: (otherlv_0= RULE_UPPERCASE_ID )
            // InternalDSL.g:6038:3: otherlv_0= RULE_UPPERCASE_ID
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
    // InternalDSL.g:6057:1: entryRuleNestedObject returns [EObject current=null] : iv_ruleNestedObject= ruleNestedObject EOF ;
    public final EObject entryRuleNestedObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedObject = null;


        try {
            // InternalDSL.g:6058:2: (iv_ruleNestedObject= ruleNestedObject EOF )
            // InternalDSL.g:6059:2: iv_ruleNestedObject= ruleNestedObject EOF
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
    // InternalDSL.g:6066:1: ruleNestedObject returns [EObject current=null] : (otherlv_0= '{' ruleNL ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+ otherlv_4= '}' ) ;
    public final EObject ruleNestedObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject lv_attributes_2_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:6069:28: ( (otherlv_0= '{' ruleNL ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+ otherlv_4= '}' ) )
            // InternalDSL.g:6070:1: (otherlv_0= '{' ruleNL ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+ otherlv_4= '}' )
            {
            // InternalDSL.g:6070:1: (otherlv_0= '{' ruleNL ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+ otherlv_4= '}' )
            // InternalDSL.g:6070:3: otherlv_0= '{' ruleNL ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+ otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,86,FOLLOW_96); 

                	newLeafNode(otherlv_0, grammarAccess.getNestedObjectAccess().getLeftCurlyBracketKeyword_0());
                
             
                    newCompositeNode(grammarAccess.getNestedObjectAccess().getNLParserRuleCall_1()); 
                
            pushFollow(FOLLOW_96);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:6082:1: ( ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL )+
            int cnt93=0;
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( ((LA93_0>=RULE_STRING && LA93_0<=RULE_ID)) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // InternalDSL.g:6082:2: ( (lv_attributes_2_0= ruleKeyValuePair ) ) ruleNL
            	    {
            	    // InternalDSL.g:6082:2: ( (lv_attributes_2_0= ruleKeyValuePair ) )
            	    // InternalDSL.g:6083:1: (lv_attributes_2_0= ruleKeyValuePair )
            	    {
            	    // InternalDSL.g:6083:1: (lv_attributes_2_0= ruleKeyValuePair )
            	    // InternalDSL.g:6084:3: lv_attributes_2_0= ruleKeyValuePair
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getNestedObjectAccess().getAttributesKeyValuePairParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_97);
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
            	        
            	    pushFollow(FOLLOW_97);
            	    ruleNL();

            	    state._fsp--;

            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt93 >= 1 ) break loop93;
                        EarlyExitException eee =
                            new EarlyExitException(93, input);
                        throw eee;
                }
                cnt93++;
            } while (true);

            otherlv_4=(Token)match(input,87,FOLLOW_2); 

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
    // InternalDSL.g:6120:1: entryRuleTypedNestedObject returns [EObject current=null] : iv_ruleTypedNestedObject= ruleTypedNestedObject EOF ;
    public final EObject entryRuleTypedNestedObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedNestedObject = null;


        try {
            // InternalDSL.g:6121:2: (iv_ruleTypedNestedObject= ruleTypedNestedObject EOF )
            // InternalDSL.g:6122:2: iv_ruleTypedNestedObject= ruleTypedNestedObject EOF
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
    // InternalDSL.g:6129:1: ruleTypedNestedObject returns [EObject current=null] : (otherlv_0= '<' ( (lv_type_1_0= ruleJavaClassReference ) ) otherlv_2= '>' ruleNL ( (lv_nestedObject_4_0= ruleNestedObject ) ) ) ;
    public final EObject ruleTypedNestedObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_type_1_0 = null;

        EObject lv_nestedObject_4_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:6132:28: ( (otherlv_0= '<' ( (lv_type_1_0= ruleJavaClassReference ) ) otherlv_2= '>' ruleNL ( (lv_nestedObject_4_0= ruleNestedObject ) ) ) )
            // InternalDSL.g:6133:1: (otherlv_0= '<' ( (lv_type_1_0= ruleJavaClassReference ) ) otherlv_2= '>' ruleNL ( (lv_nestedObject_4_0= ruleNestedObject ) ) )
            {
            // InternalDSL.g:6133:1: (otherlv_0= '<' ( (lv_type_1_0= ruleJavaClassReference ) ) otherlv_2= '>' ruleNL ( (lv_nestedObject_4_0= ruleNestedObject ) ) )
            // InternalDSL.g:6133:3: otherlv_0= '<' ( (lv_type_1_0= ruleJavaClassReference ) ) otherlv_2= '>' ruleNL ( (lv_nestedObject_4_0= ruleNestedObject ) )
            {
            otherlv_0=(Token)match(input,82,FOLLOW_6); 

                	newLeafNode(otherlv_0, grammarAccess.getTypedNestedObjectAccess().getLessThanSignKeyword_0());
                
            // InternalDSL.g:6137:1: ( (lv_type_1_0= ruleJavaClassReference ) )
            // InternalDSL.g:6138:1: (lv_type_1_0= ruleJavaClassReference )
            {
            // InternalDSL.g:6138:1: (lv_type_1_0= ruleJavaClassReference )
            // InternalDSL.g:6139:3: lv_type_1_0= ruleJavaClassReference
            {
             
            	        newCompositeNode(grammarAccess.getTypedNestedObjectAccess().getTypeJavaClassReferenceParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_94);
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

            otherlv_2=(Token)match(input,83,FOLLOW_98); 

                	newLeafNode(otherlv_2, grammarAccess.getTypedNestedObjectAccess().getGreaterThanSignKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getTypedNestedObjectAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_99);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:6167:1: ( (lv_nestedObject_4_0= ruleNestedObject ) )
            // InternalDSL.g:6168:1: (lv_nestedObject_4_0= ruleNestedObject )
            {
            // InternalDSL.g:6168:1: (lv_nestedObject_4_0= ruleNestedObject )
            // InternalDSL.g:6169:3: lv_nestedObject_4_0= ruleNestedObject
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
    // InternalDSL.g:6193:1: entryRuleKeyValuePair returns [EObject current=null] : iv_ruleKeyValuePair= ruleKeyValuePair EOF ;
    public final EObject entryRuleKeyValuePair() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyValuePair = null;


        try {
            // InternalDSL.g:6194:2: (iv_ruleKeyValuePair= ruleKeyValuePair EOF )
            // InternalDSL.g:6195:2: iv_ruleKeyValuePair= ruleKeyValuePair EOF
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
    // InternalDSL.g:6202:1: ruleKeyValuePair returns [EObject current=null] : ( ( ( (lv_identifier_0_0= RULE_ID ) ) | ( (lv_stringIdentifier_1_0= RULE_STRING ) ) ) ruleNL otherlv_3= ':' ruleNL ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ) ;
    public final EObject ruleKeyValuePair() throws RecognitionException {
        EObject current = null;

        Token lv_identifier_0_0=null;
        Token lv_stringIdentifier_1_0=null;
        Token otherlv_3=null;
        EObject lv_value_5_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:6205:28: ( ( ( ( (lv_identifier_0_0= RULE_ID ) ) | ( (lv_stringIdentifier_1_0= RULE_STRING ) ) ) ruleNL otherlv_3= ':' ruleNL ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) ) )
            // InternalDSL.g:6206:1: ( ( ( (lv_identifier_0_0= RULE_ID ) ) | ( (lv_stringIdentifier_1_0= RULE_STRING ) ) ) ruleNL otherlv_3= ':' ruleNL ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            {
            // InternalDSL.g:6206:1: ( ( ( (lv_identifier_0_0= RULE_ID ) ) | ( (lv_stringIdentifier_1_0= RULE_STRING ) ) ) ruleNL otherlv_3= ':' ruleNL ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) ) )
            // InternalDSL.g:6206:2: ( ( (lv_identifier_0_0= RULE_ID ) ) | ( (lv_stringIdentifier_1_0= RULE_STRING ) ) ) ruleNL otherlv_3= ':' ruleNL ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) )
            {
            // InternalDSL.g:6206:2: ( ( (lv_identifier_0_0= RULE_ID ) ) | ( (lv_stringIdentifier_1_0= RULE_STRING ) ) )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==RULE_ID) ) {
                alt94=1;
            }
            else if ( (LA94_0==RULE_STRING) ) {
                alt94=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }
            switch (alt94) {
                case 1 :
                    // InternalDSL.g:6206:3: ( (lv_identifier_0_0= RULE_ID ) )
                    {
                    // InternalDSL.g:6206:3: ( (lv_identifier_0_0= RULE_ID ) )
                    // InternalDSL.g:6207:1: (lv_identifier_0_0= RULE_ID )
                    {
                    // InternalDSL.g:6207:1: (lv_identifier_0_0= RULE_ID )
                    // InternalDSL.g:6208:3: lv_identifier_0_0= RULE_ID
                    {
                    lv_identifier_0_0=(Token)match(input,RULE_ID,FOLLOW_17); 

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
                    // InternalDSL.g:6225:6: ( (lv_stringIdentifier_1_0= RULE_STRING ) )
                    {
                    // InternalDSL.g:6225:6: ( (lv_stringIdentifier_1_0= RULE_STRING ) )
                    // InternalDSL.g:6226:1: (lv_stringIdentifier_1_0= RULE_STRING )
                    {
                    // InternalDSL.g:6226:1: (lv_stringIdentifier_1_0= RULE_STRING )
                    // InternalDSL.g:6227:3: lv_stringIdentifier_1_0= RULE_STRING
                    {
                    lv_stringIdentifier_1_0=(Token)match(input,RULE_STRING,FOLLOW_17); 

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
                
            pushFollow(FOLLOW_18);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            otherlv_3=(Token)match(input,37,FOLLOW_19); 

                	newLeafNode(otherlv_3, grammarAccess.getKeyValuePairAccess().getColonKeyword_2());
                
             
                    newCompositeNode(grammarAccess.getKeyValuePairAccess().getNLParserRuleCall_3()); 
                
            pushFollow(FOLLOW_19);
            ruleNL();

            state._fsp--;

             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:6263:1: ( (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection ) )
            // InternalDSL.g:6264:1: (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection )
            {
            // InternalDSL.g:6264:1: (lv_value_5_0= ruleValueOrEnumValueOrOperationCollection )
            // InternalDSL.g:6265:3: lv_value_5_0= ruleValueOrEnumValueOrOperationCollection
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
    // InternalDSL.g:6289:1: entryRuleJavaClassReference returns [EObject current=null] : iv_ruleJavaClassReference= ruleJavaClassReference EOF ;
    public final EObject entryRuleJavaClassReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaClassReference = null;


        try {
            // InternalDSL.g:6290:2: (iv_ruleJavaClassReference= ruleJavaClassReference EOF )
            // InternalDSL.g:6291:2: iv_ruleJavaClassReference= ruleJavaClassReference EOF
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
    // InternalDSL.g:6298:1: ruleJavaClassReference returns [EObject current=null] : ( ( ruleQualifiedJavaClassName ) ) ;
    public final EObject ruleJavaClassReference() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // InternalDSL.g:6301:28: ( ( ( ruleQualifiedJavaClassName ) ) )
            // InternalDSL.g:6302:1: ( ( ruleQualifiedJavaClassName ) )
            {
            // InternalDSL.g:6302:1: ( ( ruleQualifiedJavaClassName ) )
            // InternalDSL.g:6303:1: ( ruleQualifiedJavaClassName )
            {
            // InternalDSL.g:6303:1: ( ruleQualifiedJavaClassName )
            // InternalDSL.g:6304:3: ruleQualifiedJavaClassName
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
    // InternalDSL.g:6325:1: entryRuleMethodReference returns [EObject current=null] : iv_ruleMethodReference= ruleMethodReference EOF ;
    public final EObject entryRuleMethodReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMethodReference = null;


        try {
            // InternalDSL.g:6326:2: (iv_ruleMethodReference= ruleMethodReference EOF )
            // InternalDSL.g:6327:2: iv_ruleMethodReference= ruleMethodReference EOF
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
    // InternalDSL.g:6334:1: ruleMethodReference returns [EObject current=null] : ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleMethodReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:6337:28: ( ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) ) )
            // InternalDSL.g:6338:1: ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalDSL.g:6338:1: ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) ) )
            // InternalDSL.g:6338:2: ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_ID ) )
            {
            // InternalDSL.g:6338:2: ( ( ruleQualifiedJavaClassName ) )
            // InternalDSL.g:6339:1: ( ruleQualifiedJavaClassName )
            {
            // InternalDSL.g:6339:1: ( ruleQualifiedJavaClassName )
            // InternalDSL.g:6340:3: ruleQualifiedJavaClassName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getMethodReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getMethodReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_100);
            ruleQualifiedJavaClassName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,84,FOLLOW_101); 

                	newLeafNode(otherlv_1, grammarAccess.getMethodReferenceAccess().getNumberSignKeyword_1());
                
            // InternalDSL.g:6357:1: ( (otherlv_2= RULE_ID ) )
            // InternalDSL.g:6358:1: (otherlv_2= RULE_ID )
            {
            // InternalDSL.g:6358:1: (otherlv_2= RULE_ID )
            // InternalDSL.g:6359:3: otherlv_2= RULE_ID
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
    // InternalDSL.g:6378:1: entryRuleJavaConstantReference returns [EObject current=null] : iv_ruleJavaConstantReference= ruleJavaConstantReference EOF ;
    public final EObject entryRuleJavaConstantReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJavaConstantReference = null;


        try {
            // InternalDSL.g:6379:2: (iv_ruleJavaConstantReference= ruleJavaConstantReference EOF )
            // InternalDSL.g:6380:2: iv_ruleJavaConstantReference= ruleJavaConstantReference EOF
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
    // InternalDSL.g:6387:1: ruleJavaConstantReference returns [EObject current=null] : ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_UPPERCASE_ID ) ) ) ;
    public final EObject ruleJavaConstantReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:6390:28: ( ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_UPPERCASE_ID ) ) ) )
            // InternalDSL.g:6391:1: ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_UPPERCASE_ID ) ) )
            {
            // InternalDSL.g:6391:1: ( ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_UPPERCASE_ID ) ) )
            // InternalDSL.g:6391:2: ( ( ruleQualifiedJavaClassName ) ) otherlv_1= '#' ( (otherlv_2= RULE_UPPERCASE_ID ) )
            {
            // InternalDSL.g:6391:2: ( ( ruleQualifiedJavaClassName ) )
            // InternalDSL.g:6392:1: ( ruleQualifiedJavaClassName )
            {
            // InternalDSL.g:6392:1: ( ruleQualifiedJavaClassName )
            // InternalDSL.g:6393:3: ruleQualifiedJavaClassName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getJavaConstantReferenceRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getJavaConstantReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
            	    
            pushFollow(FOLLOW_100);
            ruleQualifiedJavaClassName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,84,FOLLOW_102); 

                	newLeafNode(otherlv_1, grammarAccess.getJavaConstantReferenceAccess().getNumberSignKeyword_1());
                
            // InternalDSL.g:6410:1: ( (otherlv_2= RULE_UPPERCASE_ID ) )
            // InternalDSL.g:6411:1: (otherlv_2= RULE_UPPERCASE_ID )
            {
            // InternalDSL.g:6411:1: (otherlv_2= RULE_UPPERCASE_ID )
            // InternalDSL.g:6412:3: otherlv_2= RULE_UPPERCASE_ID
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
    // InternalDSL.g:6431:1: entryRuleExecutionMultiplier returns [EObject current=null] : iv_ruleExecutionMultiplier= ruleExecutionMultiplier EOF ;
    public final EObject entryRuleExecutionMultiplier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExecutionMultiplier = null;


        try {
            // InternalDSL.g:6432:2: (iv_ruleExecutionMultiplier= ruleExecutionMultiplier EOF )
            // InternalDSL.g:6433:2: iv_ruleExecutionMultiplier= ruleExecutionMultiplier EOF
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
    // InternalDSL.g:6440:1: ruleExecutionMultiplier returns [EObject current=null] : ( ( (lv_count_0_0= ruleConstantValue ) ) otherlv_1= '*' ) ;
    public final EObject ruleExecutionMultiplier() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_count_0_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:6443:28: ( ( ( (lv_count_0_0= ruleConstantValue ) ) otherlv_1= '*' ) )
            // InternalDSL.g:6444:1: ( ( (lv_count_0_0= ruleConstantValue ) ) otherlv_1= '*' )
            {
            // InternalDSL.g:6444:1: ( ( (lv_count_0_0= ruleConstantValue ) ) otherlv_1= '*' )
            // InternalDSL.g:6444:2: ( (lv_count_0_0= ruleConstantValue ) ) otherlv_1= '*'
            {
            // InternalDSL.g:6444:2: ( (lv_count_0_0= ruleConstantValue ) )
            // InternalDSL.g:6445:1: (lv_count_0_0= ruleConstantValue )
            {
            // InternalDSL.g:6445:1: (lv_count_0_0= ruleConstantValue )
            // InternalDSL.g:6446:3: lv_count_0_0= ruleConstantValue
            {
             
            	        newCompositeNode(grammarAccess.getExecutionMultiplierAccess().getCountConstantValueParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_103);
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

            otherlv_1=(Token)match(input,75,FOLLOW_2); 

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
    // InternalDSL.g:6474:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalDSL.g:6475:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalDSL.g:6476:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalDSL.g:6483:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:6486:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalDSL.g:6487:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalDSL.g:6487:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalDSL.g:6487:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_104); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // InternalDSL.g:6494:1: (kw= '.' this_ID_2= RULE_ID )*
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==88) ) {
                    int LA95_2 = input.LA(2);

                    if ( (LA95_2==RULE_ID) ) {
                        alt95=1;
                    }


                }


                switch (alt95) {
            	case 1 :
            	    // InternalDSL.g:6495:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,88,FOLLOW_101); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_104); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop95;
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
    // InternalDSL.g:6515:1: entryRuleQualifiedJavaClassName returns [String current=null] : iv_ruleQualifiedJavaClassName= ruleQualifiedJavaClassName EOF ;
    public final String entryRuleQualifiedJavaClassName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedJavaClassName = null;


        try {
            // InternalDSL.g:6516:2: (iv_ruleQualifiedJavaClassName= ruleQualifiedJavaClassName EOF )
            // InternalDSL.g:6517:2: iv_ruleQualifiedJavaClassName= ruleQualifiedJavaClassName EOF
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
    // InternalDSL.g:6524:1: ruleQualifiedJavaClassName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedJavaClassName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_UPPERCASE_ID_2=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:6527:28: ( (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID ) )
            // InternalDSL.g:6528:1: (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID )
            {
            // InternalDSL.g:6528:1: (this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID )
            // InternalDSL.g:6529:5: this_QualifiedName_0= ruleQualifiedName kw= '.' this_UPPERCASE_ID_2= RULE_UPPERCASE_ID
            {
             
                    newCompositeNode(grammarAccess.getQualifiedJavaClassNameAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_105);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            kw=(Token)match(input,88,FOLLOW_102); 

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
    // InternalDSL.g:6560:1: entryRuleQualifiedNameWithWildcard returns [String current=null] : iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF ;
    public final String entryRuleQualifiedNameWithWildcard() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedNameWithWildcard = null;


        try {
            // InternalDSL.g:6561:2: (iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF )
            // InternalDSL.g:6562:2: iv_ruleQualifiedNameWithWildcard= ruleQualifiedNameWithWildcard EOF
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
    // InternalDSL.g:6569:1: ruleQualifiedNameWithWildcard returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedNameWithWildcard() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_QualifiedName_0 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:6572:28: ( (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? ) )
            // InternalDSL.g:6573:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            {
            // InternalDSL.g:6573:1: (this_QualifiedName_0= ruleQualifiedName (kw= '.*' )? )
            // InternalDSL.g:6574:5: this_QualifiedName_0= ruleQualifiedName (kw= '.*' )?
            {
             
                    newCompositeNode(grammarAccess.getQualifiedNameWithWildcardAccess().getQualifiedNameParserRuleCall_0()); 
                
            pushFollow(FOLLOW_106);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // InternalDSL.g:6584:1: (kw= '.*' )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==89) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalDSL.g:6585:2: kw= '.*'
                    {
                    kw=(Token)match(input,89,FOLLOW_2); 

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


    // $ANTLR start "entryRuleDocumentationComment"
    // InternalDSL.g:6598:1: entryRuleDocumentationComment returns [EObject current=null] : iv_ruleDocumentationComment= ruleDocumentationComment EOF ;
    public final EObject entryRuleDocumentationComment() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDocumentationComment = null;


        try {
            // InternalDSL.g:6599:2: (iv_ruleDocumentationComment= ruleDocumentationComment EOF )
            // InternalDSL.g:6600:2: iv_ruleDocumentationComment= ruleDocumentationComment EOF
            {
             newCompositeNode(grammarAccess.getDocumentationCommentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDocumentationComment=ruleDocumentationComment();

            state._fsp--;

             current =iv_ruleDocumentationComment; 
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
    // $ANTLR end "entryRuleDocumentationComment"


    // $ANTLR start "ruleDocumentationComment"
    // InternalDSL.g:6607:1: ruleDocumentationComment returns [EObject current=null] : ( ( (lv_content_0_0= RULE_ML_DOC_COMMENT ) ) ruleNL ) ;
    public final EObject ruleDocumentationComment() throws RecognitionException {
        EObject current = null;

        Token lv_content_0_0=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:6610:28: ( ( ( (lv_content_0_0= RULE_ML_DOC_COMMENT ) ) ruleNL ) )
            // InternalDSL.g:6611:1: ( ( (lv_content_0_0= RULE_ML_DOC_COMMENT ) ) ruleNL )
            {
            // InternalDSL.g:6611:1: ( ( (lv_content_0_0= RULE_ML_DOC_COMMENT ) ) ruleNL )
            // InternalDSL.g:6611:2: ( (lv_content_0_0= RULE_ML_DOC_COMMENT ) ) ruleNL
            {
            // InternalDSL.g:6611:2: ( (lv_content_0_0= RULE_ML_DOC_COMMENT ) )
            // InternalDSL.g:6612:1: (lv_content_0_0= RULE_ML_DOC_COMMENT )
            {
            // InternalDSL.g:6612:1: (lv_content_0_0= RULE_ML_DOC_COMMENT )
            // InternalDSL.g:6613:3: lv_content_0_0= RULE_ML_DOC_COMMENT
            {
            lv_content_0_0=(Token)match(input,RULE_ML_DOC_COMMENT,FOLLOW_4); 

            			newLeafNode(lv_content_0_0, grammarAccess.getDocumentationCommentAccess().getContentML_DOC_COMMENTTerminalRuleCall_0_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getDocumentationCommentRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"content",
                    		lv_content_0_0, 
                    		"de.gebit.integrity.DSL.ML_DOC_COMMENT");
            	    

            }


            }

             
                    newCompositeNode(grammarAccess.getDocumentationCommentAccess().getNLParserRuleCall_1()); 
                
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
    // $ANTLR end "ruleDocumentationComment"


    // $ANTLR start "entryRuleNL"
    // InternalDSL.g:6645:1: entryRuleNL returns [String current=null] : iv_ruleNL= ruleNL EOF ;
    public final String entryRuleNL() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNL = null;


        try {
            // InternalDSL.g:6646:2: (iv_ruleNL= ruleNL EOF )
            // InternalDSL.g:6647:2: iv_ruleNL= ruleNL EOF
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
    // InternalDSL.g:6654:1: ruleNL returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? )* ;
    public final AntlrDatatypeRuleToken ruleNL() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_NEWLINE_0=null;
        Token this_WS_1=null;

         enterRule(); 
            
        try {
            // InternalDSL.g:6657:28: ( (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? )* )
            // InternalDSL.g:6658:1: (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? )*
            {
            // InternalDSL.g:6658:1: (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? )*
            loop98:
            do {
                int alt98=2;
                int LA98_0 = input.LA(1);

                if ( (LA98_0==RULE_NEWLINE) ) {
                    alt98=1;
                }


                switch (alt98) {
            	case 1 :
            	    // InternalDSL.g:6658:6: this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )?
            	    {
            	    this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_107); 

            	    		current.merge(this_NEWLINE_0);
            	        
            	     
            	        newLeafNode(this_NEWLINE_0, grammarAccess.getNLAccess().getNEWLINETerminalRuleCall_0()); 
            	        
            	    // InternalDSL.g:6665:1: (this_WS_1= RULE_WS )?
            	    int alt97=2;
            	    int LA97_0 = input.LA(1);

            	    if ( (LA97_0==RULE_WS) ) {
            	        alt97=1;
            	    }
            	    switch (alt97) {
            	        case 1 :
            	            // InternalDSL.g:6665:6: this_WS_1= RULE_WS
            	            {
            	            this_WS_1=(Token)match(input,RULE_WS,FOLLOW_108); 

            	            		current.merge(this_WS_1);
            	                
            	             
            	                newLeafNode(this_WS_1, grammarAccess.getNLAccess().getWSTerminalRuleCall_1()); 
            	                

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop98;
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
    // InternalDSL.g:6680:1: entryRuleNLFORCED returns [String current=null] : iv_ruleNLFORCED= ruleNLFORCED EOF ;
    public final String entryRuleNLFORCED() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNLFORCED = null;


        try {
            // InternalDSL.g:6681:2: (iv_ruleNLFORCED= ruleNLFORCED EOF )
            // InternalDSL.g:6682:2: iv_ruleNLFORCED= ruleNLFORCED EOF
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
    // InternalDSL.g:6689:1: ruleNLFORCED returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? this_NL_2= ruleNL ) ;
    public final AntlrDatatypeRuleToken ruleNLFORCED() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_NEWLINE_0=null;
        Token this_WS_1=null;
        AntlrDatatypeRuleToken this_NL_2 = null;


         enterRule(); 
            
        try {
            // InternalDSL.g:6692:28: ( (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? this_NL_2= ruleNL ) )
            // InternalDSL.g:6693:1: (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? this_NL_2= ruleNL )
            {
            // InternalDSL.g:6693:1: (this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? this_NL_2= ruleNL )
            // InternalDSL.g:6693:6: this_NEWLINE_0= RULE_NEWLINE (this_WS_1= RULE_WS )? this_NL_2= ruleNL
            {
            this_NEWLINE_0=(Token)match(input,RULE_NEWLINE,FOLLOW_109); 

            		current.merge(this_NEWLINE_0);
                
             
                newLeafNode(this_NEWLINE_0, grammarAccess.getNLFORCEDAccess().getNEWLINETerminalRuleCall_0()); 
                
            // InternalDSL.g:6700:1: (this_WS_1= RULE_WS )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( (LA99_0==RULE_WS) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // InternalDSL.g:6700:6: this_WS_1= RULE_WS
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


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA8 dfa8 = new DFA8(this);
    protected DFA32 dfa32 = new DFA32(this);
    protected DFA44 dfa44 = new DFA44(this);
    protected DFA45 dfa45 = new DFA45(this);
    protected DFA46 dfa46 = new DFA46(this);
    protected DFA47 dfa47 = new DFA47(this);
    protected DFA51 dfa51 = new DFA51(this);
    protected DFA57 dfa57 = new DFA57(this);
    protected DFA58 dfa58 = new DFA58(this);
    protected DFA59 dfa59 = new DFA59(this);
    protected DFA60 dfa60 = new DFA60(this);
    protected DFA69 dfa69 = new DFA69(this);
    protected DFA70 dfa70 = new DFA70(this);
    protected DFA81 dfa81 = new DFA81(this);
    protected DFA82 dfa82 = new DFA82(this);
    protected DFA83 dfa83 = new DFA83(this);
    protected DFA85 dfa85 = new DFA85(this);
    protected DFA87 dfa87 = new DFA87(this);
    protected DFA91 dfa91 = new DFA91(this);
    static final String dfa_1s = "\10\uffff";
    static final String dfa_2s = "\1\26\1\uffff\1\27\3\uffff\2\27";
    static final String dfa_3s = "\1\46\1\uffff\1\46\3\uffff\2\46";
    static final String dfa_4s = "\1\uffff\1\1\1\uffff\1\2\1\3\1\4\2\uffff";
    static final String dfa_5s = "\10\uffff}>";
    static final String[] dfa_6s = {
            "\1\2\6\uffff\1\3\2\uffff\1\1\2\4\3\uffff\1\5",
            "",
            "\1\6\5\uffff\1\3\3\uffff\2\4\3\uffff\1\5",
            "",
            "",
            "",
            "\1\6\1\7\4\uffff\1\3\3\uffff\2\4\3\uffff\1\5",
            "\1\6\5\uffff\1\3\3\uffff\2\4\3\uffff\1\5"
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "133:1: (this_Import_0= ruleImport | this_PackageDefinition_1= rulePackageDefinition | this_ForkDefinition_2= ruleForkDefinition | this_VariantDefinition_3= ruleVariantDefinition )";
        }
    }
    static final String dfa_7s = "\17\uffff";
    static final String dfa_8s = "\1\26\1\uffff\1\27\1\42\10\uffff\1\27\1\42\1\27";
    static final String dfa_9s = "\1\65\1\uffff\2\65\10\uffff\3\65";
    static final String dfa_10s = "\1\uffff\1\1\2\uffff\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\3\uffff";
    static final String dfa_11s = "\17\uffff}>";
    static final String[] dfa_12s = {
            "\1\2\11\uffff\1\1\1\3\1\4\3\uffff\1\5\1\6\1\7\3\11\6\uffff\1\10\1\12\1\uffff\1\13",
            "",
            "\1\14\11\uffff\1\15\1\4\3\uffff\1\5\1\6\1\7\3\11\11\uffff\1\13",
            "\1\4\6\uffff\3\11\7\uffff\1\12\1\uffff\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\14\1\16\10\uffff\1\15\1\4\3\uffff\1\5\1\6\1\7\3\11\11\uffff\1\13",
            "\1\4\6\uffff\3\11\11\uffff\1\13",
            "\1\14\11\uffff\1\15\1\4\3\uffff\1\5\1\6\1\7\3\11\11\uffff\1\13"
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final char[] dfa_8 = DFA.unpackEncodedStringToUnsignedChars(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final short[] dfa_10 = DFA.unpackEncodedString(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[][] dfa_12 = unpackEncodedStringArray(dfa_12s);

    class DFA8 extends DFA {

        public DFA8(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 8;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_8;
            this.max = dfa_9;
            this.accept = dfa_10;
            this.special = dfa_11;
            this.transition = dfa_12;
        }
        public String getDescription() {
            return "659:1: (this_Import_0= ruleImport | this_ForkDefinition_1= ruleForkDefinition | this_VariantDefinition_2= ruleVariantDefinition | this_TestDefinition_3= ruleTestDefinition | this_CallDefinition_4= ruleCallDefinition | this_OperationDefinition_5= ruleOperationDefinition | this_SuiteDefinition_6= ruleSuiteDefinition | this_VariableDefinition_7= ruleVariableDefinition | this_ConstantDefinition_8= ruleConstantDefinition )";
        }
    }
    static final String dfa_13s = "\5\uffff";
    static final String dfa_14s = "\1\3\4\uffff";
    static final String dfa_15s = "\2\12\2\uffff\1\12";
    static final String dfa_16s = "\2\61\2\uffff\1\61";
    static final String dfa_17s = "\2\uffff\1\1\1\2\1\uffff";
    static final String dfa_18s = "\5\uffff}>";
    static final String[] dfa_19s = {
            "\1\3\14\uffff\1\1\6\uffff\1\3\16\uffff\3\3\1\uffff\1\2",
            "\1\3\14\uffff\1\1\1\4\5\uffff\1\3\16\uffff\3\3\1\uffff\1\2",
            "",
            "",
            "\1\3\14\uffff\1\1\6\uffff\1\3\16\uffff\3\3\1\uffff\1\2"
    };

    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA32 extends DFA {

        public DFA32(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 32;
            this.eot = dfa_13;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "1760:2: ( ruleNL otherlv_2= 'by default' ( (lv_default_3_0= ruleValueOrEnumValueOrOperationCollection ) ) )?";
        }
    }
    static final String dfa_20s = "\13\uffff";
    static final String dfa_21s = "\2\4\3\uffff\1\4\5\uffff";
    static final String dfa_22s = "\2\4\1\27\1\11\1\uffff\1\4\1\27\1\uffff\3\27";
    static final String dfa_23s = "\2\110\1\74\1\12\1\uffff\1\110\1\74\1\uffff\3\74";
    static final String dfa_24s = "\4\uffff\1\2\2\uffff\1\1\3\uffff";
    static final String dfa_25s = "\13\uffff}>";
    static final String[] dfa_26s = {
            "\5\4\1\uffff\1\2\13\uffff\1\4\1\1\11\uffff\1\4\10\uffff\1\4\5\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\4\2\uffff\4\4\1\uffff\2\4\6\uffff\1\4\1\3",
            "\5\4\1\uffff\1\2\13\uffff\1\4\1\1\1\5\10\uffff\1\4\10\uffff\1\4\5\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\4\2\uffff\4\4\1\uffff\2\4\6\uffff\1\4\1\3",
            "\1\6\15\uffff\1\7\26\uffff\1\4",
            "\1\11\1\10",
            "",
            "\5\4\1\uffff\1\2\13\uffff\1\4\1\1\11\uffff\1\4\10\uffff\1\4\5\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\4\2\uffff\4\4\1\uffff\2\4\6\uffff\1\4\1\3",
            "\1\6\1\12\14\uffff\1\7\26\uffff\1\4",
            "",
            "\1\6\15\uffff\1\7\26\uffff\1\4",
            "\1\6\15\uffff\1\7\26\uffff\1\4",
            "\1\6\15\uffff\1\7\26\uffff\1\4"
    };

    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final short[] dfa_21 = DFA.unpackEncodedString(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final char[] dfa_23 = DFA.unpackEncodedStringToUnsignedChars(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[] dfa_25 = DFA.unpackEncodedString(dfa_25s);
    static final short[][] dfa_26 = unpackEncodedStringArray(dfa_26s);

    class DFA44 extends DFA {

        public DFA44(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 44;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_23;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_26;
        }
        public String getDescription() {
            return "()* loopback of 2681:2: ( ruleNL ( (lv_parameters_5_0= ruleParameter ) ) )*";
        }
    }
    static final String dfa_27s = "\2\2\2\uffff\1\2";
    static final String dfa_28s = "\2\4\2\uffff\1\4";
    static final String dfa_29s = "\2\110\2\uffff\1\110";
    static final String dfa_30s = "\2\uffff\1\2\1\1\1\uffff";
    static final String[] dfa_31s = {
            "\5\2\1\uffff\1\3\13\uffff\1\2\1\1\11\uffff\1\2\10\uffff\1\2\5\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\1\2\2\uffff\4\2\1\uffff\2\2\6\uffff\1\2\1\3",
            "\5\2\1\uffff\1\3\13\uffff\1\2\1\1\1\4\10\uffff\1\2\10\uffff\1\2\5\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\1\2\2\uffff\4\2\1\uffff\2\2\6\uffff\1\2\1\3",
            "",
            "",
            "\5\2\1\uffff\1\3\13\uffff\1\2\1\1\11\uffff\1\2\10\uffff\1\2\5\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\1\2\2\uffff\4\2\1\uffff\2\2\6\uffff\1\2\1\3"
    };
    static final short[] dfa_27 = DFA.unpackEncodedString(dfa_27s);
    static final char[] dfa_28 = DFA.unpackEncodedStringToUnsignedChars(dfa_28s);
    static final char[] dfa_29 = DFA.unpackEncodedStringToUnsignedChars(dfa_29s);
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final short[][] dfa_31 = unpackEncodedStringArray(dfa_31s);

    class DFA45 extends DFA {

        public DFA45(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 45;
            this.eot = dfa_13;
            this.eof = dfa_27;
            this.min = dfa_28;
            this.max = dfa_29;
            this.accept = dfa_30;
            this.special = dfa_18;
            this.transition = dfa_31;
        }
        public String getDescription() {
            return "()* loopback of 2707:4: ( ruleNL ( (lv_results_7_0= ruleNamedResult ) ) )*";
        }
    }
    static final String dfa_32s = "\2\3\2\uffff\1\3";
    static final String dfa_33s = "\2\107\2\uffff\1\107";
    static final String[] dfa_34s = {
            "\5\3\15\uffff\1\3\1\1\11\uffff\1\3\10\uffff\1\3\5\uffff\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\3\2\uffff\2\3\1\2\1\3\1\uffff\2\3\6\uffff\1\3",
            "\5\3\15\uffff\1\3\1\1\1\4\10\uffff\1\3\10\uffff\1\3\5\uffff\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\3\2\uffff\2\3\1\2\1\3\1\uffff\2\3\6\uffff\1\3",
            "",
            "",
            "\5\3\15\uffff\1\3\1\1\11\uffff\1\3\10\uffff\1\3\5\uffff\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\3\2\uffff\2\3\1\2\1\3\1\uffff\2\3\6\uffff\1\3"
    };
    static final short[] dfa_32 = DFA.unpackEncodedString(dfa_32s);
    static final char[] dfa_33 = DFA.unpackEncodedStringToUnsignedChars(dfa_33s);
    static final short[][] dfa_34 = unpackEncodedStringArray(dfa_34s);

    class DFA46 extends DFA {

        public DFA46(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 46;
            this.eot = dfa_13;
            this.eof = dfa_32;
            this.min = dfa_28;
            this.max = dfa_33;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_34;
        }
        public String getDescription() {
            return "2733:4: ( ruleNL otherlv_9= '=' ruleNL ( (lv_result_11_0= ruleValueOrEnumValueOrOperationCollection ) ) )?";
        }
    }
    static final String dfa_35s = "\7\uffff";
    static final String dfa_36s = "\2\12\1\uffff\2\12\1\uffff\1\12";
    static final String dfa_37s = "\2\110\1\uffff\2\110\1\uffff\1\110";
    static final String dfa_38s = "\2\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String dfa_39s = "\7\uffff}>";
    static final String[] dfa_40s = {
            "\1\2\14\uffff\1\1\60\uffff\1\2",
            "\1\2\14\uffff\1\4\1\3\45\uffff\1\5\11\uffff\1\2",
            "",
            "\1\2\14\uffff\1\4\46\uffff\1\5\11\uffff\1\2",
            "\1\2\14\uffff\1\4\1\6\45\uffff\1\5\11\uffff\1\2",
            "",
            "\1\2\14\uffff\1\4\46\uffff\1\5\11\uffff\1\2"
    };

    static final short[] dfa_35 = DFA.unpackEncodedString(dfa_35s);
    static final char[] dfa_36 = DFA.unpackEncodedStringToUnsignedChars(dfa_36s);
    static final char[] dfa_37 = DFA.unpackEncodedStringToUnsignedChars(dfa_37s);
    static final short[] dfa_38 = DFA.unpackEncodedString(dfa_38s);
    static final short[] dfa_39 = DFA.unpackEncodedString(dfa_39s);
    static final short[][] dfa_40 = unpackEncodedStringArray(dfa_40s);

    class DFA47 extends DFA {

        public DFA47(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 47;
            this.eot = dfa_35;
            this.eof = dfa_35;
            this.min = dfa_36;
            this.max = dfa_37;
            this.accept = dfa_38;
            this.special = dfa_39;
            this.transition = dfa_40;
        }
        public String getDescription() {
            return "()* loopback of 2827:2: ( ruleNL ( (lv_parameters_4_0= ruleParameter ) ) )*";
        }
    }
    static final String dfa_41s = "\1\uffff\3\5\2\uffff\1\5";
    static final String dfa_42s = "\1\27\3\4\2\uffff\1\4";
    static final String dfa_43s = "\1\27\3\107\2\uffff\1\107";
    static final String dfa_44s = "\4\uffff\1\1\1\2\1\uffff";
    static final String[] dfa_45s = {
            "\1\1",
            "\5\5\15\uffff\1\5\1\3\1\2\10\uffff\1\5\10\uffff\1\5\5\uffff\1\5\2\uffff\1\5\1\uffff\1\5\1\uffff\1\5\2\uffff\2\5\1\uffff\1\5\1\4\2\5\6\uffff\1\5",
            "\5\5\15\uffff\1\5\1\3\11\uffff\1\5\10\uffff\1\5\5\uffff\1\5\2\uffff\1\5\1\uffff\1\5\1\uffff\1\5\2\uffff\2\5\1\uffff\1\5\1\4\2\5\6\uffff\1\5",
            "\5\5\15\uffff\1\5\1\3\1\6\10\uffff\1\5\10\uffff\1\5\5\uffff\1\5\2\uffff\1\5\1\uffff\1\5\1\uffff\1\5\2\uffff\2\5\1\uffff\1\5\1\4\2\5\6\uffff\1\5",
            "",
            "",
            "\5\5\15\uffff\1\5\1\3\11\uffff\1\5\10\uffff\1\5\5\uffff\1\5\2\uffff\1\5\1\uffff\1\5\1\uffff\1\5\2\uffff\2\5\1\uffff\1\5\1\4\2\5\6\uffff\1\5"
    };
    static final short[] dfa_41 = DFA.unpackEncodedString(dfa_41s);
    static final char[] dfa_42 = DFA.unpackEncodedStringToUnsignedChars(dfa_42s);
    static final char[] dfa_43 = DFA.unpackEncodedStringToUnsignedChars(dfa_43s);
    static final short[] dfa_44 = DFA.unpackEncodedString(dfa_44s);
    static final short[][] dfa_45 = unpackEncodedStringArray(dfa_45s);

    class DFA51 extends DFA {

        public DFA51(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 51;
            this.eot = dfa_35;
            this.eof = dfa_41;
            this.min = dfa_42;
            this.max = dfa_43;
            this.accept = dfa_44;
            this.special = dfa_39;
            this.transition = dfa_45;
        }
        public String getDescription() {
            return "()+ loopback of 2920:3: ( ruleNLFORCED ( (lv_rows_12_0= ruleTableTestRow ) ) )+";
        }
    }
    static final String dfa_46s = "\6\uffff";
    static final String dfa_47s = "\2\uffff\1\4\2\uffff\1\4";
    static final String dfa_48s = "\1\11\1\uffff\1\4\1\12\1\uffff\1\4";
    static final String dfa_49s = "\1\125\1\uffff\1\130\1\12\1\uffff\1\130";
    static final String dfa_50s = "\1\uffff\1\1\2\uffff\1\2\1\uffff";
    static final String dfa_51s = "\6\uffff}>";
    static final String[] dfa_52s = {
            "\1\1\1\2\12\1\75\uffff\1\1\2\uffff\1\1",
            "",
            "\5\4\1\uffff\1\4\13\uffff\2\4\11\uffff\1\4\10\uffff\1\4\5\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\2\4\1\uffff\2\4\1\uffff\1\4\1\uffff\2\4\6\uffff\2\4\2\uffff\1\1\14\uffff\1\3",
            "\1\5",
            "",
            "\5\4\1\uffff\1\4\13\uffff\2\4\11\uffff\1\4\10\uffff\1\4\5\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\2\4\1\uffff\2\4\1\uffff\1\4\1\uffff\2\4\6\uffff\2\4\2\uffff\1\1\14\uffff\1\3"
    };

    static final short[] dfa_46 = DFA.unpackEncodedString(dfa_46s);
    static final short[] dfa_47 = DFA.unpackEncodedString(dfa_47s);
    static final char[] dfa_48 = DFA.unpackEncodedStringToUnsignedChars(dfa_48s);
    static final char[] dfa_49 = DFA.unpackEncodedStringToUnsignedChars(dfa_49s);
    static final short[] dfa_50 = DFA.unpackEncodedString(dfa_50s);
    static final short[] dfa_51 = DFA.unpackEncodedString(dfa_51s);
    static final short[][] dfa_52 = unpackEncodedStringArray(dfa_52s);

    class DFA57 extends DFA {

        public DFA57(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 57;
            this.eot = dfa_46;
            this.eof = dfa_47;
            this.min = dfa_48;
            this.max = dfa_49;
            this.accept = dfa_50;
            this.special = dfa_51;
            this.transition = dfa_52;
        }
        public String getDescription() {
            return "3328:1: ( ( (lv_multiplier_2_0= ruleExecutionMultiplier ) ) ruleNL )?";
        }
    }
    static final String dfa_53s = "\2\110\1\70\1\12\1\uffff\1\110\1\70\1\uffff\3\70";
    static final String[] dfa_54s = {
            "\5\4\1\uffff\1\2\13\uffff\1\4\1\1\11\uffff\1\4\10\uffff\1\4\5\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\2\4\1\uffff\2\4\1\uffff\1\4\1\uffff\2\4\6\uffff\1\4\1\3",
            "\5\4\1\uffff\1\2\13\uffff\1\4\1\1\1\5\10\uffff\1\4\10\uffff\1\4\5\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\2\4\1\uffff\2\4\1\uffff\1\4\1\uffff\2\4\6\uffff\1\4\1\3",
            "\1\6\15\uffff\1\7\22\uffff\1\4",
            "\1\11\1\10",
            "",
            "\5\4\1\uffff\1\2\13\uffff\1\4\1\1\11\uffff\1\4\10\uffff\1\4\5\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\2\4\1\uffff\2\4\1\uffff\1\4\1\uffff\2\4\6\uffff\1\4\1\3",
            "\1\6\1\12\14\uffff\1\7\22\uffff\1\4",
            "",
            "\1\6\15\uffff\1\7\22\uffff\1\4",
            "\1\6\15\uffff\1\7\22\uffff\1\4",
            "\1\6\15\uffff\1\7\22\uffff\1\4"
    };
    static final char[] dfa_53 = DFA.unpackEncodedStringToUnsignedChars(dfa_53s);
    static final short[][] dfa_54 = unpackEncodedStringArray(dfa_54s);

    class DFA58 extends DFA {

        public DFA58(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 58;
            this.eot = dfa_20;
            this.eof = dfa_21;
            this.min = dfa_22;
            this.max = dfa_53;
            this.accept = dfa_24;
            this.special = dfa_25;
            this.transition = dfa_54;
        }
        public String getDescription() {
            return "()* loopback of 3369:2: ( ruleNL ( (lv_parameters_6_0= ruleParameter ) ) )*";
        }
    }
    static final String[] dfa_55s = {
            "\5\2\1\uffff\1\3\13\uffff\1\2\1\1\11\uffff\1\2\10\uffff\1\2\5\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\2\2\1\uffff\2\2\1\uffff\1\2\1\uffff\2\2\6\uffff\1\2\1\3",
            "\5\2\1\uffff\1\3\13\uffff\1\2\1\1\1\4\10\uffff\1\2\10\uffff\1\2\5\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\2\2\1\uffff\2\2\1\uffff\1\2\1\uffff\2\2\6\uffff\1\2\1\3",
            "",
            "",
            "\5\2\1\uffff\1\3\13\uffff\1\2\1\1\11\uffff\1\2\10\uffff\1\2\5\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\2\2\1\uffff\2\2\1\uffff\1\2\1\uffff\2\2\6\uffff\1\2\1\3"
    };
    static final short[][] dfa_55 = unpackEncodedStringArray(dfa_55s);

    class DFA59 extends DFA {

        public DFA59(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 59;
            this.eot = dfa_13;
            this.eof = dfa_27;
            this.min = dfa_28;
            this.max = dfa_29;
            this.accept = dfa_30;
            this.special = dfa_18;
            this.transition = dfa_55;
        }
        public String getDescription() {
            return "()* loopback of 3395:4: ( ruleNL ( (lv_results_8_0= ruleNamedCallResult ) ) )*";
        }
    }
    static final String[] dfa_56s = {
            "\5\3\15\uffff\1\3\1\1\11\uffff\1\3\10\uffff\1\3\5\uffff\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\3\1\2\1\uffff\2\3\1\uffff\1\3\1\uffff\2\3\6\uffff\1\3",
            "\5\3\15\uffff\1\3\1\1\1\4\10\uffff\1\3\10\uffff\1\3\5\uffff\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\3\1\2\1\uffff\2\3\1\uffff\1\3\1\uffff\2\3\6\uffff\1\3",
            "",
            "",
            "\5\3\15\uffff\1\3\1\1\11\uffff\1\3\10\uffff\1\3\5\uffff\1\3\2\uffff\1\3\1\uffff\1\3\1\uffff\1\3\1\2\1\uffff\2\3\1\uffff\1\3\1\uffff\2\3\6\uffff\1\3"
    };
    static final short[][] dfa_56 = unpackEncodedStringArray(dfa_56s);

    class DFA60 extends DFA {

        public DFA60(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 60;
            this.eot = dfa_13;
            this.eof = dfa_32;
            this.min = dfa_28;
            this.max = dfa_33;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_56;
        }
        public String getDescription() {
            return "3421:4: ( ruleNL otherlv_10= '->' ruleNL ( (lv_result_12_0= ruleVariableVariable ) ) )?";
        }
    }
    static final String[] dfa_57s = {
            "\1\1\1\2\12\1\75\uffff\1\1\2\uffff\1\1",
            "",
            "\5\4\1\uffff\1\4\13\uffff\2\4\11\uffff\1\4\10\uffff\1\4\5\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\4\1\uffff\3\4\1\uffff\1\4\1\uffff\2\4\3\uffff\1\4\2\uffff\1\4\3\uffff\1\1\14\uffff\1\3",
            "\1\5",
            "",
            "\5\4\1\uffff\1\4\13\uffff\2\4\11\uffff\1\4\10\uffff\1\4\5\uffff\1\4\2\uffff\1\4\1\uffff\1\4\1\uffff\1\4\1\uffff\3\4\1\uffff\1\4\1\uffff\2\4\3\uffff\1\4\2\uffff\1\4\3\uffff\1\1\14\uffff\1\3"
    };
    static final short[][] dfa_57 = unpackEncodedStringArray(dfa_57s);

    class DFA69 extends DFA {

        public DFA69(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 69;
            this.eot = dfa_46;
            this.eof = dfa_47;
            this.min = dfa_48;
            this.max = dfa_49;
            this.accept = dfa_50;
            this.special = dfa_51;
            this.transition = dfa_57;
        }
        public String getDescription() {
            return "3783:1: ( ( (lv_multiplier_3_0= ruleExecutionMultiplier ) ) ruleNL )?";
        }
    }
    static final String dfa_58s = "\1\2\7\uffff";
    static final String dfa_59s = "\1\4\1\27\1\uffff\1\12\1\27\1\uffff\2\27";
    static final String dfa_60s = "\1\107\1\130\1\uffff\1\12\1\70\1\uffff\1\130\1\70";
    static final String dfa_61s = "\2\uffff\1\2\2\uffff\1\1\2\uffff";
    static final String[] dfa_62s = {
            "\5\2\1\uffff\1\1\13\uffff\1\2\12\uffff\1\2\10\uffff\1\2\5\uffff\1\2\2\uffff\1\2\1\uffff\1\2\1\uffff\1\2\1\uffff\3\2\1\uffff\1\2\1\uffff\2\2\3\uffff\1\2\2\uffff\1\2",
            "\1\4\15\uffff\1\5\22\uffff\1\2\37\uffff\1\3",
            "",
            "\1\6",
            "\1\4\1\7\14\uffff\1\5\22\uffff\1\2",
            "",
            "\1\4\15\uffff\1\5\22\uffff\1\2\37\uffff\1\3",
            "\1\4\15\uffff\1\5\22\uffff\1\2"
    };
    static final short[] dfa_58 = DFA.unpackEncodedString(dfa_58s);
    static final char[] dfa_59 = DFA.unpackEncodedStringToUnsignedChars(dfa_59s);
    static final char[] dfa_60 = DFA.unpackEncodedStringToUnsignedChars(dfa_60s);
    static final short[] dfa_61 = DFA.unpackEncodedString(dfa_61s);
    static final short[][] dfa_62 = unpackEncodedStringArray(dfa_62s);

    class DFA70 extends DFA {

        public DFA70(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 70;
            this.eot = dfa_1;
            this.eof = dfa_58;
            this.min = dfa_59;
            this.max = dfa_60;
            this.accept = dfa_61;
            this.special = dfa_5;
            this.transition = dfa_62;
        }
        public String getDescription() {
            return "()* loopback of 3832:1: ( ( (lv_parameters_7_0= ruleSuiteParameter ) ) ruleNL )*";
        }
    }
    static final String dfa_63s = "\1\11\1\uffff\3\12\1\uffff\2\12";
    static final String dfa_64s = "\1\126\1\uffff\1\130\1\12\1\121\1\uffff\1\130\1\121";
    static final String dfa_65s = "\1\uffff\1\1\3\uffff\1\2\2\uffff";
    static final String[] dfa_66s = {
            "\1\1\1\2\13\1\63\uffff\1\1\6\uffff\1\1\1\uffff\1\1\2\uffff\2\1",
            "",
            "\1\1\14\uffff\1\4\6\uffff\1\5\47\uffff\1\1\12\uffff\1\5\2\uffff\1\1\3\uffff\1\3",
            "\1\6",
            "\1\1\14\uffff\1\4\1\7\5\uffff\1\5\47\uffff\1\1\12\uffff\1\5",
            "",
            "\1\1\14\uffff\1\4\6\uffff\1\5\47\uffff\1\1\12\uffff\1\5\2\uffff\1\1\3\uffff\1\3",
            "\1\1\14\uffff\1\4\6\uffff\1\5\47\uffff\1\1\12\uffff\1\5"
    };
    static final char[] dfa_63 = DFA.unpackEncodedStringToUnsignedChars(dfa_63s);
    static final char[] dfa_64 = DFA.unpackEncodedStringToUnsignedChars(dfa_64s);
    static final short[] dfa_65 = DFA.unpackEncodedString(dfa_65s);
    static final short[][] dfa_66 = unpackEncodedStringArray(dfa_66s);

    class DFA81 extends DFA {

        public DFA81(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 81;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_63;
            this.max = dfa_64;
            this.accept = dfa_65;
            this.special = dfa_5;
            this.transition = dfa_66;
        }
        public String getDescription() {
            return "4567:1: ( ( (lv_prefixOperand_2_0= ruleValueOrEnumValueOrOperationCollection ) ) ruleNL )?";
        }
    }
    static final String dfa_67s = "\2\27\2\uffff\1\27";
    static final String dfa_68s = "\2\121\2\uffff\1\121";
    static final String[] dfa_69s = {
            "\1\1\6\uffff\1\2\62\uffff\1\3",
            "\1\1\1\4\5\uffff\1\2\62\uffff\1\3",
            "",
            "",
            "\1\1\6\uffff\1\2\62\uffff\1\3"
    };
    static final char[] dfa_67 = DFA.unpackEncodedStringToUnsignedChars(dfa_67s);
    static final char[] dfa_68 = DFA.unpackEncodedStringToUnsignedChars(dfa_68s);
    static final short[][] dfa_69 = unpackEncodedStringArray(dfa_69s);

    class DFA82 extends DFA {

        public DFA82(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 82;
            this.eot = dfa_13;
            this.eof = dfa_13;
            this.min = dfa_67;
            this.max = dfa_68;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_69;
        }
        public String getDescription() {
            return "4608:2: ( ruleNL otherlv_6= 'with' ( (lv_postfixOperand_7_0= ruleValueOrEnumValueOrOperationCollection ) ) )?";
        }
    }
    static final String dfa_70s = "\2\2\2\uffff\3\2";
    static final String dfa_71s = "\2\4\2\uffff\3\4";
    static final String dfa_72s = "\2\127\2\uffff\3\127";
    static final String dfa_73s = "\2\uffff\1\2\1\1\3\uffff";
    static final String[] dfa_74s = {
            "\7\2\13\uffff\1\2\1\1\6\uffff\5\2\3\uffff\6\2\1\uffff\4\2\1\uffff\2\2\1\uffff\14\2\3\uffff\1\2\1\uffff\1\3\2\2\10\uffff\1\2\5\uffff\1\2",
            "\7\2\13\uffff\1\2\1\5\1\4\5\uffff\5\2\3\uffff\6\2\1\uffff\4\2\1\uffff\2\2\1\uffff\14\2\3\uffff\1\2\1\uffff\1\3\2\2\10\uffff\1\2\5\uffff\1\2",
            "",
            "",
            "\7\2\13\uffff\1\2\1\5\6\uffff\5\2\3\uffff\6\2\1\uffff\4\2\1\uffff\2\2\1\uffff\14\2\3\uffff\1\2\1\uffff\1\3\2\2\10\uffff\1\2\5\uffff\1\2",
            "\7\2\13\uffff\1\2\1\5\1\6\5\uffff\5\2\3\uffff\6\2\1\uffff\4\2\1\uffff\2\2\1\uffff\14\2\3\uffff\1\2\1\uffff\1\3\2\2\10\uffff\1\2\5\uffff\1\2",
            "\7\2\13\uffff\1\2\1\5\6\uffff\5\2\3\uffff\6\2\1\uffff\4\2\1\uffff\2\2\1\uffff\14\2\3\uffff\1\2\1\uffff\1\3\2\2\10\uffff\1\2\5\uffff\1\2"
    };
    static final short[] dfa_70 = DFA.unpackEncodedString(dfa_70s);
    static final char[] dfa_71 = DFA.unpackEncodedStringToUnsignedChars(dfa_71s);
    static final char[] dfa_72 = DFA.unpackEncodedStringToUnsignedChars(dfa_72s);
    static final short[] dfa_73 = DFA.unpackEncodedString(dfa_73s);
    static final short[][] dfa_74 = unpackEncodedStringArray(dfa_74s);

    class DFA83 extends DFA {

        public DFA83(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 83;
            this.eot = dfa_35;
            this.eof = dfa_70;
            this.min = dfa_71;
            this.max = dfa_72;
            this.accept = dfa_73;
            this.special = dfa_39;
            this.transition = dfa_74;
        }
        public String getDescription() {
            return "()* loopback of 4689:2: ( ruleNL otherlv_2= ',' ruleNL ( (lv_moreValues_4_0= ruleValueOrEnumValueOrOperation ) ) )*";
        }
    }
    static final String dfa_75s = "\12\uffff";
    static final String dfa_76s = "\1\11\1\uffff\1\12\2\uffff\1\130\1\12\1\123\1\130\1\uffff";
    static final String dfa_77s = "\1\126\1\uffff\1\12\2\uffff\1\130\1\25\1\124\1\130\1\uffff";
    static final String dfa_78s = "\1\uffff\1\1\1\uffff\1\2\1\3\4\uffff\1\4";
    static final String dfa_79s = "\12\uffff}>";
    static final String[] dfa_80s = {
            "\1\1\1\3\12\1\75\uffff\1\2\2\uffff\1\1\1\4",
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

    static final short[] dfa_75 = DFA.unpackEncodedString(dfa_75s);
    static final char[] dfa_76 = DFA.unpackEncodedStringToUnsignedChars(dfa_76s);
    static final char[] dfa_77 = DFA.unpackEncodedStringToUnsignedChars(dfa_77s);
    static final short[] dfa_78 = DFA.unpackEncodedString(dfa_78s);
    static final short[] dfa_79 = DFA.unpackEncodedString(dfa_79s);
    static final short[][] dfa_80 = unpackEncodedStringArray(dfa_80s);

    class DFA85 extends DFA {

        public DFA85(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 85;
            this.eot = dfa_75;
            this.eof = dfa_75;
            this.min = dfa_76;
            this.max = dfa_77;
            this.accept = dfa_78;
            this.special = dfa_79;
            this.transition = dfa_80;
        }
        public String getDescription() {
            return "4798:1: (this_StaticValue_0= ruleStaticValue | this_Variable_1= ruleVariable | this_NestedObject_2= ruleNestedObject | this_TypedNestedObject_3= ruleTypedNestedObject )";
        }
    }
    static final String dfa_81s = "\25\uffff";
    static final String dfa_82s = "\5\uffff\3\13\5\uffff\10\13";
    static final String dfa_83s = "\1\11\4\uffff\3\4\5\uffff\10\4";
    static final String dfa_84s = "\1\125\4\uffff\3\127\5\uffff\10\127";
    static final String dfa_85s = "\1\uffff\1\1\1\2\1\3\1\4\3\uffff\1\6\1\10\1\11\1\5\1\7\10\uffff";
    static final String dfa_86s = "\25\uffff}>";
    static final String[] dfa_87s = {
            "\1\1\1\uffff\1\2\1\3\2\4\1\5\1\6\1\7\3\10\75\uffff\1\12\2\uffff\1\11",
            "",
            "",
            "",
            "",
            "\7\13\7\uffff\1\14\3\uffff\2\13\5\uffff\6\13\3\uffff\6\13\1\uffff\4\13\1\uffff\2\13\1\uffff\14\13\1\uffff\3\13\1\uffff\3\13\1\uffff\6\13\1\uffff\1\13\5\uffff\1\13",
            "\7\13\10\uffff\2\14\1\uffff\1\13\1\15\5\uffff\6\13\3\uffff\6\13\1\uffff\4\13\1\uffff\2\13\1\uffff\14\13\1\uffff\3\13\1\uffff\3\13\1\uffff\6\13\1\uffff\1\13\5\uffff\1\13",
            "\7\13\11\uffff\1\14\1\uffff\1\13\1\16\5\uffff\6\13\3\uffff\6\13\1\uffff\4\13\1\uffff\2\13\1\uffff\14\13\1\uffff\3\13\1\uffff\3\13\1\uffff\6\13\1\uffff\1\13\5\uffff\1\13",
            "",
            "",
            "",
            "",
            "",
            "\7\13\10\uffff\2\14\1\uffff\1\13\1\20\1\17\4\uffff\6\13\3\uffff\6\13\1\uffff\4\13\1\uffff\2\13\1\uffff\14\13\1\uffff\1\13\1\uffff\1\13\1\uffff\3\13\1\uffff\6\13\1\uffff\1\13\5\uffff\1\13",
            "\7\13\11\uffff\1\14\1\uffff\1\13\1\22\1\21\4\uffff\6\13\3\uffff\6\13\1\uffff\4\13\1\uffff\2\13\1\uffff\14\13\1\uffff\1\13\1\uffff\1\13\1\uffff\3\13\1\uffff\6\13\1\uffff\1\13\5\uffff\1\13",
            "\7\13\10\uffff\2\14\1\uffff\1\13\1\20\5\uffff\6\13\3\uffff\6\13\1\uffff\4\13\1\uffff\2\13\1\uffff\14\13\1\uffff\1\13\1\uffff\1\13\1\uffff\3\13\1\uffff\6\13\1\uffff\1\13\5\uffff\1\13",
            "\7\13\10\uffff\2\14\1\uffff\1\13\1\20\1\23\4\uffff\6\13\3\uffff\6\13\1\uffff\4\13\1\uffff\2\13\1\uffff\14\13\1\uffff\1\13\1\uffff\1\13\1\uffff\3\13\1\uffff\6\13\1\uffff\1\13\5\uffff\1\13",
            "\7\13\11\uffff\1\14\1\uffff\1\13\1\22\5\uffff\6\13\3\uffff\6\13\1\uffff\4\13\1\uffff\2\13\1\uffff\14\13\1\uffff\1\13\1\uffff\1\13\1\uffff\3\13\1\uffff\6\13\1\uffff\1\13\5\uffff\1\13",
            "\7\13\11\uffff\1\14\1\uffff\1\13\1\22\1\24\4\uffff\6\13\3\uffff\6\13\1\uffff\4\13\1\uffff\2\13\1\uffff\14\13\1\uffff\1\13\1\uffff\1\13\1\uffff\3\13\1\uffff\6\13\1\uffff\1\13\5\uffff\1\13",
            "\7\13\10\uffff\2\14\1\uffff\1\13\1\20\5\uffff\6\13\3\uffff\6\13\1\uffff\4\13\1\uffff\2\13\1\uffff\14\13\1\uffff\1\13\1\uffff\1\13\1\uffff\3\13\1\uffff\6\13\1\uffff\1\13\5\uffff\1\13",
            "\7\13\11\uffff\1\14\1\uffff\1\13\1\22\5\uffff\6\13\3\uffff\6\13\1\uffff\4\13\1\uffff\2\13\1\uffff\14\13\1\uffff\1\13\1\uffff\1\13\1\uffff\3\13\1\uffff\6\13\1\uffff\1\13\5\uffff\1\13"
    };

    static final short[] dfa_81 = DFA.unpackEncodedString(dfa_81s);
    static final short[] dfa_82 = DFA.unpackEncodedString(dfa_82s);
    static final char[] dfa_83 = DFA.unpackEncodedStringToUnsignedChars(dfa_83s);
    static final char[] dfa_84 = DFA.unpackEncodedStringToUnsignedChars(dfa_84s);
    static final short[] dfa_85 = DFA.unpackEncodedString(dfa_85s);
    static final short[] dfa_86 = DFA.unpackEncodedString(dfa_86s);
    static final short[][] dfa_87 = unpackEncodedStringArray(dfa_87s);

    class DFA87 extends DFA {

        public DFA87(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 87;
            this.eot = dfa_81;
            this.eof = dfa_82;
            this.min = dfa_83;
            this.max = dfa_84;
            this.accept = dfa_85;
            this.special = dfa_86;
            this.transition = dfa_87;
        }
        public String getDescription() {
            return "4898:1: (this_StringValue_0= ruleStringValue | this_IntegerValue_1= ruleIntegerValue | this_DecimalValue_2= ruleDecimalValue | this_BooleanValue_3= ruleBooleanValue | this_DateValue_4= ruleDateValue | this_TimeValue_5= ruleTimeValue | this_DateAndTimeValue_6= ruleDateAndTimeValue | this_NullValue_7= ruleNullValue | this_JavaConstantValue_8= ruleJavaConstantValue )";
        }
    }
    static final String dfa_88s = "\1\17\1\uffff\1\23\1\uffff\1\23\2\uffff\1\23";
    static final String dfa_89s = "\1\21\1\uffff\1\27\1\uffff\1\30\2\uffff\1\27";
    static final String dfa_90s = "\1\uffff\1\1\1\uffff\1\4\1\uffff\1\2\1\3\1\uffff";
    static final String[] dfa_91s = {
            "\1\1\1\2\1\3",
            "",
            "\1\5\1\6\2\uffff\1\4",
            "",
            "\1\5\1\6\2\uffff\1\4\1\7",
            "",
            "",
            "\1\5\1\6\2\uffff\1\4"
    };
    static final char[] dfa_88 = DFA.unpackEncodedStringToUnsignedChars(dfa_88s);
    static final char[] dfa_89 = DFA.unpackEncodedStringToUnsignedChars(dfa_89s);
    static final short[] dfa_90 = DFA.unpackEncodedString(dfa_90s);
    static final short[][] dfa_91 = unpackEncodedStringArray(dfa_91s);

    class DFA91 extends DFA {

        public DFA91(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 91;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_88;
            this.max = dfa_89;
            this.accept = dfa_90;
            this.special = dfa_5;
            this.transition = dfa_91;
        }
        public String getDescription() {
            return "5516:1: (this_IsoDateAndTimeValue_0= ruleIsoDateAndTimeValue | this_EuropeanDateAnd24HrsTimeValue_1= ruleEuropeanDateAnd24HrsTimeValue | this_EuropeanDateAnd12HrsTimeValue_2= ruleEuropeanDateAnd12HrsTimeValue | this_USDateAnd12HrsTimeValue_3= ruleUSDateAnd12HrsTimeValue )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000004720400002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000800400L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x002C0FC7A0C00000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x002C0FC7A0400000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000001800800600L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000001800000602L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000001800800400L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000001800000402L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000002000800000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000BFFE00L,0x0000000000650200L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000800200L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000800800000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x00000E0200000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x00000E0000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x00000C0000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000F00040800000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000F00040000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000E00040800400L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000C00040800400L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000800040800400L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000040800400L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0xACAD0FC720C001F0L,0x0000000000000081L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0xACAD0FC7204001F0L,0x0000000000000081L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0002000000800002L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0010000000800000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0010000000000002L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0020000200000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0240000000BFFE00L,0x0000000000650200L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0240000000BFFE02L,0x0000000000650200L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0240000000800000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0240000000000002L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0100000000800000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000002000800400L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x1000000000800400L,0x0000000000000100L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000800400L,0x0000000000000100L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x4000000000000002L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x1000000000800000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x00000000009FFE00L,0x0000000000240000L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0100000000800400L,0x0000000000000100L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000BFFE00L,0x0000000000650202L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000800000L,0x0000000000000010L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000800000L,0x0000000000000014L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000014L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000BFFE00L,0x0000000000650208L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000800400L,0x0000000000000020L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000800400L,0x0000000000000060L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000800402L,0x0000000000000020L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0200000000800400L,0x0000000000000010L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0200000000800402L,0x0000000000000010L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0200000000800000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0200000000000002L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000800400L,0x0000000000000040L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000800402L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000600L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000800000L,0x0000000000007D00L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000000L,0x0000000000007D00L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000800000L,0x000000000000FD00L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000000L,0x000000000000FD00L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000040800000L,0x0000000000020000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x0000000000800000L,0x0000000000020000L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x0000000000800002L,0x0000000000000040L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000000880000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000900000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000000800600L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000000800600L,0x0000000000800000L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000000800000L,0x0000000000400000L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000000000002L,0x0000000001000000L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0000000000000002L,0x0000000002000000L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0000000001800002L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_109 = new BitSet(new long[]{0x0000000001800000L});

}